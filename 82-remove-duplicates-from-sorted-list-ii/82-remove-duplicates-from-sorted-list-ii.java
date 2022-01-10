class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) head = head.next;    
                pred.next = head.next;
            } else {
                pred = pred.next;    
            }
            head = head.next;    
        }
        return sentinel.next;
    }
}