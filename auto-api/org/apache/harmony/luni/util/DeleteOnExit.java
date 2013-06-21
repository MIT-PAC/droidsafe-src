package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DeleteOnExit extends Thread {
    private ArrayList<String> files = new ArrayList<String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.857 -0400", hash_original_method = "27EE8DBC151FD7836632EA2F5F9AC7C2", hash_generated_method = "27EE8DBC151FD7836632EA2F5F9AC7C2")
        public DeleteOnExit ()
    {
    }


        public static synchronized DeleteOnExit getInstance() {
        if (instance == null) {
            instance = new DeleteOnExit();
            Runtime.getRuntime().addShutdownHook(instance);
        }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.857 -0400", hash_original_method = "9511A18425627270E054955D67656A71", hash_generated_method = "734422B3564110FA8E70824F96ABC6F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFile(String filename) {
        dsTaint.addTaint(filename);
        {
            {
                boolean var0374181210025ADD06309071C5B32496_95209715 = (!files.contains(filename));
                {
                    files.add(filename);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(files) {
            //if (!files.contains(filename)) {
                //files.add(filename);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.858 -0400", hash_original_method = "557595D78AF878757FA1B104BCD5B60F", hash_generated_method = "F8EAE86D111CF60BDECD596F6CA5A065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void run() {
        Collections.sort(files);
        {
            int i;
            i = files.size() - 1;
            {
                new File(files.get(i)).delete();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Collections.sort(files);
        //for (int i = files.size() - 1; i >= 0; i--) {
            //new File(files.get(i)).delete();
        //}
    }

    
    private static DeleteOnExit instance;
}

