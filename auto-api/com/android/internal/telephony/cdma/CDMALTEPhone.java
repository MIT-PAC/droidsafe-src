package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    static final String LOG_TAG = "CDMA";
    private static final boolean DBG = true;
    SMSDispatcher m3gppSMS;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "95A3B81B84D99B553D70C547C891DC97", hash_generated_method = "FD7C986D3F49A6FCBF2D7B20005DD7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDMALTEPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(context, ci, notifier, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        // ---------- Original Method ----------
        //m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "7419DD25F2A8EC5E4F54973E3AF74E7D", hash_generated_method = "9606C2483F36459211381C5973F2FFBE")
    @DSModeled(DSC.SAFE)
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        Message onComplete;
        //Begin case EVENT_SET_NETWORK_MANUAL_COMPLETE 
        handleSetSelectNetwork((AsyncResult) msg.obj);
        //End case EVENT_SET_NETWORK_MANUAL_COMPLETE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "A724800C9AF8E80E36877A25E474B13E", hash_generated_method = "22A35D8C2BF3C5FDA2B2514F9F3C8353")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "66C432AAD817657842F9394EA9EE83CC", hash_generated_method = "0A97EF78C7B8C15977A36A17E313344D")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispose() {
        {
            super.dispose();
            m3gppSMS.dispose();
        } //End block
        // ---------- Original Method ----------
        //synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            //super.dispose();
            //m3gppSMS.dispose();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "BDA3902BB46E4D338A3093A3F1641F9B", hash_generated_method = "5BCE992A1FF91A7B065D7F1DC2785C53")
    @DSModeled(DSC.SAFE)
    @Override
    public void removeReferences() {
        super.removeReferences();
        m3gppSMS = null;
        // ---------- Original Method ----------
        //super.removeReferences();
        //m3gppSMS = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "D6AB29F1311EC0AB849815CC3FF790B9", hash_generated_method = "8871F3FE67D3A3DAA4CE661CDC939FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DataState getDataConnectionState(String apnType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(apnType);
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean varFA7F3A368C6F5E70591E7C057A7442A6_362655002 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                {
                    Object varAD41FD756955096DC69FC1F1B528A339_1912891365 = (mDataConnectionTracker.getState(apnType));
                    //Begin case FAILED IDLE 
                    ret = DataState.DISCONNECTED;
                    //End case FAILED IDLE 
                    //Begin case CONNECTED DISCONNECTING 
                    {
                        boolean var22B6F15268758460428B7D53FE560876_1591626507 = (mCT.state != Phone.State.IDLE && !mSST.isConcurrentVoiceAndDataAllowed());
                        {
                            ret = DataState.SUSPENDED;
                        } //End block
                        {
                            ret = DataState.CONNECTED;
                        } //End block
                    } //End collapsed parenthetic
                    //End case CONNECTED DISCONNECTING 
                    //Begin case INITING CONNECTING SCANNING 
                    ret = DataState.CONNECTING;
                    //End case INITING CONNECTING SCANNING 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "955158D6787C1EAFC76CF73EC2F17E5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.664 -0400", hash_original_method = "55A3B9E950023A6988A6B5C4DCBDEA6C", hash_generated_method = "5DB4E0481B0D3AD3A58D2A33BD0105FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSetSelectNetwork(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            Log.d(LOG_TAG, "unexpected result from user object.");
        } //End block
        NetworkSelectMessage nsm;
        nsm = (NetworkSelectMessage) ar.userObj;
        {
            Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        } //End block
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1717011896 = (! editor.commit());
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "209DB6DC61EA45DEB13BF7CF447B5FBA", hash_generated_method = "00B2DC3CC3B3F619A1EE8CC51322183E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean updateCurrentCarrierInProvider() {
        {
            try 
            {
                Uri uri;
                uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map;
                map = new ContentValues();
                String operatorNumeric;
                operatorNumeric = mIccRecords.getOperatorNumeric();
                map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                log("updateCurrentCarrierInProvider from UICC: numeric=" + operatorNumeric);
                mContext.getContentResolver().insert(uri, map);
            } //End block
            catch (SQLException e)
            { }
        } //End block
        {
            log("updateCurrentCarrierInProvider mIccRecords == null ret false");
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "3E01D20FCE14548AEDCD05440449A2C4", hash_generated_method = "80D318244EF561DC4A7E08A38F1ABE15")
    @DSModeled(DSC.SAFE)
    @Override
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        dsTaint.addTaint(fromMcc);
        dsTaint.addTaint(language);
        dsTaint.addTaint(country);
        super.setSystemLocale(language, country, false);
        // ---------- Original Method ----------
        //if (fromMcc) return;
        //super.setSystemLocale(language, country, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "519E7EDF42751FA0DEA26CA0D9556FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getSubscriberId() {
        String var7FD2EEB6F75B5B5070336667783F1237_94300225 = (mIccRecords.getIMSI());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "65460C8A8972BFADF7FBE63004DD2909")
    @DSModeled(DSC.SAFE)
    @Override
    public String getImei() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "B6F565272653663E1DFEFD33B9AC1C94")
    @DSModeled(DSC.SAFE)
    @Override
    public String getDeviceSvn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "9816ECED47475DB23BCECA20DA4E2B5A", hash_generated_method = "D79227DFA11E76BA06E0272470F54DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IsimRecords getIsimRecords() {
        IsimRecords var8A5C0054B8508A6A3ACBB357DC129F30_1882813507 = (mIccRecords.getIsimRecords());
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccRecords.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "8B87D2DEFE31274D39B8B7107D493972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMsisdn() {
        String var371895645902F934A5DFC882DDC1D4C9_2032961009 = (mIccRecords.getMsisdnNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "29DFB201EAF04671004F03DF1FEC9189")
    @DSModeled(DSC.SAFE)
    @Override
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "F8B11B15838465AB38A3DDFE9FF000B6", hash_generated_method = "4995C7F7D0682DAE792622E7EB524E5D")
    @DSModeled(DSC.SAFE)
    @Override
    public void requestIsimAuthentication(String nonce, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(nonce);
        mCM.requestIsimAuthentication(nonce, result);
        // ---------- Original Method ----------
        //mCM.requestIsimAuthentication(nonce, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.665 -0400", hash_original_method = "69A9D8984C1FC702F097120D9CC0BB90", hash_generated_method = "54F6C9844FC1F401EC4D5B8B17C910F3")
    @DSModeled(DSC.SAFE)
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
    }

    
    private static class NetworkSelectMessage {
        public Message message;
        public String operatorNumeric;
        public String operatorAlphaLong;
        
    }


    
}


