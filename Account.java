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

    public Account(String e, String n, double b, ArrayList<Transaction> t) {
        this.email = e;
        this.name = n;
        this.balance = b;
        this.transactions = t;
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

    public void addTransaction(String date, String name, String type, double amount, String desc) {
        Transaction temp = new Transaction(date, name, type, amount, desc);

        this.transactions.add(temp);
    }

    public String toString() {
        String acct = "";
        
        acct += String.format("%s\n\n",this.name);
        acct += String.format("Date:\t\tType:\t\tAmount:\t\tDescription:\n\n");

        for (Transaction t : this.transactions) {
            acct += t.toString();
        }

        acct += String.format("\nBalance: $%.2f\n\n", this.balance);

        return acct;
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