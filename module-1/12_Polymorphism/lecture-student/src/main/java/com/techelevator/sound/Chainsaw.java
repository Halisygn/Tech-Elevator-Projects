package com.techelevator.sound;

public class Chainsaw implements ISound{
    @Override
    public String makeSound() {
        return "buzz";
    }

    @Override
    public String getItemName() {
        return "I am a chainsaw";
    }
}
