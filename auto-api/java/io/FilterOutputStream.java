package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import libcore.util.SneakyThrow;

public class FilterOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.913 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "F5E376611CAAF4EE829F9CD268525BC2")

    protected OutputStream out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.913 -0400", hash_original_method = "970F937F317FD0AE06FB76477C0F6F62", hash_generated_method = "F989161D9880425FAE37888895ADB2DD")
    public  FilterOutputStream(OutputStream out) {
        this.out = out;
        // ---------- Original Method ----------
        //this.out = out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.914 -0400", hash_original_method = "C1E29F96DEA4D8E16CD646B2E66B7808", hash_generated_method = "DED80C76F2DDAD8BB057F50B48C2882B")
    @Override
    public void close() throws IOException {
        Throwable thrown;
        thrown = null;
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
            {
                thrown = e;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.914 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "A2EF74EEF7203CB573D4B22064D57305")
    @Override
    public void flush() throws IOException {
        out.flush();
        // ---------- Original Method ----------
        //out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.914 -0400", hash_original_method = "6F432F0CBACFD3E73C2E675DFA6BA23C", hash_generated_method = "4F8667CAC7E44A67C6DAB06530E69651")
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            int i;
            i = 0;
            {
                write(buffer[offset + i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //for (int i = 0; i < length; i++) {
            //write(buffer[offset + i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.914 -0400", hash_original_method = "10EC24027333F66A6325D4B91084AA70", hash_generated_method = "8D7C17AF8B5A147E6248279AD64AC877")
    @Override
    public void write(int oneByte) throws IOException {
        out.write(oneByte);
        addTaint(oneByte);
        // ---------- Original Method ----------
        //out.write(oneByte);
    }

    
}

