package net.tn.db.password.crypter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamBinder
  implements Runnable
{
  public static final int CLOSE_NONE = 0;
  public static final int CLOSE_IN = 1;
  public static final int CLOSE_OUT = 2;
  public static final int CLOSE_BOTH = 3;
  public static final int CLOSE_NONE_AND_FLUSH = 4;
  public static final int CLOSE_IN_AND_FLUSH = 5;
  private InputStream in;
  private OutputStream out;
  private byte[] buffer;
  private long length;
  private int runMethodCloseMode;
  private Object bufferSync = new Object();
  private boolean closed;
  private static int counter = 0;
  
  public StreamBinder(InputStream in, OutputStream out, int bufLength)
  {
    this(in, out, bufLength, 9223372036854775807L);
  }
  
  public StreamBinder(InputStream in, OutputStream out, int bufLength, long length)
  {
    this(in, out, bufLength, length, true);
  }
  
  public StreamBinder(InputStream in, OutputStream out, int bufLength, long length, boolean runMethodClose)
  {
    this(in, out, bufLength, length, runMethodClose ? 3 : 0);
  }
  
  public StreamBinder(InputStream in, OutputStream out, int bufLength, long length, int runMethodCloseMode)
  {
    this.in = in;
    this.out = out;
    this.buffer = new byte[bufLength];
    this.length = length;
    this.runMethodCloseMode = runMethodCloseMode;
  }
  

  public void run()
  {
    try
    {
      transfer(this.runMethodCloseMode);
    }
    catch (IOException e) {}
  }
  
  public long transfer()
    throws IOException
  {
    return transfer(0);
  }
  

  public long transfer(int finallyCloseMode)
    throws IOException
  {
    try
    {
      long count = 0L;
      for (;;)
      {
        synchronized (this.bufferSync)
        {
          if (this.buffer == null) {
            break;
          }
          int len = this.buffer.length > this.length ? (int)this.length : this.buffer.length;
          if ((len > 0) && ((len = this.in.read(this.buffer, 0, len)) > 0))
          {
            this.out.write(this.buffer, 0, len);
            this.length -= len;
            count += len;
          }
          else
          {
            break;
          }
        }
      }
      close(finallyCloseMode);
      return count;
    }
    catch (IOException e)
    {
      handleException(e);
      throw e;
    }
    finally
    {
      try
      {
        close(finallyCloseMode);
      }
      catch (IOException e) {}
    }
  }
  
  protected void handleException(IOException e) {}
  

  public void start()
  {
    new Thread(this, "StreamBinder-" + counter++).start();
  }
  

  public synchronized void close(int closeMode)
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    try
    {
      IOException ex = null;
      switch (closeMode)
      {
      case 1: 
        closeIn();
        break;
      case 5: 
        try
        {
          closeIn();
        }
        catch (IOException e)
        {
          ex = e;
        }
      case 4: 
        flush();
        break;
      case 2: 
        closeOut();
        break;
      case 3: 
        try
        {
          closeIn();
        }
        catch (IOException e)
        {
          ex = e;
        }
        closeOut();
        break;
      }
      if (ex != null) {
        throw ex;
      }
    }
    finally
    {
      synchronized (this.bufferSync)
      {
        if (this.buffer != null)
        {
          this.buffer = null;
          this.bufferSync.notifyAll();
        }
      }
    }
  }
  
  public void close()
    throws IOException
  {
    close(3);
  }
  
  public void closeOut()
    throws IOException
  {
    this.out.close();
  }
  
  public void closeIn()
    throws IOException
  {
    this.in.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void waitForClose()
  {
    waitForClose(0L);
  }
  
  public boolean waitForClose(long timeout)
  {
    synchronized (this.bufferSync)
    {
      try
      {
        while (this.buffer != null) {
          this.bufferSync.wait(timeout);
        }
      }
      catch (InterruptedException e) {}
      return this.buffer == null;
    }
  }
}
