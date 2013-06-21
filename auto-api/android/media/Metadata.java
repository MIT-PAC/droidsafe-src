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
    private Parcel mParcel;
    private HashMap<Integer, Integer> mKeyToPosMap =
            new HashMap<Integer, Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.296 -0400", hash_original_method = "42EB03B7CCF72771EC09BC7329CF6561", hash_generated_method = "DA29DB50537B7681661C6C11E0C14FF9")
    @DSModeled(DSC.SAFE)
    public Metadata() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.297 -0400", hash_original_method = "AD5931B1126E13DCBE3F825449AFE253", hash_generated_method = "9BF85BA6DA165753FFC8BF65CF482415")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean scanAllRecords(Parcel parcel, int bytesLeft) {
        dsTaint.addTaint(bytesLeft);
        dsTaint.addTaint(parcel.dsTaint);
        int recCount;
        recCount = 0;
        boolean error;
        error = false;
        mKeyToPosMap.clear();
        {
            int start;
            start = parcel.dataPosition();
            int size;
            size = parcel.readInt();
            {
                error = true;
            } //End block
            int metadataId;
            metadataId = parcel.readInt();
            {
                boolean varCE54963948EB187604DDE6A0205AC4AE_818451000 = (!checkMetadataId(metadataId));
                {
                    error = true;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF74D6B80DAC4C88D0ACC6CF48805058A_604762846 = (mKeyToPosMap.containsKey(metadataId));
                {
                    error = true;
                } //End block
            } //End collapsed parenthetic
            mKeyToPosMap.put(metadataId, parcel.dataPosition());
            int metadataType;
            metadataType = parcel.readInt();
            {
                error = true;
            } //End block
            parcel.setDataPosition(start + size);
            bytesLeft -= size;
        } //End block
        {
            mKeyToPosMap.clear();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.297 -0400", hash_original_method = "35CAF9C1FD62AB3C548A70E81DF2A0C5", hash_generated_method = "1B6278A98F97F48DC69FC27F36A6F82A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean parse(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        {
            boolean var21ABD0F2AE1309CFFF2D48D25194CD46_715148579 = (parcel.dataAvail() < kMetaHeaderSize);
        } //End collapsed parenthetic
        int pin;
        pin = parcel.dataPosition();
        int size;
        size = parcel.readInt();
        {
            boolean varCFE361E1F3F172CEF6C287095882467E_47614497 = (parcel.dataAvail() + kInt32Size < size || size < kMetaHeaderSize);
            {
                parcel.setDataPosition(pin);
            } //End block
        } //End collapsed parenthetic
        int kShouldBeMetaMarker;
        kShouldBeMetaMarker = parcel.readInt();
        {
            parcel.setDataPosition(pin);
        } //End block
        {
            boolean var63F06285359F6D9AE8103EB1263019E8_2062331984 = (!scanAllRecords(parcel, size - kMetaHeaderSize));
            {
                parcel.setDataPosition(pin);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.298 -0400", hash_original_method = "87FE67157845253CBCE0E047F3C9B374", hash_generated_method = "BC4A1D99479D6472CCE7A1DFC567BBAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Integer> keySet() {
        Set<Integer> var3E33E7FC7E9F2282A899D0AD6CA85C2C_670291673 = (mKeyToPosMap.keySet());
        return (Set<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mKeyToPosMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.298 -0400", hash_original_method = "7767A5018B3458E07A2B7B3389E3B1D0", hash_generated_method = "C8810787BC6EC9CF8AF00689983CA969")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean has(final int metadataId) {
        dsTaint.addTaint(metadataId);
        {
            boolean var6AD40C80246678F8DA68E7C311DBB62B_1533388984 = (!checkMetadataId(metadataId));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid key: " + metadataId);
            } //End block
        } //End collapsed parenthetic
        boolean var518C24368602C463B4298CCF83E598B1_2132458421 = (mKeyToPosMap.containsKey(metadataId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!checkMetadataId(metadataId)) {
            //throw new IllegalArgumentException("Invalid key: " + metadataId);
        //}
        //return mKeyToPosMap.containsKey(metadataId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.298 -0400", hash_original_method = "D07ADABDF4536425A343AFD4015AEABD", hash_generated_method = "AF4CA985076BE345A6E0F40789B51951")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(final int key) {
        dsTaint.addTaint(key);
        checkType(key, STRING_VAL);
        String var6C9264485E53FA73BEC7EB0B3C47752A_1297721025 = (mParcel.readString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkType(key, STRING_VAL);
        //return mParcel.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.298 -0400", hash_original_method = "2E24F7D1E582CF4592E0FE6ACF6159ED", hash_generated_method = "4683329FA0AC74B10CDA39B035D8AB01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(final int key) {
        dsTaint.addTaint(key);
        checkType(key, INTEGER_VAL);
        int var0EE6795D82619F849E2F0DB44EC65D5A_177822119 = (mParcel.readInt());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkType(key, INTEGER_VAL);
        //return mParcel.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.299 -0400", hash_original_method = "92B2C04C5831BF6FBB547313E4BFF6F1", hash_generated_method = "C64A658E010F68A7519A13EC893AAFFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(final int key) {
        dsTaint.addTaint(key);
        checkType(key, BOOLEAN_VAL);
        boolean varB95710AF752EE06FD4E29F01B7CEF65D_1760803574 = (mParcel.readInt() == 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkType(key, BOOLEAN_VAL);
        //return mParcel.readInt() == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.299 -0400", hash_original_method = "B0F0000F85D960C325C9AE562DB8183E", hash_generated_method = "5625D7A468DD607B85D3A6E4DA65131D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(final int key) {
        dsTaint.addTaint(key);
        checkType(key, LONG_VAL);
        long var6D34F257E71F05B63C93CAD5E7F6A285_260768800 = (mParcel.readLong());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkType(key, LONG_VAL);
        //return mParcel.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.299 -0400", hash_original_method = "C463F992BA89266506A75490D5B4B789", hash_generated_method = "90359CDFC13EEDCBD46F206F9B2865B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(final int key) {
        dsTaint.addTaint(key);
        checkType(key, DOUBLE_VAL);
        double var284C209350BF536BDFB828FED22EF5B2_1334980557 = (mParcel.readDouble());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkType(key, DOUBLE_VAL);
        //return mParcel.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.300 -0400", hash_original_method = "7682E02DAB96764259A6698B858B1834", hash_generated_method = "E03E42E4201652347C7EE6371A624F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getByteArray(final int key) {
        dsTaint.addTaint(key);
        checkType(key, BYTE_ARRAY_VAL);
        byte[] var096C0FF1C44A45D548514148EE1C608A_1423843945 = (mParcel.createByteArray());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //checkType(key, BYTE_ARRAY_VAL);
        //return mParcel.createByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.300 -0400", hash_original_method = "AAEF3D01D729AC9D47A3AB4C5693312B", hash_generated_method = "F2E718EABC4591674BD6AD713459A00D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getDate(final int key) {
        dsTaint.addTaint(key);
        checkType(key, DATE_VAL);
        long timeSinceEpoch;
        timeSinceEpoch = mParcel.readLong();
        String timeZone;
        timeZone = mParcel.readString();
        {
            boolean var46731DD8B805A34A89DC28D55F445C86_127332637 = (timeZone.length() == 0);
            {
                Date var11936EA63297D1EC0724C0E021B902CC_1136702999 = (new Date(timeSinceEpoch));
            } //End block
            {
                TimeZone tz;
                tz = TimeZone.getTimeZone(timeZone);
                Calendar cal;
                cal = Calendar.getInstance(tz);
                cal.setTimeInMillis(timeSinceEpoch);
                Date var37D01EF3281810E18302F526A14FB784_182720576 = (cal.getTime());
            } //End block
        } //End collapsed parenthetic
        return (Date)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.302 -0400", hash_original_method = "6E38B18258B92FBBE9034AE151B9B0E7", hash_generated_method = "727A01A64C5CC1736B68AE47C0585B8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkMetadataId(final int val) {
        dsTaint.addTaint(val);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (val <= ANY || (LAST_SYSTEM < val && val < FIRST_CUSTOM)) {
            //Log.e(TAG, "Invalid metadata ID " + val);
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.303 -0400", hash_original_method = "E71E62CC93A8C30E28BB789565435B56", hash_generated_method = "21E7AD30334AFA3B466D9D4FBE65403A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkType(final int key, final int expectedType) {
        dsTaint.addTaint(expectedType);
        dsTaint.addTaint(key);
        int pos;
        pos = mKeyToPosMap.get(key);
        mParcel.setDataPosition(pos);
        int type;
        type = mParcel.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Wrong type " + expectedType + " but got " + type);
        } //End block
        // ---------- Original Method ----------
        //final int pos = mKeyToPosMap.get(key);
        //mParcel.setDataPosition(pos);
        //final int type = mParcel.readInt();
        //if (type != expectedType) {
            //throw new IllegalStateException("Wrong type " + expectedType + " but got " + type);
        //}
    }

    
    public static final int ANY = 0;
    public static final int PAUSE_AVAILABLE         = 1;
    public static final int SEEK_BACKWARD_AVAILABLE = 2;
    public static final int SEEK_FORWARD_AVAILABLE  = 3;
    public static final int SEEK_AVAILABLE          = 4;
    public static final int TITLE                   = 5;
    public static final int COMMENT                 = 6;
    public static final int COPYRIGHT               = 7;
    public static final int ALBUM                   = 8;
    public static final int ARTIST                  = 9;
    public static final int AUTHOR                  = 10;
    public static final int COMPOSER                = 11;
    public static final int GENRE                   = 12;
    public static final int DATE                    = 13;
    public static final int DURATION                = 14;
    public static final int CD_TRACK_NUM            = 15;
    public static final int CD_TRACK_MAX            = 16;
    public static final int RATING                  = 17;
    public static final int ALBUM_ART               = 18;
    public static final int VIDEO_FRAME             = 19;
    public static final int BIT_RATE                = 20;
    public static final int AUDIO_BIT_RATE          = 21;
    public static final int VIDEO_BIT_RATE          = 22;
    public static final int AUDIO_SAMPLE_RATE       = 23;
    public static final int VIDEO_FRAME_RATE        = 24;
    public static final int MIME_TYPE               = 25;
    public static final int AUDIO_CODEC             = 26;
    public static final int VIDEO_CODEC             = 27;
    public static final int VIDEO_HEIGHT            = 28;
    public static final int VIDEO_WIDTH             = 29;
    public static final int NUM_TRACKS              = 30;
    public static final int DRM_CRIPPLED            = 31;
    private static final int LAST_SYSTEM = 31;
    private static final int FIRST_CUSTOM = 8192;
    public static final Set<Integer> MATCH_NONE = Collections.EMPTY_SET;
    public static final Set<Integer> MATCH_ALL = Collections.singleton(ANY);
    public static final int STRING_VAL     = 1;
    public static final int INTEGER_VAL    = 2;
    public static final int BOOLEAN_VAL    = 3;
    public static final int LONG_VAL       = 4;
    public static final int DOUBLE_VAL     = 5;
    public static final int DATE_VAL       = 6;
    public static final int BYTE_ARRAY_VAL = 7;
    private static final int LAST_TYPE = 7;
    private static final String TAG = "media.Metadata";
    private static final int kInt32Size = 4;
    private static final int kMetaHeaderSize = 2 * kInt32Size;
    private static final int kRecordHeaderSize = 3 * kInt32Size;
    private static final int kMetaMarker = 0x4d455441;
}

