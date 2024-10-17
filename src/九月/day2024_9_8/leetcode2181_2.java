package 九月.day2024_9_8;

public class leetcode2181_2 {
    public static ListNode generate(int[] nums){
        ListNode H=new ListNode();
        ListNode head=new ListNode();
        H=head;
        for(int i=0;i<nums.length;i++){
            ListNode node =new ListNode();
            node.val=nums[i];
            head.next=node;
            head=node;
        }
        return H.next;
    }
    public static ListNode mergeNodes(ListNode head) {
        ListNode cur=head.next;
        ListNode tail=head;
        while(cur.next!=null){
            if(cur.val!=0){
                tail.val+=cur.val;
            }else{
                tail=tail.next;
                tail.val=0;
            }
            cur=cur.next;
        }
        tail.next=null;
        return head;
    }

    public static void main(String[] args) {
        int[] nums={0,3,0};
        ListNode head=generate(nums);
//        while(head!=null){
//            System.out.printf(head.val+" ");
//            head=head.next;
//        }
        ListNode cur=mergeNodes(head);
        while(cur!=null){
            System.out.printf(cur.val+" ");
            cur=cur.next;
        }
    }
}
