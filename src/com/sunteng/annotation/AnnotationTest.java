package com.sunteng.annotation;

/**
 * Created by ST on 2017/6/27.
 */
@Test()
public class AnnotationTest {

    @TestMethod("tomcat-method")
    public void test(){
    }

    public static void main(String[] args) {
        Test t = AnnotationTest.class.getAnnotation(Test.class);
        System.out.println(t.value());
        TestMethod tm = null;

        try {
            tm = AnnotationTest.class.getDeclaredMethod("test",null).getAnnotation(TestMethod.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(tm.value());
    }
}
