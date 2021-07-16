package ssx;

import java.util.*;

/**
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_40 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println( new NO_40().combinationSum2(new int[]{10,1,2,7,6,1,5},8) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    private Set<List<Integer>> returnSet = new HashSet<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        sdf(0,new ArrayList<>(),target);

        ArrayList<List<Integer>> returnList = new ArrayList<>();
        Object[] objects = returnSet.toArray();
        for (int i = 0; i < objects.length; i++) {
            returnList.add((ArrayList<Integer>) objects[i]);
        }
        return  returnList;
    }

    private void sdf(int idx, ArrayList<Integer> calcNums,int target){
        // 出口
        if (target == 0){
            Collections.sort(calcNums);
            returnSet.add(calcNums);
            return;
        }else if (target < 0){
            return;
        }else if (idx == candidates.length){
            return;
        }

        //使用当前idx
        ArrayList<Integer> list = new ArrayList<>(calcNums);
        list.add(candidates[idx]);
        sdf(idx+1,list,target-candidates[idx]);

        //不使用当前id
        ArrayList<Integer> list2 = new ArrayList<>(calcNums);
        sdf(idx+1,list2,target);

    }

}
