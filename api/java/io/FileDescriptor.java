package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.STDERR_FILENO;
import static libcore.io.OsConstants.STDIN_FILENO;
import static libcore.io.OsConstants.STDOUT_FILENO;
import libcore.io.ErrnoException;
import libcore.io.Libcore;





public final class FileDescriptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.868 -0400", hash_original_field = "AFBBCDF48BBBB69A1D97A2B7954DC265", hash_generated_field = "AD84990C5A466F07845F94B14109703E")

    @DSVAModeled
    private int descriptor = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.868 -0400", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "85C5A980A68C0ECABEB30B9F109CBB75")
    @DSModeled(DSC.SAFE)
    public  FileDescriptor() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.868 -0400", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "C2587BEEF8DEA4653584F96F41AABBE4")
    public void sync() throws SyncFailedException {
        try 
        {
            Libcore.os.fsync(this);
        } //End block
        catch (ErrnoException errnoException)
        {
            SyncFailedException sfe = new SyncFailedException(errnoException.getMessage());
            sfe.initCause(errnoException);
            sfe.addTaint(taint);
            throw sfe;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.fsync(this);
        //} catch (ErrnoException errnoException) {
            //SyncFailedException sfe = new SyncFailedException(errnoException.getMessage());
            //sfe.initCause(errnoException);
            //throw sfe;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.869 -0400", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "6B54D15145E3FA084122E43925F70C16")
    public boolean valid() {
        boolean var0BAE74BB13337C9C944836840E955185_354885301 = (descriptor != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858377194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858377194;
        // ---------- Original Method ----------
        //return descriptor != -1;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.869 -0400", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "D6B812BE5B1DF5CB286DC57F6BA8FCCC")
    public final int getInt$() {
        int varDA3F6396C032B006442940855C25DFD8_1635296081 = (descriptor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843501575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843501575;
        // ---------- Original Method ----------
        //return descriptor;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.869 -0400", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "9CD3F8ACD13BA5BC1DEAE478056B0187")
    public final void setInt$(int fd) {
        this.descriptor = fd;
        // ---------- Original Method ----------
        //this.descriptor = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.870 -0400", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "F27413CF6C3AEDF18B37C4E67D2E6901")
    @Override
    public String toString() {
String var8713B91960E758C158A8CA2A1C6D8555_1633688236 =         "FileDescriptor[" + descriptor + "]";
        var8713B91960E758C158A8CA2A1C6D8555_1633688236.addTaint(taint);
        return var8713B91960E758C158A8CA2A1C6D8555_1633688236;
        // ---------- Original Method ----------
        //return "FileDescriptor[" + descriptor + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.870 -0400", hash_original_field = "7676E3B9130801538577AFE480937409", hash_generated_field = "C19A0692982848458993186E6FD00EBE")

    public static final FileDescriptor in = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.870 -0400", hash_original_field = "3FBE3ACD5C7F74E400CC727D35F8EDD1", hash_generated_field = "D147B1CB00E288088DE893A1ECDA0D51")

    public static final FileDescriptor out = new FileDescriptor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.870 -0400", hash_original_field = "EDC700597AEE331203E95690400900DC", hash_generated_field = "B493CA9CC8E849FAF1BEFA5E04A026DF")

    public static final FileDescriptor err = new FileDescriptor();
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}

