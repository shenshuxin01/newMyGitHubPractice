package ssx;
/**
 * 2    3    4      5      6    7     8      9
 * abc  def  ghi    jkl   mno  pqrs  tuv    wxyz
 * ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("ALL")
public class NO_17 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        List<String> strings = letterCombinations("3");

        System.out.println(strings);

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static List<String> letterCombinations(String digits) {
        int lengthArg2 = digits.length();


        HashMap<String, List<Character>> map = new HashMap<>();


        String str="";
        ArrayList<String> returnList = new ArrayList<>();
        if (lengthArg2==0){
            return returnList;
        }
        boolean flagAddMap =true;
        while (true) {
             for (int i = 0; i < lengthArg2; i++) {
                char charAt = digits.charAt(i);
                 String s = "" + i;

                 if (flagAddMap) {
                     //如果map没有，就创建
                     //if (!map.containsKey(s)) {
                         map.put(s, getListFun(toIntFun(charAt)));
                     //}
                 }
                 List<Character> characterList = map.get(s);

                    int indexZero = toIntFun(characterList.get(0));
                    Character character = characterList.get(indexZero);
                    int size = characterList.size();
                    str = str+character;

                    //判段是否进位index0 的操作
                if (i == lengthArg2-1){
                    returnList.add(str);

                    indexZero++;
                    if (indexZero < size){
                        //yes
                        char element = toCharFun(indexZero);
                        characterList.set(0, element);
                    }else {
                        // no
                        char element = toCharFun(1);
                        characterList.set(0, element);
                        //进行进位
                        for (int j = lengthArg2-1-1; j >= 0; j--) {
                            List<Character> characterList1 = map.get(""+j);
                            Character c = characterList1.get(0);
                            int i1indexZero = toIntFun(c);
                            int size1 = characterList1.size();
                            if (size1-1 == i1indexZero){
                                if (j==0){
                                    return returnList;
                                }
                                characterList1.set(0, element);
                                continue;
                            }else {
                                char element1 = toCharFun(++i1indexZero);
                                characterList1.set(0, element1);
                                break;
                            }

                        }
                        if (lengthArg2 <= 1){
                            return returnList;
                        }

                    }
                }

            }
             flagAddMap=false;

            str = "";
        }
    }
    static int toIntFun(char c){
        return ((int)c) - 48;
    }
    static char toCharFun(int c){
        return (char) (c + 48);
    }
    static List<Character> getListFun(int who){
        switch (who) {
            case 2:
                ArrayList<Character> list2 = new ArrayList<Character>();
                list2.add(0, '1');
                list2.add('a');
                list2.add('b');
                list2.add('c');
                return list2;
            case 3:
                ArrayList list3 = new ArrayList();
                list3.add(0, '1');
                list3.add('d');
                list3.add('e');
                list3.add('f');
                return list3 ;
            case 4:
            ArrayList list4 = new ArrayList();
            list4.add(0, '1');
            list4.add('g');
            list4.add('h');
            list4.add('i');
                return list4 ;
            case 5:
                ArrayList list5 = new ArrayList();
                list5.add(0, '1');
                list5.add('j');
                list5.add('k');
                list5.add('l');
                return list5 ;
            case 6:
                ArrayList list6 = new ArrayList();
                list6.add(0, '1');
                list6.add('m');
                list6.add('n');
                list6.add('o');
                return list6 ;
            case 7:
                ArrayList list7 = new ArrayList();
                list7.add(0, '1');
                list7.add('p');
                list7.add('q');
                list7.add('r');
                list7.add('s');
                return list7 ;
            case 8:
                ArrayList list8 = new ArrayList();
                list8.add(0, '1');
                list8.add('t');
                list8.add('u');
                list8.add('v');
                return list8 ;
            case 9:
                ArrayList list9 = new ArrayList();
                list9.add(0, '1');
                list9.add('w');
                list9.add('x');
                list9.add('y');
                list9.add('z');
            return list9 ;
        }
        return null;
    }
}