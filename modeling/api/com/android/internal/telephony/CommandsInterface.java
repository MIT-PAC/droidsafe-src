/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;

public interface CommandsInterface {
    enum RadioState {
        RADIO_OFF(0),         
        RADIO_UNAVAILABLE(0), 
        SIM_NOT_READY(1),     
        SIM_LOCKED_OR_ABSENT(1),  
        SIM_READY(1),         
        RUIM_NOT_READY(2),    
        RUIM_READY(2),        
        RUIM_LOCKED_OR_ABSENT(2), 
        NV_NOT_READY(3),      
        NV_READY(3);          /* Radio is on and the NV interface is available */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.391 -0500", hash_original_method = "E5010F6EF5A2495E4DE760511B116A8A", hash_generated_method = "98E9D7C79585D1B26572E5C39183F60D")
            
public boolean isOn() /* and available...*/ {
            return this == SIM_NOT_READY
                    || this == SIM_LOCKED_OR_ABSENT
                    || this == SIM_READY
                    || this == RUIM_NOT_READY
                    || this == RUIM_READY
                    || this == RUIM_LOCKED_OR_ABSENT
                    || this == NV_NOT_READY
                    || this == NV_READY;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.394 -0500", hash_original_field = "BD6E19A2A5BADB982C30B02146671E4A", hash_generated_field = "C29DB35AA70BAFD85AC3718E0519E0FE")

        private int stateType;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.397 -0500", hash_original_method = "5E10BE796CE6D84489BE2723CB5CF436", hash_generated_method = "1D3DB49C8AD90C85C8FE58248B3DD6BA")
            
private RadioState (int type) {
            stateType = type;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.400 -0500", hash_original_method = "6C859BFA41165BDDFEC05C5EB312B247", hash_generated_method = "95F6AA9758CCC486B6D5700E959B8C51")
            
public int getType() {
            return stateType;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.402 -0500", hash_original_method = "E21BD661A7E7F117EDA570407AD8378D", hash_generated_method = "BB9403B02B1B48EC8484D84995EAE5F3")
            
public boolean isAvailable() {
            return this != RADIO_UNAVAILABLE;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.404 -0500", hash_original_method = "173D20585B19562DB80ACD7D2C7B83A9", hash_generated_method = "0A10D3979B700D8B549DCB123419E1D8")
            
public boolean isSIMReady() {
            return this == SIM_READY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.407 -0500", hash_original_method = "8D143A627C38698CBC2839D3093715FC", hash_generated_method = "500B1CAC885A20A169B5AE1F68CB1648")
            
public boolean isRUIMReady() {
            return this == RUIM_READY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.410 -0500", hash_original_method = "F10A87FAE4F6E5E3D2E6FF8444F28BBF", hash_generated_method = "1BC54279674074293EC8F5D0BB150045")
            
public boolean isNVReady() {
            return this == NV_READY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.412 -0500", hash_original_method = "64FE87CCA8362EF6215C6BF08A2B7063", hash_generated_method = "F80F56187CE9659E3FD45FBA1C48AFE1")
            
public boolean isGsm() {
            if (BaseCommands.getLteOnCdmaModeStatic() == Phone.LTE_ON_CDMA_TRUE) {
                return false;
            } else {
                return this == SIM_NOT_READY
                        || this == SIM_LOCKED_OR_ABSENT
                        || this == SIM_READY;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:38.415 -0500", hash_original_method = "5372058641134AE7BF537BAA7A3ED2B2", hash_generated_method = "A2D4A9281A1FC1F1C45B89B0558DA7AA")
            
public boolean isCdma() {
            if (BaseCommands.getLteOnCdmaModeStatic() == Phone.LTE_ON_CDMA_TRUE) {
                return true;
            } else {
                return this ==  RUIM_NOT_READY
                        || this == RUIM_READY
                        || this == RUIM_LOCKED_OR_ABSENT
                        || this == NV_NOT_READY
                        || this == NV_READY;
            }
        }
    }

    

    
    static final int CLIR_DEFAULT = 0;      
    static final int CLIR_INVOCATION = 1;   
    static final int CLIR_SUPPRESSION = 2;  


    
    static final int CF_ACTION_DISABLE          = 0;
    static final int CF_ACTION_ENABLE           = 1;

    static final int CF_ACTION_REGISTRATION     = 3;
    static final int CF_ACTION_ERASURE          = 4;

    static final int CF_REASON_UNCONDITIONAL    = 0;
    static final int CF_REASON_BUSY             = 1;
    static final int CF_REASON_NO_REPLY         = 2;
    static final int CF_REASON_NOT_REACHABLE    = 3;
    static final int CF_REASON_ALL              = 4;
    static final int CF_REASON_ALL_CONDITIONAL  = 5;

    
    static final String CB_FACILITY_BAOC         = "AO";
    static final String CB_FACILITY_BAOIC        = "OI";
    static final String CB_FACILITY_BAOICxH      = "OX";
    static final String CB_FACILITY_BAIC         = "AI";
    static final String CB_FACILITY_BAICr        = "IR";
    static final String CB_FACILITY_BA_ALL       = "AB";
    static final String CB_FACILITY_BA_MO        = "AG";
    static final String CB_FACILITY_BA_MT        = "AC";
    static final String CB_FACILITY_BA_SIM       = "SC";
    static final String CB_FACILITY_BA_FD        = "FD";


    
    
    static final int SERVICE_CLASS_NONE     = 0; 
    static final int SERVICE_CLASS_VOICE    = (1 << 0);
    static final int SERVICE_CLASS_DATA     = (1 << 1); 
    static final int SERVICE_CLASS_FAX      = (1 << 2);
    static final int SERVICE_CLASS_SMS      = (1 << 3);
    static final int SERVICE_CLASS_DATA_SYNC = (1 << 4);
    static final int SERVICE_CLASS_DATA_ASYNC = (1 << 5);
    static final int SERVICE_CLASS_PACKET   = (1 << 6);
    static final int SERVICE_CLASS_PAD      = (1 << 7);
    static final int SERVICE_CLASS_MAX      = (1 << 7); 

    
    
    static final int USSD_MODE_NOTIFY       = 0;
    static final int USSD_MODE_REQUEST      = 1;

    
    static final int SIM_REFRESH_FILE_UPDATED   = 0;  
    static final int SIM_REFRESH_INIT           = 1;  
    static final int SIM_REFRESH_RESET          = 2;  

    
    static final int GSM_SMS_FAIL_CAUSE_MEMORY_CAPACITY_EXCEEDED    = 0xD3;
    static final int GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY       = 0xD4;
    static final int GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR    = 0xD5;
    static final int GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR           = 0xFF;

    
    static final int CDMA_SMS_FAIL_CAUSE_INVALID_TELESERVICE_ID     = 4;
    static final int CDMA_SMS_FAIL_CAUSE_RESOURCE_SHORTAGE          = 35;
    static final int CDMA_SMS_FAIL_CAUSE_OTHER_TERMINAL_PROBLEM     = 39;
    static final int CDMA_SMS_FAIL_CAUSE_ENCODING_PROBLEM           = 96;

    

    RadioState getRadioState();
    RadioState getSimState();
    RadioState getRuimState();
    RadioState getNvState();

    
    void registerForRadioStateChanged(Handler h, int what, Object obj);
    void unregisterForRadioStateChanged(Handler h);

    
    void registerForOn(Handler h, int what, Object obj);
    void unregisterForOn(Handler h);

    
    void registerForAvailable(Handler h, int what, Object obj);
    void unregisterForAvailable(Handler h);

    
    void registerForNotAvailable(Handler h, int what, Object obj);
    void unregisterForNotAvailable(Handler h);

    
    void registerForOffOrNotAvailable(Handler h, int what, Object obj);
    void unregisterForOffOrNotAvailable(Handler h);

    
    void registerForSIMReady(Handler h, int what, Object obj);
    void unregisterForSIMReady(Handler h);

    
    void registerForSIMLockedOrAbsent(Handler h, int what, Object obj);
    void unregisterForSIMLockedOrAbsent(Handler h);

    void registerForIccStatusChanged(Handler h, int what, Object obj);
    void unregisterForIccStatusChanged(Handler h);

    void registerForCallStateChanged(Handler h, int what, Object obj);
    void unregisterForCallStateChanged(Handler h);
    void registerForVoiceNetworkStateChanged(Handler h, int what, Object obj);
    void unregisterForVoiceNetworkStateChanged(Handler h);
    void registerForDataNetworkStateChanged(Handler h, int what, Object obj);
    void unregisterForDataNetworkStateChanged(Handler h);

    void registerForRadioTechnologyChanged(Handler h, int what, Object obj);
    void unregisterForRadioTechnologyChanged(Handler h);
    void registerForNVReady(Handler h, int what, Object obj);
    void unregisterForNVReady(Handler h);
    void registerForRUIMLockedOrAbsent(Handler h, int what, Object obj);
    void unregisterForRUIMLockedOrAbsent(Handler h);

    
    void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj);
    void unregisterForInCallVoicePrivacyOn(Handler h);
    void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj);
    void unregisterForInCallVoicePrivacyOff(Handler h);

    
    void registerForRUIMReady(Handler h, int what, Object obj);
    void unregisterForRUIMReady(Handler h);

    
    void setOnNewGsmSms(Handler h, int what, Object obj);
    void unSetOnNewGsmSms(Handler h);

    
    void setOnNewCdmaSms(Handler h, int what, Object obj);
    void unSetOnNewCdmaSms(Handler h);

    
    void setOnNewGsmBroadcastSms(Handler h, int what, Object obj);
    void unSetOnNewGsmBroadcastSms(Handler h);

    
    void setOnSmsOnSim(Handler h, int what, Object obj);
    void unSetOnSmsOnSim(Handler h);

    
    void setOnSmsStatus(Handler h, int what, Object obj);
    void unSetOnSmsStatus(Handler h);

    
    void setOnNITZTime(Handler h, int what, Object obj);
    void unSetOnNITZTime(Handler h);

    

    void setOnUSSD(Handler h, int what, Object obj);
    void unSetOnUSSD(Handler h);

    

    void setOnSignalStrengthUpdate(Handler h, int what, Object obj);
    void unSetOnSignalStrengthUpdate(Handler h);

    
    void setOnIccSmsFull(Handler h, int what, Object obj);
    void unSetOnIccSmsFull(Handler h);

    
    void registerForIccRefresh(Handler h, int what, Object obj);
    void unregisterForIccRefresh(Handler h);

    void setOnIccRefresh(Handler h, int what, Object obj);
    void unsetOnIccRefresh(Handler h);

    
    void setOnCallRing(Handler h, int what, Object obj);
    void unSetOnCallRing(Handler h);

    

    void setOnRestrictedStateChanged(Handler h, int what, Object obj);
    void unSetOnRestrictedStateChanged(Handler h);

    
    void setOnSuppServiceNotification(Handler h, int what, Object obj);
    void unSetOnSuppServiceNotification(Handler h);

    
    void setOnCatSessionEnd(Handler h, int what, Object obj);
    void unSetOnCatSessionEnd(Handler h);

    
    void setOnCatProactiveCmd(Handler h, int what, Object obj);
    void unSetOnCatProactiveCmd(Handler h);

    
    void setOnCatEvent(Handler h, int what, Object obj);
    void unSetOnCatEvent(Handler h);

    
    void setOnCatCallSetUp(Handler h, int what, Object obj);
    void unSetOnCatCallSetUp(Handler h);

    
    void setSuppServiceNotifications(boolean enable, Message result);
    

    
    void registerForDisplayInfo(Handler h, int what, Object obj);
    void unregisterForDisplayInfo(Handler h);

    
    void registerForCallWaitingInfo(Handler h, int what, Object obj);
    void unregisterForCallWaitingInfo(Handler h);

    
    void registerForSignalInfo(Handler h, int what, Object obj);
    void unregisterForSignalInfo(Handler h);

    
    void registerForNumberInfo(Handler h, int what, Object obj);
    void unregisterForNumberInfo(Handler h);

    
    void registerForRedirectedNumberInfo(Handler h, int what, Object obj);
    void unregisterForRedirectedNumberInfo(Handler h);

    
    void registerForLineControlInfo(Handler h, int what, Object obj);
    void unregisterForLineControlInfo(Handler h);

    
    void registerFoT53ClirlInfo(Handler h, int what, Object obj);
    void unregisterForT53ClirInfo(Handler h);

    
    void registerForT53AudioControlInfo(Handler h, int what, Object obj);
    void unregisterForT53AudioControlInfo(Handler h);

    
    void setEmergencyCallbackMode(Handler h, int what, Object obj);

     
     void registerForCdmaOtaProvision(Handler h,int what, Object obj);
     void unregisterForCdmaOtaProvision(Handler h);

     
     void registerForRingbackTone(Handler h, int what, Object obj);
     void unregisterForRingbackTone(Handler h);

     
     void registerForResendIncallMute(Handler h, int what, Object obj);
     void unregisterForResendIncallMute(Handler h);

     
     void registerForCdmaSubscriptionChanged(Handler h, int what, Object obj);
     void unregisterForCdmaSubscriptionChanged(Handler h);

     
     void registerForCdmaPrlChanged(Handler h, int what, Object obj);
     void unregisterForCdmaPrlChanged(Handler h);

     
     void registerForExitEmergencyCallbackMode(Handler h, int what, Object obj);
     void unregisterForExitEmergencyCallbackMode(Handler h);

     
     void registerForRilConnected(Handler h, int what, Object obj);
     void unregisterForRilConnected(Handler h);

    

    void supplyIccPin(String pin, Message result);

    

    void supplyIccPinForApp(String pin, String aid, Message result);

    

    void supplyIccPuk(String puk, String newPin, Message result);

    

    void supplyIccPukForApp(String puk, String newPin, String aid, Message result);

    

    void supplyIccPin2(String pin2, Message result);

    

    void supplyIccPin2ForApp(String pin2, String aid, Message result);

    

    void supplyIccPuk2(String puk2, String newPin2, Message result);

    

    void supplyIccPuk2ForApp(String puk2, String newPin2, String aid, Message result);

    void changeIccPin(String oldPin, String newPin, Message result);
    void changeIccPinForApp(String oldPin, String newPin, String aidPtr, Message result);
    void changeIccPin2(String oldPin2, String newPin2, Message result);
    void changeIccPin2ForApp(String oldPin2, String newPin2, String aidPtr, Message result);

    void changeBarringPassword(String facility, String oldPwd, String newPwd, Message result);

    void supplyNetworkDepersonalization(String netpin, Message result);

    
    void getCurrentCalls (Message result);

    
    @Deprecated
    void getPDPContextList(Message result);

    
    void getDataCallList(Message result);

    
    void dial (String address, int clirMode, Message result);

    
    void dial(String address, int clirMode, UUSInfo uusInfo, Message result);

    
    void getIMSI(Message result);

    
    void getIMEI(Message result);

    
    void getIMEISV(Message result);

    
    void hangupConnection (int gsmIndex, Message result);

    
    void hangupWaitingOrBackground (Message result);

    
    void hangupForegroundResumeBackground (Message result);

    
    void switchWaitingOrHoldingAndActive (Message result);

    
    void conference (Message result);

    
    void setPreferredVoicePrivacy(boolean enable, Message result);

    
    void getPreferredVoicePrivacy(Message result);

    
    void separateConnection (int gsmIndex, Message result);

    
    void acceptCall (Message result);

    
    void rejectCall (Message result);

    
    void explicitCallTransfer (Message result);

    
    void getLastCallFailCause (Message result);


    
    @Deprecated
    void getLastPdpFailCause (Message result);

    
    void getLastDataCallFailCause (Message result);

    void setMute (boolean enableMute, Message response);

    void getMute (Message response);

    
    void getSignalStrength (Message response);


    
    void getVoiceRegistrationState (Message response);

    
    void getDataRegistrationState (Message response);

    
    void getOperator(Message response);

    
    void sendDtmf(char c, Message result);


    
    void startDtmf(char c, Message result);

    
    void stopDtmf(Message result);

    
    void sendBurstDtmf(String dtmfString, int on, int off, Message result);

    
    void sendSMS (String smscPDU, String pdu, Message response);

    
    void sendCdmaSms(byte[] pdu, Message response);

    
    void deleteSmsOnSim(int index, Message response);

    
    void deleteSmsOnRuim(int index, Message response);

    
    void writeSmsToSim(int status, String smsc, String pdu, Message response);

    void writeSmsToRuim(int status, String pdu, Message response);

    void setRadioPower(boolean on, Message response);

    void acknowledgeLastIncomingGsmSms(boolean success, int cause, Message response);

    void acknowledgeLastIncomingCdmaSms(boolean success, int cause, Message response);

    
    void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu, Message response);

    
    void iccIO (int command, int fileid, String path, int p1, int p2, int p3,
            String data, String pin2, Message response);

    

    void queryCLIP(Message response);

    

    void getCLIR(Message response);

    

    void setCLIR(int clirMode, Message response);

    

    void queryCallWaiting(int serviceClass, Message response);

    

    void setCallWaiting(boolean enable, int serviceClass, Message response);

    
    void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response);

    
    void queryCallForwardStatus(int cfReason, int serviceClass,
            String number, Message response);

    void setNetworkSelectionModeAutomatic(Message response);

    void setNetworkSelectionModeManual(String operatorNumeric, Message response);

    

    void getNetworkSelectionMode(Message response);

    
    void getAvailableNetworks(Message response);

    void getBasebandVersion (Message response);


    

    void queryFacilityLock (String facility, String password, int serviceClass,
        Message response);

    

    void queryFacilityLockForApp(String facility, String password, int serviceClass, String appId,
        Message response);

    
    void setFacilityLock (String facility, boolean lockState, String password,
        int serviceClass, Message response);

    
    void setFacilityLockForApp(String facility, boolean lockState, String password,
        int serviceClass, String appId, Message response);

    void sendUSSD (String ussdString, Message response);

    
    void cancelPendingUssd (Message response);

    void resetRadio(Message result);

    
    void setBandMode (int bandMode, Message response);

    
    void queryAvailableBandMode (Message response);

    
    void setCurrentPreferredNetworkType();

    
    void setPreferredNetworkType(int networkType , Message response);

     
    void getPreferredNetworkType(Message response);

    
    void getNeighboringCids(Message response);

    
    void setLocationUpdates(boolean enable, Message response);

    
    void getSmscAddress(Message result);

    
    void setSmscAddress(String address, Message result);

    
    void reportSmsMemoryStatus(boolean available, Message result);

    
    void reportStkServiceIsRunning(Message result);

    void invokeOemRilRequestRaw(byte[] data, Message response);

    void invokeOemRilRequestStrings(String[] strings, Message response);


    
    public void sendTerminalResponse(String contents, Message response);

    
    public void sendEnvelope(String contents, Message response);

    
    public void sendEnvelopeWithStatus(String contents, Message response);

    
    public void handleCallSetupRequestFromSim(boolean accept, Message response);

    
    public void setGsmBroadcastActivation(boolean activate, Message result);

    
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response);

    
    public void getGsmBroadcastConfig(Message response);

    

    
    public void getDeviceIdentity(Message response);

    
    public void getCDMASubscription(Message response);

    
    public void sendCDMAFeatureCode(String FeatureCode, Message response);

    
    void setPhoneType(int phoneType);

    
    void queryCdmaRoamingPreference(Message response);

    
    void setCdmaRoamingPreference(int cdmaRoamingType, Message response);

    
    void setCdmaSubscriptionSource(int cdmaSubscriptionType, Message response);

    
    void getCdmaSubscriptionSource(Message response);

    
    void setTTYMode(int ttyMode, Message response);

    
    void queryTTYMode(Message response);

    
    public void setupDataCall(String radioTechnology, String profile,
            String apn, String user, String password, String authType,
            String protocol, Message result);

    
    public void deactivateDataCall(int cid, int reason, Message result);

    
    public void setCdmaBroadcastActivation(boolean activate, Message result);

    
    
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message result);

    
    public void getCdmaBroadcastConfig(Message result);

    
    public void exitEmergencyCallbackMode(Message response);

    
    public void getIccCardStatus(Message result);

    
    public int getLteOnCdmaMode();

    
    public void requestIsimAuthentication(String nonce, Message response);
}
