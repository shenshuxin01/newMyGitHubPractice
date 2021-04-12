package ssx;

public class NO_11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,1}));
    }

    static int maxArea(int[] height) {
        int resultInt = 0;

        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int area = Math.min(height[i],height[j]) * (j-i);
                resultInt = Math.max(resultInt,area);
            }
        }
        return resultInt;
    }
}