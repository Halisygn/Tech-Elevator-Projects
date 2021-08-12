package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class NonStartTest extends TestCase {

    public void testGetPartialString() {
        NonStart nonStart=new NonStart();
        Assert.assertEquals("ellohere",nonStart.getPartialString("Hello", "There"));
        Assert.assertEquals("avaode",nonStart.getPartialString("java", "code"));
        Assert.assertEquals("hotlava",nonStart.getPartialString("shotl", "java"));
        Assert.assertEquals("hotl",nonStart.getPartialString("shotl", ""));
        Assert.assertEquals("ood",nonStart.getPartialString("", "good"));
    }
}