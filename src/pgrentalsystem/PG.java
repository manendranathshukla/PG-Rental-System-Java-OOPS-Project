package pgrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class PG {
    private String name;
    private String address;
    private Owner owner;
    private List<Room> rooms;

    public PG(String name, String address, Owner owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.rooms = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    public boolean removeRoom(Room room) {
        if (rooms.remove(room)) {
            System.out.println("Room " + room.getRoomNumber() + " removed from " + name);
            return true;
        } else {
            System.out.println("Room not found in " + name);
            return false;
        }
    }

    
    @Override
    public String toString() {
        return "PG{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", owner=" + owner.getName() +
                ", number of rooms=" + rooms.size() +
                '}';
    }

    public boolean hasAvailableRooms() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                return true; // At least one room is available
            }
        }
        return false; // No available rooms
    }

    
}