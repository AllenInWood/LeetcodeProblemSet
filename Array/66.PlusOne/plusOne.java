class Solution {
    // public int[] plusOne(int[] digits) {
    //     int len = digits.length;
    //     digits[len - 1] += 1;
    //     for (int i = digits.length - 1; i >= 0; i--) {
    //         if (digits[i] > 9) {
    //             digits[i] %= 10;
    //             if ((i - 1) < 0) {
    //                 int[] newDigits = new int[digits.length + 1];
    //                 for(int j = 1; j < digits.length; j++){
    //                     newDigits[j] = digits[j];
    //                 }
    //                 newDigits[0] = 1;
    //                 return newDigits;
    //             } else {
    //                 digits[i - 1] += 1;
    //             }
    //         }
    //     }
    //     return digits;
    // }
    
    public int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + flag > 9) {
                digits[i] = (digits[i] + flag) % 10;
                flag = 1;
                if ((i - 1) < 0) { // not enough
                    int[] newDigits = new int[digits.length + 1];
                    for (int j = 0; j < digits.length; j++) {
                        newDigits[j + 1] = digits[j];
                    }
                    newDigits[0] = flag;
                    return newDigits;
                }
            } else {
                digits[i] = digits[i] + flag;
                flag = 0;
            }
        }
        return digits;
    }
}