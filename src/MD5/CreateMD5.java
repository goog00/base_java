package MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ST on 2016/3/6.
 */
public class CreateMD5 {

    public static String getMd5(String plainText){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(plainText.getBytes());

            byte[] b = md.digest();

            int i ;
            StringBuffer buf = new StringBuffer();
            for(int offset = 0;offset < b.length;offset++){
                i = b[offset];
                if(i < 0){
                    i += 256;
                }

                if(i < 16){
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            //32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        System.out.println(getMd5("hello"));
    }

}
