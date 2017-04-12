package com.viavi.tempest;

import org.junit.Test;
import static org.junit.Assert.*;

public class GivenAMainClass {
    @Test
    public void ThenTheBasicLawsOfMathematicsShouldStillApply() {
        assertEquals(2, 1 + 1);
    }

    @Test(expected = ArithmeticException.class)
    public void ThenAnExceptionGetsThrown() {
        int first = 0;
        int second = 1;
        System.out.println(second / first);
    }
}