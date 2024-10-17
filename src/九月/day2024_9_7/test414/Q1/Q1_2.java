package 九月.day2024_9_7.test414.Q1;

import java.util.ArrayList;
import java.util.List;

public class Q1_2 {
    public static long findMaximumScore(List<Integer> nums){
        long ans=0;
        int max=nums.get(0);
        for(int i=1;i<nums.size();i++){
            //开始的位置不算到结果里
            //到当前的位置，要加的显然是之前的那个开头（从哪个位置起跳，那个位置的值），然后更新每次加的值
            //（如果当前的这个值要大于之前起跳的那个值，那么就更新为当前的这个值。）
            ans+=max;
            max=Math.max(max,nums.get(i));

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,1,5};
        List<Integer> nums2=new ArrayList<>();
        for(int c:nums){
            nums2.add(c);
        }
        long ans=findMaximumScore(nums2);
        System.out.println(ans);
    }
}
