package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public abstract class OutputStream implements Closeable, Flushable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "5AFBBDC388D82721219F0E4231328848")
    @DSModeled(DSC.SAFE)
    public OutputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "21115B8151778BA3C6136A3C8DA8EA25")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "FA0415363B44AE43498BD49CE614E91B")
    @DSModeled(DSC.SAFE)
    public void flush() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "BD4CBDB7F6953C5B04B1698E514A1872")
    @DSModeled(DSC.SAFE)
    public void write(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "62A45509641AA1DFA21A1D090A45C484")
    @DSModeled(DSC.SAFE)
    public void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.642 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "72670A334E89D74D531B4ECE74FAA78A")
    @DSModeled(DSC.SAFE)
     boolean checkError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


