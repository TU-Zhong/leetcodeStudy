package 九月.day2024_9_8;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode{
    int val;
    ListNode next;
}
public class leetcode2181 {
    public ListNode mergeNodes(ListNode head) {
        Queue<Integer> queue=new PriorityQueue<>();

        ListNode H=new ListNode();
        ListNode H1=H;
        H.next=head;
        while(head!=null){
            int sum=0;
            if(head.val==0){
                head=head.next;
                while(head!=null && head.val!=0){
                    sum+=head.val;
                    head=head.next;
                }
                ListNode node=new ListNode();
                node.val=sum;
                H.next=node;
                H=node;
                if(head.next==null){
                    break;
                }
            }
        }
        return H1.next;
    }
}
