package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.403 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "EC13D736730A652A8D5F62206A0EDCDD")

    GsmCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "B06E6373CFB44BD5F02CE42C64608D89", hash_generated_field = "34C14CFE94A5D0F7C643E2D0DC23FCE9")

    UUSInfo uusInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.404 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.405 -0400", hash_original_method = "A76DAF9D6C007596CB909A2D96D7B6D3", hash_generated_method = "47B4783C73FD7C025779087C81F36B56")
      GsmConnection(Context context, DriverCall dc, GsmCallTracker ct, int index) {
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.405 -0400", hash_original_method = "1891CC0C108558254961316EC04BF5C2", hash_generated_method = "2D9B2B8FCD1B8A721910B8F6633F0259")
      GsmConnection(Context context, String dialString, GsmCallTracker ct, GsmCall parent) {
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.406 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.406 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "8234893539011CA0CBD6A88DABC240EB")
     boolean compareTo(DriverCall c) {
        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean var6A332DE396C17CD19C189EA4D870C286_1725293173 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857725517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857725517;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.407 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "B0028875E3030F1584A0FF4B8170789D")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_26097192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_26097192 = address;
        varB4EAC82CA7396A68D541C85D26508E83_26097192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_26097192;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.407 -0400", hash_original_method = "B5FB9A2BDC3179E224BACAD787EF2D05", hash_generated_method = "C7C919829B4EF2E5F827FBCF2C9AA5D7")
    public GsmCall getCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_49278227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_49278227 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_49278227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_49278227;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.408 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "3F5ACD259C2D9D40A28274469DD9DE8E")
    public long getCreateTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1321048319 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1321048319;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.408 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "51A7200CB909330E3E9A3D1B8B77873B")
    public long getConnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1549413093 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1549413093;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.409 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "BD5969CA7C8593B3852FEEE7B61F9FB4")
    public long getDisconnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_562884294 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_562884294;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.409 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "F9BD0CE7599759C964A078EC6A55E6F2")
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_88267291 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1314778730 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1314778730;
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration == 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.409 -0400", hash_original_method = "7462D7508B2729C8A635CC5C7FC6CE68", hash_generated_method = "27455A759372F7322F63F3B2C16B1581")
    public long getHoldDurationMillis() {
        {
            boolean var1FCDEA306A526D01DBB4ECC8B843377F_1510449056 = (getState() != GsmCall.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_493609826 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1697946480 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1697946480;
        // ---------- Original Method ----------
        //if (getState() != GsmCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.410 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "61AC7FB572203112B5152AEAC5536597")
    public DisconnectCause getDisconnectCause() {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_332809121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_332809121 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_332809121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332809121;
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.410 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "1E836B1F0BDBD0707E5A3944C73C9664")
    public boolean isIncoming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556644800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556644800;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.410 -0400", hash_original_method = "398AF7C0214E451C29E7D60E02DBA909", hash_generated_method = "9B37BDF57E9356121D7FCC2F0A48ECC2")
    public GsmCall.State getState() {
        GsmCall.State varB4EAC82CA7396A68D541C85D26508E83_1102789061 = null; //Variable for return #1
        GsmCall.State varB4EAC82CA7396A68D541C85D26508E83_617585153 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1102789061 = GsmCall.State.DISCONNECTED;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_617585153 = super.getState();
        } //End block
        GsmCall.State varA7E53CE21691AB073D9660D615818899_1342101301; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1342101301 = varB4EAC82CA7396A68D541C85D26508E83_1102789061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1342101301 = varB4EAC82CA7396A68D541C85D26508E83_617585153;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1342101301.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1342101301;
        // ---------- Original Method ----------
        //if (disconnected) {
            //return GsmCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.411 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "95C25B9F17CBA9FBBFEE5D205D9A3D89")
    public void hangup() throws CallStateException {
        {
            owner.hangup(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("disconnected");
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.hangup(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.411 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "9EA3AEE9D5903810DE288024DD91C72F")
    public void separate() throws CallStateException {
        {
            owner.separate(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("disconnected");
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.separate(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.411 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "31E23CA5C39B41340221B629A1A9B443")
    public PostDialState getPostDialState() {
        PostDialState varB4EAC82CA7396A68D541C85D26508E83_142706111 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_142706111 = postDialState;
        varB4EAC82CA7396A68D541C85D26508E83_142706111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_142706111;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.412 -0400", hash_original_method = "7FC9A5882D286ABFCC1FEE503B1B4BF9", hash_generated_method = "24F6AE4A8387FAA7DFEF7282333F8267")
    public void proceedAfterWaitChar() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.412 -0400", hash_original_method = "0C656170567C6DC06B89DB468E951CD9", hash_generated_method = "4F24F4B316C9CECC7BDE5CA2F94F1C3A")
    public void proceedAfterWildChar(String str) {
        setPostDialState(PostDialState.STARTED);
        {
            boolean playedTone = false;
            int len = (str != null ? str.length() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                int i = 0;
                {
                    char c = str.charAt(i);
                    Message msg = null;
                    {
                        msg = h.obtainMessage(EVENT_DTMF_DONE);
                    } //End block
                    {
                        boolean var3511F6C9B7B285C8848DD8FAF73BEEA8_1336880067 = (PhoneNumberUtils.is12Key(c));
                        {
                            owner.cm.sendDtmf(c, msg);
                            playedTone = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                processNextPostDialChar();
            } //End block
        } //End block
        {
            StringBuilder buf = new StringBuilder(str);
            buf.append(postDialString.substring(nextPostDialChar));
            postDialString = buf.toString();
            nextPostDialChar = 0;
            {
                log("proceedAfterWildChar: new postDialString is " +
                        postDialString);
            } //End block
            processNextPostDialChar();
        } //End block
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.412 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.413 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.414 -0400", hash_original_method = "DC25F8C05B93479710BEF2CD72CB101B", hash_generated_method = "4827D224FF48DF7E3234AA56EE35D8B8")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1886324469 = null; //Variable for return #1
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1583526467 = null; //Variable for return #2
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_357361859 = null; //Variable for return #3
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1954332085 = null; //Variable for return #4
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_881080214 = null; //Variable for return #5
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_70288816 = null; //Variable for return #6
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1836831856 = null; //Variable for return #7
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1984404707 = null; //Variable for return #8
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1056911099 = null; //Variable for return #9
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_980079155 = null; //Variable for return #10
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_529966783 = null; //Variable for return #11
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_233156147 = null; //Variable for return #12
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_780594290 = null; //Variable for return #13
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1304078690 = null; //Variable for return #14
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1346056981 = null; //Variable for return #15
        //Begin case CallFailCause.USER_BUSY 
        varB4EAC82CA7396A68D541C85D26508E83_1886324469 = DisconnectCause.BUSY;
        //End case CallFailCause.USER_BUSY 
        //Begin case CallFailCause.NO_CIRCUIT_AVAIL CallFailCause.TEMPORARY_FAILURE CallFailCause.SWITCHING_CONGESTION CallFailCause.CHANNEL_NOT_AVAIL CallFailCause.QOS_NOT_AVAIL CallFailCause.BEARER_NOT_AVAIL 
        varB4EAC82CA7396A68D541C85D26508E83_1583526467 = DisconnectCause.CONGESTION;
        //End case CallFailCause.NO_CIRCUIT_AVAIL CallFailCause.TEMPORARY_FAILURE CallFailCause.SWITCHING_CONGESTION CallFailCause.CHANNEL_NOT_AVAIL CallFailCause.QOS_NOT_AVAIL CallFailCause.BEARER_NOT_AVAIL 
        //Begin case CallFailCause.ACM_LIMIT_EXCEEDED 
        varB4EAC82CA7396A68D541C85D26508E83_357361859 = DisconnectCause.LIMIT_EXCEEDED;
        //End case CallFailCause.ACM_LIMIT_EXCEEDED 
        //Begin case CallFailCause.CALL_BARRED 
        varB4EAC82CA7396A68D541C85D26508E83_1954332085 = DisconnectCause.CALL_BARRED;
        //End case CallFailCause.CALL_BARRED 
        //Begin case CallFailCause.FDN_BLOCKED 
        varB4EAC82CA7396A68D541C85D26508E83_881080214 = DisconnectCause.FDN_BLOCKED;
        //End case CallFailCause.FDN_BLOCKED 
        //Begin case CallFailCause.UNOBTAINABLE_NUMBER 
        varB4EAC82CA7396A68D541C85D26508E83_70288816 = DisconnectCause.UNOBTAINABLE_NUMBER;
        //End case CallFailCause.UNOBTAINABLE_NUMBER 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        GSMPhone phone = owner.phone;
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        int serviceState = phone.getServiceState().getState();
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1836831856 = DisconnectCause.POWER_OFF;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1984404707 = DisconnectCause.OUT_OF_SERVICE;
        } //End block
        {
            boolean var5091C793378400668FE72A97939F15D8_564654198 = (phone.getIccCard().getState() != SimCard.State.READY);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1056911099 = DisconnectCause.ICC_ERROR;
            } //End block
            {
                {
                    boolean varA62FA2C2A980B99629B7CC6E6F15EA85_469207105 = (phone.mSST.mRestrictedState.isCsRestricted());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_980079155 = DisconnectCause.CS_RESTRICTED;
                    } //End block
                    {
                        boolean var37D2C9FD99D48B594DA94EC7638810B2_1977423016 = (phone.mSST.mRestrictedState.isCsEmergencyRestricted());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_529966783 = DisconnectCause.CS_RESTRICTED_EMERGENCY;
                        } //End block
                        {
                            boolean var9C5241B1025C58944F71E411BAB0F18A_469897201 = (phone.mSST.mRestrictedState.isCsNormalRestricted());
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_233156147 = DisconnectCause.CS_RESTRICTED_NORMAL;
                            } //End block
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_780594290 = DisconnectCause.ERROR_UNSPECIFIED;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1304078690 = DisconnectCause.NORMAL;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1346056981 = DisconnectCause.ERROR_UNSPECIFIED;
            } //End block
        } //End collapsed parenthetic
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        addTaint(causeCode);
        DisconnectCause varA7E53CE21691AB073D9660D615818899_1143205963; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1886324469;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1583526467;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_357361859;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1954332085;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_881080214;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_70288816;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1836831856;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1984404707;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1056911099;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_980079155;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_529966783;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_233156147;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_780594290;
                break;
            case 14: //Assign result for return ordinal #14
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1304078690;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1143205963 = varB4EAC82CA7396A68D541C85D26508E83_1346056981;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1143205963.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1143205963;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.415 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "B3C3159BD6CBC2613A9F6D73DE50EA65")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onDisconnect(disconnectCauseFromCode(causeCode));
        addTaint(causeCode);
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.415 -0400", hash_original_method = "9BE79A12D6DD94045CB54AF328E4EC88", hash_generated_method = "EC714BB30F591EC0956E1D1056AD1B07")
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        this.cause = cause;
        {
            index = -1;
            disconnectTime = System.currentTimeMillis();
            duration = SystemClock.elapsedRealtime() - connectTimeReal;
            disconnected = true;
            Log.d(LOG_TAG,
                    "[GSMConn] onDisconnect: cause=" + cause);
            owner.phone.notifyDisconnect(this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.417 -0400", hash_original_method = "96B42EEDFF6F1EDC58573CD6BAE53841", hash_generated_method = "9382473DCA208BE0D8989A8224072A18")
     boolean update(DriverCall dc) {
        GsmCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == GsmCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
        {
            boolean varE881044A72B93B862D308B06B4E2C746_70341009 = (!equalsHandlesNulls(address, dc.number));
            {
                log("update: phone # changed!");
                address = dc.number;
                changed = true;
            } //End block
        } //End collapsed parenthetic
        {
            {
                parent.detach(this);
            } //End block
            newParent.attach(this, dc);
            parent = newParent;
            changed = true;
        } //End block
        {
            boolean parentStateChange;
            parentStateChange = parent.update (this, dc);
            changed = changed || parentStateChange;
        } //End block
        log(
                "update: parent=" + parent +
                ", hasNewParent=" + (newParent != parent) +
                ", wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
        {
            boolean var06589BF74DE5997C8FC534FD1B427681_1500920545 = (wasConnectingInOrOut && !isConnectingInOrOut());
            {
                onConnectedInOrOut();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var39CF314BB7DEE265CDCBB3C2022EA156_596438777 = (changed && !wasHolding && (getState() == GsmCall.State.HOLDING));
            {
                onStartedHolding();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545249207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545249207;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.418 -0400", hash_original_method = "C488B13192B412621BF84C3D483CEE4F", hash_generated_method = "C1C80616B902D36A79AE71F71724562E")
     void fakeHoldBeforeDial() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.419 -0400", hash_original_method = "CA6F3BC3A0E7C25CF1D3A00C4B3FEC79", hash_generated_method = "8670E572457B0479F623D4EC774FCB0B")
     int getGSMIndex() throws CallStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("GSM index not yet assigned");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504103998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504103998;
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("GSM index not yet assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.420 -0400", hash_original_method = "ABFB0B36CEC0E1D483C56AE8A85E75EC", hash_generated_method = "E7EC8F4C90562CAF5D52E074F56A5E58")
     void onConnectedInOrOut() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        connectTime = System.currentTimeMillis();
        connectTimeReal = SystemClock.elapsedRealtime();
        duration = 0;
        {
            log("onConnectedInOrOut: connectTime=" + connectTime);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.420 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.422 -0400", hash_original_method = "ED55B5B85F7807A50A99A17BF067C0B0", hash_generated_method = "8FE821C490ED600D0596B5D3ED32DFA1")
    private boolean processPostDialChar(char c) {
        {
            boolean var5BF2C5BE7CCD2082ACD6C3DE182DDC82_1021137548 = (PhoneNumberUtils.is12Key(c));
            {
                owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
            } //End block
            {
                {
                    h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_FIRST_MILLIS);
                } //End block
                {
                    h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
                } //End block
            } //End block
            {
                setPostDialState(PostDialState.WAIT);
            } //End block
            {
                setPostDialState(PostDialState.WILD);
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393696728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393696728;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.426 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "5C9E73E81D700A4E3A64A8D0FE323EC8")
    public String getRemainingPostDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_545479665 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2074099770 = null; //Variable for return #2
        {
            boolean varCBE29C650BD63B7D36FF87F87B8A05C3_687081056 = (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_545479665 = "";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2074099770 = postDialString.substring(nextPostDialChar);
        String varA7E53CE21691AB073D9660D615818899_335629450; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_335629450 = varB4EAC82CA7396A68D541C85D26508E83_545479665;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_335629450 = varB4EAC82CA7396A68D541C85D26508E83_2074099770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_335629450.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_335629450;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.427 -0400", hash_original_method = "0A00BE85F59605F9BA59170C28959531", hash_generated_method = "04AF67B1D2194E8CDEEDDDBE48D86DF8")
    @Override
    protected void finalize() {
        {
            boolean varF1FD10BC172E73DC685D38B97B6A381A_2061096105 = (mPartialWakeLock.isHeld());
        } //End collapsed parenthetic
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[GSMConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.428 -0400", hash_original_method = "B0F082CCF01CD3AE555892AF55A9C3FC", hash_generated_method = "98FDC023B4A86CEFB079537F64B74806")
    private void processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;
        {
            boolean var8A7CFCBE4CC8CF2E3FB4275E7C0B692F_1506042201 = (postDialString == null ||
                postDialString.length() <= nextPostDialChar);
            {
                setPostDialState(PostDialState.COMPLETE);
                c = 0;
            } //End block
            {
                boolean isValid;
                setPostDialState(PostDialState.STARTED);
                c = postDialString.charAt(nextPostDialChar++);
                isValid = processPostDialChar(c);
                {
                    h.obtainMessage(EVENT_NEXT_POST_DIAL).sendToTarget();
                } //End block
            } //End block
        } //End collapsed parenthetic
        postDialHandler = owner.phone.mPostDialHandler;
        Message notifyMessage;
        {
            boolean varB7D67D389C6A58715F3756EDB58E607E_1021440324 = (postDialHandler != null
                && (notifyMessage = postDialHandler.messageForRegistrant()) != null);
            {
                PostDialState state = postDialState;
                AsyncResult ar = AsyncResult.forMessage(notifyMessage);
                ar.result = this;
                ar.userObj = state;
                notifyMessage.arg1 = c;
                notifyMessage.sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.429 -0400", hash_original_method = "42A83CA5C5D82F280A6650571B6091DC", hash_generated_method = "CB3704591E8F88212D9CCB002F59DAA2")
    private boolean isConnectingInOrOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627513387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_627513387;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == GsmCall.State.DIALING
            //|| parent.state == GsmCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.430 -0400", hash_original_method = "0BC976C46EE0BD1C914FEB75FAA745AD", hash_generated_method = "64C81853DD798B41302D75F5BE94621F")
    private GsmCall parentFromDCState(DriverCall.State state) {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_757640586 = null; //Variable for return #1
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_19302830 = null; //Variable for return #2
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_748490813 = null; //Variable for return #3
        //Begin case ACTIVE DIALING ALERTING 
        varB4EAC82CA7396A68D541C85D26508E83_757640586 = owner.foregroundCall;
        //End case ACTIVE DIALING ALERTING 
        //Begin case HOLDING 
        varB4EAC82CA7396A68D541C85D26508E83_19302830 = owner.backgroundCall;
        //End case HOLDING 
        //Begin case INCOMING WAITING 
        varB4EAC82CA7396A68D541C85D26508E83_748490813 = owner.ringingCall;
        //End case INCOMING WAITING 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("illegal call state: " + state);
        //End case default 
        addTaint(state.getTaint());
        GsmCall varA7E53CE21691AB073D9660D615818899_1487669435; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1487669435 = varB4EAC82CA7396A68D541C85D26508E83_757640586;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1487669435 = varB4EAC82CA7396A68D541C85D26508E83_19302830;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1487669435 = varB4EAC82CA7396A68D541C85D26508E83_748490813;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1487669435.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1487669435;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.431 -0400", hash_original_method = "845314D50CD91AD375633BF061F59C00", hash_generated_method = "15712781E6C52B5518673C4791E4EE69")
    private void setPostDialState(PostDialState s) {
        {
            acquireWakeLock();
            Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.432 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "1866A16F20E4745F204F38A3424D9B52")
    private void createWakeLock(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.433 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.433 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "BCDCBDB23D117F60EBCD1312116292AD")
    private void releaseWakeLock() {
        {
            {
                boolean var7AF9E96BF041CFB5FB2EBC225EA829D3_817112120 = (mPartialWakeLock.isHeld());
                {
                    log("releaseWakeLock");
                    mPartialWakeLock.release();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.434 -0400", hash_original_method = "7502A69F3ECD37971405A81286CC5AAF", hash_generated_method = "D56E63EDDB0F58EA4B20374C256B3BDD")
    private void log(String msg) {
        Log.d(LOG_TAG, "[GSMConn] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GSMConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.434 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "44CBF151E70ACFEE20E353B4EAE4F043")
    @Override
    public int getNumberPresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947204370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947204370;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_method = "00708DAD150C484ADEE163A005CDF57B", hash_generated_method = "C529868A8077690456AE91BAB5898357")
    @Override
    public UUSInfo getUUSInfo() {
        UUSInfo varB4EAC82CA7396A68D541C85D26508E83_672394872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_672394872 = uusInfo;
        varB4EAC82CA7396A68D541C85D26508E83_672394872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_672394872;
        // ---------- Original Method ----------
        //return uusInfo;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "82E315FF4D841CD23578FEA3A741B202")
        public void handleMessage(Message msg) {
            //Begin case EVENT_NEXT_POST_DIAL EVENT_DTMF_DONE EVENT_PAUSE_DONE 
            processNextPostDialChar();
            //End case EVENT_NEXT_POST_DIAL EVENT_DTMF_DONE EVENT_PAUSE_DONE 
            //Begin case EVENT_WAKE_LOCK_TIMEOUT 
            releaseWakeLock();
            //End case EVENT_WAKE_LOCK_TIMEOUT 
            addTaint(msg.getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "2C8C5B20CE92AFD3EA21B4CAE746E5A0", hash_generated_field = "03FF742B1D8A48B6BE32674B6F48BF75")

    static final int PAUSE_DELAY_FIRST_MILLIS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "3248E01A022251CEB250E1418C7AA8F1", hash_generated_field = "C6EAA5B8EED26E74A3179FF8DE2F06A0")

    static final int PAUSE_DELAY_MILLIS = 3 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.435 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
}

