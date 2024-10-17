package 九月.day2024_9_3;
import java.util.HashMap;

public class leetcode2708_2 {
    public static long maxStrength(int[] nums) {
        HashMap<Long,Long> memo=new HashMap<>();
        return maxStrengthhelper(nums,0,1,0,memo);
    }
    public static long maxStrengthhelper(int[] nums,int index,long result,int haschosen,HashMap<Long,Long> memo){
        if(index==nums.length){
            return haschosen==1?result:Integer.MIN_VALUE;
        }
        long index1=(long) index <<10| result<<20  |haschosen;
        if(memo.containsKey(index1)){
            return memo.get(index1);
        }
        long include=maxStrengthhelper(nums,index+1,result*nums[index],1,memo);
        long notinclude=maxStrengthhelper(nums,index+1,result,haschosen,memo);
        memo.put(index1,Math.max(include,notinclude));
        return Math.max(include,notinclude);
    }
    public static void main(String[] args) {
        int[] nums={3,-1,-5,2,5,-9};
        long ans=maxStrength(nums);
        System.out.println(ans);
    }
}
