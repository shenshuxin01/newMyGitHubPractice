package ssx;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoSum{

    public int[] twoSum(int[] nums, int target) {  //{3,2,4}  6
        int[] result= {0,0};

        for(int i=0;i<nums.length;i++){
            // System.out.println(i);
            for(int j=nums.length-1; j>i; j--){

                if(target == (nums[i]+nums[j])){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = new TwoSum().twoSum(nums, 6);
        IntStream ints1 = Arrays.stream(ints);

//        System.out.println(ints1);
        ints1.forEach(
                (s)->{
                    System.out.println(s);
                }
        );
    }
}
