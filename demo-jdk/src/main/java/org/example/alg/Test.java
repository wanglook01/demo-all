package org.example.alg;

public class Test {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            char ci = s.charAt(i);
            char cj = t.charAt(j);
            if(ci ==  cj){
                if(ci==s.length()-1){
                    return true;
                }
                i++;
                j++;
            }else{
                j++;
            }
        }
        return false;
    }
}
