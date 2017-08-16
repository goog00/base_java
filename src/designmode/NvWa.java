package designmode;

/**
 * Created by ST on 2017/3/13.
 */
public class NvWa {

    public static void main(String[] args){
        HumanFactory maleHumanFactory = new MaleFactory();//第一条生产线：男
        HumanFactory femaleHumanFactory = new FemaleFactory();//第二条生产线：女

        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYelloHuman = femaleHumanFactory.createYellowHuman();



    }
}
