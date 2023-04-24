package com.ll.level0.p120850;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            answer[i] = str.charAt(i)-'0';
        }

        Arrays.sort(answer);
        return answer;
    }
}