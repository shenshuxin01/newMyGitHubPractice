package ssx;

import java.util.HashMap;

public class NO_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));

    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int resultNum = 0;

        //倒序遍历字符串s
        for (int length = s.length()-1; length >= 0; length--) {
            char c1 = s.charAt(length);
            char c2;
            if (length==s.length()-1) {
                c2 = c1;
            }else {
                c2 = s.charAt(length+1);
            }
        //判断当前字符 和上一字符谁大
            if (map.get(""+c1) >= map.get(""+c2)){
                resultNum +=  map.get(""+c1);
            }else {
                resultNum -= map.get(""+c1)  ;
            }


        }
            return resultNum;



    }
}
