package ssx;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NO_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    static String intToRoman(int num) {
        String resultStr="" ;


        //判断个位
        int int1 = num % 10;
        if(int1 == 1){
            resultStr = "I" + resultStr;
        }else if(int1 == 2){
            resultStr = "II" + resultStr;
        }else if (int1 == 3){
            resultStr = "III" + resultStr;
        }else if (int1 == 4){
            resultStr = "IV" + resultStr;
        }else if (int1 == 5){
            resultStr = "V" + resultStr;
        }else if (int1 == 6){
            resultStr = "VI" + resultStr;
        }else if (int1 == 7){
            resultStr = "VII" + resultStr;
        }else if (int1 == 8){
            resultStr = "VIII" + resultStr;
        }else if (int1 == 9){
            resultStr = "IX" + resultStr;
        }

        //判断十位
        int int2 = (num/10) % 10;
        if(int2 == 1){
            resultStr = "X" + resultStr;
        }else if(int2 == 2){
            resultStr = "XX" + resultStr;
        }else if (int2 == 3){
            resultStr = "XXX" + resultStr;
        }else if (int2 == 4){
            resultStr = "XL" + resultStr;
        }else if (int2 == 5){
            resultStr = "L" + resultStr;
        }else if (int2 == 6){
            resultStr = "LX" + resultStr;
        }else if (int2 == 7){
            resultStr = "LXX" + resultStr;
        }else if (int2 == 8){
            resultStr = "LXXX" + resultStr;
        }else if (int2 == 9){
            resultStr = "XC" + resultStr;
        }

        //判断百位
        int int3 = (num/100) % 10;
        if(int3 == 1){
            resultStr = "C" + resultStr;
        }else if(int3 == 2){
            resultStr = "CC" + resultStr;
        }else if (int3 == 3){
            resultStr = "CCC" + resultStr;
        }else if (int3 == 4){
            resultStr = "CD" + resultStr;
        }else if (int3 == 5){
            resultStr = "D" + resultStr;
        }else if (int3 == 6){
            resultStr = "DC" + resultStr;
        }else if (int3 == 7){
            resultStr = "DCC" + resultStr;
        }else if (int3 == 8){
            resultStr = "DCCC" + resultStr;
        }else if (int3 == 9){
            resultStr = "CM" + resultStr;
        }

        //判断千位
        int int4 = (num/1000) % 10;
        if(int4 == 1){
            resultStr = "M" + resultStr;
        }else if(int4 == 2){
            resultStr = "MM" + resultStr;
        }else if (int4 == 3){
            resultStr = "MMM" + resultStr;
        }

        return "" + resultStr;
    }


    /* static String intToRoman(int num) {
        String resultStr="" ;


        //判断个位
        int int1 = num % 10;
        if(int1 == 1){
            resultStr = "I" + resultStr;
        }else if(int1 == 2){
            resultStr = "II" + resultStr;
        }else if (int1 == 3){
            resultStr = "III" + resultStr;
        }else if (int1 == 4){
            resultStr = "IV" + resultStr;
        }else if (int1 == 5){
            resultStr = "V" + resultStr;
        }else if (int1 == 6){
            resultStr = "VI" + resultStr;
        }else if (int1 == 7){
            resultStr = "VII" + resultStr;
        }else if (int1 == 8){
            resultStr = "VIII" + resultStr;
        }else if (int1 == 9){
            resultStr = "IX" + resultStr;
        }

        //判断十位
        int int2 = (num/10) % 10;
        if(int2 == 1){
            resultStr = "X" + resultStr;
        }else if(int2 == 2){
            resultStr = "XX" + resultStr;
        }else if (int2 == 3){
            resultStr = "XXX" + resultStr;
        }else if (int2 == 4){
            resultStr = "XL" + resultStr;
        }else if (int2 == 5){
            resultStr = "L" + resultStr;
        }else if (int2 == 6){
            resultStr = "LX" + resultStr;
        }else if (int2 == 7){
            resultStr = "LXX" + resultStr;
        }else if (int2 == 8){
            resultStr = "LXXX" + resultStr;
        }else if (int2 == 9){
            resultStr = "XC" + resultStr;
        }

        //判断百位
        int int3 = (num/100) % 10;
        if(int3 == 1){
            resultStr = "C" + resultStr;
        }else if(int3 == 2){
            resultStr = "CC" + resultStr;
        }else if (int3 == 3){
            resultStr = "CCC" + resultStr;
        }else if (int3 == 4){
            resultStr = "CD" + resultStr;
        }else if (int3 == 5){
            resultStr = "D" + resultStr;
        }else if (int3 == 6){
            resultStr = "DC" + resultStr;
        }else if (int3 == 7){
            resultStr = "DCC" + resultStr;
        }else if (int3 == 8){
            resultStr = "DCCC" + resultStr;
        }else if (int3 == 9){
            resultStr = "CM" + resultStr;
        }

        //判断千位
        int int4 = (num/1000) % 10;
        if(int4 == 1){
            resultStr = "M" + resultStr;
        }else if(int4 == 2){
            resultStr = "MM" + resultStr;
        }else if (int4 == 3){
            resultStr = "MMM" + resultStr;
        }

        return "" + resultStr;
    }
    */
}
