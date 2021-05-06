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
    private float balance;
    private int transactionType;
    private LocalDateTime time;
    private String message;
    
    
    public static final int DEPOSIT_OPERATION = 1;
    public static final int WITHDRAWL_OPERATION = 2;
    
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
        
        if (amount <= 0) {
            
            this.message = "Amount cannot be negative";
        }else {
            this.amount = amount;
        }
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

    public void setBalance(float balance) {
        this.balance = balance;
        
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
    
    
    public boolean equals(Transaction o) {
        
        if (o == null) return false;
        if (this.amount == o.getAmount() 
                && this.time.equals(o.getTime()) 
                && this.transactionType == o.getTransactionType()) {
            return true;
        }
        return false;
        
    }
    
    
    public void makeTransaction(float amount, boolean radBtnSavings, int transactionType) {
        
        System.out.println("Amount====> " + amount);
        this.transactionType = transactionType;
        this.amount = amount;
        this.setTime(LocalDateTime.now());
        
        if (amount <= 0) {
            
            this.message = "Amount cannot be negative";
        }else {
        
                
            if (this.getTransactionType() == DEPOSIT_OPERATION) {
                this.balance += amount;
                this.message = "Deposit Successful";
            }



            if (this.getTransactionType() == WITHDRAWL_OPERATION) {

                if (balance < 0 || (balance - amount) < 0) {
                    message = "Insufficient Funds";
                }else {
                    balance -= amount;
                    message = "Withdrwal Successful";
                }
            }
        }

        
        setChanged();
        notifyObservers(this);
    }
}
