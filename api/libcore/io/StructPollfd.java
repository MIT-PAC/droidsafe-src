package libcore.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;




public final class StructPollfd {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "4ED9B7CD0F5862CC649C5C4B2E5F5F51")

    public FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_field = "16908B0605F2645DFCB4C3A8D248CEF3", hash_generated_field = "AD8CCCEA5DD927CFDD38AD64D7260A1F")

    public short events;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_field = "7C6F5B9F008B99872B2AFF44748410C8", hash_generated_field = "C9E09D1AC67432C58BB6B9E4573BBE5A")

    public short revents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "CB5AE7A6476A1E6BA040395757BE0AEE")

    public Object userData;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_method = "46E26FF7732270460330521087FDEE88", hash_generated_method = "46E26FF7732270460330521087FDEE88")
    public StructPollfd ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.801 -0400", hash_original_method = "A14B5D7144ADE29CBA1A23DAE6B04BC8", hash_generated_method = "C09B88E9366B716401C47351ADEEF190")
    @Override
    public String toString() {
String varD1A9934F92FC0D47E0956E235ABDEC62_687273017 =         "StructPollfd[fd=" + fd + ",events=" + events + ",revents=" + revents + "]";
        varD1A9934F92FC0D47E0956E235ABDEC62_687273017.addTaint(taint);
        return varD1A9934F92FC0D47E0956E235ABDEC62_687273017;
        // ---------- Original Method ----------
        //return "StructPollfd[fd=" + fd + ",events=" + events + ",revents=" + revents + "]";
    }

    
}

