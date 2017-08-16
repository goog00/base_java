package base;

/**
 * Created by ST on 2016/3/29.
 */
public class StringTests {

    public static  void test1(){
        String a = "abcd";
        String b = "abcd";
        System.out.println(a==b);//true
        System.out.println(a.endsWith(b));//true
    }

    public static void test2(){
        String c = new String("abcd");
        String d = new String("abcd");
        System.out.println(c==d);//false
        System.out.println(c.equals(d));//true
    }

    public static void test3(){
        String c = new String("abcd").intern();
        String d = new String("abcd").intern();
        System.out.println(c==d);//true
        System.out.println(c.equals(d));//true
    }
    public static void main(String[] args){
        test3();
    }
}
