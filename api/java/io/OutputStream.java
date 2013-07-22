package java.io;

// Droidsafe Imports
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class OutputStream implements Closeable, Flushable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.069 -0400", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "2C31F8243BA27BC77BDF1F7D706C34CB")
    @DSModeled(DSC.SAFE)
    public  OutputStream() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.069 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.069 -0400", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "05987DDDCDD862E2FBC121135A80FA74")
    public void flush() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.070 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "C874A8F3DD1DC4618E30BFCFA3F99F15")
    public void write(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.071 -0400", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "E5728D1F2D8DFD725F7F880C874F1A96")
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
for(int i = offset;i < offset + count;i++)
        {
            write(buffer[i]);
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //for (int i = offset; i < offset + count; i++) {
            //write(buffer[i]);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void write(int oneByte) throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.071 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "B9162C3B7CDFDD8373475FD7D078C18F")
     boolean checkError() {
        boolean var68934A3E9455FA72420237EB05902327_1099637139 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297607398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297607398;
        // ---------- Original Method ----------
        //return false;
    }

    
}

