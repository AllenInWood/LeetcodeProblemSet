class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs == null || needs.size() == 0) {
            return 0;
        }
        return dfs(special, price, needs, 0);
    }
    private int dfs(List<List<Integer>> special, List<Integer> price, List<Integer> needs, int begin) {
        int local = directPurchase(price, needs);
        for (int i = begin; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) - offer.get(j) < 0) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            if (temp != null) {
                local = Math.min(local, offer.get(offer.size() - 1) + dfs(special, price, temp, i));
            }
        }
        return local;
    }
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}