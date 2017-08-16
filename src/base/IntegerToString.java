package base;

/**
 * 把一个基本数据类型转为字符串
 * Created by ST on 2016/6/27.
 */
public class IntegerToString {

    public static void main(String[] args){
        int loopTime = 50000;
        Integer i = 0;
        Long startTime = System.currentTimeMillis();
        for(int j = 0; j < loopTime; j++){
            String str = String.valueOf(i);
        }
        System.out.println("String.valueOf():" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for(int j = 0; j < loopTime; j ++){
            String str = i.toString();
        }
        System.out.println("Integer.toString():" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for(int j = 0; j < loopTime; j++){
            String str = i + "";
        }
        System.out.println("i +\"\": " + (System.currentTimeMillis() -startTime) + "ms");
    }
}
