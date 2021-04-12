public class TestDemo {
    public static void main(String[] args) {

        int[][] ints = new int[2][];
        ints[1]= new int[]{0,1,2,3,4};
        ints[0]= new int[]{0,1};
//        System.out.println(ints[1][2]);
        int b=0;
        System.out.println(b);
        fun(++b);
        System.out.println(b);

    }
   static void fun(int a){
       System.out.println(a);
   }
}

