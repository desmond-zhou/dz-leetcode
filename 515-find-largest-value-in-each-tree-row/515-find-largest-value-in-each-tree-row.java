class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        LinkedList<Pair<TreeNode, Integer>> traversal = new LinkedList<Pair<TreeNode, Integer>>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        int level = 0;
        int buffer = Integer.MIN_VALUE;
        traversal.add(new Pair<TreeNode, Integer>(root, level));

        while(!traversal.isEmpty()) {
            Pair<TreeNode, Integer> temp = traversal.remove();
            if (temp.getValue() != level) {
                result.add(buffer);
                level = temp.getValue();
                buffer = Integer.MIN_VALUE;
            }
            
            System.out.println(temp.getKey());
            if (temp.getKey().val > buffer) {
                buffer = temp.getKey().val;
            }
            
            if (temp.getKey().left != null) {
                traversal.add(new Pair<TreeNode, Integer>(temp.getKey().left, temp.getValue() + 1));
            }
            if (temp.getKey().right != null) {
                traversal.add(new Pair<TreeNode, Integer>(temp.getKey().right, temp.getValue() + 1));

            }
        }
        
        if (level != result.size() + 1) {
            result.add(buffer);
        }
        
        return result;
    }
}