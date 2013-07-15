package com.android.internal.telephony.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.360 -0400", hash_original_field = "887ACB3EAA8ED60F5AC1B7488F7B5188", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.360 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.361 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "2219DFDCD45EF4951BDF53AE7EA06349")
    public  SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        addTaint(context.getTaint());
        addTaint(notifier.getTaint());
        
    }

    
    public abstract Call getForegroundCall();

    
    public abstract Call getBackgroundCall();

    
    public abstract Call getRingingCall();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.362 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "A507D55175234862D7B2A08273C1D39C")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1099372221 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1099372221 = dial(dialString);
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1099372221.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1099372221;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.362 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "E596EBFCAA9358EAB55A52054AB47B3A")
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
        
        
        
        
        
        
        
        
        
        
        
    }

    
    static void migrate(RegistrantList to, RegistrantList from) {
        from.removeCleared();
        for (int i = 0, n = from.size(); i < n; i++) {
            to.add((Registrant) from.get(i));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.363 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "D3087F32116A58DD951D09CC259A1BB4")
    @Override
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        
        mRingbackRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.363 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "CA6050A415157F95762B505637B2267A")
    @Override
    public void unregisterForRingbackTone(Handler h) {
        mRingbackRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.364 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4539FAC9111879B3210C3FA868127F16")
    protected void startRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.364 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "F5BE77051721DFFE5031DF05054BCA73")
    protected void stopRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.365 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "7C3B5C9A3B5FF112E3E8A1F088E6935C")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_2089472970 = null; 
        ServiceState s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
        varB4EAC82CA7396A68D541C85D26508E83_2089472970 = s;
        varB4EAC82CA7396A68D541C85D26508E83_2089472970.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2089472970;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.367 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "AF7C3125F68AA064C2F3AB379345F3AF")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_339165204 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_339165204 = null;
        varB4EAC82CA7396A68D541C85D26508E83_339165204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_339165204;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.369 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "DC48C28F99D0DC9ED04FC19F08620CCA")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1122051522 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1122051522 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1122051522.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1122051522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.369 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "5997531833241ED4CC2B678E3C9942CF")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658989358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658989358;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.371 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "17C7CC09F093EA22E4CFE577B7C0026E")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_2032608892 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2032608892 = new SignalStrength();
        varB4EAC82CA7396A68D541C85D26508E83_2032608892.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2032608892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.371 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "06C58FB3C70CDDC4D4C26DBEC8FF6A0D")
    public boolean getMessageWaitingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372805183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372805183;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.371 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "F7CE3F30C6E5A321CCEAD23E9574AC23")
    public boolean getCallForwardingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901373640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901373640;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.372 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "78996A0A975284F39EDE178CF9E49135")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1819277957 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1819277957 = new ArrayList<MmiCode>(0);
        varB4EAC82CA7396A68D541C85D26508E83_1819277957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1819277957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.373 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "E043C271606CFF4996D920CD40E3808C")
    public DataState getDataConnectionState() {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1095321771 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1095321771 = DataState.DISCONNECTED;
        varB4EAC82CA7396A68D541C85D26508E83_1095321771.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1095321771;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.373 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "1CBF1323B1E0AB371729BB5587758A92")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_2021024909 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2021024909 = DataState.DISCONNECTED;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2021024909.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2021024909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.374 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "E112FB0F361C5C7A4B06A378AA42E9FB")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_1090638851 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1090638851 = DataActivityState.NONE;
        varB4EAC82CA7396A68D541C85D26508E83_1090638851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1090638851;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.374 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.374 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.375 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.375 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.376 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.376 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "0D459839BFD4CE2D513A693B187FDF40")
     void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
        addTaint(code.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.377 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.377 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.378 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "3715C7DF25AF22247E306E3A453FC722")
    public boolean canDial() {
        int serviceState = getServiceState().getState();
        String disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        {
            boolean varFEFC6EDC1CD0A4C14CFA3F2D7E738459_20595280 = (disableCall.equals("true"));
        } 
        boolean var6FEF584C7F9466D000AEC52C614E1712_275655850 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986107393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986107393;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.378 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "C6BA48DAF62FCA909EC08173C610F09B")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161803728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161803728;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.379 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "AC2FA02D3EED9E90D745CA039B1E63C7")
     boolean isInCall() {
        Call.State foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState = getRingingCall().getState();
        boolean varD5A00343D4B764A393A8E790D3007C99_2024679898 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065949795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065949795;
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.379 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "78F305AC73DF358B329E16898733141F")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948808806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_948808806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.379 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "0E82E3280320EEE46382188B2A583AEA")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.380 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "FC12D40C72BA4A183C0B5D48AE76566B")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.380 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "F7B5A057E05A4D68894B34176419F52F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.380 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3325DDA12C43C65FA68D146972A2FB67")
    public void setRadioPower(boolean power) {
        addTaint(power);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.381 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "5E1D4DC7297E4DD5F4FEA85470190E9D")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_501329207 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_501329207 = null;
        varB4EAC82CA7396A68D541C85D26508E83_501329207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_501329207;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.381 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "7A23CA0426DCC004ADA5584C50E1AB17")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_988621367 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_988621367 = null;
        varB4EAC82CA7396A68D541C85D26508E83_988621367.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_988621367;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.381 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "F3665304C16ED91D6B948D2C2961AD90")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1270532142 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1270532142 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1270532142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1270532142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.382 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "6FA888CEABA87530F90B0DB25D86D45F")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1459945478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1459945478 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1459945478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1459945478;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.382 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "C5E38EBFEFD75E0353806FC447C6B6B7")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1794964933 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1794964933 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1794964933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1794964933;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.383 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "CCC773217F8743E74F5807F037F0C9F1")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1372179690 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1372179690 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1372179690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1372179690;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.383 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "EE6681301E90569BFB1BF6D6BD7F7FCE")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_179547831 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_179547831 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_179547831.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_179547831;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.384 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "9C7DA93CD6A523E5FBBF98D683964F37")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_737223990 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_737223990 = null;
        varB4EAC82CA7396A68D541C85D26508E83_737223990.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_737223990;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.384 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "972843AC835A53159A9E1126F7E1F4FA")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_2054249449 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2054249449 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2054249449.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2054249449;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.385 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "FAFF44654301ED82ACA0437923FEF21D")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1647164057 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1647164057 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1647164057.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1647164057;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.385 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "F16E4251945C7BE14555B7F05D0A5EF7")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1556348537 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1556348537 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1556348537.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1556348537;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.385 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "6D153685EC1A76F8259E0FBA23CE34F4")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.386 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "8A9268A0FD3180946D6B695F260E89E4")
    public void setVoiceMailNumber(String alphaTag, String voiceMailNumber,
            Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(alphaTag.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.386 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "0DFCFA3601E2A0515241B0283FF66642")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.386 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "DC0BAAB09D7351EFC9DDD9DB87828606")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason, String dialingNumber,
            int timerSeconds, Message onComplete) {
        addTaint(commandInterfaceCFAction);
        addTaint(commandInterfaceCFReason);
        addTaint(dialingNumber.getTaint());
        addTaint(timerSeconds);
        addTaint(onComplete.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.386 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "C77A6C0124D697FB86089997222C4675")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.387 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "2C0642AA3E03137941721F3C03DDB4F0")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.387 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "70097558DD3E9A395DC3205B46BB4114")
    public void getCallWaiting(Message onComplete) {
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        addTaint(onComplete.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.387 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "09886D350A4FBA76C7FD0C69B3160FBC")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.387 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "9D4FC1B73CB5C7C54FB0E2D0D5F44BB0")
    public boolean getIccRecordsLoaded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659154468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659154468;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.388 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "DED451FBD425CE7FC6B01BB5BADBBA7C")
    public IccCard getIccCard() {
        IccCard varB4EAC82CA7396A68D541C85D26508E83_546202649 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_546202649 = null;
        varB4EAC82CA7396A68D541C85D26508E83_546202649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_546202649;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.388 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.388 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.388 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "D70D0855C7853683A027B152D06162C0")
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.389 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.389 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "C9F8D14931A4D7088B1CE18BE7613590")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.389 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "19C4A5329B71F92A665F281EBF3A1024")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.389 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "97090A2199C63B94AE595B5D298AE647")
    public List<DataConnection> getCurrentDataConnectionList() {
        List<DataConnection> varB4EAC82CA7396A68D541C85D26508E83_2141146865 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2141146865 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2141146865.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2141146865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.390 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    public void updateServiceLocation() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.390 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    public void enableLocationUpdates() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.390 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    public void disableLocationUpdates() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.390 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "3854339CEBE918656A085A036E9872E2")
    public boolean getDataRoamingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822172579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822172579;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.391 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "5388CC5174D0767861415AFF9F866AE3")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.391 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "3AE0CA609E32A9539A255E895F537D4F")
    public boolean enableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644792529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644792529;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.392 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "8C063D41050635C4562BA438DBEF6A27")
    public boolean disableDataConnectivity() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887383215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887383215;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.392 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "B5AEE04150840C596C8BE84C0CB84E06")
    public boolean isDataConnectivityPossible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923123394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923123394;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.392 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "A830C68176AF49C2915ADA927E290191")
     boolean updateCurrentCarrierInProvider() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681482036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681482036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.393 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "234D97846E2DB5B89AE8A0AA0A7F606D")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.393 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "DAEFCE25BAB679DBA8E0033424EB44CF")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_300123373 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_300123373 = null;
        varB4EAC82CA7396A68D541C85D26508E83_300123373.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_300123373;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.394 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "7067E1AE7FD8589C3884E3A4A2A56810")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_505080913 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_505080913 = null;
        varB4EAC82CA7396A68D541C85D26508E83_505080913.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_505080913;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.395 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "A6EC53283E07D498CCEFBA2B2C0B8A44")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1014691376 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1014691376 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1014691376.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1014691376;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.395 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "D67231CC7D6FA41BAA2B8837EE41BCC9")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_466112469 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_466112469 = null;
        varB4EAC82CA7396A68D541C85D26508E83_466112469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_466112469;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.395 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "F7298357E8D61D3E78F455868A7175A3")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(activate);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.396 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "D836FD94433820AC6D3BBDF7040F0EB9")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.396 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "C040BA038FB4F4C4760703542B649D2A")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.396 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "2B1C4174477ADC18DFF2E0321A33D81A")
    public boolean needsOtaServiceProvisioning() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128811438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128811438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.396 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "AF4EE66A9397B53E233A6EE389D5ED4C")
    public LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1051206435 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1051206435 = null;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1051206435.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051206435;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.397 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "8F43F44AD48244C3138B9C0BE9C1FB8E")
     void updatePhoneState() {
        State oldState = state;
        {
            boolean var472775C85B26E1907DB5673B1EE7AA42_1321628997 = (getRingingCall().isRinging());
            {
                state = State.RINGING;
            } 
            {
                boolean var7B0CF12B5E1B30F05158DD1DD70DC516_466670439 = (getForegroundCall().isIdle()
                && getBackgroundCall().isIdle());
                {
                    state = State.IDLE;
                } 
                {
                    state = State.OFFHOOK;
                } 
            } 
        } 
        {
            Log.d(LOG_TAG, " ^^^ new phone state: " + state);
            notifyPhoneStateChanged();
        } 
        
        
        
            
        
                
            
        
            
        
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.397 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
}

