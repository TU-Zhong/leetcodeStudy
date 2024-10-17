package 九月.day2024_9_18;

import java.util.*;

public class leetcode2332 {
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Queue<Integer> bus=new PriorityQueue<>();
        Queue<Integer> passenger=new PriorityQueue<>();
        for(int c:buses){
            bus.add(c);
        }
        for(int c:passengers){
            passenger.add(c);
        }
        int ans=0;
        Stack<Integer> perbus=new Stack<>();
        for(int i=0;i<buses.length;i++){
            int cap=0;
            //还没坐满，并且乘客到达时间要小于公交车出发时间
            while(cap<capacity && !passenger.isEmpty() && passenger.peek()<=buses[i]){
                //记录是哪些乘客坐上了车
                perbus.add(passenger.poll());
                cap++;
            }
            if(i==buses.length-1){
                if(perbus.isEmpty()){
                    ans=buses[buses.length-1];
                    break;
                }
                if(!perbus.isEmpty()&&perbus.peek()<buses[buses.length-1]&&cap<capacity){
                    ans=buses[buses.length-1];
                    break;
                }
                while(!perbus.isEmpty()){
                    //拿到最后一个上车的人的到达时间
                    int a=perbus.pop();
                    //他前一个人的到达时间（可能最后一个就是第一个，所以要进行判断）
                    int b=-1;
                    if(!perbus.isEmpty()){
                        b=perbus.peek();
                    }
                    if(a-1!=b){
                        ans=a-1;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] buses={3};
        int[] passengers={4};
        int capacity=1;
        int ans=latestTimeCatchTheBus(buses,passengers,capacity);
        System.out.println(ans);
    }
}
