class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> hash = new HashSet<>();
        for (int candy : candies) {
            hash.add(candy);
        }
        if (hash.size() > candies.length / 2) {
            return candies.length / 2;
        }
        return hash.size();
    }
}