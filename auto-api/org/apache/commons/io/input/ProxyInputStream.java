package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ProxyInputStream extends FilterInputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.013 -0400", hash_original_method = "F5C674A4B4C3C6B0C4DE10E9E5CA4DD0", hash_generated_method = "911B6563E9EACD806DA642F62AFFA036")
    public  ProxyInputStream(InputStream proxy) {
        super(proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.024 -0400", hash_original_method = "54B5A34E53A0B96BE3D94E0D4A7D572A", hash_generated_method = "8810D9FA362A78262C31414C7691AD1D")
    @Override
    public int read() throws IOException {
        try 
        {
            beforeRead(1);
            int b;
            b = in.read();
            afterRead(b != -1 ? 1 : -1);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122259400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122259400;
        // ---------- Original Method ----------
        //try {
            //beforeRead(1);
            //int b = in.read();
            //afterRead(b != -1 ? 1 : -1);
            //return b;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.025 -0400", hash_original_method = "ACF1A17E0D23809C356E177971499CFB", hash_generated_method = "04CA53BFBCEC3B2B46D018487D380977")
    @Override
    public int read(byte[] bts) throws IOException {
        try 
        {
            beforeRead(bts != null ? bts.length : 0);
            int n;
            n = in.read(bts);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(bts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438758441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438758441;
        // ---------- Original Method ----------
        //try {
            //beforeRead(bts != null ? bts.length : 0);
            //int n = in.read(bts);
            //afterRead(n);
            //return n;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.026 -0400", hash_original_method = "2C3D85339C2DDA831F01519845123B39", hash_generated_method = "23593E83345AD5028E9952EF573FCBB3")
    @Override
    public int read(byte[] bts, int off, int len) throws IOException {
        try 
        {
            beforeRead(len);
            int n;
            n = in.read(bts, off, len);
            afterRead(n);
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(bts[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091659075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091659075;
        // ---------- Original Method ----------
        //try {
            //beforeRead(len);
            //int n = in.read(bts, off, len);
            //afterRead(n);
            //return n;
        //} catch (IOException e) {
            //handleIOException(e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.026 -0400", hash_original_method = "FA9F888D4C4D27A705AD6E4249FF9A0F", hash_generated_method = "21189FC4A337E09A70DA21575286087A")
    @Override
    public long skip(long ln) throws IOException {
        try 
        {
            long varC0E57140B7E797AC6EA3DD813ED9EFE9_422047625 = (in.skip(ln));
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        addTaint(ln);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_978160661 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_978160661;
        // ---------- Original Method ----------
        //try {
            //return in.skip(ln);
        //} catch (IOException e) {
            //handleIOException(e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.027 -0400", hash_original_method = "7BBD2FE125A14B4336F98A66912C9079", hash_generated_method = "3A53C3EE64F9EFBD7B0A5D6F01A64FF8")
    @Override
    public int available() throws IOException {
        try 
        {
            int varBA26BD6C2684B5A5EC942BA7C9C20D72_1163160476 = (super.available());
        } //End block
        catch (IOException e)
        {
            handleIOException(e);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678879998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678879998;
        // ---------- Original Method ----------
        //try {
            //return super.available();
        //} catch (IOException e) {
            //handleIOException(e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.027 -0400", hash_original_method = "B82B927E9AF02AC9DAC77E074F6BBD30", hash_generated_method = "79D3FAF85F699F292722A00C560647B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.033 -0400", hash_original_method = "FFAC7C303832D87EA3757F73ECC9CF0F", hash_generated_method = "AA053874BBA26ECE7C7BFC30340E292E")
    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        addTaint(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.033 -0400", hash_original_method = "C1647ABF099BDE2A705C358E5A628D51", hash_generated_method = "A4E5357F2CD3B46277DB7DF26594836F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.034 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "691A4B91ECBA25E534CA49D7DF21F955")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_1015998316 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850687725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850687725;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.035 -0400", hash_original_method = "5DF216E1C56E8B7D3C0329D45F13AA7E", hash_generated_method = "28D3B9351992F9F28F9CECA31092136A")
    protected void beforeRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.037 -0400", hash_original_method = "C3D8A276950C0BAD0FCEDE931894DAB6", hash_generated_method = "B16FA33AB801ACEFC1FBAD31FBEA502C")
    protected void afterRead(int n) throws IOException {
        addTaint(n);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.042 -0400", hash_original_method = "A242DFA5F52516C95D0F167B92B745B6", hash_generated_method = "1782E1D1CE0D623FCB8AA6CF8B177B94")
    protected void handleIOException(IOException e) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //throw e;
    }

    
}

