package ssx;

public class NO7 {
    public static void main(String[] args) {
        System.out.println(executeFun(-2147483648));
    }
    static int executeFun(int num){
        //判断是不是负数
        boolean flag =false;
        if (num < 0){
            flag=true;
            num *= (-1);
        }
        //把字符串存入 buffer
        StringBuilder stringBuilder = new StringBuilder("" + num);
        //反转字符串
        stringBuilder.reverse();
        //字符串转int
        //判断是否在区间 利用抛异常
        int parseInt = 0;
        try {
             parseInt = Integer.parseInt(stringBuilder.toString());
             if (flag){
                 parseInt = parseInt*(-1);
             }
        }catch (NumberFormatException e){
            //e.printStackTrace();
        }
        return parseInt;
    }
}
