package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.Intent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.util.Log;
import com.android.internal.telephony.cdma.CDMAPhone;
import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import java.util.List;

public class PhoneProxy extends Handler implements Phone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.152 -0400", hash_original_field = "10728AB9087E7707D37847A2389DDE0C", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")

    private Phone mActivePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.152 -0400", hash_original_field = "7ECE7371C43BE14D2A55B339F95D5963", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.152 -0400", hash_original_field = "1807C68F8FB5F577A66C3A94E5AD0A66", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.153 -0400", hash_original_field = "21B855B7AFB6C39284AC629A5ACDC28A", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.153 -0400", hash_original_field = "18F20DD2807A52A04EA2B70117648163", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.153 -0400", hash_original_field = "4A5BFF6E8716B82AA5C82CBE6B802317", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.153 -0400", hash_original_field = "B37050DAC53073D34B96D1CA70F3C3FE", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")

    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.161 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "172604CCF05E7950C338A2F8CB3563A0")
    public  PhoneProxy(Phone phone) {
        mActivePhone = phone;
        mResetModemOnRadioTechnologyChange = SystemProperties.getBoolean(
                TelephonyProperties.PROPERTY_RESET_ON_RADIO_TECH_CHANGE, false);
        mIccSmsInterfaceManagerProxy = new IccSmsInterfaceManagerProxy(
                phone.getIccSmsInterfaceManager());
        mIccPhoneBookInterfaceManagerProxy = new IccPhoneBookInterfaceManagerProxy(
                phone.getIccPhoneBookInterfaceManager());
        mPhoneSubInfoProxy = new PhoneSubInfoProxy(phone.getPhoneSubInfo());
        mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
        mCommandsInterface.registerForRadioTechnologyChanged(
                this, EVENT_RADIO_TECHNOLOGY_CHANGED, null);
        // ---------- Original Method ----------
        //mActivePhone = phone;
        //mResetModemOnRadioTechnologyChange = SystemProperties.getBoolean(
                //TelephonyProperties.PROPERTY_RESET_ON_RADIO_TECH_CHANGE, false);
        //mIccSmsInterfaceManagerProxy = new IccSmsInterfaceManagerProxy(
                //phone.getIccSmsInterfaceManager());
        //mIccPhoneBookInterfaceManagerProxy = new IccPhoneBookInterfaceManagerProxy(
                //phone.getIccPhoneBookInterfaceManager());
        //mPhoneSubInfoProxy = new PhoneSubInfoProxy(phone.getPhoneSubInfo());
        //mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
        //mCommandsInterface.registerForRadioTechnologyChanged(
                //this, EVENT_RADIO_TECHNOLOGY_CHANGED, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.191 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "EAA28494EAAA429420655D8E44730A70")
    @Override
    public void handleMessage(Message msg) {
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        mOutgoingPhone = mActivePhone.getPhoneName();
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        logd("Switching phone from " + mOutgoingPhone + "Phone to " +
                    (mOutgoingPhone.equals("GSM") ? "CDMAPhone" : "GSMPhone") );
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        boolean oldPowerState;
        oldPowerState = false;
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        {
            {
                boolean var01B1DDE89E6E9D2BC475F5FFE0326C76_538478730 = (mCommandsInterface.getRadioState().isOn());
                {
                    oldPowerState = true;
                    logd("Setting Radio Power to Off");
                    mCommandsInterface.setRadioPower(false, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        {
            boolean var567788BF435FAFE5B3B27D51A9536128_1882356748 = (mOutgoingPhone.equals("GSM"));
            {
                logd("Make a new CDMAPhone and destroy the old GSMPhone.");
                ((GSMPhone)mActivePhone).dispose();
                Phone oldPhone;
                oldPhone = mActivePhone;
                mActivePhone = PhoneFactory.getCdmaPhone();
                ((GSMPhone)oldPhone).removeReferences();
                oldPhone = null;
            } //End block
            {
                logd("Make a new GSMPhone and destroy the old CDMAPhone.");
                ((CDMAPhone)mActivePhone).dispose();
                Phone oldPhone;
                oldPhone = mActivePhone;
                mActivePhone = PhoneFactory.getGsmPhone();
                ((CDMAPhone)oldPhone).removeReferences();
                oldPhone = null;
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        {
            logd("Resetting Radio");
            mCommandsInterface.setRadioPower(oldPowerState, null);
        } //End block
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        mIccSmsInterfaceManagerProxy.setmIccSmsInterfaceManager(
                    mActivePhone.getIccSmsInterfaceManager());
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        mIccPhoneBookInterfaceManagerProxy.setmIccPhoneBookInterfaceManager(
                    mActivePhone.getIccPhoneBookInterfaceManager());
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        mPhoneSubInfoProxy.setmPhoneSubInfo(this.mActivePhone.getPhoneSubInfo());
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_RADIO_TECHNOLOGY_CHANGED);
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        intent.putExtra(Phone.PHONE_NAME_KEY, mActivePhone.getPhoneName());
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        //Begin case EVENT_RADIO_TECHNOLOGY_CHANGED 
        ActivityManagerNative.broadcastStickyIntent(intent, null);
        //End case EVENT_RADIO_TECHNOLOGY_CHANGED 
        super.handleMessage(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.192 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "43C12724574E523C8E3C0107A001E72B")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_1127087898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1127087898 = mActivePhone.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_1127087898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127087898;
        // ---------- Original Method ----------
        //return mActivePhone.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.193 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "B312BA2D49333ED7721C5DC2E0142497")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1368052189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368052189 = mActivePhone.getCellLocation();
        varB4EAC82CA7396A68D541C85D26508E83_1368052189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368052189;
        // ---------- Original Method ----------
        //return mActivePhone.getCellLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.194 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "0DBAC67D6052B39D2BC8E1055925E1F5")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1907163161 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1907163161 = mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
        varB4EAC82CA7396A68D541C85D26508E83_1907163161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1907163161;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.194 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "79786626E9032855F1970FD9A693F8E6")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1645477030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1645477030 = mActivePhone.getDataConnectionState(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1645477030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1645477030;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.195 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "C5B8295016638FA85A93F25C2DCACBCB")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_1571734492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1571734492 = mActivePhone.getDataActivityState();
        varB4EAC82CA7396A68D541C85D26508E83_1571734492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571734492;
        // ---------- Original Method ----------
        //return mActivePhone.getDataActivityState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.195 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "9AA3D5E05CFD4FDC5C3799897A6F1AC5")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_799455773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_799455773 = mActivePhone.getContext();
        varB4EAC82CA7396A68D541C85D26508E83_799455773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_799455773;
        // ---------- Original Method ----------
        //return mActivePhone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.196 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "12BC90EEF277A18257AF7C2DE1C4FCC5")
    public void disableDnsCheck(boolean b) {
        mActivePhone.disableDnsCheck(b);
        addTaint(b);
        // ---------- Original Method ----------
        //mActivePhone.disableDnsCheck(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.196 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "F911BD643086DB1B4B55C8D2F8D06843")
    public boolean isDnsCheckDisabled() {
        boolean var63BCDE066CAA6ED52BCDEA8E29F6B1DB_1087364234 = (mActivePhone.isDnsCheckDisabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96229054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96229054;
        // ---------- Original Method ----------
        //return mActivePhone.isDnsCheckDisabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.196 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "02C7270360AAB62B753C4606E23A58FA")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1958908242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1958908242 = mActivePhone.getState();
        varB4EAC82CA7396A68D541C85D26508E83_1958908242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1958908242;
        // ---------- Original Method ----------
        //return mActivePhone.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.197 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "334EBF5E3745351F420DA20EEF3541E9")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_713087508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_713087508 = mActivePhone.getPhoneName();
        varB4EAC82CA7396A68D541C85D26508E83_713087508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_713087508;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.197 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "63B9254ED8D81C11F9C4CD4B9BBC8F6A")
    public int getPhoneType() {
        int varB5C5EFC4899F813B21E51CD745860764_831036727 = (mActivePhone.getPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059248277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059248277;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.209 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "B61A541765BEC2B7E5430650E68791CD")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1422126272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1422126272 = mActivePhone.getActiveApnTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1422126272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1422126272;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.209 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "A48AA3A2FA1407665A4142A34AD987DA")
    public String getActiveApnHost(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_340380547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_340380547 = mActivePhone.getActiveApnHost(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_340380547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340380547;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnHost(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.210 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "92CFED83DB1922FFF752066A7B02571B")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_2021505121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021505121 = mActivePhone.getLinkProperties(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2021505121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021505121;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.214 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "F9705F396488015B1A009C143708F692")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_962103565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_962103565 = mActivePhone.getLinkCapabilities(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_962103565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_962103565;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.215 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "FD6286797D00F15183428916944BB9BF")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1896281641 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1896281641 = mActivePhone.getSignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_1896281641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896281641;
        // ---------- Original Method ----------
        //return mActivePhone.getSignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.215 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "0A778903A47B585997135EB90EFB1A2E")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForUnknownConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.216 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "A62EA4EE5DCC3535F73043A26E2A6E00")
    public void unregisterForUnknownConnection(Handler h) {
        mActivePhone.unregisterForUnknownConnection(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForUnknownConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.216 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "BD90B464D7F48957F5E493B9821F8F45")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.225 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "A3D02AC85ECF46AFD6E92D7232F9C7F0")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.225 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "8B2C815F2AEC0DF08723519C4961C421")
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.226 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "F2B7CEECA0990E6BCF890D38858DB097")
    public void unregisterForNewRingingConnection(Handler h) {
        mActivePhone.unregisterForNewRingingConnection(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNewRingingConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.226 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "CD83B995B52B7399A5DC0C2E0AB14A2D")
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForIncomingRing(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForIncomingRing(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.226 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "95EE9BE9CE659C968337D8D8E98213D2")
    public void unregisterForIncomingRing(Handler h) {
        mActivePhone.unregisterForIncomingRing(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForIncomingRing(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.232 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "15B884DEA7639824B1002059F98ABC3C")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForDisconnect(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForDisconnect(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.236 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "16A3F8A21DA8BA0B5A5FDA5CE76C349D")
    public void unregisterForDisconnect(Handler h) {
        mActivePhone.unregisterForDisconnect(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisconnect(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.247 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "C08E7F4516CA51425DCCEBDE903386E0")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForMmiInitiate(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.247 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "84035DF796FD0C10E7DA9B84741D8D1E")
    public void unregisterForMmiInitiate(Handler h) {
        mActivePhone.unregisterForMmiInitiate(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiInitiate(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.247 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "AB506367220C419A55055246197B1422")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForMmiComplete(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiComplete(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.247 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "9AAE8E1EA56996141991AEC7411A206F")
    public void unregisterForMmiComplete(Handler h) {
        mActivePhone.unregisterForMmiComplete(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiComplete(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.248 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "EA8C34335F3FBD718EA15EC640D94F52")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_770123820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_770123820 = mActivePhone.getPendingMmiCodes();
        varB4EAC82CA7396A68D541C85D26508E83_770123820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_770123820;
        // ---------- Original Method ----------
        //return mActivePhone.getPendingMmiCodes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.248 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "A73D74E228A137BC0C7763B780A9F4D6")
    public void sendUssdResponse(String ussdMessge) {
        mActivePhone.sendUssdResponse(ussdMessge);
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.sendUssdResponse(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.248 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "2F94D9E9F161D9D20FBE7533697DCD5A")
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.249 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "6C7FA493450DC1D160FDC964EE74DD2E")
    public void unregisterForServiceStateChanged(Handler h) {
        mActivePhone.unregisterForServiceStateChanged(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForServiceStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.249 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "FD68A583C184BD40156564AA3A4267C7")
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.250 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "FA098B3E1CAFECC3DE5B65F323FBAAF0")
    public void unregisterForSuppServiceNotification(Handler h) {
        mActivePhone.unregisterForSuppServiceNotification(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceNotification(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.250 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "1486F05A02C60FAFDB41F42D61ABECF9")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.250 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "8CEE8AD71BDD7D63CA8D6490AD4C0642")
    public void unregisterForSuppServiceFailed(Handler h) {
        mActivePhone.unregisterForSuppServiceFailed(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceFailed(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.250 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "8D520B4600301BE861E3557EDE21CE60")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.251 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "1C1407AE3FBBD4E0238CACFD5568D821")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.251 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "3C26F23326FD7F6B6872A86AE705A81F")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.251 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "5E74C2F8B096B1ABE4A018A4F1C083BC")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.251 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "EA3342A25B64083E7A72BD041E739E28")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.254 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "0559D05B53A3A87B466B627FC931E10D")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.254 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "1EA746138A160CC542499B2F04E83BF1")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.254 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "0BBDFDB43103DFBCE9CA64C53135DB75")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.265 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "FE25BCAB55088F9F99E0F11951EF86E0")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.266 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "69A5CE1244CB03A15DDC5D5E2D9DDC01")
    public void unregisterForEcmTimerReset(Handler h) {
        mActivePhone.unregisterForEcmTimerReset(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForEcmTimerReset(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.267 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "6DE2A901846E672A01CE61169A519F29")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForRingbackTone(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.267 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "6D4D33A7ABBA473F4DED2C5241D4192E")
    public void unregisterForRingbackTone(Handler h) {
        mActivePhone.unregisterForRingbackTone(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.267 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "E2C36C2DD359ED8D3D3F93FD7EC8C91A")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForResendIncallMute(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.267 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "F2F74CF08EE7A5F75CEBC38B30029822")
    public void unregisterForResendIncallMute(Handler h) {
        mActivePhone.unregisterForResendIncallMute(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.268 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "103F3EB96A405978BAD774A0E050967D")
    public boolean getIccRecordsLoaded() {
        boolean varD34CD95BD9903759FA66B479DE10B32C_1307539976 = (mActivePhone.getIccRecordsLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550451604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550451604;
        // ---------- Original Method ----------
        //return mActivePhone.getIccRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.268 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "B4E1EB42A540F4D1403E68127D1FE19C")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_163810036 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_163810036 = mActivePhone.getIccCard();
        varB4EAC82CA7396A68D541C85D26508E83_163810036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_163810036;
        // ---------- Original Method ----------
        //return mActivePhone.getIccCard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.268 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        // ---------- Original Method ----------
        //mActivePhone.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.281 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        // ---------- Original Method ----------
        //mActivePhone.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.281 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        // ---------- Original Method ----------
        //mActivePhone.switchHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.282 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "61145EA9FC901203BEED95CB6468F002")
    public boolean canConference() {
        boolean varBEBBDC11FE20620D331255B29CB7C083_1649096633 = (mActivePhone.canConference());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282752609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282752609;
        // ---------- Original Method ----------
        //return mActivePhone.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.282 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    public void conference() throws CallStateException {
        mActivePhone.conference();
        // ---------- Original Method ----------
        //mActivePhone.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.283 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "0E3A6CB3D95038181ABB1A4B3DD74C43")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.283 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "5FCAA5609FA42CF2896E93517B5760C8")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.283 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "7F6BE6AD4CF5C1E81251923D35A694AA")
    public boolean canTransfer() {
        boolean varA271678BA825E5B535929271849B2922_820121471 = (mActivePhone.canTransfer());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263344768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_263344768;
        // ---------- Original Method ----------
        //return mActivePhone.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.283 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        // ---------- Original Method ----------
        //mActivePhone.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.284 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        // ---------- Original Method ----------
        //mActivePhone.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.295 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "8A76240A16DAED728F3C56C4AC1014A1")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1043056817 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1043056817 = mActivePhone.getForegroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_1043056817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1043056817;
        // ---------- Original Method ----------
        //return mActivePhone.getForegroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.296 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "2131ED16904F33915347BB0191A8894F")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_257663432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_257663432 = mActivePhone.getBackgroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_257663432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_257663432;
        // ---------- Original Method ----------
        //return mActivePhone.getBackgroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.296 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "BA28CEC424BE547FBE2116F6B8A4879E")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1133334194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1133334194 = mActivePhone.getRingingCall();
        varB4EAC82CA7396A68D541C85D26508E83_1133334194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1133334194;
        // ---------- Original Method ----------
        //return mActivePhone.getRingingCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.297 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "B04FEDF68210DAF64D42FF3E25B5A0E8")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1760599185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1760599185 = mActivePhone.dial(dialString);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1760599185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1760599185;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.297 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "18ECA401E03E8EA34709B814FF52234C")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1056318749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1056318749 = mActivePhone.dial(dialString, uusInfo);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1056318749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1056318749;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.297 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "94DCB043CFCD087C3E2B6BCA79B977D2")
    public boolean handlePinMmi(String dialString) {
        boolean var9EAF3797F0895E045EDD8A2A6F3E9DC3_611259043 = (mActivePhone.handlePinMmi(dialString));
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426911617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426911617;
        // ---------- Original Method ----------
        //return mActivePhone.handlePinMmi(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.298 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "080A6E631147182496427EF678999C73")
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        boolean varB6713A0B25EC29F71205412BEAB34760_1411252503 = (mActivePhone.handleInCallMmiCommands(command));
        addTaint(command.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55407883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55407883;
        // ---------- Original Method ----------
        //return mActivePhone.handleInCallMmiCommands(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.298 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "02BB7D3CC2467916072825823BC7F612")
    public void sendDtmf(char c) {
        mActivePhone.sendDtmf(c);
        addTaint(c);
        // ---------- Original Method ----------
        //mActivePhone.sendDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.298 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "F52C933F3F6210EBC4ADD57A96877685")
    public void startDtmf(char c) {
        mActivePhone.startDtmf(c);
        addTaint(c);
        // ---------- Original Method ----------
        //mActivePhone.startDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.298 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        // ---------- Original Method ----------
        //mActivePhone.stopDtmf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.308 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "D9D52A0A56C9B8E1D8FDC379A00959A4")
    public void setRadioPower(boolean power) {
        mActivePhone.setRadioPower(power);
        addTaint(power);
        // ---------- Original Method ----------
        //mActivePhone.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.309 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "E3253D4E4F35D936215B5D7267CAC8AF")
    public boolean getMessageWaitingIndicator() {
        boolean varE36CE85276F33DCC5B02481874938DBC_1258248084 = (mActivePhone.getMessageWaitingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771565073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_771565073;
        // ---------- Original Method ----------
        //return mActivePhone.getMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.309 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "9665251D0AF770D182CBBB9673552152")
    public boolean getCallForwardingIndicator() {
        boolean var711465E26D829245ADB92E0313FED47F_571104094 = (mActivePhone.getCallForwardingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141601042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141601042;
        // ---------- Original Method ----------
        //return mActivePhone.getCallForwardingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.309 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "ECCABC1ADB6C70A1091D934D3129C2F6")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1603853553 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1603853553 = mActivePhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_1603853553.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603853553;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.310 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "58360CCBF3F2CB4B617CAFC0844699DB")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_1541607760 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1541607760 = mActivePhone.getCdmaMin();
        varB4EAC82CA7396A68D541C85D26508E83_1541607760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1541607760;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.310 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "AC4DFAB44DC8A7641C323A78F6611672")
    public boolean isMinInfoReady() {
        boolean varBADBA5710877FFB10FBC68610BD4AFC0_1755066441 = (mActivePhone.isMinInfoReady());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821068079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821068079;
        // ---------- Original Method ----------
        //return mActivePhone.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.310 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "160578EC3059C72F60AB599A2F58203D")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1346377124 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346377124 = mActivePhone.getCdmaPrlVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1346377124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346377124;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.311 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "9F3394FD5793D844B9BB013C1C5881DF")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_486347145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_486347145 = mActivePhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_486347145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_486347145;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.311 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "09935C20562D39A9840DC08A7F8E9EB5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.312 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "7D7EA601AB432C60ADAE7F3CBBF7881B")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_355959893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_355959893 = mActivePhone.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_355959893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_355959893;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.312 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "C56EDF70EE5F0753EA8794C3001A353C")
    public int getVoiceMessageCount() {
        int varC9B97605CE24C2BC7E55AC0885C61958_1139160892 = (mActivePhone.getVoiceMessageCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013852489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013852489;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMessageCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.312 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "68CA6B615BEFA4305D0B6E6EA28ADAF4")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2083465097 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2083465097 = mActivePhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_2083465097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2083465097;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.319 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "97A671D392FA68140B94FD7E82C1FEE5")
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.332 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "EC0D35FE8D15C5E9AAEB85332F8B6483")
    public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.332 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "1120B5D491FFB1876BB7A13D90C6882D")
    public void setCallForwardingOption(int commandInterfaceCFReason,
            int commandInterfaceCFAction, String dialingNumber,
            int timerSeconds, Message onComplete) {
        mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
        addTaint(commandInterfaceCFReason);
        addTaint(commandInterfaceCFAction);
        addTaint(dialingNumber.getTaint());
        addTaint(timerSeconds);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            //commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.332 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "FFBF6A9DEC70AA76854616670FBAE969")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.332 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "3791678C450A1B92EBAC4E3409C18225")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.333 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "DB933B65555567AB746FC1ED2481897B")
    public void getCallWaiting(Message onComplete) {
        mActivePhone.getCallWaiting(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getCallWaiting(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.333 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "BD6FE1314F22D353F9B891144D17A54F")
    public void setCallWaiting(boolean enable, Message onComplete) {
        mActivePhone.setCallWaiting(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCallWaiting(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.333 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "ED47A5E576BCAA9C06EB8A135365F6D4")
    public void getAvailableNetworks(Message response) {
        mActivePhone.getAvailableNetworks(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.334 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "544C8A997BB80B6EC3E6A2E957918612")
    public void setNetworkSelectionModeAutomatic(Message response) {
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.334 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "338AD690C706E7EF191C0DDDF7B2010C")
    public void selectNetworkManually(OperatorInfo network, Message response) {
        mActivePhone.selectNetworkManually(network, response);
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.selectNetworkManually(network, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.335 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "42B4C4ACB2ED5698390A5D98323B0350")
    public void setPreferredNetworkType(int networkType, Message response) {
        mActivePhone.setPreferredNetworkType(networkType, response);
        addTaint(networkType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.335 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "2ADA13B86C878DCE6B752F3AE7B7DB51")
    public void getPreferredNetworkType(Message response) {
        mActivePhone.getPreferredNetworkType(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.345 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "3F02CB4A042513635192CF9822F667C2")
    public void getNeighboringCids(Message response) {
        mActivePhone.getNeighboringCids(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.346 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "1EE2F126B765DFFDEDDFDAE8F13A50FA")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.346 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "03177769785620AC24ACDF32DC042030")
    public void setMute(boolean muted) {
        mActivePhone.setMute(muted);
        addTaint(muted);
        // ---------- Original Method ----------
        //mActivePhone.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.346 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "824BA1D9A2D5CE1556C9B18BF2290779")
    public boolean getMute() {
        boolean var1B9136C6599825A7694821391361E39E_1282651149 = (mActivePhone.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729386054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729386054;
        // ---------- Original Method ----------
        //return mActivePhone.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.347 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "5FE50D9B90C14C65E5204A4258C5EA3D")
    public void setEchoSuppressionEnabled(boolean enabled) {
        mActivePhone.setEchoSuppressionEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.347 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "19ED6F229DEC2F2E293FBAC415416E51")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mActivePhone.invokeOemRilRequestRaw(data, response);
        addTaint(data[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.347 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "E6356B46DA998CDBC954136C7E0CE025")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.348 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "A105062AA84AB35225103828B6B4BAB5")
    public void getDataCallList(Message response) {
        mActivePhone.getDataCallList(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.348 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        // ---------- Original Method ----------
        //mActivePhone.updateServiceLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.348 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.358 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.359 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "D6867E9D55823B9E2E9B116D991405D3")
    public void setUnitTestMode(boolean f) {
        mActivePhone.setUnitTestMode(f);
        addTaint(f);
        // ---------- Original Method ----------
        //mActivePhone.setUnitTestMode(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.426 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "95C050497FF455FBD3FFBF0E5E178B3E")
    public boolean getUnitTestMode() {
        boolean varE57924CD4DCE3E1FC1150866D669EFEB_1229313969 = (mActivePhone.getUnitTestMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746865201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746865201;
        // ---------- Original Method ----------
        //return mActivePhone.getUnitTestMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.427 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "EC122FDC46515809E675B27A9720B1A4")
    public void setBandMode(int bandMode, Message response) {
        mActivePhone.setBandMode(bandMode, response);
        addTaint(bandMode);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.434 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "2868629EDEC523545BE9A1C205928F25")
    public void queryAvailableBandMode(Message response) {
        mActivePhone.queryAvailableBandMode(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.435 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "F67A793A790CCE352E077603A69A2C47")
    public boolean getDataRoamingEnabled() {
        boolean var25967ADD269A46D57FF30D567DD05A9D_1302072552 = (mActivePhone.getDataRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975916361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975916361;
        // ---------- Original Method ----------
        //return mActivePhone.getDataRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.435 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "33718B3767BF9960A57EC52790ED0ED1")
    public void setDataRoamingEnabled(boolean enable) {
        mActivePhone.setDataRoamingEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mActivePhone.setDataRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.435 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "A29117D2169347E0F382FBD9FE39BF9C")
    public void queryCdmaRoamingPreference(Message response) {
        mActivePhone.queryCdmaRoamingPreference(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.435 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "7E65859B3CF01F568233499E3F3AEF67")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.436 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "FD089ED025B112FF5E0976B225150FEC")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        addTaint(cdmaSubscriptionType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.436 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "DF0DE6CA3372F7DB043D4363F0F575B5")
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varB4EAC82CA7396A68D541C85D26508E83_1071602527 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1071602527 = mActivePhone.getSimulatedRadioControl();
        varB4EAC82CA7396A68D541C85D26508E83_1071602527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1071602527;
        // ---------- Original Method ----------
        //return mActivePhone.getSimulatedRadioControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.436 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "16FFD07C725AD3F65C758C2FF048290C")
    public int enableApnType(String type) {
        int varA930C257BD4665C868EA6EF284E5FAB4_1486558027 = (mActivePhone.enableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047758861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047758861;
        // ---------- Original Method ----------
        //return mActivePhone.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.446 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "636391FA8F43272B000C0F4CBCBCCFB5")
    public int disableApnType(String type) {
        int var0EE96BBA6B6E6339EB47881723DB0B34_441904258 = (mActivePhone.disableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658070731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658070731;
        // ---------- Original Method ----------
        //return mActivePhone.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.448 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "78BBC472F5F2DA5DB39F065D5992A153")
    public boolean isDataConnectivityPossible() {
        boolean varFD50EE22A236A635A1A5E6ECDDC3AD83_6651130 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840704994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840704994;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.448 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "3F9364E47BD06B4F22749C5E975BCE46")
    public boolean isDataConnectivityPossible(String apnType) {
        boolean var7B46E2C66CD7327260F34CAEEF4F7C05_1485793753 = (mActivePhone.isDataConnectivityPossible(apnType));
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518864277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518864277;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.449 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "D6F82C1DEE5CE9FC1D83DD22500FA040")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1356671671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1356671671 = mActivePhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_1356671671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356671671;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.449 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "9B631D6E5AC408B6B247B20073184129")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1886542130 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1886542130 = mActivePhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1886542130.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1886542130;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.451 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "068CEDEA8C8DCD6F07C0B53312B1FB64")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_64463898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_64463898 = mActivePhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_64463898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_64463898;
        // ---------- Original Method ----------
        //return mActivePhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.456 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "8F10E4E0D3EFD5A1C45D624811672135")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1252291347 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1252291347 = mActivePhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1252291347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1252291347;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.470 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "AF4F91580E77D12065A5754F331E7EE4")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1538251883 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1538251883 = mActivePhone.getEsn();
        varB4EAC82CA7396A68D541C85D26508E83_1538251883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538251883;
        // ---------- Original Method ----------
        //return mActivePhone.getEsn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.471 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "BD1DE3E796C292F7EE7F7FBFE6F25EEE")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_396457466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_396457466 = mActivePhone.getMeid();
        varB4EAC82CA7396A68D541C85D26508E83_396457466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_396457466;
        // ---------- Original Method ----------
        //return mActivePhone.getMeid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.471 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "4745D5E2136EAE00C166CFB6F6368FD4")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_3251239 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_3251239 = mActivePhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_3251239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3251239;
        // ---------- Original Method ----------
        //return mActivePhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.472 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "4719149EF75810CDDBADF871ED0660FA")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_46541383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_46541383 = mActivePhone.getImei();
        varB4EAC82CA7396A68D541C85D26508E83_46541383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46541383;
        // ---------- Original Method ----------
        //return mActivePhone.getImei();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.472 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "7CAB51DB3C4E48F1DFD5856B8342E56E")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_651191153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_651191153 = mActivePhone.getPhoneSubInfo();
        varB4EAC82CA7396A68D541C85D26508E83_651191153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651191153;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneSubInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.473 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "37F05C58640F33CFE931A331499070C9")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_524607154 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524607154 = mActivePhone.getIccSmsInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_524607154.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524607154;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSmsInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.473 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "21E36FE1C1F087AB65347B9A5266361E")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1366090378 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1366090378 = mActivePhone.getIccPhoneBookInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_1366090378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366090378;
        // ---------- Original Method ----------
        //return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.474 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "FCBFFF2A9F42577944A80EB95E9A3C0F")
    public void setTTYMode(int ttyMode, Message onComplete) {
        mActivePhone.setTTYMode(ttyMode, onComplete);
        addTaint(ttyMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.474 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "2C80F2739A5BB6BD47E4DDE5927BF72C")
    public void queryTTYMode(Message onComplete) {
        mActivePhone.queryTTYMode(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.474 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "CA56D912809FE4561D39D32B273B518D")
    public void activateCellBroadcastSms(int activate, Message response) {
        mActivePhone.activateCellBroadcastSms(activate, response);
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.activateCellBroadcastSms(activate, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.476 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "8A579B0E9B83E597915DFA694C7C66B0")
    public void getCellBroadcastSmsConfig(Message response) {
        mActivePhone.getCellBroadcastSmsConfig(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getCellBroadcastSmsConfig(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.478 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "E0689A4AEE36BEFC5B654FB47865C2ED")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.482 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        // ---------- Original Method ----------
        //mActivePhone.notifyDataActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.482 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "531D6EA9627B76FB25AC22106E3255F1")
    public void getSmscAddress(Message result) {
        mActivePhone.getSmscAddress(result);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.482 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "9C92DC4F8BBBFBD3B2D3E868202BE242")
    public void setSmscAddress(String address, Message result) {
        mActivePhone.setSmscAddress(address, result);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.482 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "2B384104B9DAC4346A9F1AB26D949AB4")
    public int getCdmaEriIconIndex() {
        int varE8C65943584090697CBEEDCCAFC2799B_284819710 = (mActivePhone.getCdmaEriIconIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158295284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158295284;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.489 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "1B304DDC14027A4F6F61F39FB976F574")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_1848575177 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1848575177 = mActivePhone.getCdmaEriText();
        varB4EAC82CA7396A68D541C85D26508E83_1848575177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1848575177;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.489 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "B68CD080E672D79E859E0D9BC5C02D60")
    public int getCdmaEriIconMode() {
        int var44559B7F040E42DDDD7BF51EF4F1B3DA_875282382 = (mActivePhone.getCdmaEriIconMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124307663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124307663;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.490 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "534A676824447C64412B364AEAF3508D")
    public Phone getActivePhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_2022783936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2022783936 = mActivePhone;
        varB4EAC82CA7396A68D541C85D26508E83_2022783936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022783936;
        // ---------- Original Method ----------
        //return mActivePhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.490 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "962932F0BDF3ED9150F000D60B1B2148")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.502 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        // ---------- Original Method ----------
        //mActivePhone.exitEmergencyCallbackMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.502 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "5FC9BA1EF03AEBB9FB7B7502157D5F07")
    public boolean needsOtaServiceProvisioning() {
        boolean var970502384D9890BA0973B383AB80C6FC_2054391191 = (mActivePhone.needsOtaServiceProvisioning());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99075897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_99075897;
        // ---------- Original Method ----------
        //return mActivePhone.needsOtaServiceProvisioning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.505 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "E45BCD10FFE455F083B6778E3AD9753D")
    public boolean isOtaSpNumber(String dialStr) {
        boolean varB4E5E50A833DA40DB1EDA30167AA00E1_617877672 = (mActivePhone.isOtaSpNumber(dialStr));
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271538647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271538647;
        // ---------- Original Method ----------
        //return mActivePhone.isOtaSpNumber(dialStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.507 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "0A44F33ACDCE543495950F5DF53CAF1D")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForCallWaiting(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForCallWaiting(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.508 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "5B49FB1E17165D5CDB7543200DB7B3D2")
    public void unregisterForCallWaiting(Handler h) {
        mActivePhone.unregisterForCallWaiting(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.508 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "EF515357CB0FB4DFDC8C1D4146D8B2E8")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSignalInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSignalInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.509 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "1EB6FB578E47793A6F8C8134B87E2381")
    public void unregisterForSignalInfo(Handler h) {
        mActivePhone.unregisterForSignalInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.514 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "096D226148C8C13B2674EBACD9393C20")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForDisplayInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.514 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "CB34740909F7AF2330A9DAE7FF2665E7")
    public void unregisterForDisplayInfo(Handler h) {
        mActivePhone.unregisterForDisplayInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.524 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "F31FE56940F77121FDCAF45692AE2EC8")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.524 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "51E323E51FAABD681C3C83B7FB4FEF9B")
    public void unregisterForNumberInfo(Handler h) {
        mActivePhone.unregisterForNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.524 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "1CA77A8012D1B60CC62933A63F0C508B")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.524 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "F31708A5138322E9089BE5C74F37DA0B")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.525 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "0331E412347E804DF54A11837D671FE2")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForLineControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.526 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "8C8E23E61369D2C96B1FA81AD8537249")
    public void unregisterForLineControlInfo(Handler h) {
        mActivePhone.unregisterForLineControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.526 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "898F85E1EAA161385D8D7E844BAD0BBE")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.526 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6373243788B2F3CD175FA2B64F781E67")
    public void unregisterForT53ClirInfo(Handler h) {
        mActivePhone.unregisterForT53ClirInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.526 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "BE08C47AC314A6BE8322FA08A7DA38DC")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.531 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "9B3F662BDB49240939E52A0602AE63E0")
    public void unregisterForT53AudioControlInfo(Handler h) {
        mActivePhone.unregisterForT53AudioControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.532 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "226CAE1026073642B9FAA2D282D6394B")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.532 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "5BBDD3BA0A72F11B9ADC7085CBD4B4E4")
    public void unsetOnEcbModeExitResponse(Handler h) {
        mActivePhone.unsetOnEcbModeExitResponse(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.533 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "559A9E0027C7FC0133727AC2EA815D0E")
    public boolean isCspPlmnEnabled() {
        boolean var202889D1FB2BEDDDD330D07A42C96AAA_1203683290 = (mActivePhone.isCspPlmnEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363161000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363161000;
        // ---------- Original Method ----------
        //return mActivePhone.isCspPlmnEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.533 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "5D27C0ACB4F5ACB4F25F44E1EF81E2E5")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_2012805121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012805121 = mActivePhone.getIsimRecords();
        varB4EAC82CA7396A68D541C85D26508E83_2012805121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012805121;
        // ---------- Original Method ----------
        //return mActivePhone.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.541 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "68362B88CED1C39CC89FB6DC764100DB")
    public void requestIsimAuthentication(String nonce, Message response) {
        mActivePhone.requestIsimAuthentication(nonce, response);
        addTaint(nonce.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.requestIsimAuthentication(nonce, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.542 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "66E05380D8535D6CF2FD69C8F0B8356A")
    @Override
    public int getLteOnCdmaMode() {
        int varC068356BB4D68BB6F09FF66311887211_2057475956 = (mActivePhone.getLteOnCdmaMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307749420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307749420;
        // ---------- Original Method ----------
        //return mActivePhone.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.556 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "CB617AE9F52618A80DC2D07579BC0ACC")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        addTaint(line);
        addTaint(countWaiting);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "6AC4402A419E268A93F43132102D405E")
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_1242948102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242948102 = mActivePhone.getUsimServiceTable();
        varB4EAC82CA7396A68D541C85D26508E83_1242948102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242948102;
        // ---------- Original Method ----------
        //return mActivePhone.getUsimServiceTable();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "D265743C68392037CBF15E907FEED16C", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "5796FC476F17BB03669177DD4AF60580", hash_generated_field = "CB1657852647FB6E5750A9AC08E67790")

    private static int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.557 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "A92D635E73640822116CDBF982E76189")

    private static String LOG_TAG = "PHONE";
}

