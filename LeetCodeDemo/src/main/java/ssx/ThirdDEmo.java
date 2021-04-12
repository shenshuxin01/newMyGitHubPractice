package ssx;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.HashSet;

public class ThirdDEmo {
    public static void main(String[] args) {
        String sourceStr = "aabcab";
        String resultStr = "";
        for (int i = 0; i < sourceStr.length(); i++) {
            HashSet<Character> set = new HashSet();
            int j=i;
            String tempStr = "";
            while (j<sourceStr.length()){
                char one = sourceStr.charAt(j);
                boolean b = set.add(one);
                if (b){
                    tempStr += one;
                }else {
                    if (resultStr.length() < tempStr.length()){
                        resultStr = tempStr;
                    }
                    break;
                }
                if (j+1 == sourceStr.length()){
                    if (resultStr.length() < tempStr.length()){
                        resultStr = tempStr;
                    }
                }
                j++;
            }
        }
        System.out.println(resultStr);
    }
}
