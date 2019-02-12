/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4actions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 21408162
 */
public class DateTest {
    
    public DateTest() {
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
     * Test of getToInt method, of class Date.
     */
    @Test
    public void testGetToInt() {
        System.out.println("getToInt");
        Date instance = new Date(1,2,4) ;
        int expResult = 40201;
        int result = instance.getToInt();
        assertEquals(expResult, result); //il faut que notre resultat getToInt soit égal à 0. 
     
    }

    /**
     * Test of fromInt method, of class Date.
     */
    @Test
    public void testFromInt() {
        System.out.println("fromInt");
        int i = 20190212;
        Date expResult = new Date();
        Date result = Date.fromInt(i);
       System.out.println(result);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of hashCode method, of class Date.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Date instance = new Date();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Date instance = new Date();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Date.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date instance = new Date();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
