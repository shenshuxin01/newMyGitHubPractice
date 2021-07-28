package ssx;

import java.util.HashSet;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 */

public class NO_44 {
    private static int a = 0;


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        //"abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab"
        //"*aabb***aa**a******aa*"
        System.out.println( isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
               , "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a" ) );

        //同步 13175毫秒
        //测试异步：：



        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }
    private static HashSet<Boolean> resultFlag=new HashSet<>();

    public static boolean isMatch(String s, String p) {
        try {
            p = p.replaceAll("\\*+", "*");
        } catch (Exception e) {
            return false;
        }
        System.out.println(p);

        fnc(s,p);
        return resultFlag.contains(true);
    }

    //递归函数
    private static void fnc(String currentS,String currentP){
        if (a++%10000000 == 0){
            System.out.println(a);
        }
        if (resultFlag.contains(true)){
            return;
        }
       //推出条件
        //字符串S已经匹配完比，退出
        if (currentS==null || currentS.length()==0){
            resultFlag.add( currentP == null || currentP.length() == 0);
            Optional<String> currentP1 = Optional.ofNullable(currentP);
            boolean present = currentP1.isPresent();
            if (present) resultFlag.add(currentP.matches("^\\*\\**\\*$"));
            resultFlag.add("*".equals(currentP));
            return;
        }
        //当前S有值，但是P已经匹配完毕，可以退出
        else if (currentP==null || currentP.length()==0){
            resultFlag.add(false);
            return;
        }
        //剪枝操作，判断当前的S是否等于P，若不等于则返回false,当前S、P都不为空
        else {
            char ats = currentS.charAt(0);
            char atp = currentP.charAt(0);
            if (atp !='*' && atp != '?' && atp!=ats){
                resultFlag.add(false);
                return;
            }
        }

        char atp = currentP.charAt(0);
        if (atp =='*'){
            //使用当前指针，并且当前指针不后裔
            fnc(currentS.substring(1),currentP);

//            Future<Integer> submit = executorService.submit(() -> {
//                fnc(currentS.substring(1),currentP);
//                return 1;
//            });
//            vector.add(submit);

            //不使用当前指针，指针后移
            fnc(currentS, currentP.substring(1));

//            Future<Integer> submit1 = executorService.submit(() -> {
//                fnc(currentS, currentP.substring(1));
//                return 1;
//            });
//            vector.add(submit1);

        }else if (atp=='?'){
            //都后移
            fnc(currentS.substring(1),currentP.substring(1));
        }else {
            //都后移
            fnc(currentS.substring(1),currentP.substring(1));
        }


    }

}
