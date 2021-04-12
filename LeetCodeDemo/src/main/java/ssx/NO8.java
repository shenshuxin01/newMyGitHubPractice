package ssx;


public class NO8 {
    public static void main(String[] args) {
        System.out.println(executeFun(""));
    }
    static int executeFun(String s){
        //去空格
        s = s.trim();
        if (s.length() == 0){
            return 0;
        }

        //判断首字符是否符合条件
        boolean positiveInt =false;
        boolean negativeInt =false;
        if(s.charAt(0) == '+'){
            positiveInt = true;
        }else if (s.charAt(0) == '-'){
            negativeInt = true;
        }else if (48 <= (int)s.charAt(0) && (int)s.charAt(0) <= 57){
            positiveInt = true;
            s = '+' + s;
        }else {
            return 0;
        }

        long temp = 0;
        long returnInt = 0;


        //遍历字符串
        for (int i = 1; i < s.length(); i++) {
            //判断字符是否符合条件
            if (48 <= (int)s.charAt(i) && (int)s.charAt(i) <= 57){
                temp = (int)s.charAt(i) - 48;
                returnInt = returnInt * 10;
                if (ifOutOfMaxLength(positiveInt,returnInt)){
                    return positiveInt ? 2147483647 : -2147483648;
                }
                returnInt = returnInt + temp;
                if (ifOutOfMaxLength(positiveInt,returnInt)){
                    return positiveInt ? 2147483647 : -2147483648;
                }
            }else {
                break;
            }
        }

        int anInt = (int) returnInt;
        return negativeInt ? anInt*(-1) : anInt;
    }
    static boolean ifOutOfMaxLength(boolean positive,long num){

        if (positive){
            if (num >= 2147483648L){
                return true;
            }
        }else {
            if (num >= 2147483649L){
                return true;
            }
        }
        return false;
    }
}
