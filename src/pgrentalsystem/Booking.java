package pgrentalsystem;

import java.util.Date;

public class Booking {
	private static int bookingCounter = 0;
	private int bookingId;
    private Tenant tenant;
    private Room room;
    private double advancePayment;
    private Date bookingDate;

    public Booking(Tenant tenant, Room room, double advancePayment) {
        this.bookingId=++bookingId;
    	this.tenant = tenant;
        this.room = room;
        this.advancePayment = advancePayment;
        this.bookingDate = new Date();
        room.setOccupied(true);
    }

    public int getBookingId() {
		return bookingId;
	}

	// Getters and Setters
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public double calculateRemainingAmount() {
        return room.getRent() - advancePayment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", tenant=" + tenant.getName() +
                ", room=" + room.getRoomNumber() +
                ", advancePayment=" + advancePayment +
                ", bookingDate=" + bookingDate +
                '}';
    }

    
}
