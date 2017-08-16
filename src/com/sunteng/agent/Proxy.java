package com.sunteng.agent;


import com.sunteng.reflect.HelloServiceProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ST on 2016/4/5.
 */
public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception{

        String methodStr = "";
        String rt = "\r\n";

        //利用反射得到inface的所有方法，并重新组装
        Method[] methods = infce.getMethods();
        for(Method m : methods){
            methodStr += " @Override" + rt +
                        "  public  " + m.getReturnType() + "  " + m.getName() + "(){"+rt+
                        "     try{" + rt +
                        "        Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() +"\");" + rt +
                        "          h.invoke(this,md);" + rt +
                        "     }catch(Exception e) {e.printStackTrace();}" + rt + "  }" + rt;
        }

        //生成java源文件
        String srcCode  = "package com.sunteng.agent;" + rt +
                          "import java.lang.reflect.Method;" + rt +
                          "public class $Proxy1 implements " + infce.getName() + "{" + rt +
                          "   public  $Proxy1(InvocationHandler h){" + rt +
                          "   this.h = h;" + rt +
                          "  }" + rt +
                          "  com.sunteng.agent.InvocationHandler h;" + rt +
                            methodStr + rt +
                          "}";
        String fileName = "D:\\work\\my_workspace\\Basic_java\\src\\com\\sunteng\\agent\\$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(srcCode);
        fw.flush();
        fw.close();

        //将Java文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        //加到内存中并实例化
        URL[] urls = new URL[]{new URL("file:/" + "D:\\work\\my_workspace\\Basic_java\\src\\")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.sunteng.agent.$Proxy1");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);
        return m;
    }

}
