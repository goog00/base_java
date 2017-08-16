package generics;

import java.util.Comparator;

/**
 * Created by ST on 2017/8/16.
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for(int i = 1; i < a.length; i++){
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min,max);
    }


    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];

        for(int i = 1; i < a.length; i++){
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min,max);
    }
    /**
     * <T extends Comparable>
     *表示T 应该是Comparable类型的子类型。T和Comparable可以是类，也可以是接口
     */
    public static <T extends Comparable> T min(T[] a){
        if(a == null || a.length == 0) return null;
        T smallest = a[0];
        for(int i = 1; i < a.length; i++){
            if(smallest.compareTo(a[i]) > 0){
                smallest = a[i];
            }
        }
        return smallest;
    }

}
