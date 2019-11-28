/* Create a Master list of lists, in which each individual list contains nodes at each level(Level order traversal).
// Definition for a Node.
class Node {
    public int val;
    Node left;
    Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        list = levelOrderR(queue);
        return list;
    }
    
    
    public List<List<Integer>> levelOrderR(Queue<Node> queue) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(queue == null || queue.size() == 0) {
            return list;
        }
        
        List<Integer> l1 = new ArrayList<Integer>();
        Queue<Node> sc = new LinkedList();
        while(queue.size() != 0) {
            Node node = queue.remove();
            l1.add(node.val);
            if(node.left != null) {
                sc.add(node.left);
            }
            if(node.right != null) {
                sc.add(node.right);
            }
        }
        
        list = levelOrderR(sc);
        list.add(0, l1);

        return list;
    }
}
