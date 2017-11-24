package com.isa.java.encoding.utf8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import org.junit.Test;

public class CharacterTest {

    @Test
    public void shouldDetectLetter() {
        boolean actual = Character.isLetter('a');

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldDetectLetter2() {
        boolean actual = Character.isLetter('A');

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldDetectLetter3() {
        boolean actual = Character.isLetter('ö');

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldDetectLetter4() {
        boolean actual = Character.isLetter('Ö');

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldDetectType() {
        int type = Character.getType('o');

        assertThat(type).isEqualTo(Character.LOWERCASE_LETTER);
    }

    @Test
    public void shouldDetectType2() {
        int type = Character.getType('O');

        assertThat(type).isEqualTo(Character.UPPERCASE_LETTER);
    }

    @Test
    public void shouldDetectType3() {
        int type = Character.getType('1');

        assertThat(type).isEqualTo(Character.DECIMAL_DIGIT_NUMBER);
    }

    @Test
    public void shouldDetectType4() {
        int type = Character.getType('.');

        assertThat(type).isEqualTo(Character.OTHER_PUNCTUATION);
    }

    @Test
    public void shouldLowercase() {
        String actual = "I".toLowerCase();

        assertThat(actual).isEqualTo("i");
    }

    @Test
    public void shouldLowercaseWithLocale() {
        String actual = "I".toLowerCase(Locale.forLanguageTag("tr"));

        assertThat(actual).isEqualTo("ı");
    }

    @Test
    public void shouldValidateCodePoint() {
        boolean actual = Character.isValidCodePoint(0x0000);

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldValidateCodePoint1() {
        boolean actual = Character.isValidCodePoint(0x1000);

        assertThat(actual).isTrue();
    }

    @Test
    public void shouldValidateCodePoint2() {
        boolean actual = Character.isValidCodePoint(0x10FFFF);

        assertThat(actual).isTrue();
    }
}
