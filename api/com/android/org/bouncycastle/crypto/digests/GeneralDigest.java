package com.android.org.bouncycastle.crypto.digests;

// Droidsafe Imports
import com.android.org.bouncycastle.crypto.ExtendedDigest;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class GeneralDigest implements ExtendedDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.245 -0400", hash_original_field = "5A6404CE8F44AE5DF2E1D4C64517E9F8", hash_generated_field = "143ABAB13B7522AC48A1AF414B584EA6")

    private byte[] xBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.245 -0400", hash_original_field = "B73BD1BA6F9DE097A99C46DA8F84D3F3", hash_generated_field = "9944C954EBE5AE117A9CFE73E4199E45")

    private int xBufOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.245 -0400", hash_original_field = "A43EF6D60A83013EA1A61A23BDB16029", hash_generated_field = "D3F3DF2B8C683F433F8C23530F50C011")

    private long byteCount;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.246 -0400", hash_original_method = "33929E7FC3CB1C0A7849A234D0A1D124", hash_generated_method = "3BCCC318CDF45D232F759196E9A77067")
    protected  GeneralDigest() {
        xBuf = new byte[4];
        xBufOff = 0;
        // ---------- Original Method ----------
        //xBuf = new byte[4];
        //xBufOff = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.247 -0400", hash_original_method = "4340B9306D0B5D5E85547023830EA78A", hash_generated_method = "67EDBC22BDA2573689E6C40DEDCB9A16")
    protected  GeneralDigest(GeneralDigest t) {
        xBuf = new byte[t.xBuf.length];
        System.arraycopy(t.xBuf, 0, xBuf, 0, t.xBuf.length);
        xBufOff = t.xBufOff;
        byteCount = t.byteCount;
        // ---------- Original Method ----------
        //xBuf = new byte[t.xBuf.length];
        //System.arraycopy(t.xBuf, 0, xBuf, 0, t.xBuf.length);
        //xBufOff = t.xBufOff;
        //byteCount = t.byteCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.248 -0400", hash_original_method = "40E7CDF1E9D122AF3862D5C54DFC78EC", hash_generated_method = "3A22FA55FE283CF58639B2682FE06454")
    public void update(
        byte in) {
        xBuf[xBufOff++] = in;
        if(xBufOff == xBuf.length)        
        {
            processWord(xBuf, 0);
            xBufOff = 0;
        } //End block
        byteCount++;
        // ---------- Original Method ----------
        //xBuf[xBufOff++] = in;
        //if (xBufOff == xBuf.length)
        //{
            //processWord(xBuf, 0);
            //xBufOff = 0;
        //}
        //byteCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.248 -0400", hash_original_method = "F796363C15CB3EC49C76DC6C83402CDE", hash_generated_method = "86D896F5E1F695AA1E2248A2BFA044C4")
    public void update(
        byte[]  in,
        int     inOff,
        int     len) {
        addTaint(len);
        addTaint(inOff);
        addTaint(in[0]);
        while
((xBufOff != 0) && (len > 0))        
        {
            update(in[inOff]);
            inOff++;
            len--;
        } //End block
        while
(len > xBuf.length)        
        {
            processWord(in, inOff);
            inOff += xBuf.length;
            len -= xBuf.length;
            byteCount += xBuf.length;
        } //End block
        while
(len > 0)        
        {
            update(in[inOff]);
            inOff++;
            len--;
        } //End block
        // ---------- Original Method ----------
        //while ((xBufOff != 0) && (len > 0))
        //{
            //update(in[inOff]);
            //inOff++;
            //len--;
        //}
        //while (len > xBuf.length)
        //{
            //processWord(in, inOff);
            //inOff += xBuf.length;
            //len -= xBuf.length;
            //byteCount += xBuf.length;
        //}
        //while (len > 0)
        //{
            //update(in[inOff]);
            //inOff++;
            //len--;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.249 -0400", hash_original_method = "E3BD506664D5291ACBDD4523D9F73924", hash_generated_method = "12F90A032EB2458DF17F3528117B2AE1")
    public void finish() {
        long bitLength = (byteCount << 3);
        update((byte)128);
        while
(xBufOff != 0)        
        {
            update((byte)0);
        } //End block
        processLength(bitLength);
        processBlock();
        // ---------- Original Method ----------
        //long    bitLength = (byteCount << 3);
        //update((byte)128);
        //while (xBufOff != 0)
        //{
            //update((byte)0);
        //}
        //processLength(bitLength);
        //processBlock();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.250 -0400", hash_original_method = "60263393C79297CFA49BF4ADA6FCDD6D", hash_generated_method = "C4C9DCEEF7EE6B581D2AB882DB95C200")
    public void reset() {
        byteCount = 0;
        xBufOff = 0;
for(int i = 0;i < xBuf.length;i++)
        {
            xBuf[i] = 0;
        } //End block
        // ---------- Original Method ----------
        //byteCount = 0;
        //xBufOff = 0;
        //for (int i = 0; i < xBuf.length; i++)
        //{
            //xBuf[i] = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.251 -0400", hash_original_method = "BDE19E4C77B0F308FC4C95638A0B9303", hash_generated_method = "72C722020324769E5CA4F2422ED90FDF")
    public int getByteLength() {
        int var081D3CAB5AB5E355C7B18381A90F6AE8_982720009 = (BYTE_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433269590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433269590;
        // ---------- Original Method ----------
        //return BYTE_LENGTH;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void processWord(byte[] in, int inOff);

    
    @DSModeled(DSC.SAFE)
    protected abstract void processLength(long bitLength);

    
    @DSModeled(DSC.SAFE)
    protected abstract void processBlock();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.251 -0400", hash_original_field = "B0EAB7EE3DAF5A2E42173AFEFC2BFC30", hash_generated_field = "3DFC995CC5383F8C69A040DE4EAEB873")

    private static final int BYTE_LENGTH = 64;
}

