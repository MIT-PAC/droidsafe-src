/*
 * ---------------------------------------------------------------------------
 * UlawEncoderInputStream.java
 *
 * Copyright 2008 Nuance Communciations, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * ---------------------------------------------------------------------------
 */

package android.speech.srec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream which transforms 16 bit pcm data to ulaw data.
 * 
 * Not yet ready to be supported, so
 * @hide
 */
public final class UlawEncoderInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.857 -0400", hash_original_field = "3FD5AA7C705278476812B7BD5C7B3BE6", hash_generated_field = "3697BCEF6A1A14D1B058C2BF89C4B29E")

    private final static String TAG = "UlawEncoderInputStream";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.858 -0400", hash_original_field = "F11E5B86EE8484D31456A0C345182E10", hash_generated_field = "104ED35BD47322945FE6FFDA2FAFEBD3")
    
    private final static int MAX_ULAW = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.860 -0400", hash_original_field = "C7C4BEA44F362609CAE9B8837C4BB75C", hash_generated_field = "78AECF70FEA25C681FF743C3356603FE")

    private final static int SCALE_BITS = 16;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.870 -0400", hash_original_method = "33F0202E86368E36288B8DD3C594E087", hash_generated_method = "3B387BC340A50634E601F0F5B778B123")
    
