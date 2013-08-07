package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

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






public class PhoneProxy extends Handler implements Phone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.824 -0400", hash_original_field = "10728AB9087E7707D37847A2389DDE0C", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")

    private Phone mActivePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.824 -0400", hash_original_field = "7ECE7371C43BE14D2A55B339F95D5963", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.824 -0400", hash_original_field = "1807C68F8FB5F577A66C3A94E5AD0A66", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.824 -0400", hash_original_field = "21B855B7AFB6C39284AC629A5ACDC28A", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.824 -0400", hash_original_field = "18F20DD2807A52A04EA2B70117648163", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.825 -0400", hash_original_field = "4A5BFF6E8716B82AA5C82CBE6B802317", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.825 -0400", hash_original_field = "B37050DAC53073D34B96D1CA70F3C3FE", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")

    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.826 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "172604CCF05E7950C338A2F8CB3563A0")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.827 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "4EC7E7070072C95BC7C7CA4B02330777")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case EVENT_RADIO_TECHNOLOGY_CHANGED:
        mOutgoingPhone = mActivePhone.getPhoneName();
        logd("Switching phone from " + mOutgoingPhone + "Phone to " +
                    (mOutgoingPhone.equals("GSM") ? "CDMAPhone" : "GSMPhone") );
        boolean oldPowerState = false;
        if(mResetModemOnRadioTechnologyChange)        
        {
            if(mCommandsInterface.getRadioState().isOn())            
            {
                oldPowerState = true;
                logd("Setting Radio Power to Off");
                mCommandsInterface.setRadioPower(false, null);
            } //End block
        } //End block
        if(mOutgoingPhone.equals("GSM"))        
        {
            logd("Make a new CDMAPhone and destroy the old GSMPhone.");
            ((GSMPhone)mActivePhone).dispose();
            Phone oldPhone = mActivePhone;
            mActivePhone = PhoneFactory.getCdmaPhone();
            ((GSMPhone)oldPhone).removeReferences();
            oldPhone = null;
        } //End block
        else
        {
            logd("Make a new GSMPhone and destroy the old CDMAPhone.");
            ((CDMAPhone)mActivePhone).dispose();
            Phone oldPhone = mActivePhone;
            mActivePhone = PhoneFactory.getGsmPhone();
            ((CDMAPhone)oldPhone).removeReferences();
            oldPhone = null;
        } //End block
        if(mResetModemOnRadioTechnologyChange)        
        {
            logd("Resetting Radio");
            mCommandsInterface.setRadioPower(oldPowerState, null);
        } //End block
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
        break;
        default:
        break;
}        super.handleMessage(msg);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.828 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "A23B5485D5103D533DA72A0955C0162F")
    public ServiceState getServiceState() {
ServiceState varB60F40D412C20B5CBF579A3940E0A1CC_1758956112 =         mActivePhone.getServiceState();
        varB60F40D412C20B5CBF579A3940E0A1CC_1758956112.addTaint(taint);
        return varB60F40D412C20B5CBF579A3940E0A1CC_1758956112;
        // ---------- Original Method ----------
        //return mActivePhone.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.828 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "B26AE81ADBF6AA5770D82A56788DED8F")
    public CellLocation getCellLocation() {
CellLocation varD3736C0AB7755A59D7EADF001F3ECFF7_750533511 =         mActivePhone.getCellLocation();
        varD3736C0AB7755A59D7EADF001F3ECFF7_750533511.addTaint(taint);
        return varD3736C0AB7755A59D7EADF001F3ECFF7_750533511;
        // ---------- Original Method ----------
        //return mActivePhone.getCellLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.828 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "562EB671E066319C768DA44376022083")
    public DataState getDataConnectionState() {
DataState var85D280C9C316E2C568EB5A1F249D156E_1648082578 =         mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
        var85D280C9C316E2C568EB5A1F249D156E_1648082578.addTaint(taint);
        return var85D280C9C316E2C568EB5A1F249D156E_1648082578;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.829 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "93335236D113B7A69282AF64CF3F52CC")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
DataState var2A179317F19FC4AC7BBD4C47EF4079EF_969000494 =         mActivePhone.getDataConnectionState(apnType);
        var2A179317F19FC4AC7BBD4C47EF4079EF_969000494.addTaint(taint);
        return var2A179317F19FC4AC7BBD4C47EF4079EF_969000494;
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.829 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "2EFD4583229121F966469B57BDF4F0F6")
    public DataActivityState getDataActivityState() {
DataActivityState varC767C1F3BD4173C01DC59523451D79E7_1945910667 =         mActivePhone.getDataActivityState();
        varC767C1F3BD4173C01DC59523451D79E7_1945910667.addTaint(taint);
        return varC767C1F3BD4173C01DC59523451D79E7_1945910667;
        // ---------- Original Method ----------
        //return mActivePhone.getDataActivityState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.829 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "BA5278C04F802D4DB05275CAAD12E5ED")
    public Context getContext() {
Context var54AA9DCA0CA04F20B6DA14B3F8D0281B_258114181 =         mActivePhone.getContext();
        var54AA9DCA0CA04F20B6DA14B3F8D0281B_258114181.addTaint(taint);
        return var54AA9DCA0CA04F20B6DA14B3F8D0281B_258114181;
        // ---------- Original Method ----------
        //return mActivePhone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.829 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "AFF99A944A226F81BE938F8DE9407D6C")
    public void disableDnsCheck(boolean b) {
        addTaint(b);
        mActivePhone.disableDnsCheck(b);
        // ---------- Original Method ----------
        //mActivePhone.disableDnsCheck(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.830 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "31ECA4C3B09466F9010F2B120B9001A6")
    public boolean isDnsCheckDisabled() {
        boolean var78018A2ADDE0F738B0FAC58F77DC3E07_1966403314 = (mActivePhone.isDnsCheckDisabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037974747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037974747;
        // ---------- Original Method ----------
        //return mActivePhone.isDnsCheckDisabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.830 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "A5ADB9101E6D1137E0E21042C6ACE895")
    public State getState() {
State varACFA40C09E4BF09E90FCEF22FEF4C12F_1021956563 =         mActivePhone.getState();
        varACFA40C09E4BF09E90FCEF22FEF4C12F_1021956563.addTaint(taint);
        return varACFA40C09E4BF09E90FCEF22FEF4C12F_1021956563;
        // ---------- Original Method ----------
        //return mActivePhone.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.830 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "FC67F3FD9E0AAC28F2DE9BF7C9696ADA")
    public String getPhoneName() {
String var7724E001F0B0AD1F05835F621BEB19F0_897915737 =         mActivePhone.getPhoneName();
        var7724E001F0B0AD1F05835F621BEB19F0_897915737.addTaint(taint);
        return var7724E001F0B0AD1F05835F621BEB19F0_897915737;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.851 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "A0A4CCD8C442F4B57D32090075C88BC7")
    public int getPhoneType() {
        int var44199ACE5F580D5BBCAE7F1C66CFA865_398396070 = (mActivePhone.getPhoneType());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139163140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139163140;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.851 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "35B9D5024028A520021AAB23B5B78E58")
    public String[] getActiveApnTypes() {
String[] varFDAE55379D17F23EC7B416DF9CA7C3CA_578221398 =         mActivePhone.getActiveApnTypes();
        varFDAE55379D17F23EC7B416DF9CA7C3CA_578221398.addTaint(taint);
        return varFDAE55379D17F23EC7B416DF9CA7C3CA_578221398;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.851 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "3FA0DB95C75747107F7C8756E6AB98D8")
    public String getActiveApnHost(String apnType) {
        addTaint(apnType.getTaint());
String var18DD9340F2BD938B2AE2F34A00E865B3_871621781 =         mActivePhone.getActiveApnHost(apnType);
        var18DD9340F2BD938B2AE2F34A00E865B3_871621781.addTaint(taint);
        return var18DD9340F2BD938B2AE2F34A00E865B3_871621781;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnHost(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.852 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "D406939336265B67C72C38685702F497")
    public LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
LinkProperties var17071AFAEE87FB3A9A650B9DB7BA4CA5_522563900 =         mActivePhone.getLinkProperties(apnType);
        var17071AFAEE87FB3A9A650B9DB7BA4CA5_522563900.addTaint(taint);
        return var17071AFAEE87FB3A9A650B9DB7BA4CA5_522563900;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.852 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "24D26EB8D61A2CE8B95B2E2C814C036D")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        addTaint(apnType.getTaint());
LinkCapabilities varE4B010A20B7B7134C11F9A30E54489CA_1088325872 =         mActivePhone.getLinkCapabilities(apnType);
        varE4B010A20B7B7134C11F9A30E54489CA_1088325872.addTaint(taint);
        return varE4B010A20B7B7134C11F9A30E54489CA_1088325872;
        // ---------- Original Method ----------
        //return mActivePhone.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.852 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "88C2CCFD82F0A448C0AB1BA8A163235C")
    public SignalStrength getSignalStrength() {
SignalStrength varE4D241E8138A7EFDC5C6CF9ABD047B39_1625776890 =         mActivePhone.getSignalStrength();
        varE4D241E8138A7EFDC5C6CF9ABD047B39_1625776890.addTaint(taint);
        return varE4D241E8138A7EFDC5C6CF9ABD047B39_1625776890;
        // ---------- Original Method ----------
        //return mActivePhone.getSignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.852 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "24F56D053027AB08C8A79DC4E866CE86")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForUnknownConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.853 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "8D1B355FB2DBA3D70FDB44576D8F6455")
    public void unregisterForUnknownConnection(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForUnknownConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForUnknownConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.853 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "F63CA439CBFCEA93A8E3F120B84A0DFD")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.854 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "9DB46481EB5B6ECFDA170FDCFA54011D")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.854 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "5984FEC8D12245C97D2EF82819794A49")
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.854 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "2818E7AA3B15359A336C27D86F04B18F")
    public void unregisterForNewRingingConnection(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForNewRingingConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNewRingingConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.855 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "BE868B82B463239D97A17B1BE7E7F31B")
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForIncomingRing(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForIncomingRing(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.855 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "80A3726B05BCD8ECD87B3CF846F40791")
    public void unregisterForIncomingRing(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForIncomingRing(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForIncomingRing(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.856 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "53EE0B98D628436BCED0AC062E2C8CA2")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForDisconnect(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisconnect(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.856 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "64FC6E5F2A014E5A613707C953C4CCD4")
    public void unregisterForDisconnect(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForDisconnect(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisconnect(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.856 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "C4DA4BC2B71451A8DA7D681124D659EB")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForMmiInitiate(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.856 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "BAC6C35D62EA993A494B236B7C82F875")
    public void unregisterForMmiInitiate(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForMmiInitiate(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiInitiate(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.857 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "E456F613788A10DF5A63AD9AA5751218")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForMmiComplete(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiComplete(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.857 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "DAC58A1D09FAD340CA2DEB9D2D173A8B")
    public void unregisterForMmiComplete(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForMmiComplete(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiComplete(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.857 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "48C896AA5EF430FEA67A2D9A516DDB53")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> varA24E567B8E59D50FBE82A57AB56DE5D2_699950778 =         mActivePhone.getPendingMmiCodes();
        varA24E567B8E59D50FBE82A57AB56DE5D2_699950778.addTaint(taint);
        return varA24E567B8E59D50FBE82A57AB56DE5D2_699950778;
        // ---------- Original Method ----------
        //return mActivePhone.getPendingMmiCodes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.857 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "F59CBDB18130AB1F22DF3EAEF3490657")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        mActivePhone.sendUssdResponse(ussdMessge);
        // ---------- Original Method ----------
        //mActivePhone.sendUssdResponse(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.858 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "1DF7E215BA0848B405697C3FAB7FDB4C")
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.858 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "12D321AB2A9466BEDCD5E50F191D79A6")
    public void unregisterForServiceStateChanged(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForServiceStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForServiceStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.859 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "41490700FBAD2FD1763AFF00B7BD0B45")
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.859 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "5D07B07B760EB99B65E240FDA822922F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSuppServiceNotification(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceNotification(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.859 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "40308FBF3D8D885AB48280DA00E4DF3F")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.860 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "174B787586E18925D619A2CF428C53F9")
    public void unregisterForSuppServiceFailed(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSuppServiceFailed(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceFailed(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.860 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "1B7FFF0C25FB8CBD7F1F44C1E9CBE65E")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.860 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "F1DE940AB98E38653D0C57577A04DD75")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.860 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "89CEBD1EDFD0B12EB579108819D14367")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "695FAA881279F98B7F83C7CDA8D3E858")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "37483E64A759BFC872D87B2A1EBB19FD")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "E0AF213829BDB4C6DF76734508630EB8")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "17367D3F3CCBF8BD408B558442E3AF85")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "632117A5BC9C08F5D65DBDD72B60427F")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "535D7BEFD06CA78319BAA51F74C2BB69")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "A5DCFB1AAD29313124291A86B003095A")
    public void unregisterForEcmTimerReset(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForEcmTimerReset(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForEcmTimerReset(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "7B5E90F4C3CFE3BA8118699252DF7AAD")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "23781EF326A96A81541361D62BB4E27C")
    public void unregisterForRingbackTone(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.861 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "6717D6D6DDE155FCFCE61ADF6B62AE2F")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "14453173F22986CB0E23E5828B5E8A02")
    public void unregisterForResendIncallMute(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "115E26E6CC4FC01323BC49D05C34079A")
    public boolean getIccRecordsLoaded() {
        boolean varDB21FD823653993E72363904C598AB1F_492899154 = (mActivePhone.getIccRecordsLoaded());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290836548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290836548;
        // ---------- Original Method ----------
        //return mActivePhone.getIccRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "99D161B62654726260BFED74F20D89C3")
    public IccCard getIccCard() {
IccCard var650671E1AA670BFE90657C7A4B1796AD_1619441511 =         mActivePhone.getIccCard();
        var650671E1AA670BFE90657C7A4B1796AD_1619441511.addTaint(taint);
        return var650671E1AA670BFE90657C7A4B1796AD_1619441511;
        // ---------- Original Method ----------
        //return mActivePhone.getIccCard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        // ---------- Original Method ----------
        //mActivePhone.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        // ---------- Original Method ----------
        //mActivePhone.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        // ---------- Original Method ----------
        //mActivePhone.switchHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "9D3B58840D38D22D9728E4171C660208")
    public boolean canConference() {
        boolean varF833CA419DB19C0593324DD68EF3B9D1_468383575 = (mActivePhone.canConference());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616462;
        // ---------- Original Method ----------
        //return mActivePhone.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    public void conference() throws CallStateException {
        mActivePhone.conference();
        // ---------- Original Method ----------
        //mActivePhone.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "C5861EB4EFC5C115633C82583A114E8E")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "5D4A98823B23ED5B3B19ADCAD6F7B87B")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "B5DDF0D1D8D4565B0D6FA1B170B75D01")
    public boolean canTransfer() {
        boolean var3E1FD3F8175208BF34A50CBCD5C003E6_749319661 = (mActivePhone.canTransfer());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934993752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934993752;
        // ---------- Original Method ----------
        //return mActivePhone.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.862 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        // ---------- Original Method ----------
        //mActivePhone.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        // ---------- Original Method ----------
        //mActivePhone.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "18B08526A3E55ADBE72A43624A87F7C2")
    public Call getForegroundCall() {
Call var0A144D171E8EE3644BEE80F7CB4EE10E_861048237 =         mActivePhone.getForegroundCall();
        var0A144D171E8EE3644BEE80F7CB4EE10E_861048237.addTaint(taint);
        return var0A144D171E8EE3644BEE80F7CB4EE10E_861048237;
        // ---------- Original Method ----------
        //return mActivePhone.getForegroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "A54C88EDF42302FD2FC93831A23DAB71")
    public Call getBackgroundCall() {
Call var9298720A9FFCCDE84E4DB6400DDA8A11_158589681 =         mActivePhone.getBackgroundCall();
        var9298720A9FFCCDE84E4DB6400DDA8A11_158589681.addTaint(taint);
        return var9298720A9FFCCDE84E4DB6400DDA8A11_158589681;
        // ---------- Original Method ----------
        //return mActivePhone.getBackgroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "6DE05E7B464E8296037E4464230B8EDD")
    public Call getRingingCall() {
Call var9CBEE4FD766BECD84BEC5FFC3CFB73AC_903003971 =         mActivePhone.getRingingCall();
        var9CBEE4FD766BECD84BEC5FFC3CFB73AC_903003971.addTaint(taint);
        return var9CBEE4FD766BECD84BEC5FFC3CFB73AC_903003971;
        // ---------- Original Method ----------
        //return mActivePhone.getRingingCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "C2E8B3F5DAAA0D967F10EA328C37CDCF")
    public Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
Connection var0E9AF1264BBE0E05A3D02BE43DB349C0_1954080047 =         mActivePhone.dial(dialString);
        var0E9AF1264BBE0E05A3D02BE43DB349C0_1954080047.addTaint(taint);
        return var0E9AF1264BBE0E05A3D02BE43DB349C0_1954080047;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "84424807531C7083520C68712BBE9D91")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
Connection var1943C260F8A86B3303DF30E653E5A3AD_1245969876 =         mActivePhone.dial(dialString, uusInfo);
        var1943C260F8A86B3303DF30E653E5A3AD_1245969876.addTaint(taint);
        return var1943C260F8A86B3303DF30E653E5A3AD_1245969876;
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "1C062A565216BC91FB3E95F01279AB83")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean varCFF8CA61D4D9884A3A242BAC3CD1E0CA_1176080187 = (mActivePhone.handlePinMmi(dialString));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205228907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205228907;
        // ---------- Original Method ----------
        //return mActivePhone.handlePinMmi(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "9F9874D9BFDABCEE7A9D2400CE9512F8")
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        addTaint(command.getTaint());
        boolean var89ADBAD6C0B3529DB0DB7E7F0FBAD4D0_1739820991 = (mActivePhone.handleInCallMmiCommands(command));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638134761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638134761;
        // ---------- Original Method ----------
        //return mActivePhone.handleInCallMmiCommands(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "1307F86CEC91A8312348D35DA455D984")
    public void sendDtmf(char c) {
        addTaint(c);
        mActivePhone.sendDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.sendDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.863 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "C718ED1AAE15425A52A667947507B808")
    public void startDtmf(char c) {
        addTaint(c);
        mActivePhone.startDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.startDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        // ---------- Original Method ----------
        //mActivePhone.stopDtmf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "951BE4178A56FAFFE7EC7D35AC2EC2C5")
    public void setRadioPower(boolean power) {
        addTaint(power);
        mActivePhone.setRadioPower(power);
        // ---------- Original Method ----------
        //mActivePhone.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "22D169D0104D8566C81021A4AF2A9786")
    public boolean getMessageWaitingIndicator() {
        boolean var8DE0DD89F4263F8099E41573A72B7058_2141362032 = (mActivePhone.getMessageWaitingIndicator());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371609596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371609596;
        // ---------- Original Method ----------
        //return mActivePhone.getMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "609F16F04E6F4C8597229C5719D7F3A1")
    public boolean getCallForwardingIndicator() {
        boolean varB4D062715EDE2BF724527FF56EEB9044_1871141696 = (mActivePhone.getCallForwardingIndicator());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1099845961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1099845961;
        // ---------- Original Method ----------
        //return mActivePhone.getCallForwardingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "F74BDD385B21E2DE765F7F7A216D40B4")
    public String getLine1Number() {
String varD615B04F3BFFE4352C5A5E76D0877B8C_199635127 =         mActivePhone.getLine1Number();
        varD615B04F3BFFE4352C5A5E76D0877B8C_199635127.addTaint(taint);
        return varD615B04F3BFFE4352C5A5E76D0877B8C_199635127;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "8CD8C00C6FEDDB54799E3C234883C65E")
    public String getCdmaMin() {
String var7B46B2E34699106F982A7086F53B001C_1297269276 =         mActivePhone.getCdmaMin();
        var7B46B2E34699106F982A7086F53B001C_1297269276.addTaint(taint);
        return var7B46B2E34699106F982A7086F53B001C_1297269276;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "BDA2D66B84CE1B43A353CEEC9AE2AB1A")
    public boolean isMinInfoReady() {
        boolean varC1EAD206A28E9865F7CE7E7DBE7B107C_1830225878 = (mActivePhone.isMinInfoReady());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484533294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484533294;
        // ---------- Original Method ----------
        //return mActivePhone.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "290712F14B1AA561FA091ECE017D65FB")
    public String getCdmaPrlVersion() {
String var6DA4A58D3FB2D81E89A9BF1A54764489_508398195 =         mActivePhone.getCdmaPrlVersion();
        var6DA4A58D3FB2D81E89A9BF1A54764489_508398195.addTaint(taint);
        return var6DA4A58D3FB2D81E89A9BF1A54764489_508398195;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "694F619D8CB7982DC38F0C8E814669DB")
    public String getLine1AlphaTag() {
String var4F99A82D9222BF2D67395946F5434E6A_1117816692 =         mActivePhone.getLine1AlphaTag();
        var4F99A82D9222BF2D67395946F5434E6A_1117816692.addTaint(taint);
        return var4F99A82D9222BF2D67395946F5434E6A_1117816692;
        // ---------- Original Method ----------
        //return mActivePhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.864 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "383AEE748CB81D0963D51182B4EA1E6A")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "60CEA3F818B2A434DB7FEE20452F7900")
    public String getVoiceMailNumber() {
String varE7F307187646B548EFAC44A59EF31EBA_1915055407 =         mActivePhone.getVoiceMailNumber();
        varE7F307187646B548EFAC44A59EF31EBA_1915055407.addTaint(taint);
        return varE7F307187646B548EFAC44A59EF31EBA_1915055407;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailNumber();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "B5E7A2AD278CF520645E3262E902E51D")
    public int getVoiceMessageCount() {
        int var50F99E7353D3DAF7CE4A9C6A6EFB1EB5_394051996 = (mActivePhone.getVoiceMessageCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169835508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169835508;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMessageCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "C421CCC49D58E8D3365A96492BA3E519")
    public String getVoiceMailAlphaTag() {
String var6E31F87FCF9C640E3D8683C179B7E5FD_342241990 =         mActivePhone.getVoiceMailAlphaTag();
        var6E31F87FCF9C640E3D8683C179B7E5FD_342241990.addTaint(taint);
        return var6E31F87FCF9C640E3D8683C179B7E5FD_342241990;
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "02038AF5A83676B9D765BD3C1EB1DCDC")
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(alphaTag.getTaint());
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "7D2EFC2788AD3334389E5A676592CF7D")
    public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "9976F2059BDD04A7F4D2639D2B1E0ADA")
    public void setCallForwardingOption(int commandInterfaceCFReason,
            int commandInterfaceCFAction, String dialingNumber,
            int timerSeconds, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(timerSeconds);
        addTaint(dialingNumber.getTaint());
        addTaint(commandInterfaceCFAction);
        addTaint(commandInterfaceCFReason);
        mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            //commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "9D1FDE4529F0B3C2C0B3A78213EBE6C8")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.865 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "2E6A3E050563D5B9BA69A87E15CB81FD")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCLIRMode);
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "63D9D61C6F46286DB0E9D674BDF0C59A")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getCallWaiting(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getCallWaiting(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "9C249C453D096D96756657F86F481988")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        mActivePhone.setCallWaiting(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setCallWaiting(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "7F763161CB96CEA998601F806F2F73CF")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mActivePhone.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "0F6A220391CFDABFCF553646347ECFE8")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        // ---------- Original Method ----------
        //mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "76D968F424747911AD7F814E4AEF4941")
    public void selectNetworkManually(OperatorInfo network, Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        mActivePhone.selectNetworkManually(network, response);
        // ---------- Original Method ----------
        //mActivePhone.selectNetworkManually(network, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "5A96E85FA6033ECFA817B7AEC5364F02")
    public void setPreferredNetworkType(int networkType, Message response) {
        addTaint(response.getTaint());
        addTaint(networkType);
        mActivePhone.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mActivePhone.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "EC800BA014DB3B190501334DF6BDD22B")
    public void getPreferredNetworkType(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mActivePhone.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "C0B818335521DE8B6991EF923B6D35EE")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getNeighboringCids(response);
        // ---------- Original Method ----------
        //mActivePhone.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "7BAB250002BC50A03B2184C1D1350300")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "404255CBC95825AB40AC39BB660021BB")
    public void setMute(boolean muted) {
        addTaint(muted);
        mActivePhone.setMute(muted);
        // ---------- Original Method ----------
        //mActivePhone.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.866 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "FDA3EAB0C3C9A3AB7A06B14B9D74C96A")
    public boolean getMute() {
        boolean varCC1DAA68F33B8E3CDE3E8FE4212AA755_1462018532 = (mActivePhone.getMute());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806524103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806524103;
        // ---------- Original Method ----------
        //return mActivePhone.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "92212B9BA8AD350E5E9CBF3D6B6258BD")
    public void setEchoSuppressionEnabled(boolean enabled) {
        addTaint(enabled);
        mActivePhone.setEchoSuppressionEnabled(enabled);
        // ---------- Original Method ----------
        //mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "CB691D27D8C106B959AF972890FBA458")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        addTaint(response.getTaint());
        addTaint(data[0]);
        mActivePhone.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "3C584B12B6CC7830F7D9CA75405C5645")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        addTaint(response.getTaint());
        addTaint(strings[0].getTaint());
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "DC4AD885CD74EB4F59C0CA73FC3D327B")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getDataCallList(response);
        // ---------- Original Method ----------
        //mActivePhone.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        // ---------- Original Method ----------
        //mActivePhone.updateServiceLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "E5066B35D37F0F7B8818ACB3AD4796C5")
    public void setUnitTestMode(boolean f) {
        addTaint(f);
        mActivePhone.setUnitTestMode(f);
        // ---------- Original Method ----------
        //mActivePhone.setUnitTestMode(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "1BDDFDE3E78F49A39EDAB8CA994CC099")
    public boolean getUnitTestMode() {
        boolean var59F70D5C16101D1739ED9D05961581BF_1687256944 = (mActivePhone.getUnitTestMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728758455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728758455;
        // ---------- Original Method ----------
        //return mActivePhone.getUnitTestMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.867 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "3C359B33F0943EDCB8F47B63E94F0CF6")
    public void setBandMode(int bandMode, Message response) {
        addTaint(response.getTaint());
        addTaint(bandMode);
        mActivePhone.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mActivePhone.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "4DF77422AB14FDD0D4A2A732D672FD8C")
    public void queryAvailableBandMode(Message response) {
        addTaint(response.getTaint());
        mActivePhone.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mActivePhone.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "A6F43C25903EBC3EB388C9E17ADBC41A")
    public boolean getDataRoamingEnabled() {
        boolean var500232FE6E30ADF3A5E96A7BA7421CD9_282046819 = (mActivePhone.getDataRoamingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567925346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567925346;
        // ---------- Original Method ----------
        //return mActivePhone.getDataRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "378CA2862A2E93DC00950D4AA8468549")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        mActivePhone.setDataRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mActivePhone.setDataRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "D820E1BD78E12612E8A21E89DBE19A34")
    public void queryCdmaRoamingPreference(Message response) {
        addTaint(response.getTaint());
        mActivePhone.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mActivePhone.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "CB1D338581307F40FBD5373D4F457AC5")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaRoamingType);
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "2292F902858C89F7DC095CA76C931562")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaSubscriptionType);
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "C40C90578925AC01D1619AA2C0897C56")
    public SimulatedRadioControl getSimulatedRadioControl() {
SimulatedRadioControl var260C456268C668FFD10DC75D44F419D6_68449358 =         mActivePhone.getSimulatedRadioControl();
        var260C456268C668FFD10DC75D44F419D6_68449358.addTaint(taint);
        return var260C456268C668FFD10DC75D44F419D6_68449358;
        // ---------- Original Method ----------
        //return mActivePhone.getSimulatedRadioControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.868 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "0D218BCBB95624B81A9A3CF7250A24C0")
    public int enableApnType(String type) {
        addTaint(type.getTaint());
        int var340D8E4E06F7EF077C5DBACF93546724_1291456207 = (mActivePhone.enableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407274450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407274450;
        // ---------- Original Method ----------
        //return mActivePhone.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "BDAFDEB10E3DF769D8ABDEDEE0983B4E")
    public int disableApnType(String type) {
        addTaint(type.getTaint());
        int varDEB79BE8BFFABED2E1315AFDC6B0A6B7_450693998 = (mActivePhone.disableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838389522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838389522;
        // ---------- Original Method ----------
        //return mActivePhone.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "D25D3D842CF8833E5CB6D4910E2672FA")
    public boolean isDataConnectivityPossible() {
        boolean var3F7CBC748801F446D625745FF37272A1_845346206 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363198569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_363198569;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "E4C3CD36BEF8FA638E7E8D56316B11F9")
    public boolean isDataConnectivityPossible(String apnType) {
        addTaint(apnType.getTaint());
        boolean var13B4BA73D19143BDF678F579BD8E6D13_294040147 = (mActivePhone.isDataConnectivityPossible(apnType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828330022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828330022;
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "9F7000F6071D72D3B67F206F4DDE87A8")
    public String getDeviceId() {
String var198CF460537B68DF3698EB5C512E12E3_830554128 =         mActivePhone.getDeviceId();
        var198CF460537B68DF3698EB5C512E12E3_830554128.addTaint(taint);
        return var198CF460537B68DF3698EB5C512E12E3_830554128;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "BEBE98B7A6AEC7CFB6097CF9678C6F25")
    public String getDeviceSvn() {
String var1A03CCEA3F2C44E7F6EE61AE8F23BC30_1930458319 =         mActivePhone.getDeviceSvn();
        var1A03CCEA3F2C44E7F6EE61AE8F23BC30_1930458319.addTaint(taint);
        return var1A03CCEA3F2C44E7F6EE61AE8F23BC30_1930458319;
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "2A970DF11DB7195C2840A1A2D18AB056")
    public String getSubscriberId() {
String varC6678EE2A7E2C464908C3BD63EA27F86_1735799484 =         mActivePhone.getSubscriberId();
        varC6678EE2A7E2C464908C3BD63EA27F86_1735799484.addTaint(taint);
        return varC6678EE2A7E2C464908C3BD63EA27F86_1735799484;
        // ---------- Original Method ----------
        //return mActivePhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "295D01CD3543F77B12503B01DD53D627")
    public String getIccSerialNumber() {
String var267F6EC3729A7AED6A1BF9FC3CCAF802_282400983 =         mActivePhone.getIccSerialNumber();
        var267F6EC3729A7AED6A1BF9FC3CCAF802_282400983.addTaint(taint);
        return var267F6EC3729A7AED6A1BF9FC3CCAF802_282400983;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "56937953077515D995BDF8CC2C7ACD2B")
    public String getEsn() {
String varDAE5B56A4AE5B60AC7D4369DE4597632_1081289751 =         mActivePhone.getEsn();
        varDAE5B56A4AE5B60AC7D4369DE4597632_1081289751.addTaint(taint);
        return varDAE5B56A4AE5B60AC7D4369DE4597632_1081289751;
        // ---------- Original Method ----------
        //return mActivePhone.getEsn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "8612DD65CE098406FD846529F2309777")
    public String getMeid() {
String varC4CD200E31813246A2E36C3829F947E0_293081252 =         mActivePhone.getMeid();
        varC4CD200E31813246A2E36C3829F947E0_293081252.addTaint(taint);
        return varC4CD200E31813246A2E36C3829F947E0_293081252;
        // ---------- Original Method ----------
        //return mActivePhone.getMeid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "5CC2BE8FF6209F6D79EEBE629EB13AD1")
    public String getMsisdn() {
String varB5AECFB92CF4F2BBF40515FBEC2A147B_2103113059 =         mActivePhone.getMsisdn();
        varB5AECFB92CF4F2BBF40515FBEC2A147B_2103113059.addTaint(taint);
        return varB5AECFB92CF4F2BBF40515FBEC2A147B_2103113059;
        // ---------- Original Method ----------
        //return mActivePhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.869 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "A44BC7AC07AF8AE7262429399011D100")
    public String getImei() {
String var199807B9CFD251093717FF07AB2613E7_1701633912 =         mActivePhone.getImei();
        var199807B9CFD251093717FF07AB2613E7_1701633912.addTaint(taint);
        return var199807B9CFD251093717FF07AB2613E7_1701633912;
        // ---------- Original Method ----------
        //return mActivePhone.getImei();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.870 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "5EB07FD32AD313D4D3ECED0ACA992DF5")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo var16550AC9086C0A3F72B46C8930895899_1973657733 =         mActivePhone.getPhoneSubInfo();
        var16550AC9086C0A3F72B46C8930895899_1973657733.addTaint(taint);
        return var16550AC9086C0A3F72B46C8930895899_1973657733;
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneSubInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "5246FF7DCC3431830439DAC320C3A52B")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_1046841861 =         mActivePhone.getIccSmsInterfaceManager();
        var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_1046841861.addTaint(taint);
        return var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_1046841861;
        // ---------- Original Method ----------
        //return mActivePhone.getIccSmsInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "FA15018B481364EA7760A836BB641653")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var313BD6618DEBD160EEE2FF9BFF8F071E_1152014825 =         mActivePhone.getIccPhoneBookInterfaceManager();
        var313BD6618DEBD160EEE2FF9BFF8F071E_1152014825.addTaint(taint);
        return var313BD6618DEBD160EEE2FF9BFF8F071E_1152014825;
        // ---------- Original Method ----------
        //return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "EF3EA2A84E20F62ADBA1891FD398561B")
    public void setTTYMode(int ttyMode, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(ttyMode);
        mActivePhone.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "7EAC51361D1115FFBD89F4516FC4A284")
    public void queryTTYMode(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "9884AB43644F370DF0F986FBEE67DD95")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        mActivePhone.activateCellBroadcastSms(activate, response);
        // ---------- Original Method ----------
        //mActivePhone.activateCellBroadcastSms(activate, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "A5D3A4E6902D2011B38745776779482F")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getCellBroadcastSmsConfig(response);
        // ---------- Original Method ----------
        //mActivePhone.getCellBroadcastSmsConfig(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "55D28AC60D2BF8EA1D3370842C77F2F4")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        // ---------- Original Method ----------
        //mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        // ---------- Original Method ----------
        //mActivePhone.notifyDataActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.871 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "00848F5CFFFA25D0CBA787F2B7C64E7C")
    public void getSmscAddress(Message result) {
        addTaint(result.getTaint());
        mActivePhone.getSmscAddress(result);
        // ---------- Original Method ----------
        //mActivePhone.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "865D9D8076ABC868AE09A5613D4F82EB")
    public void setSmscAddress(String address, Message result) {
        addTaint(result.getTaint());
        addTaint(address.getTaint());
        mActivePhone.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mActivePhone.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "8EEF10B175472C8E85A438F2C130A963")
    public int getCdmaEriIconIndex() {
        int var97F376A0CADC0E4F36957FFCCAA76010_1867136525 = (mActivePhone.getCdmaEriIconIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364590468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364590468;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "57BBF61792CA719EEF940591282CEE1B")
    public String getCdmaEriText() {
String varFBAA172F150BFFB1490E4FAFF06EF198_367603348 =         mActivePhone.getCdmaEriText();
        varFBAA172F150BFFB1490E4FAFF06EF198_367603348.addTaint(taint);
        return varFBAA172F150BFFB1490E4FAFF06EF198_367603348;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "236DE7232D1C6936A11015A483F2BF0C")
    public int getCdmaEriIconMode() {
        int varA3BAE708044E7BB258DBC489E1A088D7_1038609104 = (mActivePhone.getCdmaEriIconMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210914235 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210914235;
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconMode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "6DC3521BA515077E8DAC891E7B0C9D1F")
    public Phone getActivePhone() {
Phone var80DB6AE27D465D54797BEB544C72E98B_1101136734 =         mActivePhone;
        var80DB6AE27D465D54797BEB544C72E98B_1101136734.addTaint(taint);
        return var80DB6AE27D465D54797BEB544C72E98B_1101136734;
        // ---------- Original Method ----------
        //return mActivePhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "B796F00AD431E9DB16507806386917E9")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        // ---------- Original Method ----------
        //mActivePhone.exitEmergencyCallbackMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.873 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "40C99B2DE416AAAEBC2CF62FC70C3FC5")
    public boolean needsOtaServiceProvisioning() {
        boolean var3D8AA6EF8A5C1C19617F8C58BDE40E86_1839225900 = (mActivePhone.needsOtaServiceProvisioning());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400949689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400949689;
        // ---------- Original Method ----------
        //return mActivePhone.needsOtaServiceProvisioning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.876 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "E66EF01301ACE2EB423F5A4E946804F1")
    public boolean isOtaSpNumber(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean varB501AD12C60C738D74C29D7FCFDEC660_187538901 = (mActivePhone.isOtaSpNumber(dialStr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618063876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618063876;
        // ---------- Original Method ----------
        //return mActivePhone.isOtaSpNumber(dialStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.876 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "7A0F7E9DFA1082A7F5B28975FE2FAC57")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForCallWaiting(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCallWaiting(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.876 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "1368E00A2C91A4D268F450387A0AB6EE")
    public void unregisterForCallWaiting(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.876 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "29CF2ECC84B8D3E199FB2457C17199C1")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSignalInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSignalInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.877 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "142AB670412EC01058CB6F53F7D96EAD")
    public void unregisterForSignalInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.877 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "72532511B8696689C0AD463F22A3525B")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForDisplayInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.877 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "2CBFF56B67E24ADBE96E411A7A3505CA")
    public void unregisterForDisplayInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.878 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "9DF97B3015B6B76ABDD7975F04A82130")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.878 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "DB31F77DDE850A5ABDDCE939B31BB53D")
    public void unregisterForNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.878 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "B6268C334D64FE579DDC7337A843FDFB")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.878 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "EA23055F22C82409974EA5C646C9F4F4")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.878 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "EB8F68ECE541AE5212C58BAE22FE6407")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.879 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "9866513F6165B484F9C82EE42BA76701")
    public void unregisterForLineControlInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.879 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "6EF3FE13E8D4B4DE0EF30449891D2C5E")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.879 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6E8545D949B96A7CE4D63E4B1B8D6D9E")
    public void unregisterForT53ClirInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "38C9723DD1FF75F97274430CFC153B29")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "C8626CA20E4496EED80DD34A3DF177B6")
    public void unregisterForT53AudioControlInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "3F3554D064D0598E39D72A359B615B83")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "84A71D70EC115914F80E5ECFBD659672")
    public void unsetOnEcbModeExitResponse(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unsetOnEcbModeExitResponse(h);
        // ---------- Original Method ----------
        //mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "4145133D79337777EC524679FF8DE024")
    public boolean isCspPlmnEnabled() {
        boolean var968DC313E986F7E5171A3009C3A6CFD0_1321940999 = (mActivePhone.isCspPlmnEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695895298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695895298;
        // ---------- Original Method ----------
        //return mActivePhone.isCspPlmnEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.880 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "A7A752C618C0F5B0EDAEA24653840D1C")
    public IsimRecords getIsimRecords() {
IsimRecords varCB282C5CF39647CE67B46523B0308458_961313763 =         mActivePhone.getIsimRecords();
        varCB282C5CF39647CE67B46523B0308458_961313763.addTaint(taint);
        return varCB282C5CF39647CE67B46523B0308458_961313763;
        // ---------- Original Method ----------
        //return mActivePhone.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.881 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "2E0E9272BC477F1C590A15EF4CAA09AA")
    public void requestIsimAuthentication(String nonce, Message response) {
        addTaint(response.getTaint());
        addTaint(nonce.getTaint());
        mActivePhone.requestIsimAuthentication(nonce, response);
        // ---------- Original Method ----------
        //mActivePhone.requestIsimAuthentication(nonce, response);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.881 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "43A3B37838A642E168FA892B4C75FE7A")
    @Override
    public int getLteOnCdmaMode() {
        int var78D6CBEEE4919F50A98D963F157B7ED1_239053520 = (mActivePhone.getLteOnCdmaMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562507540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562507540;
        // ---------- Original Method ----------
        //return mActivePhone.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.882 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "8D60DF5FF48BD38ADC8FEB3B22F50B0D")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        addTaint(countWaiting);
        addTaint(line);
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.882 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "286866EA80FE074B2883D9069C8153A2")
    @Override
    public UsimServiceTable getUsimServiceTable() {
UsimServiceTable var2C7209F7557F0CD3DC521DED36839829_43438998 =         mActivePhone.getUsimServiceTable();
        var2C7209F7557F0CD3DC521DED36839829_43438998.addTaint(taint);
        return var2C7209F7557F0CD3DC521DED36839829_43438998;
        // ---------- Original Method ----------
        //return mActivePhone.getUsimServiceTable();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.882 -0400", hash_original_field = "D265743C68392037CBF15E907FEED16C", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.882 -0400", hash_original_field = "5796FC476F17BB03669177DD4AF60580", hash_generated_field = "54EE92F4B0FE4A4C30125103756EC93C")

    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.882 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
}

