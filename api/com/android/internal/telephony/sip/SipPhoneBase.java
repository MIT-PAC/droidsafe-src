package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.LinkProperties;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.util.Log;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.MmiCode;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;

abstract class SipPhoneBase extends PhoneBase {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.365 -0500", hash_original_method = "B82B52808FBFBFA65168DFE4EFB883F7", hash_generated_method = "6DCE0FBF2472ABA06C4A8CEC66842A27")
    
static void migrate(RegistrantList to, RegistrantList from) {
        from.removeCleared();
        for (int i = 0, n = from.size(); i < n; i++) {
            to.add((Registrant) from.get(i));
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.343 -0500", hash_original_field = "A4494B158A8DFAE7DB1E7482E9D0EFF9", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.345 -0500", hash_original_field = "BB68609BCFFCCE49B2D595059119B9E0", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.348 -0500", hash_original_field = "B9A7F7508B0B5FA0BFE8695446A61CF7", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.350 -0500", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "5AC992C6D92B02198939AD16AC2793D2")
    
public SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.353 -0500", hash_original_method = "1CAB47D2E81A282422BF05F30A34CFD7", hash_generated_method = "DC440E7AA4E03F9EEAE3CE647DD05D73")
    
public abstract Call getForegroundCall();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.355 -0500", hash_original_method = "D5FCBC5F93B3B40EB85D18136DC87476", hash_generated_method = "062F517AF15D5F66C9594E51AE6E425F")
    
public abstract Call getBackgroundCall();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.357 -0500", hash_original_method = "DD42E3B3A11D59E87224EE93F14E61D4", hash_generated_method = "B54B954483EE939AF1F3429D80205655")
    
public abstract Call getRingingCall();

    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.360 -0500", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "C2F70FFA41EA20E1A97DAC28668AA760")
    
public Connection dial(String dialString, UUSInfo uusInfo)
            throws CallStateException {
        // ignore UUSInfo
        return dial(dialString);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.362 -0500", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "36F486554819D3516784DFAE37ACA733")
    
void migrateFrom(SipPhoneBase from) {
        migrate(mRingbackRegistrants, from.mRingbackRegistrants);
        migrate(mPreciseCallStateRegistrants, from.mPreciseCallStateRegistrants);
        migrate(mNewRingingConnectionRegistrants, from.mNewRingingConnectionRegistrants);
        migrate(mIncomingRingRegistrants, from.mIncomingRingRegistrants);
        migrate(mDisconnectRegistrants, from.mDisconnectRegistrants);
        migrate(mServiceStateRegistrants, from.mServiceStateRegistrants);
        migrate(mMmiCompleteRegistrants, from.mMmiCompleteRegistrants);
        migrate(mMmiRegistrants, from.mMmiRegistrants);
        migrate(mUnknownConnectionRegistrants, from.mUnknownConnectionRegistrants);
        migrate(mSuppServiceFailedRegistrants, from.mSuppServiceFailedRegistrants);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.367 -0500", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "5AA05BAB1FE0FD83AA73692637EA76F9")
    
@Override
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        mRingbackRegistrants.addUnique(h, what, obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.369 -0500", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "A988AF90F09FD31C380F660BE4BB50FB")
    
@Override
    public void unregisterForRingbackTone(Handler h) {
        mRingbackRegistrants.remove(h);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.371 -0500", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "B54E5A716DDB2A146BD4F91A0B87A101")
    
protected void startRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.374 -0500", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "D19AD4A9D0A8D2738FC365DEF2577A0D")
    
protected void stopRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.377 -0500", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "9E12A9FA69863AF7B716597EAD8BA013")
    
public ServiceState getServiceState() {
        // FIXME: we may need to provide this when data connectivity is lost
        // or when server is down
        ServiceState s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
        return s;
    }

    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.379 -0500", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "420F67F3650F8FB7EA60A37E2604A77A")
    
public CellLocation getCellLocation() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.381 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    
public State getState() {
        return state;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.384 -0500", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "4210814B886A23F99600C14E1D183BF7")
    
public int getPhoneType() {
        return Phone.PHONE_TYPE_SIP;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.386 -0500", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "0FE2A2DCE63B84AB94D1F2938A2F149C")
    
public SignalStrength getSignalStrength() {
        return new SignalStrength();
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.388 -0500", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "3BF5B25AF96C858E8FABC3C811125B53")
    
public boolean getMessageWaitingIndicator() {
        return false;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.390 -0500", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "8E6012BEB68BD67AB5E85E7F8504862D")
    
public boolean getCallForwardingIndicator() {
        return false;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.392 -0500", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "8775EF86897F5D19FEEF938C6D5D3B29")
    
public List<? extends MmiCode> getPendingMmiCodes() {
        return new ArrayList<MmiCode>(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.395 -0500", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "3CD77866FD307015CF074694B89CCEB3")
    
public DataState getDataConnectionState() {
        return DataState.DISCONNECTED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.397 -0500", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "30E2D6EDB7B865F2F196F8BA6E7D9662")
    
public DataState getDataConnectionState(String apnType) {
        return DataState.DISCONNECTED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.399 -0500", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "83FB252EEC1B6183C5B319D108F8F240")
    
public DataActivityState getDataActivityState() {
        return DataActivityState.NONE;
    }

    /**
     * Notify any interested party of a Phone state change {@link Phone.State}
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.401 -0500", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "812A77A153EDB691C43A0B58CAFAA77A")
    
void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
    }

    /**
     * Notify registrants of a change in the call state. This notifies changes in {@link Call.State}
     * Use this when changes in the precise call state are needed, else use notifyPhoneStateChanged.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.403 -0500", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "12015DBC20468C486AF905F9802DB743")
    
void notifyPreciseCallStateChanged() {
        /* we'd love it if this was package-scoped*/
        super.notifyPreciseCallStateChangedP();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.405 -0500", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "292444BE96E352C8E8312B338E19EF02")
    
void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.407 -0500", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "1858091673D3A4B62C058FCC91892C36")
    
void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.409 -0500", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "4DFA3B176AED92FABCFB596FBC88C127")
    
void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.412 -0500", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "952D093251486E722309085461233179")
    
void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.413 -0500", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "73E7BFF04E4E9785E6146409272926BA")
    
void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.416 -0500", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "27274BB1C80ABA32305B3C620B24E439")
    
public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.418 -0500", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "0BD4F07060FD4C788B88AFE5CCFC599E")
    
public boolean canDial() {
        int serviceState = getServiceState().getState();
        Log.v(LOG_TAG, "canDial(): serviceState = " + serviceState);
        if (serviceState == ServiceState.STATE_POWER_OFF) return false;

        String disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        Log.v(LOG_TAG, "canDial(): disableCall = " + disableCall);
        if (disableCall.equals("true")) return false;

        Log.v(LOG_TAG, "canDial(): ringingCall: " + getRingingCall().getState());
        Log.v(LOG_TAG, "canDial(): foregndCall: " + getForegroundCall().getState());
        Log.v(LOG_TAG, "canDial(): backgndCall: " + getBackgroundCall().getState());
        return !getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.420 -0500", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "0CE2ACFA665F879EF9C05CAC200DB4C1")
    
public boolean handleInCallMmiCommands(String dialString)
            throws CallStateException {
        return false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.422 -0500", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "2A1F26DA67C6AD58471FCD8E9D9C481A")
    
boolean isInCall() {
        Call.State foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState = getRingingCall().getState();

       return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.425 -0500", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "766F9EF643FEDD9A0D13B096695244F6")
    
public boolean handlePinMmi(String dialString) {
        return false;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.427 -0500", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "29AF3114060FFCB06753BFB0DFB52CE7")
    
public void sendUssdResponse(String ussdMessge) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.429 -0500", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "1866B3E0397B273B5485A6C27A648C77")
    
public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.432 -0500", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "A4DD0351E52A4E76E8E3FCEC8677DF10")
    
public void unregisterForSuppServiceNotification(Handler h) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.434 -0500", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3D7D776F581CACA7A5338E6C76BEBF01")
    
public void setRadioPower(boolean power) {
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.436 -0500", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "140972063955D4FB76AD5008E9E53A63")
    
public String getVoiceMailNumber() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.438 -0500", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "CC899BB87D4AB834638804D9BF194BCD")
    
public String getVoiceMailAlphaTag() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.440 -0500", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "CC96FC51095A4DE7AD11CF74644742A4")
    
public String getDeviceId() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.442 -0500", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "9986291EB63158C66F3484A64ED331CE")
    
public String getDeviceSvn() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.444 -0500", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "6262BECD989C103851E46B1CAB476CE7")
    
public String getImei() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.447 -0500", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "F84140CB0018E9BAB263F282BCF6215F")
    
public String getEsn() {
        Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        return "0";
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.449 -0500", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "0C72F3ECBBF7EC89A5BA44E6FD2F85D9")
    
public String getMeid() {
        Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        return "0";
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.452 -0500", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "C628E2030C449FD53E230AA6A8D3358A")
    
public String getSubscriberId() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.454 -0500", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "EAFD9C6FA362752F88B378F0E7B0DEF9")
    
public String getIccSerialNumber() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.457 -0500", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "AA4FEDC30A0188E425974CC705987E3A")
    
public String getLine1Number() {
        return null;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.459 -0500", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "885406C50F015248A2343204A74BA44E")
    
public String getLine1AlphaTag() {
        return null;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.461 -0500", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "3938DEF71EC2820B88DADA12B3F19321")
    
public void setLine1Number(String alphaTag, String number, Message onComplete) {
        // FIXME: what to reply for SIP?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.463 -0500", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "BCA0154741618976FD24C0654679C1CE")
    
public void setVoiceMailNumber(String alphaTag, String voiceMailNumber,
            Message onComplete) {
        // FIXME: what to reply for SIP?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.465 -0500", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "7F729695E3358CE0C84F69561A97A78F")
    
public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.467 -0500", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "7416F411F147E29B5A88D7F3C3659126")
    
public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason, String dialingNumber,
            int timerSeconds, Message onComplete) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.469 -0500", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "2E69485E2850A2291928908360932232")
    
public void getOutgoingCallerIdDisplay(Message onComplete) {
        // FIXME: what to reply?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.472 -0500", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "7AFD122FA2BC9CD6164587737EE63933")
    
public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        // FIXME: what's this for SIP?
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.474 -0500", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "634FB4FF820C45802D9EEB8E087E5ECC")
    
public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.476 -0500", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "5E7377002A25520C466BFF2476562812")
    
public void setCallWaiting(boolean enable, Message onComplete) {
        Log.e(LOG_TAG, "call waiting not supported");
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.479 -0500", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "8AD28C5DBD431A0E2FA767F95FCBA9B3")
    
public boolean getIccRecordsLoaded() {
        return false;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.481 -0500", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "A30C2BB8B684980A6E71B8FF701B19DC")
    
public IccCard getIccCard() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.484 -0500", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "4FB3045AEB51BE4AE5BA1B2F97822222")
    
public void getAvailableNetworks(Message response) {
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.486 -0500", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "5C44E2DE0145E74BE24D559D7FB4F61E")
    
public void setNetworkSelectionModeAutomatic(Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.488 -0500", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "9DF4DDA2873B786F3AB42DC23023D2E3")
    
public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.490 -0500", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "EA4BBF728E1D00DE51E3F73E281A4213")
    
public void getNeighboringCids(Message response) {
    }

    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.492 -0500", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "BC4954655841B35D40DB43AEA50FC520")
    
public void setOnPostDialCharacter(Handler h, int what, Object obj) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.494 -0500", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "59563284411CF9C594810019E2452D5F")
    
public void getDataCallList(Message response) {
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.496 -0500", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "B928B26B0E85C875646B41AEF4890404")
    
public List<DataConnection> getCurrentDataConnectionList () {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.499 -0500", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "3CB1B9B0D82124EC4ABA400DC22A43F9")
    
public void updateServiceLocation() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.501 -0500", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "359073FC1D47F991D0DFF6787E784B7D")
    
public void enableLocationUpdates() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.503 -0500", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "5586E5620032B5DC903E66726FB7D733")
    
public void disableLocationUpdates() {
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.505 -0500", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "01C4C1E3FB41AFD5C3FE6A891FBEE2AA")
    
public boolean getDataRoamingEnabled() {
        return false;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.507 -0500", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "8174131EBDAA305AC1F4F01C58C2A301")
    
public void setDataRoamingEnabled(boolean enable) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.509 -0500", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "1B86067170BABB2B6D7C93C765218078")
    
public boolean enableDataConnectivity() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.511 -0500", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "327AE724D9C6B68FD387B725F4498133")
    
public boolean disableDataConnectivity() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.513 -0500", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "EC09BD5CEEC8E937FCC49A4AEE346339")
    
public boolean isDataConnectivityPossible() {
        return false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.516 -0500", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C")
    
boolean updateCurrentCarrierInProvider() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.518 -0500", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "7F19D0A93C13848858AD2440258EC9EE")
    
public void saveClirSetting(int commandInterfaceCLIRMode) {
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.520 -0500", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "EB59426252E11DDC2F011B850BF1FACB")
    
public PhoneSubInfo getPhoneSubInfo(){
        return null;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.523 -0500", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "FFEEAA42586D38B9B102494DA171E9E5")
    
public IccSmsInterfaceManager getIccSmsInterfaceManager(){
        return null;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.525 -0500", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "AEB64903A504C5549A4939EEBF04D542")
    
public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager(){
        return null;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.528 -0500", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "DCCEFE43F6D936F4C76476B26D1A16E1")
    
public IccFileHandler getIccFileHandler(){
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.530 -0500", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "FAA97FF035F627A15F5D63AE917FB7DE")
    
public void activateCellBroadcastSms(int activate, Message response) {
        Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.532 -0500", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "F67984B641EC46547761D7979815F93E")
    
public void getCellBroadcastSmsConfig(Message response) {
        Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.534 -0500", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "83C0128F3E1D210C0B8A8B0A4CBC08E8")
    
public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response){
        Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    //@Override
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.537 -0500", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "A23565122581BE8413D3687A0FB7A2A2")
    
public boolean needsOtaServiceProvisioning() {
        // FIXME: what's this for SIP?
        return false;
    }

    //@Override
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.539 -0500", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "8DC97FFEA15C61B1560A4BF2E204AB75")
    
public LinkProperties getLinkProperties(String apnType) {
        // FIXME: what's this for SIP?
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:24.541 -0500", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "681D205E001AABF5DF77739E6B0B2577")
    
void updatePhoneState() {
        State oldState = state;

        if (getRingingCall().isRinging()) {
            state = State.RINGING;
        } else if (getForegroundCall().isIdle()
                && getBackgroundCall().isIdle()) {
            state = State.IDLE;
        } else {
            state = State.OFFHOOK;
        }

        if (state != oldState) {
            Log.d(LOG_TAG, " ^^^ new phone state: " + state);
            notifyPhoneStateChanged();
        }
    }
}

