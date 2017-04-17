package TestOne;


public class Eleven {

    public static int mostWater(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                left++;
            } else {
                ans = Math.max(ans, (right - left) * height[right]);
                right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(mostWater(new int[]{1, 3, 4, 2}));
        System.out.println(mostWater(new int[]{1, 3, 4, 2, 5, 6, 3}));
    }
}
