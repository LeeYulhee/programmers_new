package com.ll.level0.p120889;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new Solution().solution();
    }
}

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        if(sides[2] < sides[0] + sides[1]){
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}
