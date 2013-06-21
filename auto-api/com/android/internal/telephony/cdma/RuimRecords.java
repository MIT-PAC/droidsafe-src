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
    private boolean  m_ota_commited=false;
    private String mImsi;
    private String mMyMobileNumber;
    private String mMin2Min1;
    private String mPrlVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.827 -0400", hash_original_method = "44C32614C87F88FAB25838E2BB007C1E", hash_generated_method = "47881B93D3114C7479EC732C9EE4565E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuimRecords(CDMAPhone p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
        adnCache = new AdnRecordCache(phone);
        recordsRequested = false;
        recordsToLoad = 0;
        p.mCM.registerForRUIMReady(this, EVENT_RUIM_READY, null);
        p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mCM.registerForIccRefresh(this, EVENT_RUIM_REFRESH, null);
        onRadioOffOrNotAvailable();
        // ---------- Original Method ----------
        //adnCache = new AdnRecordCache(phone);
        //recordsRequested = false;
        //recordsToLoad = 0;
        //p.mCM.registerForRUIMReady(this, EVENT_RUIM_READY, null);
        //p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //p.mCM.registerForIccRefresh(this, EVENT_RUIM_REFRESH, null);
        //onRadioOffOrNotAvailable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.827 -0400", hash_original_method = "BEB073340466462D0D2D43B235458798", hash_generated_method = "2C1624B406FCF7877DD944AD9568AFA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "F3AC7B1645E4B6C17E75361C82F92F71", hash_generated_method = "DD9F6DBD571BB9253EF35B64F3A1C273")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "RuimRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "RuimRecords finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "890888F3646E6C0F40397D6A9CAE2069", hash_generated_method = "C164568DFBFDA4D969CE0DF6F4836D64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "08E37B8778E680438FC3D481E4B7618D", hash_generated_method = "31DBC49B73947946D4CEA526219AE9E5")
    @DSModeled(DSC.SAFE)
    public String getMdnNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMyMobileNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "70E8E8D1A91067A8AAF119FFCE233CA9", hash_generated_method = "60E3B92D4DDBFCD090D51C0CF161F1B7")
    @DSModeled(DSC.SAFE)
    public String getCdmaMin() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMin2Min1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "85BC9F48A4C2AD64441235A9DB32E994")
    @DSModeled(DSC.SAFE)
    public String getPrlVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.828 -0400", hash_original_method = "42127C0CAB9B1B50FC97B071B6934168", hash_generated_method = "34A4B8F75C7A3BCC3B213A5F23FC6D4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVoiceMailNumber(String alphaTag, String voiceNumber, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(voiceNumber);
        AsyncResult.forMessage((onComplete)).exception =
                new IccException("setVoiceMailNumber not implemented");
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage((onComplete)).exception =
                //new IccException("setVoiceMailNumber not implemented");
        //onComplete.sendToTarget();
        //Log.e(LOG_TAG, "method setVoiceMailNumber is not implemented");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.829 -0400", hash_original_method = "1D5D0C2F4FF0286B2839C7504C536EE3", hash_generated_method = "1D0A5F0884B28FBBB41A6D75844456FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(fileList[0]);
        dsTaint.addTaint(fileChanged);
        {
            fetchRuimRecords();
        } //End block
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchRuimRecords();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.829 -0400", hash_original_method = "1499AC64B3568BF128EFDB3C9845AC3C", hash_generated_method = "BA293C4049CF6F7505683638847819B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRUIMOperatorNumeric() {
        {
            String var257DE1DB0291D742CAA69D78DF3E5122_2040682762 = (mImsi.substring(0, 3 + mncLength));
        } //End block
        int mcc;
        mcc = Integer.parseInt(mImsi.substring(0,3));
        String varF0568BF38E46D24BCE4D6B37DCC9823D_1099251125 = (mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(mcc)));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.830 -0400", hash_original_method = "584E0C361321C2DCD1B11D8CE97AF6DF", hash_generated_method = "6073BDEF14CFEE7C76B8F2B7D774FA0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
                boolean varCB772677542135EE9593195A1C9BC7E6_1431067050 = (mImsi != null && (mImsi.length() < 6 || mImsi.length() > 15));
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
                    boolean var5696560DB3AD9F8402BEAA0925BDF07A_405206095 = (operatorNumeric.length() <= 6);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.830 -0400", hash_original_method = "7082FCE9B35AC4F9F043D561172547FE", hash_generated_method = "4E29EFC8D882E521A736863E3AC3EB5F")
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
            //Log.e(LOG_TAG, "RuimRecords: recordsToLoad <0, programmer error suspected");
            //recordsToLoad = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.830 -0400", hash_original_method = "E50365918A8B4813331E3A24E11292EF", hash_generated_method = "F3E92C3FC9EE532A69A45A5B7C86909A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.831 -0400", hash_original_method = "0D138DB0BC983C7D13FA7613202FEE21", hash_generated_method = "1FF78874CA0F2DC120C3E1185A7CA429")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.831 -0400", hash_original_method = "618248758DCBCE1B082F10F6590C51C4", hash_generated_method = "BA8CEC0A1EB21779223B7C9E71BED7B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.831 -0400", hash_original_method = "409F5B7F98F19D492107B7A38CA851EE", hash_generated_method = "215DA4210C8EED2BC0EE339D0C6B1B73")
    @DSModeled(DSC.SAFE)
    @Override
    public int getDisplayRule(String plmn) {
        dsTaint.addTaint(plmn);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.831 -0400", hash_original_method = "A6740B433D4FB4F3079B795061BDE226", hash_generated_method = "B8C79B4A938C6AEE0288D9AEA1C45C4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(countWaiting);
        dsTaint.addTaint(line);
        {
            countWaiting = -1;
        } //End block
        {
            countWaiting = 0xff;
        } //End block
        countVoiceMessages = countWaiting;
        ((CDMAPhone) phone).notifyMessageWaitingIndicator();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.832 -0400", hash_original_method = "BF9176F3CF68AA171F4E13CD5AF3ED9E", hash_generated_method = "6F2CFDDCFBAE106A5329CE505C4F7944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRuimRefresh(int[] result) {
        dsTaint.addTaint(result[0]);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.832 -0400", hash_original_method = "15EF52C4433D17716212414EB6E50E76", hash_generated_method = "21B95C8B173FCFDDA072D7C1AFBFE9AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[RuimRecords] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.832 -0400", hash_original_method = "650BB8E79BCC4D913E519971F11AFA1E", hash_generated_method = "72B7FE917432E019E233B7B7080F1276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimRecords] " + s);
    }

    
    static final String LOG_TAG = "CDMA";
    private static final boolean DBG = true;
    private static final int EVENT_RUIM_READY = 1;
    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    private static final int EVENT_GET_IMSI_DONE = 3;
    private static final int EVENT_GET_DEVICE_IDENTITY_DONE = 4;
    private static final int EVENT_GET_ICCID_DONE = 5;
    private static final int EVENT_GET_CDMA_SUBSCRIPTION_DONE = 10;
    private static final int EVENT_UPDATE_DONE = 14;
    private static final int EVENT_GET_SST_DONE = 17;
    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    private static final int EVENT_SMS_ON_RUIM = 21;
    private static final int EVENT_GET_SMS_DONE = 22;
    private static final int EVENT_RUIM_REFRESH = 31;
}

