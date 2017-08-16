package base;

/**
 * Created by ST on 2017/2/23.
 */
public class C extends B {

    public static void main(String[] args){
        B b = new B();
        C c = new C();
        c = (C) b;
        b = c;
        String str = new String();
    }
}
