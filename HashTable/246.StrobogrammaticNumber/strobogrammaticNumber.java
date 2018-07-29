class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        
        int low = 0, high = num.length() - 1;
        while (low <= high) {
            if (!map.containsKey(num.charAt(low))) {
                return false;
            }
            if (map.get(num.charAt(low))
                != num.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}