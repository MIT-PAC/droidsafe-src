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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.959 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

    private long count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.960 -0400", hash_original_method = "F0667AD48C8EC6D7BA0EADD31D490B3C", hash_generated_method = "A6C7D351BCA41EB28695F09E649118AA")
    public  CountingInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.960 -0400", hash_original_method = "132500B6DBD3ECFEDBE720096796962F", hash_generated_method = "49F1D7F0BF4910EE480F68C8B63A2BF6")
    @Override
    public synchronized long skip(final long length) throws IOException {
        long skip;
        skip = super.skip(length);
        this.count += skip;
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_989317490 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_989317490;
        // ---------- Original Method ----------
        //final long skip = super.skip(length);
        //this.count += skip;
        //return skip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.960 -0400", hash_original_method = "90EDC96C8584B0F7C76A1BA2408C4520", hash_generated_method = "5BCF420B7EC98EEAA43840188F92278A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.961 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "7A8B13148F0CF4D141DEC23848591A95")
    public int getCount() {
        long result;
        result = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166191572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166191572;
        // ---------- Original Method ----------
        //long result = getByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.961 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "5396F2B9A7BC08453C97747B3A8C2FE1")
    public int resetCount() {
        long result;
        result = resetByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500087873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500087873;
        // ---------- Original Method ----------
        //long result = resetByteCount();
        //if (result > Integer.MAX_VALUE) {
            //throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        //}
        //return (int) result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.962 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "A3FAF80D73BE562245263BD064D782BB")
    public synchronized long getByteCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_107057542 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_107057542;
        // ---------- Original Method ----------
        //return this.count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.962 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "1675CFBC3073C6B6B2F2C6E399AE6E4C")
    public synchronized long resetByteCount() {
        long tmp;
        tmp = this.count;
        this.count = 0;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1336537684 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1336537684;
        // ---------- Original Method ----------
        //long tmp = this.count;
        //this.count = 0;
        //return tmp;
    }

    
}

