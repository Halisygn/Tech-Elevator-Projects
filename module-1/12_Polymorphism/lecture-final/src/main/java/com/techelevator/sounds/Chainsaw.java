package com.techelevator.sounds;

import com.techelevator.farm.Sellable;

import java.math.BigDecimal;

public class Chainsaw implements ISound {

    private boolean isStarted;

    @Override
    public String makeSound() {
        return "buzzz!";
    }

    @Override
    public String getItemName() {
        return "I am a chainsaw!";
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }
}
