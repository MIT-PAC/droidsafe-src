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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.267 -0400", hash_original_method = "A3E60CF16B32C3551F5DB0B5E8FB592F", hash_generated_method = "A3E60CF16B32C3551F5DB0B5E8FB592F")
    public AbstractFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.288 -0400", hash_original_method = "8CDF48221E968696B6D0A82E43FAB730", hash_generated_method = "9ACFD9AF8DAFD459634CFF80C8969505")
    public File[] sort(File... files) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_658497843 = null; //Variable for return #1
        {
            Arrays.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_658497843 = files;
        addTaint(files[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_658497843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658497843;
        // ---------- Original Method ----------
        //if (files != null) {
            //Arrays.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.288 -0400", hash_original_method = "905EE6016178F91F1EDE19136C3B52C8", hash_generated_method = "9596CC530A46ECFA9A7DB33AC6F623F5")
    public List<File> sort(List<File> files) {
        List<File> varB4EAC82CA7396A68D541C85D26508E83_1089851040 = null; //Variable for return #1
        {
            Collections.sort(files, this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1089851040 = files;
        addTaint(files.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1089851040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1089851040;
        // ---------- Original Method ----------
        //if (files != null) {
            //Collections.sort(files, this);
        //}
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.290 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "8793C49859397FE75E53897A5F37D4A1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_479410786 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_479410786 = getClass().getSimpleName();
        varB4EAC82CA7396A68D541C85D26508E83_479410786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_479410786;
        // ---------- Original Method ----------
        //return getClass().getSimpleName();
    }

    
}

