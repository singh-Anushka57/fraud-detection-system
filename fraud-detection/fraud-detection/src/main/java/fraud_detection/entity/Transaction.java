package fraud_detection.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private double time;
    private int fraud;

    public Transaction() {}

    public Transaction(double amount, double time, int fraud) {
        this.amount = amount;
        this.time = time;
        this.fraud = fraud;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public double getTime() { return time; }
    public int getFraud() { return fraud; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setTime(double time) { this.time = time; }
    public void setFraud(int fraud) { this.fraud = fraud; }
}