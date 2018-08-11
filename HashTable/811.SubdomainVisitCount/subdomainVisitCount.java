class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] line = str.split(" ");
            int count = Integer.valueOf(line[0]);
            String[] domains = line[1].split("\\.");
            String temp = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                temp = domains[i] + ((temp == "") ? temp : "." + temp);
                if (!map.containsKey(temp)) {
                    map.put(temp, count);
                } else {
                    map.put(temp, map.get(temp) + count);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (String str : map.keySet()) {
            ans.add(map.get(str) + " " + str);
        }
        return ans;
    }
}