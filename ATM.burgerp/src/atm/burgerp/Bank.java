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
import java.util.ArrayList;
import java.util.Random;
public class Bank {
    /**
     * name of the bank
     */
    private String name;
    /**
     * List of bank's users
     */
    private ArrayList<User> users;
    /**
     * List of accounts held by users at bank
     */
    private ArrayList<Account> accounts;
    
    public String getNewUserUUID(){
        //inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        
        do {
            uuid = ""; // start with blank uuid
            //generate random number
            for (int k = 0; k < len; k++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            //check to see if its unique
            for(User u : this.users){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        } while(nonUnique);
        return uuid;
    }
    public String getNewAccountUUID(){
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;
        
        do {
            uuid = ""; // start with blank uuid
            //generate random number
            for (int k = 0; k < len; k++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            //check to see if its unique
            for(Account a : this.accounts){
                if(uuid.compareTo(a.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        } while(nonUnique);
        //now that we know its unique return it
        return uuid;
    }
    /**
     * Add an account to the instance arraylist
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);

    }
    /**
     * Banks method to create new user
     * @param firstName users first name
     * @param lastName  users last name
     * @param pin   users pin
     * @return  the new user
     */
    public User addUser(String firstName, String lastName, String pin){
        //create a new user object ans add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        //create a new savings account for user
        Account newAccount = new Account("Savings", newUser, this);
        this.accounts.add(newAccount);
        //return new user
        return newUser;
        
    }
}

