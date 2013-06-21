package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;

public final class StructPollfd {
    public FileDescriptor fd;
    public short events;
    public short revents;
    public Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.021 -0400", hash_original_method = "95F6E4F4D73744F4B00CE9BA272ADB86", hash_generated_method = "95F6E4F4D73744F4B00CE9BA272ADB86")
        public StructPollfd ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.021 -0400", hash_original_method = "A14B5D7144ADE29CBA1A23DAE6B04BC8", hash_generated_method = "C14BA7302C38D106F0A551F23638035D")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StructPollfd[fd=" + fd + ",events=" + events + ",revents=" + revents + "]";
    }

    
}

