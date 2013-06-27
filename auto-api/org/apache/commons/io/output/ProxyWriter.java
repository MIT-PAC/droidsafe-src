package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class ProxyWriter extends FilterWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.527 -0400", hash_original_method = "033B4CFD391086531B126612D5903ED1", hash_generated_method = "D79CCC2D9701130EB837876E07EFC628")
    public  ProxyWriter(Writer proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.531 -0400", hash_original_method = "94E64203D23ECC11F0966710C23548F3", hash_generated_method = "408CCBE36FC1A70D968F4FE977AED1F6")
    @Override
    public Writer append(char c) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_909514771 = null; //Variable for return #1
        try 
        {
            beforeWrite(1);
            out.append(c);
            afterWrite(1);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_909514771 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_909514771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909514771;
        // ---------- Original Method ----------
        //try {
            //beforeWrite(1);
            //out.append(c);
            //afterWrite(1);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.532 -0400", hash_original_method = "391E9756F83F23FF347EF2129E3A0E99", hash_generated_method = "A9A2775C889758768465BAFB17E2B54B")
    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_1226974521 = null; //Variable for return #1
        try 
        {
            beforeWrite(end - start);
            out.append(csq, start, end);
            afterWrite(end - start);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1226974521 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1226974521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226974521;
        // ---------- Original Method ----------
        //try {
            //beforeWrite(end - start);
            //out.append(csq, start, end);
            //afterWrite(end - start);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.546 -0400", hash_original_method = "AF511130F35AA3E3B287C842560F9DCE", hash_generated_method = "C90A1B875B3346812FA25DE50751721B")
    @Override
    public Writer append(CharSequence csq) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_1743493448 = null; //Variable for return #1
        try 
        {
            int len;
            len = 0;
            {
                len = csq.length();
            } //End block
            beforeWrite(len);
            out.append(csq);
            afterWrite(len);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1743493448 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1743493448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1743493448;
        // ---------- Original Method ----------
        //try {
            //int len = 0;
            //if (csq != null) {
                //len = csq.length();
            //}
            //beforeWrite(len);
            //out.append(csq);
            //afterWrite(len);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.554 -0400", hash_original_method = "C10E35B15C5C34D2F11AD8F56A8AFBE7", hash_generated_method = "1EB9322108467DA4C5247F7E457F7B02")
    @Override
    public void write(int idx) throws IOException {
        try 
        {
            beforeWrite(1);
            out.write(idx);
            afterWrite(1);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(idx);
        // ---------- Original Method ----------
        //try {
            //beforeWrite(1);
            //out.write(idx);
            //afterWrite(1);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.554 -0400", hash_original_method = "579B5F1267C3E5A23AE0501F4C0FD567", hash_generated_method = "5202EA8B0380C002D6BE26D1FABA6965")
    @Override
    public void write(char[] chr) throws IOException {
        try 
        {
            int len;
            len = 0;
            {
                len = chr.length;
            } //End block
            beforeWrite(len);
            out.write(chr);
            afterWrite(len);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        // ---------- Original Method ----------
        //try {
            //int len = 0;
            //if (chr != null) {
                //len = chr.length;
            //}
            //beforeWrite(len);
            //out.write(chr);
            //afterWrite(len);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.555 -0400", hash_original_method = "4BD1C735F7EB97F1200118825DBDCCC5", hash_generated_method = "BDD9621D828C3C2E87093A69A4AFBFEE")
    @Override
    public void write(char[] chr, int st, int len) throws IOException {
        try 
        {
            beforeWrite(len);
            out.write(chr, st, len);
            afterWrite(len);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        addTaint(st);
        addTaint(len);
        // ---------- Original Method ----------
        //try {
            //beforeWrite(len);
            //out.write(chr, st, len);
            //afterWrite(len);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.556 -0400", hash_original_method = "6B60D7F6AE629840306B83B2B10FEDBF", hash_generated_method = "8102FC18925A0D5F4A9B5EFF45AAF654")
    @Override
    public void write(String str) throws IOException {
        try 
        {
            int len;
            len = 0;
            {
                len = str.length();
            } //End block
            beforeWrite(len);
            out.write(str);
            afterWrite(len);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //try {
            //int len = 0;
            //if (str != null) {
                //len = str.length();
            //}
            //beforeWrite(len);
            //out.write(str);
            //afterWrite(len);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.556 -0400", hash_original_method = "E5A50F6C55F59DD4142D90322431FA35", hash_generated_method = "D7C81C5C2B0EF2B381B61B35680E64DF")
    @Override
    public void write(String str, int st, int len) throws IOException {
        try 
        {
            beforeWrite(len);
            out.write(str, st, len);
            afterWrite(len);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(str.getTaint());
        addTaint(st);
        addTaint(len);
        // ---------- Original Method ----------
        //try {
            //beforeWrite(len);
            //out.write(str, st, len);
            //afterWrite(len);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.557 -0400", hash_original_method = "EEECDB779BCD3F1C16C4BB7414585E36", hash_generated_method = "F4E2890B99E6EE56D25924404E914D4A")
    @Override
    public void flush() throws IOException {
        try 
        {
            out.flush();
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //out.flush();
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.557 -0400", hash_original_method = "EA1F98341C1FEBB76DE541E0DAA4DDD0", hash_generated_method = "4AEAE5624C359BC6B9AE60F5188C3A93")
    @Override
    public void close() throws IOException {
        try 
        {
            out.close();
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //out.close();
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.558 -0400", hash_original_method = "961C14EE073174624B2AA02C565F3907", hash_generated_method = "2210B044857E5790E2031B7C253A923D")
    protected void beforeWrite(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.558 -0400", hash_original_method = "634EDAC0BBD2C7E1FA3D5BDE9765B3F8", hash_generated_method = "9127223EA27B492B068981CDBB807693")
    protected void afterWrite(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.568 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //throw e;
    }

    
}

