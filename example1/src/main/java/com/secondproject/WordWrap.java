package com.secondproject;

public class WordWrap {

    // Takes the input String as parameter and wraps it in lines. Line length
    // depends on the maxLineLength parameter (characters in each line before new line).
    public static String wrap(final String input, final int maxLineLength) {
        final StringBuilder accumulator = new StringBuilder();
        final int length = input.length();

        accumulator.append(input, 0, Math.min(length, maxLineLength));

        int split = maxLineLength;
        while (length > split) {
            accumulator.append("\n").append(input, split, Math.min(length, split + maxLineLength));
            split += maxLineLength;
        }
        return accumulator.toString();
    }
}
