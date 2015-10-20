package com.buobao.eie.action.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by dqf on 2015/10/19.
 * 这里实现Intercepter接口也是一样的，因为abstractInterceptor同样没有给init和destroy做有关的实现.
 */

public class TestInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Long start = System.currentTimeMillis();
        String result = invocation.invoke();
        Long end = System.currentTimeMillis();
        System.out.println(invocation.getAction().getClass().getName()+" used running time:"+(end-start)+"ms.");
        return result;
    }
}
