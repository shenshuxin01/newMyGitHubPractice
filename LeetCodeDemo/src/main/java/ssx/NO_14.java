package ssx;

import java.util.HashSet;

public class NO_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }
    public static String longestCommonPrefix(String[] strs) {
        int indexNum = 0;

        try {

            while (true) {
                HashSet<Character> set = new HashSet<>();
                boolean add = set.add(strs[0].charAt(indexNum));
                //循环数组
                for (int i = 0; i < strs.length; i++) {
                    //取字符
                    char c = strs[i].charAt(indexNum);
                    //是否匹配
                    add = set.add(c);
                    if (add) {
                        //不配
                        return strs[0].substring(0, indexNum );
                    }
                }
                indexNum++;
            }
        }catch (IndexOutOfBoundsException e){
            if (indexNum != 0){
                return strs[0].substring(0, indexNum );
            }
        }
        return "";
    }
}
