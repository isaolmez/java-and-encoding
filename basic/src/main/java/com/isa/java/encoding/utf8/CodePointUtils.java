package com.isa.java.encoding.utf8;

import com.google.common.base.Preconditions;

public class CodePointUtils {

    public static String newString(int codePoint) {
        Preconditions.checkArgument(Character.isValidCodePoint(codePoint));

        return new String(Character.toChars(codePoint));
    }

    public static String newStringOptimized(int codePoint) {
        Preconditions.checkArgument(Character.isValidCodePoint(codePoint));

        if (Character.charCount(codePoint) == 1) {
            return String.valueOf(codePoint);
        } else {
            return new String(Character.toChars(codePoint));
        }
    }

    public static String[] newStrings(int[] codePoints) {
        String[] result = new String[codePoints.length];
        char[] codeUnits = new char[2];
        for (int i = 0; i < codePoints.length; i++) {
            int count = Character.toChars(codePoints[i], codeUnits, 0);
            result[i] = new String(codeUnits, 0, count);
        }

        return result;
    }
}
