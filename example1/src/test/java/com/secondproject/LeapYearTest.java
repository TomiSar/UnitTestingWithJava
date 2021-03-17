package com.secondproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTest {

    // a year is a leap year if it is divisible by four, but, years divisible by 100, are not leap years,
    // except years divisible by 400

    @Test
    public void yearsDivisibleByFourAreLeapYears() {
        assertTrue(LeapYear.isLeapYear(2020));
    }

    @Test
    public void yearsDivisibleByHundredAreNotLeapYears() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void regularYearsAreNotLeapYears() {
        assertFalse(LeapYear.isLeapYear(2013));
    }

    @Test
    public void yearsDivisibleByFourHundredAreLeapYears() {
        assertTrue(LeapYear.isLeapYear(2000));
    }
}
