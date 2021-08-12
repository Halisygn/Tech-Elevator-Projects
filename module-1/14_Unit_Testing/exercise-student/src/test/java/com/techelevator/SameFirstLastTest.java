package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class SameFirstLastTest extends TestCase {

    public void testIsItTheSame() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        Assert.assertTrue(sameFirstLast.isItTheSame(new int[]{1}));
        Assert.assertTrue(sameFirstLast.isItTheSame(new int[]{2,2}));
        Assert.assertTrue(sameFirstLast.isItTheSame(new int[]{1,2,1}));
        Assert.assertFalse(sameFirstLast.isItTheSame(new int[]{}));
        Assert.assertFalse(sameFirstLast.isItTheSame(new int[]{1,2}));
        Assert.assertFalse(sameFirstLast.isItTheSame(new int[]{4,7,15}));
    }
}