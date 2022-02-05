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
        final PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }
        
        ListNode newRoot = new ListNode(0);
        ListNode cur = newRoot;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) pq.offer(node.next);
        }
        return newRoot.next;
    }
}