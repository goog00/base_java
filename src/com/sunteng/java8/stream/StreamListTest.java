package com.sunteng.java8.stream;


import com.sunteng.io.BinaryFile;
import com.sunteng.java8.model.Album;
import com.sunteng.java8.model.Artist;
import com.sunteng.java8.model.Track;
import org.junit.Assert;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ST on 2017/8/15.
 */
public class StreamListTest {

    static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        test8();
    }

    public static void test3(){
        List<String> collected = Stream.of("a","b","hello").map(string -> string.toUpperCase()).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A","B","HELLO"),collected);

    }
    public static void test2(){
        List<String> collected = new ArrayList<>();
        for(String string : Arrays.asList("a","b","hello")){
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        Assert.assertEquals(Arrays.asList("A","B","HELLO"),collected);
    }

    private static void test1() {
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a","b","c"),collected);
    }

    public static void test4(){
        List<String> beginWithNumbers = new ArrayList<>();
        for(String value : Arrays.asList("a","1abc","abc1")){
            if(Character.isDigit(value.charAt(0))){
                beginWithNumbers.add(value);
            }
        }
        Assert.assertEquals(Arrays.asList("1abc"),beginWithNumbers);
    }

    public static void test5(){
        List<String> beginWithNumbers = Stream.of("a","1abc","abc1").filter(value->Character.isDigit(value.charAt(0))).collect(Collectors.toList());
    }

    public static void test6(){
        List<Track> tracks = Arrays.asList(new Track("你好",512),
                new Track("你好2",412),
                new Track("你好3",212));
        Track shortestTrack =  tracks.stream().min(Comparator.comparing(track -> track.getDuration())).get();
        System.out.println(shortestTrack.getDuration());


    }


    public static void test7(){
        int count = Stream.of(1,2,3).reduce(0,(acc,element) -> acc + element);
        System.out.println(count);
    }

    public static void test8(){
        BinaryOperator<Integer> accumulator = (acc,element) -> acc + element;
        int count = accumulator.apply(accumulator.apply(accumulator.apply(0,1),2),3);
        System.out.println(count);
    }


    public Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for(Album album : albums){
            for(Track track : album.getTracks()){
                if(track.getDuration() > 25){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
    public static Set<String> test9(List<Album> albums){
        add();
        Set<String> trackNames = new HashSet<>();
        albums.stream().forEach(album -> {
            album.getTracks().forEach(track -> {
                if(track.getDuration() > 20){
                    String name = track.getName();
                    trackNames.add(name);
                }
            });
        });
        return trackNames;
    }

    public static  void add(){

        Album album = new Album();
        album.setName("专辑1");
        List<Track> tracks = new ArrayList<>();

        Track track = new Track();
        track.setName("zzzzzz");
        track.setDuration(20);
        tracks.add(track);

        Track track2 = new Track();
        track2.setName("sssss");
        track2.setDuration(22);
        tracks.add(track2);

        Track track3 = new Track();
        track3.setName("kkkk");
        track3.setDuration(25);
        tracks.add(track3);

        Track track4 = new Track();
        track4.setName("pppp");
        track4.setDuration(29);
        tracks.add(track4);

        album.setTracks(tracks);
    }


}
