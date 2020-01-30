/**
 * Parse.java
 * 
 * Parses student canteen accounts from a CSV file into Account objects
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */


import java.io.*;
import java.util.ArrayList;

public class Parse {

    private ArrayList<Account> accounts;
    private ArrayList<String> emails;

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

    public void parse() {
        String pathToCSV = "/Users/liam/Documents/Marquette Files/Eboard/Mailer/canteen.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        // get account info
        try {
            br = new BufferedReader(new FileReader(pathToCSV));
            while ((line = br.readLine()) != null) {
                String[] person = line.split(cvsSplitBy);
                String name = person[0];
                double balance = Double.parseDouble(person[1]);
                String email = person[2];

                Account temp = new Account(email,name, balance);
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

    public static void main(String[] args) {
        Parse p = new Parse();

        p.parse();

        // for (String email : p.getEmails())
        //     System.out.println(email);
        
        

    }
}