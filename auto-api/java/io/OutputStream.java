package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class OutputStream implements Closeable, Flushable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.184 -0400", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "2C31F8243BA27BC77BDF1F7D706C34CB")
    @DSModeled(DSC.SAFE)
    public OutputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.184 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.185 -0400", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "05987DDDCDD862E2FBC121135A80FA74")
    @DSModeled(DSC.SAFE)
    public void flush() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.185 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "79277C5A941CF35D871B53A2B17A5D22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.185 -0400", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "C74F6034915EDC1A1C85200A861C746A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            int i;
            i = offset;
            {
                write(buffer[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //for (int i = offset; i < offset + count; i++) {
            //write(buffer[i]);
        //}
    }

    
    public abstract void write(int oneByte) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.185 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "FDE27047AB1931599767795C9C8BC350")
    @DSModeled(DSC.SAFE)
     boolean checkError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

