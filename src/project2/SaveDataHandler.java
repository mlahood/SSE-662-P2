package project2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 * Save Data Handler
 * This class provides the complete sequence for saving data.
 */
public class SaveDataHandler {
    
    /**
     * Save Data
     * This method provides the sequence for saving data and several
     * data checking sequences to avoid and handle possible thrown 
     * exceptions in this and related methods.  
     */
    public void saveData() {
        //Build Directory
        DirectoryHandler dh = new DirectoryHandler();

        /**
         * Note:  Closing/canceling the JFileChooser results in saving 
         * a null path.  This if statement ensures that anything other
         * than approving the selection will skip the save routine.  
         */
        if(dh.getJFileChooserStatus() == JFileChooser.APPROVE_OPTION){
            dh.buildDirectory();
            
            //Bad Directory Path
            if (dh.directoryHealth() == 0){
                saveData();
            }

            //Healthy Directory Path
            if(dh.directoryHealth() == 1){
                try {
                    //Build Files and IO Streams
                    FileHandler fh = new FileHandler();

                    //Write Log File
                    fh.wFile();

                } catch (IOException ex) {
                    Logger.getLogger(SaveDataHandler.class.getName()).log(Level.SEVERE, null, ex);
                    HomeGUI.errMessage("Folder could not be found and/or is corrupted.\n"
                            +"Attempt to save the results again.", "Folder Error");
                }
            } 
        }
    }
}
