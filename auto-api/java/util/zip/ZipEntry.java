package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import libcore.io.Streams;
import libcore.io.BufferIterator;
import libcore.io.HeapBufferIterator;

public class ZipEntry implements ZipConstants, Cloneable {
    String name, comment;
    long compressedSize = -1, crc = -1, size = -1;
    int compressionMethod = -1, time = -1, modDate = -1;
    byte[] extra;
    int nameLength = -1;
    long mLocalHeaderRelOffset = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.865 -0400", hash_original_method = "60F10CCF439EC77C0A98401AA44AF184", hash_generated_method = "AF45A10614A04A249D5E93925241CEA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZipEntry(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varFF5F76428D2BF7BFF89C465C4C5EC5A8_1895640002 = (name.length() > 0xFFFF);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name too long: " + name.length());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (name.length() > 0xFFFF) {
            //throw new IllegalArgumentException("Name too long: " + name.length());
        //}
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.865 -0400", hash_original_method = "61E22A8AE090FB92E1157A3CABA3C550", hash_generated_method = "08A03EA379AE71CD04428ABF05F80280")
    @DSModeled(DSC.SAFE)
    public ZipEntry(ZipEntry ze) {
        dsTaint.addTaint(ze.dsTaint);
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
        // ---------- Original Method ----------
        //name = ze.name;
        //comment = ze.comment;
        //time = ze.time;
        //size = ze.size;
        //compressedSize = ze.compressedSize;
        //crc = ze.crc;
        //compressionMethod = ze.compressionMethod;
        //modDate = ze.modDate;
        //extra = ze.extra;
        //nameLength = ze.nameLength;
        //mLocalHeaderRelOffset = ze.mLocalHeaderRelOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.866 -0400", hash_original_method = "30F30B41DA6F50936D6BF4103A049FEE", hash_generated_method = "91EE6ECB4A8A13716DFBC0AD08E7F255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZipEntry(byte[] hdrBuf, InputStream in) throws IOException {
        dsTaint.addTaint(hdrBuf[0]);
        dsTaint.addTaint(in.dsTaint);
        Streams.readFully(in, hdrBuf, 0, hdrBuf.length);
        BufferIterator it;
        it = HeapBufferIterator.iterator(hdrBuf, 0, hdrBuf.length, ByteOrder.LITTLE_ENDIAN);
        int sig;
        sig = it.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new ZipException("Central Directory Entry not found");
        } //End block
        it.seek(10);
        compressionMethod = it.readShort();
        time = it.readShort();
        modDate = it.readShort();
        crc = ((long) it.readInt()) & 0xffffffffL;
        compressedSize = ((long) it.readInt()) & 0xffffffffL;
        size = ((long) it.readInt()) & 0xffffffffL;
        nameLength = it.readShort();
        int extraLength;
        extraLength = it.readShort();
        int commentLength;
        commentLength = it.readShort();
        it.seek(42);
        mLocalHeaderRelOffset = ((long) it.readInt()) & 0xffffffffL;
        byte[] nameBytes;
        nameBytes = new byte[nameLength];
        Streams.readFully(in, nameBytes, 0, nameBytes.length);
        name = new String(nameBytes, 0, nameBytes.length, Charsets.UTF_8);
        {
            byte[] commentBytes;
            commentBytes = new byte[commentLength];
            Streams.readFully(in, commentBytes, 0, commentLength);
            comment = new String(commentBytes, 0, commentBytes.length, Charsets.UTF_8);
        } //End block
        {
            extra = new byte[extraLength];
            Streams.readFully(in, extra, 0, extraLength);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.866 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E5CCC5133F55EB384CCE0D646E5A9DAF")
    @DSModeled(DSC.SAFE)
    public String getComment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.866 -0400", hash_original_method = "BD185E24018FAED136FF653216A88FC6", hash_generated_method = "C5F1F5CF5ECC829EA5EB5F139E623333")
    @DSModeled(DSC.SAFE)
    public long getCompressedSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return compressedSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.867 -0400", hash_original_method = "9F9CC7112652CAA1DD447640E3933AED", hash_generated_method = "7F030930D3E3B5349BF62B81ABE9EC24")
    @DSModeled(DSC.SAFE)
    public long getCrc() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return crc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.867 -0400", hash_original_method = "12884DA1C8E953155933C9EDA5E5913F", hash_generated_method = "46A74331DF96D5E9363D317321ECC8D1")
    @DSModeled(DSC.SAFE)
    public byte[] getExtra() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return extra;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.867 -0400", hash_original_method = "5D6E0D5CF72121589416F8E200760163", hash_generated_method = "2932B1A04120DF1AB745351DCF1070BE")
    @DSModeled(DSC.SAFE)
    public int getMethod() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compressionMethod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.867 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.867 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "73F9394B6399A15FBFEDB9A78D4AAF85")
    @DSModeled(DSC.SAFE)
    public long getSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.868 -0400", hash_original_method = "56915B75BB1F78598E38415E47FB9273", hash_generated_method = "109E8ECD7BB2591AD64F457D698E0766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTime() {
        {
            GregorianCalendar cal;
            cal = new GregorianCalendar();
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf) - 1,
                    modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f,
                    (time & 0x1f) << 1);
            long varCB0503844257A960EA4CE2FBE4C1D96A_741390111 = (cal.getTime().getTime());
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (time != -1) {
            //GregorianCalendar cal = new GregorianCalendar();
            //cal.set(Calendar.MILLISECOND, 0);
            //cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf) - 1,
                    //modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f,
                    //(time & 0x1f) << 1);
            //return cal.getTime().getTime();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.868 -0400", hash_original_method = "4596D564DD1CB7B8029ED574B004E951", hash_generated_method = "4DCD093BD5833B7867BE377A0E19FE6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDirectory() {
        boolean var7504AB0512AB71FEF3581A9B7F0CDEC4_2137664917 = (name.charAt(name.length() - 1) == '/');
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return name.charAt(name.length() - 1) == '/';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.868 -0400", hash_original_method = "CEDBC8A76FB638A9ACF67956D150D744", hash_generated_method = "D177DA6EB4DDCFCA1FFA4908DA9B1A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComment(String comment) {
        dsTaint.addTaint(comment);
        {
            boolean var4D71C7E4E30F10C454926F8539745204_562763992 = (comment == null || comment.length() <= 0xFFFF);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (comment == null || comment.length() <= 0xFFFF) {
            //this.comment = comment;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.868 -0400", hash_original_method = "24AF7AE4A55FD751B6B8B8E36C8E6668", hash_generated_method = "4A11FDE2B481DE5DD25EC665FB4C3F54")
    @DSModeled(DSC.SAFE)
    public void setCompressedSize(long value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //compressedSize = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.869 -0400", hash_original_method = "838546BA41BB934E0DEE95030FA7BCCE", hash_generated_method = "0E344660634A663672373D435E15F703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCrc(long value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad CRC32: " + value);
        } //End block
        // ---------- Original Method ----------
        //if (value >= 0 && value <= 0xFFFFFFFFL) {
            //crc = value;
        //} else {
            //throw new IllegalArgumentException("Bad CRC32: " + value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.869 -0400", hash_original_method = "F86C78C263DDE84D2589BD04BFB70D1E", hash_generated_method = "69A44F7C4FB505D5C1295A818BE0B559")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtra(byte[] data) {
        dsTaint.addTaint(data[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (data == null || data.length <= 0xFFFF) {
            //extra = data;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.869 -0400", hash_original_method = "2D1E6DE59F6C5F9CB50232902EB42CEC", hash_generated_method = "0EDB4E288217183DCD59D2812FD613D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethod(int value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad method: " + value);
        } //End block
        // ---------- Original Method ----------
        //if (value != STORED && value != DEFLATED) {
            //throw new IllegalArgumentException("Bad method: " + value);
        //}
        //compressionMethod = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.869 -0400", hash_original_method = "3723D5CA75C443A890F342FC88C4BC79", hash_generated_method = "785DFD6AB45BC521032D04D64B4FB8EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSize(long value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad size: " + value);
        } //End block
        // ---------- Original Method ----------
        //if (value >= 0 && value <= 0xFFFFFFFFL) {
            //size = value;
        //} else {
            //throw new IllegalArgumentException("Bad size: " + value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.870 -0400", hash_original_method = "ADBF978AE56F7313634C406FFD3BF538", hash_generated_method = "FEEBCDD0EA75A613272A17D28B4A673D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTime(long value) {
        dsTaint.addTaint(value);
        GregorianCalendar cal;
        cal = new GregorianCalendar();
        cal.setTime(new Date(value));
        int year;
        year = cal.get(Calendar.YEAR);
        {
            modDate = 0x21;
            time = 0;
        } //End block
        {
            modDate = cal.get(Calendar.DATE);
            modDate = (cal.get(Calendar.MONTH) + 1 << 5) | modDate;
            modDate = ((cal.get(Calendar.YEAR) - 1980) << 9) | modDate;
            time = cal.get(Calendar.SECOND) >> 1;
            time = (cal.get(Calendar.MINUTE) << 5) | time;
            time = (cal.get(Calendar.HOUR_OF_DAY) << 11) | time;
        } //End block
        // ---------- Original Method ----------
        //GregorianCalendar cal = new GregorianCalendar();
        //cal.setTime(new Date(value));
        //int year = cal.get(Calendar.YEAR);
        //if (year < 1980) {
            //modDate = 0x21;
            //time = 0;
        //} else {
            //modDate = cal.get(Calendar.DATE);
            //modDate = (cal.get(Calendar.MONTH) + 1 << 5) | modDate;
            //modDate = ((cal.get(Calendar.YEAR) - 1980) << 9) | modDate;
            //time = cal.get(Calendar.SECOND) >> 1;
            //time = (cal.get(Calendar.MINUTE) << 5) | time;
            //time = (cal.get(Calendar.HOUR_OF_DAY) << 11) | time;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.870 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "07B6DEDCDA0BCBF94ECA7AFA0C3C49FD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.870 -0400", hash_original_method = "CC5347E979B0813386EC9E9DE77BBA76", hash_generated_method = "89B43AF6B207A83161EF555E806BB1A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            ZipEntry result;
            result = (ZipEntry) super.clone();
            result.extra = extra != null ? extra.clone() : null;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //ZipEntry result = (ZipEntry) super.clone();
            //result.extra = extra != null ? extra.clone() : null;
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.870 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "DB029271DD504605549F91EBD610D763")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_2054456876 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
}

