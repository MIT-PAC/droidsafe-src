/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.speech.srec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class represents the header of a WAVE format audio file, which usually
 * have a .wav suffix.  The following integer valued fields are contained:
 * <ul>
 * <li> format - usually PCM, ALAW or ULAW.
 * <li> numChannels - 1 for mono, 2 for stereo.
 * <li> sampleRate - usually 8000, 11025, 16000, 22050, or 44100 hz.
 * <li> bitsPerSample - usually 16 for PCM, 8 for ALAW, or 8 for ULAW.
 * <li> numBytes - size of audio data after this header, in bytes.
 * </ul>
 * 
 * Not yet ready to be supported, so
 * @hide
 */
public class WaveHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.126 -0400", hash_original_field = "1DC951243192CAA5F9F478A309D9F90C", hash_generated_field = "78D374B52CD0EEAAE30AC735B5C4422C")

    private static final String TAG = "WaveHeader";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.128 -0400", hash_original_field = "76F8743158D84C3E3DD326101BF3EBCC", hash_generated_field = "95F96C7C887E97A95676D77A2F8557F6")
    
    private static final int HEADER_LENGTH = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.130 -0400", hash_original_field = "B5D881127A1037EA544BF09BB8AF86F3", hash_generated_field = "BEE7417D733F49023EA4DD595CB10BB9")

    public static final short FORMAT_PCM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.131 -0400", hash_original_field = "72CDDC2AA4F3C98016068DCCDCB84F42", hash_generated_field = "F5D0BA907E887D28507765A46EA21181")

    public static final short FORMAT_ALAW = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.133 -0400", hash_original_field = "73CABE2B5600946171B38A960458D6F2", hash_generated_field = "8D9334EE8755BFA5DED50B509688A090")

    public static final short FORMAT_ULAW = 7;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.161 -0400", hash_original_method = "45CDB516790526148886C288239AAC93", hash_generated_method = "DC709452FDAB7B096805DFFE99DB1834")
    
