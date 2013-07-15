package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.373 -0400", hash_original_field = "887ACB3EAA8ED60F5AC1B7488F7B5188", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.373 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.373 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "CDBDC9A800DEA3C071E799082068E40A")
    public  SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        addTaint(notifier.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract Call getForegroundCall();

    
    public abstract Call getBackgroundCall();

    
    public abstract Call getRingingCall();

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.375 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "4CD94164980E4A1A7269E47E84DF1FA5")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
Connection varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1848255774 =         dial(dialString);
        varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1848255774.addTaint(taint);
        return varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1848255774;
        // ---------- Original Method ----------
        //return dial(dialString);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.375 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "2E3ED63DA1A5AB5BC8F192FB476F9A99")
     void migrateFrom(SipPhoneBase from) {
        addTaint(from.getTaint());
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

    
        @DSModeled(DSC.SPEC)
    static void migrate(RegistrantList to, RegistrantList from) {
        from.removeCleared();
        for (int i = 0, n = from.size(); i < n; i++) {
            to.add((Registrant) from.get(i));
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.376 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "E69350012FF536E48FCB7D6FD9E5C271")
    @Override
    public void registerForRingbackTone(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mRingbackRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //mRingbackRegistrants.addUnique(h, what, obj);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.376 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "8C0AFAA28211303882650E10ED14E1CE")
    @Override
    public void unregisterForRingbackTone(Handler h) {
        addTaint(h.getTaint());
        mRingbackRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRingbackRegistrants.remove(h);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.376 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4539FAC9111879B3210C3FA868127F16")
    protected void startRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.377 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "F5BE77051721DFFE5031DF05054BCA73")
    protected void stopRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.377 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "4610E2C129AAD1699ABA52A2A30BF009")
    public ServiceState getServiceState() {
        ServiceState s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
ServiceState var0478718F0636FB61899C13801CE9FE09_2050161627 =         s;
        var0478718F0636FB61899C13801CE9FE09_2050161627.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_2050161627;
        // ---------- Original Method ----------
        //ServiceState s = new ServiceState();
        //s.setState(ServiceState.STATE_IN_SERVICE);
        //return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.377 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "213FA79056DFC4215CE2808540CDC1A9")
    public CellLocation getCellLocation() {
CellLocation var540C13E9E156B687226421B24F2DF178_176063814 =         null;
        var540C13E9E156B687226421B24F2DF178_176063814.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_176063814;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.377 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "455D493780F9B12D2F1875D023A24D89")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1784079591 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1784079591.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1784079591;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.378 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "47DB14EEBCB73926083D0CB3215183CC")
    public int getPhoneType() {
        int varF568790E2398D9017C4B1509F977AEF8_940905677 = (Phone.PHONE_TYPE_SIP);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365951372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365951372;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_SIP;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.378 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "11E491EF3282B8BCE847D62A734955EC")
    public SignalStrength getSignalStrength() {
SignalStrength var22DC4E9CDBD9412412839A52B916C09C_1313617382 =         new SignalStrength();
        var22DC4E9CDBD9412412839A52B916C09C_1313617382.addTaint(taint);
        return var22DC4E9CDBD9412412839A52B916C09C_1313617382;
        // ---------- Original Method ----------
        //return new SignalStrength();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.378 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "BB82EA7B7923BFB6AAD1369DEA23B66C")
    public boolean getMessageWaitingIndicator() {
        boolean var68934A3E9455FA72420237EB05902327_58939827 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112961044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112961044;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.378 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "6A1CFA8F3DB0394C79AB610C1C89022C")
    public boolean getCallForwardingIndicator() {
        boolean var68934A3E9455FA72420237EB05902327_1260144063 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137036845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137036845;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.379 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "AF49ACFD8B9BFBACA369F3D9C0EE2427")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> varD7278B2B1DA69DDE0B4ADC03307BD8EB_1264880563 =         new ArrayList<MmiCode>(0);
        varD7278B2B1DA69DDE0B4ADC03307BD8EB_1264880563.addTaint(taint);
        return varD7278B2B1DA69DDE0B4ADC03307BD8EB_1264880563;
        // ---------- Original Method ----------
        //return new ArrayList<MmiCode>(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.379 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "54A49039813E0D5DAFBE4354B8042264")
    public DataState getDataConnectionState() {
DataState varF4C8B07E77DF91A061E7D818139C2E10_2029481568 =         DataState.DISCONNECTED;
        varF4C8B07E77DF91A061E7D818139C2E10_2029481568.addTaint(taint);
        return varF4C8B07E77DF91A061E7D818139C2E10_2029481568;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.379 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "F2586B291F284ACA9D125893E861671C")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
DataState varF4C8B07E77DF91A061E7D818139C2E10_1035295011 =         DataState.DISCONNECTED;
        varF4C8B07E77DF91A061E7D818139C2E10_1035295011.addTaint(taint);
        return varF4C8B07E77DF91A061E7D818139C2E10_1035295011;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.379 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "1AF5B95A9E6A888BEC6907C9EBA84A7F")
    public DataActivityState getDataActivityState() {
DataActivityState varF51E2D329D60D36A08BBFD40C503477A_441998666 =         DataActivityState.NONE;
        varF51E2D329D60D36A08BBFD40C503477A_441998666.addTaint(taint);
        return varF51E2D329D60D36A08BBFD40C503477A_441998666;
        // ---------- Original Method ----------
        //return DataActivityState.NONE;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.380 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.380 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.380 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1834271AD9115788FB6995456D8952DC")
     void notifyNewRingingConnection(Connection c) {
        addTaint(c.getTaint());
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.380 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "C0967CF5B0AC71AC9086A2946F168D51")
     void notifyDisconnect(Connection cn) {
        addTaint(cn.getTaint());
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.380 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.381 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "D2A891901727494D8E369385B797C6BA")
     void notifySuppServiceFailed(SuppService code) {
        addTaint(code.getTaint());
        mSuppServiceFailedRegistrants.notifyResult(code);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.381 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "3C10FF86EDD5B27D27F8FAD326A596AF")
     void notifyServiceStateChanged(ServiceState ss) {
        addTaint(ss.getTaint());
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.381 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.382 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "BA57D9D11BF16AE6572D4B106CC41616")
    public boolean canDial() {
        int serviceState = getServiceState().getState();
    if(serviceState == ServiceState.STATE_POWER_OFF)        
        {
        boolean var68934A3E9455FA72420237EB05902327_347509131 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133555735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133555735;
        }
        String disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
    if(disableCall.equals("true"))        
        {
        boolean var68934A3E9455FA72420237EB05902327_408743227 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531781851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531781851;
        }
        boolean var04D7163281663FFF0EE7A99DC4A384C6_124991725 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997309616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997309616;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.382 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "B2D506B907167B4947E56C80645C922C")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1970365376 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705571508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705571508;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.382 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "1DA4130DB90491D9415B48A73BBEC75D")
     boolean isInCall() {
        Call.State foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState = getRingingCall().getState();
        boolean var3F84807FAEA3E7F9E7C7880BC9AD9D45_1835331783 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1099566281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1099566281;
        // ---------- Original Method ----------
        //Call.State foregroundCallState = getForegroundCall().getState();
        //Call.State backgroundCallState = getBackgroundCall().getState();
        //Call.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            //|| ringingCallState.isAlive());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.383 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "C8082ED2B5F26B719C80728433EF6676")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_507163285 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047081016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047081016;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.383 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "0E82E3280320EEE46382188B2A583AEA")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.383 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "E1D037B9B8300B37C6B7BEF6354E922E")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.383 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "F7B5A057E05A4D68894B34176419F52F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.384 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3325DDA12C43C65FA68D146972A2FB67")
    public void setRadioPower(boolean power) {
        addTaint(power);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.384 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "C366BA0378BCBD78967B760C2EC563BC")
    public String getVoiceMailNumber() {
String var540C13E9E156B687226421B24F2DF178_6203948 =         null;
        var540C13E9E156B687226421B24F2DF178_6203948.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_6203948;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.384 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "537A59F206EC6CC55DF1520D3AFB0566")
    public String getVoiceMailAlphaTag() {
String var540C13E9E156B687226421B24F2DF178_1461301507 =         null;
        var540C13E9E156B687226421B24F2DF178_1461301507.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1461301507;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.384 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "B0BB9EE6A35A2A44893E57EDF6B3AB35")
    public String getDeviceId() {
String var540C13E9E156B687226421B24F2DF178_1146039648 =         null;
        var540C13E9E156B687226421B24F2DF178_1146039648.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1146039648;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "707FA1428078104440125E22B7F2504A")
    public String getDeviceSvn() {
String var540C13E9E156B687226421B24F2DF178_1155981526 =         null;
        var540C13E9E156B687226421B24F2DF178_1155981526.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1155981526;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "F5091451E74F12F73CB3A544BFB30E7A")
    public String getImei() {
String var540C13E9E156B687226421B24F2DF178_1258726397 =         null;
        var540C13E9E156B687226421B24F2DF178_1258726397.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1258726397;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "A2E9DA1E0B8B0542FB14289437A04A8D")
    public String getEsn() {
String var50F9DEEC38DD489662C457BCE7AD28CE_709185837 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_709185837.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_709185837;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "D3EDCEA2F6EC773F6FBE4C548CD7A705")
    public String getMeid() {
String var50F9DEEC38DD489662C457BCE7AD28CE_1761166669 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_1761166669.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_1761166669;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "5F47106C8887DC0BD73562A113F9B2FB")
    public String getSubscriberId() {
String var540C13E9E156B687226421B24F2DF178_1085547436 =         null;
        var540C13E9E156B687226421B24F2DF178_1085547436.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1085547436;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.385 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "50A2A295FEDCCE1F7A99A03B5700A7D7")
    public String getIccSerialNumber() {
String var540C13E9E156B687226421B24F2DF178_446076274 =         null;
        var540C13E9E156B687226421B24F2DF178_446076274.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_446076274;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.386 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "6281209609E399F543A7B22570528CE2")
    public String getLine1Number() {
String var540C13E9E156B687226421B24F2DF178_1940262557 =         null;
        var540C13E9E156B687226421B24F2DF178_1940262557.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1940262557;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.386 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "1B48CFB1BF6385B0999FD683EC05235C")
    public String getLine1AlphaTag() {
String var540C13E9E156B687226421B24F2DF178_1873104329 =         null;
        var540C13E9E156B687226421B24F2DF178_1873104329.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1873104329;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.386 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "261C18DD9CFDE34402FD68944DA70E00")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.386 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "D2D2A1DBE6EF3DEF94A5DC3B8F85F318")
    public void setVoiceMailNumber(String alphaTag, String voiceMailNumber,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(voiceMailNumber.getTaint());
        addTaint(alphaTag.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.387 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "797DD69E68B0E8D689CB8D3E71D99547")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.387 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "B75D5A54800077CAF619C7DF5D6264FC")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason, String dialingNumber,
            int timerSeconds, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(timerSeconds);
        addTaint(dialingNumber.getTaint());
        addTaint(commandInterfaceCFReason);
        addTaint(commandInterfaceCFAction);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.387 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "A36A3C126730691AFCF80FCF79707CB2")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.388 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "0B5325FCB4DFB9A95BD43EF313C418F9")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCLIRMode);
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.388 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "6ED5C276E9CEE48168724CCC607FBBB3")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.388 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "EFB13488907DFB7E9B7AC218EB76AF66")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.388 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "DC898638C0D81E647E93AEAD1B04D7B7")
    public boolean getIccRecordsLoaded() {
        boolean var68934A3E9455FA72420237EB05902327_1262060582 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242371336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242371336;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.389 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "E938CC412C0086A26062C51E55C3DC72")
    public IccCard getIccCard() {
IccCard var540C13E9E156B687226421B24F2DF178_1741878963 =         null;
        var540C13E9E156B687226421B24F2DF178_1741878963.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1741878963;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.389 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.389 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.389 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "CEB467D58246AB825B7A34D7BBFBE069")
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.390 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.390 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "0081A8178CA4C015EBE62F24427083D2")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.390 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "19C4A5329B71F92A665F281EBF3A1024")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.390 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "69248DEAAFA50474B775F04D97084F21")
    public List<DataConnection> getCurrentDataConnectionList() {
List<DataConnection> var540C13E9E156B687226421B24F2DF178_1372727813 =         null;
        var540C13E9E156B687226421B24F2DF178_1372727813.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1372727813;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.391 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    public void updateServiceLocation() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.391 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    public void enableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.391 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    public void disableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.391 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "62FFCD491D93CB60BD73C680F5B1D5B0")
    public boolean getDataRoamingEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_206111067 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226178388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226178388;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.392 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "5388CC5174D0767861415AFF9F866AE3")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.392 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "17A211375F43229E9621328E2DEF047F")
    public boolean enableDataConnectivity() {
        boolean var68934A3E9455FA72420237EB05902327_1114648003 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774333685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774333685;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.392 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "4679F926F5D0A34F08869A4DBCD41AEF")
    public boolean disableDataConnectivity() {
        boolean var68934A3E9455FA72420237EB05902327_850885172 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862420407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862420407;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.392 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "D508E2A63ADB8BBF2113F4B02540F93F")
    public boolean isDataConnectivityPossible() {
        boolean var68934A3E9455FA72420237EB05902327_1940801934 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565571802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565571802;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.393 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "852B85BF9DCAE21C60D097679C692C13")
     boolean updateCurrentCarrierInProvider() {
        boolean var68934A3E9455FA72420237EB05902327_81240299 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063203017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063203017;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.393 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "234D97846E2DB5B89AE8A0AA0A7F606D")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.393 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "752E9B674C3C87915B7FA8A06EF1549A")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo var540C13E9E156B687226421B24F2DF178_632714140 =         null;
        var540C13E9E156B687226421B24F2DF178_632714140.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_632714140;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.393 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "7CD8D1FA05039E6E30B74AAB903FFBBD")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager var540C13E9E156B687226421B24F2DF178_1553404691 =         null;
        var540C13E9E156B687226421B24F2DF178_1553404691.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1553404691;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.393 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "6A91184A16979811469A8055BCA127CC")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var540C13E9E156B687226421B24F2DF178_695687832 =         null;
        var540C13E9E156B687226421B24F2DF178_695687832.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_695687832;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.394 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "6EA812975D42D2BB06ADF56C701ED27E")
    public IccFileHandler getIccFileHandler() {
IccFileHandler var540C13E9E156B687226421B24F2DF178_104629144 =         null;
        var540C13E9E156B687226421B24F2DF178_104629144.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_104629144;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.394 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "82419EE04970CC9DDD1C55541902677D")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.394 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "D836FD94433820AC6D3BBDF7040F0EB9")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.395 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "CA698F653324602105118AE6ECC0E893")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.395 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "9ED2604B45C10A1F84410E06B2673003")
    public boolean needsOtaServiceProvisioning() {
        boolean var68934A3E9455FA72420237EB05902327_1330871604 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567409850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567409850;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.395 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "C5C704B8A5DE5FD36C02683C0B275E81")
    public LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
LinkProperties var540C13E9E156B687226421B24F2DF178_113914469 =         null;
        var540C13E9E156B687226421B24F2DF178_113914469.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_113914469;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.396 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "543B2FB23EA614A042135EBBF0EE1B12")
     void updatePhoneState() {
        State oldState = state;
    if(getRingingCall().isRinging())        
        {
            state = State.RINGING;
        } //End block
        else
    if(getForegroundCall().isIdle()
                && getBackgroundCall().isIdle())        
        {
            state = State.IDLE;
        } //End block
        else
        {
            state = State.OFFHOOK;
        } //End block
    if(state != oldState)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.396 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
}

