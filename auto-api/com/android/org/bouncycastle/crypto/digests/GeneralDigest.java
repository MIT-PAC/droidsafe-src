package com.android.org.bouncycastle.crypto.digests;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.org.bouncycastle.crypto.ExtendedDigest;

public abstract class GeneralDigest implements ExtendedDigest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.282 -0400", hash_original_field = "5A6404CE8F44AE5DF2E1D4C64517E9F8", hash_generated_field = "143ABAB13B7522AC48A1AF414B584EA6")

    private byte[] xBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.283 -0400", hash_original_field = "B73BD1BA6F9DE097A99C46DA8F84D3F3", hash_generated_field = "9944C954EBE5AE117A9CFE73E4199E45")

    private int xBufOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.284 -0400", hash_original_field = "A43EF6D60A83013EA1A61A23BDB16029", hash_generated_field = "D3F3DF2B8C683F433F8C23530F50C011")

    private long byteCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.286 -0400", hash_original_method = "33929E7FC3CB1C0A7849A234D0A1D124", hash_generated_method = "3BCCC318CDF45D232F759196E9A77067")
    protected  GeneralDigest() {
        xBuf = new byte[4];
        xBufOff = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.288 -0400", hash_original_method = "4340B9306D0B5D5E85547023830EA78A", hash_generated_method = "67EDBC22BDA2573689E6C40DEDCB9A16")
    protected  GeneralDigest(GeneralDigest t) {
        xBuf = new byte[t.xBuf.length];
        System.arraycopy(t.xBuf, 0, xBuf, 0, t.xBuf.length);
        xBufOff = t.xBufOff;
        byteCount = t.byteCount;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.290 -0400", hash_original_method = "40E7CDF1E9D122AF3862D5C54DFC78EC", hash_generated_method = "8C9314156960D780D1EEBDD820EEF1B5")
    public void update(
        byte in) {
        xBuf[xBufOff++] = in;
        {
            processWord(xBuf, 0);
            xBufOff = 0;
        } 
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.294 -0400", hash_original_method = "F796363C15CB3EC49C76DC6C83402CDE", hash_generated_method = "1258AF33D2E03E299D9CB09E21B0974A")
    public void update(
        byte[]  in,
        int     inOff,
        int     len) {
        {
            update(in[inOff]);
        } 
        {
            processWord(in, inOff);
            inOff += xBuf.length;
            len -= xBuf.length;
            byteCount += xBuf.length;
        } 
        {
            update(in[inOff]);
        } 
        addTaint(in[0]);
        addTaint(inOff);
        addTaint(len);
        
        
        
            
            
            
        
        
        
            
            
            
            
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.296 -0400", hash_original_method = "E3BD506664D5291ACBDD4523D9F73924", hash_generated_method = "0C760DF271A1398F7224908F8AA55AEC")
    public void finish() {
        long bitLength = (byteCount << 3);
        update((byte)128);
        {
            update((byte)0);
        } 
        processLength(bitLength);
        processBlock();
        
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.298 -0400", hash_original_method = "60263393C79297CFA49BF4ADA6FCDD6D", hash_generated_method = "A05DCC2826503EB0D8682DC61E244788")
    public void reset() {
        byteCount = 0;
        xBufOff = 0;
        {
            int i = 0;
            {
                xBuf[i] = 0;
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.300 -0400", hash_original_method = "BDE19E4C77B0F308FC4C95638A0B9303", hash_generated_method = "975A1EF45A421EC5865FAEF6DBD2F50F")
    public int getByteLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352576694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352576694;
        
        
    }

    
    protected abstract void processWord(byte[] in, int inOff);

    
    protected abstract void processLength(long bitLength);

    
    protected abstract void processBlock();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:48:13.301 -0400", hash_original_field = "B0EAB7EE3DAF5A2E42173AFEFC2BFC30", hash_generated_field = "3DFC995CC5383F8C69A040DE4EAEB873")

    private static final int BYTE_LENGTH = 64;
}

