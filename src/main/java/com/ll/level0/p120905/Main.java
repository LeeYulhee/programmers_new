package com.ll.level0.p120905;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> intList = new ArrayList<>();

        for(int i : numlist){
            if(i % n == 0) {
                intList.add(i);
            }
        }
        int[] answer = intList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}