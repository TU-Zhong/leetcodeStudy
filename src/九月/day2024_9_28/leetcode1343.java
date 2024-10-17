package 九月.day2024_9_28;

public class leetcode1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int left=0;
        int sum=0;
        int ans=0;
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            int len=right-left+1;
            if(len==k+1){
                sum-=arr[left++];
                len--;
            }
            if( len==k && sum/len>=threshold){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={11,13,17,23,29,31,7,5,2,3};
        int k=3;
        int rh=5;
        int ans=numOfSubarrays(arr,k,rh);
        System.out.println(ans);
    }
}
