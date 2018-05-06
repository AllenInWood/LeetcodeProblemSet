class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            if (!map.containsKey(difficulty[i])) {
                map.put(difficulty[i], profit[i]);
            } else {
                int val = map.get(difficulty[i]);
                if (profit[i] > val) {
                    map.put(difficulty[i], profit[i]);
                }
            }
        }
        int sum = 0;
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        int di = 0;
        int wo = 0;
        
        int max = 0;
        while (wo < worker.length) {
            int cap = worker[wo++];
            while (di < difficulty.length && difficulty[di] <= cap) {
                max = Math.max(max, map.get(difficulty[di++]));
            }
            sum += max;
        }
        return sum;
    }
}