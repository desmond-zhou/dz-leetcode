/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        for (ListNode cA = headA; cA != null; cA = cA.next) {
            countA++;
        }
        
        int countB = 0;
        for (ListNode cB = headB; cB != null; cB = cB.next) {
            countB++;
        }
        
        ListNode mover = (countA > countB) ? headA : headB;
        ListNode fixer = (countA <= countB) ? headA : headB;
        int diff = Math.abs(countA - countB);
        
        for (int i = 0; i < diff; i++) {
            mover = mover.next;
        }
        
        while(mover != null && fixer != null) {
            if (mover == fixer) return mover;
            mover = mover.next;
            fixer = fixer.next;
        }
        return null;
    }
}