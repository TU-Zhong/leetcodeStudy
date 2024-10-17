package 九月.day2024_9_11.leetcode1671;

public class leetcode673 {
    public static int findNumberOfLIS(int[] nums) {
        int maxlen=1;
        int maxcount=0;
        int[] maxLen=new int[nums.length];
        int[] maxCount=new int[nums.length];
        //0代表长度，1代表个数
        for(int i=0;i<nums.length;i++){
            int[] result=findNumberOfLIShelper(nums,i,maxLen,maxCount);
            if(result[0]>maxlen){
                maxlen=result[0];
                maxcount=result[1];
            }else if(result[0]==maxlen){
                maxcount+=result[1];
            }
        }
        return maxcount;
    }
    public static int[] findNumberOfLIShelper(int[] nums,int index,int[] Len,int[] Count){
        if(index>=nums.length){
            return new int[]{0,0};
        }
        if(Len[index]!=0){
            return new int[]{Len[index],Count[index]};
        }
        int maxLen=1;
        int maxCount=1;
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                int[] result=findNumberOfLIShelper(nums,i,Len,Count);
                if(result[0]+1>maxLen){
                    maxLen=result[0]+1;
                    maxCount=result[1];
                }else if(result[0]+1==maxLen){
                    maxCount+=result[1];
                }
            }
        }
        Len[index]=maxLen;
        Count[index]=maxCount;
        return new int[]{maxLen,maxCount};
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2,2};
        int ans=findNumberOfLIS(nums);
        System.out.println(ans);
    }
}
