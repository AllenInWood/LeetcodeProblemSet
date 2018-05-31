class Solution {
    // Time Limit Exceeded
    // public List<List<String>> wordSquares(String[] words) {
    //     List<List<String>> ans = new ArrayList<>();
    //     if (words == null || words.length == 0) {
    //         return ans;
    //     }
    //     int len = words[0].length();
    //     backtracking(ans, new ArrayList<>(), words, 0, len);
    //     return ans;
    // }
    // private void backtracking(List<List<String>> ans,
    //                           List<String> temp,
    //                           String[] words,
    //                           int start,
    //                           int len) {
    //     if (start == len) {
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     for (String word : words) {
    //         boolean isValid = true;
    //         for (int i = 0; i < temp.size(); i++) {
    //             if (temp.get(i).charAt(start) != word.charAt(i)) {
    //                 isValid = false;
    //                 break;
    //             }
    //         }
    //         if (!isValid) {
    //             continue;
    //         }
    //         temp.add(word);
    //         backtracking(ans, temp, words, start + 1, len);
    //         temp.remove(temp.size() - 1);
    //     }
    // }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        int len = words[0].length();
        for (String word : words) {
            for (int i = 1; i <= len; i++) {
                if (!map.containsKey(word.substring(0, i))) {
                    map.put(word.substring(0, i), new ArrayList<>());
                }
                map.get(word.substring(0, i)).add(word);;
            }
        }
        List<String> curTemp = new ArrayList<>();
        for (String word : words) {
            curTemp.add(word);
            backtracking(words, ans, curTemp, map, len);
            curTemp.remove(curTemp.size() - 1);
        }
        return ans;
    }
    private void backtracking(String[] words,
                              List<List<String>> ans,
                              List<String> curTemp,
                              Map<String, List<String>> map,
                              int len) {
        if (curTemp.size() == len) {
            ans.add(new ArrayList<>(curTemp));
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = curTemp.size();
        for (String s : curTemp) {
            sb.append(s.charAt(size));
        }
        List<String> starts = map.get(sb.toString());
        if (starts != null) {
            for (String next : starts) {
                curTemp.add(next);
                backtracking(words, ans, curTemp, map, len);
                curTemp.remove(curTemp.size() - 1);
            }
        }
    }
}