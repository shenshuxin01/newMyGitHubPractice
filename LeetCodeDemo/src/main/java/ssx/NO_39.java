package ssx;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个无重复元素的数组candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class NO_39 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println(new NO_39().combinationSum(new int[]{2,3,5},8));

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    //用于保存结果集
    private List<List<Integer>> returnList = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0,new ArrayList<Integer>(),target);
        return returnList;
    }

    private void dfs(int idx,List<Integer> calcNums,int target){
        //退出条件：idx到达末端 或者calcNums大于等于target
        if (idx == candidates.length){
            return;
        }else if(target == 0){
            returnList.add(calcNums);
            return;
        }else if (target < 0){
            return;
        }

        //情况1.跳过当前idx
        dfs(idx+1,new ArrayList<>(calcNums),target);

        //情况2.选择当前idx
        calcNums.add(candidates[idx]);
        dfs(idx,new ArrayList<>(calcNums),target-candidates[idx]);
    }

}
