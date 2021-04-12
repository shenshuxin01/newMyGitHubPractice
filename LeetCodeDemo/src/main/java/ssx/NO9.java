package ssx;

public class NO9 {
    public static void main(String[] args) {
        System.out.println(executeFun(2100));
    }

    static boolean executeFun(int x){
        if (x < 0){
            return false;
        }else if (x < 10){
            return true;
        }

        int y = 0;
        int z = x;
        while (true) {
            int tailNum = tailNum(x);
            if (x > 9) {
                x = x / 10;
            } else {
                y *= 10;
                y += tailNum;
                break;
            }
            y *= 10;
            y += tailNum;
        }
        if (y == z){
            return true;
        }else {
            return false;
        }
    }

    static int tailNum(int x){
        return x % 10;
    }
}
