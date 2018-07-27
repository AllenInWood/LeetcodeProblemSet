class Solution {
    class Node {
        boolean isWord;
        Node[] children;
        public Node() {
            children = new Node[26];
        }
        public boolean isAbbr(String abbr, int num) {
            if (num > 0) {
                for (Node child : children) {
                    if (child != null && child.isAbbr(abbr, num - 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (abbr.length() == 0) return isWord;
                int idx = 0;
                while (idx < abbr.length() && abbr.charAt(idx) >= '0' && abbr.charAt(idx) <= '9' ) {
                    num = (num * 10) + (abbr.charAt(idx++) - '0'); 
                }
                if (num > 0)  {
                    return isAbbr(abbr.substring(idx),num);
                } else {
                    if (children[abbr.charAt(0) - 'a'] != null )   
                        return children[abbr.charAt(0) - 'a'].isAbbr(abbr.substring(1), 0);
                    else return false;
                }
            }
        }
    }
    public String minAbbreviation(String target, String[] dictionary) {
        List<String> dict = new ArrayList<>();
        int len = target.length();
        for (String str : dictionary) {
            if (str.length() == len) {
                dict.add(str);
            }
        }
        if (dict.isEmpty()) {
            return "" + len;
        }
        
        Node root = buildTrie(dict);
        char[] chars = target.toCharArray();
        String res = null;
        
        int min = 1, max = len;
        while (max >= min) {
            int mid = min + (max - min) / 2;
            List<String> abbs = new ArrayList();
            getAbbs(abbs, chars, 0, mid, new StringBuilder());
            boolean conflict = true;
            for (String abbr: abbs) {
                 if (!root.isAbbr(abbr, 0)) {
                    conflict = false;
                    res = abbr;
                    break;
                }
            }
            if (conflict) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }
    
    private Node buildTrie(List<String> dict) {
        Node root = new Node();
        for (String word : dict) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new Node();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }
    
    private void getAbbs(List<String> abbs, char[] chars, int index, int len, StringBuilder sb) {
        boolean preNum = (sb.length() > 0) && (sb.charAt(sb.length() - 1) >= '0') && (sb.charAt(sb.length() - 1) <= '9');
        if (len == 1)  {
            if (index < chars.length) {
                if (index == chars.length - 1) abbs.add(sb.toString() + chars[index]); // add one char
                if (!preNum) abbs.add(sb.toString() + (chars.length - index) ); // add a number
            }
        }
        int last = sb.length();
        for (int i = index + 1; i < chars.length; i++) {
            if (!preNum) {
                sb.append(i - index);
                getAbbs(abbs, chars, i, len - 1, sb);
                sb.delete(last, sb.length());
            }
            if (i == index + 1) {
                sb.append(chars[index]);
                getAbbs(abbs, chars, i, len - 1, sb);
                sb.delete(last, sb.length());
            }
        }
    }
}