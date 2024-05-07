// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * We could've solved this with a set of node reference but that would've taken O(n) space.
 * So, we have taken fast and slow pointers.
 * Fast pointer moves 2 steps at a time and slow pointer moves 1 step at a time.
 * If there is a cycle, the fast and slow pointers will meet at some point.
 * If there is no cycle, the fast pointer will reach null.
 * We can use this to find the start of the cycle. We can move the slow/fast pointer to the head
 * and move both pointers at the same speed (1x). The point where they meet is the start of the cycle.
 */


public class Problem3 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (!flag) return null;

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
