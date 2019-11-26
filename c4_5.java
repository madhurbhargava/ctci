/** Validate BST
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        List<Integer> list = inOrder(root);
        boolean result = validateList(list);
        return result;
    }
    
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        
        
        if(root.left != null) {
            List<Integer> l1 = inOrder(root.left);
            list.addAll(l1);
            
        } 
        list.add(root.val);
        if(root.right != null) {
            List<Integer> l2 = inOrder(root.right);
            list.addAll(l2);
        } 
        
        return list;
    }
    
    boolean validateList(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            if(i+1 < list.size() && list.get(i+1) <= list.get(i)) {
                return false;
            }
        }
        
        return true;
    }
}
