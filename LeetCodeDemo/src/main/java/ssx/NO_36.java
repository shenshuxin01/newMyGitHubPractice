package ssx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 数独部分空格内已填入了数字，空白格用 '.' 表示。

 注意：

 一个有效的数独（部分已被填充）不一定是可解的。
 只需要根据以上规则，验证已经填入的数字是否有效即可。


 示例 1：


 输入：board =
 [["5","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 输出：true
 示例 2：

 输入：board =
 [["8","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 输出：false
 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。


 提示：

 board.length == 9
 board[i].length == 9
 board[i][j] 是一位数字或者 '.'
 *
 */

public class NO_36 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        /**
         *
         * [["5","3",".",".","7",".",".",".","."],
         * ["6",".",".","1","9","5",".",".","."],
         * [".","9","8",".",".",".",".","6","."],
         * ["8",".",".",".","6",".",".",".","3"],
         * ["4",".",".","8",".","3",".",".","1"],
         * ["7",".",".",".","2",".",".",".","6"],
         * [".","6",".",".",".",".","2","8","."],
         * [".",".",".","4","1","9",".",".","5"],
         * [".",".",".",".","8",".",".","7","9"]]
         */
        char[][] board = new char[9][9];

        String s="\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"";
        String[] split = s.split("],\\[");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(",");
            for (int j = 0; j < split1.length; j++) {
                String substring = split1[j].substring(1, 2);
                board[i][j]=substring.toCharArray()[0];
            }
//            System.out.println(Arrays.toString(board[i]));

        }

        System.out.println( isValidSudoku(board) );

        System.out.println("执行时间："+(System.currentTimeMillis()-l)+"毫秒");
    }

    /**
     *
     * [["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]]
     */
    public static boolean isValidSudoku(char[][] board) {

        HashSet<Character> atRow0 = new HashSet<Character>();

        ArrayList<HashSet<Character>> listCols = new ArrayList<>();
        HashSet<Character> atCol0 = new HashSet<Character>();
        listCols.add(atCol0);

        ArrayList<HashSet<Character>> listAreas = new ArrayList<>();
        HashSet<Character> atArea0 = new HashSet<Character>();
        listAreas.add(atArea0);
        listAreas.add(new HashSet<Character>());
        listAreas.add(new HashSet<Character>());
/**
 *        0i 0-2 j 0-2       1i 0-2 j 3-5     2i 0-2 j 6-8
 *        3i 3-5 j 0-2       4i 3-5 j 3-5     5i 3-5 j 6-8
 *        6i 6-8 j 0-2       7i 6-8 j 3-5     8i 6-8 j 6-8
 *
 */

        boolean isPoint;
        boolean isRowLast;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //判断列
                try {
                    HashSet<Character> set = listCols.get(j);
                }catch (IndexOutOfBoundsException e){
                    listCols.add(new HashSet<Character>() );
                }

                char at = board[i][j];
                isPoint = at == '.';
                // i值空值行号0~8、j值空值列数0~8
                if (!isPoint) {
                    //判断行
                    boolean add = atRow0.add(at);
                    if (!add){
                        return false;
                    }


                    boolean addCol = listCols.get(j).add(at);
                    if (!addCol){
                        return false;
                    }

                    //判断区
                    if (i<3){
                        if (j<3){
                            boolean add0 = listAreas.get(0).add(at);
                            if (!add0){
                                return false;
                            }
                        }else if (j>5){
                            boolean add1 = listAreas.get(1).add(at);
                            if (!add1){
                                return false;
                            }
                        }else {
                            boolean add2 = listAreas.get(2).add(at);
                            if (!add2){
                                return false;
                            }
                        }
                    }
                    else if (i>5){
                        if (j<3){
                            boolean add0 = listAreas.get(0).add(at);
                            if (!add0){
                                return false;
                            }
                        }else if (j>5){
                            boolean add1 = listAreas.get(1).add(at);
                            if (!add1){
                                return false;
                            }
                        }else {
                            boolean add2 = listAreas.get(2).add(at);
                            if (!add2){
                                return false;
                            }
                        }
                    }
                    else {
                        if (j<3){
                            boolean add0 = listAreas.get(0).add(at);
                            if (!add0){
                                return false;
                            }
                        }else if (j>5){
                            boolean add1 = listAreas.get(1).add(at);
                            if (!add1){
                                return false;
                            }
                        }else {
                            boolean add2 = listAreas.get(2).add(at);
                            if (!add2){
                                return false;
                            }
                        }
                    }

                }

                //重置行
                isRowLast = j==8;
                if (isRowLast) {
                    atRow0.clear();
                    if (i%3==2){
                        listAreas.get(0).clear();
                        listAreas.get(1).clear();
                        listAreas.get(2).clear();
                    }
                }
            }
        }

        return true;
    }
}
