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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "10728AB9087E7707D37847A2389DDE0C", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")

    private Phone mActivePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "7ECE7371C43BE14D2A55B339F95D5963", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "1807C68F8FB5F577A66C3A94E5AD0A66", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "21B855B7AFB6C39284AC629A5ACDC28A", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "18F20DD2807A52A04EA2B70117648163", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "4A5BFF6E8716B82AA5C82CBE6B802317", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_field = "B37050DAC53073D34B96D1CA70F3C3FE", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")

    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.721 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "172604CCF05E7950C338A2F8CB3563A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.723 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "6E9C8A1A39CD8FAEC6D706234CE38E38")
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
                boolean var01B1DDE89E6E9D2BC475F5FFE0326C76_32309261 = (mCommandsInterface.getRadioState().isOn());
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
            boolean var567788BF435FAFE5B3B27D51A9536128_1118948110 = (mOutgoingPhone.equals("GSM"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.730 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "899787231BCA01A7396F4419198778C0")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_168388863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_168388863 = mActivePhone.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_168388863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_168388863;
        // ---------- Original Method ----------
        //return mActivePhone.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.730 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "BA3A4E6EEEB9EEBCB99F50C54AD51E6F")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1634895228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1634895228 = mActivePhone.getCellLocation();
        varB4EAC82CA7396A68D541C85D26508E83_1634895228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634895228;
        // ---------- Original Method ----------
        //return mActivePhone.getCellLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.732 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "35F61EACCDF588F57C838B1D054C82D0")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1891396108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1891396108 = mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
        varB4EAC82CA7396A68D541C85D26508E83_1891396108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1891396108;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.732 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "3275D8BEFDF5B82E6561551EC7510ABC")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1127590302 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1127590302 = mActivePhone.getDataConnectionState(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1127590302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127590302;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.737 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "1C6385A2EEF6761613908146E19B82ED")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_779552883 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_779552883 = mActivePhone.getDataActivityState();
        varB4EAC82CA7396A68D541C85D26508E83_779552883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_779552883;
        // ---------- Original Method ----------
        //return mActivePhone.getDataActivityState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.748 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "D840AFDA480772183586E87C43CC655F")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_2025988077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025988077 = mActivePhone.getContext();
        varB4EAC82CA7396A68D541C85D26508E83_2025988077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025988077;
        // ---------- Original Method ----------
        //return mActivePhone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.749 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "12BC90EEF277A18257AF7C2DE1C4FCC5")
    public void disableDnsCheck(boolean b) {
        mActivePhone.disableDnsCheck(b);
        addTaint(b);
        // ---------- Original Method ----------
        //mActivePhone.disableDnsCheck(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.749 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "0CFB78A26ED51EECB1F92F042DC032D3")
    public boolean isDnsCheckDisabled() {
        boolean var63BCDE066CAA6ED52BCDEA8E29F6B1DB_1794175061 = (mActivePhone.isDnsCheckDisabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913807663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_913807663;
        // ---------- Original Method ----------
        //return mActivePhone.isDnsCheckDisabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.749 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "302816CDA0C7610FDF995C8531F11BDB")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_382380713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_382380713 = mActivePhone.getState();
        varB4EAC82CA7396A68D541C85D26508E83_382380713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_382380713;
        // ---------- Original Method ----------
        //return mActivePhone.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.750 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "09A5E2A907FB768394D40252749A4448")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_484498060 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484498060 = mActivePhone.getPhoneName();
        varB4EAC82CA7396A68D541C85D26508E83_484498060.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484498060;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.750 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "27434CE4D1E87FB03284A02C3594AEF3")
    public int getPhoneType() {
        int varB5C5EFC4899F813B21E51CD745860764_101107866 = (mActivePhone.getPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430497597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430497597;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.751 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "210DF7BF0EA1D9A13203EC018EB61035")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_795074356 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_795074356 = mActivePhone.getActiveApnTypes();
        varB4EAC82CA7396A68D541C85D26508E83_795074356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_795074356;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.751 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "95C86EBDFE1294D859D54DB3A335916F")
    public String getActiveApnHost(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_1601836982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1601836982 = mActivePhone.getActiveApnHost(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1601836982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1601836982;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnHost(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.752 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "8F765F0A6BC20AE29A8BF0E6A6878D9E")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_236695609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_236695609 = mActivePhone.getLinkProperties(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_236695609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_236695609;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.752 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "7F65D1625ED73347D76D60D055421B2B")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1122931982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1122931982 = mActivePhone.getLinkCapabilities(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1122931982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1122931982;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.752 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "3F21E5162C969785F50A33D3ECA76396")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1534615330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1534615330 = mActivePhone.getSignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_1534615330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534615330;
        // ---------- Original Method ----------
        //return mActivePhone.getSignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.834 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "0A778903A47B585997135EB90EFB1A2E")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForUnknownConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.835 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "A62EA4EE5DCC3535F73043A26E2A6E00")
    public void unregisterForUnknownConnection(Handler h) {
        mActivePhone.unregisterForUnknownConnection(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForUnknownConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.835 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "BD90B464D7F48957F5E493B9821F8F45")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.844 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "A3D02AC85ECF46AFD6E92D7232F9C7F0")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.844 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "8B2C815F2AEC0DF08723519C4961C421")
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.844 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "F2B7CEECA0990E6BCF890D38858DB097")
    public void unregisterForNewRingingConnection(Handler h) {
        mActivePhone.unregisterForNewRingingConnection(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNewRingingConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.845 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "CD83B995B52B7399A5DC0C2E0AB14A2D")
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForIncomingRing(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForIncomingRing(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.845 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "95EE9BE9CE659C968337D8D8E98213D2")
    public void unregisterForIncomingRing(Handler h) {
        mActivePhone.unregisterForIncomingRing(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForIncomingRing(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.846 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "15B884DEA7639824B1002059F98ABC3C")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForDisconnect(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForDisconnect(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.848 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "16A3F8A21DA8BA0B5A5FDA5CE76C349D")
    public void unregisterForDisconnect(Handler h) {
        mActivePhone.unregisterForDisconnect(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisconnect(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.849 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "C08E7F4516CA51425DCCEBDE903386E0")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForMmiInitiate(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.849 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "84035DF796FD0C10E7DA9B84741D8D1E")
    public void unregisterForMmiInitiate(Handler h) {
        mActivePhone.unregisterForMmiInitiate(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiInitiate(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.849 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "AB506367220C419A55055246197B1422")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForMmiComplete(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiComplete(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.854 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "9AAE8E1EA56996141991AEC7411A206F")
    public void unregisterForMmiComplete(Handler h) {
        mActivePhone.unregisterForMmiComplete(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiComplete(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.857 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "A063E2DF9630201E8203AD733E3DF5F3")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_986103158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_986103158 = mActivePhone.getPendingMmiCodes();
        varB4EAC82CA7396A68D541C85D26508E83_986103158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_986103158;
        // ---------- Original Method ----------
        //return mActivePhone.getPendingMmiCodes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.857 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "A73D74E228A137BC0C7763B780A9F4D6")
    public void sendUssdResponse(String ussdMessge) {
        mActivePhone.sendUssdResponse(ussdMessge);
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.sendUssdResponse(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.857 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "2F94D9E9F161D9D20FBE7533697DCD5A")
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.863 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "6C7FA493450DC1D160FDC964EE74DD2E")
    public void unregisterForServiceStateChanged(Handler h) {
        mActivePhone.unregisterForServiceStateChanged(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForServiceStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.879 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "FD68A583C184BD40156564AA3A4267C7")
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.885 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "FA098B3E1CAFECC3DE5B65F323FBAAF0")
    public void unregisterForSuppServiceNotification(Handler h) {
        mActivePhone.unregisterForSuppServiceNotification(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceNotification(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.886 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "1486F05A02C60FAFDB41F42D61ABECF9")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.886 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "8CEE8AD71BDD7D63CA8D6490AD4C0642")
    public void unregisterForSuppServiceFailed(Handler h) {
        mActivePhone.unregisterForSuppServiceFailed(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceFailed(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.886 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "8D520B4600301BE861E3557EDE21CE60")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.887 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "1C1407AE3FBBD4E0238CACFD5568D821")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.887 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "3C26F23326FD7F6B6872A86AE705A81F")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.888 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "5E74C2F8B096B1ABE4A018A4F1C083BC")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.888 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "EA3342A25B64083E7A72BD041E739E28")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.889 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "0559D05B53A3A87B466B627FC931E10D")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.889 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "1EA746138A160CC542499B2F04E83BF1")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.911 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "0BBDFDB43103DFBCE9CA64C53135DB75")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.911 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "FE25BCAB55088F9F99E0F11951EF86E0")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.911 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "69A5CE1244CB03A15DDC5D5E2D9DDC01")
    public void unregisterForEcmTimerReset(Handler h) {
        mActivePhone.unregisterForEcmTimerReset(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForEcmTimerReset(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.912 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "6DE2A901846E672A01CE61169A519F29")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForRingbackTone(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.912 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "6D4D33A7ABBA473F4DED2C5241D4192E")
    public void unregisterForRingbackTone(Handler h) {
        mActivePhone.unregisterForRingbackTone(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.912 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "E2C36C2DD359ED8D3D3F93FD7EC8C91A")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForResendIncallMute(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.912 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "F2F74CF08EE7A5F75CEBC38B30029822")
    public void unregisterForResendIncallMute(Handler h) {
        mActivePhone.unregisterForResendIncallMute(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.913 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "4B0837C2F0527100BB96A5D34F6CE8C3")
    public boolean getIccRecordsLoaded() {
        boolean varD34CD95BD9903759FA66B479DE10B32C_1439153191 = (mActivePhone.getIccRecordsLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517101424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517101424;
        // ---------- Original Method ----------
        //return mActivePhone.getIccRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.918 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "BA6827039BC531CA11DCB9D67ECFD1B3")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_825983491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_825983491 = mActivePhone.getIccCard();
        varB4EAC82CA7396A68D541C85D26508E83_825983491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825983491;
        // ---------- Original Method ----------
        //return mActivePhone.getIccCard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.918 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        // ---------- Original Method ----------
        //mActivePhone.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.918 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        // ---------- Original Method ----------
        //mActivePhone.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.919 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        // ---------- Original Method ----------
        //mActivePhone.switchHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.919 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "A7D622C600E1D6ECB550D4133FA362D0")
    public boolean canConference() {
        boolean varBEBBDC11FE20620D331255B29CB7C083_1156939146 = (mActivePhone.canConference());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845224611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845224611;
        // ---------- Original Method ----------
        //return mActivePhone.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.919 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    public void conference() throws CallStateException {
        mActivePhone.conference();
        // ---------- Original Method ----------
        //mActivePhone.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.919 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "0E3A6CB3D95038181ABB1A4B3DD74C43")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.920 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "5FCAA5609FA42CF2896E93517B5760C8")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.920 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "447DF17375FE476E9FC4DB6F4AAAFC96")
    public boolean canTransfer() {
        boolean varA271678BA825E5B535929271849B2922_1062252646 = (mActivePhone.canTransfer());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38339834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_38339834;
        // ---------- Original Method ----------
        //return mActivePhone.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.920 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        // ---------- Original Method ----------
        //mActivePhone.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.920 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        // ---------- Original Method ----------
        //mActivePhone.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.921 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "80AD2BB859CD8542811619460125132A")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_2054459032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2054459032 = mActivePhone.getForegroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_2054459032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2054459032;
        // ---------- Original Method ----------
        //return mActivePhone.getForegroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.921 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "A4446E994460F8060C10E208F27A1216")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_168048181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_168048181 = mActivePhone.getBackgroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_168048181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_168048181;
        // ---------- Original Method ----------
        //return mActivePhone.getBackgroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.931 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "9979A738200AEA65C0D4627D8CBA9C3F")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_603093727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_603093727 = mActivePhone.getRingingCall();
        varB4EAC82CA7396A68D541C85D26508E83_603093727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603093727;
        // ---------- Original Method ----------
        //return mActivePhone.getRingingCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.932 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "EE0558CC1E6674DDD8FCE2DD18206452")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1423887987 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1423887987 = mActivePhone.dial(dialString);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1423887987.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423887987;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.932 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "0DE20895C5BDA13C5D776A8CDD46A8E9")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1344957537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1344957537 = mActivePhone.dial(dialString, uusInfo);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1344957537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344957537;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.932 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "0937D161CD456B48C2138E21D0220914")
    public boolean handlePinMmi(String dialString) {
        boolean var9EAF3797F0895E045EDD8A2A6F3E9DC3_1411977116 = (mActivePhone.handlePinMmi(dialString));
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158446719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158446719;
        // ---------- Original Method ----------
        //return mActivePhone.handlePinMmi(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.933 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "12EB97FF086E0EA0A0D7F28B18ADBECC")
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        boolean varB6713A0B25EC29F71205412BEAB34760_2139812098 = (mActivePhone.handleInCallMmiCommands(command));
        addTaint(command.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734664012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_734664012;
        // ---------- Original Method ----------
        //return mActivePhone.handleInCallMmiCommands(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.933 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "02BB7D3CC2467916072825823BC7F612")
    public void sendDtmf(char c) {
        mActivePhone.sendDtmf(c);
        addTaint(c);
        // ---------- Original Method ----------
        //mActivePhone.sendDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.933 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "F52C933F3F6210EBC4ADD57A96877685")
    public void startDtmf(char c) {
        mActivePhone.startDtmf(c);
        addTaint(c);
        // ---------- Original Method ----------
        //mActivePhone.startDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.933 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        // ---------- Original Method ----------
        //mActivePhone.stopDtmf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.934 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "D9D52A0A56C9B8E1D8FDC379A00959A4")
    public void setRadioPower(boolean power) {
        mActivePhone.setRadioPower(power);
        addTaint(power);
        // ---------- Original Method ----------
        //mActivePhone.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.934 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "46F6FE0211A98F22350E5550F79AC470")
    public boolean getMessageWaitingIndicator() {
        boolean varE36CE85276F33DCC5B02481874938DBC_1600047811 = (mActivePhone.getMessageWaitingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974125155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974125155;
        // ---------- Original Method ----------
        //return mActivePhone.getMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.934 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "346BFB4983F517D837C4472D92A16871")
    public boolean getCallForwardingIndicator() {
        boolean var711465E26D829245ADB92E0313FED47F_209407994 = (mActivePhone.getCallForwardingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847281053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847281053;
        // ---------- Original Method ----------
        //return mActivePhone.getCallForwardingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.935 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "256B977B52A1A3A1F77B696AF42375B7")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_952328274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_952328274 = mActivePhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_952328274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952328274;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.948 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "849646381507F0F7BCF2BCE16A1761E4")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_1793569671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1793569671 = mActivePhone.getCdmaMin();
        varB4EAC82CA7396A68D541C85D26508E83_1793569671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793569671;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.948 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "9ED656A3740869BF7E7B3E05FDE66407")
    public boolean isMinInfoReady() {
        boolean varBADBA5710877FFB10FBC68610BD4AFC0_633092542 = (mActivePhone.isMinInfoReady());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857722175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857722175;
        // ---------- Original Method ----------
        //return mActivePhone.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.949 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "A830D49A8FA703AA472FB526CF569571")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1927813231 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1927813231 = mActivePhone.getCdmaPrlVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1927813231.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1927813231;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.949 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "CB5AEADBDC45D99FB035BB97408E1412")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_499012981 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_499012981 = mActivePhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_499012981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499012981;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.949 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "09935C20562D39A9840DC08A7F8E9EB5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.950 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "709143AB2EFD073974FB840BCB49BC25")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1140865282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1140865282 = mActivePhone.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1140865282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1140865282;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.950 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "2D1480BCB09CDB40A2512E4D67C0C24D")
    public int getVoiceMessageCount() {
        int varC9B97605CE24C2BC7E55AC0885C61958_935086145 = (mActivePhone.getVoiceMessageCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174027123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174027123;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMessageCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.950 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "E7D663886F5F5EA572A1879890DA6FA7")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1385079578 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385079578 = mActivePhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1385079578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385079578;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.951 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "97A671D392FA68140B94FD7E82C1FEE5")
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.960 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "EC0D35FE8D15C5E9AAEB85332F8B6483")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.960 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "1120B5D491FFB1876BB7A13D90C6882D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.960 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "FFBF6A9DEC70AA76854616670FBAE969")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.961 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "3791678C450A1B92EBAC4E3409C18225")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.961 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "DB933B65555567AB746FC1ED2481897B")
    public void getCallWaiting(Message onComplete) {
        mActivePhone.getCallWaiting(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getCallWaiting(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.961 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "BD6FE1314F22D353F9B891144D17A54F")
    public void setCallWaiting(boolean enable, Message onComplete) {
        mActivePhone.setCallWaiting(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCallWaiting(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.962 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "ED47A5E576BCAA9C06EB8A135365F6D4")
    public void getAvailableNetworks(Message response) {
        mActivePhone.getAvailableNetworks(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.962 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "544C8A997BB80B6EC3E6A2E957918612")
    public void setNetworkSelectionModeAutomatic(Message response) {
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.962 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "338AD690C706E7EF191C0DDDF7B2010C")
    public void selectNetworkManually(OperatorInfo network, Message response) {
        mActivePhone.selectNetworkManually(network, response);
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.selectNetworkManually(network, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.962 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "42B4C4ACB2ED5698390A5D98323B0350")
    public void setPreferredNetworkType(int networkType, Message response) {
        mActivePhone.setPreferredNetworkType(networkType, response);
        addTaint(networkType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.963 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "2ADA13B86C878DCE6B752F3AE7B7DB51")
    public void getPreferredNetworkType(Message response) {
        mActivePhone.getPreferredNetworkType(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.963 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "3F02CB4A042513635192CF9822F667C2")
    public void getNeighboringCids(Message response) {
        mActivePhone.getNeighboringCids(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.963 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "1EE2F126B765DFFDEDDFDAE8F13A50FA")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.963 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "03177769785620AC24ACDF32DC042030")
    public void setMute(boolean muted) {
        mActivePhone.setMute(muted);
        addTaint(muted);
        // ---------- Original Method ----------
        //mActivePhone.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.964 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "93059CEC5FBD210C20C8A28EBB0EDAD5")
    public boolean getMute() {
        boolean var1B9136C6599825A7694821391361E39E_1998564432 = (mActivePhone.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671570536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671570536;
        // ---------- Original Method ----------
        //return mActivePhone.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.964 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "5FE50D9B90C14C65E5204A4258C5EA3D")
    public void setEchoSuppressionEnabled(boolean enabled) {
        mActivePhone.setEchoSuppressionEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.964 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "19ED6F229DEC2F2E293FBAC415416E51")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mActivePhone.invokeOemRilRequestRaw(data, response);
        addTaint(data[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.964 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "E6356B46DA998CDBC954136C7E0CE025")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.982 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "A105062AA84AB35225103828B6B4BAB5")
    public void getDataCallList(Message response) {
        mActivePhone.getDataCallList(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.983 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        // ---------- Original Method ----------
        //mActivePhone.updateServiceLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.983 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.983 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.983 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "D6867E9D55823B9E2E9B116D991405D3")
    public void setUnitTestMode(boolean f) {
        mActivePhone.setUnitTestMode(f);
        addTaint(f);
        // ---------- Original Method ----------
        //mActivePhone.setUnitTestMode(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.983 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "C6AE5C805C85BC07E30EF9B807AB8846")
    public boolean getUnitTestMode() {
        boolean varE57924CD4DCE3E1FC1150866D669EFEB_428206864 = (mActivePhone.getUnitTestMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370660869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370660869;
        // ---------- Original Method ----------
        //return mActivePhone.getUnitTestMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.984 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "EC122FDC46515809E675B27A9720B1A4")
    public void setBandMode(int bandMode, Message response) {
        mActivePhone.setBandMode(bandMode, response);
        addTaint(bandMode);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.984 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "2868629EDEC523545BE9A1C205928F25")
    public void queryAvailableBandMode(Message response) {
        mActivePhone.queryAvailableBandMode(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.984 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "6C6C170FE6878702ED0F3913FD5BAC36")
    public boolean getDataRoamingEnabled() {
        boolean var25967ADD269A46D57FF30D567DD05A9D_1023499050 = (mActivePhone.getDataRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535022476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535022476;
        // ---------- Original Method ----------
        //return mActivePhone.getDataRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.984 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "33718B3767BF9960A57EC52790ED0ED1")
    public void setDataRoamingEnabled(boolean enable) {
        mActivePhone.setDataRoamingEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mActivePhone.setDataRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.007 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "A29117D2169347E0F382FBD9FE39BF9C")
    public void queryCdmaRoamingPreference(Message response) {
        mActivePhone.queryCdmaRoamingPreference(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.008 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "7E65859B3CF01F568233499E3F3AEF67")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.008 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "FD089ED025B112FF5E0976B225150FEC")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        addTaint(cdmaSubscriptionType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.009 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "3E4312AB781EA6575F8C61F4F5B87FC0")
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varB4EAC82CA7396A68D541C85D26508E83_1207077785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1207077785 = mActivePhone.getSimulatedRadioControl();
        varB4EAC82CA7396A68D541C85D26508E83_1207077785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207077785;
        // ---------- Original Method ----------
        //return mActivePhone.getSimulatedRadioControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.009 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "4A626A0640C55A8CAFF9DD91171A8E7D")
    public int enableApnType(String type) {
        int varA930C257BD4665C868EA6EF284E5FAB4_1796464776 = (mActivePhone.enableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822200828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822200828;
        // ---------- Original Method ----------
        //return mActivePhone.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.010 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "B48024BDE4C1F9DF2097F4FE4D52FA41")
    public int disableApnType(String type) {
        int var0EE96BBA6B6E6339EB47881723DB0B34_727700317 = (mActivePhone.disableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657137965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657137965;
        // ---------- Original Method ----------
        //return mActivePhone.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.011 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "E04338277A84F165057B2D07F627DE66")
    public boolean isDataConnectivityPossible() {
        boolean varFD50EE22A236A635A1A5E6ECDDC3AD83_1588925957 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001028509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001028509;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.011 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "6DED3EDA98A7F142452F17A85603AD7B")
    public boolean isDataConnectivityPossible(String apnType) {
        boolean var7B46E2C66CD7327260F34CAEEF4F7C05_365681976 = (mActivePhone.isDataConnectivityPossible(apnType));
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979494377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979494377;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.012 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "C66F501BB550268AA853159288A983C0")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_87749489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_87749489 = mActivePhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_87749489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87749489;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.012 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "7EAD90D3C551BFDCA02AC137EB37AE7B")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1640819029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1640819029 = mActivePhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1640819029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1640819029;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.012 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "E295307529F5158DA497B9D4A61F8642")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_2026669044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2026669044 = mActivePhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_2026669044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2026669044;
        // ---------- Original Method ----------
        //return mActivePhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.013 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "DD1AC844F56157417B95AE4BC8804913")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_313153814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_313153814 = mActivePhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_313153814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_313153814;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.013 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "09494A6284B94785C2A8B03222AEED22")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1649755767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649755767 = mActivePhone.getEsn();
        varB4EAC82CA7396A68D541C85D26508E83_1649755767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649755767;
        // ---------- Original Method ----------
        //return mActivePhone.getEsn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.014 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "0F83844B04EAF15B2B0FBFC6B342A2B7")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_6991151 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_6991151 = mActivePhone.getMeid();
        varB4EAC82CA7396A68D541C85D26508E83_6991151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_6991151;
        // ---------- Original Method ----------
        //return mActivePhone.getMeid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.014 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "5C9D145A3F0186D8769BF0183E23E647")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_2039337575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2039337575 = mActivePhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_2039337575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2039337575;
        // ---------- Original Method ----------
        //return mActivePhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.015 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "5A24B2E3A8F6978222D517EEEDE8C13B")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1817577281 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1817577281 = mActivePhone.getImei();
        varB4EAC82CA7396A68D541C85D26508E83_1817577281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817577281;
        // ---------- Original Method ----------
        //return mActivePhone.getImei();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.028 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "6F90F38AF6024BFAB86ACE7F4C5EBBC5")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_609870790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_609870790 = mActivePhone.getPhoneSubInfo();
        varB4EAC82CA7396A68D541C85D26508E83_609870790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609870790;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneSubInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.028 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "FABECFF37CD40292AF196D91B5B6B557")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_734438484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_734438484 = mActivePhone.getIccSmsInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_734438484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_734438484;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSmsInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.029 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "6281EFE519E69BB09EB6D908109C2DCD")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_460082912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_460082912 = mActivePhone.getIccPhoneBookInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_460082912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_460082912;
        // ---------- Original Method ----------
        //return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.030 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "FCBFFF2A9F42577944A80EB95E9A3C0F")
    public void setTTYMode(int ttyMode, Message onComplete) {
        mActivePhone.setTTYMode(ttyMode, onComplete);
        addTaint(ttyMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.049 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "2C80F2739A5BB6BD47E4DDE5927BF72C")
    public void queryTTYMode(Message onComplete) {
        mActivePhone.queryTTYMode(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.050 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "CA56D912809FE4561D39D32B273B518D")
    public void activateCellBroadcastSms(int activate, Message response) {
        mActivePhone.activateCellBroadcastSms(activate, response);
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.activateCellBroadcastSms(activate, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.050 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "8A579B0E9B83E597915DFA694C7C66B0")
    public void getCellBroadcastSmsConfig(Message response) {
        mActivePhone.getCellBroadcastSmsConfig(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getCellBroadcastSmsConfig(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.050 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "E0689A4AEE36BEFC5B654FB47865C2ED")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.050 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        // ---------- Original Method ----------
        //mActivePhone.notifyDataActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.051 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "531D6EA9627B76FB25AC22106E3255F1")
    public void getSmscAddress(Message result) {
        mActivePhone.getSmscAddress(result);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.051 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "9C92DC4F8BBBFBD3B2D3E868202BE242")
    public void setSmscAddress(String address, Message result) {
        mActivePhone.setSmscAddress(address, result);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.051 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "B34A55A987D308B02CDA3D4674509A2E")
    public int getCdmaEriIconIndex() {
        int varE8C65943584090697CBEEDCCAFC2799B_355203680 = (mActivePhone.getCdmaEriIconIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267815478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267815478;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.052 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "87CF3F842434A36B81A6FDEBEAF9EE9D")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_722388565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_722388565 = mActivePhone.getCdmaEriText();
        varB4EAC82CA7396A68D541C85D26508E83_722388565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_722388565;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.052 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "88D20CF83C678DED4374129D0893A256")
    public int getCdmaEriIconMode() {
        int var44559B7F040E42DDDD7BF51EF4F1B3DA_1647460178 = (mActivePhone.getCdmaEriIconMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273307815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273307815;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.053 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "024A772DAAA264958BDC34EED4E944DD")
    public Phone getActivePhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_372065306 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_372065306 = mActivePhone;
        varB4EAC82CA7396A68D541C85D26508E83_372065306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_372065306;
        // ---------- Original Method ----------
        //return mActivePhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.053 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "962932F0BDF3ED9150F000D60B1B2148")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.054 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        // ---------- Original Method ----------
        //mActivePhone.exitEmergencyCallbackMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.054 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "FE2901898820CEAAFD827F78CF6AAF29")
    public boolean needsOtaServiceProvisioning() {
        boolean var970502384D9890BA0973B383AB80C6FC_217515434 = (mActivePhone.needsOtaServiceProvisioning());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928123999 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928123999;
        // ---------- Original Method ----------
        //return mActivePhone.needsOtaServiceProvisioning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.054 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "91ECC05364D996D066E4F63E08E9E2A9")
    public boolean isOtaSpNumber(String dialStr) {
        boolean varB4E5E50A833DA40DB1EDA30167AA00E1_1458737477 = (mActivePhone.isOtaSpNumber(dialStr));
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563768076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563768076;
        // ---------- Original Method ----------
        //return mActivePhone.isOtaSpNumber(dialStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.065 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "0A44F33ACDCE543495950F5DF53CAF1D")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForCallWaiting(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForCallWaiting(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.066 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "5B49FB1E17165D5CDB7543200DB7B3D2")
    public void unregisterForCallWaiting(Handler h) {
        mActivePhone.unregisterForCallWaiting(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.066 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "EF515357CB0FB4DFDC8C1D4146D8B2E8")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForSignalInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForSignalInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.066 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "1EB6FB578E47793A6F8C8134B87E2381")
    public void unregisterForSignalInfo(Handler h) {
        mActivePhone.unregisterForSignalInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.066 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "096D226148C8C13B2674EBACD9393C20")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForDisplayInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.067 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "CB34740909F7AF2330A9DAE7FF2665E7")
    public void unregisterForDisplayInfo(Handler h) {
        mActivePhone.unregisterForDisplayInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.067 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "F31FE56940F77121FDCAF45692AE2EC8")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.067 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "51E323E51FAABD681C3C83B7FB4FEF9B")
    public void unregisterForNumberInfo(Handler h) {
        mActivePhone.unregisterForNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.067 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "1CA77A8012D1B60CC62933A63F0C508B")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.089 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "F31708A5138322E9089BE5C74F37DA0B")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.089 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "0331E412347E804DF54A11837D671FE2")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForLineControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.089 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "8C8E23E61369D2C96B1FA81AD8537249")
    public void unregisterForLineControlInfo(Handler h) {
        mActivePhone.unregisterForLineControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.091 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "898F85E1EAA161385D8D7E844BAD0BBE")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.092 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6373243788B2F3CD175FA2B64F781E67")
    public void unregisterForT53ClirInfo(Handler h) {
        mActivePhone.unregisterForT53ClirInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.092 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "BE08C47AC314A6BE8322FA08A7DA38DC")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.093 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "9B3F662BDB49240939E52A0602AE63E0")
    public void unregisterForT53AudioControlInfo(Handler h) {
        mActivePhone.unregisterForT53AudioControlInfo(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.093 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "226CAE1026073642B9FAA2D282D6394B")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.093 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "5BBDD3BA0A72F11B9ADC7085CBD4B4E4")
    public void unsetOnEcbModeExitResponse(Handler h) {
        mActivePhone.unsetOnEcbModeExitResponse(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.094 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "1A72C2FD348170FE2ED2E1FF24F2CF33")
    public boolean isCspPlmnEnabled() {
        boolean var202889D1FB2BEDDDD330D07A42C96AAA_1080936456 = (mActivePhone.isCspPlmnEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124442396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_124442396;
        // ---------- Original Method ----------
        //return mActivePhone.isCspPlmnEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.094 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "3EF19BD59E4CD52DD80C50F73DD1146F")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_1715251416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1715251416 = mActivePhone.getIsimRecords();
        varB4EAC82CA7396A68D541C85D26508E83_1715251416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715251416;
        // ---------- Original Method ----------
        //return mActivePhone.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.095 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "68362B88CED1C39CC89FB6DC764100DB")
    public void requestIsimAuthentication(String nonce, Message response) {
        mActivePhone.requestIsimAuthentication(nonce, response);
        addTaint(nonce.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mActivePhone.requestIsimAuthentication(nonce, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.095 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "6A771ECFFE9DE5B256AF0AEAB138114E")
    @Override
    public int getLteOnCdmaMode() {
        int varC068356BB4D68BB6F09FF66311887211_1415823654 = (mActivePhone.getLteOnCdmaMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309271083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309271083;
        // ---------- Original Method ----------
        //return mActivePhone.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.095 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "CB617AE9F52618A80DC2D07579BC0ACC")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        addTaint(line);
        addTaint(countWaiting);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.096 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "0D18D059163AC319DC58D9E92B09ACA4")
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_351274501 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_351274501 = mActivePhone.getUsimServiceTable();
        varB4EAC82CA7396A68D541C85D26508E83_351274501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_351274501;
        // ---------- Original Method ----------
        //return mActivePhone.getUsimServiceTable();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.097 -0400", hash_original_field = "D265743C68392037CBF15E907FEED16C", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.097 -0400", hash_original_field = "5796FC476F17BB03669177DD4AF60580", hash_generated_field = "CB1657852647FB6E5750A9AC08E67790")

    private static int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.097 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "A92D635E73640822116CDBF982E76189")

    private static String LOG_TAG = "PHONE";
}

