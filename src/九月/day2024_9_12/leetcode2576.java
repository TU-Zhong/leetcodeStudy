package 九月.day2024_9_12;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode2576 {
    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int ans=0;
        HashSet<Integer> map=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int pos=find(nums,2*nums[i],left);
            if(!map.contains(i)&&!map.contains(pos) && pos!=-1){
                map.add(i);
                map.add(pos);
                ans++;
            }
            left=pos+1;
            if(left>=nums.length){
                break;
            }
        }
        return ans*2;
    }
    public static int find(int[] nums,int target,int start){
        int left=start,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                if(mid==0||nums[mid-1]<=target){
                    return mid;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,9 };
        int ans=maxNumOfMarkedIndices(nums);
        System.out.println(ans);
    }
}
