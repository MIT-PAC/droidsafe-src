package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.RILConstants;
import android.content.Intent;
import android.telephony.SignalStrength;
import android.telephony.ServiceState;
import android.telephony.cdma.CdmaCellLocation;
import android.os.AsyncResult;
import android.os.Message;
import android.provider.Telephony.Intents;
import android.text.TextUtils;
import android.util.Log;
import android.util.EventLog;
import com.android.internal.telephony.gsm.GsmDataConnectionTracker;

public class CdmaLteServiceStateTracker extends CdmaServiceStateTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.890 -0400", hash_original_field = "B5F20DF0028332D17F33E3BF40040A23", hash_generated_field = "879F4AF456AD7D7A9BB5520F0BAD6F62")

    CDMALTEPhone mCdmaLtePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.890 -0400", hash_original_field = "422A4AE190845160AC9AC0B750445158", hash_generated_field = "CCE1FE524FD9420E4F8B07A4C62521E0")

    private ServiceState mLteSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.891 -0400", hash_original_field = "8F9DBE53F0380067CC21F8BCAF3A13AB", hash_generated_field = "33DD1D28F358EBB2DB6B0718CE46393E")

    private boolean mNeedToRegForSimLoaded = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.891 -0400", hash_original_method = "47593605762760CA14FD5EED8D416F47", hash_generated_method = "11DA1E1C518A4BE5A894F01418433984")
    public  CdmaLteServiceStateTracker(CDMALTEPhone phone) {
        super(phone);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        mCdmaLtePhone = phone;
        mLteSS = new ServiceState();
        log("CdmaLteServiceStateTracker Constructors");
        // ---------- Original Method ----------
        //cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        //mCdmaLtePhone = phone;
        //mLteSS = new ServiceState();
        //if (DBG) log("CdmaLteServiceStateTracker Constructors");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.891 -0400", hash_original_method = "E8B96682BA406A5B61C3BDB5E6938EBA", hash_generated_method = "C9E65A83CD4B2E304C5D2B05ECCE7357")
    @Override
    public void dispose() {
        cm.unregisterForSIMReady(this);
        super.dispose();
        // ---------- Original Method ----------
        //cm.unregisterForSIMReady(this);
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.892 -0400", hash_original_method = "D5AC4DEC3B42E743000565D518230B6D", hash_generated_method = "57CEFDCD4A5B41FD0CF7DA195C8E6DB9")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        int[] ints;
        String[] strings;
        //Begin case EVENT_POLL_STATE_GPRS 
        log("handleMessage EVENT_POLL_STATE_GPRS");
        //End case EVENT_POLL_STATE_GPRS 
        //Begin case EVENT_POLL_STATE_GPRS 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_POLL_STATE_GPRS 
        //Begin case EVENT_POLL_STATE_GPRS 
        handlePollStateResult(msg.what, ar);
        //End case EVENT_POLL_STATE_GPRS 
        //Begin case EVENT_SIM_READY 
        log("handleMessage EVENT_SIM_READY");
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        isSubscriptionFromRuim = false;
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        {
            phone.mIccRecords.registerForRecordsLoaded(this, EVENT_SIM_RECORDS_LOADED, null);
            mNeedToRegForSimLoaded = false;
        } //End block
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        pollState();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        queueNextSignalStrengthPoll();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        phone.prepareEri();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        CdmaLteUiccRecords sim = (CdmaLteUiccRecords)phone.mIccRecords;
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        {
            boolean var9D34BD6BCEA8823A6E7690D862CEC2C3_1249782168 = ((sim != null) && sim.isProvisioned());
            {
                mMdn = sim.getMdn();
                mMin = sim.getMin();
                parseSidNid(sim.getSid(), sim.getNid());
                mPrlVersion = sim.getPrlVersion();
                ;
                mIsMinInfoReady = true;
                updateOtaspState();
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        pollState();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.892 -0400", hash_original_method = "F7DAEBCFC7E85FA3AD1692EAA757E22A", hash_generated_method = "FA3060E6DE889A075C4DD548B09B8298")
    @Override
    protected void setCdmaTechnology(int radioTechnology) {
        newSS.setRadioTechnology(radioTechnology);
        addTaint(radioTechnology);
        // ---------- Original Method ----------
        //newSS.setRadioTechnology(radioTechnology);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.893 -0400", hash_original_method = "DA636A49D82699419B2FBA1150F1CBEF", hash_generated_method = "7B14FE006E128915DF57E51910632260")
    @Override
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        {
            log("handlePollStateResultMessage: EVENT_POLL_STATE_GPRS");
            String states[] = (String[])ar.result;
            int type = 0;
            int regState = -1;
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
                    {
                        type = Integer.parseInt(states[3]);
                    } //End block
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("handlePollStateResultMessage: error parsing GprsRegistrationState: "
                                    + ex);
                } //End block
            } //End block
            mLteSS.setRadioTechnology(type);
            mLteSS.setState(regCodeToServiceState(regState));
        } //End block
        {
            super.handlePollStateResultMessage(what, ar);
        } //End block
        addTaint(what);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.894 -0400", hash_original_method = "10E4D98F7F6A52C0BD2C384AE2F36499", hash_generated_method = "FE4E9808A03FFE71C90B9C094045E9B6")
    @Override
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.895 -0400", hash_original_method = "B583B233911BF73B0CF330862869CA80", hash_generated_method = "5690298A122F706FA385B133A958F220")
    @Override
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1089072437 = (cm.getRadioState());
            //Begin case RADIO_UNAVAILABLE 
            newSS.setStateOutOfService();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            newCellLoc.setStateInvalid();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            setSignalStrengthDefaultValues();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            mGotCountryCode = false;
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            pollStateDone();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_OFF 
            newSS.setStateOff();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            newCellLoc.setStateInvalid();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            setSignalStrengthDefaultValues();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            mGotCountryCode = false;
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            pollStateDone();
            //End case RADIO_OFF 
            //Begin case default 
            cm.getOperator(obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));
            //End case default 
            //Begin case default 
            cm.getVoiceRegistrationState(obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA,
                        pollingContext));
            //End case default 
            //Begin case default 
            int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                        .getContentResolver(),
                        android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                        RILConstants.PREFERRED_NETWORK_MODE);
            //End case default 
            //Begin case default 
            log("pollState: network mode here is = " + networkMode);
            //End case default 
            //Begin case default 
            {
                cm.getDataRegistrationState(obtainMessage(EVENT_POLL_STATE_GPRS,
                                                pollingContext));
            } //End block
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.908 -0400", hash_original_method = "8C8D67873F7E3A192C41A2E8D9515387", hash_generated_method = "D748003FB367E85D656CBC72490FF59A")
    @Override
    protected void pollStateDone() {
        {
            boolean var85740719351D67237F92A95FD3ABA8BA_1141788373 = (mLteSS.getState() == ServiceState.STATE_IN_SERVICE);
            {
                newNetworkType = mLteSS.getRadioTechnology();
                mNewDataConnectionState = mLteSS.getState();
                newSS.setRadioTechnology(newNetworkType);
                log("pollStateDone LTE/eHRPD STATE_IN_SERVICE newNetworkType = " + newNetworkType);
            } //End block
            {
                newNetworkType = newSS.getRadioTechnology();
                mNewDataConnectionState = radioTechnologyToDataServiceState(newNetworkType);
                log("pollStateDone CDMA STATE_IN_SERVICE newNetworkType = " + newNetworkType +
                " mNewDataConnectionState = " + mNewDataConnectionState);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF8098F829C01844ABD87B8B4A0FC9D4A_1358344922 = (newSS.getState() == ServiceState.STATE_OUT_OF_SERVICE);
            {
                int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                                  .getContentResolver(),
                                  android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                                  RILConstants.PREFERRED_NETWORK_MODE);
                {
                    log("pollState: LTE Only mode");
                    newSS.setState(mLteSS.getState());
                } //End block
            } //End block
        } //End collapsed parenthetic
        log("pollStateDone: oldSS=[" + ss + "] newSS=[" + newSS + "]");
        boolean hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
                && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
                && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionAttached = mDataConnectionState != ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionDetached = mDataConnectionState == ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionChanged = mDataConnectionState != mNewDataConnectionState;
        boolean hasNetworkTypeChanged = networkType != newNetworkType;
        boolean hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged = !newCellLoc.equals(cellLoc);
        boolean has4gHandoff = mNewDataConnectionState == ServiceState.STATE_IN_SERVICE &&
                (((networkType == ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) ||
                 ((networkType == ServiceState.RADIO_TECHNOLOGY_EHRPD) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE)));
        boolean hasMultiApnSupport = (((newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE) ||
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) &&
                 ((networkType != ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (networkType != ServiceState.RADIO_TECHNOLOGY_EHRPD)));
        boolean hasLostMultiApnSupport = ((newNetworkType >= ServiceState.RADIO_TECHNOLOGY_IS95A) &&
             (newNetworkType <= ServiceState.RADIO_TECHNOLOGY_EVDO_A));
        {
            log("pollStateDone:"
                + " hasRegistered=" + hasRegistered
                + " hasDeegistered=" + hasDeregistered
                + " hasCdmaDataConnectionAttached=" + hasCdmaDataConnectionAttached
                + " hasCdmaDataConnectionDetached=" + hasCdmaDataConnectionDetached
                + " hasCdmaDataConnectionChanged=" + hasCdmaDataConnectionChanged
                + " hasNetworkTypeChanged = " + hasNetworkTypeChanged
                + " hasChanged=" + hasChanged
                + " hasRoamingOn=" + hasRoamingOn
                + " hasRoamingOff=" + hasRoamingOff
                + " hasLocationChanged=" + hasLocationChanged
                + " has4gHandoff = " + has4gHandoff
                + " hasMultiApnSupport=" + hasMultiApnSupport
                + " hasLostMultiApnSupport=" + hasLostMultiApnSupport);
        } //End block
        {
            boolean varFBC93C93BF6E0681C0D933A82F5AF355_445347951 = (ss.getState() != newSS.getState()
                || mDataConnectionState != mNewDataConnectionState);
            {
                EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE, ss.getState(),
                    mDataConnectionState, newSS.getState(), mNewDataConnectionState);
            } //End block
        } //End collapsed parenthetic
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        mLteSS.setStateOutOfService();
        {
            log("GsmDataConnectionTracker Created");
            phone.mDataConnectionTracker.dispose();
            phone.mDataConnectionTracker = new GsmDataConnectionTracker(mCdmaLtePhone);
        } //End block
        {
            log("GsmDataConnectionTracker disposed");
            phone.mDataConnectionTracker.dispose();
            phone.mDataConnectionTracker = new CdmaDataConnectionTracker(phone);
        } //End block
        CdmaCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
        mDataConnectionState = mNewDataConnectionState;
        networkType = newNetworkType;
        newSS.setStateOutOfService();
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        } //End block
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            {
                boolean var72283BC64009A3DEA26FA3DDFEC94971_1192820151 = (phone.isEriFileLoaded());
                {
                    String eriText;
                    {
                        boolean var0782B3C53497F07CDAB38A690B362545_966131158 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
                        {
                            eriText = phone.getCdmaEriText();
                        } //End block
                        {
                            eriText = phone.getContext()
                            .getText(com.android.internal.R.string.roamingTextSearching).toString();
                        } //End block
                    } //End collapsed parenthetic
                    ss.setOperatorAlphaLong(eriText);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var12C9A31E4BF3A482FBF5E32FA9877B39_1467777606 = (cm.getSimState().isSIMReady());
                {
                    boolean showSpn = ((CdmaLteUiccRecords)phone.mIccRecords).getCsimSpnDisplayCondition();
                    int iconIndex = ss.getCdmaEriIconIndex();
                    {
                        boolean var3546F4D93F8FF71613BC20AED7ABF5DE_1544904549 = (showSpn && (iconIndex == EriInfo.ROAMING_INDICATOR_OFF) &&
                    isInHomeSidNid(ss.getSystemId(), ss.getNetworkId()));
                        {
                            ss.setOperatorAlphaLong(phone.mIccRecords.getServiceProviderName());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            String operatorNumeric;
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } //End block
            {
                String isoCountryCode = "";
                try 
                {
                    isoCountryCode = MccTable.countryCodeForMcc(Integer.parseInt(operatorNumeric
                            .substring(0, 3)));
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } //End block
                catch (StringIndexOutOfBoundsException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } //End block
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY,
                        isoCountryCode);
                mGotCountryCode = true;
                {
                    fixTimeZone(isoCountryCode);
                } //End block
            } //End block
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");
            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        } //End block
        {
            mAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            mDetachedRegistrants.notifyRegistrants();
        } //End block
        {
            phone.notifyDataConnection(null);
        } //End block
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } //End block
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } //End block
        {
            phone.notifyLocationChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.909 -0400", hash_original_method = "0ED1F162D4C144EF609907545C4226C8", hash_generated_method = "496A0A7CC323B7A4ED8669AA0EAC3219")
    @Override
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SignalStrength oldSignalStrength = mSignalStrength;
        {
            setSignalStrengthDefaultValues();
        } //End block
        {
            int[] ints = (int[])ar.result;
            int lteCqi = 99;
            int lteRsrp = -1;
            int lteRssi = 99;
            int offset = 2;
            int cdmaDbm;
            cdmaDbm = -ints[offset];
            cdmaDbm = -120;
            int cdmaEcio;
            cdmaEcio = -ints[offset + 1];
            cdmaEcio = -160;
            int evdoRssi;
            evdoRssi = -ints[offset + 2];
            evdoRssi = -120;
            int evdoEcio;
            evdoEcio = -ints[offset + 3];
            evdoEcio = -1;
            int evdoSnr;
            evdoSnr = ints[offset + 4];
            evdoSnr = -1;
            {
                lteRssi = (ints[offset + 5] >= 0) ? ints[offset + 5] : 99;
                lteRsrp = (ints[offset + 6] < 0) ? ints[offset + 6] : -1;
                lteCqi = (ints[offset + 7] >= 0) ? ints[offset + 7] : 99;
            } //End block
            {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, false);
            } //End block
            {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, lteRssi, lteRsrp, -1, -1, lteCqi, true);
            } //End block
        } //End block
        try 
        {
            phone.notifySignalStrength();
        } //End block
        catch (NullPointerException ex)
        {
            loge("onSignalStrengthResult() Phone already destroyed: " + ex
                    + "SignalStrength not notified");
        } //End block
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.910 -0400", hash_original_method = "020897B26D59971A2D338DF9E45E01F9", hash_generated_method = "6CE26747CE1BC50A385A86CD05C13DE6")
    @Override
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291140850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291140850;
        // ---------- Original Method ----------
        //return (networkType == ServiceState.RADIO_TECHNOLOGY_LTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.910 -0400", hash_original_method = "CF88CF61D429A57A2B7C32EDDBA3E37B", hash_generated_method = "3DF3F566886B637200EE2BBA4F925211")
    private boolean isInHomeSidNid(int sid, int nid) {
        {
            boolean var8DFAF15637FBBDA85495DB9127D9BC24_1909581457 = (isSidsAllZeros());
        } //End collapsed parenthetic
        {
            int i = 0;
        } //End collapsed parenthetic
        addTaint(sid);
        addTaint(nid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975335344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975335344;
        // ---------- Original Method ----------
        //if (isSidsAllZeros()) return true;
        //if (mHomeSystemId.length != mHomeNetworkId.length) return true;
        //if (sid == 0) return true;
        //for (int i = 0; i < mHomeSystemId.length; i++) {
            //if ((mHomeSystemId[i] == sid) &&
                //((mHomeNetworkId[i] == 0) || (mHomeNetworkId[i] == 65535) ||
                 //(nid == 0) || (nid == 65535) || (mHomeNetworkId[i] == nid))) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.911 -0400", hash_original_method = "3CA2CE2F434AACC848657E54771E66A4", hash_generated_method = "BCEA2E1D20D832C750B189C41E37C215")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaLteSST] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.911 -0400", hash_original_method = "CE31FBC457ABF05FA318FEB73DCA10E2", hash_generated_method = "9CAD79F5F2E82C48926C38487323D3F6")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
}

