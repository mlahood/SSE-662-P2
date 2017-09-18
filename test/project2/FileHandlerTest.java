/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import project2.FileHandler;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileHandlerTest extends TestCase {
    String dirPath = "C:\\Users\\matthew.lahood\\Desktop\\Results";
    
    public FileHandlerTest(String testName) throws IOException {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(FileHandlerTest.class); 
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
     * Test of Constructor, of class FileHandler.
     */
    public void testConstructor() throws IOException{
        System.out.println("Constructor Test Method");
        FileHandler instance = new FileHandler();
        
        assertNotNull(instance.fw);
        assertNotNull(dirPath);
        assertEquals(instance.logFile, "\\Results.log");
        assertEquals(dirPath, dirPath + instance.logFile);
    }
}
