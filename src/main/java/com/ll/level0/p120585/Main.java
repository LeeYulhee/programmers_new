package com.ll.level0.p120585;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;

        for(int i = 0; i < array.length; i ++){
            if(array[i] > height){
                answer += 1;
            }
        }

        return answer;
    }
}