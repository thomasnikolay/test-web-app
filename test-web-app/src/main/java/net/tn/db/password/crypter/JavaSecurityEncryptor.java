package net.tn.db.password.crypter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class JavaSecurityEncryptor
{
  private static final String ENCODING = "UTF-8";
  public static final String ENCRYPTION_ALGORITHM_AES = "AES";
  public static final String ENCRYPTION_ALGORITHM_DES = "DES";
  public static final String ENCRYPTION_ALGORITHM_TRIPPLE_DES = "DESede";
  public static final String ENCRYPTION_ALGORITHM_BLOWFISH = "Blowfish";
  private byte[] keyBytes;
  private String algorithm;
  private Cipher cipher;
  
  public JavaSecurityEncryptor(String algorithm, String key)
    throws Exception
  {
    init(algorithm, key.getBytes("UTF-8"));
  }
  
  public JavaSecurityEncryptor(String algorithm, byte[] keyBytes)
    throws Exception
  {
    init(algorithm, keyBytes);
  }
  
  private void init(String algorithm, byte[] keyBytes)
    throws Exception
  {
    this.algorithm = algorithm;
    this.keyBytes = keyBytes;
    this.cipher = Cipher.getInstance(algorithm);
  }
  
  public String encrypt(String clearText)
    throws Exception
  {
    SecretKeySpec keyspec = new SecretKeySpec(this.keyBytes, this.algorithm);
    this.cipher.init(1, keyspec);
    byte[] encrypted = this.cipher.doFinal(clearText.getBytes("UTF-8"));
    return encodeBASE64(encrypted);
  }
  
  public String decrypt(String cipherText)
    throws Exception
  {
    byte[] cipherBytes = decodeBASE64(cipherText);
    SecretKeySpec keyspec = new SecretKeySpec(this.keyBytes, this.algorithm);
    this.cipher.init(2, keyspec);
    byte[] decrypted = this.cipher.doFinal(cipherBytes);
    return new String(decrypted, "UTF-8");
  }
  
  protected String encodeBASE64(byte[] data)
    throws IOException
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
    BASE64EncoderStream encoderStream = new BASE64EncoderStream(baos);
    encoderStream.write(data);
    encoderStream.flush();
    return new String(baos.toByteArray(), "8859_1");
  }
  
  protected byte[] decodeBASE64(String data)
    throws IOException
  {
    BASE64DecoderStream decoderStream = new BASE64DecoderStream(new ByteArrayInputStream(data.getBytes("8859_1")));
    

    ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
    StreamBinder streamBinder = new StreamBinder(decoderStream, baos, 128);
    streamBinder.transfer();
    return baos.toByteArray();
  }
  
    public static void main(String[] args) throws Exception {
      JavaSecurityEncryptor javaSecurityEncryptor = new JavaSecurityEncryptor("AES", "top_secret_key:)");
        System.out.println(javaSecurityEncryptor.decrypt("mZRcSiNPY3f+k/hb7BwJxw=="));
        System.out.println(javaSecurityEncryptor.encrypt("L0b1aW71!"));
    }
}
