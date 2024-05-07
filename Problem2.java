// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * Keep a distance of n between fast and slow pointers.
 * When fast reaches the end, slow will be one node before the node to be removed.
 * So, we can simply remove the node by changing the next pointer of slow.
 * Dummy node is used to keep a distance of n between fast and slow pointers.
 */

public class Problem2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int cnt = 0;
        while(cnt <= n) {
            fast = fast.next;
            cnt++;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;

        return dummy.next;
    }

}
