package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.ArrayList;
import java.util.List;

abstract class SipPhoneBase extends PhoneBase {
    private RegistrantList mRingbackRegistrants = new RegistrantList();
    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.432 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "E60EE62CAF47FB82E5BFD7F7CB83B5CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    public abstract Call getForegroundCall();

    
    public abstract Call getBackgroundCall();

    
    public abstract Call getRingingCall();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.433 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "E1EF750C3D6F20034DBA809942ACFC98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        Connection var5C51845179BD4D4096AEB107BE78E0A3_1978824360 = (dial(dialString));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.433 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "5C6D58A6EFBD9CB8DD759721322F6F8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void migrateFrom(SipPhoneBase from) {
        dsTaint.addTaint(from.dsTaint);
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
        // ---------- Original Method ----------
        //migrate(mRingbackRegistrants, from.mRingbackRegistrants);
        //migrate(mPreciseCallStateRegistrants, from.mPreciseCallStateRegistrants);
        //migrate(mNewRingingConnectionRegistrants, from.mNewRingingConnectionRegistrants);
        //migrate(mIncomingRingRegistrants, from.mIncomingRingRegistrants);
        //migrate(mDisconnectRegistrants, from.mDisconnectRegistrants);
        //migrate(mServiceStateRegistrants, from.mServiceStateRegistrants);
        //migrate(mMmiCompleteRegistrants, from.mMmiCompleteRegistrants);
        //migrate(mMmiRegistrants, from.mMmiRegistrants);
        //migrate(mUnknownConnectionRegistrants, from.mUnknownConnectionRegistrants);
        //migrate(mSuppServiceFailedRegistrants, from.mSuppServiceFailedRegistrants);
    }

    
        static void migrate(RegistrantList to, RegistrantList from) {
        from.removeCleared();
        for (int i = 0, n = from.size(); i < n; i++) {
            to.add((Registrant) from.get(i));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.434 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "5CCFF4F4EA20455EF0BA095CFF560408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mRingbackRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //mRingbackRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.434 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "7FD875E052B649D6CA477E7B48CD4A2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterForRingbackTone(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mRingbackRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRingbackRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.434 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4F5B51E39D224FFDB19629709C004699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void startRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.434 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "3A6CABF2E9356A6EBB9744A338A2C113")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void stopRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.435 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "E71CFFCC1E3EAD3BDEAEFB671671A619")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceState getServiceState() {
        ServiceState s;
        s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ServiceState s = new ServiceState();
        //s.setState(ServiceState.STATE_IN_SERVICE);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.435 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "3DF0EEA5C20FDAC86AF0DA6505D90C72")
    @DSModeled(DSC.SAFE)
    public CellLocation getCellLocation() {
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.435 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "F5E227F5D2B96691C815C4C56ED31889")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.435 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "5271E3A13B8C8989362C4205E6344FC4")
    @DSModeled(DSC.SAFE)
    public int getPhoneType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.435 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "9B805ADD8BBF468742E96958F6D8E666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignalStrength getSignalStrength() {
        SignalStrength var533E61EF28087A27BC5C91F1F0C3B9F2_809248007 = (new SignalStrength());
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "58604AFFB1851EB9A29E2ED531034385")
    @DSModeled(DSC.SAFE)
    public boolean getMessageWaitingIndicator() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "2D1E9C8EFAD28A3B5E5F8AD44F70F89C")
    @DSModeled(DSC.SAFE)
    public boolean getCallForwardingIndicator() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "0E2264742DFD602D0811376DE10D0B44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> var654DA2283C2B7582690648C3BEA2DC44_1786775448 = (new ArrayList<MmiCode>(0));
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ArrayList<MmiCode>(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "D649A827182EDAADDE2B4BC79743F3A5")
    @DSModeled(DSC.SAFE)
    public DataState getDataConnectionState() {
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "7964169BF6224B080F814B92C1F74E15")
    @DSModeled(DSC.SAFE)
    public DataState getDataConnectionState(String apnType) {
        dsTaint.addTaint(apnType);
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.436 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "52CAFF5EDE4A840AE40C87F46EF4D802")
    @DSModeled(DSC.SAFE)
    public DataActivityState getDataActivityState() {
        return (DataActivityState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return DataActivityState.NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.437 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.437 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.437 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "31C9E56614FB3AAD40C46802EAC18158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyNewRingingConnection(Connection c) {
        dsTaint.addTaint(c.dsTaint);
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.437 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "2C4B5AD2DBE6251947A4E99B58E84719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyDisconnect(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.437 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.438 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "9B00EFA70F78F3A7ED04EFF6E261F229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifySuppServiceFailed(SuppService code) {
        dsTaint.addTaint(code.dsTaint);
        mSuppServiceFailedRegistrants.notifyResult(code);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.438 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "E90FF12135FFFA3180D191EA7D408C6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyServiceStateChanged(ServiceState ss) {
        dsTaint.addTaint(ss.dsTaint);
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.438 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.438 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "C09480E077498235E0A612F608598AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canDial() {
        int serviceState;
        serviceState = getServiceState().getState();
        String disableCall;
        disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        {
            boolean varFEFC6EDC1CD0A4C14CFA3F2D7E738459_1805445380 = (disableCall.equals("true"));
        } //End collapsed parenthetic
        boolean var6FEF584C7F9466D000AEC52C614E1712_1138244208 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.439 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "EA93C431593F139C246A2D1A4BBCA2A5")
    @DSModeled(DSC.SAFE)
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.439 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "90BF849B21AB0118F5BBE0C11662DCC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInCall() {
        Call.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean varD5A00343D4B764A393A8E790D3007C99_703005723 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Call.State foregroundCallState = getForegroundCall().getState();
        //Call.State backgroundCallState = getBackgroundCall().getState();
        //Call.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            //|| ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.439 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "B7AB62CAB69D0F978FCFED3DCB5AE0B3")
    @DSModeled(DSC.SAFE)
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.439 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "8AD6365DB2DDB07CDD5C4A3FEA3E9629")
    @DSModeled(DSC.SAFE)
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "BFF1FC9CF18B2999C64E9338EA972110")
    @DSModeled(DSC.SAFE)
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "B6506C279219BCD6B56197DE0CFFFCB1")
    @DSModeled(DSC.SAFE)
    public void unregisterForSuppServiceNotification(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "202C381A9EE3A21D3AA3633A9BBD03C9")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "14E33B1387BD5D732ED87B3B44CC8035")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "B30631EA4DD07C81C58ADF2CB5A0CE1B")
    @DSModeled(DSC.SAFE)
    public String getVoiceMailAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.440 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "8468657140DD305D4A86C27C81E740A7")
    @DSModeled(DSC.SAFE)
    public String getDeviceId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.441 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "ADC307F8D9535CA1B74D888754D4D116")
    @DSModeled(DSC.SAFE)
    public String getDeviceSvn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.441 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "E97C30A97358D1E84D20259986309B8B")
    @DSModeled(DSC.SAFE)
    public String getImei() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.441 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "A562C0354315EBC22DF412EA26816C3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEsn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.441 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "9B62DAF1804ABD9561A80D3A6F07B6CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMeid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.441 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "180D8A3140939AD3ADE362623C2A2B01")
    @DSModeled(DSC.SAFE)
    public String getSubscriberId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.442 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "73B6CCE8E5F9A9398AFEFFC858CD3906")
    @DSModeled(DSC.SAFE)
    public String getIccSerialNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.442 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "A4AE08093D758A609AA82863785D73E2")
    @DSModeled(DSC.SAFE)
    public String getLine1Number() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.442 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "30B14C0C731285C56191896DACAF414A")
    @DSModeled(DSC.SAFE)
    public String getLine1AlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.444 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "7A9710628A930E459723062368C794F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.444 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "6569FD9CC3B1941E569F04F2CBC7A9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMailNumber(String alphaTag, String voiceMailNumber,
            Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(voiceMailNumber);
        dsTaint.addTaint(alphaTag);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.445 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "3EEBEB03AA98F21A7BF4109B5C51A555")
    @DSModeled(DSC.SAFE)
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.445 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "C78FBB13A6AD1C09C5C8D4259BCD6726")
    @DSModeled(DSC.SAFE)
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason, String dialingNumber,
            int timerSeconds, Message onComplete) {
        dsTaint.addTaint(timerSeconds);
        dsTaint.addTaint(commandInterfaceCFAction);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(dialingNumber);
        dsTaint.addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.445 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "49C3C316E17691685BD0BB52ED3BE560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.445 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "772B57AF907EBFB55627FCD4E496D351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.447 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "18045A4B94DA66E9FA0194BA5258BBA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.448 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "C63AB8DC7513C3A28F60817181EB2BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.448 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "EC0319255A035344AEC2CAA7F04EC7FC")
    @DSModeled(DSC.SAFE)
    public boolean getIccRecordsLoaded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.448 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "4299E8D80C6F1B8C6C375508A829C8E0")
    @DSModeled(DSC.SAFE)
    public IccCard getIccCard() {
        return (IccCard)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.448 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "3E3F50BB94B25E2D622FD080BCC810CF")
    @DSModeled(DSC.SAFE)
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.449 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "5E7FFA9B4297CBB83246324E90789FCA")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeAutomatic(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.449 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "839764CAEC03A66EEE83A979642DF051")
    @DSModeled(DSC.SAFE)
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.449 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "A4B0BE56110081A9C5ECBF549C763C49")
    @DSModeled(DSC.SAFE)
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.450 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "E3E96CC34318235A849E7DCEC3E70943")
    @DSModeled(DSC.SAFE)
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.450 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "B2181F76B4927A5EB860EFFED6FD4EA7")
    @DSModeled(DSC.SAFE)
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.450 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "756BEBD2D8409BD8FCBC897145CBCF55")
    @DSModeled(DSC.SAFE)
    public List<DataConnection> getCurrentDataConnectionList() {
        return (List<DataConnection>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.451 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    @DSModeled(DSC.SAFE)
    public void updateServiceLocation() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.451 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    @DSModeled(DSC.SAFE)
    public void enableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.451 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    @DSModeled(DSC.SAFE)
    public void disableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.451 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "421D748AE44C37AC3453BC93C9575444")
    @DSModeled(DSC.SAFE)
    public boolean getDataRoamingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.451 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "B111611E05D20885B151881E12B0B889")
    @DSModeled(DSC.SAFE)
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "5458C8495B9097AC6E582C4D47525EC1")
    @DSModeled(DSC.SAFE)
    public boolean enableDataConnectivity() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "014AB5493640621B0153E09E1F7C9AE6")
    @DSModeled(DSC.SAFE)
    public boolean disableDataConnectivity() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "6E1781A5334F04C3F535B4AF9037E29E")
    @DSModeled(DSC.SAFE)
    public boolean isDataConnectivityPossible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "77745389221BD48B1CFAFCB3D328038A")
    @DSModeled(DSC.SAFE)
     boolean updateCurrentCarrierInProvider() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "8CDDC97BB1FB8926EBB4C5BCB6206042")
    @DSModeled(DSC.SAFE)
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        dsTaint.addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.452 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "4BAFEBCF96546046281A26ED900EC9CB")
    @DSModeled(DSC.SAFE)
    public PhoneSubInfo getPhoneSubInfo() {
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.453 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "B47EBB392DDF13099524946F879338E3")
    @DSModeled(DSC.SAFE)
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.453 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "4006B1BB40E1081BA9FA14D015945432")
    @DSModeled(DSC.SAFE)
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.453 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "25B5B7F4A3CAEEC82984C91EEEC20A9D")
    @DSModeled(DSC.SAFE)
    public IccFileHandler getIccFileHandler() {
        return (IccFileHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.453 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "4DEFF9C6EF8956FDD0D1983AB30E695D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(activate);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.453 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "C7285F189916DED4F92D37A2B46927B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.454 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "F1C65913C0091E759D8562306FA3CC79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray[0]);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.454 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "5E512AF1432DDA1E803A60D0438B9C5E")
    @DSModeled(DSC.SAFE)
    public boolean needsOtaServiceProvisioning() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.454 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "D6FEB85E0CEE5EBD8B6D61F45EB43973")
    @DSModeled(DSC.SAFE)
    public LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.454 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "32E1D09728EF0D6A62E3FF722E44B46E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updatePhoneState() {
        State oldState;
        oldState = state;
        {
            boolean var472775C85B26E1907DB5673B1EE7AA42_1933864062 = (getRingingCall().isRinging());
            {
                state = State.RINGING;
            } //End block
            {
                boolean var7B0CF12B5E1B30F05158DD1DD70DC516_494770979 = (getForegroundCall().isIdle()
                && getBackgroundCall().isIdle());
                {
                    state = State.IDLE;
                } //End block
                {
                    state = State.OFFHOOK;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            Log.d(LOG_TAG, " ^^^ new phone state: " + state);
            notifyPhoneStateChanged();
        } //End block
        // ---------- Original Method ----------
        //State oldState = state;
        //if (getRingingCall().isRinging()) {
            //state = State.RINGING;
        //} else if (getForegroundCall().isIdle()
                //&& getBackgroundCall().isIdle()) {
            //state = State.IDLE;
        //} else {
            //state = State.OFFHOOK;
        //}
        //if (state != oldState) {
            //Log.d(LOG_TAG, " ^^^ new phone state: " + state);
            //notifyPhoneStateChanged();
        //}
    }

    
    private static final String LOG_TAG = "SipPhone";
}

