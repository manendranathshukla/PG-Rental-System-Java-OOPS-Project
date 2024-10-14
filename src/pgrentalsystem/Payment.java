package pgrentalsystem;

import java.util.Date;

public class Payment {
    private Booking booking;
    private double amount;
    private Date paymentDate;

    public Payment(Booking booking, double amount) {
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = new Date();
    }

    // Getters and Setters
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
