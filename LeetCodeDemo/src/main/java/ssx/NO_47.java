package ssx;

import org.junit.Test;

import java.util.*;

/**
 *给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_47 {

    @Test
    public void testLC() {
        long l = System.currentTimeMillis();

        System.out.println( permuteUnique(new int[]{1,2,1}) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }


    private final List<List<Integer>> returnList = new ArrayList<>();
    private int numsLen;

    public List<List<Integer>> permuteUnique(int[] nums) {

        numsLen = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add);
        digui(0,list);
        return returnList;
    }

    private void digui(int currentIndex, List<Integer> currentList){
        //判断参1 和numsLen的关系
        if (currentIndex > numsLen){
            return;
        }else if (currentIndex == numsLen){
            returnList.add(currentList);
            return;
        }else if (currentIndex < numsLen){
            HashSet<Integer> set = new HashSet<>();
            for (int i = currentIndex; i < numsLen; i++){
                if (!set.add(currentList.get(i))) continue;
                //分别让此区间的数当作当前数据的的位置，进行回溯
                //交换数字内两个变量的位置
                List<Integer> integers = changeNumsTwo(new ArrayList<>(currentList), currentIndex, i);
                digui(currentIndex+1,integers);
            }
        }else {
            throw new RuntimeException("错误！这是哪？？+currentIndex+currentList"+currentIndex+"||||"+currentList);
        }
    }

    private List<Integer> changeNumsTwo(List<Integer> changeNums, int index1, int index2){
        if (changeNums == null || changeNums.size()<2) return changeNums;
        int temp = changeNums.get(index1);
        changeNums.set(index1,changeNums.get(index2)) ;
        changeNums.set(index2,temp);
        return changeNums;
    }
}
