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

public class Account {
    /**
 * The type of account
 * @author Paul
 */
    private String name;
   
    private double balance;
    /**
     * Unique universal ID, alphanumeric
     */
    private String uuid;
    /**
     * The user object associated with the account
     */
    private User holder;
    /**
     * A list of all transactions associated with this account
     */
    private ArrayList<Transaction> transactions;
    
    public Account(String name, User holder, Bank theBank){
        //set basic values
        this.name = name;
        this.holder = holder;
        //ask bank to issue new uuid
        this.uuid = theBank.getNewAccountUUID();
        //init the list of transactios
        this.transactions = new ArrayList<>();
        //add the holder and the bank
        //holder.addAccount(this);
        //theBank.addAccount(this);
    } 
    /**
     * ACCSseot mehtod for accoutn uuis
     * @return account uuid
     */
    public String getUUID(){
        return this.uuid;
    }
}
