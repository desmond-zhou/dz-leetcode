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
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        
        int numComp = 0;
        ListNode cur = head;
        boolean active = false;
        while (cur != null) {
            if (!numSet.contains(cur.val) && active) {
                active = false;
            } else if (numSet.contains(cur.val) && !active) {
                numComp++;
                active = true;
            }
            cur = cur.next; 
        }
        
        return numComp;
    }
}