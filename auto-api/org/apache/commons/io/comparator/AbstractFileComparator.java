package org.apache.commons.io.comparator;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class AbstractFileComparator implements Comparator<File> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.316 -0400", hash_original_method = "A3E60CF16B32C3551F5DB0B5E8FB592F", hash_generated_method = "A3E60CF16B32C3551F5DB0B5E8FB592F")
    public AbstractFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.317 -0400", hash_original_method = "8CDF48221E968696B6D0A82E43FAB730", hash_generated_method = "CA2F3D5066FECFC16B9603EED36C70A2")
    public File[] sort(File... files) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_447135346 = null; //Variable for return #1
        {
            Arrays.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_447135346 = files;
        addTaint(files[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_447135346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_447135346;
        // ---------- Original Method ----------
        //if (files != null) {
            //Arrays.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.317 -0400", hash_original_method = "905EE6016178F91F1EDE19136C3B52C8", hash_generated_method = "28F8E112910E110CA20CE23466F9F163")
    public List<File> sort(List<File> files) {
        List<File> varB4EAC82CA7396A68D541C85D26508E83_1348671372 = null; //Variable for return #1
        {
            Collections.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1348671372 = files;
        addTaint(files.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1348671372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348671372;
        // ---------- Original Method ----------
        //if (files != null) {
            //Collections.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.318 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "D41DA43DF8A1188DBC6633B9B2BD8E24")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1281774814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1281774814 = getClass().getSimpleName();
        varB4EAC82CA7396A68D541C85D26508E83_1281774814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281774814;
        // ---------- Original Method ----------
        //return getClass().getSimpleName();
    }

    
}

