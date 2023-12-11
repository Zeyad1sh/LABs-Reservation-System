package sem451;

import java.util.*;

class Lab {
    private int labID;
    private int capacity;
    private boolean[] availability;

    public Lab(int labID, int capacity) {
        this.labID = labID;
        this.capacity = capacity;
        this.availability = new boolean[24]; // Assuming labs have 24 available slots (hours)
        Arrays.fill(availability, true); // Initially, all slots are available
    }

    public boolean reserveSlot(int slot) {
        if (slot >= 0 && slot < 24 && availability[slot]) {
            availability[slot] = false; // Book the slot
            return true;
        }
        return false; // Slot not available or invalid slot
    }

    public void displayAvailability() {
        System.out.println("Lab " + labID + " Availability:");
        for (int i = 0; i < 24; i++) {
            if (availability[i]) {
                System.out.println("Slot " + i + ": Available");
            } else {
                System.out.println("Slot " + i + ": Booked");
            }
        }
    }
}

class Reservation {
    private String user;
    private int labID;
    private int slot;

    public Reservation(String user, int labID, int slot) {
        this.user = user;
        this.labID = labID;
        this.slot = slot;
    }

    // Getter methods for user, labID, and slot
    // Additional methods for managing reservations and user details can be added
}

public class LabReservationSystem {
    public static void main(String[] args) {
        // Create Labs
        Lab lab1 = new Lab(1, 10); // Lab ID 1 with a capacity of 10
        Lab lab2 = new Lab(2, 15); // Lab ID 2 with a capacity of 15

        // Display Lab Availability
        lab1.displayAvailability();
        lab2.displayAvailability();

        // Example Reservation
        String user = "John Doe";
        int labID = 1;
        int slot = 13; // Book slot 13 for Lab 1
        Reservation reservation = new Reservation(user, labID, slot);
        if (lab1.reserveSlot(slot)) {
            System.out.println("Reservation Successful for " + user + " at Lab " + labID + " Slot " + slot);
        } else {
            System.out.println("Reservation Failed! Slot " + slot + " not available.");
        }

        // Display Updated Availability
        lab1.displayAvailability();
    }
}