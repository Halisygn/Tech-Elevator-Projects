package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxEnd3Test extends TestCase {

    public void testMakeArray() {
        MaxEnd3 maxEnd3=new MaxEnd3();
        Assert.assertArrayEquals(new int[]{3,3,3},maxEnd3.makeArray(new int[]{ 1,2,3}));
        Assert.assertArrayEquals(new int[]{7,7,7},maxEnd3.makeArray(new int[]{ 7,2,5}));
        Assert.assertArrayEquals(new int[]{6,6,6},maxEnd3.makeArray(new int[]{ 6,6,6}));
        Assert.assertArrayEquals(new int[]{4,4,4},maxEnd3.makeArray(new int[]{ 4,11,3}));

    }
}