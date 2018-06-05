class Solution {
    // left and right part array
    // public int longestMountain(int[] A) {
//         int[] left = new int[A.length];
//         int[] right = new int[A.length];
//         for (int i = 0; i < A.length; i++) {
//             if (i == 0 || A[i - 1] >= A[i]) {
//                 left[i] = 0;
//             } else {
//                 left[i] = left[i - 1] + 1;
//             }
//         }
//         for (int i = A.length - 1; i >= 0; i--) {
//             if (i == A.length - 1 || A[i + 1] >= A[i]) {
//                 right[i] = 0;
//             } else {
//                 right[i] = right[i + 1] + 1;
//             }
//         }
        
//         int max = 0;
//         for (int i = 0; i < A.length; i++) {
//             if (left[i] > 0 && right[i] > 0) {
//                 max = Math.max(max, left[i] + right[i] + 1);
//             }
//         }
//         return max;
//     }
    
    
    
    // one traverse
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int l = i, r = i;
                while ((l - 1) >= 0 && A[l] > A[l - 1]) {
                    l--;
                }
                while ((r + 1) < A.length && A[r] > A[r + 1]) {
                    r++;
                }
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}