package ssx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NO_46 {

    @Test
    public void testLC() {
        long l = System.currentTimeMillis();

        System.out.println( permute(new int[]{1}) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    private List<List<Integer>> returnList = new ArrayList<>();
    private int numsLen ;

    public List<List<Integer>> permute(int[] nums) {
        numsLen = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add);
        huiSu(0,list);
        return returnList;
    }

    private void huiSu(int currentIndex,List<Integer> currentList){
        //判断参1 和numsLen的关系
        if (currentIndex > numsLen){
            return;
        }else if (currentIndex == numsLen){
            returnList.add(currentList);
            return;
        }else if (currentIndex < numsLen){
            for (int i = currentIndex; i < numsLen; i++){
                //分别让此区间的数当作当前数据的的位置，进行回溯
                //交换数字内两个变量的位置
                List<Integer> integers = changeNumsTwo(new ArrayList<>(currentList), currentIndex, i);
                huiSu(currentIndex+1,integers);
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
