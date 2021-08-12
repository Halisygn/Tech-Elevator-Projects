package com.techelevator.sounds;

public class OneDirection implements ISound {

    private boolean IsPlaying;

    @Override
    public String makeSound() {
        return "shreeking nails on chalkboard!";
    }

    @Override
    public String getItemName() {
        return "We are Kevin's Favorite band since Menudo";
    }


    public boolean isPlaying() {
        return IsPlaying;
    }

    public void setPlaying(boolean playing) {
        IsPlaying = playing;
    }
}
