package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.util.Log;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.gsm.GsmSMSDispatcher;
import com.android.internal.telephony.gsm.SimCard;
import com.android.internal.telephony.ims.IsimRecords;

public class CDMALTEPhone extends CDMAPhone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.617 -0400", hash_original_field = "5FF746CE02B754A19471A70F50E4C815", hash_generated_field = "27F27AE32D7151DB014BA8DF2F1FF61C")

    SMSDispatcher m3gppSMS;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.617 -0400", hash_original_method = "95A3B81B84D99B553D70C547C891DC97", hash_generated_method = "7186C8D445CE5FD2ADEACCBFE51F9383")
    public  CDMALTEPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(context, ci, notifier, false);
        addTaint(notifier.getTaint());
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        // ---------- Original Method ----------
        //m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.618 -0400", hash_original_method = "7419DD25F2A8EC5E4F54973E3AF74E7D", hash_generated_method = "E666EC1DEE3712C9AFD8E800BDD4B431")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        Message onComplete;
switch(msg.what){
        case EVENT_SET_NETWORK_MANUAL_COMPLETE:
        handleSetSelectNetwork((AsyncResult) msg.obj);
        break;
        default:
        super.handleMessage(msg);
}
        // ---------- Original Method ----------
        //AsyncResult ar;
        //Message onComplete;
        //switch (msg.what) {
            //case EVENT_SET_NETWORK_MANUAL_COMPLETE:
                //handleSetSelectNetwork((AsyncResult) msg.obj);
                //break;
            //default:
                //super.handleMessage(msg);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.618 -0400", hash_original_method = "A724800C9AF8E80E36877A25E474B13E", hash_generated_method = "BB92E66E6A1EC42AB8A8874247EB43E6")
    @Override
    protected void initSstIcc() {
        mSST = new CdmaLteServiceStateTracker(this);
        mIccRecords = new CdmaLteUiccRecords(this);
        mIccCard = new SimCard(this, LOG_TAG, DBG);
        mIccFileHandler = new CdmaLteUiccFileHandler(this);
        // ---------- Original Method ----------
        //mSST = new CdmaLteServiceStateTracker(this);
        //mIccRecords = new CdmaLteUiccRecords(this);
        //mIccCard = new SimCard(this, LOG_TAG, DBG);
        //mIccFileHandler = new CdmaLteUiccFileHandler(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.619 -0400", hash_original_method = "66C432AAD817657842F9394EA9EE83CC", hash_generated_method = "BE28F43C73D1A2ACA840E26EDB7B9BF5")
    @Override
    public void dispose() {
        synchronized
(PhoneProxy.lockForRadioTechnologyChange)        {
            super.dispose();
            m3gppSMS.dispose();
        } //End block
        // ---------- Original Method ----------
        //synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            //super.dispose();
            //m3gppSMS.dispose();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.619 -0400", hash_original_method = "BDA3902BB46E4D338A3093A3F1641F9B", hash_generated_method = "34741DA197EEA964843CD3F86845CD77")
    @Override
    public void removeReferences() {
        super.removeReferences();
        m3gppSMS = null;
        // ---------- Original Method ----------
        //super.removeReferences();
        //m3gppSMS = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.621 -0400", hash_original_method = "D6AB29F1311EC0AB849815CC3FF790B9", hash_generated_method = "F6B7A4FBF85B9BED68FF50E8B305052D")
    @Override
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
        DataState ret = DataState.DISCONNECTED;
    if(mSST == null)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
    if(mDataConnectionTracker.isApnTypeEnabled(apnType) == false)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
        {
switch(mDataConnectionTracker.getState(apnType)){
            case FAILED:
            case IDLE:
            ret = DataState.DISCONNECTED;
            break;
            case CONNECTED:
            case DISCONNECTING:
    if(mCT.state != Phone.State.IDLE && !mSST.isConcurrentVoiceAndDataAllowed())            
            {
                ret = DataState.SUSPENDED;
            } //End block
            else
            {
                ret = DataState.CONNECTED;
            } //End block
            break;
            case INITING:
            case CONNECTING:
            case SCANNING:
            ret = DataState.CONNECTING;
            break;
}
        } //End block
        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
DataState varEDFF4FBBF053B5DC2B444ADFA049EE0F_2034734996 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_2034734996.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2034734996;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.622 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "ED3994A72D1681C6ED272E38D565CABC")
    @Override
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.624 -0400", hash_original_method = "55A3B9E950023A6988A6B5C4DCBDEA6C", hash_generated_method = "9D68D09A9CDC24FE2E8AF94F0D427509")
    private void handleSetSelectNetwork(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(!(ar.userObj instanceof NetworkSelectMessage))        
        {
    if(DBG)            
            Log.d(LOG_TAG, "unexpected result from user object.");
            return;
        } //End block
        NetworkSelectMessage nsm = (NetworkSelectMessage) ar.userObj;
    if(nsm.message != null)        
        {
    if(DBG)            
            Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        } //End block
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);
    if(! editor.commit())        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.625 -0400", hash_original_method = "209DB6DC61EA45DEB13BF7CF447B5FBA", hash_generated_method = "95F616D123E9E556BBBAE69A5A247B9F")
    @Override
    public boolean updateCurrentCarrierInProvider() {
    if(mIccRecords != null)        
        {
            try 
            {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                String operatorNumeric = mIccRecords.getOperatorNumeric();
                map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                log("updateCurrentCarrierInProvider from UICC: numeric=" + operatorNumeric);
                mContext.getContentResolver().insert(uri, map);
                boolean varB326B5062B2F0E69046810717534CB09_878570954 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883869464 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_883869464;
            } //End block
            catch (SQLException e)
            {
            } //End block
        } //End block
        else
        {
            log("updateCurrentCarrierInProvider mIccRecords == null ret false");
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_304827799 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33579852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33579852;
        // ---------- Original Method ----------
        //if (mIccRecords != null) {
            //try {
                //Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                //ContentValues map = new ContentValues();
                //String operatorNumeric = mIccRecords.getOperatorNumeric();
                //map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                //log("updateCurrentCarrierInProvider from UICC: numeric=" + operatorNumeric);
                //mContext.getContentResolver().insert(uri, map);
                //return true;
            //} catch (SQLException e) {
                //Log.e(LOG_TAG, "[CDMALTEPhone] Can't store current operator ret false", e);
            //}
        //} else {
            //log("updateCurrentCarrierInProvider mIccRecords == null ret false");
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.626 -0400", hash_original_method = "3E01D20FCE14548AEDCD05440449A2C4", hash_generated_method = "C0318C47A19F42F3751E8F5DF75E2F6C")
    @Override
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        addTaint(fromMcc);
        addTaint(country.getTaint());
        addTaint(language.getTaint());
    if(fromMcc)        
        return;
        super.setSystemLocale(language, country, false);
        // ---------- Original Method ----------
        //if (fromMcc) return;
        //super.setSystemLocale(language, country, false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.626 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "9D5351907D6BC695DF94D64BDA73B6A5")
    @Override
    public String getSubscriberId() {
String var9E0F6CF9E749066E7163DA637BDC770E_1890310153 =         mIccRecords.getIMSI();
        var9E0F6CF9E749066E7163DA637BDC770E_1890310153.addTaint(taint);
        return var9E0F6CF9E749066E7163DA637BDC770E_1890310153;
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.626 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "5AFCBAB8A5BDA69A65622C7BE760B9B5")
    @Override
    public String getImei() {
String varDEC341D68DE51B3F93C3763FDA1DF1F5_1923884351 =         mImei;
        varDEC341D68DE51B3F93C3763FDA1DF1F5_1923884351.addTaint(taint);
        return varDEC341D68DE51B3F93C3763FDA1DF1F5_1923884351;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.627 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "134730FC46821F3CA992113221862242")
    @Override
    public String getDeviceSvn() {
String var440DA0F542A7DF067CD1A564FADAEE1C_943659356 =         mImeiSv;
        var440DA0F542A7DF067CD1A564FADAEE1C_943659356.addTaint(taint);
        return var440DA0F542A7DF067CD1A564FADAEE1C_943659356;
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.627 -0400", hash_original_method = "9816ECED47475DB23BCECA20DA4E2B5A", hash_generated_method = "1A83EA8AB0BBF6276C03B893FCB0151F")
    @Override
    public IsimRecords getIsimRecords() {
IsimRecords varA54E2F00206ADE38CAE9E5438115660C_800510347 =         mIccRecords.getIsimRecords();
        varA54E2F00206ADE38CAE9E5438115660C_800510347.addTaint(taint);
        return varA54E2F00206ADE38CAE9E5438115660C_800510347;
        // ---------- Original Method ----------
        //return mIccRecords.getIsimRecords();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.627 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "5E7081A72EE04339263029385E04B5D6")
    @Override
    public String getMsisdn() {
String var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_222578075 =         mIccRecords.getMsisdnNumber();
        var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_222578075.addTaint(taint);
        return var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_222578075;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "276A7FEC40B6D9144DB1F28951D35976")
    @Override
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        mCM.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_method = "F8B11B15838465AB38A3DDFE9FF000B6", hash_generated_method = "20892B8ECEDF6A4F71CD9DF7BE70AAC7")
    @Override
    public void requestIsimAuthentication(String nonce, Message result) {
        addTaint(result.getTaint());
        addTaint(nonce.getTaint());
        mCM.requestIsimAuthentication(nonce, result);
        // ---------- Original Method ----------
        //mCM.requestIsimAuthentication(nonce, result);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_method = "69A9D8984C1FC702F097120D9CC0BB90", hash_generated_method = "D617ECE150CDF40841A353EBC76DCAE6")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
    if(DBG)        
        Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
    }

    
    private static class NetworkSelectMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.628 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.629 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.629 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.629 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
}

