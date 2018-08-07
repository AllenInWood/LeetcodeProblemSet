class Solution {   
    List<String> list;
    public List<String> generatePalindromes(String s) {
        list = new ArrayList<>();
        int oddNum = 0;
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
            oddNum = (map[c] & 1) == 1 ? (oddNum + 1) : (oddNum - 1);
        }
        if (oddNum > 1) {
            return list;
        }
        
        String mid = "";
        int length = 0;
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                if ((map[i] & 1) == 1) {
                    mid = "" + (char) i;
                    map[i]--;
                }
                map[i] /= 2;
                length += map[i];
            }
        }
        generatePalindromesHelper(map, length, "", mid);
        return list;
    }
    private void generatePalindromesHelper(int[] map, int length, String s, String mid) {
        if (s.length() == length) {
            StringBuilder reverse = new StringBuilder(s).reverse();
            list.add(reverse.toString() + mid + s);
            return;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                map[i]--;
                generatePalindromesHelper(map, length, s + (char) i, mid);
                map[i]++;
            }
        }
        
    }
}