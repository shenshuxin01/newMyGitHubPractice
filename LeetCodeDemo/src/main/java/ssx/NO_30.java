package ssx;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 *给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_30 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
//"barfoofoobarthefoobarman"
//["bar","foo","the"]
        List<Integer> barfoothefoobarman = findSubstring("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab",


                new String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"});
//                new String[]{"ab"});

        assert barfoothefoobarman != null;
        System.out.println(barfoothefoobarman.size());
        barfoothefoobarman.forEach(System.out::println);

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();

        LinkedList<String> listBak = null;

        LinkedList<String> list = new LinkedList<>(Arrays.asList(words));
        ArrayList<Integer> returnList = new ArrayList<>();

        int i1 = s.length() - wordLength * words.length;
        for (int i = 0; i <= i1; i++) {
            String substring = s.substring(i, i + wordLength);
            if (list.contains(substring)){
                //调用方法，以wordLength为长度 判断
                listBak = new LinkedList<>(Arrays.asList(words));
                int rightFun = rightFun(i, s, listBak,wordLength);
                if (rightFun == 1){
                    returnList.add(i);
                }
                //可以尝试多线程 提高效率
            }
        }

        return returnList;
    }

    private static int rightFun(int start,String string,List list,int wordLen) {
        try {
            int i = 0;
            while (true) {//  23456789
                String substring = string.substring(start + wordLen * i, start + wordLen * i + wordLen);
                int i1 = list.indexOf(substring);
                if (i1 == -1) {
                    return -1;
                } else {
                    list.remove(i1);
                    if (list.size() == 0) {
                        return 1;
                    }
                }

                i++;
            }
        }catch (Exception e){
            return -1;
        }
    }


















//    public static List<Integer> findSubstring(String s, String[] words) {
//        int wordLength = words[0].length();
////        new CountDownLatch()
//        int countA = 0;
//        int[] countB = {0};
//
//        LinkedList<String> listBak = null;
//
//         LinkedList<String> list = new LinkedList<>(Arrays.asList(words));
//         ArrayList<Integer> returnList = new ArrayList<>();
//
//        int i1 = s.length() - wordLength * words.length;
//        for (int i = 0; i <= i1; i++) {
//            String substring = s.substring(i, i + wordLength);
//            if (list.contains(substring)){
//                //调用方法，以wordLength为长度 判断
//                                        //                listBak = new LinkedList<>(Arrays.asList(words));
//                                        //                int rightFun = rightFun(i, s, listBak,wordLength);
//                                        //                if (rightFun == 1){
//                                        //                    returnList.add(i);
//                                        //                }
//                //可以尝试多线程 提高效率
//                new MyThread(listBak, words, i, s, wordLength, returnList,countB).start();
//                countA++;
//            }
//        }
//    //        System.out.println("一个几个线程："+count);\
//        while (true){
//            if (countA == countB[0]){
//                break;
//            }
//        }
//        return returnList;
//    }
//
//    private static class MyThread extends Thread{
//        List list;
//        List returnList;
//        String [] strings;
//        int i;
//        String s;
//        int wordLen;
//        int[] count;
//
//        public MyThread(List list, String[] strings, int i, String s, int wordLen,List returnList,int[] count) {
//            this.list = list;
//            this.returnList = returnList;
//            this.strings = strings;
//            this.i = i;
//            this.count = count;
//            this.s = s;
//            this.wordLen = wordLen;
//        }
//
//        @Override
//        public void run() {
//            list = new LinkedList<>(Arrays.asList(strings));
//            int rightFun = rightFun(i, s, list,wordLen);
//            if (rightFun == 1){
//                returnList.add(i);
//            }
//            count[0]++;
//        }
//    }
//
//    private static int rightFun(int start,String string,List list,int wordLen) {
//        try {
//            int i = 0;
//            while (true) {//  23456789
//                String substring = string.substring(start + wordLen * i, start + wordLen * i + wordLen);
//                int i1 = list.indexOf(substring);
//                if (i1 == -1) {
//                    return -1;
//                } else {
//                    list.remove(i1);
//                    if (list.size() == 0) {
//                        return 1;
//                    }
//                }
//
//                i++;
//            }
//        }catch (Exception e){
//            return -1;
//        }
//    }

}
