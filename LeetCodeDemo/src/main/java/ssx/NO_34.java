package ssx;

import java.util.Arrays;

/**
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 通过次数263,928提交次数621,226
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_34 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println(Arrays.toString(new NO_34().searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public int[] searchRange(int[] nums, int target) {
        int prefix=-1,suffix=-1;
        int binarySearch = Arrays.binarySearch(nums, target);
        if (binarySearch >= 0){
            int prefixA =0,suffixA=binarySearch;
            while (true){ //prefix
                  int binarySearch1 = Arrays.binarySearch(nums, prefixA, suffixA, target);
                if (binarySearch1<0){
                    prefix=suffixA;
                    break;
                }
                if (binarySearch1==0? true:nums[binarySearch1-1]!=target){
                    prefix=binarySearch1;
                    break;
                }
                suffixA=binarySearch1;
            }

            prefixA=binarySearch;
            int length = nums.length;
            suffixA= length;
            while (true){ //suffix
                int binarySearch2 = Arrays.binarySearch(nums, prefixA, suffixA, target);

                if (binarySearch2==length-1?true: nums[binarySearch2+1]!=target){
                    suffix=binarySearch2;
                    break;
                }

                prefixA=binarySearch2;
                if (prefixA==length-1?false:nums[prefixA+1]==target){
                    prefixA++;
                }else {
                    suffix=prefixA;
                    break;
                }

//                if (suffixA -2 == prefixA){
//                    suffix= nums[suffixA-1]==target?suffixA-1:suffixA-1-1;
//                    break;
//                }

            }
        }
        return new int[]{prefix,suffix};
    }

}
