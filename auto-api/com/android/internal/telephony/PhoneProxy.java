package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public final static Object lockForRadioTechnologyChange = new Object();
    private Phone mActivePhone;
    private String mOutgoingPhone;
    private CommandsInterface mCommandsInterface;
    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
    private PhoneSubInfoProxy mPhoneSubInfoProxy;
    private boolean mResetModemOnRadioTechnologyChange = false;
    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
    private static final String LOG_TAG = "PHONE";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.389 -0400", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "B0BD967A4866AD751B047C79C892F906")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "B940ABF0B231C9C89EFABD0EC1A95322")
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
                boolean var01B1DDE89E6E9D2BC475F5FFE0326C76_1143606864 = (mCommandsInterface.getRadioState().isOn());
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
            boolean var567788BF435FAFE5B3B27D51A9536128_509154135 = (mOutgoingPhone.equals("GSM"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "0B1698B355A404B2090D50EDC0CDBBB1", hash_generated_method = "1183BC7FE3BDC2AE5CE72B7E7F14E6BE")
    private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "FC69337B9A14ACA905A1351B5B3311C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState getServiceState() {
        ServiceState var68A6299B03F5C6DE8DBFFE00CF64CB52_1246017700 = (mActivePhone.getServiceState());
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getServiceState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "1B53F4A9DBAE1FBC9ADAB16B9512B4BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CellLocation getCellLocation() {
        CellLocation var5D6A546CD7CD9EB866718740B52A0AE6_2074562304 = (mActivePhone.getCellLocation());
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getCellLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "868A91E9034E96C9936A89CEF6069FFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        DataState var39A1908289DC27F9F6237CDECE88297E_523677472 = (mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "6DA488D96972587F21C1E1A49A9EB8F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState(String apnType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(apnType);
        DataState var5472BFD0FF7C69B2C073F54858F7E78F_885592812 = (mActivePhone.getDataConnectionState(apnType));
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataConnectionState(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "DA4B86D594B2614153F187E163914CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataActivityState getDataActivityState() {
        DataActivityState var448332583A6ABD5E1DABE76DB28830B8_1130763759 = (mActivePhone.getDataActivityState());
        return (DataActivityState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getDataActivityState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "C561DC0F8BD1954688055F443D23B31C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getContext() {
        Context var8868A5FB63500B5DED9638973CDD9011_912999895 = (mActivePhone.getContext());
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "557CE40E3A89E8A419269E5ED2F1A21F")
    @DSModeled(DSC.SAFE)
    public void disableDnsCheck(boolean b) {
        dsTaint.addTaint(b);
        mActivePhone.disableDnsCheck(b);
        // ---------- Original Method ----------
        //mActivePhone.disableDnsCheck(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "D312155281A030B3CED1855B4C4A8CEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDnsCheckDisabled() {
        boolean var63BCDE066CAA6ED52BCDEA8E29F6B1DB_1977449159 = (mActivePhone.isDnsCheckDisabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDnsCheckDisabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "0C5BA473CE7D39CCB51A4BB403B4E9A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getState() {
        State var995854D66F535E24949945EA663AE145_1445074495 = (mActivePhone.getState());
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "C07787D06B87532F54207817F9921155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPhoneName() {
        String var5F0FC993ED2DE4CF56E3AD22001B2604_1702933945 = (mActivePhone.getPhoneName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "EE5212E2AA7BCF0ADC20D347C28C302B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPhoneType() {
        int varB5C5EFC4899F813B21E51CD745860764_1919637648 = (mActivePhone.getPhoneType());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "91648118DE111B464241CBE8E7C711F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getActiveApnTypes() {
        String[] varFE4B2C63DC7552A45AABC2A6D1D6D99C_645418403 = (mActivePhone.getActiveApnTypes());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnTypes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "F49087B565A17277A7F53F3D792DC382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getActiveApnHost(String apnType) {
        dsTaint.addTaint(apnType);
        String var20554E84F4D293A98E0A4491756546C8_649530658 = (mActivePhone.getActiveApnHost(apnType));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getActiveApnHost(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "FAB0E1FC7CB6CB8E313042B2A09C9AC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        LinkProperties var9C6162DC120629310398FD5418471D58_264933535 = (mActivePhone.getLinkProperties(apnType));
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getLinkProperties(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "A11E3AD7C9EF3DBA7F7888ADCD1ABE9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        LinkCapabilities var35CA08C2FFC06879213E013B7419860A_1734663656 = (mActivePhone.getLinkCapabilities(apnType));
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getLinkCapabilities(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.390 -0400", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "A0256393A20CC8EE44B91EA4716C69E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength getSignalStrength() {
        SignalStrength var9F23190DAB6C2A562F1AD505A48809D9_583451344 = (mActivePhone.getSignalStrength());
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getSignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "F0423090A2F0704D633A777CF35DC295")
    @DSModeled(DSC.SAFE)
    public void registerForUnknownConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForUnknownConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "5BDEC2E98BCD6FD467BDAE032EC58892")
    @DSModeled(DSC.SAFE)
    public void unregisterForUnknownConnection(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForUnknownConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForUnknownConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "CE55909133D1255D2172A20CD9CD9150")
    @DSModeled(DSC.SAFE)
    public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "D24A793C81ECB526C45CBE3C25B15DF3")
    @DSModeled(DSC.SAFE)
    public void unregisterForPreciseCallStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForPreciseCallStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "2F22FF1C58FEBA8D9062D21355A4A7F2")
    @DSModeled(DSC.SAFE)
    public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForNewRingingConnection(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "623D89B9CF95E9F95117E780DEFE9579")
    @DSModeled(DSC.SAFE)
    public void unregisterForNewRingingConnection(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForNewRingingConnection(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNewRingingConnection(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "2A3F2D5AE37A2BEB850B16B97092CD98")
    @DSModeled(DSC.SAFE)
    public void registerForIncomingRing(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForIncomingRing(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForIncomingRing(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "95ED5C616DF757C7D5606C06A7BB7ACC")
    @DSModeled(DSC.SAFE)
    public void unregisterForIncomingRing(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForIncomingRing(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForIncomingRing(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "A5EC8A0C5FA8A8F92143987F94E9BDB6")
    @DSModeled(DSC.SAFE)
    public void registerForDisconnect(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForDisconnect(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisconnect(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "8D48673FF37AAB1CBF388667BC838C6C")
    @DSModeled(DSC.SAFE)
    public void unregisterForDisconnect(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForDisconnect(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisconnect(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "B8D5A210CFB8E85BEE67E8D9F0DFED2D")
    @DSModeled(DSC.SAFE)
    public void registerForMmiInitiate(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForMmiInitiate(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "D7DED406AE5B63AA052DCA251FC877BB")
    @DSModeled(DSC.SAFE)
    public void unregisterForMmiInitiate(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForMmiInitiate(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiInitiate(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "93AD974379A01588FC6FC9DC788FB7AC")
    @DSModeled(DSC.SAFE)
    public void registerForMmiComplete(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForMmiComplete(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForMmiComplete(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "31F44A12036E555CDC60BE6ABC565413")
    @DSModeled(DSC.SAFE)
    public void unregisterForMmiComplete(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForMmiComplete(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForMmiComplete(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "BCACBC238A14794753453D975E7BD276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varFBFB9846DEED69D90C7852623E9CA9DC_1545680633 = (mActivePhone.getPendingMmiCodes());
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getPendingMmiCodes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "63860EBA32409BC0150A2291929FCDEF")
    @DSModeled(DSC.SAFE)
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        mActivePhone.sendUssdResponse(ussdMessge);
        // ---------- Original Method ----------
        //mActivePhone.sendUssdResponse(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "C73DDD5B998E71C0E7BCF58B293DA814")
    @DSModeled(DSC.SAFE)
    public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForServiceStateChanged(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "07AB87FA6AA513A54AE9D29245DFFC40")
    @DSModeled(DSC.SAFE)
    public void unregisterForServiceStateChanged(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForServiceStateChanged(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForServiceStateChanged(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.391 -0400", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "D760225FB78CC2FCE60AAEC4FD6153EC")
    @DSModeled(DSC.SAFE)
    public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "130CBE4B917AB6C32F044D77E7C15822")
    @DSModeled(DSC.SAFE)
    public void unregisterForSuppServiceNotification(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSuppServiceNotification(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceNotification(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "E27F27FE94FA6F135697F7C25AF0E170")
    @DSModeled(DSC.SAFE)
    public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "4196E4CC5F6F83AB21C70516F258C9E1")
    @DSModeled(DSC.SAFE)
    public void unregisterForSuppServiceFailed(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSuppServiceFailed(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSuppServiceFailed(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "2FBB83E4D269CC9C3E7E90A4279FA6E6")
    @DSModeled(DSC.SAFE)
    public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "A6DD2DA04A2E235C5EC5DE0DB1A29348")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOn(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "E7BB3D04796061B3BEFE3227634EFA2C")
    @DSModeled(DSC.SAFE)
    public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "93143D06408C0D2CB62FFE912136CD9B")
    @DSModeled(DSC.SAFE)
    public void unregisterForInCallVoicePrivacyOff(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "09E2D733DBB3BDF09C8D8B2ACBA70140")
    @DSModeled(DSC.SAFE)
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "73755FFC856148FE9ACA62C2A7563CCB")
    @DSModeled(DSC.SAFE)
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForCdmaOtaStatusChange(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "955ED685F6FECCD91537A950ECCFCAAE")
    @DSModeled(DSC.SAFE)
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "03FB3801B53275A07FB04F52EF913304")
    @DSModeled(DSC.SAFE)
    public void unregisterForSubscriptionInfoReady(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "F2DF07BA4DB0C19FE8C7D2899677597B")
    @DSModeled(DSC.SAFE)
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForEcmTimerReset(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "F3863176AC053B5C834640397DD21A5F")
    @DSModeled(DSC.SAFE)
    public void unregisterForEcmTimerReset(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForEcmTimerReset(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForEcmTimerReset(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "FC0B29C791784AAA38B126D00E42A748")
    @DSModeled(DSC.SAFE)
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForRingbackTone(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRingbackTone(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "DE4270641E1A95BE729CD0836B0A1838")
    @DSModeled(DSC.SAFE)
    public void unregisterForRingbackTone(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForRingbackTone(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRingbackTone(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "8F22757A9E595F483DBB46E3CF5E7CD8")
    @DSModeled(DSC.SAFE)
    public void registerForResendIncallMute(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForResendIncallMute(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "166C28C2610BF606E8906E61C26E5A7E")
    @DSModeled(DSC.SAFE)
    public void unregisterForResendIncallMute(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForResendIncallMute(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForResendIncallMute(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "253563E44007000A607EE9B284064C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getIccRecordsLoaded() {
        boolean varD34CD95BD9903759FA66B479DE10B32C_847155579 = (mActivePhone.getIccRecordsLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getIccRecordsLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.392 -0400", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "86776B37BF79BC9F6F93EB3A3DA9CB28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccCard getIccCard() {
        IccCard varFDFBF4D817EF0C0729E3392EF51C246F_1577723080 = (mActivePhone.getIccCard());
        return (IccCard)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccCard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "0CA4B63C9012862D0DD6157520AAE92B")
    @DSModeled(DSC.SAFE)
    public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
        // ---------- Original Method ----------
        //mActivePhone.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "1DA5D09F77273916ED4FCF41FBE6BF85")
    @DSModeled(DSC.SAFE)
    public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
        // ---------- Original Method ----------
        //mActivePhone.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "012DA741CEE4D4517E4AB92D5A4AB519")
    @DSModeled(DSC.SAFE)
    public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
        // ---------- Original Method ----------
        //mActivePhone.switchHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "F112B884ABA00C186E2C20ADCF0AD982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canConference() {
        boolean varBEBBDC11FE20620D331255B29CB7C083_627507243 = (mActivePhone.canConference());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "3706FF08CA9948644E0DA7637507E980")
    @DSModeled(DSC.SAFE)
    public void conference() throws CallStateException {
        mActivePhone.conference();
        // ---------- Original Method ----------
        //mActivePhone.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "FD5F5D15378E7F4CA3D76076A8210C4B")
    @DSModeled(DSC.SAFE)
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "9A256B2B64C1145C16FE5BC646A5E865")
    @DSModeled(DSC.SAFE)
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "4EB0BA6AD6FF26CA6D65036EBFAFC152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTransfer() {
        boolean varA271678BA825E5B535929271849B2922_288604258 = (mActivePhone.canTransfer());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "42D4456564B51252A1F16B4D585AB280")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
        // ---------- Original Method ----------
        //mActivePhone.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "C8EB5FD7966C4C1975F024D238BD31C6")
    @DSModeled(DSC.SAFE)
    public void clearDisconnected() {
        mActivePhone.clearDisconnected();
        // ---------- Original Method ----------
        //mActivePhone.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "307C07C7617AF7269BAD0FB5FD26B0A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getForegroundCall() {
        Call var09EE12544CE529DE2F9AD98B26AA9446_1747040125 = (mActivePhone.getForegroundCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getForegroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "C9B00658AB197A1931A452BF02E743A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getBackgroundCall() {
        Call var4BCF868900FE3124FB5FA46464F4BB1F_1296611694 = (mActivePhone.getBackgroundCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getBackgroundCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "C7EB08407617E1000C699B1761440D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call getRingingCall() {
        Call var168AA4ECE8197CB04DD3E9F7402E7E5D_223921313 = (mActivePhone.getRingingCall());
        return (Call)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getRingingCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "7C42077F4B1B97551DEA4E8E6552F57A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        Connection var32A22D652381019DA25DF9814E3FD615_1715669888 = (mActivePhone.dial(dialString));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "3CFA5B10C16A2805AE68CD78DFB87344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        Connection var1A4300BF0DA93EA826AE1CF555EB94F1_1283233158 = (mActivePhone.dial(dialString, uusInfo));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.dial(dialString, uusInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "C2AE54895685BFB4563D110C7D0A8B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        boolean var9EAF3797F0895E045EDD8A2A6F3E9DC3_52404647 = (mActivePhone.handlePinMmi(dialString));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.handlePinMmi(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "5D56CB9C0FE5D2AC0C5C7082EE049EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleInCallMmiCommands(String command) throws CallStateException {
        dsTaint.addTaint(command);
        boolean varB6713A0B25EC29F71205412BEAB34760_983388726 = (mActivePhone.handleInCallMmiCommands(command));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.handleInCallMmiCommands(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "1BBD9B27589C4FED9D8DE81011B0689B")
    @DSModeled(DSC.SAFE)
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        mActivePhone.sendDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.sendDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "09394224CC05B86DC6EA99D9DA56E2F7")
    @DSModeled(DSC.SAFE)
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        mActivePhone.startDtmf(c);
        // ---------- Original Method ----------
        //mActivePhone.startDtmf(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "1EEEE173A0F6932BB667D7C0445B0D54")
    @DSModeled(DSC.SAFE)
    public void stopDtmf() {
        mActivePhone.stopDtmf();
        // ---------- Original Method ----------
        //mActivePhone.stopDtmf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "4022DC3CD2577DD5C0C74BDE1DDB4355")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        mActivePhone.setRadioPower(power);
        // ---------- Original Method ----------
        //mActivePhone.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "54F81C2DAA0B9631ED830FBBAFCD4527")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMessageWaitingIndicator() {
        boolean varE36CE85276F33DCC5B02481874938DBC_1730931033 = (mActivePhone.getMessageWaitingIndicator());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getMessageWaitingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.393 -0400", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "539383070B3DE1BF1239831321CEBF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getCallForwardingIndicator() {
        boolean var711465E26D829245ADB92E0313FED47F_192244072 = (mActivePhone.getCallForwardingIndicator());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getCallForwardingIndicator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "76E2AA200C59848947133274E26606D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var6A5444B45643DE896C5B531D2376DCA8_1204789715 = (mActivePhone.getLine1Number());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "96CD787E24FDF6A74151F561AE14E29B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaMin() {
        String var088DD5310349107F29D3792A6000BB8C_1982374149 = (mActivePhone.getCdmaMin());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "89BB45A5F8D7264FC7855CC0BC9E77D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMinInfoReady() {
        boolean varBADBA5710877FFB10FBC68610BD4AFC0_1012201982 = (mActivePhone.isMinInfoReady());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "81878EFD23259054A49C8CFE42DBCA7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaPrlVersion() {
        String varD5AE4A4CBD2F880C9A908311D0D36F3E_764604614 = (mActivePhone.getCdmaPrlVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "BCD44143AE474EB5079F38896C9D358C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        String varA1897AD9ABF542ACBB7A2B7FF5E1C5F4_1802452624 = (mActivePhone.getLine1AlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "B30F4CEB52740033E63F9E273FD34D77")
    @DSModeled(DSC.SAFE)
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "2482867872D41B7E128B3B80163343FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String varDD102027E9A8ED892A47E16CFF1014F5_727082171 = (mActivePhone.getVoiceMailNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "E16173CBC553E3AF1BDCF8234B281C1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVoiceMessageCount() {
        int varC9B97605CE24C2BC7E55AC0885C61958_816016111 = (mActivePhone.getVoiceMessageCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMessageCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "2F817F6AE4816BD7D51F4B830C086BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String var9C6F41174851009625FA52C459B0B495_613273929 = (mActivePhone.getVoiceMailAlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "A624A5B546EB9384051DEB3F37984FAE")
    @DSModeled(DSC.SAFE)
    public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(voiceMailNumber);
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "AC6BD5CCF919729713AB3E2BCA92920C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "14B5522CB11DCCD2187FD7B50BE18587")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "D8218A7555EF2FB0332D0E057726D7C6")
    @DSModeled(DSC.SAFE)
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "BF17C06B713117D98369E3A521F04D7A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "A84BF8839797CA708E35717D690C5C03")
    @DSModeled(DSC.SAFE)
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.getCallWaiting(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.getCallWaiting(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "1A08BD237C4F594B9C4F93D39C00108E")
    @DSModeled(DSC.SAFE)
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        mActivePhone.setCallWaiting(enable, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setCallWaiting(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "A8A22C65469DCA3BE34C6C7E36A8FECD")
    @DSModeled(DSC.SAFE)
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mActivePhone.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "71EF6B5389EE88D32FDDE9BE8BBE28D8")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeAutomatic(Message response) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.setNetworkSelectionModeAutomatic(response);
        // ---------- Original Method ----------
        //mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "6685D2677C22E12406423CD38A18BEF8")
    @DSModeled(DSC.SAFE)
    public void selectNetworkManually(OperatorInfo network, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        mActivePhone.selectNetworkManually(network, response);
        // ---------- Original Method ----------
        //mActivePhone.selectNetworkManually(network, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.394 -0400", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "E473C17B2BD0B22040C784EB69FBA6EC")
    @DSModeled(DSC.SAFE)
    public void setPreferredNetworkType(int networkType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(networkType);
        mActivePhone.setPreferredNetworkType(networkType, response);
        // ---------- Original Method ----------
        //mActivePhone.setPreferredNetworkType(networkType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "27CF8D89A0FC64DBF78E50BB4E2D68E2")
    @DSModeled(DSC.SAFE)
    public void getPreferredNetworkType(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getPreferredNetworkType(response);
        // ---------- Original Method ----------
        //mActivePhone.getPreferredNetworkType(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "BFB46057A1DBF3BA3767314E31D52E98")
    @DSModeled(DSC.SAFE)
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getNeighboringCids(response);
        // ---------- Original Method ----------
        //mActivePhone.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "4F59E07CEC77137680AA9F82C8F34A13")
    @DSModeled(DSC.SAFE)
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.setOnPostDialCharacter(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "E6B4B1E7C655061D6012439356D83C00")
    @DSModeled(DSC.SAFE)
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        mActivePhone.setMute(muted);
        // ---------- Original Method ----------
        //mActivePhone.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "18FB002CAB42C5504A7065CFB86BAA01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var1B9136C6599825A7694821391361E39E_1713172121 = (mActivePhone.getMute());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "A0CF2214120E8733789BDEADDF82AE37")
    @DSModeled(DSC.SAFE)
    public void setEchoSuppressionEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        mActivePhone.setEchoSuppressionEnabled(enabled);
        // ---------- Original Method ----------
        //mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "620308BD3C2F02DD6BCB776C95ADC467")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(data);
        mActivePhone.invokeOemRilRequestRaw(data, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "1C23E815C25729E9966302D21537F103")
    @DSModeled(DSC.SAFE)
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(strings);
        mActivePhone.invokeOemRilRequestStrings(strings, response);
        // ---------- Original Method ----------
        //mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "052EDC27ADAB3C2D384543CF29167385")
    @DSModeled(DSC.SAFE)
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getDataCallList(response);
        // ---------- Original Method ----------
        //mActivePhone.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "1DEC653030276C67968472C2944DE1FE")
    @DSModeled(DSC.SAFE)
    public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
        // ---------- Original Method ----------
        //mActivePhone.updateServiceLocation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "CF8CB04E8F772281420483C469B73EDF")
    @DSModeled(DSC.SAFE)
    public void enableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActivePhone.enableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "C1296A5C16A035C4E421E6C0D81EE10A")
    @DSModeled(DSC.SAFE)
    public void disableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActivePhone.disableLocationUpdates();
        // ---------- Original Method ----------
        //mActivePhone.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "65834F2308A28F581FB21D641B4F31CB")
    @DSModeled(DSC.SAFE)
    public void setUnitTestMode(boolean f) {
        dsTaint.addTaint(f);
        mActivePhone.setUnitTestMode(f);
        // ---------- Original Method ----------
        //mActivePhone.setUnitTestMode(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "BCBAAF6D03866FE69161E16213C3A6EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getUnitTestMode() {
        boolean varE57924CD4DCE3E1FC1150866D669EFEB_120375046 = (mActivePhone.getUnitTestMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getUnitTestMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "BFE1D2D2EE0BD4BE9BF5E6AF24907705")
    @DSModeled(DSC.SAFE)
    public void setBandMode(int bandMode, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(bandMode);
        mActivePhone.setBandMode(bandMode, response);
        // ---------- Original Method ----------
        //mActivePhone.setBandMode(bandMode, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "6B03F9513EE65C15B3A2257B38191EF6")
    @DSModeled(DSC.SAFE)
    public void queryAvailableBandMode(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.queryAvailableBandMode(response);
        // ---------- Original Method ----------
        //mActivePhone.queryAvailableBandMode(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "9D1200CC6F2FB7E4768F9F82CCF6FE24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataRoamingEnabled() {
        boolean var25967ADD269A46D57FF30D567DD05A9D_512931772 = (mActivePhone.getDataRoamingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.getDataRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "BF8EDE34985C9E86287D9A7C839CBE20")
    @DSModeled(DSC.SAFE)
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mActivePhone.setDataRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mActivePhone.setDataRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "774B3007A058C8FD608943EBC4CE84FD")
    @DSModeled(DSC.SAFE)
    public void queryCdmaRoamingPreference(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.queryCdmaRoamingPreference(response);
        // ---------- Original Method ----------
        //mActivePhone.queryCdmaRoamingPreference(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "A62ADB8241BBA12FA03A7F7B0E0FAA02")
    @DSModeled(DSC.SAFE)
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaRoamingType);
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "8945CD68B85612EAF1275871A614806A")
    @DSModeled(DSC.SAFE)
    public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(cdmaSubscriptionType);
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
        // ---------- Original Method ----------
        //mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.395 -0400", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "59C70FCE2FA70D90CFDC6BC8A536FEF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimulatedRadioControl getSimulatedRadioControl() {
        SimulatedRadioControl varC2FE4D10D10BDB42F1AA6F0F831C38BC_1999030676 = (mActivePhone.getSimulatedRadioControl());
        return (SimulatedRadioControl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getSimulatedRadioControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "417F9D27F99B5B963B34C0C5CDD151AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enableApnType(String type) {
        dsTaint.addTaint(type);
        int varA930C257BD4665C868EA6EF284E5FAB4_633617205 = (mActivePhone.enableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.enableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "4E6C48BA3A749128FD0B0887E3908E60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int disableApnType(String type) {
        dsTaint.addTaint(type);
        int var0EE96BBA6B6E6339EB47881723DB0B34_1672649396 = (mActivePhone.disableApnType(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.disableApnType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "E3FF3096E9B2FF12F0277DC29EE31D0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible() {
        boolean varFD50EE22A236A635A1A5E6ECDDC3AD83_680177425 = (mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "101553CB4D794D6E380D5B926D602308")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDataConnectivityPossible(String apnType) {
        dsTaint.addTaint(apnType);
        boolean var7B46E2C66CD7327260F34CAEEF4F7C05_987951635 = (mActivePhone.isDataConnectivityPossible(apnType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isDataConnectivityPossible(apnType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "3FF48643EE54BA885DE30C19D9B8973B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        String varA06FB37169DF3EA57D58C62B54B1C20A_1130904235 = (mActivePhone.getDeviceId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "5617CCC125619F57E28EC67B0D60A91B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSvn() {
        String var9F05C900CEC245C57C549C403F57E7D7_1272540244 = (mActivePhone.getDeviceSvn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "1E9255FB4F8B1A9D0A9F407FB0B3130E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String var8A51A4D484693B644E2C2A9914385B7E_1478603479 = (mActivePhone.getSubscriberId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "4C737C3978B3A10D6D50AC9681943B1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIccSerialNumber() {
        String varCE2ABD4DD3C528AF73986DDC49FB2362_340666260 = (mActivePhone.getIccSerialNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "FDABD400DB1F9BF00A5687123452FE3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEsn() {
        String varE2127E237DBEEA4B4F086C92813ECEF2_956928478 = (mActivePhone.getEsn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getEsn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "C3EC5ED6A004B7F3F148981676314975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMeid() {
        String var1DA94A645E16112BE2D864F6F16440E9_1078732218 = (mActivePhone.getMeid());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getMeid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "9045A2A0CFD559A55256A31B41B9DFF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        String varA4F464752386C26D6465AB8C838A3CE2_1986885494 = (mActivePhone.getMsisdn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "2F5E4296A06C87DFB2A5D0D84BC4FE24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getImei() {
        String var67B5768DDFFDEC0EB30CD43936C3A955_848522683 = (mActivePhone.getImei());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getImei();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "8B7009513C25F57BC50188E03B7F8433")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo var7AC4CA237015E4BE3BB6336167CF81C5_1504930913 = (mActivePhone.getPhoneSubInfo());
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getPhoneSubInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "18CF8D358BC7F15C8BAF3F47079B6903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varD2BEA2D316C97FE0A2552247A3397A0D_732759704 = (mActivePhone.getIccSmsInterfaceManager());
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccSmsInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "1A4B78A4D0F44CB65634144450AC0AC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager var6F9416B1006A25743BCB3C7AB738FBF6_798894506 = (mActivePhone.getIccPhoneBookInterfaceManager());
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "5324394E762954E503446C11B0AAE32B")
    @DSModeled(DSC.SAFE)
    public void setTTYMode(int ttyMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(ttyMode);
        mActivePhone.setTTYMode(ttyMode, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "52CFA9C848073976698DD077FAFEEB3E")
    @DSModeled(DSC.SAFE)
    public void queryTTYMode(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mActivePhone.queryTTYMode(onComplete);
        // ---------- Original Method ----------
        //mActivePhone.queryTTYMode(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "110EE3B63DBFCE3A19040AB0E9A70999")
    @DSModeled(DSC.SAFE)
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(activate);
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.activateCellBroadcastSms(activate, response);
        // ---------- Original Method ----------
        //mActivePhone.activateCellBroadcastSms(activate, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "A3AC2C23FC18F5B31A92F79DF7323A94")
    @DSModeled(DSC.SAFE)
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mActivePhone.getCellBroadcastSmsConfig(response);
        // ---------- Original Method ----------
        //mActivePhone.getCellBroadcastSmsConfig(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "3E92B7265665ED37F3AF14DF82D124E7")
    @DSModeled(DSC.SAFE)
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray);
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
        // ---------- Original Method ----------
        //mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.396 -0400", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "E1601AD1930008E5E8944EA7B568671C")
    @DSModeled(DSC.SAFE)
    public void notifyDataActivity() {
        mActivePhone.notifyDataActivity();
        // ---------- Original Method ----------
        //mActivePhone.notifyDataActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "47F965D95EE779E7A0732F2EB794008F")
    @DSModeled(DSC.SAFE)
    public void getSmscAddress(Message result) {
        dsTaint.addTaint(result.dsTaint);
        mActivePhone.getSmscAddress(result);
        // ---------- Original Method ----------
        //mActivePhone.getSmscAddress(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "0CD169824DD2AC3DA91FC31A42DA02C4")
    @DSModeled(DSC.SAFE)
    public void setSmscAddress(String address, Message result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(address);
        mActivePhone.setSmscAddress(address, result);
        // ---------- Original Method ----------
        //mActivePhone.setSmscAddress(address, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "22CC93B31A04037E3537838F01CD9607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int varE8C65943584090697CBEEDCCAFC2799B_1130051778 = (mActivePhone.getCdmaEriIconIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "E0A2C0ED33A2461CC75007C5C8E54EF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaEriText() {
        String varA44D2B9F8DC51266BAA79BEC6AC3AB01_241890853 = (mActivePhone.getCdmaEriText());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "E89C12230413F921FE755CF9055CEDAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var44559B7F040E42DDDD7BF51EF4F1B3DA_1021133575 = (mActivePhone.getCdmaEriIconMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "FEE3E491B082A3EB51699DB795123869")
    @DSModeled(DSC.SAFE)
    public Phone getActivePhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "57B45D838A35D465F6C5752757A02F4D")
    @DSModeled(DSC.SAFE)
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
        // ---------- Original Method ----------
        //mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "97630A4BE773320BCA914286AA0B4880")
    @DSModeled(DSC.SAFE)
    public void exitEmergencyCallbackMode() {
        mActivePhone.exitEmergencyCallbackMode();
        // ---------- Original Method ----------
        //mActivePhone.exitEmergencyCallbackMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "07D0A4B0460AED8644AF19DA17B77E63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needsOtaServiceProvisioning() {
        boolean var970502384D9890BA0973B383AB80C6FC_36645076 = (mActivePhone.needsOtaServiceProvisioning());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.needsOtaServiceProvisioning();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "D5B0DEF460C5D403E8C9244C25390D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOtaSpNumber(String dialStr) {
        dsTaint.addTaint(dialStr);
        boolean varB4E5E50A833DA40DB1EDA30167AA00E1_1631909377 = (mActivePhone.isOtaSpNumber(dialStr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isOtaSpNumber(dialStr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "EE673E836E3E8C712A9899816FB554DD")
    @DSModeled(DSC.SAFE)
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForCallWaiting(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForCallWaiting(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "D95392CF393D1748FC1BAD0997807FF5")
    @DSModeled(DSC.SAFE)
    public void unregisterForCallWaiting(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "1BC58C4ED67CF38F7653935B7F023C56")
    @DSModeled(DSC.SAFE)
    public void registerForSignalInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForSignalInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForSignalInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "CF291B906452EB9145B2B66C1C3E7CDF")
    @DSModeled(DSC.SAFE)
    public void unregisterForSignalInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForSignalInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForSignalInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "EFED169A2B17F898DD1DE26219AC1298")
    @DSModeled(DSC.SAFE)
    public void registerForDisplayInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForDisplayInfo(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "A5B7A0C6CFE88C5D950746EAFCE668F2")
    @DSModeled(DSC.SAFE)
    public void unregisterForDisplayInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForDisplayInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForDisplayInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "C55875EAD1F05B8A25AFE9EA1FA09106")
    @DSModeled(DSC.SAFE)
    public void registerForNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "299C02B5C4570DE645BA16F32936F9BB")
    @DSModeled(DSC.SAFE)
    public void unregisterForNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "7A7DB61F3550157C77F11E51B63ADFC8")
    @DSModeled(DSC.SAFE)
    public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "80AAB5E0A5053C2C0E2E3D90648EB611")
    @DSModeled(DSC.SAFE)
    public void unregisterForRedirectedNumberInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForRedirectedNumberInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.397 -0400", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "60516E5384DF778F0B9DB7452E5F7569")
    @DSModeled(DSC.SAFE)
    public void registerForLineControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForLineControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "80F118D0E56384AEA85821B70D3F7D00")
    @DSModeled(DSC.SAFE)
    public void unregisterForLineControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForLineControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForLineControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "724269D75004D05A381FA23E334A783F")
    @DSModeled(DSC.SAFE)
    public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "6B82E5227A47A89C2059DC5FFE30350E")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53ClirInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForT53ClirInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53ClirInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "AD643DFB943FD861C894B5EC32A40610")
    @DSModeled(DSC.SAFE)
    public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
        // ---------- Original Method ----------
        //mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "16E64C2009103846A43A22185AF72A6B")
    @DSModeled(DSC.SAFE)
    public void unregisterForT53AudioControlInfo(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unregisterForT53AudioControlInfo(h);
        // ---------- Original Method ----------
        //mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "7E944B0A94F3222EDDEBB265F73E8ADC")
    @DSModeled(DSC.SAFE)
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
        // ---------- Original Method ----------
        //mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "234A64394543BC4A5C3BC3A1BF5DBAA1")
    @DSModeled(DSC.SAFE)
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mActivePhone.unsetOnEcbModeExitResponse(h);
        // ---------- Original Method ----------
        //mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "668AE5A266CC7227A5B28AA0E5551579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCspPlmnEnabled() {
        boolean var202889D1FB2BEDDDD330D07A42C96AAA_1213121596 = (mActivePhone.isCspPlmnEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivePhone.isCspPlmnEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "AFAC3B3531EBD6341C492D35BC091756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IsimRecords getIsimRecords() {
        IsimRecords var3797B3AFE135B247AC4E4C046D28FD89_1741225598 = (mActivePhone.getIsimRecords());
        return (IsimRecords)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getIsimRecords();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "723D9B5F69DE1DD2F9460F8AC6A3B0B0")
    @DSModeled(DSC.SAFE)
    public void requestIsimAuthentication(String nonce, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(nonce);
        mActivePhone.requestIsimAuthentication(nonce, response);
        // ---------- Original Method ----------
        //mActivePhone.requestIsimAuthentication(nonce, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "B53B992B53F6469447F9A830F596CC06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getLteOnCdmaMode() {
        int varC068356BB4D68BB6F09FF66311887211_226022265 = (mActivePhone.getLteOnCdmaMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mActivePhone.getLteOnCdmaMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "B0B95DFE3D31C2D906F8D4CFE1A65A34")
    @DSModeled(DSC.SAFE)
    @Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        dsTaint.addTaint(line);
        dsTaint.addTaint(countWaiting);
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
        // ---------- Original Method ----------
        //mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.398 -0400", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "8F136007A9BC9AF812C9DDF231633AD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public UsimServiceTable getUsimServiceTable() {
        UsimServiceTable var2709A3F874BD957959B962BB1AB64CD4_1593204829 = (mActivePhone.getUsimServiceTable());
        return (UsimServiceTable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivePhone.getUsimServiceTable();
    }

    
}


