package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SignalStrength implements Parcelable { // This value is set by the ServiceStateTracker onSignalStrengthResult

    /**
     * Create a new SignalStrength from a intent notifier Bundle
     *
     * This method is used by PhoneStateIntentReceiver and maybe by
     * external applications.
     *
     * @param m Bundle from intent notifier
     * @return newly created SignalStrength
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.524 -0500", hash_original_method = "F74095F651F3A7ACE8110967D615306B", hash_generated_method = "D262C61D273102DA93E08958EA36A1F1")
    
public static SignalStrength newFromBundle(Bundle m) {
        SignalStrength ret;
        ret = new SignalStrength();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    /**
     * log
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.712 -0500", hash_original_method = "277DE078A3A03DEDE382EACFE7464D2F", hash_generated_method = "735FBAD30ECBFB458FF9D49ED05CF8FD")
    
private static void log(String s) {
        Log.w(LOG_TAG, s);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.415 -0500", hash_original_field = "5DD80A8750491DA26C4FBD004B3C57C8", hash_generated_field = "6E97287BC5323EE3BC717AB66CCBDA0F")

    private static final String LOG_TAG = "SignalStrength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.420 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.425 -0500", hash_original_field = "716DF6D29353257FC3F76380825B545B", hash_generated_field = "F36B5DA862F2210B7CC8B63BBEC96BC6")

    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.430 -0500", hash_original_field = "564954C6C84BFBF3047FDEA705F988FD", hash_generated_field = "97056B85052FD1665F55A477FCCE88E5")

    public static final int SIGNAL_STRENGTH_POOR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.436 -0500", hash_original_field = "1338A3F076D1ACA7409FEE26094F7F8D", hash_generated_field = "3C5058BFCEEB115196EE2231DF9981BF")

    public static final int SIGNAL_STRENGTH_MODERATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.441 -0500", hash_original_field = "5E470FC33752C826D45E830287B1DF65", hash_generated_field = "84ECBAA9293AB4A1FA6C266A70AD82B1")

    public static final int SIGNAL_STRENGTH_GOOD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.446 -0500", hash_original_field = "69711A990BA93487026D4963A9AB97E2", hash_generated_field = "8354359F6FF7CC86EEAB975D01842E00")

    public static final int SIGNAL_STRENGTH_GREAT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.451 -0500", hash_original_field = "78000C6AB06742DB0B3A816436C257A1", hash_generated_field = "77B4BF83352A596F63869F754229CB9B")

    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.458 -0500", hash_original_field = "8E31076D04EC68E3F5F76000802DE88B", hash_generated_field = "BDFDB8B094372B725FE43741B8D7FCCB")

    public static final String[] SIGNAL_STRENGTH_NAMES = {
        "none", "poor", "moderate", "good", "great"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "17161E0D5F664640DD3B27CBEFA72BA0", hash_generated_field = "9C95D36DB334C11AD4000563454AA3FC")

    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.571 -0500", hash_original_method = "FD487B8B32AF513C14420FE03C44E804", hash_generated_method = "FBB55F9C50025DD4CE74BA243C7973DE")
        
public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.576 -0500", hash_original_method = "0A7CC95D329D0816525677C5750140E9", hash_generated_method = "4AEB3F01F18CF1585BF55AE4A08CD24A")
        
public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.462 -0500", hash_original_field = "0CBBC6A72330084E0CC692C755044B09", hash_generated_field = "DF212ABBD77FA8BBA06AA948D0C786A3")

    private int mGsmSignalStrength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.467 -0500", hash_original_field = "8B5E0463438451B3E5A13222F556D2B1", hash_generated_field = "62197276EA9E6CE4D0502EE53FF46E07")

    private int mGsmBitErrorRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.472 -0500", hash_original_field = "718FE6AEE7CAB3F6EEE0681A49ABBD06", hash_generated_field = "E86784A230D482159884E423762742A0")

    private int mCdmaDbm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.477 -0500", hash_original_field = "AA280C7EB41BDEC06FF762D1B7CA92D7", hash_generated_field = "6E97F40BFD836F3CE5BD662C51380A2E")

    private int mCdmaEcio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.482 -0500", hash_original_field = "854C6B26A02287849D5AFE137DDEE0DB", hash_generated_field = "5F77C00D970A012CF8A70A743502955E")

    private int mEvdoDbm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.486 -0500", hash_original_field = "6FDB64E890242C074EE9560B8DF3FDEB", hash_generated_field = "9D4FAC062F6677FEF890917A2CC74060")

    private int mEvdoEcio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.491 -0500", hash_original_field = "F919FA943612E7EA28A2F2E5A54E1793", hash_generated_field = "A8393F6F3E55D49B155906169F7DF105")

    private int mEvdoSnr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.497 -0500", hash_original_field = "7B0B441611B71220B687FDC3E41A8E95", hash_generated_field = "2E9C18263B0918B024A476E0A3021D5D")

    private int mLteSignalStrength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.501 -0500", hash_original_field = "CE016C8D25CB8FD288B0253D114BBA47", hash_generated_field = "F7BF008784D2B5C3302EECB15948BC9E")

    private int mLteRsrp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.505 -0500", hash_original_field = "7796A07EDCACAF05024B615D793B1419", hash_generated_field = "034A5562CA8669F3C12137B1EB35AA93")

    private int mLteRsrq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.510 -0500", hash_original_field = "6A7457B917C73FDC85548CBF20AB4923", hash_generated_field = "CF3AA4BA421912BC2B971AF50DDB829D")

    private int mLteRssnr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.515 -0500", hash_original_field = "B34E401530F050E0AF759347444F1719", hash_generated_field = "39529D74D8B59671DDC05D399EF4A2BD")

    private int mLteCqi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.520 -0500", hash_original_field = "16B155E0C303D6F5ECDBE048BD6C6AD6", hash_generated_field = "5BB65659E30CE1CC8D95D33184A43135")

    private boolean isGsm;

    /**
     * Empty constructor
     *
     * @hide
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.529 -0500", hash_original_method = "39BD55AB1A011261FC242AC9054B9C2E", hash_generated_method = "5B311C8F95E0463D19E33F59389E3E80")
    
public SignalStrength() {
        mGsmSignalStrength = 99;
        mGsmBitErrorRate = -1;
        mCdmaDbm = -1;
        mCdmaEcio = -1;
        mEvdoDbm = -1;
        mEvdoEcio = -1;
        mEvdoSnr = -1;
        mLteSignalStrength = -1;
        mLteRsrp = -1;
        mLteRsrq = -1;
        mLteRssnr = -1;
        mLteCqi = -1;
        isGsm = true;
    }

    /**
     * Constructor
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.535 -0500", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "614BF96E4E6C01488E7FC97D07AF001B")
    
public SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            int lteSignalStrength, int lteRsrp, int lteRsrq, int lteRssnr, int lteCqi,
            boolean gsm) {
        mGsmSignalStrength = gsmSignalStrength;
        mGsmBitErrorRate = gsmBitErrorRate;
        mCdmaDbm = cdmaDbm;
        mCdmaEcio = cdmaEcio;
        mEvdoDbm = evdoDbm;
        mEvdoEcio = evdoEcio;
        mEvdoSnr = evdoSnr;
        mLteSignalStrength = lteSignalStrength;
        mLteRsrp = lteRsrp;
        mLteRsrq = lteRsrq;
        mLteRssnr = lteRssnr;
        mLteCqi = lteCqi;
        isGsm = gsm;
    }

    /**
     * Constructor
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.541 -0500", hash_original_method = "50D26D8F6F19A1F72234E376840BB613", hash_generated_method = "45D85321B18D404F19621F75F6F2EF7B")
    
public SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            boolean gsm) {
        this(gsmSignalStrength, gsmBitErrorRate, cdmaDbm, cdmaEcio,
                evdoDbm, evdoEcio, evdoSnr, -1, -1, -1, -1, -1, gsm);
    }

    /**
     * Copy constructors
     *
     * @param s Source SignalStrength
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.546 -0500", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "16B7EA948454D079B746A18CB9BDC0C7")
    
public SignalStrength(SignalStrength s) {
        copyFrom(s);
    }

    /**
     * Construct a SignalStrength object from the given parcel.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.556 -0500", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "DA08102AFFDAD05B779B6EB245A14FFA")
    
public SignalStrength(Parcel in) {
        mGsmSignalStrength = in.readInt();
        mGsmBitErrorRate = in.readInt();
        mCdmaDbm = in.readInt();
        mCdmaEcio = in.readInt();
        mEvdoDbm = in.readInt();
        mEvdoEcio = in.readInt();
        mEvdoSnr = in.readInt();
        mLteSignalStrength = in.readInt();
        mLteRsrp = in.readInt();
        mLteRsrq = in.readInt();
        mLteRssnr = in.readInt();
        mLteCqi = in.readInt();
        isGsm = (in.readInt() != 0);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.551 -0500", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "B85F01283BD71E753B8E04C6ECFDD3CA")
    
protected void copyFrom(SignalStrength s) {
        mGsmSignalStrength = s.mGsmSignalStrength;
        mGsmBitErrorRate = s.mGsmBitErrorRate;
        mCdmaDbm = s.mCdmaDbm;
        mCdmaEcio = s.mCdmaEcio;
        mEvdoDbm = s.mEvdoDbm;
        mEvdoEcio = s.mEvdoEcio;
        mEvdoSnr = s.mEvdoSnr;
        mLteSignalStrength = s.mLteSignalStrength;
        mLteRsrp = s.mLteRsrp;
        mLteRsrq = s.mLteRsrq;
        mLteRssnr = s.mLteRssnr;
        mLteCqi = s.mLteCqi;
        isGsm = s.isGsm;
    }

    /**
     * {@link Parcelable#writeToParcel}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.561 -0500", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "6552A84D8A543BBD88280E09B55A46F6")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mGsmSignalStrength);
        out.writeInt(mGsmBitErrorRate);
        out.writeInt(mCdmaDbm);
        out.writeInt(mCdmaEcio);
        out.writeInt(mEvdoDbm);
        out.writeInt(mEvdoEcio);
        out.writeInt(mEvdoSnr);
        out.writeInt(mLteSignalStrength);
        out.writeInt(mLteRsrp);
        out.writeInt(mLteRsrq);
        out.writeInt(mLteRssnr);
        out.writeInt(mLteCqi);
        out.writeInt(isGsm ? 1 : 0);
    }

    /**
     * {@link Parcelable#describeContents}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.565 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Get the GSM Signal Strength, valid values are (0-31, 99) as defined in TS 27.007 8.5
     */
    @DSSpec(DSCat.PHONE_STATE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.584 -0500", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "CBC90B152B3CA37C0698181443702CA1")
    
public int getGsmSignalStrength() {
        return this.mGsmSignalStrength;
    }

    /**
     * Get the GSM bit error rate (0-7, 99) as defined in TS 27.007 8.5
     */
    @DSSpec(DSCat.PHONE_STATE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.590 -0500", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "B16D3AA7A53422306E3A8740E3C67D7F")
    
public int getGsmBitErrorRate() {
        return this.mGsmBitErrorRate;
    }

    /**
     * Get the CDMA RSSI value in dBm
     */
    @DSSpec(DSCat.PHONE_STATE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.594 -0500", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "836885968B8AC0E5580F43B2D5AA9963")
    
public int getCdmaDbm() {
        return this.mCdmaDbm;
    }

    /**
     * Get the CDMA Ec/Io value in dB*10
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.598 -0500", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "7CF8615F4999A1DEB5E9E69E4C71105C")
    
public int getCdmaEcio() {
        return this.mCdmaEcio;
    }

    /**
     * Get the EVDO RSSI value in dBm
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.602 -0500", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "CF1E921B63371517D651D32B6D66885C")
    
public int getEvdoDbm() {
        return this.mEvdoDbm;
    }

    /**
     * Get the EVDO Ec/Io value in dB*10
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.606 -0500", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "E0F1C04DCDFEA48FF27E7568449A248F")
    
public int getEvdoEcio() {
        return this.mEvdoEcio;
    }

    /**
     * Get the signal to noise ratio. Valid values are 0-8. 8 is the highest.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.610 -0500", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "A75B4C92D8C401436FA5CEE42A38C107")
    
public int getEvdoSnr() {
        return this.mEvdoSnr;
    }

    /**
     * Get signal level as an int from 0..4
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.615 -0500", hash_original_method = "7504E540028056CDE39219F81B4E1E59", hash_generated_method = "842F87F6F7F7B7D9924C69932C2B9958")
    
public int getLevel() {
        int level;

        if (isGsm) {
            if ((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1)) {
                level = getGsmLevel();
            } else {
                level = getLteLevel();
            }
        } else {
            int cdmaLevel = getCdmaLevel();
            int evdoLevel = getEvdoLevel();
            if (evdoLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN) {
                /* We don't know evdo, use cdma */
                level = getCdmaLevel();
            } else if (cdmaLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN) {
                /* We don't know cdma, use evdo */
                level = getEvdoLevel();
            } else {
                /* We know both, use the lowest level */
                level = cdmaLevel < evdoLevel ? cdmaLevel : evdoLevel;
            }
        }
        if (DBG) log("getLevel=" + level);
        return level;
    }

    /**
     * Get the signal level as an asu value between 0..31, 99 is unknown
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.620 -0500", hash_original_method = "6887E245B7148208FA71118C76512694", hash_generated_method = "AFF46E2FBC9A6ABC9ADD5E2B1D3DF9B0")
    
public int getAsuLevel() {
        int asuLevel;
        if (isGsm) {
            if ((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1)) {
                asuLevel = getGsmAsuLevel();
            } else {
                asuLevel = getLteAsuLevel();
            }
        } else {
            int cdmaAsuLevel = getCdmaAsuLevel();
            int evdoAsuLevel = getEvdoAsuLevel();
            if (evdoAsuLevel == 0) {
                /* We don't know evdo use, cdma */
                asuLevel = cdmaAsuLevel;
            } else if (cdmaAsuLevel == 0) {
                /* We don't know cdma use, evdo */
                asuLevel = evdoAsuLevel;
            } else {
                /* We know both, use the lowest level */
                asuLevel = cdmaAsuLevel < evdoAsuLevel ? cdmaAsuLevel : evdoAsuLevel;
            }
        }
        if (DBG) log("getAsuLevel=" + asuLevel);
        return asuLevel;
    }

    /**
     * Get the signal strength as dBm
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.625 -0500", hash_original_method = "91A92262F8869E8CA480E3922C8E164F", hash_generated_method = "F8AEE6964D3BBAC08D70507D411198EC")
    
public int getDbm() {
        int dBm;

        if(isGsm()) {
            if ((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1)) {
                dBm = getGsmDbm();
            } else {
                dBm = getLteDbm();
            }
        } else {
            dBm = getCdmaDbm();
        }
        if (DBG) log("getDbm=" + dBm);
        return dBm;
    }

    /**
     * Get Gsm signal strength as dBm
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.630 -0500", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "C2C2B71C0BEA196AE42DC8779609DC06")
    
public int getGsmDbm() {
        int dBm;

        int gsmSignalStrength = getGsmSignalStrength();
        int asu = (gsmSignalStrength == 99 ? -1 : gsmSignalStrength);
        if (asu != -1) {
            dBm = -113 + (2 * asu);
        } else {
            dBm = -1;
        }
        if (DBG) log("getGsmDbm=" + dBm);
        return dBm;
    }

    /**
     * Get gsm as level 0..4
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.635 -0500", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "ACEA269BFABDE7496A419B66B3513F13")
    
public int getGsmLevel() {
        int level;

        // ASU ranges from 0 to 31 - TS 27.007 Sec 8.5
        // asu = 0 (-113dB or less) is very weak
        // signal, its better to show 0 bars to the user in such cases.
        // asu = 99 is a special case, where the signal strength is unknown.
        int asu = getGsmSignalStrength();
        if (asu <= 2 || asu == 99) level = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        else if (asu >= 12) level = SIGNAL_STRENGTH_GREAT;
        else if (asu >= 8)  level = SIGNAL_STRENGTH_GOOD;
        else if (asu >= 5)  level = SIGNAL_STRENGTH_MODERATE;
        else level = SIGNAL_STRENGTH_POOR;
        if (DBG) log("getGsmLevel=" + level);
        return level;
    }

    /**
     * Get the gsm signal level as an asu value between 0..31, 99 is unknown
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.641 -0500", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "8BDA35C9EE527BAD2783CF4D97290121")
    
public int getGsmAsuLevel() {
        // ASU ranges from 0 to 31 - TS 27.007 Sec 8.5
        // asu = 0 (-113dB or less) is very weak
        // signal, its better to show 0 bars to the user in such cases.
        // asu = 99 is a special case, where the signal strength is unknown.
        int level = getGsmSignalStrength();
        if (DBG) log("getGsmAsuLevel=" + level);
        return level;
    }

    /**
     * Get cdma as level 0..4
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.646 -0500", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "CB1E07E237199AC54ED3FFE24C4C8914")
    
public int getCdmaLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int levelDbm;
        int levelEcio;

        if (cdmaDbm >= -75) levelDbm = SIGNAL_STRENGTH_GREAT;
        else if (cdmaDbm >= -85) levelDbm = SIGNAL_STRENGTH_GOOD;
        else if (cdmaDbm >= -95) levelDbm = SIGNAL_STRENGTH_MODERATE;
        else if (cdmaDbm >= -100) levelDbm = SIGNAL_STRENGTH_POOR;
        else levelDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;

        // Ec/Io are in dB*10
        if (cdmaEcio >= -90) levelEcio = SIGNAL_STRENGTH_GREAT;
        else if (cdmaEcio >= -110) levelEcio = SIGNAL_STRENGTH_GOOD;
        else if (cdmaEcio >= -130) levelEcio = SIGNAL_STRENGTH_MODERATE;
        else if (cdmaEcio >= -150) levelEcio = SIGNAL_STRENGTH_POOR;
        else levelEcio = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;

        int level = (levelDbm < levelEcio) ? levelDbm : levelEcio;
        if (DBG) log("getCdmaLevel=" + level);
        return level;
    }

    /**
     * Get the cdma signal level as an asu value between 0..31, 99 is unknown
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.652 -0500", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "D2D8EEE5422E48683C1F8010CF6B6580")
    
public int getCdmaAsuLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int cdmaAsuLevel;
        int ecioAsuLevel;

        if (cdmaDbm >= -75) cdmaAsuLevel = 16;
        else if (cdmaDbm >= -82) cdmaAsuLevel = 8;
        else if (cdmaDbm >= -90) cdmaAsuLevel = 4;
        else if (cdmaDbm >= -95) cdmaAsuLevel = 2;
        else if (cdmaDbm >= -100) cdmaAsuLevel = 1;
        else cdmaAsuLevel = 99;

        // Ec/Io are in dB*10
        if (cdmaEcio >= -90) ecioAsuLevel = 16;
        else if (cdmaEcio >= -100) ecioAsuLevel = 8;
        else if (cdmaEcio >= -115) ecioAsuLevel = 4;
        else if (cdmaEcio >= -130) ecioAsuLevel = 2;
        else if (cdmaEcio >= -150) ecioAsuLevel = 1;
        else ecioAsuLevel = 99;

        int level = (cdmaAsuLevel < ecioAsuLevel) ? cdmaAsuLevel : ecioAsuLevel;
        if (DBG) log("getCdmaAsuLevel=" + level);
        return level;
    }

    /**
     * Get Evdo as level 0..4
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.658 -0500", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "8AEBD915D6EC034217EB3BFF97C8E6F8")
    
public int getEvdoLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;

        if (evdoDbm >= -65) levelEvdoDbm = SIGNAL_STRENGTH_GREAT;
        else if (evdoDbm >= -75) levelEvdoDbm = SIGNAL_STRENGTH_GOOD;
        else if (evdoDbm >= -90) levelEvdoDbm = SIGNAL_STRENGTH_MODERATE;
        else if (evdoDbm >= -105) levelEvdoDbm = SIGNAL_STRENGTH_POOR;
        else levelEvdoDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;

        if (evdoSnr >= 7) levelEvdoSnr = SIGNAL_STRENGTH_GREAT;
        else if (evdoSnr >= 5) levelEvdoSnr = SIGNAL_STRENGTH_GOOD;
        else if (evdoSnr >= 3) levelEvdoSnr = SIGNAL_STRENGTH_MODERATE;
        else if (evdoSnr >= 1) levelEvdoSnr = SIGNAL_STRENGTH_POOR;
        else levelEvdoSnr = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;

        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
        if (DBG) log("getEvdoLevel=" + level);
        return level;
    }

    /**
     * Get the evdo signal level as an asu value between 0..31, 99 is unknown
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.663 -0500", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "2D9D2D57ADE9025D1A571DBA72780BFF")
    
public int getEvdoAsuLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;

        if (evdoDbm >= -65) levelEvdoDbm = 16;
        else if (evdoDbm >= -75) levelEvdoDbm = 8;
        else if (evdoDbm >= -85) levelEvdoDbm = 4;
        else if (evdoDbm >= -95) levelEvdoDbm = 2;
        else if (evdoDbm >= -105) levelEvdoDbm = 1;
        else levelEvdoDbm = 99;

        if (evdoSnr >= 7) levelEvdoSnr = 16;
        else if (evdoSnr >= 6) levelEvdoSnr = 8;
        else if (evdoSnr >= 5) levelEvdoSnr = 4;
        else if (evdoSnr >= 3) levelEvdoSnr = 2;
        else if (evdoSnr >= 1) levelEvdoSnr = 1;
        else levelEvdoSnr = 99;

        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
        if (DBG) log("getEvdoAsuLevel=" + level);
        return level;
    }

    /**
     * Get LTE as dBm
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.668 -0500", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "A2FB0A483B2495384417590B637B00B3")
    
public int getLteDbm() {
        return mLteRsrp;
    }

    /**
     * Get LTE as level 0..4
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.672 -0500", hash_original_method = "CDB40306822E2DC8617AD5A6BB9C97E4", hash_generated_method = "53FE26EDA023995FA53580B41C15C3E2")
    
public int getLteLevel() {
        int levelLteRsrp = 0;

        if (mLteRsrp == -1) levelLteRsrp = 0;
        else if (mLteRsrp >= -85) levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        else if (mLteRsrp >= -95) levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        else if (mLteRsrp >= -105) levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        else if (mLteRsrp >= -115) levelLteRsrp = SIGNAL_STRENGTH_POOR;
        else levelLteRsrp = 0;

        if (DBG) log("Lte level: "+levelLteRsrp);
        return levelLteRsrp;
    }

    /**
     * Get the LTE signal level as an asu value between 0..97, 99 is unknown
     * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.678 -0500", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "83860E8BA866BDB665AC2749FB5AD6E5")
    
public int getLteAsuLevel() {
        int lteAsuLevel = 99;
        int lteDbm = getLteDbm();
        if (lteDbm <= -140) lteAsuLevel = 0;
        else if (lteDbm >= -43) lteAsuLevel = 97;
        else lteAsuLevel = lteDbm + 140;
        if (DBG) log("Lte Asu level: "+lteAsuLevel);
        return lteAsuLevel;
    }

    /**
     * @return true if this is for GSM
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSSpec(DSCat.PHONE_STATE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.682 -0500", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "B70409FA6ADEB0B1159578592B61EB05")
    
public boolean isGsm() {
        return this.isGsm;
    }

    /**
     * @return hash code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.687 -0500", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "F31A78FDF53901CABE2268F0585E0E54")
    
@Override
    public int hashCode() {
        int primeNum = 31;
        return ((mGsmSignalStrength * primeNum)
                + (mGsmBitErrorRate * primeNum)
                + (mCdmaDbm * primeNum) + (mCdmaEcio * primeNum)
                + (mEvdoDbm * primeNum) + (mEvdoEcio * primeNum) + (mEvdoSnr * primeNum)
                + (mLteSignalStrength * primeNum) + (mLteRsrp * primeNum)
                + (mLteRsrq * primeNum) + (mLteRssnr * primeNum) + (mLteCqi * primeNum)
                + (isGsm ? 1 : 0));
    }

    /**
     * @return true if the signal strengths are the same
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.693 -0500", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "300E89C8E73B1FC5E5AD5D1F57AC069C")
    
@Override
    public boolean equals (Object o) {
        SignalStrength s;

        try {
            s = (SignalStrength) o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return (mGsmSignalStrength == s.mGsmSignalStrength
                && mGsmBitErrorRate == s.mGsmBitErrorRate
                && mCdmaDbm == s.mCdmaDbm
                && mCdmaEcio == s.mCdmaEcio
                && mEvdoDbm == s.mEvdoDbm
                && mEvdoEcio == s.mEvdoEcio
                && mEvdoSnr == s.mEvdoSnr
                && mLteSignalStrength == s.mLteSignalStrength
                && mLteRsrp == s.mLteRsrp
                && mLteRsrq == s.mLteRsrq
                && mLteRssnr == s.mLteRssnr
                && mLteCqi == s.mLteCqi
                && isGsm == s.isGsm);
    }

    /**
     * @return string representation.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.698 -0500", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "15FEA039970CFFA8D149F77DE1D83B8A")
    
@Override
    public String toString() {
        return ("SignalStrength:"
                + " " + mGsmSignalStrength
                + " " + mGsmBitErrorRate
                + " " + mCdmaDbm
                + " " + mCdmaEcio
                + " " + mEvdoDbm
                + " " + mEvdoEcio
                + " " + mEvdoSnr
                + " " + mLteSignalStrength
                + " " + mLteRsrp
                + " " + mLteRsrq
                + " " + mLteRssnr
                + " " + mLteCqi
                + " " + (isGsm ? "gsm|lte" : "cdma"));
    }

    /**
     * Set SignalStrength based on intent notifier map
     *
     * @param m intent notifier map
     * @hide
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.703 -0500", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "95924EC67C4EF5182C0126129F09A75D")
    
private void setFromNotifierBundle(Bundle m) {
        mGsmSignalStrength = m.getInt("GsmSignalStrength");
        mGsmBitErrorRate = m.getInt("GsmBitErrorRate");
        mCdmaDbm = m.getInt("CdmaDbm");
        mCdmaEcio = m.getInt("CdmaEcio");
        mEvdoDbm = m.getInt("EvdoDbm");
        mEvdoEcio = m.getInt("EvdoEcio");
        mEvdoSnr = m.getInt("EvdoSnr");
        mLteSignalStrength = m.getInt("LteSignalStrength");
        mLteRsrp = m.getInt("LteRsrp");
        mLteRsrq = m.getInt("LteRsrq");
        mLteRssnr = m.getInt("LteRssnr");
        mLteCqi = m.getInt("LteCqi");
        isGsm = m.getBoolean("isGsm");
    }

    /**
     * Set intent notifier Bundle based on SignalStrength
     *
     * @param m intent notifier Bundle
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:47.707 -0500", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "04666F3055631A388E7245104E27551E")
    
public void fillInNotifierBundle(Bundle m) {
        m.putInt("GsmSignalStrength", mGsmSignalStrength);
        m.putInt("GsmBitErrorRate", mGsmBitErrorRate);
        m.putInt("CdmaDbm", mCdmaDbm);
        m.putInt("CdmaEcio", mCdmaEcio);
        m.putInt("EvdoDbm", mEvdoDbm);
        m.putInt("EvdoEcio", mEvdoEcio);
        m.putInt("EvdoSnr", mEvdoSnr);
        m.putInt("LteSignalStrength", mLteSignalStrength);
        m.putInt("LteRsrp", mLteRsrp);
        m.putInt("LteRsrq", mLteRsrq);
        m.putInt("LteRssnr", mLteRssnr);
        m.putInt("LteCqi", mLteCqi);
        m.putBoolean("isGsm", Boolean.valueOf(isGsm));
    }
    // orphaned legacy method
    public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }
    
    // orphaned legacy method
    public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    
}

