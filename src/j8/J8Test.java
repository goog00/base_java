package j8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class J8Test {
    public static void main(String[] args) {
//        Arrays.asList("a","b","c","d").forEach(e-> System.out.println(e));
//        Arrays.asList("a","b","c","d").sort((e1,e2)->e1.compareTo(e2));
//
//        Arrays.asList("a","b","c","d").sort((e1,e2)->{
//            int result = e1.compareTo(e2);
//            return result;
//        });
//
//        String regex = "/retail/prescription/";
//        String val = "/retail/prescription/kkkkk";
//        Pattern p = Pattern.compile(regex);
//        Matcher matcher = p.matcher(val);
//        System.out.println(matcher.find());

//        BigDecimal kk = BigDecimal.ZERO;
//        BigDecimal k2 = new BigDecimal(3);
//        kk = kk.add(k2);
//        System.out.println(kk);

//        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
//        long count = nums.stream().filter(num->num != null).count();
//        System.out.println(count);


        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is" + nums.stream().filter(num->num != null).distinct().mapToInt(num->num*2).peek(System.out::println).skip(2).limit(4).sum());

        //汇聚
//        List<Integer> numsWithoutNull = nums.stream().filter(num-> num != null).collect(() ->new ArrayList<Integer>(),(list,item)->list.add(item),(list1,list2)->list1.addAll(list2));
//        numsWithoutNull.stream().peek(System.out::println);


        List<String> wordList = Lists.newArrayList("sunteng","zhangsan","lisi","wangwu");
//        filter(wordList);

        //map方法
//        map(wordList);

//        limit();

//        sorted();

//        collect();
        reduce();
    }

    private static void filter(List<String> wordList) {
        //filter方法
        long count = wordList.stream().filter(word->word != null).filter(word->word.length() > 5).count();
        System.out.println(count);
    }

    private static void map(List<String> wordList) {
        //map方法
        //转换成大写字母
//        Stream<String> stream =  wordList.stream().map(String::toUpperCase);
//        stream.peek(e->System.out.println(e)).collect(Collectors.toList());
//        stream.forEach(item->System.out.println(item));

        //取出每个字符串第一个字符
        wordList.stream().map( s->s.charAt(0));
    }

    private static void limit(){
        List<Integer> collect = IntStream.range(1, 100).limit(90).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }
    private static void sorted(){
        String[]  arr = new String[]{"b_123","c+342","b#632","d_123"};
        List<String> ll = Arrays.stream(arr).sorted((s1,s2) ->{
            if(s1.charAt(0) == s2.charAt(0)){
                return s1.substring(2).compareTo(s2.substring(2));
            } else {
                return s1.charAt(0) - s2.charAt(0);
            }
        }).peek(System.out::println).collect(Collectors.toList());
    }


    private static void collect(){
        List<String> stringList = new ArrayList<>(Arrays.asList("qaz","string","1234"));
        List<String> asList = stringList.stream().collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        String concat = stringList.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(concat);

    }

    private static void reduce(){
        Optional<Integer> total = Stream.of(1,2,3,4,5).reduce((x, y) -> x+ y);
        Integer total2 = Stream.of(1,2,3,4,5).reduce(1,(x,y) -> x + y);

        System.out.println(total);
        System.out.println(total2);

    }

    @Test
    public void stream_to_set() {

        Set<Integer> numbers = Stream.of(1, 2, 3)
                .collect(Collectors.toSet());

        assertTrue(numbers.size() == 3);
    }

}