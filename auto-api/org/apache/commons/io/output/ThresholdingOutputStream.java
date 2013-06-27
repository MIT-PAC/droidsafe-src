package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;

public abstract class ThresholdingOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.568 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.568 -0400", hash_original_field = "9CC26FA09CE37BC95AFE01BC718836D1", hash_generated_field = "C6743BCE3F1A0F9070591F7112B3B8ED")

    private long written;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.568 -0400", hash_original_field = "1BDEDCC31758B35D15DDCAF4609EEEA9", hash_generated_field = "5E8665C6D9CAC8C9DDEA8BC1F29622E7")

    private boolean thresholdExceeded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.568 -0400", hash_original_method = "77C2ECB5C285EF71184BF3F2AC3FDA1E", hash_generated_method = "6EFB5AA431D618543ED37CD003D63A47")
    public  ThresholdingOutputStream(int threshold) {
        this.threshold = threshold;
        // ---------- Original Method ----------
        //this.threshold = threshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.579 -0400", hash_original_method = "A749941175ED4946E5E13C756C47A3BF", hash_generated_method = "1B16ACFA175D8DE83701F847D4306C0E")
    @Override
    public void write(int b) throws IOException {
        checkThreshold(1);
        getStream().write(b);
        addTaint(b);
        // ---------- Original Method ----------
        //checkThreshold(1);
        //getStream().write(b);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.583 -0400", hash_original_method = "BDE8F5646F213B56F0E18C72C563121D", hash_generated_method = "2A7FA011EB0B78EE8C968BF8C7C0F902")
    @Override
    public void write(byte b[]) throws IOException {
        checkThreshold(b.length);
        getStream().write(b);
        written += b.length;
        // ---------- Original Method ----------
        //checkThreshold(b.length);
        //getStream().write(b);
        //written += b.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.584 -0400", hash_original_method = "63B0905E0F7F5A890F09CED6998445D1", hash_generated_method = "4F9A9D8789BB4384B43452ABBA614060")
    @Override
    public void write(byte b[], int off, int len) throws IOException {
        checkThreshold(len);
        getStream().write(b, off, len);
        written += len;
        addTaint(b);
        addTaint(off);
        // ---------- Original Method ----------
        //checkThreshold(len);
        //getStream().write(b, off, len);
        //written += len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.584 -0400", hash_original_method = "7DA4C958A096834DFED555D27E028982", hash_generated_method = "395693CB9ECAF5848281296D19170B8F")
    @Override
    public void flush() throws IOException {
        getStream().flush();
        // ---------- Original Method ----------
        //getStream().flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.585 -0400", hash_original_method = "D4B771243EF7B4BDA5F26E7A828E3C67", hash_generated_method = "5C34C055951B1151A39D8A541244097F")
    @Override
    public void close() throws IOException {
        try 
        {
            flush();
        } //End block
        catch (IOException ignored)
        { }
        getStream().close();
        // ---------- Original Method ----------
        //try
        //{
            //flush();
        //}
        //catch (IOException ignored)
        //{
        //}
        //getStream().close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.585 -0400", hash_original_method = "D74160AE6FC7C2C8DE051989EE60B0B3", hash_generated_method = "04BAE8CF6B97F16D81076217A744DAB5")
    public int getThreshold() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654683346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654683346;
        // ---------- Original Method ----------
        //return threshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.586 -0400", hash_original_method = "406CBD57F94439414A20EAD4F95AFAE5", hash_generated_method = "DBF04379FDE24EC8340C7CF9FBAE217C")
    public long getByteCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_461367371 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_461367371;
        // ---------- Original Method ----------
        //return written;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.586 -0400", hash_original_method = "1EA9299850929B3D5FCE42AA4C38FE08", hash_generated_method = "26149B49C4FE4DF027BE7372989D5E0A")
    public boolean isThresholdExceeded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020858681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020858681;
        // ---------- Original Method ----------
        //return written > threshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.592 -0400", hash_original_method = "16D96BE3274D83A99EFD52BEDEDB0485", hash_generated_method = "5E7E02C3D354A6FFC063414AC2021AA0")
    protected void checkThreshold(int count) throws IOException {
        {
            thresholdExceeded = true;
            thresholdReached();
        } //End block
        addTaint(count);
        // ---------- Original Method ----------
        //if (!thresholdExceeded && written + count > threshold)
        //{
            //thresholdExceeded = true;
            //thresholdReached();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.592 -0400", hash_original_method = "30120E8670CD410900DBC3B4D1B240BE", hash_generated_method = "27A32EB1C009ED9E66461A03B0F831A0")
    protected void resetByteCount() {
        this.thresholdExceeded = false;
        this.written = 0;
        // ---------- Original Method ----------
        //this.thresholdExceeded = false;
        //this.written = 0;
    }

    
    protected abstract OutputStream getStream() throws IOException;

    
    protected abstract void thresholdReached() throws IOException;

    
}

