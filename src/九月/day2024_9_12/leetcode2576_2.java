package 九月.day2024_9_12;
import java.util.Arrays;

public class leetcode2576_2 {
    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length / 2 + 1; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left * 2; // 最多匹配 left 对，有 left * 2 个数
    }

    private static boolean check(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[nums.length - k + i]) {
                return false;
            }
        }
        return true;
    }
    public static int[] generate(int size,int num){
        int[] nums=new int[(int)(Math.random()*size)+1];
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)(Math.random()*num)+1;
        }
        return nums;
    }

    public static void main(String[] args) {
        int size=5;
        int num=10;
        int testtimes=100000;
        for(int i=0;i<testtimes;i++){
            int[] nums=generate(size,num);
            int ans=maxNumOfMarkedIndices(nums);
            int ans2=leetcode2576_3.maxNumOfMarkedIndices(nums);
            if(ans!=ans2){
                System.out.println("wrong answer!");
                for(int c:nums){
                    System.out.printf(c+" ");
                }
                System.out.println();
                System.out.println(ans+" , "+ans2);
                break;
            }
        }
    }
}
