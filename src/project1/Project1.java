package project1;

import javax.swing.UIManager;

public class Project1 {

    /**
     * Main
     * This method is the program entry point.   
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Set Windows Appearance
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception evt) {
        }
        
        // Create an instance of the application
        HomeGUI mainGUI = new HomeGUI();
    }
}
