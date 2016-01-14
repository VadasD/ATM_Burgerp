/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.burgerp;

/**
 *
 * @author Paul
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class User {

    /**
     * users last name
     */
    private String lastName;
    /**
     * users first name
     */
    private String firstName;
    /**
     * Users unique identifier
     */
    private String uuid;
    /**
     * We'll use java's MD5 encryption to store pin numbers
     */
    private byte pinHash[];

    private ArrayList<Account> Accounts;

    /**
     *
     * @param firstName local variable that will be stored as instance variable
     * @param lastName
     **
     * @param pin We'll use MD5 MessageDigest to process
     * @param theBank Need the bank so we can call methods
     */
    public void User(String firstName, String lastName,
            String pin, Bank theBank) {

        this.firstName = firstName;

        this.lastName = lastName;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("caught NoSuchAlgorithmException");
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            //Kick user out
            System.exit(1);

        }
        //ask bank to generate uuid
        this.uuid = theBank.getNewUserUUID();
        //alert the console of a new user
        System.out.printf("New User %s, %s with ID %s Created \n", lastName, firstName, this.uuid);
    }

    /**
     * Add an account to the instance arraylist
     *
     * @param anAcct
     */
    public void addAccount(Account anAcct) {
        this.Accounts.add(anAcct);

    }

    public String getUUID() {
        return this.uuid;
    }
}
