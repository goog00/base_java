package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ST on 2017/2/23.
 */
public class A {
    public static void main(String[] args){
        byte b = 1;
        int  i = 27;
        char c = 'a';
        short s = 3;
        float f = 3.03f;
        double d = 4;
        long l = 5l;

//        i = b;
//        System.out.println(i);
//        i = c;
//        System.out.println(i);
          b = (byte)i;
        System.out.println(b);
        b = (byte) c;
        b +=c;
        System.out.println(b);
        c = (char) i;
        System.out.println(c);
        s = (short) i;
        s += i;//自动强制类型转换，高位转低为，精度会降低
        System.out.println(s);

//         f = i;
//        System.out.println(f);
        i = (int) f;
        System.out.println(i);
        b = (byte) f;
        System.out.println(b);
//        d = f;
//        System.out.println(d);
        f = (float) d;
        System.out.println(f);

        Integer integer = new Integer(3);
        System.out.println();

        final  int k = 9;
        final  String str = "eee";

        final  Date date = new Date();
        Date date1 = new Date();
        date.setTime(444444l);

        final  StringBuffer sb = new StringBuffer("dddd");
        sb.append("33");
        Calendar calendar = Calendar.getInstance();
        Long time = calendar.getTimeInMillis();
        System.out.println(time);//当前时间
        Calendar future = Calendar.getInstance();
        future.set(Calendar.YEAR,2014);
        System.out.println(calendar.after(future));//当前时间与指定时间对比
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-1);
        Date date3 = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date3));//减一天/加一天

        System.out.println(calendar.get(Calendar.YEAR));//年
        System.out.println(calendar.get(Calendar.MONTH) + 1);//月
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//日
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//小时
        System.out.println(calendar.get(Calendar.MINUTE));//分钟数
        System.out.println(calendar.get(Calendar.SECOND));//毫秒数
        System.out.println(calendar.getActualMinimum(Calendar.DAY_OF_MONTH));//获取本月最小天数
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));//获取本月最大天数
        Date date2 = new Date();
        System.out.println(date2.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date2));//指定时间格式，返回格式化后的时间字符串
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2016-3-3"));//把指定格式的字符串时间解析成Date类型
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
