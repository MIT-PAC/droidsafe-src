package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class OutputStream implements Closeable, Flushable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.729 -0400", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "2C31F8243BA27BC77BDF1F7D706C34CB")
    public  OutputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.729 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.729 -0400", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "05987DDDCDD862E2FBC121135A80FA74")
    public void flush() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.730 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "9CF54F5514EB45305F74BC43AC7A8B7B")
    public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.730 -0400", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "3D05FB186CADC84D954A69F99EE14795")
    public void write(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            int i = offset;
            {
                write(buffer[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //for (int i = offset; i < offset + count; i++) {
            //write(buffer[i]);
        //}
    }

    
    public abstract void write(int oneByte) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.730 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "41A04104132C5C1DFBD9D0F81F2973D9")
     boolean checkError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649951112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649951112;
        // ---------- Original Method ----------
        //return false;
    }

    
}

