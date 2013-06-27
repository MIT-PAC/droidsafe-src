package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SignalStrength implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "36364D56AF7648551EABF35067448EA3", hash_generated_field = "DF212ABBD77FA8BBA06AA948D0C786A3")

    private int mGsmSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "4F36803C89FD3F6E2D99093C436FBBF9", hash_generated_field = "62197276EA9E6CE4D0502EE53FF46E07")

    private int mGsmBitErrorRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "5E0B80EB4A28EC07E79031265C7AE746", hash_generated_field = "E86784A230D482159884E423762742A0")

    private int mCdmaDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "F8E9877DC52E8EE8F0DF96254A50BF11", hash_generated_field = "6E97F40BFD836F3CE5BD662C51380A2E")

    private int mCdmaEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "434CC9E4495710173A2FB3E253E0CF8B", hash_generated_field = "5F77C00D970A012CF8A70A743502955E")

    private int mEvdoDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "F1BE692BEEB4983C117785FF72750B0D", hash_generated_field = "9D4FAC062F6677FEF890917A2CC74060")

    private int mEvdoEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "C85157EE67DC34A80E3B67796522D23D", hash_generated_field = "A8393F6F3E55D49B155906169F7DF105")

    private int mEvdoSnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "FBE5D9D9DD310250942F33DAB41678F0", hash_generated_field = "2E9C18263B0918B024A476E0A3021D5D")

    private int mLteSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "C9762CBD0EAA7A95E02E0A893545B09D", hash_generated_field = "F7BF008784D2B5C3302EECB15948BC9E")

    private int mLteRsrp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.642 -0400", hash_original_field = "066CA432B5E7799DBE42C87AE9CACDE1", hash_generated_field = "034A5562CA8669F3C12137B1EB35AA93")

    private int mLteRsrq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.663 -0400", hash_original_field = "52547F4A6247CE9C757092A5223DE2DB", hash_generated_field = "CF3AA4BA421912BC2B971AF50DDB829D")

    private int mLteRssnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.663 -0400", hash_original_field = "2D8DC7FAC1A5AAD6C5B6837B0661D2F4", hash_generated_field = "39529D74D8B59671DDC05D399EF4A2BD")

    private int mLteCqi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.663 -0400", hash_original_field = "63820013ACAF4CF17E3413B6B4EA67DD", hash_generated_field = "5BB65659E30CE1CC8D95D33184A43135")

    private boolean isGsm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.664 -0400", hash_original_method = "39BD55AB1A011261FC242AC9054B9C2E", hash_generated_method = "D875ED6565624795B17AC9E777BF75B0")
    public  SignalStrength() {
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
        // ---------- Original Method ----------
        //mGsmSignalStrength = 99;
        //mGsmBitErrorRate = -1;
        //mCdmaDbm = -1;
        //mCdmaEcio = -1;
        //mEvdoDbm = -1;
        //mEvdoEcio = -1;
        //mEvdoSnr = -1;
        //mLteSignalStrength = -1;
        //mLteRsrp = -1;
        //mLteRsrq = -1;
        //mLteRssnr = -1;
        //mLteCqi = -1;
        //isGsm = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.665 -0400", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "8B3499FE5FE1F52A2BA85D36FF45861A")
    public  SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
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
        // ---------- Original Method ----------
        //mGsmSignalStrength = gsmSignalStrength;
        //mGsmBitErrorRate = gsmBitErrorRate;
        //mCdmaDbm = cdmaDbm;
        //mCdmaEcio = cdmaEcio;
        //mEvdoDbm = evdoDbm;
        //mEvdoEcio = evdoEcio;
        //mEvdoSnr = evdoSnr;
        //mLteSignalStrength = lteSignalStrength;
        //mLteRsrp = lteRsrp;
        //mLteRsrq = lteRsrq;
        //mLteRssnr = lteRssnr;
        //mLteCqi = lteCqi;
        //isGsm = gsm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.666 -0400", hash_original_method = "50D26D8F6F19A1F72234E376840BB613", hash_generated_method = "84D96D14B49EB6A5F9479A10F2D6CE8E")
    public  SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            boolean gsm) {
        this(gsmSignalStrength, gsmBitErrorRate, cdmaDbm, cdmaEcio,
                evdoDbm, evdoEcio, evdoSnr, -1, -1, -1, -1, -1, gsm);
        addTaint(gsmSignalStrength);
        addTaint(gsmBitErrorRate);
        addTaint(cdmaDbm);
        addTaint(cdmaEcio);
        addTaint(evdoDbm);
        addTaint(evdoEcio);
        addTaint(evdoSnr);
        addTaint(gsm);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.666 -0400", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "AD1C4173311FB36B551149F186F0E1C4")
    public  SignalStrength(SignalStrength s) {
        copyFrom(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.671 -0400", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "FAA7B76356B0BAA9AA3D8202B8B90A6A")
    public  SignalStrength(Parcel in) {
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
        // ---------- Original Method ----------
        //mGsmSignalStrength = in.readInt();
        //mGsmBitErrorRate = in.readInt();
        //mCdmaDbm = in.readInt();
        //mCdmaEcio = in.readInt();
        //mEvdoDbm = in.readInt();
        //mEvdoEcio = in.readInt();
        //mEvdoSnr = in.readInt();
        //mLteSignalStrength = in.readInt();
        //mLteRsrp = in.readInt();
        //mLteRsrq = in.readInt();
        //mLteRssnr = in.readInt();
        //mLteCqi = in.readInt();
        //isGsm = (in.readInt() != 0);
    }

    
        public static SignalStrength newFromBundle(Bundle m) {
        SignalStrength ret;
        ret = new SignalStrength();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.673 -0400", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "A7E9AAE67CFBB3173109CFF2547D84E6")
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
        // ---------- Original Method ----------
        //mGsmSignalStrength = s.mGsmSignalStrength;
        //mGsmBitErrorRate = s.mGsmBitErrorRate;
        //mCdmaDbm = s.mCdmaDbm;
        //mCdmaEcio = s.mCdmaEcio;
        //mEvdoDbm = s.mEvdoDbm;
        //mEvdoEcio = s.mEvdoEcio;
        //mEvdoSnr = s.mEvdoSnr;
        //mLteSignalStrength = s.mLteSignalStrength;
        //mLteRsrp = s.mLteRsrp;
        //mLteRsrq = s.mLteRsrq;
        //mLteRssnr = s.mLteRssnr;
        //mLteCqi = s.mLteCqi;
        //isGsm = s.isGsm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.674 -0400", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "D1D433DE5256A23888C63D49CE539E2A")
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
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeInt(mGsmSignalStrength);
        //out.writeInt(mGsmBitErrorRate);
        //out.writeInt(mCdmaDbm);
        //out.writeInt(mCdmaEcio);
        //out.writeInt(mEvdoDbm);
        //out.writeInt(mEvdoEcio);
        //out.writeInt(mEvdoSnr);
        //out.writeInt(mLteSignalStrength);
        //out.writeInt(mLteRsrp);
        //out.writeInt(mLteRsrq);
        //out.writeInt(mLteRssnr);
        //out.writeInt(mLteCqi);
        //out.writeInt(isGsm ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.675 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "596A0F87637B94756FCA41036F90DB94")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403025254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403025254;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.675 -0400", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "A207FF734DD0798158936C9CB1C5FE6B")
    public int getGsmSignalStrength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999431240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999431240;
        // ---------- Original Method ----------
        //return this.mGsmSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.676 -0400", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "925F3E0958F3E6EB2160409F673E0933")
    public int getGsmBitErrorRate() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519489612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519489612;
        // ---------- Original Method ----------
        //return this.mGsmBitErrorRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.676 -0400", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "2D4A9A3CF82E0415374BB46DAF538810")
    public int getCdmaDbm() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357416294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357416294;
        // ---------- Original Method ----------
        //return this.mCdmaDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.677 -0400", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "D4EEC626556C1A5F56F1CC40B80AF485")
    public int getCdmaEcio() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195518629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195518629;
        // ---------- Original Method ----------
        //return this.mCdmaEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.677 -0400", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "968B5DFD4E6F4944FE4043FC370D9F41")
    public int getEvdoDbm() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342974104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342974104;
        // ---------- Original Method ----------
        //return this.mEvdoDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.678 -0400", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "C04D21A5BF771E80FBD5341D6F58DAFC")
    public int getEvdoEcio() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512775503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512775503;
        // ---------- Original Method ----------
        //return this.mEvdoEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.678 -0400", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "CF11D267607DF8D071FE9D35349321B0")
    public int getEvdoSnr() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953013389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953013389;
        // ---------- Original Method ----------
        //return this.mEvdoSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.679 -0400", hash_original_method = "7504E540028056CDE39219F81B4E1E59", hash_generated_method = "39429E0AA30A1B23A96D3090CE7CFE19")
    public int getLevel() {
        int level;
        {
            {
                level = getGsmLevel();
            } //End block
            {
                level = getLteLevel();
            } //End block
        } //End block
        {
            int cdmaLevel;
            cdmaLevel = getCdmaLevel();
            int evdoLevel;
            evdoLevel = getEvdoLevel();
            {
                level = getCdmaLevel();
            } //End block
            {
                level = getEvdoLevel();
            } //End block
            {
                level = cdmaLevel < evdoLevel ? cdmaLevel : evdoLevel;
            } //End block
        } //End block
        log("getLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571524871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571524871;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.680 -0400", hash_original_method = "6887E245B7148208FA71118C76512694", hash_generated_method = "1356A4347F34E442321A68D48F88FBFE")
    public int getAsuLevel() {
        int asuLevel;
        {
            {
                asuLevel = getGsmAsuLevel();
            } //End block
            {
                asuLevel = getLteAsuLevel();
            } //End block
        } //End block
        {
            int cdmaAsuLevel;
            cdmaAsuLevel = getCdmaAsuLevel();
            int evdoAsuLevel;
            evdoAsuLevel = getEvdoAsuLevel();
            {
                asuLevel = cdmaAsuLevel;
            } //End block
            {
                asuLevel = evdoAsuLevel;
            } //End block
            {
                asuLevel = cdmaAsuLevel < evdoAsuLevel ? cdmaAsuLevel : evdoAsuLevel;
            } //End block
        } //End block
        log("getAsuLevel=" + asuLevel);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599361932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599361932;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.681 -0400", hash_original_method = "91A92262F8869E8CA480E3922C8E164F", hash_generated_method = "8655EAE2C4D3B1181E38C7AAFE1704AD")
    public int getDbm() {
        int dBm;
        {
            boolean varF960B97914BA73BFBB3E304B0A5AA8C0_92735636 = (isGsm());
            {
                {
                    dBm = getGsmDbm();
                } //End block
                {
                    dBm = getLteDbm();
                } //End block
            } //End block
            {
                dBm = getCdmaDbm();
            } //End block
        } //End collapsed parenthetic
        log("getDbm=" + dBm);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166887850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166887850;
        // ---------- Original Method ----------
        //int dBm;
        //if(isGsm()) {
            //if ((mLteSignalStrength == -1)
                    //&& (mLteRsrp == -1)
                    //&& (mLteRsrq == -1)
                    //&& (mLteRssnr == -1)
                    //&& (mLteCqi == -1)) {
                //dBm = getGsmDbm();
            //} else {
                //dBm = getLteDbm();
            //}
        //} else {
            //dBm = getCdmaDbm();
        //}
        //if (DBG) log("getDbm=" + dBm);
        //return dBm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.744 -0400", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "342F39141EEE04B855071E91C2D0A1EA")
    public int getGsmDbm() {
        int dBm;
        int gsmSignalStrength;
        gsmSignalStrength = getGsmSignalStrength();
        int asu;
        asu = (gsmSignalStrength == 99 ? -1 : gsmSignalStrength);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            dBm = -113 + (2 * asu);
        } //End block
        {
            dBm = -1;
        } //End block
        log("getGsmDbm=" + dBm);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4368299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4368299;
        // ---------- Original Method ----------
        //int dBm;
        //int gsmSignalStrength = getGsmSignalStrength();
        //int asu = (gsmSignalStrength == 99 ? -1 : gsmSignalStrength);
        //if (asu != -1) {
            //dBm = -113 + (2 * asu);
        //} else {
            //dBm = -1;
        //}
        //if (DBG) log("getGsmDbm=" + dBm);
        //return dBm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.745 -0400", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "2AC5BD4D0003C9F3B95B64FCFDE0ED98")
    public int getGsmLevel() {
        int level;
        int asu;
        asu = getGsmSignalStrength();
        level = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        level = SIGNAL_STRENGTH_GREAT;
        level = SIGNAL_STRENGTH_GOOD;
        level = SIGNAL_STRENGTH_MODERATE;
        level = SIGNAL_STRENGTH_POOR;
        log("getGsmLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106931892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106931892;
        // ---------- Original Method ----------
        //int level;
        //int asu = getGsmSignalStrength();
        //if (asu <= 2 || asu == 99) level = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        //else if (asu >= 12) level = SIGNAL_STRENGTH_GREAT;
        //else if (asu >= 8)  level = SIGNAL_STRENGTH_GOOD;
        //else if (asu >= 5)  level = SIGNAL_STRENGTH_MODERATE;
        //else level = SIGNAL_STRENGTH_POOR;
        //if (DBG) log("getGsmLevel=" + level);
        //return level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.746 -0400", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "D8B4EBB85D703FD9EC061B5908C8175D")
    public int getGsmAsuLevel() {
        int level;
        level = getGsmSignalStrength();
        log("getGsmAsuLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541843739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541843739;
        // ---------- Original Method ----------
        //int level = getGsmSignalStrength();
        //if (DBG) log("getGsmAsuLevel=" + level);
        //return level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.753 -0400", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "119C763932F7313DD79AAB114ABE595F")
    public int getCdmaLevel() {
        int cdmaDbm;
        cdmaDbm = getCdmaDbm();
        int cdmaEcio;
        cdmaEcio = getCdmaEcio();
        int levelDbm;
        int levelEcio;
        levelDbm = SIGNAL_STRENGTH_GREAT;
        levelDbm = SIGNAL_STRENGTH_GOOD;
        levelDbm = SIGNAL_STRENGTH_MODERATE;
        levelDbm = SIGNAL_STRENGTH_POOR;
        levelDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        levelEcio = SIGNAL_STRENGTH_GREAT;
        levelEcio = SIGNAL_STRENGTH_GOOD;
        levelEcio = SIGNAL_STRENGTH_MODERATE;
        levelEcio = SIGNAL_STRENGTH_POOR;
        levelEcio = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level;
        level = levelDbm;
        level = levelEcio;
        log("getCdmaLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634750142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634750142;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.760 -0400", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "7FA6D5005231F8438B0C684D2EA3CA96")
    public int getCdmaAsuLevel() {
        int cdmaDbm;
        cdmaDbm = getCdmaDbm();
        int cdmaEcio;
        cdmaEcio = getCdmaEcio();
        int cdmaAsuLevel;
        int ecioAsuLevel;
        cdmaAsuLevel = 16;
        cdmaAsuLevel = 8;
        cdmaAsuLevel = 4;
        cdmaAsuLevel = 2;
        cdmaAsuLevel = 1;
        cdmaAsuLevel = 99;
        ecioAsuLevel = 16;
        ecioAsuLevel = 8;
        ecioAsuLevel = 4;
        ecioAsuLevel = 2;
        ecioAsuLevel = 1;
        ecioAsuLevel = 99;
        int level;
        level = cdmaAsuLevel;
        level = ecioAsuLevel;
        log("getCdmaAsuLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961580304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961580304;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.838 -0400", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "2474869729F25CDAC791B227BEC7891A")
    public int getEvdoLevel() {
        int evdoDbm;
        evdoDbm = getEvdoDbm();
        int evdoSnr;
        evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
        levelEvdoDbm = SIGNAL_STRENGTH_GREAT;
        levelEvdoDbm = SIGNAL_STRENGTH_GOOD;
        levelEvdoDbm = SIGNAL_STRENGTH_MODERATE;
        levelEvdoDbm = SIGNAL_STRENGTH_POOR;
        levelEvdoDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        levelEvdoSnr = SIGNAL_STRENGTH_GREAT;
        levelEvdoSnr = SIGNAL_STRENGTH_GOOD;
        levelEvdoSnr = SIGNAL_STRENGTH_MODERATE;
        levelEvdoSnr = SIGNAL_STRENGTH_POOR;
        levelEvdoSnr = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level;
        level = levelEvdoDbm;
        level = levelEvdoSnr;
        log("getEvdoLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923560953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923560953;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.850 -0400", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "77F868CE75D3A0A958F0F689AA778A6B")
    public int getEvdoAsuLevel() {
        int evdoDbm;
        evdoDbm = getEvdoDbm();
        int evdoSnr;
        evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
        levelEvdoDbm = 16;
        levelEvdoDbm = 8;
        levelEvdoDbm = 4;
        levelEvdoDbm = 2;
        levelEvdoDbm = 1;
        levelEvdoDbm = 99;
        levelEvdoSnr = 16;
        levelEvdoSnr = 8;
        levelEvdoSnr = 4;
        levelEvdoSnr = 2;
        levelEvdoSnr = 1;
        levelEvdoSnr = 99;
        int level;
        level = levelEvdoDbm;
        level = levelEvdoSnr;
        log("getEvdoAsuLevel=" + level);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151022721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151022721;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.853 -0400", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "C30EC103DAAD595E4B19B08EAA9F0D98")
    public int getLteDbm() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29990929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29990929;
        // ---------- Original Method ----------
        //return mLteRsrp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.854 -0400", hash_original_method = "CDB40306822E2DC8617AD5A6BB9C97E4", hash_generated_method = "30CDEEEE4D525190075034093F0F9D7F")
    public int getLteLevel() {
        int levelLteRsrp;
        levelLteRsrp = 0;
        levelLteRsrp = 0;
        levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        levelLteRsrp = SIGNAL_STRENGTH_POOR;
        levelLteRsrp = 0;
        log("Lte level: "+levelLteRsrp);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518304602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_518304602;
        // ---------- Original Method ----------
        //int levelLteRsrp = 0;
        //if (mLteRsrp == -1) levelLteRsrp = 0;
        //else if (mLteRsrp >= -85) levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        //else if (mLteRsrp >= -95) levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        //else if (mLteRsrp >= -105) levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        //else if (mLteRsrp >= -115) levelLteRsrp = SIGNAL_STRENGTH_POOR;
        //else levelLteRsrp = 0;
        //if (DBG) log("Lte level: "+levelLteRsrp);
        //return levelLteRsrp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.856 -0400", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "7B447F70CB4C1E6487BB14A89109C457")
    public int getLteAsuLevel() {
        int lteAsuLevel;
        lteAsuLevel = 99;
        int lteDbm;
        lteDbm = getLteDbm();
        lteAsuLevel = 0;
        lteAsuLevel = 97;
        lteAsuLevel = lteDbm + 140;
        log("Lte Asu level: "+lteAsuLevel);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1100395140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1100395140;
        // ---------- Original Method ----------
        //int lteAsuLevel = 99;
        //int lteDbm = getLteDbm();
        //if (lteDbm <= -140) lteAsuLevel = 0;
        //else if (lteDbm >= -43) lteAsuLevel = 97;
        //else lteAsuLevel = lteDbm + 140;
        //if (DBG) log("Lte Asu level: "+lteAsuLevel);
        //return lteAsuLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.856 -0400", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "12D17FC6548A118A6BDC91D9089D6D8A")
    public boolean isGsm() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260316202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260316202;
        // ---------- Original Method ----------
        //return this.isGsm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.887 -0400", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "23DA497FEDF631D45D7C107B83ACA463")
    @Override
    public int hashCode() {
        int primeNum;
        primeNum = 31;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082333340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082333340;
        // ---------- Original Method ----------
        //int primeNum = 31;
        //return ((mGsmSignalStrength * primeNum)
                //+ (mGsmBitErrorRate * primeNum)
                //+ (mCdmaDbm * primeNum) + (mCdmaEcio * primeNum)
                //+ (mEvdoDbm * primeNum) + (mEvdoEcio * primeNum) + (mEvdoSnr * primeNum)
                //+ (mLteSignalStrength * primeNum) + (mLteRsrp * primeNum)
                //+ (mLteRsrq * primeNum) + (mLteRssnr * primeNum) + (mLteCqi * primeNum)
                //+ (isGsm ? 1 : 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.888 -0400", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "90B139B68E9DDD5943FE7605A5E3DFC8")
    @Override
    public boolean equals(Object o) {
        SignalStrength s;
        try 
        {
            s = (SignalStrength) o;
        } //End block
        catch (ClassCastException ex)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952023598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_952023598;
        // ---------- Original Method ----------
        //SignalStrength s;
        //try {
            //s = (SignalStrength) o;
        //} catch (ClassCastException ex) {
            //return false;
        //}
        //if (o == null) {
            //return false;
        //}
        //return (mGsmSignalStrength == s.mGsmSignalStrength
                //&& mGsmBitErrorRate == s.mGsmBitErrorRate
                //&& mCdmaDbm == s.mCdmaDbm
                //&& mCdmaEcio == s.mCdmaEcio
                //&& mEvdoDbm == s.mEvdoDbm
                //&& mEvdoEcio == s.mEvdoEcio
                //&& mEvdoSnr == s.mEvdoSnr
                //&& mLteSignalStrength == s.mLteSignalStrength
                //&& mLteRsrp == s.mLteRsrp
                //&& mLteRsrq == s.mLteRsrq
                //&& mLteRssnr == s.mLteRssnr
                //&& mLteCqi == s.mLteCqi
                //&& isGsm == s.isGsm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.890 -0400", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "A8DAAE2FA58BACC33DE3181472A41A84")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_943244613 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_943244613 = ("SignalStrength:"
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
        varB4EAC82CA7396A68D541C85D26508E83_943244613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943244613;
        // ---------- Original Method ----------
        //return ("SignalStrength:"
                //+ " " + mGsmSignalStrength
                //+ " " + mGsmBitErrorRate
                //+ " " + mCdmaDbm
                //+ " " + mCdmaEcio
                //+ " " + mEvdoDbm
                //+ " " + mEvdoEcio
                //+ " " + mEvdoSnr
                //+ " " + mLteSignalStrength
                //+ " " + mLteRsrp
                //+ " " + mLteRsrq
                //+ " " + mLteRssnr
                //+ " " + mLteCqi
                //+ " " + (isGsm ? "gsm|lte" : "cdma"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.903 -0400", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "57872D825CCE8069EA73912FC049646A")
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
        // ---------- Original Method ----------
        //mGsmSignalStrength = m.getInt("GsmSignalStrength");
        //mGsmBitErrorRate = m.getInt("GsmBitErrorRate");
        //mCdmaDbm = m.getInt("CdmaDbm");
        //mCdmaEcio = m.getInt("CdmaEcio");
        //mEvdoDbm = m.getInt("EvdoDbm");
        //mEvdoEcio = m.getInt("EvdoEcio");
        //mEvdoSnr = m.getInt("EvdoSnr");
        //mLteSignalStrength = m.getInt("LteSignalStrength");
        //mLteRsrp = m.getInt("LteRsrp");
        //mLteRsrq = m.getInt("LteRsrq");
        //mLteRssnr = m.getInt("LteRssnr");
        //mLteCqi = m.getInt("LteCqi");
        //isGsm = m.getBoolean("isGsm");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.904 -0400", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "DE945727E8B0559D1DC7CB4C231BFCCD")
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
        addTaint(m.getTaint());
        // ---------- Original Method ----------
        //m.putInt("GsmSignalStrength", mGsmSignalStrength);
        //m.putInt("GsmBitErrorRate", mGsmBitErrorRate);
        //m.putInt("CdmaDbm", mCdmaDbm);
        //m.putInt("CdmaEcio", mCdmaEcio);
        //m.putInt("EvdoDbm", mEvdoDbm);
        //m.putInt("EvdoEcio", mEvdoEcio);
        //m.putInt("EvdoSnr", mEvdoSnr);
        //m.putInt("LteSignalStrength", mLteSignalStrength);
        //m.putInt("LteRsrp", mLteRsrp);
        //m.putInt("LteRsrq", mLteRsrq);
        //m.putInt("LteRssnr", mLteRssnr);
        //m.putInt("LteCqi", mLteCqi);
        //m.putBoolean("isGsm", Boolean.valueOf(isGsm));
    }

    
        private static void log(String s) {
        Log.w(LOG_TAG, s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.904 -0400", hash_original_field = "C81CEEA616DACC3409F74A8F2E89C2D7", hash_generated_field = "20C9A89B1EAB5F65DBD99B081CFD2A73")

    private static String LOG_TAG = "SignalStrength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.904 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.905 -0400", hash_original_field = "E3D80F247EF1D5B34B0E769FD1239224", hash_generated_field = "F36B5DA862F2210B7CC8B63BBEC96BC6")

    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "B7A02C6B4B4F42B51CC6EDA55F844223", hash_generated_field = "97056B85052FD1665F55A477FCCE88E5")

    public static final int SIGNAL_STRENGTH_POOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "6B215F20C22540EE4A2E519DB5D5D414", hash_generated_field = "3C5058BFCEEB115196EE2231DF9981BF")

    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "0F3C746ABE8B77807F6D1A46EA2C6AFD", hash_generated_field = "84ECBAA9293AB4A1FA6C266A70AD82B1")

    public static final int SIGNAL_STRENGTH_GOOD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "9446F7559D8E241F4FFD1BC1796DEF80", hash_generated_field = "8354359F6FF7CC86EEAB975D01842E00")

    public static final int SIGNAL_STRENGTH_GREAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "094A086A62C5D628F015BC285BF0F69C", hash_generated_field = "77B4BF83352A596F63869F754229CB9B")

    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "E377057C1EA6E7FC917C9D253FD3DA64", hash_generated_field = "BDFDB8B094372B725FE43741B8D7FCCB")

    public static final String[] SIGNAL_STRENGTH_NAMES = {
        "none", "poor", "moderate", "good", "great"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:38.919 -0400", hash_original_field = "17161E0D5F664640DD3B27CBEFA72BA0", hash_generated_field = "9C95D36DB334C11AD4000563454AA3FC")

    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {
        public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }

        public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    };
}

