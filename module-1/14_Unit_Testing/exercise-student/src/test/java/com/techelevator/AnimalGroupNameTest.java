package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;

public class AnimalGroupNameTest extends TestCase {

    public void testGetHerd() {
        //Arrange
        AnimalGroupName animalGroup=new AnimalGroupName();
        //Act Assert
        Assert.assertEquals("getHerd_should_return_\"Tower\"_when_animal_name_\"Giraffe\"",
                "Tower",animalGroup.getHerd("Giraffe"));
        Assert.assertEquals("getHerd_should_return_\"unknown\"_when_animal_name_\"\"",
                "unknown",animalGroup.getHerd(""));
        Assert.assertEquals("getHerd_should_return_\"unknown\"_when_animal_name_\"cat\"",
                "unknown",animalGroup.getHerd("cat"));
        Assert.assertEquals("getHerd_should_return_\"Herd\"_when_animal_name_\"elEphant\"",
                "Herd",animalGroup.getHerd("elEphant"));
        Assert.assertEquals("getHerd_should_return_\"Herd\"_when_animal_name_\"ELEPHANT\"",
                "Herd",animalGroup.getHerd("ELEPHANT"));
        Assert.assertEquals("getHerd_should_return_\"unknown\"_when_animal_name_\" \"",
                "unknown",animalGroup.getHerd(" "));
    }
}