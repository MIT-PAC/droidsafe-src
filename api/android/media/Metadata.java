package android.media;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.util.Log;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

public class Metadata {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.445 -0400", hash_original_field = "4FCFEE3D082C4C61BD6B374EB2663F5D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.445 -0400", hash_original_field = "BC8CD0D2025A922BC51438ACD866BFAA", hash_generated_field = "2FB876C8ECAC97F654B4ACAD4543A0A9")

    private final HashMap<Integer, Integer> mKeyToPosMap = new HashMap<Integer, Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.445 -0400", hash_original_method = "42EB03B7CCF72771EC09BC7329CF6561", hash_generated_method = "DA29DB50537B7681661C6C11E0C14FF9")
    public  Metadata() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.446 -0400", hash_original_method = "AD5931B1126E13DCBE3F825449AFE253", hash_generated_method = "24D8B5D0D17613730F5FBD30BCF7D7BA")
    private boolean scanAllRecords(Parcel parcel, int bytesLeft) {
        addTaint(bytesLeft);
        addTaint(parcel.getTaint());
        int recCount = 0;
        boolean error = false;
        mKeyToPosMap.clear();
        while
(bytesLeft > kRecordHeaderSize)        
        {
            final int start = parcel.dataPosition();
            final int size = parcel.readInt();
    if(size <= kRecordHeaderSize)            
            {
                error = true;
                break;
            } 
            final int metadataId = parcel.readInt();
    if(!checkMetadataId(metadataId))            
            {
                error = true;
                break;
            } 
    if(mKeyToPosMap.containsKey(metadataId))            
            {
                error = true;
                break;
            } 
            mKeyToPosMap.put(metadataId, parcel.dataPosition());
            final int metadataType = parcel.readInt();
    if(metadataType <= 0 || metadataType > LAST_TYPE)            
            {
                error = true;
                break;
            } 
            parcel.setDataPosition(start + size);
            bytesLeft -= size;
            ++recCount;
        } 
    if(0 != bytesLeft || error)        
        {
            mKeyToPosMap.clear();
            boolean var68934A3E9455FA72420237EB05902327_1624918800 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188086629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188086629;
        } 
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_43165208 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796783014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796783014;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.447 -0400", hash_original_method = "35CAF9C1FD62AB3C548A70E81DF2A0C5", hash_generated_method = "D5F8A353A6F3C3FCCE5872BCC888A04D")
    public boolean parse(Parcel parcel) {
    if(parcel.dataAvail() < kMetaHeaderSize)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1813434528 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793602581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_793602581;
        } 
        final int pin = parcel.dataPosition();
        final int size = parcel.readInt();
    if(parcel.dataAvail() + kInt32Size < size || size < kMetaHeaderSize)        
        {
            parcel.setDataPosition(pin);
            boolean var68934A3E9455FA72420237EB05902327_1024836247 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925654219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_925654219;
        } 
        final int kShouldBeMetaMarker = parcel.readInt();
    if(kShouldBeMetaMarker != kMetaMarker)        
        {
            parcel.setDataPosition(pin);
            boolean var68934A3E9455FA72420237EB05902327_1892481579 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654356059 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654356059;
        } 
    if(!scanAllRecords(parcel, size - kMetaHeaderSize))        
        {
            parcel.setDataPosition(pin);
            boolean var68934A3E9455FA72420237EB05902327_730228999 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580870927 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_580870927;
        } 
        mParcel = parcel;
        boolean varB326B5062B2F0E69046810717534CB09_90280423 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117656726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117656726;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.448 -0400", hash_original_method = "87FE67157845253CBCE0E047F3C9B374", hash_generated_method = "B1F9C7054A6CA07661BD51AD542C70D4")
    public Set<Integer> keySet() {
Set<Integer> var19BD1B7180A2FD56EA0AAC27E469272A_1239317072 =         mKeyToPosMap.keySet();
        var19BD1B7180A2FD56EA0AAC27E469272A_1239317072.addTaint(taint);
        return var19BD1B7180A2FD56EA0AAC27E469272A_1239317072;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.448 -0400", hash_original_method = "7767A5018B3458E07A2B7B3389E3B1D0", hash_generated_method = "F557A7F287E84E747E9821DAF4E0526A")
    public boolean has(final int metadataId) {
        addTaint(metadataId);
    if(!checkMetadataId(metadataId))        
        {
            IllegalArgumentException var4268ED9EEE53F5A4B3E33D0277ED3540_178182072 = new IllegalArgumentException("Invalid key: " + metadataId);
            var4268ED9EEE53F5A4B3E33D0277ED3540_178182072.addTaint(taint);
            throw var4268ED9EEE53F5A4B3E33D0277ED3540_178182072;
        } 
        boolean varFA6C1A9BC3CC5AA941D303B9190E5D65_266351548 = (mKeyToPosMap.containsKey(metadataId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152015813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_152015813;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.448 -0400", hash_original_method = "D07ADABDF4536425A343AFD4015AEABD", hash_generated_method = "67F2F1CB83011D3A2BE9B671BEFCE4C1")
    public String getString(final int key) {
        addTaint(key);
        checkType(key, STRING_VAL);
String var1B25834954A649773DFCF4733E0DFAF6_394641459 =         mParcel.readString();
        var1B25834954A649773DFCF4733E0DFAF6_394641459.addTaint(taint);
        return var1B25834954A649773DFCF4733E0DFAF6_394641459;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.449 -0400", hash_original_method = "2E24F7D1E582CF4592E0FE6ACF6159ED", hash_generated_method = "CE967B1F9F87FEC57554D2C392BD02BA")
    public int getInt(final int key) {
        addTaint(key);
        checkType(key, INTEGER_VAL);
        int varE64C5C7FD09A93118A088CDB1D3718AE_1691580835 = (mParcel.readInt());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730087621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730087621;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.449 -0400", hash_original_method = "92B2C04C5831BF6FBB547313E4BFF6F1", hash_generated_method = "F00E51A8159D0C0240B388310FD3306D")
    public boolean getBoolean(final int key) {
        addTaint(key);
        checkType(key, BOOLEAN_VAL);
        boolean var824FF84DB064E92912046EA27D6E2BCD_2139405977 = (mParcel.readInt() == 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543977646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_543977646;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.450 -0400", hash_original_method = "B0F0000F85D960C325C9AE562DB8183E", hash_generated_method = "67BFACFDCA0C52C0A9C3DD00D56F5CFF")
    public long getLong(final int key) {
        addTaint(key);
        checkType(key, LONG_VAL);
        long varC139587F1A6C2A13A8331800842B50D8_1604709267 = (mParcel.readLong());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1869923105 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1869923105;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.450 -0400", hash_original_method = "C463F992BA89266506A75490D5B4B789", hash_generated_method = "6A743FA9BB306CCB7F73F1395F0E8781")
    public double getDouble(final int key) {
        addTaint(key);
        checkType(key, DOUBLE_VAL);
        double varAB36E54B83B0CD4D3A5139D0288CA08B_338802492 = (mParcel.readDouble());
                double varE8CD7DA078A86726031AD64F35F5A6C0_820370863 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_820370863;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.450 -0400", hash_original_method = "7682E02DAB96764259A6698B858B1834", hash_generated_method = "C0939285AE6046CA8F1B6247AC78A62D")
    public byte[] getByteArray(final int key) {
        addTaint(key);
        checkType(key, BYTE_ARRAY_VAL);
        byte[] var834140174B64337217F08BE735F61381_1858221533 = (mParcel.createByteArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_647641690 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_647641690;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.451 -0400", hash_original_method = "AAEF3D01D729AC9D47A3AB4C5693312B", hash_generated_method = "A956E045AF410FC19A489E93379A8FD7")
    public Date getDate(final int key) {
        addTaint(key);
        checkType(key, DATE_VAL);
        final long timeSinceEpoch = mParcel.readLong();
        final String timeZone = mParcel.readString();
    if(timeZone.length() == 0)        
        {
Date var083F5268185148E79542B76638F0FD04_1968804664 =             new Date(timeSinceEpoch);
            var083F5268185148E79542B76638F0FD04_1968804664.addTaint(taint);
            return var083F5268185148E79542B76638F0FD04_1968804664;
        } 
        else
        {
            TimeZone tz = TimeZone.getTimeZone(timeZone);
            Calendar cal = Calendar.getInstance(tz);
            cal.setTimeInMillis(timeSinceEpoch);
Date varBD9B55B530F60709CCFA9E4F3BCA3194_1539058481 =             cal.getTime();
            varBD9B55B530F60709CCFA9E4F3BCA3194_1539058481.addTaint(taint);
            return varBD9B55B530F60709CCFA9E4F3BCA3194_1539058481;
        } 
        
        
        
        
        
            
        
            
            
            
            
        
    }

    
        @DSModeled(DSC.SAFE)
    public static int lastSytemId() {
        return LAST_SYSTEM;
    }

    
        @DSModeled(DSC.SAFE)
    public static int firstCustomId() {
        return FIRST_CUSTOM;
    }

    
        @DSModeled(DSC.SAFE)
    public static int lastType() {
        return LAST_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.452 -0400", hash_original_method = "6E38B18258B92FBBE9034AE151B9B0E7", hash_generated_method = "B870DC29092194644C831D4EE3D38C47")
    private boolean checkMetadataId(final int val) {
        addTaint(val);
    if(val <= ANY || (LAST_SYSTEM < val && val < FIRST_CUSTOM))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1705242468 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507072219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507072219;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1354961818 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785163099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785163099;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_method = "E71E62CC93A8C30E28BB789565435B56", hash_generated_method = "05E79B7E43309E23BF6AE6A411934967")
    private void checkType(final int key, final int expectedType) {
        addTaint(expectedType);
        addTaint(key);
        final int pos = mKeyToPosMap.get(key);
        mParcel.setDataPosition(pos);
        final int type = mParcel.readInt();
    if(type != expectedType)        
        {
            IllegalStateException var67B542E62848F6BD5D8396962162229E_2066198860 = new IllegalStateException("Wrong type " + expectedType + " but got " + type);
            var67B542E62848F6BD5D8396962162229E_2066198860.addTaint(taint);
            throw var67B542E62848F6BD5D8396962162229E_2066198860;
        } 
        
        
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "9E6C95959D97EE52448613D6E718D529", hash_generated_field = "271F985F66AF930C8E8A9EBAEE01B1B2")

    public static final int ANY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "56530E6E6F1C785A3D535F7CAE6435AF", hash_generated_field = "AE6368E43C99E9EEA60637591164FFB1")

    public static final int PAUSE_AVAILABLE         = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "23EA93AEF3F71F2102367F05013A7CCD", hash_generated_field = "46F901C9E691B29A72B5520A441B2D26")

    public static final int SEEK_BACKWARD_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "914315ADEDEC735942DE470877ADA126", hash_generated_field = "049D33CB034E1FF3D2FCDE01A4270437")

    public static final int SEEK_FORWARD_AVAILABLE  = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "D9C76E51B576D844848F3D93DF209C48", hash_generated_field = "8C369D4EA5BA97EF2FDFEA9A31361D80")

    public static final int SEEK_AVAILABLE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "8C568D0E48D34449015A11FF9E5AD74E", hash_generated_field = "75B2B84BF3AA52808CE416456AB29DF5")

    public static final int TITLE                   = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "7EEF3C02E207D164D91EE42BC0C54098", hash_generated_field = "7FAD0FE0D5702D4E4ABF35E98D4FB7B2")

    public static final int COMMENT                 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "4011B594F00780F9EA887D87A226E0FE", hash_generated_field = "B380C993112A61E1FF9F0CF69B7F1FA9")

    public static final int COPYRIGHT               = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "30B9F6EE4AFB0846D6EF932A636DDECF", hash_generated_field = "FEFBFEECD1A6F246D5BDE896FC065DD4")

    public static final int ALBUM                   = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.453 -0400", hash_original_field = "DF15569AF4C3A5EC9052B181BCD42F2E", hash_generated_field = "08824B53FE61B1ED88BCCD5327B62DBF")

    public static final int ARTIST                  = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "370BA7126EF2B33342CDF59EF559D844", hash_generated_field = "9B6932F63A3686222D832796D34A410E")

    public static final int AUTHOR                  = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "B4E1BECA1B586D7D292A4FB94CC17E86", hash_generated_field = "9045EC2C51E1F57231CD0F619DABB54B")

    public static final int COMPOSER                = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "F8D9C860AF29CC45F77138766226DEC6", hash_generated_field = "633A54CA632E60AF917E44A0FD37994F")

    public static final int GENRE                   = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "295A4FF44CDE5724730C10223159D649", hash_generated_field = "4883438BFBEB52490C6FF591909F3066")

    public static final int DATE                    = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "28EAD8423162A9C638F6DBC27680EDD0", hash_generated_field = "15FA023849C8E5DA34D141053A308487")

    public static final int DURATION                = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "63EBCDCC711C985B362590BC7E226A39", hash_generated_field = "B49FD84DBCE39070E6CA011ED96B26E6")

