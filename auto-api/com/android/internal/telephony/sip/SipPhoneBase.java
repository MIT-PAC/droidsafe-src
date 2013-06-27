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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.580 -0400", hash_original_field = "887ACB3EAA8ED60F5AC1B7488F7B5188", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.580 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.580 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "2219DFDCD45EF4951BDF53AE7EA06349")
    public  SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        addTaint(context.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract Call getForegroundCall();

    
    public abstract Call getBackgroundCall();

    
    public abstract Call getRingingCall();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.605 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "584572EDBAF02CBC11C8AC4A0D437F98")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1068966164 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1068966164 = dial(dialString);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1068966164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068966164;
        // ---------- Original Method ----------
        //return dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.605 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "E596EBFCAA9358EAB55A52054AB47B3A")
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
        addTaint(from.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.606 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "D3087F32116A58DD951D09CC259A1BB4")
    @Override
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mRingbackRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mRingbackRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.606 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "CA6050A415157F95762B505637B2267A")
    @Override
    public void unregisterForRingbackTone(Handler h) {
        mRingbackRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRingbackRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.607 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4F5B51E39D224FFDB19629709C004699")
    protected void startRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.628 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "3A6CABF2E9356A6EBB9744A338A2C113")
    protected void stopRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.629 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "DA3857C6E063D8BF0A2E364DF7367F70")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_623534940 = null; //Variable for return #1
        ServiceState s;
        s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
        varB4EAC82CA7396A68D541C85D26508E83_623534940 = s;
        varB4EAC82CA7396A68D541C85D26508E83_623534940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_623534940;
        // ---------- Original Method ----------
        //ServiceState s = new ServiceState();
        //s.setState(ServiceState.STATE_IN_SERVICE);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.629 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "8100B74D688C5512FF3835191F8965AC")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_345052461 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345052461 = null;
        varB4EAC82CA7396A68D541C85D26508E83_345052461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345052461;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.630 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "561BE14D6F5CC4A4EA9941E631E80212")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_2008340657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2008340657 = state;
        varB4EAC82CA7396A68D541C85D26508E83_2008340657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008340657;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.630 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "B4129A12DC2D4AA0BE8C7E9858E469C1")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377345877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377345877;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.630 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "0C27AB42A8E4880D9CBCD7A503F290B7")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_115322859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_115322859 = new SignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_115322859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_115322859;
        // ---------- Original Method ----------
        //return new SignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.631 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "E406E82C6E7C2BF0B968DAEB488089D6")
    public boolean getMessageWaitingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679086030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679086030;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.631 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "658D991BC899C0AC20B7CB0BAAAD3824")
    public boolean getCallForwardingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079639648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079639648;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.631 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "69650227193906F2F9FC6CBF5313990D")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_754049282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_754049282 = new ArrayList<MmiCode>(0);
        varB4EAC82CA7396A68D541C85D26508E83_754049282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754049282;
        // ---------- Original Method ----------
        //return new ArrayList<MmiCode>(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.652 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "0462E2D6203CB2FED06B5811D545759F")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_328061293 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_328061293 = DataState.DISCONNECTED;
        varB4EAC82CA7396A68D541C85D26508E83_328061293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328061293;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.653 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "976AD4FC0B00DB8BD48A8FE9AEE985B5")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_847589959 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_847589959 = DataState.DISCONNECTED;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_847589959.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847589959;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.653 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "90264208629AF098E9601B8C7D7A038C")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_1004095801 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004095801 = DataActivityState.NONE;
        varB4EAC82CA7396A68D541C85D26508E83_1004095801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004095801;
        // ---------- Original Method ----------
        //return DataActivityState.NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.653 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.653 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.654 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.654 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.654 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.654 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "0D459839BFD4CE2D513A693B187FDF40")
     void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
        addTaint(code.getTaint());
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.655 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.655 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.656 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "6DC6B586FD967888C0F398F1C61BC522")
    public boolean canDial() {
        int serviceState;
        serviceState = getServiceState().getState();
        String disableCall;
        disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        {
            boolean varFEFC6EDC1CD0A4C14CFA3F2D7E738459_1693454773 = (disableCall.equals("true"));
        } //End collapsed parenthetic
        boolean var6FEF584C7F9466D000AEC52C614E1712_1249959442 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201670399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201670399;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.656 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "9B5ABBB80B939459B1AE8F3973D1F40D")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440039646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440039646;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.665 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "30762BE0BEBF0E4F5A74933872A366A9")
     boolean isInCall() {
        Call.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean varD5A00343D4B764A393A8E790D3007C99_236801343 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77695522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_77695522;
        // ---------- Original Method ----------
        //Call.State foregroundCallState = getForegroundCall().getState();
        //Call.State backgroundCallState = getBackgroundCall().getState();
        //Call.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            //|| ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.666 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "C60C7C5D86D317E1C4E9D38F43234D24")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857312442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857312442;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.666 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "0E82E3280320EEE46382188B2A583AEA")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.680 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "FC12D40C72BA4A183C0B5D48AE76566B")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.686 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "F7B5A057E05A4D68894B34176419F52F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.686 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3325DDA12C43C65FA68D146972A2FB67")
    public void setRadioPower(boolean power) {
        addTaint(power);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.687 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "3DF170C751BC1F5C77FE6592266600A7")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1643357659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1643357659 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1643357659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1643357659;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.687 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "07D5089739E08C33C0B477B882A28331")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1454119397 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1454119397 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1454119397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454119397;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.692 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "0DFA41D884139BD41E8A92340CA1B841")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1507254726 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1507254726 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1507254726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507254726;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.692 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "18DEEE0B080FFE433C84945642536A13")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851113866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851113866 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1851113866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851113866;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.693 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "D87E57973F28B28D83D0F02A3D1BA589")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_64525340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_64525340 = null;
        varB4EAC82CA7396A68D541C85D26508E83_64525340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_64525340;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.788 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "8E455A8256F8C9689C375A159EB4727B")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1368066616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368066616 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1368066616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368066616;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.788 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "468F28F3189D584B228264BEE2BBA474")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_1154807712 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1154807712 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1154807712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1154807712;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.789 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "5D451A6762985769F6ADB1619A59EA40")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1286048183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1286048183 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1286048183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286048183;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.789 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "48EE085A50C3BE8482CF46E8D3EF5669")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1431066065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1431066065 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1431066065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1431066065;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.791 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "26565A23819A7535A569C49FD7DA2CA3")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_101011320 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_101011320 = null;
        varB4EAC82CA7396A68D541C85D26508E83_101011320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101011320;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.791 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "48C8A03F95EB50AC36D570A18413DCF4")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_609103483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_609103483 = null;
        varB4EAC82CA7396A68D541C85D26508E83_609103483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609103483;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.792 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "6D153685EC1A76F8259E0FBA23CE34F4")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.792 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "8A9268A0FD3180946D6B695F260E89E4")
    public void setVoiceMailNumber(String alphaTag, String voiceMailNumber,
            Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(alphaTag.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.802 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "0DFCFA3601E2A0515241B0283FF66642")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.803 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "DC0BAAB09D7351EFC9DDD9DB87828606")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason, String dialingNumber,
            int timerSeconds, Message onComplete) {
        addTaint(commandInterfaceCFAction);
        addTaint(commandInterfaceCFReason);
        addTaint(dialingNumber.getTaint());
        addTaint(timerSeconds);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.803 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.803 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.813 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.821 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.822 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "0DD6A20DC41B3AA5A45AFAF5978304F5")
    public boolean getIccRecordsLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691666816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691666816;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.822 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "373992E52F85083F7669F5B4C8B82D91")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_1913101842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1913101842 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1913101842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1913101842;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.823 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.823 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.823 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "D70D0855C7853683A027B152D06162C0")
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.823 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.830 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "C9F8D14931A4D7088B1CE18BE7613590")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.836 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "19C4A5329B71F92A665F281EBF3A1024")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.836 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "543E3A5A401CCBA72F6183BFB0B52FBC")
    public List<DataConnection> getCurrentDataConnectionList() {
        List<DataConnection> varB4EAC82CA7396A68D541C85D26508E83_1352371138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352371138 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1352371138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352371138;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.837 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    public void updateServiceLocation() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.837 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    public void enableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.837 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    public void disableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.837 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "422FE4B4B1085A7301D95B24FA072280")
    public boolean getDataRoamingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630115819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630115819;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.838 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "5388CC5174D0767861415AFF9F866AE3")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.838 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "84CB089C339820E0AE52435BC252C4AD")
    public boolean enableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962513385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962513385;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.838 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "110DC3F0B8474A7D7E86235B23B60160")
    public boolean disableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_278607549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_278607549;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.838 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "EADDDD9D4C706F030A9A179B24B7165B")
    public boolean isDataConnectivityPossible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640640481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640640481;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.843 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "13281AAC33C36B843C0414EB8E1DC7D2")
     boolean updateCurrentCarrierInProvider() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091491573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091491573;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.843 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "234D97846E2DB5B89AE8A0AA0A7F606D")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.844 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "BF82A5ABD9425BEA4965A6411824FD52")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_202404799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_202404799 = null;
        varB4EAC82CA7396A68D541C85D26508E83_202404799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_202404799;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.844 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "9638CD4FF66648C7FBE86C67D948EA5A")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_554693135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_554693135 = null;
        varB4EAC82CA7396A68D541C85D26508E83_554693135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554693135;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.856 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "975A0CFB9FDD3D31BBED1C08F29045A9")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_2063644607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2063644607 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2063644607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2063644607;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.857 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "F4B2421E0179D9F193737421D0C94768")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_745869654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_745869654 = null;
        varB4EAC82CA7396A68D541C85D26508E83_745869654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_745869654;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.857 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "F7298357E8D61D3E78F455868A7175A3")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.857 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "D836FD94433820AC6D3BBDF7040F0EB9")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.857 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "C040BA038FB4F4C4760703542B649D2A")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.858 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "6229D0E6149636D71ACF380526D8C438")
    public boolean needsOtaServiceProvisioning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166173285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166173285;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.858 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "759161A5EBB934A9A5BFD9F71C547901")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1110881353 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1110881353 = null;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1110881353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1110881353;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.868 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "726D712A65BA2DA6C1D721D3ABC98BDA")
     void updatePhoneState() {
        State oldState;
        oldState = state;
        {
            boolean var472775C85B26E1907DB5673B1EE7AA42_1159817179 = (getRingingCall().isRinging());
            {
                state = State.RINGING;
            } //End block
            {
                boolean var7B0CF12B5E1B30F05158DD1DD70DC516_1942251095 = (getForegroundCall().isIdle()
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:24.868 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "71F7148CFC829A5A8E1F7DF4C5808550")

    private static String LOG_TAG = "SipPhone";
}

