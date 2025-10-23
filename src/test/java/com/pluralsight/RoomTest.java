package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    @Test
    public void checkIn_should_make_room_occupied_and_dirty() {
        Room emptyCleanRoom = new Room(10, 124.00, false, false);

        emptyCleanRoom.checkIn();

        assertTrue(emptyCleanRoom.isDirty() && emptyCleanRoom.isOccupied());
    }

    @Test
    public void checkIn_should_not_work_on_occupied_clean_room() {
        Room occupiedCleanRoom = new Room(10, 124.00, true, false);

        occupiedCleanRoom.checkIn();

        assertTrue(occupiedCleanRoom.isOccupied());
        assertFalse(occupiedCleanRoom.isDirty());
    }

    @Test
    public void checkIn_should_not_work_on_empty_dirty_room() {
        Room emptyDirtyRoom = new Room(10, 124.00, false, true);

        emptyDirtyRoom.checkIn();

        assertFalse(emptyDirtyRoom.isOccupied());
        assertTrue(emptyDirtyRoom.isDirty());
    }

    @Test
    public void checkIn_should_not_work_on_occupied_dirty_room() {
        Room occupiedDirtyRoom = new Room(10, 124.00, true, true);

        occupiedDirtyRoom.checkIn();

        assertTrue(occupiedDirtyRoom.isOccupied());
        assertTrue(occupiedDirtyRoom.isDirty());
    }


}
