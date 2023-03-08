package com.ll.level0.p120893;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    //System.out.println(new Solution().solution();

public class Tests {
    @Test
    @DisplayName("cccCCC => CCCccc")
    void t1() {
        assertThat(new Solution().solution("cccCCC")).isEqualTo("CCCccc");
    }

    @Test
    @DisplayName("abCdEfghIJ => ABcDeFGHij")
    void t2() {
        assertThat(new Solution().solution("abCdEfghIJ")).isEqualTo("ABcDeFGHij");
    }
}
