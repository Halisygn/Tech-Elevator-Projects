package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public void turnOff() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
        if (isOn && (currentChannel >= 3 && currentChannel <= 18)) {
            this.currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn && currentChannel <= 18) {
            this.currentChannel += 1;
        }
        if (isOn && currentChannel > 18) {
            this.currentChannel =3;
        }
    }

    public void channelDown() {
        if (isOn && currentChannel >= 3) {
            this.currentChannel -= 1;
        }
        if (isOn && currentChannel < 3) {
            this.currentChannel = 18;
        }
    }

    public void raiseVolume() {
        if (isOn && currentVolume < 10) {
            this.currentVolume += 1;
        }
    }

    public void lowerVolume() {
        if (isOn && currentVolume > 0) {
            this.currentVolume -= 1;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
