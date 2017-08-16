package simplejava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ST on 2016/4/5.
 */
public class ArrayContain {

    /**
     * Using List
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useList(String[] arr,String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * Using Set
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useSet(String arr[],String targetValue){
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * Using a simple loop
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean userLoop(String[] arr,String targetValue){
        for(String s : arr){
            if(s.equals(targetValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * Using Array.binarySearch(): the code below is wrong,it is listed here for completeness.
     * binarySearch() can ONLY be used on sorted arrays.You will see the result is weird when running the code below.
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useArrayBinarySearch(String[] arr,String targetValue){
        int a = Arrays.binarySearch(arr,targetValue);
        if(a > 0){
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args){
        String[] arr = new String[]{"3","4","k","h","d"};

        boolean k = useArrayBinarySearch(arr,"l");
        System.out.println(k);

//        Arrays.sort();

    }


}
