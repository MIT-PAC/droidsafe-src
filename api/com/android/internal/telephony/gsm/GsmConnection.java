package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.util.Log;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import com.android.internal.telephony.*;

public class GsmConnection extends Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "EC13D736730A652A8D5F62206A0EDCDD")

    GsmCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.079 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "B06E6373CFB44BD5F02CE42C64608D89", hash_generated_field = "34C14CFE94A5D0F7C643E2D0DC23FCE9")

    UUSInfo uusInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.080 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.082 -0400", hash_original_method = "A76DAF9D6C007596CB909A2D96D7B6D3", hash_generated_method = "59B20B5B2BE78451B905D0129E9C87E3")
      GsmConnection(Context context, DriverCall dc, GsmCallTracker ct, int index) {
        addTaint(context.getTaint());
        createWakeLock(context);
        acquireWakeLock();
        owner = ct;
        h = new MyHandler(owner.getLooper());
        address = dc.number;
        isIncoming = dc.isMT;
        createTime = System.currentTimeMillis();
        numberPresentation = dc.numberPresentation;
        uusInfo = dc.uusInfo;
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
        //numberPresentation = dc.numberPresentation;
        //uusInfo = dc.uusInfo;
        //this.index = index;
        //parent = parentFromDCState (dc.state);
        //parent.attach(this, dc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.084 -0400", hash_original_method = "1891CC0C108558254961316EC04BF5C2", hash_generated_method = "AD7DF28FEF3EEEE03D5256FC483D9A5B")
      GsmConnection(Context context, String dialString, GsmCallTracker ct, GsmCall parent) {
        addTaint(context.getTaint());
        createWakeLock(context);
        acquireWakeLock();
        owner = ct;
        h = new MyHandler(owner.getLooper());
        this.dialString = dialString;
        this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        index = -1;
        isIncoming = false;
        createTime = System.currentTimeMillis();
        this.parent = parent;
        parent.attachFake(this, GsmCall.State.DIALING);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //this.dialString = dialString;
        //this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        //this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        //index = -1;
        //isIncoming = false;
        //createTime = System.currentTimeMillis();
        //this.parent = parent;
        //parent.attachFake(this, GsmCall.State.DIALING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.084 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
        static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.085 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "F18CE226B0AE62ECAF10E7B9E58D7813")
     boolean compareTo(DriverCall c) {
        addTaint(c.getTaint());
    if(! (isIncoming || c.isMT))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1612079320 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67027682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67027682;
        }
        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean varBF3876711D5B74828BC1D97D2E05DEA1_468088636 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444339086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444339086;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.085 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "C8C1D5C7EE310913C04993FD61D092A2")
    public String getAddress() {
String var814577DDD37BAFB17E08CBEFDB411BAE_77198904 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_77198904.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_77198904;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.085 -0400", hash_original_method = "B5FB9A2BDC3179E224BACAD787EF2D05", hash_generated_method = "9BE5BA059696A636ECDE484559B577EB")
    public GsmCall getCall() {
GsmCall var0F49909EA73F8892C338E4DCA6EB9906_27952058 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_27952058.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_27952058;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.085 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "2F834C1F9CE9F9159BD60D605B5933DA")
    public long getCreateTime() {
        long var1ED2E1B19B6E55D52D2473BE17A4AFD9_954571273 = (createTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_490977014 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_490977014;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.086 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "17C254B6B3A4EB895B57BA434B23F710")
    public long getConnectTime() {
        long var2A390E9117109AD2E2B8D0011E8B167F_148441320 = (connectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1838092146 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1838092146;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.086 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "5D5C61E6CC3A22B61CA869D4E3BED50F")
    public long getDisconnectTime() {
        long varAD92DC1F9C0B5401DB7C9C68DE643AD5_68497368 = (disconnectTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1509242724 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1509242724;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.086 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "62FF7D865D2ADA8E92584A727D70C11F")
    public long getDurationMillis() {
    if(connectTimeReal == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_887643051 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_643375223 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_643375223;
        } //End block
        else
    if(duration == 0)        
        {
            long var0E51B42E3AFE6CDC7CBD85F000104A04_174783815 = (SystemClock.elapsedRealtime() - connectTimeReal);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_51035827 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_51035827;
        } //End block
        else
        {
            long varB85EC314BF443B797EF8A66B3B03F8A4_1096948917 = (duration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1929965739 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1929965739;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.087 -0400", hash_original_method = "7462D7508B2729C8A635CC5C7FC6CE68", hash_generated_method = "2091907C448EECF883397CAAFFBB754E")
    public long getHoldDurationMillis() {
    if(getState() != GsmCall.State.HOLDING)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_694822235 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1551585348 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1551585348;
        } //End block
        else
        {
            long var4D3CB05626CB322D40708E297E465B19_1696788213 = (SystemClock.elapsedRealtime() - holdingStartTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_723907257 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_723907257;
        } //End block
        // ---------- Original Method ----------
        //if (getState() != GsmCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.087 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "B1E2ACDC4B3F4EFADFC3494189429E5F")
    public DisconnectCause getDisconnectCause() {
DisconnectCause var3C8F3313F49435961542E8707E527956_1946890852 =         cause;
        var3C8F3313F49435961542E8707E527956_1946890852.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_1946890852;
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.087 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "34C5AB644C03A083887FA198C388B194")
    public boolean isIncoming() {
        boolean varBC23EBAFF55FFCC779696072ED387D2F_1064758746 = (isIncoming);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840017612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840017612;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.087 -0400", hash_original_method = "398AF7C0214E451C29E7D60E02DBA909", hash_generated_method = "AB16A200A4B1BB87214EF77271EBC089")
    public GsmCall.State getState() {
    if(disconnected)        
        {
GsmCall.State var93E5BEAE78EC7BB883980F16F28D3F7F_650834092 =             GsmCall.State.DISCONNECTED;
            var93E5BEAE78EC7BB883980F16F28D3F7F_650834092.addTaint(taint);
            return var93E5BEAE78EC7BB883980F16F28D3F7F_650834092;
        } //End block
        else
        {
GsmCall.State varB2F6DC77C80BF408EE3A0FF5E79E41E6_1351029234 =             super.getState();
            varB2F6DC77C80BF408EE3A0FF5E79E41E6_1351029234.addTaint(taint);
            return varB2F6DC77C80BF408EE3A0FF5E79E41E6_1351029234;
        } //End block
        // ---------- Original Method ----------
        //if (disconnected) {
            //return GsmCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.088 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "F39BAA01F152574665EF3D7BBE9465E8")
    public void hangup() throws CallStateException {
    if(!disconnected)        
        {
            owner.hangup(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_250552733 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_250552733.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_250552733;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.hangup(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.088 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "51CB0744C7372BFEC456F7494A9F9AB0")
    public void separate() throws CallStateException {
    if(!disconnected)        
        {
            owner.separate(this);
        } //End block
        else
        {
            CallStateException var9F0A1BB767273E5B72754F1932D273E4_1904964705 = new CallStateException ("disconnected");
            var9F0A1BB767273E5B72754F1932D273E4_1904964705.addTaint(taint);
            throw var9F0A1BB767273E5B72754F1932D273E4_1904964705;
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.separate(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.088 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "F90BB3BFB62332B9A3814530C62F9395")
    public PostDialState getPostDialState() {
PostDialState varA5212BBA7CEDC5476DB20427B201984F_69930283 =         postDialState;
        varA5212BBA7CEDC5476DB20427B201984F_69930283.addTaint(taint);
        return varA5212BBA7CEDC5476DB20427B201984F_69930283;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.089 -0400", hash_original_method = "7FC9A5882D286ABFCC1FEE503B1B4BF9", hash_generated_method = "F9A4ED0B8C75FD216BAA102E5E264689")
    public void proceedAfterWaitChar() {
    if(postDialState != PostDialState.WAIT)        
        {
            return;
        } //End block
        setPostDialState(PostDialState.STARTED);
        processNextPostDialChar();
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.WAIT) {
            //Log.w(LOG_TAG, "GsmConnection.proceedAfterWaitChar(): Expected "
                //+ "getPostDialState() to be WAIT but was " + postDialState);
            //return;
        //}
        //setPostDialState(PostDialState.STARTED);
        //processNextPostDialChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.089 -0400", hash_original_method = "0C656170567C6DC06B89DB468E951CD9", hash_generated_method = "B2D8273FD08380C4F705AAFB46DE1697")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.090 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.090 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.090 -0400", hash_original_method = "DC25F8C05B93479710BEF2CD72CB101B", hash_generated_method = "2F681458405436F09AA21A5CEC3CBF50")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        addTaint(causeCode);
switch(causeCode){
        case CallFailCause.USER_BUSY:
DisconnectCause varD2DF84FFC9BA616CBCBA3F0FE59C873F_366148475 =         DisconnectCause.BUSY;
        varD2DF84FFC9BA616CBCBA3F0FE59C873F_366148475.addTaint(taint);
        return varD2DF84FFC9BA616CBCBA3F0FE59C873F_366148475;
        case CallFailCause.NO_CIRCUIT_AVAIL:
        case CallFailCause.TEMPORARY_FAILURE:
        case CallFailCause.SWITCHING_CONGESTION:
        case CallFailCause.CHANNEL_NOT_AVAIL:
        case CallFailCause.QOS_NOT_AVAIL:
        case CallFailCause.BEARER_NOT_AVAIL:
DisconnectCause varE1E8481615DCF7AD24466AE126D9E63D_826756557 =         DisconnectCause.CONGESTION;
        varE1E8481615DCF7AD24466AE126D9E63D_826756557.addTaint(taint);
        return varE1E8481615DCF7AD24466AE126D9E63D_826756557;
        case CallFailCause.ACM_LIMIT_EXCEEDED:
DisconnectCause var28EC0BD504B7AF6E3EB037C6627E06B0_1117561546 =         DisconnectCause.LIMIT_EXCEEDED;
        var28EC0BD504B7AF6E3EB037C6627E06B0_1117561546.addTaint(taint);
        return var28EC0BD504B7AF6E3EB037C6627E06B0_1117561546;
        case CallFailCause.CALL_BARRED:
DisconnectCause var33E373DEFC5372A2CA9459FB8EE82A29_1733090309 =         DisconnectCause.CALL_BARRED;
        var33E373DEFC5372A2CA9459FB8EE82A29_1733090309.addTaint(taint);
        return var33E373DEFC5372A2CA9459FB8EE82A29_1733090309;
        case CallFailCause.FDN_BLOCKED:
DisconnectCause varFC6EBF80C57CE323DF25B9404743E45F_794098013 =         DisconnectCause.FDN_BLOCKED;
        varFC6EBF80C57CE323DF25B9404743E45F_794098013.addTaint(taint);
        return varFC6EBF80C57CE323DF25B9404743E45F_794098013;
        case CallFailCause.UNOBTAINABLE_NUMBER:
DisconnectCause varF728D16FBB3D36B0E2C84F33B94FC41A_539829454 =         DisconnectCause.UNOBTAINABLE_NUMBER;
        varF728D16FBB3D36B0E2C84F33B94FC41A_539829454.addTaint(taint);
        return varF728D16FBB3D36B0E2C84F33B94FC41A_539829454;
        case CallFailCause.ERROR_UNSPECIFIED:
        case CallFailCause.NORMAL_CLEARING:
        default:
        GSMPhone phone = owner.phone;
        int serviceState = phone.getServiceState().getState();
    if(serviceState == ServiceState.STATE_POWER_OFF)        
        {
DisconnectCause varB5A548D4E8E9956A6B17DAA602130C2E_1232222667 =             DisconnectCause.POWER_OFF;
            varB5A548D4E8E9956A6B17DAA602130C2E_1232222667.addTaint(taint);
            return varB5A548D4E8E9956A6B17DAA602130C2E_1232222667;
        } //End block
        else
    if(serviceState == ServiceState.STATE_OUT_OF_SERVICE
                        || serviceState == ServiceState.STATE_EMERGENCY_ONLY)        
        {
DisconnectCause varC7C8C415DA4C9B549FC44EE39C9BE577_940354163 =             DisconnectCause.OUT_OF_SERVICE;
            varC7C8C415DA4C9B549FC44EE39C9BE577_940354163.addTaint(taint);
            return varC7C8C415DA4C9B549FC44EE39C9BE577_940354163;
        } //End block
        else
    if(phone.getIccCard().getState() != SimCard.State.READY)        
        {
DisconnectCause varBEDBF280E043E08987916CA3350BFE4A_2142121915 =             DisconnectCause.ICC_ERROR;
            varBEDBF280E043E08987916CA3350BFE4A_2142121915.addTaint(taint);
            return varBEDBF280E043E08987916CA3350BFE4A_2142121915;
        } //End block
        else
    if(causeCode == CallFailCause.ERROR_UNSPECIFIED)        
        {
    if(phone.mSST.mRestrictedState.isCsRestricted())            
            {
DisconnectCause var62363F0F3695EB75FF2AC0377F1A5BA7_1384252417 =                 DisconnectCause.CS_RESTRICTED;
                var62363F0F3695EB75FF2AC0377F1A5BA7_1384252417.addTaint(taint);
                return var62363F0F3695EB75FF2AC0377F1A5BA7_1384252417;
            } //End block
            else
    if(phone.mSST.mRestrictedState.isCsEmergencyRestricted())            
            {
DisconnectCause varE289700B42F495348D254C49E89EBE55_1641420295 =                 DisconnectCause.CS_RESTRICTED_EMERGENCY;
                varE289700B42F495348D254C49E89EBE55_1641420295.addTaint(taint);
                return varE289700B42F495348D254C49E89EBE55_1641420295;
            } //End block
            else
    if(phone.mSST.mRestrictedState.isCsNormalRestricted())            
            {
DisconnectCause varF82392BD04BBC5C798F4657162F3EB3F_1020870944 =                 DisconnectCause.CS_RESTRICTED_NORMAL;
                varF82392BD04BBC5C798F4657162F3EB3F_1020870944.addTaint(taint);
                return varF82392BD04BBC5C798F4657162F3EB3F_1020870944;
            } //End block
            else
            {
DisconnectCause varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1972150973 =                 DisconnectCause.ERROR_UNSPECIFIED;
                varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1972150973.addTaint(taint);
                return varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_1972150973;
            } //End block
        } //End block
        else
    if(causeCode == CallFailCause.NORMAL_CLEARING)        
        {
DisconnectCause varEE0E8A8143B9D21A7A986AA8541D8AF4_1047478679 =             DisconnectCause.NORMAL;
            varEE0E8A8143B9D21A7A986AA8541D8AF4_1047478679.addTaint(taint);
            return varEE0E8A8143B9D21A7A986AA8541D8AF4_1047478679;
        } //End block
        else
        {
DisconnectCause varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_24673545 =             DisconnectCause.ERROR_UNSPECIFIED;
            varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_24673545.addTaint(taint);
            return varC8CDCB9D5A5BB9B45130E99DF5EA2CE8_24673545;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.091 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "2B64FFEED2AC71B83DA0C46F70DF5CB5")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(causeCode);
        onDisconnect(disconnectCauseFromCode(causeCode));
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.092 -0400", hash_original_method = "9BE79A12D6DD94045CB54AF328E4EC88", hash_generated_method = "03EDB42CC6B92C09817F2A398B9CA2AE")
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        this.cause = cause;
    if(!disconnected)        
        {
            index = -1;
            disconnectTime = System.currentTimeMillis();
            duration = SystemClock.elapsedRealtime() - connectTimeReal;
            disconnected = true;
    if(false)            
            Log.d(LOG_TAG,
                    "[GSMConn] onDisconnect: cause=" + cause);
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
            //index = -1;
            //disconnectTime = System.currentTimeMillis();
            //duration = SystemClock.elapsedRealtime() - connectTimeReal;
            //disconnected = true;
            //if (false) Log.d(LOG_TAG,
                    //"[GSMConn] onDisconnect: cause=" + cause);
            //owner.phone.notifyDisconnect(this);
            //if (parent != null) {
                //parent.connectionDisconnected(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.093 -0400", hash_original_method = "96B42EEDFF6F1EDC58573CD6BAE53841", hash_generated_method = "611CD3A58ADFC948069072EDAD32008B")
     boolean update(DriverCall dc) {
        GsmCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == GsmCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
    if(!equalsHandlesNulls(address, dc.number))        
        {
    if(Phone.DEBUG_PHONE)            
            log("update: phone # changed!");
            address = dc.number;
            changed = true;
        } //End block
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
                "update: parent=" + parent +
                ", hasNewParent=" + (newParent != parent) +
                ", wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
    if(wasConnectingInOrOut && !isConnectingInOrOut())        
        {
            onConnectedInOrOut();
        } //End block
    if(changed && !wasHolding && (getState() == GsmCall.State.HOLDING))        
        {
            onStartedHolding();
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_2112530728 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549243274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549243274;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.094 -0400", hash_original_method = "C488B13192B412621BF84C3D483CEE4F", hash_generated_method = "D2C58C2E973E537F7EECF0F7DDDD8CF2")
     void fakeHoldBeforeDial() {
    if(parent != null)        
        {
            parent.detach(this);
        } //End block
        parent = owner.backgroundCall;
        parent.attachFake(this, GsmCall.State.HOLDING);
        onStartedHolding();
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.detach(this);
        //}
        //parent = owner.backgroundCall;
        //parent.attachFake(this, GsmCall.State.HOLDING);
        //onStartedHolding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.094 -0400", hash_original_method = "CA6F3BC3A0E7C25CF1D3A00C4B3FEC79", hash_generated_method = "61C7C7B7E6C8654EB01D6C6FCF446D56")
     int getGSMIndex() throws CallStateException {
    if(index >= 0)        
        {
            int varA2687A7C7EA79F31F8AD4DF5FB404647_1168650624 = (index + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484360464 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484360464;
        } //End block
        else
        {
            CallStateException var5A775B435E0B79956794BF5D30451A3A_2110848279 = new CallStateException ("GSM index not yet assigned");
            var5A775B435E0B79956794BF5D30451A3A_2110848279.addTaint(taint);
            throw var5A775B435E0B79956794BF5D30451A3A_2110848279;
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("GSM index not yet assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.094 -0400", hash_original_method = "ABFB0B36CEC0E1D483C56AE8A85E75EC", hash_generated_method = "1622C44C62865EEADE2A74D6741D3B27")
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
        releaseWakeLock();
        // ---------- Original Method ----------
        //connectTime = System.currentTimeMillis();
        //connectTimeReal = SystemClock.elapsedRealtime();
        //duration = 0;
        //if (Phone.DEBUG_PHONE) {
            //log("onConnectedInOrOut: connectTime=" + connectTime);
        //}
        //if (!isIncoming) {
            //processNextPostDialChar();
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.095 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.096 -0400", hash_original_method = "ED55B5B85F7807A50A99A17BF067C0B0", hash_generated_method = "57B7983E6AFBF941747D40F1067DEABA")
    private boolean processPostDialChar(char c) {
        addTaint(c);
    if(PhoneNumberUtils.is12Key(c))        
        {
            owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        } //End block
        else
    if(c == PhoneNumberUtils.PAUSE)        
        {
    if(nextPostDialChar == 1)            
            {
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_FIRST_MILLIS);
            } //End block
            else
            {
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
            } //End block
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
            boolean var68934A3E9455FA72420237EB05902327_1856738388 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451100105 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451100105;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2081720541 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703905234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703905234;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.096 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "C0409651C4737BC939467E3C63C5A723")
    public String getRemainingPostDialString() {
    if(postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2013651203 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2013651203.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2013651203;
        } //End block
String var1129EB08E954CD256D4EF667275C80A7_1458454526 =         postDialString.substring(nextPostDialChar);
        var1129EB08E954CD256D4EF667275C80A7_1458454526.addTaint(taint);
        return var1129EB08E954CD256D4EF667275C80A7_1458454526;
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
            //|| postDialState == PostDialState.COMPLETE
            //|| postDialString == null
            //|| postDialString.length() <= nextPostDialChar
        //) {
            //return "";
        //}
        //return postDialString.substring(nextPostDialChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.097 -0400", hash_original_method = "0A00BE85F59605F9BA59170C28959531", hash_generated_method = "1183BEBEE0655D6AC4F38CB304BD9DDA")
    @Override
    protected void finalize() {
    if(mPartialWakeLock.isHeld())        
        {
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[GSMConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.098 -0400", hash_original_method = "B0F082CCF01CD3AE555892AF55A9C3FC", hash_generated_method = "52CCBE8B2FCEF37E1A1291B0E3C578DA")
    private void processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;
    if(postDialState == PostDialState.CANCELLED)        
        {
            return;
        } //End block
    if(postDialString == null ||
                postDialString.length() <= nextPostDialChar)        
        {
            setPostDialState(PostDialState.COMPLETE);
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
    if(postDialHandler != null
                && (notifyMessage = postDialHandler.messageForRegistrant()) != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.098 -0400", hash_original_method = "42A83CA5C5D82F280A6650571B6091DC", hash_generated_method = "48EDF2A2F1A5B6250FF27D8FCFDCBB04")
    private boolean isConnectingInOrOut() {
        boolean var9DDCB50C00CA33B6E52C4B0D27604257_1613536418 = (parent == null || parent == owner.ringingCall
            || parent.state == GsmCall.State.DIALING
            || parent.state == GsmCall.State.ALERTING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819029917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819029917;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == GsmCall.State.DIALING
            //|| parent.state == GsmCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.099 -0400", hash_original_method = "0BC976C46EE0BD1C914FEB75FAA745AD", hash_generated_method = "E89A0BA6DB843B77FAE387537B84C1CB")
    private GsmCall parentFromDCState(DriverCall.State state) {
        addTaint(state.getTaint());
switch(state){
        case ACTIVE:
        case DIALING:
        case ALERTING:
GsmCall varC102678DE4CE1C7B17F4189381EF06A7_785446008 =         owner.foregroundCall;
        varC102678DE4CE1C7B17F4189381EF06A7_785446008.addTaint(taint);
        return varC102678DE4CE1C7B17F4189381EF06A7_785446008;
        case HOLDING:
GsmCall varA426A0A6C423A974DB19CD194B07865A_1007096887 =         owner.backgroundCall;
        varA426A0A6C423A974DB19CD194B07865A_1007096887.addTaint(taint);
        return varA426A0A6C423A974DB19CD194B07865A_1007096887;
        case INCOMING:
        case WAITING:
GsmCall varC0AC0CA56D4A71D743E3F1BD12ED290B_1397655211 =         owner.ringingCall;
        varC0AC0CA56D4A71D743E3F1BD12ED290B_1397655211.addTaint(taint);
        return varC0AC0CA56D4A71D743E3F1BD12ED290B_1397655211;
        default:
        RuntimeException var0C856D8E8320CBACC5D8B230F765BAA8_450905740 = new RuntimeException("illegal call state: " + state);
        var0C856D8E8320CBACC5D8B230F765BAA8_450905740.addTaint(taint);
        throw var0C856D8E8320CBACC5D8B230F765BAA8_450905740;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.099 -0400", hash_original_method = "845314D50CD91AD375633BF061F59C00", hash_generated_method = "DB23C2EC5FB44232FB2E0499B430E268")
    private void setPostDialState(PostDialState s) {
    if(postDialState != PostDialState.STARTED
                && s == PostDialState.STARTED)        
        {
            acquireWakeLock();
            Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        } //End block
        else
    if(postDialState == PostDialState.STARTED
                && s != PostDialState.STARTED)        
        {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        } //End block
        postDialState = s;
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.STARTED
                //&& s == PostDialState.STARTED) {
            //acquireWakeLock();
            //Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            //h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        //} else if (postDialState == PostDialState.STARTED
                //&& s != PostDialState.STARTED) {
            //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            //releaseWakeLock();
        //}
        //postDialState = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.100 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "EAAFC0E2C4C27B5B5C8A84464E5BC79D")
    private void createWakeLock(Context context) {
        addTaint(context.getTaint());
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.100 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.100 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "655A9C93A6A7AEB2604B2CC2E97ADF64")
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
        //synchronized(mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.100 -0400", hash_original_method = "7502A69F3ECD37971405A81286CC5AAF", hash_generated_method = "6E0183367681C66BD7744A7D0D4D48B2")
    private void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[GSMConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GSMConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.101 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "918472C7DC3A72894BECC9762BF2FF88")
    @Override
    public int getNumberPresentation() {
        int varF00A6033EECCE0EBD17BDAAC2E6671A9_459634424 = (numberPresentation);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827481948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827481948;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.101 -0400", hash_original_method = "00708DAD150C484ADEE163A005CDF57B", hash_generated_method = "EAD3A5D19E43366B88218B0E2C647F5E")
    @Override
    public UUSInfo getUUSInfo() {
UUSInfo varA895D46E646801B5946947C8C017318B_303430981 =         uusInfo;
        varA895D46E646801B5946947C8C017318B_303430981.addTaint(taint);
        return varA895D46E646801B5946947C8C017318B_303430981;
        // ---------- Original Method ----------
        //return uusInfo;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.101 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.101 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "379856D1922C03BCEBAC6EFF68A63B7F")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "2C8C5B20CE92AFD3EA21B4CAE746E5A0", hash_generated_field = "03FF742B1D8A48B6BE32674B6F48BF75")

    static final int PAUSE_DELAY_FIRST_MILLIS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "3248E01A022251CEB250E1418C7AA8F1", hash_generated_field = "C6EAA5B8EED26E74A3179FF8DE2F06A0")

    static final int PAUSE_DELAY_MILLIS = 3 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:27.102 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
}

