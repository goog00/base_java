package base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ST on 2016/3/7.
 */
public class RegexMatches {

    public  static void main(String[] args){

        //按照指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\\\d+)(.*)";



        //创建Pattern对象
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);

        System.out.println();

        if(m.find()){
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        } else {
            System.out.println("no match");
        }
        for(int i = 1700;i < 1710 ; i++){
            matchPhone(new Integer(i).toString());
        }


    }


    public static  void matchPhone(String pre){

        String phonePattern = "(^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7})$";

        String phone = pre + "6903049";

        Pattern p = Pattern.compile(phonePattern);
        Matcher m = p.matcher(phone);

        System.out.println(m.matches() + "    " + pre);

    }
}
