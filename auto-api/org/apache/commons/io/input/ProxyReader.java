package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public abstract class ProxyReader extends FilterReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.201 -0400", hash_original_method = "B02C906E6ABD17D05C219574C0B0E791", hash_generated_method = "1962D98F648B2D4130241C21DB88F8B5")
    public  ProxyReader(Reader proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.201 -0400", hash_original_method = "F5A2FF58A48B2EE55066C0DB2B9AC980", hash_generated_method = "61104A0D53268E5E816EC3E3836BE10B")
    @Override
    public int read() throws IOException {
        try 
        {
            beforeRead(1);
            int c = in.read();
            afterRead(c != -1 ? 1 : -1);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226298299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226298299;
        // ---------- Original Method ----------
        //try {
            //beforeRead(1);
            //int c = in.read();
            //afterRead(c != -1 ? 1 : -1);
            //return c;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.202 -0400", hash_original_method = "994E9DF4336B3658B3591197F683F468", hash_generated_method = "6C0F09298C14618E2238A614D5B64CAD")
    @Override
    public int read(char[] chr) throws IOException {
        try 
        {
            beforeRead(chr != null ? chr.length : 0);
            int n = in.read(chr);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951239215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951239215;
        // ---------- Original Method ----------
        //try {
            //beforeRead(chr != null ? chr.length : 0);
            //int n = in.read(chr);
            //afterRead(n);
            //return n;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.202 -0400", hash_original_method = "819423AAC8700E3137A36825F0D63A1E", hash_generated_method = "F6F7135B65C8C012BF6A55B64DBFF4FF")
    @Override
    public int read(char[] chr, int st, int len) throws IOException {
        try 
        {
            beforeRead(len);
            int n = in.read(chr, st, len);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        addTaint(st);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303408531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303408531;
        // ---------- Original Method ----------
        //try {
            //beforeRead(len);
            //int n = in.read(chr, st, len);
            //afterRead(n);
            //return n;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.203 -0400", hash_original_method = "6C91D7D5FFA64861FDFA028E5549C4E1", hash_generated_method = "3D42ABC0AE6CFA3ACB312817874E7C54")
    @Override
    public int read(CharBuffer target) throws IOException {
        try 
        {
            beforeRead(target != null ? target.length() : 0);
            int n = in.read(target);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437133994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437133994;
        // ---------- Original Method ----------
        //try {
            //beforeRead(target != null ? target.length() : 0);
            //int n = in.read(target);
            //afterRead(n);
            //return n;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.204 -0400", hash_original_method = "FA9F888D4C4D27A705AD6E4249FF9A0F", hash_generated_method = "E7F1545B06C80C055EBB7C5DBF3262C8")
    @Override
    public long skip(long ln) throws IOException {
        try 
        {
            long varC0E57140B7E797AC6EA3DD813ED9EFE9_2045459684 = (in.skip(ln));
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(ln);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_410951767 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_410951767;
        // ---------- Original Method ----------
        //try {
            //return in.skip(ln);
        //} catch (IOException e) {
            //handleIOException(e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.204 -0400", hash_original_method = "898ED87B3E2D635579A550CF0CA7DA33", hash_generated_method = "31D3588931CF4ACAC287DAEFCFB02F6F")
    @Override
    public boolean ready() throws IOException {
        try 
        {
            boolean var0C6F32F006D456011D89BF2F028E95C1_38729481 = (in.ready());
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909038282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_909038282;
        // ---------- Original Method ----------
        //try {
            //return in.ready();
        //} catch (IOException e) {
            //handleIOException(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.205 -0400", hash_original_method = "B82B927E9AF02AC9DAC77E074F6BBD30", hash_generated_method = "79D3FAF85F699F292722A00C560647B2")
    @Override
    public void close() throws IOException {
        try 
        {
            in.close();
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //in.close();
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.206 -0400", hash_original_method = "C433C94D03198733235CDD6598A695B3", hash_generated_method = "B1A6411193D9D70B81D4D714285367DA")
    @Override
    public synchronized void mark(int idx) throws IOException {
        try 
        {
            in.mark(idx);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(idx);
        // ---------- Original Method ----------
        //try {
            //in.mark(idx);
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.208 -0400", hash_original_method = "C1647ABF099BDE2A705C358E5A628D51", hash_generated_method = "A4E5357F2CD3B46277DB7DF26594836F")
    @Override
    public synchronized void reset() throws IOException {
        try 
        {
            in.reset();
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //in.reset();
        //} catch (IOException e) {
            //handleIOException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.208 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "9AF2BF4B873FE25C78F39B0FE8942B97")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_402325046 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062370735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062370735;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.210 -0400", hash_original_method = "5DF216E1C56E8B7D3C0329D45F13AA7E", hash_generated_method = "28D3B9351992F9F28F9CECA31092136A")
    protected void beforeRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.211 -0400", hash_original_method = "C3D8A276950C0BAD0FCEDE931894DAB6", hash_generated_method = "B16FA33AB801ACEFC1FBAD31FBEA502C")
    protected void afterRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.212 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //throw e;
    }

    
}

