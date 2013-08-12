package com.android.internal.telephony.sip;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.375 -0400", hash_original_field = "887ACB3EAA8ED60F5AC1B7488F7B5188", hash_generated_field = "06D1F76E7074A960DC898B74320CA0F3")

    private RegistrantList mRingbackRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.375 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "5DA87F87641C402C829DF297ABF4F811")

    private State state = State.IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.375 -0400", hash_original_method = "FA4D90BB4122B02943EC91BF5E05BD9E", hash_generated_method = "CDBDC9A800DEA3C071E799082068E40A")
    public  SipPhoneBase(Context context, PhoneNotifier notifier) {
        super(notifier, context, new SipCommandInterface(context), false);
        addTaint(notifier.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Call getForegroundCall();

    
    @DSModeled(DSC.SAFE)
    public abstract Call getBackgroundCall();

    
    @DSModeled(DSC.SAFE)
    public abstract Call getRingingCall();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.376 -0400", hash_original_method = "17D3E0C068D84F4DB7E1D7ED343AE432", hash_generated_method = "5A2C0AD273D72BC2162D99CAA16C1B6D")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
Connection varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1324101926 =         dial(dialString);
        varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1324101926.addTaint(taint);
        return varCF6DE2A854D55FF4BBFA80C5AEE7DC08_1324101926;
        // ---------- Original Method ----------
        //return dial(dialString);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.376 -0400", hash_original_method = "36F486554819D3516784DFAE37ACA733", hash_generated_method = "2E3ED63DA1A5AB5BC8F192FB476F9A99")
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

    
    @DSModeled(DSC.SAFE)
    static void migrate(RegistrantList to, RegistrantList from) {
        from.removeCleared();
        for (int i = 0, n = from.size(); i < n; i++) {
            to.add((Registrant) from.get(i));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.377 -0400", hash_original_method = "A462DF8F9BADFDEAC0F7512D6A88E267", hash_generated_method = "E69350012FF536E48FCB7D6FD9E5C271")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.377 -0400", hash_original_method = "DCE1DDCF75E34486A85C49B95D229240", hash_generated_method = "8C0AFAA28211303882650E10ED14E1CE")
    @Override
    public void unregisterForRingbackTone(Handler h) {
        addTaint(h.getTaint());
        mRingbackRegistrants.remove(h);
        // ---------- Original Method ----------
        //mRingbackRegistrants.remove(h);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.378 -0400", hash_original_method = "AF4E2BB5D42F69166E8A415E4BF0E6F4", hash_generated_method = "4539FAC9111879B3210C3FA868127F16")
    protected void startRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.TRUE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.378 -0400", hash_original_method = "8F71479C7943295B833E91C6F37D36ED", hash_generated_method = "F5BE77051721DFFE5031DF05054BCA73")
    protected void stopRingbackTone() {
        AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        mRingbackRegistrants.notifyRegistrants(result);
        // ---------- Original Method ----------
        //AsyncResult result = new AsyncResult(null, Boolean.FALSE, null);
        //mRingbackRegistrants.notifyRegistrants(result);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.379 -0400", hash_original_method = "55AF48A1589EA41698674B955CFD9D76", hash_generated_method = "C6B03377675A087A6D18F81509F4383C")
    public ServiceState getServiceState() {
        ServiceState s = new ServiceState();
        s.setState(ServiceState.STATE_IN_SERVICE);
ServiceState var0478718F0636FB61899C13801CE9FE09_1298520786 =         s;
        var0478718F0636FB61899C13801CE9FE09_1298520786.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1298520786;
        // ---------- Original Method ----------
        //ServiceState s = new ServiceState();
        //s.setState(ServiceState.STATE_IN_SERVICE);
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.379 -0400", hash_original_method = "C91EF993CFF3E980A5E5083D47787FE2", hash_generated_method = "9441B39755C4B86F029E6794616F2C9B")
    public CellLocation getCellLocation() {
CellLocation var540C13E9E156B687226421B24F2DF178_166489077 =         null;
        var540C13E9E156B687226421B24F2DF178_166489077.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_166489077;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.379 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "623301D5702E90626F81BCA014EC8412")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1950010014 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1950010014.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1950010014;
        // ---------- Original Method ----------
        //return state;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.380 -0400", hash_original_method = "D156A16780F70B18E54D7E31D2F4A731", hash_generated_method = "9F706EA2D8C1FB022ADADF4383193205")
    public int getPhoneType() {
        int varF568790E2398D9017C4B1509F977AEF8_1878437447 = (Phone.PHONE_TYPE_SIP);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133080773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133080773;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.380 -0400", hash_original_method = "17F02D10154FAED3700CC39E151297FB", hash_generated_method = "BC23BA2DA9D129EFD523B9DE094635E6")
    public SignalStrength getSignalStrength() {
SignalStrength var22DC4E9CDBD9412412839A52B916C09C_493158201 =         new SignalStrength();
        var22DC4E9CDBD9412412839A52B916C09C_493158201.addTaint(taint);
        return var22DC4E9CDBD9412412839A52B916C09C_493158201;
        // ---------- Original Method ----------
        //return new SignalStrength();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.380 -0400", hash_original_method = "332EA67793D49A8F39F395B80A31DE07", hash_generated_method = "B384464A92BC33E982EF19D8696137E6")
    public boolean getMessageWaitingIndicator() {
        boolean var68934A3E9455FA72420237EB05902327_1795722571 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148416696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148416696;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.381 -0400", hash_original_method = "782A19718CB82C89C99C92A22851D5F3", hash_generated_method = "C81BA84C9C07B3B99737887235531209")
    public boolean getCallForwardingIndicator() {
        boolean var68934A3E9455FA72420237EB05902327_1899695231 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750000889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750000889;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.381 -0400", hash_original_method = "30CC65A7EA33D226213D83007BB97BDE", hash_generated_method = "B12AAAC69C857E393815AA3E3CCFEF13")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> varD7278B2B1DA69DDE0B4ADC03307BD8EB_1388491303 =         new ArrayList<MmiCode>(0);
        varD7278B2B1DA69DDE0B4ADC03307BD8EB_1388491303.addTaint(taint);
        return varD7278B2B1DA69DDE0B4ADC03307BD8EB_1388491303;
        // ---------- Original Method ----------
        //return new ArrayList<MmiCode>(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.381 -0400", hash_original_method = "0F892B00FA6A5B20BECAADA8E432F7C8", hash_generated_method = "C4D2DC707578128A43948D768B36BD16")
    public DataState getDataConnectionState() {
DataState varF4C8B07E77DF91A061E7D818139C2E10_677317061 =         DataState.DISCONNECTED;
        varF4C8B07E77DF91A061E7D818139C2E10_677317061.addTaint(taint);
        return varF4C8B07E77DF91A061E7D818139C2E10_677317061;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.382 -0400", hash_original_method = "82D10B1571239AFF33F8F34F4897802A", hash_generated_method = "F2E31224934B3582FE7CAB0ECFCE05B8")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
DataState varF4C8B07E77DF91A061E7D818139C2E10_1927809518 =         DataState.DISCONNECTED;
        varF4C8B07E77DF91A061E7D818139C2E10_1927809518.addTaint(taint);
        return varF4C8B07E77DF91A061E7D818139C2E10_1927809518;
        // ---------- Original Method ----------
        //return DataState.DISCONNECTED;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.382 -0400", hash_original_method = "EEB8511A7AB7307508BCD88B52DF7E31", hash_generated_method = "33D7C07356F184AB3831C093BA323B58")
    public DataActivityState getDataActivityState() {
DataActivityState varF51E2D329D60D36A08BBFD40C503477A_1735134218 =         DataActivityState.NONE;
        varF51E2D329D60D36A08BBFD40C503477A_1735134218.addTaint(taint);
        return varF51E2D329D60D36A08BBFD40C503477A_1735134218;
        // ---------- Original Method ----------
        //return DataActivityState.NONE;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.382 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.383 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.383 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1834271AD9115788FB6995456D8952DC")
     void notifyNewRingingConnection(Connection c) {
        addTaint(c.getTaint());
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.383 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "C0967CF5B0AC71AC9086A2946F168D51")
     void notifyDisconnect(Connection cn) {
        addTaint(cn.getTaint());
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.383 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.384 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "D2A891901727494D8E369385B797C6BA")
     void notifySuppServiceFailed(SuppService code) {
        addTaint(code.getTaint());
        mSuppServiceFailedRegistrants.notifyResult(code);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.384 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "3C10FF86EDD5B27D27F8FAD326A596AF")
     void notifyServiceStateChanged(ServiceState ss) {
        addTaint(ss.getTaint());
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.384 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.385 -0400", hash_original_method = "4A0C3356C889DFBC581CC011E95718EA", hash_generated_method = "AAFF0D977C437D9D80751D7EBB8A0434")
    public boolean canDial() {
        int serviceState = getServiceState().getState();
        if(serviceState == ServiceState.STATE_POWER_OFF)        
        {
        boolean var68934A3E9455FA72420237EB05902327_724887014 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653230185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653230185;
        }
        String disableCall = SystemProperties.get(
                TelephonyProperties.PROPERTY_DISABLE_CALL, "false");
        if(disableCall.equals("true"))        
        {
        boolean var68934A3E9455FA72420237EB05902327_834503246 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241086039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241086039;
        }
        boolean var04D7163281663FFF0EE7A99DC4A384C6_1746541247 = (!getRingingCall().isRinging()
                && (!getForegroundCall().getState().isAlive()
                    || !getBackgroundCall().getState().isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495094098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495094098;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.386 -0400", hash_original_method = "AD21B61A3B2BD5EA1D1607592E76FC09", hash_generated_method = "32E88766F9ABE13578F241C8CA244DF9")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1564814873 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101235766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101235766;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.387 -0400", hash_original_method = "2A1F26DA67C6AD58471FCD8E9D9C481A", hash_generated_method = "8F1CEA7101713FEC86376E47E9324599")
     boolean isInCall() {
        Call.State foregroundCallState = getForegroundCall().getState();
        Call.State backgroundCallState = getBackgroundCall().getState();
        Call.State ringingCallState = getRingingCall().getState();
        boolean var3F84807FAEA3E7F9E7C7880BC9AD9D45_2016318077 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive()
            || ringingCallState.isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003208206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003208206;
        // ---------- Original Method ----------
        //Call.State foregroundCallState = getForegroundCall().getState();
        //Call.State backgroundCallState = getBackgroundCall().getState();
        //Call.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive()
            //|| ringingCallState.isAlive());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.387 -0400", hash_original_method = "0E5C04DF5C1FBCC1441C38B04202BEC5", hash_generated_method = "F7ED5958B7ECD51676FA686C02949347")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1381840141 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653892997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653892997;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.388 -0400", hash_original_method = "B280D27D3796215AB318AF69FF45963B", hash_generated_method = "0E82E3280320EEE46382188B2A583AEA")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.388 -0400", hash_original_method = "5655DD58A9DF1FD4E03BA723869217B5", hash_generated_method = "E1D037B9B8300B37C6B7BEF6354E922E")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.389 -0400", hash_original_method = "9DA9E14B4FBAF78A158AD0B6D1F89071", hash_generated_method = "F7B5A057E05A4D68894B34176419F52F")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.389 -0400", hash_original_method = "9D0C0D8BE9BABAF1D8DDD00147E9B8A0", hash_generated_method = "3325DDA12C43C65FA68D146972A2FB67")
    public void setRadioPower(boolean power) {
        addTaint(power);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.389 -0400", hash_original_method = "5B36EC3545EA7D9B6D580B9CA25FD98C", hash_generated_method = "78842FFC315420386659AE5B039D9994")
    public String getVoiceMailNumber() {
String var540C13E9E156B687226421B24F2DF178_415926790 =         null;
        var540C13E9E156B687226421B24F2DF178_415926790.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_415926790;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.389 -0400", hash_original_method = "5CB47C1B0C4CAD738C12EF7E7C4FF126", hash_generated_method = "10ECB18FACD585CEA526C7CBDEC628E7")
    public String getVoiceMailAlphaTag() {
String var540C13E9E156B687226421B24F2DF178_208048058 =         null;
        var540C13E9E156B687226421B24F2DF178_208048058.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_208048058;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.389 -0400", hash_original_method = "8F5D46AA6CE6A507D46D45F56FAFD011", hash_generated_method = "4F435C8171262134444BFDD7837B6DE3")
    public String getDeviceId() {
String var540C13E9E156B687226421B24F2DF178_791639998 =         null;
        var540C13E9E156B687226421B24F2DF178_791639998.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_791639998;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "BD6A647949BDC26954FD7A78B410A165", hash_generated_method = "D23646A781AEE0111C667A172CC7A403")
    public String getDeviceSvn() {
String var540C13E9E156B687226421B24F2DF178_1318493836 =         null;
        var540C13E9E156B687226421B24F2DF178_1318493836.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1318493836;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "68C1ACAFE7C37B5C0545508E507F3DEE", hash_generated_method = "386820E37FD523F9F6AD7B1841A17698")
    public String getImei() {
String var540C13E9E156B687226421B24F2DF178_1390757260 =         null;
        var540C13E9E156B687226421B24F2DF178_1390757260.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1390757260;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "066F3BEEA663C8F40314596ACA31DE8A", hash_generated_method = "CB775C450109769DE3820B9FF0FD30A8")
    public String getEsn() {
String var50F9DEEC38DD489662C457BCE7AD28CE_447268083 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_447268083.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_447268083;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "F01DF3253612CC9AB1E7B6B052F89D9E", hash_generated_method = "13E6E38A124FED6094980105476994F3")
    public String getMeid() {
String var50F9DEEC38DD489662C457BCE7AD28CE_1028119120 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_1028119120.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_1028119120;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SipPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "73B16FD7D870CD30970A04ADEBAD50EE", hash_generated_method = "31D6C79FF83AA0A92AD580B077039DBF")
    public String getSubscriberId() {
String var540C13E9E156B687226421B24F2DF178_918345069 =         null;
        var540C13E9E156B687226421B24F2DF178_918345069.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_918345069;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "12198439B6CEAB4301B79A5259D1390B", hash_generated_method = "250215204C443F0CB62E947627A4ECCB")
    public String getIccSerialNumber() {
String var540C13E9E156B687226421B24F2DF178_75476445 =         null;
        var540C13E9E156B687226421B24F2DF178_75476445.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_75476445;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "7D0BF3EB57A409FDD3185CD55F336518", hash_generated_method = "DEDA6732B8DABD341C45A12AFBDD1675")
    public String getLine1Number() {
String var540C13E9E156B687226421B24F2DF178_1353803219 =         null;
        var540C13E9E156B687226421B24F2DF178_1353803219.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1353803219;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "01896056554D538EFB47B84E1123E5B1", hash_generated_method = "7597C2975984B30E294461F6B1F1AF47")
    public String getLine1AlphaTag() {
String var540C13E9E156B687226421B24F2DF178_473490874 =         null;
        var540C13E9E156B687226421B24F2DF178_473490874.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_473490874;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "42B4B37693EAAD827C7D316E55B2CE6C", hash_generated_method = "261C18DD9CFDE34402FD68944DA70E00")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "7E4A81F94959E23DEADDA359CB855716", hash_generated_method = "D2D2A1DBE6EF3DEF94A5DC3B8F85F318")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.390 -0400", hash_original_method = "66256E1852F019E47C97B93A992ABB2C", hash_generated_method = "797DD69E68B0E8D689CB8D3E71D99547")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "F46C9631F861B0FCDE0E6FCDDDABC58E", hash_generated_method = "B75D5A54800077CAF619C7DF5D6264FC")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "0D09CB6308056457AD1772B2CC5B82FC", hash_generated_method = "A36A3C126730691AFCF80FCF79707CB2")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "56612EF91DCB9A3808F62E57BF0F81E1", hash_generated_method = "0B5325FCB4DFB9A95BD43EF313C418F9")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "14E36FB03F40D4635F36E46C38B086BD", hash_generated_method = "6ED5C276E9CEE48168724CCC607FBBB3")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        AsyncResult.forMessage(onComplete, null, null);
        onComplete.sendToTarget();
        // ---------- Original Method ----------
        //AsyncResult.forMessage(onComplete, null, null);
        //onComplete.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "80F9B6F2C3F4CA6200C97C4377273E17", hash_generated_method = "EFB13488907DFB7E9B7AC218EB76AF66")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "call waiting not supported");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "27BD0473BFC5D98F668462A42EC01A2F", hash_generated_method = "C74164C9EF6CCF173DB9B3030D669A1E")
    public boolean getIccRecordsLoaded() {
        boolean var68934A3E9455FA72420237EB05902327_1576950333 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788558339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_788558339;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "C16BAA9E30FD06D2E3848915A1670617", hash_generated_method = "B53FCBE6853C19F3502FF6980E971AC1")
    public IccCard getIccCard() {
IccCard var540C13E9E156B687226421B24F2DF178_1654792406 =         null;
        var540C13E9E156B687226421B24F2DF178_1654792406.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1654792406;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.391 -0400", hash_original_method = "F3D2B6350F8E1C278AFA7ECA9187C8D7", hash_generated_method = "8DE8805B27756ABC38F4FA4C3F7580C2")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "958A118B1D6DEAAC3F2CD7A0471E8E5A", hash_generated_method = "7A56B99868460FC0089A1CFE78EAEABC")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "7ACE1B8AEA90F1CDB1FDECFA2DA5C6BD", hash_generated_method = "CEB467D58246AB825B7A34D7BBFBE069")
    public void selectNetworkManually(
            OperatorInfo network,
            Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "1E1F359D4473F2441E02E8FE890DEF1C", hash_generated_method = "803A54BA31E9F8CEE7211DF5B414A74F")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "D72E95BA671FD1DF5E112C634C709C22", hash_generated_method = "0081A8178CA4C015EBE62F24427083D2")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "01526CFA42A67B736429D6885814543E", hash_generated_method = "19C4A5329B71F92A665F281EBF3A1024")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "A299C26C55A9C3CB073E39A9CEBA941C", hash_generated_method = "C9F847D4B82923EFF7438598A6E111D7")
    public List<DataConnection> getCurrentDataConnectionList() {
List<DataConnection> var540C13E9E156B687226421B24F2DF178_2023700822 =         null;
        var540C13E9E156B687226421B24F2DF178_2023700822.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2023700822;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.392 -0400", hash_original_method = "4C059DF7C7D69ACF7A40492B141C0E0E", hash_generated_method = "D7E6004C1DEBD5A2CEFE043CA7249D9E")
    public void updateServiceLocation() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "5881AE4FC70280DEC942C9EA7D28599B", hash_generated_method = "F02F2190EA3201DB366C413C2A586A1E")
    public void enableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "735D1391D95196F0FDC1BE41DDFF045E", hash_generated_method = "E000C34487E62E94C959CF881716F440")
    public void disableLocationUpdates() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "1FA99E0FD5CBC0C7E23E4562022C6C7B", hash_generated_method = "DCD38C467AFD416E58FFA737EB8D3EAA")
    public boolean getDataRoamingEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_2081291691 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890259029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890259029;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "D7864742ED28BB1025A64DF25F9573F2", hash_generated_method = "5388CC5174D0767861415AFF9F866AE3")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "ED02158A4D2C2891FD4DF19755FFC21E", hash_generated_method = "B811C623846065ADC4961FA77E4C7A81")
    public boolean enableDataConnectivity() {
        boolean var68934A3E9455FA72420237EB05902327_37655354 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722592915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_722592915;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "6C7C764BC0409F3779A8035A74DD7498", hash_generated_method = "26559ECA387D092E0929CE4E99200DB9")
    public boolean disableDataConnectivity() {
        boolean var68934A3E9455FA72420237EB05902327_1588413009 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_507379532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_507379532;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "4163B9D7D88469B6B3262F63C99CA67D", hash_generated_method = "F148E42E6611D2474783A9C305D82ECD")
    public boolean isDataConnectivityPossible() {
        boolean var68934A3E9455FA72420237EB05902327_767872124 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271719296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271719296;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "7A2F4DC26C7BCEF3EFD92AA765E71F2C", hash_generated_method = "4AB7942E81028C9DCD5FD3294A07C128")
     boolean updateCurrentCarrierInProvider() {
        boolean var68934A3E9455FA72420237EB05902327_16931478 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257516732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257516732;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "9C23BB5EE7564DC165411E2240D9C48B", hash_generated_method = "234D97846E2DB5B89AE8A0AA0A7F606D")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "EC804499C6B57F7E869E59DC08B6DF4A", hash_generated_method = "A057FC79E7A186809A41D73CEB56EEC8")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo var540C13E9E156B687226421B24F2DF178_321084610 =         null;
        var540C13E9E156B687226421B24F2DF178_321084610.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_321084610;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "812193F93806F59ED749922B050DF10F", hash_generated_method = "C6BCC909349C51DC256AF48811A37342")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager var540C13E9E156B687226421B24F2DF178_1371940890 =         null;
        var540C13E9E156B687226421B24F2DF178_1371940890.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1371940890;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.393 -0400", hash_original_method = "86B1FE249C1D5498C35312B21CC1C136", hash_generated_method = "0DB8F243739BB863275FB41320CC97F1")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var540C13E9E156B687226421B24F2DF178_848198866 =         null;
        var540C13E9E156B687226421B24F2DF178_848198866.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_848198866;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "A0048838E294262C3DA3F1BBED334947", hash_generated_method = "7F1D783B059F46E26751F1822996F59B")
    public IccFileHandler getIccFileHandler() {
IccFileHandler var540C13E9E156B687226421B24F2DF178_1081575447 =         null;
        var540C13E9E156B687226421B24F2DF178_1081575447.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1081575447;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "51CFE835DBE89FFE2A674C84F61C2939", hash_generated_method = "82419EE04970CC9DDD1C55541902677D")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "2EDA6D4BFCED672397851989BEC927ED", hash_generated_method = "D836FD94433820AC6D3BBDF7040F0EB9")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "0B5BC72A0180CA9A3EFA64E22D357228", hash_generated_method = "CA698F653324602105118AE6ECC0E893")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! This functionality is not implemented for SIP.");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "08A6E4B71FA09531A80AE7640F0ED8FC", hash_generated_method = "7905FFFA921580789FD825ABDE900D30")
    public boolean needsOtaServiceProvisioning() {
        boolean var68934A3E9455FA72420237EB05902327_277598842 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236889174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_236889174;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "49CCE355DDA22C6F211BF19B00C3D5D9", hash_generated_method = "03AF175808C204AB3B32032DDBB4897D")
    public LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
LinkProperties var540C13E9E156B687226421B24F2DF178_1058176457 =         null;
        var540C13E9E156B687226421B24F2DF178_1058176457.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1058176457;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_method = "681D205E001AABF5DF77739E6B0B2577", hash_generated_method = "543B2FB23EA614A042135EBBF0EE1B12")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.394 -0400", hash_original_field = "976523C589B0B5F84D4530AFB1044D93", hash_generated_field = "7A17420CA7320CD6991D9BB201E6C8AD")

    private static final String LOG_TAG = "SipPhone";
}

