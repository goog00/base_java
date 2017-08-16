package base;

import java.util.*;

/**
 * Created by ST on 2017/2/3.
 */
public class Obj implements Cloneable{

    private int a;
    private String str = new String();
    private Date date = new Date();

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object clone(){
        Obj o = null;
        try {
            o = (Obj) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //深复制
        o.date = (Date) this.getDate().clone();
        return o;
    }

    public static void main(String[] args){
//        Obj obj = new Obj();
//        Obj b = (Obj) obj.clone();
//        b.setA(2);
//        System.out.println(obj.getA());
//        System.out.println(b.getA());
//        b.date.setMonth(2);
//        System.out.println(obj.getDate());
//        System.out.println(b.getDate());

//        Integer f1 = 127,f2 = 30,f3=127,f4=30;
//        System.out.println(f1 == f3);
//        System.out.println(f2 == f4);
//
//        Integer a = 411;
//        Value value = new Value();
//        value.setB(411);
//        Integer c = value.getB();
//        System.out.println(a == c);
//
//        String[] strs = new String[10];
//        int k = strs.length;


        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());


        Calendar calendar = Calendar.getInstance();
        int k = calendar.get(Calendar.YEAR);
        System.out.println(k);

        Obj o = new Obj();
        inner in = new Obj.inner();
        new inner();


        List<String> list = new ArrayList<String>();
        Iterator iterator = list.iterator();
        iterator.hasNext();
        Collections.synchronizedList(new LinkedList<Object>());

        Object object = new String();

        int i = 3;
//        i++;
//        ++i;
        System.out.println(++i);

    }

    public static class inner{

    }


}
