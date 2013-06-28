package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.424 -0400", hash_original_field = "4FCFEE3D082C4C61BD6B374EB2663F5D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.424 -0400", hash_original_field = "BC8CD0D2025A922BC51438ACD866BFAA", hash_generated_field = "2FB876C8ECAC97F654B4ACAD4543A0A9")

    private final HashMap<Integer, Integer> mKeyToPosMap = new HashMap<Integer, Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.424 -0400", hash_original_method = "42EB03B7CCF72771EC09BC7329CF6561", hash_generated_method = "DA29DB50537B7681661C6C11E0C14FF9")
    public  Metadata() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.425 -0400", hash_original_method = "AD5931B1126E13DCBE3F825449AFE253", hash_generated_method = "8F1C821814115C546F8D0E961E02FC45")
    private boolean scanAllRecords(Parcel parcel, int bytesLeft) {
        int recCount = 0;
        boolean error = false;
        mKeyToPosMap.clear();
        {
            final int start = parcel.dataPosition();
            final int size = parcel.readInt();
            {
                error = true;
            } //End block
            final int metadataId = parcel.readInt();
            {
                boolean varCE54963948EB187604DDE6A0205AC4AE_96247453 = (!checkMetadataId(metadataId));
                {
                    error = true;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF74D6B80DAC4C88D0ACC6CF48805058A_593551717 = (mKeyToPosMap.containsKey(metadataId));
                {
                    error = true;
                } //End block
            } //End collapsed parenthetic
            mKeyToPosMap.put(metadataId, parcel.dataPosition());
            final int metadataType = parcel.readInt();
            {
                error = true;
            } //End block
            parcel.setDataPosition(start + size);
            bytesLeft -= size;
        } //End block
        {
            mKeyToPosMap.clear();
        } //End block
        addTaint(parcel.getTaint());
        addTaint(bytesLeft);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196254621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196254621;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.426 -0400", hash_original_method = "35CAF9C1FD62AB3C548A70E81DF2A0C5", hash_generated_method = "C50887463C12943FF53F294606F35E0B")
    public boolean parse(Parcel parcel) {
        {
            boolean var21ABD0F2AE1309CFFF2D48D25194CD46_502730899 = (parcel.dataAvail() < kMetaHeaderSize);
        } //End collapsed parenthetic
        final int pin = parcel.dataPosition();
        final int size = parcel.readInt();
        {
            boolean varCFE361E1F3F172CEF6C287095882467E_1856871791 = (parcel.dataAvail() + kInt32Size < size || size < kMetaHeaderSize);
            {
                parcel.setDataPosition(pin);
            } //End block
        } //End collapsed parenthetic
        final int kShouldBeMetaMarker = parcel.readInt();
        {
            parcel.setDataPosition(pin);
        } //End block
        {
            boolean var63F06285359F6D9AE8103EB1263019E8_30028201 = (!scanAllRecords(parcel, size - kMetaHeaderSize));
            {
                parcel.setDataPosition(pin);
            } //End block
        } //End collapsed parenthetic
        mParcel = parcel;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91591182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91591182;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.427 -0400", hash_original_method = "87FE67157845253CBCE0E047F3C9B374", hash_generated_method = "F31820BBEA17B904845559BB7FB51D96")
    public Set<Integer> keySet() {
        Set<Integer> varB4EAC82CA7396A68D541C85D26508E83_770574424 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_770574424 = mKeyToPosMap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_770574424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_770574424;
        // ---------- Original Method ----------
        //return mKeyToPosMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.427 -0400", hash_original_method = "7767A5018B3458E07A2B7B3389E3B1D0", hash_generated_method = "32DF705C67E6440CE61A5E68FD5C6DFD")
    public boolean has(final int metadataId) {
        {
            boolean var6AD40C80246678F8DA68E7C311DBB62B_526161013 = (!checkMetadataId(metadataId));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid key: " + metadataId);
            } //End block
        } //End collapsed parenthetic
        boolean var518C24368602C463B4298CCF83E598B1_595672837 = (mKeyToPosMap.containsKey(metadataId));
        addTaint(metadataId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178501061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178501061;
        // ---------- Original Method ----------
        //if (!checkMetadataId(metadataId)) {
            //throw new IllegalArgumentException("Invalid key: " + metadataId);
        //}
        //return mKeyToPosMap.containsKey(metadataId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.428 -0400", hash_original_method = "D07ADABDF4536425A343AFD4015AEABD", hash_generated_method = "B7FCE09150ADE24A93474EC497803AE4")
    public String getString(final int key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1052446817 = null; //Variable for return #1
        checkType(key, STRING_VAL);
        varB4EAC82CA7396A68D541C85D26508E83_1052446817 = mParcel.readString();
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_1052446817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1052446817;
        // ---------- Original Method ----------
        //checkType(key, STRING_VAL);
        //return mParcel.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.428 -0400", hash_original_method = "2E24F7D1E582CF4592E0FE6ACF6159ED", hash_generated_method = "08A7888ECC09A1AC2752EDC8F7E0C7B3")
    public int getInt(final int key) {
        checkType(key, INTEGER_VAL);
        int var0EE6795D82619F849E2F0DB44EC65D5A_495017415 = (mParcel.readInt());
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393620844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393620844;
        // ---------- Original Method ----------
        //checkType(key, INTEGER_VAL);
        //return mParcel.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.429 -0400", hash_original_method = "92B2C04C5831BF6FBB547313E4BFF6F1", hash_generated_method = "FC9A19894397D556EB80072C965E77C8")
    public boolean getBoolean(final int key) {
        checkType(key, BOOLEAN_VAL);
        boolean varB95710AF752EE06FD4E29F01B7CEF65D_8106340 = (mParcel.readInt() == 1);
        addTaint(key);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500392649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500392649;
        // ---------- Original Method ----------
        //checkType(key, BOOLEAN_VAL);
        //return mParcel.readInt() == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.429 -0400", hash_original_method = "B0F0000F85D960C325C9AE562DB8183E", hash_generated_method = "0054AD45A6DB7F64249CC0FA48A4F651")
    public long getLong(final int key) {
        checkType(key, LONG_VAL);
        long var6D34F257E71F05B63C93CAD5E7F6A285_1930061655 = (mParcel.readLong());
        addTaint(key);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1859747629 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1859747629;
        // ---------- Original Method ----------
        //checkType(key, LONG_VAL);
        //return mParcel.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.430 -0400", hash_original_method = "C463F992BA89266506A75490D5B4B789", hash_generated_method = "59457C3692D764D41F44F37794E059C6")
    public double getDouble(final int key) {
        checkType(key, DOUBLE_VAL);
        double var284C209350BF536BDFB828FED22EF5B2_304541076 = (mParcel.readDouble());
        addTaint(key);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1697154236 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1697154236;
        // ---------- Original Method ----------
        //checkType(key, DOUBLE_VAL);
        //return mParcel.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.430 -0400", hash_original_method = "7682E02DAB96764259A6698B858B1834", hash_generated_method = "DDF25B2AB42A88BB3E7739DBD30CD4CC")
    public byte[] getByteArray(final int key) {
        checkType(key, BYTE_ARRAY_VAL);
        byte[] var096C0FF1C44A45D548514148EE1C608A_1695234652 = (mParcel.createByteArray());
        addTaint(key);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1682593047 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1682593047;
        // ---------- Original Method ----------
        //checkType(key, BYTE_ARRAY_VAL);
        //return mParcel.createByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.431 -0400", hash_original_method = "AAEF3D01D729AC9D47A3AB4C5693312B", hash_generated_method = "7333FD84BC10869CDC051F4B7411E6E4")
    public Date getDate(final int key) {
        Date varB4EAC82CA7396A68D541C85D26508E83_962608237 = null; //Variable for return #1
        Date varB4EAC82CA7396A68D541C85D26508E83_1409202618 = null; //Variable for return #2
        checkType(key, DATE_VAL);
        final long timeSinceEpoch = mParcel.readLong();
        final String timeZone = mParcel.readString();
        {
            boolean var46731DD8B805A34A89DC28D55F445C86_318705049 = (timeZone.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_962608237 = new Date(timeSinceEpoch);
            } //End block
            {
                TimeZone tz = TimeZone.getTimeZone(timeZone);
                Calendar cal = Calendar.getInstance(tz);
                cal.setTimeInMillis(timeSinceEpoch);
                varB4EAC82CA7396A68D541C85D26508E83_1409202618 = cal.getTime();
            } //End block
        } //End collapsed parenthetic
        addTaint(key);
        Date varA7E53CE21691AB073D9660D615818899_242729143; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_242729143 = varB4EAC82CA7396A68D541C85D26508E83_962608237;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_242729143 = varB4EAC82CA7396A68D541C85D26508E83_1409202618;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_242729143.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_242729143;
        // ---------- Original Method ----------
        //checkType(key, DATE_VAL);
        //final long timeSinceEpoch = mParcel.readLong();
        //final String timeZone = mParcel.readString();
        //if (timeZone.length() == 0) {
            //return new Date(timeSinceEpoch);
        //} else {
            //TimeZone tz = TimeZone.getTimeZone(timeZone);
            //Calendar cal = Calendar.getInstance(tz);
            //cal.setTimeInMillis(timeSinceEpoch);
            //return cal.getTime();
        //}
    }

    
    public static int lastSytemId() {
        return LAST_SYSTEM;
    }

    
    public static int firstCustomId() {
        return FIRST_CUSTOM;
    }

    
    public static int lastType() {
        return LAST_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_method = "6E38B18258B92FBBE9034AE151B9B0E7", hash_generated_method = "ED42A29A349306DA53A800CC7933459B")
    private boolean checkMetadataId(final int val) {
        addTaint(val);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584731085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584731085;
        // ---------- Original Method ----------
        //if (val <= ANY || (LAST_SYSTEM < val && val < FIRST_CUSTOM)) {
            //Log.e(TAG, "Invalid metadata ID " + val);
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_method = "E71E62CC93A8C30E28BB789565435B56", hash_generated_method = "9A7916AD32D1CAA12077B7444506C85C")
    private void checkType(final int key, final int expectedType) {
        final int pos = mKeyToPosMap.get(key);
        mParcel.setDataPosition(pos);
        final int type = mParcel.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Wrong type " + expectedType + " but got " + type);
        } //End block
        addTaint(key);
        addTaint(expectedType);
        // ---------- Original Method ----------
        //final int pos = mKeyToPosMap.get(key);
        //mParcel.setDataPosition(pos);
        //final int type = mParcel.readInt();
        //if (type != expectedType) {
            //throw new IllegalStateException("Wrong type " + expectedType + " but got " + type);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "9E6C95959D97EE52448613D6E718D529", hash_generated_field = "271F985F66AF930C8E8A9EBAEE01B1B2")

    public static final int ANY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "56530E6E6F1C785A3D535F7CAE6435AF", hash_generated_field = "AE6368E43C99E9EEA60637591164FFB1")

    public static final int PAUSE_AVAILABLE         = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "23EA93AEF3F71F2102367F05013A7CCD", hash_generated_field = "46F901C9E691B29A72B5520A441B2D26")

    public static final int SEEK_BACKWARD_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "914315ADEDEC735942DE470877ADA126", hash_generated_field = "049D33CB034E1FF3D2FCDE01A4270437")

    public static final int SEEK_FORWARD_AVAILABLE  = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "D9C76E51B576D844848F3D93DF209C48", hash_generated_field = "8C369D4EA5BA97EF2FDFEA9A31361D80")

    public static final int SEEK_AVAILABLE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "8C568D0E48D34449015A11FF9E5AD74E", hash_generated_field = "75B2B84BF3AA52808CE416456AB29DF5")

    public static final int TITLE                   = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "7EEF3C02E207D164D91EE42BC0C54098", hash_generated_field = "7FAD0FE0D5702D4E4ABF35E98D4FB7B2")

    public static final int COMMENT                 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "4011B594F00780F9EA887D87A226E0FE", hash_generated_field = "B380C993112A61E1FF9F0CF69B7F1FA9")

    public static final int COPYRIGHT               = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "30B9F6EE4AFB0846D6EF932A636DDECF", hash_generated_field = "FEFBFEECD1A6F246D5BDE896FC065DD4")

    public static final int ALBUM                   = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "DF15569AF4C3A5EC9052B181BCD42F2E", hash_generated_field = "08824B53FE61B1ED88BCCD5327B62DBF")

    public static final int ARTIST                  = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "370BA7126EF2B33342CDF59EF559D844", hash_generated_field = "9B6932F63A3686222D832796D34A410E")

    public static final int AUTHOR                  = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "B4E1BECA1B586D7D292A4FB94CC17E86", hash_generated_field = "9045EC2C51E1F57231CD0F619DABB54B")

    public static final int COMPOSER                = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "F8D9C860AF29CC45F77138766226DEC6", hash_generated_field = "633A54CA632E60AF917E44A0FD37994F")

    public static final int GENRE                   = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.432 -0400", hash_original_field = "295A4FF44CDE5724730C10223159D649", hash_generated_field = "4883438BFBEB52490C6FF591909F3066")

    public static final int DATE                    = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "28EAD8423162A9C638F6DBC27680EDD0", hash_generated_field = "15FA023849C8E5DA34D141053A308487")

    public static final int DURATION                = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "63EBCDCC711C985B362590BC7E226A39", hash_generated_field = "B49FD84DBCE39070E6CA011ED96B26E6")

    public static final int CD_TRACK_NUM            = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "7EDF94F0F0433F2807DA4A033B820026", hash_generated_field = "6CFB0BDF0A044457DE3A6EF053EAD7FF")

    public static final int CD_TRACK_MAX            = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "ABE90C6851ACA1651A8300BE5AF17B4F", hash_generated_field = "116BCAD6827EB7E6F29FF99723630108")

    public static final int RATING                  = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "B6F13551E635AA16E514BB1FE3FCF997", hash_generated_field = "B94397894C3ECA23E8121436A05E1F15")

    public static final int ALBUM_ART               = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "D7676A5981CF821ACCC5F2671701DF0C", hash_generated_field = "9BCB4F47E11E2879C9FD118207566BE7")

    public static final int VIDEO_FRAME             = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "05E49AF1871CB42A32588DA3B29E5134", hash_generated_field = "3B5214F2354D9670232DF595ADE692C0")

    public static final int BIT_RATE                = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "049480BAE5CE2F1DCF279699820B9AF8", hash_generated_field = "CEE5F84209D1A9CECF68A3CC3A8C3B99")

    public static final int AUDIO_BIT_RATE          = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "E111AF0F1C6F751984B84AC13144548E", hash_generated_field = "B63610915ED53DB99EEFD94AC60BA48F")

    public static final int VIDEO_BIT_RATE          = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "B7F8DCEEF5F9D89D2582DE706949CDAA", hash_generated_field = "32A3FE0E05678D4921EEE708240005C7")

    public static final int AUDIO_SAMPLE_RATE       = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "530CF49E765F3C5D31CAF969AABA1E1D", hash_generated_field = "48891A04C95D86C021ABBB5330559110")

    public static final int VIDEO_FRAME_RATE        = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "7AD35B6FBDC316FCF36B7301CAE5558C", hash_generated_field = "10506AAA3103EE56F85D9DA9C9E9ABFB")

    public static final int MIME_TYPE               = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "15A420FA97E0F59DB5515F3BBB71277C", hash_generated_field = "7DB5FB490EBBE4A4EA078BBDD601207A")

    public static final int AUDIO_CODEC             = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "D3D00BCA2FF79D1ED608EB54C1B6AC37", hash_generated_field = "A64E69344DEC5B6C1C0902AB9AACF252")

    public static final int VIDEO_CODEC             = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "F4364D411A64294A3DD51E1924E536AB", hash_generated_field = "702655F67DE29AE5A8BDF1E719B76C7A")

    public static final int VIDEO_HEIGHT            = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "79CD0578E0836392DEF188F01F9839BA", hash_generated_field = "8FC12812E41B124235247AA42917AE6B")

    public static final int VIDEO_WIDTH             = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "4C89124979992F6BDF2EAF17A346247F", hash_generated_field = "FC59F584C1C09117E84066DF58D78D54")

    public static final int NUM_TRACKS              = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "BF036B0C89E2D9CCA0A69E742567CD02", hash_generated_field = "E7CB62F0C88D5C2CD6F4FA68370C3C4E")

    public static final int DRM_CRIPPLED            = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "45DA3E9B4602C1975FC4DF2C27C3C5F5", hash_generated_field = "138468D81E8995E87BF04E16A5FD4F56")

    private static final int LAST_SYSTEM = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "F3BB21E3686616B89A17DF323E23B6B2", hash_generated_field = "1293C8B3CCCB6F01014120B141F15535")

    private static final int FIRST_CUSTOM = 8192;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "5033A8B966A32A77A4D85B802D0D4B1E", hash_generated_field = "8A66644CC95C8A07C55A5FF2998EC1F2")

    public static final Set<Integer> MATCH_NONE = Collections.EMPTY_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "6EC552EA09FE2324D0BA4E25612F444C", hash_generated_field = "CC8D0ACD77DAAAA0E3403FBFC54E8016")

    public static final Set<Integer> MATCH_ALL = Collections.singleton(ANY);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "DFD7BC0A571DF443C6CFFB61E7A92CB9", hash_generated_field = "A62FB349802C75EDFC168254DBA3EFBF")

    public static final int STRING_VAL     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "FFA578B4A6CE050F6A93AF818801769C", hash_generated_field = "271E0941B952E3A622F2B9CB332E88D0")

    public static final int INTEGER_VAL    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "9CE1382ADE753DC8A6ADAEDD1AD6F901", hash_generated_field = "2C69BCCDD399B6924E68CFAF66290A6E")

    public static final int BOOLEAN_VAL    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "8789F8E7E434451C9E480EBC210773D0", hash_generated_field = "7D1B17D2C9091932A4FDD599FA016B84")

    public static final int LONG_VAL       = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "DB8E1400019999635EE18D28868CBF8F", hash_generated_field = "3F86594A4E751DC1C92107189E8C1605")

    public static final int DOUBLE_VAL     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "605ECD1382737058381EC01F8C382054", hash_generated_field = "CB15A3E308CC118919DC8966A9D3476B")

    public static final int DATE_VAL       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "C4A54FFE8C1CD9771A59C488FEE5B341", hash_generated_field = "4913EDEFCF294DFFCAC4DF9B4D1A7A36")

    public static final int BYTE_ARRAY_VAL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "4D453B4F15D8102E01C2E170C5C0A7A4", hash_generated_field = "7E529498F95414C9DED9F3867D24734C")

    private static final int LAST_TYPE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "96A6EBBED14196AED641FBD9DE338832", hash_generated_field = "EC6F98E58115DB1A9B2DE74236D3700C")

    private static final String TAG = "media.Metadata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "2AAE87DD7A4A1D254CD3422B5F8A29C4", hash_generated_field = "B38D3572DBAFFF8AAEA7DDE94DF97406")

    private static final int kInt32Size = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "54422C72A9FFF7C24E8FCFB53A1F6B5A", hash_generated_field = "FB5073A1654DE2CF650852DC3CFB72C4")

    private static final int kMetaHeaderSize = 2 * kInt32Size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "D1A9D5B2CC898272F35A7A6A0F7FE2F5", hash_generated_field = "C8DFC1C86B7C58B1324649FBB87DF241")

    private static final int kRecordHeaderSize = 3 * kInt32Size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.433 -0400", hash_original_field = "7FAC4445F5BAA2210A97E003FE872696", hash_generated_field = "DEB70152C7D87EED0BC5674B9F2A6028")

    private static final int kMetaMarker = 0x4d455441;
}

