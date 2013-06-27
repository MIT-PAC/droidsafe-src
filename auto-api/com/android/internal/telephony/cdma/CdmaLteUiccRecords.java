package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.ArrayList;
import java.util.Locale;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_TEST_CSIM;

public final class CdmaLteUiccRecords extends SIMRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.889 -0400", hash_original_field = "EAD5894CADB8C58D92F20ECA3BE46145", hash_generated_field = "0EA5A23D0B103EB32088F2AFA5A81D56")

    private byte[] mEFpl = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "27551E419713C252A87208D182894F9F", hash_generated_field = "4E309DA9BD4276B5B2895900A28385AA")

    private byte[] mEFli = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "787982BCC7FBB638743E917A1A07FF25", hash_generated_field = "67923527211FB9CFFD63CABF8457488F")

    boolean mCsimSpnDisplayCondition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "668F18316067BA6BA373EB7A1A194905")

    private String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "76757017C04E4F68837E82FA49F255D6")

    private String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "B8BE6DB09BD8854591229D68900E289B", hash_generated_field = "5A2266CADFF6598434ED5A41825FE05C")

    private String mHomeSystemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "E59F319DAD5C3639BF542CFAC6400BD6", hash_generated_field = "39BD12C4CE1FCA7643D00FFDCF67E813")

    private String mHomeNetworkId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_field = "FF160C2639C0D417E686A17E80AFA77C", hash_generated_field = "1CB9B41742E9334CCB648792393F8F47")

    private IsimUiccRecords mIsimUiccRecords = new IsimUiccRecords();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.896 -0400", hash_original_method = "1EEE248672EF4A8C6E78EC57BC4B596E", hash_generated_method = "2D882D7A9673974FCDBD7A2C4A677D9E")
    public  CdmaLteUiccRecords(PhoneBase p) {
        super(p);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.897 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "CA6811C3E8E53F79CAB56366EF38ECC8")
    @Override
    protected void onRecordLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        recordsToLoad -= 1;
        {
            onAllRecordsLoaded();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.897 -0400", hash_original_method = "E8EE1C045698968684402EFF7D154AD0", hash_generated_method = "EF8A1A3F87EF17E62252C665538BB192")
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setLocaleFromCsim();
        super.onAllRecordsLoaded();
        // ---------- Original Method ----------
        //setLocaleFromCsim();
        //super.onAllRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.898 -0400", hash_original_method = "5BA121C6EACB6C26C7E5BA17D0EA0EBE", hash_generated_method = "EE8366A3C2B215ABBF71F4B8EA45F5B4")
    @Override
    protected void fetchSimRecords() {
        IccFileHandler iccFh;
        iccFh = phone.getIccFileHandler();
        recordsRequested = true;
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        iccFh.loadEFTransparent(EF_ICCID, obtainMessage(EVENT_GET_ICCID_DONE));
        iccFh.loadEFTransparent(EF_AD, obtainMessage(EVENT_GET_AD_DONE));
        iccFh.loadEFTransparent(EF_PL,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfPlLoaded()));
        new AdnRecordLoader(phone).loadFromEF(EF_MSISDN, EF_EXT1, 1,
                obtainMessage(EVENT_GET_MSISDN_DONE));
        iccFh.loadEFTransparent(EF_SST, obtainMessage(EVENT_GET_SST_DONE));
        iccFh.loadEFTransparent(EF_CSIM_LI,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimLiLoaded()));
        iccFh.loadEFTransparent(EF_CSIM_SPN,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimSpnLoaded()));
        iccFh.loadEFLinearFixed(EF_CSIM_MDN, 1,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimMdnLoaded()));
        iccFh.loadEFTransparent(EF_CSIM_IMSIM,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimImsimLoaded()));
        iccFh.loadEFLinearFixedAll(EF_CSIM_CDMAHOME,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimCdmaHomeLoaded()));
        iccFh.loadEFTransparent(EF_CSIM_EPRL,
                obtainMessage(EVENT_GET_ICC_RECORD_DONE, new EfCsimEprlLoaded()));
        recordsToLoad += mIsimUiccRecords.fetchIsimRecords(iccFh, this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.906 -0400", hash_original_method = "097B9B51B341025D2C6281D6E7202450", hash_generated_method = "956FCABF763F62B1B236C6D8E4712567")
    private int adjstMinDigits(int digits) {
        digits += 111;
        digits = (digits % 10 == 0)?(digits - 10):digits;
        digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        addTaint(digits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600526464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600526464;
        // ---------- Original Method ----------
        //digits += 111;
        //digits = (digits % 10 == 0)?(digits - 10):digits;
        //digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        //digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        //return digits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.906 -0400", hash_original_method = "8ACEB43E18F76CD22FB9AEC49B26074B", hash_generated_method = "26E5CA583F98930B44FCC5AA1790AB11")
    private void onGetCSimEprlDone(AsyncResult ar) {
        byte[] data;
        data = (byte[]) ar.result;
        log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        {
            int prlId;
            prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            mPrlVersion = Integer.toString(prlId);
        } //End block
        log("CSIM PRL version=" + mPrlVersion);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //byte[] data = (byte[]) ar.result;
        //if (DBG) log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        //if (data.length > 3) {
            //int prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            //mPrlVersion = Integer.toString(prlId);
        //}
        //if (DBG) log("CSIM PRL version=" + mPrlVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.909 -0400", hash_original_method = "6650B0E8C5FD9109D896567DAC7169B6", hash_generated_method = "F09CE8FC8926B656C108C358A1F5667A")
    private void setLocaleFromCsim() {
        String prefLang;
        prefLang = null;
        prefLang = findBestLanguage(mEFli);
        {
            prefLang = findBestLanguage(mEFpl);
        } //End block
        {
            String imsi;
            imsi = getIMSI();
            String country;
            country = null;
            {
                country = MccTable.countryCodeForMcc(
                                    Integer.parseInt(imsi.substring(0,3)));
            } //End block
            log("Setting locale to " + prefLang + "_" + country);
            phone.setSystemLocale(prefLang, country, false);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.910 -0400", hash_original_method = "389005660E8D32B57FD0D16BC435823F", hash_generated_method = "9DA21550567D06985882B26193661586")
    private String findBestLanguage(byte[] languages) {
        String varB4EAC82CA7396A68D541C85D26508E83_944140040 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2108686114 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_126438193 = null; //Variable for return #3
        String bestMatch;
        bestMatch = null;
        String[] locales;
        locales = phone.getContext().getAssets().getLocales();
        varB4EAC82CA7396A68D541C85D26508E83_944140040 = null;
        {
            int i;
            i = 0;
            i += 2;
            {
                try 
                {
                    String lang;
                    lang = new String(languages, i, 2, "ISO-8859-1");
                    {
                        int j;
                        j = 0;
                        {
                            {
                                boolean var69DCEA382207578FA668797854F726E5_1679467534 = (locales[j] != null && locales[j].length() >= 2 &&
                        locales[j].substring(0, 2).equals(lang));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_2108686114 = lang;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (java.io.UnsupportedEncodingException e)
                {
                    log ("Failed to parse SIM language records");
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_126438193 = null;
        addTaint(languages[0]);
        String varA7E53CE21691AB073D9660D615818899_2064673250; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2064673250 = varB4EAC82CA7396A68D541C85D26508E83_944140040;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2064673250 = varB4EAC82CA7396A68D541C85D26508E83_2108686114;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2064673250 = varB4EAC82CA7396A68D541C85D26508E83_126438193;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2064673250.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2064673250;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.917 -0400", hash_original_method = "8715F9DE01323914473DFA590E77B6CC", hash_generated_method = "3B0C37B4DB1B82C374F0F01783AC8402")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CSIM] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CSIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.917 -0400", hash_original_method = "2E582D58F93B3D53A9755A5359649796", hash_generated_method = "01262007AEE252593CEC27CC6EFDD900")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CSIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.918 -0400", hash_original_method = "0A56566EECB0365BEB6D3F46827C5157", hash_generated_method = "9F6CCB4AAFB91010DC6238912BD6AEC3")
    public String getMdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1003461409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1003461409 = mMdn;
        varB4EAC82CA7396A68D541C85D26508E83_1003461409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1003461409;
        // ---------- Original Method ----------
        //return mMdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.918 -0400", hash_original_method = "80A82BB385CD03C9B3FC60961865E100", hash_generated_method = "20556788899F563DC99E66EC734E9839")
    public String getMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_1911516754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1911516754 = mMin;
        varB4EAC82CA7396A68D541C85D26508E83_1911516754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1911516754;
        // ---------- Original Method ----------
        //return mMin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.919 -0400", hash_original_method = "063CD09EDCF873A8EE48D2C85BBEA4D0", hash_generated_method = "C7D313AE8EEBCA2AF068B5C8C1E11704")
    public String getSid() {
        String varB4EAC82CA7396A68D541C85D26508E83_1773468991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1773468991 = mHomeSystemId;
        varB4EAC82CA7396A68D541C85D26508E83_1773468991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1773468991;
        // ---------- Original Method ----------
        //return mHomeSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.919 -0400", hash_original_method = "884F79DB94780A6DBB795ED0D5CD48AE", hash_generated_method = "EE4000234A64CA745C95E818EDBD4C36")
    public String getNid() {
        String varB4EAC82CA7396A68D541C85D26508E83_148069492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_148069492 = mHomeNetworkId;
        varB4EAC82CA7396A68D541C85D26508E83_148069492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148069492;
        // ---------- Original Method ----------
        //return mHomeNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.925 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "72BC920CF2EC59159B239746926DC56F")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1797425561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797425561 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1797425561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797425561;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.931 -0400", hash_original_method = "C58B4A883B983444DBA9A30FEBE0DD9B", hash_generated_method = "B2EC350351411D40C84E386FDA5962D8")
    public boolean getCsimSpnDisplayCondition() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515522970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515522970;
        // ---------- Original Method ----------
        //return mCsimSpnDisplayCondition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.931 -0400", hash_original_method = "C3918CF1E72E747DA54324AC57BD2CA6", hash_generated_method = "825D43C2E45D9CED8CAD51D10ECA0D23")
    @Override
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1019276827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1019276827 = mIsimUiccRecords;
        varB4EAC82CA7396A68D541C85D26508E83_1019276827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1019276827;
        // ---------- Original Method ----------
        //return mIsimUiccRecords;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.932 -0400", hash_original_method = "80E64791B17F9A8D9A19FB8366ED7D81", hash_generated_method = "AF78B50D9236D7A35BC7C54C540B26E1")
    @Override
    public boolean isProvisioned() {
        {
            boolean var0DF60DD5FEFC41C1EAAF86A01E334B0D_1651800010 = (SystemProperties.getBoolean(PROPERTY_TEST_CSIM, false));
        } //End collapsed parenthetic
        {
            boolean varCD4B507D60337FD84160863D2C35D3EA_664403527 = (phone.mIccCard.isApplicationOnIcc(AppType.APPTYPE_CSIM) &&
            ((mMdn == null) || (mMin == null)));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882938412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882938412;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.932 -0400", hash_original_method = "B5878332DE43EFB46C0A76BAF3DD0FEF", hash_generated_method = "62E45FAAB15EFE7F928E41656E715D66")
    @Override
    protected int dispatchGsmMessage(SmsMessageBase message) {
        int var03061910AF29178D75093273D4AADF1D_1013422937 = (((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message));
        addTaint(message.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076768157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076768157;
        // ---------- Original Method ----------
        //return ((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message);
    }

    
    private class EfPlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.932 -0400", hash_original_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0", hash_generated_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0")
        public EfPlLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.933 -0400", hash_original_method = "46D131BE59CA4E55BA893DF6F7101791", hash_generated_method = "6CE1A0CD53211E5E7C53C9674F2D1A68")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1812409887 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1812409887 = "EF_PL";
            varB4EAC82CA7396A68D541C85D26508E83_1812409887.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1812409887;
            // ---------- Original Method ----------
            //return "EF_PL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.933 -0400", hash_original_method = "10BD1E11D2518DCC1D89C745EA9F4059", hash_generated_method = "05C389710CE12C46BC9343BCD871DD75")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mEFpl = (byte[]) ar.result;
            log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //mEFpl = (byte[]) ar.result;
            //if (DBG) log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
        }

        
    }


    
    private class EfCsimLiLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.941 -0400", hash_original_method = "E478CAA1D3303C7E73C9739FE9545558", hash_generated_method = "E478CAA1D3303C7E73C9739FE9545558")
        public EfCsimLiLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.947 -0400", hash_original_method = "43CB272303B94BD2BDA1313C04660298", hash_generated_method = "FF5BE7BB903E7B10858251A44ED39C5C")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_862803200 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_862803200 = "EF_CSIM_LI";
            varB4EAC82CA7396A68D541C85D26508E83_862803200.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_862803200;
            // ---------- Original Method ----------
            //return "EF_CSIM_LI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.954 -0400", hash_original_method = "450EAA4EF2F439560DA5559C99B4124D", hash_generated_method = "04AB73D30242CA42A2807A8BD3A59F4E")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mEFli = (byte[]) ar.result;
            {
                int i;
                i = 0;
                i+=2;
                {
                    //Begin case 0x01 
                    mEFli[i] = 'e';
                    //End case 0x01 
                    //Begin case 0x01 
                    mEFli[i+1] = 'n';
                    //End case 0x01 
                    //Begin case 0x02 
                    mEFli[i] = 'f';
                    //End case 0x02 
                    //Begin case 0x02 
                    mEFli[i+1] = 'r';
                    //End case 0x02 
                    //Begin case 0x03 
                    mEFli[i] = 'e';
                    //End case 0x03 
                    //Begin case 0x03 
                    mEFli[i+1] = 's';
                    //End case 0x03 
                    //Begin case 0x04 
                    mEFli[i] = 'j';
                    //End case 0x04 
                    //Begin case 0x04 
                    mEFli[i+1] = 'a';
                    //End case 0x04 
                    //Begin case 0x05 
                    mEFli[i] = 'k';
                    //End case 0x05 
                    //Begin case 0x05 
                    mEFli[i+1] = 'o';
                    //End case 0x05 
                    //Begin case 0x06 
                    mEFli[i] = 'z';
                    //End case 0x06 
                    //Begin case 0x06 
                    mEFli[i+1] = 'h';
                    //End case 0x06 
                    //Begin case 0x07 
                    mEFli[i] = 'h';
                    //End case 0x07 
                    //Begin case 0x07 
                    mEFli[i+1] = 'e';
                    //End case 0x07 
                    //Begin case default 
                    mEFli[i] = ' ';
                    //End case default 
                    //Begin case default 
                    mEFli[i+1] = ' ';
                    //End case default 
                } //End block
            } //End collapsed parenthetic
            log("EF_LI=" + IccUtils.bytesToHexString(mEFli));
            addTaint(ar.getTaint());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.955 -0400", hash_original_method = "19150581A2F47334F7DE2BBDCA8A8F1E", hash_generated_method = "19150581A2F47334F7DE2BBDCA8A8F1E")
        public EfCsimSpnLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.955 -0400", hash_original_method = "E361E237BF5D8C3526DBBFADBF2588AE", hash_generated_method = "7F719C582A0116C02CCFF6B96886CB08")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1416686386 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1416686386 = "EF_CSIM_SPN";
            varB4EAC82CA7396A68D541C85D26508E83_1416686386.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1416686386;
            // ---------- Original Method ----------
            //return "EF_CSIM_SPN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.956 -0400", hash_original_method = "57EF16BB2157E0EC6AC6B1903C815AC5", hash_generated_method = "A5B20CEE1B9D491E45D721798254905E")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            byte[] data;
            data = (byte[]) ar.result;
            log("CSIM_SPN=" +
                         IccUtils.bytesToHexString(data));
            mCsimSpnDisplayCondition = ((0x01 & data[0]) != 0);
            int encoding;
            encoding = data[1];
            int language;
            language = data[2];
            byte[] spnData;
            spnData = new byte[32];
            System.arraycopy(data, 3, spnData, 0, (data.length < 32) ? data.length : 32);
            int numBytes;
            {
                numBytes = 0;
            } //End collapsed parenthetic
            {
                spn = "";
            } //End block
            try 
            {
                //Begin case UserData.ENCODING_OCTET UserData.ENCODING_LATIN 
                spn = new String(spnData, 0, numBytes, "ISO-8859-1");
                //End case UserData.ENCODING_OCTET UserData.ENCODING_LATIN 
                //Begin case UserData.ENCODING_IA5 UserData.ENCODING_GSM_7BIT_ALPHABET UserData.ENCODING_7BIT_ASCII 
                spn = GsmAlphabet.gsm7BitPackedToString(spnData, 0, (numBytes*8)/7);
                //End case UserData.ENCODING_IA5 UserData.ENCODING_GSM_7BIT_ALPHABET UserData.ENCODING_7BIT_ASCII 
                //Begin case UserData.ENCODING_UNICODE_16 
                spn =  new String(spnData, 0, numBytes, "utf-16");
                //End case UserData.ENCODING_UNICODE_16 
                //Begin case default 
                log("SPN encoding not supported");
                //End case default 
            } //End block
            catch (Exception e)
            {
                log("spn decode error: " + e);
            } //End block
            log("spn=" + spn);
            log("spnCondition=" + mCsimSpnDisplayCondition);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimMdnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.957 -0400", hash_original_method = "FA7FB660C97CE3D4BC72D3E68D236931", hash_generated_method = "FA7FB660C97CE3D4BC72D3E68D236931")
        public EfCsimMdnLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.957 -0400", hash_original_method = "6DF96F6BE7868B2EF5D1FBEB4BBED3CD", hash_generated_method = "5901CB218D69158EC513E55B587D1A15")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1925668575 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1925668575 = "EF_CSIM_MDN";
            varB4EAC82CA7396A68D541C85D26508E83_1925668575.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1925668575;
            // ---------- Original Method ----------
            //return "EF_CSIM_MDN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.022 -0400", hash_original_method = "A47BCAD22D310B4F4C4F5C35578109CD", hash_generated_method = "DCCE3F1219B3CDB8FFB44BC406D53FDB")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            byte[] data;
            data = (byte[]) ar.result;
            log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            int mdnDigitsNum;
            mdnDigitsNum = 0x0F & data[0];
            mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
            log("CSIM MDN=" + mMdn);
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //if (DBG) log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            //int mdnDigitsNum = 0x0F & data[0];
            //mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
            //if (DBG) log("CSIM MDN=" + mMdn);
        }

        
    }


    
    private class EfCsimImsimLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.022 -0400", hash_original_method = "E1B1DAC057539F9FD410F55956D30AAC", hash_generated_method = "E1B1DAC057539F9FD410F55956D30AAC")
        public EfCsimImsimLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.023 -0400", hash_original_method = "076F279972298500654A9EE948D0453D", hash_generated_method = "D5BE7D126D09944DAFC532145596882B")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_411589036 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_411589036 = "EF_CSIM_IMSIM";
            varB4EAC82CA7396A68D541C85D26508E83_411589036.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_411589036;
            // ---------- Original Method ----------
            //return "EF_CSIM_IMSIM";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.024 -0400", hash_original_method = "17F309FAD2B89ABBF6BD1F73DBFF98C1", hash_generated_method = "D7B8451007F1175AD687F54EC3E1C64E")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            byte[] data;
            data = (byte[]) ar.result;
            log("CSIM_IMSIM=" + IccUtils.bytesToHexString(data));
            boolean provisioned;
            provisioned = ((data[7] & 0x80) == 0x80);
            {
                int first3digits;
                first3digits = ((0x03 & data[2]) << 8) + (0xFF & data[1]);
                int second3digits;
                second3digits = (((0xFF & data[5]) << 8) | (0xFF & data[4])) >> 6;
                int digit7;
                digit7 = 0x0F & (data[4] >> 2);
                digit7 = 0;
                int last3digits;
                last3digits = ((0x03 & data[4]) << 8) | (0xFF & data[3]);
                first3digits = adjstMinDigits(first3digits);
                second3digits = adjstMinDigits(second3digits);
                last3digits = adjstMinDigits(last3digits);
                StringBuilder builder;
                builder = new StringBuilder();
                builder.append(String.format(Locale.US, "%03d", first3digits));
                builder.append(String.format(Locale.US, "%03d", second3digits));
                builder.append(String.format(Locale.US, "%d", digit7));
                builder.append(String.format(Locale.US, "%03d", last3digits));
                mMin = builder.toString();
                log("min present=" + mMin);
            } //End block
            {
                log("min not present");
            } //End block
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimCdmaHomeLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.024 -0400", hash_original_method = "860B35F5393621E32B68838EF207B1C4", hash_generated_method = "860B35F5393621E32B68838EF207B1C4")
        public EfCsimCdmaHomeLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.025 -0400", hash_original_method = "72D2F700CD05B7B8BF5E2816D58B5E15", hash_generated_method = "91D4D4715408B7DC1BF25A16C85C4FD7")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1603643287 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1603643287 = "EF_CSIM_CDMAHOME";
            varB4EAC82CA7396A68D541C85D26508E83_1603643287.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1603643287;
            // ---------- Original Method ----------
            //return "EF_CSIM_CDMAHOME";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.087 -0400", hash_original_method = "71E7D2ACFBE7DC249602D69114B85759", hash_generated_method = "711A700C1170155BBEBD594D1C7710F9")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ArrayList<byte[]> dataList;
            dataList = (ArrayList<byte[]>) ar.result;
            log("CSIM_CDMAHOME data size=" + dataList.size());
            {
                boolean varF19482EB714ACA27D23BC9E396383613_403267236 = (dataList.isEmpty());
            } //End collapsed parenthetic
            StringBuilder sidBuf;
            sidBuf = new StringBuilder();
            StringBuilder nidBuf;
            nidBuf = new StringBuilder();
            {
                Iterator<byte[]> varA79222549A4B1EDD1159325125C84E5C_514285970 = (dataList).iterator();
                varA79222549A4B1EDD1159325125C84E5C_514285970.hasNext();
                byte[] data = varA79222549A4B1EDD1159325125C84E5C_514285970.next();
                {
                    {
                        int sid;
                        sid = ((data[1] & 0xFF) << 8) | (data[0] & 0xFF);
                        int nid;
                        nid = ((data[3] & 0xFF) << 8) | (data[2] & 0xFF);
                        sidBuf.append(sid).append(',');
                        nidBuf.append(nid).append(',');
                    } //End block
                } //End block
            } //End collapsed parenthetic
            sidBuf.setLength(sidBuf.length()-1);
            nidBuf.setLength(nidBuf.length()-1);
            mHomeSystemId = sidBuf.toString();
            mHomeNetworkId = nidBuf.toString();
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimEprlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.097 -0400", hash_original_method = "352B4C8E045B195C6E9E4E04AF0DE6EE", hash_generated_method = "352B4C8E045B195C6E9E4E04AF0DE6EE")
        public EfCsimEprlLoaded ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.104 -0400", hash_original_method = "04C305ABDF4F5B734468C2FED0130506", hash_generated_method = "E9D7F8022BCAFE59FBB1DA780F243884")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_80382136 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_80382136 = "EF_CSIM_EPRL";
            varB4EAC82CA7396A68D541C85D26508E83_80382136.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_80382136;
            // ---------- Original Method ----------
            //return "EF_CSIM_EPRL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.105 -0400", hash_original_method = "B4E1B568EC9A83A605CFFEF5F57F8030", hash_generated_method = "DEED060B9909A9ED769BC4B5070AD46A")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onGetCSimEprlDone(ar);
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //onGetCSimEprlDone(ar);
        }

        
    }


    
}

