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
    CDMALTEPhone mCdmaLtePhone;
    private ServiceState  mLteSS;
    private boolean mNeedToRegForSimLoaded = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.516 -0400", hash_original_method = "47593605762760CA14FD5EED8D416F47", hash_generated_method = "120D2620EC673327380F747E6972D98A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaLteServiceStateTracker(CDMALTEPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        mLteSS = new ServiceState();
        log("CdmaLteServiceStateTracker Constructors");
        // ---------- Original Method ----------
        //cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        //mCdmaLtePhone = phone;
        //mLteSS = new ServiceState();
        //if (DBG) log("CdmaLteServiceStateTracker Constructors");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.516 -0400", hash_original_method = "E8B96682BA406A5B61C3BDB5E6938EBA", hash_generated_method = "C9E65A83CD4B2E304C5D2B05ECCE7357")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        cm.unregisterForSIMReady(this);
        super.dispose();
        // ---------- Original Method ----------
        //cm.unregisterForSIMReady(this);
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.518 -0400", hash_original_method = "D5AC4DEC3B42E743000565D518230B6D", hash_generated_method = "04F7EC646AD6518E13C7D0E0D58D6674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        CdmaLteUiccRecords sim;
        sim = (CdmaLteUiccRecords)phone.mIccRecords;
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        {
            boolean var9D34BD6BCEA8823A6E7690D862CEC2C3_1499368306 = ((sim != null) && sim.isProvisioned());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.519 -0400", hash_original_method = "F7DAEBCFC7E85FA3AD1692EAA757E22A", hash_generated_method = "35F1B7B55C195478C93E750CB3E32075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setCdmaTechnology(int radioTechnology) {
        dsTaint.addTaint(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        // ---------- Original Method ----------
        //newSS.setRadioTechnology(radioTechnology);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.521 -0400", hash_original_method = "DA636A49D82699419B2FBA1150F1CBEF", hash_generated_method = "70B25FD4FB870917F427C81CFC97A752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(ar.dsTaint);
        {
            log("handlePollStateResultMessage: EVENT_POLL_STATE_GPRS");
            String states[];
            states = (String[])ar.result;
            int type;
            type = 0;
            int regState;
            regState = -1;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.522 -0400", hash_original_method = "1D3F6C65DB762B56FF7135205F7AED1D", hash_generated_method = "8AE901A925E2CCBCE4B512603BBA39AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, SignalStrength.INVALID_SNR, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1,
                //-1, -1, -1, SignalStrength.INVALID_SNR, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.523 -0400", hash_original_method = "B583B233911BF73B0CF330862869CA80", hash_generated_method = "6965B02E4485AD281C0D39CB865F1054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1098881813 = (cm.getRadioState());
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
            int networkMode;
            networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.525 -0400", hash_original_method = "8C8D67873F7E3A192C41A2E8D9515387", hash_generated_method = "DDE9FD6BCDBAF1DC2EB8806EE9785F37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void pollStateDone() {
        {
            boolean var85740719351D67237F92A95FD3ABA8BA_1272498423 = (mLteSS.getState() == ServiceState.STATE_IN_SERVICE);
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
            boolean varF8098F829C01844ABD87B8B4A0FC9D4A_37392578 = (newSS.getState() == ServiceState.STATE_OUT_OF_SERVICE);
            {
                int networkMode;
                networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
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
        boolean hasRegistered;
        hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
                && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered;
        hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
                && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionAttached;
        hasCdmaDataConnectionAttached = mDataConnectionState != ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionDetached;
        hasCdmaDataConnectionDetached = mDataConnectionState == ServiceState.STATE_IN_SERVICE
                && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionChanged;
        hasCdmaDataConnectionChanged = mDataConnectionState != mNewDataConnectionState;
        boolean hasNetworkTypeChanged;
        hasNetworkTypeChanged = networkType != newNetworkType;
        boolean hasChanged;
        hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn;
        hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff;
        hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged;
        hasLocationChanged = !newCellLoc.equals(cellLoc);
        boolean has4gHandoff;
        has4gHandoff = mNewDataConnectionState == ServiceState.STATE_IN_SERVICE &&
                (((networkType == ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) ||
                 ((networkType == ServiceState.RADIO_TECHNOLOGY_EHRPD) &&
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE)));
        boolean hasMultiApnSupport;
        hasMultiApnSupport = (((newNetworkType == ServiceState.RADIO_TECHNOLOGY_LTE) ||
                  (newNetworkType == ServiceState.RADIO_TECHNOLOGY_EHRPD)) &&
                 ((networkType != ServiceState.RADIO_TECHNOLOGY_LTE) &&
                  (networkType != ServiceState.RADIO_TECHNOLOGY_EHRPD)));
        boolean hasLostMultiApnSupport;
        hasLostMultiApnSupport = ((newNetworkType >= ServiceState.RADIO_TECHNOLOGY_IS95A) &&
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
            boolean varFBC93C93BF6E0681C0D933A82F5AF355_1677825819 = (ss.getState() != newSS.getState()
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
        CdmaCellLocation tcl;
        tcl = cellLoc;
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
                boolean var72283BC64009A3DEA26FA3DDFEC94971_569674847 = (phone.isEriFileLoaded());
                {
                    String eriText;
                    {
                        boolean var0782B3C53497F07CDAB38A690B362545_1599506219 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
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
                boolean var12C9A31E4BF3A482FBF5E32FA9877B39_649764979 = (cm.getSimState().isSIMReady());
                {
                    boolean showSpn;
                    showSpn = ((CdmaLteUiccRecords)phone.mIccRecords).getCsimSpnDisplayCondition();
                    int iconIndex;
                    iconIndex = ss.getCdmaEriIconIndex();
                    {
                        boolean var3546F4D93F8FF71613BC20AED7ABF5DE_512945403 = (showSpn && (iconIndex == EriInfo.ROAMING_INDICATOR_OFF) &&
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
                String isoCountryCode;
                isoCountryCode = "";
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.527 -0400", hash_original_method = "8D30BBD98AE13644E5394C7E27460D08", hash_generated_method = "72ED88178F14AD9DF63806B4D3570F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
        SignalStrength oldSignalStrength;
        oldSignalStrength = mSignalStrength;
        {
            setSignalStrengthDefaultValues();
        } //End block
        {
            int[] ints;
            ints = (int[])ar.result;
            int lteRssi;
            lteRssi = -1;
            int lteRsrp;
            lteRsrp = -1;
            int lteRsrq;
            lteRsrq = -1;
            int lteRssnr;
            lteRssnr = SignalStrength.INVALID_SNR;
            int lteCqi;
            lteCqi = -1;
            int offset;
            offset = 2;
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
                lteRssi = ints[offset+5];
                lteRsrp = ints[offset+6];
                lteRsrq = ints[offset+7];
                lteRssnr = ints[offset+8];
                lteCqi = ints[offset+9];
            } //End block
            {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, false);
            } //End block
            {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, lteRssi, lteRsrp, lteRsrq, lteRssnr, lteCqi, true);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.527 -0400", hash_original_method = "020897B26D59971A2D338DF9E45E01F9", hash_generated_method = "EE2A2B72EEE425983518F98478C5BB15")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isConcurrentVoiceAndDataAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (networkType == ServiceState.RADIO_TECHNOLOGY_LTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.527 -0400", hash_original_method = "CF88CF61D429A57A2B7C32EDDBA3E37B", hash_generated_method = "9E15F33F003545436AAA71F6D935CE17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isInHomeSidNid(int sid, int nid) {
        dsTaint.addTaint(sid);
        dsTaint.addTaint(nid);
        {
            boolean var8DFAF15637FBBDA85495DB9127D9BC24_628463319 = (isSidsAllZeros());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.527 -0400", hash_original_method = "3CA2CE2F434AACC848657E54771E66A4", hash_generated_method = "ADF8B0045CF03CFB6A862DBC3FDFFA7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CdmaLteSST] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.528 -0400", hash_original_method = "CE31FBC457ABF05FA318FEB73DCA10E2", hash_generated_method = "046D9473D323F5CA8846AEB7EF855922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
}

