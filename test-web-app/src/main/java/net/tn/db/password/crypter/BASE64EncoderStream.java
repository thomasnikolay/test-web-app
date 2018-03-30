package net.tn.db.password.crypter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BASE64EncoderStream
  extends FilterOutputStream
{
  private byte[] buffer;
  private int bufsize;
  private int count;
  private int bytesPerLine;
  
  public BASE64EncoderStream(OutputStream outputstream, int i)
  {
    super(outputstream);
    this.buffer = new byte[3];
    this.bytesPerLine = i;
  }
  
  public BASE64EncoderStream(OutputStream outputstream)
  {
    this(outputstream, 76);
  }
  
  public void write(byte[] abyte0, int i, int j)
    throws IOException
  {
    for (int k = 0; k < j; k++) {
      write(abyte0[(i + k)]);
    }
  }
  
  public void write(byte[] abyte0)
    throws IOException
  {
    write(abyte0, 0, abyte0.length);
  }
  
  public void write(int i)
    throws IOException
  {
    this.buffer[(this.bufsize++)] = ((byte)i);
    if (this.bufsize == 3)
    {
      encode();
      this.bufsize = 0;
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.bufsize > 0)
    {
      encode();
      this.bufsize = 0;
    }
    this.out.flush();
  }
  
  public void close()
    throws IOException
  {
    flush();
    this.out.close();
  }
  
  private void encode()
    throws IOException
  {
    if (this.count + 4 > this.bytesPerLine)
    {
      this.out.write(13);
      this.out.write(10);
      this.count = 0;
    }
    if (this.bufsize == 1)
    {
      byte byte0 = this.buffer[0];
      int i = 0;
      this.out.write(pem_array[(byte0 >>> 2 & 0x3F)]);
      this.out.write(pem_array[((byte0 << 4 & 0x30) + (i >>> 4 & 0xF))]);
      this.out.write(61);
      this.out.write(61);
    }
    else if (this.bufsize == 2)
    {
      byte byte1 = this.buffer[0];
      byte byte3 = this.buffer[1];
      int j = 0;
      this.out.write(pem_array[(byte1 >>> 2 & 0x3F)]);
      this.out.write(pem_array[((byte1 << 4 & 0x30) + (byte3 >>> 4 & 0xF))]);
      this.out.write(pem_array[((byte3 << 2 & 0x3C) + (j >>> 6 & 0x3))]);
      this.out.write(61);
    }
    else
    {
      byte byte2 = this.buffer[0];
      byte byte4 = this.buffer[1];
      byte byte5 = this.buffer[2];
      this.out.write(pem_array[(byte2 >>> 2 & 0x3F)]);
      this.out.write(pem_array[((byte2 << 4 & 0x30) + (byte4 >>> 4 & 0xF))]);
      this.out.write(pem_array[((byte4 << 2 & 0x3C) + (byte5 >>> 6 & 0x3))]);
      this.out.write(pem_array[(byte5 & 0x3F)]);
    }
    this.count += 4;
  }
  
  private static final char[] pem_array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
}
