package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "EAD5894CADB8C58D92F20ECA3BE46145", hash_generated_field = "0EA5A23D0B103EB32088F2AFA5A81D56")

    private byte[] mEFpl = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "27551E419713C252A87208D182894F9F", hash_generated_field = "4E309DA9BD4276B5B2895900A28385AA")

    private byte[] mEFli = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "787982BCC7FBB638743E917A1A07FF25", hash_generated_field = "67923527211FB9CFFD63CABF8457488F")

    boolean mCsimSpnDisplayCondition = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "668F18316067BA6BA373EB7A1A194905")

    private String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "76757017C04E4F68837E82FA49F255D6")

    private String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "B8BE6DB09BD8854591229D68900E289B", hash_generated_field = "5A2266CADFF6598434ED5A41825FE05C")

    private String mHomeSystemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "E59F319DAD5C3639BF542CFAC6400BD6", hash_generated_field = "39BD12C4CE1FCA7643D00FFDCF67E813")

    private String mHomeNetworkId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_field = "FF160C2639C0D417E686A17E80AFA77C", hash_generated_field = "89D89698232B45908D9688BC55F4F5B6")

    private final IsimUiccRecords mIsimUiccRecords = new IsimUiccRecords();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.980 -0400", hash_original_method = "1EEE248672EF4A8C6E78EC57BC4B596E", hash_generated_method = "2D882D7A9673974FCDBD7A2C4A677D9E")
    public  CdmaLteUiccRecords(PhoneBase p) {
        super(p);
        addTaint(p.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.981 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "CA6811C3E8E53F79CAB56366EF38ECC8")
    @Override
    protected void onRecordLoaded() {
        
        recordsToLoad -= 1;
        {
            onAllRecordsLoaded();
        } 
        {
            recordsToLoad = 0;
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.981 -0400", hash_original_method = "E8EE1C045698968684402EFF7D154AD0", hash_generated_method = "EF8A1A3F87EF17E62252C665538BB192")
    @Override
    protected void onAllRecordsLoaded() {
        
        setLocaleFromCsim();
        super.onAllRecordsLoaded();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.981 -0400", hash_original_method = "5BA121C6EACB6C26C7E5BA17D0EA0EBE", hash_generated_method = "8B7B370769E419433BFF02508FAD854A")
    @Override
    protected void fetchSimRecords() {
        IccFileHandler iccFh = phone.getIccFileHandler();
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.982 -0400", hash_original_method = "097B9B51B341025D2C6281D6E7202450", hash_generated_method = "001117E355A50FC39F859476EC90AD22")
    private int adjstMinDigits(int digits) {
        digits += 111;
        digits = (digits % 10 == 0)?(digits - 10):digits;
        digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        addTaint(digits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858969977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858969977;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.982 -0400", hash_original_method = "8ACEB43E18F76CD22FB9AEC49B26074B", hash_generated_method = "D582CF6BA3743032E754A248E27A5DB8")
    private void onGetCSimEprlDone(AsyncResult ar) {
        byte[] data = (byte[]) ar.result;
        log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        {
            int prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            mPrlVersion = Integer.toString(prlId);
        } 
        log("CSIM PRL version=" + mPrlVersion);
        addTaint(ar.getTaint());
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.984 -0400", hash_original_method = "6650B0E8C5FD9109D896567DAC7169B6", hash_generated_method = "53983C10B026189C086A41C730FAE5ED")
    private void setLocaleFromCsim() {
        String prefLang = null;
        prefLang = findBestLanguage(mEFli);
        {
            prefLang = findBestLanguage(mEFpl);
        } 
        {
            String imsi = getIMSI();
            String country = null;
            {
                country = MccTable.countryCodeForMcc(
                                    Integer.parseInt(imsi.substring(0,3)));
            } 
            log("Setting locale to " + prefLang + "_" + country);
            phone.setSystemLocale(prefLang, country, false);
        } 
        {
            log ("No suitable CSIM selected locale");
        } 
        
        
        
        
            
        
        
            
            
            
                
                                    
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.985 -0400", hash_original_method = "389005660E8D32B57FD0D16BC435823F", hash_generated_method = "40AA93154C1ECB99961765D44D190213")
    private String findBestLanguage(byte[] languages) {
        String varB4EAC82CA7396A68D541C85D26508E83_329346463 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1609677936 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2089472328 = null; 
        String bestMatch = null;
        String[] locales = phone.getContext().getAssets().getLocales();
        varB4EAC82CA7396A68D541C85D26508E83_329346463 = null;
        {
            int i = 0;
            i += 2;
            {
                try 
                {
                    String lang = new String(languages, i, 2, "ISO-8859-1");
                    {
                        int j = 0;
                        {
                            {
                                boolean var69DCEA382207578FA668797854F726E5_924486614 = (locales[j] != null && locales[j].length() >= 2 &&
                        locales[j].substring(0, 2).equals(lang));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1609677936 = lang;
                                } 
                            } 
                        } 
                    } 
                } 
                catch (java.io.UnsupportedEncodingException e)
                {
                    log ("Failed to parse SIM language records");
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2089472328 = null;
        addTaint(languages[0]);
        String varA7E53CE21691AB073D9660D615818899_839452016; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_839452016 = varB4EAC82CA7396A68D541C85D26508E83_329346463;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_839452016 = varB4EAC82CA7396A68D541C85D26508E83_1609677936;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_839452016 = varB4EAC82CA7396A68D541C85D26508E83_2089472328;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_839452016.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_839452016;
        
        
        
        
        
            
                
                
                    
                        
                        
                    
                
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.986 -0400", hash_original_method = "8715F9DE01323914473DFA590E77B6CC", hash_generated_method = "3B0C37B4DB1B82C374F0F01783AC8402")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CSIM] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.986 -0400", hash_original_method = "2E582D58F93B3D53A9755A5359649796", hash_generated_method = "01262007AEE252593CEC27CC6EFDD900")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.986 -0400", hash_original_method = "0A56566EECB0365BEB6D3F46827C5157", hash_generated_method = "EC3AB5EA582076BCF92494C446DE9E73")
    public String getMdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_378287026 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_378287026 = mMdn;
        varB4EAC82CA7396A68D541C85D26508E83_378287026.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_378287026;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.987 -0400", hash_original_method = "80A82BB385CD03C9B3FC60961865E100", hash_generated_method = "2AAFC36F19F09EAC4BDA1183232A0E80")
    public String getMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_2144452580 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2144452580 = mMin;
        varB4EAC82CA7396A68D541C85D26508E83_2144452580.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2144452580;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.987 -0400", hash_original_method = "063CD09EDCF873A8EE48D2C85BBEA4D0", hash_generated_method = "386D2284BC50A4C12EF1C6199D0E5619")
    public String getSid() {
        String varB4EAC82CA7396A68D541C85D26508E83_1403888183 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1403888183 = mHomeSystemId;
        varB4EAC82CA7396A68D541C85D26508E83_1403888183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1403888183;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.988 -0400", hash_original_method = "884F79DB94780A6DBB795ED0D5CD48AE", hash_generated_method = "C9B82C62E17FBB9AD01F4B714E824E9D")
    public String getNid() {
        String varB4EAC82CA7396A68D541C85D26508E83_2005383035 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2005383035 = mHomeNetworkId;
        varB4EAC82CA7396A68D541C85D26508E83_2005383035.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2005383035;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.988 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "E52E2F7FD9236BAE91BD3FDC4E55FC2A")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_899591039 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_899591039 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_899591039.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_899591039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.989 -0400", hash_original_method = "C58B4A883B983444DBA9A30FEBE0DD9B", hash_generated_method = "6A1B545FE884269AC09456AA63AE6450")
    public boolean getCsimSpnDisplayCondition() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844464040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844464040;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.989 -0400", hash_original_method = "C3918CF1E72E747DA54324AC57BD2CA6", hash_generated_method = "8856A8409034A32ECAF1C12F7A0B6084")
    @Override
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_688136827 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_688136827 = mIsimUiccRecords;
        varB4EAC82CA7396A68D541C85D26508E83_688136827.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_688136827;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.989 -0400", hash_original_method = "80E64791B17F9A8D9A19FB8366ED7D81", hash_generated_method = "8F2118AACA69FD5FA52397A88F30FAD4")
    @Override
    public boolean isProvisioned() {
        {
            boolean var0DF60DD5FEFC41C1EAAF86A01E334B0D_555839789 = (SystemProperties.getBoolean(PROPERTY_TEST_CSIM, false));
        } 
        {
            boolean varCD4B507D60337FD84160863D2C35D3EA_844392629 = (phone.mIccCard.isApplicationOnIcc(AppType.APPTYPE_CSIM) &&
            ((mMdn == null) || (mMin == null)));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59521256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59521256;
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.990 -0400", hash_original_method = "B5878332DE43EFB46C0A76BAF3DD0FEF", hash_generated_method = "A35E8B314F6863EDFDA4A370FE2F9EFF")
    @Override
    protected int dispatchGsmMessage(SmsMessageBase message) {
        int var03061910AF29178D75093273D4AADF1D_1155359021 = (((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message));
        addTaint(message.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152403556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152403556;
        
        
    }

    
    private class EfPlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.990 -0400", hash_original_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0", hash_generated_method = "DB9BC3CFEBE0D6E01F9D56ED9DD44BA0")
        public EfPlLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.990 -0400", hash_original_method = "46D131BE59CA4E55BA893DF6F7101791", hash_generated_method = "A2221A25309EDBFA6BBC6F1A73F34CAD")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_10519624 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_10519624 = "EF_PL";
            varB4EAC82CA7396A68D541C85D26508E83_10519624.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_10519624;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.990 -0400", hash_original_method = "10BD1E11D2518DCC1D89C745EA9F4059", hash_generated_method = "05C389710CE12C46BC9343BCD871DD75")
        public void onRecordLoaded(AsyncResult ar) {
            
            mEFpl = (byte[]) ar.result;
            log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
            addTaint(ar.getTaint());
            
            
            
        }

        
    }


    
    private class EfCsimLiLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.990 -0400", hash_original_method = "E478CAA1D3303C7E73C9739FE9545558", hash_generated_method = "E478CAA1D3303C7E73C9739FE9545558")
        public EfCsimLiLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.991 -0400", hash_original_method = "43CB272303B94BD2BDA1313C04660298", hash_generated_method = "FA06A6FCB0B6020EFAB33EE1C4452B5A")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1941221240 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1941221240 = "EF_CSIM_LI";
            varB4EAC82CA7396A68D541C85D26508E83_1941221240.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1941221240;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.992 -0400", hash_original_method = "450EAA4EF2F439560DA5559C99B4124D", hash_generated_method = "713595C5D70F71B8C984B227F848BBC6")
        public void onRecordLoaded(AsyncResult ar) {
            
            mEFli = (byte[]) ar.result;
            {
                int i = 0;
                i+=2;
                {
                    
                    mEFli[i] = 'e';
                    
                    
                    mEFli[i+1] = 'n';
                    
                    
                    mEFli[i] = 'f';
                    
                    
                    mEFli[i+1] = 'r';
                    
                    
                    mEFli[i] = 'e';
                    
                    
                    mEFli[i+1] = 's';
                    
                    
                    mEFli[i] = 'j';
                    
                    
                    mEFli[i+1] = 'a';
                    
                    
                    mEFli[i] = 'k';
                    
                    
                    mEFli[i+1] = 'o';
                    
                    
                    mEFli[i] = 'z';
                    
                    
                    mEFli[i+1] = 'h';
                    
                    
                    mEFli[i] = 'h';
                    
                    
                    mEFli[i+1] = 'e';
                    
                    
                    mEFli[i] = ' ';
                    
                    
                    mEFli[i+1] = ' ';
                    
                } 
            } 
            log("EF_LI=" + IccUtils.bytesToHexString(mEFli));
            addTaint(ar.getTaint());
            
            
            
                
                
                
                
                
                
                
                
                
                
            
            
        }

        
    }


    
    private class EfCsimSpnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.992 -0400", hash_original_method = "19150581A2F47334F7DE2BBDCA8A8F1E", hash_generated_method = "19150581A2F47334F7DE2BBDCA8A8F1E")
        public EfCsimSpnLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.993 -0400", hash_original_method = "E361E237BF5D8C3526DBBFADBF2588AE", hash_generated_method = "876B6E7E3A3718066303A802DDDA2876")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_36091476 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_36091476 = "EF_CSIM_SPN";
            varB4EAC82CA7396A68D541C85D26508E83_36091476.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_36091476;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.994 -0400", hash_original_method = "57EF16BB2157E0EC6AC6B1903C815AC5", hash_generated_method = "2E471B1F026A10CB3B4A507368E9DEC7")
        public void onRecordLoaded(AsyncResult ar) {
            
            byte[] data = (byte[]) ar.result;
            log("CSIM_SPN=" +
                         IccUtils.bytesToHexString(data));
            mCsimSpnDisplayCondition = ((0x01 & data[0]) != 0);
            int encoding = data[1];
            int language = data[2];
            byte[] spnData = new byte[32];
            System.arraycopy(data, 3, spnData, 0, (data.length < 32) ? data.length : 32);
            int numBytes;
            {
                numBytes = 0;
            } 
            {
                spn = "";
            } 
            try 
            {
                
                spn = new String(spnData, 0, numBytes, "ISO-8859-1");
                
                
                spn = GsmAlphabet.gsm7BitPackedToString(spnData, 0, (numBytes*8)/7);
                
                
                spn =  new String(spnData, 0, numBytes, "utf-16");
                
                
                log("SPN encoding not supported");
                
            } 
            catch (Exception e)
            {
                log("spn decode error: " + e);
            } 
            log("spn=" + spn);
            log("spnCondition=" + mCsimSpnDisplayCondition);
            phone.setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, spn);
            addTaint(ar.getTaint());
            
            
        }

        
    }


    
    private class EfCsimMdnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.994 -0400", hash_original_method = "FA7FB660C97CE3D4BC72D3E68D236931", hash_generated_method = "FA7FB660C97CE3D4BC72D3E68D236931")
        public EfCsimMdnLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.996 -0400", hash_original_method = "6DF96F6BE7868B2EF5D1FBEB4BBED3CD", hash_generated_method = "2181D5F61D2209462EA96357FCB280AA")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1927159481 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1927159481 = "EF_CSIM_MDN";
            varB4EAC82CA7396A68D541C85D26508E83_1927159481.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1927159481;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.997 -0400", hash_original_method = "A47BCAD22D310B4F4C4F5C35578109CD", hash_generated_method = "7AA4FC9E9A84C7C8A51F7D7705D3A6D4")
        public void onRecordLoaded(AsyncResult ar) {
            
            byte[] data = (byte[]) ar.result;
            log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            int mdnDigitsNum = 0x0F & data[0];
            mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
            log("CSIM MDN=" + mMdn);
            addTaint(ar.getTaint());
            
            
            
            
            
            
        }

        
    }


    
    private class EfCsimImsimLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.997 -0400", hash_original_method = "E1B1DAC057539F9FD410F55956D30AAC", hash_generated_method = "E1B1DAC057539F9FD410F55956D30AAC")
        public EfCsimImsimLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.998 -0400", hash_original_method = "076F279972298500654A9EE948D0453D", hash_generated_method = "2C29DC795BEC1E620411627AD46C6D00")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_61083654 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_61083654 = "EF_CSIM_IMSIM";
            varB4EAC82CA7396A68D541C85D26508E83_61083654.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_61083654;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.998 -0400", hash_original_method = "17F309FAD2B89ABBF6BD1F73DBFF98C1", hash_generated_method = "88B800D06CA2AD892118A4CAE849AD45")
        public void onRecordLoaded(AsyncResult ar) {
            
            byte[] data = (byte[]) ar.result;
            log("CSIM_IMSIM=" + IccUtils.bytesToHexString(data));
            boolean provisioned = ((data[7] & 0x80) == 0x80);
            {
                int first3digits = ((0x03 & data[2]) << 8) + (0xFF & data[1]);
                int second3digits = (((0xFF & data[5]) << 8) | (0xFF & data[4])) >> 6;
                int digit7 = 0x0F & (data[4] >> 2);
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
                log("min present=" + mMin);
            } 
            {
                log("min not present");
            } 
            addTaint(ar.getTaint());
            
            
        }

        
    }


    
    private class EfCsimCdmaHomeLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.999 -0400", hash_original_method = "860B35F5393621E32B68838EF207B1C4", hash_generated_method = "860B35F5393621E32B68838EF207B1C4")
        public EfCsimCdmaHomeLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.999 -0400", hash_original_method = "72D2F700CD05B7B8BF5E2816D58B5E15", hash_generated_method = "95427FC313254F1EA6FD06E26C497534")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1044904967 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1044904967 = "EF_CSIM_CDMAHOME";
            varB4EAC82CA7396A68D541C85D26508E83_1044904967.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1044904967;
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.009 -0400", hash_original_method = "71E7D2ACFBE7DC249602D69114B85759", hash_generated_method = "ACF06BCD94C808F802246D01BC777630")
        public void onRecordLoaded(AsyncResult ar) {
            
            ArrayList<byte[]> dataList = (ArrayList<byte[]>) ar.result;
            log("CSIM_CDMAHOME data size=" + dataList.size());
            {
                boolean varF19482EB714ACA27D23BC9E396383613_1736460863 = (dataList.isEmpty());
            } 
            StringBuilder sidBuf = new StringBuilder();
            StringBuilder nidBuf = new StringBuilder();
            {
                Iterator<byte[]> varA79222549A4B1EDD1159325125C84E5C_1187744732 = (dataList).iterator();
                varA79222549A4B1EDD1159325125C84E5C_1187744732.hasNext();
                byte[] data = varA79222549A4B1EDD1159325125C84E5C_1187744732.next();
                {
                    {
                        int sid = ((data[1] & 0xFF) << 8) | (data[0] & 0xFF);
                        int nid = ((data[3] & 0xFF) << 8) | (data[2] & 0xFF);
                        sidBuf.append(sid).append(',');
                        nidBuf.append(nid).append(',');
                    } 
                } 
            } 
            sidBuf.setLength(sidBuf.length()-1);
            nidBuf.setLength(nidBuf.length()-1);
            mHomeSystemId = sidBuf.toString();
            mHomeNetworkId = nidBuf.toString();
            addTaint(ar.getTaint());
            
            
        }

        
    }


    
    private class EfCsimEprlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.009 -0400", hash_original_method = "352B4C8E045B195C6E9E4E04AF0DE6EE", hash_generated_method = "352B4C8E045B195C6E9E4E04AF0DE6EE")
        public EfCsimEprlLoaded ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.014 -0400", hash_original_method = "04C305ABDF4F5B734468C2FED0130506", hash_generated_method = "F8F88DB6113B3ECAC3A242EAF6AE357B")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_173968373 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_173968373 = "EF_CSIM_EPRL";
            varB4EAC82CA7396A68D541C85D26508E83_173968373.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_173968373;
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.018 -0400", hash_original_method = "B4E1B568EC9A83A605CFFEF5F57F8030", hash_generated_method = "DEED060B9909A9ED769BC4B5070AD46A")
        public void onRecordLoaded(AsyncResult ar) {
            
            onGetCSimEprlDone(ar);
            addTaint(ar.getTaint());
            
            
        }

        
    }


    
}

