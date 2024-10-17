package 九月.day2024_9_7;

public class leecode977_2 {
    public static int[] sortedSquares(int[] nums) {
        int p1=0;
        int p2=nums.length-1;
        int[] result=new int[nums.length];
        int index=nums.length-1;
        while(p1!=p2){
            int ans1=nums[p1]*nums[p1];
            int ans2=nums[p2]*nums[p2];
            if(ans1>=ans2){
                result[index--]=ans1;
                p1++;
            }else{
                result[index--]=ans2;
                p2--;
            }
        }
        result[index--]=nums[p1]*nums[p2];
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-7,-3,2,3,11};
        int[] ans=sortedSquares(nums);
        for(int c:ans){
            System.out.println(c);
        }
    }
}
