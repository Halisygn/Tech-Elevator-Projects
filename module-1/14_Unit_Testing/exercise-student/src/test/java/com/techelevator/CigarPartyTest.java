package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class CigarPartyTest extends TestCase {

    public void testHaveParty() {
        //Arrange
        CigarParty party=new CigarParty();
        //Act and Assert
        Assert.assertTrue(party.haveParty(50,true));
        Assert.assertTrue(party.haveParty(45,false));
        Assert.assertTrue(party.haveParty(70,true));
        Assert.assertFalse(party.haveParty(70,false));
        Assert.assertFalse(party.haveParty(30,false));
        Assert.assertFalse(party.haveParty(30,true));
        Assert.assertTrue(party.haveParty(40,true));
        Assert.assertTrue(party.haveParty(40,false));
        Assert.assertTrue(party.haveParty(60,true));
        Assert.assertTrue(party.haveParty(60,false));











    }
}