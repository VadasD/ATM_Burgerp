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
import java.util.Date;

public class Transaction {
    /**
     * size of transaction
     */
    private double amount;
    /**
     * time of transaction using Java's Date object
     */
    private Date timestamp;
    /**
     * optional note regarding transaction purpose
     */
    private String memo;
    /**
     * account of transaction origin
     */
    private Account inAccount;
}
