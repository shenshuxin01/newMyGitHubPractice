package ssx;

import java.util.Stack;

/**
 *输入：s = "()[]{}"
 * 输出：true
 *
 */

public class NO_20 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( isValid("(){[]{}()}") );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
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