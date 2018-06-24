class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }
//         int n1 = nums1.length, n2 = nums2.length;
//         if (nums1.length == 0) {
//             return ((double) nums2[(n2 - 1) / 2] + (double) nums2[n2 / 2]) / 2;
//         }
//         int size = n1 + n2;
//         int cut1 = n1 / 2;
//         int cut2 = size / 2 - cut1;
//         int cutL = 0, cutR = n1;
        
//         while (cut1 <= n1) {
//             cut1 = cutL + (cutR - cutL) / 2;
//             cut2 = size / 2 - cut1;
            
//             double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
//             double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
//             double r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
//             double r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
            
//             if (l1 > r2) {
//                 cutR = cut1 - 1;
//             } else if (l2 > r1) {
//                 cutL = cut1 + 1;
//             } else { // correct cut
//                 if (size % 2 == 0) {
//                     double l = Math.max(l1, l2);
//                     double r = Math.min(r1, r2);
//                     return (l + r) / 2;
//                 } else {
//                     double r = Math.min(r1, r2);
//                     return r;
//                 }
//             }
//         }
//         return -1;
//     }
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length, n2 = nums2.length;
        if (nums1.length == 0) {
            if (n2 % 2 == 0) {
                return ((double) nums2[(n2 - 1) / 2] + (double) nums2[n2 / 2]) / 2;
            } else {
                return (double) nums2[n2 / 2];
            }
        }
        int left = (n1 + n2 + 1) / 2;
        int cut1 = n1 / 2;
        int cut2 = left - cut1;
        int cutL = 0, cutR = n1;
        while (cut1 <= n1) {
            cut1 = cutL + (cutR - cutL) / 2;
            cut2 = left - cut1;
            
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
            
            if (l1 > r2) {
                cutR = cut1 - 1;
            } else if (l2 > r1) {
                cutL = cut1 + 1;
            } else { // correct cut
                if ((n1 + n2) % 2 == 0) {
                    double l = Math.max(l1, l2);
                    double r = Math.min(r1, r2);
                    return (l + r) / 2;
                } else {
                    double l = Math.max(l1, l2);
                    return l;
                }
            }
        }
        return -1;
    }
}