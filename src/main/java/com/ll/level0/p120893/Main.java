package com.ll.level0.p120893;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string) {

        StringBuilder sb= new StringBuilder();

        for(int i = 0; i < my_string.length(); i++){
            int a = my_string.charAt(i);
            if(a >= 65 && a <= 90) {
                sb.append((char) (a + 32));
            } else if (a >= 97 && a <= 122) {
                sb.append((char) (a - 32));
            }
        }
        return String.valueOf(sb);
    }
}