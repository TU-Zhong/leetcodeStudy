package 九月.day2024_9_28;

public class leetcode1652拆炸弹 {
    public static int[] decrypt(int[] code, int k) {
        int[] res=new int[code.length];
        if(k==0){
            return res;
        }
        int[] helper=new int[code.length*2];
        for(int i=0;i<helper.length;i++){
            helper[i]=i>=code.length?code[i-code.length]:code[i];
        }
        int left=k<0?code.length+k:1;
        int sum=0;
        int index=0;
        for(int right=left;right<helper.length;right++){
            sum+=helper[right];
            int len=right-left+1;
            if(len==Math.abs(k)+1){
                sum-=helper[left++];
                len--;
            }
            if(len==Math.abs(k)){
                res[index++]=sum;
                if(index==code.length){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={5,7,1,4};
        int k=-3;
        int[] ans=decrypt(nums,k);
        for(int c:ans){
            System.out.printf(c+" ");
        }
    }
}