private static void readId(InputStream in, String id) throws IOException {
        for (int i = 0; i < id.length(); i++) {
            if (id.charAt(i) != in.read()) throw new IOException( id + " tag not present");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.163 -0400", hash_original_method = "67C28DAF1C6A8E13B150CC63C85676BC", hash_generated_method = "BD3FA0450531C707E470D9D0FCC732C0")
    
private static int readInt(InputStream in) throws IOException {
        return in.read() | (in.read() << 8) | (in.read() << 16) | (in.read() << 24);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.164 -0400", hash_original_method = "38D8C04FFBAA2493EB3F8493C8DD88DC", hash_generated_method = "A72801232C24F8DF9CD2ADDEE3CEA058")
    
private static short readShort(InputStream in) throws IOException {
        return (short)(in.read() | (in.read() << 8));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.167 -0400", hash_original_method = "4F10C41832AD82512364F9FC719F464E", hash_generated_method = "7CF61525377751D0AA7619AEB3F067D1")
    
private static void writeId(OutputStream out, String id) throws IOException {
        for (int i = 0; i < id.length(); i++) out.write(id.charAt(i));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.169 -0400", hash_original_method = "F83E86532DB453E8E87FDF50225CA3E1", hash_generated_method = "B83B670B36477303ABA2FBC04F21EC7D")
    
private static void writeInt(OutputStream out, int val) throws IOException {
        out.write(val >> 0);
        out.write(val >> 8);
        out.write(val >> 16);
        out.write(val >> 24);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.171 -0400", hash_original_method = "5B6C077725E1253786A78B6C31E3B3C2", hash_generated_method = "976AF5A130F5103A61F08D6A6101511B")
    
private static void writeShort(OutputStream out, short val) throws IOException {
        out.write(val >> 0);
        out.write(val >> 8);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.134 -0400", hash_original_field = "1DAB2EB1E00CC9957CC4A0AC7BE14905", hash_generated_field = "481669C62BD570C9F73ADCEE233E941C")
    
    private short mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.136 -0400", hash_original_field = "BB2B13C2A1ADE982E38F0A5B1CC4EBB3", hash_generated_field = "A50B04E0191FF635EDBF177D248F20B5")

    private short mNumChannels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.137 -0400", hash_original_field = "1B75864085633CA21F9147BBF45F67AE", hash_generated_field = "BE376E6E4BD10675600CC7DC38F1CCBD")

    private int mSampleRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.138 -0400", hash_original_field = "3FF0C55F8F8ADFBAD06DF7E731234267", hash_generated_field = "03FE67D6DA4773B1FAB5FED5E738896D")

    private short mBitsPerSample;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.140 -0400", hash_original_field = "E616DBBC9B2A38673D4D052F1DFA0B7B", hash_generated_field = "5BCDB54674CC0761D0B323B79866A784")

    private int mNumBytes;
    
    /**
     * Construct a WaveHeader, with all fields defaulting to zero.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.141 -0400", hash_original_method = "97EB53FCD1385046D183D3B84D3EFDC0", hash_generated_method = "7A87D5A5389578D4361D0717F8B1E8C9")
    
public WaveHeader() {
    }
    
    /**
     * Construct a WaveHeader, with fields initialized.
     * @param format format of audio data,
     * one of {@link #FORMAT_PCM}, {@link #FORMAT_ULAW}, or {@link #FORMAT_ALAW}. 
     * @param numChannels 1 for mono, 2 for stereo.
     * @param sampleRate typically 8000, 11025, 16000, 22050, or 44100 hz.
     * @param bitsPerSample usually 16 for PCM, 8 for ULAW or 8 for ALAW.
     * @param numBytes size of audio data after this header, in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.143 -0400", hash_original_method = "D511A82312BD30DBAF2B8F418361AEBA", hash_generated_method = "AEDAC4259A10A308D4B16FB1A50BECBB")
    
public WaveHeader(short format, short numChannels, int sampleRate, short bitsPerSample, int numBytes) {
        mFormat = format;
        mSampleRate = sampleRate;
        mNumChannels = numChannels;
        mBitsPerSample = bitsPerSample;
        mNumBytes = numBytes;
    }
    
    /**
     * Get the format field.
     * @return format field,
     * one of {@link #FORMAT_PCM}, {@link #FORMAT_ULAW}, or {@link #FORMAT_ALAW}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.144 -0400", hash_original_method = "C6C1883A7B06E5B68745C87E0339603D", hash_generated_method = "9BD2740E90FDBD948FDDB794B08BDDB4")
    
public short getFormat() {
        return mFormat;
    }
    
    /**
     * Set the format field.
     * @param format
     * one of {@link #FORMAT_PCM}, {@link #FORMAT_ULAW}, or {@link #FORMAT_ALAW}.
     * @return reference to this WaveHeader instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.146 -0400", hash_original_method = "2DA21580557D12A148F57AF6B4E83AA7", hash_generated_method = "772727E4DC5F5EA01DF4F13CCE42632F")
    
public WaveHeader setFormat(short format) {
        mFormat = format;
        return this;
    }
    
    /**
     * Get the number of channels.
     * @return number of channels, 1 for mono, 2 for stereo.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.147 -0400", hash_original_method = "E0E362467431FCE6D6ADA06B8C9BA4D3", hash_generated_method = "F55238F423B99045F2E5B4A4B49AEFEE")
    
public short getNumChannels() {
        return mNumChannels;
    }
    
    /**
     * Set the number of channels.
     * @param numChannels 1 for mono, 2 for stereo.
     * @return reference to this WaveHeader instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.148 -0400", hash_original_method = "73C627F5BAA55BF509B4B75BE984B827", hash_generated_method = "92EE99BD719029B3919961BA1C3C453B")
    
public WaveHeader setNumChannels(short numChannels) {
        mNumChannels = numChannels;
        return this;
    }
    
    /**
     * Get the sample rate.
     * @return sample rate, typically 8000, 11025, 16000, 22050, or 44100 hz.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.151 -0400", hash_original_method = "5666B4191766587ED45008EA1D23BF73", hash_generated_method = "82B2B8B776281A57F731F434FB352AEA")
    
public int getSampleRate() {
        return mSampleRate;
    }
    
    /**
     * Set the sample rate.
     * @param sampleRate sample rate, typically 8000, 11025, 16000, 22050, or 44100 hz.
     * @return reference to this WaveHeader instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.152 -0400", hash_original_method = "2A98B3930037661C3A16468251D5FF27", hash_generated_method = "F4088FB9A7EE0448C7A4B61C49B90B61")
    
public WaveHeader setSampleRate(int sampleRate) {
        mSampleRate = sampleRate;
        return this;
    }
    
    /**
     * Get the number of bits per sample.
     * @return number of bits per sample,
     * usually 16 for PCM, 8 for ULAW or 8 for ALAW.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.153 -0400", hash_original_method = "EFEED8BA14D6EE4041552CF000931E69", hash_generated_method = "245978E78A2FDF24815964A76492BFF6")
    
public short getBitsPerSample() {
        return mBitsPerSample;
    }
    
    /**
     * Set the number of bits per sample.
     * @param bitsPerSample number of bits per sample,
     * usually 16 for PCM, 8 for ULAW or 8 for ALAW.
     * @return reference to this WaveHeader instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.155 -0400", hash_original_method = "4EC3F698D4C2B54EA1FA79E09F9D8BF7", hash_generated_method = "0453B7CC6895C92A0666480F63AE1620")
    
public WaveHeader setBitsPerSample(short bitsPerSample) {
        mBitsPerSample = bitsPerSample;
        return this;
    }
    
    /**
     * Get the size of audio data after this header, in bytes.
     * @return size of audio data after this header, in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.156 -0400", hash_original_method = "2994BD3295FC27BBF09A716311DA6B18", hash_generated_method = "42950E25394E0AF2FB576BD81EF4ABC1")
    
public int getNumBytes() {
        return mNumBytes;
    }
    
    /**
     * Set the size of audio data after this header, in bytes.
     * @param numBytes size of audio data after this header, in bytes.
     * @return reference to this WaveHeader instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.158 -0400", hash_original_method = "F1AE2BDE1AAAFA730A48A7E0118851BF", hash_generated_method = "33D736577E1AD5E1DDC71D86FE576524")
    
public WaveHeader setNumBytes(int numBytes) {
        mNumBytes = numBytes;
        return this;
    }
    
    /**
     * Read and initialize a WaveHeader.
     * @param in {@link java.io.InputStream} to read from.
     * @return number of bytes consumed.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.159 -0400", hash_original_method = "7738994C396E70C7EFEEA7D2AA2F1AD1", hash_generated_method = "986210729B777C7EC530D049B23297BC")
    
public int read(InputStream in) throws IOException {
        /* RIFF header */
        readId(in, "RIFF");
        int numBytes = readInt(in) - 36;
        readId(in, "WAVE");

        /* fmt chunk */
        readId(in, "fmt ");
        if (16 != readInt(in)) throw new IOException("fmt chunk length not 16");
        mFormat = readShort(in);
        mNumChannels = readShort(in);
        mSampleRate = readInt(in);
        int byteRate = readInt(in);
        short blockAlign = readShort(in);
        mBitsPerSample = readShort(in);
        if (byteRate != mNumChannels * mSampleRate * mBitsPerSample / 8) {
            throw new IOException("fmt.ByteRate field inconsistent");
        }
        if (blockAlign != mNumChannels * mBitsPerSample / 8) {
            throw new IOException("fmt.BlockAlign field inconsistent");
        }

        /* data chunk */
        readId(in, "data");
        mNumBytes = readInt(in);
        
        return HEADER_LENGTH;
    }

    /**
     * Write a WAVE file header.
     * @param out {@link java.io.OutputStream} to receive the header.
     * @return number of bytes written.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.166 -0400", hash_original_method = "323AE877A485E2230A5765DF1BD64079", hash_generated_method = "A68E04245E149796E160577CA9A73023")
    
public int write(OutputStream out) throws IOException {
        /* RIFF header */
        writeId(out, "RIFF");
        writeInt(out, 36 + mNumBytes);
        writeId(out, "WAVE");

        /* fmt chunk */
        writeId(out, "fmt ");
        writeInt(out, 16);
        writeShort(out, mFormat);
        writeShort(out, mNumChannels);
        writeInt(out, mSampleRate);
        writeInt(out, mNumChannels * mSampleRate * mBitsPerSample / 8);
        writeShort(out, (short)(mNumChannels * mBitsPerSample / 8));
        writeShort(out, mBitsPerSample);

        /* data chunk */
        writeId(out, "data");
        writeInt(out, mNumBytes);
        
        return HEADER_LENGTH;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.172 -0400", hash_original_method = "A0AE6B92EE29351CAE938312CF649E75", hash_generated_method = "7675AFF25CCB82A0B8931697982E02DD")
    
@Override
    public String toString() {
        return String.format(
                "WaveHeader format=%d numChannels=%d sampleRate=%d bitsPerSample=%d numBytes=%d",
                mFormat, mNumChannels, mSampleRate, mBitsPerSample, mNumBytes);
    }

}
