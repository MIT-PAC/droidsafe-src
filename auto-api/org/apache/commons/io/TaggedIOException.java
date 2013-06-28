package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.Serializable;

public class TaggedIOException extends IOExceptionWithCause {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.446 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "46DF86FF17DD00E0280EE95BAD31EE1B")

    private Serializable tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.447 -0400", hash_original_method = "AC74491EC46A5F4D5E2635850D49BE12", hash_generated_method = "E506C86846D9ADA25322BCDFFD1D8851")
    public  TaggedIOException(IOException original, Serializable tag) {
        super(original.getMessage(), original);
        this.tag = tag;
        addTaint(original.getTaint());
        // ---------- Original Method ----------
        //this.tag = tag;
    }

    
    public static boolean isTaggedWith(Throwable throwable, Object tag) {
        return tag != null
            && throwable instanceof TaggedIOException
            && tag.equals(((TaggedIOException) throwable).tag);
    }

    
    public static void throwCauseIfTaggedWith(Throwable throwable, Object tag) throws IOException {
        if (isTaggedWith(throwable, tag)) {
            throw ((TaggedIOException) throwable).getCause();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.448 -0400", hash_original_method = "4F4B9B983AF73239615D861FCC97BC71", hash_generated_method = "FB0340E1F3C10E00B6C046206D5DB1B4")
    public Serializable getTag() {
        Serializable varB4EAC82CA7396A68D541C85D26508E83_1912098909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1912098909 = tag;
        varB4EAC82CA7396A68D541C85D26508E83_1912098909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1912098909;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.449 -0400", hash_original_method = "5CB5049271906C3DE2CF2601187D937A", hash_generated_method = "92D6AED3EDF04FA74C980305C573C495")
    @Override
    public IOException getCause() {
        IOException varB4EAC82CA7396A68D541C85D26508E83_418461883 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_418461883 = (IOException) super.getCause();
        varB4EAC82CA7396A68D541C85D26508E83_418461883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418461883;
        // ---------- Original Method ----------
        //return (IOException) super.getCause();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.449 -0400", hash_original_field = "3CC20DF5D8A84A797FC8D0E0A5093EC1", hash_generated_field = "F26F0168B6E12A1D6C601DA33E32D966")

    private static final long serialVersionUID = -6994123481142850163L;
}

