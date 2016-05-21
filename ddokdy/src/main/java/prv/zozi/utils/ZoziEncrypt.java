package prv.zozi.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.util.Base64;

public class ZoziEncrypt {
	 public static String Decrypt(String text, String key) throws Exception
     {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] keyBytes= new byte[16];
               byte[] b= key.getBytes("UTF-8");
               int len= b.length;
               if (len > keyBytes.length) len = keyBytes.length;
               System.arraycopy(b, 0, keyBytes, 0, len);
               SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
               IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
               cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);

               
//               BASE64Decoder decoder = new BASE64Decoder();
//               Base64.decode(input, flags)
//               byte [] results = cipher.doFinal(decoder.decodeBuffer(text));
              // BASE64Decoder decoder = new BASE64Decoder();
              // Base64.decode(input, flags)
               byte [] results = cipher.doFinal(Base64.decode(text, 0));
               
               return new String(results,"UTF-8");
     }

     public static String Encrypt(String text, String key) throws Exception
     {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] keyBytes= new byte[16];
               byte[] b= key.getBytes("UTF-8");
               int len= b.length;
               if (len > keyBytes.length) len = keyBytes.length;
               System.arraycopy(b, 0, keyBytes, 0, len);
               SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
               IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
               cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

               byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
//               BASE64Encoder encoder = new BASE64Encoder();
//               return encoder.encode(results);
               
               return Base64.encodeToString(results, 0);
     }
}
