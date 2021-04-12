package ssx;

import java.util.ArrayList;
import java.util.HashMap;

public class NO6 {
    public static void main(String[] args) {
        String executeFun = executeFun("ab", 1);
        System.out.println(executeFun);
    }

    static String executeFun(String s, int numRows){
        //创建 numRows个 map存字符串
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 1; i <= numRows; i++) {
            map.put(i,new ArrayList<String>());
        }

        //int pointer
        int pointerMax = numRows;
        int pointer = 1;

        //是否正序
        boolean clockwise = true;
        if (numRows == 1){
            return s;
        }

        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //if  ---  list.add()
            if (clockwise && (pointer) < pointerMax){
                map.get(pointer).add(""+s.charAt(i));
                pointer++;
            }else if (clockwise && (pointer) == pointerMax){
                map.get(pointer).add(""+s.charAt(i));
                pointer--;
                clockwise = false;
            }else if (!clockwise && (pointer) > 1){
                map.get(pointer).add(""+s.charAt(i));
                pointer--;
            }else if (!clockwise && (pointer) == 1){
                map.get(pointer).add(""+s.charAt(i));
                pointer++;
                clockwise = true;
            }
        }
        //拼接最终返回字符串
        StringBuilder resultStr = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            map.get(i).forEach(s1 -> resultStr.append(s1));
        }
        return resultStr.toString();
    }


}
