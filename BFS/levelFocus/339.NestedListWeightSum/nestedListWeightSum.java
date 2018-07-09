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
    // public int depthSum(List<NestedInteger> nestedList) {
    //     if (nestedList == null || nestedList.size() == 0) {
    //         return 0;
    //     }
    //     int res = 0;
    //     Queue<NestedInteger> queue = new LinkedList<>();
    //     for (NestedInteger element : nestedList) {
    //         if (element.isInteger()) {
    //             res += element.getInteger();
    //         } else {
    //             queue.offer(element);
    //             int weight = 1;
    //             while (!queue.isEmpty()) {
    //                 int size = queue.size();
    //                 while (size-- > 0) {
    //                     NestedInteger cur = queue.poll();
    //                     if (cur.isInteger()) {
    //                         res += weight * cur.getInteger();
    //                     } else {
    //                         for (NestedInteger temp : cur.getList()) {
    //                             queue.offer(temp);
    //                         }
    //                     }
    //                 }
    //                 weight++;
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int res = 0;
        int weight = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    res += weight * cur.getInteger();
                } else {
                    for (NestedInteger next : cur.getList()) {
                        queue.offer(next);
                    }
                }
            }
            weight++;
        }
        return res;
    }
}