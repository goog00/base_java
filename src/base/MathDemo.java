package base;


import java.util.Random;

/**
 * Created by ST on 2016/6/28.
 */
public class MathDemo {


    /**
     * ceil()结果是大于或等于该值最接近的整数
     */
    public static void testCeil(){
        double d = 2.62;
        double d1 = Math.ceil(d);
        System.out.println("before :" + d + ",ceil: " + d1);

    }

    /**
     * floor()结果是向下，小于或等于该值的最接近的整数
     */
    public static void testFloor(){
        double d = 2.63;
        double d1 = Math.floor(d);
        System.out.println("before :" + d + ",floor : " + d1);
    }

    /**
     * 四舍五入
     */
    public static void testRound(){
        double d = 2.34;
        double d1 = Math.round(d);
        System.out.println("before :" + d + ",double:" + d1);
    }


    public static void main(String[] args){
//        testCeil();
//        testFloor();
//        testRound();


        Random random = new Random();
        random.nextInt(0);
    }
}
