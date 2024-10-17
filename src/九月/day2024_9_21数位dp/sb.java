package 九月.day2024_9_21数位dp;

import java.util.Scanner;

public class sb {
    public static String f(String s){
        char[] s1=s.toCharArray();
        int p1=0;
        int p2=s.length()-1;
        while(p1<=p2){
            char a=s1[p1];
            s1[p1]=s1[p2];
            s1[p2]=a;
            p1++;
            p2--;
        }
        return new String(s1);
    }

    public static void main(String[] args) {
        String s=new Scanner(System.in).nextLine();
        String res=f(s);
        System.out.println(res);
    }
}
