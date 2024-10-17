package 九月.day2024_9_7.test414.Q1;

public class Q1 {
    public static String convertDateToBinary(String date) {
        String s1=date.substring(0,4);
        String S1=Integer.toBinaryString(Integer.parseInt(s1));
        String s2=date.substring(5,7);
        String S2=Integer.toBinaryString(Integer.parseInt(s2));
        String s3=date.substring(8);
        String S3=Integer.toBinaryString(Integer.parseInt(s3));
        return S1+"-"+S2+"-"+S3;
    }

    public static void main(String[] args) {
        String s="1900-01-01";
        System.out.println(convertDateToBinary(s));
    }
}
