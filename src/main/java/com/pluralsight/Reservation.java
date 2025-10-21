package com.pluralsight;

import java.util.Objects;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private final double basePrice;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.basePrice = (roomType.equals("king")) ? 139.00 : 124.00;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        double output = this.basePrice * this.numberOfNights;
        if (this.isWeekend) {
            return output * 1.1;
        }
        return output;
    }
}