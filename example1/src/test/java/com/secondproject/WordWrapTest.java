package com.secondproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapTest {

    public static final int MAX_LINE_LENGTH = 5;
    // a method that breaks words on specified space with new line, like a word processor would.

    @Test
    public void shortLinesShouldNotWrap() {
        final String input = WordWrap.wrap("Hey", MAX_LINE_LENGTH);
        assertEquals("Hey", input);
    }

    @Test
    public void lineShouldWrapIfOverLineLength() {
        final String input = WordWrap.wrap("TDD tests", MAX_LINE_LENGTH);
        assertEquals("TDD t\nests", input);
    }

    @Test
    public void longLinesShouldWrapTwice() {
        final String input = WordWrap.wrap("Catch the bugs", MAX_LINE_LENGTH);
        assertEquals("Catch\n the \nbugs", input);
    }

    @Test
    public void longerLinesShouldWrapMultipleTimes() {
        final String input = WordWrap.wrap("Unit testing is great way to catch bugs.", MAX_LINE_LENGTH);
        assertEquals("Unit \ntesti\nng is\n grea\nt way\n to c\natch \nbugs.", input);
    }

    @Test
    public void longLinesDontHaveToBeMultipleOfLineLength() {
        final String input = WordWrap.wrap("The Sleepy Brown Fox.", MAX_LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox\n.", input);
    }
}
