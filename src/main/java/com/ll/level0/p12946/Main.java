package com.ll.level0.p12946;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(new Solution().solution(4))
                // main 함수로 실행 시, debug 모드로 세팅한 depth 부분 출력안 되는지 확인
        );
    }
}

class Solution {
    public static boolean isDebug = false;
    // isDebug로 debug가 false일 때는 depth부분 미출력(프로그래머스 제출할 때 depth 부분 불필요)

    public int[][] solution(int n) {
        return new Hanoi(1, 3, n).toArray();
    }
}

class Hanoi {
    private final List<int[]> paths = new ArrayList<>();
    // 경로가 몇 개나 생길지 모르니까 일단 List로 선언
    private int calculateCallCount = 0;
    // 재귀 함수 debug 모드로 실행할 때, 몇 번째 호출인지 보기 위해 만든 변수

    public Hanoi(int from, int to, int n) {
        calculate(from, to, n, 1); // 객체가 만들어지면서 처음으로 재귀가 실행되기 때문에 depth = 1
        // 생성자 안에 메서드는 객체가 생성될 때 바로 실행되는 초기화 메서드
        // Hanoi 클래스의 객체는 생성되면서 int 변수가 초기화 되고, calculate 메서드가 호출되어 N 값에 따라 paths 리스트에 경로 배열이 추가됨
    }

    private void calculate(int from, int to, int n, int depth) {
         /* 이 문제의 일반식
            from => empty, n-1개 이동
            from => to, 1개 이동
            empty => to, n-1개 이동
            from : 시작점, to : 목적지, empty : from과 to를 제외한 기둥 번호, n : 옮길 원판 개수
                재귀 함수의 상태는 곧 매개변수의 구성(from, to, n) */
        calculateCallCount++;
        // calculate 함수 실행 시 Count++
        String debugLineHead = "\t".repeat(depth - 1) + String.format("%03d : (%d) => (%d), %d개 옮기기", calculateCallCount, from, to, n);
        // 탭을 depth - 1 만큼 반복 + caculate 호출 횟수, from, to, n을 String debugLineHead에 대입

        if (Solution.isDebug) System.out.println(debugLineHead + " - 시작");
        // isDebug가 true면 debugLineHead와 시작 출력

        if (n == 1) { // 재귀 함수의 종료 조건, 종료 조건은 보통 점화식 앞에 옴
            addPath(from, to); // addPath로 from, to를 paths에 추가

            if (Solution.isDebug) System.out.println(debugLineHead + " - 끝(addPath)");
            // isDebug가 true면 debugLineHead와 끝(addPath : addPath가 실행된 시점) 출력 : 기록되어야 하는 경로는 결국 1개, 1개의 목적지로 이동하는 경로이기 때문

            return; // 함수 종료, 이게 실행되면 연쇄적으로 함수가 종료됨
        }

        int empty = 6 - from - to;

        //  점화식 시작
        calculate(from, empty, n - 1, depth + 1); // n-1개를 일단 치워 놓고
        calculate(from, to, 1, depth + 1); // 밑장을 to로 옮김
        calculate(empty, to, n - 1, depth + 1); // 치워놨던 n-1개를 to로 옮김
        // 점화식 끝

        if (Solution.isDebug) System.out.println(debugLineHead + " - 끝");
        // isDebug가 true면 debugLineHead와 끝 출력
    }

    private void addPath(int from, int to) {
        paths.add(new int[]{from, to});
    }

    public int[][] toArray() {
        // List<int[]> => int[][]
        return paths
                .stream()
                .toArray(int[][]::new);
    } // paths의 값들을 이차원 배열로 변경
}