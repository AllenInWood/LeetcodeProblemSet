class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int i = map.get(list2[j]);
                if (i + j < minIndexSum) {
                    ans.clear();
                    minIndexSum = i + j;
                    ans.add(list2[j]);
                } else if (i + j == minIndexSum) {
                    ans.add(list2[j]);
                }
            }
        }
        String[] result = new String[ans.size()];
        return ans.toArray(result);
    }
}