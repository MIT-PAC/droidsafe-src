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
    private byte[] mEFpl = null;
    private byte[] mEFli = null;
    boolean mCsimSpnDisplayCondition = false;
    private String mMdn;
    private String mMin;
    private String mPrlVersion;
    private String mHomeSystemId;
    private String mHomeNetworkId;
    private IsimUiccRecords mIsimUiccRecords = new IsimUiccRecords();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.593 -0400", hash_original_method = "1EEE248672EF4A8C6E78EC57BC4B596E", hash_generated_method = "C53888FFA25A4E6157662567E2352B88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaLteUiccRecords(PhoneBase p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.593 -0400", hash_original_method = "2DE8400081AD5D0DFDE4A5A335B40E41", hash_generated_method = "CA6811C3E8E53F79CAB56366EF38ECC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.593 -0400", hash_original_method = "E8EE1C045698968684402EFF7D154AD0", hash_generated_method = "EF8A1A3F87EF17E62252C665538BB192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setLocaleFromCsim();
        super.onAllRecordsLoaded();
        // ---------- Original Method ----------
        //setLocaleFromCsim();
        //super.onAllRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.593 -0400", hash_original_method = "5BA121C6EACB6C26C7E5BA17D0EA0EBE", hash_generated_method = "EE8366A3C2B215ABBF71F4B8EA45F5B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.594 -0400", hash_original_method = "097B9B51B341025D2C6281D6E7202450", hash_generated_method = "24689998D000BD009BC20E65A0A9D41D")
    @DSModeled(DSC.SAFE)
    private int adjstMinDigits(int digits) {
        dsTaint.addTaint(digits);
        digits += 111;
        digits = (digits % 10 == 0)?(digits - 10):digits;
        digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //digits += 111;
        //digits = (digits % 10 == 0)?(digits - 10):digits;
        //digits = ((digits / 10) % 10 == 0)?(digits - 100):digits;
        //digits = ((digits / 100) % 10 == 0)?(digits - 1000):digits;
        //return digits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.594 -0400", hash_original_method = "8ACEB43E18F76CD22FB9AEC49B26074B", hash_generated_method = "9A64C0A9A71EDA8CF3CE5BE36D0DFF9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onGetCSimEprlDone(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        byte[] data;
        data = (byte[]) ar.result;
        log("CSIM_EPRL=" + IccUtils.bytesToHexString(data));
        {
            int prlId;
            prlId = ((data[2] & 0xFF) << 8) | (data[3] & 0xFF);
            mPrlVersion = Integer.toString(prlId);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.595 -0400", hash_original_method = "6650B0E8C5FD9109D896567DAC7169B6", hash_generated_method = "F09CE8FC8926B656C108C358A1F5667A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.595 -0400", hash_original_method = "389005660E8D32B57FD0D16BC435823F", hash_generated_method = "BDFBC9BBAEA2D407A6AA2329C9BA7DEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String findBestLanguage(byte[] languages) {
        dsTaint.addTaint(languages[0]);
        String bestMatch;
        bestMatch = null;
        String[] locales;
        locales = phone.getContext().getAssets().getLocales();
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
                                boolean var69DCEA382207578FA668797854F726E5_789893090 = (locales[j] != null && locales[j].length() >= 2 &&
                        locales[j].substring(0, 2).equals(lang));
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.595 -0400", hash_original_method = "8715F9DE01323914473DFA590E77B6CC", hash_generated_method = "11D4BD959B8CA715482564FC7E6544F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CSIM] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CSIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.595 -0400", hash_original_method = "2E582D58F93B3D53A9755A5359649796", hash_generated_method = "787E67B0F26FCA0C5F4CBD327B3080D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CSIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.595 -0400", hash_original_method = "0A56566EECB0365BEB6D3F46827C5157", hash_generated_method = "4CCFC9D1E40E4B23CB468B547090B628")
    @DSModeled(DSC.SAFE)
    public String getMdn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "80A82BB385CD03C9B3FC60961865E100", hash_generated_method = "3118F011D4A3D379B2287DD6100E39C6")
    @DSModeled(DSC.SAFE)
    public String getMin() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "063CD09EDCF873A8EE48D2C85BBEA4D0", hash_generated_method = "FCEC9D00006E61287D031D5C145A1671")
    @DSModeled(DSC.SAFE)
    public String getSid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHomeSystemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "884F79DB94780A6DBB795ED0D5CD48AE", hash_generated_method = "5314E8FCAC2BA706F8790B1F2D20F83E")
    @DSModeled(DSC.SAFE)
    public String getNid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHomeNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "85BC9F48A4C2AD64441235A9DB32E994")
    @DSModeled(DSC.SAFE)
    public String getPrlVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "C58B4A883B983444DBA9A30FEBE0DD9B", hash_generated_method = "BB6D181AF605609C7BC452D8A51BCB24")
    @DSModeled(DSC.SAFE)
    public boolean getCsimSpnDisplayCondition() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCsimSpnDisplayCondition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "C3918CF1E72E747DA54324AC57BD2CA6", hash_generated_method = "53ACC6140CC97A0E626C5640E7B0CAA8")
    @DSModeled(DSC.SAFE)
    @Override
    public IsimRecords getIsimRecords() {
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIsimUiccRecords;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.596 -0400", hash_original_method = "80E64791B17F9A8D9A19FB8366ED7D81", hash_generated_method = "A8D9974D33D7C86D14FF0ACD238F79AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isProvisioned() {
        {
            boolean var0DF60DD5FEFC41C1EAAF86A01E334B0D_632603485 = (SystemProperties.getBoolean(PROPERTY_TEST_CSIM, false));
        } //End collapsed parenthetic
        {
            boolean varCD4B507D60337FD84160863D2C35D3EA_2059313538 = (phone.mIccCard.isApplicationOnIcc(AppType.APPTYPE_CSIM) &&
            ((mMdn == null) || (mMin == null)));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "B5878332DE43EFB46C0A76BAF3DD0FEF", hash_generated_method = "1FCC5416E1B756500AFCB34A513B97A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int dispatchGsmMessage(SmsMessageBase message) {
        dsTaint.addTaint(message.dsTaint);
        int var03061910AF29178D75093273D4AADF1D_671871892 = (((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((CDMALTEPhone) phone).m3gppSMS.dispatchMessage(message);
    }

    
    private class EfPlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "83970BAE03E02823AF48318A87816800", hash_generated_method = "83970BAE03E02823AF48318A87816800")
                public EfPlLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "46D131BE59CA4E55BA893DF6F7101791", hash_generated_method = "B7AB4E51B76D36C61F065F04AC2B4440")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_PL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "10BD1E11D2518DCC1D89C745EA9F4059", hash_generated_method = "339D26026FD1140D3A157E3DFB32B05F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            mEFpl = (byte[]) ar.result;
            log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
            // ---------- Original Method ----------
            //mEFpl = (byte[]) ar.result;
            //if (DBG) log("EF_PL=" + IccUtils.bytesToHexString(mEFpl));
        }

        
    }


    
    private class EfCsimLiLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "5F9ABC2DDBA413EFD6CA606D0665F3A0", hash_generated_method = "5F9ABC2DDBA413EFD6CA606D0665F3A0")
                public EfCsimLiLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.597 -0400", hash_original_method = "43CB272303B94BD2BDA1313C04660298", hash_generated_method = "4A22D6A5AF70158AE2CF4BA0EE0DF0B0")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_LI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.598 -0400", hash_original_method = "450EAA4EF2F439560DA5559C99B4124D", hash_generated_method = "67BFF6DD4F7ACA2E140CC5EBA7530ED3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.598 -0400", hash_original_method = "228425DAED8BC0DFD955609292E6526F", hash_generated_method = "228425DAED8BC0DFD955609292E6526F")
                public EfCsimSpnLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.598 -0400", hash_original_method = "E361E237BF5D8C3526DBBFADBF2588AE", hash_generated_method = "F8E0EAB93D4CD9CC83BA903C6E0CE2D9")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_SPN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.598 -0400", hash_original_method = "57EF16BB2157E0EC6AC6B1903C815AC5", hash_generated_method = "B1B794C1D0CFEBB751E0746001A18819")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimMdnLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.599 -0400", hash_original_method = "64A9F10540C225FA5E7332D1F656A567", hash_generated_method = "64A9F10540C225FA5E7332D1F656A567")
                public EfCsimMdnLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.599 -0400", hash_original_method = "6DF96F6BE7868B2EF5D1FBEB4BBED3CD", hash_generated_method = "5BC96F6E7C0DA34E000226EF8C09397B")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_MDN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.599 -0400", hash_original_method = "A47BCAD22D310B4F4C4F5C35578109CD", hash_generated_method = "B2543CEAF68D19CB2557F00E41CEA2DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            byte[] data;
            data = (byte[]) ar.result;
            log("CSIM_MDN=" + IccUtils.bytesToHexString(data));
            int mdnDigitsNum;
            mdnDigitsNum = 0x0F & data[0];
            mMdn = IccUtils.cdmaBcdToString(data, 1, mdnDigitsNum);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.599 -0400", hash_original_method = "0A4D5837B3945124552BF6BB16192F04", hash_generated_method = "0A4D5837B3945124552BF6BB16192F04")
                public EfCsimImsimLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.599 -0400", hash_original_method = "076F279972298500654A9EE948D0453D", hash_generated_method = "54FB456A2443C34EB3FD94DE0E6D69C6")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_IMSIM";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.600 -0400", hash_original_method = "17F309FAD2B89ABBF6BD1F73DBFF98C1", hash_generated_method = "97CD69A4B75D5991AF61DB85EDE20C7D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimCdmaHomeLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.600 -0400", hash_original_method = "A67CD14BFBA5B5D58ECAEB5E059EAB8B", hash_generated_method = "A67CD14BFBA5B5D58ECAEB5E059EAB8B")
                public EfCsimCdmaHomeLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.600 -0400", hash_original_method = "72D2F700CD05B7B8BF5E2816D58B5E15", hash_generated_method = "6194B231B06B6C99B385031B15B5EF5B")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_CDMAHOME";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.606 -0400", hash_original_method = "71E7D2ACFBE7DC249602D69114B85759", hash_generated_method = "092534A847F425036839788904B1B25E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            ArrayList<byte[]> dataList;
            dataList = (ArrayList<byte[]>) ar.result;
            log("CSIM_CDMAHOME data size=" + dataList.size());
            {
                boolean varF19482EB714ACA27D23BC9E396383613_1852006140 = (dataList.isEmpty());
            } //End collapsed parenthetic
            StringBuilder sidBuf;
            sidBuf = new StringBuilder();
            StringBuilder nidBuf;
            nidBuf = new StringBuilder();
            {
                Iterator<byte[]> varA79222549A4B1EDD1159325125C84E5C_2098277756 = (dataList).iterator();
                varA79222549A4B1EDD1159325125C84E5C_2098277756.hasNext();
                byte[] data = varA79222549A4B1EDD1159325125C84E5C_2098277756.next();
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class EfCsimEprlLoaded implements IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.609 -0400", hash_original_method = "26A81031A7AC08B39CFFB73AC20254AD", hash_generated_method = "26A81031A7AC08B39CFFB73AC20254AD")
                public EfCsimEprlLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.609 -0400", hash_original_method = "04C305ABDF4F5B734468C2FED0130506", hash_generated_method = "BD84EF999B5766E8EBCA506243A302AD")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_CSIM_EPRL";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.610 -0400", hash_original_method = "B4E1B568EC9A83A605CFFEF5F57F8030", hash_generated_method = "036639585B5AEBA93F95FD7A958AD3FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            onGetCSimEprlDone(ar);
            // ---------- Original Method ----------
            //onGetCSimEprlDone(ar);
        }

        
    }


    
}

