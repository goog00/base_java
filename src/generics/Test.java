package generics;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
//        boolean isOk = false;
//        isOk = test(isOk);
//        System.out.println(isOk);
//
//        List list = new ArrayList<>();
//
//        List list1 = new ArrayList<>();
//        List list2 = new ArrayList<>();
//        System.out.println(list.size());
//        list.addAll(list1);
//        list.addAll(null);
//        list.addAll(list2);
//
//        System.out.println(list.size());
        Integer kk = null;
        System.out.println(kk + "");

        Stu stu = new Stu();
        stu.setK(new BigDecimal(10));
        stu.setVal(10);
        Stu stu2 = new Stu();
        stu2.setK(new BigDecimal(15));
        stu2.setVal(100);
        Stu stu3 = new Stu();
        stu3.setK(new BigDecimal(20));
        stu3.setVal(20);
        List<Stu> list = new ArrayList<>();
        list.add(stu);
        list.add(stu);
        list.add(stu);

        Integer kkk = list.stream().mapToInt(item-> item.val).sum();
        System.out.println(kkk);


    }

    public static boolean test(boolean isOk){
        isOk = true;
        return isOk;
    }


}
class Stu{
    BigDecimal k;
    Integer val;

    public BigDecimal getK() {
        return k;
    }

    public void setK(BigDecimal k) {
        this.k = k;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}