package generics;


/**
 * Created by ST on 2016/1/5.
 */
public class Test {

    String name;
    Test k ;

    public Test(String name){
        this.name = name;
    }

    public Test getK() {
        return k;
    }

    public void setK(Test k) {
        this.k = k;
    }

    public static void main(String[] args){
//        Test t = new Test("llllllllllll");//创建一个Test 对象
//        System.out.println(t.getK());
//        t.setK(t);
//        Test l = t.getK();
//        System.out.println(l.name);

    }
}
