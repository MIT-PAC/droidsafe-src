package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.telephony.RILConstants.*;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.os.PowerManager.WakeLock;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;
import com.android.internal.telephony.gsm.SuppServiceNotification;
import com.android.internal.telephony.cdma.CdmaCallWaitingNotification;
import com.android.internal.telephony.cdma.CdmaInformationRecords;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

class RILRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.235 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "2C995DC68A290AA0E91A0F8065297DF6")

    int mSerial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.235 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "6C368ED9CE82768FD0B5A0D34D844F82")

    int mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.235 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "275BCCDB24FCA985A62252086534EA41")

    Message mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.235 -0400", hash_original_field = "1F2DFA567DCF95833EDDF7AEC167FEC7", hash_generated_field = "EEF79C3D9374B5C2140B6DF15C81B0D3")

    Parcel mp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.235 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "64C9DCC5A15FF3A81952EE0FF77BF4DE")

    RILRequest mNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.246 -0400", hash_original_method = "9C4E8F6E2A10EF2C06F20638ED2CBC6D", hash_generated_method = "560681FC445F3861C142757487DA3B91")
    private  RILRequest() {
        // ---------- Original Method ----------
    }

    
        static RILRequest obtain(int request, Message result) {
        RILRequest rr = null;
        synchronized(sPoolSync) {
            if (sPool != null) {
                rr = sPool;
                sPool = rr.mNext;
                rr.mNext = null;
                sPoolSize--;
            }
        }
        if (rr == null) {
            rr = new RILRequest();
        }
        synchronized(sSerialMonitor) {
            rr.mSerial = sNextSerial++;
        }
        rr.mRequest = request;
        rr.mResult = result;
        rr.mp = Parcel.obtain();
        if (result != null && result.getTarget() == null) {
            throw new NullPointerException("Message target must not be null");
        }
        rr.mp.writeInt(request);
        rr.mp.writeInt(rr.mSerial);
        return rr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.248 -0400", hash_original_method = "E7EE736E24A2BE53AC107C249FFB0880", hash_generated_method = "2CC4C29F04564704D254356C451809E3")
     void release() {
        {
            {
                this.mNext = sPool;
                sPool = this;
                mResult = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (sPoolSync) {
            //if (sPoolSize < MAX_POOL_SIZE) {
                //this.mNext = sPool;
                //sPool = this;
                //sPoolSize++;
                //mResult = null;
            //}
        //}
    }

    
        static void resetSerial() {
        synchronized(sSerialMonitor) {
            sNextSerial = 0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.257 -0400", hash_original_method = "9C13ECBB4C9B57CD7FC06025C6091C8F", hash_generated_method = "D133F478D4AC1D34C19F10469E947A52")
     String serialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_606634062 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(8);
        String sn;
        sn = Integer.toString(mSerial);
        sb.append('[');
        {
            int i, s;
            i = 0;
            s = sn.length();
            {
                sb.append('0');
            } //End block
        } //End collapsed parenthetic
        sb.append(sn);
        sb.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_606634062 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_606634062.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_606634062;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(8);
        //String sn;
        //sn = Integer.toString(mSerial);
        //sb.append('[');
        //for (int i = 0, s = sn.length() ; i < 4 - s; i++) {
            //sb.append('0');
        //}
        //sb.append(sn);
        //sb.append(']');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_method = "DAF6125A6A3BAA8EA4AAF17920DB80E6", hash_generated_method = "BA8A1D52078D3A6AF8F13F23255497FF")
     void onError(int error, Object ret) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CommandException ex;
        ex = CommandException.fromRilErrno(error);
        Log.d(LOG_TAG, serialString() + "< "
            + RIL.requestToString(mRequest)
            + " error: " + ex);
        {
            AsyncResult.forMessage(mResult, ret, ex);
            mResult.sendToTarget();
        } //End block
        {
            mp.recycle();
            mp = null;
        } //End block
        addTaint(error);
        addTaint(ret.getTaint());
        // ---------- Original Method ----------
        //CommandException ex;
        //ex = CommandException.fromRilErrno(error);
        //if (RIL.RILJ_LOGD) Log.d(LOG_TAG, serialString() + "< "
            //+ RIL.requestToString(mRequest)
            //+ " error: " + ex);
        //if (mResult != null) {
            //AsyncResult.forMessage(mResult, ret, ex);
            //mResult.sendToTarget();
        //}
        //if (mp != null) {
            //mp.recycle();
            //mp = null;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "DCD4DA7F13FEC5D49BF1C3CE354FB202")

    static String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "5427C798EA4BCDD653BC3E19DA14EDA3", hash_generated_field = "4648C36C9B39D123F3C2DC203738A8FE")

    static int sNextSerial = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "0470E9F275C220FB347853BB1394F8E2", hash_generated_field = "A7E278FEB1EC2BFEA3ED505503B40F1D")

    static Object sSerialMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "8885194D9D2ADA6648AB65C43BA7A18A")

    private static Object sPoolSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "E6E7B1EE519E99449DC5CFD28949053E", hash_generated_field = "29AEB546B72810AE137F2724EB8AC46F")

    private static RILRequest sPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.258 -0400", hash_original_field = "F95B54369A4D6DB4C3ACF86CE99D31FA", hash_generated_field = "23F671A1BB1E9EF88E29479BFF2420DE")

    private static int MAX_POOL_SIZE = 4;
}

public final class RIL extends BaseCommands implements CommandsInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "6971E2A0D3E5B2508308ACDF0894CC71")

    LocalSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "D98DF8D8C44F237131E3131E7D96BB06", hash_generated_field = "447BDB484814847833708DAC5CD0741B")

    HandlerThread mSenderThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "96F4E0D75276B088A94548BBA71042AB", hash_generated_field = "F824B77C4D08BC410F85653F55DB5D17")

    RILSender mSender;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "C42E57035DC58A8EF93627DAE705E4EB", hash_generated_field = "4C5A8172CA27A059D229944DFD840114")

    Thread mReceiverThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "B718778FEA0061AFBE714CC16C50488E")

    RILReceiver mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "C3E41FC6371E803E2DA98F1EFF9EF47B", hash_generated_field = "102A8E8B4FA31B396B477F22D2A32DA8")

    int mWakeLockTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "DFF633BBB29FA60E5096BC022C074C8C", hash_generated_field = "9200B1A2FDF04FDBA9EA6DB75F97F5C2")

    int mRequestMessagesPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "8792B45034366F06E89F0CF7947B7575", hash_generated_field = "2A0F03062FAF4047F837E853AF898D37")

    int mRequestMessagesWaiting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "57D356D53799C83A82E9E7DBBDB489EF", hash_generated_field = "A8E052F302542BDDE893942D71524913")

    ArrayList<RILRequest> mRequestsList = new ArrayList<RILRequest>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.262 -0400", hash_original_field = "7A74E6AA0A9A2FF1A7B6935083BAFD8F", hash_generated_field = "DD6FA850B0C2512C103BBC579CD52D51")

    Object mLastNITZTimeInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.267 -0400", hash_original_field = "BF2765A7DF728F4D51D697E315A27D1E", hash_generated_field = "15AFC0F21805B2388FF8513DA9BFD2A3")

    BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.267 -0400", hash_original_method = "2E7815AD99D182A9CFAEBA30A64F6122", hash_generated_method = "35D773FB99E7561D9B38F2B75F44F7C8")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var8C358EA74D49A7EAFB8AA331D6B03438_159201406 = (intent.getAction().equals(Intent.ACTION_SCREEN_ON));
                {
                    sendScreenState(true);
                } //End block
                {
                    boolean varD09851821BF78B9C6FDD532B0303A63D_1463680122 = (intent.getAction().equals(Intent.ACTION_SCREEN_OFF));
                    {
                        sendScreenState(false);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                //sendScreenState(true);
            //} else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                //sendScreenState(false);
            //} else {
                //Log.w(LOG_TAG, "RIL received unexpected Intent: " + intent.getAction());
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.267 -0400", hash_original_field = "D41C93A29A8110B1E773EFFE673A66AE", hash_generated_field = "517EE6BA92CA6D3C16C0F4FDDB025C17")

    private int mSetPreferredNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.269 -0400", hash_original_method = "57415555D3C32D9CF1C37CD62128114E", hash_generated_method = "B401D470538D0A4E49C5F2602BEEE68F")
    public  RIL(Context context, int preferredNetworkType, int cdmaSubscription) {
        super(context);
        {
            riljLog("RIL(context, preferredNetworkType=" + preferredNetworkType +
                    " cdmaSubscription=" + cdmaSubscription + ")");
        } //End block
        mCdmaSubscription  = cdmaSubscription;
        mPreferredNetworkType = preferredNetworkType;
        mPhoneType = RILConstants.NO_PHONE;
        PowerManager pm;
        pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        mWakeLock.setReferenceCounted(false);
        mWakeLockTimeout = SystemProperties.getInt(TelephonyProperties.PROPERTY_WAKE_LOCK_TIMEOUT,
                DEFAULT_WAKE_LOCK_TIMEOUT);
        mRequestMessagesPending = 0;
        mRequestMessagesWaiting = 0;
        mSenderThread = new HandlerThread("RILSender");
        mSenderThread.start();
        Looper looper;
        looper = mSenderThread.getLooper();
        mSender = new RILSender(looper);
        ConnectivityManager cm;
        cm = (ConnectivityManager)context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        {
            boolean varD774D9E55CA6214CD6B06FC22CB353B1_946054631 = (cm.isNetworkSupported(ConnectivityManager.TYPE_MOBILE) == false);
            {
                riljLog("Not starting RILReceiver: wifi-only");
            } //End block
            {
                riljLog("Starting RILReceiver");
                mReceiver = new RILReceiver();
                mReceiverThread = new Thread(mReceiver, "RILReceiver");
                mReceiverThread.start();
                IntentFilter filter;
                filter = new IntentFilter();
                filter.addAction(Intent.ACTION_SCREEN_ON);
                filter.addAction(Intent.ACTION_SCREEN_OFF);
                context.registerReceiver(mIntentReceiver, filter);
            } //End block
        } //End collapsed parenthetic
        addTaint(context.getTaint());
        addTaint(preferredNetworkType);
        addTaint(cdmaSubscription);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int readRilMessage(InputStream is, byte[] buffer) throws IOException {
        int countRead;
        int offset;
        int remaining;
        int messageLength;
        offset = 0;
        remaining = 4;
        do {
            countRead = is.read(buffer, offset, remaining);
            if (countRead < 0 ) {
                Log.e(LOG_TAG, "Hit EOS reading message length");
                return -1;
            }
            offset += countRead;
            remaining -= countRead;
        } while (remaining > 0);
        messageLength = ((buffer[0] & 0xff) << 24)
                | ((buffer[1] & 0xff) << 16)
                | ((buffer[2] & 0xff) << 8)
                | (buffer[3] & 0xff);
        offset = 0;
        remaining = messageLength;
        do {
            countRead = is.read(buffer, offset, remaining);
            if (countRead < 0 ) {
                Log.e(LOG_TAG, "Hit EOS reading message.  messageLength=" + messageLength
                        + " remaining=" + remaining);
                return -1;
            }
            offset += countRead;
            remaining -= countRead;
        } while (remaining > 0);
        return messageLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.286 -0400", hash_original_method = "9505EC70575F3F081B82639224A26C6E", hash_generated_method = "940003D104FF1257EFD98542EB753F31")
    @Override
    public void setOnNITZTime(Handler h, int what, Object obj) {
        super.setOnNITZTime(h, what, obj);
        {
            mNITZTimeRegistrant
                .notifyRegistrant(
                    new AsyncResult (null, mLastNITZTimeInfo, null));
            mLastNITZTimeInfo = null;
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //super.setOnNITZTime(h, what, obj);
        //if (mLastNITZTimeInfo != null) {
            //mNITZTimeRegistrant
                //.notifyRegistrant(
                    //new AsyncResult (null, mLastNITZTimeInfo, null));
            //mLastNITZTimeInfo = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.287 -0400", hash_original_method = "9A7EB00CD2404F3C288A75EFD9E4A220", hash_generated_method = "2A010BD5EA303421FF6F2274A2590A86")
    public void getIccCardStatus(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.287 -0400", hash_original_method = "A64490CEA7617DBF7C16959DD443F320", hash_generated_method = "A9501B0CB452CD6FA43F5CADE57A70AD")
    @Override
    public void supplyIccPin(String pin, Message result) {
        supplyIccPinForApp(pin, null, result);
        addTaint(pin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //supplyIccPinForApp(pin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.288 -0400", hash_original_method = "292CEACE366769BDA48EB6300D49BD27", hash_generated_method = "B961577872D356C1E6F881581536072C")
    @Override
    public void supplyIccPinForApp(String pin, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(pin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(2);
        //rr.mp.writeString(pin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.288 -0400", hash_original_method = "EDD0A15F8BC2322B300440A8148B03FB", hash_generated_method = "7E7A5F044B35F70296B08EEAE8F6FB15")
    @Override
    public void supplyIccPuk(String puk, String newPin, Message result) {
        supplyIccPukForApp(puk, newPin, null, result);
        addTaint(puk.getTaint());
        addTaint(newPin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //supplyIccPukForApp(puk, newPin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.293 -0400", hash_original_method = "1780B25BC715F62B7E7B76DC76BDB7F8", hash_generated_method = "EC028419DA8B01A150DEFC9CD0B44670")
    @Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(puk.getTaint());
        addTaint(newPin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(puk);
        //rr.mp.writeString(newPin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.297 -0400", hash_original_method = "8076AE95CA0491033B7A3B1FDB27A00D", hash_generated_method = "FA19620A646A653AD4AE427594790488")
    @Override
    public void supplyIccPin2(String pin, Message result) {
        supplyIccPin2ForApp(pin, null, result);
        addTaint(pin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //supplyIccPin2ForApp(pin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.297 -0400", hash_original_method = "2364DF46EB4F312709574B2C726226B0", hash_generated_method = "1A4040BBF2BC765189CC9DC312DC6DE4")
    @Override
    public void supplyIccPin2ForApp(String pin, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(pin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(2);
        //rr.mp.writeString(pin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.298 -0400", hash_original_method = "02C50C8BAA9C120A4383EA48E4CE9EF9", hash_generated_method = "1A8A7206940E08EF0994C99E9D32FEEB")
    @Override
    public void supplyIccPuk2(String puk2, String newPin2, Message result) {
        supplyIccPuk2ForApp(puk2, newPin2, null, result);
        addTaint(puk2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //supplyIccPuk2ForApp(puk2, newPin2, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.315 -0400", hash_original_method = "16881D0ACCF987B6F55F1477C7A8AF2E", hash_generated_method = "07EAF53F1AB6EDF2AE950132449E6D37")
    @Override
    public void supplyIccPuk2ForApp(String puk, String newPin2, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(puk.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(puk);
        //rr.mp.writeString(newPin2);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.316 -0400", hash_original_method = "E5801ABF4ED976E8B47A9DC4E0EF9FFC", hash_generated_method = "84EF96C27669BE6422B503C6D28F5AC7")
    @Override
    public void changeIccPin(String oldPin, String newPin, Message result) {
        changeIccPinForApp(oldPin, newPin, null, result);
        addTaint(oldPin.getTaint());
        addTaint(newPin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //changeIccPinForApp(oldPin, newPin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.316 -0400", hash_original_method = "FB6D60EEFAF19AC3A68522374AFE5A34", hash_generated_method = "40BDB3085ADFB76E26B5FDEA73669950")
    @Override
    public void changeIccPinForApp(String oldPin, String newPin, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(oldPin.getTaint());
        addTaint(newPin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(oldPin);
        //rr.mp.writeString(newPin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.316 -0400", hash_original_method = "09C1A469DD89C445C72DC064DAF532C6", hash_generated_method = "71E2F019F26209C28C9204F410CC5420")
    @Override
    public void changeIccPin2(String oldPin2, String newPin2, Message result) {
        changeIccPin2ForApp(oldPin2, newPin2, null, result);
        addTaint(oldPin2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //changeIccPin2ForApp(oldPin2, newPin2, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.317 -0400", hash_original_method = "5CD184F5005892F6A2376DA12B8940E7", hash_generated_method = "F145DF4FE390A847946F129702C6DDDC")
    @Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aid, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin2);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(oldPin2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(oldPin2);
        //rr.mp.writeString(newPin2);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.317 -0400", hash_original_method = "DCA3B69D42E061A95FB4470FAF19888E", hash_generated_method = "3876AB4E5EFC4585C648446234508F09")
    public void changeBarringPassword(String facility, String oldPwd, String newPwd, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(facility);
        rr.mp.writeString(oldPwd);
        rr.mp.writeString(newPwd);
        send(rr);
        addTaint(facility.getTaint());
        addTaint(oldPwd.getTaint());
        addTaint(newPwd.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(facility);
        //rr.mp.writeString(oldPwd);
        //rr.mp.writeString(newPwd);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.324 -0400", hash_original_method = "FD9166E53C98E732567F842FC6265121", hash_generated_method = "6ED1FC08BFEBAB4FE28F73401AB1EE6F")
    public void supplyNetworkDepersonalization(String netpin, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(1);
        rr.mp.writeString(netpin);
        send(rr);
        addTaint(netpin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(1);
        //rr.mp.writeString(netpin);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.324 -0400", hash_original_method = "6F2937ACBD34EE8D8FEF57D35663AFCC", hash_generated_method = "C7F198A906C4CFAD2198BE68AAF63DEF")
    public void getCurrentCalls(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.324 -0400", hash_original_method = "A1D311E0B227CABB8D0707A1650659D2", hash_generated_method = "9FB76FC67D6532AAD0E5E2AC48373D7A")
    @Deprecated
    public void getPDPContextList(Message result) {
        getDataCallList(result);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //getDataCallList(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.333 -0400", hash_original_method = "68CF653DB375A3C63D89D09DBB57244C", hash_generated_method = "84B9370C777BD2C02C37CC455AAB570D")
    public void getDataCallList(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.334 -0400", hash_original_method = "85029AD0E77EFB7E7AAB9535BAB079D4", hash_generated_method = "17ACC58C4441A8020141361793F38400")
    public void dial(String address, int clirMode, Message result) {
        dial(address, clirMode, null, result);
        addTaint(address.getTaint());
        addTaint(clirMode);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //dial(address, clirMode, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.334 -0400", hash_original_method = "2937351315DD22A0DBB0EBEECB6FBD52", hash_generated_method = "F95E29263672AD9632F6A216608A9007")
    public void dial(String address, int clirMode, UUSInfo uusInfo, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DIAL, result);
        rr.mp.writeString(address);
        rr.mp.writeInt(clirMode);
        rr.mp.writeInt(0);
        {
            rr.mp.writeInt(0);
        } //End block
        {
            rr.mp.writeInt(1);
            rr.mp.writeInt(uusInfo.getType());
            rr.mp.writeInt(uusInfo.getDcs());
            rr.mp.writeByteArray(uusInfo.getUserData());
        } //End block
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(address.getTaint());
        addTaint(clirMode);
        addTaint(uusInfo.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DIAL, result);
        //rr.mp.writeString(address);
        //rr.mp.writeInt(clirMode);
        //rr.mp.writeInt(0);
        //if (uusInfo == null) {
            //rr.mp.writeInt(0); 
        //} else {
            //rr.mp.writeInt(1); 
            //rr.mp.writeInt(uusInfo.getType());
            //rr.mp.writeInt(uusInfo.getDcs());
            //rr.mp.writeByteArray(uusInfo.getUserData());
        //}
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.343 -0400", hash_original_method = "DCABA764531B1065D0038AAAD031BA27", hash_generated_method = "398568ECFEE7A7F48445AC0BC7482BEC")
    public void getIMSI(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.344 -0400", hash_original_method = "4D0F2CCF9960CC448C13E6CB3F3B5DE4", hash_generated_method = "C3D1593E09E540CEAFDFFB7E9900F25A")
    public void getIMEI(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.344 -0400", hash_original_method = "149F0748B48493B8EA1EFEBB8389549A", hash_generated_method = "8EC36D04940B81F2B7A3E260B91A3FB6")
    public void getIMEISV(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.349 -0400", hash_original_method = "7905AFC17F454606777953D509A8D53A", hash_generated_method = "A3AFC3123DB4E4EBC73BDA06291A1863")
    public void hangupConnection(int gsmIndex, Message result) {
        riljLog("hangupConnection: gsmIndex=" + gsmIndex);
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        addTaint(gsmIndex);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("hangupConnection: gsmIndex=" + gsmIndex);
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                //gsmIndex);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(gsmIndex);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.350 -0400", hash_original_method = "85440FD9AE077A395C6F94573FB9B35A", hash_generated_method = "A4F06DA4920B5B72569BE7BFC9BE0074")
    public void hangupWaitingOrBackground(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.350 -0400", hash_original_method = "7CE301AE0A34FEB3B57BD0350A2D5E6A", hash_generated_method = "48B52450314E6D540AC702C1F856F867")
    public void hangupForegroundResumeBackground(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(
                        RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(
                        //RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.359 -0400", hash_original_method = "D308C1E0C4F8D94B5EF5B2D9D0D36F66", hash_generated_method = "830AB378EA74C28BC476CED2DA29288C")
    public void switchWaitingOrHoldingAndActive(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(
                        RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(
                        //RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.362 -0400", hash_original_method = "E472C7A7FA5FA1FA68AAF1D140E0BD67", hash_generated_method = "74054017170704A8FCFA96707C219728")
    public void conference(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.363 -0400", hash_original_method = "B803BD13961A7A2F16F3119AE2CBAC6F", hash_generated_method = "15DE72E70BF9C90F015DA7212199EF1A")
    public void setPreferredVoicePrivacy(boolean enable, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1:0);
        send(rr);
        addTaint(enable);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                //result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1:0);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.363 -0400", hash_original_method = "3E434E6C0C8E17A9191C0565807B19D8", hash_generated_method = "A4900ADEB412AE2A3CE37828D2097D27")
    public void getPreferredVoicePrivacy(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                //result);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.363 -0400", hash_original_method = "4B8D613904DEDF72212F0EB9A1BF349B", hash_generated_method = "DEDC1FDD93B73EB2BAE15E6D4C30C0D9")
    public void separateConnection(int gsmIndex, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        addTaint(gsmIndex);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + gsmIndex);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(gsmIndex);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.368 -0400", hash_original_method = "8CB5CF57551B01694681D1FE4B325AA7", hash_generated_method = "D39F0B27039EE1934551E89CEE30498A")
    public void acceptCall(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ANSWER, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_ANSWER, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.375 -0400", hash_original_method = "2E92E83F2C082778F7F377F259918641", hash_generated_method = "C88D3A6FC8353B566AEEE4119A7B2C4A")
    public void rejectCall(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_UDUB, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_UDUB, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.391 -0400", hash_original_method = "4490A3E422842C7946255FFDE06D02C6", hash_generated_method = "2B1D95A863C990EFA4E1D995934E0844")
    public void explicitCallTransfer(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.392 -0400", hash_original_method = "286D2CDF105911EDAA78CDFFAADE2FB4", hash_generated_method = "FB3A5DC84696DEA5E0C11CA450661F0B")
    public void getLastCallFailCause(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.392 -0400", hash_original_method = "E839391FA5F4E8371F0D2466E996CFDA", hash_generated_method = "E736392F3D904B6F15316A35E764CB6F")
    public void getLastPdpFailCause(Message result) {
        getLastDataCallFailCause (result);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //getLastDataCallFailCause (result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.393 -0400", hash_original_method = "367089EF39FE579C6BCEE97FCB3E914B", hash_generated_method = "A30AA91DBA8D7738985C9397B064195D")
    public void getLastDataCallFailCause(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.393 -0400", hash_original_method = "350AC1F658DA4E0097EF1D14A3117454", hash_generated_method = "82F835620AE2E19C6D384750E5FA7B56")
    public void setMute(boolean enableMute, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + enableMute);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enableMute ? 1 : 0);
        send(rr);
        addTaint(enableMute);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + enableMute);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enableMute ? 1 : 0);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.396 -0400", hash_original_method = "B42AC6EC10626260A88AA941D9E9F704", hash_generated_method = "8458C7E5E55D01AFE0A0CF33B1611C3A")
    public void getMute(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.397 -0400", hash_original_method = "16BB78D78D9B012F64B70344D11CBBD0", hash_generated_method = "D808BE8337732BC7EB89D51133DD98F7")
    public void getSignalStrength(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.397 -0400", hash_original_method = "CD1D773750E577C45A4986B8D31A3404", hash_generated_method = "C39F8C4CB153D34C850987D6BA7BCC8E")
    public void getVoiceRegistrationState(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.401 -0400", hash_original_method = "A42E908B0E0EAE7E9677D8B8370610F9", hash_generated_method = "D4D2F35E6D9F094E67FCBD124DE0F21E")
    public void getDataRegistrationState(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.411 -0400", hash_original_method = "F3EF4D956FA5FB9BDF6C62381BC62F41", hash_generated_method = "0E56A31B10FC35C9187067E1B1F2F8A6")
    public void getOperator(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_OPERATOR, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OPERATOR, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.411 -0400", hash_original_method = "3D70E9C0BFE2429BE8FC0BF7A1D59B4A", hash_generated_method = "D422E3C99EC57AF9CE6C8E24E5A39DCA")
    public void sendDtmf(char c, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DTMF, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        addTaint(c);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(Character.toString(c));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.412 -0400", hash_original_method = "BAA741C14C9F73BEA8C72D4011D64DC0", hash_generated_method = "1B58761066E92510E7DBDACBE07973F3")
    public void startDtmf(char c, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DTMF_START, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        addTaint(c);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF_START, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(Character.toString(c));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.412 -0400", hash_original_method = "C4D329464DB2A188FDA1049FC1B5C820", hash_generated_method = "930F5B5979B8B0EC727A36CFB4156C6E")
    public void stopDtmf(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.414 -0400", hash_original_method = "AF9E26B6734BDEC93AE44BA0DF8E2C9A", hash_generated_method = "4AC9180BC03ED9CB64F362D5F2195098")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_BURST_DTMF, result);
        rr.mp.writeInt(3);
        rr.mp.writeString(dtmfString);
        rr.mp.writeString(Integer.toString(on));
        rr.mp.writeString(Integer.toString(off));
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + dtmfString);
        send(rr);
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BURST_DTMF, result);
        //rr.mp.writeInt(3);
        //rr.mp.writeString(dtmfString);
        //rr.mp.writeString(Integer.toString(on));
        //rr.mp.writeString(Integer.toString(off));
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + dtmfString);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.424 -0400", hash_original_method = "6216EB8701D12EFA1EABB572C0722209", hash_generated_method = "C2EEBF15EDE95EA2C14A5C59B3AD30EA")
    public void sendSMS(String smscPDU, String pdu, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(smscPDU);
        rr.mp.writeString(pdu);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(smscPDU.getTaint());
        addTaint(pdu.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);
        //rr.mp.writeInt(2);
        //rr.mp.writeString(smscPDU);
        //rr.mp.writeString(pdu);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.432 -0400", hash_original_method = "B6146A457115D22EC1FC450C9E047949", hash_generated_method = "51534B71343EEA53E87BF09D4DD70763")
    public void sendCdmaSms(byte[] pdu, Message result) {
        int address_nbr_of_digits;
        int subaddr_nbr_of_digits;
        int bearerDataLength;
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(pdu);
        DataInputStream dis;
        dis = new DataInputStream(bais);
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_SEND_SMS, result);
        try 
        {
            rr.mp.writeInt(dis.readInt());
            rr.mp.writeByte((byte) dis.readInt());
            rr.mp.writeInt(dis.readInt());
            rr.mp.writeInt(dis.read());
            rr.mp.writeInt(dis.read());
            rr.mp.writeInt(dis.read());
            rr.mp.writeInt(dis.read());
            address_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) address_nbr_of_digits);
            {
                int i;
                i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } //End block
            } //End collapsed parenthetic
            rr.mp.writeInt(dis.read());
            rr.mp.writeByte((byte) dis.read());
            subaddr_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) subaddr_nbr_of_digits);
            {
                int i;
                i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } //End block
            } //End collapsed parenthetic
            bearerDataLength = dis.read();
            rr.mp.writeInt(bearerDataLength);
            {
                int i;
                i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            riljLog("sendSmsCdma: conversion from input stream to object failed: "
                    + ex);
        } //End block
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(pdu[0]);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.437 -0400", hash_original_method = "33AA1BF497C1DD92CFF4D18BA36EE77C", hash_generated_method = "345B9B600EFAE25811482D2CE1ADA314")
    public void deleteSmsOnSim(int index, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DELETE_SMS_ON_SIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } //End block
        send(rr);
        addTaint(index);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DELETE_SMS_ON_SIM,
                //response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(index);
        //if (false) {
            //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    //+ requestToString(rr.mRequest)
                    //+ " " + index);
        //}
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.438 -0400", hash_original_method = "AADBC281C1547D2CD40AF49A4F15439D", hash_generated_method = "BADAA832F751B94EF8D42826D0878F9B")
    public void deleteSmsOnRuim(int index, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } //End block
        send(rr);
        addTaint(index);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM,
                //response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(index);
        //if (false) {
            //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    //+ requestToString(rr.mRequest)
                    //+ " " + index);
        //}
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.438 -0400", hash_original_method = "371A972FE084C98FCAE13C1996429D8F", hash_generated_method = "B8EEB066D2EBDBBDAA6A59FFE316B37A")
    public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        status = translateStatus(status);
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_WRITE_SMS_TO_SIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        rr.mp.writeString(smsc);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } //End block
        send(rr);
        addTaint(status);
        addTaint(smsc.getTaint());
        addTaint(pdu.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //status = translateStatus(status);
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_WRITE_SMS_TO_SIM,
                //response);
        //rr.mp.writeInt(status);
        //rr.mp.writeString(pdu);
        //rr.mp.writeString(smsc);
        //if (false) {
            //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    //+ requestToString(rr.mRequest)
                    //+ " " + status);
        //}
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.533 -0400", hash_original_method = "05C70D9FCCFAC2D0EDAAC7E4EA19DFB0", hash_generated_method = "4FFEAE1452346F5615B7258D7D55D3C2")
    public void writeSmsToRuim(int status, String pdu, Message response) {
        status = translateStatus(status);
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } //End block
        send(rr);
        addTaint(status);
        addTaint(pdu.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //status = translateStatus(status);
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM,
                //response);
        //rr.mp.writeInt(status);
        //rr.mp.writeString(pdu);
        //if (false) {
            //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    //+ requestToString(rr.mRequest)
                    //+ " " + status);
        //}
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.533 -0400", hash_original_method = "0D77FBD1C1F349CB6A533B80F899FC6F", hash_generated_method = "FD9746EBBF90661B7FF4891EB152587A")
    private int translateStatus(int status) {
        addTaint(status);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379187627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379187627;
        // ---------- Original Method ----------
        //switch(status & 0x7) {
            //case SmsManager.STATUS_ON_ICC_READ:
                //return 1;
            //case SmsManager.STATUS_ON_ICC_UNREAD:
                //return 0;
            //case SmsManager.STATUS_ON_ICC_SENT:
                //return 3;
            //case SmsManager.STATUS_ON_ICC_UNSENT:
                //return 2;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.534 -0400", hash_original_method = "9997727B0C7061EF37C7F5F20BA491DC", hash_generated_method = "F18C60347AFDF6D44E40E826A038F4DA")
    public void setupDataCall(String radioTechnology, String profile, String apn,
            String user, String password, String authType, String protocol,
            Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SETUP_DATA_CALL, result);
        rr.mp.writeInt(7);
        rr.mp.writeString(radioTechnology);
        rr.mp.writeString(profile);
        rr.mp.writeString(apn);
        rr.mp.writeString(user);
        rr.mp.writeString(password);
        rr.mp.writeString(authType);
        rr.mp.writeString(protocol);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + " " + radioTechnology + " "
                + profile + " " + apn + " " + user + " "
                + password + " " + authType + " " + protocol);
        send(rr);
        addTaint(radioTechnology.getTaint());
        addTaint(profile.getTaint());
        addTaint(apn.getTaint());
        addTaint(user.getTaint());
        addTaint(password.getTaint());
        addTaint(authType.getTaint());
        addTaint(protocol.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SETUP_DATA_CALL, result);
        //rr.mp.writeInt(7);
        //rr.mp.writeString(radioTechnology);
        //rr.mp.writeString(profile);
        //rr.mp.writeString(apn);
        //rr.mp.writeString(user);
        //rr.mp.writeString(password);
        //rr.mp.writeString(authType);
        //rr.mp.writeString(protocol);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest) + " " + radioTechnology + " "
                //+ profile + " " + apn + " " + user + " "
                //+ password + " " + authType + " " + protocol);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.534 -0400", hash_original_method = "7ACA8E6FBBE8E5A758B0F14E8B7A1BD0", hash_generated_method = "ECFAFA3B37314C6D9A5EF24E7AD85B8F")
    public void deactivateDataCall(int cid, int reason, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DEACTIVATE_DATA_CALL, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(Integer.toString(cid));
        rr.mp.writeString(Integer.toString(reason));
        riljLog(rr.serialString() + "> " +
                requestToString(rr.mRequest) + " " + cid + " " + reason);
        send(rr);
        addTaint(cid);
        addTaint(reason);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DEACTIVATE_DATA_CALL, result);
        //rr.mp.writeInt(2);
        //rr.mp.writeString(Integer.toString(cid));
        //rr.mp.writeString(Integer.toString(reason));
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " +
                //requestToString(rr.mRequest) + " " + cid + " " + reason);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.535 -0400", hash_original_method = "EB783AFA41C6889D4897D81BF3D72432", hash_generated_method = "FD53B967A6C90CC9F7CFE40E45FDAFD8")
    public void setRadioPower(boolean on, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_RADIO_POWER, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + (on ? " on" : " off"));
        } //End block
        send(rr);
        addTaint(on);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_RADIO_POWER, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(on ? 1 : 0);
        //if (RILJ_LOGD) {
            //riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ (on ? " on" : " off"));
        //}
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.535 -0400", hash_original_method = "20525E4C07E2BDDC8598F4A8A0A24AAC", hash_generated_method = "039B079B0E6411A82C17F40FC7F8770C")
    public void setSuppServiceNotifications(boolean enable, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest));
        send(rr);
        addTaint(enable);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.536 -0400", hash_original_method = "2FD7CAC0F0B66293984C61A06F9D6871", hash_generated_method = "831D0F08C52948985D775CCE644E38A0")
    public void acknowledgeLastIncomingGsmSms(boolean success, int cause, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(2);
        rr.mp.writeInt(success ? 1 : 0);
        rr.mp.writeInt(cause);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
        addTaint(success);
        addTaint(cause);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SMS_ACKNOWLEDGE, result);
        //rr.mp.writeInt(2);
        //rr.mp.writeInt(success ? 1 : 0);
        //rr.mp.writeInt(cause);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " " + success + " " + cause);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.536 -0400", hash_original_method = "7D64BD1B5FFD5E98E91826BF607F7EF6", hash_generated_method = "D62C752266A1F6D27924284E96FD512F")
    public void acknowledgeLastIncomingCdmaSms(boolean success, int cause, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(success ? 0 : 1);
        rr.mp.writeInt(cause);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
        addTaint(success);
        addTaint(cause);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);
        //rr.mp.writeInt(success ? 0 : 1);
        //rr.mp.writeInt(cause);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " " + success + " " + cause);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.540 -0400", hash_original_method = "64AA0D67C6CE837D613809948FDF7791", hash_generated_method = "9294F6F39BE69F2AE75090F991BE11D6")
    public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(success ? "1" : "0");
        rr.mp.writeString(ackPdu);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + ' ' + success + " [" + ackPdu + ']');
        send(rr);
        addTaint(success);
        addTaint(ackPdu.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU, result);
        //rr.mp.writeInt(2);
        //rr.mp.writeString(success ? "1" : "0");
        //rr.mp.writeString(ackPdu);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ ' ' + success + " [" + ackPdu + ']');
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.541 -0400", hash_original_method = "59EE7F242CC2ECDC31CC3317E2625FB0", hash_generated_method = "6ABFB7170EA6B9DC51F56C725B35447A")
    public void iccIO(int command, int fileid, String path, int p1, int p2, int p3,
            String data, String pin2, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SIM_IO, result);
        rr.mp.writeInt(command);
        rr.mp.writeInt(fileid);
        rr.mp.writeString(path);
        rr.mp.writeInt(p1);
        rr.mp.writeInt(p2);
        rr.mp.writeInt(p3);
        rr.mp.writeString(data);
        rr.mp.writeString(pin2);
        riljLog(rr.serialString() + "> iccIO: " + requestToString(rr.mRequest)
                + " 0x" + Integer.toHexString(command)
                + " 0x" + Integer.toHexString(fileid) + " "
                + " path: " + path + ","
                + p1 + "," + p2 + "," + p3);
        send(rr);
        addTaint(command);
        addTaint(fileid);
        addTaint(path.getTaint());
        addTaint(p1);
        addTaint(p2);
        addTaint(p3);
        addTaint(data.getTaint());
        addTaint(pin2.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SIM_IO, result);
        //rr.mp.writeInt(command);
        //rr.mp.writeInt(fileid);
        //rr.mp.writeString(path);
        //rr.mp.writeInt(p1);
        //rr.mp.writeInt(p2);
        //rr.mp.writeInt(p3);
        //rr.mp.writeString(data);
        //rr.mp.writeString(pin2);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> iccIO: " + requestToString(rr.mRequest)
                //+ " 0x" + Integer.toHexString(command)
                //+ " 0x" + Integer.toHexString(fileid) + " "
                //+ " path: " + path + ","
                //+ p1 + "," + p2 + "," + p3);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.541 -0400", hash_original_method = "ED6C155DF5FB4724355C53F41C941076", hash_generated_method = "A78C696022CA4CE1333F5FFA5CDD1BC9")
    public void getCLIR(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.542 -0400", hash_original_method = "19860D4829B0277968FE7219CA94272C", hash_generated_method = "EBD2D33FED14D2969D1E2C9204A5FB91")
    public void setCLIR(int clirMode, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(clirMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + clirMode);
        send(rr);
        addTaint(clirMode);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(clirMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + clirMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.542 -0400", hash_original_method = "32FF52B6F1E399D1F262392EAB262972", hash_generated_method = "6CC5930866A52ABE16CB7D587EE087D4")
    public void queryCallWaiting(int serviceClass, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(serviceClass);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + serviceClass);
        send(rr);
        addTaint(serviceClass);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(serviceClass);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + serviceClass);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.550 -0400", hash_original_method = "5A203D1E3F2536DB5285EBA696BDFC7A", hash_generated_method = "9DC340178307603E385DF7A89DAED9F5")
    public void setCallWaiting(boolean enable, int serviceClass, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_WAITING, response);
        rr.mp.writeInt(2);
        rr.mp.writeInt(enable ? 1 : 0);
        rr.mp.writeInt(serviceClass);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + enable + ", " + serviceClass);
        send(rr);
        addTaint(enable);
        addTaint(serviceClass);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_CALL_WAITING, response);
        //rr.mp.writeInt(2);
        //rr.mp.writeInt(enable ? 1 : 0);
        //rr.mp.writeInt(serviceClass);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " " + enable + ", " + serviceClass);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.550 -0400", hash_original_method = "B2CF07F1A50F7E09BFE7FA86DAEC0935", hash_generated_method = "BEFD1361B57C767058248BA6B504387B")
    public void setNetworkSelectionModeAutomatic(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.555 -0400", hash_original_method = "D59960D2C4E94DFBAD71EBB3A94610C2", hash_generated_method = "F8D604CEB1E16E3B6C1E598936CDB167")
    public void setNetworkSelectionModeManual(String operatorNumeric, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + operatorNumeric);
        rr.mp.writeString(operatorNumeric);
        send(rr);
        addTaint(operatorNumeric.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + operatorNumeric);
        //rr.mp.writeString(operatorNumeric);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.556 -0400", hash_original_method = "7D16D9750A543F65AAA01DDCEE296D12", hash_generated_method = "67D68ED64F800032FE83080EF6438779")
    public void getNetworkSelectionMode(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.556 -0400", hash_original_method = "A28AFA8A6050502E50A0794217CD9CA3", hash_generated_method = "796A29E596C2AC62DFAC79F67FE2A772")
    public void getAvailableNetworks(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.557 -0400", hash_original_method = "BAE7513A4D74D7F41628BC2CA56E49A7", hash_generated_method = "AA764F51DCF90C126F4C35B8A4876CBF")
    public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_FORWARD, response);
        rr.mp.writeInt(action);
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (timeSeconds);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + action + " " + cfReason + " " + serviceClass
                    + timeSeconds);
        send(rr);
        addTaint(action);
        addTaint(cfReason);
        addTaint(serviceClass);
        addTaint(number.getTaint());
        addTaint(timeSeconds);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_CALL_FORWARD, response);
        //rr.mp.writeInt(action);
        //rr.mp.writeInt(cfReason);
        //rr.mp.writeInt(serviceClass);
        //rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        //rr.mp.writeString(number);
        //rr.mp.writeInt (timeSeconds);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + action + " " + cfReason + " " + serviceClass
                    //+ timeSeconds);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.563 -0400", hash_original_method = "23037026F2CF508E3AB593A615459BEF", hash_generated_method = "5A50F5248C3D8C9F461023E219DF1CAE")
    public void queryCallForwardStatus(int cfReason, int serviceClass,
                String number, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_FORWARD_STATUS, response);
        rr.mp.writeInt(2);
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (0);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + cfReason + " " + serviceClass);
        send(rr);
        addTaint(cfReason);
        addTaint(serviceClass);
        addTaint(number.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
            //= RILRequest.obtain(RIL_REQUEST_QUERY_CALL_FORWARD_STATUS, response);
        //rr.mp.writeInt(2);
        //rr.mp.writeInt(cfReason);
        //rr.mp.writeInt(serviceClass);
        //rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        //rr.mp.writeString(number);
        //rr.mp.writeInt (0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " " + cfReason + " " + serviceClass);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.568 -0400", hash_original_method = "51655E0BCF7B1E2F86E04B0432A13A10", hash_generated_method = "FD10D96296974388F3709D343913F323")
    public void queryCLIP(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
            //= RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.569 -0400", hash_original_method = "A7E1CFA2EA980EF525A71B63D23749C6", hash_generated_method = "9068BBD141060D674BC0919521A73A20")
    public void getBasebandVersion(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.569 -0400", hash_original_method = "E2D6CDE0F4A2E0F1E247B2E96BC06629", hash_generated_method = "03D9979C1BDC618FF8F306793F7E836C")
    @Override
    public void queryFacilityLock(String facility, String password, int serviceClass,
                            Message response) {
        queryFacilityLockForApp(facility, password, serviceClass, null, response);
        addTaint(facility.getTaint());
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //queryFacilityLockForApp(facility, password, serviceClass, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.569 -0400", hash_original_method = "B68C5E6FDA45200A6E5673701837774F", hash_generated_method = "B1192D6606CD1D0626B527210EAB7C47")
    @Override
    public void queryFacilityLockForApp(String facility, String password, int serviceClass, String appId,
                            Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_FACILITY_LOCK, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(4);
        rr.mp.writeString(facility);
        rr.mp.writeString(password);
        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);
        send(rr);
        addTaint(facility.getTaint());
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(appId.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_FACILITY_LOCK, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(4);
        //rr.mp.writeString(facility);
        //rr.mp.writeString(password);
        //rr.mp.writeString(Integer.toString(serviceClass));
        //rr.mp.writeString(appId);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.570 -0400", hash_original_method = "AF27A0F06A4AEF0B8CE967EE20FD6D5A", hash_generated_method = "62ABC180D4CDA1E57B46B0F281F232A2")
    @Override
    public void setFacilityLock(String facility, boolean lockState, String password,
                        int serviceClass, Message response) {
        setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
        addTaint(facility.getTaint());
        addTaint(lockState);
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.570 -0400", hash_original_method = "99FAE35221FB0E541022587B483A8F41", hash_generated_method = "A1DBF513FB564839DEA3CA93E631867C")
    @Override
    public void setFacilityLockForApp(String facility, boolean lockState, String password,
                        int serviceClass, String appId, Message response) {
        String lockString;
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_FACILITY_LOCK, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(5);
        rr.mp.writeString(facility);
        lockString = (lockState)?"1":"0";
        rr.mp.writeString(lockString);
        rr.mp.writeString(password);
        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);
        send(rr);
        addTaint(facility.getTaint());
        addTaint(lockState);
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(appId.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //String lockString;
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_FACILITY_LOCK, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(5);
        //rr.mp.writeString(facility);
        //lockString = (lockState)?"1":"0";
        //rr.mp.writeString(lockString);
        //rr.mp.writeString(password);
        //rr.mp.writeString(Integer.toString(serviceClass));
        //rr.mp.writeString(appId);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.575 -0400", hash_original_method = "B3D73089A364D1181DC1E2D229325D6D", hash_generated_method = "0AEA5A4AFD2986F4AD49F673770A5A5F")
    public void sendUSSD(String ussdString, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + ussdString);
        rr.mp.writeString(ussdString);
        send(rr);
        addTaint(ussdString.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + ussdString);
        //rr.mp.writeString(ussdString);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.576 -0400", hash_original_method = "08754E29DFB7112567CD0DC9F54BCD3D", hash_generated_method = "04D87F86EE8B9D8D4831D705903F1265")
    public void cancelPendingUssd(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);
        //if (RILJ_LOGD) riljLog(rr.serialString()
                //+ "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.577 -0400", hash_original_method = "5EED3CE7F239827AE459A68B7A5F6205", hash_generated_method = "C2EBB55385293BDFC1C8D69D31DF622F")
    public void resetRadio(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.580 -0400", hash_original_method = "CC2053517147AA26411A18AF4FB47931", hash_generated_method = "81D5208CDC435EFB746196479E1BE8F8")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               + "[" + IccUtils.bytesToHexString(data) + "]");
        rr.mp.writeByteArray(data);
        send(rr);
        addTaint(data[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               //+ "[" + IccUtils.bytesToHexString(data) + "]");
        //rr.mp.writeByteArray(data);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.580 -0400", hash_original_method = "30F3E98808998C1043AF97B2AEFF80ED", hash_generated_method = "F1E8FC3AAFD0F2D9FCB4C5A2CE4C787A")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeStringArray(strings);
        send(rr);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeStringArray(strings);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.587 -0400", hash_original_method = "0483D811AD0184EC240C471A09F163C0", hash_generated_method = "C802C5BAE19C1F9896226F52D5BCC031")
    public void setBandMode(int bandMode, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(bandMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 + " " + bandMode);
        send(rr);
        addTaint(bandMode);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(bandMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 //+ " " + bandMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.587 -0400", hash_original_method = "3559A91588B2C9F9707F9FC4DC3F7539", hash_generated_method = "8248D7744D25E795738BA93670EDB672")
    public void queryAvailableBandMode(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.587 -0400", hash_original_method = "E6DDFD05E0997BF7790CA803E711C2EC", hash_generated_method = "1D6489C9D58C3E16DD5159620B09A767")
    public void sendTerminalResponse(String contents, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.589 -0400", hash_original_method = "AF8E8A7CD3B08412D1DCD73CAE0ACCA0", hash_generated_method = "E830369A230FACFDD3A4DE56BF0A89C8")
    public void sendEnvelope(String contents, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.589 -0400", hash_original_method = "A3C6115C92419E7DB4E4439F1BAFD013", hash_generated_method = "57AB071C2C1690B9EAF9FA2942B9B4EC")
    public void sendEnvelopeWithStatus(String contents, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + '[' + contents + ']');
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ '[' + contents + ']');
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.592 -0400", hash_original_method = "0FD1EE2A52540A4F80ECA30E950318D2", hash_generated_method = "ABC3B4E83938812D50435B0DD16FC177")
    public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
            RILConstants.RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM,
            response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        int[] param;
        param = new int[1];
        param[0] = accept ? 1 : 0;
        rr.mp.writeIntArray(param);
        send(rr);
        addTaint(accept);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
            //RILConstants.RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM,
            //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //int[] param = new int[1];
        //param[0] = accept ? 1 : 0;
        //rr.mp.writeIntArray(param);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.597 -0400", hash_original_method = "E0470661D17E36A9D9FCCA070C28B88C", hash_generated_method = "8F3EBD836485C251BFD8B926999FF50B")
    @Override
    public void setCurrentPreferredNetworkType() {
        riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        setPreferredNetworkType(mSetPreferredNetworkType, null);
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        //setPreferredNetworkType(mSetPreferredNetworkType, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.599 -0400", hash_original_method = "CD05D01D2353BF09784B2C892638713C", hash_generated_method = "7A0DE1515A6867E183DD049624D76642")
    public void setPreferredNetworkType(int networkType , Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(networkType);
        mSetPreferredNetworkType = networkType;
        mPreferredNetworkType = networkType;
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + networkType);
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(networkType);
        //mSetPreferredNetworkType = networkType;
        //mPreferredNetworkType = networkType;
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + networkType);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.599 -0400", hash_original_method = "9630540DB0E1A382F252246374543CFF", hash_generated_method = "E6D08C6639C6EEC0ED271754DA98BCAD")
    public void getPreferredNetworkType(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.600 -0400", hash_original_method = "EA7CB0793F40AD8E91B9E82268500DF5", hash_generated_method = "6097C214B227733FDF794DBB60D53976")
    public void getNeighboringCids(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.601 -0400", hash_original_method = "29FCAB1F96F7A6DF63D13BAE634B9C42", hash_generated_method = "FAA33D55EAA80973496607573FC813D6")
    public void setLocationUpdates(boolean enable, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + enable);
        send(rr);
        addTaint(enable);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest) + ": " + enable);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.601 -0400", hash_original_method = "7C3C5691348423704F3F89A5A1253262", hash_generated_method = "629E411C03C26F25F1CEDBED2F1D14E0")
    public void getSmscAddress(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.602 -0400", hash_original_method = "8030AF8483F275DADFE9FBCDFA4401B2", hash_generated_method = "2F61381048CC51C28F7E53DD2C2534FF")
    public void setSmscAddress(String address, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);
        rr.mp.writeString(address);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + address);
        send(rr);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);
        //rr.mp.writeString(address);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + address);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.605 -0400", hash_original_method = "E14FF49FE633CFCC7BBD49EA04EF5648", hash_generated_method = "7D70EA7D44347EE65B5BDC2AE6617785")
    public void reportSmsMemoryStatus(boolean available, Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(available ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + available);
        send(rr);
        addTaint(available);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(available ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest) + ": " + available);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.605 -0400", hash_original_method = "00A5515B81A4CB5336CA56505ADAAD61", hash_generated_method = "FCAAA2286945AC86A23FA1F88B08FBA8")
    public void reportStkServiceIsRunning(Message result) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.611 -0400", hash_original_method = "8D8904D0E740DF21294F215C1D1D7109", hash_generated_method = "F860A399A9636CB74C3B29C0D136127D")
    public void getGsmBroadcastConfig(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.613 -0400", hash_original_method = "052EA3DC72AD24FB98DF1CE5007E33C5", hash_generated_method = "03B6DD599EEDE53BA6F91F05A74EEE6E")
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GSM_SET_BROADCAST_CONFIG, response);
        int numOfConfig;
        numOfConfig = config.length;
        rr.mp.writeInt(numOfConfig);
        {
            int i;
            i = 0;
            {
                rr.mp.writeInt(config[i].getFromServiceId());
                rr.mp.writeInt(config[i].getToServiceId());
                rr.mp.writeInt(config[i].getFromCodeScheme());
                rr.mp.writeInt(config[i].getToCodeScheme());
                rr.mp.writeInt(config[i].isSelected() ? 1 : 0);
            } //End block
        } //End collapsed parenthetic
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " with " + numOfConfig + " configs : ");
            {
                int i;
                i = 0;
                {
                    riljLog(config[i].toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        send(rr);
        addTaint(config[0].getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.613 -0400", hash_original_method = "A31C3FA8B485D8364A045A89E34CE9F1", hash_generated_method = "F5BA1949FB3C4F24534971F602C66026")
    public void setGsmBroadcastActivation(boolean activate, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 : 1);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(activate ? 0 : 1);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.615 -0400", hash_original_method = "98C8C2D826445A3B0F1B6AA20E13AA85", hash_generated_method = "CDB134071FC26154095914CCF9209A81")
    private void sendScreenState(boolean on) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest) + ": " + on);
        send(rr);
        addTaint(on);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(on ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString()
                //+ "> " + requestToString(rr.mRequest) + ": " + on);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.615 -0400", hash_original_method = "BB835229E5EA50CDBB0B126232F0F168", hash_generated_method = "D18433B9DE179811653284B06AFFE308")
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendScreenState(true);
        // ---------- Original Method ----------
        //sendScreenState(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.617 -0400", hash_original_method = "160781DFD510822CA161AF254F33803E", hash_generated_method = "AA834817D18DE4B1EA169EA9684157AA")
    private RadioState getRadioStateFromInt(int stateInt) {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_171415166 = null; //Variable for return #1
        RadioState state;
        //Begin case 0 
        state = RadioState.RADIO_OFF;
        //End case 0 
        //Begin case 1 
        state = RadioState.RADIO_UNAVAILABLE;
        //End case 1 
        //Begin case 2 
        state = RadioState.SIM_NOT_READY;
        //End case 2 
        //Begin case 3 
        state = RadioState.SIM_LOCKED_OR_ABSENT;
        //End case 3 
        //Begin case 4 
        state = RadioState.SIM_READY;
        //End case 4 
        //Begin case 5 
        state = RadioState.RUIM_NOT_READY;
        //End case 5 
        //Begin case 6 
        state = RadioState.RUIM_READY;
        //End case 6 
        //Begin case 7 
        state = RadioState.RUIM_LOCKED_OR_ABSENT;
        //End case 7 
        //Begin case 8 
        state = RadioState.NV_NOT_READY;
        //End case 8 
        //Begin case 9 
        state = RadioState.NV_READY;
        //End case 9 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_RadioState: " + stateInt);
        //End case default 
        varB4EAC82CA7396A68D541C85D26508E83_171415166 = state;
        addTaint(stateInt);
        varB4EAC82CA7396A68D541C85D26508E83_171415166.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171415166;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.617 -0400", hash_original_method = "63485FEB05CEDE30346AAC1338BBCCD0", hash_generated_method = "954427291C6C8AFB7B940F81041935AF")
    private void switchToRadioState(RadioState newState) {
        setRadioState(newState);
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //setRadioState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.619 -0400", hash_original_method = "80B68145386C06F39CF9C77A11CB4F6E", hash_generated_method = "D20AAC8AAD15FFE2B35A5089E4A4BB71")
    private void acquireWakeLock() {
        {
            mWakeLock.acquire();
            mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            Message msg;
            msg = mSender.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            mSender.sendMessageDelayed(msg, mWakeLockTimeout);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mWakeLock) {
            //mWakeLock.acquire();
            //mRequestMessagesPending++;
            //mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            //Message msg = mSender.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            //mSender.sendMessageDelayed(msg, mWakeLockTimeout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.619 -0400", hash_original_method = "F7B2E2DA8A26C192DB4FA2BF8451999B", hash_generated_method = "5771CE983E2DEBAB7B58487A7E98EA00")
    private void releaseWakeLockIfDone() {
        {
            {
                boolean var89EBFD9F809D519C007EEC04CB5812D0_1759624847 = (mWakeLock.isHeld() &&
                (mRequestMessagesPending == 0) &&
                (mRequestMessagesWaiting == 0));
                {
                    mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                    mWakeLock.release();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mWakeLock) {
            //if (mWakeLock.isHeld() &&
                //(mRequestMessagesPending == 0) &&
                //(mRequestMessagesWaiting == 0)) {
                //mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                //mWakeLock.release();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.625 -0400", hash_original_method = "035841781AADB837D6EAD23CCB5C67B0", hash_generated_method = "D3C6079FD62199DBC8AAA51BFFFF2490")
    private void send(RILRequest rr) {
        Message msg;
        {
            rr.onError(RADIO_NOT_AVAILABLE, null);
            rr.release();
        } //End block
        msg = mSender.obtainMessage(EVENT_SEND, rr);
        acquireWakeLock();
        msg.sendToTarget();
        addTaint(rr.getTaint());
        // ---------- Original Method ----------
        //Message msg;
        //if (mSocket == null) {
            //rr.onError(RADIO_NOT_AVAILABLE, null);
            //rr.release();
            //return;
        //}
        //msg = mSender.obtainMessage(EVENT_SEND, rr);
        //acquireWakeLock();
        //msg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.627 -0400", hash_original_method = "BE5BB24392C97184A4E1C8B58214F114", hash_generated_method = "4258AF80C29E2713EB33D8D58FE7CCE4")
    private void processResponse(Parcel p) {
        int type;
        type = p.readInt();
        {
            processUnsolicited (p);
        } //End block
        {
            processSolicited (p);
        } //End block
        releaseWakeLockIfDone();
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //int type;
        //type = p.readInt();
        //if (type == RESPONSE_UNSOLICITED) {
            //processUnsolicited (p);
        //} else if (type == RESPONSE_SOLICITED) {
            //processSolicited (p);
        //}
        //releaseWakeLockIfDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.627 -0400", hash_original_method = "BC68EE684C76422271CAFE5D885C13B0", hash_generated_method = "7A85789443C37F1759638FA2349E7C6A")
    private void clearRequestsList(int error, boolean loggable) {
        RILRequest rr;
        {
            int count;
            count = mRequestsList.size();
            {
                Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                        " mReqPending=" + mRequestMessagesPending +
                        " mRequestList=" + count);
            } //End block
            {
                int i;
                i = 0;
                {
                    rr = mRequestsList.get(i);
                    {
                        Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] " +
                            requestToString(rr.mRequest));
                    } //End block
                    rr.onError(error, null);
                    rr.release();
                } //End block
            } //End collapsed parenthetic
            mRequestsList.clear();
            mRequestMessagesWaiting = 0;
        } //End block
        addTaint(error);
        addTaint(loggable);
        // ---------- Original Method ----------
        //RILRequest rr;
        //synchronized (mRequestsList) {
            //int count = mRequestsList.size();
            //if (RILJ_LOGD && loggable) {
                //Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                        //" mReqPending=" + mRequestMessagesPending +
                        //" mRequestList=" + count);
            //}
            //for (int i = 0; i < count ; i++) {
                //rr = mRequestsList.get(i);
                //if (RILJ_LOGD && loggable) {
                    //Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] " +
                            //requestToString(rr.mRequest));
                //}
                //rr.onError(error, null);
                //rr.release();
            //}
            //mRequestsList.clear();
            //mRequestMessagesWaiting = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.628 -0400", hash_original_method = "821C18746C2BF0250268E9897F34563E", hash_generated_method = "251F12B4BD7BDA2DE0FF24CB3F957338")
    private RILRequest findAndRemoveRequestFromList(int serial) {
        RILRequest varB4EAC82CA7396A68D541C85D26508E83_1968901127 = null; //Variable for return #1
        RILRequest varB4EAC82CA7396A68D541C85D26508E83_1511580053 = null; //Variable for return #2
        {
            {
                int i, s;
                i = 0;
                s = mRequestsList.size();
                {
                    RILRequest rr;
                    rr = mRequestsList.get(i);
                    {
                        mRequestsList.remove(i);
                        varB4EAC82CA7396A68D541C85D26508E83_1968901127 = rr;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1511580053 = null;
        addTaint(serial);
        RILRequest varA7E53CE21691AB073D9660D615818899_1851869531; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1851869531 = varB4EAC82CA7396A68D541C85D26508E83_1968901127;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1851869531 = varB4EAC82CA7396A68D541C85D26508E83_1511580053;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1851869531.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1851869531;
        // ---------- Original Method ----------
        //synchronized (mRequestsList) {
            //for (int i = 0, s = mRequestsList.size() ; i < s ; i++) {
                //RILRequest rr = mRequestsList.get(i);
                //if (rr.mSerial == serial) {
                    //mRequestsList.remove(i);
                    //if (mRequestMessagesWaiting > 0)
                        //mRequestMessagesWaiting--;
                    //return rr;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.648 -0400", hash_original_method = "E53F353584D1FC1676A6EAA90642D430", hash_generated_method = "6D4A9C66E888E83A924ACB1A99F43397")
    private void processSolicited(Parcel p) {
        int serial, error;
        boolean found;
        found = false;
        serial = p.readInt();
        error = p.readInt();
        RILRequest rr;
        rr = findAndRemoveRequestFromList(serial);
        Object ret;
        ret = null;
        {
            boolean varC99D962AF06CF99AD34CE6AAAD8ADD1D_4144217 = (error == 0 || p.dataAvail() > 0);
            {
                try 
                {
                    //Begin case RIL_REQUEST_GET_SIM_STATUS 
                    ret =  responseIccCardStatus(p);
                    //End case RIL_REQUEST_GET_SIM_STATUS 
                    //Begin case RIL_REQUEST_ENTER_SIM_PIN 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_ENTER_SIM_PIN 
                    //Begin case RIL_REQUEST_ENTER_SIM_PUK 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_ENTER_SIM_PUK 
                    //Begin case RIL_REQUEST_ENTER_SIM_PIN2 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_ENTER_SIM_PIN2 
                    //Begin case RIL_REQUEST_ENTER_SIM_PUK2 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_ENTER_SIM_PUK2 
                    //Begin case RIL_REQUEST_CHANGE_SIM_PIN 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CHANGE_SIM_PIN 
                    //Begin case RIL_REQUEST_CHANGE_SIM_PIN2 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CHANGE_SIM_PIN2 
                    //Begin case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION 
                    //Begin case RIL_REQUEST_GET_CURRENT_CALLS 
                    ret =  responseCallList(p);
                    //End case RIL_REQUEST_GET_CURRENT_CALLS 
                    //Begin case RIL_REQUEST_DIAL 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DIAL 
                    //Begin case RIL_REQUEST_GET_IMSI 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_GET_IMSI 
                    //Begin case RIL_REQUEST_HANGUP 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_HANGUP 
                    //Begin case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND 
                    //Begin case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND 
                    //Begin case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE 
                    //Begin case RIL_REQUEST_CONFERENCE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CONFERENCE 
                    //Begin case RIL_REQUEST_UDUB 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_UDUB 
                    //Begin case RIL_REQUEST_LAST_CALL_FAIL_CAUSE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_LAST_CALL_FAIL_CAUSE 
                    //Begin case RIL_REQUEST_SIGNAL_STRENGTH 
                    ret =  responseSignalStrength(p);
                    //End case RIL_REQUEST_SIGNAL_STRENGTH 
                    //Begin case RIL_REQUEST_VOICE_REGISTRATION_STATE 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_VOICE_REGISTRATION_STATE 
                    //Begin case RIL_REQUEST_DATA_REGISTRATION_STATE 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_DATA_REGISTRATION_STATE 
                    //Begin case RIL_REQUEST_OPERATOR 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_OPERATOR 
                    //Begin case RIL_REQUEST_RADIO_POWER 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_RADIO_POWER 
                    //Begin case RIL_REQUEST_DTMF 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DTMF 
                    //Begin case RIL_REQUEST_SEND_SMS 
                    ret =  responseSMS(p);
                    //End case RIL_REQUEST_SEND_SMS 
                    //Begin case RIL_REQUEST_SEND_SMS_EXPECT_MORE 
                    ret =  responseSMS(p);
                    //End case RIL_REQUEST_SEND_SMS_EXPECT_MORE 
                    //Begin case RIL_REQUEST_SETUP_DATA_CALL 
                    ret =  responseSetupDataCall(p);
                    //End case RIL_REQUEST_SETUP_DATA_CALL 
                    //Begin case RIL_REQUEST_SIM_IO 
                    ret =  responseICC_IO(p);
                    //End case RIL_REQUEST_SIM_IO 
                    //Begin case RIL_REQUEST_SEND_USSD 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SEND_USSD 
                    //Begin case RIL_REQUEST_CANCEL_USSD 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CANCEL_USSD 
                    //Begin case RIL_REQUEST_GET_CLIR 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_GET_CLIR 
                    //Begin case RIL_REQUEST_SET_CLIR 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_CLIR 
                    //Begin case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS 
                    ret =  responseCallForward(p);
                    //End case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS 
                    //Begin case RIL_REQUEST_SET_CALL_FORWARD 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_CALL_FORWARD 
                    //Begin case RIL_REQUEST_QUERY_CALL_WAITING 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_CALL_WAITING 
                    //Begin case RIL_REQUEST_SET_CALL_WAITING 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_CALL_WAITING 
                    //Begin case RIL_REQUEST_SMS_ACKNOWLEDGE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SMS_ACKNOWLEDGE 
                    //Begin case RIL_REQUEST_GET_IMEI 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_GET_IMEI 
                    //Begin case RIL_REQUEST_GET_IMEISV 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_GET_IMEISV 
                    //Begin case RIL_REQUEST_ANSWER 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_ANSWER 
                    //Begin case RIL_REQUEST_DEACTIVATE_DATA_CALL 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DEACTIVATE_DATA_CALL 
                    //Begin case RIL_REQUEST_QUERY_FACILITY_LOCK 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_FACILITY_LOCK 
                    //Begin case RIL_REQUEST_SET_FACILITY_LOCK 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_SET_FACILITY_LOCK 
                    //Begin case RIL_REQUEST_CHANGE_BARRING_PASSWORD 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CHANGE_BARRING_PASSWORD 
                    //Begin case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE 
                    //Begin case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC 
                    //Begin case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL 
                    //Begin case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS 
                    ret =  responseOperatorInfos(p);
                    //End case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS 
                    //Begin case RIL_REQUEST_DTMF_START 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DTMF_START 
                    //Begin case RIL_REQUEST_DTMF_STOP 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DTMF_STOP 
                    //Begin case RIL_REQUEST_BASEBAND_VERSION 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_BASEBAND_VERSION 
                    //Begin case RIL_REQUEST_SEPARATE_CONNECTION 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SEPARATE_CONNECTION 
                    //Begin case RIL_REQUEST_SET_MUTE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_MUTE 
                    //Begin case RIL_REQUEST_GET_MUTE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_GET_MUTE 
                    //Begin case RIL_REQUEST_QUERY_CLIP 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_CLIP 
                    //Begin case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE 
                    //Begin case RIL_REQUEST_DATA_CALL_LIST 
                    ret =  responseDataCallList(p);
                    //End case RIL_REQUEST_DATA_CALL_LIST 
                    //Begin case RIL_REQUEST_RESET_RADIO 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_RESET_RADIO 
                    //Begin case RIL_REQUEST_OEM_HOOK_RAW 
                    ret =  responseRaw(p);
                    //End case RIL_REQUEST_OEM_HOOK_RAW 
                    //Begin case RIL_REQUEST_OEM_HOOK_STRINGS 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_OEM_HOOK_STRINGS 
                    //Begin case RIL_REQUEST_SCREEN_STATE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SCREEN_STATE 
                    //Begin case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION 
                    //Begin case RIL_REQUEST_WRITE_SMS_TO_SIM 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_WRITE_SMS_TO_SIM 
                    //Begin case RIL_REQUEST_DELETE_SMS_ON_SIM 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_DELETE_SMS_ON_SIM 
                    //Begin case RIL_REQUEST_SET_BAND_MODE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_BAND_MODE 
                    //Begin case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE 
                    //Begin case RIL_REQUEST_STK_GET_PROFILE 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_STK_GET_PROFILE 
                    //Begin case RIL_REQUEST_STK_SET_PROFILE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_STK_SET_PROFILE 
                    //Begin case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND 
                    //Begin case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE 
                    //Begin case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM 
                    //Begin case RIL_REQUEST_EXPLICIT_CALL_TRANSFER 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_EXPLICIT_CALL_TRANSFER 
                    //Begin case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE 
                    //Begin case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE 
                    ret =  responseGetPreferredNetworkType(p);
                    //End case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE 
                    //Begin case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS 
                    ret = responseCellList(p);
                    //End case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS 
                    //Begin case RIL_REQUEST_SET_LOCATION_UPDATES 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_LOCATION_UPDATES 
                    //Begin case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE 
                    //Begin case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE 
                    //Begin case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE 
                    //Begin case RIL_REQUEST_SET_TTY_MODE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_SET_TTY_MODE 
                    //Begin case RIL_REQUEST_QUERY_TTY_MODE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_QUERY_TTY_MODE 
                    //Begin case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE 
                    //Begin case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE 
                    //Begin case RIL_REQUEST_CDMA_FLASH 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_FLASH 
                    //Begin case RIL_REQUEST_CDMA_BURST_DTMF 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_BURST_DTMF 
                    //Begin case RIL_REQUEST_CDMA_SEND_SMS 
                    ret =  responseSMS(p);
                    //End case RIL_REQUEST_CDMA_SEND_SMS 
                    //Begin case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE 
                    //Begin case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG 
                    ret =  responseGmsBroadcastConfig(p);
                    //End case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG 
                    //Begin case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG 
                    //Begin case RIL_REQUEST_GSM_BROADCAST_ACTIVATION 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_GSM_BROADCAST_ACTIVATION 
                    //Begin case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG 
                    ret =  responseCdmaBroadcastConfig(p);
                    //End case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG 
                    //Begin case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG 
                    //Begin case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION 
                    //Begin case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY 
                    //Begin case RIL_REQUEST_CDMA_SUBSCRIPTION 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_CDMA_SUBSCRIPTION 
                    //Begin case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM 
                    //Begin case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM 
                    ret =  responseVoid(p);
                    //End case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM 
                    //Begin case RIL_REQUEST_DEVICE_IDENTITY 
                    ret =  responseStrings(p);
                    //End case RIL_REQUEST_DEVICE_IDENTITY 
                    //Begin case RIL_REQUEST_GET_SMSC_ADDRESS 
                    ret = responseString(p);
                    //End case RIL_REQUEST_GET_SMSC_ADDRESS 
                    //Begin case RIL_REQUEST_SET_SMSC_ADDRESS 
                    ret = responseVoid(p);
                    //End case RIL_REQUEST_SET_SMSC_ADDRESS 
                    //Begin case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE 
                    ret = responseVoid(p);
                    //End case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE 
                    //Begin case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS 
                    ret = responseVoid(p);
                    //End case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS 
                    //Begin case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING 
                    ret = responseVoid(p);
                    //End case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING 
                    //Begin case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE 
                    ret =  responseInts(p);
                    //End case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE 
                    //Begin case RIL_REQUEST_ISIM_AUTHENTICATION 
                    ret =  responseString(p);
                    //End case RIL_REQUEST_ISIM_AUTHENTICATION 
                    //Begin case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU 
                    ret = responseVoid(p);
                    //End case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU 
                    //Begin case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS 
                    ret = responseICC_IO(p);
                    //End case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized solicited response: " + rr.mRequest);
                    //End case default 
                } //End block
                catch (Throwable tr)
                {
                    {
                        AsyncResult.forMessage(rr.mResult, null, tr);
                        rr.mResult.sendToTarget();
                    } //End block
                    rr.release();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            rr.onError(error, ret);
            rr.release();
        } //End block
        riljLog(rr.serialString() + "< " + requestToString(rr.mRequest)
            + " " + retToString(rr.mRequest, ret));
        {
            AsyncResult.forMessage(rr.mResult, ret, null);
            rr.mResult.sendToTarget();
        } //End block
        rr.release();
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:18.757 -0400", hash_original_method = "8A94A1215BBA17FF474D4F8406941ACC", hash_generated_method = "B3ED0B1B52CC3EE9E50FB6FA0C87C81A")
    private String retToString(int req, Object ret) {
        String varB4EAC82CA7396A68D541C85D26508E83_1342998438 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_49504807 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1884498865 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1342998438 = "";
        //Begin case RIL_REQUEST_GET_IMSI RIL_REQUEST_GET_IMEI RIL_REQUEST_GET_IMEISV 
        {
            varB4EAC82CA7396A68D541C85D26508E83_49504807 = "";
        } //End block
        //End case RIL_REQUEST_GET_IMSI RIL_REQUEST_GET_IMEI RIL_REQUEST_GET_IMEISV 
        StringBuilder sb;
        String s;
        int length;
        {
            int[] intArray;
            intArray = (int[]) ret;
            length = intArray.length;
            sb = new StringBuilder("{");
            {
                int i;
                i = 0;
                sb.append(intArray[i++]);
                {
                    sb.append(", ").append(intArray[i++]);
                } //End block
            } //End block
            sb.append("}");
            s = sb.toString();
        } //End block
        {
            String[] strings;
            strings = (String[]) ret;
            length = strings.length;
            sb = new StringBuilder("{");
            {
                int i;
                i = 0;
                sb.append(strings[i++]);
                {
                    sb.append(", ").append(strings[i++]);
                } //End block
            } //End block
            sb.append("}");
            s = sb.toString();
        } //End block
        {
            ArrayList<DriverCall> calls;
            calls = (ArrayList<DriverCall>) ret;
            sb = new StringBuilder(" ");
            {
                Iterator<DriverCall> var4B2037772A81856F80258F9F44AA331B_1956844745 = (calls).iterator();
                var4B2037772A81856F80258F9F44AA331B_1956844745.hasNext();
                DriverCall dc = var4B2037772A81856F80258F9F44AA331B_1956844745.next();
                {
                    sb.append("[").append(dc).append("] ");
                } //End block
            } //End collapsed parenthetic
            s = sb.toString();
        } //End block
        {
            ArrayList<NeighboringCellInfo> cells;
            cells = (ArrayList<NeighboringCellInfo>) ret;
            sb = new StringBuilder(" ");
            {
                Iterator<NeighboringCellInfo> varA3884DD0459ACF5B7D7CFE2B0AD6D134_1064014645 = (cells).iterator();
                varA3884DD0459ACF5B7D7CFE2B0AD6D134_1064014645.hasNext();
                NeighboringCellInfo cell = varA3884DD0459ACF5B7D7CFE2B0AD6D134_1064014645.next();
                {
                    sb.append(cell).append(" ");
                } //End block
            } //End collapsed parenthetic
            s = sb.toString();
        } //End block
        {
            s = ret.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1884498865 = s;
        addTaint(req);
        addTaint(ret.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2060366765; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2060366765 = varB4EAC82CA7396A68D541C85D26508E83_1342998438;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2060366765 = varB4EAC82CA7396A68D541C85D26508E83_49504807;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2060366765 = varB4EAC82CA7396A68D541C85D26508E83_1884498865;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2060366765.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2060366765;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.221 -0400", hash_original_method = "0DD0C2CAC9DFFC256536DE8141109DEC", hash_generated_method = "8443E8FE5065C7CBD3E912D7554614BA")
    private void processUnsolicited(Parcel p) {
        int response;
        Object ret;
        response = p.readInt();
        try 
        {
            //Begin case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
            //Begin case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
            //Begin case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
            //Begin case RIL_UNSOL_RESPONSE_NEW_SMS 
            ret =  responseString(p);
            //End case RIL_UNSOL_RESPONSE_NEW_SMS 
            //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
            ret =  responseString(p);
            //End case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
            //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
            ret =  responseInts(p);
            //End case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
            //Begin case RIL_UNSOL_ON_USSD 
            ret =  responseStrings(p);
            //End case RIL_UNSOL_ON_USSD 
            //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
            ret =  responseString(p);
            //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
            //Begin case RIL_UNSOL_SIGNAL_STRENGTH 
            ret = responseSignalStrength(p);
            //End case RIL_UNSOL_SIGNAL_STRENGTH 
            //Begin case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
            ret = responseDataCallList(p);
            //End case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
            //Begin case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
            ret = responseSuppServiceNotification(p);
            //End case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
            //Begin case RIL_UNSOL_STK_SESSION_END 
            ret = responseVoid(p);
            //End case RIL_UNSOL_STK_SESSION_END 
            //Begin case RIL_UNSOL_STK_PROACTIVE_COMMAND 
            ret = responseString(p);
            //End case RIL_UNSOL_STK_PROACTIVE_COMMAND 
            //Begin case RIL_UNSOL_STK_EVENT_NOTIFY 
            ret = responseString(p);
            //End case RIL_UNSOL_STK_EVENT_NOTIFY 
            //Begin case RIL_UNSOL_STK_CALL_SETUP 
            ret = responseInts(p);
            //End case RIL_UNSOL_STK_CALL_SETUP 
            //Begin case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
            //Begin case RIL_UNSOL_SIM_REFRESH 
            ret =  responseInts(p);
            //End case RIL_UNSOL_SIM_REFRESH 
            //Begin case RIL_UNSOL_CALL_RING 
            ret =  responseCallRing(p);
            //End case RIL_UNSOL_CALL_RING 
            //Begin case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
            ret = responseInts(p);
            //End case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
            //Begin case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
            //Begin case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
            ret =  responseCdmaSms(p);
            //End case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
            //Begin case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
            ret =  responseRaw(p);
            //End case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
            //Begin case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
            ret =  responseVoid(p);
            //End case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
            //Begin case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
            ret = responseVoid(p);
            //End case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
            //Begin case RIL_UNSOL_CDMA_CALL_WAITING 
            ret = responseCdmaCallWaiting(p);
            //End case RIL_UNSOL_CDMA_CALL_WAITING 
            //Begin case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
            ret = responseInts(p);
            //End case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
            //Begin case RIL_UNSOL_CDMA_INFO_REC 
            ret = responseCdmaInformationRecord(p);
            //End case RIL_UNSOL_CDMA_INFO_REC 
            //Begin case RIL_UNSOL_OEM_HOOK_RAW 
            ret = responseRaw(p);
            //End case RIL_UNSOL_OEM_HOOK_RAW 
            //Begin case RIL_UNSOL_RINGBACK_TONE 
            ret = responseInts(p);
            //End case RIL_UNSOL_RINGBACK_TONE 
            //Begin case RIL_UNSOL_RESEND_INCALL_MUTE 
            ret = responseVoid(p);
            //End case RIL_UNSOL_RESEND_INCALL_MUTE 
            //Begin case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
            ret = responseInts(p);
            //End case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
            //Begin case RIL_UNSOl_CDMA_PRL_CHANGED 
            ret = responseInts(p);
            //End case RIL_UNSOl_CDMA_PRL_CHANGED 
            //Begin case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
            ret = responseVoid(p);
            //End case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
            //Begin case RIL_UNSOL_RIL_CONNECTED 
            ret = responseInts(p);
            //End case RIL_UNSOL_RIL_CONNECTED 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized unsol response: " + response);
            //End case default 
        } //End block
        catch (Throwable tr)
        { }
        //Begin case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        RadioState newState;
        newState = getRadioStateFromInt(p.readInt());
        //End case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        unsljLogMore(response, newState.toString());
        //End case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        switchToRadioState(newState);
        //End case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
        unsljLog(response);
        //End case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
        mCallStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        //End case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
        unsljLog(response);
        //End case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
        mVoiceNetworkStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        //End case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS 
        {
            unsljLog(response);
            String a[];
            a = new String[2];
            a[1] = (String)ret;
            SmsMessage sms;
            sms = SmsMessage.newFromCMT(a);
            {
                mGsmSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
            } //End block
        } //End block
        //End case RIL_UNSOL_RESPONSE_NEW_SMS 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
        {
            mSmsStatusRegistrant.notifyRegistrant(
                            new AsyncResult(null, ret, null));
        } //End block
        //End case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        int[] smsIndex;
        smsIndex = (int[])ret;
        //End case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        //Begin case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        {
            {
                mSmsOnSimRegistrant.
                                notifyRegistrant(new AsyncResult(null, smsIndex, null));
            } //End block
        } //End block
        {
            riljLog(" NEW_SMS_ON_SIM ERROR with wrong length "
                            + smsIndex.length);
        } //End block
        //End case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM 
        //Begin case RIL_UNSOL_ON_USSD 
        String[] resp;
        resp = (String[])ret;
        //End case RIL_UNSOL_ON_USSD 
        //Begin case RIL_UNSOL_ON_USSD 
        {
            resp = new String[2];
            resp[0] = ((String[])ret)[0];
            resp[1] = null;
        } //End block
        //End case RIL_UNSOL_ON_USSD 
        //Begin case RIL_UNSOL_ON_USSD 
        unsljLogMore(response, resp[0]);
        //End case RIL_UNSOL_ON_USSD 
        //Begin case RIL_UNSOL_ON_USSD 
        {
            mUSSDRegistrant.notifyRegistrant(
                        new AsyncResult (null, resp, null));
        } //End block
        //End case RIL_UNSOL_ON_USSD 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        long nitzReceiveTime;
        nitzReceiveTime = p.readLong();
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        Object[] result;
        result = new Object[2];
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        result[0] = ret;
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        result[1] = Long.valueOf(nitzReceiveTime);
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_NITZ_TIME_RECEIVED 
        {
            mNITZTimeRegistrant
                        .notifyRegistrant(new AsyncResult (null, result, null));
        } //End block
        {
            mLastNITZTimeInfo = result;
        } //End block
        //End case RIL_UNSOL_NITZ_TIME_RECEIVED 
        //Begin case RIL_UNSOL_SIGNAL_STRENGTH 
        unsljLogvRet(response, ret);
        //End case RIL_UNSOL_SIGNAL_STRENGTH 
        //Begin case RIL_UNSOL_SIGNAL_STRENGTH 
        {
            mSignalStrengthRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_SIGNAL_STRENGTH 
        //Begin case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
        //Begin case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
        mDataNetworkStateRegistrants.notifyRegistrants(new AsyncResult(null, ret, null));
        //End case RIL_UNSOL_DATA_CALL_LIST_CHANGED 
        //Begin case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
        //Begin case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
        {
            mSsnRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_SUPP_SVC_NOTIFICATION 
        //Begin case RIL_UNSOL_STK_SESSION_END 
        unsljLog(response);
        //End case RIL_UNSOL_STK_SESSION_END 
        //Begin case RIL_UNSOL_STK_SESSION_END 
        {
            mCatSessionEndRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_STK_SESSION_END 
        //Begin case RIL_UNSOL_STK_PROACTIVE_COMMAND 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_STK_PROACTIVE_COMMAND 
        //Begin case RIL_UNSOL_STK_PROACTIVE_COMMAND 
        {
            mCatProCmdRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_STK_PROACTIVE_COMMAND 
        //Begin case RIL_UNSOL_STK_EVENT_NOTIFY 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_STK_EVENT_NOTIFY 
        //Begin case RIL_UNSOL_STK_EVENT_NOTIFY 
        {
            mCatEventRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_STK_EVENT_NOTIFY 
        //Begin case RIL_UNSOL_STK_CALL_SETUP 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_STK_CALL_SETUP 
        //Begin case RIL_UNSOL_STK_CALL_SETUP 
        {
            mCatCallSetUpRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_STK_CALL_SETUP 
        //Begin case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
        unsljLog(response);
        //End case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
        //Begin case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } //End block
        //End case RIL_UNSOL_SIM_SMS_STORAGE_FULL 
        //Begin case RIL_UNSOL_SIM_REFRESH 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_SIM_REFRESH 
        //Begin case RIL_UNSOL_SIM_REFRESH 
        {
            mIccRefreshRegistrants.notifyRegistrants(
                            new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_SIM_REFRESH 
        //Begin case RIL_UNSOL_CALL_RING 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_CALL_RING 
        //Begin case RIL_UNSOL_CALL_RING 
        {
            mRingRegistrant.notifyRegistrant(
                            new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_CALL_RING 
        //Begin case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
        unsljLogvRet(response, ret);
        //End case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
        {
            mRestrictedStateRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_RESTRICTED_STATE_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
        unsljLog(response);
        //End case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
        {
            mIccStatusChangedRegistrants.notifyRegistrants();
        } //End block
        //End case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED 
        //Begin case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        unsljLog(response);
        //End case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        //Begin case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        SmsMessage sms;
        sms = (SmsMessage) ret;
        //End case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        //Begin case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        {
            mCdmaSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
        } //End block
        //End case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS 
        //Begin case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
        unsljLog(response);
        //End case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
        //Begin case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
        {
            mGsmBroadcastSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, ret, null));
        } //End block
        //End case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS 
        //Begin case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
        unsljLog(response);
        //End case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
        //Begin case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } //End block
        //End case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL 
        //Begin case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
        unsljLog(response);
        //End case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
        //Begin case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
        {
            mEmergencyCallbackModeRegistrant.notifyRegistrant();
        } //End block
        //End case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE 
        //Begin case RIL_UNSOL_CDMA_CALL_WAITING 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_CDMA_CALL_WAITING 
        //Begin case RIL_UNSOL_CDMA_CALL_WAITING 
        {
            mCallWaitingInfoRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_CDMA_CALL_WAITING 
        //Begin case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
        //Begin case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
        {
            mOtaProvisionRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS 
        //Begin case RIL_UNSOL_CDMA_INFO_REC 
        ArrayList<CdmaInformationRecords> listInfoRecs;
        //End case RIL_UNSOL_CDMA_INFO_REC 
        //Begin case RIL_UNSOL_CDMA_INFO_REC 
        try 
        {
            listInfoRecs = (ArrayList<CdmaInformationRecords>)ret;
        } //End block
        catch (ClassCastException e)
        { }
        //End case RIL_UNSOL_CDMA_INFO_REC 
        //Begin case RIL_UNSOL_CDMA_INFO_REC 
        {
            Iterator<CdmaInformationRecords> var31392388BAFC4C31423B73000D3019F0_848297363 = (listInfoRecs).iterator();
            var31392388BAFC4C31423B73000D3019F0_848297363.hasNext();
            CdmaInformationRecords rec = var31392388BAFC4C31423B73000D3019F0_848297363.next();
            {
                unsljLogRet(response, rec);
                notifyRegistrantsCdmaInfoRec(rec);
            } //End block
        } //End collapsed parenthetic
        //End case RIL_UNSOL_CDMA_INFO_REC 
        //Begin case RIL_UNSOL_OEM_HOOK_RAW 
        unsljLogvRet(response, IccUtils.bytesToHexString((byte[])ret));
        //End case RIL_UNSOL_OEM_HOOK_RAW 
        //Begin case RIL_UNSOL_OEM_HOOK_RAW 
        {
            mUnsolOemHookRawRegistrant.notifyRegistrant(new AsyncResult(null, ret, null));
        } //End block
        //End case RIL_UNSOL_OEM_HOOK_RAW 
        //Begin case RIL_UNSOL_RINGBACK_TONE 
        unsljLogvRet(response, ret);
        //End case RIL_UNSOL_RINGBACK_TONE 
        //Begin case RIL_UNSOL_RINGBACK_TONE 
        {
            boolean playtone;
            playtone = (((int[])ret)[0] == 1);
            mRingbackToneRegistrants.notifyRegistrants(
                                        new AsyncResult (null, playtone, null));
        } //End block
        //End case RIL_UNSOL_RINGBACK_TONE 
        //Begin case RIL_UNSOL_RESEND_INCALL_MUTE 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_RESEND_INCALL_MUTE 
        //Begin case RIL_UNSOL_RESEND_INCALL_MUTE 
        {
            mResendIncallMuteRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_RESEND_INCALL_MUTE 
        //Begin case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
        //Begin case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
        {
            mCdmaSubscriptionChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED 
        //Begin case RIL_UNSOl_CDMA_PRL_CHANGED 
        unsljLogRet(response, ret);
        //End case RIL_UNSOl_CDMA_PRL_CHANGED 
        //Begin case RIL_UNSOl_CDMA_PRL_CHANGED 
        {
            mCdmaPrlChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        //End case RIL_UNSOl_CDMA_PRL_CHANGED 
        //Begin case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
        unsljLogRet(response, ret);
        //End case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
        //Begin case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
        {
            mExitEmergencyCallbackModeRegistrants.notifyRegistrants(
                                        new AsyncResult (null, null, null));
        } //End block
        //End case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE 
        //Begin case RIL_UNSOL_RIL_CONNECTED 
        {
            unsljLogRet(response, ret);
            setRadioPower(false, null);
            setPreferredNetworkType(mPreferredNetworkType, null);
            setCdmaSubscriptionSource(mCdmaSubscription, null);
            notifyRegistrantsRilConnectionChanged(((int[])ret)[0]);
        } //End block
        //End case RIL_UNSOL_RIL_CONNECTED 
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.248 -0400", hash_original_method = "B856EBB2256F144A73FE56175A9B6A36", hash_generated_method = "DC2B05731FADC5E6AEC3A48FE5E1D3A8")
    private void notifyRegistrantsRilConnectionChanged(int rilVer) {
        mRilVersion = rilVer;
        {
            mRilConnectedRegistrants.notifyRegistrants(
                                new AsyncResult (null, new Integer(rilVer), null));
        } //End block
        addTaint(rilVer);
        // ---------- Original Method ----------
        //mRilVersion = rilVer;
        //if (mRilConnectedRegistrants != null) {
            //mRilConnectedRegistrants.notifyRegistrants(
                                //new AsyncResult (null, new Integer(rilVer), null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.249 -0400", hash_original_method = "2C7447093749DDBD708485E3CB5D7194", hash_generated_method = "036A519D6791366F4E31E65A1F482DE6")
    private Object responseInts(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1080183071 = null; //Variable for return #1
        int numInts;
        int response[];
        numInts = p.readInt();
        response = new int[numInts];
        {
            int i;
            i = 0;
            {
                response[i] = p.readInt();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1080183071 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1080183071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1080183071;
        // ---------- Original Method ----------
        //int numInts;
        //int response[];
        //numInts = p.readInt();
        //response = new int[numInts];
        //for (int i = 0 ; i < numInts ; i++) {
            //response[i] = p.readInt();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.249 -0400", hash_original_method = "F83E9E0330A999E5D5277EA606DEC7ED", hash_generated_method = "B10946A647BD518910760944A770D921")
    private Object responseVoid(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1478747550 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1478747550 = null;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1478747550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1478747550;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.251 -0400", hash_original_method = "A9CCF034900EFF9E845FDB7DB22E08D2", hash_generated_method = "E28984FCB4077A5BF5D82546C4AA5873")
    private Object responseCallForward(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_378445079 = null; //Variable for return #1
        int numInfos;
        CallForwardInfo infos[];
        numInfos = p.readInt();
        infos = new CallForwardInfo[numInfos];
        {
            int i;
            i = 0;
            {
                infos[i] = new CallForwardInfo();
                infos[i].status = p.readInt();
                infos[i].reason = p.readInt();
                infos[i].serviceClass = p.readInt();
                infos[i].toa = p.readInt();
                infos[i].number = p.readString();
                infos[i].timeSeconds = p.readInt();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_378445079 = infos;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_378445079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_378445079;
        // ---------- Original Method ----------
        //int numInfos;
        //CallForwardInfo infos[];
        //numInfos = p.readInt();
        //infos = new CallForwardInfo[numInfos];
        //for (int i = 0 ; i < numInfos ; i++) {
            //infos[i] = new CallForwardInfo();
            //infos[i].status = p.readInt();
            //infos[i].reason = p.readInt();
            //infos[i].serviceClass = p.readInt();
            //infos[i].toa = p.readInt();
            //infos[i].number = p.readString();
            //infos[i].timeSeconds = p.readInt();
        //}
        //return infos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.264 -0400", hash_original_method = "6CA2F91918640E9DE536352B73E673A3", hash_generated_method = "891F3B4C1C02D980618167F344172988")
    private Object responseSuppServiceNotification(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1489515808 = null; //Variable for return #1
        SuppServiceNotification notification;
        notification = new SuppServiceNotification();
        notification.notificationType = p.readInt();
        notification.code = p.readInt();
        notification.index = p.readInt();
        notification.type = p.readInt();
        notification.number = p.readString();
        varB4EAC82CA7396A68D541C85D26508E83_1489515808 = notification;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1489515808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489515808;
        // ---------- Original Method ----------
        //SuppServiceNotification notification = new SuppServiceNotification();
        //notification.notificationType = p.readInt();
        //notification.code = p.readInt();
        //notification.index = p.readInt();
        //notification.type = p.readInt();
        //notification.number = p.readString();
        //return notification;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.265 -0400", hash_original_method = "F3FE5FFB00EF9163091B0B3C9957ECDA", hash_generated_method = "4CD3F6900ACB28EC5ACF55648C6441A6")
    private Object responseCdmaSms(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_992119892 = null; //Variable for return #1
        SmsMessage sms;
        sms = SmsMessage.newFromParcel(p);
        varB4EAC82CA7396A68D541C85D26508E83_992119892 = sms;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_992119892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992119892;
        // ---------- Original Method ----------
        //SmsMessage sms;
        //sms = SmsMessage.newFromParcel(p);
        //return sms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.265 -0400", hash_original_method = "E706FBE3176786F101EC24273C477E8B", hash_generated_method = "AF25BBB43D50F5BD8A3685678A29049F")
    private Object responseString(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_106313984 = null; //Variable for return #1
        String response;
        response = p.readString();
        varB4EAC82CA7396A68D541C85D26508E83_106313984 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_106313984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106313984;
        // ---------- Original Method ----------
        //String response;
        //response = p.readString();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.266 -0400", hash_original_method = "D52365FD6A67C03CB48CBBF364BA22AF", hash_generated_method = "AAC3B2631CFC005ECC358AB2517D8371")
    private Object responseStrings(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2015646720 = null; //Variable for return #1
        int num;
        String response[];
        response = p.readStringArray();
        {
            num = p.readInt();
            response = new String[num];
            {
                int i;
                i = 0;
                {
                    response[i] = p.readString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2015646720 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2015646720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015646720;
        // ---------- Original Method ----------
        //int num;
        //String response[];
        //response = p.readStringArray();
        //if (false) {
            //num = p.readInt();
            //response = new String[num];
            //for (int i = 0; i < num; i++) {
                //response[i] = p.readString();
            //}
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.278 -0400", hash_original_method = "B7DD4FAF5DCF16E3869A5E71E7C7982F", hash_generated_method = "E65E52532EC33CDBE99F6D84391DA04B")
    private Object responseRaw(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_489464357 = null; //Variable for return #1
        int num;
        byte response[];
        response = p.createByteArray();
        varB4EAC82CA7396A68D541C85D26508E83_489464357 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_489464357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_489464357;
        // ---------- Original Method ----------
        //int num;
        //byte response[];
        //response = p.createByteArray();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.278 -0400", hash_original_method = "6A2331BAD13DEAF24E14B96082F25F22", hash_generated_method = "82951BDFE4A10B9FA3C46ADE98E47101")
    private Object responseSMS(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1855756640 = null; //Variable for return #1
        int messageRef, errorCode;
        String ackPDU;
        messageRef = p.readInt();
        ackPDU = p.readString();
        errorCode = p.readInt();
        SmsResponse response;
        response = new SmsResponse(messageRef, ackPDU, errorCode);
        varB4EAC82CA7396A68D541C85D26508E83_1855756640 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1855756640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1855756640;
        // ---------- Original Method ----------
        //int messageRef, errorCode;
        //String ackPDU;
        //messageRef = p.readInt();
        //ackPDU = p.readString();
        //errorCode = p.readInt();
        //SmsResponse response = new SmsResponse(messageRef, ackPDU, errorCode);
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.279 -0400", hash_original_method = "36285902341CFAECFF4B1CF0D454D382", hash_generated_method = "D625948B0C96BD84C9483F549713B1F3")
    private Object responseICC_IO(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_801126475 = null; //Variable for return #1
        int sw1, sw2;
        byte data[];
        data = null;
        Message ret;
        sw1 = p.readInt();
        sw2 = p.readInt();
        String s;
        s = p.readString();
        riljLog("< iccIO: "
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s);
        varB4EAC82CA7396A68D541C85D26508E83_801126475 = new IccIoResult(sw1, sw2, s);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_801126475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801126475;
        // ---------- Original Method ----------
        //int sw1, sw2;
        //byte data[] = null;
        //Message ret;
        //sw1 = p.readInt();
        //sw2 = p.readInt();
        //String s = p.readString();
        //if (RILJ_LOGV) riljLog("< iccIO: "
                //+ " 0x" + Integer.toHexString(sw1)
                //+ " 0x" + Integer.toHexString(sw2) + " "
                //+ s);
        //return new IccIoResult(sw1, sw2, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.285 -0400", hash_original_method = "D5683AC0AFFFFAC7278B155F54988C15", hash_generated_method = "D67BCA83321FC02DE74132B595C7F581")
    private Object responseIccCardStatus(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1567697385 = null; //Variable for return #1
        IccCardApplication ca;
        IccCardStatus status;
        status = new IccCardStatus();
        status.setCardState(p.readInt());
        status.setUniversalPinState(p.readInt());
        status.setGsmUmtsSubscriptionAppIndex(p.readInt());
        status.setCdmaSubscriptionAppIndex(p.readInt());
        status.setImsSubscriptionAppIndex(p.readInt());
        int numApplications;
        numApplications = p.readInt();
        {
            numApplications = IccCardStatus.CARD_MAX_APPS;
        } //End block
        status.setNumApplications(numApplications);
        {
            int i;
            i = 0;
            {
                ca = new IccCardApplication();
                ca.app_type       = ca.AppTypeFromRILInt(p.readInt());
                ca.app_state      = ca.AppStateFromRILInt(p.readInt());
                ca.perso_substate = ca.PersoSubstateFromRILInt(p.readInt());
                ca.aid            = p.readString();
                ca.app_label      = p.readString();
                ca.pin1_replaced  = p.readInt();
                ca.pin1           = ca.PinStateFromRILInt(p.readInt());
                ca.pin2           = ca.PinStateFromRILInt(p.readInt());
                status.addApplication(ca);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1567697385 = status;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1567697385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1567697385;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.302 -0400", hash_original_method = "26536CEB9BA98624BF6B84456E63F303", hash_generated_method = "35E0DB3E721B4DF3C1559D3E8B89A40B")
    private Object responseCallList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1680134533 = null; //Variable for return #1
        int num;
        int voiceSettings;
        ArrayList<DriverCall> response;
        DriverCall dc;
        num = p.readInt();
        response = new ArrayList<DriverCall>(num);
        {
            int i;
            i = 0;
            {
                dc = new DriverCall();
                dc.state = DriverCall.stateFromCLCC(p.readInt());
                dc.index = p.readInt();
                dc.TOA = p.readInt();
                dc.isMpty = (0 != p.readInt());
                dc.isMT = (0 != p.readInt());
                dc.als = p.readInt();
                voiceSettings = p.readInt();
                dc.isVoice = (0 == voiceSettings) ? false : true;
                dc.isVoicePrivacy = (0 != p.readInt());
                dc.number = p.readString();
                int np;
                np = p.readInt();
                dc.numberPresentation = DriverCall.presentationFromCLIP(np);
                dc.name = p.readString();
                dc.namePresentation = p.readInt();
                int uusInfoPresent;
                uusInfoPresent = p.readInt();
                {
                    dc.uusInfo = new UUSInfo();
                    dc.uusInfo.setType(p.readInt());
                    dc.uusInfo.setDcs(p.readInt());
                    byte[] userData;
                    userData = p.createByteArray();
                    dc.uusInfo.setUserData(userData);
                    riljLogv(String.format("Incoming UUS : type=%d, dcs=%d, length=%d",
                                dc.uusInfo.getType(), dc.uusInfo.getDcs(),
                                dc.uusInfo.getUserData().length));
                    riljLogv("Incoming UUS : data (string)="
                        + new String(dc.uusInfo.getUserData()));
                    riljLogv("Incoming UUS : data (hex): "
                        + IccUtils.bytesToHexString(dc.uusInfo.getUserData()));
                } //End block
                {
                    riljLogv("Incoming UUS : NOT present!");
                } //End block
                dc.number = PhoneNumberUtils.stringFromStringAndTOA(dc.number, dc.TOA);
                response.add(dc);
                {
                    mVoicePrivacyOnRegistrants.notifyRegistrants();
                    riljLog("InCall VoicePrivacy is enabled");
                } //End block
                {
                    mVoicePrivacyOffRegistrants.notifyRegistrants();
                    riljLog("InCall VoicePrivacy is disabled");
                } //End block
            } //End block
        } //End collapsed parenthetic
        Collections.sort(response);
        varB4EAC82CA7396A68D541C85D26508E83_1680134533 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1680134533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1680134533;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.304 -0400", hash_original_method = "ED5CAFCBF47B1330CD2566A0B897CA0C", hash_generated_method = "E7B1DD4B2316B13C2B0BFC2CC76FE31B")
    private DataCallState getDataCallState(Parcel p, int version) {
        DataCallState varB4EAC82CA7396A68D541C85D26508E83_529707797 = null; //Variable for return #1
        DataCallState dataCall;
        dataCall = new DataCallState();
        dataCall.version = version;
        {
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            String addresses;
            addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_460370307 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dataCall.status = p.readInt();
            dataCall.suggestedRetryTime = p.readInt();
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            dataCall.ifname = p.readString();
            {
                boolean var9C097F15414DD096BEEBECEC45CBC3B3_43565285 = ((dataCall.status == DataConnection.FailCause.NONE.getErrorCode()) &&
                    TextUtils.isEmpty(dataCall.ifname));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getDataCallState, no ifname");
                } //End block
            } //End collapsed parenthetic
            String addresses;
            addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_665406673 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } //End block
            } //End collapsed parenthetic
            String dnses;
            dnses = p.readString();
            {
                boolean var22967F124DA8C753464DD7656A6CF5D6_1360450967 = (!TextUtils.isEmpty(dnses));
                {
                    dataCall.dnses = dnses.split(" ");
                } //End block
            } //End collapsed parenthetic
            String gateways;
            gateways = p.readString();
            {
                boolean var68C55CDE386BBAC0DE45A0309B2750DE_1711913279 = (!TextUtils.isEmpty(gateways));
                {
                    dataCall.gateways = gateways.split(" ");
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_529707797 = dataCall;
        addTaint(p.getTaint());
        addTaint(version);
        varB4EAC82CA7396A68D541C85D26508E83_529707797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_529707797;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.317 -0400", hash_original_method = "123D49A321BB97EFA9843423F7545450", hash_generated_method = "13F5910E7278EB136720DC7036B171D3")
    private Object responseDataCallList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2032766775 = null; //Variable for return #1
        ArrayList<DataCallState> response;
        int ver;
        ver = p.readInt();
        int num;
        num = p.readInt();
        riljLog("responseDataCallList ver=" + ver + " num=" + num);
        response = new ArrayList<DataCallState>(num);
        {
            int i;
            i = 0;
            {
                response.add(getDataCallState(p, ver));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2032766775 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2032766775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2032766775;
        // ---------- Original Method ----------
        //ArrayList<DataCallState> response;
        //int ver = p.readInt();
        //int num = p.readInt();
        //riljLog("responseDataCallList ver=" + ver + " num=" + num);
        //response = new ArrayList<DataCallState>(num);
        //for (int i = 0; i < num; i++) {
            //response.add(getDataCallState(p, ver));
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.328 -0400", hash_original_method = "6E11D362E553C380CF6ADBFD5304CD05", hash_generated_method = "ECFCE57FE5902E0FC2E31322976A1FEA")
    private Object responseSetupDataCall(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_873897314 = null; //Variable for return #1
        int ver;
        ver = p.readInt();
        int num;
        num = p.readInt();
        riljLog("responseSetupDataCall ver=" + ver + " num=" + num);
        DataCallState dataCall;
        {
            dataCall = new DataCallState();
            dataCall.version = ver;
            dataCall.cid = Integer.parseInt(p.readString());
            dataCall.ifname = p.readString();
            {
                boolean varFCAE9407C997419D11FB63DAA27B5891_749786393 = (TextUtils.isEmpty(dataCall.ifname));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response, no ifname");
                } //End block
            } //End collapsed parenthetic
            String addresses;
            addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_63971887 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } //End block
            } //End collapsed parenthetic
            {
                String dnses;
                dnses = p.readString();
                riljLog("responseSetupDataCall got dnses=" + dnses);
                {
                    boolean varA216814F255A7125BD1D54E6A9B9165D_1357465745 = (!TextUtils.isEmpty(dnses));
                    {
                        dataCall.dnses = dnses.split(" ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                String gateways;
                gateways = p.readString();
                riljLog("responseSetupDataCall got gateways=" + gateways);
                {
                    boolean var851B476C40C2CFC5CF415FF73D1F92EC_479502815 = (!TextUtils.isEmpty(gateways));
                    {
                        dataCall.gateways = gateways.split(" ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response expecting 1 RIL_Data_Call_response_v5"
                        + " got " + num);
            } //End block
            dataCall = getDataCallState(p, ver);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_873897314 = dataCall;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_873897314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873897314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.338 -0400", hash_original_method = "F2D5C4032BE6024B6126759412E50A01", hash_generated_method = "7CCB0A16753AC5FF7F3FC9AA159950A4")
    private Object responseOperatorInfos(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_923646973 = null; //Variable for return #1
        String strings[];
        strings = (String [])responseStrings(p);
        ArrayList<OperatorInfo> ret;
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got "
                + strings.length + " strings, expected multible of 4");
        } //End block
        ret = new ArrayList<OperatorInfo>(strings.length / 4);
        {
            int i;
            i = 0;
            i += 4;
            {
                ret.add (
                new OperatorInfo(
                    strings[i+0],
                    strings[i+1],
                    strings[i+2],
                    strings[i+3]));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_923646973 = ret;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_923646973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_923646973;
        // ---------- Original Method ----------
        //String strings[] = (String [])responseStrings(p);
        //ArrayList<OperatorInfo> ret;
        //if (strings.length % 4 != 0) {
            //throw new RuntimeException(
                //"RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got "
                //+ strings.length + " strings, expected multible of 4");
        //}
        //ret = new ArrayList<OperatorInfo>(strings.length / 4);
        //for (int i = 0 ; i < strings.length ; i += 4) {
            //ret.add (
                //new OperatorInfo(
                    //strings[i+0],
                    //strings[i+1],
                    //strings[i+2],
                    //strings[i+3]));
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.340 -0400", hash_original_method = "E4123D5DA30749CB6D4FFE47F8C7BEAC", hash_generated_method = "6D1819DE548237A3691620BDC6F5BA6C")
    private Object responseCellList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_545200308 = null; //Variable for return #1
        int num, rssi;
        String location;
        ArrayList<NeighboringCellInfo> response;
        NeighboringCellInfo cell;
        num = p.readInt();
        response = new ArrayList<NeighboringCellInfo>();
        String radioString;
        radioString = SystemProperties.get(
               TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE, "unknown");
        int radioType;
        {
            boolean var968A11328ED5DD3D9A4D0157DF90DD59_1745103451 = (radioString.equals("GPRS"));
            {
                radioType = NETWORK_TYPE_GPRS;
            } //End block
            {
                boolean varA1A3CAAABF34B78222EF834ECB712EBE_1540007587 = (radioString.equals("EDGE"));
                {
                    radioType = NETWORK_TYPE_EDGE;
                } //End block
                {
                    boolean var281246F88355BADDC459CFA9135E481F_460031220 = (radioString.equals("UMTS"));
                    {
                        radioType = NETWORK_TYPE_UMTS;
                    } //End block
                    {
                        boolean var3EAFEEE374799CED3C653463F8D1F789_2023594278 = (radioString.equals("HSDPA"));
                        {
                            radioType = NETWORK_TYPE_HSDPA;
                        } //End block
                        {
                            boolean varA89604559FBE3A92D87A3C7FCC5B22A2_112062162 = (radioString.equals("HSUPA"));
                            {
                                radioType = NETWORK_TYPE_HSUPA;
                            } //End block
                            {
                                boolean varA181BEC579269E2127B9ABCD5D79305A_986735142 = (radioString.equals("HSPA"));
                                {
                                    radioType = NETWORK_TYPE_HSPA;
                                } //End block
                                {
                                    radioType = NETWORK_TYPE_UNKNOWN;
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            {
                int i;
                i = 0;
                {
                    rssi = p.readInt();
                    location = p.readString();
                    cell = new NeighboringCellInfo(rssi, location, radioType);
                    response.add(cell);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_545200308 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_545200308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_545200308;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.341 -0400", hash_original_method = "225C4A262B1740AD55FF47639121D5EF", hash_generated_method = "F373EF0DD5A98122B967308B7A3E770E")
    private Object responseGetPreferredNetworkType(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_513187681 = null; //Variable for return #1
        int [] response;
        response = (int[]) responseInts(p);
        {
            mPreferredNetworkType = response[0];
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_513187681 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_513187681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_513187681;
        // ---------- Original Method ----------
        //int [] response = (int[]) responseInts(p);
        //if (response.length >= 1) {
           //mPreferredNetworkType = response[0];
       //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.342 -0400", hash_original_method = "C459166A8880B065FE8A1B083AFDAF89", hash_generated_method = "9FC6858A09FADBAE4E410415FD06F9D5")
    private Object responseGmsBroadcastConfig(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_345465538 = null; //Variable for return #1
        int num;
        ArrayList<SmsBroadcastConfigInfo> response;
        SmsBroadcastConfigInfo info;
        num = p.readInt();
        response = new ArrayList<SmsBroadcastConfigInfo>(num);
        {
            int i;
            i = 0;
            {
                int fromId;
                fromId = p.readInt();
                int toId;
                toId = p.readInt();
                int fromScheme;
                fromScheme = p.readInt();
                int toScheme;
                toScheme = p.readInt();
                boolean selected;
                selected = (p.readInt() == 1);
                info = new SmsBroadcastConfigInfo(fromId, toId, fromScheme,
                    toScheme, selected);
                response.add(info);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_345465538 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_345465538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345465538;
        // ---------- Original Method ----------
        //int num;
        //ArrayList<SmsBroadcastConfigInfo> response;
        //SmsBroadcastConfigInfo info;
        //num = p.readInt();
        //response = new ArrayList<SmsBroadcastConfigInfo>(num);
        //for (int i = 0; i < num; i++) {
            //int fromId = p.readInt();
            //int toId = p.readInt();
            //int fromScheme = p.readInt();
            //int toScheme = p.readInt();
            //boolean selected = (p.readInt() == 1);
            //info = new SmsBroadcastConfigInfo(fromId, toId, fromScheme,
                    //toScheme, selected);
            //response.add(info);
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.359 -0400", hash_original_method = "55259F8FDA4B0C41A34B6184E02D7C2F", hash_generated_method = "197386EF6061714AF4F5D0075A307EDC")
    private Object responseCdmaBroadcastConfig(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1566447290 = null; //Variable for return #1
        int numServiceCategories;
        int response[];
        numServiceCategories = p.readInt();
        {
            int numInts;
            numInts = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES * CDMA_BSI_NO_OF_INTS_STRUCT + 1;
            response = new int[numInts];
            response[0] = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES;
            {
                int i;
                i = 1;
                i += CDMA_BSI_NO_OF_INTS_STRUCT;
                {
                    response[i + 0] = i / CDMA_BSI_NO_OF_INTS_STRUCT;
                    response[i + 1] = 1;
                    response[i + 2] = 0;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int numInts;
            numInts = (numServiceCategories * CDMA_BSI_NO_OF_INTS_STRUCT) + 1;
            response = new int[numInts];
            response[0] = numServiceCategories;
            {
                int i;
                i = 1;
                {
                    response[i] = p.readInt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1566447290 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1566447290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566447290;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.365 -0400", hash_original_method = "90CED6467BA07D7B46A1F95705E3AC70", hash_generated_method = "810326CD022D3865FD3DE0D10E4CB73B")
    private Object responseSignalStrength(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1540019986 = null; //Variable for return #1
        int numInts;
        numInts = 12;
        int response[];
        response = new int[numInts];
        {
            int i;
            i = 0;
            {
                response[i] = p.readInt();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1540019986 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1540019986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1540019986;
        // ---------- Original Method ----------
        //int numInts = 12;
        //int response[];
        //response = new int[numInts];
        //for (int i = 0 ; i < numInts ; i++) {
            //response[i] = p.readInt();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.453 -0400", hash_original_method = "07F57EA5026D76F851755C6714CD7CB2", hash_generated_method = "288CC724ECD589FD43C5EBA97ADD298F")
    private ArrayList<CdmaInformationRecords> responseCdmaInformationRecord(Parcel p) {
        ArrayList<CdmaInformationRecords> varB4EAC82CA7396A68D541C85D26508E83_506921814 = null; //Variable for return #1
        int numberOfInfoRecs;
        ArrayList<CdmaInformationRecords> response;
        numberOfInfoRecs = p.readInt();
        response = new ArrayList<CdmaInformationRecords>(numberOfInfoRecs);
        {
            int i;
            i = 0;
            {
                CdmaInformationRecords InfoRec;
                InfoRec = new CdmaInformationRecords(p);
                response.add(InfoRec);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_506921814 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_506921814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_506921814;
        // ---------- Original Method ----------
        //int numberOfInfoRecs;
        //ArrayList<CdmaInformationRecords> response;
        //numberOfInfoRecs = p.readInt();
        //response = new ArrayList<CdmaInformationRecords>(numberOfInfoRecs);
        //for (int i = 0; i < numberOfInfoRecs; i++) {
            //CdmaInformationRecords InfoRec = new CdmaInformationRecords(p);
            //response.add(InfoRec);
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.454 -0400", hash_original_method = "C7CB5D07451D489A78BF82365C5A0B27", hash_generated_method = "5F199726C523CBC70F0BD11F4D5E7ABE")
    private Object responseCdmaCallWaiting(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2092557440 = null; //Variable for return #1
        CdmaCallWaitingNotification notification;
        notification = new CdmaCallWaitingNotification();
        notification.number = p.readString();
        notification.numberPresentation = notification.presentationFromCLIP(p.readInt());
        notification.name = p.readString();
        notification.namePresentation = notification.numberPresentation;
        notification.isPresent = p.readInt();
        notification.signalType = p.readInt();
        notification.alertPitch = p.readInt();
        notification.signal = p.readInt();
        notification.numberType = p.readInt();
        notification.numberPlan = p.readInt();
        varB4EAC82CA7396A68D541C85D26508E83_2092557440 = notification;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2092557440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2092557440;
        // ---------- Original Method ----------
        //CdmaCallWaitingNotification notification = new CdmaCallWaitingNotification();
        //notification.number = p.readString();
        //notification.numberPresentation = notification.presentationFromCLIP(p.readInt());
        //notification.name = p.readString();
        //notification.namePresentation = notification.numberPresentation;
        //notification.isPresent = p.readInt();
        //notification.signalType = p.readInt();
        //notification.alertPitch = p.readInt();
        //notification.signal = p.readInt();
        //notification.numberType = p.readInt();
        //notification.numberPlan = p.readInt();
        //return notification;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.458 -0400", hash_original_method = "F4EF6B3A014077C64691F0B8D26D4AED", hash_generated_method = "ED64C0B04F6666B942E8D939369D99D0")
    private Object responseCallRing(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1601679125 = null; //Variable for return #1
        char response[];
        response = new char[4];
        response[0] = (char) p.readInt();
        response[1] = (char) p.readInt();
        response[2] = (char) p.readInt();
        response[3] = (char) p.readInt();
        varB4EAC82CA7396A68D541C85D26508E83_1601679125 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1601679125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1601679125;
        // ---------- Original Method ----------
        //char response[] = new char[4];
        //response[0] = (char) p.readInt();
        //response[1] = (char) p.readInt();
        //response[2] = (char) p.readInt();
        //response[3] = (char) p.readInt();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.460 -0400", hash_original_method = "04666C2E99832FCFAFCF388A68EF0610", hash_generated_method = "A08297D7D286C6BA2A7AD819C0F3E4B9")
    private void notifyRegistrantsCdmaInfoRec(CdmaInformationRecords infoRec) {
        int response;
        response = RIL_UNSOL_CDMA_INFO_REC;
        {
            {
                unsljLogRet(response, infoRec.record);
                mDisplayInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mSignalInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mNumberInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mRedirNumInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mLineControlInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mT53ClirInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        {
            {
                unsljLogRet(response, infoRec.record);
                mT53AudCntrlInfoRegistrants.notifyRegistrants(
                       new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        addTaint(infoRec.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static String requestToString(int request) {
        switch(request) {
            case RIL_REQUEST_GET_SIM_STATUS: return "GET_SIM_STATUS";
            case RIL_REQUEST_ENTER_SIM_PIN: return "ENTER_SIM_PIN";
            case RIL_REQUEST_ENTER_SIM_PUK: return "ENTER_SIM_PUK";
            case RIL_REQUEST_ENTER_SIM_PIN2: return "ENTER_SIM_PIN2";
            case RIL_REQUEST_ENTER_SIM_PUK2: return "ENTER_SIM_PUK2";
            case RIL_REQUEST_CHANGE_SIM_PIN: return "CHANGE_SIM_PIN";
            case RIL_REQUEST_CHANGE_SIM_PIN2: return "CHANGE_SIM_PIN2";
            case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION: return "ENTER_NETWORK_DEPERSONALIZATION";
            case RIL_REQUEST_GET_CURRENT_CALLS: return "GET_CURRENT_CALLS";
            case RIL_REQUEST_DIAL: return "DIAL";
            case RIL_REQUEST_GET_IMSI: return "GET_IMSI";
            case RIL_REQUEST_HANGUP: return "HANGUP";
            case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND: return "HANGUP_WAITING_OR_BACKGROUND";
            case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND: return "HANGUP_FOREGROUND_RESUME_BACKGROUND";
            case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE: return "REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE";
            case RIL_REQUEST_CONFERENCE: return "CONFERENCE";
            case RIL_REQUEST_UDUB: return "UDUB";
            case RIL_REQUEST_LAST_CALL_FAIL_CAUSE: return "LAST_CALL_FAIL_CAUSE";
            case RIL_REQUEST_SIGNAL_STRENGTH: return "SIGNAL_STRENGTH";
            case RIL_REQUEST_VOICE_REGISTRATION_STATE: return "VOICE_REGISTRATION_STATE";
            case RIL_REQUEST_DATA_REGISTRATION_STATE: return "DATA_REGISTRATION_STATE";
            case RIL_REQUEST_OPERATOR: return "OPERATOR";
            case RIL_REQUEST_RADIO_POWER: return "RADIO_POWER";
            case RIL_REQUEST_DTMF: return "DTMF";
            case RIL_REQUEST_SEND_SMS: return "SEND_SMS";
            case RIL_REQUEST_SEND_SMS_EXPECT_MORE: return "SEND_SMS_EXPECT_MORE";
            case RIL_REQUEST_SETUP_DATA_CALL: return "SETUP_DATA_CALL";
            case RIL_REQUEST_SIM_IO: return "SIM_IO";
            case RIL_REQUEST_SEND_USSD: return "SEND_USSD";
            case RIL_REQUEST_CANCEL_USSD: return "CANCEL_USSD";
            case RIL_REQUEST_GET_CLIR: return "GET_CLIR";
            case RIL_REQUEST_SET_CLIR: return "SET_CLIR";
            case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS: return "QUERY_CALL_FORWARD_STATUS";
            case RIL_REQUEST_SET_CALL_FORWARD: return "SET_CALL_FORWARD";
            case RIL_REQUEST_QUERY_CALL_WAITING: return "QUERY_CALL_WAITING";
            case RIL_REQUEST_SET_CALL_WAITING: return "SET_CALL_WAITING";
            case RIL_REQUEST_SMS_ACKNOWLEDGE: return "SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GET_IMEI: return "GET_IMEI";
            case RIL_REQUEST_GET_IMEISV: return "GET_IMEISV";
            case RIL_REQUEST_ANSWER: return "ANSWER";
            case RIL_REQUEST_DEACTIVATE_DATA_CALL: return "DEACTIVATE_DATA_CALL";
            case RIL_REQUEST_QUERY_FACILITY_LOCK: return "QUERY_FACILITY_LOCK";
            case RIL_REQUEST_SET_FACILITY_LOCK: return "SET_FACILITY_LOCK";
            case RIL_REQUEST_CHANGE_BARRING_PASSWORD: return "CHANGE_BARRING_PASSWORD";
            case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE: return "QUERY_NETWORK_SELECTION_MODE";
            case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC: return "SET_NETWORK_SELECTION_AUTOMATIC";
            case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL: return "SET_NETWORK_SELECTION_MANUAL";
            case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS : return "QUERY_AVAILABLE_NETWORKS ";
            case RIL_REQUEST_DTMF_START: return "DTMF_START";
            case RIL_REQUEST_DTMF_STOP: return "DTMF_STOP";
            case RIL_REQUEST_BASEBAND_VERSION: return "BASEBAND_VERSION";
            case RIL_REQUEST_SEPARATE_CONNECTION: return "SEPARATE_CONNECTION";
            case RIL_REQUEST_SET_MUTE: return "SET_MUTE";
            case RIL_REQUEST_GET_MUTE: return "GET_MUTE";
            case RIL_REQUEST_QUERY_CLIP: return "QUERY_CLIP";
            case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE: return "LAST_DATA_CALL_FAIL_CAUSE";
            case RIL_REQUEST_DATA_CALL_LIST: return "DATA_CALL_LIST";
            case RIL_REQUEST_RESET_RADIO: return "RESET_RADIO";
            case RIL_REQUEST_OEM_HOOK_RAW: return "OEM_HOOK_RAW";
            case RIL_REQUEST_OEM_HOOK_STRINGS: return "OEM_HOOK_STRINGS";
            case RIL_REQUEST_SCREEN_STATE: return "SCREEN_STATE";
            case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION: return "SET_SUPP_SVC_NOTIFICATION";
            case RIL_REQUEST_WRITE_SMS_TO_SIM: return "WRITE_SMS_TO_SIM";
            case RIL_REQUEST_DELETE_SMS_ON_SIM: return "DELETE_SMS_ON_SIM";
            case RIL_REQUEST_SET_BAND_MODE: return "SET_BAND_MODE";
            case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE: return "QUERY_AVAILABLE_BAND_MODE";
            case RIL_REQUEST_STK_GET_PROFILE: return "REQUEST_STK_GET_PROFILE";
            case RIL_REQUEST_STK_SET_PROFILE: return "REQUEST_STK_SET_PROFILE";
            case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND: return "REQUEST_STK_SEND_ENVELOPE_COMMAND";
            case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE: return "REQUEST_STK_SEND_TERMINAL_RESPONSE";
            case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM: return "REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM";
            case RIL_REQUEST_EXPLICIT_CALL_TRANSFER: return "REQUEST_EXPLICIT_CALL_TRANSFER";
            case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE: return "REQUEST_SET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE: return "REQUEST_GET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS: return "REQUEST_GET_NEIGHBORING_CELL_IDS";
            case RIL_REQUEST_SET_LOCATION_UPDATES: return "REQUEST_SET_LOCATION_UPDATES";
            case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE: return "RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE: return "RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE";
            case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE: return "RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE";
            case RIL_REQUEST_SET_TTY_MODE: return "RIL_REQUEST_SET_TTY_MODE";
            case RIL_REQUEST_QUERY_TTY_MODE: return "RIL_REQUEST_QUERY_TTY_MODE";
            case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE: return "RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE: return "RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_FLASH: return "RIL_REQUEST_CDMA_FLASH";
            case RIL_REQUEST_CDMA_BURST_DTMF: return "RIL_REQUEST_CDMA_BURST_DTMF";
            case RIL_REQUEST_CDMA_SEND_SMS: return "RIL_REQUEST_CDMA_SEND_SMS";
            case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE: return "RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG: return "RIL_REQUEST_GSM_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG: return "RIL_REQUEST_GSM_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG: return "RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG: return "RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_BROADCAST_ACTIVATION: return "RIL_REQUEST_GSM_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY: return "RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY";
            case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION: return "RIL_REQUEST_CDMA_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_SUBSCRIPTION: return "RIL_REQUEST_CDMA_SUBSCRIPTION";
            case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM: return "RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM";
            case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM: return "RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM";
            case RIL_REQUEST_DEVICE_IDENTITY: return "RIL_REQUEST_DEVICE_IDENTITY";
            case RIL_REQUEST_GET_SMSC_ADDRESS: return "RIL_REQUEST_GET_SMSC_ADDRESS";
            case RIL_REQUEST_SET_SMSC_ADDRESS: return "RIL_REQUEST_SET_SMSC_ADDRESS";
            case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE: return "REQUEST_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS: return "RIL_REQUEST_REPORT_SMS_MEMORY_STATUS";
            case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING: return "RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING";
            case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE: return "RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_ISIM_AUTHENTICATION: return "RIL_REQUEST_ISIM_AUTHENTICATION";
            case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU: return "RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU";
            case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS: return "RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS";
            default: return "<unknown request>";
        }
    }

    
        static String responseToString(int request) {
        switch(request) {
            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED: return "UNSOL_RESPONSE_RADIO_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED: return "UNSOL_RESPONSE_CALL_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED: return "UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_NEW_SMS: return "UNSOL_RESPONSE_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT: return "UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT";
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM: return "UNSOL_RESPONSE_NEW_SMS_ON_SIM";
            case RIL_UNSOL_ON_USSD: return "UNSOL_ON_USSD";
            case RIL_UNSOL_ON_USSD_REQUEST: return "UNSOL_ON_USSD_REQUEST";
            case RIL_UNSOL_NITZ_TIME_RECEIVED: return "UNSOL_NITZ_TIME_RECEIVED";
            case RIL_UNSOL_SIGNAL_STRENGTH: return "UNSOL_SIGNAL_STRENGTH";
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED: return "UNSOL_DATA_CALL_LIST_CHANGED";
            case RIL_UNSOL_SUPP_SVC_NOTIFICATION: return "UNSOL_SUPP_SVC_NOTIFICATION";
            case RIL_UNSOL_STK_SESSION_END: return "UNSOL_STK_SESSION_END";
            case RIL_UNSOL_STK_PROACTIVE_COMMAND: return "UNSOL_STK_PROACTIVE_COMMAND";
            case RIL_UNSOL_STK_EVENT_NOTIFY: return "UNSOL_STK_EVENT_NOTIFY";
            case RIL_UNSOL_STK_CALL_SETUP: return "UNSOL_STK_CALL_SETUP";
            case RIL_UNSOL_SIM_SMS_STORAGE_FULL: return "UNSOL_SIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_SIM_REFRESH: return "UNSOL_SIM_REFRESH";
            case RIL_UNSOL_CALL_RING: return "UNSOL_CALL_RING";
            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED: return "UNSOL_RESPONSE_SIM_STATUS_CHANGED";
            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS: return "UNSOL_RESPONSE_CDMA_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS: return "UNSOL_RESPONSE_NEW_BROADCAST_SMS";
            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL: return "UNSOL_CDMA_RUIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_RESTRICTED_STATE_CHANGED: return "UNSOL_RESTRICTED_STATE_CHANGED";
            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE: return "UNSOL_ENTER_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_CDMA_CALL_WAITING: return "UNSOL_CDMA_CALL_WAITING";
            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS: return "UNSOL_CDMA_OTA_PROVISION_STATUS";
            case RIL_UNSOL_CDMA_INFO_REC: return "UNSOL_CDMA_INFO_REC";
            case RIL_UNSOL_OEM_HOOK_RAW: return "UNSOL_OEM_HOOK_RAW";
            case RIL_UNSOL_RINGBACK_TONE: return "UNSOL_RINGBACK_TONG";
            case RIL_UNSOL_RESEND_INCALL_MUTE: return "UNSOL_RESEND_INCALL_MUTE";
            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED: return "CDMA_SUBSCRIPTION_SOURCE_CHANGED";
            case RIL_UNSOl_CDMA_PRL_CHANGED: return "UNSOL_CDMA_PRL_CHANGED";
            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE: return "UNSOL_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_RIL_CONNECTED: return "UNSOL_RIL_CONNECTED";
            default: return "<unknown reponse>";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.461 -0400", hash_original_method = "513B160CE13530A75C92D2BB2C156FD7", hash_generated_method = "1DBAD6D542F25A57B4009829649F29CE")
    private void riljLog(String msg) {
        Log.d(LOG_TAG, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.462 -0400", hash_original_method = "709360DE622013B25C1B037A3416C3B6", hash_generated_method = "A6A9E98C2BCD8F608F27D186F899DF39")
    private void riljLogv(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.v(LOG_TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.462 -0400", hash_original_method = "2B7AB7C6A9DFCD91149097CF23FA21DF", hash_generated_method = "B52B409C42158CA261942C6F070B75C4")
    private void unsljLog(int response) {
        riljLog("[UNSL]< " + responseToString(response));
        addTaint(response);
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.462 -0400", hash_original_method = "B9D4DA0AB06082664757422C0E23F4B2", hash_generated_method = "C635E6F7126FC1A69EEAA186FAE030B4")
    private void unsljLogMore(int response, String more) {
        riljLog("[UNSL]< " + responseToString(response) + " " + more);
        addTaint(response);
        addTaint(more.getTaint());
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response) + " " + more);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.462 -0400", hash_original_method = "02F7DA800ECB6E455062B2AF08D2856E", hash_generated_method = "F4EBD85BD05DB5C70A5F9939E8399949")
    private void unsljLogRet(int response, Object ret) {
        riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        addTaint(response);
        addTaint(ret.getTaint());
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.463 -0400", hash_original_method = "5479F9B9AF9D3C3FE7229BC789506755", hash_generated_method = "DD2481D70785482CAFBAC150AD419EF5")
    private void unsljLogvRet(int response, Object ret) {
        riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        addTaint(response);
        addTaint(ret.getTaint());
        // ---------- Original Method ----------
        //riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.465 -0400", hash_original_method = "B8DB86D0D3DD2A6C87C6DBBEA17396A3", hash_generated_method = "DA91515E0197E01450D7BD50EF19C959")
    public void getDeviceIdentity(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.466 -0400", hash_original_method = "2F4B55F10DAACCDACB48694F0AD6C5FC", hash_generated_method = "F593BF68DCF2C6F7424566CC68169DC7")
    public void getCDMASubscription(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.479 -0400", hash_original_method = "CD84ED40ADC2BEFF960D6D373762CCB2", hash_generated_method = "F64182D4D087BC588BF19867130D35E1")
    @Override
    public void setPhoneType(int phoneType) {
        riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        mPhoneType = phoneType;
        addTaint(phoneType);
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        //mPhoneType = phoneType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.479 -0400", hash_original_method = "849E6CD9CCE8F1ECF8BC959270B499A0", hash_generated_method = "8917C6950AA198A202A5D146451DDE66")
    public void queryCdmaRoamingPreference(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.480 -0400", hash_original_method = "BC2979EAC0CBA90D634290B385917086", hash_generated_method = "A267A63F595AA3D3FE66B3D8656FDBE9")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaRoamingType);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaRoamingType);
        send(rr);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(cdmaRoamingType);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + cdmaRoamingType);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.480 -0400", hash_original_method = "5B737D91D0E47D0010D2976568B23A82", hash_generated_method = "1667F348EEB4A928F6BEC7CA7ABC7855")
    public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaSubscription);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaSubscription);
        send(rr);
        addTaint(cdmaSubscription);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(cdmaSubscription);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + cdmaSubscription);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.482 -0400", hash_original_method = "5EEECA9C4DAFB6EB7CE2420CACC9812C", hash_generated_method = "C39FBC0263CDC36CBC5DCFFF7E9EBF64")
    @Override
    public void getCdmaSubscriptionSource(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.484 -0400", hash_original_method = "116710C0DB0DC531DE694B6BC2F4AE2B", hash_generated_method = "12F1AA942D1314EE97832B70C6EBA984")
    public void queryTTYMode(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.485 -0400", hash_original_method = "0B5DA23B67CE8A881960D39226001892", hash_generated_method = "C23D941E8BCC057ABB23E6A23D80D23C")
    public void setTTYMode(int ttyMode, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_TTY_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(ttyMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + ttyMode);
        send(rr);
        addTaint(ttyMode);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_SET_TTY_MODE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(ttyMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + ttyMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.485 -0400", hash_original_method = "9DB0667959C6184F19426DF0FB910315", hash_generated_method = "3B5A9CB04DEE0A2C10DEFC84E65229B1")
    public void sendCDMAFeatureCode(String FeatureCode, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);
        rr.mp.writeString(FeatureCode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + FeatureCode);
        send(rr);
        addTaint(FeatureCode.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);
        //rr.mp.writeString(FeatureCode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + FeatureCode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.485 -0400", hash_original_method = "EB6E132144573DF781138A585850ED0A", hash_generated_method = "23CEE1ACB24F2009E2688B19A74B0A4C")
    public void getCdmaBroadcastConfig(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.497 -0400", hash_original_method = "7AE57418607D61F0BA79FD2FF4F728AF", hash_generated_method = "CA98FF9C749B927C2A30336E794641B6")
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);
        {
            int i;
            i = 0;
            {
                rr.mp.writeInt(configValuesArray[i]);
            } //End block
        } //End collapsed parenthetic
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);
        //for(int i = 0; i < configValuesArray.length; i++) {
            //rr.mp.writeInt(configValuesArray[i]);
        //}
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.498 -0400", hash_original_method = "41C22C7BD9DE14E15F4803649E353969", hash_generated_method = "A06DBAE166A31BD3EBC2643F7D2269A8")
    public void setCdmaBroadcastActivation(boolean activate, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 :1);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(activate ? 0 :1);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.498 -0400", hash_original_method = "82BAE0E7FF72D1A409D61F03DD8EFEA2", hash_generated_method = "03697BD09191FFFE883F19E1B437C773")
    public void exitEmergencyCallbackMode(Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.499 -0400", hash_original_method = "381EF137384490D69DA50E927DA4C209", hash_generated_method = "93C9AB4F7A7EB3EA61F048EF1C556CBC")
    public void requestIsimAuthentication(String nonce, Message response) {
        RILRequest rr;
        rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);
        rr.mp.writeString(nonce);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(nonce.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);
        //rr.mp.writeString(nonce);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    class RILSender extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.499 -0400", hash_original_field = "99EC5806475395530F37CCDC6DD85CE7", hash_generated_field = "D1362109E83ED4221773106790FD549F")

        byte[] dataLength = new byte[4];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.515 -0400", hash_original_method = "4D17817439BCC34837C575257CF9147F", hash_generated_method = "29FB6336B11BB21F807AB588DD6B15C1")
        public  RILSender(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.516 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.520 -0400", hash_original_method = "D25DB5A43D9B976C2A2C198EC34CFB08", hash_generated_method = "AFB511713F137000E4E6D0790FCE422F")
        @Override
        public void handleMessage(Message msg) {
            RILRequest rr;
            rr = (RILRequest)(msg.obj);
            RILRequest req;
            req = null;
            //Begin case EVENT_SEND 
            boolean alreadySubtracted;
            alreadySubtracted = false;
            //End case EVENT_SEND 
            //Begin case EVENT_SEND 
            try 
            {
                LocalSocket s;
                s = mSocket;
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
                    alreadySubtracted = true;
                } //End block
                {
                    mRequestsList.add(rr);
                } //End block
                alreadySubtracted = true;
                byte[] data;
                data = rr.mp.marshall();
                rr.mp.recycle();
                rr.mp = null;
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                    "Parcel larger than max bytes allowed! "
                                                          + data.length);
                } //End block
                dataLength[0] = dataLength[1] = 0;
                dataLength[2] = (byte)((data.length >> 8) & 0xff);
                dataLength[3] = (byte)((data.length) & 0xff);
                s.getOutputStream().write(dataLength);
                s.getOutputStream().write(data);
            } //End block
            catch (IOException ex)
            {
                req = findAndRemoveRequestFromList(rr.mSerial);
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
                } //End block
            } //End block
            catch (RuntimeException exc)
            {
                req = findAndRemoveRequestFromList(rr.mSerial);
                {
                    rr.onError(GENERIC_FAILURE, null);
                    rr.release();
                } //End block
            } //End block
            finally 
            {
                releaseWakeLockIfDone();
            } //End block
            //End case EVENT_SEND 
            //Begin case EVENT_WAKE_LOCK_TIMEOUT 
            {
                {
                    boolean var9A4CAC6617AE0A733634FB069C49B2EA_961359379 = (mWakeLock.isHeld());
                    {
                        {
                            Log.d(LOG_TAG, "NOTE: mReqWaiting is NOT 0 but"
                                        + mRequestMessagesWaiting + " at TIMEOUT, reset!"
                                        + " There still msg waitng for response");
                            mRequestMessagesWaiting = 0;
                            {
                                {
                                    int count;
                                    count = mRequestsList.size();
                                    Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                                                " mRequestList=" + count);
                                    {
                                        int i;
                                        i = 0;
                                        {
                                            rr = mRequestsList.get(i);
                                            Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] "
                                                    + requestToString(rr.mRequest));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End block
                        {
                            mRequestMessagesPending = 0;
                        } //End block
                        mWakeLock.release();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case EVENT_WAKE_LOCK_TIMEOUT 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class RILReceiver implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.536 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

        byte[] buffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.537 -0400", hash_original_method = "AEB7D4EC0C0D3B29B57F76734A093487", hash_generated_method = "832D356F5AA3BF59D3700679E90409AE")
          RILReceiver() {
            buffer = new byte[RIL_MAX_COMMAND_BYTES];
            // ---------- Original Method ----------
            //buffer = new byte[RIL_MAX_COMMAND_BYTES];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_method = "3E25FFC0D00CEB4B0CF0C518A51DB777", hash_generated_method = "4DEEBD6C6C260383678C8A3641CF1D6D")
        public void run() {
            int retryCount;
            retryCount = 0;
            try 
            {
                {
                    LocalSocket s;
                    s = null;
                    LocalSocketAddress l;
                    try 
                    {
                        s = new LocalSocket();
                        l = new LocalSocketAddress(SOCKET_NAME_RIL,
                            LocalSocketAddress.Namespace.RESERVED);
                        s.connect(l);
                    } //End block
                    catch (IOException ex)
                    {
                        try 
                        {
                            {
                                s.close();
                            } //End block
                        } //End block
                        catch (IOException ex2)
                        { }
                        try 
                        {
                            Thread.sleep(SOCKET_OPEN_RETRY_MILLIS);
                        } //End block
                        catch (InterruptedException er)
                        { }
                    } //End block
                    retryCount = 0;
                    mSocket = s;
                    int length;
                    length = 0;
                    try 
                    {
                        InputStream is;
                        is = mSocket.getInputStream();
                        {
                            Parcel p;
                            length = readRilMessage(is, buffer);
                            p = Parcel.obtain();
                            p.unmarshall(buffer, 0, length);
                            p.setDataPosition(0);
                            processResponse(p);
                            p.recycle();
                        } //End block
                    } //End block
                    catch (java.io.IOException ex)
                    { }
                    catch (Throwable tr)
                    { }
                    setRadioState (RadioState.RADIO_UNAVAILABLE);
                    try 
                    {
                        mSocket.close();
                    } //End block
                    catch (IOException ex)
                    { }
                    mSocket = null;
                    RILRequest.resetSerial();
                    clearRequestsList(RADIO_NOT_AVAILABLE, false);
                } //End block
            } //End block
            catch (Throwable tr)
            { }
            notifyRegistrantsRilConnectionChanged(-1);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "DCD4DA7F13FEC5D49BF1C3CE354FB202")

    static String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "97BCE9C97BFBAA0A5C9DFC01C512C8DD", hash_generated_field = "125F61AC6BB29A4FB36D5D46913F79E0")

    static boolean RILJ_LOGD = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "F756B39DA24610C6F147A03CB86C32C2", hash_generated_field = "710617C4E5519CAA16CE39F79E7F3371")

    static boolean RILJ_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "6E111A082683CFC823505D73C04427F7", hash_generated_field = "F944748FAA2DF57333927A89C17E634D")

    private static int DEFAULT_WAKE_LOCK_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "08D692F77DFF6777C68397D86FEB9673", hash_generated_field = "73022A61A83F7165408B200492B7DD53")

    static int EVENT_SEND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "57F4D6DC61899A880DD9EEDBA4F80E99", hash_generated_field = "46034EEE283EE721C2B7B1E366FB3212")

    static int EVENT_WAKE_LOCK_TIMEOUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "02403D71B4446414F4F3E9A28C344489", hash_generated_field = "3532D1C7D1A6FE190B99050241ECBF6D")

    static int RIL_MAX_COMMAND_BYTES = (8 * 1024);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "0838500EAFB49E0F91ECEFAAF400CACC", hash_generated_field = "6F4A3159D5C02DEDBC162646D665C237")

    static int RESPONSE_SOLICITED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "8186BFE56666A15DDA7631C9969B8ECA", hash_generated_field = "E251B2D25969E20E216E66BC57C3A3A1")

    static int RESPONSE_UNSOLICITED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "631DB341385DA34F9C870222FFCB6E51", hash_generated_field = "98C197E1233BCC3ADC8EF60F0D1CA776")

    static String SOCKET_NAME_RIL = "rild";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "8743C5F3EB20F43B4A7B1384E1EE0BAB", hash_generated_field = "0C53C88B2803D8D6F8AA4060509AF463")

    static int SOCKET_OPEN_RETRY_MILLIS = 4 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "FFFA1391A6C60617637A5396E1A930EF", hash_generated_field = "79607DD51F5A30E708BAEC26CC293E02")

    private static int CDMA_BSI_NO_OF_INTS_STRUCT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.539 -0400", hash_original_field = "75B7020754749B8753BB0C8AD8761874", hash_generated_field = "D6376ADEBCEEB3D6E30EA8937D20414A")

    private static int CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES = 31;
}

