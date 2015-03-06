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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.util.EmptyArray;
import dalvik.system.CloseGuard;

public class Deflater {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.723 -0500", hash_original_field = "E85D7D547BCB2C42E7F038B26BC9B1EE", hash_generated_field = "13698D975E7B2387C4A72B340600110B")

    public static final int BEST_COMPRESSION = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.726 -0500", hash_original_field = "0352AF540A6FE458BF060FE319C11FE9", hash_generated_field = "890A9513D044EA8A70C3430C0F3910C0")

    public static final int BEST_SPEED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.728 -0500", hash_original_field = "06B8CBC903252137ED167BC44F48E232", hash_generated_field = "E7BE2C778DA6187E3452B1A718873C24")

    public static final int DEFAULT_COMPRESSION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.731 -0500", hash_original_field = "A3D32E75A5BE2868441A12AA11134E00", hash_generated_field = "19AAC35E658ABBCEB552A5E24211DA20")

    public static final int DEFAULT_STRATEGY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.734 -0500", hash_original_field = "76C48874DF3F847D8799A9755C24ED8B", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.736 -0500", hash_original_field = "521230263380193C9BC4E2095F66CC6B", hash_generated_field = "2321B2F07267BE7486401DE443318EEF")

    public static final int FILTERED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.739 -0500", hash_original_field = "DD5FC05DCD5C651F12758D1E4312E68C", hash_generated_field = "4686D220D976568E44E871FF5A4F153B")

    public static final int HUFFMAN_ONLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.741 -0500", hash_original_field = "6741A7EE51BBB97027CD1AD9D1A0AF44", hash_generated_field = "7E480562BE1ECBC592DFD29907509C69")

    public static final int NO_COMPRESSION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.744 -0500", hash_original_field = "E6C4B7E98BE875342365180AC7F93B77", hash_generated_field = "64337D4FC74C09056924942AC04865E4")

    public static final int NO_FLUSH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.747 -0500", hash_original_field = "66267C4269AD3E7E4D0DBCEB63AD4B7E", hash_generated_field = "7943C4EAA611D10AC2C91440A4B6FD09")

    public static final int SYNC_FLUSH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.750 -0500", hash_original_field = "3FCFBEEA75D0AAEE7918CBDA6545ECCF", hash_generated_field = "7C02FA0E9AA9D37F4E5455FE8EF0CA0F")

    public static final int FULL_FLUSH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.752 -0500", hash_original_field = "658C69298EE2851D75B4C44C73C2C439", hash_generated_field = "7F3FB3722552665A1F9F50826D383337")

    private static final int FINISH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.755 -0500", hash_original_field = "6F9099FA89F5F1A1D3D252D9864EA5A2", hash_generated_field = "FE9D47B0BB2944D7D04C48564510EA37")

    private int flushParm = NO_FLUSH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.757 -0500", hash_original_field = "59CD61E3A383ACAD01F8F1AA33285180", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.760 -0500", hash_original_field = "9DD4FCAC72A22ADDE5A5D47CF9140D77", hash_generated_field = "27139595293C7DFAFE0E0E3302C66E6F")

    private int compressLevel = DEFAULT_COMPRESSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.762 -0500", hash_original_field = "F148B82EE930A7E4F67D330C395EAAAC", hash_generated_field = "BB7C60E9AAF3128E30F80132DBC518E3")

    private int strategy = DEFAULT_STRATEGY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.764 -0500", hash_original_field = "29B64591123A903836B90C66F6149507", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.767 -0500", hash_original_field = "F1446DCAD6A059A865BF8D29770BBE1A", hash_generated_field = "97F892FF664C2B7167B136A4B04D7E33")

    private byte[] inputBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.769 -0500", hash_original_field = "26AE1163BD027CE87ED65D36070B90DA", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.771 -0500", hash_original_field = "A2FC62482F8FC5A7B00D9127EAC6F44C", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.775 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * Constructs a new {@code Deflater} instance using the default compression
     * level. The strategy can be specified with {@link #setStrategy}. A
     * header is added to the output by default; use {@link
     * #Deflater(int, boolean)} if you need to omit the header.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.778 -0500", hash_original_method = "6DBC61BE4FC097F2420F36A015A6138C", hash_generated_method = "8855039A4E948A2EBAE9A37F127A6C32")
    
public Deflater() {
        this(DEFAULT_COMPRESSION, false);
    }

    /**
     * Constructs a new {@code Deflater} instance using compression
     * level {@code level}. The strategy can be specified with {@link #setStrategy}.
     * A header is added to the output by default; use
     * {@link #Deflater(int, boolean)} if you need to omit the header.
     *
     * @param level
     *            the compression level in the range between 0 and 9.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.780 -0500", hash_original_method = "EE2B377CE8D615D75129B5A0881EF06D", hash_generated_method = "7984FC435A3A7867215F0AF3F1B6C573")
    
public Deflater(int level) {
        this(level, false);
    }

    /**
     * Constructs a new {@code Deflater} instance with a specific compression
     * level. If {@code noHeader} is true, no ZLIB header is added to the
     * output. In a ZIP archive every entry (compressed file) comes with such a
     * header. The strategy can be specified using {@link #setStrategy}.
     *
     * @param level
     *            the compression level in the range between 0 and 9.
     * @param noHeader
     *            {@code true} indicates that no ZLIB header should be written.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.783 -0500", hash_original_method = "2C334DD40EC2ED2E518DCA464DFDC51E", hash_generated_method = "4CD73A96FD978B4532E5D32548FEC5C8")
    
public Deflater(int level, boolean noHeader) {
        if (level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION) {
            throw new IllegalArgumentException();
        }
        compressLevel = level;
        streamHandle = createStream(compressLevel, strategy, noHeader);
        guard.open("end");
    }

    /**
     * Deflates the data (previously passed to {@link #setInput setInput}) into the
     * supplied buffer.
     *
     * @return number of bytes of compressed data written to {@code buf}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.785 -0500", hash_original_method = "611AF07E266F550F53CDF01F1CC352A1", hash_generated_method = "FC427B8EEC53AFC977E8B0D330D010BA")
    
public int deflate(byte[] buf) {
        return deflate(buf, 0, buf.length);
    }

    /**
     * Deflates data (previously passed to {@link #setInput setInput}) into a specific
     * region within the supplied buffer.
     *
     * @return the number of bytes of compressed data written to {@code buf}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.788 -0500", hash_original_method = "0A84F3CD8D711F8E28F74CE9A11C545E", hash_generated_method = "02F0C53054935B096D133B75CBDF0099")
    
public synchronized int deflate(byte[] buf, int offset, int byteCount) {
        return deflateImpl(buf, offset, byteCount, flushParm);
    }

    /**
     * Deflates data (previously passed to {@link #setInput setInput}) into a specific
     * region within the supplied buffer, optionally flushing the input buffer.
     *
     * @param flush one of {@link #NO_FLUSH}, {@link #SYNC_FLUSH} or {@link #FULL_FLUSH}.
     * @return the number of compressed bytes written to {@code buf}. If this
     *      equals {@code byteCount}, the number of bytes of input to be flushed
     *      may have exceeded the output buffer's capacity. In this case,
     *      finishing a flush will require the output buffer to be drained
     *      and additional calls to {@link #deflate} to be made.
     * @hide
     * @since 1.7
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.791 -0500", hash_original_method = "0DC5FF46D79769AAEF0B4E5EA32BA58D", hash_generated_method = "04C3B82E1BCE6669B5B47C959713746C")
    
public synchronized int deflate(byte[] buf, int offset, int byteCount, int flush) {
        if (flush != NO_FLUSH && flush != SYNC_FLUSH && flush != FULL_FLUSH) {
            throw new IllegalArgumentException("Bad flush value: " + flush);
        }
        return deflateImpl(buf, offset, byteCount, flush);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.794 -0500", hash_original_method = "CF6CE2BCD1B535E0E9CC69A73F69BC28", hash_generated_method = "A078D50FDF874C2FC1BC03968C7FEDA2")
    
private synchronized int deflateImpl(byte[] buf, int offset, int byteCount, int flush) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        if (inputBuffer == null) {
            setInput(EmptyArray.BYTE);
        }
        return deflateImpl(buf, offset, byteCount, streamHandle, flush);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.524 -0400", hash_original_method = "54CA80994C94CBB2D32C9857F1640D60", hash_generated_method = "1E6ADEC5F486A5F0536DA89705CD1920")
    
    private int deflateImpl(byte[] buf, int offset, int byteCount, long handle, int flushParm){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	taintDouble += flushParm;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    /**
     * Frees all resources held onto by this deflating algorithm. Any unused
     * input or output is discarded. This method should be called explicitly in
     * order to free native resources as soon as possible. After {@code end()} is
     * called, other methods will typically throw {@code IllegalStateException}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.800 -0500", hash_original_method = "59D998A9FACC96CAD9DEE3EEFD22688A", hash_generated_method = "FD85EB7EBAC8A6B33BB75FD0B188343E")
    
public synchronized void end() {
        guard.close();
        endImpl();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.803 -0500", hash_original_method = "4DA7D037A1FCD4109F30526C6DE57D1C", hash_generated_method = "5A4E6FDDE1BB7592807BB7526C139841")
    
private void endImpl() {
        if (streamHandle != -1) {
            endImpl(streamHandle);
            inputBuffer = null;
            streamHandle = -1;
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.525 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "D37840FF1F65E54A18F1909F3D74BED2")
    
    private void endImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.810 -0500", hash_original_method = "FC32DF56978CE95FA2CC2CA96409152E", hash_generated_method = "09E00EA73277F9B2AD883CD1303F9264")
    
@Override protected void finalize() {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            synchronized (this) {
                end(); // to allow overriding classes to clean up
                endImpl(); // in case those classes don't call super.end()
            }
        } finally {
            try {
                super.finalize();
            } catch (Throwable t) {
                throw new AssertionError(t);
            }
        }
    }

    /**
     * Indicates to the {@code Deflater} that all uncompressed input has been provided
     * to it.
     *
     * @see #finished
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.813 -0500", hash_original_method = "CE8BB8EC5EB7D8A83BE6D0D952D2FABD", hash_generated_method = "6E4DC661CEF6D6C634EA0F50B1605232")
    
public synchronized void finish() {
        flushParm = FINISH;
    }

    /**
     * Returns true if {@link #finish finish} has been called and all
     * data provided by {@link #setInput setInput} has been
     * successfully compressed and consumed by {@link #deflate deflate}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.815 -0500", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "9EE93713E74AD8A78F696927ADB1433F")
    
public synchronized boolean finished() {
        return finished;
    }

    /**
     * Returns the {@link Adler32} checksum of the uncompressed data read so far.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.818 -0500", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "82F839CE56BEDC13EDBA911A4636B0D0")
    
public synchronized int getAdler() {
        checkOpen();
        return getAdlerImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.528 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "61AA5FDACEC6651845F52881D1AA45E1")
    
    private int getAdlerImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    /**
     * Returns the total number of bytes of input read by this {@code Deflater}. This
     * method is limited to 32 bits; use {@link #getBytesRead} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.825 -0500", hash_original_method = "26E16A0AF7B91ACC2C2C1D26CF0A41A1", hash_generated_method = "D284806A89A9523A4B4F4E5202A70457")
    
public synchronized int getTotalIn() {
        checkOpen();
        return (int) getTotalInImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.529 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "FB76E0894AEC3C0AE237576E4437CBE2")
    
    private long getTotalInImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    /**
     * Returns the total number of bytes written to the output buffer by this {@code
     * Deflater}. The method is limited to 32 bits; use {@link #getBytesWritten} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.831 -0500", hash_original_method = "20FDDC2AB6FE185B9CAB89D86709EB03", hash_generated_method = "1FDB242971A3388A116AFC528BAAD583")
    
public synchronized int getTotalOut() {
        checkOpen();
        return (int) getTotalOutImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.530 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "5AF6B3DE8DAA8B45ECC40138EB65121D")
    
    private long getTotalOutImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    /**
     * Returns true if {@link #setInput setInput} must be called before deflation can continue.
     * If all uncompressed data has been provided to the {@code Deflater},
     * {@link #finish} must be called to ensure the compressed data is output.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.838 -0500", hash_original_method = "F6DEF148508A4D024151CB5B8FE739D4", hash_generated_method = "8994640FCDCD529BAA7DA9F474773FE7")
    
public synchronized boolean needsInput() {
        if (inputBuffer == null) {
            return true;
        }
        return inRead == inLength;
    }

    /**
     * Resets the {@code Deflater} to accept new input without affecting any
     * previously made settings for the compression strategy or level. This
     * operation <i>must</i> be called after {@link #finished} returns
     * true if the {@code Deflater} is to be reused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.841 -0500", hash_original_method = "F900704F0994CBD6978E5E4205C2BFAA", hash_generated_method = "5B35A3103A8BE7FA8114623903BDB649")
    
public synchronized void reset() {
        checkOpen();
        flushParm = NO_FLUSH;
        finished = false;
        resetImpl(streamHandle);
        inputBuffer = null;
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.531 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "E5AD6996270CB0317F4EFC6A63FC0EF4")
    
    private void resetImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    /**
     * Sets the dictionary to be used for compression by this {@code Deflater}.
     * This method can only be called if this {@code Deflater} supports the writing
     * of ZLIB headers. This is the default, but can be overridden
     * using {@link #Deflater(int, boolean)}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.847 -0500", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "086990A774EFC7D1A36FF93572821569")
    
public void setDictionary(byte[] dictionary) {
        setDictionary(dictionary, 0, dictionary.length);
    }

    /**
     * Sets the dictionary to be used for compression by this {@code Deflater}.
     * This method can only be called if this {@code Deflater} supports the writing
     * of ZLIB headers. This is the default, but can be overridden
     * using {@link #Deflater(int, boolean)}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.851 -0500", hash_original_method = "7FB505FB7F1826F86B368368EBDBCA40", hash_generated_method = "4AF53AB1FC1CD1B06CB20B6F4E90756C")
    
public synchronized void setDictionary(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        setDictionaryImpl(buf, offset, byteCount, streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.533 -0400", hash_original_method = "7E435812B66ABED0B356693E1B3AC0D7", hash_generated_method = "410D1701A2AFAF799D79F1813807FE5A")
    
    private void setDictionaryImpl(byte[] buf, int offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    /**
     * Sets the input buffer the {@code Deflater} will use to extract uncompressed bytes
     * for later compression.
     */
    @DSSink({DSSinkKind.IO})
    @DSSafe(DSCat.UTIL_FUNCTION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.857 -0500", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "19B3B4D9BFCD113AADCC6DB794F536DA")
    
public void setInput(byte[] buf) {
        setInput(buf, 0, buf.length);
    }

    /**
     * Sets the input buffer the {@code Deflater} will use to extract uncompressed bytes
     * for later compression.
     */
    @DSSink({DSSinkKind.IO})
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.860 -0500", hash_original_method = "5EAC232252C5BA68B98F924DC24DA75C", hash_generated_method = "F84DF425B88F7030AFB1ADE467975000")
    
public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inLength = byteCount;
        inRead = 0;
        if (inputBuffer == null) {
            setLevelsImpl(compressLevel, strategy, streamHandle);
        }
        inputBuffer = buf;
        setInputImpl(buf, offset, byteCount, streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.535 -0400", hash_original_method = "6366C8E331223E53339096A4FF906729", hash_generated_method = "F498BBC9F5D71014544CEBA66B82D21E")
    
    private void setLevelsImpl(int level, int strategy, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += level;
    	taintDouble += strategy;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.536 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "D0CB44C44F11094BAD5A989A17A93627")
    
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    /**
     * Sets the compression level to be used when compressing data. The
     * compression level must be a value between 0 and 9. This value must be set
     * prior to calling {@link #setInput setInput}.
     * @exception IllegalArgumentException
     *                If the compression level is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.871 -0500", hash_original_method = "56416D14F8B23CE0A4E07C0AD61CD8D1", hash_generated_method = "D6E7B94614B19EB00B5D403095381D75")
    
public synchronized void setLevel(int level) {
        if (level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION) {
            throw new IllegalArgumentException("Bad level: " + level);
        }
        if (inputBuffer != null) {
            throw new IllegalStateException("setLevel cannot be called after setInput");
        }
        compressLevel = level;
    }

    /**
     * Sets the compression strategy to be used. The strategy must be one of
     * FILTERED, HUFFMAN_ONLY or DEFAULT_STRATEGY. This value must be set prior
     * to calling {@link #setInput setInput}.
     *
     * @exception IllegalArgumentException
     *                If the strategy specified is not one of FILTERED,
     *                HUFFMAN_ONLY or DEFAULT_STRATEGY.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.873 -0500", hash_original_method = "9A84D355252A826695237C59231B1742", hash_generated_method = "DFB868324F54D195331F1F28A1CC7F3B")
    
public synchronized void setStrategy(int strategy) {
        if (strategy < DEFAULT_STRATEGY || strategy > HUFFMAN_ONLY) {
            throw new IllegalArgumentException("Bad strategy: " + strategy);
        }
        if (inputBuffer != null) {
            throw new IllegalStateException("setStrategy cannot be called after setInput");
        }
        this.strategy = strategy;
    }

    /**
     * Returns the total number of bytes read by the {@code Deflater}. This
     * method is the same as {@link #getTotalIn} except that it returns a
     * {@code long} value instead of an integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.876 -0500", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "FCE91DCC2F170EFCCC587BDC96E02BDA")
    
public synchronized long getBytesRead() {
        checkOpen();
        return getTotalInImpl(streamHandle);
    }

    /**
     * Returns a the total number of bytes written by this {@code Deflater}. This
     * method is the same as {@code getTotalOut} except it returns a
     * {@code long} value instead of an integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.879 -0500", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "6759B83D7E1BB8BF4188E4F21BEAB91C")
    
public synchronized long getBytesWritten() {
        checkOpen();
        return getTotalOutImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.538 -0400", hash_original_method = "C56CB62EAF4356747257EC4F43A6E2A6", hash_generated_method = "BEDDA6B061A376260BA66ADFD27ACE2B")
    
    private long createStream(int level, int strategy1, boolean noHeader1){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += level;
    	taintDouble += strategy1;
    	taintDouble += ((noHeader1) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.885 -0500", hash_original_method = "367A42A5784C609E2D8E37BE922AB4A4", hash_generated_method = "6E548EC6D5D2EE4AE8DEE8BBBE547265")
    
private void checkOpen() {
        if (streamHandle == -1) {
            throw new IllegalStateException("attempt to use Deflater after calling end");
        }
    }
}

