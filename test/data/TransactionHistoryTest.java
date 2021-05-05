/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author izuek
 */
public class TransactionHistoryTest {
    
    public TransactionHistoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTransaction method, of class TransactionHistory.
     */
    @Test
    public void testAddTransaction() {
        System.out.println("addTransaction");
        Transaction transaction = new Transaction();
        
        
        transaction.setBalance(5, true, 1);
        
        TransactionHistory instance = new TransactionHistory();
        instance.addTransaction(transaction);
    }

    /**
     * Test of displayTransaction method, of class TransactionHistory.
     */
    @Test
    public void testDisplayTransaction() {
        System.out.println("displayTransaction");
        TransactionHistory instance = new TransactionHistory();
        String expResult = "";
        String result = instance.displayTransaction();
        assertEquals(expResult, result);
    }
    
}
