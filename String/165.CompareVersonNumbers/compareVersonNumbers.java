class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals("") || version2.equals("")) {
            return 0;
        }
        version1 += ".";
        version2 += ".";
        int res = helper(version1, version2);
        
        return res;
    }
    private int helper(String str1, String str2) {
        if (str1.equals("") && str2.equals("")) {
            return 0;
        } else if (str1.equals("")) {
            str1 += "0.";
        } else if (str2.equals("")) {
            str2 += "0.";
        }
        
        String sub1 = str1.substring(0, str1.indexOf("."));
        String sub2 = str2.substring(0, str2.indexOf("."));
        
        String s1 = str1.substring(str1.indexOf(".") + 1);
        String s2 = str2.substring(str2.indexOf(".") + 1);
        
        if (Integer.parseInt(sub1) > Integer.parseInt(sub2)) {
            return 1;
        } else if (Integer.parseInt(sub1) < Integer.parseInt(sub2)) {
            return -1;
        } else {
            return helper(s1, s2);
        }
    }
}