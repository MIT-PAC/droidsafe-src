package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.SystemProperties;
import android.util.Log;
import com.android.internal.telephony.AdnRecord;
import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.AdnRecordLoader;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.cdma.RuimCard;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.IccException;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneProxy;

public final class RuimRecords extends IccRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.524 -0400", hash_original_field = "D57C967AFB88E398799D962D4CC36F18", hash_generated_field = "37183B293BAF9977D813A0D8B999B0F9")

    private boolean m_ota_commited = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.524 -0400", hash_original_field = "4F9847092C634F7B4329BF13174FA31C", hash_generated_field = "A49B5B8A3936B1A215B30A4E9A5841DC")

    private String mImsi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.524 -0400", hash_original_field = "BE7323C4B428116296019E60C4CCE82C", hash_generated_field = "07024A0AF2A22C972FCABAB2E680DB0C")

    private String mMyMobileNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.524 -0400", hash_original_field = "DB0B364B3D3C2A70B9F66E344B46BD4D", hash_generated_field = "30353D389E5CA4140AE5202689686C7C")

    private String mMin2Min1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.524 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.525 -0400", hash_original_method = "44C32614C87F88FAB25838E2BB007C1E", hash_generated_method = "F11316E16F85CCE1CFED3464EB37BA7A")
      RuimRecords(CDMAPhone p) {
        super(p);
        adnCache = new AdnRecordCache(phone);
        recordsRequested = false;
        recordsToLoad = 0;
        p.mCM.registerForRUIMReady(this, EVENT_RUIM_READY, null);
        p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mCM.registerForIccRefresh(this, EVENT_RUIM_REFRESH, null);
        onRadioOffOrNotAvailable();
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //adnCache = new AdnRecordCache(phone);
        //recordsRequested = false;
        //recordsToLoad = 0;
        //p.mCM.registerForRUIMReady(this, EVENT_RUIM_READY, null);
        //p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //p.mCM.registerForIccRefresh(this, EVENT_RUIM_REFRESH, null);
        //onRadioOffOrNotAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.525 -0400", hash_original_method = "BEB073340466462D0D2D43B235458798", hash_generated_method = "2C1624B406FCF7877DD944AD9568AFA1")
    @Override
    public void dispose() {
        phone.mCM.unregisterForRUIMReady(this);
        phone.mCM.unregisterForOffOrNotAvailable( this);
        phone.mCM.unregisterForIccRefresh(this);
        // ---------- Original Method ----------
        //phone.mCM.unregisterForRUIMReady(this);
        //phone.mCM.unregisterForOffOrNotAvailable( this);
        //phone.mCM.unregisterForIccRefresh(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.525 -0400", hash_original_method = "F3AC7B1645E4B6C17E75361C82F92F71", hash_generated_method = "DD9F6DBD571BB9253EF35B64F3A1C273")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "RuimRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "RuimRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.525 -0400", hash_original_method = "890888F3646E6C0F40397D6A9CAE2069", hash_generated_method = "C164568DFBFDA4D969CE0DF6F4836D64")
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        countVoiceMessages = 0;
        mncLength = UNINITIALIZED;
        iccid = null;
        adnCache.reset();
        recordsRequested = false;
        // ---------- Original Method ----------
        //countVoiceMessages = 0;
        //mncLength = UNINITIALIZED;
        //iccid = null;
        //adnCache.reset();
        //recordsRequested = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.526 -0400", hash_original_method = "08E37B8778E680438FC3D481E4B7618D", hash_generated_method = "7AEC383395C25CBBE167804CAA545475")
    public String getMdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_748281868 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_748281868 = mMyMobileNumber;
        varB4EAC82CA7396A68D541C85D26508E83_748281868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748281868;
        // ---------- Original Method ----------
        //return mMyMobileNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.526 -0400", hash_original_method = "70E8E8D1A91067A8AAF119FFCE233CA9", hash_generated_method = "981746C90956018F2B39CB6188CDCD07")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_634265786 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_634265786 = mMin2Min1;
        varB4EAC82CA7396A68D541C85D26508E83_634265786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_634265786;
        // ---------- Original Method ----------
        //return mMin2Min1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.526 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "185B24A2015126226B85C8A331F3602D")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_300818471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_300818471 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_300818471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300818471;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.527 -0400", hash_original_method = "42127C0CAB9B1B50FC97B071B6934168", hash_generated_method = "F2DAB10FD5D2E56D3B223F6260497803")
    @Override
    public void setVoiceMailNumber(String alphaTag, String voiceNumber, Message onComplete) {
        AsyncResult.forMessage((onComplete)).exception =
                new IccException("setVoiceMailNumber not implemented");
        onComplete.sendToTarget();
        addTaint(alphaTag.getTaint());
        addTaint(voiceNumber.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage((onComplete)).exception =
                //new IccException("setVoiceMailNumber not implemented");
        //onComplete.sendToTarget();
        //Log.e(LOG_TAG, "method setVoiceMailNumber is not implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.527 -0400", hash_original_method = "1D5D0C2F4FF0286B2839C7504C536EE3", hash_generated_method = "111986CE15D0A7E647C0FA2CE8052118")
    @Override
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            fetchRuimRecords();
        } //End block
        addTaint(fileChanged);
        addTaint(fileList[0]);
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchRuimRecords();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.528 -0400", hash_original_method = "1499AC64B3568BF128EFDB3C9845AC3C", hash_generated_method = "50092F2577AB783E1374540339D2A796")
    public String getRUIMOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_134426073 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1171580955 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_29367963 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_134426073 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1171580955 = mImsi.substring(0, 3 + mncLength);
        } //End block
        int mcc = Integer.parseInt(mImsi.substring(0,3));
        varB4EAC82CA7396A68D541C85D26508E83_29367963 = mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(mcc));
        String varA7E53CE21691AB073D9660D615818899_281696730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_281696730 = varB4EAC82CA7396A68D541C85D26508E83_134426073;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_281696730 = varB4EAC82CA7396A68D541C85D26508E83_1171580955;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_281696730 = varB4EAC82CA7396A68D541C85D26508E83_29367963;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_281696730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_281696730;
        // ---------- Original Method ----------
        //if (mImsi == null) {
            //return null;
        //}
        //if (mncLength != UNINITIALIZED && mncLength != UNKNOWN) {
            //return mImsi.substring(0, 3 + mncLength);
        //}
        //int mcc = Integer.parseInt(mImsi.substring(0,3));
        //return mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(mcc));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.530 -0400", hash_original_method = "584E0C361321C2DCD1B11D8CE97AF6DF", hash_generated_method = "DE1571B6E8887CE7E1BBDBEF57A13F2B")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        byte data[];
        boolean isRecordLoadResponse = false;
        try 
        {
            //Begin case EVENT_RUIM_READY 
            onRuimReady();
            //End case EVENT_RUIM_READY 
            //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            onRadioOffOrNotAvailable();
            //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
            //Begin case EVENT_GET_DEVICE_IDENTITY_DONE 
            Log.d(LOG_TAG, "Event EVENT_GET_DEVICE_IDENTITY_DONE Received");
            //End case EVENT_GET_DEVICE_IDENTITY_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            mImsi = (String) ar.result;
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                boolean varCB772677542135EE9593195A1C9BC7E6_214974733 = (mImsi != null && (mImsi.length() < 6 || mImsi.length() > 15));
                {
                    mImsi = null;
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            Log.d(LOG_TAG, "IMSI: " + mImsi.substring(0, 6) + "xxxxxxxxx");
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            String operatorNumeric = getRUIMOperatorNumeric();
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                {
                    boolean var5696560DB3AD9F8402BEAA0925BDF07A_1438808556 = (operatorNumeric.length() <= 6);
                    {
                        MccTable.updateMccMncConfiguration(phone, operatorNumeric);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            String localTemp[] = (String[])ar.result;
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            mMyMobileNumber = localTemp[0];
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            mMin2Min1 = localTemp[3];
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            mPrlVersion = localTemp[4];
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            Log.d(LOG_TAG, "MDN: " + mMyMobileNumber + " MIN: " + mMin2Min1);
            //End case EVENT_GET_CDMA_SUBSCRIPTION_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            isRecordLoadResponse = true;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            data = (byte[])ar.result;
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            iccid = IccUtils.bcdToString(data, 0, data.length);
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_GET_ICCID_DONE 
            Log.d(LOG_TAG, "iccid: " + iccid);
            //End case EVENT_GET_ICCID_DONE 
            //Begin case EVENT_UPDATE_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_GET_SST_DONE 
            Log.d(LOG_TAG, "Event EVENT_GET_SST_DONE Received");
            //End case EVENT_GET_SST_DONE 
            //Begin case EVENT_RUIM_REFRESH 
            isRecordLoadResponse = false;
            //End case EVENT_RUIM_REFRESH 
            //Begin case EVENT_RUIM_REFRESH 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_RUIM_REFRESH 
            //Begin case EVENT_RUIM_REFRESH 
            {
                handleRuimRefresh((int[])(ar.result));
            } //End block
            //End case EVENT_RUIM_REFRESH 
        } //End block
        catch (RuntimeException exc)
        { }
        finally 
        {
            {
                onRecordLoaded();
            } //End block
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.530 -0400", hash_original_method = "7082FCE9B35AC4F9F043D561172547FE", hash_generated_method = "4E29EFC8D882E521A736863E3AC3EB5F")
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
            //Log.e(LOG_TAG, "RuimRecords: recordsToLoad <0, programmer error suspected");
            //recordsToLoad = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.531 -0400", hash_original_method = "E50365918A8B4813331E3A24E11292EF", hash_generated_method = "6CFAD0B158363BF05556EF8B3989AC09")
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Log.d(LOG_TAG, "RuimRecords: record load complete");
        String operator = getRUIMOperatorNumeric();
        SystemProperties.set(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
        {
            SystemProperties.set(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    MccTable.countryCodeForMcc(Integer.parseInt(mImsi.substring(0,3))));
        } //End block
        recordsLoadedRegistrants.notifyRegistrants(
            new AsyncResult(null, null, null));
        phone.mIccCard.broadcastIccStateChangedIntent(
                RuimCard.INTENT_VALUE_ICC_LOADED, null);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "RuimRecords: record load complete");
        //String operator = getRUIMOperatorNumeric();
        //SystemProperties.set(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
        //if (mImsi != null) {
            //SystemProperties.set(PROPERTY_ICC_OPERATOR_ISO_COUNTRY,
                    //MccTable.countryCodeForMcc(Integer.parseInt(mImsi.substring(0,3))));
        //}
        //recordsLoadedRegistrants.notifyRegistrants(
            //new AsyncResult(null, null, null));
        //phone.mIccCard.broadcastIccStateChangedIntent(
                //RuimCard.INTENT_VALUE_ICC_LOADED, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.531 -0400", hash_original_method = "0D138DB0BC983C7D13FA7613202FEE21", hash_generated_method = "1FF78874CA0F2DC120C3E1185A7CA429")
    private void onRuimReady() {
        phone.mIccCard.broadcastIccStateChangedIntent(
                RuimCard.INTENT_VALUE_ICC_READY, null);
        fetchRuimRecords();
        phone.mCM.getCDMASubscription(obtainMessage(EVENT_GET_CDMA_SUBSCRIPTION_DONE));
        // ---------- Original Method ----------
        //phone.mIccCard.broadcastIccStateChangedIntent(
                //RuimCard.INTENT_VALUE_ICC_READY, null);
        //fetchRuimRecords();
        //phone.mCM.getCDMASubscription(obtainMessage(EVENT_GET_CDMA_SUBSCRIPTION_DONE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.531 -0400", hash_original_method = "618248758DCBCE1B082F10F6590C51C4", hash_generated_method = "BA8CEC0A1EB21779223B7C9E71BED7B6")
    private void fetchRuimRecords() {
        recordsRequested = true;
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        phone.getIccFileHandler().loadEFTransparent(EF_ICCID,
                obtainMessage(EVENT_GET_ICCID_DONE));
        // ---------- Original Method ----------
        //recordsRequested = true;
        //Log.v(LOG_TAG, "RuimRecords:fetchRuimRecords " + recordsToLoad);
        //phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        //recordsToLoad++;
        //phone.getIccFileHandler().loadEFTransparent(EF_ICCID,
                //obtainMessage(EVENT_GET_ICCID_DONE));
        //recordsToLoad++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.532 -0400", hash_original_method = "409F5B7F98F19D492107B7A38CA851EE", hash_generated_method = "C7D8577BF882BC30D794D248FE671DB5")
    @Override
    public int getDisplayRule(String plmn) {
        addTaint(plmn.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509940693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509940693;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.532 -0400", hash_original_method = "A6740B433D4FB4F3079B795061BDE226", hash_generated_method = "2B4D284BB171EE804A370D6C46918F7E")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        {
            countWaiting = -1;
        } //End block
        {
            countWaiting = 0xff;
        } //End block
        countVoiceMessages = countWaiting;
        ((CDMAPhone) phone).notifyMessageWaitingIndicator();
        addTaint(line);
        addTaint(countWaiting);
        // ---------- Original Method ----------
        //if (line != 1) {
            //return;
        //}
        //if (countWaiting < 0) {
            //countWaiting = -1;
        //} else if (countWaiting > 0xff) {
            //countWaiting = 0xff;
        //}
        //countVoiceMessages = countWaiting;
        //((CDMAPhone) phone).notifyMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.532 -0400", hash_original_method = "BF9176F3CF68AA171F4E13CD5AF3ED9E", hash_generated_method = "244DB579EB291E05C69F634DCEC22D97")
    private void handleRuimRefresh(int[] result) {
        {
            log("handleRuimRefresh without input");
        } //End block
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        log("handleRuimRefresh with SIM_REFRESH_FILE_UPDATED");
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        adnCache.reset();
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        fetchRuimRecords();
        //End case CommandsInterface.SIM_REFRESH_FILE_UPDATED 
        //Begin case CommandsInterface.SIM_REFRESH_INIT 
        log("handleRuimRefresh with SIM_REFRESH_INIT");
        //End case CommandsInterface.SIM_REFRESH_INIT 
        //Begin case CommandsInterface.SIM_REFRESH_INIT 
        fetchRuimRecords();
        //End case CommandsInterface.SIM_REFRESH_INIT 
        //Begin case CommandsInterface.SIM_REFRESH_RESET 
        log("handleRuimRefresh with SIM_REFRESH_RESET");
        //End case CommandsInterface.SIM_REFRESH_RESET 
        //Begin case CommandsInterface.SIM_REFRESH_RESET 
        phone.mCM.setRadioPower(false, null);
        //End case CommandsInterface.SIM_REFRESH_RESET 
        //Begin case default 
        log("handleRuimRefresh with unknown operation");
        //End case default 
        addTaint(result[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_method = "15EF52C4433D17716212414EB6E50E76", hash_generated_method = "CC023C7256A7FDCE68395BBE9743FE4C")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[RuimRecords] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_method = "650BB8E79BCC4D913E519971F11AFA1E", hash_generated_method = "E7D94BCA5445789397AC7E67B09B77DB")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "1DEBF446A40353CC61F12433EDA4A667", hash_generated_field = "70C0002A03DDB0315C52D7F0E8B395A2")

    private static final int EVENT_RUIM_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "B41D6834011DAA4DB1A6AC940ADFA38E", hash_generated_field = "C65DF4AD1462685EBC499AE583280BAA")

    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "1C7B2408ABBFF84C0AE773B343AAE081", hash_generated_field = "29F539FB0647EE31D849E06DE444129C")

    private static final int EVENT_GET_IMSI_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "1EDF89A33C559C7081F2F14D9D9F0BD5", hash_generated_field = "A26946778DAA98F81D609908E4D9E727")

    private static final int EVENT_GET_DEVICE_IDENTITY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "F04ED69F1D1D36AD737B9E6BF7733C67", hash_generated_field = "1DF607ACA15F09CB3B4DC1DFD512B2E3")

    private static final int EVENT_GET_ICCID_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "3C3AA88B43A133797BBE286990868EB6", hash_generated_field = "F65C212D57735E486171DDE0436EF906")

    private static final int EVENT_GET_CDMA_SUBSCRIPTION_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "529053860FA14F8B31FBDEC20F5F5B03", hash_generated_field = "7C08F6997CDB1F95B53292AC6E4DA474")

    private static final int EVENT_UPDATE_DONE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "1E3C0E257296800F8D76872CD2E55387", hash_generated_field = "94AFAFC942E8F21799585FB7E7B86992")

    private static final int EVENT_GET_SST_DONE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "3B79516072415E285E9DD48ECF8C32E3", hash_generated_field = "9F464D691ED618E65FF918987EFF9274")

    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "5EB21554FBD2F493FD526FF035BA3944", hash_generated_field = "961A7A4D60E11CE78834F70BC49A219A")

    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "752339407D2812D75F5811F2D829619F", hash_generated_field = "ED99436836464B30EF1636FCBA09D78C")

    private static final int EVENT_SMS_ON_RUIM = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "17E27DF4CEFFF43554FD32CB85BD7662", hash_generated_field = "18FB3B701347968BBB3DB68B7D9FA9E0")

    private static final int EVENT_GET_SMS_DONE = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.533 -0400", hash_original_field = "27D03FBCCCD2C74099B3C666524D8E79", hash_generated_field = "AA66F54A711788ECF4FB24747995AEB7")

    private static final int EVENT_RUIM_REFRESH = 31;
}

