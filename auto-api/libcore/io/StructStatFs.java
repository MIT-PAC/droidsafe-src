package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructStatFs {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "F5384879ABDA803D556FB5514F2EE2DC", hash_generated_field = "393385A523174AFDB05044DC2616C489")

    public long f_bsize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "3340E3BECC748B61CA2849A22279195F", hash_generated_field = "73FDA67C9E7A32800F3A913EB375A8E2")

    public long f_blocks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "E625DA82DE8CE03A6B116CE1EF219D5D", hash_generated_field = "E81C53EE35DB89B361209151796230E4")

    public long f_bfree;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "B6972767FF01A4DDD1523C39C64D5854", hash_generated_field = "FAF44ECD212DFE0743EC8C276EFB3556")

    public long f_bavail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "0D78CEED2A7A2A06243B05AEE55722EC", hash_generated_field = "9AE73195774F4D82AB6BA86637F1BAC9")

    public long f_files;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "9B387E1909AB1DEC19F5299A20F61732", hash_generated_field = "CE00EA2D6772EDA745B9940E04BBFCD1")

    public long f_ffree;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "E0CFFCB44E4C35CBDAD8F63EE8B91C44", hash_generated_field = "260FCEB9BCA6D0EE0E63006473B1BDA2")

    public long f_namemax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.648 -0400", hash_original_field = "2CE563E34B3A0A72110AA21B46A8C740", hash_generated_field = "4DCD47127BE14BFAFAD60CAA185C09B4")

    public long f_frsize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.649 -0400", hash_original_method = "A2BBDE1C513EF61F7C6F88EB6F620A3C", hash_generated_method = "BD7647E8428982D10E703E25BB8BE610")
      StructStatFs(long f_bsize, long f_blocks, long f_bfree, long f_bavail,
            long f_files, long f_ffree, long f_namemax, long f_frsize) {
        this.f_bsize = f_bsize;
        this.f_blocks = f_blocks;
        this.f_bfree = f_bfree;
        this.f_bavail = f_bavail;
        this.f_files = f_files;
        this.f_ffree = f_ffree;
        this.f_namemax = f_namemax;
        this.f_frsize = f_frsize;
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

