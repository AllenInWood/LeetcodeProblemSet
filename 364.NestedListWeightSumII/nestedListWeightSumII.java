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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        int prev = 0;
        int total = 0;
        for (NestedInteger next : nestedList) {
            queue.offer(next);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    levelSum += cur.getInteger();
                } else {
                    List<NestedInteger> nextNestedList = cur.getList();
                    for (NestedInteger n : nextNestedList) {
                        queue.offer(n);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}