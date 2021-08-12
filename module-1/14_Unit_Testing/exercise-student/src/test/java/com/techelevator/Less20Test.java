package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class Less20Test extends TestCase {

    public void testIsLessThanMultipleOf20() {
        Less20 less20=new Less20();
        Assert.assertTrue(less20.isLessThanMultipleOf20(18));
        Assert.assertTrue(less20.isLessThanMultipleOf20(19));
        Assert.assertTrue(less20.isLessThanMultipleOf20(38));
        Assert.assertTrue(less20.isLessThanMultipleOf20(59));
        Assert.assertFalse(less20.isLessThanMultipleOf20(32));
        Assert.assertFalse(less20.isLessThanMultipleOf20(20));
        Assert.assertFalse(less20.isLessThanMultipleOf20(0));
    }
}