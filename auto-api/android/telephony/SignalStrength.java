package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SignalStrength implements Parcelable {
    private static final String LOG_TAG = "SignalStrength";
    private static final boolean DBG = false;
    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    public static final int SIGNAL_STRENGTH_POOR = 1;
    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    public static final int SIGNAL_STRENGTH_GOOD = 3;
    public static final int SIGNAL_STRENGTH_GREAT = 4;
    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    public static final String[] SIGNAL_STRENGTH_NAMES = {
        "none", "poor", "moderate", "good", "great"
    };
    public static final int INVALID_SNR = 0x7FFFFFFF;
    private int mGsmSignalStrength;
    private int mGsmBitErrorRate;
    private int mCdmaDbm;
    private int mCdmaEcio;
    private int mEvdoDbm;
    private int mEvdoEcio;
    private int mEvdoSnr;
    private int mLteSignalStrength;
    private int mLteRsrp;
    private int mLteRsrq;
    private int mLteRssnr;
    private int mLteCqi;
    private boolean isGsm;
    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.732 -0400", hash_original_method = "FD487B8B32AF513C14420FE03C44E804", hash_generated_method = "C0A433784C77B4AC1384572B984EB414")
        @DSModeled(DSC.SAFE)
        public SignalStrength createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (SignalStrength)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SignalStrength(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.732 -0400", hash_original_method = "0A7CC95D329D0816525677C5750140E9", hash_generated_method = "A430F75ADE14666314E6439250705DB2")
        @DSModeled(DSC.SAFE)
        public SignalStrength[] newArray(int size) {
            dsTaint.addTaint(size);
            return (SignalStrength[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SignalStrength[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.732 -0400", hash_original_method = "B19A039139049ABEE5A254FA80C7B57A", hash_generated_method = "A8664AF85FB62953A01ECEC2E0FE0EA6")
    @DSModeled(DSC.SAFE)
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
        mLteRssnr = INVALID_SNR;
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
        //mLteRssnr = INVALID_SNR;
        //mLteCqi = -1;
        //isGsm = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "23A4696A7D43F2365D139723CF7786EB")
    @DSModeled(DSC.SAFE)
    public SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            int lteSignalStrength, int lteRsrp, int lteRsrq, int lteRssnr, int lteCqi,
            boolean gsm) {
        dsTaint.addTaint(lteRssnr);
        dsTaint.addTaint(evdoEcio);
        dsTaint.addTaint(lteCqi);
        dsTaint.addTaint(gsmBitErrorRate);
        dsTaint.addTaint(gsmSignalStrength);
        dsTaint.addTaint(lteSignalStrength);
        dsTaint.addTaint(gsm);
        dsTaint.addTaint(evdoSnr);
        dsTaint.addTaint(cdmaDbm);
        dsTaint.addTaint(lteRsrp);
        dsTaint.addTaint(lteRsrq);
        dsTaint.addTaint(evdoDbm);
        dsTaint.addTaint(cdmaEcio);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "1A95E94EA24470021E483A93B39FC8F2", hash_generated_method = "7763EAABCB969810B1FE136F19B2A4E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            boolean gsm) {
        this(gsmSignalStrength, gsmBitErrorRate, cdmaDbm, cdmaEcio,
                evdoDbm, evdoEcio, evdoSnr, -1, -1,
                -1, INVALID_SNR, -1, gsm);
        dsTaint.addTaint(evdoEcio);
        dsTaint.addTaint(evdoDbm);
        dsTaint.addTaint(gsmBitErrorRate);
        dsTaint.addTaint(gsmSignalStrength);
        dsTaint.addTaint(gsm);
        dsTaint.addTaint(cdmaDbm);
        dsTaint.addTaint(evdoSnr);
        dsTaint.addTaint(cdmaEcio);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "AC4D7371FC6EFAF13124AE70EDEFDCFA")
    @DSModeled(DSC.SAFE)
    public SignalStrength(SignalStrength s) {
        dsTaint.addTaint(s.dsTaint);
        copyFrom(s);
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "02FD999E358A79ADC43E45144333D7AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "F74095F651F3A7ACE8110967D615306B", hash_generated_method = "D262C61D273102DA93E08958EA36A1F1")
    public static SignalStrength newFromBundle(Bundle m) {
        SignalStrength ret;
        ret = new SignalStrength();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "4C8F8A027E4BC95075A5498B0716DDF4")
    @DSModeled(DSC.SAFE)
    protected void copyFrom(SignalStrength s) {
        dsTaint.addTaint(s.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.733 -0400", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "C135CA15A4F9E314D10691AE34C6AA85")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "CF0FE1AC090314012CB9614F3359C11D")
    @DSModeled(DSC.SAFE)
    public int getGsmSignalStrength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mGsmSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "9191C87EA7D56EAC2DA8479AD4550E81")
    @DSModeled(DSC.SAFE)
    public int getGsmBitErrorRate() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mGsmBitErrorRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "015C9C126F359DD25816A8FF95E7D347")
    @DSModeled(DSC.SAFE)
    public int getCdmaDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "53A940400F1E293D79F07C194BEF0DF5")
    @DSModeled(DSC.SAFE)
    public int getCdmaEcio() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "2A3AF645AE6C99A4B2A559ED02A0288B")
    @DSModeled(DSC.SAFE)
    public int getEvdoDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "8072F28D942762531EA6B71502D59948")
    @DSModeled(DSC.SAFE)
    public int getEvdoEcio() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "1ECF226DDA249B7D48DF78CBE0FB0AC2")
    @DSModeled(DSC.SAFE)
    public int getEvdoSnr() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "F59C8D97D2E96EEB14624FE89A3493B7", hash_generated_method = "002943E6BC5291525E79436F92DD8B91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.734 -0400", hash_original_method = "B4F1A536224AC90FE04A204F92D4D6F3", hash_generated_method = "6AE6B2E930A1E2665FD1FCBF14E4A9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.735 -0400", hash_original_method = "92699B3B048DF308B0FA6E08DF9ACC74", hash_generated_method = "D78A703074385C595E6CE9C982842A6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDbm() {
        int dBm;
        {
            boolean varF960B97914BA73BFBB3E304B0A5AA8C0_705388579 = (isGsm());
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int dBm;
        //if(isGsm()) {
            //if ((mLteSignalStrength == -1)
                    //&& (mLteRsrp == -1)
                    //&& (mLteRsrq == -1)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.735 -0400", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "89068A0013ACA75EF02528AC668E2837")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.735 -0400", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "91690002E69EB3C6998FBA1053C7A68D")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.735 -0400", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "23BF3202BA7BA36C9D28C6AB9744A722")
    @DSModeled(DSC.SAFE)
    public int getGsmAsuLevel() {
        int level;
        level = getGsmSignalStrength();
        log("getGsmAsuLevel=" + level);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int level = getGsmSignalStrength();
        //if (DBG) log("getGsmAsuLevel=" + level);
        //return level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.735 -0400", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "96CA662A333F622B1CC11027CD68EC21")
    @DSModeled(DSC.SAFE)
    public int getCdmaLevel() {
        final int cdmaDbm;
        cdmaDbm = getCdmaDbm();
        final int cdmaEcio;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.736 -0400", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "7DA444FB13E1A2D012F777CEE1126B85")
    @DSModeled(DSC.SAFE)
    public int getCdmaAsuLevel() {
        final int cdmaDbm;
        cdmaDbm = getCdmaDbm();
        final int cdmaEcio;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.736 -0400", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "8E48FD32D6B120E1A698354184A04395")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.736 -0400", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "AA49053801B869C8CB8AD4E788CEB250")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.736 -0400", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "D802C60348D55433A9838400BD858C96")
    @DSModeled(DSC.SAFE)
    public int getLteDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLteRsrp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.737 -0400", hash_original_method = "2A0B6509EB47469E34BE2D8607AC636B", hash_generated_method = "5E66EA1ED3B463F5D04D13CCC4A66C3B")
    @DSModeled(DSC.SAFE)
    public int getLteLevel() {
        int levelLteRsrp;
        levelLteRsrp = 0;
        int levelLteRssnr;
        levelLteRssnr = 0;
        levelLteRsrp = 0;
        levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        levelLteRsrp = SIGNAL_STRENGTH_POOR;
        levelLteRssnr = 0;
        levelLteRssnr = SIGNAL_STRENGTH_GREAT;
        levelLteRssnr = SIGNAL_STRENGTH_GOOD;
        levelLteRssnr = SIGNAL_STRENGTH_MODERATE;
        levelLteRssnr = SIGNAL_STRENGTH_POOR;
        int level;
        level = levelLteRssnr;
        level = levelLteRsrp;
        level = (levelLteRssnr < levelLteRsrp) ? levelLteRssnr : levelLteRsrp;
        log("Lte rsrp level: "+levelLteRsrp
                + " snr level: " + levelLteRssnr + " level: " + level);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.737 -0400", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "9698267935D118288BC1C59C371F4867")
    @DSModeled(DSC.SAFE)
    public int getLteAsuLevel() {
        int lteAsuLevel;
        lteAsuLevel = 99;
        int lteDbm;
        lteDbm = getLteDbm();
        lteAsuLevel = 0;
        lteAsuLevel = 97;
        lteAsuLevel = lteDbm + 140;
        log("Lte Asu level: "+lteAsuLevel);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int lteAsuLevel = 99;
        //int lteDbm = getLteDbm();
        //if (lteDbm <= -140) lteAsuLevel = 0;
        //else if (lteDbm >= -43) lteAsuLevel = 97;
        //else lteAsuLevel = lteDbm + 140;
        //if (DBG) log("Lte Asu level: "+lteAsuLevel);
        //return lteAsuLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.737 -0400", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "C0EFDB82C9F9B40E3B2B015D0ED682B0")
    @DSModeled(DSC.SAFE)
    public boolean isGsm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isGsm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.737 -0400", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "A9040E930044450649F3ECB90F6BCDCD")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        int primeNum;
        primeNum = 31;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.737 -0400", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "4450145EFD348D9A31C8988DD6DA608A")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        SignalStrength s;
        try 
        {
            s = (SignalStrength) o;
        } //End block
        catch (ClassCastException ex)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.738 -0400", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "2C504AC89B623FB0C7E1F788BF2BEB93")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.738 -0400", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "542065790B96B0FDABB241B18EFB5AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFromNotifierBundle(Bundle m) {
        dsTaint.addTaint(m.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.738 -0400", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "1D254C75C11AE302017FF6623B9F4A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fillInNotifierBundle(Bundle m) {
        dsTaint.addTaint(m.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.738 -0400", hash_original_method = "277DE078A3A03DEDE382EACFE7464D2F", hash_generated_method = "735FBAD30ECBFB458FF9D49ED05CF8FD")
    private static void log(String s) {
        Log.w(LOG_TAG, s);
    }

    
}


