class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length == 0) {
//             return 0;
//         }
//         int[] left = new int[height.length];
//         int[] right = new int[height.length];
//         int leftMax = 0;
//         for (int i = 0; i < height.length; i++) {
//             left[i] = leftMax;
//             leftMax = Math.max(leftMax, height[i]);
//         }
//         int rightMax = 0;
//         for (int i = height.length - 1; i >= 0; i--) {
//             right[i] = rightMax;
//             rightMax = Math.max(rightMax, height[i]);
//         }
        
//         int res = 0;
//         for (int i = 0; i < height.length; i++) {
//             int threshold = Math.min(left[i], right[i]);
//             res += (threshold > height[i]) ? threshold - height[i] : 0;
//         }
//         return res;
//     }
    
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}