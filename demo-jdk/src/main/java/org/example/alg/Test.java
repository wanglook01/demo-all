package org.example.alg;

public class Test {

    public static void main(String[] args) {
        //System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(Integer.valueOf(200) == Integer.valueOf(200));
        new Object().equals()
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                right = mid;
                ans = mid;
            } else {
                left = mid;
            }
        }
        return ans;
    }
}
