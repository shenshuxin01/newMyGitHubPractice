package ssx;

/**
 *给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_29 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( divide(2147483647,1) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    /**
     * 输入：
     * -2147483648
     * -1
     * 输出：
     * -1
     * 预期结果：
     * 2147483647

     */

    public static int divide(int dividend, int divisor) {
//        if (dividend==Integer.MIN_VALUE){
//
//        }else if (divisor == Integer.MIN_VALUE){
//
//        }
        int x = -1;

        if (dividend>=0 && divisor<0 || dividend<0 && divisor>=0){ //结果是负数 --
            dividend = dividend <0 ? dividend : Integer.parseInt("-"+Math.abs(dividend)); //现在是负数
            divisor = divisor <0 ? divisor : Integer.parseInt("-"+Math.abs(divisor)); //负数

            while (true){
                int count = 0;
                for (int i = 0; i > divisor; i--) {
                    count +=x;
                }
                if (count == dividend){
                    return x;
                }else if (count < dividend){
                    return x+1;
                }
                x--;

            }
        }else { //结果是正数 ++
            dividend = dividend <0 ? dividend : Integer.parseInt("-"+Math.abs(dividend)); //现在是负数
            divisor = divisor <0 ? divisor : Integer.parseInt("-"+Math.abs(divisor)); //负数
            while (true) {
                int count = 0;
                for (int i = 0; i > divisor; i--) {
                    count +=x;
                }
                if (count == dividend){
                    return Math.abs(x) == Integer.MIN_VALUE? Integer.MAX_VALUE:Math.abs(x);
                }else if (count < dividend){
                    return Math.abs(x+1);
                }
                x--;
            }
        }
//        return 0;
    }

}
