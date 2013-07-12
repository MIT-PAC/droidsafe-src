package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "10728AB9087E7707D37847A2389DDE0C", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")

    private Phone mActivePhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "7ECE7371C43BE14D2A55B339F95D5963", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "1807C68F8FB5F577A66C3A94E5AD0A66", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "21B855B7AFB6C39284AC629A5ACDC28A", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "18F20DD2807A52A04EA2B70117648163", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "4A5BFF6E8716B82AA5C82CBE6B802317", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.289 -0400", hash_original_field = "B37050DAC53073D34B96D1CA70F3C3FE", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")

    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.290 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "172604CCF05E7950C338A2F8CB3563A0")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.290 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "4EC7E7070072C95BC7C7CA4B02330777")
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
            } 
        } 
    if(mOutgoingPhone.equals("GSM"))        
        {
            logd("Make a new CDMAPhone and destroy the old GSMPhone.");
            ((GSMPhone)mActivePhone).dispose();
            Phone oldPhone = mActivePhone;
            mActivePhone = PhoneFactory.getCdmaPhone();
            ((GSMPhone)oldPhone).removeReferences();
            oldPhone = null;
        } 
        else
        {
            logd("Make a new GSMPhone and destroy the old CDMAPhone.");
            ((CDMAPhone)mActivePhone).dispose();
            Phone oldPhone = mActivePhone;
            mActivePhone = PhoneFactory.getGsmPhone();
            ((CDMAPhone)oldPhone).removeReferences();
            oldPhone = null;
        } 
    if(mResetModemOnRadioTechnologyChange)        
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
        break;
        default:
        break;
}        super.handleMessage(msg);
        
        
    }

    
        private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "7DE620B0C1B9BA03495D04AA646982FE")
    public ServiceState getServiceState() {
ServiceState varB60F40D412C20B5CBF579A3940E0A1CC_154721447 =         mActivePhone.getServiceState();
        varB60F40D412C20B5CBF579A3940E0A1CC_154721447.addTaint(taint);
        return varB60F40D412C20B5CBF579A3940E0A1CC_154721447;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "376EE0FDAAEA7F7F9F36FE970CE53416")
    public CellLocation getCellLocation() {
CellLocation varD3736C0AB7755A59D7EADF001F3ECFF7_1390872399 =         mActivePhone.getCellLocation();
        varD3736C0AB7755A59D7EADF001F3ECFF7_1390872399.addTaint(taint);
        return varD3736C0AB7755A59D7EADF001F3ECFF7_1390872399;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "B22E62B9873BA0548035EA4CAA4060E1")
    public DataState getDataConnectionState() {
DataState var85D280C9C316E2C568EB5A1F249D156E_922034460 =         mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
        var85D280C9C316E2C568EB5A1F249D156E_922034460.addTaint(taint);
        return var85D280C9C316E2C568EB5A1F249D156E_922034460;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "ED1A3F73AC6E01D3A70946EA4A3E9FB1")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
