/**
 * Account.java
 * 
 * Data structure that contains canteen account information for a student
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */

 import java.util.ArrayList;

public class Account {
    private String email;
    private String name;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String e, String n, double b) {
        this.email = e;
        this.name = n;
        this.balance = b;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setName(String n) {
        this.name = n;
    } 

    public void setBalance(double b) {
        this.balance = b;
    }

    public void setTransactions(ArrayList<Transaction> t) {
        this.transactions = t;   
    }

    public void addTransaction(double amount, String desc) {
        Transaction temp = new Transaction(amount, desc);

        this.transactions.add(temp);
        this.balance -= amount;

    }

    public String toString() {
        return String.format("%s\n\nNo transactions available yet. \nBalance: $%.2f\n\n",this.name, this.balance);
    }

    public void printAccount() {
        System.out.printf("%s\n", this.name);
        System.out.printf("%s\n", this.email);
        System.out.println();
        for (Transaction t : this.transactions) {
            System.out.println(t.toString());
        }
        System.out.println();
        System.out.printf("Balance: $%.2f\n\n", this.balance);
    }

    public static void main(String[] args) {


    }
}