package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class FileDescriptor {
    public static final FileDescriptor in = new FileDescriptor();
    public static final FileDescriptor out = new FileDescriptor();
    public static final FileDescriptor err = new FileDescriptor();
    private int descriptor = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "69E84402B98FA692C1407F0A7BC6438C")
    @DSModeled(DSC.SAFE)
    public FileDescriptor() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "67B2C11B5FE6A2D570025ED863AA16D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "271099AE4F82D5B87E5410B6AC8C069E")
    @DSModeled(DSC.SAFE)
    public boolean valid() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return descriptor != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "D312A835A9BA2AAB1BB2182D56FA0271")
    @DSModeled(DSC.SAFE)
    public final int getInt$() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return descriptor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "B5137D2495AA2349D450595363CF06EA")
    @DSModeled(DSC.SAFE)
    public final void setInt$(int fd) {
        dsTaint.addTaint(fd);
        // ---------- Original Method ----------
        //this.descriptor = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.450 -0400", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "EBCEDA8CD3EFE1D9511BFF0F120D45B3")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "FileDescriptor[" + descriptor + "]";
    }

    
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}


