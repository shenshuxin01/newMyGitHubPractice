package ssx;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8

 */

public class NO_22 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( generateParenthesis(5) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> returnList = new ArrayList<>();
        String maxBinary="";
        String binaryNum="";  // 0代表：'('       1代表：')'
        for (int i = 0; i < n; i++) {
            maxBinary = maxBinary+11;
            binaryNum = binaryNum+"00";
        }
        long parseMaxBinaryToDecimalNum = Long.parseLong(maxBinary,2);
        for (int i = 0; i <= parseMaxBinaryToDecimalNum; i++) {

            String bracket = "";
            //遍历二进制字符串
            for (int j = 0; j < binaryNum.length(); j++) {
                if (binaryNum.charAt(j) == '0'){
                    bracket=bracket+"(";
                }else {
                    bracket=bracket+")";
                }
            }

            if (isValid(bracket)){ //方法返回值true代表为符合条件的字符串
                returnList.add(bracket);
            }

            //把二进制数转为10进制，然后加一，再转为二进制数
            long parseInt = Long.parseLong(binaryNum, 2);
            binaryNum = Integer.toUnsignedString((int)(parseInt + 1), 2);
            binaryNum = String.format("%0"+ (2*n) +"d",Long.parseLong(binaryNum));
        }
        return returnList;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c = ' ';
        char charAt = ' ';
        for (int i = 0; i < s.length(); i++) {
            charAt = s.charAt(i);
            try {
                c = stack.peek();
                if (charAt == '(' || charAt == '[' || charAt == '{'){
                    stack.push(charAt);
                }else if ((charAt == ')' && c == '(') || (charAt == ']' && c == '[') || (charAt == '}' && c == '{')){
                    stack.pop();
                }else {
                    return false;
                }
            } catch (Exception e) {
                stack.push(charAt);
            }
        }
        return stack.empty();
    }

}
