package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.624 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.627 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.629 -0500", hash_original_field = "27F27AE32D7151DB014BA8DF2F1FF61C", hash_generated_field = "27F27AE32D7151DB014BA8DF2F1FF61C")

    SMSDispatcher m3gppSMS;

    // Constructors
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.641 -0500", hash_original_method = "95A3B81B84D99B553D70C547C891DC97", hash_generated_method = "88A3E066075D863F51C2A45969D82471")
    
public CDMALTEPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(context, ci, notifier, false);
        m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.644 -0500", hash_original_method = "7419DD25F2A8EC5E4F54973E3AF74E7D", hash_generated_method = "A95A5BB9C248FC914A314126C843D57B")
    
@Override
    public void handleMessage (Message msg) {
        AsyncResult ar;
        Message onComplete;
        switch (msg.what) {
            // handle the select network completion callbacks.
            case EVENT_SET_NETWORK_MANUAL_COMPLETE:
                handleSetSelectNetwork((AsyncResult) msg.obj);
                break;
            default:
                super.handleMessage(msg);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.646 -0500", hash_original_method = "A724800C9AF8E80E36877A25E474B13E", hash_generated_method = "0EE18C85032F9B0CDA16E5B971C97394")
    
@Override
    protected void initSstIcc() {
        mSST = new CdmaLteServiceStateTracker(this);
        mIccRecords = new CdmaLteUiccRecords(this);
        mIccCard = new SimCard(this, LOG_TAG, DBG);
        mIccFileHandler = new CdmaLteUiccFileHandler(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.649 -0500", hash_original_method = "66C432AAD817657842F9394EA9EE83CC", hash_generated_method = "0AE9DCA5C3361FEF186B38CBAF681297")
    
@Override
    public void dispose() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            super.dispose();
            m3gppSMS.dispose();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.652 -0500", hash_original_method = "BDA3902BB46E4D338A3093A3F1641F9B", hash_generated_method = "164819150BE527B747213D025B3F99D9")
    
@Override
    public void removeReferences() {
        super.removeReferences();
        m3gppSMS = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.655 -0500", hash_original_method = "D6AB29F1311EC0AB849815CC3FF790B9", hash_generated_method = "994016234E59982709C9691B9FEF30B2")
    
@Override
    public DataState getDataConnectionState(String apnType) {
        DataState ret = DataState.DISCONNECTED;

        if (mSST == null) {
            // Radio Technology Change is ongoing, dispose() and
            // removeReferences() have already been called

            ret = DataState.DISCONNECTED;
        } else if (mDataConnectionTracker.isApnTypeEnabled(apnType) == false) {
            ret = DataState.DISCONNECTED;
        } else {
            switch (mDataConnectionTracker.getState(apnType)) {
                case FAILED:
                case IDLE:
                    ret = DataState.DISCONNECTED;
                    break;

                case CONNECTED:
                case DISCONNECTING:
                    if (mCT.state != Phone.State.IDLE && !mSST.isConcurrentVoiceAndDataAllowed()) {
                        ret = DataState.SUSPENDED;
                    } else {
                        ret = DataState.CONNECTED;
                    }
                    break;

                case INITING:
                case CONNECTING:
                case SCANNING:
                    ret = DataState.CONNECTING;
                    break;
            }
        }

        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.657 -0500", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "69248CC08688A25AC427C30AD02C28FE")
    
@Override
    public void
    selectNetworkManually(OperatorInfo network,
            Message response) {
        // wrap the response message in our own message along with
        // the operator's id.
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();

        // get the message
        Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);

        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    /**
     * Used to track the settings upon completion of the network change.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.660 -0500", hash_original_method = "55A3B9E950023A6988A6B5C4DCBDEA6C", hash_generated_method = "FCA9220C59ACC5602EBC8A8A450E14DD")
    
private void handleSetSelectNetwork(AsyncResult ar) {
        // look for our wrapper within the asyncresult, skip the rest if it
        // is null.
        if (!(ar.userObj instanceof NetworkSelectMessage)) {
            if (DBG) Log.d(LOG_TAG, "unexpected result from user object.");
            return;
        }

        NetworkSelectMessage nsm = (NetworkSelectMessage) ar.userObj;

        // found the object, now we send off the message we had originally
        // attached to the request.
        if (nsm.message != null) {
            if (DBG) Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        }

        // open the shared preferences editor, and write the value.
        // nsm.operatorNumeric is "" if we're in automatic.selection.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);

        // commit and log the result.
        if (! editor.commit()) {
            Log.e(LOG_TAG, "failed to commit network selection preference");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.663 -0500", hash_original_method = "209DB6DC61EA45DEB13BF7CF447B5FBA", hash_generated_method = "3C92F4BBFB64C1EF4941E4126246F01C")
    
@Override
    public boolean updateCurrentCarrierInProvider() {
        if (mIccRecords != null) {
            try {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                String operatorNumeric = mIccRecords.getOperatorNumeric();
                map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                log("updateCurrentCarrierInProvider from UICC: numeric=" + operatorNumeric);
                mContext.getContentResolver().insert(uri, map);
                return true;
            } catch (SQLException e) {
                Log.e(LOG_TAG, "[CDMALTEPhone] Can't store current operator ret false", e);
            }
        } else {
            log("updateCurrentCarrierInProvider mIccRecords == null ret false");
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.665 -0500", hash_original_method = "3E01D20FCE14548AEDCD05440449A2C4", hash_generated_method = "481063AA9E64D6835A4D2C6ED2A38A09")
    
@Override
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        // Avoid system locale is set from MCC table if CDMALTEPhone is used.
        // The locale will be picked up based on EFpl/EFli once CSIM records are loaded.
        if (fromMcc) return;

        super.setSystemLocale(language, country, false);
    }

    // return IMSI from USIM as subscriber ID.
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.667 -0500", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "61DF0D8CEEED037CC4021D8AFBCFEC9E")
    
@Override
    public String getSubscriberId() {
        return mIccRecords.getIMSI();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.670 -0500", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "F2ACFCEBB390ABDC4340F05E7FFDBB5C")
    
@Override
    public String getImei() {
        return mImei;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.672 -0500", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "F74607AC6D3291B5D40293274DA80CCB")
    
@Override
    public String getDeviceSvn() {
        return mImeiSv;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.675 -0500", hash_original_method = "9816ECED47475DB23BCECA20DA4E2B5A", hash_generated_method = "78B92215C2B85EF5F14717FCDA18017C")
    
@Override
    public IsimRecords getIsimRecords() {
        return mIccRecords.getIsimRecords();
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.677 -0500", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "C643750F6EC44E71120807E5FC6FB0C0")
    
@Override
    public String getMsisdn() {
        return mIccRecords.getMsisdnNumber();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.680 -0500", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "4B89959CC41D0CB5D374F11DBE99A97A")
    
@Override
    public void getAvailableNetworks(Message response) {
        mCM.getAvailableNetworks(response);
    }
    
    private static class NetworkSelectMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.632 -0500", hash_original_field = "917CC93E170BCDBC06457BE4F50622BF", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.634 -0500", hash_original_field = "EDEB2AE49295E0D0131E5CCBDF250E4F", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.637 -0500", hash_original_field = "D5205C75E0728BD5532E96497C7DFA52", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:21.873 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.682 -0500", hash_original_method = "F8B11B15838465AB38A3DDFE9FF000B6", hash_generated_method = "D4170D5839D1C09C139275D314DDA69E")
    
@Override
    public void requestIsimAuthentication(String nonce, Message result) {
        mCM.requestIsimAuthentication(nonce, result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.685 -0500", hash_original_method = "69A9D8984C1FC702F097120D9CC0BB90", hash_generated_method = "474B94D247575626BF707489948D21B1")
    
@Override
    protected void log(String s) {
        if (DBG)
            Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
    }
}

