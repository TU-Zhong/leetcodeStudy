package 九月.day2024_9_28;

import java.util.HashMap;
import java.util.List;

public class leetcode2841几乎唯一子数组的最大值 {
    public static long maxSum(List<Integer> nums, int m, int k) {
        int left=0;
        //sum记录子数组的总和大小
        long sum=0;
        //cnt用来记录子数组中不同的数的数目
        int cnt=0;
        long ans=0;
        //用哈希表来记录子数组中每个数字出现了多少次
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<nums.size();right++){
            //当把新的right加入到子数组中时，更新sum和cnt,以及map
            int cur=nums.get(right);
            sum+=cur;
            if(!map.containsKey(cur)){
                cnt++;
            }
            map.put(cur,map.containsKey(cur)?map.get(cur)+1:1);
            //计算子数组长度，如果超出长度就减去left位置的数，更新sum,cnt,map,len
            int len=right-left+1;
            if(len==k+1){
                int pre=nums.get(left);
                if(map.get(pre)==1){
                    map.remove(pre);
                    cnt--;
                }else{
                    map.put(pre,map.get(pre)-1);
                }
                sum-=pre;
                len--;
                left++;
            }
            //如果cnt>=m然后数组长度达标，就可以对ans进行更新了
            if(cnt>=m&&len==k){
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
