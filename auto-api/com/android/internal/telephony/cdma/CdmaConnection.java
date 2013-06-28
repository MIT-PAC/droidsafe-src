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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "0FC853D69B46537C5EADDE1D3144A296")

    CdmaCall parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "6BEE54DB0A5A8BDBAB5D2767D60E4A06", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "651EFD6FB9FDDF9C1713795AFFA34606", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "BC23EBAFF55FFCC779696072ED387D2F", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "3A561116F0C9675A3C83D21FA365050D", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "05B2F7F3A77F16B32088D3A5F859DA1D", hash_generated_field = "A86CFAAA1D8CDA1D974D232F92D46C54")

    String cnapName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "1ED2E1B19B6E55D52D2473BE17A4AFD9", hash_generated_field = "88A71A811D0CFD868BD514D9A7A9DADE")

    long createTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "2A390E9117109AD2E2B8D0011E8B167F", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "AD92DC1F9C0B5401DB7C9C68DE643AD5", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "109C61524952CEA8F4A768697A2B73EA", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "A2E64D805CF0AE78B184102EDC3BD0CA", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "0F847399DDED77AD45DD7EA28753707C", hash_generated_field = "6EBA36FD71F695F0A7004724AFD9D8F8")

    int nextPostDialChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "49B7DD8E3C021E93E1C2561230FF0A8C", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "9D7046FD56054C9553777648B65C3DFB", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "919D5B2A2D59B0077315014A855EE804", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "778094E282EEBED743C4D949C49552AA", hash_generated_field = "C4B8315EB90D5A6B253E1367ECCBDAE5")

    int cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.530 -0400", hash_original_field = "362C25534800BA6D1ACF57C4E902FFD0", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.532 -0400", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "B5FDE1FC9A731A84F9F908B959C9923D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.534 -0400", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "6A13546D0C40A4A5A6648E7EF9A9DBC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.535 -0400", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "B9B570ED1FEBC8F021ED323C04BC9333")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.536 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.538 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "BBDF14596FFF0E060948271F28A21704")
     boolean compareTo(DriverCall c) {
        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean var6A332DE396C17CD19C189EA4D870C286_442406378 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555039290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555039290;
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.540 -0400", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "803719ED35E428A9621FD347F4D65D44")
    public String getOrigDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_25032475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_25032475 = dialString;
        varB4EAC82CA7396A68D541C85D26508E83_25032475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25032475;
        // ---------- Original Method ----------
        //return dialString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.541 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "55CD5370CFCAC69D289DBC944B8D29A3")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1530841184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1530841184 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1530841184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530841184;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.541 -0400", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "D2E3019064170F9043B0ACEE84B12993")
    public String getCnapName() {
        String varB4EAC82CA7396A68D541C85D26508E83_365382881 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_365382881 = cnapName;
        varB4EAC82CA7396A68D541C85D26508E83_365382881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_365382881;
        // ---------- Original Method ----------
        //return cnapName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.542 -0400", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "043BC088EF93526E57D3998797AD6BD2")
    public int getCnapNamePresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520501249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520501249;
        // ---------- Original Method ----------
        //return cnapNamePresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.542 -0400", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "E581CE9499C7B1B55C0DA670238FF199")
    public CdmaCall getCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1821874635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1821874635 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1821874635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821874635;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.542 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "B50B4B193A632E9036B6CC04C1938052")
    public long getCreateTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1356188706 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1356188706;
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.543 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "4D46B86A0754AD8704B045A6D57D87FA")
    public long getConnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1840728291 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1840728291;
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.543 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "8B93398A86C3EF58E2CBFAC8A7680E9C")
    public long getDisconnectTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_785481467 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_785481467;
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.543 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "2E18BF7F89774DA5BDC724FC2BDE1DF0")
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_2023739118 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1124867232 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1124867232;
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration == 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.544 -0400", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "D18BBEB4734B4304B8D0382E14B309CD")
    public long getHoldDurationMillis() {
        {
            boolean var3DCCE9B94C5A4DB6DBDF4AE746672EAF_1999894997 = (getState() != CdmaCall.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_1633131164 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1082513342 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1082513342;
        // ---------- Original Method ----------
        //if (getState() != CdmaCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.545 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "C9FA4193A5CD9F0EEBC868DE173EF137")
    public DisconnectCause getDisconnectCause() {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1757100903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1757100903 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_1757100903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757100903;
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.545 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "0822D1302104C9D06808CC28101DA7A4")
    public boolean isIncoming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738791825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738791825;
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.546 -0400", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "E03B8C743CB02C38BA6148A617DD2A00")
    public CdmaCall.State getState() {
        CdmaCall.State varB4EAC82CA7396A68D541C85D26508E83_631422012 = null; //Variable for return #1
        CdmaCall.State varB4EAC82CA7396A68D541C85D26508E83_1740837571 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_631422012 = CdmaCall.State.DISCONNECTED;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1740837571 = super.getState();
        } //End block
        CdmaCall.State varA7E53CE21691AB073D9660D615818899_130843078; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_130843078 = varB4EAC82CA7396A68D541C85D26508E83_631422012;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_130843078 = varB4EAC82CA7396A68D541C85D26508E83_1740837571;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_130843078.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_130843078;
        // ---------- Original Method ----------
        //if (disconnected) {
            //return CdmaCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.546 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "95C25B9F17CBA9FBBFEE5D205D9A3D89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.547 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "9EA3AEE9D5903810DE288024DD91C72F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.547 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "FC7296922C71FFBAB1796B01540268B1")
    public PostDialState getPostDialState() {
        PostDialState varB4EAC82CA7396A68D541C85D26508E83_992575319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_992575319 = postDialState;
        varB4EAC82CA7396A68D541C85D26508E83_992575319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992575319;
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.548 -0400", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "B5A5F43B2D6BA699B87F1C4A827A83D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.549 -0400", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "A2BB418B52084A53984C5CCAD860C652")
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
                        boolean var3511F6C9B7B285C8848DD8FAF73BEEA8_881150331 = (PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.549 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.549 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.551 -0400", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "FA0DF89A1A448302D3D6A8B1CB5C01B2")
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_399727536 = null; //Variable for return #1
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_422606560 = null; //Variable for return #2
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1592335460 = null; //Variable for return #3
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1855891513 = null; //Variable for return #4
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_86515598 = null; //Variable for return #5
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_457519164 = null; //Variable for return #6
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1928552904 = null; //Variable for return #7
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1626199678 = null; //Variable for return #8
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_944329228 = null; //Variable for return #9
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1312152762 = null; //Variable for return #10
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1889312521 = null; //Variable for return #11
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_696936681 = null; //Variable for return #12
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1476341928 = null; //Variable for return #13
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_5310497 = null; //Variable for return #14
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1020229089 = null; //Variable for return #15
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1029934306 = null; //Variable for return #16
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1710270928 = null; //Variable for return #17
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_1661126900 = null; //Variable for return #18
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_830620649 = null; //Variable for return #19
        DisconnectCause varB4EAC82CA7396A68D541C85D26508E83_751845616 = null; //Variable for return #20
        //Begin case CallFailCause.USER_BUSY 
        varB4EAC82CA7396A68D541C85D26508E83_399727536 = DisconnectCause.BUSY;
        //End case CallFailCause.USER_BUSY 
        //Begin case CallFailCause.NO_CIRCUIT_AVAIL 
        varB4EAC82CA7396A68D541C85D26508E83_422606560 = DisconnectCause.CONGESTION;
        //End case CallFailCause.NO_CIRCUIT_AVAIL 
        //Begin case CallFailCause.ACM_LIMIT_EXCEEDED 
        varB4EAC82CA7396A68D541C85D26508E83_1592335460 = DisconnectCause.LIMIT_EXCEEDED;
        //End case CallFailCause.ACM_LIMIT_EXCEEDED 
        //Begin case CallFailCause.CALL_BARRED 
        varB4EAC82CA7396A68D541C85D26508E83_1855891513 = DisconnectCause.CALL_BARRED;
        //End case CallFailCause.CALL_BARRED 
        //Begin case CallFailCause.FDN_BLOCKED 
        varB4EAC82CA7396A68D541C85D26508E83_86515598 = DisconnectCause.FDN_BLOCKED;
        //End case CallFailCause.FDN_BLOCKED 
        //Begin case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE 
        varB4EAC82CA7396A68D541C85D26508E83_457519164 = DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
        //End case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE 
        //Begin case CallFailCause.CDMA_DROP 
        varB4EAC82CA7396A68D541C85D26508E83_1928552904 = DisconnectCause.CDMA_DROP;
        //End case CallFailCause.CDMA_DROP 
        //Begin case CallFailCause.CDMA_INTERCEPT 
        varB4EAC82CA7396A68D541C85D26508E83_1626199678 = DisconnectCause.CDMA_INTERCEPT;
        //End case CallFailCause.CDMA_INTERCEPT 
        //Begin case CallFailCause.CDMA_REORDER 
        varB4EAC82CA7396A68D541C85D26508E83_944329228 = DisconnectCause.CDMA_REORDER;
        //End case CallFailCause.CDMA_REORDER 
        //Begin case CallFailCause.CDMA_SO_REJECT 
        varB4EAC82CA7396A68D541C85D26508E83_1312152762 = DisconnectCause.CDMA_SO_REJECT;
        //End case CallFailCause.CDMA_SO_REJECT 
        //Begin case CallFailCause.CDMA_RETRY_ORDER 
        varB4EAC82CA7396A68D541C85D26508E83_1889312521 = DisconnectCause.CDMA_RETRY_ORDER;
        //End case CallFailCause.CDMA_RETRY_ORDER 
        //Begin case CallFailCause.CDMA_ACCESS_FAILURE 
        varB4EAC82CA7396A68D541C85D26508E83_696936681 = DisconnectCause.CDMA_ACCESS_FAILURE;
        //End case CallFailCause.CDMA_ACCESS_FAILURE 
        //Begin case CallFailCause.CDMA_PREEMPTED 
        varB4EAC82CA7396A68D541C85D26508E83_1476341928 = DisconnectCause.CDMA_PREEMPTED;
        //End case CallFailCause.CDMA_PREEMPTED 
        //Begin case CallFailCause.CDMA_NOT_EMERGENCY 
        varB4EAC82CA7396A68D541C85D26508E83_5310497 = DisconnectCause.CDMA_NOT_EMERGENCY;
        //End case CallFailCause.CDMA_NOT_EMERGENCY 
        //Begin case CallFailCause.CDMA_ACCESS_BLOCKED 
        varB4EAC82CA7396A68D541C85D26508E83_1020229089 = DisconnectCause.CDMA_ACCESS_BLOCKED;
        //End case CallFailCause.CDMA_ACCESS_BLOCKED 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        CDMAPhone phone = owner.phone;
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        int serviceState = phone.getServiceState().getState();
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1029934306 = DisconnectCause.POWER_OFF;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1710270928 = DisconnectCause.OUT_OF_SERVICE;
        } //End block
        {
            boolean var5318065248B225746CCB04257EE4FCAF_1845999541 = (phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1661126900 = DisconnectCause.ICC_ERROR;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_830620649 = DisconnectCause.NORMAL;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_751845616 = DisconnectCause.ERROR_UNSPECIFIED;
            } //End block
        } //End collapsed parenthetic
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        addTaint(causeCode);
        DisconnectCause varA7E53CE21691AB073D9660D615818899_1976136306; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_399727536;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_422606560;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1592335460;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1855891513;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_86515598;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_457519164;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1928552904;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1626199678;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_944329228;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1312152762;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1889312521;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_696936681;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1476341928;
                break;
            case 14: //Assign result for return ordinal #14
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_5310497;
                break;
            case 15: //Assign result for return ordinal #15
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1020229089;
                break;
            case 16: //Assign result for return ordinal #16
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1029934306;
                break;
            case 17: //Assign result for return ordinal #17
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1710270928;
                break;
            case 18: //Assign result for return ordinal #18
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_1661126900;
                break;
            case 19: //Assign result for return ordinal #19
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_830620649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1976136306 = varB4EAC82CA7396A68D541C85D26508E83_751845616;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1976136306.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1976136306;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.551 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "B3C3159BD6CBC2613A9F6D73DE50EA65")
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onDisconnect(disconnectCauseFromCode(causeCode));
        addTaint(causeCode);
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.552 -0400", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "72B39D63D848895CFE8F29AD54F9CBA5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.552 -0400", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "CF8681A9D50E00434CB753048BF5237A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.553 -0400", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "AE498B34696E0268FF91785D9D65FF76")
     boolean update(DriverCall dc) {
        CdmaCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == CdmaCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
        log("parent= " +parent +", newParent= " + newParent);
        {
            boolean varE881044A72B93B862D308B06B4E2C746_149880948 = (!equalsHandlesNulls(address, dc.number));
            {
                log("update: phone # changed!");
                address = dc.number;
                changed = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF66A5F27CBDFB14ABE33A4866161657_1302817127 = (TextUtils.isEmpty(dc.name));
            {
                {
                    boolean var7C19AFEC02610CDDD59D911E3D26C4DA_1614325402 = (!TextUtils.isEmpty(cnapName));
                    {
                        changed = true;
                        cnapName = "";
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varF0DFECF36FC63723F9C46BF83DB19F78_1943012383 = (!dc.name.equals(cnapName));
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
            boolean var06589BF74DE5997C8FC534FD1B427681_233670058 = (wasConnectingInOrOut && !isConnectingInOrOut());
            {
                onConnectedInOrOut();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3036BA6BA6AAD044DE061F78357C6B88_407581618 = (changed && !wasHolding && (getState() == CdmaCall.State.HOLDING));
            {
                onStartedHolding();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381134874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_381134874;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.553 -0400", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "22169BE4E2819F9F2B45393E43081B53")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.554 -0400", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "9AB8496E54511EAF839A2265B2B58059")
     int getCDMAIndex() throws CallStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CDMA connection index not assigned");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112378729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112378729;
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("CDMA connection index not assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.554 -0400", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "72C1AAD866A2C25266FF38699D7AD211")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.555 -0400", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "21162B02B62CC3BB8D40FD8D893D1D38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.556 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.557 -0400", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "E7D9D6470DDBEF47E006572BF5074151")
    private boolean processPostDialChar(char c) {
        {
            boolean var5BF2C5BE7CCD2082ACD6C3DE182DDC82_489892534 = (PhoneNumberUtils.is12Key(c));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11470831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_11470831;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.559 -0400", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "FE5DC6D8D1585C8268E156798D5EDDB0")
    public String getRemainingPostDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_862816971 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_760762537 = null; //Variable for return #2
        {
            boolean var78E7EE5EE640C52F974C3F3F0E9A201B_155059541 = (postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_862816971 = "";
            } //End block
        } //End collapsed parenthetic
        String subStr = postDialString.substring(nextPostDialChar);
        {
            int wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            int pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
            {
                subStr = subStr.substring(0, wIndex);
            } //End block
            {
                subStr = subStr.substring(0, pIndex);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_760762537 = subStr;
        String varA7E53CE21691AB073D9660D615818899_107829068; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_107829068 = varB4EAC82CA7396A68D541C85D26508E83_862816971;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_107829068 = varB4EAC82CA7396A68D541C85D26508E83_760762537;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_107829068.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_107829068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.559 -0400", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "A4174D978C660E4F226AF82F316B38CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.559 -0400", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "18BFC44477C37544668753FF73CCCF54")
    @Override
    protected void finalize() {
        {
            boolean varF1FD10BC172E73DC685D38B97B6A381A_1288644202 = (mPartialWakeLock.isHeld());
        } //End collapsed parenthetic
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.560 -0400", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "0173D0D0AB8EF4DE0EF54CEE93E3A55E")
     void processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;
        {
            releaseWakeLock();
        } //End block
        {
            boolean var8A7CFCBE4CC8CF2E3FB4275E7C0B692F_1879509703 = (postDialString == null ||
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
            boolean var12510AAE23ED58E74D3CE982EB9B37AD_1165719600 = (postDialHandler != null &&
                (notifyMessage = postDialHandler.messageForRegistrant()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.561 -0400", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "CCA17AF8C1290F1DE7AE0348739F9B50")
    private boolean isConnectingInOrOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534495750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534495750;
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == CdmaCall.State.DIALING
            //|| parent.state == CdmaCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.562 -0400", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "5FCC5B64B2244C719092042C040D9E0D")
    private CdmaCall parentFromDCState(DriverCall.State state) {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_2104994923 = null; //Variable for return #1
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1800813625 = null; //Variable for return #2
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_987533450 = null; //Variable for return #3
        //Begin case ACTIVE DIALING ALERTING 
        varB4EAC82CA7396A68D541C85D26508E83_2104994923 = owner.foregroundCall;
        //End case ACTIVE DIALING ALERTING 
        //Begin case HOLDING 
        varB4EAC82CA7396A68D541C85D26508E83_1800813625 = owner.backgroundCall;
        //End case HOLDING 
        //Begin case INCOMING WAITING 
        varB4EAC82CA7396A68D541C85D26508E83_987533450 = owner.ringingCall;
        //End case INCOMING WAITING 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("illegal call state: " + state);
        //End case default 
        addTaint(state.getTaint());
        CdmaCall varA7E53CE21691AB073D9660D615818899_637585131; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_637585131 = varB4EAC82CA7396A68D541C85D26508E83_2104994923;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_637585131 = varB4EAC82CA7396A68D541C85D26508E83_1800813625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_637585131 = varB4EAC82CA7396A68D541C85D26508E83_987533450;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_637585131.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_637585131;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.563 -0400", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "BEA4C27144527BC48A98FDC2BBE147ED")
    private void setPostDialState(PostDialState s) {
        {
            {
                {
                    boolean var6C6587FD0E036C04321BAEEA5C3E9D65_86656681 = (mPartialWakeLock.isHeld());
                    {
                        h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                    } //End block
                    {
                        acquireWakeLock();
                    } //End block
                } //End collapsed parenthetic
                Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.563 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "1866A16F20E4745F204F38A3424D9B52")
    private void createWakeLock(Context context) {
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.565 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.566 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "435B175C0A84D49CE9F12B2BBF6E5215")
    private void releaseWakeLock() {
        {
            {
                boolean var7AF9E96BF041CFB5FB2EBC225EA829D3_44757216 = (mPartialWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.571 -0400", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "5F5A47F67F63255E02E93F99622150E2")
    private void log(String msg) {
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.571 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "F32FDE85A3E9FB1947544357BB88E13E")
    @Override
    public int getNumberPresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857053264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857053264;
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.572 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "EC1CDFFE5376074BBB8846076051FFDF")
    @Override
    public UUSInfo getUUSInfo() {
        UUSInfo varB4EAC82CA7396A68D541C85D26508E83_1470652188 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470652188 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1470652188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470652188;
        // ---------- Original Method ----------
        //return null;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.572 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "9F81445C1E6268163583AF9421B2D274")
          MyHandler(Looper l) {
            super(l);
            addTaint(l.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "82E315FF4D841CD23578FEA3A741B202")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "7704FE668B9C1C089259D6CEED742FC3", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "14BAF9BD9D872934E32A0EC614CCB609", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "44337A632EF9C75005A31A24BCE51D89", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "BFAA4FABA80533E5EEDE70D24C452A4C", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "257B1549D7640408D15AC93307777800", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.573 -0400", hash_original_field = "150B3B1EED2149C93D65E2E16D8B0C2A", hash_generated_field = "32583EE0477EC212D3437226C61913CB")

    static final int PAUSE_DELAY_MILLIS = 2 * 1000;
}

