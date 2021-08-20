package ssx;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 */

public class NO_49 {

    @Test
    public void testLC() {
        long l = System.currentTimeMillis();

        System.out.println( groupAnagrams(new String[]{"a"})  );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String >> tempMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            StringBuilder newStr = new StringBuilder();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for (int j = 0; j < chars.length; j++) {
                newStr.append(chars[j]);
            }
            //当前sort后的单词是否已经出现在map里面
            addNewStr(tempMap,newStr.toString(),str);
        }

        List<List<String>> lists = new ArrayList<>();

        tempMap.forEach((k, v) -> {
            lists.add(v);
        });
        return lists;
    }

    /**
     * 此方法实现 字符串插入到list里面，如果字符串不存在就新建map-K,若存在就追加map-V
     * @param tempMap
     * @param newStr
     * @param mapKStr
     */
    private void addNewStr(Map<String,List<String >> tempMap,String newStr,String mapKStr){
        AtomicBoolean flag = new AtomicBoolean(false);
        tempMap.forEach((k,v) ->{
            if (newStr.equals(k)){
                v.add(mapKStr);
                flag.set(true);
            }
        });
        if (!flag.get()){
            ArrayList<String> v = new ArrayList<>();
            v.add(mapKStr);
            tempMap.put(newStr, v);
        }
    }

}
