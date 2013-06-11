package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class StructStatFs {
    public final long f_bsize;
    public final long f_blocks;
    public final long f_bfree;
    public final long f_bavail;
    public final long f_files;
    public final long f_ffree;
    public final long f_namemax;
    public final long f_frsize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.501 -0400", hash_original_method = "A2BBDE1C513EF61F7C6F88EB6F620A3C", hash_generated_method = "6620CF7B9EE72D07549BCE77E288ADC0")
    @DSModeled(DSC.SAFE)
     StructStatFs(long f_bsize, long f_blocks, long f_bfree, long f_bavail,
            long f_files, long f_ffree, long f_namemax, long f_frsize) {
        dsTaint.addTaint(f_blocks);
        dsTaint.addTaint(f_files);
        dsTaint.addTaint(f_ffree);
        dsTaint.addTaint(f_bsize);
        dsTaint.addTaint(f_frsize);
        dsTaint.addTaint(f_bfree);
        dsTaint.addTaint(f_namemax);
        dsTaint.addTaint(f_bavail);
        // ---------- Original Method ----------
        //this.f_bsize = f_bsize;
        //this.f_blocks = f_blocks;
        //this.f_bfree = f_bfree;
        //this.f_bavail = f_bavail;
        //this.f_files = f_files;
        //this.f_ffree = f_ffree;
        //this.f_namemax = f_namemax;
        //this.f_frsize = f_frsize;
    }

    
}


