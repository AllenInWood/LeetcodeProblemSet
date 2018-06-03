/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // iterative bfs
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) {
//             return true;
//         }
//         if (p == null || q == null) {
//             return false;
//         }
        
//         Queue<TreeNode> pQueue = new LinkedList<>();
//         pQueue.offer(p);
//         Queue<TreeNode> qQueue = new LinkedList<>();
//         qQueue.offer(q);
        
//         while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
//             TreeNode pCur = pQueue.poll();
//             TreeNode qCur = qQueue.poll();
//             if (pCur.val != qCur.val) {
//                 return false;
//             }
//             if (pCur.left != null && qCur.left != null) {
//                 pQueue.offer(pCur.left);
//                 qQueue.offer(qCur.left);
//             } else if (pCur.left != null || qCur.left != null) {
//                 return false;
//             }
//             if (pCur.right != null && qCur.right != null) {
//                 pQueue.offer(pCur.right);
//                 qQueue.offer(qCur.right);
//             } else if (pCur.right != null || qCur.right != null) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
    
    // dfs
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return dfs(p, q);
    }
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p.val != q.val) {
            return false;
        }
        if (p.left != null && q.left != null) {
            if (!dfs(p.left, q.left)) {
                return false;
            }
        } else if (p.left != null || q.left != null) {
            return false;
        }
        if (p.right != null && q.right != null) {
            if (!dfs(p.right, q.right)) {
                return false;
            }
        } else if (p.right != null || q.right != null) {
            return false;
        }
        return true;
    }
}