public static void encode(byte[] pcmBuf, int pcmOffset,
            byte[] ulawBuf, int ulawOffset, int length, int max) {
        
        // from  'ulaw' in wikipedia
        // +8191 to +8159                          0x80
        // +8158 to +4063 in 16 intervals of 256   0x80 + interval number
        // +4062 to +2015 in 16 intervals of 128   0x90 + interval number
        // +2014 to  +991 in 16 intervals of  64   0xA0 + interval number
        //  +990 to  +479 in 16 intervals of  32   0xB0 + interval number
        //  +478 to  +223 in 16 intervals of  16   0xC0 + interval number
        //  +222 to   +95 in 16 intervals of   8   0xD0 + interval number
        //   +94 to   +31 in 16 intervals of   4   0xE0 + interval number
        //   +30 to    +1 in 15 intervals of   2   0xF0 + interval number
        //     0                                   0xFF
        
        //    -1                                   0x7F
        //   -31 to    -2 in 15 intervals of   2   0x70 + interval number
        //   -95 to   -32 in 16 intervals of   4   0x60 + interval number
        //  -223 to   -96 in 16 intervals of   8   0x50 + interval number
        //  -479 to  -224 in 16 intervals of  16   0x40 + interval number
        //  -991 to  -480 in 16 intervals of  32   0x30 + interval number
        // -2015 to  -992 in 16 intervals of  64   0x20 + interval number
        // -4063 to -2016 in 16 intervals of 128   0x10 + interval number
        // -8159 to -4064 in 16 intervals of 256   0x00 + interval number
        // -8192 to -8160                          0x00
        
        // set scale factors
        if (max <= 0) max = MAX_ULAW;
        
        int coef = MAX_ULAW * (1 << SCALE_BITS) / max;
        
        for (int i = 0; i < length; i++) {
            int pcm = (0xff & pcmBuf[pcmOffset++]) + (pcmBuf[pcmOffset++] << 8);
            pcm = (pcm * coef) >> SCALE_BITS;
            
            int ulaw;
            if (pcm >= 0) {
                ulaw = pcm <= 0 ? 0xff :
                        pcm <=   30 ? 0xf0 + ((  30 - pcm) >> 1) :
                        pcm <=   94 ? 0xe0 + ((  94 - pcm) >> 2) :
                        pcm <=  222 ? 0xd0 + (( 222 - pcm) >> 3) :
                        pcm <=  478 ? 0xc0 + (( 478 - pcm) >> 4) :
                        pcm <=  990 ? 0xb0 + (( 990 - pcm) >> 5) :
                        pcm <= 2014 ? 0xa0 + ((2014 - pcm) >> 6) :
                        pcm <= 4062 ? 0x90 + ((4062 - pcm) >> 7) :
                        pcm <= 8158 ? 0x80 + ((8158 - pcm) >> 8) :
                        0x80;
            } else {
                ulaw = -1 <= pcm ? 0x7f :
                          -31 <= pcm ? 0x70 + ((pcm -   -31) >> 1) :
                          -95 <= pcm ? 0x60 + ((pcm -   -95) >> 2) :
                         -223 <= pcm ? 0x50 + ((pcm -  -223) >> 3) :
                         -479 <= pcm ? 0x40 + ((pcm -  -479) >> 4) :
                         -991 <= pcm ? 0x30 + ((pcm -  -991) >> 5) :
                        -2015 <= pcm ? 0x20 + ((pcm - -2015) >> 6) :
                        -4063 <= pcm ? 0x10 + ((pcm - -4063) >> 7) :
                        -8159 <= pcm ? 0x00 + ((pcm - -8159) >> 8) :
                        0x00;
            }
            ulawBuf[ulawOffset++] = (byte)ulaw;
        }
    }
    
    /**
     * Compute the maximum of the absolute value of the pcm samples.
     * The return value can be used to set ulaw encoder scaling.
     * @param pcmBuf array containing 16 bit pcm data.
     * @param offset offset of start of 16 bit pcm data.
     * @param length number of pcm samples (not number of input bytes)
     * @return maximum abs of pcm data values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.872 -0400", hash_original_method = "809379BF79F9399301A93C4CE561647E", hash_generated_method = "DA6B98CC42ACCEE43DE2B0725E00C56A")
    
public static int maxAbsPcm(byte[] pcmBuf, int offset, int length) {
        int max = 0;
        for (int i = 0; i < length; i++) {
            int pcm = (0xff & pcmBuf[offset++]) + (pcmBuf[offset++] << 8);
            if (pcm < 0) pcm = -pcm;
            if (pcm > max) max = pcm;
        }
        return max;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.861 -0400", hash_original_field = "1634FBC64B8FD325086483774D25FC9C", hash_generated_field = "9DC54C0EDA2EFE184D8D41ADBEAE2CF5")
    
    private InputStream mIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.863 -0400", hash_original_field = "5532C4BFF48CADB5E631372FF8EBCB66", hash_generated_field = "66A5F9DE5276D709F03C7237FE38ABF0")
    
    private int mMax = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.864 -0400", hash_original_field = "2BCFB5982CB22E130C6C7D08F1F2B31B", hash_generated_field = "07A0F75F749366F44B5F1F7B93DF4626")
    
    private final byte[] mBuf = new byte[1024];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.865 -0400", hash_original_field = "61B66897D77E78D5B8A3298FD8EF469C", hash_generated_field = "257EAB9DE214E9C1A8E04D28FD1FB443")

    private int mBufCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.867 -0400", hash_original_field = "F2C0D94F7A8C986534145C29C73EBAF7", hash_generated_field = "4218F1CA63F49EC26C9730C12AB316CC")
    
    private final byte[] mOneByte = new byte[1];

    /**
     * Create an InputStream which takes 16 bit pcm data and produces ulaw data.
     * @param in InputStream containing 16 bit pcm data.
     * @param max pcm value corresponding to maximum ulaw value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.874 -0400", hash_original_method = "37683A0367984FFADD961BF374D117C6", hash_generated_method = "E4030BC1B6AB5B23AE126640083B4594")
    
public UlawEncoderInputStream(InputStream in, int max) {
        mIn = in;
        mMax = max;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.875 -0400", hash_original_method = "7F6544AC2BC80BD62573014D72475A49", hash_generated_method = "E8EF73931C7DF84103FE1AC9F8FB728E")
    
@Override
    public int read(byte[] buf, int offset, int length) throws IOException {
        if (mIn == null) throw new IllegalStateException("not open");

        // return at least one byte, but try to fill 'length'
        while (mBufCount < 2) {
            int n = mIn.read(mBuf, mBufCount, Math.min(length * 2, mBuf.length - mBufCount));
            if (n == -1) return -1;
            mBufCount += n;
        }
        
        // compand data
        int n = Math.min(mBufCount / 2, length);
        encode(mBuf, 0, buf, offset, n, mMax);
        
        // move data to bottom of mBuf
        mBufCount -= n * 2;
        for (int i = 0; i < mBufCount; i++) mBuf[i] = mBuf[i + n * 2];
        
        return n;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.877 -0400", hash_original_method = "2F668D010292F41F8534D9B42F402EB1", hash_generated_method = "E92D53D06BA9BE55F7FB3173E2C57885")
    
@Override
    public int read(byte[] buf) throws IOException {
        return read(buf, 0, buf.length);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.878 -0400", hash_original_method = "57F60B9384F00CF314262EEE7416F389", hash_generated_method = "8E7AF22696DB9CD9143CDA142A9E6E1A")
    
@Override
    public int read() throws IOException {
        int n = read(mOneByte, 0, 1);
        if (n == -1) return -1;
        return 0xff & (int)mOneByte[0];
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.880 -0400", hash_original_method = "6398F6422A13B336F4E332ED4B6F7FCE", hash_generated_method = "79B81B083278DCDC337EE31024B3A21D")
    
@Override
    public void close() throws IOException {
        if (mIn != null) {
            InputStream in = mIn;
            mIn = null;
            in.close();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:12:13.882 -0400", hash_original_method = "CD81B4AAF2CD71D1A2AF4CF5851D7D44", hash_generated_method = "72462907F37541A607A475E1C5C61B7C")
    
@Override
    public int available() throws IOException {
        return (mIn.available() + mBufCount) / 2;
    }
}
