package demo;


public class Main {
    public static void main(String[] args) {
        boolean b = MyProducer.runFun();
        System.out.println(b);

        MyConsumer.runFun();
     }
}
