package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.*;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.text.TextUtils;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import com.android.internal.telephony.TelephonyProperties;

public class CdmaConnection extends Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "0FC853D69B46537C5EADDE1D3144A296")

    CdmaCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "05B2F7F3A77F16B32088D3A5F859DA1D", hash_generated_field = "A86CFAAA1D8CDA1D974D232F92D46C54")

    String cnapName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.180 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "778094E282EEBED743C4D949C49552AA", hash_generated_field = "C4B8315EB90D5A6B253E1367ECCBDAE5")

    int cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.181 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.183 -0400", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "E0653E5ECB32CFE32119A6216A323B6B")
      CdmaConnection(Context context, DriverCall dc, CdmaCallTracker ct, int index) {
        addTaint(context.getTaint());
        createWakeLock(context);
        acquireWakeLock();
        owner = ct;
        h = new MyHandler(owner.getLooper());
        address = dc.number;
        isIncoming = dc.isMT;
        createTime = System.currentTimeMillis();
        cnapName = dc.name;
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;
        this.index = index;
        parent = parentFromDCState (dc.state);
        parent.attach(this, dc);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //address = dc.number;
        //isIncoming = dc.isMT;
        //createTime = System.currentTimeMillis();
        //cnapName = dc.name;
        //cnapNamePresentation = dc.namePresentation;
        //numberPresentation = dc.numberPresentation;
        //this.index = index;
        //parent = parentFromDCState (dc.state);
        //parent.attach(this, dc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.185 -0400", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "09AAB4676C77F22AE1219502DA815E9D")
      CdmaConnection(Context context, String dialString, CdmaCallTracker ct, CdmaCall parent) {
        addTaint(context.getTaint());
        createWakeLock(context);
        acquireWakeLock();
        owner = ct;
        h = new MyHandler(owner.getLooper());
        this.dialString = dialString;
        Log.d(LOG_TAG, "[CDMAConn] CdmaConnection: dialString=" + dialString);
        dialString = formatDialString(dialString);
        Log.d(LOG_TAG, "[CDMAConn] CdmaConnection:formated dialString=" + dialString);
        this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        index = -1;
        isIncoming = false;
        cnapName = null;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        createTime = System.currentTimeMillis();
    if(parent != null)        
        {
            this.parent = parent;
    if(parent.state == CdmaCall.State.ACTIVE)            
            {
                parent.attachFake(this, CdmaCall.State.ACTIVE);
            } //End block
            else
            {
                parent.attachFake(this, CdmaCall.State.DIALING);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.186 -0400", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "DE0C7034193CF7B80F1BDFCFBCB41426")
      CdmaConnection(Context context, CdmaCallWaitingNotification cw, CdmaCallTracker ct,
            CdmaCall parent) {
        addTaint(context.getTaint());
        createWakeLock(context);
        acquireWakeLock();
        owner = ct;
        h = new MyHandler(owner.getLooper());
        address = cw.number;
        numberPresentation = cw.numberPresentation;
        cnapName = cw.name;
        cnapNamePresentation = cw.namePresentation;
        index = -1;
        isIncoming = true;
        createTime = System.currentTimeMillis();
        connectTime = 0;
        this.parent = parent;
        parent.attachFake(this, CdmaCall.State.WAITING);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //address = cw.number;
        //numberPresentation = cw.numberPresentation;
        //cnapName = cw.name;
        //cnapNamePresentation = cw.namePresentation;
        //index = -1;
        //isIncoming = true;
        //createTime = System.currentTimeMillis();
        //connectTime = 0;
        //this.parent = parent;
        //parent.attachFake(this, CdmaCall.State.WAITING);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.186 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
    static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.187 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "ED399915493F9BB348CCD1BA864ECD3C")
     boolean compareTo(DriverCall c) {
        addTaint(c.getTaint());
    if(! (isIncoming || c.isMT))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2055315618 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078144870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078144870;
        }
        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean varBF3876711D5B74828BC1D97D2E05DEA1_693066158 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501314394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501314394;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.187 -0400", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "DF7EDF9522598FD069C98F7C67CA6D8E")
    public String getOrigDialString() {
String varB410F776CE655F7FA9256BA7731599DA_2068348842 =         dialString;
        varB410F776CE655F7FA9256BA7731599DA_2068348842.addTaint(taint);
        return varB410F776CE655F7FA9256BA7731599DA_2068348842;
        // ---------- Original Method ----------
        //return dialString;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.187 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "6A7FFA4B9BA4A879687B51E2C20A18C2")
    public String getAddress() {
String var814577DDD37BAFB17E08CBEFDB411BAE_1396302566 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1396302566.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1396302566;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.187 -0400", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "A00FBEAB177511D376826A2E1B0DDCC8")
    public String getCnapName() {
String var527119163DEA8F24BBC497A7DD6905DC_2126700945 =         cnapName;
        var527119163DEA8F24BBC497A7DD6905DC_2126700945.addTaint(taint);
        return var527119163DEA8F24BBC497A7DD6905DC_2126700945;
        // ---------- Original Method ----------
        //return cnapName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.188 -0400", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "F9282C0DA29BFC31A2C2C28682280E2C")
    public int getCnapNamePresentation() {
        int varBA6B6A03D4382EA050EDB7907F5C12CB_845703323 = (cnapNamePresentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427050566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427050566;
        // ---------- Original Method ----------
        //return cnapNamePresentation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.188 -0400", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "47F97E28242E7917BC5C35D695BDD60C")
    public CdmaCall getCall() {
CdmaCall var0F49909EA73F8892C338E4DCA6EB9906_2076059031 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_2076059031.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_2076059031;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.188 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "3486B281E66A578456663DF7A768ABA6")
    public long getCreateTime() {
        long var1ED2E1B19B6E55D52D2473BE17A4AFD9_1650908726 = (createTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1450890374 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1450890374;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.188 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "94211229BE7BABE1FCE56CEEF03A918A")
    public long getConnectTime() {
        long var2A390E9117109AD2E2B8D0011E8B167F_1673843584 = (connectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_293314760 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_293314760;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.188 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "5BB3954745DEF6C0177DB798758BFBC7")
    public long getDisconnectTime() {
        long varAD92DC1F9C0B5401DB7C9C68DE643AD5_676749660 = (disconnectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1795330770 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1795330770;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.189 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "1F34E842243C052228DA5C674196712E")
    public long getDurationMillis() {
    if(connectTimeReal == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1046682146 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_991486194 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_991486194;
        } //End block
        else
    if(duration == 0)        
        {
            long var0E51B42E3AFE6CDC7CBD85F000104A04_1857098172 = (SystemClock.elapsedRealtime() - connectTimeReal);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_858011829 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_858011829;
        } //End block
        else
        {
            long varB85EC314BF443B797EF8A66B3B03F8A4_1212340765 = (duration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_768849715 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_768849715;
        } //End block
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration == 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.189 -0400", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "73E806FD6A99782D88E5D1020DE80C35")
    public long getHoldDurationMillis() {
    if(getState() != CdmaCall.State.HOLDING)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1897769278 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_781285155 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_781285155;
        } //End block
        else
        {
            long var4D3CB05626CB322D40708E297E465B19_1321545668 = (SystemClock.elapsedRealtime() - holdingStartTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1300113509 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1300113509;
        } //End block
        // ---------- Original Method ----------
        //if (getState() != CdmaCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.189 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "57DFEB8AED25DEE29FB9D54ECC4F1DF8")
    public DisconnectCause getDisconnectCause() {
DisconnectCause var3C8F3313F49435961542E8707E527956_2048224727 =         cause;
        var3C8F3313F49435961542E8707E527956_2048224727.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_2048224727;
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.190 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "9E7AB0C69F8707B89FB9246EF5477C21")
    public boolean isIncoming() {
        boolean varBC23EBAFF55FFCC779696072ED387D2F_1024720952 = (isIncoming);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563503972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563503972;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.190 -0400", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "86C126E25922D857C582FBA6BEFFFED7")
    public CdmaCall.State getState() {
    if(disconnected)        
        {
CdmaCall.State var9CF7689232D8AFA81B76F22A2097602F_1656823076 =             CdmaCall.State.DISCONNECTED;
            var9CF7689232D8AFA81B76F22A2097602F_1656823076.addTaint(taint);
            return var9CF7689232D8AFA81B76F22A2097602F_1656823076;
        } //End block
        else
        {
CdmaCall.State varB2F6DC77C80BF408EE3A0FF5E79E41E6_2006663009 =             super.getState();
            varB2F6DC77C80BF408EE3A0FF5E79E41E6_2006663009.addTaint(taint);
            return varB2F6DC77C80BF408EE3A0FF5E79E41E6_2006663009;
        } //End block
        // ---------- Original Method ----------
        //if (disconnected) {
            //return CdmaCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.190 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "6B8C349C8BA335C309265058C46BE807")
    public void hangup() throws CallStateException {
    if(!disconnected)        
        {
            owner.hangup(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_1236775660 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_1236775660.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_1236775660;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.hangup(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.191 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "EFCDAE2CCB80A1976D692DDA07DC3692")
    public void separate() throws CallStateException {
    if(!disconnected)        
        {
            owner.separate(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_1211870179 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_1211870179.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_1211870179;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.separate(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.191 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "C40C0487A07D9D08F0087D9803F2874F")
    public PostDialState getPostDialState() {
PostDialState varA5212BBA7CEDC5476DB20427B201984F_287508974 =         postDialState;
        varA5212BBA7CEDC5476DB20427B201984F_287508974.addTaint(taint);
        return varA5212BBA7CEDC5476DB20427B201984F_287508974;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.191 -0400", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "7953B1AC054F13BEFE43B9A27747E82E")
    public void proceedAfterWaitChar() {
    if(postDialState != PostDialState.WAIT)        
        {
            return;
        } //End block
        setPostDialState(PostDialState.STARTED);
        processNextPostDialChar();
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.WAIT) {
            //Log.w(LOG_TAG, "CdmaConnection.proceedAfterWaitChar(): Expected "
                //+ "getPostDialState() to be WAIT but was " + postDialState);
            //return;
        //}
        //setPostDialState(PostDialState.STARTED);
        //processNextPostDialChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.192 -0400", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "B2D8273FD08380C4F705AAFB46DE1697")
    public void proceedAfterWildChar(String str) {
        addTaint(str.getTaint());
    if(postDialState != PostDialState.WILD)        
        {
            return;
        } //End block
        setPostDialState(PostDialState.STARTED);
    if(false)        
        {
            boolean playedTone = false;
            int len = (str != null ? str.length() : 0);
for(int i=0;i<len;i++)
            {
                char c = str.charAt(i);
                Message msg = null;
    if(i == len-1)                
                {
                    msg = h.obtainMessage(EVENT_DTMF_DONE);
                } //End block
    if(PhoneNumberUtils.is12Key(c))                
                {
                    owner.cm.sendDtmf(c, msg);
                    playedTone = true;
                } //End block
            } //End block
    if(!playedTone)            
            {
                processNextPostDialChar();
            } //End block
        } //End block
        else
        {
            StringBuilder buf = new StringBuilder(str);
            buf.append(postDialString.substring(nextPostDialChar));
            postDialString = buf.toString();
            nextPostDialChar = 0;
    if(Phone.DEBUG_PHONE)            
            {
                log("proceedAfterWildChar: new postDialString is " +
                        postDialString);
            } //End block
            processNextPostDialChar();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.193 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.193 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.194 -0400", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "FB4D4E5057C209CA32AFA2B51CA97730")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        addTaint(causeCode);
switch(causeCode){
        case CallFailCause.USER_BUSY:
DisconnectCause varD2DF84FFC9BA616CBCBA3F0FE59C873F_350321005 =         DisconnectCause.BUSY;
        varD2DF84FFC9BA616CBCBA3F0FE59C873F_350321005.addTaint(taint);
        return varD2DF84FFC9BA616CBCBA3F0FE59C873F_350321005;
        case CallFailCause.NO_CIRCUIT_AVAIL:
DisconnectCause varE1E8481615DCF7AD24466AE126D9E63D_1223782514 =         DisconnectCause.CONGESTION;
        varE1E8481615DCF7AD24466AE126D9E63D_1223782514.addTaint(taint);
        return varE1E8481615DCF7AD24466AE126D9E63D_1223782514;
        case CallFailCause.ACM_LIMIT_EXCEEDED:
DisconnectCause var28EC0BD504B7AF6E3EB037C6627E06B0_1334012496 =         DisconnectCause.LIMIT_EXCEEDED;
        var28EC0BD504B7AF6E3EB037C6627E06B0_1334012496.addTaint(taint);
        return var28EC0BD504B7AF6E3EB037C6627E06B0_1334012496;
        case CallFailCause.CALL_BARRED:
DisconnectCause var33E373DEFC5372A2CA9459FB8EE82A29_272555245 =         DisconnectCause.CALL_BARRED;
        var33E373DEFC5372A2CA9459FB8EE82A29_272555245.addTaint(taint);
        return var33E373DEFC5372A2CA9459FB8EE82A29_272555245;
        case CallFailCause.FDN_BLOCKED:
DisconnectCause varFC6EBF80C57CE323DF25B9404743E45F_107556556 =         DisconnectCause.FDN_BLOCKED;
        varFC6EBF80C57CE323DF25B9404743E45F_107556556.addTaint(taint);
        return varFC6EBF80C57CE323DF25B9404743E45F_107556556;
        case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE:
DisconnectCause var0BAC4CA5699024EFFF675D1740865295_1387687272 =         DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
        var0BAC4CA5699024EFFF675D1740865295_1387687272.addTaint(taint);
        return var0BAC4CA5699024EFFF675D1740865295_1387687272;
        case CallFailCause.CDMA_DROP:
DisconnectCause varA331B1812847E7F85B915FAE4BAE041F_1282917202 =         DisconnectCause.CDMA_DROP;
        varA331B1812847E7F85B915FAE4BAE041F_1282917202.addTaint(taint);
        return varA331B1812847E7F85B915FAE4BAE041F_1282917202;
        case CallFailCause.CDMA_INTERCEPT:
DisconnectCause var4D05A02A5F398F1DC4DE3BEDD12F469E_289396271 =         DisconnectCause.CDMA_INTERCEPT;
        var4D05A02A5F398F1DC4DE3BEDD12F469E_289396271.addTaint(taint);
        return var4D05A02A5F398F1DC4DE3BEDD12F469E_289396271;
        case CallFailCause.CDMA_REORDER:
DisconnectCause varF6606C3770F553CE0380A5165F62E44A_495629096 =         DisconnectCause.CDMA_REORDER;
        varF6606C3770F553CE0380A5165F62E44A_495629096.addTaint(taint);
        return varF6606C3770F553CE0380A5165F62E44A_495629096;
        case CallFailCause.CDMA_SO_REJECT:
DisconnectCause varC651B7611EF6F8504D8F88F0F97FC44B_996390256 =         DisconnectCause.CDMA_SO_REJECT;
        varC651B7611EF6F8504D8F88F0F97FC44B_996390256.addTaint(taint);
        return varC651B7611EF6F8504D8F88F0F97FC44B_996390256;
        case CallFailCause.CDMA_RETRY_ORDER:
DisconnectCause varC0787D632E23A900254D0BC1B5A2A8D1_1649174048 =         DisconnectCause.CDMA_RETRY_ORDER;
        varC0787D632E23A900254D0BC1B5A2A8D1_1649174048.addTaint(taint);
        return varC0787D632E23A900254D0BC1B5A2A8D1_1649174048;
        case CallFailCause.CDMA_ACCESS_FAILURE:
DisconnectCause varC60D48D13C210832CD310DADB0650157_943721490 =         DisconnectCause.CDMA_ACCESS_FAILURE;
        varC60D48D13C210832CD310DADB0650157_943721490.addTaint(taint);
        return varC60D48D13C210832CD310DADB0650157_943721490;
        case CallFailCause.CDMA_PREEMPTED:
DisconnectCause varC5A89D1300BE894AFCF76B495032131E_2075293348 =         DisconnectCause.CDMA_PREEMPTED;
        varC5A89D1300BE894AFCF76B495032131E_2075293348.addTaint(taint);
        return varC5A89D1300BE894AFCF76B495032131E_2075293348;
        case CallFailCause.CDMA_NOT_EMERGENCY:
DisconnectCause varFF22BFA9702319BBBEB352FDA73A8B7B_1290333580 =         DisconnectCause.CDMA_NOT_EMERGENCY;
        varFF22BFA9702319BBBEB352FDA73A8B7B_1290333580.addTaint(taint);
        return varFF22BFA9702319BBBEB352FDA73A8B7B_1290333580;
        case CallFailCause.CDMA_ACCESS_BLOCKED:
DisconnectCause var2F126A508B10D8BD54837730597F4ABE_1064383468 =         DisconnectCause.CDMA_ACCESS_BLOCKED;
        var2F126A508B10D8BD54837730597F4ABE_1064383468.addTaint(taint);
        return var2F126A508B10D8BD54837730597F4ABE_1064383468;
        case CallFailCause.ERROR_UNSPECIFIED:
        case CallFailCause.NORMAL_CLEARING:
        default:
        CDMAPhone phone = owner.phone;
        int serviceState = phone.getServiceState().getState();
    if(serviceState == ServiceState.STATE_POWER_OFF)        
        {
DisconnectCause varB5A548D4E8E9956A6B17DAA602130C2E_159773781 =             DisconnectCause.POWER_OFF;
            varB5A548D4E8E9956A6B17DAA602130C2E_159773781.addTaint(taint);
            return varB5A548D4E8E9956A6B17DAA602130C2E_159773781;
        } //End block
        else
    if(serviceState == ServiceState.STATE_OUT_OF_SERVICE
                        || serviceState == ServiceState.STATE_EMERGENCY_ONLY)        
        {
DisconnectCause varC7C8C415DA4C9B549FC44EE39C9BE577_1499386701 =             DisconnectCause.OUT_OF_SERVICE;
            varC7C8C415DA4C9B549FC44EE39C9BE577_1499386701.addTaint(taint);
            return varC7C8C415DA4C9B549FC44EE39C9BE577_1499386701;
        } //End block
        else
    if(phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY)        
        {
DisconnectCause varBEDBF280E043E08987916CA3350BFE4A_1543013566 =             DisconnectCause.ICC_ERROR;
            varBEDBF280E043E08987916CA3350BFE4A_1543013566.addTaint(taint);
            return varBEDBF280E043E08987916CA3350BFE4A_1543013566;
        } //End block
        else
    if(causeCode==CallFailCause.NORMAL_CLEARING)        
        {
DisconnectCause varEE0E8A8143B9D21A7A986AA8541D8AF4_194284840 =             DisconnectCause.NORMAL;
            varEE0E8A8143B9D21A7A986AA8541D8AF4_194284840.addTaint(taint);
            return varEE0E8A8143B9D21A7A986AA8541D8AF4_194284840;
        } //End block
        else
        {
DisconnectCause varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1881266158 =             DisconnectCause.ERROR_UNSPECIFIED;
            varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1881266158.addTaint(taint);
            return varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1881266158;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.195 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "2B64FFEED2AC71B83DA0C46F70DF5CB5")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(causeCode);
        onDisconnect(disconnectCauseFromCode(causeCode));
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.195 -0400", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "05FA53BD7F3DEAE6DC5F6BACAF416AFF")
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        this.cause = cause;
    if(!disconnected)        
        {
            doDisconnect();
    if(false)            
            Log.d(LOG_TAG,
                    "[CDMAConn] onDisconnect: cause=" + cause);
            owner.phone.notifyDisconnect(this);
    if(parent != null)            
            {
                parent.connectionDisconnected(this);
            } //End block
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //this.cause = cause;
        //if (!disconnected) {
            //doDisconnect();
            //if (false) Log.d(LOG_TAG,
                    //"[CDMAConn] onDisconnect: cause=" + cause);
            //owner.phone.notifyDisconnect(this);
            //if (parent != null) {
                //parent.connectionDisconnected(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.196 -0400", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "768CA1D957BC71C4AF9BEE5D06699C12")
     void onLocalDisconnect() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!disconnected)        
        {
            doDisconnect();
    if(false)            
            Log.d(LOG_TAG,
                    "[CDMAConn] onLoalDisconnect" );
    if(parent != null)            
            {
                parent.detach(this);
            } //End block
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (!disconnected) {
            //doDisconnect();
            //if (false) Log.d(LOG_TAG,
                    //"[CDMAConn] onLoalDisconnect" );
            //if (parent != null) {
                //parent.detach(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.198 -0400", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "FC6833597FDEEF895BF34949913BB431")
     boolean update(DriverCall dc) {
        CdmaCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == CdmaCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
    if(Phone.DEBUG_PHONE)        
        log("parent= " +parent +", newParent= " + newParent);
    if(!equalsHandlesNulls(address, dc.number))        
        {
    if(Phone.DEBUG_PHONE)            
            log("update: phone # changed!");
            address = dc.number;
            changed = true;
        } //End block
    if(TextUtils.isEmpty(dc.name))        
        {
    if(!TextUtils.isEmpty(cnapName))            
            {
                changed = true;
                cnapName = "";
            } //End block
        } //End block
        else
    if(!dc.name.equals(cnapName))        
        {
            changed = true;
            cnapName = dc.name;
        } //End block
    if(Phone.DEBUG_PHONE)        
        log("--dssds----"+cnapName);
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;
    if(newParent != parent)        
        {
    if(parent != null)            
            {
                parent.detach(this);
            } //End block
            newParent.attach(this, dc);
            parent = newParent;
            changed = true;
        } //End block
        else
        {
            boolean parentStateChange;
            parentStateChange = parent.update (this, dc);
            changed = changed || parentStateChange;
        } //End block
    if(Phone.DEBUG_PHONE)        
        log(
                "Update, wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
    if(wasConnectingInOrOut && !isConnectingInOrOut())        
        {
            onConnectedInOrOut();
        } //End block
    if(changed && !wasHolding && (getState() == CdmaCall.State.HOLDING))        
        {
            onStartedHolding();
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1523551368 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62373178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62373178;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.198 -0400", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "5A5BEF0C70845A84F08055BD57662E8D")
     void fakeHoldBeforeDial() {
    if(parent != null)        
        {
            parent.detach(this);
        } //End block
        parent = owner.backgroundCall;
        parent.attachFake(this, CdmaCall.State.HOLDING);
        onStartedHolding();
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.detach(this);
        //}
        //parent = owner.backgroundCall;
        //parent.attachFake(this, CdmaCall.State.HOLDING);
        //onStartedHolding();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.199 -0400", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "B1794263428CF90BC9C73462306FD4A7")
     int getCDMAIndex() throws CallStateException {
    if(index >= 0)        
        {
            int varA2687A7C7EA79F31F8AD4DF5FB404647_1453473536 = (index + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145908128 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145908128;
        } //End block
        else
        {
            CallStateException varF822401CF8B329675E5841CD4C7AE44C_1395078968 = new CallStateException ("CDMA connection index not assigned");
            varF822401CF8B329675E5841CD4C7AE44C_1395078968.addTaint(taint);
            throw varF822401CF8B329675E5841CD4C7AE44C_1395078968;
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("CDMA connection index not assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.200 -0400", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "EFEDE383D1AD59D23F6B1FB76FD29004")
     void onConnectedInOrOut() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        connectTime = System.currentTimeMillis();
        connectTimeReal = SystemClock.elapsedRealtime();
        duration = 0;
    if(Phone.DEBUG_PHONE)        
        {
            log("onConnectedInOrOut: connectTime=" + connectTime);
        } //End block
    if(!isIncoming)        
        {
            processNextPostDialChar();
        } //End block
        else
        {
            releaseWakeLock();
        } //End block
        // ---------- Original Method ----------
        //connectTime = System.currentTimeMillis();
        //connectTimeReal = SystemClock.elapsedRealtime();
        //duration = 0;
        //if (Phone.DEBUG_PHONE) {
            //log("onConnectedInOrOut: connectTime=" + connectTime);
        //}
        //if (!isIncoming) {
            //processNextPostDialChar();
        //} else {
            //releaseWakeLock();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.201 -0400", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "21162B02B62CC3BB8D40FD8D893D1D38")
    private void doDisconnect() {
        index = -1;
        disconnectTime = System.currentTimeMillis();
        duration = SystemClock.elapsedRealtime() - connectTimeReal;
        disconnected = true;
        // ---------- Original Method ----------
        //index = -1;
        //disconnectTime = System.currentTimeMillis();
        //duration = SystemClock.elapsedRealtime() - connectTimeReal;
        //disconnected = true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.201 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.202 -0400", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "D679F392205A76CFE9FEA952EFED638C")
    private boolean processPostDialChar(char c) {
        addTaint(c);
    if(PhoneNumberUtils.is12Key(c))        
        {
            owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        } //End block
        else
    if(c == PhoneNumberUtils.PAUSE)        
        {
            setPostDialState(PostDialState.PAUSE);
            h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
        } //End block
        else
    if(c == PhoneNumberUtils.WAIT)        
        {
            setPostDialState(PostDialState.WAIT);
        } //End block
        else
    if(c == PhoneNumberUtils.WILD)        
        {
            setPostDialState(PostDialState.WILD);
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1315327637 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074940994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074940994;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1879175855 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046752997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046752997;
        // ---------- Original Method ----------
        //if (PhoneNumberUtils.is12Key(c)) {
            //owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        //} else if (c == PhoneNumberUtils.PAUSE) {
            //setPostDialState(PostDialState.PAUSE);
            //h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            //PAUSE_DELAY_MILLIS);
        //} else if (c == PhoneNumberUtils.WAIT) {
            //setPostDialState(PostDialState.WAIT);
        //} else if (c == PhoneNumberUtils.WILD) {
            //setPostDialState(PostDialState.WILD);
        //} else {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.203 -0400", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "907B60EF10318EC07DFAC2256E94BCC8")
    public String getRemainingPostDialString() {
    if(postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1409440731 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1409440731.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1409440731;
        } //End block
        String subStr = postDialString.substring(nextPostDialChar);
    if(subStr != null)        
        {
            int wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            int pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
    if(wIndex > 0 && (wIndex < pIndex || pIndex <= 0))            
            {
                subStr = subStr.substring(0, wIndex);
            } //End block
            else
    if(pIndex > 0)            
            {
                subStr = subStr.substring(0, pIndex);
            } //End block
        } //End block
String var3CA17F3B01DECFEB1669A1F96CAE471F_1162716968 =         subStr;
        var3CA17F3B01DECFEB1669A1F96CAE471F_1162716968.addTaint(taint);
        return var3CA17F3B01DECFEB1669A1F96CAE471F_1162716968;
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
                //|| postDialState == PostDialState.COMPLETE
                //|| postDialString == null
                //|| postDialString.length() <= nextPostDialChar) {
            //return "";
        //}
        //String subStr = postDialString.substring(nextPostDialChar);
        //if (subStr != null) {
            //int wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            //int pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
            //if (wIndex > 0 && (wIndex < pIndex || pIndex <= 0)) {
                //subStr = subStr.substring(0, wIndex);
            //} else if (pIndex > 0) {
                //subStr = subStr.substring(0, pIndex);
            //}
        //}
        //return subStr;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.204 -0400", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "4D965351675313DA10B06B56D19C84AD")
    public void updateParent(CdmaCall oldParent, CdmaCall newParent) {
        addTaint(oldParent.getTaint());
    if(newParent != oldParent)        
        {
    if(oldParent != null)            
            {
                oldParent.detach(this);
            } //End block
            newParent.attachFake(this, CdmaCall.State.ACTIVE);
            parent = newParent;
        } //End block
        // ---------- Original Method ----------
        //if (newParent != oldParent) {
            //if (oldParent != null) {
                //oldParent.detach(this);
            //}
            //newParent.attachFake(this, CdmaCall.State.ACTIVE);
            //parent = newParent;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.204 -0400", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "A362F164D1B9BD9FB27118D1CF0DD504")
    @Override
    protected void finalize() {
    if(mPartialWakeLock.isHeld())        
        {
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.205 -0400", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "9C7620E97668A530A07EBEBB3C343FCF")
     void processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;
    if(postDialState == PostDialState.CANCELLED)        
        {
            releaseWakeLock();
            return;
        } //End block
    if(postDialString == null ||
                postDialString.length() <= nextPostDialChar)        
        {
            setPostDialState(PostDialState.COMPLETE);
            releaseWakeLock();
            c = 0;
        } //End block
        else
        {
            boolean isValid;
            setPostDialState(PostDialState.STARTED);
            c = postDialString.charAt(nextPostDialChar++);
            isValid = processPostDialChar(c);
    if(!isValid)            
            {
                h.obtainMessage(EVENT_NEXT_POST_DIAL).sendToTarget();
                return;
            } //End block
        } //End block
        postDialHandler = owner.phone.mPostDialHandler;
        Message notifyMessage;
    if(postDialHandler != null &&
                (notifyMessage = postDialHandler.messageForRegistrant()) != null)        
        {
            PostDialState state = postDialState;
            AsyncResult ar = AsyncResult.forMessage(notifyMessage);
            ar.result = this;
            ar.userObj = state;
            notifyMessage.arg1 = c;
            notifyMessage.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.205 -0400", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "8F2AE0A6393DDDB8853A79DA312EF6B2")
    private boolean isConnectingInOrOut() {
        boolean var77EDDB5F0BE48A133FFD8B9FD3472D18_1954529762 = (parent == null || parent == owner.ringingCall
            || parent.state == CdmaCall.State.DIALING
            || parent.state == CdmaCall.State.ALERTING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672437849 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672437849;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == CdmaCall.State.DIALING
            //|| parent.state == CdmaCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.206 -0400", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "4A974A4789AFD5BD176A4450A52A0443")
    private CdmaCall parentFromDCState(DriverCall.State state) {
        addTaint(state.getTaint());
switch(state){
        case ACTIVE:
        case DIALING:
        case ALERTING:
CdmaCall varC102678DE4CE1C7B17F4189381EF06A7_520411814 =         owner.foregroundCall;
        varC102678DE4CE1C7B17F4189381EF06A7_520411814.addTaint(taint);
        return varC102678DE4CE1C7B17F4189381EF06A7_520411814;
        case HOLDING:
CdmaCall varA426A0A6C423A974DB19CD194B07865A_798327261 =         owner.backgroundCall;
        varA426A0A6C423A974DB19CD194B07865A_798327261.addTaint(taint);
        return varA426A0A6C423A974DB19CD194B07865A_798327261;
        case INCOMING:
        case WAITING:
CdmaCall varC0AC0CA56D4A71D743E3F1BD12ED290B_1532902191 =         owner.ringingCall;
        varC0AC0CA56D4A71D743E3F1BD12ED290B_1532902191.addTaint(taint);
        return varC0AC0CA56D4A71D743E3F1BD12ED290B_1532902191;
        default:
        RuntimeException var0C856D8E8320CBACC5D8B230F765BAA8_1241438625 = new RuntimeException("illegal call state: " + state);
        var0C856D8E8320CBACC5D8B230F765BAA8_1241438625.addTaint(taint);
        throw var0C856D8E8320CBACC5D8B230F765BAA8_1241438625;
}
        // ---------- Original Method ----------
        //switch (state) {
            //case ACTIVE:
            //case DIALING:
            //case ALERTING:
                //return owner.foregroundCall;
            //case HOLDING:
                //return owner.backgroundCall;
            //case INCOMING:
            //case WAITING:
                //return owner.ringingCall;
            //default:
                //throw new RuntimeException("illegal call state: " + state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.206 -0400", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "0205F1D837F6559240A2475B1E9A0AEB")
    private void setPostDialState(PostDialState s) {
    if(s == PostDialState.STARTED ||
                s == PostDialState.PAUSE)        
        {
            synchronized
(mPartialWakeLock)            {
    if(mPartialWakeLock.isHeld())                
                {
                    h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                } //End block
                else
                {
                    acquireWakeLock();
                } //End block
                Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            } //End block
        } //End block
        else
        {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        } //End block
        postDialState = s;
        // ---------- Original Method ----------
        //if (s == PostDialState.STARTED ||
                //s == PostDialState.PAUSE) {
            //synchronized (mPartialWakeLock) {
                //if (mPartialWakeLock.isHeld()) {
                    //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                //} else {
                    //acquireWakeLock();
                //}
                //Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                //h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            //}
        //} else {
            //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            //releaseWakeLock();
        //}
        //postDialState = s;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.206 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "EAAFC0E2C4C27B5B5C8A84464E5BC79D")
    private void createWakeLock(Context context) {
        addTaint(context.getTaint());
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.207 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.207 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "655A9C93A6A7AEB2604B2CC2E97ADF64")
    private void releaseWakeLock() {
        synchronized
(mPartialWakeLock)        {
    if(mPartialWakeLock.isHeld())            
            {
                log("releaseWakeLock");
                mPartialWakeLock.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isPause(char c) {
        return c == PhoneNumberUtils.PAUSE;
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isWait(char c) {
        return c == PhoneNumberUtils.WAIT;
    }

    
        private static int findNextPCharOrNonPOrNonWCharIndex(String phoneNumber, int currIndex) {
        boolean wMatched = isWait(phoneNumber.charAt(currIndex));
        int index = currIndex + 1;
        int length = phoneNumber.length();
        while (index < length) {
            char cNext = phoneNumber.charAt(index);
            if (isWait(cNext)) {
                wMatched = true;
            }
            if (!isWait(cNext) && !isPause(cNext)) {
                break;
            }
            index++;
        }
        if ((index < length) && (index > (currIndex + 1))  &&
            ((wMatched == false) && isPause(phoneNumber.charAt(currIndex)))) {
            return (currIndex + 1);
        }
        return index;
    }

    
        @DSModeled(DSC.SPEC)
    private static char findPOrWCharToAppend(String phoneNumber, int currPwIndex, int nextNonPwCharIndex) {
        char c = phoneNumber.charAt(currPwIndex);
        char ret;
        ret = (isPause(c)) ? PhoneNumberUtils.PAUSE : PhoneNumberUtils.WAIT;
        if (nextNonPwCharIndex > (currPwIndex + 1)) {
            ret = PhoneNumberUtils.WAIT;
        }
        return ret;
    }

    
        public static String formatDialString(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        int length = phoneNumber.length();
        StringBuilder ret = new StringBuilder();
        char c;
        int currIndex = 0;
        while (currIndex < length) {
            c = phoneNumber.charAt(currIndex);
            if (isPause(c) || isWait(c)) {
                if (currIndex < length - 1) {
                    int nextIndex = findNextPCharOrNonPOrNonWCharIndex(phoneNumber, currIndex);
                    if (nextIndex < length) {
                        char pC = findPOrWCharToAppend(phoneNumber, currIndex, nextIndex);
                        ret.append(pC);
                        if (nextIndex > (currIndex + 1)) {
                            currIndex = nextIndex - 1;
                        }
                    } else if (nextIndex == length) {
                        currIndex = length - 1;
                    }
                }
            } else {
                ret.append(c);
            }
            currIndex++;
        }
        return PhoneNumberUtils.cdmaCheckAndProcessPlusCode(ret.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.209 -0400", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "5C90FD58D3F28B09261FE8407ED1971A")
    private void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.209 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "91735EF072C55CCFDC4D67778734DD97")
    @Override
    public int getNumberPresentation() {
        int varF00A6033EECCE0EBD17BDAAC2E6671A9_1159991311 = (numberPresentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587034881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587034881;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.209 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "3106E04868B9E37E038B650E1E8CF112")
    @Override
    public UUSInfo getUUSInfo() {
UUSInfo var540C13E9E156B687226421B24F2DF178_813311448 =         null;
        var540C13E9E156B687226421B24F2DF178_813311448.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_813311448;
        // ---------- Original Method ----------
        //return null;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.209 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.209 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "379856D1922C03BCEBAC6EFF68A63B7F")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case EVENT_NEXT_POST_DIAL:
            case EVENT_DTMF_DONE:
            case EVENT_PAUSE_DONE:
            processNextPostDialChar();
            break;
            case EVENT_WAKE_LOCK_TIMEOUT:
            releaseWakeLock();
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case EVENT_NEXT_POST_DIAL:
                //case EVENT_DTMF_DONE:
                //case EVENT_PAUSE_DONE:
                    //processNextPostDialChar();
                    //break;
                //case EVENT_WAKE_LOCK_TIMEOUT:
                    //releaseWakeLock();
                    //break;
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.210 -0400", hash_original_field = "150B3B1EED2149C93D65E2E16D8B0C2A", hash_generated_field = "32583EE0477EC212D3437226C61913CB")

    static final int PAUSE_DELAY_MILLIS = 2 * 1000;
}

