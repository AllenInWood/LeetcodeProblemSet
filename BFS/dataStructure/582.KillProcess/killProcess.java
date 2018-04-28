class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<>();
        if (pid == null || pid.size() == 0) {
            return ans;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            if (!mapping.containsKey(pp)) {
                mapping.put(pp, new ArrayList<>());
            }
            mapping.get(pp).add(p);
        }
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            if (mapping.containsKey(cur)) {
                for (int pro : mapping.get(cur)) {
                    queue.offer(pro);
                }
            }
        }
        return ans;
    }
}