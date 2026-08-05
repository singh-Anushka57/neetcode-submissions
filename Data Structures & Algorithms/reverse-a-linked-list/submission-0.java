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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode x=head.next;
        ListNode y=x.next;
        ListNode z=head;
       while(y!=null){
        x.next=z;
        z=x;
        x=y;
        y=y.next;
       }
       x.next=z;
       head.next=null;
       return x;
    }
}
