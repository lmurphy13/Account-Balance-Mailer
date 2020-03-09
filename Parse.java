/**
 * Parse.java
 * 
 * Parses student canteen accounts from CSV files into Account and Transaction objects
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Parse {

    private ArrayList<Account> accounts;
    private ArrayList<String> emails;
    private ArrayList<Transaction> trans; // transaction objects to be sorted by person

    public Parse() {
        this.accounts = new ArrayList<Account>();
        this.emails = new ArrayList<String>();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public ArrayList<String> getEmails() {
        return this.emails;
    }

    public void parseTransactions() {
        String pathToRecords = "/Users/liam/Documents/Marquette Files/Eboard/Mailer/records.csv";
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


         // get transaction info
         try {
            br = new BufferedReader(new FileReader(pathToRecords));
            while ((line = br.readLine()) != null) {
                String[] record = line.split(cvsSplitBy);
                String date = record[0];
                String name = record[1];
                String type = record[2];
                double amount = Double.parseDouble(record[4]);
                String desc = record[5];

                Transaction temp = new Transaction(date, name, type, amount, desc);
                trans.add(temp);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public void parseAccounts() {
        String pathToCanteen = "/Users/liam/Documents/Marquette Files/Eboard/Mailer/canteen.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        // get account info
        try {
            br = new BufferedReader(new FileReader(pathToCanteen));
            while ((line = br.readLine()) != null) {
                String[] person = line.split(cvsSplitBy);
                String name = person[0];
                double balance = Double.parseDouble(person[1]);
                String email = person[2];

                ArrayList<Transaction> transLocal = new ArrayList<Transaction>();

                for (Transaction t : this.trans) {
                    if (t.getName().equals(name)) {
                        transLocal.add(t);
                    }
                }

                


                Account temp = new Account(email,name, balance, transLocal);
                this.accounts.add(temp);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sort(ArrayList<Transaction> trans) {
        for (Transaction t : trans) {
            if (t.getDate()
        }
    }

    public static void main(String[] args) {
        Parse p = new Parse();

        p.parse();

        // for (String email : p.getEmails())
        //     System.out.println(email);
    }
}