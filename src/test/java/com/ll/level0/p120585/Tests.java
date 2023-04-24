package com.ll.level0.p120585;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    @DisplayName("[149, 180, 192, 170] 167 => 3")
    void t1() {
        assertThat(new com.ll.level0.p120585.Solution().solution(new int[]{149, 180, 192, 170}, 167)).isEqualTo(3);
    }

    @Test
    @DisplayName("[180, 120, 140] 190 => 0")
    void t2() {
        assertThat(new com.ll.level0.p120585.Solution().solution(new int[]{180, 120, 140}, 190)).isEqualTo(0);
    }

    @Test
    @DisplayName("[180, 120, 140, 170] 160 => 2")
    void t3() {
        assertThat(new com.ll.level0.p120585.Solution().solution(new int[]{180, 120, 140, 170}, 160)).isEqualTo(2);
    }

    @Test
    @DisplayName("[190, 153, 167, 158, 178, 199, 160, 132, 150] 165 => 4")
    void t4() {
        assertThat(new com.ll.level0.p120585.Solution().solution(new int[]{190, 153, 167, 158, 178, 199, 160, 132, 150}, 165)).isEqualTo(4);
    }
}
