class Solution {
    // public int hIndex(int[] citations) {
    //     int length = citations.length;
    //     if (citations == null || length == 0) {
    //         return 0;
    //     }
    //     int[] temp = new int[length];
    //     Arrays.fill(temp, 0);
    //     for (int i = length - 1; i >= 0; i--) {
    //         for (int j = 0; j < length; j++) {
    //             if (citations[j] > i) {
    //                 temp[i]++;
    //             }
    //         }
    //     }
    //     for (int i = length - 1; i >= 0; i--) {
    //         if (temp[i] >= i + 1) {
    //             return i + 1;
    //         }
    //     }
    //     return 0;
    // }
    
    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
        	return 0;
        }
        int[] temp = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                temp[length]++;
            } else {
                temp[citations[i]]++;
            }
        }
        int t = 0;
        int result = 0;
        
        for (int i = length; i >= 0; i--) {
            t = t + temp[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
}