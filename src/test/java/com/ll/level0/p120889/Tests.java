package com.ll.level0.p120889;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    //System.out.println(new Solution().solution();

public class Tests {
    @Test
    @DisplayName("1, 2, 3 => 2")
    void t1() {
        assertThat(new Solution().solution(new int[]{1, 2, 3})).isEqualTo(2);
    }

    @Test
    @DisplayName("3, 6, 2 => 2")
    void t2() {
        assertThat(new Solution().solution(new int[]{3, 6, 2})).isEqualTo(2);
    }

    @Test
    @DisplayName("199, 72, 222 => 1")
    void t3() {
        assertThat(new Solution().solution(new int[]{199, 72, 222})).isEqualTo(1);
    }
}
