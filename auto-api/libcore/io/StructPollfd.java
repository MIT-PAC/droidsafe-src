package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;

public final class StructPollfd {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.497 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "4ED9B7CD0F5862CC649C5C4B2E5F5F51")

    public FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.497 -0400", hash_original_field = "16908B0605F2645DFCB4C3A8D248CEF3", hash_generated_field = "AD8CCCEA5DD927CFDD38AD64D7260A1F")

    public short events;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.497 -0400", hash_original_field = "7C6F5B9F008B99872B2AFF44748410C8", hash_generated_field = "C9E09D1AC67432C58BB6B9E4573BBE5A")

    public short revents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.497 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "CB5AE7A6476A1E6BA040395757BE0AEE")

    public Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.497 -0400", hash_original_method = "46E26FF7732270460330521087FDEE88", hash_generated_method = "46E26FF7732270460330521087FDEE88")
    public StructPollfd ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.498 -0400", hash_original_method = "A14B5D7144ADE29CBA1A23DAE6B04BC8", hash_generated_method = "8D0D022D552C9782B525F57A52E7E604")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1744072669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1744072669 = "StructPollfd[fd=" + fd + ",events=" + events + ",revents=" + revents + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1744072669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1744072669;
        
        
    }

    
}

