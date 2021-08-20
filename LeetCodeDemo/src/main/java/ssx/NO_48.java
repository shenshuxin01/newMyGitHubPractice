package ssx;

import org.junit.Test;

import java.util.Arrays;

/**
 *给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 *输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author Shenshuxin
 * @deprecated 未开发完成，这个逻辑很简单，但是写起来很麻烦，有空再写！
 */
public class NO_48 {

    @Test
    public void testLC() {
        long l = System.currentTimeMillis();

        int[][] ints = new int[3][3];
        ints[0] = new int[]{1,2,3};
        ints[1] = new int[]{4,5,6};
        ints[2] = new int[]{7,8,9};
//        int[][] ints1 = {new int[]{1}, new int[]{2}};


        rotate(ints) ;
        System.out.println(Arrays.deepToString(ints));

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    /**
     * 这个题拖了三天了，今天做完
     * @param matrix 例子[[1,2,3],[4,5,6],[7,8,9]]
     */
    public void rotate(int[][] matrix) {
        //每一圈都要交换4次
        //退出条件是当前圈的长度=1
        //可以使用递归
        dfs(matrix,1);
    }

    /**
     * 递归交换位置
     *
     * int = new int[n][n]
     * 发现一个规律，当前深度和长度的关系，最外层的深度为1，长度为int.length
     *                                    深度为2，长度为int.length-2
     *                                    深度为3，长度为int.length-4
     *                                    ...
     *                                    深度为x，长度为int.length-(x-1)*2
     *
     * @param ints 待交换的数组
     * @param currentDepth 当前要处理的深度，最外层为1，向中心递增+1
     */
    private void dfs(int[][] ints, int currentDepth){
        //退出条件,长度为1退出
        if (ints.length-(currentDepth-1)*2 <= 1){
            return;
        }
        //交换4次，上下左右，先定义临时变量数组用于保存
        int[] tempOldInts = null,tempNewInts = null;/* = new int[ints.length-(currentDepth-1)*2];
        int[] tempNewInts = new int[ints.length-(currentDepth-1)*2];*/

        //声明当前子数组起始下标指针，从0开始
        int currentSubIndexOfInts = currentDepth-1;

        for (int i = 0; i < 4; i++) {
            //获取上-行 有效子数组，并保存于tempOldInts,注意，若此变量有值，就不重新赋值了
            tempOldInts = tempOldInts ==null ? getSubInts(ints, i, currentSubIndexOfInts) : tempNewInts;
            //获取右-行 有效子数组，并保存于tempNewInts
            tempNewInts = getSubInts(ints,i==3?0:i+1,currentSubIndexOfInts);
            //把上-行有效子数组 覆盖到 右-行有效子数组
            System.out.println();
        }
        dfs(ints,currentDepth+1);

    }

    /**
     * 获得数组中的有效子串 0右 1下 2左 3上
     *
     * @param ints 待获取的数组集合
     * @param whereInInts 指定获取数组集合中的上下左右
     * @param currentSubIndexOfInts 待获取的字串在数组集合中的下标指针 从0开始
     * @return 返回有效子串
     */
    private int[] getSubInts(int[][] ints, int whereInInts, int currentSubIndexOfInts){
        int[] resultInts = new int[ints.length-currentSubIndexOfInts*2];
        switch (whereInInts){
            //右
            case 0:
                for (int i = currentSubIndexOfInts; i < ints.length-currentSubIndexOfInts; i++) {
                    int node = ints[i][ints.length - currentSubIndexOfInts - 1];
                    resultInts[i-currentSubIndexOfInts] = node;
                }
                break;
            //下
            case 1:
                for (int i = currentSubIndexOfInts; i < ints[ints.length - 1 - currentSubIndexOfInts].length-currentSubIndexOfInts; i++) {
                    int node = ints[ints.length - 1 - currentSubIndexOfInts][i];
                    resultInts[i-currentSubIndexOfInts] = node;
                }
                break;
            //左
            case 2:
                for (int i = currentSubIndexOfInts; i < ints[currentSubIndexOfInts].length-currentSubIndexOfInts; i++) {
                    int node = ints[currentSubIndexOfInts][i];
                    resultInts[i-currentSubIndexOfInts] = node;
                }
                break;
            //上
            case 3:
                for (int i = currentSubIndexOfInts; i < ints.length-currentSubIndexOfInts; i++) {
                    int node = ints[i][currentSubIndexOfInts];
                    resultInts[i-currentSubIndexOfInts] = node;
                }
        }

        return resultInts;
    }

}
