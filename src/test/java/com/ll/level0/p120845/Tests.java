package com.ll.level0.p120845;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("[1, 1, 1], 1 => 1")
    void t1() {
        assertThat(new Solution().solution(new int[]{1, 1, 1}, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("[10, 8, 6], 3 => 12")
    void t2() {
        assertThat(new Solution().solution(new int[]{10, 8, 6}, 3)).isEqualTo(12);
    }
}
