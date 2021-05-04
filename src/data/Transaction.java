/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

/**
 *
 * @author izuek
 */
public class Transaction extends Observable {
    
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
        
        this.transactionType = transactionType;
        this.amount = amount;
        this.setTime(LocalDateTime.now());
        
        if (this.getAmount() <= 0) {
            
            this.message = "Amount cannot be negative";
        }else {
        
        
                
            if (this.getTransactionType() == 1) {
                this.balance = this.balance + amount;
                this.message = "Deposit Successful";
            }



            if (this.getTransactionType() == 2) {

                if (this.balance <= 0) {
                    this.message = "Insufficient Funds";
                }else {
                    this.balance = this.balance - amount;
                    this.message = "Withdrwal Successful";
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
    
    
    public String toString() {
        
        
        String timeString = "";
        String dateString = ""; 
        String transactionTypeName = "";
        
        dateString = this.getTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        timeString = this.getTime().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        
        if (this.getTransactionType() == 1) transactionTypeName = "Deposit";
        else if(this.getTransactionType() == 2) transactionTypeName = "Withdrawal";
        
        return transactionTypeName + " of " + this.getAmount() + " @ " + dateString + " " + timeString + " ==> Message: " + this.getMessage();
    }
    
}
