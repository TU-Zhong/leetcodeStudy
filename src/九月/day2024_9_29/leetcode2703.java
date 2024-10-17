package 九月.day2024_9_29;

public class leetcode2703 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int sum=0;
        for(int i=0;i<=tickets.length;i++){
            if(tickets[i]>0){
                tickets[i]--;
                sum++;
            }
            if(i==k&& tickets[i]==0){
                break;
            }
            if(i==tickets.length-1){
                i=-1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] tickets={5,1,1,1};
        int k=0;
        int ans=timeRequiredToBuy(tickets,k);
        System.out.println(ans);
    }
}
