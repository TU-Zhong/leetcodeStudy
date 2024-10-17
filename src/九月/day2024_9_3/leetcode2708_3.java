package 九月.day2024_9_3;

public class leetcode2708_3 {
    public static long maxStrength(int[] nums) {
        return maxStrengthhelper(nums,0,1,1,false);
    }
    public static long maxStrengthhelper(int[] nums,int index,long Max,long Min,boolean haschosen){
        if(index==nums.length){
            return haschosen==true?Max:Integer.MIN_VALUE;
        }
        long nextMax=Math.max(nums[index],Math.max(nums[index]*Max,nums[index]*Min));
        long nextMin=Math.min(nums[index],Math.min(nums[index]*Max,nums[index]*Min));
        long includes=maxStrengthhelper(nums,index+1,nextMax,nextMin,true);
        long notincludes=maxStrengthhelper(nums,index+1,Max,Min,haschosen);
        return Math.max(includes,notincludes);
    }

    public static void main(String[] args) {
        int[] nums={-1};
        long ans=maxStrength(nums);
        System.out.println(ans);
    }
}
