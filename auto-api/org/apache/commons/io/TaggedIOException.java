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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.222 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "46DF86FF17DD00E0280EE95BAD31EE1B")

    private Serializable tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.222 -0400", hash_original_method = "AC74491EC46A5F4D5E2635850D49BE12", hash_generated_method = "E506C86846D9ADA25322BCDFFD1D8851")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.224 -0400", hash_original_method = "4F4B9B983AF73239615D861FCC97BC71", hash_generated_method = "20A3E5ED9E8CBAEF128E58739BD06AC4")
    public Serializable getTag() {
        Serializable varB4EAC82CA7396A68D541C85D26508E83_281473158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_281473158 = tag;
        varB4EAC82CA7396A68D541C85D26508E83_281473158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_281473158;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.232 -0400", hash_original_method = "5CB5049271906C3DE2CF2601187D937A", hash_generated_method = "F4A46D7E5548A75A247E53F3A447A801")
    @Override
    public IOException getCause() {
        IOException varB4EAC82CA7396A68D541C85D26508E83_1238989599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1238989599 = (IOException) super.getCause();
        varB4EAC82CA7396A68D541C85D26508E83_1238989599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1238989599;
        // ---------- Original Method ----------
        //return (IOException) super.getCause();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.243 -0400", hash_original_field = "3CC20DF5D8A84A797FC8D0E0A5093EC1", hash_generated_field = "1E112E82DB5FC4DAB6E3F4DF6508F4B9")

    private static long serialVersionUID = -6994123481142850163L;
}

