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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.784 -0400", hash_original_method = "B19A039139049ABEE5A254FA80C7B57A", hash_generated_method = "2D2036519AD0598D800D33651C932D6B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.784 -0400", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "51D2E5885AE5FA784908EC5E4BB7142E")
    @DSModeled(DSC.SAFE)
    public SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            int lteSignalStrength, int lteRsrp, int lteRsrq, int lteRssnr, int lteCqi,
            boolean gsm) {
        dsTaint.addTaint(lteRssnr);
        dsTaint.addTaint(lteRsrp);
        dsTaint.addTaint(evdoEcio);
        dsTaint.addTaint(lteRsrq);
        dsTaint.addTaint(evdoDbm);
        dsTaint.addTaint(lteCqi);
        dsTaint.addTaint(gsmBitErrorRate);
        dsTaint.addTaint(gsmSignalStrength);
        dsTaint.addTaint(lteSignalStrength);
        dsTaint.addTaint(gsm);
        dsTaint.addTaint(evdoSnr);
        dsTaint.addTaint(cdmaDbm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.784 -0400", hash_original_method = "1A95E94EA24470021E483A93B39FC8F2", hash_generated_method = "8E5320AB85B58EBA1763A3849CFAA0B4")
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
        dsTaint.addTaint(evdoSnr);
        dsTaint.addTaint(cdmaDbm);
        dsTaint.addTaint(cdmaEcio);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.784 -0400", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "43A3601AEBA9B937EFD3B487222822F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength(SignalStrength s) {
        dsTaint.addTaint(s.dsTaint);
        copyFrom(s);
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.785 -0400", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "84F2BCE872A365F62919A1028F44A77A")
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

    
        public static SignalStrength newFromBundle(Bundle m) {
        SignalStrength ret;
        ret = new SignalStrength();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.785 -0400", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "1D479C03DE6F5E4D368EB51F2418E3EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.786 -0400", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "5472562F8B9BBBC3F067F17D0A84C4C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.786 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.786 -0400", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "30FB005B2DBD7313D2AC5CF5D0A302A9")
    @DSModeled(DSC.SAFE)
    public int getGsmSignalStrength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mGsmSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.786 -0400", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "A989BE476E6FB3CC42DDDD93C2F03436")
    @DSModeled(DSC.SAFE)
    public int getGsmBitErrorRate() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mGsmBitErrorRate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.787 -0400", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "7A58F83AF399FD277D748C2C86B6408E")
    @DSModeled(DSC.SAFE)
    public int getCdmaDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.787 -0400", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "35C5D70B088F0729192500CFD0CDE34F")
    @DSModeled(DSC.SAFE)
    public int getCdmaEcio() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mCdmaEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.787 -0400", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "9DEE317EB3EB8D6C9440B5FE8C04EE79")
    @DSModeled(DSC.SAFE)
    public int getEvdoDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoDbm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.787 -0400", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "8DDB539B7277A37A995CC1C94F860BC9")
    @DSModeled(DSC.SAFE)
    public int getEvdoEcio() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoEcio;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.787 -0400", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "1E46D089B194CA89C997C2DFDEBD2A8E")
    @DSModeled(DSC.SAFE)
    public int getEvdoSnr() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.mEvdoSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.788 -0400", hash_original_method = "F59C8D97D2E96EEB14624FE89A3493B7", hash_generated_method = "315D66C1F69D39123FB5DDDFA572CFBB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.788 -0400", hash_original_method = "B4F1A536224AC90FE04A204F92D4D6F3", hash_generated_method = "07B4DFFECEC41AD3EA715D313E581354")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.789 -0400", hash_original_method = "92699B3B048DF308B0FA6E08DF9ACC74", hash_generated_method = "90E065D333E2BD0D91592F7780C58F6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDbm() {
        int dBm;
        {
            boolean varF960B97914BA73BFBB3E304B0A5AA8C0_1924730494 = (isGsm());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.789 -0400", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "43415E8A60B7635BA79F13CA315CB0BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.789 -0400", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "32EB201C016007163844B573ABA1E9EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.789 -0400", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "DEF316F758790DCF22AE845BCBD7AE82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.790 -0400", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "DCC779209BA6FB982283DC3A4F98DC1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.790 -0400", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "E0C3369609966EA0831B88175E402D55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.791 -0400", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "49220F0A0B3C100C265E9E3F04F58527")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.791 -0400", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "0AD801806A7DC336F248592F5A982CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.791 -0400", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "A2DBF07460EABE6A9A5A4DEF6E698E09")
    @DSModeled(DSC.SAFE)
    public int getLteDbm() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLteRsrp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.792 -0400", hash_original_method = "2A0B6509EB47469E34BE2D8607AC636B", hash_generated_method = "92084F4E384BD5BEC8ECAFACA590304A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.792 -0400", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "D081FC3704F25BC3CFF464BDEB8D4CAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.792 -0400", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "AF192F57BA8BE80D84A5B3E8DFF02B9E")
    @DSModeled(DSC.SAFE)
    public boolean isGsm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isGsm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.793 -0400", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "5D6266A92DFD6EAF0DB25F600BE5E831")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.793 -0400", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "BE439F70E26AB3C0A323142E7C3A0F41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.794 -0400", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "3BA95DBB4F1199903BF57D3D4882B3E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.794 -0400", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "4B69E6FBFE7176532CB121FE318CABFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.795 -0400", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "DF44EE0E597EA6F4330537E2D471960E")
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

    
        private static void log(String s) {
        Log.w(LOG_TAG, s);
    }

    
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
    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.795 -0400", hash_original_method = "FD487B8B32AF513C14420FE03C44E804", hash_generated_method = "32B4B8616A517B53612646B600E996DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SignalStrength createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SignalStrength var18382BFCAFDACA36B823EEE5FBCA5EAE_1444131470 = (new SignalStrength(in));
            return (SignalStrength)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SignalStrength(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.795 -0400", hash_original_method = "0A7CC95D329D0816525677C5750140E9", hash_generated_method = "53AE4B37534B5A191FC742EB9798807E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SignalStrength[] newArray(int size) {
            dsTaint.addTaint(size);
            SignalStrength[] varEBB5F95C56CDEAD5D21CAAF9FB8D432F_11139769 = (new SignalStrength[size]);
            return (SignalStrength[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SignalStrength[size];
        }

        
}; //Transformed anonymous class
}

