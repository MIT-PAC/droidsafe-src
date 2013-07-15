package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.494 -0400", hash_original_field = "B5F20DF0028332D17F33E3BF40040A23", hash_generated_field = "879F4AF456AD7D7A9BB5520F0BAD6F62")

    CDMALTEPhone mCdmaLtePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.494 -0400", hash_original_field = "422A4AE190845160AC9AC0B750445158", hash_generated_field = "CCE1FE524FD9420E4F8B07A4C62521E0")

    private ServiceState mLteSS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.494 -0400", hash_original_field = "8F9DBE53F0380067CC21F8BCAF3A13AB", hash_generated_field = "33DD1D28F358EBB2DB6B0718CE46393E")

    private boolean mNeedToRegForSimLoaded = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.494 -0400", hash_original_method = "47593605762760CA14FD5EED8D416F47", hash_generated_method = "8CC02D5856489478DBA476AA6E781FDD")
    public  CdmaLteServiceStateTracker(CDMALTEPhone phone) {
        super(phone);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        mCdmaLtePhone = phone;
        mLteSS = new ServiceState();
    if(DBG)        
        log("CdmaLteServiceStateTracker Constructors");
        // ---------- Original Method ----------
        //cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        //mCdmaLtePhone = phone;
        //mLteSS = new ServiceState();
        //if (DBG) log("CdmaLteServiceStateTracker Constructors");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.495 -0400", hash_original_method = "E8B96682BA406A5B61C3BDB5E6938EBA", hash_generated_method = "C9E65A83CD4B2E304C5D2B05ECCE7357")
    @Override
    public void dispose() {
        cm.unregisterForSIMReady(this);
        super.dispose();
        // ---------- Original Method ----------
        //cm.unregisterForSIMReady(this);
        //super.dispose();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.496 -0400", hash_original_method = "D5AC4DEC3B42E743000565D518230B6D", hash_generated_method = "99F6F9E45C1260AD764C2BCE0C13A713")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        int[] ints;
        String[] strings;
switch(msg.what){
        case EVENT_POLL_STATE_GPRS:
    if(DBG)        
        log("handleMessage EVENT_POLL_STATE_GPRS");
        ar = (AsyncResult)msg.obj;
        handlePollStateResult(msg.what, ar);
        break;
        case EVENT_SIM_READY:
    if(DBG)        
        log("handleMessage EVENT_SIM_READY");
        isSubscriptionFromRuim = false;
    if(mNeedToRegForSimLoaded)        
        {
            phone.mIccRecords.registerForRecordsLoaded(this, EVENT_SIM_RECORDS_LOADED, null);
            mNeedToRegForSimLoaded = false;
        } //End block
        pollState();
        queueNextSignalStrengthPoll();
        phone.prepareEri();
        break;
        case EVENT_SIM_RECORDS_LOADED:
        CdmaLteUiccRecords sim = (CdmaLteUiccRecords)phone.mIccRecords;
    if((sim != null) && sim.isProvisioned())        
        {
            mMdn = sim.getMdn();
            mMin = sim.getMin();
            parseSidNid(sim.getSid(), sim.getNid());
            mPrlVersion = sim.getPrlVersion();
            ;
            mIsMinInfoReady = true;
            updateOtaspState();
        } //End block
        pollState();
        break;
        default:
        super.handleMessage(msg);
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.496 -0400", hash_original_method = "F7DAEBCFC7E85FA3AD1692EAA757E22A", hash_generated_method = "FE6134B3653813226AE2A5A663467FE8")
    @Override
    protected void setCdmaTechnology(int radioTechnology) {
        addTaint(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        // ---------- Original Method ----------
        //newSS.setRadioTechnology(radioTechnology);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.497 -0400", hash_original_method = "DA636A49D82699419B2FBA1150F1CBEF", hash_generated_method = "7EE7351FE073D76A4EE957740A245782")
    @Override
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(what);
    if(what == EVENT_POLL_STATE_GPRS)        
        {
    if(DBG)            
            log("handlePollStateResultMessage: EVENT_POLL_STATE_GPRS");
            String states[] = (String[])ar.result;
            int type = 0;
            int regState = -1;
    if(states.length > 0)            
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
    if(states.length >= 4 && states[3] != null)                    
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
        else
        {
            super.handlePollStateResultMessage(what, ar);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.498 -0400", hash_original_method = "10E4D98F7F6A52C0BD2C384AE2F36499", hash_generated_method = "FE4E9808A03FFE71C90B9C094045E9B6")
    @Override
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.499 -0400", hash_original_method = "B583B233911BF73B0CF330862869CA80", hash_generated_method = "B09C2F3C804DD2D8F311DFE081057E12")
    @Override
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
switch(cm.getRadioState()){
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
        pollingContext[0]++;
        cm.getOperator(obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));
        pollingContext[0]++;
        cm.getVoiceRegistrationState(obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA,
                        pollingContext));
        int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                        .getContentResolver(),
                        android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                        RILConstants.PREFERRED_NETWORK_MODE);
    if(DBG)        
        log("pollState: network mode here is = " + networkMode);
    if((networkMode == RILConstants.NETWORK_MODE_GLOBAL)
                        || (networkMode == RILConstants.NETWORK_MODE_LTE_ONLY))        
        {
            pollingContext[0]++;
            cm.getDataRegistrationState(obtainMessage(EVENT_POLL_STATE_GPRS,
                                                pollingContext));
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.504 -0400", hash_original_method = "8C8D67873F7E3A192C41A2E8D9515387", hash_generated_method = "EF9D54C421B6EC1B80DF5D9F6CA8E789")
    @Override
    protected void pollStateDone() {
    if(mLteSS.getState() == ServiceState.STATE_IN_SERVICE)        
        {
            newNetworkType = mLteSS.getRadioTechnology();
            mNewDataConnectionState = mLteSS.getState();
            newSS.setRadioTechnology(newNetworkType);
            log("pollStateDone LTE/eHRPD STATE_IN_SERVICE newNetworkType = " + newNetworkType);
        } //End block
        else
        {
            newNetworkType = newSS.getRadioTechnology();
            mNewDataConnectionState = radioTechnologyToDataServiceState(newNetworkType);
            log("pollStateDone CDMA STATE_IN_SERVICE newNetworkType = " + newNetworkType +
                " mNewDataConnectionState = " + mNewDataConnectionState);
        } //End block
    if(newSS.getState() == ServiceState.STATE_OUT_OF_SERVICE)        
        {
            int networkMode = android.provider.Settings.Secure.getInt(phone.getContext()
                                  .getContentResolver(),
                                  android.provider.Settings.Secure.PREFERRED_NETWORK_MODE,
                                  RILConstants.PREFERRED_NETWORK_MODE);
    if(networkMode == RILConstants.NETWORK_MODE_LTE_ONLY)            
            {
    if(DBG)                
                log("pollState: LTE Only mode");
                newSS.setState(mLteSS.getState());
            } //End block
        } //End block
    if(DBG)        
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
    if(DBG)        
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
    if(ss.getState() != newSS.getState()
                || mDataConnectionState != mNewDataConnectionState)        
        {
            EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE, ss.getState(),
                    mDataConnectionState, newSS.getState(), mNewDataConnectionState);
        } //End block
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        mLteSS.setStateOutOfService();
    if((hasMultiApnSupport)
                && (phone.mDataConnectionTracker instanceof CdmaDataConnectionTracker))        
        {
    if(DBG)            
            log("GsmDataConnectionTracker Created");
            phone.mDataConnectionTracker.dispose();
            phone.mDataConnectionTracker = new GsmDataConnectionTracker(mCdmaLtePhone);
        } //End block
    if((hasLostMultiApnSupport)
                && (phone.mDataConnectionTracker instanceof GsmDataConnectionTracker))        
        {
    if(DBG)            
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
    if(hasNetworkTypeChanged)        
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        } //End block
    if(hasRegistered)        
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } //End block
    if(hasChanged)        
        {
    if(phone.isEriFileLoaded())            
            {
                String eriText;
    if(ss.getState() == ServiceState.STATE_IN_SERVICE)                
                {
                    eriText = phone.getCdmaEriText();
                } //End block
                else
                {
                    eriText = phone.getContext()
                            .getText(com.android.internal.R.string.roamingTextSearching).toString();
                } //End block
                ss.setOperatorAlphaLong(eriText);
            } //End block
    if(cm.getSimState().isSIMReady())            
            {
                boolean showSpn = ((CdmaLteUiccRecords)phone.mIccRecords).getCsimSpnDisplayCondition();
                int iconIndex = ss.getCdmaEriIconIndex();
    if(showSpn && (iconIndex == EriInfo.ROAMING_INDICATOR_OFF) &&
                    isInHomeSidNid(ss.getSystemId(), ss.getNetworkId()))                
                {
                    ss.setOperatorAlphaLong(phone.mIccRecords.getServiceProviderName());
                } //End block
            } //End block
            String operatorNumeric;
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
    if(operatorNumeric == null)            
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } //End block
            else
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
    if(mNeedFixZone)                
                {
                    fixTimeZone(isoCountryCode);
                } //End block
            } //End block
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");
            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        } //End block
    if(hasCdmaDataConnectionAttached || has4gHandoff)        
        {
            mAttachedRegistrants.notifyRegistrants();
        } //End block
    if(hasCdmaDataConnectionDetached)        
        {
            mDetachedRegistrants.notifyRegistrants();
        } //End block
    if((hasCdmaDataConnectionChanged || hasNetworkTypeChanged))        
        {
            phone.notifyDataConnection(null);
        } //End block
    if(hasRoamingOn)        
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } //End block
    if(hasRoamingOff)        
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } //End block
    if(hasLocationChanged)        
        {
            phone.notifyLocationChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.508 -0400", hash_original_method = "0ED1F162D4C144EF609907545C4226C8", hash_generated_method = "E88F45F59F5F84E8D3ED32B6BEF3371F")
    @Override
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ar.getTaint());
        SignalStrength oldSignalStrength = mSignalStrength;
    if(ar.exception != null)        
        {
            setSignalStrengthDefaultValues();
        } //End block
        else
        {
            int[] ints = (int[])ar.result;
            int lteCqi = 99;
            int lteRsrp = -1;
            int lteRssi = 99;
            int offset = 2;
            int cdmaDbm = (ints[offset] > 0) ? -ints[offset] : -120;
            int cdmaEcio = (ints[offset + 1] > 0) ? -ints[offset + 1] : -160;
            int evdoRssi = (ints[offset + 2] > 0) ? -ints[offset + 2] : -120;
            int evdoEcio = (ints[offset + 3] > 0) ? -ints[offset + 3] : -1;
            int evdoSnr = ((ints[offset + 4] > 0) && (ints[offset + 4] <= 8)) ? ints[offset + 4]
                    : -1;
    if(networkType == ServiceState.RADIO_TECHNOLOGY_LTE)            
            {
                lteRssi = (ints[offset + 5] >= 0) ? ints[offset + 5] : 99;
                lteRsrp = (ints[offset + 6] < 0) ? ints[offset + 6] : -1;
                lteCqi = (ints[offset + 7] >= 0) ? ints[offset + 7] : 99;
            } //End block
    if(networkType != ServiceState.RADIO_TECHNOLOGY_LTE)            
            {
                mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio, evdoRssi, evdoEcio,
                        evdoSnr, false);
            } //End block
            else
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.509 -0400", hash_original_method = "020897B26D59971A2D338DF9E45E01F9", hash_generated_method = "E477066A62B6FDC66E69F17BFDF9DDE6")
    @Override
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var202937DDE9B2F6E32AF932440DA25F83_878618834 = ((networkType == ServiceState.RADIO_TECHNOLOGY_LTE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077528299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077528299;
        // ---------- Original Method ----------
        //return (networkType == ServiceState.RADIO_TECHNOLOGY_LTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.510 -0400", hash_original_method = "CF88CF61D429A57A2B7C32EDDBA3E37B", hash_generated_method = "A621F81841D3ADFD9903A598AF493B9B")
    private boolean isInHomeSidNid(int sid, int nid) {
        addTaint(nid);
        addTaint(sid);
    if(isSidsAllZeros())        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1413300199 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824619484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824619484;
        }
    if(mHomeSystemId.length != mHomeNetworkId.length)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_607694276 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944022958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944022958;
        }
    if(sid == 0)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1481902193 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928583800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928583800;
        }
for(int i = 0;i < mHomeSystemId.length;i++)
        {
    if((mHomeSystemId[i] == sid) &&
                ((mHomeNetworkId[i] == 0) || (mHomeNetworkId[i] == 65535) ||
                 (nid == 0) || (nid == 65535) || (mHomeNetworkId[i] == nid)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1798184456 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327533190 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327533190;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_164468973 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272738930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_272738930;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.510 -0400", hash_original_method = "3CA2CE2F434AACC848657E54771E66A4", hash_generated_method = "B6DA6A58DAF4513C2CBC2FEB61446FA4")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[CdmaLteSST] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.511 -0400", hash_original_method = "CE31FBC457ABF05FA318FEB73DCA10E2", hash_generated_method = "9CAD79F5F2E82C48926C38487323D3F6")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaLteSST] " + s);
    }

    
}

