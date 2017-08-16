package com.sunteng.java8.stream;

import com.sunteng.java8.model.Artist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ST on 2017/8/15.
 */
public class StreamTest {

    static  List<Artist> allArtists = new ArrayList<Artist>();


    public static void test1(){
        add();
        int count = 0;
        for(Artist artist : allArtists){
            if(artist.isFrom("London")){
                count++;
                System.out.println(1);
            }
        }
        System.out.print(count);
    }


    public static void test2(){
        add();
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()){
            Artist artist = iterator.next();
            if(artist.isFrom("London")){
                count++;
            }
        }
        System.out.println(count);
    }

    public static  void test3(){
        add();
        long count = allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");

        }).count();
        System.out.println(count);
    }

    private static void add(){
        Artist artist1 = new Artist();
        artist1.setName("zhangsan");
        artist1.setMembers("lisi");
        artist1.setOrigin("London");
        allArtists.add(artist1);


        Artist artist2 = new Artist();
        artist2.setName("zhangsan2");
        artist2.setMembers("lisi2");
        artist2.setOrigin("London2");
        allArtists.add(artist2);


        Artist artist3 = new Artist();
        artist3.setName("zhangsan3");
        artist3.setMembers("lisi3");
        artist3.setOrigin("London");
        allArtists.add(artist3);


        Artist artist4 = new Artist();
        artist4.setName("zhangsan4");
        artist4.setMembers("lisi4");
        artist4.setOrigin("London");
        allArtists.add(artist4);
    }

    public static void main(String[] args) {
        test3();
    }

}
