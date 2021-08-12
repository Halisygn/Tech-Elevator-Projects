package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class DateFashionTest extends TestCase {

    public void testGetATable() {
        DateFashion score=new DateFashion();
        Assert.assertEquals(2,score.getATable(8,8));
        Assert.assertEquals(1,score.getATable(3,4));
        Assert.assertEquals(2,score.getATable(9,10));
        Assert.assertEquals(0,score.getATable(2,8));
        Assert.assertEquals(0,score.getATable(2,1));
        Assert.assertEquals(0,score.getATable(5,1));
        Assert.assertEquals(0,score.getATable(1,1));
        Assert.assertEquals(2,score.getATable(4,8));
        Assert.assertEquals(2,score.getATable(9,6));
        Assert.assertEquals(0,score.getATable(1,4));
    }
}