DataState var2A179317F19FC4AC7BBD4C47EF4079EF_2110288824 =         mActivePhone.getDataConnectionState(apnType);
        var2A179317F19FC4AC7BBD4C47EF4079EF_2110288824.addTaint(taint);
        return var2A179317F19FC4AC7BBD4C47EF4079EF_2110288824;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "C0F34EC9E6F8B91D44CB2D591921E7A4")
    public DataActivityState getDataActivityState() {
DataActivityState varC767C1F3BD4173C01DC59523451D79E7_299543807 =         mActivePhone.getDataActivityState();
        varC767C1F3BD4173C01DC59523451D79E7_299543807.addTaint(taint);
        return varC767C1F3BD4173C01DC59523451D79E7_299543807;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.291 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "0576418E42632C144DA2F75D56353086")
    public Context getContext() {
Context var54AA9DCA0CA04F20B6DA14B3F8D0281B_1388559017 =         mActivePhone.getContext();
        var54AA9DCA0CA04F20B6DA14B3F8D0281B_1388559017.addTaint(taint);
        return var54AA9DCA0CA04F20B6DA14B3F8D0281B_1388559017;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.301 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "AFF99A944A226F81BE938F8DE9407D6C")
    public void disableDnsCheck(boolean b) {
        addTaint(b);
        mActivePhone.disableDnsCheck(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.301 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "69C92163DA8943A575A24167C84B0863")
    public boolean isDnsCheckDisabled() {
        boolean var78018A2ADDE0F738B0FAC58F77DC3E07_417352717 = (mActivePhone.isDnsCheckDisabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492900288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_492900288;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.301 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "7B525DA21D6D2CEF08E53D06464C9D21")
    public State getState() {
State varACFA40C09E4BF09E90FCEF22FEF4C12F_315596749 =         mActivePhone.getState();
        varACFA40C09E4BF09E90FCEF22FEF4C12F_315596749.addTaint(taint);
        return varACFA40C09E4BF09E90FCEF22FEF4C12F_315596749;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.301 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "BC17BB67C743B365124C8E8C5A8F9062")
    public String getPhoneName() {
String var7724E001F0B0AD1F05835F621BEB19F0_2096142646 =         mActivePhone.getPhoneName();
        var7724E001F0B0AD1F05835F621BEB19F0_2096142646.addTaint(taint);
        return var7724E001F0B0AD1F05835F621BEB19F0_2096142646;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "D5F79635E37458CE3B6284A47F10FA54")
    public int getPhoneType() {
        int var44199ACE5F580D5BBCAE7F1C66CFA865_2027998397 = (mActivePhone.getPhoneType());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451091199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451091199;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "A0BA47C5A1480B2B50684B14E02D9D98")
    public String[] getActiveApnTypes() {
String[] varFDAE55379D17F23EC7B416DF9CA7C3CA_1887599125 =         mActivePhone.getActiveApnTypes();
        varFDAE55379D17F23EC7B416DF9CA7C3CA_1887599125.addTaint(taint);
        return varFDAE55379D17F23EC7B416DF9CA7C3CA_1887599125;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "EBF792492F378B6A0DDC481A9267E4B6")
    public String getActiveApnHost(String apnType) {
        addTaint(apnType.getTaint());
String var18DD9340F2BD938B2AE2F34A00E865B3_824937698 =         mActivePhone.getActiveApnHost(apnType);
        var18DD9340F2BD938B2AE2F34A00E865B3_824937698.addTaint(taint);
        return var18DD9340F2BD938B2AE2F34A00E865B3_824937698;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "9661452E7048ED04056CEE04905EEE78")
    public LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
LinkProperties var17071AFAEE87FB3A9A650B9DB7BA4CA5_424698585 =         mActivePhone.getLinkProperties(apnType);
        var17071AFAEE87FB3A9A650B9DB7BA4CA5_424698585.addTaint(taint);
        return var17071AFAEE87FB3A9A650B9DB7BA4CA5_424698585;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "317471C1AC7B080190AC1DF17BD74572")
    public LinkCapabilities getLinkCapabilities(String apnType) {
        addTaint(apnType.getTaint());
LinkCapabilities varE4B010A20B7B7134C11F9A30E54489CA_1918517689 =         mActivePhone.getLinkCapabilities(apnType);
        varE4B010A20B7B7134C11F9A30E54489CA_1918517689.addTaint(taint);
        return varE4B010A20B7B7134C11F9A30E54489CA_1918517689;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "D8134D52136589616B67562EF871E677")
    public SignalStrength getSignalStrength() {
SignalStrength varE4D241E8138A7EFDC5C6CF9ABD047B39_1628795037 =         mActivePhone.getSignalStrength();
        varE4D241E8138A7EFDC5C6CF9ABD047B39_1628795037.addTaint(taint);
        return varE4D241E8138A7EFDC5C6CF9ABD047B39_1628795037;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "24F56D053027AB08C8A79DC4E866CE86")
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForUnknownConnection(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "8D1B355FB2DBA3D70FDB44576D8F6455")
    public void unregisterForUnknownConnection(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForUnknownConnection(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "F63CA439CBFCEA93A8E3F120B84A0DFD")
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.302 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "9DB46481EB5B6ECFDA170FDCFA54011D")
    public void unregisterForPreciseCallStateChanged(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "5984FEC8D12245C97D2EF82819794A49")
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "2818E7AA3B15359A336C27D86F04B18F")
    public void unregisterForNewRingingConnection(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForNewRingingConnection(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "BE868B82B463239D97A17B1BE7E7F31B")
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForIncomingRing(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "80A3726B05BCD8ECD87B3CF846F40791")
    public void unregisterForIncomingRing(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForIncomingRing(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "53EE0B98D628436BCED0AC062E2C8CA2")
    public void registerForDisconnect(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForDisconnect(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "64FC6E5F2A014E5A613707C953C4CCD4")
    public void unregisterForDisconnect(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForDisconnect(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "C4DA4BC2B71451A8DA7D681124D659EB")
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForMmiInitiate(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "BAC6C35D62EA993A494B236B7C82F875")
    public void unregisterForMmiInitiate(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForMmiInitiate(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.303 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "E456F613788A10DF5A63AD9AA5751218")
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForMmiComplete(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "DAC58A1D09FAD340CA2DEB9D2D173A8B")
    public void unregisterForMmiComplete(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForMmiComplete(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "AF9E9B2ED7B405EF389F8E2ACA49D041")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> varA24E567B8E59D50FBE82A57AB56DE5D2_1957538594 =         mActivePhone.getPendingMmiCodes();
        varA24E567B8E59D50FBE82A57AB56DE5D2_1957538594.addTaint(taint);
        return varA24E567B8E59D50FBE82A57AB56DE5D2_1957538594;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "F59CBDB18130AB1F22DF3EAEF3490657")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        mActivePhone.sendUssdResponse(ussdMessge);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "1DF7E215BA0848B405697C3FAB7FDB4C")
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "12D321AB2A9466BEDCD5E50F191D79A6")
    public void unregisterForServiceStateChanged(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForServiceStateChanged(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "41490700FBAD2FD1763AFF00B7BD0B45")
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "5D07B07B760EB99B65E240FDA822922F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSuppServiceNotification(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "40308FBF3D8D885AB48280DA00E4DF3F")
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "174B787586E18925D619A2CF428C53F9")
    public void unregisterForSuppServiceFailed(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSuppServiceFailed(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.304 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "1B7FFF0C25FB8CBD7F1F44C1E9CBE65E")
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "F1DE940AB98E38653D0C57577A04DD75")
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "89CEBD1EDFD0B12EB579108819D14367")
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "695FAA881279F98B7F83C7CDA8D3E858")
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "37483E64A759BFC872D87B2A1EBB19FD")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "E0AF213829BDB4C6DF76734508630EB8")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "17367D3F3CCBF8BD408B558442E3AF85")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "632117A5BC9C08F5D65DBDD72B60427F")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "535D7BEFD06CA78319BAA51F74C2BB69")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.305 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "A5DCFB1AAD29313124291A86B003095A")
    public void unregisterForEcmTimerReset(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForEcmTimerReset(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "7B5E90F4C3CFE3BA8118699252DF7AAD")
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForRingbackTone(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "23781EF326A96A81541361D62BB4E27C")
    public void unregisterForRingbackTone(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForRingbackTone(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "6717D6D6DDE155FCFCE61ADF6B62AE2F")
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForResendIncallMute(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "14453173F22986CB0E23E5828B5E8A02")
    public void unregisterForResendIncallMute(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForResendIncallMute(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "CB7C604BBB999349F88E7BAACC38371A")
    public boolean getIccRecordsLoaded() {
        boolean varDB21FD823653993E72363904C598AB1F_769916210 = (mActivePhone.getIccRecordsLoaded());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826142527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826142527;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "AD6A29B9038C814A9DE57178A08BD4EA")
    public IccCard getIccCard() {
IccCard var650671E1AA670BFE90657C7A4B1796AD_1648888597 =         mActivePhone.getIccCard();
        var650671E1AA670BFE90657C7A4B1796AD_1648888597.addTaint(taint);
        return var650671E1AA670BFE90657C7A4B1796AD_1648888597;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.306 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "C503433A44D53B929EFD5EE23A27B526")
    public boolean canConference() {
        boolean varF833CA419DB19C0593324DD68EF3B9D1_1875870408 = (mActivePhone.canConference());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061785476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061785476;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    public void conference() throws CallStateException {
        mActivePhone.conference();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "C5861EB4EFC5C115633C82583A114E8E")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "5D4A98823B23ED5B3B19ADCAD6F7B87B")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "430423C2F595205722D8C6E31F2A63DE")
    public boolean canTransfer() {
        boolean var3E1FD3F8175208BF34A50CBCD5C003E6_1472502699 = (mActivePhone.canTransfer());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149290871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149290871;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.307 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.308 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "3BD3A0B4E5CB05415B5156BC96B9FA5A")
    public Call getForegroundCall() {
Call var0A144D171E8EE3644BEE80F7CB4EE10E_1949759308 =         mActivePhone.getForegroundCall();
        var0A144D171E8EE3644BEE80F7CB4EE10E_1949759308.addTaint(taint);
        return var0A144D171E8EE3644BEE80F7CB4EE10E_1949759308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.308 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "64BD172105914DD74B0D2A442783FC0C")
    public Call getBackgroundCall() {
Call var9298720A9FFCCDE84E4DB6400DDA8A11_531724145 =         mActivePhone.getBackgroundCall();
        var9298720A9FFCCDE84E4DB6400DDA8A11_531724145.addTaint(taint);
        return var9298720A9FFCCDE84E4DB6400DDA8A11_531724145;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.309 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "E29591E26CCAE13179BCFB0C7207FBF2")
    public Call getRingingCall() {
Call var9CBEE4FD766BECD84BEC5FFC3CFB73AC_1241921375 =         mActivePhone.getRingingCall();
        var9CBEE4FD766BECD84BEC5FFC3CFB73AC_1241921375.addTaint(taint);
        return var9CBEE4FD766BECD84BEC5FFC3CFB73AC_1241921375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.309 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "AA8B24511C13308F1F8DE3D18C1F927A")
    public Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
Connection var0E9AF1264BBE0E05A3D02BE43DB349C0_187772438 =         mActivePhone.dial(dialString);
        var0E9AF1264BBE0E05A3D02BE43DB349C0_187772438.addTaint(taint);
        return var0E9AF1264BBE0E05A3D02BE43DB349C0_187772438;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.309 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "04DCD1E0A2B2227C96A36F926B43E3AE")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
Connection var1943C260F8A86B3303DF30E653E5A3AD_2092147651 =         mActivePhone.dial(dialString, uusInfo);
        var1943C260F8A86B3303DF30E653E5A3AD_2092147651.addTaint(taint);
        return var1943C260F8A86B3303DF30E653E5A3AD_2092147651;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.309 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "6269F18443C52D03BB57B975C1A41201")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean varCFF8CA61D4D9884A3A242BAC3CD1E0CA_1219883610 = (mActivePhone.handlePinMmi(dialString));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691865597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691865597;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.309 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "166B008634444E0F5A5FB4DA1E97D372")
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        addTaint(command.getTaint());
        boolean var89ADBAD6C0B3529DB0DB7E7F0FBAD4D0_2087611516 = (mActivePhone.handleInCallMmiCommands(command));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555113327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555113327;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.310 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "1307F86CEC91A8312348D35DA455D984")
    public void sendDtmf(char c) {
        addTaint(c);
        mActivePhone.sendDtmf(c);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.310 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "C718ED1AAE15425A52A667947507B808")
    public void startDtmf(char c) {
        addTaint(c);
        mActivePhone.startDtmf(c);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.310 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.310 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "951BE4178A56FAFFE7EC7D35AC2EC2C5")
    public void setRadioPower(boolean power) {
        addTaint(power);
        mActivePhone.setRadioPower(power);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.311 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "A9B054982955F27FFECE193FE9FF005D")
    public boolean getMessageWaitingIndicator() {
        boolean var8DE0DD89F4263F8099E41573A72B7058_347100597 = (mActivePhone.getMessageWaitingIndicator());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281775705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281775705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.311 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "8AA4DCD69385827074D2F8137FB95273")
    public boolean getCallForwardingIndicator() {
        boolean varB4D062715EDE2BF724527FF56EEB9044_1108011608 = (mActivePhone.getCallForwardingIndicator());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142813239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142813239;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.311 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "369CE943870561500E8D3D3051ED1DC8")
    public String getLine1Number() {
String varD615B04F3BFFE4352C5A5E76D0877B8C_1227796939 =         mActivePhone.getLine1Number();
        varD615B04F3BFFE4352C5A5E76D0877B8C_1227796939.addTaint(taint);
        return varD615B04F3BFFE4352C5A5E76D0877B8C_1227796939;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "6C96190916DC9D234D4B6779FB8F081D")
    public String getCdmaMin() {
String var7B46B2E34699106F982A7086F53B001C_1207044658 =         mActivePhone.getCdmaMin();
        var7B46B2E34699106F982A7086F53B001C_1207044658.addTaint(taint);
        return var7B46B2E34699106F982A7086F53B001C_1207044658;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "7DFD20E8D05602E8B089DFA9723E1410")
    public boolean isMinInfoReady() {
        boolean varC1EAD206A28E9865F7CE7E7DBE7B107C_881475568 = (mActivePhone.isMinInfoReady());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1896281313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1896281313;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "AFAF7FE54B7A633CD82147144502962A")
    public String getCdmaPrlVersion() {
String var6DA4A58D3FB2D81E89A9BF1A54764489_2142740515 =         mActivePhone.getCdmaPrlVersion();
        var6DA4A58D3FB2D81E89A9BF1A54764489_2142740515.addTaint(taint);
        return var6DA4A58D3FB2D81E89A9BF1A54764489_2142740515;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "18CEA165A6DF4C51B69004FDF7407598")
    public String getLine1AlphaTag() {
String var4F99A82D9222BF2D67395946F5434E6A_583937973 =         mActivePhone.getLine1AlphaTag();
        var4F99A82D9222BF2D67395946F5434E6A_583937973.addTaint(taint);
        return var4F99A82D9222BF2D67395946F5434E6A_583937973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "383AEE748CB81D0963D51182B4EA1E6A")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "F312ACB6699B2CF1E1F6BC3606C17FAC")
    public String getVoiceMailNumber() {
String varE7F307187646B548EFAC44A59EF31EBA_1197743588 =         mActivePhone.getVoiceMailNumber();
        varE7F307187646B548EFAC44A59EF31EBA_1197743588.addTaint(taint);
        return varE7F307187646B548EFAC44A59EF31EBA_1197743588;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.312 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "2481A9659831E0548FEF6837612A0D0F")
    public int getVoiceMessageCount() {
        int var50F99E7353D3DAF7CE4A9C6A6EFB1EB5_237710712 = (mActivePhone.getVoiceMessageCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033634973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033634973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "D473CF5966C0F0485B1291573B80E76D")
    public String getVoiceMailAlphaTag() {
String var6E31F87FCF9C640E3D8683C179B7E5FD_1219650155 =         mActivePhone.getVoiceMailAlphaTag();
        var6E31F87FCF9C640E3D8683C179B7E5FD_1219650155.addTaint(taint);
        return var6E31F87FCF9C640E3D8683C179B7E5FD_1219650155;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "02038AF5A83676B9D765BD3C1EB1DCDC")
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(alphaTag.getTaint());
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "7D2EFC2788AD3334389E5A676592CF7D")
    public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "9976F2059BDD04A7F4D2639D2B1E0ADA")
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
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "9D1FDE4529F0B3C2C0B3A78213EBE6C8")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "2E6A3E050563D5B9BA69A87E15CB81FD")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCLIRMode);
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "63D9D61C6F46286DB0E9D674BDF0C59A")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.getCallWaiting(onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.313 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "9C249C453D096D96756657F86F481988")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        mActivePhone.setCallWaiting(enable, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "7F763161CB96CEA998601F806F2F73CF")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getAvailableNetworks(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "0F6A220391CFDABFCF553646347ECFE8")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "76D968F424747911AD7F814E4AEF4941")
    public void selectNetworkManually(OperatorInfo network, Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        mActivePhone.selectNetworkManually(network, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "5A96E85FA6033ECFA817B7AEC5364F02")
    public void setPreferredNetworkType(int networkType, Message response) {
        addTaint(response.getTaint());
        addTaint(networkType);
        mActivePhone.setPreferredNetworkType(networkType, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "EC800BA014DB3B190501334DF6BDD22B")
    public void getPreferredNetworkType(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getPreferredNetworkType(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "C0B818335521DE8B6991EF923B6D35EE")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getNeighboringCids(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "7BAB250002BC50A03B2184C1D1350300")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "404255CBC95825AB40AC39BB660021BB")
    public void setMute(boolean muted) {
        addTaint(muted);
        mActivePhone.setMute(muted);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "AF443CE4706F787DF29CB45FFF18F799")
    public boolean getMute() {
        boolean varCC1DAA68F33B8E3CDE3E8FE4212AA755_1497561997 = (mActivePhone.getMute());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_180592685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_180592685;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.314 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "92212B9BA8AD350E5E9CBF3D6B6258BD")
    public void setEchoSuppressionEnabled(boolean enabled) {
        addTaint(enabled);
        mActivePhone.setEchoSuppressionEnabled(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "CB691D27D8C106B959AF972890FBA458")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        addTaint(response.getTaint());
        addTaint(data[0]);
        mActivePhone.invokeOemRilRequestRaw(data, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "3C584B12B6CC7830F7D9CA75405C5645")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        addTaint(response.getTaint());
        addTaint(strings[0].getTaint());
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "DC4AD885CD74EB4F59C0CA73FC3D327B")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getDataCallList(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "E5066B35D37F0F7B8818ACB3AD4796C5")
    public void setUnitTestMode(boolean f) {
        addTaint(f);
        mActivePhone.setUnitTestMode(f);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "2E01CFF1F5446758AE7D46F17D459C27")
    public boolean getUnitTestMode() {
        boolean var59F70D5C16101D1739ED9D05961581BF_910827999 = (mActivePhone.getUnitTestMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121954038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121954038;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "3C359B33F0943EDCB8F47B63E94F0CF6")
    public void setBandMode(int bandMode, Message response) {
        addTaint(response.getTaint());
        addTaint(bandMode);
        mActivePhone.setBandMode(bandMode, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.315 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "4DF77422AB14FDD0D4A2A732D672FD8C")
    public void queryAvailableBandMode(Message response) {
        addTaint(response.getTaint());
        mActivePhone.queryAvailableBandMode(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.316 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "BD9FFF61ECD66CEC26BED83EED9E6A9E")
    public boolean getDataRoamingEnabled() {
        boolean var500232FE6E30ADF3A5E96A7BA7421CD9_2082010372 = (mActivePhone.getDataRoamingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938146087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938146087;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.316 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "378CA2862A2E93DC00950D4AA8468549")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        mActivePhone.setDataRoamingEnabled(enable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.316 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "D820E1BD78E12612E8A21E89DBE19A34")
    public void queryCdmaRoamingPreference(Message response) {
        addTaint(response.getTaint());
        mActivePhone.queryCdmaRoamingPreference(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.316 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "CB1D338581307F40FBD5373D4F457AC5")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaRoamingType);
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.317 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "2292F902858C89F7DC095CA76C931562")
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaSubscriptionType);
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.317 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "1D43C8684D5F11C191FABEA5DBDBE596")
    public SimulatedRadioControl getSimulatedRadioControl() {
SimulatedRadioControl var260C456268C668FFD10DC75D44F419D6_530867824 =         mActivePhone.getSimulatedRadioControl();
        var260C456268C668FFD10DC75D44F419D6_530867824.addTaint(taint);
        return var260C456268C668FFD10DC75D44F419D6_530867824;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.317 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "096474F82453ACE3EB761DF780B0778B")
    public int enableApnType(String type) {
        addTaint(type.getTaint());
        int var340D8E4E06F7EF077C5DBACF93546724_1660098333 = (mActivePhone.enableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696456423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696456423;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.317 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "261A553F95EF4B1EA896FE01363E21BC")
    public int disableApnType(String type) {
        addTaint(type.getTaint());
        int varDEB79BE8BFFABED2E1315AFDC6B0A6B7_1374533655 = (mActivePhone.disableApnType(type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938486246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938486246;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.317 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "63623002ADA3EC103F426529970F8460")
    public boolean isDataConnectivityPossible() {
        boolean var3F7CBC748801F446D625745FF37272A1_871198274 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383960890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383960890;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.318 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "AD476926E7E7764AEA54DB8219246586")
    public boolean isDataConnectivityPossible(String apnType) {
        addTaint(apnType.getTaint());
        boolean var13B4BA73D19143BDF678F579BD8E6D13_806619003 = (mActivePhone.isDataConnectivityPossible(apnType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942798631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942798631;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.318 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "05CFDB7726BF3F8D2CD9C13D80F6BCCC")
    public String getDeviceId() {
String var198CF460537B68DF3698EB5C512E12E3_219546483 =         mActivePhone.getDeviceId();
        var198CF460537B68DF3698EB5C512E12E3_219546483.addTaint(taint);
        return var198CF460537B68DF3698EB5C512E12E3_219546483;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.319 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "478379F227513A99C73A83A7CCE7110D")
    public String getDeviceSvn() {
String var1A03CCEA3F2C44E7F6EE61AE8F23BC30_187072320 =         mActivePhone.getDeviceSvn();
        var1A03CCEA3F2C44E7F6EE61AE8F23BC30_187072320.addTaint(taint);
        return var1A03CCEA3F2C44E7F6EE61AE8F23BC30_187072320;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.319 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "B9D0ED325DB1DDE286DE1DE7BEC1298A")
    public String getSubscriberId() {
String varC6678EE2A7E2C464908C3BD63EA27F86_1337013918 =         mActivePhone.getSubscriberId();
        varC6678EE2A7E2C464908C3BD63EA27F86_1337013918.addTaint(taint);
        return varC6678EE2A7E2C464908C3BD63EA27F86_1337013918;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.319 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "86151BFFFC2B5F30D4807DC16C5C5F1A")
    public String getIccSerialNumber() {
String var267F6EC3729A7AED6A1BF9FC3CCAF802_925446959 =         mActivePhone.getIccSerialNumber();
        var267F6EC3729A7AED6A1BF9FC3CCAF802_925446959.addTaint(taint);
        return var267F6EC3729A7AED6A1BF9FC3CCAF802_925446959;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "B74C972FDFB7551C4F130CCE1B35E256")
    public String getEsn() {
String varDAE5B56A4AE5B60AC7D4369DE4597632_1526382776 =         mActivePhone.getEsn();
        varDAE5B56A4AE5B60AC7D4369DE4597632_1526382776.addTaint(taint);
        return varDAE5B56A4AE5B60AC7D4369DE4597632_1526382776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "0ADFFB35E276F8A99F97B17B49D09A7F")
    public String getMeid() {
String varC4CD200E31813246A2E36C3829F947E0_1391034040 =         mActivePhone.getMeid();
        varC4CD200E31813246A2E36C3829F947E0_1391034040.addTaint(taint);
        return varC4CD200E31813246A2E36C3829F947E0_1391034040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "02828B654F530CEEC8B04E74B266C280")
    public String getMsisdn() {
String varB5AECFB92CF4F2BBF40515FBEC2A147B_840943526 =         mActivePhone.getMsisdn();
        varB5AECFB92CF4F2BBF40515FBEC2A147B_840943526.addTaint(taint);
        return varB5AECFB92CF4F2BBF40515FBEC2A147B_840943526;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "0A1B4EACC7A197766319C3EA8B8B19EB")
    public String getImei() {
String var199807B9CFD251093717FF07AB2613E7_1786167136 =         mActivePhone.getImei();
        var199807B9CFD251093717FF07AB2613E7_1786167136.addTaint(taint);
        return var199807B9CFD251093717FF07AB2613E7_1786167136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "7D4EE729561E411A7885928A932CD86B")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo var16550AC9086C0A3F72B46C8930895899_620542194 =         mActivePhone.getPhoneSubInfo();
        var16550AC9086C0A3F72B46C8930895899_620542194.addTaint(taint);
        return var16550AC9086C0A3F72B46C8930895899_620542194;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "570CFC062FD6B7E3D07721F7F967DB11")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_388030057 =         mActivePhone.getIccSmsInterfaceManager();
        var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_388030057.addTaint(taint);
        return var7EBB15B8ED2C4F7DC4D4BE1E19A1A37F_388030057;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "B2CECA763B38F8236F3349E12B1E5625")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var313BD6618DEBD160EEE2FF9BFF8F071E_2074080494 =         mActivePhone.getIccPhoneBookInterfaceManager();
        var313BD6618DEBD160EEE2FF9BFF8F071E_2074080494.addTaint(taint);
        return var313BD6618DEBD160EEE2FF9BFF8F071E_2074080494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.320 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "EF3EA2A84E20F62ADBA1891FD398561B")
    public void setTTYMode(int ttyMode, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(ttyMode);
        mActivePhone.setTTYMode(ttyMode, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "7EAC51361D1115FFBD89F4516FC4A284")
    public void queryTTYMode(Message onComplete) {
        addTaint(onComplete.getTaint());
        mActivePhone.queryTTYMode(onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "9884AB43644F370DF0F986FBEE67DD95")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        mActivePhone.activateCellBroadcastSms(activate, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "A5D3A4E6902D2011B38745776779482F")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        mActivePhone.getCellBroadcastSmsConfig(response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "55D28AC60D2BF8EA1D3370842C77F2F4")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.321 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "00848F5CFFFA25D0CBA787F2B7C64E7C")
    public void getSmscAddress(Message result) {
        addTaint(result.getTaint());
        mActivePhone.getSmscAddress(result);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "865D9D8076ABC868AE09A5613D4F82EB")
    public void setSmscAddress(String address, Message result) {
        addTaint(result.getTaint());
        addTaint(address.getTaint());
        mActivePhone.setSmscAddress(address, result);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "377B3CC1204A94051BC4F7C24298F251")
    public int getCdmaEriIconIndex() {
        int var97F376A0CADC0E4F36957FFCCAA76010_2108037967 = (mActivePhone.getCdmaEriIconIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651707386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651707386;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "E6A32A92C90CE242FBFD90464D67308E")
    public String getCdmaEriText() {
String varFBAA172F150BFFB1490E4FAFF06EF198_2078417219 =         mActivePhone.getCdmaEriText();
        varFBAA172F150BFFB1490E4FAFF06EF198_2078417219.addTaint(taint);
        return varFBAA172F150BFFB1490E4FAFF06EF198_2078417219;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "9FF041E74BB42BDD3FB44802B5F4856E")
    public int getCdmaEriIconMode() {
        int varA3BAE708044E7BB258DBC489E1A088D7_201949841 = (mActivePhone.getCdmaEriIconMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615871614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615871614;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "12041D3D4DC7E3A010E88179279D74AE")
    public Phone getActivePhone() {
Phone var80DB6AE27D465D54797BEB544C72E98B_694173884 =         mActivePhone;
        var80DB6AE27D465D54797BEB544C72E98B_694173884.addTaint(taint);
        return var80DB6AE27D465D54797BEB544C72E98B_694173884;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.325 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "B796F00AD431E9DB16507806386917E9")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.326 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.326 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "5831341303B44189B3DD44A9E83A3958")
    public boolean needsOtaServiceProvisioning() {
        boolean var3D8AA6EF8A5C1C19617F8C58BDE40E86_699183905 = (mActivePhone.needsOtaServiceProvisioning());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196206071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196206071;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.326 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "E9962F7416D79A2479D469787E2BE023")
    public boolean isOtaSpNumber(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean varB501AD12C60C738D74C29D7FCFDEC660_1800657073 = (mActivePhone.isOtaSpNumber(dialStr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181647231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181647231;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.327 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "7A0F7E9DFA1082A7F5B28975FE2FAC57")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForCallWaiting(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.327 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "1368E00A2C91A4D268F450387A0AB6EE")
    public void unregisterForCallWaiting(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForCallWaiting(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.328 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "29CF2ECC84B8D3E199FB2457C17199C1")
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForSignalInfo(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.328 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "142AB670412EC01058CB6F53F7D96EAD")
    public void unregisterForSignalInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForSignalInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.328 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "72532511B8696689C0AD463F22A3525B")
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForDisplayInfo(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.328 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "2CBFF56B67E24ADBE96E411A7A3505CA")
    public void unregisterForDisplayInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForDisplayInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.328 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "9DF97B3015B6B76ABDD7975F04A82130")
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForNumberInfo(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.330 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "DB31F77DDE850A5ABDDCE939B31BB53D")
    public void unregisterForNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForNumberInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.330 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "B6268C334D64FE579DDC7337A843FDFB")
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.330 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "EA23055F22C82409974EA5C646C9F4F4")
    public void unregisterForRedirectedNumberInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.331 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "EB8F68ECE541AE5212C58BAE22FE6407")
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForLineControlInfo( h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.331 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "9866513F6165B484F9C82EE42BA76701")
    public void unregisterForLineControlInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForLineControlInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.331 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "6EF3FE13E8D4B4DE0EF30449891D2C5E")
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.331 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6E8545D949B96A7CE4D63E4B1B8D6D9E")
    public void unregisterForT53ClirInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForT53ClirInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.331 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "38C9723DD1FF75F97274430CFC153B29")
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "C8626CA20E4496EED80DD34A3DF177B6")
    public void unregisterForT53AudioControlInfo(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unregisterForT53AudioControlInfo(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "3F3554D064D0598E39D72A359B615B83")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "84A71D70EC115914F80E5ECFBD659672")
    public void unsetOnEcbModeExitResponse(Handler h) {
        addTaint(h.getTaint());
        mActivePhone.unsetOnEcbModeExitResponse(h);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "BD879132A5AFE0ABF504AED8F54FFBD3")
    public boolean isCspPlmnEnabled() {
        boolean var968DC313E986F7E5171A3009C3A6CFD0_1784609394 = (mActivePhone.isCspPlmnEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138303830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138303830;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "B3377A9241D6342A7E7007F81ACD7F31")
    public IsimRecords getIsimRecords() {
IsimRecords varCB282C5CF39647CE67B46523B0308458_62889743 =         mActivePhone.getIsimRecords();
        varCB282C5CF39647CE67B46523B0308458_62889743.addTaint(taint);
        return varCB282C5CF39647CE67B46523B0308458_62889743;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.332 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "2E0E9272BC477F1C590A15EF4CAA09AA")
    public void requestIsimAuthentication(String nonce, Message response) {
        addTaint(response.getTaint());
        addTaint(nonce.getTaint());
        mActivePhone.requestIsimAuthentication(nonce, response);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.333 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "8F2FA52A6A5BE925E2E227EC9D5B436B")
    @Override
    public int getLteOnCdmaMode() {
        int var78D6CBEEE4919F50A98D963F157B7ED1_315513407 = (mActivePhone.getLteOnCdmaMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823190732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823190732;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.333 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "8D60DF5FF48BD38ADC8FEB3B22F50B0D")
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        addTaint(countWaiting);
        addTaint(line);
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.335 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "682647475BA3A87C7B077DFB32A5F78B")
    @Override
    public UsimServiceTable getUsimServiceTable() {
UsimServiceTable var2C7209F7557F0CD3DC521DED36839829_696113601 =         mActivePhone.getUsimServiceTable();
        var2C7209F7557F0CD3DC521DED36839829_696113601.addTaint(taint);
        return var2C7209F7557F0CD3DC521DED36839829_696113601;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.335 -0400", hash_original_field = "D265743C68392037CBF15E907FEED16C", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.335 -0400", hash_original_field = "5796FC476F17BB03669177DD4AF60580", hash_generated_field = "54EE92F4B0FE4A4C30125103756EC93C")

    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.335 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
}

