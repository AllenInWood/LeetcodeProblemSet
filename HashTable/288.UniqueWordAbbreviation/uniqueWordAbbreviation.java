class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String dict : dictionary) {
            String str = getKey(dict);
            if (map.containsKey(str)) {
                if (!map.get(str).equals(dict)) {
                    map.put(str, "");
                }
            } else {
                map.put(str, dict);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        if (!map.containsKey(key)) {
            return true;
        } else {
            if (map.get(key).equals(word)) {
                return true;
            }
            return false;
        }
    }
    
    private String getKey(String dict) {
        if (dict.length() <= 2) {
            return dict;
        }
        return dict.charAt(0)
            + Integer.toString(dict.length() - 2)
            + dict.charAt(dict.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */