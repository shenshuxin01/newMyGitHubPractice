package ssx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 */

public class NO_18 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( fourSum(new int[]{     },0) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        int numsLength = nums.length;
        if (numsLength<4){
            return returnList;
        }
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < numsLength-1-1-1; i++) {
            for (int j = i+1; j < numsLength-2; j++) {
                for (int k = j+1; k < numsLength-1; k++) {
                    for (int l = k+1; l < numsLength; l++) {
                        int num = nums[i];
                        int num1 = nums[j];
                        int num2 = nums[k];
                        int num3 = nums[l];
                        if (num + num1 + num2 + num3 == target ){
                            if (set.add(""+ num +","+ num1 +","+ num2 +","+ num3)){
                                ArrayList<Integer> integers = new ArrayList<>();
                                integers.add(num);
                                integers.add(num1);
                                integers.add(num2);
                                integers.add(num3);
                                returnList.add(integers);
                            }
                        }

                    }
                }
            }
        }
        return returnList;
    }

}
