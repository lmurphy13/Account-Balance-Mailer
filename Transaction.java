/**
 * Transaction.java
 * 
 * Data structure that represents a canteen Transaction with monetary amount and description
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */

public class Transaction {
    private String date;
    private String name;
    private String type;
    private double amount;
    private String desc;

    public Transaction(String date, String name, String type, double amount, String desc) {
        this.date = date;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t$%.2f\t\t%s", this.date, this.type, this.amount, this.desc);
    }

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDate(String d) {
        this.date = d;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setType(String t) {
        this.type = t;
    }

    public void setAmount(double a) {
        this.amount = a;
    }

    public void setDesc(String d) {
        this.desc = d;
    }

    public static void main(String[] args) {
        Transaction t = new Transaction("30-Jan-20", "Liam Murphy", "Withdrawal", 41.48, "Winter outing");
        System.out.println(t.toString());
    }
}