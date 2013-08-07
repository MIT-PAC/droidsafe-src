package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.annotations.*;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Log;

import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccException;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.MccTable;






public final class RuimRecords extends IccRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.340 -0400", hash_original_field = "D57C967AFB88E398799D962D4CC36F18", hash_generated_field = "37183B293BAF9977D813A0D8B999B0F9")

    private boolean m_ota_commited = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.340 -0400", hash_original_field = "4F9847092C634F7B4329BF13174FA31C", hash_generated_field = "A49B5B8A3936B1A215B30A4E9A5841DC")

    private String mImsi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.340 -0400", hash_original_field = "BE7323C4B428116296019E60C4CCE82C", hash_generated_field = "07024A0AF2A22C972FCABAB2E680DB0C")

    private String mMyMobileNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.340 -0400", hash_original_field = "DB0B364B3D3C2A70B9F66E344B46BD4D", hash_generated_field = "30353D389E5CA4140AE5202689686C7C")

    private String mMin2Min1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.340 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "B5278138A8F074DD973D122E731F6E34")

    private String mPrlVersion;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.341 -0400", hash_original_method = "44C32614C87F88FAB25838E2BB007C1E", hash_generated_method = "282B775ED5840C4C14DF47054E02291D")
      RuimRecords(CDMAPhone p) {
        super(p);
        addTaint(p.getTaint());
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.341 -0400", hash_original_method = "BEB073340466462D0D2D43B235458798", hash_generated_method = "2C1624B406FCF7877DD944AD9568AFA1")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.342 -0400", hash_original_method = "F3AC7B1645E4B6C17E75361C82F92F71", hash_generated_method = "8135547F7335BCC93E8ADF2EAD79E568")
    @Override
    protected void finalize() {
        if(DBG)        
        Log.d(LOG_TAG, "RuimRecords finalized");
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "RuimRecords finalized");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.342 -0400", hash_original_method = "890888F3646E6C0F40397D6A9CAE2069", hash_generated_method = "C164568DFBFDA4D969CE0DF6F4836D64")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.343 -0400", hash_original_method = "08E37B8778E680438FC3D481E4B7618D", hash_generated_method = "C55E2A2B55A4A89454B4DE6C0E7EA8C6")
    public String getMdnNumber() {
String var1FDFB70D070E103265F511CBBD7E87E9_1961015093 =         mMyMobileNumber;
        var1FDFB70D070E103265F511CBBD7E87E9_1961015093.addTaint(taint);
        return var1FDFB70D070E103265F511CBBD7E87E9_1961015093;
        // ---------- Original Method ----------
        //return mMyMobileNumber;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.343 -0400", hash_original_method = "70E8E8D1A91067A8AAF119FFCE233CA9", hash_generated_method = "67DD5DE74D3640FA59FF33993F3CA06B")
    public String getCdmaMin() {
String var3AED8228038CC465260B536B9B728D30_550573643 =         mMin2Min1;
        var3AED8228038CC465260B536B9B728D30_550573643.addTaint(taint);
        return var3AED8228038CC465260B536B9B728D30_550573643;
        // ---------- Original Method ----------
        //return mMin2Min1;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.343 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "C0F7244E2A9B3EAFB963BC996E69C647")
    public String getPrlVersion() {
String varF0DFA2A5AE60E78166448A9BF5899625_302694040 =         mPrlVersion;
        varF0DFA2A5AE60E78166448A9BF5899625_302694040.addTaint(taint);
        return varF0DFA2A5AE60E78166448A9BF5899625_302694040;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.344 -0400", hash_original_method = "42127C0CAB9B1B50FC97B071B6934168", hash_generated_method = "A4FEC9C6D9285F1AF3DAB2AFF680011F")
    @Override
    public void setVoiceMailNumber(String alphaTag, String voiceNumber, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(voiceNumber.getTaint());
        addTaint(alphaTag.getTaint());
        AsyncResult.forMessage((onComplete)).exception =
                new IccException("setVoiceMailNumber not implemented");
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage((onComplete)).exception =
                //new IccException("setVoiceMailNumber not implemented");
        //onComplete.sendToTarget();
        //Log.e(LOG_TAG, "method setVoiceMailNumber is not implemented");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.344 -0400", hash_original_method = "1D5D0C2F4FF0286B2839C7504C536EE3", hash_generated_method = "72BD7942533D93BFB9764D286429D53E")
    @Override
    public void onRefresh(boolean fileChanged, int[] fileList) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fileList[0]);
        addTaint(fileChanged);
        if(fileChanged)        
        {
            fetchRuimRecords();
        } //End block
        // ---------- Original Method ----------
        //if (fileChanged) {
            //fetchRuimRecords();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.345 -0400", hash_original_method = "1499AC64B3568BF128EFDB3C9845AC3C", hash_generated_method = "0561A77057949C09A65BBC2584738062")
    public String getRUIMOperatorNumeric() {
        if(mImsi == null)        
        {
String var540C13E9E156B687226421B24F2DF178_374518931 =             null;
            var540C13E9E156B687226421B24F2DF178_374518931.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_374518931;
        } //End block
        if(mncLength != UNINITIALIZED && mncLength != UNKNOWN)        
        {
String var037E65592CE79D6DE6FB65BCCEB02E99_696647560 =             mImsi.substring(0, 3 + mncLength);
            var037E65592CE79D6DE6FB65BCCEB02E99_696647560.addTaint(taint);
            return var037E65592CE79D6DE6FB65BCCEB02E99_696647560;
        } //End block
        int mcc = Integer.parseInt(mImsi.substring(0,3));
String var61ABF2776DBD6C902397B405DE533C4D_1351928350 =         mImsi.substring(0, 3 + MccTable.smallestDigitsMccForMnc(mcc));
        var61ABF2776DBD6C902397B405DE533C4D_1351928350.addTaint(taint);
        return var61ABF2776DBD6C902397B405DE533C4D_1351928350;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.348 -0400", hash_original_method = "584E0C361321C2DCD1B11D8CE97AF6DF", hash_generated_method = "699ED64687E8576A8A3645AF6763C44E")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        byte data[];
        boolean isRecordLoadResponse = false;
        try 
        {
switch(msg.what){
            case EVENT_RUIM_READY:
            onRuimReady();
            break;
            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
            onRadioOffOrNotAvailable();
            break;
            case EVENT_GET_DEVICE_IDENTITY_DONE:
            Log.d(LOG_TAG, "Event EVENT_GET_DEVICE_IDENTITY_DONE Received");
            break;
            case EVENT_GET_IMSI_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            if(ar.exception != null)            
            {
                break;
            } //End block
            mImsi = (String) ar.result;
            if(mImsi != null && (mImsi.length() < 6 || mImsi.length() > 15))            
            {
                mImsi = null;
            } //End block
            Log.d(LOG_TAG, "IMSI: " + mImsi.substring(0, 6) + "xxxxxxxxx");
            String operatorNumeric = getRUIMOperatorNumeric();
            if(operatorNumeric != null)            
            {
                if(operatorNumeric.length() <= 6)                
                {
                    MccTable.updateMccMncConfiguration(phone, operatorNumeric);
                } //End block
            } //End block
            break;
            case EVENT_GET_CDMA_SUBSCRIPTION_DONE:
            ar = (AsyncResult)msg.obj;
            String localTemp[] = (String[])ar.result;
            if(ar.exception != null)            
            {
                break;
            } //End block
            mMyMobileNumber = localTemp[0];
            mMin2Min1 = localTemp[3];
            mPrlVersion = localTemp[4];
            Log.d(LOG_TAG, "MDN: " + mMyMobileNumber + " MIN: " + mMin2Min1);
            break;
            case EVENT_GET_ICCID_DONE:
            isRecordLoadResponse = true;
            ar = (AsyncResult)msg.obj;
            data = (byte[])ar.result;
            if(ar.exception != null)            
            {
                break;
            } //End block
            iccid = IccUtils.bcdToString(data, 0, data.length);
            Log.d(LOG_TAG, "iccid: " + iccid);
            break;
            case EVENT_UPDATE_DONE:
            ar = (AsyncResult)msg.obj;
            if(ar.exception != null)            
            {
            } //End block
            break;
            case EVENT_GET_ALL_SMS_DONE:
            case EVENT_MARK_SMS_READ_DONE:
            case EVENT_SMS_ON_RUIM:
            case EVENT_GET_SMS_DONE:
            break;
            case EVENT_GET_SST_DONE:
            Log.d(LOG_TAG, "Event EVENT_GET_SST_DONE Received");
            break;
            case EVENT_RUIM_REFRESH:
            isRecordLoadResponse = false;
            ar = (AsyncResult)msg.obj;
            if(ar.exception == null)            
            {
                handleRuimRefresh((int[])(ar.result));
            } //End block
            break;
}
        } //End block
        catch (RuntimeException exc)
        {
        } //End block
        finally 
        {
            if(isRecordLoadResponse)            
            {
                onRecordLoaded();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.349 -0400", hash_original_method = "7082FCE9B35AC4F9F043D561172547FE", hash_generated_method = "F63B5B9289591575DB6AD56FDD6563CC")
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
            //Log.e(LOG_TAG, "RuimRecords: recordsToLoad <0, programmer error suspected");
            //recordsToLoad = 0;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.350 -0400", hash_original_method = "E50365918A8B4813331E3A24E11292EF", hash_generated_method = "FBF5B9BBF59482AF31F258DFBEBA6FA4")
    @Override
    protected void onAllRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Log.d(LOG_TAG, "RuimRecords: record load complete");
        String operator = getRUIMOperatorNumeric();
        SystemProperties.set(PROPERTY_ICC_OPERATOR_NUMERIC, operator);
        if(mImsi != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.350 -0400", hash_original_method = "0D138DB0BC983C7D13FA7613202FEE21", hash_generated_method = "1FF78874CA0F2DC120C3E1185A7CA429")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.351 -0400", hash_original_method = "618248758DCBCE1B082F10F6590C51C4", hash_generated_method = "6D556C673F6D97DF2BE72929A2949E7B")
    private void fetchRuimRecords() {
        recordsRequested = true;
        phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        recordsToLoad++;
        phone.getIccFileHandler().loadEFTransparent(EF_ICCID,
                obtainMessage(EVENT_GET_ICCID_DONE));
        recordsToLoad++;
        // ---------- Original Method ----------
        //recordsRequested = true;
        //Log.v(LOG_TAG, "RuimRecords:fetchRuimRecords " + recordsToLoad);
        //phone.mCM.getIMSI(obtainMessage(EVENT_GET_IMSI_DONE));
        //recordsToLoad++;
        //phone.getIccFileHandler().loadEFTransparent(EF_ICCID,
                //obtainMessage(EVENT_GET_ICCID_DONE));
        //recordsToLoad++;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.351 -0400", hash_original_method = "409F5B7F98F19D492107B7A38CA851EE", hash_generated_method = "C7EC2D52AEC568C2FC824893EC383A64")
    @Override
    public int getDisplayRule(String plmn) {
        addTaint(plmn.getTaint());
        int varCFCD208495D565EF66E7DFF9F98764DA_1010387078 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900469314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900469314;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.351 -0400", hash_original_method = "A6740B433D4FB4F3079B795061BDE226", hash_generated_method = "AB33E6F7F8D8827A2806B032DF81D24A")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        addTaint(countWaiting);
        addTaint(line);
        if(line != 1)        
        {
            return;
        } //End block
        if(countWaiting < 0)        
        {
            countWaiting = -1;
        } //End block
        else
        if(countWaiting > 0xff)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.351 -0400", hash_original_method = "BF9176F3CF68AA171F4E13CD5AF3ED9E", hash_generated_method = "DB8AD3E07BE7726A72327FFBE1B7A781")
    private void handleRuimRefresh(int[] result) {
        addTaint(result[0]);
        if(result == null || result.length == 0)        
        {
            if(DBG)            
            log("handleRuimRefresh without input");
            return;
        } //End block
switch((result[0])){
        case CommandsInterface.SIM_REFRESH_FILE_UPDATED:
        if(DBG)        
        log("handleRuimRefresh with SIM_REFRESH_FILE_UPDATED");
        adnCache.reset();
        fetchRuimRecords();
        break;
        case CommandsInterface.SIM_REFRESH_INIT:
        if(DBG)        
        log("handleRuimRefresh with SIM_REFRESH_INIT");
        fetchRuimRecords();
        break;
        case CommandsInterface.SIM_REFRESH_RESET:
        if(DBG)        
        log("handleRuimRefresh with SIM_REFRESH_RESET");
        phone.mCM.setRadioPower(false, null);
        break;
        default:
        if(DBG)        
        log("handleRuimRefresh with unknown operation");
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_method = "15EF52C4433D17716212414EB6E50E76", hash_generated_method = "7D5682B24658D535E9B96A107AF718F4")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[RuimRecords] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_method = "650BB8E79BCC4D913E519971F11AFA1E", hash_generated_method = "E7D94BCA5445789397AC7E67B09B77DB")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimRecords] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "1DEBF446A40353CC61F12433EDA4A667", hash_generated_field = "70C0002A03DDB0315C52D7F0E8B395A2")

    private static final int EVENT_RUIM_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "B41D6834011DAA4DB1A6AC940ADFA38E", hash_generated_field = "C65DF4AD1462685EBC499AE583280BAA")

    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "1C7B2408ABBFF84C0AE773B343AAE081", hash_generated_field = "29F539FB0647EE31D849E06DE444129C")

    private static final int EVENT_GET_IMSI_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "1EDF89A33C559C7081F2F14D9D9F0BD5", hash_generated_field = "A26946778DAA98F81D609908E4D9E727")

    private static final int EVENT_GET_DEVICE_IDENTITY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "F04ED69F1D1D36AD737B9E6BF7733C67", hash_generated_field = "1DF607ACA15F09CB3B4DC1DFD512B2E3")

    private static final int EVENT_GET_ICCID_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "3C3AA88B43A133797BBE286990868EB6", hash_generated_field = "F65C212D57735E486171DDE0436EF906")

    private static final int EVENT_GET_CDMA_SUBSCRIPTION_DONE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "529053860FA14F8B31FBDEC20F5F5B03", hash_generated_field = "7C08F6997CDB1F95B53292AC6E4DA474")

    private static final int EVENT_UPDATE_DONE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "1E3C0E257296800F8D76872CD2E55387", hash_generated_field = "94AFAFC942E8F21799585FB7E7B86992")

    private static final int EVENT_GET_SST_DONE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "3B79516072415E285E9DD48ECF8C32E3", hash_generated_field = "9F464D691ED618E65FF918987EFF9274")

    private static final int EVENT_GET_ALL_SMS_DONE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "5EB21554FBD2F493FD526FF035BA3944", hash_generated_field = "961A7A4D60E11CE78834F70BC49A219A")

    private static final int EVENT_MARK_SMS_READ_DONE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "752339407D2812D75F5811F2D829619F", hash_generated_field = "ED99436836464B30EF1636FCBA09D78C")

    private static final int EVENT_SMS_ON_RUIM = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "17E27DF4CEFFF43554FD32CB85BD7662", hash_generated_field = "18FB3B701347968BBB3DB68B7D9FA9E0")

    private static final int EVENT_GET_SMS_DONE = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.352 -0400", hash_original_field = "27D03FBCCCD2C74099B3C666524D8E79", hash_generated_field = "AA66F54A711788ECF4FB24747995AEB7")

    private static final int EVENT_RUIM_REFRESH = 31;
}

