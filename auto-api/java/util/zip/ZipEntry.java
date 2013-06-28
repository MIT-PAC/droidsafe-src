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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.891 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

    String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.891 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "6C9FE4127C88B2FD28EFE861CA65A713")

    String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.891 -0400", hash_original_field = "C5E5A955FA15B20B3341DBBE88FC7A86", hash_generated_field = "478CA1ABD1000352F0D3B41DF1BC279C")

    long compressedSize = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.891 -0400", hash_original_field = "5C56311F54A7F40FAE6AFE3628ADC545", hash_generated_field = "FD3FB5730AEB4A6C989707CB73029195")

    long crc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "304D03889695AEE9913D341019E1E376", hash_generated_field = "A9A882B5A3A733E9894435C866426B82")

    long size = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "BF4C950D8399B9737456D4D33896D59B", hash_generated_field = "42BA978FE70CA4813B7E014BB946F0B0")

    int compressionMethod = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "F4B056B63B98600F9120FEB1C129B502", hash_generated_field = "83E94A8F4FE01AB901FF6388E2A539CB")

    int time = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "50DFF0173F283C416C0F84DE329BEAB6", hash_generated_field = "7F3B557606C1E0A605131CB47C9B3638")

    int modDate = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "EA9F91B2CDA019730F2891BD12A7A4D6", hash_generated_field = "4DB50909B6C3CA3BD728DB05D0FA3D9B")

    byte[] extra;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "1858EB989B5C48C5F78690997386A30C", hash_generated_field = "5ED088AEC2A67EA91C7AE0A2164EEA41")

    int nameLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_field = "A73F9B31C6C9894483E283B195B46914", hash_generated_field = "675B1E366E23748C61289B20C0ED87D0")

    long mLocalHeaderRelOffset = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.892 -0400", hash_original_method = "60F10CCF439EC77C0A98401AA44AF184", hash_generated_method = "06CEFE024C4151664B3266FE53A46AAB")
    public  ZipEntry(String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varFF5F76428D2BF7BFF89C465C4C5EC5A8_1420261568 = (name.length() > 0xFFFF);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name too long: " + name.length());
            } //End block
        } //End collapsed parenthetic
        this.name = name;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (name.length() > 0xFFFF) {
            //throw new IllegalArgumentException("Name too long: " + name.length());
        //}
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.893 -0400", hash_original_method = "61E22A8AE090FB92E1157A3CABA3C550", hash_generated_method = "EE7980F5AAA554D14BBE4B0FC31F3A68")
    public  ZipEntry(ZipEntry ze) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.894 -0400", hash_original_method = "30F30B41DA6F50936D6BF4103A049FEE", hash_generated_method = "3F1ECCB541EE958D338FF1160EA64583")
      ZipEntry(byte[] hdrBuf, InputStream in) throws IOException {
        Streams.readFully(in, hdrBuf, 0, hdrBuf.length);
        BufferIterator it = HeapBufferIterator.iterator(hdrBuf, 0, hdrBuf.length, ByteOrder.LITTLE_ENDIAN);
        int sig = it.readInt();
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
        int extraLength = it.readShort();
        int commentLength = it.readShort();
        it.seek(42);
        mLocalHeaderRelOffset = ((long) it.readInt()) & 0xffffffffL;
        byte[] nameBytes = new byte[nameLength];
        Streams.readFully(in, nameBytes, 0, nameBytes.length);
        name = new String(nameBytes, 0, nameBytes.length, Charsets.UTF_8);
        {
            byte[] commentBytes = new byte[commentLength];
            Streams.readFully(in, commentBytes, 0, commentLength);
            comment = new String(commentBytes, 0, commentBytes.length, Charsets.UTF_8);
        } //End block
        {
            extra = new byte[extraLength];
            Streams.readFully(in, extra, 0, extraLength);
        } //End block
        addTaint(hdrBuf[0]);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.894 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "49D118935F1D12B565BCFE1A717925CB")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1279957971 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1279957971 = comment;
        varB4EAC82CA7396A68D541C85D26508E83_1279957971.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279957971;
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.895 -0400", hash_original_method = "BD185E24018FAED136FF653216A88FC6", hash_generated_method = "8E01983F834F989080DC74BB3984968F")
    public long getCompressedSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_114711603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_114711603;
        // ---------- Original Method ----------
        //return compressedSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.895 -0400", hash_original_method = "9F9CC7112652CAA1DD447640E3933AED", hash_generated_method = "E776324E689B99E0971D5D6ED03A571D")
    public long getCrc() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1084042774 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1084042774;
        // ---------- Original Method ----------
        //return crc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.896 -0400", hash_original_method = "12884DA1C8E953155933C9EDA5E5913F", hash_generated_method = "FA883AA05CDF74268D26BE69D74C19DF")
    public byte[] getExtra() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1754260426 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1754260426;
        // ---------- Original Method ----------
        //return extra;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.896 -0400", hash_original_method = "5D6E0D5CF72121589416F8E200760163", hash_generated_method = "7FD8AB8DFA486CD36EE7A38F55E33EC0")
    public int getMethod() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040386280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040386280;
        // ---------- Original Method ----------
        //return compressionMethod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.896 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A2E413946FA10216E9FD2520A7BE8479")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_966213024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_966213024 = name;
        varB4EAC82CA7396A68D541C85D26508E83_966213024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966213024;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.897 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "D9397827F16C352687767C5867897C8C")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_87940551 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_87940551;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.897 -0400", hash_original_method = "56915B75BB1F78598E38415E47FB9273", hash_generated_method = "5DECC8B43A32AC0EA36F8CB2B456EFC7")
    public long getTime() {
        {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf) - 1,
                    modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f,
                    (time & 0x1f) << 1);
            long varCB0503844257A960EA4CE2FBE4C1D96A_771269585 = (cal.getTime().getTime());
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_86962418 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_86962418;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.897 -0400", hash_original_method = "4596D564DD1CB7B8029ED574B004E951", hash_generated_method = "491C19C89A912E44F78F44E27590CAE6")
    public boolean isDirectory() {
        boolean var7504AB0512AB71FEF3581A9B7F0CDEC4_162723286 = (name.charAt(name.length() - 1) == '/');
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383873368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383873368;
        // ---------- Original Method ----------
        //return name.charAt(name.length() - 1) == '/';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.898 -0400", hash_original_method = "CEDBC8A76FB638A9ACF67956D150D744", hash_generated_method = "A4CE71AA1DE1BD5E05D6741468F1B689")
    public void setComment(String comment) {
        {
            boolean var4D71C7E4E30F10C454926F8539745204_572752382 = (comment == null || comment.length() <= 0xFFFF);
            {
                this.comment = comment;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.898 -0400", hash_original_method = "24AF7AE4A55FD751B6B8B8E36C8E6668", hash_generated_method = "334A47E452019AA69BE98A99FED4C96B")
    public void setCompressedSize(long value) {
        compressedSize = value;
        // ---------- Original Method ----------
        //compressedSize = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.898 -0400", hash_original_method = "838546BA41BB934E0DEE95030FA7BCCE", hash_generated_method = "4D998BF000A043E7EA1C30FDFC693AFF")
    public void setCrc(long value) {
        {
            crc = value;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.899 -0400", hash_original_method = "F86C78C263DDE84D2589BD04BFB70D1E", hash_generated_method = "891B1752DB30327F6B70EA6FF27D781D")
    public void setExtra(byte[] data) {
        {
            extra = data;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.899 -0400", hash_original_method = "2D1E6DE59F6C5F9CB50232902EB42CEC", hash_generated_method = "A271D69A0F1897DD6C159D7A91F8CCE0")
    public void setMethod(int value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad method: " + value);
        } //End block
        compressionMethod = value;
        // ---------- Original Method ----------
        //if (value != STORED && value != DEFLATED) {
            //throw new IllegalArgumentException("Bad method: " + value);
        //}
        //compressionMethod = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.900 -0400", hash_original_method = "3723D5CA75C443A890F342FC88C4BC79", hash_generated_method = "09BB1F8A3F3B73899AEA07AAC1519222")
    public void setSize(long value) {
        {
            size = value;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.901 -0400", hash_original_method = "ADBF978AE56F7313634C406FFD3BF538", hash_generated_method = "228868D04FB3468A4E8F5D458206E862")
    public void setTime(long value) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(value));
        int year = cal.get(Calendar.YEAR);
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
        addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.901 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "60A3DF06D9186AFE7626ED7781A09D46")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_205269276 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_205269276 = name;
        varB4EAC82CA7396A68D541C85D26508E83_205269276.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_205269276;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.902 -0400", hash_original_method = "CC5347E979B0813386EC9E9DE77BBA76", hash_generated_method = "AD5C47CC24B131303B698FF5B76E5ED7")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2023912752 = null; //Variable for return #1
        try 
        {
            ZipEntry result = (ZipEntry) super.clone();
            result.extra = extra != null ? extra.clone() : null;
            varB4EAC82CA7396A68D541C85D26508E83_2023912752 = result;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2023912752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2023912752;
        // ---------- Original Method ----------
        //try {
            //ZipEntry result = (ZipEntry) super.clone();
            //result.extra = extra != null ? extra.clone() : null;
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.902 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "2707A3C81F8AD6C54EAB1ED1B02BBA66")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_192373964 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_610815120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_610815120;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.902 -0400", hash_original_field = "869069D8A539375615C84E9AABE70433", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.902 -0400", hash_original_field = "892931149BD1D6C244D3C42F2AB305A9", hash_generated_field = "C303454481B8041CEF37C1E89A2E0D63")

    public static final int STORED = 0;
}

