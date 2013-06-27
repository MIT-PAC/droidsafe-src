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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.028 -0400", hash_original_method = "B02C906E6ABD17D05C219574C0B0E791", hash_generated_method = "1962D98F648B2D4130241C21DB88F8B5")
    public  ProxyReader(Reader proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.028 -0400", hash_original_method = "F5A2FF58A48B2EE55066C0DB2B9AC980", hash_generated_method = "2285363DB4A5EE19A8AFDB2D5DDED73B")
    @Override
    public int read() throws IOException {
        try 
        {
            beforeRead(1);
            int c;
            c = in.read();
            afterRead(c != -1 ? 1 : -1);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403365619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403365619;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.029 -0400", hash_original_method = "994E9DF4336B3658B3591197F683F468", hash_generated_method = "DED6B57650E5512E01F64A0A910E2DFF")
    @Override
    public int read(char[] chr) throws IOException {
        try 
        {
            beforeRead(chr != null ? chr.length : 0);
            int n;
            n = in.read(chr);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159823209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159823209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.029 -0400", hash_original_method = "819423AAC8700E3137A36825F0D63A1E", hash_generated_method = "AEF30D2657DEE2824078679CC9BDBEA0")
    @Override
    public int read(char[] chr, int st, int len) throws IOException {
        try 
        {
            beforeRead(len);
            int n;
            n = in.read(chr, st, len);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(chr[0]);
        addTaint(st);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25023704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25023704;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.030 -0400", hash_original_method = "6C91D7D5FFA64861FDFA028E5549C4E1", hash_generated_method = "69BC98F1648E32CF14EC3337CE39906C")
    @Override
    public int read(CharBuffer target) throws IOException {
        try 
        {
            beforeRead(target != null ? target.length() : 0);
            int n;
            n = in.read(target);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246920341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_246920341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.048 -0400", hash_original_method = "FA9F888D4C4D27A705AD6E4249FF9A0F", hash_generated_method = "47CD362D2B6F045ED6CFBDB8A64379D2")
    @Override
    public long skip(long ln) throws IOException {
        try 
        {
            long varC0E57140B7E797AC6EA3DD813ED9EFE9_709639081 = (in.skip(ln));
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(ln);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1566583411 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1566583411;
        // ---------- Original Method ----------
        //try {
            //return in.skip(ln);
        //} catch (IOException e) {
            //handleIOException(e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.048 -0400", hash_original_method = "898ED87B3E2D635579A550CF0CA7DA33", hash_generated_method = "ACC035751C691B4DF491CF1B832D18EC")
    @Override
    public boolean ready() throws IOException {
        try 
        {
            boolean var0C6F32F006D456011D89BF2F028E95C1_282647526 = (in.ready());
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580317791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580317791;
        // ---------- Original Method ----------
        //try {
            //return in.ready();
        //} catch (IOException e) {
            //handleIOException(e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.048 -0400", hash_original_method = "B82B927E9AF02AC9DAC77E074F6BBD30", hash_generated_method = "79D3FAF85F699F292722A00C560647B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.049 -0400", hash_original_method = "C433C94D03198733235CDD6598A695B3", hash_generated_method = "B1A6411193D9D70B81D4D714285367DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.050 -0400", hash_original_method = "C1647ABF099BDE2A705C358E5A628D51", hash_generated_method = "A4E5357F2CD3B46277DB7DF26594836F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.050 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "838B5D67DBD8A874F27C49E832BB2C72")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_470860975 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924687290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924687290;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.050 -0400", hash_original_method = "5DF216E1C56E8B7D3C0329D45F13AA7E", hash_generated_method = "28D3B9351992F9F28F9CECA31092136A")
    protected void beforeRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.050 -0400", hash_original_method = "C3D8A276950C0BAD0FCEDE931894DAB6", hash_generated_method = "B16FA33AB801ACEFC1FBAD31FBEA502C")
    protected void afterRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.051 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //throw e;
    }

    
}

