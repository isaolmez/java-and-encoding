package com.isa.java.encoding.utf8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Test;

public class CodePointUtilsTest {

    @Test
    public void shouldCreateNewString_InBMP_1() {
        String actual = CodePointUtils.newString(65);

        assertThat(actual).isEqualTo("A");
        assertThat(actual.codePointCount(0, actual.length())).isEqualTo(1); // Code point count
        assertThat(actual.length()).isEqualTo(1); // Char count
        assertThat(actual.getBytes().length).isEqualTo(1); // Byte count
    }

    @Test
    public void shouldCreateNewString_InBMP_2() {
        String actual = CodePointUtils.newString(231);

        assertThat(actual).isEqualTo("ç");
        assertThat(actual.codePointCount(0, actual.length())).isEqualTo(1);
        assertThat(actual.length()).isEqualTo(1);
        assertThat(actual.getBytes().length).isEqualTo(2);
    }

    @Test
    public void shouldCreateNewString_FromSupplementary() {
        String actual = CodePointUtils.newString(0x10400);

        System.out.println(actual.length());
        assertThat(actual.codePointCount(0, actual.length())).isEqualTo(1);
        assertThat(actual.length()).isEqualTo(2);
        assertThat(actual.getBytes().length).isEqualTo(4);
    }

    @Test
    public void shouldCreateNewString_FromLowerLimit() {
        CodePointUtils.newString(0x0000);
    }

    @Test
    public void shouldCreateNewString_FromUpperLimit() {
        CodePointUtils.newString(0x10FFFF);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateNewString_IfCodePointIsNotValid() {
        CodePointUtils.newString(0x10FFFF + 0x1);

        fail("Should have failed");
    }

    @Test
    public void shouldCreateNewStrings() {
        int[] codePoints = new int[]{65, 66, 231};

        String[] actualStrings = CodePointUtils.newStrings(codePoints);

        assertThat(actualStrings.length).isEqualTo(3);
        assertThat(actualStrings[0]).isEqualTo("A");
        assertThat(actualStrings[1]).isEqualTo("B");
        assertThat(actualStrings[2]).isEqualTo("ç");
    }

}
