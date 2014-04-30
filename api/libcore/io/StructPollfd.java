package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;

public final class StructPollfd {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.184 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "4ED9B7CD0F5862CC649C5C4B2E5F5F51")

    public FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.186 -0500", hash_original_field = "273D8FB48892528212EED9DFB057B35D", hash_generated_field = "AD8CCCEA5DD927CFDD38AD64D7260A1F")

    public short events;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.188 -0500", hash_original_field = "4314AA1D2E8C5A91EC0704E0954B8F0D", hash_generated_field = "C9E09D1AC67432C58BB6B9E4573BBE5A")

    public short revents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.191 -0500", hash_original_field = "64F9C8FFBF59E1349A604124A0E0710A", hash_generated_field = "CB5AE7A6476A1E6BA040395757BE0AEE")

    public Object userData;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_method = "46E26FF7732270460330521087FDEE88", hash_generated_method = "46E26FF7732270460330521087FDEE88")
    public StructPollfd ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.193 -0500", hash_original_method = "A14B5D7144ADE29CBA1A23DAE6B04BC8", hash_generated_method = "C524CB084AA16F2A7514F3446CA9F741")
    
@Override public String toString() {
        return "StructPollfd[fd=" + fd + ",events=" + events + ",revents=" + revents + "]";
    }
    
}

