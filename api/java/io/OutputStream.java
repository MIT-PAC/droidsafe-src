package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class OutputStream implements Closeable, Flushable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.502 -0400", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "2C31F8243BA27BC77BDF1F7D706C34CB")
    public  OutputStream() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.502 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    public void close() throws IOException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.503 -0400", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "05987DDDCDD862E2FBC121135A80FA74")
    public void flush() throws IOException {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.503 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "C874A8F3DD1DC4618E30BFCFA3F99F15")
    public void write(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.504 -0400", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "E5728D1F2D8DFD725F7F880C874F1A96")
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
for(int i = offset;i < offset + count;i++)
        {
            write(buffer[i]);
        } 
        
        
        
            
        
    }

    
    public abstract void write(int oneByte) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.505 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "10DF48273EAB503E1C1A258921C8C704")
     boolean checkError() {
        boolean var68934A3E9455FA72420237EB05902327_1401244965 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401878188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401878188;
        
        
    }

    
}

