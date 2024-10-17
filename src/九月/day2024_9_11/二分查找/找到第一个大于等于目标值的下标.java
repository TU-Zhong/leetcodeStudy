package 九月.day2024_9_11.二分查找;

public class 找到第一个大于等于目标值的下标 {
    public static int find(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                if(mid==0||nums[mid-1]<target){
                    return mid;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2,2,6,6,6,6,6};
        int index=find(nums,3);
        System.out.println(index);
    }
}
