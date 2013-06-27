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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.862 -0400", hash_original_field = "887ACB3EAA8ED60F5AC1B7488F7B5188", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.862 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.863 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "2219DFDCD45EF4951BDF53AE7EA06349")
    public  SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        addTaint(context.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract Call getForegroundCall();

    
    public abstract Call getBackgroundCall();

    
    public abstract Call getRingingCall();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.868 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "D43B922DE46B97DB2B13B1F06631BC43")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_544567243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544567243 = dial(dialString);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_544567243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544567243;
        // ---------- Original Method ----------
        //return dial(dialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.871 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "E596EBFCAA9358EAB55A52054AB47B3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.872 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "D3087F32116A58DD951D09CC259A1BB4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.872 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "CA6050A415157F95762B505637B2267A")
    @Override
    public void unregisterForRingbackTone(Handler h) {
        mRingbackRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mRingbackRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.873 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4F5B51E39D224FFDB19629709C004699")
    protected void startRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.873 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "3A6CABF2E9356A6EBB9744A338A2C113")
    protected void stopRingbackTone() {
        AsyncResult result;
        result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.882 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "DFCE25A7F489E82B5A9007690F16DE92")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_503709683 = null; //Variable for return #1
        ServiceState s;
        s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
        varB4EAC82CA7396A68D541C85D26508E83_503709683 = s;
        varB4EAC82CA7396A68D541C85D26508E83_503709683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503709683;
        // ---------- Original Method ----------
        //ServiceState s = new ServiceState();
        //s.setState(ServiceState.STATE_IN_SERVICE);
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.882 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "27BAA7DF02356920AA112F2BCD64F564")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_868492671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_868492671 = null;
        varB4EAC82CA7396A68D541C85D26508E83_868492671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_868492671;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.885 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "755C454A7C32EE53F5464A2BA4510B79")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_732198583 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732198583 = state;
        varB4EAC82CA7396A68D541C85D26508E83_732198583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732198583;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.886 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "CA8090F287FDBA06E42F696DE59526E7")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687378982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687378982;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.886 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "95F90457CDB28AD94CFD7E588FBFF1B0")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_206763454 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_206763454 = new SignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_206763454.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206763454;
        // ---------- Original Method ----------
        //return new SignalStrength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.897 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "389CC6DFE0C8A439BC88E6068F031BB0")
    public boolean getMessageWaitingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945459249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945459249;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.898 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "7F5B859CA3388E85E5E523CAE6DD2E8C")
    public boolean getCallForwardingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773439681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773439681;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.898 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "3E0FCA430FAC96D024DD74DE6179CA4A")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1659791998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1659791998 = new ArrayList<MmiCode>(0);
        varB4EAC82CA7396A68D541C85D26508E83_1659791998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1659791998;
        // ---------- Original Method ----------
        //return new ArrayList<MmiCode>(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.900 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "618588E32D5900971CDC1DA682578277")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1806342503 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1806342503 = DataState.DISCONNECTED;
        varB4EAC82CA7396A68D541C85D26508E83_1806342503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1806342503;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.901 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "1C333CA71B729B97143BFC5A112585B5")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_284320659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_284320659 = DataState.DISCONNECTED;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_284320659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_284320659;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.901 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "B01D2401783771DC911F1A5F7D386DA5")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_826515085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_826515085 = DataActivityState.NONE;
        varB4EAC82CA7396A68D541C85D26508E83_826515085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_826515085;
        // ---------- Original Method ----------
        //return DataActivityState.NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.907 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.907 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.912 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.913 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.913 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.913 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "0D459839BFD4CE2D513A693B187FDF40")
     void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
        addTaint(code.getTaint());
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.916 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.917 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.917 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "103D46E7AAC357DACD14209E3AA7548C")
    public boolean canDial() {
        int serviceState;
        serviceState = getServiceState().getState();
        String disableCall;
        disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        {
            boolean varFEFC6EDC1CD0A4C14CFA3F2D7E738459_1745944247 = (disableCall.equals("true"));
        } //End collapsed parenthetic
        boolean var6FEF584C7F9466D000AEC52C614E1712_942904395 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664164716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664164716;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.923 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "4B3F890C3968BDB1E9FD492553EB0479")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630526416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630526416;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.923 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "C9CE44B32E58AD2AE21EFBA2419C8414")
     boolean isInCall() {
        Call.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean varD5A00343D4B764A393A8E790D3007C99_2132126973 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052396189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052396189;
        // ---------- Original Method ----------
        //Call.State foregroundCallState = getForegroundCall().getState();
        //Call.State backgroundCallState = getBackgroundCall().getState();
        //Call.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            //|| ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.938 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "A8300CAE628A827A41866B4C4DA2B4A8")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693830042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693830042;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.938 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "0E82E3280320EEE46382188B2A583AEA")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.938 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "FC12D40C72BA4A183C0B5D48AE76566B")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.938 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "F7B5A057E05A4D68894B34176419F52F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.938 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3325DDA12C43C65FA68D146972A2FB67")
    public void setRadioPower(boolean power) {
        addTaint(power);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.939 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "B101DEE8FF2B496015F40C7935579F47")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_524743595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_524743595 = null;
        varB4EAC82CA7396A68D541C85D26508E83_524743595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_524743595;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.939 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "39103EBE97006AAAE4970F72FCB4C62B")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1399118977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1399118977 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1399118977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1399118977;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.940 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "DDC7D6E3121BE1052B023D13603A64BC")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1273476054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1273476054 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1273476054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1273476054;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.940 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "CEC03B5024E296E1C9701F56CB6C30EB")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_491409520 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_491409520 = null;
        varB4EAC82CA7396A68D541C85D26508E83_491409520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491409520;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.940 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "A933ED78BC10D9BC8277698DAC54816F")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1237731165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1237731165 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1237731165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1237731165;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.942 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "B039D9F2E5F0777D7EFB5B243FC9522B")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_854210255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854210255 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_854210255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854210255;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.942 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "F2D93526C651D06AA8669D4279362351")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_1297722539 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1297722539 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1297722539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297722539;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.942 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "B7F88C0B0B193F4A2ED5015085260DF8")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_249431223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_249431223 = null;
        varB4EAC82CA7396A68D541C85D26508E83_249431223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_249431223;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.949 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "E63A88CE1BD8B581CBFC87603C12A5B1")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1184919334 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1184919334 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1184919334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184919334;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.953 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "129268FF1DFFDF06BB5AFA60D8FEEFBD")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1790725985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1790725985 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1790725985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1790725985;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.953 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "EACAA8B9DF801A00A0897E7DDF4583C6")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1782900888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782900888 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1782900888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782900888;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.953 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "6D153685EC1A76F8259E0FBA23CE34F4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.954 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "8A9268A0FD3180946D6B695F260E89E4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.954 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "0DFCFA3601E2A0515241B0283FF66642")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.954 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "DC0BAAB09D7351EFC9DDD9DB87828606")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.971 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.971 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.972 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.972 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.972 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "13E994FCFC7946001D2B4AEDBCE4A374")
    public boolean getIccRecordsLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022658469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022658469;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.973 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "50A22E397CA78A0D04172E955368AC8B")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_794855481 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_794855481 = null;
        varB4EAC82CA7396A68D541C85D26508E83_794855481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794855481;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.973 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.973 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.973 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "D70D0855C7853683A027B152D06162C0")
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.979 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.979 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "C9F8D14931A4D7088B1CE18BE7613590")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.994 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "19C4A5329B71F92A665F281EBF3A1024")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.995 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "2EB2CA811B2158865B43308BF858AA7C")
    public List<DataConnection> getCurrentDataConnectionList() {
        List<DataConnection> varB4EAC82CA7396A68D541C85D26508E83_244222923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_244222923 = null;
        varB4EAC82CA7396A68D541C85D26508E83_244222923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_244222923;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.995 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    public void updateServiceLocation() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.995 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    public void enableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.995 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    public void disableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.995 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "02E46550EBEBBE847904DC3E118D5400")
    public boolean getDataRoamingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658623676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658623676;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.996 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "5388CC5174D0767861415AFF9F866AE3")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.996 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "9FA6C10690C804F113C912516C1BCC9B")
    public boolean enableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132718882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132718882;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.996 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "74C057CDDE5C78355821A083DFEE7279")
    public boolean disableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141655276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141655276;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.996 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "0BA6372191946D4667D44D76DDC1A2A7")
    public boolean isDataConnectivityPossible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655639180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655639180;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.997 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "FB9C64C5576085D0FA7A1ED449948113")
     boolean updateCurrentCarrierInProvider() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305595728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305595728;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.997 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "234D97846E2DB5B89AE8A0AA0A7F606D")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.997 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "20CA8A661B124D9B89AE30E92CDCE475")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_658954638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658954638 = null;
        varB4EAC82CA7396A68D541C85D26508E83_658954638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658954638;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.014 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "3F05AB7B99D952E0157135BC0DEA035C")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1920092762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1920092762 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1920092762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1920092762;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.015 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "796E7C404E5CCD7C1040DFFE8DADD376")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1085120591 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1085120591 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1085120591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1085120591;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.016 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "E6E1F5C98F6454163DCA0AED6EC4139E")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_2038586980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2038586980 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2038586980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2038586980;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.016 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "F7298357E8D61D3E78F455868A7175A3")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.016 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "D836FD94433820AC6D3BBDF7040F0EB9")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.016 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "C040BA038FB4F4C4760703542B649D2A")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.017 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "A0CA8F847DCEBD5AAA30E0188755D968")
    public boolean needsOtaServiceProvisioning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493406270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493406270;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.017 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "D5ABB70EBA092E62EB09CAE26DA1286B")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1561420798 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561420798 = null;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1561420798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561420798;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.031 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "BB7F1C10AC16D71AF7ADA446135AAF0E")
     void updatePhoneState() {
        State oldState;
        oldState = state;
        {
            boolean var472775C85B26E1907DB5673B1EE7AA42_936676753 = (getRingingCall().isRinging());
            {
                state = State.RINGING;
            } //End block
            {
                boolean var7B0CF12B5E1B30F05158DD1DD70DC516_793468459 = (getForegroundCall().isIdle()
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.031 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "71F7148CFC829A5A8E1F7DF4C5808550")

    private static String LOG_TAG = "SipPhone";
}

