package base;

/**
 * Created by ST on 2017/2/13.
 */
public class MyRunnable implements Runnable{

    private int countDown = 3;
    private static int count = 0;
    private final  int id = count++;
    public MyRunnable(String msg){
        System.out.println(msg);
    }
    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown +"你好" : "消息结束");
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }

    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new MyRunnable("启动消息"));
            thread.start();
        }
    }


}
