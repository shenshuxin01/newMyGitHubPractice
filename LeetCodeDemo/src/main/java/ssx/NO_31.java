package ssx;

import java.util.Arrays;

/**
 *实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_31 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        int[] ints = {1,2,3};
//        int[] ints = {1,3,2};
        nextPermutation(ints);

        Arrays.stream(ints).forEach(s-> System.out.print(s+","));
        System.out.println();
        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    //[1,20,3,4,5,6,3]
    //[1,20,3,4,6,3,5]
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int tail = nums[length-1];

        for (int i = length-2; i >= 0; i--) {
            int head = nums[i];
            if (head < tail){
                 // --需求变更、在5后面的集合里面选出最大值，和5交换位置。。。相当于从5开始升序，最后一位放到前面


                //把5及其后续的所有节点进行升序排列
                    //求出节点长度，进行遍历
                for (int j = i; j < length; j++) {
                    //采用冒泡排序、快速排序等，实现快速排列
//                    int max=nums[j];
                    for (int k = i+1; k<length-(j-i); k++){
                        if (nums[k-1] > nums[k]){
//                             nums[k] = nums[k-1] ^ nums[k];
//                             nums[k-1] = nums[k-1] ^ nums[k];
//                             nums[k] = nums[k-1] ^ nums[k];
                            int tem = nums[k-1];

                            nums[k-1] = nums[k];
                            nums[k] = tem;
                        }
                    }
                }
                //子集里面最小的但是大于nums[i]，移动到 nums[i]  6676  6766
                int index=length-1;
                while (true){
                    if (nums[index]>head && nums[index-1]<= head){
                        while (index>i){
                            nums[index] = nums[index]^nums[index-1];
                            nums[index-1] = nums[index]^nums[index-1];
                            nums[index] = nums[index]^nums[index-1];
                            index--;
                        }
                        return;
                    }
                    index--;
                }

//                return;
            }
            tail=head;
        }
        Arrays.sort(nums);
    }

}
