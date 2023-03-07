package com.ll.level0.p120839;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rsp.length(); i++) {

            char chr = rsp.charAt(i);

            switch(chr){
                case 48:
                    sb.append("5");
                    break;
                case 50:
                    sb.append("0");
                    break;
                case 53:
                    sb.append("2");
                    break;
            }
        }
        return String.valueOf(sb);
    }
}
