/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author izuek
 */
public class TransactionHistory extends Observable {
    
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        setChanged();
        notifyObservers(displayTransaction());
    }
    
    
    public String displayTransaction() {
        
        String allTransaction = "";
        int i;
        for (i = 0; i < transactionList.size(); i++) {
            allTransaction += transactionList.get(i).toString() + "\n";
        }
        return allTransaction;
        
        
    }
}
