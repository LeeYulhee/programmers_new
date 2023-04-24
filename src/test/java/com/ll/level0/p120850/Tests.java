package com.ll.level0.p120850;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Tests {
    @Test
    @DisplayName("hi12392 => [1, 2, 2, 3, 9]")
    void t1() {
        assertThat(new Solution().solution("hi12392")).isEqualTo(new int[]{1, 2, 2, 3, 9});
    }

    @Test
    @DisplayName("p2o4i8gj2 => [2, 2, 4, 8]")
    void t2() {
        assertThat(new Solution().solution("p2o4i8gj2")).isEqualTo(new int[]{2, 2, 4, 8});
    }

    @Test
    @DisplayName("abcde0 => 0")
    void t3() {
        assertThat(new Solution().solution("abcde0")).isEqualTo(new int[]{0});
    }
}
