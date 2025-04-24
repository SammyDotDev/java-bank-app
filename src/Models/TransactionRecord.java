package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionRecord {
    private String sender;
    private String recipient;
    private double amount;
    private LocalDate date;
    private LocalTime time;

    public TransactionRecord(String sender, String recipient, double amount, LocalDate date, LocalTime time){
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
