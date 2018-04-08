class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIp(s, ans, "", 0, 0);
        return ans;
    }
    private void restoreIp(String s, List<String> ans, String temp, int index, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && index == s.length()) {
            ans.add(temp);
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            String t = s.substring(index, index + i);
            if ((t.startsWith("0") && t.length() > 1) || (i == 3 && Integer.parseInt(t) >= 256)) {
                continue;
            }
            restoreIp(s, ans, temp + t + (count == 3 ? "" : "."), index + i, count + 1);
        }
    }
}