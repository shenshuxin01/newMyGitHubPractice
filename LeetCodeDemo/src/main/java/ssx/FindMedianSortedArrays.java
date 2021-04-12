package ssx;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindMedianSortedArrays {
    public static double main1() {
        int[] nums1 = {2,3};
        int[] nums2 = {};

        double d;
        ArrayList<Integer> l = new ArrayList<>();
        IntStream stream1 = Arrays.stream(nums1);
        IntStream stream2 = Arrays.stream(nums2);
        stream1.forEach(s -> l.add(s));
        stream2.forEach((s)->{
            l.add(s);
        });
        l.sort((o1, o2) -> {
            return o1 - o2;
        });
        if (l.size() % 2 == 0){
            Integer integer1 = l.get(l.size() / 2 - 1);
            Integer integer2 = l.get(l.size() / 2);
            integer1 +=integer2;
            d = (double)integer1;
            d /= 2;
            return d;
        }else {
            Integer integer1 = l.get(l.size() / 2);
            return integer1;
        }
    }


    public static void main(String[] args) {
        double v = main1();
        System.out.println(v);
    }
}
