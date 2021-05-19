package javaCharacteristicInherit;

import java.util.Calendar;

public class Cat extends Animal {
    public Cat(){
        System.out.println("子类无参构造方法执行");
    }

    public Cat(int a){
        System.out.println("子类含参构造方法执行");
    }

}
