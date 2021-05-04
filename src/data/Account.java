/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDateTime;
import java.util.Observable;

/**
 *
 * @author izuek
 */
public class Account extends Observable {
    
    private int accountNo;
    private int accountType;
    private float amount;
    private float balance = 0;
    private int transactionType;
    private LocalDateTime time;
    private String message;
    

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    


    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    
        
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    public float getBalance() {
        return balance;
    }

    public void setBalance(float amount, boolean radBtnSavings, int transactionType) {
        
        
        if (amount <= 0) {
            
            this.message = "Amount cannot be negative";
        }else {
        
        
                
            if (transactionType == 1) {
                this.balance += amount;
            }



            if (transactionType == 2) {

                if (this.balance <= 0) {
                    this.message = "Insufficient Funds";
                }else {
                    this.balance -= amount;
                }
            }
        }

        
        setChanged();
        notifyObservers(this);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
}
