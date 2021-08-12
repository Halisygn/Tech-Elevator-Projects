package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class FrontTimesTest extends TestCase {

    public void testGenerateString() {
        FrontTimes font=new FrontTimes();
        Assert.assertEquals("chochocho",font.generateString("chocolate",3));
        Assert.assertEquals("HalHal",font.generateString("Halis",2));
        Assert.assertEquals("Cho",font.generateString("Cho",1));
        Assert.assertEquals("HiHiHi",font.generateString("Hi",3));
        Assert.assertEquals("aa",font.generateString("a",2));
        Assert.assertEquals("",font.generateString("a",0));
        Assert.assertEquals("",font.generateString("",3));
        Assert.assertEquals("  ",font.generateString(" ",2));




    }
}