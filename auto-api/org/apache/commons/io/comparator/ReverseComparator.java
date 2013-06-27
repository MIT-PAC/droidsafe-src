package org.apache.commons.io.comparator;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class ReverseComparator extends AbstractFileComparator implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.401 -0400", hash_original_field = "7F662005788AB434B371FBB0EFC6D45F", hash_generated_field = "8E91842B65FD0EE8A0384B6BD2C7B49A")

    private Comparator<File> delegate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.402 -0400", hash_original_method = "15DF831649D5DCA7131B2AF990D917CB", hash_generated_method = "90BD9B0A424C79966396186D07A9410B")
    public  ReverseComparator(Comparator<File> delegate) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Delegate comparator is missing");
        } //End block
        this.delegate = delegate;
        // ---------- Original Method ----------
        //if (delegate == null) {
            //throw new IllegalArgumentException("Delegate comparator is missing");
        //}
        //this.delegate = delegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.402 -0400", hash_original_method = "F10F7743D97AD6B571D16076EE2F8E5C", hash_generated_method = "1CF1E2B0051A7B396BC3D221FC5ACDDF")
    public int compare(File file1, File file2) {
        int var0036CE19F0F0040F7CAEF9A4AB3A7FDC_126223980 = (delegate.compare(file2, file1));
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961422443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961422443;
        // ---------- Original Method ----------
        //return delegate.compare(file2, file1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.412 -0400", hash_original_method = "A7C889B68BCBEC308734FF9FD7CA04D8", hash_generated_method = "4FCD58A8DBFEF113D57B30290326AA41")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1285845226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1285845226 = super.toString() + "[" + delegate.toString() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1285845226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285845226;
        // ---------- Original Method ----------
        //return super.toString() + "[" + delegate.toString() + "]";
    }

    
}

