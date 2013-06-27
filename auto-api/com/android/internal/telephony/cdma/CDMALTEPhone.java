package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.669 -0400", hash_original_field = "5FF746CE02B754A19471A70F50E4C815", hash_generated_field = "27F27AE32D7151DB014BA8DF2F1FF61C")

    SMSDispatcher m3gppSMS;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.670 -0400", hash_original_method = "95A3B81B84D99B553D70C547C891DC97", hash_generated_method = "F50AD14F2191F991F142CFDD7698053C")
    public  CDMALTEPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(context, ci, notifier, false);
        m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
        //m3gppSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.670 -0400", hash_original_method = "7419DD25F2A8EC5E4F54973E3AF74E7D", hash_generated_method = "20CF8BE9EA384B3B93ED8269BBE5937C")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        Message onComplete;
        //Begin case EVENT_SET_NETWORK_MANUAL_COMPLETE 
        handleSetSelectNetwork((AsyncResult) msg.obj);
        //End case EVENT_SET_NETWORK_MANUAL_COMPLETE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.671 -0400", hash_original_method = "A724800C9AF8E80E36877A25E474B13E", hash_generated_method = "BB92E66E6A1EC42AB8A8874247EB43E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.682 -0400", hash_original_method = "66C432AAD817657842F9394EA9EE83CC", hash_generated_method = "11237E3ED9E3EA0C65905500A42CD3EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.682 -0400", hash_original_method = "BDA3902BB46E4D338A3093A3F1641F9B", hash_generated_method = "34741DA197EEA964843CD3F86845CD77")
    @Override
    public void removeReferences() {
        super.removeReferences();
        m3gppSMS = null;
        // ---------- Original Method ----------
        //super.removeReferences();
        //m3gppSMS = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.683 -0400", hash_original_method = "D6AB29F1311EC0AB849815CC3FF790B9", hash_generated_method = "D542EACF511D42A796107A65C2F07B67")
    @Override
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_827148973 = null; //Variable for return #1
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean varFA7F3A368C6F5E70591E7C057A7442A6_1836257820 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                {
                    Object varAD41FD756955096DC69FC1F1B528A339_988693888 = (mDataConnectionTracker.getState(apnType));
                    //Begin case FAILED IDLE 
                    ret = DataState.DISCONNECTED;
                    //End case FAILED IDLE 
                    //Begin case CONNECTED DISCONNECTING 
                    {
                        boolean var22B6F15268758460428B7D53FE560876_1799373864 = (mCT.state != Phone.State.IDLE && !mSST.isConcurrentVoiceAndDataAllowed());
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
        varB4EAC82CA7396A68D541C85D26508E83_827148973 = ret;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_827148973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827148973;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.683 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "AC13EB0F6B58B218EBF0517B0174C3D9")
    @Override
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.694 -0400", hash_original_method = "55A3B9E950023A6988A6B5C4DCBDEA6C", hash_generated_method = "AC874B366FE3469E69C03E9A21D8CB44")
    private void handleSetSelectNetwork(AsyncResult ar) {
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
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1738222064 = (! editor.commit());
        } //End collapsed parenthetic
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.696 -0400", hash_original_method = "209DB6DC61EA45DEB13BF7CF447B5FBA", hash_generated_method = "6EFD57D06EF5F3DFE54CCABEA8996E7C")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802125572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802125572;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.703 -0400", hash_original_method = "3E01D20FCE14548AEDCD05440449A2C4", hash_generated_method = "3A8896C9306D2A67C5BCB0ECD4080C6E")
    @Override
    public void setSystemLocale(String language, String country, boolean fromMcc) {
        super.setSystemLocale(language, country, false);
        addTaint(language.getTaint());
        addTaint(country.getTaint());
        addTaint(fromMcc);
        // ---------- Original Method ----------
        //if (fromMcc) return;
        //super.setSystemLocale(language, country, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.703 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "23124D57BCB46A874603CD50A3342D58")
    @Override
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_958768536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_958768536 = mIccRecords.getIMSI();
        varB4EAC82CA7396A68D541C85D26508E83_958768536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958768536;
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.704 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "1AB84839E5795A47E177828488E9A8A6")
    @Override
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_2030825373 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2030825373 = mImei;
        varB4EAC82CA7396A68D541C85D26508E83_2030825373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2030825373;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.704 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "4E8707B67F3A965A23785AE6694EF62B")
    @Override
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1029057195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1029057195 = mImeiSv;
        varB4EAC82CA7396A68D541C85D26508E83_1029057195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1029057195;
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.704 -0400", hash_original_method = "9816ECED47475DB23BCECA20DA4E2B5A", hash_generated_method = "1FA71BDAAEB4E6718DB2A1E6C17CA8EC")
    @Override
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1208718426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1208718426 = mIccRecords.getIsimRecords();
        varB4EAC82CA7396A68D541C85D26508E83_1208718426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1208718426;
        // ---------- Original Method ----------
        //return mIccRecords.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.705 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "51857DCE6C704E253F0B5E1D73826E50")
    @Override
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1738098020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1738098020 = mIccRecords.getMsisdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1738098020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738098020;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.705 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "7A0261EFBFA0095CF18C0C0DC0174007")
    @Override
    public void getAvailableNetworks(Message response) {
        mCM.getAvailableNetworks(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.705 -0400", hash_original_method = "F8B11B15838465AB38A3DDFE9FF000B6", hash_generated_method = "9105AE7ABCA1149EF39D69759A35626D")
    @Override
    public void requestIsimAuthentication(String nonce, Message result) {
        mCM.requestIsimAuthentication(nonce, result);
        addTaint(nonce.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mCM.requestIsimAuthentication(nonce, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_method = "69A9D8984C1FC702F097120D9CC0BB90", hash_generated_method = "31C8452321744193E59AC1DDD9B23A37")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMALTEPhone] " + s);
    }

    
    private static class NetworkSelectMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.708 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
}

