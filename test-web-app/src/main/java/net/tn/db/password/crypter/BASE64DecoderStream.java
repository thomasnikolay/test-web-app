package net.tn.db.password.crypter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BASE64DecoderStream
  extends FilterInputStream
{
  private byte[] buffer;
  private int bufsize;
  private int index;
  
  public BASE64DecoderStream(InputStream inputstream)
  {
    super(inputstream);
    this.decode_buffer = new byte[4];
    this.buffer = new byte[3];
  }
  
  public int read()
    throws IOException
  {
    if (this.index >= this.bufsize)
    {
      decode();
      if (this.bufsize == 0) {
        return -1;
      }
      this.index = 0;
    }
    return this.buffer[(this.index++)] & 0xFF;
  }
  
  public int read(byte[] abyte0, int i, int j)
    throws IOException
  {
    int k;
    try
    {
      for (k = 0; k < j; k++)
      {
        int l;
        if ((l = read()) == -1)
        {
          if (k != 0) {
            break;
          }
          k = -1; break;
        }
        abyte0[(i + k)] = ((byte)l);
      }
    }
    catch (IOException _ex)
    {
      k = -1;
    }
    return k;
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int available()
    throws IOException
  {
    return this.in.available() * 3 / 4 + (this.bufsize - this.index);
  }
  
  private void decode()
    throws IOException
  {
    this.bufsize = 0;
    int i;
    do
    {
      i = this.in.read();
      if (i == -1) {
        return;
      }
    } while ((i == 10) || (i == 13));
    this.decode_buffer[0] = ((byte)i);
    int j = 3;
    int l;
    for (int k = 1; (l = this.in.read(this.decode_buffer, k, j)) != j; k += l)
    {
      if (l == -1) {
        throw new IOException("Error in encoded stream");
      }
      j -= l;
    }
    byte byte0 = pem_convert_array[(this.decode_buffer[0] & 0xFF)];
    byte byte2 = pem_convert_array[(this.decode_buffer[1] & 0xFF)];
    this.buffer[(this.bufsize++)] = ((byte)(byte0 << 2 & 0xFC | byte2 >>> 4 & 0x3));
    if (this.decode_buffer[2] == 61) {
      return;
    }
    byte0 = byte2;
    byte2 = pem_convert_array[(this.decode_buffer[2] & 0xFF)];
    this.buffer[(this.bufsize++)] = ((byte)(byte0 << 4 & 0xF0 | byte2 >>> 2 & 0xF));
    if (this.decode_buffer[3] == 61) {
      return;
    }
    byte byte1 = byte2;
    byte2 = pem_convert_array[(this.decode_buffer[3] & 0xFF)];
    this.buffer[(this.bufsize++)] = ((byte)(byte1 << 6 & 0xC0 | byte2 & 0x3F));
  }
  
  private static final char[] pem_array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
  private static final byte[] pem_convert_array = new byte[256];
  private byte[] decode_buffer;
  
  static
  {
    for (int i = 0; i < 255; i++) {
      pem_convert_array[i] = -1;
    }
    for (int j = 0; j < pem_array.length; j++) {
      pem_convert_array[pem_array[j]] = ((byte)j);
    }
  }
}
