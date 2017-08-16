package base;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * Created by ST on 2016/2/13.
 */
public class Value {
    Integer b ;

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }


    int i ;

    public static void main(String[] args) throws IOException {

//        Value v1 = new Value();
//        Value v2 = new Value();
//        v1.i = v2.i = 100;

////        System.out.println(v1.equals(v2));
//
//        String s1 = new String("kk");
//        String s2 = new String("kk");
//
//        String k = s1.toUpperCase();
//        System.out.println(s1);
//
//        System.out.println(s1.equals(s2));
//
//        byte[] k3 = s1.getBytes("ISO-8859-1");
//
//        byte a = 2;
//        byte b = 3;
//        a = (byte) (a + b);
//        a += b;
//        double l = 999;
//        long j = (long) l;
//
//        System.out.println(3*0.1);
//
//        String jdkBit = System.getProperty("sun.arch.data.model");
//        System.out.println(jdkBit);
//        System.out.println(System.getProperty("os.arch"));
//
////        Runtime.freeMemory();
//        Runtime runtime = Runtime.getRuntime();
//
//        long kl = runtime.freeMemory();
//        System.out.println(kl);

//        test();

//        List<String> listOfPhones = new ArrayList<String>(Arrays.asList( "iPhone 6S", "iPhone 6", "iPhone 5", "Samsung Galaxy 4", "Lumia Nokia"));
//        System.out.println("list of phones: " + listOfPhones);
////        // Iterating and removing objects from list
////        // This is wrong way, will throw ConcurrentModificationException
//        for(String phone : listOfPhones){
//            if(phone.startsWith("iPhone")){
//                listOfPhones.remove(phone);
//                // will throw exception } }
//            }
//        }

//        byte g = 8;
//
//        StringBuffer sb = new StringBuffer("string");
//        sb.reverse();
//        System.out.println(sb);
//
//        int a = 7,b = 9;
//        a = a + b; //16
//        b = a - b; // actually (a + b) - (b), so now b is equal to a
//        a = a - b; //
//
//
//        Map<String,Object> map = new HashMap<String,Object>();
//        //遍历map,keySet()返回键值集合，values() 返回Collections 集合，使用foreach循环遍历
//        Set<String> keys = map.keySet();
//        Collection<Object> values = map.values();


//        int i = 9;
//        System.out.println(i++);
//        System.out.println(i);
          String str1 = "1";
          String str2 = "1";
        System.out.println();
        System.out.println((str1 + "3").equals(str2 + "3"));

        float g = 3.2F;


    }

    public static void test() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("q");
        list.add("2");
        list.add("9");
        list.add("9");
        list.add("9");
        System.out.println(list);
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//           String k = (String) iterator.next();
//            System.out.println(k);
//            if(k.equals("2")){
//                iterator.remove();
//            }
//
//        }

        for(String k : list){
            if(k.equals("2")){
                list.remove(k);
            }
        }
        System.out.println(list.size());

        FileChannel channel = new FileInputStream("").getChannel(),
                    out = new FileInputStream("").getChannel();
        ByteBuffer  byteBuffer = ByteBuffer.allocate(1024);
        while(channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();

        }


    }




}


