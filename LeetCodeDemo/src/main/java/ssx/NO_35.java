package ssx;

/**
 *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_35 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( searchInsert(new int[]{1,3,5,6},7) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static int searchInsert(int[] nums, int target) {
        int prefix = 0,suffix = nums.length-1;
        int mid= (prefix+suffix)/2;

        while (prefix <= suffix){
            int midValue = nums[mid];
            if (target > midValue){
                prefix=mid;
            }else if (target < midValue){
                suffix=mid;
            }else {
                return mid;
            }
            if (prefix+1 >= suffix){
                int p = nums[prefix];
                int s = nums[suffix];
                if (target == p){
                    return prefix;
                }else if (target == s){
                    return suffix;
                }else if (target > s){
                    return suffix+1;
                }else if (target < p){
                    return prefix;
                }else {
                    return prefix+1;
                }
            }

            mid= (prefix+suffix)/2;

        }
        return mid;
    }

}
