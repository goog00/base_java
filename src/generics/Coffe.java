package generics;

/**
 * Created by ST on 2016/1/5.
 */
public class Coffe {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
