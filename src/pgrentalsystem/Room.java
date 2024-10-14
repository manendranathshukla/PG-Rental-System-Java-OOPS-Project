package pgrentalsystem;

public class Room {
    private int roomNumber;
    private double rent;
    private boolean isOccupied;
    private String roomType;

    public Room(int roomNumber, double rent,String roomType) {
        this.roomNumber = roomNumber;
        this.rent = rent;
        this.isOccupied = false;
        this.roomType=roomType;
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }
    

    public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", rent=" + rent +
                ", isOccupied=" + isOccupied +
                ", roomType='" + roomType + '\'' +
                '}';
    }

}

