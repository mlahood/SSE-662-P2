/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import project2.Calculator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatorTest extends TestCase {
    Calculator instance = new Calculator();
    
    public CalculatorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CalculatorTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of Constructor, of class Calculator.
     */
    public void testConstructor(){
        System.out.println("Constructor Test Method");
        
        assertNotNull(Calculator.numberList);
        assertTrue(Calculator.rMax==107);
        assertTrue(Calculator.rMin==-20);
        assertTrue(Calculator.rTotal==25);
        assertTrue(Calculator.max==0);
        assertTrue(Calculator.min==0);
        assertTrue(Calculator.ave==0);
    }
    
    /**
     * Test of populateArray method, of class Calculator.
     */
    public void testPopulateArray() {
        System.out.println("populateArray Test Method");
        
        Calculator instance = new Calculator();
        instance.populateArray();
        
        assertNotNull(Calculator.numberList);
        int size = Calculator.numberList.size();
        assertEquals(size, Calculator.rTotal);
        
        for(int i = 0; i < Calculator.numberList.size(); i++){
            assertTrue(Calculator.numberList.get(i)<=Calculator.rMax);
            assertTrue(Calculator.numberList.get(i)>=Calculator.rMin);
        }
    }

    /**
     * Test of mathEngine method, of class Calculator.
     */
    public void testMathEngine() {
        System.out.println("mathEngine Test Method");
        
        Calculator instance = new Calculator();
        instance.populateArray();
        instance.populateArray();
        instance.mathEngine();
        
        assertTrue(Calculator.max!=0);
        assertTrue(Calculator.min!=0);
        assertTrue(Calculator.ave!=0);
        
        //Ensure only 1 min number is in the correct array position; array(0).
        int count = 0;
        int index = 0;
        for(int i = 0; i < Calculator.numberList.size(); i++){
            if(Calculator.numberList.get(index) >= Calculator.numberList.get(i)){
                count++;
            }
        }
        assertTrue(count==1);
        
        //Ensure only 1 max number is in the correct array position; array(max).
        count = 0;
        index = Calculator.numberList.size()-1;
        for(int i = 0; i < Calculator.numberList.size(); i++){
            if(Calculator.numberList.get(index) <= Calculator.numberList.get(i)){
                count++;
            }
        }
        assertTrue(count==1);
    }
}
