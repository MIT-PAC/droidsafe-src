package org.apache.harmony.luni.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DeleteOnExit extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.248 -0400", hash_original_field = "C79C30DC0DDC0096B04E0C1DA71D54C1", hash_generated_field = "47F1474B6B515F8F9C9704A4267BE62A")

    private ArrayList<String> files = new ArrayList<String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.248 -0400", hash_original_method = "80FBB7FC28966FEC5371F3D04A9D4E08", hash_generated_method = "80FBB7FC28966FEC5371F3D04A9D4E08")
    public DeleteOnExit ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static synchronized DeleteOnExit getInstance() {
        if (instance == null) {
            instance = new DeleteOnExit();
            Runtime.getRuntime().addShutdownHook(instance);
        }
        return instance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.249 -0400", hash_original_method = "9511A18425627270E054955D67656A71", hash_generated_method = "B76F616B0E99FE92920E903A9D9A87E7")
    public void addFile(String filename) {
        {
            {
                boolean var0374181210025ADD06309071C5B32496_563753047 = (!files.contains(filename));
                {
                    files.add(filename);
                } 
            } 
        } 
        addTaint(filename.getTaint());
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.249 -0400", hash_original_method = "557595D78AF878757FA1B104BCD5B60F", hash_generated_method = "05C4BCFA7422DA613AED579FB5A8BBD6")
    @Override
    public void run() {
        Collections.sort(files);
        {
            int i = files.size() - 1;
            {
                new File(files.get(i)).delete();
            } 
        } 
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.249 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1D7484B2D124716E795B5B3B920FBF1B")

    private static DeleteOnExit instance;
}

