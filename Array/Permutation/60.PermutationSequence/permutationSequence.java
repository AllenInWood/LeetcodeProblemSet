class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
            System.out.println(factor[i]);
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factor[i - 1];
            k = k % factor[i - 1];
            sb.append(ans.get(index));
            ans.remove(index);
        }
        return sb.toString();
    }
}