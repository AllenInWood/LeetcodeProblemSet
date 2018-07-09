/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    // public int depthSumInverse(List<NestedInteger> nestedList) {
    //     if (nestedList == null || nestedList.size() == 0) {
    //         return 0;
    //     }
    //     int maxDepth = dfs(nestedList);
    //     return getSum(nestedList, maxDepth);
    // }
    // private int getSum(List<NestedInteger> nestedList, int depth) {
    //     int sum = 0;
    //     if (nestedList == null || nestedList.size() == 0) {
    //         return sum;
    //     }
    //     for (NestedInteger nestedInteger : nestedList) {
    //         if (nestedInteger.isInteger()) {
    //             sum += depth * nestedInteger.getInteger();
    //         } else {
    //             sum += getSum(nestedInteger.getList(), depth - 1);
    //         }
    //     }
    //     return sum;
    // }
    // private int dfs(List<NestedInteger> nestedList) {
    //     if (nestedList == null || nestedList.size() == 0) {
    //         return 0;
    //     }
    //     int max = 0;
    //     for (NestedInteger nestedInteger : nestedList) {
    //         if (nestedInteger.isInteger()) {
    //             max = Math.max(max, 1);
    //         } else {
    //             max = Math.max(max, dfs(nestedInteger.getList()) + 1);
    //         }
    //     }
    //     return max;
    // }
    
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int depth = bfs(nestedList);
        int sum = bfsSum(nestedList, depth);
        return sum;
    }
    private int bfsSum(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    res += depth * cur.getInteger();
                } else {
                    for (NestedInteger next : cur.getList()) {
                        queue.offer(next);
                    }
                }
            }
            depth--;
        }
        return res;
    }
    private int bfs(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (!cur.isInteger()) {
                    for (NestedInteger next : cur.getList()) {
                        queue.offer(next);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}