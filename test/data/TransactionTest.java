/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDateTime;
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
public class TransactionTest {
    
    public TransactionTest() {
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


    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Transaction instance = new Transaction();
        instance.setAmount(2.0F);
        float expResult = 2.0F;
        float result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }
    
    
    
    @Test
    public void testDepositAmount() {
        System.out.println("depositAmount");
        Transaction instance = new Transaction();
        instance.setBalance(5, true, 1);
        float expResult = 5.0F;
        float result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testWithdrawAmount() {
        System.out.println("withdrawAmount");
        Transaction instance = new Transaction();
        instance.setBalance(5, true, 1);
        
        instance.setBalance(3, true, 2);
        
        float expResult = 2.0F;
        float result = instance.getBalance();
        
        assertEquals(expResult, result, 0.0);
    }
    
    
    
    @Test
    public void testNegativeAmount() {
        System.out.println("getAmount");
        Transaction instance = new Transaction();
        instance.setAmount(-1.0F);
        float expResult = 0.0F;
        float result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }


    @Test
    public void testEquals() {
        System.out.println("equals");
        Transaction o = new Transaction();
        Transaction instance = new Transaction();
        
        instance.setBalance(5, true, 1);
        
        o.setAmount(5);
        o.setTime(LocalDateTime.now());
        o.setTransactionType(1);
                
                
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result );
    }
    
}
