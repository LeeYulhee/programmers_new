package com.ll.level0.p120892;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public String solution(String cipher, int code) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= cipher.length()/code; i++) {
            sb.append(cipher.charAt((code*i)-1));
        }

        return String.valueOf(sb);
    }
}
