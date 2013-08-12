package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.util.SneakyThrow;





public class FilterOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.991 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "F5E376611CAAF4EE829F9CD268525BC2")

    protected OutputStream out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.992 -0400", hash_original_method = "970F937F317FD0AE06FB76477C0F6F62", hash_generated_method = "F989161D9880425FAE37888895ADB2DD")
    @DSModeled(DSC.SAFE)
    public  FilterOutputStream(OutputStream out) {
        this.out = out;
        // ---------- Original Method ----------
        //this.out = out;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.992 -0400", hash_original_method = "C1E29F96DEA4D8E16CD646B2E66B7808", hash_generated_method = "AC13D11143D0A052A3D9F2A56DE4CE3B")
    @Override
    public void close() throws IOException {
        Throwable thrown = null;
        try 
        {
            flush();
        } //End block
        catch (Throwable e)
        {
            thrown = e;
        } //End block
        try 
        {
            out.close();
        } //End block
        catch (Throwable e)
        {
            if(thrown == null)            
            {
                thrown = e;
            } //End block
        } //End block
        if(thrown != null)        
        {
            SneakyThrow.sneakyThrow(thrown);
        } //End block
        // ---------- Original Method ----------
        //Throwable thrown = null;
        //try {
            //flush();
        //} catch (Throwable e) {
            //thrown = e;
        //}
        //try {
            //out.close();
        //} catch (Throwable e) {
            //if (thrown == null) {
                //thrown = e;
            //}
        //}
        //if (thrown != null) {
            //SneakyThrow.sneakyThrow(thrown);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.993 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "A2EF74EEF7203CB573D4B22064D57305")
    @Override
    public void flush() throws IOException {
        out.flush();
        // ---------- Original Method ----------
        //out.flush();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.994 -0400", hash_original_method = "6F432F0CBACFD3E73C2E675DFA6BA23C", hash_generated_method = "E3A5CF635677037D69531729E07E0E17")
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
for(int i = 0;i < length;i++)
        {
            write(buffer[offset + i]);
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //for (int i = 0; i < length; i++) {
            //write(buffer[offset + i]);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.994 -0400", hash_original_method = "10EC24027333F66A6325D4B91084AA70", hash_generated_method = "EBAE2AB4E266AF5ADD2FC53827D10E0A")
    @Override
    public void write(int oneByte) throws IOException {
        addTaint(oneByte);
        out.write(oneByte);
        // ---------- Original Method ----------
        //out.write(oneByte);
    }

    
}

