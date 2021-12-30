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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        
        ListNode psRoot = new ListNode(0);
        ListNode combHead = psRoot;
        while (!pq.isEmpty()) {
            ListNode nextSmallest = pq.poll();
            combHead.next = nextSmallest;
            combHead = nextSmallest;
            ListNode reentry = nextSmallest.next;
            nextSmallest.next = null;
            if (reentry != null) pq.add(reentry);
        }
        return psRoot.next;
    }
}