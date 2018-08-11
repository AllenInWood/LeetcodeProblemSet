class Solution {
    // two traverse
    // public int numSubarrayBoundedMax(int[] A, int L, int R) {
    //     if (A == null || A.length == 0) {
    //         return 0;
    //     }
    //     int count = 0;
    //     for (int i = 0; i < A.length; i++) {
    //         boolean pre = false;
    //         for (int j = i; j < A.length; j++) {
    //             if (A[j] > R) {
    //                 break;
    //             }
    //             if (A[j] >= L && A[j] <= R) {
    //                 pre = true;
    //                 count++;
    //             } else if (pre) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    
    
    // one traverse
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start = -1, last = -1, res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                start = last = i;
                continue;
            }
            if (A[i] >= L) {
                last = i;
            }
            res += last - start;
        }
        return res;
    }
}