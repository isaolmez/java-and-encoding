package com.isa.java.encoding.utf8;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.junit.Test;

public class EncodingTest {

    private static final String ISO_8859_1_TURKISH = "ISO-8859-9";

    @Test
    public void shouldGetDefaultEncoding() throws IOException {
        String fileName = Thread.currentThread().getContextClassLoader().getResource("output.txt").getPath();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
        String encoding = reader.getEncoding();

        assertThat(encoding).isEqualTo("UTF8");
    }

    @Test
    public void shouldGetBytes1() throws UnsupportedEncodingException {
        String turkish = "a";

        System.out.println(Arrays.toString(turkish.getBytes()));
        System.out.println(Arrays.toString(turkish.getBytes(UTF_8)));
        System.out.println(Arrays.toString(turkish.getBytes(ISO_8859_1)));

        assertThat(turkish.getBytes()).containsExactly(97);
        assertThat(turkish.getBytes(UTF_8)).containsExactly(97);
        assertThat(turkish.getBytes(ISO_8859_1)).containsExactly(97);
    }

    @Test
    public void shouldGetBytes2() throws UnsupportedEncodingException {
        String turkish = "ş";

        System.out.println(Arrays.toString(turkish.getBytes()));
        System.out.println(Arrays.toString(turkish.getBytes(UTF_8)));
        System.out.println(Arrays.toString(turkish.getBytes(ISO_8859_1)));

        assertThat(turkish.getBytes()).containsExactly(-59, -97);
        assertThat(turkish.getBytes(UTF_8)).containsExactly(-59, -97);
        assertThat(turkish.getBytes(ISO_8859_1)).containsExactly(63);
    }

    @Test
    public void shouldGetBytes3() throws UnsupportedEncodingException {
        String turkish = "ç";

        System.out.println(Arrays.toString(turkish.getBytes()));
        System.out.println(Arrays.toString(turkish.getBytes(UTF_8)));
        System.out.println(Arrays.toString(turkish.getBytes(ISO_8859_1)));

        assertThat(turkish.getBytes()).containsExactly(-61, -89);
        assertThat(turkish.getBytes(UTF_8)).containsExactly(-61, -89);
        assertThat(turkish.getBytes(ISO_8859_1)).containsExactly(-25);
    }

    @Test
    public void shouldGetBytes4() throws UnsupportedEncodingException {
        String turkish = "çş";

        System.out.println(Arrays.toString(turkish.getBytes()));
        System.out.println(Arrays.toString(turkish.getBytes(UTF_8)));
        System.out.println(Arrays.toString(turkish.getBytes(ISO_8859_1)));

        assertThat(turkish.getBytes()).containsExactly(-61, -89, -59, -97);
        assertThat(turkish.getBytes(UTF_8)).containsExactly(-61, -89, -59, -97);
        assertThat(turkish.getBytes(ISO_8859_1)).containsExactly(-25, 63);
    }

    @Test
    public void shouldGetBytes5() throws UnsupportedEncodingException {
        String latin = "Ã§Å\u009F";

        System.out.println((char) latin.codePointAt(0));
        System.out.println(Arrays.toString(latin.getBytes()));
        System.out.println(Arrays.toString(latin.getBytes(UTF_8)));
        System.out.println(Arrays.toString(latin.getBytes(ISO_8859_1)));
        System.out.println(new String(latin.getBytes(ISO_8859_1), ISO_8859_1));
        System.out.println(new String(latin.getBytes(ISO_8859_1), UTF_8));
    }

    @Test
    public void shouldReadEnglish1() throws IOException {
        String turkish = "a";

        String actual = new String(turkish.getBytes(), ISO_8859_1);
        System.out.println(actual);

        assertThat(actual).isEqualTo("a");
    }

    @Test
    public void shouldReadEnglish2() throws IOException {
        String turkish = "a";

        String actual = new String(turkish.getBytes(UTF_8), ISO_8859_1);
        System.out.println(actual);

        assertThat(actual).isEqualTo("a");
    }

    @Test
    public void shouldReadNonEnglish1() throws IOException {
        String turkish = "şç";

        String actual = new String(turkish.getBytes(), ISO_8859_1);
        System.out.println(actual);

        assertThat(actual).isEqualTo("Å\u009FÃ§");
    }

    @Test
    public void shouldReadNonEnglish2() throws IOException {
        String turkish = "şç";

        String actual = new String(turkish.getBytes(UTF_8), ISO_8859_1);
        System.out.println(actual);

        assertThat(actual).isEqualTo("Å\u009FÃ§");
    }

    @Test
    public void shouldReadNonEnglish3() throws IOException {
        String turkish = "şç";

        String actual = new String(turkish.getBytes(ISO_8859_1), ISO_8859_1);

        System.out.println(actual);
        System.out.println(Arrays.toString(actual.getBytes(ISO_8859_1)));

        assertThat(actual).isEqualTo("?ç");
    }

    @Test
    public void shouldReadNonEnglish4() throws IOException {
        String turkish = "şç";

        String actual = new String(turkish.getBytes(ISO_8859_1), UTF_8);

        System.out.println(actual);
        System.out.println(Arrays.toString(actual.getBytes(UTF_8)));

        assertThat(actual).isEqualTo("?�");
    }


    @Test
    public void shouldReadTurkish() throws IOException {
        String turkish = "şç";

        String actual = new String(turkish.getBytes(ISO_8859_1_TURKISH), ISO_8859_1_TURKISH);

        System.out.println(actual);
        System.out.println(Arrays.toString(actual.getBytes(ISO_8859_1_TURKISH)));

        assertThat(actual).isEqualTo("şç");
    }

    @Test
    public void shouldEncode() throws IOException {
        String turkish = "Ã§Å\u009F";

        String actual = new String(turkish.getBytes(ISO_8859_1), UTF_8);

        System.out.println(actual);
    }
}
