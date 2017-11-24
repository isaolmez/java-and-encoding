package com.isa.java.encoding.utf8;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.junit.Test;

public class UrlEncodingTest {

    @Test
    public void shouldUrlEncode() throws UnsupportedEncodingException {
        String turkish = "a";

        String actual = URLEncoder.encode(turkish, UTF_8.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("a");
    }

    @Test
    public void shouldUrlEncode2() throws UnsupportedEncodingException {
        String turkish = "ç";

        String actual = URLEncoder.encode(turkish, UTF_8.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("%C3%A7");
    }

    @Test
    public void shouldUrlEncode3() throws UnsupportedEncodingException {
        String turkish = "ş";

        String actual = URLEncoder.encode(turkish, UTF_8.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("%C5%9F");
    }

    @Test
    public void shouldUrlEncode4() throws UnsupportedEncodingException {
        String turkish = "a";

        String actual = URLEncoder.encode(turkish, ISO_8859_1.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("a");
    }

    @Test
    public void shouldUrlEncode5() throws UnsupportedEncodingException {
        String turkish = "ç";

        String actual = URLEncoder.encode(turkish, ISO_8859_1.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("%E7");
    }

    @Test
    public void shouldUrlEncode6() throws UnsupportedEncodingException {
        String turkish = "ş";

        String actual = URLEncoder.encode(turkish, ISO_8859_1.name());

        System.out.println(actual);
        assertThat(actual).isEqualTo("%3F");
    }

    @Test
    public void shouldUrlDecode() throws UnsupportedEncodingException {
        String decoded = URLDecoder.decode("%C3%A7%C5%9F%C3%B6%C3%BC", UTF_8.name());
        System.out.println(decoded);
    }
}