    public static final int CD_TRACK_NUM            = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "7EDF94F0F0433F2807DA4A033B820026", hash_generated_field = "6CFB0BDF0A044457DE3A6EF053EAD7FF")

    public static final int CD_TRACK_MAX            = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "ABE90C6851ACA1651A8300BE5AF17B4F", hash_generated_field = "116BCAD6827EB7E6F29FF99723630108")

    public static final int RATING                  = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "B6F13551E635AA16E514BB1FE3FCF997", hash_generated_field = "B94397894C3ECA23E8121436A05E1F15")

    public static final int ALBUM_ART               = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "D7676A5981CF821ACCC5F2671701DF0C", hash_generated_field = "9BCB4F47E11E2879C9FD118207566BE7")

    public static final int VIDEO_FRAME             = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "05E49AF1871CB42A32588DA3B29E5134", hash_generated_field = "3B5214F2354D9670232DF595ADE692C0")

    public static final int BIT_RATE                = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "049480BAE5CE2F1DCF279699820B9AF8", hash_generated_field = "CEE5F84209D1A9CECF68A3CC3A8C3B99")

    public static final int AUDIO_BIT_RATE          = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "E111AF0F1C6F751984B84AC13144548E", hash_generated_field = "B63610915ED53DB99EEFD94AC60BA48F")

    public static final int VIDEO_BIT_RATE          = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "B7F8DCEEF5F9D89D2582DE706949CDAA", hash_generated_field = "32A3FE0E05678D4921EEE708240005C7")

    public static final int AUDIO_SAMPLE_RATE       = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.454 -0400", hash_original_field = "530CF49E765F3C5D31CAF969AABA1E1D", hash_generated_field = "48891A04C95D86C021ABBB5330559110")

    public static final int VIDEO_FRAME_RATE        = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "7AD35B6FBDC316FCF36B7301CAE5558C", hash_generated_field = "10506AAA3103EE56F85D9DA9C9E9ABFB")

    public static final int MIME_TYPE               = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "15A420FA97E0F59DB5515F3BBB71277C", hash_generated_field = "7DB5FB490EBBE4A4EA078BBDD601207A")

    public static final int AUDIO_CODEC             = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "D3D00BCA2FF79D1ED608EB54C1B6AC37", hash_generated_field = "A64E69344DEC5B6C1C0902AB9AACF252")

    public static final int VIDEO_CODEC             = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "F4364D411A64294A3DD51E1924E536AB", hash_generated_field = "702655F67DE29AE5A8BDF1E719B76C7A")

    public static final int VIDEO_HEIGHT            = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "79CD0578E0836392DEF188F01F9839BA", hash_generated_field = "8FC12812E41B124235247AA42917AE6B")

    public static final int VIDEO_WIDTH             = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "4C89124979992F6BDF2EAF17A346247F", hash_generated_field = "FC59F584C1C09117E84066DF58D78D54")

    public static final int NUM_TRACKS              = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "BF036B0C89E2D9CCA0A69E742567CD02", hash_generated_field = "E7CB62F0C88D5C2CD6F4FA68370C3C4E")

    public static final int DRM_CRIPPLED            = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "45DA3E9B4602C1975FC4DF2C27C3C5F5", hash_generated_field = "138468D81E8995E87BF04E16A5FD4F56")

    private static final int LAST_SYSTEM = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.455 -0400", hash_original_field = "F3BB21E3686616B89A17DF323E23B6B2", hash_generated_field = "1293C8B3CCCB6F01014120B141F15535")

    private static final int FIRST_CUSTOM = 8192;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "5033A8B966A32A77A4D85B802D0D4B1E", hash_generated_field = "8A66644CC95C8A07C55A5FF2998EC1F2")

    public static final Set<Integer> MATCH_NONE = Collections.EMPTY_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "6EC552EA09FE2324D0BA4E25612F444C", hash_generated_field = "CC8D0ACD77DAAAA0E3403FBFC54E8016")

    public static final Set<Integer> MATCH_ALL = Collections.singleton(ANY);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "DFD7BC0A571DF443C6CFFB61E7A92CB9", hash_generated_field = "A62FB349802C75EDFC168254DBA3EFBF")

    public static final int STRING_VAL     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "FFA578B4A6CE050F6A93AF818801769C", hash_generated_field = "271E0941B952E3A622F2B9CB332E88D0")

    public static final int INTEGER_VAL    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "9CE1382ADE753DC8A6ADAEDD1AD6F901", hash_generated_field = "2C69BCCDD399B6924E68CFAF66290A6E")

    public static final int BOOLEAN_VAL    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "8789F8E7E434451C9E480EBC210773D0", hash_generated_field = "7D1B17D2C9091932A4FDD599FA016B84")

    public static final int LONG_VAL       = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "DB8E1400019999635EE18D28868CBF8F", hash_generated_field = "3F86594A4E751DC1C92107189E8C1605")

    public static final int DOUBLE_VAL     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "605ECD1382737058381EC01F8C382054", hash_generated_field = "CB15A3E308CC118919DC8966A9D3476B")

    public static final int DATE_VAL       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.456 -0400", hash_original_field = "C4A54FFE8C1CD9771A59C488FEE5B341", hash_generated_field = "4913EDEFCF294DFFCAC4DF9B4D1A7A36")

    public static final int BYTE_ARRAY_VAL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "4D453B4F15D8102E01C2E170C5C0A7A4", hash_generated_field = "7E529498F95414C9DED9F3867D24734C")

    private static final int LAST_TYPE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "96A6EBBED14196AED641FBD9DE338832", hash_generated_field = "EC6F98E58115DB1A9B2DE74236D3700C")

    private static final String TAG = "media.Metadata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "2AAE87DD7A4A1D254CD3422B5F8A29C4", hash_generated_field = "B38D3572DBAFFF8AAEA7DDE94DF97406")

    private static final int kInt32Size = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "54422C72A9FFF7C24E8FCFB53A1F6B5A", hash_generated_field = "FB5073A1654DE2CF650852DC3CFB72C4")

    private static final int kMetaHeaderSize = 2 * kInt32Size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "D1A9D5B2CC898272F35A7A6A0F7FE2F5", hash_generated_field = "C8DFC1C86B7C58B1324649FBB87DF241")

    private static final int kRecordHeaderSize = 3 * kInt32Size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.457 -0400", hash_original_field = "7FAC4445F5BAA2210A97E003FE872696", hash_generated_field = "DEB70152C7D87EED0BC5674B9F2A6028")

    private static final int kMetaMarker = 0x4d455441;
}

