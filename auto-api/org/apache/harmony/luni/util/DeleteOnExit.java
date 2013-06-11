package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DeleteOnExit extends Thread {
    private static DeleteOnExit instance;
    private ArrayList<String> files = new ArrayList<String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.588 -0400", hash_original_method = "5F2B916DEBE9B88C4D0351AB645CF666", hash_generated_method = "D55E2D40C001CB12E806F853D6224C5F")
    public static synchronized DeleteOnExit getInstance() {
        if (instance == null) {
            instance = new DeleteOnExit();
            Runtime.getRuntime().addShutdownHook(instance);
        }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.588 -0400", hash_original_method = "9511A18425627270E054955D67656A71", hash_generated_method = "A6693430B9DC34156E30201EA7208C4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFile(String filename) {
        dsTaint.addTaint(filename);
        {
            {
                boolean var0374181210025ADD06309071C5B32496_367388527 = (!files.contains(filename));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.588 -0400", hash_original_method = "557595D78AF878757FA1B104BCD5B60F", hash_generated_method = "3023043BD1341029BB336636231D1511")
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

    
}


