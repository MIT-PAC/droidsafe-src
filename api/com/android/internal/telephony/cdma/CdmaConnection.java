package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;






public class CdmaConnection extends Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "0FC853D69B46537C5EADDE1D3144A296")

    CdmaCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "05B2F7F3A77F16B32088D3A5F859DA1D", hash_generated_field = "A86CFAAA1D8CDA1D974D232F92D46C54")

    String cnapName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.438 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "778094E282EEBED743C4D949C49552AA", hash_generated_field = "C4B8315EB90D5A6B253E1367ECCBDAE5")

    int cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.439 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.440 -0400", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "E0653E5ECB32CFE32119A6216A323B6B")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.443 -0400", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "09AAB4676C77F22AE1219502DA815E9D")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.445 -0400", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "DE0C7034193CF7B80F1BDFCFBCB41426")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.445 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.446 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "019B39176E9E08F38798789B413224FB")
     boolean compareTo(DriverCall c) {
        addTaint(c.getTaint());
        if(! (isIncoming || c.isMT))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2073236219 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_897487337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_897487337;
        }
        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean varBF3876711D5B74828BC1D97D2E05DEA1_1695352448 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588258270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_588258270;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.446 -0400", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "D9984935F94A1C3679670F953CF6103C")
    public String getOrigDialString() {
String varB410F776CE655F7FA9256BA7731599DA_1159611322 =         dialString;
        varB410F776CE655F7FA9256BA7731599DA_1159611322.addTaint(taint);
        return varB410F776CE655F7FA9256BA7731599DA_1159611322;
        // ---------- Original Method ----------
        //return dialString;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.446 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "FE861E4F02386271AD93EA9863186BCF")
    public String getAddress() {
String var814577DDD37BAFB17E08CBEFDB411BAE_1993217049 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1993217049.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1993217049;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.446 -0400", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "23FF8A59AD19478C4CC1D45FDC07B96E")
    public String getCnapName() {
String var527119163DEA8F24BBC497A7DD6905DC_352723998 =         cnapName;
        var527119163DEA8F24BBC497A7DD6905DC_352723998.addTaint(taint);
        return var527119163DEA8F24BBC497A7DD6905DC_352723998;
        // ---------- Original Method ----------
        //return cnapName;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "74533FBF3C2046502851F50CFEE4F2F3")
    public int getCnapNamePresentation() {
        int varBA6B6A03D4382EA050EDB7907F5C12CB_1890270134 = (cnapNamePresentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684202042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684202042;
        // ---------- Original Method ----------
        //return cnapNamePresentation;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "5A7657394EA0CBB6F3469E7F25750AB4")
    public CdmaCall getCall() {
CdmaCall var0F49909EA73F8892C338E4DCA6EB9906_331841508 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_331841508.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_331841508;
        // ---------- Original Method ----------
        //return parent;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "C0BFE68B4B56A41801D82262FDD65BBB")
    public long getCreateTime() {
        long var1ED2E1B19B6E55D52D2473BE17A4AFD9_669991267 = (createTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_948904992 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_948904992;
        // ---------- Original Method ----------
        //return createTime;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "9908BF1650295FBD36AC12D596668E02")
    public long getConnectTime() {
        long var2A390E9117109AD2E2B8D0011E8B167F_1589264391 = (connectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_662170294 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_662170294;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "5FCAE79AAB51620625AA87E33C7D8078")
    public long getDisconnectTime() {
        long varAD92DC1F9C0B5401DB7C9C68DE643AD5_1603653732 = (disconnectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1820168405 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1820168405;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.447 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "03DD5219F97FA89837E15B24C91E442D")
    public long getDurationMillis() {
        if(connectTimeReal == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1006226263 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_48041785 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_48041785;
        } //End block
        else
        if(duration == 0)        
        {
            long var0E51B42E3AFE6CDC7CBD85F000104A04_1724181168 = (SystemClock.elapsedRealtime() - connectTimeReal);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_400199320 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_400199320;
        } //End block
        else
        {
            long varB85EC314BF443B797EF8A66B3B03F8A4_1553312996 = (duration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1487532810 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1487532810;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "95689463CED605FCA5D85A4C5349897F")
    public long getHoldDurationMillis() {
        if(getState() != CdmaCall.State.HOLDING)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_929437743 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1434622119 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1434622119;
        } //End block
        else
        {
            long var4D3CB05626CB322D40708E297E465B19_1572542550 = (SystemClock.elapsedRealtime() - holdingStartTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_834171129 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_834171129;
        } //End block
        // ---------- Original Method ----------
        //if (getState() != CdmaCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "3AE88759BC5A21309435B3D77E392040")
    public DisconnectCause getDisconnectCause() {
DisconnectCause var3C8F3313F49435961542E8707E527956_675261022 =         cause;
        var3C8F3313F49435961542E8707E527956_675261022.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_675261022;
        // ---------- Original Method ----------
        //return cause;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "F32838AEE7B488C0CF8C026FD292C240")
    public boolean isIncoming() {
        boolean varBC23EBAFF55FFCC779696072ED387D2F_1130525289 = (isIncoming);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356701510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356701510;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "C2351FC05A998C03E18F2DFE6F42F8A9")
    public CdmaCall.State getState() {
        if(disconnected)        
        {
CdmaCall.State var9CF7689232D8AFA81B76F22A2097602F_1471206896 =             CdmaCall.State.DISCONNECTED;
            var9CF7689232D8AFA81B76F22A2097602F_1471206896.addTaint(taint);
            return var9CF7689232D8AFA81B76F22A2097602F_1471206896;
        } //End block
        else
        {
CdmaCall.State varB2F6DC77C80BF408EE3A0FF5E79E41E6_656539485 =             super.getState();
            varB2F6DC77C80BF408EE3A0FF5E79E41E6_656539485.addTaint(taint);
            return varB2F6DC77C80BF408EE3A0FF5E79E41E6_656539485;
        } //End block
        // ---------- Original Method ----------
        //if (disconnected) {
            //return CdmaCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "82A6E491E0200E46CBA74B6DA25F3D59")
    public void hangup() throws CallStateException {
        if(!disconnected)        
        {
            owner.hangup(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_896143303 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_896143303.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_896143303;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.hangup(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "048B8B9A6884E67849A1DEA9CA4E9E70")
    public void separate() throws CallStateException {
        if(!disconnected)        
        {
            owner.separate(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_2123071058 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_2123071058.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_2123071058;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.separate(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.448 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "02D149ABFF045074CE2D1EB064D94433")
    public PostDialState getPostDialState() {
PostDialState varA5212BBA7CEDC5476DB20427B201984F_830088560 =         postDialState;
        varA5212BBA7CEDC5476DB20427B201984F_830088560.addTaint(taint);
        return varA5212BBA7CEDC5476DB20427B201984F_830088560;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.449 -0400", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "7953B1AC054F13BEFE43B9A27747E82E")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.449 -0400", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "B2D8273FD08380C4F705AAFB46DE1697")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.449 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.449 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.450 -0400", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "8DD2DBBBB4CC761C131AFD376590647F")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        addTaint(causeCode);
switch(causeCode){
        case CallFailCause.USER_BUSY:
DisconnectCause varD2DF84FFC9BA616CBCBA3F0FE59C873F_1987369687 =         DisconnectCause.BUSY;
        varD2DF84FFC9BA616CBCBA3F0FE59C873F_1987369687.addTaint(taint);
        return varD2DF84FFC9BA616CBCBA3F0FE59C873F_1987369687;
        case CallFailCause.NO_CIRCUIT_AVAIL:
DisconnectCause varE1E8481615DCF7AD24466AE126D9E63D_1362920901 =         DisconnectCause.CONGESTION;
        varE1E8481615DCF7AD24466AE126D9E63D_1362920901.addTaint(taint);
        return varE1E8481615DCF7AD24466AE126D9E63D_1362920901;
        case CallFailCause.ACM_LIMIT_EXCEEDED:
DisconnectCause var28EC0BD504B7AF6E3EB037C6627E06B0_204898339 =         DisconnectCause.LIMIT_EXCEEDED;
        var28EC0BD504B7AF6E3EB037C6627E06B0_204898339.addTaint(taint);
        return var28EC0BD504B7AF6E3EB037C6627E06B0_204898339;
        case CallFailCause.CALL_BARRED:
DisconnectCause var33E373DEFC5372A2CA9459FB8EE82A29_561830990 =         DisconnectCause.CALL_BARRED;
        var33E373DEFC5372A2CA9459FB8EE82A29_561830990.addTaint(taint);
        return var33E373DEFC5372A2CA9459FB8EE82A29_561830990;
        case CallFailCause.FDN_BLOCKED:
DisconnectCause varFC6EBF80C57CE323DF25B9404743E45F_264625023 =         DisconnectCause.FDN_BLOCKED;
        varFC6EBF80C57CE323DF25B9404743E45F_264625023.addTaint(taint);
        return varFC6EBF80C57CE323DF25B9404743E45F_264625023;
        case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE:
DisconnectCause var0BAC4CA5699024EFFF675D1740865295_321395303 =         DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
        var0BAC4CA5699024EFFF675D1740865295_321395303.addTaint(taint);
        return var0BAC4CA5699024EFFF675D1740865295_321395303;
        case CallFailCause.CDMA_DROP:
DisconnectCause varA331B1812847E7F85B915FAE4BAE041F_1594552878 =         DisconnectCause.CDMA_DROP;
        varA331B1812847E7F85B915FAE4BAE041F_1594552878.addTaint(taint);
        return varA331B1812847E7F85B915FAE4BAE041F_1594552878;
        case CallFailCause.CDMA_INTERCEPT:
DisconnectCause var4D05A02A5F398F1DC4DE3BEDD12F469E_547529143 =         DisconnectCause.CDMA_INTERCEPT;
        var4D05A02A5F398F1DC4DE3BEDD12F469E_547529143.addTaint(taint);
        return var4D05A02A5F398F1DC4DE3BEDD12F469E_547529143;
        case CallFailCause.CDMA_REORDER:
DisconnectCause varF6606C3770F553CE0380A5165F62E44A_1197833456 =         DisconnectCause.CDMA_REORDER;
        varF6606C3770F553CE0380A5165F62E44A_1197833456.addTaint(taint);
        return varF6606C3770F553CE0380A5165F62E44A_1197833456;
        case CallFailCause.CDMA_SO_REJECT:
DisconnectCause varC651B7611EF6F8504D8F88F0F97FC44B_289179126 =         DisconnectCause.CDMA_SO_REJECT;
        varC651B7611EF6F8504D8F88F0F97FC44B_289179126.addTaint(taint);
        return varC651B7611EF6F8504D8F88F0F97FC44B_289179126;
        case CallFailCause.CDMA_RETRY_ORDER:
DisconnectCause varC0787D632E23A900254D0BC1B5A2A8D1_848085956 =         DisconnectCause.CDMA_RETRY_ORDER;
        varC0787D632E23A900254D0BC1B5A2A8D1_848085956.addTaint(taint);
        return varC0787D632E23A900254D0BC1B5A2A8D1_848085956;
        case CallFailCause.CDMA_ACCESS_FAILURE:
DisconnectCause varC60D48D13C210832CD310DADB0650157_613116028 =         DisconnectCause.CDMA_ACCESS_FAILURE;
        varC60D48D13C210832CD310DADB0650157_613116028.addTaint(taint);
        return varC60D48D13C210832CD310DADB0650157_613116028;
        case CallFailCause.CDMA_PREEMPTED:
DisconnectCause varC5A89D1300BE894AFCF76B495032131E_2003714400 =         DisconnectCause.CDMA_PREEMPTED;
        varC5A89D1300BE894AFCF76B495032131E_2003714400.addTaint(taint);
        return varC5A89D1300BE894AFCF76B495032131E_2003714400;
        case CallFailCause.CDMA_NOT_EMERGENCY:
DisconnectCause varFF22BFA9702319BBBEB352FDA73A8B7B_800776472 =         DisconnectCause.CDMA_NOT_EMERGENCY;
        varFF22BFA9702319BBBEB352FDA73A8B7B_800776472.addTaint(taint);
        return varFF22BFA9702319BBBEB352FDA73A8B7B_800776472;
        case CallFailCause.CDMA_ACCESS_BLOCKED:
DisconnectCause var2F126A508B10D8BD54837730597F4ABE_861386063 =         DisconnectCause.CDMA_ACCESS_BLOCKED;
        var2F126A508B10D8BD54837730597F4ABE_861386063.addTaint(taint);
        return var2F126A508B10D8BD54837730597F4ABE_861386063;
        case CallFailCause.ERROR_UNSPECIFIED:
        case CallFailCause.NORMAL_CLEARING:
        default:
        CDMAPhone phone = owner.phone;
        int serviceState = phone.getServiceState().getState();
        if(serviceState == ServiceState.STATE_POWER_OFF)        
        {
DisconnectCause varB5A548D4E8E9956A6B17DAA602130C2E_634737249 =             DisconnectCause.POWER_OFF;
            varB5A548D4E8E9956A6B17DAA602130C2E_634737249.addTaint(taint);
            return varB5A548D4E8E9956A6B17DAA602130C2E_634737249;
        } //End block
        else
        if(serviceState == ServiceState.STATE_OUT_OF_SERVICE
                        || serviceState == ServiceState.STATE_EMERGENCY_ONLY)        
        {
DisconnectCause varC7C8C415DA4C9B549FC44EE39C9BE577_2138358421 =             DisconnectCause.OUT_OF_SERVICE;
            varC7C8C415DA4C9B549FC44EE39C9BE577_2138358421.addTaint(taint);
            return varC7C8C415DA4C9B549FC44EE39C9BE577_2138358421;
        } //End block
        else
        if(phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY)        
        {
DisconnectCause varBEDBF280E043E08987916CA3350BFE4A_1476954729 =             DisconnectCause.ICC_ERROR;
            varBEDBF280E043E08987916CA3350BFE4A_1476954729.addTaint(taint);
            return varBEDBF280E043E08987916CA3350BFE4A_1476954729;
        } //End block
        else
        if(causeCode==CallFailCause.NORMAL_CLEARING)        
        {
DisconnectCause varEE0E8A8143B9D21A7A986AA8541D8AF4_1761057678 =             DisconnectCause.NORMAL;
            varEE0E8A8143B9D21A7A986AA8541D8AF4_1761057678.addTaint(taint);
            return varEE0E8A8143B9D21A7A986AA8541D8AF4_1761057678;
        } //End block
        else
        {
DisconnectCause varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1266934141 =             DisconnectCause.ERROR_UNSPECIFIED;
            varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1266934141.addTaint(taint);
            return varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1266934141;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.450 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "2B64FFEED2AC71B83DA0C46F70DF5CB5")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(causeCode);
        onDisconnect(disconnectCauseFromCode(causeCode));
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.450 -0400", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "05FA53BD7F3DEAE6DC5F6BACAF416AFF")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.450 -0400", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "768CA1D957BC71C4AF9BEE5D06699C12")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.451 -0400", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "3E52DF375FA9040B0EDB1F3C4CA71983")
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
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1353935741 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656799524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_656799524;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.451 -0400", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "5A5BEF0C70845A84F08055BD57662E8D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.451 -0400", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "2E156F716B5EB89391F5996D4024A552")
     int getCDMAIndex() throws CallStateException {
        if(index >= 0)        
        {
            int varA2687A7C7EA79F31F8AD4DF5FB404647_801554122 = (index + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034614831 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034614831;
        } //End block
        else
        {
            CallStateException varF822401CF8B329675E5841CD4C7AE44C_368034895 = new CallStateException ("CDMA connection index not assigned");
            varF822401CF8B329675E5841CD4C7AE44C_368034895.addTaint(taint);
            throw varF822401CF8B329675E5841CD4C7AE44C_368034895;
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("CDMA connection index not assigned");
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.452 -0400", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "EFEDE383D1AD59D23F6B1FB76FD29004")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.452 -0400", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "21162B02B62CC3BB8D40FD8D893D1D38")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.452 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.452 -0400", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "8B77D0720192D9A6E2A6BE7EC80B819A")
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
            boolean var68934A3E9455FA72420237EB05902327_1646228247 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871161553 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_871161553;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_554689073 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896640682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896640682;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.452 -0400", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "383DF465F70C4CE0CD79EBDD9649B793")
    public String getRemainingPostDialString() {
        if(postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_910529855 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_910529855.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_910529855;
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
String var3CA17F3B01DECFEB1669A1F96CAE471F_1380997319 =         subStr;
        var3CA17F3B01DECFEB1669A1F96CAE471F_1380997319.addTaint(taint);
        return var3CA17F3B01DECFEB1669A1F96CAE471F_1380997319;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.453 -0400", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "4D965351675313DA10B06B56D19C84AD")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.453 -0400", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "A362F164D1B9BD9FB27118D1CF0DD504")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.453 -0400", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "9C7620E97668A530A07EBEBB3C343FCF")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.453 -0400", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "684A9971276BA6FB18776CD6856BE6DD")
    private boolean isConnectingInOrOut() {
        boolean var77EDDB5F0BE48A133FFD8B9FD3472D18_1862424596 = (parent == null || parent == owner.ringingCall
            || parent.state == CdmaCall.State.DIALING
            || parent.state == CdmaCall.State.ALERTING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1893407309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1893407309;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == CdmaCall.State.DIALING
            //|| parent.state == CdmaCall.State.ALERTING;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.453 -0400", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "4BEE91FE2C6D04314086D6B5C8DB4CCC")
    private CdmaCall parentFromDCState(DriverCall.State state) {
        addTaint(state.getTaint());
switch(state){
        case ACTIVE:
        case DIALING:
        case ALERTING:
CdmaCall varC102678DE4CE1C7B17F4189381EF06A7_2115231546 =         owner.foregroundCall;
        varC102678DE4CE1C7B17F4189381EF06A7_2115231546.addTaint(taint);
        return varC102678DE4CE1C7B17F4189381EF06A7_2115231546;
        case HOLDING:
CdmaCall varA426A0A6C423A974DB19CD194B07865A_173043462 =         owner.backgroundCall;
        varA426A0A6C423A974DB19CD194B07865A_173043462.addTaint(taint);
        return varA426A0A6C423A974DB19CD194B07865A_173043462;
        case INCOMING:
        case WAITING:
CdmaCall varC0AC0CA56D4A71D743E3F1BD12ED290B_928400675 =         owner.ringingCall;
        varC0AC0CA56D4A71D743E3F1BD12ED290B_928400675.addTaint(taint);
        return varC0AC0CA56D4A71D743E3F1BD12ED290B_928400675;
        default:
        RuntimeException var0C856D8E8320CBACC5D8B230F765BAA8_494731432 = new RuntimeException("illegal call state: " + state);
        var0C856D8E8320CBACC5D8B230F765BAA8_494731432.addTaint(taint);
        throw var0C856D8E8320CBACC5D8B230F765BAA8_494731432;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.454 -0400", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "0205F1D837F6559240A2475B1E9A0AEB")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.454 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "EAAFC0E2C4C27B5B5C8A84464E5BC79D")
    private void createWakeLock(Context context) {
        addTaint(context.getTaint());
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.454 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.454 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "655A9C93A6A7AEB2604B2CC2E97ADF64")
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

    
    @DSModeled(DSC.BAN)
    private static boolean isPause(char c) {
        return c == PhoneNumberUtils.PAUSE;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isWait(char c) {
        return c == PhoneNumberUtils.WAIT;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static char findPOrWCharToAppend(String phoneNumber, int currPwIndex, int nextNonPwCharIndex) {
        char c = phoneNumber.charAt(currPwIndex);
        char ret;
        ret = (isPause(c)) ? PhoneNumberUtils.PAUSE : PhoneNumberUtils.WAIT;
        if (nextNonPwCharIndex > (currPwIndex + 1)) {
            ret = PhoneNumberUtils.WAIT;
        }
        return ret;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "5C90FD58D3F28B09261FE8407ED1971A")
    private void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "A3E9B8424A6F072B53889BFB2DFE2E1A")
    @Override
    public int getNumberPresentation() {
        int varF00A6033EECCE0EBD17BDAAC2E6671A9_490387090 = (numberPresentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037707975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037707975;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "C9FE723FD9404A24766F2864FB1088CC")
    @Override
    public UUSInfo getUUSInfo() {
UUSInfo var540C13E9E156B687226421B24F2DF178_56605308 =         null;
        var540C13E9E156B687226421B24F2DF178_56605308.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_56605308;
        // ---------- Original Method ----------
        //return null;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "379856D1922C03BCEBAC6EFF68A63B7F")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.455 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.456 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.456 -0400", hash_original_field = "150B3B1EED2149C93D65E2E16D8B0C2A", hash_generated_field = "32583EE0477EC212D3437226C61913CB")

    static final int PAUSE_DELAY_MILLIS = 2 * 1000;
}

