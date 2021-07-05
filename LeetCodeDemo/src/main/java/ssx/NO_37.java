//package ssx;
//
//import org.omg.PortableInterceptor.INACTIVE;
//
//import java.io.FileNotFoundException;
//import java.io.PrintStream;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.*;
//
//import static java.lang.System.*;
//
///**
// *编写一个程序，通过填充空格来解决数独问题。
// *
// * 数独的解法需 遵循如下规则：
// *
// * 数字 1-9 在每一行只能出现一次。
// * 数字 1-9 在每一列只能出现一次。
// * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
// * 数独部分空格内已填入了数字，空白格用 '.' 表示。
// *
// *  
// *
// * 示例：
// *
// *
// * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
// * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// *
// *
// *  
// *
// * 提示：
// *
// * board.length == 9
// * board[i].length == 9
// * board[i][j] 是一位数字或者 '.'
// * 题目数据 保证 输入数独仅有一个解
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/sudoku-solver
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// *
// */
//
//public class NO_37 {
//    //存区域未出现的数字     9个
//    static ArrayList<LinkedList<Character>> areas = new ArrayList<>();
//    static Map<Integer, LinkedList<Character>> getIndexMap = new HashMap<>();
//    static int globalCount=0;
//
//    public static void main(String[] args) {
//        long l = currentTimeMillis();
//        char[][] board = new char[9][9];
//
//        String s="\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"";
//        String[] split = s.split("],\\[");
//        for (int i = 0; i < split.length; i++) {
//            String[] split1 = split[i].split(",");
//            for (int j = 0; j < split1.length; j++) {
//                String substring = split1[j].substring(1, 2);
//                board[i][j] = substring.toCharArray()[0];
//            }
//        }
//
//        new NO_37().solveSudoku(board);
//
//        out.println("执行时间："+(currentTimeMillis()-l)+"毫秒");
//    }
//
//    public void solveSudoku(char[][] board){
//        //        /**
////         *
////         *[["5","3",".",".","7",".",".",".","."],
////         * ["6",".",".","1","9","5",".",".","."],
////         * [".","9","8",".",".",".",".","6","."],
////         *
////         * ["8",".",".",".","6",".",".",".","3"],
////         * ["4",".",".","8",".","3",".",".","1"],
////         * ["7",".",".",".","2",".",".",".","6"],
////         *
////         * [".","6",".",".",".",".","2","8","."],
////         * [".",".",".","4","1","9",".",".","5"],
////         * [".",".",".",".","8",".",".","7","9"]]
////         */
//
//        //需要存一行未出现的数字  9个
//        ArrayList<LinkedList<Character>> rows = new ArrayList<>();
//        //存一列未出现的数字     9个
//        ArrayList<LinkedList<Character>> cols = new ArrayList<>();
//
//        ArrayList<ArrayList> boardLists = new ArrayList<>();
//
//        //遍历整个数组
//        for (int i = 0; i < board.length; i++) {
//            LinkedList<Character> row = new LinkedList<>();
//            for (int j = 49; j <= 57; j++) { //'1'->49
//                row.add((char)j);
//            }
//            rows.add(row);
//
//            for (int j = 0; j < board[i].length; j++) {
//                char c = board[i][j];
//
//                //记录行
//                row.remove(new Character(c)); //可能会抛异常 .不存在列表
//
//                //记录列
//                LinkedList<Character> col=null;
//                try{
//                    col = cols.get(j);
//                }catch (IndexOutOfBoundsException e){
//                    col = new LinkedList<>();
//                    cols.add(col);
//                    for (int k = 49; k <= 57; k++) { //'1'->49
//                        col.add((char)k);
//                    }
//                }
//                col.remove(new Character(c));
//
//                //记录区
//                if (i<3){
//                    if (j<3){
//                        storList(0,c,i,j);
//                    }else if (j>5){
//                        storList(2,c,i,j);
//                    }else {
//                        storList(1,c,i,j);
//                    }
//                }else if (i>5){
//                    if (j<3){
//                        storList(6,c,i,j);
//                    }else if (j>5){
//                        storList(8,c,i,j);
//                    }else {
//                        storList(7,c,i,j);
//                    }
//                }else {
//                    if (j<3){
//                        storList(3,c,i,j);
//                    }else if (j>5){
//                        storList(5,c,i,j);
//                    }else {
//                        storList(4,c,i,j);
//                    }
//                }
//
//                ArrayList e = new ArrayList();
//                //取得所有可能性
//                e.add(-1);//该可能性的集合指针
//                e.add(1);//该可能性的集合size
//                e.add(c);
//                boardLists.add(e);
//            }
//        }
//
//        //把可能性存于board
//        for (int i = 0; i < boardLists.size(); i++) {
//            ArrayList list = boardLists.get(i);
//            if ((char) list.get(2) == '.'){
//                list.remove(2);
//                LinkedList<Character> row = rows.get(i / 9);
//                LinkedList<Character> col = cols.get(i % 9);
//                LinkedList<Character> area = getIndexMap.get(i);
//
//                ArrayList<Character> set = new ArrayList<>();
//                for (int j = 0; j < row.size(); j++) {
//                    set.add(row.get(j));
//                }
//                for (int j = 0; j < 2; j++) {
//                    LinkedList<Character> l = j==0?col:area;
//                    for (int k = 0; k < set.size(); k++) {
//                        Character character = set.get(k);
//                        if (!l.contains(character)){
//                            set.set(k,'N');
//                        }
//                    }
//                }
//
//                set.forEach(s->{
//                    if (s.equals('N')){
//                        return;
//                    }
//                    list.add(s);
//                });
//                list.set(1,list.size()-2);
//
//            }
//        }
////        out.println(boardLists);
//
//        //新改动开始
//        int boardListsIndex = 0;
//        while (boardListsIndex <= 80) {//等于81则代表整个board已经赋值结束  //遍历整个board
//            ArrayList getNode = boardLists.get(boardListsIndex);//获取当前节点
//            int nodeSize = (int)getNode.get(1);//获取节点大小
//            if (nodeSize == 1){ //当前节点为固定节点，直接pass
//                boardListsIndex++;
//                continue;
//            }else {  //为空节点，进行赋值
//                int currentNodeIndexAndBoardListsIndex = getCurrentNodeIndexAndBoardListsIndex(getNode, boardLists,boardListsIndex);
////                boardListsIndex
//
//            }
//        }
//
//
//
//    }
//
//
//    //如果是-1回溯操作的话就需要先把当前节点index=-1，然后处理上一个节点
//    private static int getCurrentNodeIndexAndBoardListsIndex(ArrayList getNode,ArrayList<ArrayList> boardLists,int boardListsIndex){
//        int nodeIndex = (int) getNode.get(0);
//        int nodeSize = (int) getNode.get(1);
//        char currentValue = (char) getNode.get(nodeIndex);
//
//        //获取当前节点所在行的可能性（排除当前节点）  保存于rows
//        ArrayList<Character> rows = new ArrayList<>();
//        for (int j = 49; j <= 57; j++) { //'1'->49
//            char j1 = (char) j;
//            rows.add(j1);
//        }
//        int currentRow = boardListsIndex / 9;
//        for (int i=9*currentRow; i<10*currentRow; i++){
//            ArrayList arrayList = boardLists.get(i);
//            int alIndex = (int) arrayList.get(0);
//            char alChar = (char) arrayList.get(alIndex);
//            rows.remove(new Character(alChar));
//        }
//
//
//        //获取当前节点所在列的可能性
//        ArrayList<Character> cols = new ArrayList<>();
//        for (int j = 49; j <= 57; j++) { //'1'->49
//            char j1 = (char) j;
//            cols.add(j1);
//        }
//        int currentCol = boardListsIndex % 9;
//        for (int i = 0; i < 8; i++) {
//            ArrayList arrayList = boardLists.get(9 * i + currentCol);
//            int alIndex = (int) arrayList.get(0);
//            char alChar = (char) arrayList.get(alIndex);
//            cols.remove(new Character(alChar));
//        }
//
//        //获取当前节点所在区的可能性
//        ArrayList<Character> areas = new ArrayList<>();
//        for (int j = 49; j <= 57; j++) { //'1'->49
//            char j1 = (char) j;
//            areas.add(j1);
//        }
//
//
//return 0;
//    }
//
//
//
//
////    public static void solveSudoku(char[][] board) throws FileNotFoundException {
////        /**
////         *
////         *[["5","3",".",".","7",".",".",".","."],
////         * ["6",".",".","1","9","5",".",".","."],
////         * [".","9","8",".",".",".",".","6","."],
////         *
////         * ["8",".",".",".","6",".",".",".","3"],
////         * ["4",".",".","8",".","3",".",".","1"],
////         * ["7",".",".",".","2",".",".",".","6"],
////         *
////         * [".","6",".",".",".",".","2","8","."],
////         * [".",".",".","4","1","9",".",".","5"],
////         * [".",".",".",".","8",".",".","7","9"]]
////         */
////
////        //需要存一行未出现的数字  9个
////        ArrayList<LinkedList<Character>> rows = new ArrayList<>();
////        //存一列未出现的数字     9个
////        ArrayList<LinkedList<Character>> cols = new ArrayList<>();
////
////        ArrayList<ArrayList> boardLists = new ArrayList<>();
////
////        //遍历整个数组
////        for (int i = 0; i < board.length; i++) {
////            LinkedList<Character> row = new LinkedList<>();
////            for (int j = 49; j <= 57; j++) { //'1'->49
////                row.add((char)j);
////            }
////            rows.add(row);
////
////            for (int j = 0; j < board[i].length; j++) {
////                char c = board[i][j];
////
////                //记录行
////                row.remove(new Character(c)); //可能会抛异常 .不存在列表
////
////                //记录列
////                LinkedList<Character> col=null;
////                try{
////                    col = cols.get(j);
////                }catch (IndexOutOfBoundsException e){
////                    col = new LinkedList<>();
////                    cols.add(col);
////                    for (int k = 49; k <= 57; k++) { //'1'->49
////                        col.add((char)k);
////                    }
////                }
////                col.remove(new Character(c));
////
////                //记录区
////                if (i<3){
////                    if (j<3){
////                        storList(0,c,i,j);
////                    }else if (j>5){
////                        storList(2,c,i,j);
////                    }else {
////                        storList(1,c,i,j);
////                    }
////                }else if (i>5){
////                    if (j<3){
////                        storList(6,c,i,j);
////                    }else if (j>5){
////                        storList(8,c,i,j);
////                    }else {
////                        storList(7,c,i,j);
////                    }
////                }else {
////                    if (j<3){
////                        storList(3,c,i,j);
////                    }else if (j>5){
////                        storList(5,c,i,j);
////                    }else {
////                        storList(4,c,i,j);
////                    }
////                }
////
////                ArrayList e = new ArrayList();
////                //取得所有可能性
////                e.add(2);//该可能性的集合指针，从2开始
////                e.add(1);//该可能性的集合size
////                e.add(c);
////                boardLists.add(e);
////            }
////        }
////
////        //把可能性存于board
////        for (int i = 0; i < boardLists.size(); i++) {
////            ArrayList list = boardLists.get(i);
////            if ((char) list.get(2) == '.'){
////                list.remove(2);
////                LinkedList<Character> row = rows.get(i / 9);
////                LinkedList<Character> col = cols.get(i % 9);
////                LinkedList<Character> area = getIndexMap.get(i);
////
////                ArrayList<Character> set = new ArrayList<>();
////                for (int j = 0; j < row.size(); j++) {
////                    set.add(row.get(j));
////                }
////                for (int j = 0; j < 2; j++) {
////                    LinkedList<Character> l = j==0?col:area;
////                    for (int k = 0; k < set.size(); k++) {
////                        Character character = set.get(k);
////                        if (!l.contains(character)){
////                            set.set(k,'N');
////                        }
////                    }
////                }
////
////                set.forEach(s->{
////                    if (s.equals('N')){
////                        return;
////                    }
////                    list.add(s);
////                });
////                list.set(1,list.size()-2);
////
////            }
////        }
////        HashSet<String> set = new HashSet<>();
////
////
////
////
////        while (true) {
////
////            StringBuilder stringBuilder = new StringBuilder();
////            if (++globalCount==500) return;
////            //列出当前一个可能性
////            char[][] testBoard = new char[9][9];
////            for (int i = 80; i > -1; i--) {
////                int b0 = i / 9;
////                int b1 = i % 9;
////                ArrayList pointList = boardLists.get(i);
////                int currentIndex = (int) pointList.get(0);
////                int s = (int) pointList.get(1);
////                testBoard[b0][b1] = (char) pointList.get(currentIndex);
////                if (s!=1){
////                    stringBuilder.append(testBoard[b0][b1]);
////                }
////
////                //12211132223311441511252224151121232122322211221
////                //42515132223311441511252224151121232122322211221
////
////            }
////            String s = stringBuilder.toString();
////            out.println(s);
////            boolean add = set.add(s);
////            if (!add){
////                out.println("错误！！"+s);
////            }
////
////
//////            System.out.println("=============================");
//////            System.out.println(++globalCount);
//////            System.out.println("=============================");
//////            for (int i = 0; i < 9; i++) {
//////                for (int j = 0; j < 9; j++) {
//////                    System.out.print(testBoard[i][j] + ",");
//////                }
//////                System.out.println();
//////            }
////
////
////            //开始+1
////            for (int i = boardLists.size()-1; i >= 0; i--) {
////                ArrayList list = boardLists.get(i);
////                int size = (int) list.get(1);
////                if (size==1){
////                    continue;
////                }
////                int index = (int) list.get(0);
////                if (index == size+1){
////                    //需要进位操作
////                    //把当前index重置
////                    list.set(0,2);
////                    //下一个list++
////                    nextListAdd(boardLists,i);
////                    break;
////                }else if (index < size+1){
////                    index++;
////                    list.set(0,index);
////                    break;
////                }
////            }
////
////            if (NO_36.isValidSudoku(testBoard)){
////                out.println("=============================");
////                out.println(++globalCount);
////                out.println("=============================");
////                for (int i = 0; i < 9; i++) {
////                    for (int j = 0; j < 9; j++) {
////                        out.print(testBoard[i][j] + ",");
////                    }
////                    out.println();
////                }
////                return;
////            }
////
////        }
////
////
////    }
////
//    private static void storList(int listIndex,Character c,int fi,int fj){
//        LinkedList<Character> area=null;
//        try{
//            area = areas.get(listIndex);
//        }catch (IndexOutOfBoundsException e){
//            area = new LinkedList<>();
//            areas.add(area);
//            for (int k = 49; k <= 57; k++) { //'1'->49
//                area.add((char)k);
//            }
//        }
//        area.remove(new Character(c));
//
//        int i = fi * 9 + fj;
//        getIndexMap.put(i,area);
//
//    }
////
////    //需要+1的list
//    private static void nextListAdd(ArrayList<ArrayList> all,int currentList){
//
//        ArrayList nextList = all.get(currentList - 1);
//        int size = (int) nextList.get(1);
//        int index = (int) nextList.get(0);
//        if (size==1){
//            nextListAdd(all,currentList-1);
//        }else if (index == size+1){
//            nextList.set(0,2);
//            nextListAdd(all,currentList-1);
//        }else {
//            nextList.set(0,++index);
//        }
//    }
//
//}
