package base;

/**
 * Created by ST on 2016/4/5.
 */
public class JNC extends Wine {

    public String name = "sub";

    public void test(){
        System.out.println("sub.........test");
    }

    public void test3(){

    }
    public static void main(String[] args){
        Wine w = new JNC();
        System.out.println(w.name);
        w.test();
//        w.test3
    }
}
