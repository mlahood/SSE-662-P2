package project1;

import java.io.File;
import javax.swing.JFileChooser;
import static project1.HomeGUI.errMessage;

/**
 * Directory Handler
 * This class provides all the necessary methods for the creation
 * and health monitoring of directories needed for saving files.
 * <p>
 * Root Directory Path:
 * C:\UserSelectedPath\
 */
public class DirectoryHandler {
    JFileChooser fc;
    int jFileChooserStatus;
    File rootPath;
    final String dirName = "\\Results";
    static String dirPath;
   
    /**
     * Directory Handler
     * This constructor initializes the JFileChooser GUI.
     */
    DirectoryHandler(){
        fc = new JFileChooser("C:\\");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        rootPath = null;
        jFileChooserStatus = fc.showOpenDialog(null);
    }
    
    /**
     * Build Directory
     * This method creates the directory in the selected path.
     * <p>
     * Full Directory Path:
     * C:\UserSelectedPath\Results
     */
    public void buildDirectory(){
        rootPath = fc.getSelectedFile();
        dirPath = rootPath + dirName;
        File dir = new File(rootPath + dirName);
        dir.mkdir(); 
    }
    
     /**
     * Directory Health
     * This method verifies the health of the complete directory
     * path.  
     * <p>
     * Full Directory Path:
     * C:\UserSelectedPath\Results
     */
    public int directoryHealth(){
        int health = 0;
        File fd = new File(dirPath);
        if (fd.exists()){
            health = 1;
        }
        else{
            errMessage(
                "Folder could not be created and/or found in the selected path."
                , "Directory Error");
            health = 0;
        }
        return health;
    }

     /**
     * Get Directory Path
     * @return The full directory path. 
     */
    public static String getDirPath() {
        return dirPath;
    }
    
     /**
     * Get JFileChooser Status
     * @return The status of the file chooser. 
     */
    public int getJFileChooserStatus(){
        return jFileChooserStatus;
    }
}
