package ssx;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 */

public class NO_45 {

    @Test
    public void testLC() {
        System.out.println("开始测试");
        long l = System.currentTimeMillis();

        System.out.println( jump(new int[]{1,1}) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }


    //贪心算法
    public int jump(int[] nums) {
        //定义当前指针
        int indexK=0;
        int numsLen = nums.length;
        int countStep = 0;

        while (true) {
            //退出条件
            if (indexK>=numsLen-1){
                break;
            }
            //定义当前指针所指的值的大小
            int indexV = nums[indexK];

            if (indexV+indexK>=numsLen-1){
                countStep++;
                break;
            }

            int currentMaxK = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            //遍历 [当前指针的下标,指针下标+指针所指的值]
            for (int i = indexK+1; i<=indexK+indexV && i<numsLen; i++){
                currentMaxK = Math.max(currentMaxK,nums[i]+i);
                map.put(nums[i]+i,i);
            }
            // 取出最大的值，然后跳到此处
            indexK = map.get(currentMaxK);
            countStep++;
            //  继续while循环，。直到数组末尾
        }
        return countStep;
    }



}
