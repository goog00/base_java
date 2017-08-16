package com.sunteng.agent;
import java.lang.reflect.Method;
public class $Proxy1 implements com.sunteng.agent.UserMgr{
   public  $Proxy1(InvocationHandler h){
   this.h = h;
  }
  com.sunteng.agent.InvocationHandler h;
 @Override
  public  void  addUser(){
     try{
        Method md = com.sunteng.agent.UserMgr.class.getMethod("addUser");
          h.invoke(this,md);
     }catch(Exception e) {e.printStackTrace();}
  }
 @Override
  public  void  delUser(){
     try{
        Method md = com.sunteng.agent.UserMgr.class.getMethod("delUser");
          h.invoke(this,md);
     }catch(Exception e) {e.printStackTrace();}
  }

}