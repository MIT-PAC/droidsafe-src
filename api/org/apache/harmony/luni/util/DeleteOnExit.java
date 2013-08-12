package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;




public class DeleteOnExit extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.039 -0400", hash_original_field = "C79C30DC0DDC0096B04E0C1DA71D54C1", hash_generated_field = "47F1474B6B515F8F9C9704A4267BE62A")

    private ArrayList<String> files = new ArrayList<String>();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.039 -0400", hash_original_method = "80FBB7FC28966FEC5371F3D04A9D4E08", hash_generated_method = "80FBB7FC28966FEC5371F3D04A9D4E08")
    public DeleteOnExit ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static synchronized DeleteOnExit getInstance() {
        if (instance == null) {
            instance = new DeleteOnExit();
            Runtime.getRuntime().addShutdownHook(instance);
        }
        return instance;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.040 -0400", hash_original_method = "9511A18425627270E054955D67656A71", hash_generated_method = "7D6E107248AD3EDA0A89EA0026A6BAAB")
    public void addFile(String filename) {
        addTaint(filename.getTaint());
        synchronized
(files)        {
            if(!files.contains(filename))            
            {
                files.add(filename);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(files) {
            //if (!files.contains(filename)) {
                //files.add(filename);
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.040 -0400", hash_original_method = "557595D78AF878757FA1B104BCD5B60F", hash_generated_method = "CD59D5F997E2C9D76EC29E08D774C012")
    @Override
    public void run() {
        Collections.sort(files);
for(int i = files.size() - 1;i >= 0;i--)
        {
            new File(files.get(i)).delete();
        } //End block
        // ---------- Original Method ----------
        //Collections.sort(files);
        //for (int i = files.size() - 1; i >= 0; i--) {
            //new File(files.get(i)).delete();
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.040 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "1D7484B2D124716E795B5B3B920FBF1B")

    private static DeleteOnExit instance;
}

