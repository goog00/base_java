package com.sunteng.agent;

import java.lang.reflect.Method;

/**
 * Created by ST on 2016/4/5.
 */
public interface InvocationHandler {
    void invoke(Object o,Method m);
}
