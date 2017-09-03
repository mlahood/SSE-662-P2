/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.File;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DirectoryHandlerTest extends TestCase {
    String testDirPath = "C:\\Users\\matthew.lahood\\Desktop\\Results";
    
    public DirectoryHandlerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(DirectoryHandlerTest.class);
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
    public void testConstructor() {
        DirectoryHandler test = new DirectoryHandler();
        System.out.println("Constructor Test Method");
        assertNotNull(test.fc);
        assertNotNull(test.jFileChooserStatus);
        assertNull(test.rootPath);
    }
    
    /**
     * Test of buildDirectory method, of class DirectoryHandler.
     */
    public void testBuildDirectory() {
        System.out.println("buildDirectory Test Method");
        DirectoryHandler instance = new DirectoryHandler();
        instance.buildDirectory();
        
        assertEquals(testDirPath, instance.dirPath);
    }

    /**
     * Test of directoryHealth method, of class DirectoryHandler.
     */
    public void testDirectoryHealth() {
        System.out.println("directoryHealth Test Method");
        
        DirectoryHandler instance = new DirectoryHandler();
        instance.directoryHealth();
        
        int health = 0;
        File fd = new File(instance.dirPath);
        if (fd.exists()){
            health = 1;
        }
        else{
            health = 0;
        }
        assertFalse(health!=1);
    }
}
