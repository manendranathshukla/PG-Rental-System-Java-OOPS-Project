package pgrentalsystem;

public class Tenant {
    private String name;
    private String contactNumber;
    private Room room;

    public Tenant(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    public void assignRoom(Room room) {
        if (room != null && !room.isOccupied()) {
            this.room = room;
            room.setOccupied(true);
            System.out.println(name + " has been assigned to Room " + room.getRoomNumber());
        } else {
            System.out.println("Room is either null or already occupied.");
        }
    }

    public void clearRoom() {
        if (room != null) {
            room.setOccupied(false);
            System.out.println(name + " has vacated Room " + room.getRoomNumber());
            room = null;
        } else {
            System.out.println(name + " has no room to vacate.");
        }
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", room=" + (room != null ? room.getRoomNumber() : "No room assigned") +
                '}';
    }

}
