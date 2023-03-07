package com.ll.level0.p120839;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("2 => 0")
    void t1() {
        assertThat(new Solution().solution("2")).isEqualTo("0");
    }

    @Test
    @DisplayName("205 => 052")
    void t2() {
        assertThat(new Solution().solution("205")).isEqualTo("052");
    }
}
