package com.telecom.models;

/**
 * Created by Stefan on 9/27/2018.
 */
public class PhoneNumber {
    private int number;
    private boolean activated;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    public PhoneNumber(int number) {
        this.number = number;
        this.activated = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
