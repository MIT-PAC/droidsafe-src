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

public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.379 -0400", hash_original_method = "08CA0A0311AD1ADA5A548E62ED6CB972", hash_generated_method = "08CA0A0311AD1ADA5A548E62ED6CB972")
    public LastModifiedFileComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.380 -0400", hash_original_method = "2A7F9A9DA1FD0DBF21511D990BEE362C", hash_generated_method = "DD7FD3B10C116362C23FB6A6DD1DDE80")
    public int compare(File file1, File file2) {
        long result;
        result = file1.lastModified() - file2.lastModified();
        addTaint(file1.getTaint());
        addTaint(file2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223128724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223128724;
        // ---------- Original Method ----------
        //long result = file1.lastModified() - file2.lastModified();
        //if (result < 0) {
            //return -1;
        //} else if (result > 0) {
            //return 1;
        //} else {
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.380 -0400", hash_original_field = "C583E64AED030B4460245F81988123C6", hash_generated_field = "94023D28CB355D93C34C3C54C9AD3C6F")

    public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.380 -0400", hash_original_field = "A4B7DC3B4C7BC72B5190030AE49FDBCB", hash_generated_field = "C065146AFEFC52527628CE9F33D912DD")

    public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseComparator(LASTMODIFIED_COMPARATOR);
}

