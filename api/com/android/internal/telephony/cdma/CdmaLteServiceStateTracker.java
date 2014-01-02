package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.AsyncResult;
import android.os.Message;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.util.EventLog;
import android.util.Log;

import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.gsm.GsmDataConnectionTracker;






public class CdmaLteServiceStateTracker extends CdmaServiceStateTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.448 -0500", hash_original_field = "879F4AF456AD7D7A9BB5520F0BAD6F62", hash_generated_field = "879F4AF456AD7D7A9BB5520F0BAD6F62")

    CDMALTEPhone mCdmaLtePhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.450 -0500", hash_original_field = "30863065C53EF2AE7F6D6E713A334376", hash_generated_field = "CCE1FE524FD9420E4F8B07A4C62521E0")


    private ServiceState  mLteSS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.453 -0500", hash_original_field = "C7C433963F4B4A5906B8318911ECA31F", hash_generated_field = "33DD1D28F358EBB2DB6B0718CE46393E")

    private boolean mNeedToRegForSimLoaded = true;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.455 -0500", hash_original_method = "47593605762760CA14FD5EED8D416F47", hash_generated_method = "B56056DFB2764A7F316092A36DCAAC40")
    
public CdmaLteServiceStateTracker(CDMALTEPhone phone) {
        super(phone);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        mCdmaLtePhone = phone;

        mLteSS = new ServiceState();
        if (DBG) log("CdmaLteServiceStateTracker Constructors");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.458 -0500", hash_original_method = "E8B96682BA406A5B61C3BDB5E6938EBA", hash_generated_method = "8CD85EC22F318208A04AAAAA6FBC67F9")
    
@Override
    public void dispose() {
        cm.unregisterForSIMReady(this);
        super.dispose();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.461 -0500", hash_original_method = "D5AC4DEC3B42E743000565D518230B6D", hash_generated_method = "175356D8D372E9D980766052FA5AC179")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        int[] ints;
        String[] strings;
        switch (msg.what) {
        case EVENT_POLL_STATE_GPRS:
            if (DBG) log("handleMessage EVENT_POLL_STATE_GPRS");
            ar = (AsyncResult)msg.obj;
            handlePollStateResult(msg.what, ar);
            break;
        case EVENT_SIM_READY:
            if (DBG) log("handleMessage EVENT_SIM_READY");
            isSubscriptionFromRuim = false;
            // Register SIM_RECORDS_LOADED dynamically.
            // This is to avoid confilct with RUIM_READY scenario)
            if (mNeedToRegForSimLoaded) {
                phone.mIccRecords.registerForRecordsLoaded(this, EVENT_SIM_RECORDS_LOADED, null);
                mNeedToRegForSimLoaded = false;
            }
            pollState();
            // Signal strength polling stops when radio is off.
            queueNextSignalStrengthPoll();

            // load ERI file
            phone.prepareEri();
            break;
        case EVENT_SIM_RECORDS_LOADED:
            CdmaLteUiccRecords sim = (CdmaLteUiccRecords)phone.mIccRecords;
            if ((sim != null) && sim.isProvisioned()) {
                mMdn = sim.getMdn();
                mMin = sim.getMin();
                parseSidNid(sim.getSid(), sim.getNid());
                mPrlVersion = sim.getPrlVersion();;
                mIsMinInfoReady = true;
                updateOtaspState();
            }
            // SID/NID/PRL is loaded. Poll service state
            // again to update to the roaming state with
            // the latest variables.
            pollState();
            break;
        default:
            super.handleMessage(msg);
        }
    }

    /**
     * Set the cdmaSS for EVENT_POLL_STATE_REGISTRATION_CDMA
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.463 -0500", hash_original_method = "F7DAEBCFC7E85FA3AD1692EAA757E22A", hash_generated_method = "0F2F03D179DB5107AF9DDE5CA61A118A")
    
@Override
    protected void setCdmaTechnology(int radioTechnology) {
        // Called on voice registration state response.
        // Just record new CDMA radio technology
        newSS.setRadioTechnology(radioTechnology);
    }

    /**
     * Handle the result of one of the pollState()-related requests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.466 -0500", hash_original_method = "DA636A49D82699419B2FBA1150F1CBEF", hash_generated_method = "F667FE431F48E013D6A55B3947BBB1B2")
    
@Override
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        if (what == EVENT_POLL_STATE_GPRS) {
            if (DBG) log("handlePollStateResultMessage: EVENT_POLL_STATE_GPRS");
            String states[] = (String[])ar.result;

            int type = 0;
            int regState = -1;
            if (states.length > 0) {
                try {
                    regState = Integer.parseInt(states[0]);

                    // states[3] (if present) is the current radio technology
                    if (states.length >= 4 && states[3] != null) {
                        type = Integer.parseInt(states[3]);
                    }
                } catch (NumberFormatException ex) {
                    loge("handlePollStateResultMessage: error parsing GprsRegistrationState: "
                                    + ex);
                }
            }

            mLteSS.setRadioTechnology(type);
            mLteSS.setState(regCodeToServiceState(regState));
        } else {
            super.handlePollStateResultMessage(what, ar);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.469 -0500", hash_original_method = "10E4D98F7F6A52C0BD2C384AE2F36499", hash_generated_method = "EE52FB270FB21FA9B7391BE3FCC699CC")
    
@Override
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.472 -0500", hash_original_method = "B583B233911BF73B0CF330862869CA80", hash_generated_method = "35A2F7BAE98F1B1784CDE3149FE1C049")
    
@Override
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;

        switch (cm.getRadioState()) {
            case RADIO_UNAVAILABLE:
                newSS.setStateOutOfService();
                newCellLoc.setStateInvalid();
                setSignalStrengthDefaultValues();
                mGotCountryCode = false;

                pollStateDone();
                break;

            case RADIO_OFF:
                newSS.setStateOff();
                newCellLoc.setStateInvalid();
                setSignalStrengthDefaultValues();
                mGotCountryCode = false;

                pollStateDone();
                break;

            default:
                // Issue all poll-related commands at once, then count
                // down the responses which are allowed to arrive
                // out-of-order.

                pollingContext[0]++;
                // RIL_REQUEST_OPERATOR is necessary for CDMA
                cm.getOperator(obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));

                pollingContext[0]++;
                // RIL_REQUEST_VOICE_REGISTRATION_STATE is necessary for CDMA
                cm.getVoiceRegistrationState(obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA,
                        pollingContext));

                int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                        .getContentResolver(),
                        android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                        RILConstants.PREFERRED_NETWORK_MODE);
                if (DBG) log("pollState: network mode here is = " + networkMode);
                if ((networkMode == RILConstants.NETWORK_MODE_GLOBAL)
                        || (networkMode == RILConstants.NETWORK_MODE_LTE_ONLY)) {
                    pollingContext[0]++;
                    // RIL_REQUEST_DATA_REGISTRATION_STATE
                    cm.getDataRegistrationState(obtainMessage(EVENT_POLL_STATE_GPRS,
                                                pollingContext));
                }
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.479 -0500", hash_original_method = "8C8D67873F7E3A192C41A2E8D9515387", hash_generated_method = "96F36937C3740CD00970039902AD023C")
    
@Override
    protected void pollStateDone() {
        // determine data NetworkType from both LET and CDMA SS
        if (mLteSS.getState() == ServiceState.STATE_IN_SERVICE) {
            //in LTE service
            newNetworkType = mLteSS.getRadioTechnology();
            mNewDataConnectionState = mLteSS.getState();
            newSS.setRadioTechnology(newNetworkType);
            log("pollStateDone LTE/eHRPD STATE_IN_SERVICE newNetworkType = " + newNetworkType);
        } else {
            // LTE out of service, get CDMA Service State
            newNetworkType = newSS.getRadioTechnology();
            mNewDataConnectionState = radioTechnologyToDataServiceState(newNetworkType);
            log("pollStateDone CDMA STATE_IN_SERVICE newNetworkType = " + newNetworkType +
                " mNewDataConnectionState = " + mNewDataConnectionState);
        }

        // TODO: Add proper support for LTE Only, we should be looking at
        //       the preferred network mode, to know when newSS state should
        //       be coming from mLteSs state. This was needed to pass a VZW
        //       LTE Only test.
        //
        // If CDMA service is OOS, double check if the device is running with LTE only
        // mode. If that is the case, derive the service state from LTE side.
        // To set in LTE only mode, sqlite3 /data/data/com.android.providers.settings/
        // databases/settings.db "update secure set value='11' where name='preferred_network_mode'"
        if (newSS.getState() == ServiceState.STATE_OUT_OF_SERVICE) {
            int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                                  .getContentResolver(),
                                  android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                                  RILConstants.PREFERRED_NETWORK_MODE);
            if (networkMode == RILConstants.NETWORK_MODE_LTE_ONLY) {
                if (DBG) log("pollState: LTE Only mode");
                newSS.setState(mLteSS.getState());
            }
        }

        if (DBG) log("pollStateDone: oldSS=[" + ss + "] newSS=[" + newSS + "]");

        boolean hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
                && newSS.getState() == ServiceState.STATE_IN_SERVICE;

        boolean hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
                && newSS.getState() != ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionAttached =
            mDataConnectionState != ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionDetached =
            mDataConnectionState == ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionChanged =
            mDataConnectionState != mNewDataConnectionState;

        boolean hasNetworkTypeChanged = networkType != newNetworkType;

        boolean hasChanged = !newSS.equals(ss);

        boolean hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();

        boolean hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();

        boolean hasLocationChanged = !newCellLoc.equals(cellLoc);

        boolean has4gHandoff =
                mNewDataConnectionState == ServiceState.STATE_IN_SERVICE &&
                (((networkType == ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) ||
                 ((networkType == ServiceState.RADIO_TECHNOLOGY_EHRPD) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE)));

        boolean hasMultiApnSupport =
                (((newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE) ||
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) &&
                 ((networkType != ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (networkType != ServiceState.RADIO_TECHNOLOGY_EHRPD)));

        boolean hasLostMultiApnSupport =
            ((newNetworkType >= ServiceState.RADIO_TECHNOLOGY_IS95A) &&
             (newNetworkType <= ServiceState.RADIO_TECHNOLOGY_EVDO_A));

        if (DBG) {
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
        }
        // Add an event log when connection state changes
        if (ss.getState() != newSS.getState()
                || mDataConnectionState != mNewDataConnectionState) {
            EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE, ss.getState(),
                    mDataConnectionState, newSS.getState(), mNewDataConnectionState);
        }

        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        // clean slate for next time
        newSS.setStateOutOfService();
        mLteSS.setStateOutOfService();

        if ((hasMultiApnSupport)
                && (phone.mDataConnectionTracker instanceof CdmaDataConnectionTracker)) {
            if (DBG) log("GsmDataConnectionTracker Created");
            phone.mDataConnectionTracker.dispose();
            phone.mDataConnectionTracker = new GsmDataConnectionTracker(mCdmaLtePhone);
        }

        if ((hasLostMultiApnSupport)
                && (phone.mDataConnectionTracker instanceof GsmDataConnectionTracker)) {
            if (DBG)log("GsmDataConnectionTracker disposed");
            phone.mDataConnectionTracker.dispose();
            phone.mDataConnectionTracker = new CdmaDataConnectionTracker(phone);
        }

        CdmaCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;

        mDataConnectionState = mNewDataConnectionState;
        networkType = newNetworkType;

        newSS.setStateOutOfService(); // clean slate for next time

        if (hasNetworkTypeChanged) {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        }

        if (hasRegistered) {
            mNetworkAttachedRegistrants.notifyRegistrants();
        }

        if (hasChanged) {
            if (phone.isEriFileLoaded()) {
                String eriText;
                // Now the CDMAPhone sees the new ServiceState so it can get the
                // new ERI text
                if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
                    eriText = phone.getCdmaEriText();
                } else {
                    // Note that ServiceState.STATE_OUT_OF_SERVICE is valid used
                    // for
                    // mRegistrationState 0,2,3 and 4
                    eriText = phone.getContext()
                            .getText(com.android.internal.R.string.roamingTextSearching).toString();
                }
                ss.setOperatorAlphaLong(eriText);
            }

            if (cm.getSimState().isSIMReady()) {
                // SIM is found on the device. If ERI roaming is OFF and SID/NID matches
                // one configfured in SIM, use operator name from CSIM record.
                boolean showSpn =
                    ((CdmaLteUiccRecords)phone.mIccRecords).getCsimSpnDisplayCondition();
                int iconIndex = ss.getCdmaEriIconIndex();

                if (showSpn && (iconIndex == EriInfo.ROAMING_INDICATOR_OFF) &&
                    isInHomeSidNid(ss.getSystemId(), ss.getNetworkId())) {
                    ss.setOperatorAlphaLong(phone.mIccRecords.getServiceProviderName());
                }
            }

            String operatorNumeric;

            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());

            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);

            if (operatorNumeric == null) {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } else {
                String isoCountryCode = "";
                try {
                    isoCountryCode = MccTable.countryCodeForMcc(Integer.parseInt(operatorNumeric
                            .substring(0, 3)));
                } catch (NumberFormatException ex) {
                    loge("countryCodeForMcc error" + ex);
                } catch (StringIndexOutOfBoundsException ex) {
                    loge("countryCodeForMcc error" + ex);
                }

                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY,
                        isoCountryCode);
                mGotCountryCode = true;
                if (mNeedFixZone) {
                    fixTimeZone(isoCountryCode);
                }
            }

            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");

            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        }

        if (hasCdmaDataConnectionAttached || has4gHandoff) {
            mAttachedRegistrants.notifyRegistrants();
        }

        if (hasCdmaDataConnectionDetached) {
            mDetachedRegistrants.notifyRegistrants();
        }

        if ((hasCdmaDataConnectionChanged || hasNetworkTypeChanged)) {
            phone.notifyDataConnection(null);
        }

        if (hasRoamingOn) {
            mRoamingOnRegistrants.notifyRegistrants();
        }

        if (hasRoamingOff) {
            mRoamingOffRegistrants.notifyRegistrants();
        }

        if (hasLocationChanged) {
            phone.notifyLocationChanged();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.484 -0500", hash_original_method = "0ED1F162D4C144EF609907545C4226C8", hash_generated_method = "602FD629C257ACC57CBB9E3A7CA58384")
    
@Override
    protected void onSignalStrengthResult(AsyncResult ar) {
        SignalStrength oldSignalStrength = mSignalStrength;

        if (ar.exception != null) {
            // Most likely radio is resetting/disconnected change to default
            // values.
            setSignalStrengthDefaultValues();
        } else {
            int[] ints = (int[])ar.result;
            int lteCqi = 99, lteRsrp = -1;
            int lteRssi = 99;
            int offset = 2;
            int cdmaDbm = (ints[offset] > 0) ? -ints[offset] : -120;
            int cdmaEcio = (ints[offset + 1] > 0) ? -ints[offset + 1] : -160;
            int evdoRssi = (ints[offset + 2] > 0) ? -ints[offset + 2] : -120;
            int evdoEcio = (ints[offset + 3] > 0) ? -ints[offset + 3] : -1;
            int evdoSnr = ((ints[offset + 4] > 0) && (ints[offset + 4] <= 8)) ? ints[offset + 4]
                    : -1;
            if (networkType == ServiceState.RADIO_TECHNOLOGY_LTE) {
                lteRssi = (ints[offset + 5] >= 0) ? ints[offset + 5] : 99;
                lteRsrp = (ints[offset + 6] < 0) ? ints[offset + 6] : -1;
                lteCqi = (ints[offset + 7] >= 0) ? ints[offset + 7] : 99;
            }

            if (networkType != ServiceState.RADIO_TECHNOLOGY_LTE) {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, false);
            } else {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, lteRssi, lteRsrp, -1, -1, lteCqi, true);
            }
        }

        try {
            phone.notifySignalStrength();
        } catch (NullPointerException ex) {
            loge("onSignalStrengthResult() Phone already destroyed: " + ex
                    + "SignalStrength not notified");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.486 -0500", hash_original_method = "020897B26D59971A2D338DF9E45E01F9", hash_generated_method = "C4DFBDDC6593B307B9173E8F4B98AFE9")
    
@Override
    public boolean isConcurrentVoiceAndDataAllowed() {
        // Note: it needs to be confirmed which CDMA network types
        // can support voice and data calls concurrently.
        // For the time-being, the return value will be false.
        return (networkType == ServiceState.RADIO_TECHNOLOGY_LTE);
    }

    /**
     * Check whether the specified SID and NID pair appears in the HOME SID/NID list
     * read from NV or SIM.
     *
     * @return true if provided sid/nid pair belongs to operator's home network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.489 -0500", hash_original_method = "CF88CF61D429A57A2B7C32EDDBA3E37B", hash_generated_method = "BC0C7568898C2FF324345168E2B73A7D")
    
private boolean isInHomeSidNid(int sid, int nid) {
        // if SID/NID is not available, assume this is home network.
        if (isSidsAllZeros()) return true;

        // length of SID/NID shold be same
        if (mHomeSystemId.length != mHomeNetworkId.length) return true;

        if (sid == 0) return true;

        for (int i = 0; i < mHomeSystemId.length; i++) {
            // Use SID only if NID is a reserved value.
            // SID 0 and NID 0 and 65535 are reserved. (C.0005 2.6.5.2)
            if ((mHomeSystemId[i] == sid) &&
                ((mHomeNetworkId[i] == 0) || (mHomeNetworkId[i] == 65535) ||
                 (nid == 0) || (nid == 65535) || (mHomeNetworkId[i] == nid))) {
                return true;
            }
        }
        // SID/NID are not in the list. So device is not in home network
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.492 -0500", hash_original_method = "3CA2CE2F434AACC848657E54771E66A4", hash_generated_method = "C9DA0BC0F5BE642C8EDCEAFD0D2068AE")
    
@Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaLteSST] " + s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.494 -0500", hash_original_method = "CE31FBC457ABF05FA318FEB73DCA10E2", hash_generated_method = "A57137CA1176F14542C6B8BD6FFDE6A6")
    
@Override
    protected void loge(String s) {
        Log.e(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
}

