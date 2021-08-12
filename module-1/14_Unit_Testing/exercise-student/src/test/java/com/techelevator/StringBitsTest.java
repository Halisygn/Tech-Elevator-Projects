package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class StringBitsTest extends TestCase {

    public void testGetBits() {
        StringBits stringBits=new StringBits();
        Assert.assertEquals("Hlo",stringBits.getBits("Hello"));
        Assert.assertEquals("H",stringBits.getBits("Hi"));
        Assert.assertEquals("wloe",stringBits.getBits("welcome"));
        Assert.assertEquals("",stringBits.getBits(""));
    }
}