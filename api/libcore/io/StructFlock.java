package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public final class StructFlock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.436 -0500", hash_original_field = "195DBF6C9F07DA1D55577092198A87FA", hash_generated_field = "F9D431F6400B333E4DEC5C071DC91AEB")

    public short l_type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.439 -0500", hash_original_field = "F08ADF56A835E767C27635F2587B9464", hash_generated_field = "0463453A1AA9CF88BDF12C2A0B513A73")

    public short l_whence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.441 -0500", hash_original_field = "92BFDEF8DC1A6D45DA6A60AA6A1C1BA2", hash_generated_field = "0348CDD1CD8793E70282CBBC56AD1394")

    public long l_start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.443 -0500", hash_original_field = "BC96892751020D7ACFD00E2D350DE668", hash_generated_field = "7D66A4AF407BCCCD334EC982CFAE22BF")


    /** Byte count to operate on. */
    public long l_len;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.445 -0500", hash_original_field = "EF00B22C10DD3F1951DAFDD4F788B882", hash_generated_field = "DF56723A36435A1A3E6E9853DC718F84")


    /** Process blocking our lock (filled in by F_GETLK, otherwise unused). */
    public int l_pid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.794 -0400", hash_original_method = "DFA63A134B73478BDD4F5CF409821F5F", hash_generated_method = "DFA63A134B73478BDD4F5CF409821F5F")
    public StructFlock ()
    {
        //Synthesized constructor
    }


}

