package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import libcore.io.BufferIterator;
import libcore.io.HeapBufferIterator;
import libcore.io.Streams;

public class ZipEntry implements ZipConstants, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.303 -0500", hash_original_field = "76C48874DF3F847D8799A9755C24ED8B", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.307 -0500", hash_original_field = "5C7A58E94B0366CCD8319D0DE1E9C38C", hash_generated_field = "C303454481B8041CEF37C1E89A2E0D63")

    public static final int STORED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

    String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "6C9FE4127C88B2FD28EFE861CA65A713")

    String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "C5E5A955FA15B20B3341DBBE88FC7A86", hash_generated_field = "478CA1ABD1000352F0D3B41DF1BC279C")

    long compressedSize = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "5C56311F54A7F40FAE6AFE3628ADC545", hash_generated_field = "FD3FB5730AEB4A6C989707CB73029195")

    long crc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "304D03889695AEE9913D341019E1E376", hash_generated_field = "A9A882B5A3A733E9894435C866426B82")

    long size = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "BF4C950D8399B9737456D4D33896D59B", hash_generated_field = "42BA978FE70CA4813B7E014BB946F0B0")

    int compressionMethod = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "F4B056B63B98600F9120FEB1C129B502", hash_generated_field = "83E94A8F4FE01AB901FF6388E2A539CB")

    int time = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "50DFF0173F283C416C0F84DE329BEAB6", hash_generated_field = "7F3B557606C1E0A605131CB47C9B3638")

    int modDate = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.297 -0500", hash_original_field = "4DB50909B6C3CA3BD728DB05D0FA3D9B", hash_generated_field = "4DB50909B6C3CA3BD728DB05D0FA3D9B")

    byte[] extra;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.299 -0500", hash_original_field = "5ED088AEC2A67EA91C7AE0A2164EEA41", hash_generated_field = "5ED088AEC2A67EA91C7AE0A2164EEA41")

    int nameLength = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.301 -0500", hash_original_field = "675B1E366E23748C61289B20C0ED87D0", hash_generated_field = "675B1E366E23748C61289B20C0ED87D0")

    long mLocalHeaderRelOffset = -1;

    /**
     * Constructs a new {@code ZipEntry} with the specified name.
     *
     * @param name
     *            the name of the ZIP entry.
     * @throws IllegalArgumentException
     *             if the name length is outside the range (> 0xFFFF).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.310 -0500", hash_original_method = "60F10CCF439EC77C0A98401AA44AF184", hash_generated_method = "F5AE49741A518153E5A7FD0732EEE752")
    
public ZipEntry(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        if (name.length() > 0xFFFF) {
            throw new IllegalArgumentException("Name too long: " + name.length());
        }
        this.name = name;
    }

    /**
     * Constructs a new {@code ZipEntry} using the values obtained from {@code
     * ze}.
     *
     * @param ze
     *            the {@code ZipEntry} from which to obtain values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.357 -0500", hash_original_method = "61E22A8AE090FB92E1157A3CABA3C550", hash_generated_method = "3EBE4419052845F92E599C1C14FCA073")
    
public ZipEntry(ZipEntry ze) {
        name = ze.name;
        comment = ze.comment;
        time = ze.time;
        size = ze.size;
        compressedSize = ze.compressedSize;
        crc = ze.crc;
        compressionMethod = ze.compressionMethod;
        modDate = ze.modDate;
        extra = ze.extra;
        nameLength = ze.nameLength;
        mLocalHeaderRelOffset = ze.mLocalHeaderRelOffset;
    }

    /*
     * Internal constructor.  Creates a new ZipEntry by reading the
     * Central Directory Entry from "in", which must be positioned at
     * the CDE signature.
     *
     * On exit, "in" will be positioned at the start of the next entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.367 -0500", hash_original_method = "30F30B41DA6F50936D6BF4103A049FEE", hash_generated_method = "8D65F2E329523CA8B82B4DE7CB4195AD")
    
ZipEntry(byte[] hdrBuf, InputStream in) throws IOException {
        Streams.readFully(in, hdrBuf, 0, hdrBuf.length);

        BufferIterator it = HeapBufferIterator.iterator(hdrBuf, 0, hdrBuf.length, ByteOrder.LITTLE_ENDIAN);

        int sig = it.readInt();
        if (sig != CENSIG) {
             throw new ZipException("Central Directory Entry not found");
        }

        it.seek(10);
        compressionMethod = it.readShort();
        time = it.readShort();
        modDate = it.readShort();

        // These are 32-bit values in the file, but 64-bit fields in this object.
        crc = ((long) it.readInt()) & 0xffffffffL;
        compressedSize = ((long) it.readInt()) & 0xffffffffL;
        size = ((long) it.readInt()) & 0xffffffffL;

        nameLength = it.readShort();
        int extraLength = it.readShort();
        int commentLength = it.readShort();

        // This is a 32-bit value in the file, but a 64-bit field in this object.
        it.seek(42);
        mLocalHeaderRelOffset = ((long) it.readInt()) & 0xffffffffL;

        byte[] nameBytes = new byte[nameLength];
        Streams.readFully(in, nameBytes, 0, nameBytes.length);
        name = new String(nameBytes, 0, nameBytes.length, Charsets.UTF_8);

        // The RI has always assumed UTF-8. (If GPBF_UTF8_FLAG isn't set, the encoding is
        // actually IBM-437.)
        if (commentLength > 0) {
            byte[] commentBytes = new byte[commentLength];
            Streams.readFully(in, commentBytes, 0, commentLength);
            comment = new String(commentBytes, 0, commentBytes.length, Charsets.UTF_8);
        }

        if (extraLength > 0) {
            extra = new byte[extraLength];
            Streams.readFully(in, extra, 0, extraLength);
        }
    }

    /**
     * Gets the comment for this {@code ZipEntry}.
     *
     * @return the comment for this {@code ZipEntry}, or {@code null} if there
     *         is no comment. If we're reading an archive with
     *         {@code ZipInputStream} the comment is not available.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.312 -0500", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E40F10878D62F1009133973700BC0B5C")
    
public String getComment() {
        return comment;
    }

    /**
     * Gets the compressed size of this {@code ZipEntry}.
     *
     * @return the compressed size, or -1 if the compressed size has not been
     *         set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.314 -0500", hash_original_method = "BD185E24018FAED136FF653216A88FC6", hash_generated_method = "618115E6AFA25933753DDB659E8201D9")
    
public long getCompressedSize() {
        return compressedSize;
    }

    /**
     * Gets the checksum for this {@code ZipEntry}.
     *
     * @return the checksum, or -1 if the checksum has not been set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.318 -0500", hash_original_method = "9F9CC7112652CAA1DD447640E3933AED", hash_generated_method = "5096DC92A02BC3D5F3C9C04FCC34F0DB")
    
public long getCrc() {
        return crc;
    }

    /**
     * Gets the extra information for this {@code ZipEntry}.
     *
     * @return a byte array containing the extra information, or {@code null} if
     *         there is none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.320 -0500", hash_original_method = "12884DA1C8E953155933C9EDA5E5913F", hash_generated_method = "D75852F09EA6AE77443AF8398BA9726E")
    
public byte[] getExtra() {
        return extra;
    }

    /**
     * Gets the compression method for this {@code ZipEntry}.
     *
     * @return the compression method, either {@code DEFLATED}, {@code STORED}
     *         or -1 if the compression method has not been set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.322 -0500", hash_original_method = "5D6E0D5CF72121589416F8E200760163", hash_generated_method = "2814E00E387AF31379BCB7F27E4D2902")
    
public int getMethod() {
        return compressionMethod;
    }

    /**
     * Gets the name of this {@code ZipEntry}.
     *
     * @return the entry name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.325 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Gets the uncompressed size of this {@code ZipEntry}.
     *
     * @return the uncompressed size, or {@code -1} if the size has not been
     *         set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.327 -0500", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "EB3DBFDE453A5D88801767E17B680EEE")
    
public long getSize() {
        return size;
    }

    /**
     * Gets the last modification time of this {@code ZipEntry}.
     *
     * @return the last modification time as the number of milliseconds since
     *         Jan. 1, 1970.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.330 -0500", hash_original_method = "56915B75BB1F78598E38415E47FB9273", hash_generated_method = "DCBFB3FD066C705D17A8774B0FD308D7")
    
public long getTime() {
        if (time != -1) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf) - 1,
                    modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f,
                    (time & 0x1f) << 1);
            return cal.getTime().getTime();
        }
        return -1;
    }

    /**
     * Determine whether or not this {@code ZipEntry} is a directory.
     *
     * @return {@code true} when this {@code ZipEntry} is a directory, {@code
     *         false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.332 -0500", hash_original_method = "4596D564DD1CB7B8029ED574B004E951", hash_generated_method = "6DC5C14B19BFC6BD79DFAFD26F16A37A")
    
public boolean isDirectory() {
        return name.charAt(name.length() - 1) == '/';
    }

    /**
     * Sets the comment for this {@code ZipEntry}.
     *
     * @param comment
     *            the comment for this entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.335 -0500", hash_original_method = "CEDBC8A76FB638A9ACF67956D150D744", hash_generated_method = "8BEAA9AAAE222EF32D3CDA6C69F8CBF2")
    
public void setComment(String comment) {
        if (comment == null || comment.length() <= 0xFFFF) {
            this.comment = comment;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the compressed size for this {@code ZipEntry}.
     *
     * @param value
     *            the compressed size (in bytes).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.337 -0500", hash_original_method = "24AF7AE4A55FD751B6B8B8E36C8E6668", hash_generated_method = "D822921F2230771E368E17EFDA92BAD0")
    
public void setCompressedSize(long value) {
        compressedSize = value;
    }

    /**
     * Sets the checksum for this {@code ZipEntry}.
     *
     * @param value
     *            the checksum for this entry.
     * @throws IllegalArgumentException
     *             if {@code value} is < 0 or > 0xFFFFFFFFL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.340 -0500", hash_original_method = "838546BA41BB934E0DEE95030FA7BCCE", hash_generated_method = "A40348576F3C1524440EB2AE0A784F27")
    
public void setCrc(long value) {
        if (value >= 0 && value <= 0xFFFFFFFFL) {
            crc = value;
        } else {
            throw new IllegalArgumentException("Bad CRC32: " + value);
        }
    }

    /**
     * Sets the extra information for this {@code ZipEntry}.
     *
     * @param data
     *            a byte array containing the extra information.
     * @throws IllegalArgumentException
     *             when the length of data is greater than 0xFFFF bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.343 -0500", hash_original_method = "F86C78C263DDE84D2589BD04BFB70D1E", hash_generated_method = "E50C3DCF7E9C2CC9EB51606F81AB60F4")
    
public void setExtra(byte[] data) {
        if (data == null || data.length <= 0xFFFF) {
            extra = data;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the compression method for this {@code ZipEntry}.
     *
     * @param value
     *            the compression method, either {@code DEFLATED} or {@code
     *            STORED}.
     * @throws IllegalArgumentException
     *             when value is not {@code DEFLATED} or {@code STORED}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.345 -0500", hash_original_method = "2D1E6DE59F6C5F9CB50232902EB42CEC", hash_generated_method = "C49A8F971B1C88D21C1F61929D62C1BB")
    
public void setMethod(int value) {
        if (value != STORED && value != DEFLATED) {
            throw new IllegalArgumentException("Bad method: " + value);
        }
        compressionMethod = value;
    }

    /**
     * Sets the uncompressed size of this {@code ZipEntry}.
     *
     * @param value
     *            the uncompressed size for this entry.
     * @throws IllegalArgumentException
     *             if {@code value} < 0 or {@code value} > 0xFFFFFFFFL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.348 -0500", hash_original_method = "3723D5CA75C443A890F342FC88C4BC79", hash_generated_method = "9A5932A8B6BB9493282A41805E8FD195")
    
public void setSize(long value) {
        if (value >= 0 && value <= 0xFFFFFFFFL) {
            size = value;
        } else {
            throw new IllegalArgumentException("Bad size: " + value);
        }
    }

    /**
     * Sets the modification time of this {@code ZipEntry}.
     *
     * @param value
     *            the modification time as the number of milliseconds since Jan.
     *            1, 1970.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.351 -0500", hash_original_method = "ADBF978AE56F7313634C406FFD3BF538", hash_generated_method = "827755DBC6CCDCE7DA5662AAEBB810D7")
    
public void setTime(long value) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(value));
        int year = cal.get(Calendar.YEAR);
        if (year < 1980) {
            modDate = 0x21;
            time = 0;
        } else {
            modDate = cal.get(Calendar.DATE);
            modDate = (cal.get(Calendar.MONTH) + 1 << 5) | modDate;
            modDate = ((cal.get(Calendar.YEAR) - 1980) << 9) | modDate;
            time = cal.get(Calendar.SECOND) >> 1;
            time = (cal.get(Calendar.MINUTE) << 5) | time;
            time = (cal.get(Calendar.HOUR_OF_DAY) << 11) | time;
        }
    }

    /**
     * Returns the string representation of this {@code ZipEntry}.
     *
     * @return the string representation of this {@code ZipEntry}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.354 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }

    /**
     * Returns a deep copy of this zip entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.361 -0500", hash_original_method = "CC5347E979B0813386EC9E9DE77BBA76", hash_generated_method = "2369D231E720E4DD7AA31AD4AE508C0D")
    
@Override public Object clone() {
        try {
            ZipEntry result = (ZipEntry) super.clone();
            result.extra = extra != null ? extra.clone() : null;
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns the hash code for this {@code ZipEntry}.
     *
     * @return the hash code of the entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.363 -0500", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "79AB96931D4D2744C8AC02B11E3A7517")
    
@Override
    public int hashCode() {
        return name.hashCode();
    }
}

