package com.android.internal.telephony.cdma;

// Droidsafe Imports
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_TEST_CSIM;

import java.util.ArrayList;
import java.util.Locale;

import android.os.AsyncResult;
import android.os.SystemProperties;
import android.util.Log;

import com.android.internal.telephony.AdnRecordLoader;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccCardApplication.AppType;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.telephony.gsm.SIMRecords;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.ims.IsimUiccRecords;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class CdmaLteUiccRecords extends SIMRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "EAD5894CADB8C58D92F20ECA3BE46145", hash_generated_field = "0EA5A23D0B103EB32088F2AFA5A81D56")

    private byte[] mEFpl = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "27551E419713C252A87208D182894F9F", hash_generated_field = "4E309DA9BD4276B5B2895900A28385AA")

    private byte[] mEFli = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "787982BCC7FBB638743E917A1A07FF25", hash_generated_field = "67923527211FB9CFFD63CABF8457488F")

    boolean mCsimSpnDisplayCondition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "668F18316067BA6BA373EB7A1A194905")

    private String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "76757017C04E4F68837E82FA49F255D6")

    private String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.857 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.858 -0400", hash_original_field = "B8BE6DB09BD8854591229D68900E289B", hash_generated_field = "5A2266CADFF6598434ED5A41825FE05C")

    private String mHomeSystemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.858 -0400", hash_original_field = "E59F319DAD5C3639BF542CFAC6400BD6", hash_generated_field = "39BD12C4CE1FCA7643D00FFDCF67E813")

    private String mHomeNetworkId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.858 -0400", hash_original_field = "FF160C2639C0D417E686A17E80AFA77C", hash_generated_field = "89D89698232B45908D9688BC55F4F5B6")

    private final IsimUiccRecords mIsimUiccRecords = new IsimUiccRecords();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.858 -0400", hash_original_method = "1EEE248672EF4A8C6E78EC57BC4B596E", hash_generated_method = "2D882D7A9673974FCDBD7A2C4A677D9E")
    public  CdmaLteUiccRecords(PhoneBase p) {
        super(p);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.858 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "B7D227E03E096434627AED5838ED4D4C")
    @Override
    protected void onRecordLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        recordsToLoad -= 1;
        if(recordsToLoad == 0 && recordsRequested == true)        
        {
            onAllRecordsLoaded();
        } //End block
        else
        if(recordsToLoad < 0)        
        {
            recordsToLoad = 0;
        } //End block
        // ---------- Original Method ----------
        //recordsToLoad -= 1;
        //if (recordsToLoad == 0 && recordsRequested == true) {
            //onAllRecordsLoaded();
        //} else if (recordsToLoad < 0) {
            //Log.e(LOG_TAG, "SIMRecords: recordsToLoad <0, programmer error suspected");
            //recordsToLoad = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.859 -0400", hash_original_method = "E8EE1C045698968684402EFF7D154AD0", hash_generated_method = "EF8A1A3F87EF17E62252C665538BB192")
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setLocaleFromCsim();
        super.onAllRecordsLoaded();
        // ---------- Original Method ----------
        //setLocaleFromCsim();
        //super.onAllRecordsLoaded();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.860 -0400", hash_original_method = "5BA121C6EACB6C26C7E5BA17D0EA0EBE", hash_generated_method = "8DCB71A409D56AC629C6749E94C990F2")
    @Override
    protected void fetchSimRecords() {
        IccFileHandler iccFh = phone.getIccFileHandler();
        recordsRequested = true;
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_ICCID, obtainMessage(EVENT_GET_ICCID_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_AD, obtainMessage(EVENT_GET_AD_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_PL,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfPlLoaded()));
        recordsToLoad++;
        new AdnRecordLoader(phone).loadFromEF(EF_MSISDN, EF_EXT1, 1,
                obtainMessage(EVENT_GET_MSISDN_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_SST, obtainMessage(EVENT_GET_SST_DONE));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_CSIM_LI,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimLiLoaded()));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_CSIM_SPN,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimSpnLoaded()));
        recordsToLoad++;
        iccFh.loadEFLinearFixed(EF_CSIM_MDN, 1,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimMdnLoaded()));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_CSIM_IMSIM,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimImsimLoaded()));
        recordsToLoad++;
        iccFh.loadEFLinearFixedAll(EF_CSIM_CDMAHOME,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimCdmaHomeLoaded()));
        recordsToLoad++;
        iccFh.loadEFTransparent(EF_CSIM_EPRL,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimEprlLoaded()));
        recordsToLoad++;
        recordsToLoad += mIsimUiccRecords.fetchIsimRecords(iccFh, this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.861 -0400", hash_original_method = "097B9B51B341025D2C6281D6E7202450", hash_generated_method = "D8B485151DC04C36A1C4737907DF22F3")
    private int adjstMinDigits(int digits) {
        addTaint(digits);
        digits += 111;
        digits = (digits % 10 == 0)?(digits - 10):digits;
        digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        int varA2AACBD15B619A9B9E5581A6C33BD2B1_2109745743 = (digits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71458887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71458887;
        // ---------- Original Method ----------
        //digits += 111;
        //digits = (digits % 10 == 0)?(digits - 10):digits;
        //digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        //digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        //return digits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.861 -0400", hash_original_method = "8ACEB43E18F76CD22FB9AEC49B26074B", hash_generated_method = "64E5924418210E0B9742CA09B82954C2")
    private void onGetCSimEprlDone(AsyncResult ar) {
        addTaint(ar.getTaint());
        byte[] data = (byte[]) ar.result;
        if(DBG)        
        log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        if(data.length > 3)        
        {
            int prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            mPrlVersion = Integer.toString(prlId);
        } //End block
        if(DBG)        
        log("CSIM PRL version=" + mPrlVersion);
        // ---------- Original Method ----------
        //byte[] data = (byte[]) ar.result;
        //if (DBG) log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        //if (data.length > 3) {
            //int prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            //mPrlVersion = Integer.toString(prlId);
        //}
        //if (DBG) log("CSIM PRL version=" + mPrlVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.862 -0400", hash_original_method = "6650B0E8C5FD9109D896567DAC7169B6", hash_generated_method = "B33DD1884BB9E62900073EF24B64FE00")
    private void setLocaleFromCsim() {
        String prefLang = null;
        prefLang = findBestLanguage(mEFli);
        if(prefLang == null)        
        {
            prefLang = findBestLanguage(mEFpl);
        } //End block
        if(prefLang != null)        
        {
            String imsi = getIMSI();
            String country = null;
            if(imsi != null)            
            {
                country = MccTable.countryCodeForMcc(
                                    Integer.parseInt(imsi.substring(0,3)));
            } //End block
            log("Setting locale to " + prefLang + "_" + country);
            phone.setSystemLocale(prefLang, country, false);
        } //End block
        else
        {
            log ("No suitable CSIM selected locale");
        } //End block
        // ---------- Original Method ----------
        //String prefLang = null;
        //prefLang = findBestLanguage(mEFli);
        //if (prefLang == null) {
            //prefLang = findBestLanguage(mEFpl);
        //}
        //if (prefLang != null) {
            //String imsi = getIMSI();
            //String country = null;
            //if (imsi != null) {
                //country = MccTable.countryCodeForMcc(
                                    //Integer.parseInt(imsi.substring(0,3)));
            //}
            //log("Setting locale to " + prefLang + "_" + country);
            //phone.setSystemLocale(prefLang, country, false);
        //} else {
            //log ("No suitable CSIM selected locale");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.863 -0400", hash_original_method = "389005660E8D32B57FD0D16BC435823F", hash_generated_method = "7D688FF6C7A21385B1AA202AB384E3D0")
    private String findBestLanguage(byte[] languages) {
        addTaint(languages[0]);
        String bestMatch = null;
        String[] locales = phone.getContext().getAssets().getLocales();
        if((languages == null) || (locales == null))        
        {
String var540C13E9E156B687226421B24F2DF178_1944953944 =         null;
        var540C13E9E156B687226421B24F2DF178_1944953944.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1944953944;
        }
for(int i = 0;(i + 1) < languages.length;i += 2)
        {
            try 
            {
                String lang = new String(languages, i, 2, "ISO-8859-1");
for(int j = 0;j < locales.length;j++)
                {
                    if(locales[j] != null && locales[j].length() >= 2 &&
                        locales[j].substring(0, 2).equals(lang))                    
                    {
String varA4CAABCC7740D97423804A50787E8FE8_147377388 =                         lang;
                        varA4CAABCC7740D97423804A50787E8FE8_147377388.addTaint(taint);
                        return varA4CAABCC7740D97423804A50787E8FE8_147377388;
                    } //End block
                } //End block
                if(bestMatch != null)                
                break;
            } //End block
            catch (java.io.UnsupportedEncodingException e)
            {
                log ("Failed to parse SIM language records");
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_2129984190 =         null;
        var540C13E9E156B687226421B24F2DF178_2129984190.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2129984190;
        // ---------- Original Method ----------
        //String bestMatch = null;
        //String[] locales = phone.getContext().getAssets().getLocales();
        //if ((languages == null) || (locales == null)) return null;
        //for (int i = 0; (i + 1) < languages.length; i += 2) {
            //try {
                //String lang = new String(languages, i, 2, "ISO-8859-1");
                //for (int j = 0; j < locales.length; j++) {
                    //if (locales[j] != null && locales[j].length() >= 2 &&
                        //locales[j].substring(0, 2).equals(lang)) {
                        //return lang;
                    //}
                //}
                //if (bestMatch != null) break;
            //} catch(java.io.UnsupportedEncodingException e) {
                //log ("Failed to parse SIM language records");
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.863 -0400", hash_original_method = "8715F9DE01323914473DFA590E77B6CC", hash_generated_method = "AD7FBED3E995ADE5916F56A3AE0B337B")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[CSIM] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CSIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.864 -0400", hash_original_method = "2E582D58F93B3D53A9755A5359649796", hash_generated_method = "01262007AEE252593CEC27CC6EFDD900")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CSIM] " + s);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.864 -0400", hash_original_method = "0A56566EECB0365BEB6D3F46827C5157", hash_generated_method = "D900CC36C110072429B7B16EAD80FD60")
    public String getMdn() {
String var393C1D26E06E9DFB5EBF371AB98AA875_488487703 =         mMdn;
        var393C1D26E06E9DFB5EBF371AB98AA875_488487703.addTaint(taint);
        return var393C1D26E06E9DFB5EBF371AB98AA875_488487703;
        // ---------- Original Method ----------
        //return mMdn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.864 -0400", hash_original_method = "80A82BB385CD03C9B3FC60961865E100", hash_generated_method = "A585DCFD62F9397CBC90F3B435F0D62C")
    public String getMin() {
String varFF498CE7DB7B276D58AE6690DD82E33E_1003979442 =         mMin;
        varFF498CE7DB7B276D58AE6690DD82E33E_1003979442.addTaint(taint);
        return varFF498CE7DB7B276D58AE6690DD82E33E_1003979442;
        // ---------- Original Method ----------
        //return mMin;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.864 -0400", hash_original_method = "063CD09EDCF873A8EE48D2C85BBEA4D0", hash_generated_method = "D52459D757CB8F396C0936C325D2BAEB")
    public String getSid() {
String varFD2D431497481B2BDF28AE8346814D54_1335685745 =         mHomeSystemId;
        varFD2D431497481B2BDF28AE8346814D54_1335685745.addTaint(taint);
        return varFD2D431497481B2BDF28AE8346814D54_1335685745;
        // ---------- Original Method ----------
        //return mHomeSystemId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.865 -0400", hash_original_method = "884F79DB94780A6DBB795ED0D5CD48AE", hash_generated_method = "A7A3F2029C549A69756D7A17B7507311")
    public String getNid() {
String var3934B37C896EBDACECB487BCC2589F5E_1891885324 =         mHomeNetworkId;
        var3934B37C896EBDACECB487BCC2589F5E_1891885324.addTaint(taint);
        return var3934B37C896EBDACECB487BCC2589F5E_1891885324;
        // ---------- Original Method ----------
        //return mHomeNetworkId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.865 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "888F425F48059355ED91320E64F26A37")
    public String getPrlVersion() {
String varF0DFA2A5AE60E78166448A9BF5899625_429671421 =         mPrlVersion;
        varF0DFA2A5AE60E78166448A9BF5899625_429671421.addTaint(taint);
        return varF0DFA2A5AE60E78166448A9BF5899625_429671421;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.865 -0400", hash_original_method = "C58B4A883B983444DBA9A30FEBE0DD9B", hash_generated_method = "2D513424D404887CFB476E4B42F0D6F8")
    public boolean getCsimSpnDisplayCondition() {
        boolean var2FB84317EB0764E4B104D72016521CD2_81039904 = (mCsimSpnDisplayCondition);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594262461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594262461;
        // ---------- Original Method ----------
        //return mCsimSpnDisplayCondition;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.865 -0400", hash_original_method = "C3918CF1E72E747DA54324AC57BD2CA6", hash_generated_method = "4D2797ECBCA7CD99737332176B676312")
    @Override
    public IsimRecords getIsimRecords() {
IsimRecords var9FA4504138E211DC1245B2D89A614D67_411058342 =         mIsimUiccRecords;
        var9FA4504138E211DC1245B2D89A614D67_411058342.addTaint(taint);
        return var9FA4504138E211DC1245B2D89A614D67_411058342;
        // ---------- Original Method ----------
        //return mIsimUiccRecords;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.866 -0400", hash_original_method = "80E64791B17F9A8D9A19FB8366ED7D81", hash_generated_method = "73A065D2C8F8988D08C97DD66E796D98")
    @Override
    public boolean isProvisioned() {
        if(SystemProperties.getBoolean(PROPERTY_TEST_CSIM, false))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1993894734 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461265189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_461265189;
        } //End block
        if(phone.mIccCard.isApplicationOnIcc(AppType.APPTYPE_CSIM) &&
            ((mMdn == null) || (mMin == null)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1067572698 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772786299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772786299;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_551149581 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122764681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122764681;
        // ---------- Original Method ----------
        //if (SystemProperties.getBoolean(PROPERTY_TEST_CSIM, false)) {
            //return true;
        //}
        //if (phone.mIccCard.isApplicationOnIcc(AppType.APPTYPE_CSIM) &&
            //((mMdn == null) || (mMin == null))) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.866 -0400", hash_original_method = "B5878332DE43EFB46C0A76BAF3DD0FEF", hash_generated_method = "0579C6C822FBF8984E53EDBE456A7A65")
    @Override
    protected int dispatchGsmMessage(SmsMessageBase message) {
        addTaint(message.getTaint());
        int var7F91CE8992BA317537F207F464A7A54C_485265009 = (((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523968665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523968665;
        // ---------- Original Method ----------
        //return ((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message);
    }

    
    private class EfPlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.866 -0400", hash_original_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0", hash_generated_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0")
        public EfPlLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.867 -0400", hash_original_method = "46D131BE59CA4E55BA893DF6F7101791", hash_generated_method = "E94999271A5FCD7664B6A9E6CF14891C")
        public String getEfName() {
String var513A1894234E60DB93F91E2EBB321818_1499045688 =             "EF_PL";
            var513A1894234E60DB93F91E2EBB321818_1499045688.addTaint(taint);
            return var513A1894234E60DB93F91E2EBB321818_1499045688;
            // ---------- Original Method ----------
            //return "EF_PL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.867 -0400", hash_original_method = "10BD1E11D2518DCC1D89C745EA9F4059", hash_generated_method = "6F05EEEE9B66E5E88566E17DF02079AC")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            mEFpl = (byte[]) ar.result;
            if(DBG)            
            log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
            // ---------- Original Method ----------
            //mEFpl = (byte[]) ar.result;
            //if (DBG) log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
        }

        
    }


    
    private class EfCsimLiLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.867 -0400", hash_original_method = "E478CAA1D3303C7E73C9739FE9545558", hash_generated_method = "E478CAA1D3303C7E73C9739FE9545558")
        public EfCsimLiLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.867 -0400", hash_original_method = "43CB272303B94BD2BDA1313C04660298", hash_generated_method = "2436DAB2CB134856E06FC2788865909E")
        public String getEfName() {
String var0C55B213DB3CB1F3FA5AF7F0C5D26F41_1822955296 =             "EF_CSIM_LI";
            var0C55B213DB3CB1F3FA5AF7F0C5D26F41_1822955296.addTaint(taint);
            return var0C55B213DB3CB1F3FA5AF7F0C5D26F41_1822955296;
            // ---------- Original Method ----------
            //return "EF_CSIM_LI";
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.868 -0400", hash_original_method = "450EAA4EF2F439560DA5559C99B4124D", hash_generated_method = "88B08C9FED1AE20B3DB490C5AD3B88AD")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            mEFli = (byte[]) ar.result;
for(int i = 0;i < mEFli.length;i+=2)
            {
switch(mEFli[i+1]){
                case 0x01:
                mEFli[i] = 'e';
                mEFli[i+1] = 'n';
                break;
                case 0x02:
                mEFli[i] = 'f';
                mEFli[i+1] = 'r';
                break;
                case 0x03:
                mEFli[i] = 'e';
                mEFli[i+1] = 's';
                break;
                case 0x04:
                mEFli[i] = 'j';
                mEFli[i+1] = 'a';
                break;
                case 0x05:
                mEFli[i] = 'k';
                mEFli[i+1] = 'o';
                break;
                case 0x06:
                mEFli[i] = 'z';
                mEFli[i+1] = 'h';
                break;
                case 0x07:
                mEFli[i] = 'h';
                mEFli[i+1] = 'e';
                break;
                default:
                mEFli[i] = ' ';
                mEFli[i+1] = ' ';
}
            } //End block
            if(DBG)            
            log("EF_LI=" + IccUtils.bytesToHexString(mEFli));
            // ---------- Original Method ----------
            //mEFli = (byte[]) ar.result;
            //for (int i = 0; i < mEFli.length; i+=2) {
                //switch(mEFli[i+1]) {
                //case 0x01: mEFli[i] = 'e'; mEFli[i+1] = 'n';break;
                //case 0x02: mEFli[i] = 'f'; mEFli[i+1] = 'r';break;
                //case 0x03: mEFli[i] = 'e'; mEFli[i+1] = 's';break;
                //case 0x04: mEFli[i] = 'j'; mEFli[i+1] = 'a';break;
                //case 0x05: mEFli[i] = 'k'; mEFli[i+1] = 'o';break;
                //case 0x06: mEFli[i] = 'z'; mEFli[i+1] = 'h';break;
                //case 0x07: mEFli[i] = 'h'; mEFli[i+1] = 'e';break;
                //default: mEFli[i] = ' '; mEFli[i+1] = ' ';
                //}
            //}
            //if (DBG) log("EF_LI=" + IccUtils.bytesToHexString(mEFli));
        }

        
    }


    
    private class EfCsimSpnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.869 -0400", hash_original_method = "19150581A2F47334F7DE2BBDCA8A8F1E", hash_generated_method = "19150581A2F47334F7DE2BBDCA8A8F1E")
        public EfCsimSpnLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.869 -0400", hash_original_method = "E361E237BF5D8C3526DBBFADBF2588AE", hash_generated_method = "F37C0C5E86243113D38E74CFBF63E97B")
        public String getEfName() {
String varA4C3CE1F1A7611DA5E2A3192BC7D3F91_1618482883 =             "EF_CSIM_SPN";
            varA4C3CE1F1A7611DA5E2A3192BC7D3F91_1618482883.addTaint(taint);
            return varA4C3CE1F1A7611DA5E2A3192BC7D3F91_1618482883;
            // ---------- Original Method ----------
            //return "EF_CSIM_SPN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.870 -0400", hash_original_method = "57EF16BB2157E0EC6AC6B1903C815AC5", hash_generated_method = "0408F2161CAC48C34A96B232D2FF5FC7")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            byte[] data = (byte[]) ar.result;
            if(DBG)            
            log("CSIM_SPN=" +
                         IccUtils.bytesToHexString(data));
            mCsimSpnDisplayCondition = ((0x01 & data[0]) != 0);
            int encoding = data[1];
            int language = data[2];
            byte[] spnData = new byte[32];
            System.arraycopy(data, 3, spnData, 0, (data.length < 32) ? data.length : 32);
            int numBytes;
for(numBytes = 0;numBytes < spnData.length;numBytes++)
            {
                if((spnData[numBytes] & 0xFF) == 0xFF)                
                break;
            } //End block
            if(numBytes == 0)            
            {
                spn = "";
                return;
            } //End block
            try 
            {
switch(encoding){
                case UserData.ENCODING_OCTET:
                case UserData.ENCODING_LATIN:
                spn = new String(spnData, 0, numBytes, "ISO-8859-1");
                break;
                case UserData.ENCODING_IA5:
                case UserData.ENCODING_GSM_7BIT_ALPHABET:
                case UserData.ENCODING_7BIT_ASCII:
                spn = GsmAlphabet.gsm7BitPackedToString(spnData, 0, (numBytes*8)/7);
                break;
                case UserData.ENCODING_UNICODE_16:
                spn =  new String(spnData, 0, numBytes, "utf-16");
                break;
                default:
                log("SPN encoding not supported");
}
            } //End block
            catch (Exception e)
            {
                log("spn decode error: " + e);
            } //End block
            if(DBG)            
            log("spn=" + spn);
            if(DBG)            
            log("spnCondition=" + mCsimSpnDisplayCondition);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimMdnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.870 -0400", hash_original_method = "FA7FB660C97CE3D4BC72D3E68D236931", hash_generated_method = "FA7FB660C97CE3D4BC72D3E68D236931")
        public EfCsimMdnLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.871 -0400", hash_original_method = "6DF96F6BE7868B2EF5D1FBEB4BBED3CD", hash_generated_method = "D1333D4B53725EF6CCEA9FEE794CFBFF")
        public String getEfName() {
String varF29B05E9A4381212A0376D6296361B0B_2054969289 =             "EF_CSIM_MDN";
            varF29B05E9A4381212A0376D6296361B0B_2054969289.addTaint(taint);
            return varF29B05E9A4381212A0376D6296361B0B_2054969289;
            // ---------- Original Method ----------
            //return "EF_CSIM_MDN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.871 -0400", hash_original_method = "A47BCAD22D310B4F4C4F5C35578109CD", hash_generated_method = "CA9D4C2BFA58BEA9B688DC03C0B83857")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            byte[] data = (byte[]) ar.result;
            if(DBG)            
            log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            int mdnDigitsNum = 0x0F & data[0];
            mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
            if(DBG)            
            log("CSIM MDN=" + mMdn);
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //if (DBG) log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            //int mdnDigitsNum = 0x0F & data[0];
            //mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
            //if (DBG) log("CSIM MDN=" + mMdn);
        }

        
    }


    
    private class EfCsimImsimLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.871 -0400", hash_original_method = "E1B1DAC057539F9FD410F55956D30AAC", hash_generated_method = "E1B1DAC057539F9FD410F55956D30AAC")
        public EfCsimImsimLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.872 -0400", hash_original_method = "076F279972298500654A9EE948D0453D", hash_generated_method = "A51264E35B9EF0EC1A471F186FCAA6DB")
        public String getEfName() {
String varF98FD8D49A0E6522E0E3E4E510CDC037_133501469 =             "EF_CSIM_IMSIM";
            varF98FD8D49A0E6522E0E3E4E510CDC037_133501469.addTaint(taint);
            return varF98FD8D49A0E6522E0E3E4E510CDC037_133501469;
            // ---------- Original Method ----------
            //return "EF_CSIM_IMSIM";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.872 -0400", hash_original_method = "17F309FAD2B89ABBF6BD1F73DBFF98C1", hash_generated_method = "723A15A32CD21C1E5B1E69E16FCBB0BB")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            byte[] data = (byte[]) ar.result;
            if(DBG)            
            log("CSIM_IMSIM=" + IccUtils.bytesToHexString(data));
            boolean provisioned = ((data[7] & 0x80) == 0x80);
            if(provisioned)            
            {
                int first3digits = ((0x03 & data[2]) << 8) + (0xFF & data[1]);
                int second3digits = (((0xFF & data[5]) << 8) | (0xFF & data[4])) >> 6;
                int digit7 = 0x0F & (data[4] >> 2);
                if(digit7 > 0x09)                
                digit7 = 0;
                int last3digits = ((0x03 & data[4]) << 8) | (0xFF & data[3]);
                first3digits = adjstMinDigits(first3digits);
                second3digits = adjstMinDigits(second3digits);
                last3digits = adjstMinDigits(last3digits);
                StringBuilder builder = new StringBuilder();
                builder.append(String.format(Locale.US, "%03d", first3digits));
                builder.append(String.format(Locale.US, "%03d", second3digits));
                builder.append(String.format(Locale.US, "%d", digit7));
                builder.append(String.format(Locale.US, "%03d", last3digits));
                mMin = builder.toString();
                if(DBG)                
                log("min present=" + mMin);
            } //End block
            else
            {
                if(DBG)                
                log("min not present");
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimCdmaHomeLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.873 -0400", hash_original_method = "860B35F5393621E32B68838EF207B1C4", hash_generated_method = "860B35F5393621E32B68838EF207B1C4")
        public EfCsimCdmaHomeLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.873 -0400", hash_original_method = "72D2F700CD05B7B8BF5E2816D58B5E15", hash_generated_method = "2F275A5B255EBA93E6D9199CA64E371B")
        public String getEfName() {
String varB3406108D299562EFF46E9471973B52E_36991271 =             "EF_CSIM_CDMAHOME";
            varB3406108D299562EFF46E9471973B52E_36991271.addTaint(taint);
            return varB3406108D299562EFF46E9471973B52E_36991271;
            // ---------- Original Method ----------
            //return "EF_CSIM_CDMAHOME";
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.873 -0400", hash_original_method = "71E7D2ACFBE7DC249602D69114B85759", hash_generated_method = "FB6E40D15E5BD8B906DF7ABD149B6262")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            ArrayList<byte[]> dataList = (ArrayList<byte[]>) ar.result;
            if(DBG)            
            log("CSIM_CDMAHOME data size=" + dataList.size());
            if(dataList.isEmpty())            
            {
                return;
            } //End block
            StringBuilder sidBuf = new StringBuilder();
            StringBuilder nidBuf = new StringBuilder();
for(byte[] data : dataList)
            {
                if(data.length == 5)                
                {
                    int sid = ((data[1] & 0xFF) << 8) | (data[0] & 0xFF);
                    int nid = ((data[3] & 0xFF) << 8) | (data[2] & 0xFF);
                    sidBuf.append(sid).append(',');
                    nidBuf.append(nid).append(',');
                } //End block
            } //End block
            sidBuf.setLength(sidBuf.length()-1);
            nidBuf.setLength(nidBuf.length()-1);
            mHomeSystemId = sidBuf.toString();
            mHomeNetworkId = nidBuf.toString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimEprlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.874 -0400", hash_original_method = "352B4C8E045B195C6E9E4E04AF0DE6EE", hash_generated_method = "352B4C8E045B195C6E9E4E04AF0DE6EE")
        public EfCsimEprlLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.874 -0400", hash_original_method = "04C305ABDF4F5B734468C2FED0130506", hash_generated_method = "EC15DEA40682F96D70A33B476F0B9078")
        public String getEfName() {
String var00C958484E51A3739F90563221AC3032_1500332999 =             "EF_CSIM_EPRL";
            var00C958484E51A3739F90563221AC3032_1500332999.addTaint(taint);
            return var00C958484E51A3739F90563221AC3032_1500332999;
            // ---------- Original Method ----------
            //return "EF_CSIM_EPRL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.874 -0400", hash_original_method = "B4E1B568EC9A83A605CFFEF5F57F8030", hash_generated_method = "7EDB07F533D6B95CA1D8B0FAA95AED92")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            onGetCSimEprlDone(ar);
            // ---------- Original Method ----------
            //onGetCSimEprlDone(ar);
        }

        
    }


    
}

