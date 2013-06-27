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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.742 -0400", hash_original_field = "D57C967AFB88E398799D962D4CC36F18", hash_generated_field = "37183B293BAF9977D813A0D8B999B0F9")

    private boolean m_ota_commited = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.742 -0400", hash_original_field = "4F9847092C634F7B4329BF13174FA31C", hash_generated_field = "A49B5B8A3936B1A215B30A4E9A5841DC")

    private String mImsi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.742 -0400", hash_original_field = "BE7323C4B428116296019E60C4CCE82C", hash_generated_field = "07024A0AF2A22C972FCABAB2E680DB0C")

    private String mMyMobileNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.742 -0400", hash_original_field = "DB0B364B3D3C2A70B9F66E344B46BD4D", hash_generated_field = "30353D389E5CA4140AE5202689686C7C")

    private String mMin2Min1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.743 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.743 -0400", hash_original_method = "44C32614C87F88FAB25838E2BB007C1E", hash_generated_method = "F11316E16F85CCE1CFED3464EB37BA7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.743 -0400", hash_original_method = "BEB073340466462D0D2D43B235458798", hash_generated_method = "2C1624B406FCF7877DD944AD9568AFA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.744 -0400", hash_original_method = "F3AC7B1645E4B6C17E75361C82F92F71", hash_generated_method = "DD9F6DBD571BB9253EF35B64F3A1C273")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "RuimRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "RuimRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.744 -0400", hash_original_method = "890888F3646E6C0F40397D6A9CAE2069", hash_generated_method = "C164568DFBFDA4D969CE0DF6F4836D64")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.762 -0400", hash_original_method = "08E37B8778E680438FC3D481E4B7618D", hash_generated_method = "78985B5CC24D7E00176A9F36974A3EB4")
    public String getMdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_523898691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_523898691 = mMyMobileNumber;
        varB4EAC82CA7396A68D541C85D26508E83_523898691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_523898691;
        // ---------- Original Method ----------
        //return mMyMobileNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.763 -0400", hash_original_method = "70E8E8D1A91067A8AAF119FFCE233CA9", hash_generated_method = "EA6B71DB034C2838EB742502CB9DDB0D")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_1056174410 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1056174410 = mMin2Min1;
        varB4EAC82CA7396A68D541C85D26508E83_1056174410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1056174410;
        // ---------- Original Method ----------
        //return mMin2Min1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.764 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "4EC5F993651DBBF8C8EFB058EC70797A")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1016616288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1016616288 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1016616288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1016616288;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.764 -0400", hash_original_method = "42127C0CAB9B1B50FC97B071B6934168", hash_generated_method = "F2DAB10FD5D2E56D3B223F6260497803")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.764 -0400", hash_original_method = "1D5D0C2F4FF0286B2839C7504C536EE3", hash_generated_method = "111986CE15D0A7E647C0FA2CE8052118")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.768 -0400", hash_original_method = "1499AC64B3568BF128EFDB3C9845AC3C", hash_generated_method = "12AD7F4E86CEE5DE627AD0AB0D36900A")
    public String getRUIMOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_713513594 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_307703992 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_939482421 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_713513594 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_307703992 = mImsi.substring(0, 3 + mncLength);
        } //End block
        int mcc;
        mcc = Integer.parseInt(mImsi.substring(0,3));
        varB4EAC82CA7396A68D541C85D26508E83_939482421 = mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(mcc));
        String varA7E53CE21691AB073D9660D615818899_1179738625; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1179738625 = varB4EAC82CA7396A68D541C85D26508E83_713513594;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1179738625 = varB4EAC82CA7396A68D541C85D26508E83_307703992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1179738625 = varB4EAC82CA7396A68D541C85D26508E83_939482421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1179738625.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1179738625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.773 -0400", hash_original_method = "584E0C361321C2DCD1B11D8CE97AF6DF", hash_generated_method = "EC2A587A1D11541AE65298B127B2D6B6")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        byte data[];
        boolean isRecordLoadResponse;
        isRecordLoadResponse = false;
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
                boolean varCB772677542135EE9593195A1C9BC7E6_288600788 = (mImsi != null && (mImsi.length() < 6 || mImsi.length() > 15));
                {
                    mImsi = null;
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            Log.d(LOG_TAG, "IMSI: " + mImsi.substring(0, 6) + "xxxxxxxxx");
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            String operatorNumeric;
            operatorNumeric = getRUIMOperatorNumeric();
            //End case EVENT_GET_IMSI_DONE 
            //Begin case EVENT_GET_IMSI_DONE 
            {
                {
                    boolean var5696560DB3AD9F8402BEAA0925BDF07A_1638077432 = (operatorNumeric.length() <= 6);
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
            String localTemp[];
            localTemp = (String[])ar.result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.774 -0400", hash_original_method = "7082FCE9B35AC4F9F043D561172547FE", hash_generated_method = "4E29EFC8D882E521A736863E3AC3EB5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.794 -0400", hash_original_method = "E50365918A8B4813331E3A24E11292EF", hash_generated_method = "F3E92C3FC9EE532A69A45A5B7C86909A")
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Log.d(LOG_TAG, "RuimRecords: record load complete");
        String operator;
        operator = getRUIMOperatorNumeric();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.795 -0400", hash_original_method = "0D138DB0BC983C7D13FA7613202FEE21", hash_generated_method = "1FF78874CA0F2DC120C3E1185A7CA429")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.804 -0400", hash_original_method = "618248758DCBCE1B082F10F6590C51C4", hash_generated_method = "BA8CEC0A1EB21779223B7C9E71BED7B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.804 -0400", hash_original_method = "409F5B7F98F19D492107B7A38CA851EE", hash_generated_method = "93F50378B53754E92FE9E2B29911101B")
    @Override
    public int getDisplayRule(String plmn) {
        addTaint(plmn.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749107892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749107892;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.805 -0400", hash_original_method = "A6740B433D4FB4F3079B795061BDE226", hash_generated_method = "2B4D284BB171EE804A370D6C46918F7E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.806 -0400", hash_original_method = "BF9176F3CF68AA171F4E13CD5AF3ED9E", hash_generated_method = "244DB579EB291E05C69F634DCEC22D97")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_method = "15EF52C4433D17716212414EB6E50E76", hash_generated_method = "CC023C7256A7FDCE68395BBE9743FE4C")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[RuimRecords] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_method = "650BB8E79BCC4D913E519971F11AFA1E", hash_generated_method = "E7D94BCA5445789397AC7E67B09B77DB")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "1DEBF446A40353CC61F12433EDA4A667", hash_generated_field = "6915BC2C1A89D6E7A441D3DBA7D7788A")

    private static int EVENT_RUIM_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "B41D6834011DAA4DB1A6AC940ADFA38E", hash_generated_field = "7BCF1FFF9022E22F04BC0FDC1FAA6FD5")

    private static int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "1C7B2408ABBFF84C0AE773B343AAE081", hash_generated_field = "AE868B57B0686F8FBB77E884F3131357")

    private static int EVENT_GET_IMSI_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "1EDF89A33C559C7081F2F14D9D9F0BD5", hash_generated_field = "5F551C5C9A634CA5D81D164FC94CD0F7")

    private static int EVENT_GET_DEVICE_IDENTITY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "F04ED69F1D1D36AD737B9E6BF7733C67", hash_generated_field = "4287E57BC7188F5B29EA8284D50EB309")

    private static int EVENT_GET_ICCID_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "3C3AA88B43A133797BBE286990868EB6", hash_generated_field = "4E33B3F55ABC3C132F844C995AE9A69D")

    private static int EVENT_GET_CDMA_SUBSCRIPTION_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "529053860FA14F8B31FBDEC20F5F5B03", hash_generated_field = "B0B78B92D79876F59FE3B5A8E316C0E4")

    private static int EVENT_UPDATE_DONE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.817 -0400", hash_original_field = "1E3C0E257296800F8D76872CD2E55387", hash_generated_field = "223E83F9999315E9590F93EEDFA7D934")

    private static int EVENT_GET_SST_DONE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.818 -0400", hash_original_field = "3B79516072415E285E9DD48ECF8C32E3", hash_generated_field = "1E34B501E28E4512D34E6566C6DC5F9E")

    private static int EVENT_GET_ALL_SMS_DONE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.818 -0400", hash_original_field = "5EB21554FBD2F493FD526FF035BA3944", hash_generated_field = "19C1026B8F804F62066BB3602553F56D")

    private static int EVENT_MARK_SMS_READ_DONE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.818 -0400", hash_original_field = "752339407D2812D75F5811F2D829619F", hash_generated_field = "0C69E7653A644B9EA39B0CCD8B2B175A")

    private static int EVENT_SMS_ON_RUIM = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.818 -0400", hash_original_field = "17E27DF4CEFFF43554FD32CB85BD7662", hash_generated_field = "2E17A31BF2AA6CC5E5F0D8A7BA22651E")

    private static int EVENT_GET_SMS_DONE = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.818 -0400", hash_original_field = "27D03FBCCCD2C74099B3C666524D8E79", hash_generated_field = "1A10E297D3EB690CEBE0D5037F4E87A5")

    private static int EVENT_RUIM_REFRESH = 31;
}

