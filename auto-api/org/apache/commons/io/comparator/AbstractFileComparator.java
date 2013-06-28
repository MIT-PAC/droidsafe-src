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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.472 -0400", hash_original_method = "A3E60CF16B32C3551F5DB0B5E8FB592F", hash_generated_method = "A3E60CF16B32C3551F5DB0B5E8FB592F")
    public AbstractFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.473 -0400", hash_original_method = "8CDF48221E968696B6D0A82E43FAB730", hash_generated_method = "BC3C04DC4B0922C731B3A37B0811DBA8")
    public File[] sort(File... files) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_217706821 = null; //Variable for return #1
        {
            Arrays.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_217706821 = files;
        addTaint(files[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_217706821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_217706821;
        // ---------- Original Method ----------
        //if (files != null) {
            //Arrays.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.474 -0400", hash_original_method = "905EE6016178F91F1EDE19136C3B52C8", hash_generated_method = "5AB0B327AE00576A4779EDFEDC850A90")
    public List<File> sort(List<File> files) {
        List<File> varB4EAC82CA7396A68D541C85D26508E83_2096429079 = null; //Variable for return #1
        {
            Collections.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2096429079 = files;
        addTaint(files.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2096429079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096429079;
        // ---------- Original Method ----------
        //if (files != null) {
            //Collections.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.474 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "45641E92F6895EFCC48E721B27A3CF91")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1660212355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660212355 = getClass().getSimpleName();
        varB4EAC82CA7396A68D541C85D26508E83_1660212355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660212355;
        // ---------- Original Method ----------
        //return getClass().getSimpleName();
    }

    
}

