package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class Lucky13Test extends TestCase {

    public void testGetLucky() {
        Lucky13 lucky13=new Lucky13();
        Assert.assertTrue(lucky13.getLucky(new int[] { 0, 2, 4 }));
        Assert.assertFalse(lucky13.getLucky(new int[] { 1, 2, 4 }));
        Assert.assertFalse(lucky13.getLucky(new int[] { 1, 2, 3 }));
        Assert.assertFalse(lucky13.getLucky(new int[] { 1 }));
        Assert.assertTrue(lucky13.getLucky(new int[] { }));
        Assert.assertFalse(lucky13.getLucky(new int[] { 1, 2, 3,3 }));

    }
}