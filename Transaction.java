/**
 * Transaction.java
 * 
 * Data structure that represents a canteen Transaction with monetary amount and description
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */

public class Transaction {
    private double amount;
    private String desc;

    public Transaction(double a, String d) {
        this.amount = a;
        this.desc = d;
    }

    @Override
    public String toString() {
        return String.format("$%.2f : %s", this.amount, this.desc);
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setAmount(double a) {
        this.amount = a;
    }

    public void setDesc(String d) {
        this.desc = d;
    }
}