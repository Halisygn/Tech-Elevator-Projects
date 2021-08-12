package com.techelevator.sound;

public class OneDirection implements ISound{

    @Override
    public String makeSound() {
        return "shreeking nails on chalkboard!";
    }

    public String getItemName(){
        return "One direction";
    }

}
