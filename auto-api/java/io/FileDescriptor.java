package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class FileDescriptor {
    private int descriptor = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.758 -0400", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "85C5A980A68C0ECABEB30B9F109CBB75")
    @DSModeled(DSC.SAFE)
    public FileDescriptor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.759 -0400", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "25AFC79BFB4F60369D19193124ED8FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sync() throws SyncFailedException {
        try 
        {
            Libcore.os.fsync(this);
        } //End block
        catch (ErrnoException errnoException)
        {
            SyncFailedException sfe;
            sfe = new SyncFailedException(errnoException.getMessage());
            sfe.initCause(errnoException);
            if (DroidSafeAndroidRuntime.control) throw sfe;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.759 -0400", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "D5EF63AEAD45CA3234C810DB1C2B53DB")
    @DSModeled(DSC.SAFE)
    public boolean valid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return descriptor != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.759 -0400", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "C0051E1BEAF2FB59FB313CD912D587AE")
    @DSModeled(DSC.SAFE)
    public final int getInt$() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.759 -0400", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "A90BEE4ADE52124B3CAF6DF3D5452169")
    @DSModeled(DSC.SAFE)
    public final void setInt$(int fd) {
        dsTaint.addTaint(fd);
        // ---------- Original Method ----------
        //this.descriptor = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.759 -0400", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "AB56E77FDAA9F73420D4617665E5E126")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "FileDescriptor[" + descriptor + "]";
    }

    
    public static final FileDescriptor in = new FileDescriptor();
    public static final FileDescriptor out = new FileDescriptor();
    public static final FileDescriptor err = new FileDescriptor();
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}

