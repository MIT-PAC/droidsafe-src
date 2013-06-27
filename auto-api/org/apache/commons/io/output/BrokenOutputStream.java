package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public class BrokenOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.321 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "0AF882C2A99BE536634D8324F0026FC7")

    private IOException exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.322 -0400", hash_original_method = "DC14AD217499C73BF2ED5ED6A0A09FC7", hash_generated_method = "B583450364F55E98B5A147E20626DCBB")
    public  BrokenOutputStream(IOException exception) {
        this.exception = exception;
        // ---------- Original Method ----------
        //this.exception = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.322 -0400", hash_original_method = "59CC42DFD0763C2AECC76B7A8477456C", hash_generated_method = "477B6B0CECA3F8A2CDE7D14FA39961FE")
    public  BrokenOutputStream() {
        this(new IOException("Broken output stream"));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.322 -0400", hash_original_method = "AF68FB9108929D9CC8AF2DAD857DF91D", hash_generated_method = "C21AC761EFBE347F255D89D7612E8847")
    @Override
    public void write(int b) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        addTaint(b);
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.323 -0400", hash_original_method = "2F30F2D964E96D4253E7019EBAE48140", hash_generated_method = "D720B8B4685C1A3032A6C9EED4EB35AD")
    @Override
    public void flush() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.323 -0400", hash_original_method = "CEF9D34BF3086FDA40BC370A70DF5AD2", hash_generated_method = "CD44425886925F374C1CABFFFBF1F1AD")
    @Override
    public void close() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        // ---------- Original Method ----------
        //throw exception;
    }

    
}

