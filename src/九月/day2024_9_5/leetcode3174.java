package 九月.day2024_9_5;

public class leetcode3174 {
    public static String clearDigits(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                String s1="";
                String s2="";
                if(i-1>=0){
                    s1=s.substring(0,i-1);
                }
                if(i+1<=s.length()-1){
                    s2=s.substring(i+1);
                }
                s=s1+s2;
                i-=2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s="cb34";
        String s2=clearDigits(s);
        System.out.println(s2);
    }
}
