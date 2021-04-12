package main;


import directory.IA;
import directory.ImplA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class B{
    public void before(){
        System.out.println("环绕增强方法before 执行");
    }
    public void after(){
        System.out.println("环绕增强方法after 执行");
    }
}
public class Main {

    public static void main(String[] args) {
        final ImplA implA = new ImplA();
//        implA.show();
       final B b = new B();

        IA o = (IA)Proxy.newProxyInstance(
                implA.getClass().getClassLoader(),
                implA.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        b.after();
                        Object invoke = method.invoke(implA);
                        b.before();
                        return invoke;
                    }
                });
        o.bb();
    }
}
