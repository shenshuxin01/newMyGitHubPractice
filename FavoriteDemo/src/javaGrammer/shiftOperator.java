package javaGrammer;

public class shiftOperator {
    public static void main(String[] args) {
        fun();
    }

    /**
     * java位移运算符： >>带符号（正负号）   底层二进制数向右移动 是2的n次幂 例如 2>>1 则代表 0010右移一位 0001
     *               >>>无符号  >>>：无符号右移。无论是正数还是负数，高位通通补0。
     *
     *
     *               00000000000000000000000000000100
     *               00000000000000000000000000000010
     *               11111111111111111111111111111101
     *               11111111111111111111111111111110
     *
     */
    private static void fun(){
        System.out.println(4>>1); // 相当于 4/2
        System.out.println(4>>2); // 相当于 4/(2*2)
        System.out.println(4>>3); // 相当于 4/(2*2*2) 结果是小于1的小数，默认int类型，则取0
//        System.out.println((int)0.2);
        System.out.println("=====1======");
        System.out.println(-4<<2); // 相当于 -4*(2*2)
        System.out.println("======2======");
        System.out.println(4>>>1);
        System.out.println(-4>>>1);//结果为什么是这样的呢？ 看下面
        System.out.println("===3====");
        System.out.println("4对应的二进制："+Integer.toBinaryString(4));
        System.out.println("-4对应的二进制："+Integer.toBinaryString(-4));
        System.out.println("上面对应的二进制length："+Integer.toBinaryString(-4).length());
        System.out.println("-4>>1对应的二进制："+Integer.toBinaryString(-4>>1));
        System.out.println("上面对应的二进制："+Integer.toBinaryString(-4>>1).length());
        System.out.println("-4>>>1对应的二进制："+Integer.toBinaryString(-4>>>1));
        System.out.println("上面对应的二进制："+Integer.toBinaryString(-4>>>1).length());

    }

    //运算符 与、或、非、异或
    private static void fun1(){
        int n = 2;

//        //十进制2 转二进制
//        System.out.println(Integer.toBinaryString(2));
//
//        //二进制10 转十进制
//        System.out.println(Integer.parseInt("10",2));

        //运算符 与&    都是1结果才是1
        System.out.println("运算符 与&    都是1结果才是1");
        int i = 10 & 6;
        System.out.println(Integer.toBinaryString(10));
        System.out.println("0"+Integer.toBinaryString(6));
        System.out.println(i);

        //或运算符 全0则0

        //异或运算 ^ 不同出1   应用：交换两个变量数值，且不用中间变量
        System.out.println("异或运算 ^ 不同出1");
        int j = 10 ^ 6;
        System.out.println(Integer.toBinaryString(10));
        System.out.println("0"+Integer.toBinaryString(6));
        System.out.println(j);
        System.out.println("异或运算应用：交换变量");
        int a=-1,b=Integer.MAX_VALUE;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" <-- a,  b --> "+b);

        //二进制10 转十进制
//        System.out.println(Integer.parseInt("11111111111111111111111111111110",2));
    }
}
