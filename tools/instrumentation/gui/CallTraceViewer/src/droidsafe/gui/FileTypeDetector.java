/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 *
 * @author Nguyen Nguyen
 */
public class FileTypeDetector {
    public static enum FileType {
        UNKNOWN,
        CLASSIFCATION,
        CALLTRACE
    }
    
    private FileTypeDetector() {}
    
    private static FileTypeDetector instance = new FileTypeDetector();
    
    public static FileTypeDetector v() { return instance; }
    
    /**
     * method to determine the file type
     * @param file
     * @return 
     */
    public FileType getFileType(File file) {
        FileType type = FileType.UNKNOWN;
        
        try {
            FileInputStream is = new FileInputStream(file);            
        }
        
        catch (Exception ex){
            
        }
        
        return type;
    }
    
    public FileType getFileType(List<String> contentLines) {
        FileType type = FileType.UNKNOWN;
        
        int  count = 0;
        for (String line:  contentLines){
            if (count++ > 100)
                break;
            
            if (line.contains("DSI")) {
                return FileType.CALLTRACE;
            }
            
            if (line.contains("@DS") || line.contains("NO_INFO") ||
                line.contains("UNCLASSIFIED")) {
                return FileType.CLASSIFCATION;
            }
        }
                
        return type;
    }
    
}
