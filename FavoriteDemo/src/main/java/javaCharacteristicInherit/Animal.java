package javaCharacteristicInherit;

public abstract class Animal {
    public void fun() {
        System.out.println("父类fun方法执行");
    }

    public void fufun() {
        System.out.println("父类fufun方法执行");
    }
    public Animal(int a){
        System.out.println("父类含参构造方法执行");
    }
    public Animal(){
        System.out.println("父类无参构造方法执行");
    }
}
