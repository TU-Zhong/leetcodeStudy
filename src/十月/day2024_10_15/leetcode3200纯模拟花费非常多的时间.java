package 十月.day2024_10_15;

public class leetcode3200纯模拟花费非常多的时间 {
    public static int maxHeightOfTriangle(int red, int blue) {
        int n=0;
        if(red>=blue){
            n=red;
            red=blue;
            blue=n;
        }
        int index=a(red,blue);
        int index2=a(blue,red);
        return Math.max(index,index2);
    }
    public static int a(int red,int blue){
        int index=1;
        while(red>0 && blue>0){
            if(index%2==1){
                red-=index;
                if(blue>=index+1){
                    index++;
                }else{
                    break;
                }
            }else if(index%2==0){
                blue-=index;
                if(red>=index+1){
                    index++;
                }else{
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int red=9;
        int blue=3;
        System.out.println(maxHeightOfTriangle(red,blue));
    }
}
