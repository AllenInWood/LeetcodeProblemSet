class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                res++;
            }
        }
        return res;
    }
}