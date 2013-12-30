package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.225 -0500", hash_original_method = "0B1698B355A404B2090D50EDC0CDBBB1", hash_generated_method = "1183BC7FE3BDC2AE5CE72B7E7F14E6BE")
    
private static void logd(String msg) {
        Log.d(LOG_TAG, "[PhoneProxy] " + msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.196 -0500", hash_original_field = "F9138C945C7BCD32D0FD36AF92DF1A88", hash_generated_field = "02BC139DB0105CA7515EEC1DAAE977A9")

    public final static Object lockForRadioTechnologyChange = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.214 -0500", hash_original_field = "FA286A806880F557FA2F91E6051D58CE", hash_generated_field = "54EE92F4B0FE4A4C30125103756EC93C")


    private static final int EVENT_RADIO_TECHNOLOGY_CHANGED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.217 -0500", hash_original_field = "F4446E751DD7D5E85FE650192A5E7AE4", hash_generated_field = "4A57918A348D50A14B9C302A7B5E80AE")

    private static final String LOG_TAG = "PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.198 -0500", hash_original_field = "1068890E9C6D127AE7A4CC53E45E2D63", hash_generated_field = "79E1E1372DEBD73F7DC06CB339BF8515")


    private Phone mActivePhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.200 -0500", hash_original_field = "1C1BE0F8AB5B5BD36DC96C6ADA057D44", hash_generated_field = "DDAC63588CE98849D5263880B7CCAB1C")

    private String mOutgoingPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.202 -0500", hash_original_field = "8C0D26C4A7F3EECA8BC4EE3F65C71182", hash_generated_field = "87B1B27FFCD694EC9D1655CC1B9CA724")

    private CommandsInterface mCommandsInterface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.204 -0500", hash_original_field = "DDCE6594759AEA72A565A39EFFAEAF76", hash_generated_field = "39B8DCDEBABBB509EC1ED767090CA555")

    private IccSmsInterfaceManagerProxy mIccSmsInterfaceManagerProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.207 -0500", hash_original_field = "87BBDE3B392581313CAB09AF3635DB5A", hash_generated_field = "40950CC9ACAAB7312B06F5F9AF4EE209")

    private IccPhoneBookInterfaceManagerProxy mIccPhoneBookInterfaceManagerProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.209 -0500", hash_original_field = "04AEE4D1481AB3080542D843A133A044", hash_generated_field = "DBAC441931D27FB499444461968E857D")

    private PhoneSubInfoProxy mPhoneSubInfoProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.212 -0500", hash_original_field = "1BBE1ED87F57F7F30CFB2D9ADB5287CC", hash_generated_field = "BA1007FE924A9E554E78582269299C5A")


    private boolean mResetModemOnRadioTechnologyChange = false;

    //***** Class Methods
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.220 -0500", hash_original_method = "486A050D86A6A9FD6E0482A7E8659AE1", hash_generated_method = "4F4F0BE9E3FDCCD901A3672CCB7AE6B9")
    
public PhoneProxy(Phone phone) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.223 -0500", hash_original_method = "E195EC1A1EABBEB6AA309412029DC755", hash_generated_method = "CD08DD6C0E587B0395672024A23CBE67")
    
@Override
    public void handleMessage(Message msg) {
        switch(msg.what) {
        case EVENT_RADIO_TECHNOLOGY_CHANGED:
            //switch Phone from CDMA to GSM or vice versa
            mOutgoingPhone = mActivePhone.getPhoneName();
            logd("Switching phone from " + mOutgoingPhone + "Phone to " +
                    (mOutgoingPhone.equals("GSM") ? "CDMAPhone" : "GSMPhone") );
            boolean oldPowerState = false; // old power state to off
            if (mResetModemOnRadioTechnologyChange) {
                if (mCommandsInterface.getRadioState().isOn()) {
                    oldPowerState = true;
                    logd("Setting Radio Power to Off");
                    mCommandsInterface.setRadioPower(false, null);
                }
            }

            if(mOutgoingPhone.equals("GSM")) {
                logd("Make a new CDMAPhone and destroy the old GSMPhone.");

                ((GSMPhone)mActivePhone).dispose();
                Phone oldPhone = mActivePhone;

                //Give the garbage collector a hint to start the garbage collection asap
                // NOTE this has been disabled since radio technology change could happen during
                //   e.g. a multimedia playing and could slow the system. Tests needs to be done
                //   to see the effects of the GC call here when system is busy.
                //System.gc();

                mActivePhone = PhoneFactory.getCdmaPhone();
                ((GSMPhone)oldPhone).removeReferences();
                oldPhone = null;
            } else {
                logd("Make a new GSMPhone and destroy the old CDMAPhone.");

                ((CDMAPhone)mActivePhone).dispose();
                //mActivePhone = null;
                Phone oldPhone = mActivePhone;

                // Give the GC a hint to start the garbage collection asap
                // NOTE this has been disabled since radio technology change could happen during
                //   e.g. a multimedia playing and could slow the system. Tests needs to be done
                //   to see the effects of the GC call here when system is busy.
                //System.gc();

                mActivePhone = PhoneFactory.getGsmPhone();
                ((CDMAPhone)oldPhone).removeReferences();
                oldPhone = null;
            }

            if (mResetModemOnRadioTechnologyChange) {
                logd("Resetting Radio");
                mCommandsInterface.setRadioPower(oldPowerState, null);
            }

            //Set the new interfaces in the proxy's
            mIccSmsInterfaceManagerProxy.setmIccSmsInterfaceManager(
                    mActivePhone.getIccSmsInterfaceManager());
            mIccPhoneBookInterfaceManagerProxy.setmIccPhoneBookInterfaceManager(
                    mActivePhone.getIccPhoneBookInterfaceManager());
            mPhoneSubInfoProxy.setmPhoneSubInfo(this.mActivePhone.getPhoneSubInfo());
            mCommandsInterface = ((PhoneBase)mActivePhone).mCM;

            //Send an Intent to the PhoneApp that we had a radio technology change
            Intent intent = new Intent(TelephonyIntents.ACTION_RADIO_TECHNOLOGY_CHANGED);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            intent.putExtra(Phone.PHONE_NAME_KEY, mActivePhone.getPhoneName());
            ActivityManagerNative.broadcastStickyIntent(intent, null);
            break;
        default:
            Log.e(LOG_TAG,"Error! This handler was not registered for this message type. Message: "
                    + msg.what);
        break;
        }
        super.handleMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.227 -0500", hash_original_method = "F6146C48221B6AC50FCC99C2E0732890", hash_generated_method = "E1C32A65E2DC519576243B4684B05FE3")
    
public ServiceState getServiceState() {
        return mActivePhone.getServiceState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.230 -0500", hash_original_method = "977991957EA985C198AAE07D77598BC6", hash_generated_method = "0020C7A4B47D7882DD5EAE6AC3BD58A2")
    
public CellLocation getCellLocation() {
        return mActivePhone.getCellLocation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.232 -0500", hash_original_method = "7C4D56DFB9AD515A69A05C172287E403", hash_generated_method = "8F4DE0DEE140F752837CA97BD7154A8B")
    
public DataState getDataConnectionState() {
        return mActivePhone.getDataConnectionState(Phone.APN_TYPE_DEFAULT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.235 -0500", hash_original_method = "D7E946B9D40F208EF0C3DF24B899C37E", hash_generated_method = "38DBDB6929926F0B867DF30172E9C81F")
    
public DataState getDataConnectionState(String apnType) {
        return mActivePhone.getDataConnectionState(apnType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.237 -0500", hash_original_method = "8EE3EB20EF5E0BEB971664CA6D2C14B1", hash_generated_method = "E08B259B8A2D620ABD2D157E4CBC2018")
    
public DataActivityState getDataActivityState() {
        return mActivePhone.getDataActivityState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.239 -0500", hash_original_method = "22F8712EB30D49FEA52D38AA2D015573", hash_generated_method = "4F2478EC10483092D3CA291588D45F63")
    
public Context getContext() {
        return mActivePhone.getContext();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.241 -0500", hash_original_method = "ECA3A2B59149A3DFBA58D2DCF3634593", hash_generated_method = "18A4C8CAE1D29B76FE3CAD2E72AED87C")
    
public void disableDnsCheck(boolean b) {
        mActivePhone.disableDnsCheck(b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.244 -0500", hash_original_method = "EBEEAB7D67FF870611649D584AA0DD3F", hash_generated_method = "B782C807ACB39E12D12CA280B43B241A")
    
public boolean isDnsCheckDisabled() {
        return mActivePhone.isDnsCheckDisabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.246 -0500", hash_original_method = "0A20FEAF8264BAD64EFDE98F01E863F9", hash_generated_method = "6CED0F6B8E0B5DF32FDC6791219337CB")
    
public State getState() {
        return mActivePhone.getState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.248 -0500", hash_original_method = "BA6A5305156A7886803B81E975A9F08E", hash_generated_method = "11A2854F87A9D78DEB632FFD82A97F9A")
    
public String getPhoneName() {
        return mActivePhone.getPhoneName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.251 -0500", hash_original_method = "3E62B25A79E53E7703B3567F76AD6B2A", hash_generated_method = "4782FD0BC1C494509A543CECD5DA7B1F")
    
public int getPhoneType() {
        return mActivePhone.getPhoneType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.253 -0500", hash_original_method = "300FDD9092F34E8971EBD6AE242E7025", hash_generated_method = "633B286617C9BDF62433F05F9CA45CCB")
    
public String[] getActiveApnTypes() {
        return mActivePhone.getActiveApnTypes();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.256 -0500", hash_original_method = "DBB6D2A259790FC79B9F80AE021A760F", hash_generated_method = "1FEF8304A392837AB60A5492A8BA633A")
    
public String getActiveApnHost(String apnType) {
        return mActivePhone.getActiveApnHost(apnType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.258 -0500", hash_original_method = "7710C4C4432F211EFE7AD8A984CD2FB0", hash_generated_method = "20075A158CDDC9106BB2449A4DF8FA1E")
    
public LinkProperties getLinkProperties(String apnType) {
        return mActivePhone.getLinkProperties(apnType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.260 -0500", hash_original_method = "9EC4A02FBC847E33B8F7336E14FF2A4C", hash_generated_method = "70F8B93E8EFDA7A71DA6F2046064E86C")
    
public LinkCapabilities getLinkCapabilities(String apnType) {
        return mActivePhone.getLinkCapabilities(apnType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.263 -0500", hash_original_method = "10F86AA0A18CC6F6A539C498739147D9", hash_generated_method = "90A7ADAEBCAFD889B6EF5AFF627693FC")
    
public SignalStrength getSignalStrength() {
        return mActivePhone.getSignalStrength();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.265 -0500", hash_original_method = "B019DDAEB9A74F24038762D0D1339B1C", hash_generated_method = "8305BCE21B5C8487836870490589B328")
    
public void registerForUnknownConnection(Handler h, int what, Object obj) {
        mActivePhone.registerForUnknownConnection(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.267 -0500", hash_original_method = "6E1A0BF55C45D0A5DEB5FA399DF42EBD", hash_generated_method = "B61A032D9CABF60D270ABA50518D1F75")
    
public void unregisterForUnknownConnection(Handler h) {
        mActivePhone.unregisterForUnknownConnection(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.269 -0500", hash_original_method = "6D3352A526035270D65D3D2A47D52853", hash_generated_method = "DA721EBDF79435F0DCE148852460F373")
    
public void registerForPreciseCallStateChanged(Handler h, int what, Object obj) {
        mActivePhone.registerForPreciseCallStateChanged(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.271 -0500", hash_original_method = "858C5800BBFD4CDC4AA5612326219251", hash_generated_method = "52AEC1BECB536B301429C81517C82711")
    
public void unregisterForPreciseCallStateChanged(Handler h) {
        mActivePhone.unregisterForPreciseCallStateChanged(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.273 -0500", hash_original_method = "2C1C8B4A632E4710725E0C29E7614A86", hash_generated_method = "C615FDD0622A8B277B395D95AFD87EC2")
    
public void registerForNewRingingConnection(Handler h, int what, Object obj) {
        mActivePhone.registerForNewRingingConnection(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.276 -0500", hash_original_method = "AA76A039D61FF4F98B7AD3C763D88C46", hash_generated_method = "C4879C5C2F9D971C016BCF7B7053F00A")
    
public void unregisterForNewRingingConnection(Handler h) {
        mActivePhone.unregisterForNewRingingConnection(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.278 -0500", hash_original_method = "5382BBEF54B2531E597E5DC240CA82C3", hash_generated_method = "7C0A89D951D98180ECA1F4B633D794AC")
    
public void registerForIncomingRing(Handler h, int what, Object obj) {
        mActivePhone.registerForIncomingRing(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.280 -0500", hash_original_method = "89B3FB8353576E45AE2853D7C7925A6C", hash_generated_method = "6A9630CA6D8462A7A1EFA3B1080FDD44")
    
public void unregisterForIncomingRing(Handler h) {
        mActivePhone.unregisterForIncomingRing(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.283 -0500", hash_original_method = "F17E27799AE092E3FA781F6890524880", hash_generated_method = "49FF77D72909DEC1F590FDE725F727CC")
    
public void registerForDisconnect(Handler h, int what, Object obj) {
        mActivePhone.registerForDisconnect(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.285 -0500", hash_original_method = "23805639F7B48C16AA55B68151BD7148", hash_generated_method = "9F59B5D5C88025D7B6BCC95B5E3932BE")
    
public void unregisterForDisconnect(Handler h) {
        mActivePhone.unregisterForDisconnect(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.287 -0500", hash_original_method = "51AC3BCFCF338CB35BE82F32A708F6C1", hash_generated_method = "1349B5122758E2FCBC99EE7406C7B3E3")
    
public void registerForMmiInitiate(Handler h, int what, Object obj) {
        mActivePhone.registerForMmiInitiate(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.289 -0500", hash_original_method = "FD33855D15D4049C6FFF263FA5822C3B", hash_generated_method = "9214EA7CAA33896832ED173A4B402D8D")
    
public void unregisterForMmiInitiate(Handler h) {
        mActivePhone.unregisterForMmiInitiate(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.291 -0500", hash_original_method = "3A199A3D1AD81E2E9E1ED53B30A1398C", hash_generated_method = "407CCF633E78F2B9B5BE65BCD2CAE663")
    
public void registerForMmiComplete(Handler h, int what, Object obj) {
        mActivePhone.registerForMmiComplete(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.294 -0500", hash_original_method = "1BCE4C027188FE6A6372E460BA5C2A0D", hash_generated_method = "B7C763B61AAC904B63A392ED6C55981C")
    
public void unregisterForMmiComplete(Handler h) {
        mActivePhone.unregisterForMmiComplete(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.296 -0500", hash_original_method = "965809E4C7AF7ECD99BD9FF4F65AE728", hash_generated_method = "5B33AD1C9D2917FB542875DEBCD0DFB5")
    
public List<? extends MmiCode> getPendingMmiCodes() {
        return mActivePhone.getPendingMmiCodes();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.299 -0500", hash_original_method = "B939C63BC31CD003D961725459DB1D42", hash_generated_method = "0A717926D68E1243C23A03372680ABDA")
    
public void sendUssdResponse(String ussdMessge) {
        mActivePhone.sendUssdResponse(ussdMessge);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.301 -0500", hash_original_method = "CDE1783A5D3B55BB6E102EB1AE836901", hash_generated_method = "30B18DA91AED282DE515AB6362FB2F97")
    
public void registerForServiceStateChanged(Handler h, int what, Object obj) {
        mActivePhone.registerForServiceStateChanged(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.303 -0500", hash_original_method = "CF1D890BB84E9F295397BDBC761A6B02", hash_generated_method = "BC250C3950005581554C3B0854549A9C")
    
public void unregisterForServiceStateChanged(Handler h) {
        mActivePhone.unregisterForServiceStateChanged(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.305 -0500", hash_original_method = "BFB77B5FF783EC80AF90C227BA732748", hash_generated_method = "C9C17665406C6588718DDE785FA5EC98")
    
public void registerForSuppServiceNotification(Handler h, int what, Object obj) {
        mActivePhone.registerForSuppServiceNotification(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.308 -0500", hash_original_method = "5A1ACD5D496D5A7749EC71B629BDC544", hash_generated_method = "B13597B3ADB68BA05A7E7EE26E56443A")
    
public void unregisterForSuppServiceNotification(Handler h) {
        mActivePhone.unregisterForSuppServiceNotification(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.310 -0500", hash_original_method = "291C78A7F0F8DC1C11FF93915605337F", hash_generated_method = "A01E8B72838C73AE7FF44BECBAFA25E2")
    
public void registerForSuppServiceFailed(Handler h, int what, Object obj) {
        mActivePhone.registerForSuppServiceFailed(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.312 -0500", hash_original_method = "97EFE4BB9FE91C9C9FB3BF236BA82681", hash_generated_method = "75FB5257C2EFA57CA13B416F32A43720")
    
public void unregisterForSuppServiceFailed(Handler h) {
        mActivePhone.unregisterForSuppServiceFailed(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.314 -0500", hash_original_method = "496A0D696EBB860F00C524D2C874530D", hash_generated_method = "C8CFF6C73707FBE728677241AD2DB1D5")
    
public void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj){
        mActivePhone.registerForInCallVoicePrivacyOn(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.316 -0500", hash_original_method = "0596A53DE0CD40E24BD622C2A10DB61F", hash_generated_method = "8D5FE4A7F6B50DF30D9A0A80A7CB7A0A")
    
public void unregisterForInCallVoicePrivacyOn(Handler h){
        mActivePhone.unregisterForInCallVoicePrivacyOn(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.318 -0500", hash_original_method = "8580D37C907E7A9F693EB245DEF13136", hash_generated_method = "672EA90C6674B249530E28FCB717695E")
    
public void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj){
        mActivePhone.registerForInCallVoicePrivacyOff(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.321 -0500", hash_original_method = "E7481BA4FE9ECE1EB332BE2813856B0F", hash_generated_method = "D1A0397D49CF45F8A7CA8290987350F2")
    
public void unregisterForInCallVoicePrivacyOff(Handler h){
        mActivePhone.unregisterForInCallVoicePrivacyOff(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.323 -0500", hash_original_method = "63FB86C462C85472E9B1DE83D5992033", hash_generated_method = "889714FB2415A1EFDA223D62F9309CD3")
    
public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        mActivePhone.registerForCdmaOtaStatusChange(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.325 -0500", hash_original_method = "B07CAFCA57A86824FD764E8F5BCC69F6", hash_generated_method = "CACAAAB9509D07B48D115F4B3F029E28")
    
public void unregisterForCdmaOtaStatusChange(Handler h) {
         mActivePhone.unregisterForCdmaOtaStatusChange(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.328 -0500", hash_original_method = "D2EC4ABC85C2DBBBD2F97B01B00FC354", hash_generated_method = "60256F5FF63AD23EB3CB98888EC3925A")
    
public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        mActivePhone.registerForSubscriptionInfoReady(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.330 -0500", hash_original_method = "8D3E4B5E276708402BA8905C031A4077", hash_generated_method = "76384307BFF2E11D3A5B0CEA056300AF")
    
public void unregisterForSubscriptionInfoReady(Handler h) {
        mActivePhone.unregisterForSubscriptionInfoReady(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.332 -0500", hash_original_method = "F20E47EE52F6D2491D65D5697A31CABF", hash_generated_method = "C80DF87DCFC32676575B56358C630530")
    
public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        mActivePhone.registerForEcmTimerReset(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.334 -0500", hash_original_method = "920206F31962950D0AAEBD74D3EB74A0", hash_generated_method = "33FCE2AF105AE0AC8B7F3137337ACA91")
    
public void unregisterForEcmTimerReset(Handler h) {
        mActivePhone.unregisterForEcmTimerReset(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.336 -0500", hash_original_method = "7EF3A6A80892F2979555A67DD970C0E2", hash_generated_method = "848A1EF79A0AB41C3E730CDCFF1F552D")
    
public void registerForRingbackTone(Handler h, int what, Object obj) {
        mActivePhone.registerForRingbackTone(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.339 -0500", hash_original_method = "798B92E735E3353B7D58D71CA839CF04", hash_generated_method = "171EE88AA07562B0FFABE84C5BF902E0")
    
public void unregisterForRingbackTone(Handler h) {
        mActivePhone.unregisterForRingbackTone(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.342 -0500", hash_original_method = "1F657D031A61151E70121C4B52E6A8BE", hash_generated_method = "6A8CB10EF348A665D75E8E5D800FDC82")
    
public void registerForResendIncallMute(Handler h, int what, Object obj) {
        mActivePhone.registerForResendIncallMute(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.344 -0500", hash_original_method = "318D4EA275085D9FE368237910C439C9", hash_generated_method = "5864B3978F64A84E400D8AF0B83E74F7")
    
public void unregisterForResendIncallMute(Handler h) {
        mActivePhone.unregisterForResendIncallMute(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.346 -0500", hash_original_method = "573CC92F3418BCFB0FF251AE3595504E", hash_generated_method = "846F997537110AE9D32EC9D0A102CAEC")
    
public boolean getIccRecordsLoaded() {
        return mActivePhone.getIccRecordsLoaded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.348 -0500", hash_original_method = "ED5011C4FD69C3E6F976A9BF6511614B", hash_generated_method = "50D46D5865F59AAB7941CDA5EEA93273")
    
public IccCard getIccCard() {
        return mActivePhone.getIccCard();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.351 -0500", hash_original_method = "818C139D018C986F782D9EE4A8763344", hash_generated_method = "4E2AAF07D232FEE7FA89DC0E6A6C081F")
    
public void acceptCall() throws CallStateException {
        mActivePhone.acceptCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.353 -0500", hash_original_method = "97E2AC795479FE1B7319A33A335CD66F", hash_generated_method = "44367EA8B4741F76B017ED7611344FB0")
    
public void rejectCall() throws CallStateException {
        mActivePhone.rejectCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.355 -0500", hash_original_method = "549C1597B8B994A03D2CEB12047B69BF", hash_generated_method = "50AF6185A02C94C3CCD21319671D8FDE")
    
public void switchHoldingAndActive() throws CallStateException {
        mActivePhone.switchHoldingAndActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.357 -0500", hash_original_method = "0419E40E3C36CBD5616113C5884F64DA", hash_generated_method = "DCABD4E7F38299ED4D67A87C642A211C")
    
public boolean canConference() {
        return mActivePhone.canConference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.359 -0500", hash_original_method = "B22D8C438D71F38CB8F4D8D6DFAC611B", hash_generated_method = "61F7FF009DE54B8257E881B95903CB62")
    
public void conference() throws CallStateException {
        mActivePhone.conference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.361 -0500", hash_original_method = "A5A7E6BB7B283912DDE8630491120174", hash_generated_method = "0CD0EDDB956D1FFE8F5349BA81E77F2E")
    
public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        mActivePhone.enableEnhancedVoicePrivacy(enable, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.363 -0500", hash_original_method = "54592304AB72D14126CEC7573AE57082", hash_generated_method = "A0486DFF30C9B86F71CFBA8C4E2B666C")
    
public void getEnhancedVoicePrivacy(Message onComplete) {
        mActivePhone.getEnhancedVoicePrivacy(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.366 -0500", hash_original_method = "7014D93A23435FF79D4BFA94D9A9FC07", hash_generated_method = "997CF1929A95FBCE0491AC6A3FE51732")
    
public boolean canTransfer() {
        return mActivePhone.canTransfer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.368 -0500", hash_original_method = "3CEA96380D119DFA11B425ED6B3125D9", hash_generated_method = "F0CE6F0017E9FE752E6A20CB7AB526E9")
    
public void explicitCallTransfer() throws CallStateException {
        mActivePhone.explicitCallTransfer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.370 -0500", hash_original_method = "02B61187C67CC232DCBA69D31D34EA32", hash_generated_method = "D9BCB3A157F928070AD385BA5CEE3BA4")
    
public void clearDisconnected() {
        mActivePhone.clearDisconnected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.373 -0500", hash_original_method = "87919758DEFE651AC6D6A949AA5E8BE1", hash_generated_method = "0A43051139CBFD09E4A2F9AE7AA39C35")
    
public Call getForegroundCall() {
        return mActivePhone.getForegroundCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.375 -0500", hash_original_method = "79059A2027409AA40012045BC12C74F8", hash_generated_method = "539EDF7560CCE674AA6F5FD6710FD1F8")
    
public Call getBackgroundCall() {
        return mActivePhone.getBackgroundCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.377 -0500", hash_original_method = "25A6B759039431C26AB250FD612D30B1", hash_generated_method = "FA5DCBD469AA5F837274623ED9BCAF18")
    
public Call getRingingCall() {
        return mActivePhone.getRingingCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.379 -0500", hash_original_method = "BB7BA0AEA89C9F082B060BF7F91AA704", hash_generated_method = "558B67B8CC14996AEFAF37256E93C73E")
    
public Connection dial(String dialString) throws CallStateException {
        return mActivePhone.dial(dialString);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.381 -0500", hash_original_method = "5DE617D800B1B829CA4E6A4F18F6EB08", hash_generated_method = "798718B9434B2461FB7C1CA85C82A97B")
    
public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        return mActivePhone.dial(dialString, uusInfo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.384 -0500", hash_original_method = "9B5B70522CA15CFB91C76B0984182CA1", hash_generated_method = "811BEC6BBC98B9BC6C9330816D8CB66C")
    
public boolean handlePinMmi(String dialString) {
        return mActivePhone.handlePinMmi(dialString);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.387 -0500", hash_original_method = "C46007CECA2CF81CCE63431501B53EC9", hash_generated_method = "2C4360C1CE00ABF5C93EA3805BF53AAF")
    
public boolean handleInCallMmiCommands(String command) throws CallStateException {
        return mActivePhone.handleInCallMmiCommands(command);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.389 -0500", hash_original_method = "0B6C232D6E8256028E4E830B46E0C865", hash_generated_method = "A6319772CDD5A928CADEEF7BB11453C4")
    
public void sendDtmf(char c) {
        mActivePhone.sendDtmf(c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.391 -0500", hash_original_method = "0BF246784E14D976C00B34F2293C9DD9", hash_generated_method = "E21F35FAFFC8DC2FE98157DE722E244B")
    
public void startDtmf(char c) {
        mActivePhone.startDtmf(c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.393 -0500", hash_original_method = "7A948DB508D0F070854394E948C19D5E", hash_generated_method = "127C113BAC51860B7B1983F84696A621")
    
public void stopDtmf() {
        mActivePhone.stopDtmf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.396 -0500", hash_original_method = "06BEA46EB33C17C0D8EC097176162A12", hash_generated_method = "230E56FD2B81AA961F3487BE7472AA65")
    
public void setRadioPower(boolean power) {
        mActivePhone.setRadioPower(power);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.398 -0500", hash_original_method = "A0C1C046E248344C729559EE414F342E", hash_generated_method = "C809DB2FB56893C7FEAB86407AB7BD2B")
    
public boolean getMessageWaitingIndicator() {
        return mActivePhone.getMessageWaitingIndicator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.400 -0500", hash_original_method = "F1A2FB70EC1DACCE7F0918B592265B15", hash_generated_method = "71D339EF12037939481724EECDC5E959")
    
public boolean getCallForwardingIndicator() {
        return mActivePhone.getCallForwardingIndicator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.402 -0500", hash_original_method = "1CAA7F0C710838B237CC4DA5C7E7A33A", hash_generated_method = "14E41EC14008CD7172C3815B1C3BB16D")
    
public String getLine1Number() {
        return mActivePhone.getLine1Number();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.404 -0500", hash_original_method = "10EAA774600B04568EE091121E794971", hash_generated_method = "A8E6B74D4E080188CF672C4E59D071E2")
    
public String getCdmaMin() {
        return mActivePhone.getCdmaMin();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.406 -0500", hash_original_method = "A71E3ECA8C6BA629D2669D9D003E8E82", hash_generated_method = "B826A9C6F238A9002E55B1C728F04638")
    
public boolean isMinInfoReady() {
        return mActivePhone.isMinInfoReady();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.408 -0500", hash_original_method = "67E2C83E9DB650D3B6C51CD69583EDC3", hash_generated_method = "D4EE3E3DC3C915E258CAC7DEF4753BA8")
    
public String getCdmaPrlVersion() {
        return mActivePhone.getCdmaPrlVersion();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.411 -0500", hash_original_method = "120E431958E44A5C955EC29DDD87D928", hash_generated_method = "E0EE6D161708AB4F05999054CAB7C775")
    
public String getLine1AlphaTag() {
        return mActivePhone.getLine1AlphaTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.413 -0500", hash_original_method = "26770037AE4E2E1515FF2F3BB6F4CF17", hash_generated_method = "54B1237E553480FB3B53024D422DA8AF")
    
public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mActivePhone.setLine1Number(alphaTag, number, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.415 -0500", hash_original_method = "E98C356F195960A9D5230053710E4E64", hash_generated_method = "DAD5822C1408196DA335A2EC05F68903")
    
public String getVoiceMailNumber() {
        return mActivePhone.getVoiceMailNumber();
    }

     /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.418 -0500", hash_original_method = "D1C747624B6D1D0F21E7BC1753211E26", hash_generated_method = "394E9406B998EC43EAD04F1264E73B31")
    
public int getVoiceMessageCount(){
        return mActivePhone.getVoiceMessageCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.420 -0500", hash_original_method = "FC3451D7762D06B58ED1AC6B8DC91C9B", hash_generated_method = "7365E7BD35372D2455726387B036EEF4")
    
public String getVoiceMailAlphaTag() {
        return mActivePhone.getVoiceMailAlphaTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.423 -0500", hash_original_method = "522282B12A2B688AADF5447531A6EC32", hash_generated_method = "FFF02E26966313C96F2D640853F4E61B")
    
public void setVoiceMailNumber(String alphaTag,String voiceMailNumber,
            Message onComplete) {
        mActivePhone.setVoiceMailNumber(alphaTag, voiceMailNumber, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.425 -0500", hash_original_method = "86E14C93495E4C2EB6232D120A78ED3F", hash_generated_method = "E8BC5A6779A756722FB589A80CE69EB7")
    
public void getCallForwardingOption(int commandInterfaceCFReason,
            Message onComplete) {
        mActivePhone.getCallForwardingOption(commandInterfaceCFReason,
                onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.427 -0500", hash_original_method = "CBFC5803992D2E6608C59A2C061F78E7", hash_generated_method = "4DC11D1A2AD4BA4F031842DF9294F284")
    
public void setCallForwardingOption(int commandInterfaceCFReason,
            int commandInterfaceCFAction, String dialingNumber,
            int timerSeconds, Message onComplete) {
        mActivePhone.setCallForwardingOption(commandInterfaceCFReason,
            commandInterfaceCFAction, dialingNumber, timerSeconds, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.429 -0500", hash_original_method = "AF286AD09BEA2798BEC2DEED1333B02E", hash_generated_method = "F283B14FACC83182FCDB83DC97905951")
    
public void getOutgoingCallerIdDisplay(Message onComplete) {
        mActivePhone.getOutgoingCallerIdDisplay(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.432 -0500", hash_original_method = "4DB15912E84A1437FA732CF441FE9BE5", hash_generated_method = "CB06D75E2BF3FE107EB2571DE735976C")
    
public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
            Message onComplete) {
        mActivePhone.setOutgoingCallerIdDisplay(commandInterfaceCLIRMode,
                onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.434 -0500", hash_original_method = "D7C353092E0E02293EE7D1F380F106FD", hash_generated_method = "8E116F179D20D68FED55665057815634")
    
public void getCallWaiting(Message onComplete) {
        mActivePhone.getCallWaiting(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.436 -0500", hash_original_method = "4A6B6036C75BD72C377A9C63DDB5DDAF", hash_generated_method = "06BEEE11B88508C7E6B0482187E44573")
    
public void setCallWaiting(boolean enable, Message onComplete) {
        mActivePhone.setCallWaiting(enable, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.438 -0500", hash_original_method = "A6F1CB8E89876C00E820BBE51B2BA46A", hash_generated_method = "7B8B0C852108510439F3F518457DEDC5")
    
public void getAvailableNetworks(Message response) {
        mActivePhone.getAvailableNetworks(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.441 -0500", hash_original_method = "CCC0383764181B21DD71B0C7CBFA3583", hash_generated_method = "33E6FA101DE11E56C0DA84D07CBCAF87")
    
public void setNetworkSelectionModeAutomatic(Message response) {
        mActivePhone.setNetworkSelectionModeAutomatic(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.443 -0500", hash_original_method = "32562D9B02BBA935D68D766DF3A99AB5", hash_generated_method = "67E1A461A459B3CEBB57507E185F5550")
    
public void selectNetworkManually(OperatorInfo network, Message response) {
        mActivePhone.selectNetworkManually(network, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.445 -0500", hash_original_method = "4679FCD51F20EB924517A4780BB13924", hash_generated_method = "F578163665646A38D4BB7B9DC24E22AA")
    
public void setPreferredNetworkType(int networkType, Message response) {
        mActivePhone.setPreferredNetworkType(networkType, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.447 -0500", hash_original_method = "25A22EEE8A64E80AD17264AC62119D91", hash_generated_method = "D6D7B5C81F85D6803682C7455434F19B")
    
public void getPreferredNetworkType(Message response) {
        mActivePhone.getPreferredNetworkType(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.449 -0500", hash_original_method = "E237054E620C95355A936DB3AA0C64E2", hash_generated_method = "A0EA2E7F5F94D7DC98AEDB120AAE5211")
    
public void getNeighboringCids(Message response) {
        mActivePhone.getNeighboringCids(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.451 -0500", hash_original_method = "AC14A905F8FF05A176B475E869B2A375", hash_generated_method = "00B20914D5C614E3F4343BCF7C975327")
    
public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mActivePhone.setOnPostDialCharacter(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.453 -0500", hash_original_method = "65FAB3F7948B788B5C89AC1B14A02C8D", hash_generated_method = "6FAECACE7AEACC7EC22F28DC9AD250FA")
    
public void setMute(boolean muted) {
        mActivePhone.setMute(muted);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.456 -0500", hash_original_method = "F6AD30CE89308E5CF22664B8E215DF6B", hash_generated_method = "C4676135DECC15F197B5A6C37ACFAF61")
    
public boolean getMute() {
        return mActivePhone.getMute();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.458 -0500", hash_original_method = "5715B1A91F99F5BB1F5D5EE2C48B0CC1", hash_generated_method = "E68551AB05767B1F9E1DCF44E3EDEC0E")
    
public void setEchoSuppressionEnabled(boolean enabled) {
        mActivePhone.setEchoSuppressionEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.461 -0500", hash_original_method = "6B481F073AEC57F3B022CCCA80FE55F8", hash_generated_method = "1B206DB530EB65AEFCE4C30CEA13712D")
    
public void invokeOemRilRequestRaw(byte[] data, Message response) {
        mActivePhone.invokeOemRilRequestRaw(data, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.463 -0500", hash_original_method = "1C7B38B1CF40E625B142E7177280E63D", hash_generated_method = "8430C5D45F181B9384339E4C4D2C73D1")
    
public void invokeOemRilRequestStrings(String[] strings, Message response) {
        mActivePhone.invokeOemRilRequestStrings(strings, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.466 -0500", hash_original_method = "1D5FCE6DD20C83C80CF156CE692CB4A6", hash_generated_method = "20861EB69959797301A1D2C3302B688C")
    
public void getDataCallList(Message response) {
        mActivePhone.getDataCallList(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.468 -0500", hash_original_method = "1C09DC09B772867440DA6E2967E9FBFD", hash_generated_method = "64D94CA1445280596F1D2CEED2592481")
    
public void updateServiceLocation() {
        mActivePhone.updateServiceLocation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.470 -0500", hash_original_method = "640EA3CF557AB7DE58B7D737C6DA4C5C", hash_generated_method = "2F4EC4AEC27C568AB0DB0F65B47F231E")
    
public void enableLocationUpdates() {
        mActivePhone.enableLocationUpdates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.473 -0500", hash_original_method = "063B9FD715E5F2F2C3C83ECA8334F519", hash_generated_method = "565EBF1449B4F57821541DEAE12D835A")
    
public void disableLocationUpdates() {
        mActivePhone.disableLocationUpdates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.475 -0500", hash_original_method = "457D206E05D563816C5855FA476861B2", hash_generated_method = "740F9C8E1466F7C328BF1E501D0FA20F")
    
public void setUnitTestMode(boolean f) {
        mActivePhone.setUnitTestMode(f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.477 -0500", hash_original_method = "F2E5760DFB518C3EC61CEE553486D36A", hash_generated_method = "D042E046BC84E8F72ECCECF68D08D8F2")
    
public boolean getUnitTestMode() {
        return mActivePhone.getUnitTestMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.479 -0500", hash_original_method = "23052B91D3CA97C96F37F6B3A4F34CD6", hash_generated_method = "A40E9CE9444EE6CB9CB6B36F7DBC90C8")
    
public void setBandMode(int bandMode, Message response) {
        mActivePhone.setBandMode(bandMode, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.481 -0500", hash_original_method = "A369A3698868D4703C1BBAC87DF19825", hash_generated_method = "DB8DE25DAD8FAEF43AC42BA4A48C6479")
    
public void queryAvailableBandMode(Message response) {
        mActivePhone.queryAvailableBandMode(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.483 -0500", hash_original_method = "83A00455A700B137B9490650D9F36B9D", hash_generated_method = "9AE70BA49EA5406CAFE4A696F0856099")
    
public boolean getDataRoamingEnabled() {
        return mActivePhone.getDataRoamingEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.486 -0500", hash_original_method = "E1705A991A7EDCAB74DCBA7B48CAC41D", hash_generated_method = "95D4BE15FD4480960610B5CC85FD5291")
    
public void setDataRoamingEnabled(boolean enable) {
        mActivePhone.setDataRoamingEnabled(enable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.488 -0500", hash_original_method = "6A9B3C5B4A71E7D2470947E0AA2A5BCC", hash_generated_method = "4B55B6CCAE933D3D1D8A2244C2518CFA")
    
public void queryCdmaRoamingPreference(Message response) {
        mActivePhone.queryCdmaRoamingPreference(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.491 -0500", hash_original_method = "1FC93ADA8B13CFFC5239004F3B3CB0B5", hash_generated_method = "AE97FFC68C3EC4F9F6E571EA27D0F85B")
    
public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        mActivePhone.setCdmaRoamingPreference(cdmaRoamingType, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.493 -0500", hash_original_method = "8C53B1B8D1D6A38DA0E604956F179C6D", hash_generated_method = "3494A06F0B172E359EA528DDCC88A903")
    
public void setCdmaSubscription(int cdmaSubscriptionType, Message response) {
        mActivePhone.setCdmaSubscription(cdmaSubscriptionType, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.495 -0500", hash_original_method = "1088387CE055184E1F97FE6BBA54FF58", hash_generated_method = "B9F9DAB8E7DADB9CF0D5BBC7B4EA85FA")
    
public SimulatedRadioControl getSimulatedRadioControl() {
        return mActivePhone.getSimulatedRadioControl();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.497 -0500", hash_original_method = "75BC6DC84B42C3A26CA665761D0F7A10", hash_generated_method = "676A0B617F87BA7ECEED53EB44EE7F26")
    
public int enableApnType(String type) {
        return mActivePhone.enableApnType(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.499 -0500", hash_original_method = "1210CFF29BBBF64B1DC9D62AC86E1155", hash_generated_method = "0A08503F8F009C742A6FC605F18952C2")
    
public int disableApnType(String type) {
        return mActivePhone.disableApnType(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.502 -0500", hash_original_method = "9034514FEEE6D5B439090B03B1D51B35", hash_generated_method = "021453CF53A8997076BBD65E848E0B6B")
    
public boolean isDataConnectivityPossible() {
        return mActivePhone.isDataConnectivityPossible(Phone.APN_TYPE_DEFAULT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.504 -0500", hash_original_method = "A007860DE758B191AB9479ED676F0C07", hash_generated_method = "6B915F0579CBBB19B5AF1DF81FD995AB")
    
public boolean isDataConnectivityPossible(String apnType) {
        return mActivePhone.isDataConnectivityPossible(apnType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.506 -0500", hash_original_method = "3998BBC7D6E7B86D0EF695C7689974F8", hash_generated_method = "C216D6B18090B91E0BA4349E6C5F7AD3")
    
public String getDeviceId() {
        return mActivePhone.getDeviceId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.508 -0500", hash_original_method = "76EAEF0E66F2A9BBE4717FE73F5ED353", hash_generated_method = "DA6148C1328EAF4FC24B0A21D92DE21C")
    
public String getDeviceSvn() {
        return mActivePhone.getDeviceSvn();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.512 -0500", hash_original_method = "1ECAE2CD43CA09CB9212F2988BDE6FBC", hash_generated_method = "B28AF85C618F087DC9AB3E263780A1CD")
    
public String getSubscriberId() {
        return mActivePhone.getSubscriberId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.515 -0500", hash_original_method = "8CEEEC6C5657CF093EC5C2CD2B317EA0", hash_generated_method = "3B86863F47B13CF7A33B1AB99894B9BA")
    
public String getIccSerialNumber() {
        return mActivePhone.getIccSerialNumber();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.517 -0500", hash_original_method = "2D1CB2879A81E8F3B8DDFCA9A2C2729E", hash_generated_method = "2A250161B2346C132DD6827C39004949")
    
public String getEsn() {
        return mActivePhone.getEsn();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.519 -0500", hash_original_method = "52D33A8014F33FDF48C4849E35A302B8", hash_generated_method = "8E75050322151BDE8E45A159EE97E528")
    
public String getMeid() {
        return mActivePhone.getMeid();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.521 -0500", hash_original_method = "3CACCFD581E76689B35FC9516D7D6722", hash_generated_method = "CECF983ECCD001E1BED8EB7F6CEADF3D")
    
public String getMsisdn() {
        return mActivePhone.getMsisdn();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.523 -0500", hash_original_method = "AA62493265BE82E1EA914E3BCF7156B9", hash_generated_method = "63BE1F9AACBA700162F0392CFAFDD900")
    
public String getImei() {
        return mActivePhone.getImei();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.525 -0500", hash_original_method = "F690EA9868154CE135715DACD9F934BA", hash_generated_method = "1C771E545F581D5052679DBAB4AD6605")
    
public PhoneSubInfo getPhoneSubInfo(){
        return mActivePhone.getPhoneSubInfo();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.527 -0500", hash_original_method = "086F5D99D445443CC50FFF4E863848F2", hash_generated_method = "B995BB30649A610D9C40FE1770116BAC")
    
public IccSmsInterfaceManager getIccSmsInterfaceManager(){
        return mActivePhone.getIccSmsInterfaceManager();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.529 -0500", hash_original_method = "60C2E0B4179F9AE0AB8C22122916C887", hash_generated_method = "85290E03DA28458F5C3355C981497593")
    
public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager(){
        return mActivePhone.getIccPhoneBookInterfaceManager();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.532 -0500", hash_original_method = "BF3B8B247068D4ADEA1F37A9B4F54BEE", hash_generated_method = "38F7AFE09A535B420B0BA9069EF83AA0")
    
public void setTTYMode(int ttyMode, Message onComplete) {
        mActivePhone.setTTYMode(ttyMode, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.535 -0500", hash_original_method = "7032666270258E807A57538A004ED89C", hash_generated_method = "F62B110AEBA088B4EEE68FDE8A9B15E5")
    
public void queryTTYMode(Message onComplete) {
        mActivePhone.queryTTYMode(onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.537 -0500", hash_original_method = "049ED66F5C09B698FEC3E3D94D92B23F", hash_generated_method = "41AEBF49C57189671576B5C553D15454")
    
public void activateCellBroadcastSms(int activate, Message response) {
        mActivePhone.activateCellBroadcastSms(activate, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.539 -0500", hash_original_method = "8568141E62F764FB2C60CDDD3F5BE824", hash_generated_method = "691CB3F7495F9C5DF97634C27AC7A60A")
    
public void getCellBroadcastSmsConfig(Message response) {
        mActivePhone.getCellBroadcastSmsConfig(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.542 -0500", hash_original_method = "94113A359AA9972971ECDC1E12DDE1DF", hash_generated_method = "624E5D26EBCA4A5045D66C6CB9BBA00A")
    
public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        mActivePhone.setCellBroadcastSmsConfig(configValuesArray, response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.544 -0500", hash_original_method = "126AB2B3AB841B888F5ABFA3111435C5", hash_generated_method = "008B85865E7F00A2BD7FF0779EC434E0")
    
public void notifyDataActivity() {
         mActivePhone.notifyDataActivity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.546 -0500", hash_original_method = "7EA1DF4C3C9340F77B51ED8AAF4D9915", hash_generated_method = "7807775D68B0CE954ECD40729B8C1593")
    
public void getSmscAddress(Message result) {
        mActivePhone.getSmscAddress(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.548 -0500", hash_original_method = "FB2B0BAB94F6FB8614046C8030FDB583", hash_generated_method = "9826455BD2A7123369CF064E854705D6")
    
public void setSmscAddress(String address, Message result) {
        mActivePhone.setSmscAddress(address, result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.551 -0500", hash_original_method = "7E642731976316851883AF453F0DE9D1", hash_generated_method = "FDC68F35276C1DC919C21AFE4B82D826")
    
public int getCdmaEriIconIndex() {
        return mActivePhone.getCdmaEriIconIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.553 -0500", hash_original_method = "E4FB10ACB3B935577FCA6097A2878CDF", hash_generated_method = "900EE81327798720BA6252DB19FDC8BF")
    
public String getCdmaEriText() {
        return mActivePhone.getCdmaEriText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.555 -0500", hash_original_method = "D2EB202C2A6C92D481F95F578A41184F", hash_generated_method = "2B5158B61A68AC417230C960C2A757B5")
    
public int getCdmaEriIconMode() {
        return mActivePhone.getCdmaEriIconMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.557 -0500", hash_original_method = "C3F5107FB4E93BC1C37D52CD5D46B8CE", hash_generated_method = "8B723A6A9301CBBC05D94C3760D67944")
    
public Phone getActivePhone() {
        return mActivePhone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.559 -0500", hash_original_method = "DBD858F210C7F2CCF40F9ECFF3F5960C", hash_generated_method = "8AAAB0D88123EB606FB8E196D2F2F63F")
    
public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete){
        mActivePhone.sendBurstDtmf(dtmfString, on, off, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.562 -0500", hash_original_method = "8BFD81BBE49EE543CC3D717485A9086C", hash_generated_method = "6C9099D2AD74AE3314B4C12609809DF9")
    
public void exitEmergencyCallbackMode(){
        mActivePhone.exitEmergencyCallbackMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.564 -0500", hash_original_method = "8726ABCB4E2BFA30281306F58F6D1D44", hash_generated_method = "6ED1691654A22F3552DDE83285665639")
    
public boolean needsOtaServiceProvisioning(){
        return mActivePhone.needsOtaServiceProvisioning();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.566 -0500", hash_original_method = "FC9EE79D6E4BBDA9E87C5C7785BF5296", hash_generated_method = "FE714B9112C5CE69A2676640A7890305")
    
public boolean isOtaSpNumber(String dialStr){
        return mActivePhone.isOtaSpNumber(dialStr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.568 -0500", hash_original_method = "81EEB667D660E1C4817CDA2165DBC719", hash_generated_method = "35D7A483657AEF32D8D8FC40B710E0F6")
    
public void registerForCallWaiting(Handler h, int what, Object obj){
        mActivePhone.registerForCallWaiting(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.570 -0500", hash_original_method = "043761EEB80233EAAA0ED4C7284122E5", hash_generated_method = "A81EFC756A633C6B56AF734D26B756A6")
    
public void unregisterForCallWaiting(Handler h){
        mActivePhone.unregisterForCallWaiting(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.572 -0500", hash_original_method = "B8A81334C9B85923298A0218EB6228DA", hash_generated_method = "14A08691CAB3C679E7E3E2FE8322A642")
    
public void registerForSignalInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForSignalInfo(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.575 -0500", hash_original_method = "56F07C7E7F2E45B8ACB0AAFD9FC9AA58", hash_generated_method = "E84C46EFCCCB5D8CD5DF26CFA2E6B0AB")
    
public void unregisterForSignalInfo(Handler h) {
        mActivePhone.unregisterForSignalInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.577 -0500", hash_original_method = "BBDB04AE23DA14934AE112C01736669E", hash_generated_method = "CD51606E0E1A99F500AB5691C830B961")
    
public void registerForDisplayInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForDisplayInfo(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.580 -0500", hash_original_method = "01AAE958AD4359500B5B2BE98BB89BF8", hash_generated_method = "F7B63970271747F1CA942B18C9DBFD67")
    
public void unregisterForDisplayInfo(Handler h) {
        mActivePhone.unregisterForDisplayInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.583 -0500", hash_original_method = "36E3230BC8D9B35B76BF13641751629A", hash_generated_method = "BB3D9C7CBA08B1FA68CD6E3D25059218")
    
public void registerForNumberInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForNumberInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.585 -0500", hash_original_method = "8FFE8C3BE21136EDEFE91247D2089A6F", hash_generated_method = "DA860FF5E44C80DF4D42674F469B2DF3")
    
public void unregisterForNumberInfo(Handler h) {
        mActivePhone.unregisterForNumberInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.587 -0500", hash_original_method = "2B564E821C2FB72BDEAD4AA025AF0066", hash_generated_method = "CD6CAA5F90BA9C4778770C2DF4448B1F")
    
public void registerForRedirectedNumberInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForRedirectedNumberInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.589 -0500", hash_original_method = "BF962A345FAA2ACA1D6CE7EF895448CB", hash_generated_method = "41D35C78ED0A7E5B91E97E6E63320011")
    
public void unregisterForRedirectedNumberInfo(Handler h) {
        mActivePhone.unregisterForRedirectedNumberInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.592 -0500", hash_original_method = "9CC0055A8F08112A17125C260D3A9792", hash_generated_method = "267255CF0E27A7AFDFAEDA1BB5994DBD")
    
public void registerForLineControlInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForLineControlInfo( h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.594 -0500", hash_original_method = "4006432BA645767628E298E56F6FF468", hash_generated_method = "3DD95F194FE1E2A43D916A74C35DD767")
    
public void unregisterForLineControlInfo(Handler h) {
        mActivePhone.unregisterForLineControlInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.596 -0500", hash_original_method = "B6078895A8CE2B44D88AB2AA42C5B470", hash_generated_method = "A38241EA363B361604B85B2CA3C15E23")
    
public void registerFoT53ClirlInfo(Handler h, int what, Object obj) {
        mActivePhone.registerFoT53ClirlInfo(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.598 -0500", hash_original_method = "253E2BC4B1A44A6A95CA1620A686C816", hash_generated_method = "8D2F51C68472D0D90F92D20A69C9117C")
    
public void unregisterForT53ClirInfo(Handler h) {
        mActivePhone.unregisterForT53ClirInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.601 -0500", hash_original_method = "32A2CE43AB145EDFCAA8E4ECC9759844", hash_generated_method = "DA23F615586CC3FA6325A8CF1D815E74")
    
public void registerForT53AudioControlInfo(Handler h, int what, Object obj) {
        mActivePhone.registerForT53AudioControlInfo( h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.603 -0500", hash_original_method = "4AE0D61BDA071A6EF1270192C4CF1047", hash_generated_method = "9EF73256B87740AB84AC5D874B1E85E3")
    
public void unregisterForT53AudioControlInfo(Handler h) {
        mActivePhone.unregisterForT53AudioControlInfo(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.606 -0500", hash_original_method = "41133F4DD588507965EC315DCBBFF060", hash_generated_method = "44FA23284BFF62215497FB5E34D9E72B")
    
public void setOnEcbModeExitResponse(Handler h, int what, Object obj){
        mActivePhone.setOnEcbModeExitResponse(h,what,obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.608 -0500", hash_original_method = "4E8588DDBC5EF0D4B7CA47E34F25DA4E", hash_generated_method = "BDDB54B8211B2D679E21AB566C1DCD82")
    
public void unsetOnEcbModeExitResponse(Handler h){
        mActivePhone.unsetOnEcbModeExitResponse(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.610 -0500", hash_original_method = "2ED432182E52B464F176F32C70048A75", hash_generated_method = "AC13A07CF4E8D9F8698B59DC418992C7")
    
public boolean isCspPlmnEnabled() {
        return mActivePhone.isCspPlmnEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.612 -0500", hash_original_method = "6B3F3727C6E27C1D7509403503E192DB", hash_generated_method = "BBEFFABA9C47E3ED13A7C0AE8C5ED6BA")
    
public IsimRecords getIsimRecords() {
        return mActivePhone.getIsimRecords();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.614 -0500", hash_original_method = "55C7B062A224143E4F3BC5AEB56D7D1B", hash_generated_method = "D3B36C6C760EB4A9434AC2DBF004B8B8")
    
public void requestIsimAuthentication(String nonce, Message response) {
        mActivePhone.requestIsimAuthentication(nonce, response);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.616 -0500", hash_original_method = "941A6F344732C9909039B3394C47476B", hash_generated_method = "5B70C9D3BF54D2660A7C27B4C48218C8")
    
@Override
    public int getLteOnCdmaMode() {
        return mActivePhone.getLteOnCdmaMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.619 -0500", hash_original_method = "76C4D60AAD82037C8D80BAFC420E4BE1", hash_generated_method = "98588777C17F2021E6E5E07FB5C213E1")
    
@Override
    public void setVoiceMessageWaiting(int line, int countWaiting) {
        mActivePhone.setVoiceMessageWaiting(line, countWaiting);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:09.622 -0500", hash_original_method = "7E67422BCCEADCFE06A679F5EB930FDC", hash_generated_method = "B0C383E9C52AB3A6F52876270B282094")
    
@Override
    public UsimServiceTable getUsimServiceTable() {
        return mActivePhone.getUsimServiceTable();
    }
}

