package org.language;

/**
 * Author: nitinkumar
 * Created Date: 01/06/20
 * Info: Demo to see how Proxy works using reflection in Java
 **/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyDemo {

    public static void main(String[] args) {
        ClassImplementingAnInterface original = new ClassImplementingAnInterface();
        MyHandler myHandler = new MyHandler(original);
        Interface1 f = (Interface1) Proxy.newProxyInstance(Interface1.class.getClassLoader(),
                new Class[]{Interface1.class},
                myHandler);
        f.originalMethod("Invoked originalMethod. Some Message..");
    }
}

interface Interface1 {
    void originalMethod(String s);
}

class ClassImplementingAnInterface implements Interface1 {
    public void originalMethod(String s) {
        System.out.println(s);
    }
}

class MyHandler implements InvocationHandler {
    private final Interface1 original;

    public MyHandler(Interface1 original) {
        this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        System.out.println(" args received:"+ Arrays.toString(args)+" ");
        System.out.println("Pre logging");
        method.invoke(original, args);
        System.out.println("Post logging");
        return null;
    }
}
/*
O/P
 args received:[Invoked originalMethod. Some Message..]
Pre logging
Invoked originalMethod. Some Message..
Post logging
 */