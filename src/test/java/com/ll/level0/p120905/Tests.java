package com.ll.level0.p120905;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    //System.out.println(new Solution().solution();

public class Tests {
    @Test
    @DisplayName("3, [4, 5, 6, 7, 8, 9, 10, 11, 12] => [6, 9, 12]")
    void t1() {
        assertThat(new Solution().solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})).isEqualTo(new int[]{6, 9, 12});
    }

    @Test
    @DisplayName("5, [1, 9, 3, 10, 13, 5] => [10, 5]")
    void t2() {
        assertThat(new Solution().solution(5, new int[]{1, 9, 3, 10, 13, 5})).isEqualTo(new int[]{10, 5});
    }

    @Test
    @DisplayName("12, [2, 100, 120, 600, 12, 12] => [120, 600, 12, 12]")
    void t3() {
        assertThat(new Solution().solution(12, new int[]{2, 100, 120, 600, 12, 12})).isEqualTo(new int[]{120, 600, 12, 12});
    }
}
