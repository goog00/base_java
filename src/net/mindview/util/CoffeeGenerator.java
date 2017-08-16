package net.mindview.util;

import generics.*;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by ST on 2016/1/5.
 */
public class CoffeeGenerator implements Generator<Coffe>,Iterator<Coffe> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator(){}

    private int size = 0;
    public CoffeeGenerator(int size){
        size = size;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Coffe next() {
        try {
            return (Coffe) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void remove() {

    }
}
