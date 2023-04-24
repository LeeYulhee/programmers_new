package com.ll.level0.p120909;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        double d = Math.sqrt(n);
        return d % 1 == 0 ? 1 : 2;
    }
}