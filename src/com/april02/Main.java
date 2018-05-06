package com.april02;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            if (str.length()<=64 && str.matches("[0-9A-Za-z]+")){
                System.out.println(MaxSubString(str).length());
            }else{
                System.out.println("error");
            }
        }
    }
    public static boolean duichen(String str){
        char[] chr = str.toCharArray();
        int min = 0;
        int max = chr.length-1;
        while(min<max){
            if (chr[min++]!=chr[max--])
                return false;
        }
        return true;
    }
    public static String MaxSubString(String str){
        String sub = "";
        for (int i = str.length();i>=2;i--)
            for (int j = 0; j<i-1;j++){
                String temp = str.substring(j,i);
                int len = temp.length();
                if (duichen(temp) && sub.length()<len)
                    sub = temp;
            }
        return sub;
    }
}