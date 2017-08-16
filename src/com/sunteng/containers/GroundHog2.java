package com.sunteng.containers;

/**
 * Created by ST on 2016/2/13.
 */
public class GroundHog2  extends GroundHog{
    protected int number;

    public GroundHog2(int n ){
        super(n);
    }

    public int hashCode(){
        return number;
    }

    public boolean equals(Object o ){
        System.out.println(o);
        return o instanceof GroundHog2 && (number == ((GroundHog2)o).number);
    }

}
