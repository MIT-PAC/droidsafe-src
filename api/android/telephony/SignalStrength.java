package android.telephony;

// Droidsafe Imports
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SignalStrength implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "36364D56AF7648551EABF35067448EA3", hash_generated_field = "DF212ABBD77FA8BBA06AA948D0C786A3")

    private int mGsmSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "4F36803C89FD3F6E2D99093C436FBBF9", hash_generated_field = "62197276EA9E6CE4D0502EE53FF46E07")

    private int mGsmBitErrorRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "5E0B80EB4A28EC07E79031265C7AE746", hash_generated_field = "E86784A230D482159884E423762742A0")

    private int mCdmaDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "F8E9877DC52E8EE8F0DF96254A50BF11", hash_generated_field = "6E97F40BFD836F3CE5BD662C51380A2E")

    private int mCdmaEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "434CC9E4495710173A2FB3E253E0CF8B", hash_generated_field = "5F77C00D970A012CF8A70A743502955E")

    private int mEvdoDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "F1BE692BEEB4983C117785FF72750B0D", hash_generated_field = "9D4FAC062F6677FEF890917A2CC74060")

    private int mEvdoEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.829 -0400", hash_original_field = "C85157EE67DC34A80E3B67796522D23D", hash_generated_field = "A8393F6F3E55D49B155906169F7DF105")

    private int mEvdoSnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "FBE5D9D9DD310250942F33DAB41678F0", hash_generated_field = "2E9C18263B0918B024A476E0A3021D5D")

    private int mLteSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "C9762CBD0EAA7A95E02E0A893545B09D", hash_generated_field = "F7BF008784D2B5C3302EECB15948BC9E")

    private int mLteRsrp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "066CA432B5E7799DBE42C87AE9CACDE1", hash_generated_field = "034A5562CA8669F3C12137B1EB35AA93")

    private int mLteRsrq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "52547F4A6247CE9C757092A5223DE2DB", hash_generated_field = "CF3AA4BA421912BC2B971AF50DDB829D")

    private int mLteRssnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "2D8DC7FAC1A5AAD6C5B6837B0661D2F4", hash_generated_field = "39529D74D8B59671DDC05D399EF4A2BD")

    private int mLteCqi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.830 -0400", hash_original_field = "63820013ACAF4CF17E3413B6B4EA67DD", hash_generated_field = "5BB65659E30CE1CC8D95D33184A43135")

    private boolean isGsm;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.831 -0400", hash_original_method = "39BD55AB1A011261FC242AC9054B9C2E", hash_generated_method = "D875ED6565624795B17AC9E777BF75B0")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.835 -0400", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "8B3499FE5FE1F52A2BA85D36FF45861A")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.835 -0400", hash_original_method = "50D26D8F6F19A1F72234E376840BB613", hash_generated_method = "B75B55533EC54529861535BB55D7AF99")
    public  SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            boolean gsm) {
        this(gsmSignalStrength, gsmBitErrorRate, cdmaDbm, cdmaEcio,
                evdoDbm, evdoEcio, evdoSnr, -1, -1, -1, -1, -1, gsm);
        addTaint(gsm);
        addTaint(evdoSnr);
        addTaint(evdoEcio);
        addTaint(evdoDbm);
        addTaint(cdmaEcio);
        addTaint(cdmaDbm);
        addTaint(gsmBitErrorRate);
        addTaint(gsmSignalStrength);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.836 -0400", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "8775670C6B925846E405B998852B6AAB")
    public  SignalStrength(SignalStrength s) {
        addTaint(s.getTaint());
        copyFrom(s);
        // ---------- Original Method ----------
        //copyFrom(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.837 -0400", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "FAA7B76356B0BAA9AA3D8202B8B90A6A")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.839 -0400", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "A7E9AAE67CFBB3173109CFF2547D84E6")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.839 -0400", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "B90DF558AEC913DC18D8555F274B17F0")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.840 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C5AB890CB99E1D7BCD624ACB460201CE")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1536993382 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145810973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145810973;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.840 -0400", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "D384C234F64C9C6220A316ED681457C8")
    public int getGsmSignalStrength() {
        int varF6D024FCBC092F8CA655B3ADD44E65F2_2050923072 = (this.mGsmSignalStrength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84533596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84533596;
        // ---------- Original Method ----------
        //return this.mGsmSignalStrength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.840 -0400", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "E0203E0654273200E472EC2218D2F055")
    public int getGsmBitErrorRate() {
        int var3D6B6FCA5C55C54B4E9616E3F18CCF4A_1341898401 = (this.mGsmBitErrorRate);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376150223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376150223;
        // ---------- Original Method ----------
        //return this.mGsmBitErrorRate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.840 -0400", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "AF354944CE4CCD99604206F28F7C817B")
    public int getCdmaDbm() {
        int var1634A1D6AA6A3D50C93AE184F8CBD9B3_981123336 = (this.mCdmaDbm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027038706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027038706;
        // ---------- Original Method ----------
        //return this.mCdmaDbm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.841 -0400", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "45C73F36529DBF22B3E5A8B33DAAB396")
    public int getCdmaEcio() {
        int var26C8A0B22A123734990D48F8274C8129_2147140372 = (this.mCdmaEcio);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830609448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830609448;
        // ---------- Original Method ----------
        //return this.mCdmaEcio;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.841 -0400", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "8C58EF5CD3B7AF86E006F36DE330DCE3")
    public int getEvdoDbm() {
        int varE161CACFF03699C64B2E7386CC1AB736_1131224222 = (this.mEvdoDbm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879276373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879276373;
        // ---------- Original Method ----------
        //return this.mEvdoDbm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.841 -0400", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "BB05DEC642CE2829251D389DADB75E2A")
    public int getEvdoEcio() {
        int var3E78086B484F051EAB78CE913A8DD796_1030092332 = (this.mEvdoEcio);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052310089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052310089;
        // ---------- Original Method ----------
        //return this.mEvdoEcio;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.842 -0400", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "0B6811EC3B078080A1DBC70889B6EB8C")
    public int getEvdoSnr() {
        int varE1D4E57EE59C0185BEB84F195185B7B5_1613588965 = (this.mEvdoSnr);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14242896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14242896;
        // ---------- Original Method ----------
        //return this.mEvdoSnr;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.843 -0400", hash_original_method = "7504E540028056CDE39219F81B4E1E59", hash_generated_method = "08CFDE14D4A6633CEA4F0CAA98FF5F89")
    public int getLevel() {
        int level;
        if(isGsm)        
        {
            if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                level = getGsmLevel();
            } //End block
            else
            {
                level = getLteLevel();
            } //End block
        } //End block
        else
        {
            int cdmaLevel = getCdmaLevel();
            int evdoLevel = getEvdoLevel();
            if(evdoLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN)            
            {
                level = getCdmaLevel();
            } //End block
            else
            if(cdmaLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN)            
            {
                level = getEvdoLevel();
            } //End block
            else
            {
                level = cdmaLevel < evdoLevel ? cdmaLevel : evdoLevel;
            } //End block
        } //End block
        if(DBG)        
        log("getLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_1380490916 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780034052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780034052;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.844 -0400", hash_original_method = "6887E245B7148208FA71118C76512694", hash_generated_method = "AECB185C16FE5FD1C4A1666ECB4872E7")
    public int getAsuLevel() {
        int asuLevel;
        if(isGsm)        
        {
            if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                asuLevel = getGsmAsuLevel();
            } //End block
            else
            {
                asuLevel = getLteAsuLevel();
            } //End block
        } //End block
        else
        {
            int cdmaAsuLevel = getCdmaAsuLevel();
            int evdoAsuLevel = getEvdoAsuLevel();
            if(evdoAsuLevel == 0)            
            {
                asuLevel = cdmaAsuLevel;
            } //End block
            else
            if(cdmaAsuLevel == 0)            
            {
                asuLevel = evdoAsuLevel;
            } //End block
            else
            {
                asuLevel = cdmaAsuLevel < evdoAsuLevel ? cdmaAsuLevel : evdoAsuLevel;
            } //End block
        } //End block
        if(DBG)        
        log("getAsuLevel=" + asuLevel);
        int var0A23479432B8D79D03BA8EAF294724FF_642076107 = (asuLevel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265477662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265477662;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.845 -0400", hash_original_method = "91A92262F8869E8CA480E3922C8E164F", hash_generated_method = "2C9255775E8EC586079F93B5B18AA2CF")
    public int getDbm() {
        int dBm;
        if(isGsm())        
        {
            if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                dBm = getGsmDbm();
            } //End block
            else
            {
                dBm = getLteDbm();
            } //End block
        } //End block
        else
        {
            dBm = getCdmaDbm();
        } //End block
        if(DBG)        
        log("getDbm=" + dBm);
        int var21B2C5773D09C68FE13DD43912183F9B_1349281700 = (dBm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424861520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424861520;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.845 -0400", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "943A033D5E73A878CB4EC6B77514CA26")
    public int getGsmDbm() {
        int dBm;
        int gsmSignalStrength = getGsmSignalStrength();
        int asu = (gsmSignalStrength == 99 ? -1 : gsmSignalStrength);
        if(asu != -1)        
        {
            dBm = -113 + (2 * asu);
        } //End block
        else
        {
            dBm = -1;
        } //End block
        if(DBG)        
        log("getGsmDbm=" + dBm);
        int var21B2C5773D09C68FE13DD43912183F9B_1032248309 = (dBm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450351472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450351472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.845 -0400", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "0E700603C82E6E42E05529D50C01136D")
    public int getGsmLevel() {
        int level;
        int asu = getGsmSignalStrength();
        if(asu <= 2 || asu == 99)        
        level = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        else
        if(asu >= 12)        
        level = SIGNAL_STRENGTH_GREAT;
        else
        if(asu >= 8)        
        level = SIGNAL_STRENGTH_GOOD;
        else
        if(asu >= 5)        
        level = SIGNAL_STRENGTH_MODERATE;
        else
        level = SIGNAL_STRENGTH_POOR;
        if(DBG)        
        log("getGsmLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_543626311 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962985658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962985658;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.846 -0400", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "C84943CB90BE79CB0569F3B599DE7EAE")
    public int getGsmAsuLevel() {
        int level = getGsmSignalStrength();
        if(DBG)        
        log("getGsmAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_561689999 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478531795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478531795;
        // ---------- Original Method ----------
        //int level = getGsmSignalStrength();
        //if (DBG) log("getGsmAsuLevel=" + level);
        //return level;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.846 -0400", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "9339037037540A9EB7EB4FFCBD1785EE")
    public int getCdmaLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int levelDbm;
        int levelEcio;
        if(cdmaDbm >= -75)        
        levelDbm = SIGNAL_STRENGTH_GREAT;
        else
        if(cdmaDbm >= -85)        
        levelDbm = SIGNAL_STRENGTH_GOOD;
        else
        if(cdmaDbm >= -95)        
        levelDbm = SIGNAL_STRENGTH_MODERATE;
        else
        if(cdmaDbm >= -100)        
        levelDbm = SIGNAL_STRENGTH_POOR;
        else
        levelDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        if(cdmaEcio >= -90)        
        levelEcio = SIGNAL_STRENGTH_GREAT;
        else
        if(cdmaEcio >= -110)        
        levelEcio = SIGNAL_STRENGTH_GOOD;
        else
        if(cdmaEcio >= -130)        
        levelEcio = SIGNAL_STRENGTH_MODERATE;
        else
        if(cdmaEcio >= -150)        
        levelEcio = SIGNAL_STRENGTH_POOR;
        else
        levelEcio = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level = (levelDbm < levelEcio) ? levelDbm : levelEcio;
        if(DBG)        
        log("getCdmaLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_2060598117 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72260945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72260945;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.848 -0400", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "4A0228946FD2B7306987D0CED296F102")
    public int getCdmaAsuLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int cdmaAsuLevel;
        int ecioAsuLevel;
        if(cdmaDbm >= -75)        
        cdmaAsuLevel = 16;
        else
        if(cdmaDbm >= -82)        
        cdmaAsuLevel = 8;
        else
        if(cdmaDbm >= -90)        
        cdmaAsuLevel = 4;
        else
        if(cdmaDbm >= -95)        
        cdmaAsuLevel = 2;
        else
        if(cdmaDbm >= -100)        
        cdmaAsuLevel = 1;
        else
        cdmaAsuLevel = 99;
        if(cdmaEcio >= -90)        
        ecioAsuLevel = 16;
        else
        if(cdmaEcio >= -100)        
        ecioAsuLevel = 8;
        else
        if(cdmaEcio >= -115)        
        ecioAsuLevel = 4;
        else
        if(cdmaEcio >= -130)        
        ecioAsuLevel = 2;
        else
        if(cdmaEcio >= -150)        
        ecioAsuLevel = 1;
        else
        ecioAsuLevel = 99;
        int level = (cdmaAsuLevel < ecioAsuLevel) ? cdmaAsuLevel : ecioAsuLevel;
        if(DBG)        
        log("getCdmaAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_1386492117 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341940953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341940953;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.848 -0400", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "AC2FFB8282F23A18BC09DDBB93C1337E")
    public int getEvdoLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
        if(evdoDbm >= -65)        
        levelEvdoDbm = SIGNAL_STRENGTH_GREAT;
        else
        if(evdoDbm >= -75)        
        levelEvdoDbm = SIGNAL_STRENGTH_GOOD;
        else
        if(evdoDbm >= -90)        
        levelEvdoDbm = SIGNAL_STRENGTH_MODERATE;
        else
        if(evdoDbm >= -105)        
        levelEvdoDbm = SIGNAL_STRENGTH_POOR;
        else
        levelEvdoDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        if(evdoSnr >= 7)        
        levelEvdoSnr = SIGNAL_STRENGTH_GREAT;
        else
        if(evdoSnr >= 5)        
        levelEvdoSnr = SIGNAL_STRENGTH_GOOD;
        else
        if(evdoSnr >= 3)        
        levelEvdoSnr = SIGNAL_STRENGTH_MODERATE;
        else
        if(evdoSnr >= 1)        
        levelEvdoSnr = SIGNAL_STRENGTH_POOR;
        else
        levelEvdoSnr = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
        if(DBG)        
        log("getEvdoLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_745832721 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349840083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349840083;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.849 -0400", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "1129D0E6F4BB2BC99E9E30A596D04784")
    public int getEvdoAsuLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
        if(evdoDbm >= -65)        
        levelEvdoDbm = 16;
        else
        if(evdoDbm >= -75)        
        levelEvdoDbm = 8;
        else
        if(evdoDbm >= -85)        
        levelEvdoDbm = 4;
        else
        if(evdoDbm >= -95)        
        levelEvdoDbm = 2;
        else
        if(evdoDbm >= -105)        
        levelEvdoDbm = 1;
        else
        levelEvdoDbm = 99;
        if(evdoSnr >= 7)        
        levelEvdoSnr = 16;
        else
        if(evdoSnr >= 6)        
        levelEvdoSnr = 8;
        else
        if(evdoSnr >= 5)        
        levelEvdoSnr = 4;
        else
        if(evdoSnr >= 3)        
        levelEvdoSnr = 2;
        else
        if(evdoSnr >= 1)        
        levelEvdoSnr = 1;
        else
        levelEvdoSnr = 99;
        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
        if(DBG)        
        log("getEvdoAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_580629415 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212043642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212043642;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.850 -0400", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "178BB658364DF12FE6AA6BFBABCC6704")
    public int getLteDbm() {
        int varC9762CBD0EAA7A95E02E0A893545B09D_405704638 = (mLteRsrp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319896140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319896140;
        // ---------- Original Method ----------
        //return mLteRsrp;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.850 -0400", hash_original_method = "CDB40306822E2DC8617AD5A6BB9C97E4", hash_generated_method = "B1C15CEBD70730638FFF8B03CCC2C7E8")
    public int getLteLevel() {
        int levelLteRsrp = 0;
        if(mLteRsrp == -1)        
        levelLteRsrp = 0;
        else
        if(mLteRsrp >= -85)        
        levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        else
        if(mLteRsrp >= -95)        
        levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        else
        if(mLteRsrp >= -105)        
        levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        else
        if(mLteRsrp >= -115)        
        levelLteRsrp = SIGNAL_STRENGTH_POOR;
        else
        levelLteRsrp = 0;
        if(DBG)        
        log("Lte level: "+levelLteRsrp);
        int varA51AFA071C3DD6BE51B5B624324DC6BC_2057022626 = (levelLteRsrp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463334231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463334231;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.850 -0400", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "CFE3A97474C079D14D345ACF51B3EB1D")
    public int getLteAsuLevel() {
        int lteAsuLevel = 99;
        int lteDbm = getLteDbm();
        if(lteDbm <= -140)        
        lteAsuLevel = 0;
        else
        if(lteDbm >= -43)        
        lteAsuLevel = 97;
        else
        lteAsuLevel = lteDbm + 140;
        if(DBG)        
        log("Lte Asu level: "+lteAsuLevel);
        int varBC17D11A841959FC6E06C0270787B1E9_836301835 = (lteAsuLevel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506466515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506466515;
        // ---------- Original Method ----------
        //int lteAsuLevel = 99;
        //int lteDbm = getLteDbm();
        //if (lteDbm <= -140) lteAsuLevel = 0;
        //else if (lteDbm >= -43) lteAsuLevel = 97;
        //else lteAsuLevel = lteDbm + 140;
        //if (DBG) log("Lte Asu level: "+lteAsuLevel);
        //return lteAsuLevel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.850 -0400", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "E80AE69A3504395BB13FEC971C01677A")
    public boolean isGsm() {
        boolean var26B70D966913FAE5824B1B6647F5C9F3_2062159001 = (this.isGsm);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515415554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515415554;
        // ---------- Original Method ----------
        //return this.isGsm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.851 -0400", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "38435661D67CDF9C5C612FCA6FF94656")
    @Override
    public int hashCode() {
        int primeNum = 31;
        int var461905A7DCCF46114DFA53BFFBA3663C_721825598 = (((mGsmSignalStrength * primeNum)
                + (mGsmBitErrorRate * primeNum)
                + (mCdmaDbm * primeNum) + (mCdmaEcio * primeNum)
                + (mEvdoDbm * primeNum) + (mEvdoEcio * primeNum) + (mEvdoSnr * primeNum)
                + (mLteSignalStrength * primeNum) + (mLteRsrp * primeNum)
                + (mLteRsrq * primeNum) + (mLteRssnr * primeNum) + (mLteCqi * primeNum)
                + (isGsm ? 1 : 0)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10394322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_10394322;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.852 -0400", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "F98D04BB83E9FAD7DF117FF50340C10A")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        SignalStrength s;
        try 
        {
            s = (SignalStrength) o;
        } //End block
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1319540490 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830954343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_830954343;
        } //End block
        if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1510069002 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104170150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104170150;
        } //End block
        boolean varD3F5E11D698AE21F5FA0E987030704AB_749921783 = ((mGsmSignalStrength == s.mGsmSignalStrength
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
                && isGsm == s.isGsm));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449438792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449438792;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.853 -0400", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "0E6BFBEF759E165420AEB9396CC15D43")
    @Override
    public String toString() {
String var3AB1774E337C2A164F26B8C12AE948E0_1668494751 =         ("SignalStrength:"
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
        var3AB1774E337C2A164F26B8C12AE948E0_1668494751.addTaint(taint);
        return var3AB1774E337C2A164F26B8C12AE948E0_1668494751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.853 -0400", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "57872D825CCE8069EA73912FC049646A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "F6A68F433F790947D25FFFAFAAF8E71F")
    public void fillInNotifierBundle(Bundle m) {
        addTaint(m.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    private static void log(String s) {
        Log.w(LOG_TAG, s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "C81CEEA616DACC3409F74A8F2E89C2D7", hash_generated_field = "6E97287BC5323EE3BC717AB66CCBDA0F")

    private static final String LOG_TAG = "SignalStrength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "E3D80F247EF1D5B34B0E769FD1239224", hash_generated_field = "F36B5DA862F2210B7CC8B63BBEC96BC6")

    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "B7A02C6B4B4F42B51CC6EDA55F844223", hash_generated_field = "97056B85052FD1665F55A477FCCE88E5")

    public static final int SIGNAL_STRENGTH_POOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "6B215F20C22540EE4A2E519DB5D5D414", hash_generated_field = "3C5058BFCEEB115196EE2231DF9981BF")

    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "0F3C746ABE8B77807F6D1A46EA2C6AFD", hash_generated_field = "84ECBAA9293AB4A1FA6C266A70AD82B1")

    public static final int SIGNAL_STRENGTH_GOOD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "9446F7559D8E241F4FFD1BC1796DEF80", hash_generated_field = "8354359F6FF7CC86EEAB975D01842E00")

    public static final int SIGNAL_STRENGTH_GREAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "094A086A62C5D628F015BC285BF0F69C", hash_generated_field = "77B4BF83352A596F63869F754229CB9B")

    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "E377057C1EA6E7FC917C9D253FD3DA64", hash_generated_field = "BDFDB8B094372B725FE43741B8D7FCCB")

    public static final String[] SIGNAL_STRENGTH_NAMES = {
        "none", "poor", "moderate", "good", "great"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.854 -0400", hash_original_field = "17161E0D5F664640DD3B27CBEFA72BA0", hash_generated_field = "9C95D36DB334C11AD4000563454AA3FC")

    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {
        public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }

        public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    };
    // orphaned legacy method
    public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }
    
    // orphaned legacy method
    public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    
}

