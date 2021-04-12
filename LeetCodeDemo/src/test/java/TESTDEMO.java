public class TESTDEMO {
    public static void main(String[] args) {
        System.out.println("*********测试使用*********");

        int i = 2;
        int j=2;
        A.fun(i,j);

        System.out.println(i);
        System.out.println(j);
    }
}

class A{
    public static void fun(int a,int b) {
        a=1;
        b=1;
    }
}
