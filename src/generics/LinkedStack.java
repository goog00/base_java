package generics;


/**
 * Created by ST on 2016/1/5.
 */
public class LinkedStack<T> {

    private static class Node<U>{
        U item;
        Node<U> next;
        //无参构造
        Node(){
            item = null;
            next = null;
        }
        //有参构造
        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item == null && next == null;
        }

    }


    private Node<T> top = new Node<T>();//end sentinel

    public void push(T item){
        top = new Node<T>(item,top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args){
        //创建一个String类型的堆栈
        LinkedStack<String> lss = new LinkedStack<String>();
        System.out.println(lss.top);
        //放进这个堆栈容器中
        for(String s : "Phasers or stun!".split(" ")){
            lss.push(s);
        }
        String s ;
        while((s = lss.pop()) != null){
            System.out.println(s);
        }
    }





}
