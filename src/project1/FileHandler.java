package project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File Handler
 * This class provides all the necessary methods to 
 * create/read/write serial data and string text files.  
 */
public class FileHandler{
    //File Read/Writers
    FileWriter fw;
    
    //Full file path components.
    String filePath;
    final String logFile =  "\\Results.log";
    final String endln = System.getProperty( "line.separator" );
    
    /**
    * File Handler
    * This constructor ingests the verified root directory 
    * path chosen by the user and creates the log file. 
    * 1.  StringResults:  Read/conversion of SerialResults to string.
    * This constructor also initializes all read/writers for the 
    * operations.
    * <p>
    * File Path:
    * C:\<UserSelectedPath>\Results\SResults.log
    * <p>
    * Exception handling is thrown to SaveDataHandler.saveData();
    */
    FileHandler() throws IOException{
        filePath = DirectoryHandler.getDirPath() + logFile;
        fw = new FileWriter(filePath);
    }
        
    /**
     * Serial File Writer
     * This method reads the program held SerialResults.log 
     * file and converts the de-serialized objects to strings.  
     * The strings are then written to the StringResults.log file.  
     * <p>
     * Exception handling is completed locally.
     */
    public void wFile() {
        try{
            //Write file header data.
            fw.write(String.format("%tc", new Date()) + endln + endln); 
            fw.write("*** Raw Data Values ***" + endln);
            
            for(int i = 0; i < Calculator.numberList.size(); i++){
                String value = Calculator.numberList.get(i).toString();
                fw.append(value);
                fw.append(endln);
            } 

            //Append file footer data
            fw.append(endln);
            fw.append("*** Calculated Values ***" + endln);
            fw.append("Rounded Max:  "  + Calculator.getMax() + endln);
            fw.append("Rounded Min:  "  + Calculator.getMin() + endln);
            fw.append("Rounded Average:  "  + Calculator.getAverage() + endln);

            fw.close();

        } catch (IOException ex) {
            ioErrorMessage();
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * IO Error Message
    * This method calls the GUI error message handler.
    */
    private void ioErrorMessage(){
        HomeGUI.errMessage("File not found or corrupted. \n"
            + "Attempt to save again.", "File IO Error");
    }
}
            