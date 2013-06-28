package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends ProxyInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.111 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

    private long count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.112 -0400", hash_original_method = "F0667AD48C8EC6D7BA0EADD31D490B3C", hash_generated_method = "A6C7D351BCA41EB28695F09E649118AA")
    public  CountingInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.112 -0400", hash_original_method = "132500B6DBD3ECFEDBE720096796962F", hash_generated_method = "AC94BC89F98E42618B197AC5535B68D3")
    @Override
    public synchronized long skip(final long length) throws IOException {
        final long skip = super.skip(length);
        this.count += skip;
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_92156846 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_92156846;
        // ---------- Original Method ----------
        //final long skip = super.skip(length);
        //this.count += skip;
        //return skip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.113 -0400", hash_original_method = "90EDC96C8584B0F7C76A1BA2408C4520", hash_generated_method = "5BCF420B7EC98EEAA43840188F92278A")
    @Override
    protected synchronized void afterRead(int n) {
        {
            this.count += n;
        } //End block
        // ---------- Original Method ----------
        //if (n != -1) {
            //this.count += n;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.113 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "FFE0CCBECEB00544C7E3609F53298DF2")
    public int getCount() {
        long result = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138638305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138638305;
        // ---------- Original Method ----------
        //long result = getByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.114 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "08FF710035CDA59004AE09BA25A4651C")
    public int resetCount() {
        long result = resetByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117246811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117246811;
        // ---------- Original Method ----------
        //long result = resetByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.114 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "6FC8329DC59178B09642F9900B37EA97")
    public synchronized long getByteCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_383574755 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_383574755;
        // ---------- Original Method ----------
        //return this.count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.114 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "2E8234B420297944B11C9DD76B615C87")
    public synchronized long resetByteCount() {
        long tmp = this.count;
        this.count = 0;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1480480407 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1480480407;
        // ---------- Original Method ----------
        //long tmp = this.count;
        //this.count = 0;
        //return tmp;
    }

    
}

