package ssx;

import java.util.ArrayList;
import java.util.HashSet;

public class NO5 {
    static String shuffleStr(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 67; i++) {

            int d = (int)Math.floor(Math.random() * 26) + 65;
            char c = (char) d;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String s = shuffleStr();
        System.out.println(s);
        System.out.println(fun(s));
    }

    public static String[] main() {
        String s = shuffleStr();
        String fun = fun(s);
        return new String[]{s,fun};
    }
    static String fun(String str) {
        //String str = "aaaa";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if (set.size()==1){
            //System.out.println(str);
            return str;
        }
        String returnStr = "";
        for (int i = 0; i < str.length(); i++) {//遍历字符串 str
            char c = str.charAt(i); //提取每一个字符
            int lengthNum = lengthNum(i+1,str.length());
            String maxSubStr = maxSubStr(c, str, i, lengthNum);//获取当前最大的回文字串
            returnStr = ifResultStr(maxSubStr, returnStr);//判断是否最终最长的回文子串
        }

        String twoSubStr = twoSubStr(str);//判断 “xarra”类型
        returnStr = ifResultStr(twoSubStr,returnStr);
        //System.out.println(returnStr);
        return returnStr;
    }

    static String twoSubStr(String str){
        String twoSubStrReturn ="";
        //找出所有的、两个字符相邻的字串 保存其始末位置、字串
        ArrayList<String[]> list = new ArrayList<>();
        char temp1=str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (temp1 == str.charAt(i)){
                list.add(new String[]{""+temp1+temp1,""+(i-1),""+i,""}); //字串、开始位置、结束位置
            }
            temp1 = str.charAt(i);
        }
        //遍历list
        for (int i = 0; i < list.size(); i++) {
            String[] everyOneList = list.get(i);
            //找出取出可能的最大的回文字串的  长度 /2
            int shortNum = Math.min(Integer.parseInt(everyOneList[1]) + 1 - 1, str.length() - Integer.parseInt(everyOneList[2]) - 1);
            //找出当前的最大回文子串
            String twoMaxSubOne = twoMaxSubOne(str,everyOneList[0],Integer.parseInt(everyOneList[1]),Integer.parseInt(everyOneList[2]),shortNum);
            //判断是否是最大的字串
            twoSubStrReturn = ifResultStr(twoSubStrReturn, twoMaxSubOne);
        }

        return twoSubStrReturn;
    }

    static String twoMaxSubOne(String str,String middleStr,int headIndex,int tailIndex,int shortNum){
        String currentStr=middleStr;
        for (int i = 1; i <= shortNum; i++) {
            if (str.charAt(headIndex-i) == str.charAt(tailIndex+i)){
                currentStr = str.charAt(headIndex-i) + currentStr + str.charAt(headIndex-i);
            } else {
                break;
            }
        }
        return currentStr;
    }

    static int lengthNum(int i,int strLength){ //取出可能的最大的回文字串的  长度 /2
        int shortNum = Math.min(i - 1, strLength - i);
        return shortNum;
    }

    static String maxSubStr(char c,String str,int n,int lengthNum){
        String currentSubStr = ""+c;
        //String tempStr = currentSubStr;
        if (lengthNum == 0){
            return currentSubStr;
        }
        for (int i = 1; i <= lengthNum; i++) {
            char cHead = str.charAt(n - i);
            char cTail = str.charAt(n + i);

            if (cHead == cTail) {
                currentSubStr = cHead + currentSubStr + cTail;
            }else if (c == cTail || c == cHead){
                if (i !=1 ){
                    break;
                }
                currentSubStr = c == cTail ? currentSubStr +cTail : cHead + currentSubStr;
                break;
            }else {
                break;
            }
        }
        return currentSubStr;
    }

    static String ifResultStr(String m,String r){
        if (m.length() > r.length()){
            return m;
        }else {
            return r;
        }
    }
}
