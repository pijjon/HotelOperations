package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= this.bookedSuites) {
                this.bookedSuites -= numberOfRooms;
                return true;
            } else {

                return false;
            }
        } else {
            if (numberOfRooms <= this.bookedBasicRooms) {
                this.bookedBasicRooms -= numberOfRooms;
                return true;
            } else {

                return false;
            }
        }
    }

    public int getAvailableSuites() {
        return this.getNumberOfSuites() - this.getBookedSuites();
    }

    public int getAvailableRoom() {
        return this.getNumberOfRooms() - this.getBookedBasicRooms();
    }


}

