package ssx;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123456787654321234567876543", num2 = "2435465767564354"
 * 输出: "300674780105560928351107164372122879548222"
 * 说明：
 *
 * num1 和 num2 的长度小于110。 代表Long类型也存不下去
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */

public class NO_43 {

    public static void main(String[] args) {


        long l = System.currentTimeMillis();
       System.out.println(multiply("0","0")  );
        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }


    public static String multiply2(String num1, String num2) {
       return new BigInteger(num1).multiply(new BigInteger(num2)).toString();


    }
    public static String multiply(String num1, String num2) {
        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();
        ArrayList<ArrayList<Integer>> subResults = new ArrayList<>();

        for (int i = num2s.length-1; i >= 0 ; i--) {
            ArrayList<Integer> subResult = new ArrayList<>();
            int current2Num = num2s[i] -48;
            boolean carryFlag = false;
            int carryValue = 0;

            for (int k = 0; k < (num2s.length-1 - i); k++) {
                subResult.add(0);
            }
            for (int j = num1s.length-1; j >= 0 ; j--) {

                int current1Num = num1s[j] -48;
                int multiplication = current1Num * current2Num;
                if (carryFlag){
                    multiplication = carryValue +  multiplication ;
                }

                if (multiplication >9){
                    carryFlag = true;
                    carryValue = multiplication/10;
                }else {
                    carryFlag = false;
                }
                subResult.add(multiplication % 10);
                if (j==0){
                    if (carryFlag) subResult.add(carryValue);
                    subResults.add(subResult);
                }
            }

        }
        return getResultStr(subResults);
    }

    private static String getResultStr(ArrayList<ArrayList<Integer>> lists){
        StringBuilder stringBuilder = new StringBuilder();

        //获取最高位是鸡
        int paraReturnLen = lists.get(lists.size() - 1).size();

        int carryValue = 0;
        boolean carryFlag = false;
        //指针越小，越靠近个位
        for (int i = 0; i < paraReturnLen; i++) {
            //外层循环位数
            //内层计算当前位数，从各位开始计算，个位是0

            //当前cell累计求和
            int cellCount = 0;
            for (int j = 0; j < lists.size(); j++) {
                Integer cellNum=0;
                try {
                    cellNum = lists.get(j).get(i);
                } catch (Exception e) {
                    cellNum = 0;
                }
                cellCount+=cellNum;
            } //最终的cellCount值最大是81

            if (carryFlag){
                cellCount+=carryValue;
            }
            if (cellCount >9){
                carryFlag = true;
                carryValue = cellCount/10;
            }else {
                carryFlag = false;
            }
            stringBuilder.insert(0,cellCount % 10);

        }
        if (carryFlag){
            stringBuilder.insert(0,carryValue);
        }
        String s = stringBuilder.toString();
        String retStr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' == c){
                if (i==s.length()-1){
                    return "0";
                }
                continue;
            }else {
              return  s.substring(i);
            }
        }
        return s;
    }

}
