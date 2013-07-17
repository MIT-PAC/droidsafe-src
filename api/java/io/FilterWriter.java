package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class FilterWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.377 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.382 -0400", hash_original_method = "C9832951E5B51AA5FF45C56E637B6353", hash_generated_method = "0518BC8718C104755E1F89522C6C593B")
    protected  FilterWriter(Writer out) {
        super(out);
        this.out = out;
        // ---------- Original Method ----------
        //this.out = out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.385 -0400", hash_original_method = "05673170CC0D0E023F5651E2EFB2043A", hash_generated_method = "7E3EAF948428C48249AF30A6023CCA05")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            out.close();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.387 -0400", hash_original_method = "6E517A9D20FAB02C8C7ECBD26B835783", hash_generated_method = "8D19DCD755BC396FA0BB006F1B21D220")
    @Override
    public void flush() throws IOException {
        synchronized
(lock)        {
            out.flush();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.391 -0400", hash_original_method = "8844CE5B6BE403964369DBE67DE17A9B", hash_generated_method = "FE2C872D8D3C9882A42EC5E656EB3FA9")
    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            out.write(buffer, offset, count);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(buffer, offset, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.398 -0400", hash_original_method = "C0F1D18AD38B0E8F448CFE46E5D9188A", hash_generated_method = "DE231F72051E6E88702E4C21C0F72D22")
    @Override
    public void write(int oneChar) throws IOException {
        addTaint(oneChar);
        synchronized
(lock)        {
            out.write(oneChar);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(oneChar);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.401 -0400", hash_original_method = "C7C8D1E997868E998D408F658DA19BDC", hash_generated_method = "9FD7A8FA2198CECC9EB5F2AC8532319D")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        synchronized
(lock)        {
            out.write(str, offset, count);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(str, offset, count);
        //}
    }

    
}

