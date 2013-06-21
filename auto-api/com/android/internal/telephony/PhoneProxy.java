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
    private Phone mActivePhone;
    private String mOutgoingPhone;
    private CommandsInterface mCommandsInterface;
    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    private boolean mResetModemOnRadioTechnologyChange = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.671 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "1F05ADEB8974E953FB8AB81BA1B16213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneProxy(Phone phone) {
        dsTaint.addTaint(phone.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.672 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "1E3AB7ECA9BB4A0FC09A6B19A47F5F47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
                boolean var01B1DDE89E6E9D2BC475F5FFE0326C76_24094981 = (mCommandsInterface.getRadioState().isOn());
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
            boolean var567788BF435FAFE5B3B27D51A9536128_246682953 = (mOutgoingPhone.equals("GSM"));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.674 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "9EBD8F2C115082B7E66175A252D2F479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState getServiceState() {
        ServiceState var68A6299B03F5C6DE8DBFFE00CF64CB52_485102797 = (mActivePhone.getServiceState());
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.674 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "ADE345455A8FA2CA13914A899B6A0B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CellLocation getCellLocation() {
        CellLocation var5D6A546CD7CD9EB866718740B52A0AE6_219106297 = (mActivePhone.getCellLocation());
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getCellLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.674 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "9DC33963A6301359A05E9BBDBA10CD7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState() {
        DataState var39A1908289DC27F9F6237CDECE88297E_2015589701 = (mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.675 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "03DB003012E1B4065F0B72BC2571E9F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState(String apnType) {
        dsTaint.addTaint(apnType);
        DataState var5472BFD0FF7C69B2C073F54858F7E78F_148199780 = (mActivePhone.getDataConnectionState(apnType));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.675 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "8961F6E7855E7139156EB3579567680D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataActivityState getDataActivityState() {
        DataActivityState var448332583A6ABD5E1DABE76DB28830B8_578838969 = (mActivePhone.getDataActivityState());
        return (DataActivityState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataActivityState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.675 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "B47D20A1A67C09B7F7EC2F6640749B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getContext() {
        Context var8868A5FB63500B5DED9638973CDD9011_850934949 = (mActivePhone.getContext());
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.675 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "33B683A008802C28D06F357DF569783A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableDnsCheck(boolean b) {
        dsTaint.addTaint(b);
        mActivePhone.disableDnsCheck(b);
        // ---------- Original Method ----------
        //mActivePhone.disableDnsCheck(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.675 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "8E60A6EC0FADEC76348901F58C8E0B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDnsCheckDisabled() {
        boolean var63BCDE066CAA6ED52BCDEA8E29F6B1DB_583187980 = (mActivePhone.isDnsCheckDisabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDnsCheckDisabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.676 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "01B17095C20BDECE0FC2346D62A19819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getState() {
        State var995854D66F535E24949945EA663AE145_4124145 = (mActivePhone.getState());
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.676 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "36923C2F873C21D7EFE55D4F6626AF08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneName() {
        String var5F0FC993ED2DE4CF56E3AD22001B2604_825258625 = (mActivePhone.getPhoneName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.676 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "1DD39634A9038CDE31BE10CE6BA5F341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPhoneType() {
        int varB5C5EFC4899F813B21E51CD745860764_269368670 = (mActivePhone.getPhoneType());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.676 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "269AED958A56EE60CE912F5ACAD6F62E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getActiveApnTypes() {
        String[] varFE4B2C63DC7552A45AABC2A6D1D6D99C_1603256936 = (mActivePhone.getActiveApnTypes());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.676 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "8CBD9DD5D422F925FB4CD57FE8382E77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getActiveApnHost(String apnType) {
        dsTaint.addTaint(apnType);
        String var20554E84F4D293A98E0A4491756546C8_788654267 = (mActivePhone.getActiveApnHost(apnType));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnHost(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.677 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "AB24FFCD3EE5036A4F8B428B541F2B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        LinkProperties var9C6162DC120629310398FD5418471D58_915533921 = (mActivePhone.getLinkProperties(apnType));
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.677 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "069AA4737A816D5C0E09BAEE2595B0BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        LinkCapabilities var35CA08C2FFC06879213E013B7419860A_1568654218 = (mActivePhone.getLinkCapabilities(apnType));
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.677 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "AA088B1BD06A68137C670BC5DD5EC5AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength getSignalStrength() {
        SignalStrength var9F23190DAB6C2A562F1AD505A48809D9_2123740017 = (mActivePhone.getSignalStrength());
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getSignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.677 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "09695D0E21031EC2A9225A2059AC7011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForUnknownConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.677 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "5DB95A6B9F6361CB58A110F7C0C03AB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForUnknownConnection(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForUnknownConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForUnknownConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.678 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "44E0DA573CE9C6623651DC1164AD6D4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.678 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "911C5A8D615B0534132C90E9C2AA3A2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForPreciseCallStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.678 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "0635E878CA37D0FCA2CFF17F9E7C2D43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.678 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "4F087A08FB93C7FCB86527E442629F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNewRingingConnection(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForNewRingingConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNewRingingConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.679 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "613DA92CC58E9116C5D0994A08136C6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForIncomingRing(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForIncomingRing(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.679 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "F8CB61AE6FE061B285E6B0647EFE62AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForIncomingRing(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForIncomingRing(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForIncomingRing(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.679 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "68D32301333710E1D30F3BDAB32BC408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForDisconnect(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisconnect(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.679 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "D6D52CC51FC7F07CC8F13EDD933BD827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDisconnect(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForDisconnect(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisconnect(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.679 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "87729181BF1C4811DA54E4D1517403C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForMmiInitiate(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "1A7B50B3D803D98816E708ECC6886D91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForMmiInitiate(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForMmiInitiate(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiInitiate(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "F4FA07A92525B371EF1FEF808EB171F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForMmiComplete(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiComplete(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "C935D49C3EC29C4020119CDBDBBDD120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForMmiComplete(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForMmiComplete(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiComplete(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "9AA9705050A6893DEA1E46959C641138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varFBFB9846DEED69D90C7852623E9CA9DC_905719059 = (mActivePhone.getPendingMmiCodes());
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getPendingMmiCodes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "98DCA80850BED465BADDA73C06674BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        mActivePhone.sendUssdResponse(ussdMessge);
        // ---------- Original Method ----------
        //mActivePhone.sendUssdResponse(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.680 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "1605D720C9B7043363BE6A0CEB2870E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.681 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "BF2299CF6E230498B1648CEF1D9E140F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForServiceStateChanged(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForServiceStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForServiceStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.681 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "0E65BEDFC1C33FCFEFCC07A68E470775")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.681 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "604F41547B54DC4F816AD3E2CBF4762A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSuppServiceNotification(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSuppServiceNotification(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceNotification(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.681 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "46496CE5A71AFB071A70002F9F5DAF04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.681 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "76E69F586EFD2A8E9E16FEC354737237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSuppServiceFailed(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSuppServiceFailed(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceFailed(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.682 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "F15EB505B491CB927F06A16B15463630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.682 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "10653C45C164D504FBCCF29BAEC384DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.682 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "CD15C8C6EB7706CF2CF93B209EB47661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.682 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "27A468D3E688A7A49B57109FD7E02F94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.682 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "B1D8B30CE9885C10D2A9087AB9DFC198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "FD7D09FC055A948FDA7FCC9FFFFB3773")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "0DC8FCCC43C25610B6038AF5029C9CC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "54CAF32656BBB6C4DCF98B9682788C2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSubscriptionInfoReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "C41ED18D43520847535A4429D2182A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "C80D91E28363D96EC5A42719095FE4D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForEcmTimerReset(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForEcmTimerReset(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForEcmTimerReset(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.683 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "17C33382CAFDC51D5F99AABD20A92512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "53FC7B1EBDA186DEB0AE8BF74E8C6F34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRingbackTone(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "671B8B2906F5E4BDB3FCB2D621770375")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "B306EB90A6833CB7E1514507E1086AE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForResendIncallMute(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "7B692785511C3EEEC4DAFFABC73BA4E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getIccRecordsLoaded() {
        boolean varD34CD95BD9903759FA66B479DE10B32C_2060157424 = (mActivePhone.getIccRecordsLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getIccRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "17C3E7A88E5BE992F87AAB754A48D6B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccCard getIccCard() {
        IccCard varFDFBF4D817EF0C0729E3392EF51C246F_114151791 = (mActivePhone.getIccCard());
        return (IccCard)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccCard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.684 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "A277E50117A2E01AD5FB8CC532607D62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        // ---------- Original Method ----------
        //mActivePhone.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "C2B9EDFBE66B3696443E4D7CCAC2C89C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        // ---------- Original Method ----------
        //mActivePhone.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "9F7F775A077B9F6F14E584FC9157BCAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        // ---------- Original Method ----------
        //mActivePhone.switchHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "15959BB7A5B405B54467B127C273A67C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canConference() {
        boolean varBEBBDC11FE20620D331255B29CB7C083_423194266 = (mActivePhone.canConference());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "2767764ED8E32D7B2DC8DBC8F1C54100")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void conference() throws CallStateException {
        mActivePhone.conference();
        // ---------- Original Method ----------
        //mActivePhone.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "30F70EC81C014A368DF61AD4FDBD983C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "2BB68198525460FD7D436BC6407353CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.685 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "1400FC9AF85D1858654C1C63DD86F655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTransfer() {
        boolean varA271678BA825E5B535929271849B2922_1075996863 = (mActivePhone.canTransfer());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "17DCD3FECAB90CF0C35DB2DA1F0E5B0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        // ---------- Original Method ----------
        //mActivePhone.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "A7271A2F092FEA9C5ED4627E2ECE310B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        // ---------- Original Method ----------
        //mActivePhone.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "BF980D4CBFD4B1852E3B174BFE85F596")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getForegroundCall() {
        Call var09EE12544CE529DE2F9AD98B26AA9446_1731584383 = (mActivePhone.getForegroundCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getForegroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "D62AF25E69F6FF83A5EF341B59DDEAB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getBackgroundCall() {
        Call var4BCF868900FE3124FB5FA46464F4BB1F_228046804 = (mActivePhone.getBackgroundCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getBackgroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "2977BFCE8C0447EBDC3A549B3905F109")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getRingingCall() {
        Call var168AA4ECE8197CB04DD3E9F7402E7E5D_227225998 = (mActivePhone.getRingingCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getRingingCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.686 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "F3EE6F8787B2FFB2128822B51E866DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        Connection var32A22D652381019DA25DF9814E3FD615_2124334089 = (mActivePhone.dial(dialString));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.687 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "501F109D97666210D6A5A0938D1AE5C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        Connection var1A4300BF0DA93EA826AE1CF555EB94F1_1393537996 = (mActivePhone.dial(dialString, uusInfo));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.687 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "A1A7BFC6FD1579CE57F17E439C4E57D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        boolean var9EAF3797F0895E045EDD8A2A6F3E9DC3_1185352493 = (mActivePhone.handlePinMmi(dialString));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.handlePinMmi(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.687 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "DC08C12D448057542A5258F63EF90FF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        dsTaint.addTaint(command);
        boolean varB6713A0B25EC29F71205412BEAB34760_1898568187 = (mActivePhone.handleInCallMmiCommands(command));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.handleInCallMmiCommands(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.687 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "4B585F3AF7060F5CF709159969769791")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        mActivePhone.sendDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.sendDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.687 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "84DFA13BB7CB5D33E3FBEFC6F786B910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        mActivePhone.startDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.startDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.698 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "E2D070ECDE64FCAAC101196E4561F340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        // ---------- Original Method ----------
        //mActivePhone.stopDtmf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.698 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "5F0E073D074CC7D95F28DC27C12C8A0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        mActivePhone.setRadioPower(power);
        // ---------- Original Method ----------
        //mActivePhone.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.698 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "E9A50771A75D619A2AA408A3C31A05A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMessageWaitingIndicator() {
        boolean varE36CE85276F33DCC5B02481874938DBC_231971909 = (mActivePhone.getMessageWaitingIndicator());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.698 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "7DCF1390916E9D20AFBCE6C194EE34EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getCallForwardingIndicator() {
        boolean var711465E26D829245ADB92E0313FED47F_420741582 = (mActivePhone.getCallForwardingIndicator());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getCallForwardingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.699 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "A43B7DD3712A8C4F7C0146D5AA50DBB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var6A5444B45643DE896C5B531D2376DCA8_714757133 = (mActivePhone.getLine1Number());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.699 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "288E63392DD72DD69A1475D9022F3563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaMin() {
        String var088DD5310349107F29D3792A6000BB8C_1890432959 = (mActivePhone.getCdmaMin());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.699 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "9F9A09018175DDE12AB0ECB9DE97D936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMinInfoReady() {
        boolean varBADBA5710877FFB10FBC68610BD4AFC0_128528890 = (mActivePhone.isMinInfoReady());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.699 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "258C5D6F980C739DCAB8021CC9E5C99E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaPrlVersion() {
        String varD5AE4A4CBD2F880C9A908311D0D36F3E_1686318867 = (mActivePhone.getCdmaPrlVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.699 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "D22B948C92EC890DE641FE91F230A4EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        String varA1897AD9ABF542ACBB7A2B7FF5E1C5F4_1856899957 = (mActivePhone.getLine1AlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.700 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "12972A0D9EA2936ADF6147B91FF7F4F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.700 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "7D82E8278A511692E95AE7E60679FFBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String varDD102027E9A8ED892A47E16CFF1014F5_1312015017 = (mActivePhone.getVoiceMailNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.700 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "EE0435EBBA460FD2FE228353F93DCA01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVoiceMessageCount() {
        int varC9B97605CE24C2BC7E55AC0885C61958_1831592377 = (mActivePhone.getVoiceMessageCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMessageCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.700 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "BB4487847CDBE67F23121D5066E844CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String var9C6F41174851009625FA52C459B0B495_1977555362 = (mActivePhone.getVoiceMailAlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.700 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "1257CC915096405A9C566FD6B5E2FB1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(voiceMailNumber);
        dsTaint.addTaint(alphaTag);
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.701 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "EF850AC99AEBDFF2C883A6D1130E64CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCFReason);
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.701 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "19F3155B2FC105C7BEA0F01B637759AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallForwardingOption(int commandInterfaceCFReason,
            int commandInterfaceCFAction, String dialingNumber,
            int timerSeconds, Message onComplete) {
        dsTaint.addTaint(timerSeconds);
        dsTaint.addTaint(commandInterfaceCFAction);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(dialingNumber);
        dsTaint.addTaint(commandInterfaceCFReason);
        mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            //commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.701 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "6A5AACA9010A97970214B0FA7F9CF9B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.702 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "DEF9ED9B098A4BB9E60E75299DFA1485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                //onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.702 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "C57B58C6951B5AA9DCC78F78659EAB05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getCallWaiting(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getCallWaiting(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.702 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "8F240C137967E78A57AC7661FC78D3DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        mActivePhone.setCallWaiting(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setCallWaiting(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.702 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "C58D0C3CA013340E21FFFFF40440C675")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mActivePhone.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.702 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "1E78DAA9C53A8FFAA302851A44602131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkSelectionModeAutomatic(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        // ---------- Original Method ----------
        //mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.703 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "150A266E873132D1116380E7080C7FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectNetworkManually(OperatorInfo network, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        mActivePhone.selectNetworkManually(network, response);
        // ---------- Original Method ----------
        //mActivePhone.selectNetworkManually(network, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.703 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "26AC22FA919917701E1759B402CE6603")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPreferredNetworkType(int networkType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(networkType);
        mActivePhone.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mActivePhone.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.703 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "A5B2C5859D5DE3E274454E3AF3B41EBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getPreferredNetworkType(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mActivePhone.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.704 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "C8A9D1010B466F2772472275B4B0BB94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getNeighboringCids(response);
        // ---------- Original Method ----------
        //mActivePhone.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.704 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "28BAD06B7F2F1CE681440DC84C3464FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.705 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "B5F7761AE211EE431DFCC22A8257A60B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        mActivePhone.setMute(muted);
        // ---------- Original Method ----------
        //mActivePhone.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.705 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "D95E4C1C62911CDC5A671E92F427FE27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var1B9136C6599825A7694821391361E39E_1724003054 = (mActivePhone.getMute());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.706 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "81BD81D402D714F87B43D652F89C3046")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEchoSuppressionEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mActivePhone.setEchoSuppressionEnabled(enabled);
        // ---------- Original Method ----------
        //mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.706 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "8EFB42695E498E70F0D4290839E453AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(data[0]);
        mActivePhone.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.706 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "68A72DF7DAA6190B4407B3511A9FFBF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(strings[0]);
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.706 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "D13292380D95058F6C1CF24448C215E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getDataCallList(response);
        // ---------- Original Method ----------
        //mActivePhone.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.706 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "6AC143B2A053E16C92E4BC668BDC8386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        // ---------- Original Method ----------
        //mActivePhone.updateServiceLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.707 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "EE686EA0C1CC3D0FF23D1171258EA387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.707 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "918C89BD45069A6F50EBD48797A4DB8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.707 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "AD2FD3F4B42A43CE56F96401F8800A73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUnitTestMode(boolean f) {
        dsTaint.addTaint(f);
        mActivePhone.setUnitTestMode(f);
        // ---------- Original Method ----------
        //mActivePhone.setUnitTestMode(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.707 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "98E69EFD99F30AFBC2F20C82BF52091F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getUnitTestMode() {
        boolean varE57924CD4DCE3E1FC1150866D669EFEB_749588581 = (mActivePhone.getUnitTestMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getUnitTestMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.707 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "66772C1A93004DF8DAD52BCFFFE4C42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBandMode(int bandMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(bandMode);
        mActivePhone.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mActivePhone.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.708 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "46CA78B58F6F571AEAEF461852F6C6C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryAvailableBandMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mActivePhone.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.708 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "55C04F28D11D0C0A60F4E73069865A77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataRoamingEnabled() {
        boolean var25967ADD269A46D57FF30D567DD05A9D_1391259989 = (mActivePhone.getDataRoamingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getDataRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.708 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "F4245EB63CFB589A39E5B42A38607987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mActivePhone.setDataRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mActivePhone.setDataRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.708 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "90CB432051BC7D9E96D8EA12D79459D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryCdmaRoamingPreference(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mActivePhone.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.708 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "17465A7F859E70C2BC644092FF12E803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaRoamingType);
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.709 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "AF6EBB91720F8EBEB8396AC1ECB2413D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaSubscriptionType);
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.709 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "5CE3A0CAFF755480ACFE8A2E2A123182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varC2FE4D10D10BDB42F1AA6F0F831C38BC_937731381 = (mActivePhone.getSimulatedRadioControl());
        return (SimulatedRadioControl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getSimulatedRadioControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.709 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "CAD5C0BFBE4C0CB9647E155AA86CA088")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enableApnType(String type) {
        dsTaint.addTaint(type);
        int varA930C257BD4665C868EA6EF284E5FAB4_387280661 = (mActivePhone.enableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.709 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "D783E4FFBD2A1FE4B720DB742F5B88D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int disableApnType(String type) {
        dsTaint.addTaint(type);
        int var0EE96BBA6B6E6339EB47881723DB0B34_1467959371 = (mActivePhone.disableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.709 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "925BD9EEE1FA56C8A7B3E9CBDA3BF1C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible() {
        boolean varFD50EE22A236A635A1A5E6ECDDC3AD83_599098613 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.710 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "10FB8F618ED449A702B048F626E627D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible(String apnType) {
        dsTaint.addTaint(apnType);
        boolean var7B46E2C66CD7327260F34CAEEF4F7C05_778778415 = (mActivePhone.isDataConnectivityPossible(apnType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.710 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "DAEDF10F5465A1AC4BE69298E1C97BCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        String varA06FB37169DF3EA57D58C62B54B1C20A_266805538 = (mActivePhone.getDeviceId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.710 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "CE4846B3788B1089A3096AC0CB6DBC5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSvn() {
        String var9F05C900CEC245C57C549C403F57E7D7_1949175633 = (mActivePhone.getDeviceSvn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.710 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "86FBC31C2B0AA986F20D514A5FA7AF23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String var8A51A4D484693B644E2C2A9914385B7E_1417287000 = (mActivePhone.getSubscriberId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.710 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "DECD97B6BEC32B01A0F26622EBA02B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIccSerialNumber() {
        String varCE2ABD4DD3C528AF73986DDC49FB2362_1493861372 = (mActivePhone.getIccSerialNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "347D6EC7E1D86C3C79ECF8EF1F37AC0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEsn() {
        String varE2127E237DBEEA4B4F086C92813ECEF2_1733110329 = (mActivePhone.getEsn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getEsn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "27F7C83152C0F5C44E0823ABBA444B16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMeid() {
        String var1DA94A645E16112BE2D864F6F16440E9_2070594248 = (mActivePhone.getMeid());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getMeid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "28240208533A71DDA98158CAFE13DD41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        String varA4F464752386C26D6465AB8C838A3CE2_252639302 = (mActivePhone.getMsisdn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "DB4DBEA6DD1BBD2049E3D24E7ECDB545")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getImei() {
        String var67B5768DDFFDEC0EB30CD43936C3A955_1367476576 = (mActivePhone.getImei());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getImei();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "5C2F4E86D26326B31C69FCB7AA42C502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo var7AC4CA237015E4BE3BB6336167CF81C5_1159303025 = (mActivePhone.getPhoneSubInfo());
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneSubInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "9A555C02D484444407EC6752811CADBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varD2BEA2D316C97FE0A2552247A3397A0D_1546340953 = (mActivePhone.getIccSmsInterfaceManager());
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccSmsInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.711 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "010DC7F409DD798241FD4F64CBDBCE07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager var6F9416B1006A25743BCB3C7AB738FBF6_1691686797 = (mActivePhone.getIccPhoneBookInterfaceManager());
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "571CE765C8B73D5D5DE276C3DFD8130D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTTYMode(int ttyMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(ttyMode);
        mActivePhone.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "FE22E3525878B649865E0A2EDF34EE4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void queryTTYMode(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "EBBBE0C6A8E6F3A82A7596CDF7A1B1EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(activate);
        mActivePhone.activateCellBroadcastSms(activate, response);
        // ---------- Original Method ----------
        //mActivePhone.activateCellBroadcastSms(activate, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "47C7E9FE50F174CE6074EA90443418CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getCellBroadcastSmsConfig(response);
        // ---------- Original Method ----------
        //mActivePhone.getCellBroadcastSmsConfig(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "E5508D4A2C06E8B065E1CBC691471EBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray[0]);
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        // ---------- Original Method ----------
        //mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.712 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "146B4894587E9A8C34FBA98E63CB8ABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        // ---------- Original Method ----------
        //mActivePhone.notifyDataActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "9E7D04FB30A4A33A5F468E91148A9F89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSmscAddress(Message result) {
        dsTaint.addTaint(result.dsTaint);
        mActivePhone.getSmscAddress(result);
        // ---------- Original Method ----------
        //mActivePhone.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "C9BE45EF6632F2DAA44A5D514D03B772")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSmscAddress(String address, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        mActivePhone.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mActivePhone.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "9E4EA05F4062B2F4B679420425366F97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconIndex() {
        int varE8C65943584090697CBEEDCCAFC2799B_1988987100 = (mActivePhone.getCdmaEriIconIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "34E38396AA9E91B3E4963A0424626783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaEriText() {
        String varA44D2B9F8DC51266BAA79BEC6AC3AB01_1298991217 = (mActivePhone.getCdmaEriText());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "2FBBE8467161B3DDF507110F40275C27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconMode() {
        int var44559B7F040E42DDDD7BF51EF4F1B3DA_404025920 = (mActivePhone.getCdmaEriIconMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "0CC132DAA2851F97B3287691273C43C8")
    @DSModeled(DSC.SAFE)
    public Phone getActivePhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.713 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "6820BDC2FCEE6EC10470CA10DB3FAE4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "FB8A8D637BCF4A179080A06ED7351DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        // ---------- Original Method ----------
        //mActivePhone.exitEmergencyCallbackMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "8A75BAA9A75245415E8ECF9AB7BA0903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needsOtaServiceProvisioning() {
        boolean var970502384D9890BA0973B383AB80C6FC_1175826155 = (mActivePhone.needsOtaServiceProvisioning());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.needsOtaServiceProvisioning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "982B3F0FFB56EE60E1FCD152470CBDC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOtaSpNumber(String dialStr) {
        dsTaint.addTaint(dialStr);
        boolean varB4E5E50A833DA40DB1EDA30167AA00E1_646104822 = (mActivePhone.isOtaSpNumber(dialStr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isOtaSpNumber(dialStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "C760BD3EBE9851873DF6B3BCB0B33340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForCallWaiting(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCallWaiting(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "A518CFB62BF600715C890CDC31199329")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallWaiting(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "478E97B9839172997A1C98DD759C165E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSignalInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSignalInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.714 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "3C9069A5EC308DE82D3AF3DAD4C6DBF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSignalInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "99D67BE86B58D97E1282C3F7BBE5BCAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForDisplayInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "B2DBBBECA697199AFDDFD06CDF4DB419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForDisplayInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "EECD92BD8349B2BE891B16AC6C6B44EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "CD363DA39BF5740B5614F3EF904D1877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "3F620631917D90308E66C1F4A008F492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.715 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "F48A0245D94EDF9F8D3A84D83A367078")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForRedirectedNumberInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "4CC8288D3B41A3C7B52A49AC031EAB69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "05178D938DD794B4C2089CC056443E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForLineControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "2DA62AC7EDD45320073CE8F79FB4047B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "A5FE7752D394EACB3EA4A13A24644A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53ClirInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "336F2B6CB8A158E898D307B10AD3335F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "BC7A5A9C15CFC815BA60339236CADECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForT53AudioControlInfo(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.716 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "FA857D1BE0670156B38E89F10BB2124B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.717 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "35DA8C9E7715903326B030BD67074BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unsetOnEcbModeExitResponse(h);
        // ---------- Original Method ----------
        //mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.717 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "0FAD21AD1C3A4D4D6C8599A9039D6F1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCspPlmnEnabled() {
        boolean var202889D1FB2BEDDDD330D07A42C96AAA_366284904 = (mActivePhone.isCspPlmnEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isCspPlmnEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.717 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "76AC9745EBD419D3D7BF0889C4BCE9EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IsimRecords getIsimRecords() {
        IsimRecords var3797B3AFE135B247AC4E4C046D28FD89_147895734 = (mActivePhone.getIsimRecords());
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.717 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "7B0498B8D7FACA5E66866AFFC10C16C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestIsimAuthentication(String nonce, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(nonce);
        mActivePhone.requestIsimAuthentication(nonce, response);
        // ---------- Original Method ----------
        //mActivePhone.requestIsimAuthentication(nonce, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.718 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "01CE934062BE1FC522496D77BFCFDE46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int varC068356BB4D68BB6F09FF66311887211_403232074 = (mActivePhone.getLteOnCdmaMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.718 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "ED55451938F10EFA7629668A7F58353B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(countWaiting);
        dsTaint.addTaint(line);
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.720 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "A16510E7324964AA6591F232B29AC634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable var2709A3F874BD957959B962BB1AB64CD4_2004094904 = (mActivePhone.getUsimServiceTable());
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getUsimServiceTable();
    }

    
    public final static Object lockForRadioTechnologyChange = new Object();
    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    private static final String LOG_TAG = "PHONE";
}

