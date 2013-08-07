package java.util.zip;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "EA9F91B2CDA019730F2891BD12A7A4D6", hash_generated_field = "4DB50909B6C3CA3BD728DB05D0FA3D9B")

    byte[] extra;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "1858EB989B5C48C5F78690997386A30C", hash_generated_field = "5ED088AEC2A67EA91C7AE0A2164EEA41")

    int nameLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.743 -0400", hash_original_field = "A73F9B31C6C9894483E283B195B46914", hash_generated_field = "675B1E366E23748C61289B20C0ED87D0")

    long mLocalHeaderRelOffset = -1;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.744 -0400", hash_original_method = "60F10CCF439EC77C0A98401AA44AF184", hash_generated_method = "698922F491816612D48156F7E5C915E3")
    public  ZipEntry(String name) {
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_687030580 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_687030580.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_687030580;
        } //End block
        if(name.length() > 0xFFFF)        
        {
            IllegalArgumentException var1B12458CDCB97CFAA13FFC1631C55D96_1337737405 = new IllegalArgumentException("Name too long: " + name.length());
            var1B12458CDCB97CFAA13FFC1631C55D96_1337737405.addTaint(taint);
            throw var1B12458CDCB97CFAA13FFC1631C55D96_1337737405;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.746 -0400", hash_original_method = "61E22A8AE090FB92E1157A3CABA3C550", hash_generated_method = "EE7980F5AAA554D14BBE4B0FC31F3A68")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.749 -0400", hash_original_method = "30F30B41DA6F50936D6BF4103A049FEE", hash_generated_method = "A9878FB9865DC4F25CAA33407E8B20FF")
      ZipEntry(byte[] hdrBuf, InputStream in) throws IOException {
        addTaint(in.getTaint());
        addTaint(hdrBuf[0]);
        Streams.readFully(in, hdrBuf, 0, hdrBuf.length);
        BufferIterator it = HeapBufferIterator.iterator(hdrBuf, 0, hdrBuf.length, ByteOrder.LITTLE_ENDIAN);
        int sig = it.readInt();
        if(sig != CENSIG)        
        {
            ZipException varE3B0680FE06DE8664F35975E79E65F68_952373201 = new ZipException("Central Directory Entry not found");
            varE3B0680FE06DE8664F35975E79E65F68_952373201.addTaint(taint);
            throw varE3B0680FE06DE8664F35975E79E65F68_952373201;
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
        if(commentLength > 0)        
        {
            byte[] commentBytes = new byte[commentLength];
            Streams.readFully(in, commentBytes, 0, commentLength);
            comment = new String(commentBytes, 0, commentBytes.length, Charsets.UTF_8);
        } //End block
        if(extraLength > 0)        
        {
            extra = new byte[extraLength];
            Streams.readFully(in, extra, 0, extraLength);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.749 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "33E2BB30AB1851AC003777F53CDB6FBB")
    public String getComment() {
String var20FC6A677850B0D1A8135B6A0BB12A1F_1260298660 =         comment;
        var20FC6A677850B0D1A8135B6A0BB12A1F_1260298660.addTaint(taint);
        return var20FC6A677850B0D1A8135B6A0BB12A1F_1260298660;
        // ---------- Original Method ----------
        //return comment;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.749 -0400", hash_original_method = "BD185E24018FAED136FF653216A88FC6", hash_generated_method = "1C09CC3F6FDE3007260EBEA3902D2C3B")
    public long getCompressedSize() {
        long varD21EEAE05759BB4CAE36118C403A0B35_1893273922 = (compressedSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1031293031 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1031293031;
        // ---------- Original Method ----------
        //return compressedSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.750 -0400", hash_original_method = "9F9CC7112652CAA1DD447640E3933AED", hash_generated_method = "150BEAD3106AA8DD14A13020CC31126D")
    public long getCrc() {
        long varF5AD59C5401FEA3F2DF0703D958FDC97_1713490617 = (crc);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_518266282 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_518266282;
        // ---------- Original Method ----------
        //return crc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.750 -0400", hash_original_method = "12884DA1C8E953155933C9EDA5E5913F", hash_generated_method = "F94EA65A291457F36318D5786F8D9C72")
    public byte[] getExtra() {
        byte[] varEA9F91B2CDA019730F2891BD12A7A4D6_1537108700 = (extra);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_293688386 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_293688386;
        // ---------- Original Method ----------
        //return extra;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.750 -0400", hash_original_method = "5D6E0D5CF72121589416F8E200760163", hash_generated_method = "3ED524CACEC1495BD4B8BE2F462D7914")
    public int getMethod() {
        int var2BB54D2AE49B8469137AD2B40B9E2AD5_1265331274 = (compressionMethod);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507057148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507057148;
        // ---------- Original Method ----------
        //return compressionMethod;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.751 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CE46F6BFFC4856A3178AD152A4EB77E1")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_34165614 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_34165614.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_34165614;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.751 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "118CEB63DCA895F3D6270A346BB9C7C3")
    public long getSize() {
        long varF7BD60B75B29D79B660A2859395C1A24_876598597 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1665745678 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1665745678;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.751 -0400", hash_original_method = "56915B75BB1F78598E38415E47FB9273", hash_generated_method = "CD1167599984E44D2E2327C9266EA8C5")
    public long getTime() {
        if(time != -1)        
        {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf) - 1,
                    modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f,
                    (time & 0x1f) << 1);
            long varD897C319978CB89BC60FB82CFE66280C_634110633 = (cal.getTime().getTime());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2084094986 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2084094986;
        } //End block
        long var6BB61E3B7BCE0931DA574D19D1D82C88_1233653963 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_332338598 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_332338598;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.751 -0400", hash_original_method = "4596D564DD1CB7B8029ED574B004E951", hash_generated_method = "D232A0205BA44C42DAC9E4A17B06944A")
    public boolean isDirectory() {
        boolean var9305E4B280032E8A26470B4467C14FB0_23805977 = (name.charAt(name.length() - 1) == '/');
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98651545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98651545;
        // ---------- Original Method ----------
        //return name.charAt(name.length() - 1) == '/';
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.752 -0400", hash_original_method = "CEDBC8A76FB638A9ACF67956D150D744", hash_generated_method = "9F8771ACA3550FC9C9D1CF7D5EEAFFCB")
    public void setComment(String comment) {
        if(comment == null || comment.length() <= 0xFFFF)        
        {
            this.comment = comment;
        } //End block
        else
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_482671718 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_482671718.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_482671718;
        } //End block
        // ---------- Original Method ----------
        //if (comment == null || comment.length() <= 0xFFFF) {
            //this.comment = comment;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.753 -0400", hash_original_method = "24AF7AE4A55FD751B6B8B8E36C8E6668", hash_generated_method = "334A47E452019AA69BE98A99FED4C96B")
    public void setCompressedSize(long value) {
        compressedSize = value;
        // ---------- Original Method ----------
        //compressedSize = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.753 -0400", hash_original_method = "838546BA41BB934E0DEE95030FA7BCCE", hash_generated_method = "B9191D638AAA68DCFB493D84306E1F4D")
    public void setCrc(long value) {
        if(value >= 0 && value <= 0xFFFFFFFFL)        
        {
            crc = value;
        } //End block
        else
        {
            IllegalArgumentException var9F8F375A1948C3CD4C89D5F7D35CB942_1933000581 = new IllegalArgumentException("Bad CRC32: " + value);
            var9F8F375A1948C3CD4C89D5F7D35CB942_1933000581.addTaint(taint);
            throw var9F8F375A1948C3CD4C89D5F7D35CB942_1933000581;
        } //End block
        // ---------- Original Method ----------
        //if (value >= 0 && value <= 0xFFFFFFFFL) {
            //crc = value;
        //} else {
            //throw new IllegalArgumentException("Bad CRC32: " + value);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.754 -0400", hash_original_method = "F86C78C263DDE84D2589BD04BFB70D1E", hash_generated_method = "CF8D52244CB2091FF7959032C289FF0A")
    public void setExtra(byte[] data) {
        if(data == null || data.length <= 0xFFFF)        
        {
            extra = data;
        } //End block
        else
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_224469260 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_224469260.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_224469260;
        } //End block
        // ---------- Original Method ----------
        //if (data == null || data.length <= 0xFFFF) {
            //extra = data;
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.755 -0400", hash_original_method = "2D1E6DE59F6C5F9CB50232902EB42CEC", hash_generated_method = "14E521FAD0E3C254E9A88422F08D2ECA")
    public void setMethod(int value) {
        if(value != STORED && value != DEFLATED)        
        {
            IllegalArgumentException var22353D932D287A5A101ADFE7E5875133_1927523426 = new IllegalArgumentException("Bad method: " + value);
            var22353D932D287A5A101ADFE7E5875133_1927523426.addTaint(taint);
            throw var22353D932D287A5A101ADFE7E5875133_1927523426;
        } //End block
        compressionMethod = value;
        // ---------- Original Method ----------
        //if (value != STORED && value != DEFLATED) {
            //throw new IllegalArgumentException("Bad method: " + value);
        //}
        //compressionMethod = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.755 -0400", hash_original_method = "3723D5CA75C443A890F342FC88C4BC79", hash_generated_method = "920ED62E9C9AA23C72E8C4D4F17A2B63")
    public void setSize(long value) {
        if(value >= 0 && value <= 0xFFFFFFFFL)        
        {
            size = value;
        } //End block
        else
        {
            IllegalArgumentException var97E3DE9695082C1213A16A44F9609B98_905707739 = new IllegalArgumentException("Bad size: " + value);
            var97E3DE9695082C1213A16A44F9609B98_905707739.addTaint(taint);
            throw var97E3DE9695082C1213A16A44F9609B98_905707739;
        } //End block
        // ---------- Original Method ----------
        //if (value >= 0 && value <= 0xFFFFFFFFL) {
            //size = value;
        //} else {
            //throw new IllegalArgumentException("Bad size: " + value);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.757 -0400", hash_original_method = "ADBF978AE56F7313634C406FFD3BF538", hash_generated_method = "957F97614EE107C751ABC721C144BD24")
    public void setTime(long value) {
        addTaint(value);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(value));
        int year = cal.get(Calendar.YEAR);
        if(year < 1980)        
        {
            modDate = 0x21;
            time = 0;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.758 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "24F8A9670D77158B772BF43AF07245CC")
    @Override
    public String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_1458564326 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1458564326.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1458564326;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.759 -0400", hash_original_method = "CC5347E979B0813386EC9E9DE77BBA76", hash_generated_method = "E2EC6A82115D2F7B7F0FEF4774633CC3")
    @Override
    public Object clone() {
        try 
        {
            ZipEntry result = (ZipEntry) super.clone();
            result.extra = extra != null ? extra.clone() : null;
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1458579202 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1458579202.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1458579202;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1416844871 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1416844871.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1416844871;
        } //End block
        // ---------- Original Method ----------
        //try {
            //ZipEntry result = (ZipEntry) super.clone();
            //result.extra = extra != null ? extra.clone() : null;
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.760 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "C522FFD219E3C53BB8A8E7296D619020")
    @Override
    public int hashCode() {
        int var5715838B66EDF423F24A871806972EB3_231155624 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111531010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1111531010;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.760 -0400", hash_original_field = "869069D8A539375615C84E9AABE70433", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.760 -0400", hash_original_field = "892931149BD1D6C244D3C42F2AB305A9", hash_generated_field = "C303454481B8041CEF37C1E89A2E0D63")

    public static final int STORED = 0;
}

