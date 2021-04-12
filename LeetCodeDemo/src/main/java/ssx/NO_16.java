package ssx;
/*
* 输入：nums = [-1,2,1,-4], target = 1
  输出：2
  解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
*  */

public class NO_16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{  1,1,1,1  },-3));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int numsLength = nums.length;
        int tempNum = getSumNum(nums[0]+nums[1]+nums[2], target);
        for (int i = 0; i < numsLength-2; i++) {
            for (int j = i+1; j < numsLength-1; j++) {
                for (int k = j+1; k < numsLength; k++) {
                    //调用方法 比较两个数字相差几个单位
                    int sumNum = getSumNum(nums[i]+nums[j]+nums[k], target);
                    //调用方法，比较两个数字哪个更接近0
                    tempNum = fun(tempNum,sumNum);
                }
            }
        }
        return tempNum+target;
    }
    //调用方法 比较两个数字相差几个单位  3  4
    public static int getSumNum(int a,int t){
//        if (t>a){
//            return (Math.abs(a-t))*(-1);
//        }else {
//            return a-t;
//        }
        return a-t;
    }

    //调用方法，比较两个数字哪个更接近0
    public static int fun(int a,int b){
        boolean aFlag = a<0;
        boolean bFlag = b<0;// true  - zero big
        a=Math.abs(a);
        b=Math.abs(b);
        int min;
        if (a>b){
            min = bFlag?(-1)*b:b;
        }else {
            min = aFlag?(-1)*a:a;
        }
        return min;
    }
}
