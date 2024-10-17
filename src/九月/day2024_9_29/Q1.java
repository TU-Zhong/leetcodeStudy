package 九月.day2024_9_29;

public class Q1 {
    public static char kthCharacter(int k) {
        int[] nums=new int[k+5];
        nums[1]=0;
        int index=1;
        int p2=index;
        while(index<=k){
            for(int i=1;i<=p2;i++){
                if(index>k){
                    break;
                }
                nums[++index]=nums[i]+1;
            }
            p2=index;
        }
        int a=nums[k]%26;
        char ans='a';
        for(char i='a';'z'-i>=0;i++){
            if(i-'a'==a){
                ans= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int k=10;
        char ans=kthCharacter(k);
        System.out.println(ans);
    }
}
