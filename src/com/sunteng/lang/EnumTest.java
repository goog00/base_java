package com.sunteng.lang;

/**
 * Created by ST on 2016/1/30.
 */
public class EnumTest {

    public static void main(String[] args){
//        WeekDay weekDay = WeekDay.SUN;
//        System.out.println(WeekDay.values());

        Color co = Color.RED;
        System.out.println(co.count);
        System.out.println(co.nextColor().name());
    }

    public enum WeekDay{
        SUN(7),MON,TUE;

        private WeekDay(){
            System.out.println("first");
        }

        private WeekDay(int num){
            System.out.println("second");
        }
    }

    public  enum Color{
        RED(1){
            @Override
            public Color nextColor() {
                System.out.println("执行RED,返回GREEN");
                return GREEN;
            }
        },
        GREEN{
            @Override
            public Color nextColor() {
                System.out.println("执行GREN,返回YELLOW");
                return YELLOW;
            }
        },
        YELLOW{
            @Override
            public Color nextColor() {
                System.out.println("执行YELLOW,返回RED");
                return RED;
            }
        };



        private Color(){}
        private int count;

        private Color(int count){
            this.count = count;
        }

        public abstract Color nextColor();
    }
}
