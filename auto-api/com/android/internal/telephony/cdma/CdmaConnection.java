package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.305 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "0FC853D69B46537C5EADDE1D3144A296")

    CdmaCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "05B2F7F3A77F16B32088D3A5F859DA1D", hash_generated_field = "A86CFAAA1D8CDA1D974D232F92D46C54")

    String cnapName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "778094E282EEBED743C4D949C49552AA", hash_generated_field = "C4B8315EB90D5A6B253E1367ECCBDAE5")

    int cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.306 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.307 -0400", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "B5FDE1FC9A731A84F9F908B959C9923D")
      CdmaConnection(Context context, DriverCall dc, CdmaCallTracker ct, int index) {
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.308 -0400", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "6A13546D0C40A4A5A6648E7EF9A9DBC3")
      CdmaConnection(Context context, String dialString, CdmaCallTracker ct, CdmaCall parent) {
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
        {
            this.parent = parent;
            {
                parent.attachFake(this, CdmaCall.State.ACTIVE);
            } //End block
            {
                parent.attachFake(this, CdmaCall.State.DIALING);
            } //End block
        } //End block
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.309 -0400", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "B9B570ED1FEBC8F021ED323C04BC9333")
      CdmaConnection(Context context, CdmaCallWaitingNotification cw, CdmaCallTracker ct,
            CdmaCall parent) {
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.309 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
        static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.321 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "1F085F78FA894FB4D1E48F6A2287395E")
     boolean compareTo(DriverCall c) {
        String cAddress;
        cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean var6A332DE396C17CD19C189EA4D870C286_2099107853 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798555539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798555539;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.322 -0400", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "FC6D92756EBED034CC94E86434566EB5")
    public String getOrigDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_536800085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_536800085 = dialString;
        varB4EAC82CA7396A68D541C85D26508E83_536800085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_536800085;
        // ---------- Original Method ----------
        //return dialString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.323 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "A6DD1A46CB4A9F218200A8583F8116A3")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1168340625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1168340625 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1168340625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1168340625;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.323 -0400", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "880B4D8205144F6D724761C97E93BC8E")
    public String getCnapName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1496463094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1496463094 = cnapName;
        varB4EAC82CA7396A68D541C85D26508E83_1496463094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496463094;
        // ---------- Original Method ----------
        //return cnapName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.323 -0400", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "63D030B5BB9D9F38EDE51E99EF80167F")
    public int getCnapNamePresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291216419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291216419;
        // ---------- Original Method ----------
        //return cnapNamePresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.324 -0400", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "068817D4297D6C428FD025F63F687E7B")
    public CdmaCall getCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1173675636 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1173675636 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1173675636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173675636;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.324 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "9007B88F942BBB941C0C0B616A56FA7D")
    public long getCreateTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1547412386 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1547412386;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.324 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "0C734354B9D122595E69916614355682")
    public long getConnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_762343376 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_762343376;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.341 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "691A9258EB9293AD9CFBE09889E1A169")
    public long getDisconnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_466264073 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_466264073;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.353 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "BAC8D700CBE41CC38C686A9301767278")
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_1006837842 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1842036365 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1842036365;
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration == 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.353 -0400", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "018F83B3B83421426E249CBBC8357DEE")
    public long getHoldDurationMillis() {
        {
            boolean var3DCCE9B94C5A4DB6DBDF4AE746672EAF_903699955 = (getState() != CdmaCall.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_1790135993 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1365703640 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1365703640;
        // ---------- Original Method ----------
        //if (getState() != CdmaCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.354 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "3DBD7BB5DF97C3A12F5AE35538699E72")
    public DisconnectCause getDisconnectCause() {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1404840108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1404840108 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_1404840108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1404840108;
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.354 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "5827110A8CA59857D046889D615FE944")
    public boolean isIncoming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447039608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447039608;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.355 -0400", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "B298B27B81F2DD17A1EB1596FE458C7B")
    public CdmaCall.State getState() {
        CdmaCall.State varB4EAC82CA7396A68D541C85D26508E83_95347322 = null; //Variable for return #1
        CdmaCall.State varB4EAC82CA7396A68D541C85D26508E83_77620482 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_95347322 = CdmaCall.State.DISCONNECTED;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_77620482 = super.getState();
        } //End block
        CdmaCall.State varA7E53CE21691AB073D9660D615818899_1215914555; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1215914555 = varB4EAC82CA7396A68D541C85D26508E83_95347322;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1215914555 = varB4EAC82CA7396A68D541C85D26508E83_77620482;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1215914555.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1215914555;
        // ---------- Original Method ----------
        //if (disconnected) {
            //return CdmaCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.355 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "95C25B9F17CBA9FBBFEE5D205D9A3D89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.355 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "9EA3AEE9D5903810DE288024DD91C72F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.356 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "074AED1318CB0DDB53EE5F081F16CEB0")
    public PostDialState getPostDialState() {
        PostDialState varB4EAC82CA7396A68D541C85D26508E83_2072731352 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2072731352 = postDialState;
        varB4EAC82CA7396A68D541C85D26508E83_2072731352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072731352;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.356 -0400", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "B5A5F43B2D6BA699B87F1C4A827A83D7")
    public void proceedAfterWaitChar() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.357 -0400", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "8944D7FCCF952269F0A3E00A55B29567")
    public void proceedAfterWildChar(String str) {
        setPostDialState(PostDialState.STARTED);
        {
            boolean playedTone;
            playedTone = false;
            int len;
            len = (str != null ? str.length() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                int i;
                i = 0;
                {
                    char c;
                    c = str.charAt(i);
                    Message msg;
                    msg = null;
                    {
                        msg = h.obtainMessage(EVENT_DTMF_DONE);
                    } //End block
                    {
                        boolean var3511F6C9B7B285C8848DD8FAF73BEEA8_446818925 = (PhoneNumberUtils.is12Key(c));
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
            StringBuilder buf;
            buf = new StringBuilder(str);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.357 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.357 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.383 -0400", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "BF80432E3DA779752270757B07EA84C6")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_788377566 = null; //Variable for return #1
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_2066080787 = null; //Variable for return #2
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1087918327 = null; //Variable for return #3
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_568415872 = null; //Variable for return #4
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1851259941 = null; //Variable for return #5
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_805637051 = null; //Variable for return #6
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_182114899 = null; //Variable for return #7
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1904443700 = null; //Variable for return #8
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1648129084 = null; //Variable for return #9
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1980088993 = null; //Variable for return #10
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_395652564 = null; //Variable for return #11
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1291398855 = null; //Variable for return #12
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1390793751 = null; //Variable for return #13
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1911694634 = null; //Variable for return #14
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_202284292 = null; //Variable for return #15
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_457641077 = null; //Variable for return #16
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_396918676 = null; //Variable for return #17
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1662684180 = null; //Variable for return #18
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1438491169 = null; //Variable for return #19
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1216266440 = null; //Variable for return #20
        //Begin case CallFailCause.USER_BUSY 
        varB4EAC82CA7396A68D541C85D26508E83_788377566 = DisconnectCause.BUSY;
        //End case CallFailCause.USER_BUSY 
        //Begin case CallFailCause.NO_CIRCUIT_AVAIL 
        varB4EAC82CA7396A68D541C85D26508E83_2066080787 = DisconnectCause.CONGESTION;
        //End case CallFailCause.NO_CIRCUIT_AVAIL 
        //Begin case CallFailCause.ACM_LIMIT_EXCEEDED 
        varB4EAC82CA7396A68D541C85D26508E83_1087918327 = DisconnectCause.LIMIT_EXCEEDED;
        //End case CallFailCause.ACM_LIMIT_EXCEEDED 
        //Begin case CallFailCause.CALL_BARRED 
        varB4EAC82CA7396A68D541C85D26508E83_568415872 = DisconnectCause.CALL_BARRED;
        //End case CallFailCause.CALL_BARRED 
        //Begin case CallFailCause.FDN_BLOCKED 
        varB4EAC82CA7396A68D541C85D26508E83_1851259941 = DisconnectCause.FDN_BLOCKED;
        //End case CallFailCause.FDN_BLOCKED 
        //Begin case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE 
        varB4EAC82CA7396A68D541C85D26508E83_805637051 = DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
        //End case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE 
        //Begin case CallFailCause.CDMA_DROP 
        varB4EAC82CA7396A68D541C85D26508E83_182114899 = DisconnectCause.CDMA_DROP;
        //End case CallFailCause.CDMA_DROP 
        //Begin case CallFailCause.CDMA_INTERCEPT 
        varB4EAC82CA7396A68D541C85D26508E83_1904443700 = DisconnectCause.CDMA_INTERCEPT;
        //End case CallFailCause.CDMA_INTERCEPT 
        //Begin case CallFailCause.CDMA_REORDER 
        varB4EAC82CA7396A68D541C85D26508E83_1648129084 = DisconnectCause.CDMA_REORDER;
        //End case CallFailCause.CDMA_REORDER 
        //Begin case CallFailCause.CDMA_SO_REJECT 
        varB4EAC82CA7396A68D541C85D26508E83_1980088993 = DisconnectCause.CDMA_SO_REJECT;
        //End case CallFailCause.CDMA_SO_REJECT 
        //Begin case CallFailCause.CDMA_RETRY_ORDER 
        varB4EAC82CA7396A68D541C85D26508E83_395652564 = DisconnectCause.CDMA_RETRY_ORDER;
        //End case CallFailCause.CDMA_RETRY_ORDER 
        //Begin case CallFailCause.CDMA_ACCESS_FAILURE 
        varB4EAC82CA7396A68D541C85D26508E83_1291398855 = DisconnectCause.CDMA_ACCESS_FAILURE;
        //End case CallFailCause.CDMA_ACCESS_FAILURE 
        //Begin case CallFailCause.CDMA_PREEMPTED 
        varB4EAC82CA7396A68D541C85D26508E83_1390793751 = DisconnectCause.CDMA_PREEMPTED;
        //End case CallFailCause.CDMA_PREEMPTED 
        //Begin case CallFailCause.CDMA_NOT_EMERGENCY 
        varB4EAC82CA7396A68D541C85D26508E83_1911694634 = DisconnectCause.CDMA_NOT_EMERGENCY;
        //End case CallFailCause.CDMA_NOT_EMERGENCY 
        //Begin case CallFailCause.CDMA_ACCESS_BLOCKED 
        varB4EAC82CA7396A68D541C85D26508E83_202284292 = DisconnectCause.CDMA_ACCESS_BLOCKED;
        //End case CallFailCause.CDMA_ACCESS_BLOCKED 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        CDMAPhone phone;
        phone = owner.phone;
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        int serviceState;
        serviceState = phone.getServiceState().getState();
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        {
            varB4EAC82CA7396A68D541C85D26508E83_457641077 = DisconnectCause.POWER_OFF;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_396918676 = DisconnectCause.OUT_OF_SERVICE;
        } //End block
        {
            boolean var5318065248B225746CCB04257EE4FCAF_832927433 = (phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1662684180 = DisconnectCause.ICC_ERROR;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1438491169 = DisconnectCause.NORMAL;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1216266440 = DisconnectCause.ERROR_UNSPECIFIED;
            } //End block
        } //End collapsed parenthetic
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        addTaint(causeCode);
        DisconnectCause varA7E53CE21691AB073D9660D615818899_1588528206; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_788377566;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_2066080787;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1087918327;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_568415872;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1851259941;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_805637051;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_182114899;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1904443700;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1648129084;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1980088993;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_395652564;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1291398855;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1390793751;
                break;
            case 14: //Assign result for return ordinal #14
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1911694634;
                break;
            case 15: //Assign result for return ordinal #15
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_202284292;
                break;
            case 16: //Assign result for return ordinal #16
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_457641077;
                break;
            case 17: //Assign result for return ordinal #17
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_396918676;
                break;
            case 18: //Assign result for return ordinal #18
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1662684180;
                break;
            case 19: //Assign result for return ordinal #19
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1438491169;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1588528206 = varB4EAC82CA7396A68D541C85D26508E83_1216266440;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1588528206.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1588528206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.384 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "B3C3159BD6CBC2613A9F6D73DE50EA65")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onDisconnect(disconnectCauseFromCode(causeCode));
        addTaint(causeCode);
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.384 -0400", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "72B39D63D848895CFE8F29AD54F9CBA5")
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        this.cause = cause;
        {
            doDisconnect();
            Log.d(LOG_TAG,
                    "[CDMAConn] onDisconnect: cause=" + cause);
            owner.phone.notifyDisconnect(this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.385 -0400", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "CF8681A9D50E00434CB753048BF5237A")
     void onLocalDisconnect() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            doDisconnect();
            Log.d(LOG_TAG,
                    "[CDMAConn] onLoalDisconnect" );
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.392 -0400", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "AE7B5D72FD336CE741AEDDB1EC66242F")
     boolean update(DriverCall dc) {
        CdmaCall newParent;
        boolean changed;
        changed = false;
        boolean wasConnectingInOrOut;
        wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding;
        wasHolding = (getState() == CdmaCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
        log("parent= " +parent +", newParent= " + newParent);
        {
            boolean varE881044A72B93B862D308B06B4E2C746_472962513 = (!equalsHandlesNulls(address, dc.number));
            {
                log("update: phone # changed!");
                address = dc.number;
                changed = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF66A5F27CBDFB14ABE33A4866161657_13682356 = (TextUtils.isEmpty(dc.name));
            {
                {
                    boolean var7C19AFEC02610CDDD59D911E3D26C4DA_738771163 = (!TextUtils.isEmpty(cnapName));
                    {
                        changed = true;
                        cnapName = "";
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varF0DFECF36FC63723F9C46BF83DB19F78_141474778 = (!dc.name.equals(cnapName));
                {
                    changed = true;
                    cnapName = dc.name;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        log("--dssds----"+cnapName);
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;
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
                "Update, wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
        {
            boolean var06589BF74DE5997C8FC534FD1B427681_1628964118 = (wasConnectingInOrOut && !isConnectingInOrOut());
            {
                onConnectedInOrOut();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3036BA6BA6AAD044DE061F78357C6B88_2119099163 = (changed && !wasHolding && (getState() == CdmaCall.State.HOLDING));
            {
                onStartedHolding();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293115521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293115521;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.392 -0400", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "22169BE4E2819F9F2B45393E43081B53")
     void fakeHoldBeforeDial() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.395 -0400", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "D834F7BE03B7FB9C0A195EC493B2283B")
     int getCDMAIndex() throws CallStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CDMA connection index not assigned");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340738831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340738831;
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("CDMA connection index not assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.397 -0400", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "72C1AAD866A2C25266FF38699D7AD211")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.408 -0400", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "21162B02B62CC3BB8D40FD8D893D1D38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.408 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.413 -0400", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "EC5EF1985D84AEC547CB81952044E60B")
    private boolean processPostDialChar(char c) {
        {
            boolean var5BF2C5BE7CCD2082ACD6C3DE182DDC82_1292725533 = (PhoneNumberUtils.is12Key(c));
            {
                owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
            } //End block
            {
                setPostDialState(PostDialState.PAUSE);
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
            } //End block
            {
                setPostDialState(PostDialState.WAIT);
            } //End block
            {
                setPostDialState(PostDialState.WILD);
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215341293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215341293;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.424 -0400", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "13026A5DB2554BB27E62D660BBA3FC06")
    public String getRemainingPostDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_73782191 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2061856211 = null; //Variable for return #2
        {
            boolean var78E7EE5EE640C52F974C3F3F0E9A201B_1791664789 = (postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_73782191 = "";
            } //End block
        } //End collapsed parenthetic
        String subStr;
        subStr = postDialString.substring(nextPostDialChar);
        {
            int wIndex;
            wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            int pIndex;
            pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
            {
                subStr = subStr.substring(0, wIndex);
            } //End block
            {
                subStr = subStr.substring(0, pIndex);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2061856211 = subStr;
        String varA7E53CE21691AB073D9660D615818899_740330114; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_740330114 = varB4EAC82CA7396A68D541C85D26508E83_73782191;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_740330114 = varB4EAC82CA7396A68D541C85D26508E83_2061856211;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_740330114.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_740330114;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.425 -0400", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "A4174D978C660E4F226AF82F316B38CD")
    public void updateParent(CdmaCall oldParent, CdmaCall newParent) {
        {
            {
                oldParent.detach(this);
            } //End block
            newParent.attachFake(this, CdmaCall.State.ACTIVE);
            parent = newParent;
        } //End block
        addTaint(oldParent.getTaint());
        // ---------- Original Method ----------
        //if (newParent != oldParent) {
            //if (oldParent != null) {
                //oldParent.detach(this);
            //}
            //newParent.attachFake(this, CdmaCall.State.ACTIVE);
            //parent = newParent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.426 -0400", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "3B0AF792747923ED014EFE6DC207CE68")
    @Override
    protected void finalize() {
        {
            boolean varF1FD10BC172E73DC685D38B97B6A381A_1786117322 = (mPartialWakeLock.isHeld());
        } //End collapsed parenthetic
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.439 -0400", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "EBAE1B325692BC10085C57817EB5EA86")
     void processNextPostDialChar() {
        char c;
        c = 0;
        Registrant postDialHandler;
        {
            releaseWakeLock();
        } //End block
        {
            boolean var8A7CFCBE4CC8CF2E3FB4275E7C0B692F_399009160 = (postDialString == null ||
                postDialString.length() <= nextPostDialChar);
            {
                setPostDialState(PostDialState.COMPLETE);
                releaseWakeLock();
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
            boolean var12510AAE23ED58E74D3CE982EB9B37AD_924215668 = (postDialHandler != null &&
                (notifyMessage = postDialHandler.messageForRegistrant()) != null);
            {
                PostDialState state;
                state = postDialState;
                AsyncResult ar;
                ar = AsyncResult.forMessage(notifyMessage);
                ar.result = this;
                ar.userObj = state;
                notifyMessage.arg1 = c;
                notifyMessage.sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.439 -0400", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "51929DC113EA910F857DFA55E0B21F58")
    private boolean isConnectingInOrOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488017513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488017513;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == CdmaCall.State.DIALING
            //|| parent.state == CdmaCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.440 -0400", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "CDF86DD30609F29FE20E223A1B5B68DF")
    private CdmaCall parentFromDCState(DriverCall.State state) {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1311735567 = null; //Variable for return #1
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_613327899 = null; //Variable for return #2
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_2108289197 = null; //Variable for return #3
        //Begin case ACTIVE DIALING ALERTING 
        varB4EAC82CA7396A68D541C85D26508E83_1311735567 = owner.foregroundCall;
        //End case ACTIVE DIALING ALERTING 
        //Begin case HOLDING 
        varB4EAC82CA7396A68D541C85D26508E83_613327899 = owner.backgroundCall;
        //End case HOLDING 
        //Begin case INCOMING WAITING 
        varB4EAC82CA7396A68D541C85D26508E83_2108289197 = owner.ringingCall;
        //End case INCOMING WAITING 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("illegal call state: " + state);
        //End case default 
        addTaint(state.getTaint());
        CdmaCall varA7E53CE21691AB073D9660D615818899_844855713; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_844855713 = varB4EAC82CA7396A68D541C85D26508E83_1311735567;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_844855713 = varB4EAC82CA7396A68D541C85D26508E83_613327899;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_844855713 = varB4EAC82CA7396A68D541C85D26508E83_2108289197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_844855713.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_844855713;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.441 -0400", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "03746A7A73879D48189A35D69A4FD2DD")
    private void setPostDialState(PostDialState s) {
        {
            {
                {
                    boolean var6C6587FD0E036C04321BAEEA5C3E9D65_608723115 = (mPartialWakeLock.isHeld());
                    {
                        h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                    } //End block
                    {
                        acquireWakeLock();
                    } //End block
                } //End collapsed parenthetic
                Message msg;
                msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.444 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "7BA0C400148DECCFE5A0E4A6A7F15B47")
    private void createWakeLock(Context context) {
        PowerManager pm;
        pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.545 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.545 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "797E76B37AB59CFBDCCB4708450C0F0C")
    private void releaseWakeLock() {
        {
            {
                boolean var7AF9E96BF041CFB5FB2EBC225EA829D3_31115055 = (mPartialWakeLock.isHeld());
                {
                    log("releaseWakeLock");
                    mPartialWakeLock.release();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
        private static boolean isPause(char c) {
        return c == PhoneNumberUtils.PAUSE;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.547 -0400", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "5F5A47F67F63255E02E93F99622150E2")
    private void log(String msg) {
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.547 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "B990BC2029E82F628FBF4C10FD56C6A3")
    @Override
    public int getNumberPresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751638136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751638136;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.547 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "D5308198782E7EF22227CD4CB34BB576")
    @Override
    public UUSInfo getUUSInfo() {
        UUSInfo varB4EAC82CA7396A68D541C85D26508E83_23160202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_23160202 = null;
        varB4EAC82CA7396A68D541C85D26508E83_23160202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_23160202;
        // ---------- Original Method ----------
        //return null;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "82E315FF4D841CD23578FEA3A741B202")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "8602F066F15B8DB83834FFB3405C6195")

    static int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "3628FC5DC1511141A8B8C0DC43B6F183")

    static int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "2BCE328FA95D3A022AA3AD9E264106C4")

    static int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "8D5D4E0B53268E488478A7735C31CBD5")

    static int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "D07220517DDFF3EE2A5418E536B66F68")

    static int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.554 -0400", hash_original_field = "150B3B1EED2149C93D65E2E16D8B0C2A", hash_generated_field = "C60B1727316B4BE800E452744C91E5F0")

    static int PAUSE_DELAY_MILLIS = 2 * 1000;
}

