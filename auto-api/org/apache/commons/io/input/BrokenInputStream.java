package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class BrokenInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.890 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "0AF882C2A99BE536634D8324F0026FC7")

    private IOException exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.891 -0400", hash_original_method = "25F9B147A640764BAD5A91174402EA28", hash_generated_method = "BF8AA24429B4877C16CC9622C8BC976B")
    public  BrokenInputStream(IOException exception) {
        this.exception = exception;
        // ---------- Original Method ----------
        //this.exception = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.892 -0400", hash_original_method = "007AAB59B3A8E9E189A528ECE8101DA6", hash_generated_method = "E68852BCA60B9DB97770C951544E5F82")
    public  BrokenInputStream() {
        this(new IOException("Broken input stream"));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.892 -0400", hash_original_method = "28F9C38B3FDDDB64FC933645C8F9DFA7", hash_generated_method = "4C3E7C0A8CF30DAD1D724971631D3DC3")
    @Override
    public int read() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800495800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800495800;
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.892 -0400", hash_original_method = "F031365D6E829A45B7583B6D22A26F0A", hash_generated_method = "ACEB33DCA36B3AEAAC604EB365D63F10")
    @Override
    public int available() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460495590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460495590;
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.901 -0400", hash_original_method = "CAAF4DC59EF8C31987E09418AE767741", hash_generated_method = "D132B8814F1CB054C453486FDBC0EFD9")
    @Override
    public long skip(long n) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1461453248 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1461453248;
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.902 -0400", hash_original_method = "0FA8319FDCFD8207BDB70BAA26E790B7", hash_generated_method = "2F1AA3D82CFD667FC33A4892CA77973C")
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        // ---------- Original Method ----------
        //throw exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.902 -0400", hash_original_method = "CEF9D34BF3086FDA40BC370A70DF5AD2", hash_generated_method = "CD44425886925F374C1CABFFFBF1F1AD")
    @Override
    public void close() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw exception;
        // ---------- Original Method ----------
        //throw exception;
    }

    
}

