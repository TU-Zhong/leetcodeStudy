package 九月.day2024_9_5;

import java.util.HashMap;

public class leetcode2606 {
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<chars.length();i++){
            map.put(chars.charAt(i),vals[i]);
        }
        int ans=maximumCostSubstringhelper(map,s);
        return ans>0?ans:0;
    }
    public static int maximumCostSubstringhelper(HashMap<Character,Integer> map,String s){
        int[] nums=new int[s.length()];
        for(int i=0;i<nums.length;i++){
            nums[i]=map.containsKey(s.charAt(i))?map.get(s.charAt(i)):s.charAt(i)-'a'+1;
        }
        int currentMax=nums[0];
        int globalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(nums[i],currentMax+nums[i]);
            globalMax=Math.max(globalMax,currentMax);
        }
        return globalMax;
    }
}
