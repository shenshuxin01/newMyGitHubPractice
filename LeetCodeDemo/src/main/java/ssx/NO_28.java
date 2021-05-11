package ssx;

/**
 *实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_28 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( strStr("zxcv","xc") );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static int strStr(String haystack, String needle) {
//        int pram1 = haystack.length();
//        int needle.length() = needle.length();


        try {
            for (int i = needle.length() - 1; i <= haystack.length() - 1; i++) {
//                String substring = ;
//                int i1 = ;
//                int i2 = ;
                if (needle.hashCode() == haystack.substring(i - needle.length()+1, i+1).hashCode()) {
                    return i - needle.length()+1;
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            return 0;
        }
        return -1;
    }

}
