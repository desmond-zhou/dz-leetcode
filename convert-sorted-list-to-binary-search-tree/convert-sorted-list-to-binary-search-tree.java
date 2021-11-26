/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val, null, null);
        }
        ListNode newStart = split(head);
        TreeNode left = sortedListToBST(head);
        TreeNode right = null;
        if (newStart.next != null)
            right = sortedListToBST(newStart.next);
        TreeNode root = new TreeNode(newStart.val, left, right);
        return root;
    }
    
    public ListNode split(ListNode head) {
        int count = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            count++;
        }
        
        int half = count/2;
        int step = 1;
        cur = head;
        while (step < half) {
            cur = cur.next;
            step++;
        }
        
        ListNode newStart = cur.next;
        cur.next = null;
        
        return newStart;
    }
    
}