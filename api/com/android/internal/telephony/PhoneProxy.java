package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "10728AB9087E7707D37847A2389DDE0C", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")

    private Phone mActivePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "7ECE7371C43BE14D2A55B339F95D5963", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "1807C68F8FB5F577A66C3A94E5AD0A66", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "21B855B7AFB6C39284AC629A5ACDC28A", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "18F20DD2807A52A04EA2B70117648163", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "4A5BFF6E8716B82AA5C82CBE6B802317", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.607 -0400", hash_original_field = "B37050DAC53073D34B96D1CA70F3C3FE", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")

    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.608 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "172604CCF05E7950C338A2F8CB3563A0")
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
        
        
        
                
        
                
        
                
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.609 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "55D323A25C2948A04E9B42A103FE399B")
    @Override
    public void handleMessage(Message msg) {
        
        mOutgoingPhone = mActivePhone.getPhoneName();
        
        
        logd("Switching phone from " + mOutgoingPhone + "Phone to " +
                    (mOutgoingPhone.equals("GSM") ? "CDMAPhone" : "GSMPhone") );
        
        
        boolean oldPowerState = false;
        
        
        {
            {
                boolean var01B1DDE89E6E9D2BC475F5FFE0326C76_767565035 = (mCommandsInterface.getRadioState().isOn());
                {
                    oldPowerState = true;
                    logd("Setting Radio Power to Off");
                    mCommandsInterface.setRadioPower(false, null);
                } 
            } 
        } 
        
        
        {
            boolean var567788BF435FAFE5B3B27D51A9536128_795591296 = (mOutgoingPhone.equals("GSM"));
            {
                logd("Make a new CDMAPhone and destroy the old GSMPhone.");
                ((GSMPhone)mActivePhone).dispose();
                Phone oldPhone = mActivePhone;
                mActivePhone = PhoneFactory.getCdmaPhone();
                ((GSMPhone)oldPhone).removeReferences();
                oldPhone = null;
            } 
            {
                logd("Make a new GSMPhone and destroy the old CDMAPhone.");
                ((CDMAPhone)mActivePhone).dispose();
                Phone oldPhone = mActivePhone;
                mActivePhone = PhoneFactory.getGsmPhone();
                ((CDMAPhone)oldPhone).removeReferences();
                oldPhone = null;
            } 
        } 
        
        
        {
            logd("Resetting Radio");
            mCommandsInterface.setRadioPower(oldPowerState, null);
        } 
        
        
        mIccSmsInterfaceManagerProxy.setmIccSmsInterfaceManager(
                    mActivePhone.getIccSmsInterfaceManager());
        
        
        mIccPhoneBookInterfaceManagerProxy.setmIccPhoneBookInterfaceManager(
                    mActivePhone.getIccPhoneBookInterfaceManager());
        
        
        mPhoneSubInfoProxy.setmPhoneSubInfo(this.mActivePhone.getPhoneSubInfo());
        
        
        mCommandsInterface = ((PhoneBase)mActivePhone).mCM;
        
        
        Intent intent = new Intent(TelephonyIntents.ACTION_RADIO_TECHNOLOGY_CHANGED);
        
        
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        
        
        intent.putExtra(Phone.PHONE_NAME_KEY, mActivePhone.getPhoneName());
        
        
        ActivityManagerNative.broadcastStickyIntent(intent, null);
        
        super.handleMessage(msg);
        addTaint(msg.getTaint());
        
        
    }

    
    private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.610 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "4942FB3EB3D644F824F213172A9CA52E")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_168903840 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_168903840 = mActivePhone.getServiceState();
        varB4EAC82CA7396A68D541C85D26508E83_168903840.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_168903840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.611 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "3E045E5B0BF437F0217E172C3E1CA022")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1428907062 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1428907062 = mActivePhone.getCellLocation();
        varB4EAC82CA7396A68D541C85D26508E83_1428907062.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428907062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.612 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "0BC743FE3235A911B94E4BE434E50BE0")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1483817066 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1483817066 = mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
        varB4EAC82CA7396A68D541C85D26508E83_1483817066.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1483817066;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.612 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "68829F8EF33E1CA0CDE1B98D786B613F")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1079548050 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1079548050 = mActivePhone.getDataConnectionState(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1079548050.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1079548050;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.613 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "A3D06BDCEB3D6382153403292241971E")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_13011136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_13011136 = mActivePhone.getDataActivityState();
        varB4EAC82CA7396A68D541C85D26508E83_13011136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_13011136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.614 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "B39EDB8DD245922E57F3421902E265E4")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1537987298 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1537987298 = mActivePhone.getContext();
        varB4EAC82CA7396A68D541C85D26508E83_1537987298.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1537987298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.614 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "12BC90EEF277A18257AF7C2DE1C4FCC5")
    public void disableDnsCheck(boolean b) {
        mActivePhone.disableDnsCheck(b);
        addTaint(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.615 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "58BAE817961F7A5EC4BBB6DE0B34DC18")
    public boolean isDnsCheckDisabled() {
        boolean var63BCDE066CAA6ED52BCDEA8E29F6B1DB_2115425142 = (mActivePhone.isDnsCheckDisabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591633557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591633557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.616 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "4D5096A8AD67BEA6A83796FFAD28385A")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_810170861 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_810170861 = mActivePhone.getState();
        varB4EAC82CA7396A68D541C85D26508E83_810170861.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_810170861;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.616 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "7D714BAF838B5283E969355421E07365")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_471590603 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_471590603 = mActivePhone.getPhoneName();
        varB4EAC82CA7396A68D541C85D26508E83_471590603.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_471590603;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.617 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "2D90BC19A68E8A82E6315FBBBEBAB18B")
    public int getPhoneType() {
        int varB5C5EFC4899F813B21E51CD745860764_463262318 = (mActivePhone.getPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282012541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282012541;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.617 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "FC3197FDB62D50D08FD97D06665862D0")
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1127748402 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1127748402 = mActivePhone.getActiveApnTypes();
        varB4EAC82CA7396A68D541C85D26508E83_1127748402.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1127748402;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.618 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "4E8C7AD27F26FEAE21A4A1E256E7DBB9")
    public String getActiveApnHost(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_671257613 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_671257613 = mActivePhone.getActiveApnHost(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_671257613.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_671257613;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.618 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "4F822AA183E260FACB2828890D9E0314")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1811401019 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1811401019 = mActivePhone.getLinkProperties(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1811401019.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1811401019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.619 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "7A4064337214E3EB44826C8BCC39E835")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1314080200 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1314080200 = mActivePhone.getLinkCapabilities(apnType);
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1314080200.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1314080200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.619 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "81B283A2DD510C7BEBD6D1F5CDCFD1A0")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1437071041 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1437071041 = mActivePhone.getSignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_1437071041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1437071041;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.620 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "0A778903A47B585997135EB90EFB1A2E")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        
        mActivePhone.registerForUnknownConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.620 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "A62EA4EE5DCC3535F73043A26E2A6E00")
    public void unregisterForUnknownConnection(Handler h) {
        mActivePhone.unregisterForUnknownConnection(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.621 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "BD90B464D7F48957F5E493B9821F8F45")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.621 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "A3D02AC85ECF46AFD6E92D7232F9C7F0")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.622 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "8B2C815F2AEC0DF08723519C4961C421")
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.622 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "F2B7CEECA0990E6BCF890D38858DB097")
    public void unregisterForNewRingingConnection(Handler h) {
        mActivePhone.unregisterForNewRingingConnection(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.623 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "CD83B995B52B7399A5DC0C2E0AB14A2D")
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        
        mActivePhone.registerForIncomingRing(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.624 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "95EE9BE9CE659C968337D8D8E98213D2")
    public void unregisterForIncomingRing(Handler h) {
        mActivePhone.unregisterForIncomingRing(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.625 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "15B884DEA7639824B1002059F98ABC3C")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        
        mActivePhone.registerForDisconnect(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.626 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "16A3F8A21DA8BA0B5A5FDA5CE76C349D")
    public void unregisterForDisconnect(Handler h) {
        mActivePhone.unregisterForDisconnect(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.627 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "C08E7F4516CA51425DCCEBDE903386E0")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        
        mActivePhone.registerForMmiInitiate(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.628 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "84035DF796FD0C10E7DA9B84741D8D1E")
    public void unregisterForMmiInitiate(Handler h) {
        mActivePhone.unregisterForMmiInitiate(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.629 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "AB506367220C419A55055246197B1422")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        
        mActivePhone.registerForMmiComplete(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.630 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "9AAE8E1EA56996141991AEC7411A206F")
    public void unregisterForMmiComplete(Handler h) {
        mActivePhone.unregisterForMmiComplete(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.632 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "3BE4828A5A88EDA1F5F251285CC238A4")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1752829016 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1752829016 = mActivePhone.getPendingMmiCodes();
        varB4EAC82CA7396A68D541C85D26508E83_1752829016.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1752829016;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.633 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "A73D74E228A137BC0C7763B780A9F4D6")
    public void sendUssdResponse(String ussdMessge) {
        mActivePhone.sendUssdResponse(ussdMessge);
        addTaint(ussdMessge.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.634 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "2F94D9E9F161D9D20FBE7533697DCD5A")
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.635 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "6C7FA493450DC1D160FDC964EE74DD2E")
    public void unregisterForServiceStateChanged(Handler h) {
        mActivePhone.unregisterForServiceStateChanged(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.636 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "FD68A583C184BD40156564AA3A4267C7")
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.637 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "FA098B3E1CAFECC3DE5B65F323FBAAF0")
    public void unregisterForSuppServiceNotification(Handler h) {
        mActivePhone.unregisterForSuppServiceNotification(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.637 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "1486F05A02C60FAFDB41F42D61ABECF9")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.638 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "8CEE8AD71BDD7D63CA8D6490AD4C0642")
    public void unregisterForSuppServiceFailed(Handler h) {
        mActivePhone.unregisterForSuppServiceFailed(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.638 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "8D520B4600301BE861E3557EDE21CE60")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.638 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "1C1407AE3FBBD4E0238CACFD5568D821")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.639 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "3C26F23326FD7F6B6872A86AE705A81F")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.639 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "5E74C2F8B096B1ABE4A018A4F1C083BC")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.639 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "EA3342A25B64083E7A72BD041E739E28")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.640 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "0559D05B53A3A87B466B627FC931E10D")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.640 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "1EA746138A160CC542499B2F04E83BF1")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.640 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "0BBDFDB43103DFBCE9CA64C53135DB75")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.641 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "FE25BCAB55088F9F99E0F11951EF86E0")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.641 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "69A5CE1244CB03A15DDC5D5E2D9DDC01")
    public void unregisterForEcmTimerReset(Handler h) {
        mActivePhone.unregisterForEcmTimerReset(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.641 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "6DE2A901846E672A01CE61169A519F29")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        
        mActivePhone.registerForRingbackTone(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.642 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "6D4D33A7ABBA473F4DED2C5241D4192E")
    public void unregisterForRingbackTone(Handler h) {
        mActivePhone.unregisterForRingbackTone(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.642 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "E2C36C2DD359ED8D3D3F93FD7EC8C91A")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        
        mActivePhone.registerForResendIncallMute(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.643 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "F2F74CF08EE7A5F75CEBC38B30029822")
    public void unregisterForResendIncallMute(Handler h) {
        mActivePhone.unregisterForResendIncallMute(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.643 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "9C5E5163EED6E8256F8FE8F87AF9BDB4")
    public boolean getIccRecordsLoaded() {
        boolean varD34CD95BD9903759FA66B479DE10B32C_1567681990 = (mActivePhone.getIccRecordsLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465284757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465284757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.644 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "9C4ED9CE24F2899994AF7949A23F76D2")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_1136693226 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1136693226 = mActivePhone.getIccCard();
        varB4EAC82CA7396A68D541C85D26508E83_1136693226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1136693226;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.644 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.644 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.645 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.645 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "16F427C3E6338F7F5D193A415705284F")
    public boolean canConference() {
        boolean varBEBBDC11FE20620D331255B29CB7C083_1103128619 = (mActivePhone.canConference());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120957290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120957290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.646 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    public void conference() throws CallStateException {
        mActivePhone.conference();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.646 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "0E3A6CB3D95038181ABB1A4B3DD74C43")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.647 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "5FCAA5609FA42CF2896E93517B5760C8")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.647 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "48CD6CB852AF8554918DFA5434E88317")
    public boolean canTransfer() {
        boolean varA271678BA825E5B535929271849B2922_88301955 = (mActivePhone.canTransfer());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413688585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413688585;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.648 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.650 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.653 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "BCF626FA1E3F22F15026F2693406A56B")
    public Call getForegroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1023390417 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1023390417 = mActivePhone.getForegroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_1023390417.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1023390417;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.654 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "D2294F7542A78535175E525C332C6038")
    public Call getBackgroundCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1462104093 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1462104093 = mActivePhone.getBackgroundCall();
        varB4EAC82CA7396A68D541C85D26508E83_1462104093.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1462104093;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.656 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "941B6F5B2084AC9FA2AFBB3889990D37")
    public Call getRingingCall() {
        Call varB4EAC82CA7396A68D541C85D26508E83_1844927459 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1844927459 = mActivePhone.getRingingCall();
        varB4EAC82CA7396A68D541C85D26508E83_1844927459.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1844927459;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.657 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "FBE1A2B3E1410E08366E38629ED6B4CC")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_558636904 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_558636904 = mActivePhone.dial(dialString);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_558636904.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_558636904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.659 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "5C6DF0CD51F4EC8EBEDABB8BA1F922C9")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_270739422 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_270739422 = mActivePhone.dial(dialString, uusInfo);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_270739422.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_270739422;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.660 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "50C72C0C676C2B62EA4A84523E7CD905")
    public boolean handlePinMmi(String dialString) {
        boolean var9EAF3797F0895E045EDD8A2A6F3E9DC3_615352452 = (mActivePhone.handlePinMmi(dialString));
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061078073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061078073;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.661 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "238B444C12223D595D80A225015E49B9")
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        boolean varB6713A0B25EC29F71205412BEAB34760_1828288566 = (mActivePhone.handleInCallMmiCommands(command));
        addTaint(command.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335378275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335378275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.661 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "02BB7D3CC2467916072825823BC7F612")
    public void sendDtmf(char c) {
        mActivePhone.sendDtmf(c);
        addTaint(c);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.662 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "F52C933F3F6210EBC4ADD57A96877685")
    public void startDtmf(char c) {
        mActivePhone.startDtmf(c);
        addTaint(c);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.662 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.663 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "D9D52A0A56C9B8E1D8FDC379A00959A4")
    public void setRadioPower(boolean power) {
        mActivePhone.setRadioPower(power);
        addTaint(power);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.663 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "FE126656285F6A4AEE33EBC78F543951")
    public boolean getMessageWaitingIndicator() {
        boolean varE36CE85276F33DCC5B02481874938DBC_1395388269 = (mActivePhone.getMessageWaitingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644469737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644469737;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.663 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "FA109EA9A4F9440B51EDC3F8567086C4")
    public boolean getCallForwardingIndicator() {
        boolean var711465E26D829245ADB92E0313FED47F_236355953 = (mActivePhone.getCallForwardingIndicator());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527302320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527302320;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.664 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "17340ADDD2CF316BB6B462AE77732365")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1888798594 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1888798594 = mActivePhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_1888798594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1888798594;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.665 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "422DC940BF986F97D670B0D97600800B")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_413606987 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_413606987 = mActivePhone.getCdmaMin();
        varB4EAC82CA7396A68D541C85D26508E83_413606987.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_413606987;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.666 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "8C979B33C444E1973AB06756CB94D29D")
    public boolean isMinInfoReady() {
        boolean varBADBA5710877FFB10FBC68610BD4AFC0_1653379227 = (mActivePhone.isMinInfoReady());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625659896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625659896;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.668 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "EC8B4A48CAC0F70AABEE9954EA419B4C")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_751838191 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_751838191 = mActivePhone.getCdmaPrlVersion();
        varB4EAC82CA7396A68D541C85D26508E83_751838191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_751838191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.669 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "7EAFAD3423036BED3133DADAD8B2D18B")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_640155079 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_640155079 = mActivePhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_640155079.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_640155079;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.670 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "09935C20562D39A9840DC08A7F8E9EB5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.671 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "2104899A38CDA067B9158F0467B8460D")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_936438737 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_936438737 = mActivePhone.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_936438737.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_936438737;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.672 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "04B3B3E658C758517380020FA80ED88E")
    public int getVoiceMessageCount() {
        int varC9B97605CE24C2BC7E55AC0885C61958_1515679160 = (mActivePhone.getVoiceMessageCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196065637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1196065637;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.673 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "A1E688550C5B5B5E9681CCC759D87DD9")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1608461652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1608461652 = mActivePhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1608461652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1608461652;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.674 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "97A671D392FA68140B94FD7E82C1FEE5")
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.675 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "EC0D35FE8D15C5E9AAEB85332F8B6483")
    public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.676 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "1120B5D491FFB1876BB7A13D90C6882D")
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
        
        
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.678 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "FFBF6A9DEC70AA76854616670FBAE969")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.678 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "3791678C450A1B92EBAC4E3409C18225")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.679 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "DB933B65555567AB746FC1ED2481897B")
    public void getCallWaiting(Message onComplete) {
        mActivePhone.getCallWaiting(onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.680 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "BD6FE1314F22D353F9B891144D17A54F")
    public void setCallWaiting(boolean enable, Message onComplete) {
        mActivePhone.setCallWaiting(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.681 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "ED47A5E576BCAA9C06EB8A135365F6D4")
    public void getAvailableNetworks(Message response) {
        mActivePhone.getAvailableNetworks(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.683 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "544C8A997BB80B6EC3E6A2E957918612")
    public void setNetworkSelectionModeAutomatic(Message response) {
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.683 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "338AD690C706E7EF191C0DDDF7B2010C")
    public void selectNetworkManually(OperatorInfo network, Message response) {
        mActivePhone.selectNetworkManually(network, response);
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.684 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "42B4C4ACB2ED5698390A5D98323B0350")
    public void setPreferredNetworkType(int networkType, Message response) {
        mActivePhone.setPreferredNetworkType(networkType, response);
        addTaint(networkType);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.685 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "2ADA13B86C878DCE6B752F3AE7B7DB51")
    public void getPreferredNetworkType(Message response) {
        mActivePhone.getPreferredNetworkType(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.685 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "3F02CB4A042513635192CF9822F667C2")
    public void getNeighboringCids(Message response) {
        mActivePhone.getNeighboringCids(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.686 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "1EE2F126B765DFFDEDDFDAE8F13A50FA")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.686 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "03177769785620AC24ACDF32DC042030")
    public void setMute(boolean muted) {
        mActivePhone.setMute(muted);
        addTaint(muted);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.687 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "A07F3EB96BFC290EDEEEA4AE08017D9A")
    public boolean getMute() {
        boolean var1B9136C6599825A7694821391361E39E_126920879 = (mActivePhone.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252051419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252051419;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.687 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "5FE50D9B90C14C65E5204A4258C5EA3D")
    public void setEchoSuppressionEnabled(boolean enabled) {
        mActivePhone.setEchoSuppressionEnabled(enabled);
        addTaint(enabled);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.687 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "19ED6F229DEC2F2E293FBAC415416E51")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mActivePhone.invokeOemRilRequestRaw(data, response);
        addTaint(data[0]);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.688 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "E6356B46DA998CDBC954136C7E0CE025")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.688 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "A105062AA84AB35225103828B6B4BAB5")
    public void getDataCallList(Message response) {
        mActivePhone.getDataCallList(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.688 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.689 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.689 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.689 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "D6867E9D55823B9E2E9B116D991405D3")
    public void setUnitTestMode(boolean f) {
        mActivePhone.setUnitTestMode(f);
        addTaint(f);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.690 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "CC3373CD7E4FE839DF53C6153DAB276A")
    public boolean getUnitTestMode() {
        boolean varE57924CD4DCE3E1FC1150866D669EFEB_1750868390 = (mActivePhone.getUnitTestMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177619465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_177619465;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.690 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "EC122FDC46515809E675B27A9720B1A4")
    public void setBandMode(int bandMode, Message response) {
        mActivePhone.setBandMode(bandMode, response);
        addTaint(bandMode);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.690 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "2868629EDEC523545BE9A1C205928F25")
    public void queryAvailableBandMode(Message response) {
        mActivePhone.queryAvailableBandMode(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.691 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "5170C2B4631682A437A8C65951796A87")
    public boolean getDataRoamingEnabled() {
        boolean var25967ADD269A46D57FF30D567DD05A9D_86772878 = (mActivePhone.getDataRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84066991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_84066991;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.691 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "33718B3767BF9960A57EC52790ED0ED1")
    public void setDataRoamingEnabled(boolean enable) {
        mActivePhone.setDataRoamingEnabled(enable);
        addTaint(enable);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.692 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "A29117D2169347E0F382FBD9FE39BF9C")
    public void queryCdmaRoamingPreference(Message response) {
        mActivePhone.queryCdmaRoamingPreference(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.692 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "7E65859B3CF01F568233499E3F3AEF67")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.693 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "FD089ED025B112FF5E0976B225150FEC")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        addTaint(cdmaSubscriptionType);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.694 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "F55B03C141BA44C4BCD27596783E1C24")
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varB4EAC82CA7396A68D541C85D26508E83_1412439975 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1412439975 = mActivePhone.getSimulatedRadioControl();
        varB4EAC82CA7396A68D541C85D26508E83_1412439975.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1412439975;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.694 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "35C6C24C1EBD594B8954EB606DC0E9EB")
    public int enableApnType(String type) {
        int varA930C257BD4665C868EA6EF284E5FAB4_445710817 = (mActivePhone.enableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849982334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849982334;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.694 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "6ADE448401C7F58EF307AADAFBBA1BA8")
    public int disableApnType(String type) {
        int var0EE96BBA6B6E6339EB47881723DB0B34_1528939282 = (mActivePhone.disableApnType(type));
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920374910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920374910;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.695 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "83790EAD1E344F6B06D209A1D5891293")
    public boolean isDataConnectivityPossible() {
        boolean varFD50EE22A236A635A1A5E6ECDDC3AD83_853693331 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836604720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836604720;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.695 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "436AF832EAD69FCCE3B63C3A27405182")
    public boolean isDataConnectivityPossible(String apnType) {
        boolean var7B46E2C66CD7327260F34CAEEF4F7C05_867042587 = (mActivePhone.isDataConnectivityPossible(apnType));
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870947945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870947945;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.695 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "257A766DBAD9A9365DA5DAC3DDF2D4CA")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_57220578 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_57220578 = mActivePhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_57220578.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_57220578;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.696 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "76B57FBDEFCBB85B50576A794599ACA6")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1421816302 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1421816302 = mActivePhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1421816302.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1421816302;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.697 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "E044FEF6351A38CA3C3802E8A9208C70")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_725063482 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_725063482 = mActivePhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_725063482.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725063482;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.697 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "57ECF4E590582719E238729BD00A1044")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_844436832 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_844436832 = mActivePhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_844436832.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_844436832;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.698 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "3EA12AAFA3EDC06DA9F4B3BE0968FDC3")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1920430327 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1920430327 = mActivePhone.getEsn();
        varB4EAC82CA7396A68D541C85D26508E83_1920430327.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920430327;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.698 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "05B36C3166BE9397A340947EDCDE0B06")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_561484346 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_561484346 = mActivePhone.getMeid();
        varB4EAC82CA7396A68D541C85D26508E83_561484346.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_561484346;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.699 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "5A68FC5F7AF961DE1D8B13E03477F833")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_169155635 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_169155635 = mActivePhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_169155635.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_169155635;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.699 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "386D298B4EAEEEE7B1158A4300E2440E")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1329323783 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1329323783 = mActivePhone.getImei();
        varB4EAC82CA7396A68D541C85D26508E83_1329323783.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1329323783;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.700 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "F2BB3C2738D1EC837114EBBA23653EE0")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_2129640178 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2129640178 = mActivePhone.getPhoneSubInfo();
        varB4EAC82CA7396A68D541C85D26508E83_2129640178.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2129640178;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.702 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "A0B800DB4221D6434724433A342C3044")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1614406614 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1614406614 = mActivePhone.getIccSmsInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_1614406614.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1614406614;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.704 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "7AC95D95BA0AA93CA5698176315BF2B0")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_110867674 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_110867674 = mActivePhone.getIccPhoneBookInterfaceManager();
        varB4EAC82CA7396A68D541C85D26508E83_110867674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_110867674;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.704 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "FCBFFF2A9F42577944A80EB95E9A3C0F")
    public void setTTYMode(int ttyMode, Message onComplete) {
        mActivePhone.setTTYMode(ttyMode, onComplete);
        addTaint(ttyMode);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.705 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "2C80F2739A5BB6BD47E4DDE5927BF72C")
    public void queryTTYMode(Message onComplete) {
        mActivePhone.queryTTYMode(onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.706 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "CA56D912809FE4561D39D32B273B518D")
    public void activateCellBroadcastSms(int activate, Message response) {
        mActivePhone.activateCellBroadcastSms(activate, response);
        addTaint(activate);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.706 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "8A579B0E9B83E597915DFA694C7C66B0")
    public void getCellBroadcastSmsConfig(Message response) {
        mActivePhone.getCellBroadcastSmsConfig(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.707 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "E0689A4AEE36BEFC5B654FB47865C2ED")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.708 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.708 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "531D6EA9627B76FB25AC22106E3255F1")
    public void getSmscAddress(Message result) {
        mActivePhone.getSmscAddress(result);
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.709 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "9C92DC4F8BBBFBD3B2D3E868202BE242")
    public void setSmscAddress(String address, Message result) {
        mActivePhone.setSmscAddress(address, result);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.709 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "DEB6F36D319AD631D723EE67F9C3A5FB")
    public int getCdmaEriIconIndex() {
        int varE8C65943584090697CBEEDCCAFC2799B_2009204274 = (mActivePhone.getCdmaEriIconIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463489897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463489897;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.710 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "812506B7A60FAF552D64DA8F38B7B3FC")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_688394645 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_688394645 = mActivePhone.getCdmaEriText();
        varB4EAC82CA7396A68D541C85D26508E83_688394645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_688394645;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.711 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "9CF8B542FC0C6AC066FAF805FE9C08D6")
    public int getCdmaEriIconMode() {
        int var44559B7F040E42DDDD7BF51EF4F1B3DA_402117218 = (mActivePhone.getCdmaEriIconMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884958285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884958285;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.712 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "65691F90ED4C20ABC7832C2AA82569C3")
    public Phone getActivePhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1524688408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1524688408 = mActivePhone;
        varB4EAC82CA7396A68D541C85D26508E83_1524688408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1524688408;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.712 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "962932F0BDF3ED9150F000D60B1B2148")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.713 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.713 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "96260940A29E275E1F8278F07FA62E5B")
    public boolean needsOtaServiceProvisioning() {
        boolean var970502384D9890BA0973B383AB80C6FC_1007368183 = (mActivePhone.needsOtaServiceProvisioning());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453231383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453231383;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.714 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "3D0CD2F5A1E38A34CE90D7D7D7153ACB")
    public boolean isOtaSpNumber(String dialStr) {
        boolean varB4E5E50A833DA40DB1EDA30167AA00E1_414411406 = (mActivePhone.isOtaSpNumber(dialStr));
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361592677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361592677;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.714 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "0A44F33ACDCE543495950F5DF53CAF1D")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        
        mActivePhone.registerForCallWaiting(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.714 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "5B49FB1E17165D5CDB7543200DB7B3D2")
    public void unregisterForCallWaiting(Handler h) {
        mActivePhone.unregisterForCallWaiting(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.714 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "EF515357CB0FB4DFDC8C1D4146D8B2E8")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForSignalInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.715 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "1EB6FB578E47793A6F8C8134B87E2381")
    public void unregisterForSignalInfo(Handler h) {
        mActivePhone.unregisterForSignalInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.715 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "096D226148C8C13B2674EBACD9393C20")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForDisplayInfo(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.715 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "CB34740909F7AF2330A9DAE7FF2665E7")
    public void unregisterForDisplayInfo(Handler h) {
        mActivePhone.unregisterForDisplayInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.715 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "F31FE56940F77121FDCAF45692AE2EC8")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.716 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "51E323E51FAABD681C3C83B7FB4FEF9B")
    public void unregisterForNumberInfo(Handler h) {
        mActivePhone.unregisterForNumberInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.716 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "1CA77A8012D1B60CC62933A63F0C508B")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.716 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "F31708A5138322E9089BE5C74F37DA0B")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.716 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "0331E412347E804DF54A11837D671FE2")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForLineControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.717 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "8C8E23E61369D2C96B1FA81AD8537249")
    public void unregisterForLineControlInfo(Handler h) {
        mActivePhone.unregisterForLineControlInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.717 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "898F85E1EAA161385D8D7E844BAD0BBE")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.717 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6373243788B2F3CD175FA2B64F781E67")
    public void unregisterForT53ClirInfo(Handler h) {
        mActivePhone.unregisterForT53ClirInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.718 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "BE08C47AC314A6BE8322FA08A7DA38DC")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.718 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "9B3F662BDB49240939E52A0602AE63E0")
    public void unregisterForT53AudioControlInfo(Handler h) {
        mActivePhone.unregisterForT53AudioControlInfo(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.719 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "226CAE1026073642B9FAA2D282D6394B")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.719 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "5BBDD3BA0A72F11B9ADC7085CBD4B4E4")
    public void unsetOnEcbModeExitResponse(Handler h) {
        mActivePhone.unsetOnEcbModeExitResponse(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.720 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "B61397CE85FA91530BC6F004DD98C875")
    public boolean isCspPlmnEnabled() {
        boolean var202889D1FB2BEDDDD330D07A42C96AAA_1231182930 = (mActivePhone.isCspPlmnEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739202755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739202755;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.720 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "643187BA4BD62CDE6F6D2164A10184D2")
    public IsimRecords getIsimRecords() {
        IsimRecords varB4EAC82CA7396A68D541C85D26508E83_971357954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_971357954 = mActivePhone.getIsimRecords();
        varB4EAC82CA7396A68D541C85D26508E83_971357954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_971357954;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.722 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "68362B88CED1C39CC89FB6DC764100DB")
    public void requestIsimAuthentication(String nonce, Message response) {
        mActivePhone.requestIsimAuthentication(nonce, response);
        addTaint(nonce.getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.722 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "0E15C12C4252DCA56DAA3F81C08CA9AF")
    @Override
    public int getLteOnCdmaMode() {
        int varC068356BB4D68BB6F09FF66311887211_23398776 = (mActivePhone.getLteOnCdmaMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495738666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495738666;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.723 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "CB617AE9F52618A80DC2D07579BC0ACC")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        addTaint(line);
        addTaint(countWaiting);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.726 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "A936135945D375DE6E845B5ED7499394")
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable varB4EAC82CA7396A68D541C85D26508E83_1216351649 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1216351649 = mActivePhone.getUsimServiceTable();
        varB4EAC82CA7396A68D541C85D26508E83_1216351649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1216351649;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.726 -0400", hash_original_field = "D265743C68392037CBF15E907FEED16C", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.726 -0400", hash_original_field = "5796FC476F17BB03669177DD4AF60580", hash_generated_field = "54EE92F4B0FE4A4C30125103756EC93C")

    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.727 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
}

