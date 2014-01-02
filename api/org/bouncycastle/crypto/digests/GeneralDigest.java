package org.bouncycastle.crypto.digests;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.ExtendedDigest;






public abstract class GeneralDigest implements ExtendedDigest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.028 -0500", hash_original_field = "80FB030010B139D624F8F6338A378203", hash_generated_field = "3DFC995CC5383F8C69A040DE4EAEB873")

    private static final int BYTE_LENGTH = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.031 -0500", hash_original_field = "E0EA9885EBE79CCB412ED94F98F9B8F7", hash_generated_field = "143ABAB13B7522AC48A1AF414B584EA6")

    private byte[]  xBuf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.033 -0500", hash_original_field = "DEB7A2CF73CEDCD6731733F2DC74D50F", hash_generated_field = "9944C954EBE5AE117A9CFE73E4199E45")

    private int     xBufOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.035 -0500", hash_original_field = "BCA4DEF68AEEA879C3CDF52B3B2B0634", hash_generated_field = "D3F3DF2B8C683F433F8C23530F50C011")


    private long    byteCount;

    /**
     * Standard constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.038 -0500", hash_original_method = "33929E7FC3CB1C0A7849A234D0A1D124", hash_generated_method = "FBAD8AE896CBA798BFEACCA37936C14A")
    
protected GeneralDigest()
    {
        xBuf = new byte[4];
        xBufOff = 0;
    }

    /**
     * Copy constructor.  We are using copy constructors in place
     * of the Object.clone() interface as this interface is not
     * supported by J2ME.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.041 -0500", hash_original_method = "4340B9306D0B5D5E85547023830EA78A", hash_generated_method = "0F741F2A06666205137F35653B20669C")
    
protected GeneralDigest(GeneralDigest t)
    {
        xBuf = new byte[t.xBuf.length];
        System.arraycopy(t.xBuf, 0, xBuf, 0, t.xBuf.length);

        xBufOff = t.xBufOff;
        byteCount = t.byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.043 -0500", hash_original_method = "40E7CDF1E9D122AF3862D5C54DFC78EC", hash_generated_method = "B5827A21C816F17D7F7DEE369F308804")
    
public void update(
        byte in)
    {
        xBuf[xBufOff++] = in;

        if (xBufOff == xBuf.length)
        {
            processWord(xBuf, 0);
            xBufOff = 0;
        }

        byteCount++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.045 -0500", hash_original_method = "F796363C15CB3EC49C76DC6C83402CDE", hash_generated_method = "05B20E71CDF6E2857F13A047528CB064")
    
public void update(
        byte[]  in,
        int     inOff,
        int     len)
    {
        //
        // fill the current word
        //
        while ((xBufOff != 0) && (len > 0))
        {
            update(in[inOff]);

            inOff++;
            len--;
        }

        //
        // process whole words.
        //
        while (len > xBuf.length)
        {
            processWord(in, inOff);

            inOff += xBuf.length;
            len -= xBuf.length;
            byteCount += xBuf.length;
        }

        //
        // load in the remainder.
        //
        while (len > 0)
        {
            update(in[inOff]);

            inOff++;
            len--;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.048 -0500", hash_original_method = "E3BD506664D5291ACBDD4523D9F73924", hash_generated_method = "34173DD611171C7B57F1170AF36BA9C4")
    
public void finish()
    {
        long    bitLength = (byteCount << 3);

        //
        // add the pad bytes.
        //
        update((byte)128);

        while (xBufOff != 0)
        {
            update((byte)0);
        }

        processLength(bitLength);

        processBlock();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.050 -0500", hash_original_method = "60263393C79297CFA49BF4ADA6FCDD6D", hash_generated_method = "42BB594A1781D07A4896092B29C838A3")
    
public void reset()
    {
        byteCount = 0;

        xBufOff = 0;
        for (int i = 0; i < xBuf.length; i++)
        {
            xBuf[i] = 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.053 -0500", hash_original_method = "BDE19E4C77B0F308FC4C95638A0B9303", hash_generated_method = "CB7C557138F85205C7FCD23EE8ED1D1C")
    
public int getByteLength()
    {
        return BYTE_LENGTH;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.055 -0500", hash_original_method = "04DFDFE0453D80C4BC4B5BEFF90F3950", hash_generated_method = "E10F26F2963935FC91B6A1386ACD670E")
    
protected abstract void processWord(byte[] in, int inOff);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.057 -0500", hash_original_method = "6496E83EE108E3B358778ABF0CBEFB20", hash_generated_method = "AB621FDEE444104D0FBF4358FF256476")
    
protected abstract void processLength(long bitLength);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.059 -0500", hash_original_method = "F44EC1E32B9782C51662CD086C13B889", hash_generated_method = "4340306794C7254459C227CFBB2C305E")
    
protected abstract void processBlock();
}

