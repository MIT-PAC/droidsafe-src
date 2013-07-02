package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.291 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "2C995DC68A290AA0E91A0F8065297DF6")

    int mSerial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.291 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "6C368ED9CE82768FD0B5A0D34D844F82")

    int mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.291 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "275BCCDB24FCA985A62252086534EA41")

    Message mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.291 -0400", hash_original_field = "1F2DFA567DCF95833EDDF7AEC167FEC7", hash_generated_field = "EEF79C3D9374B5C2140B6DF15C81B0D3")

    Parcel mp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.291 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "64C9DCC5A15FF3A81952EE0FF77BF4DE")

    RILRequest mNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.292 -0400", hash_original_method = "9C4E8F6E2A10EF2C06F20638ED2CBC6D", hash_generated_method = "560681FC445F3861C142757487DA3B91")
    private  RILRequest() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.292 -0400", hash_original_method = "E7EE736E24A2BE53AC107C249FFB0880", hash_generated_method = "2CC4C29F04564704D254356C451809E3")
     void release() {
        {
            {
                this.mNext = sPool;
                sPool = this;
                mResult = null;
            } 
        } 
        
        
            
                
                
                
                
            
        
    }

    
    static void resetSerial() {
        synchronized(sSerialMonitor) {
            sNextSerial = 0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_method = "9C13ECBB4C9B57CD7FC06025C6091C8F", hash_generated_method = "299EA4BCB989C0C022E51DDB4256A05A")
     String serialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1025194864 = null; 
        StringBuilder sb = new StringBuilder(8);
        String sn;
        sn = Integer.toString(mSerial);
        sb.append('[');
        {
            int i = 0;
            int s = sn.length();
            {
                sb.append('0');
            } 
        } 
        sb.append(sn);
        sb.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1025194864 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1025194864.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1025194864;
        
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_method = "DAF6125A6A3BAA8EA4AAF17920DB80E6", hash_generated_method = "BA8A1D52078D3A6AF8F13F23255497FF")
     void onError(int error, Object ret) {
        
        CommandException ex;
        ex = CommandException.fromRilErrno(error);
        Log.d(LOG_TAG, serialString() + "< "
            + RIL.requestToString(mRequest)
            + " error: " + ex);
        {
            AsyncResult.forMessage(mResult, ret, ex);
            mResult.sendToTarget();
        } 
        {
            mp.recycle();
            mp = null;
        } 
        addTaint(error);
        addTaint(ret.getTaint());
        
        
        
        
            
            
        
            
            
        
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "5427C798EA4BCDD653BC3E19DA14EDA3", hash_generated_field = "4648C36C9B39D123F3C2DC203738A8FE")

    static int sNextSerial = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "0470E9F275C220FB347853BB1394F8E2", hash_generated_field = "A7E278FEB1EC2BFEA3ED505503B40F1D")

    static Object sSerialMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "8885194D9D2ADA6648AB65C43BA7A18A")

    private static Object sPoolSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "E6E7B1EE519E99449DC5CFD28949053E", hash_generated_field = "29AEB546B72810AE137F2724EB8AC46F")

    private static RILRequest sPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.293 -0400", hash_original_field = "F95B54369A4D6DB4C3ACF86CE99D31FA", hash_generated_field = "E10F8FF6B26141CA5E230C0B750B2798")

    private static final int MAX_POOL_SIZE = 4;
}

public final class RIL extends BaseCommands implements CommandsInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "6971E2A0D3E5B2508308ACDF0894CC71")

    LocalSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "D98DF8D8C44F237131E3131E7D96BB06", hash_generated_field = "447BDB484814847833708DAC5CD0741B")

    HandlerThread mSenderThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "96F4E0D75276B088A94548BBA71042AB", hash_generated_field = "F824B77C4D08BC410F85653F55DB5D17")

    RILSender mSender;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "C42E57035DC58A8EF93627DAE705E4EB", hash_generated_field = "4C5A8172CA27A059D229944DFD840114")

    Thread mReceiverThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "B718778FEA0061AFBE714CC16C50488E")

    RILReceiver mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "C3E41FC6371E803E2DA98F1EFF9EF47B", hash_generated_field = "102A8E8B4FA31B396B477F22D2A32DA8")

    int mWakeLockTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "DFF633BBB29FA60E5096BC022C074C8C", hash_generated_field = "9200B1A2FDF04FDBA9EA6DB75F97F5C2")

    int mRequestMessagesPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "8792B45034366F06E89F0CF7947B7575", hash_generated_field = "2A0F03062FAF4047F837E853AF898D37")

    int mRequestMessagesWaiting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "57D356D53799C83A82E9E7DBBDB489EF", hash_generated_field = "A8E052F302542BDDE893942D71524913")

    ArrayList<RILRequest> mRequestsList = new ArrayList<RILRequest>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.294 -0400", hash_original_field = "7A74E6AA0A9A2FF1A7B6935083BAFD8F", hash_generated_field = "DD6FA850B0C2512C103BBC579CD52D51")

    Object mLastNITZTimeInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.295 -0400", hash_original_field = "BF2765A7DF728F4D51D697E315A27D1E", hash_generated_field = "0EB899EA628BF1BD4CA4D632F2A8D506")

    BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.295 -0400", hash_original_method = "2E7815AD99D182A9CFAEBA30A64F6122", hash_generated_method = "553AEA2DBD1EADB4B4CC318E4F64ACC6")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean var8C358EA74D49A7EAFB8AA331D6B03438_1781041244 = (intent.getAction().equals(Intent.ACTION_SCREEN_ON));
                {
                    sendScreenState(true);
                } 
                {
                    boolean varD09851821BF78B9C6FDD532B0303A63D_1430556920 = (intent.getAction().equals(Intent.ACTION_SCREEN_OFF));
                    {
                        sendScreenState(false);
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
            
                
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.295 -0400", hash_original_field = "D41C93A29A8110B1E773EFFE673A66AE", hash_generated_field = "517EE6BA92CA6D3C16C0F4FDDB025C17")

    private int mSetPreferredNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.296 -0400", hash_original_method = "57415555D3C32D9CF1C37CD62128114E", hash_generated_method = "4C0227578905013250F417AB9618AAD7")
    public  RIL(Context context, int preferredNetworkType, int cdmaSubscription) {
        super(context);
        {
            riljLog("RIL(context, preferredNetworkType=" + preferredNetworkType +
                    " cdmaSubscription=" + cdmaSubscription + ")");
        } 
        mCdmaSubscription  = cdmaSubscription;
        mPreferredNetworkType = preferredNetworkType;
        mPhoneType = RILConstants.NO_PHONE;
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        mWakeLock.setReferenceCounted(false);
        mWakeLockTimeout = SystemProperties.getInt(TelephonyProperties.PROPERTY_WAKE_LOCK_TIMEOUT,
                DEFAULT_WAKE_LOCK_TIMEOUT);
        mRequestMessagesPending = 0;
        mRequestMessagesWaiting = 0;
        mSenderThread = new HandlerThread("RILSender");
        mSenderThread.start();
        Looper looper = mSenderThread.getLooper();
        mSender = new RILSender(looper);
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        {
            boolean varD774D9E55CA6214CD6B06FC22CB353B1_404009525 = (cm.isNetworkSupported(ConnectivityManager.TYPE_MOBILE) == false);
            {
                riljLog("Not starting RILReceiver: wifi-only");
            } 
            {
                riljLog("Starting RILReceiver");
                mReceiver = new RILReceiver();
                mReceiverThread = new Thread(mReceiver, "RILReceiver");
                mReceiverThread.start();
                IntentFilter filter = new IntentFilter();
                filter.addAction(Intent.ACTION_SCREEN_ON);
                filter.addAction(Intent.ACTION_SCREEN_OFF);
                context.registerReceiver(mIntentReceiver, filter);
            } 
        } 
        addTaint(context.getTaint());
        addTaint(preferredNetworkType);
        addTaint(cdmaSubscription);
        
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.297 -0400", hash_original_method = "9505EC70575F3F081B82639224A26C6E", hash_generated_method = "940003D104FF1257EFD98542EB753F31")
    @Override
    public void setOnNITZTime(Handler h, int what, Object obj) {
        super.setOnNITZTime(h, what, obj);
        {
            mNITZTimeRegistrant
                .notifyRegistrant(
                    new AsyncResult (null, mLastNITZTimeInfo, null));
            mLastNITZTimeInfo = null;
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
            
                
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.297 -0400", hash_original_method = "9A7EB00CD2404F3C288A75EFD9E4A220", hash_generated_method = "0239B8997C50E3DD6E0C48DCA5195208")
    public void getIccCardStatus(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.298 -0400", hash_original_method = "A64490CEA7617DBF7C16959DD443F320", hash_generated_method = "A9501B0CB452CD6FA43F5CADE57A70AD")
    @Override
    public void supplyIccPin(String pin, Message result) {
        supplyIccPinForApp(pin, null, result);
        addTaint(pin.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.298 -0400", hash_original_method = "292CEACE366769BDA48EB6300D49BD27", hash_generated_method = "D15AB9CFE2DE7C6C5F55EA5637D40BE3")
    @Override
    public void supplyIccPinForApp(String pin, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(pin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.298 -0400", hash_original_method = "EDD0A15F8BC2322B300440A8148B03FB", hash_generated_method = "7E7A5F044B35F70296B08EEAE8F6FB15")
    @Override
    public void supplyIccPuk(String puk, String newPin, Message result) {
        supplyIccPukForApp(puk, newPin, null, result);
        addTaint(puk.getTaint());
        addTaint(newPin.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.299 -0400", hash_original_method = "1780B25BC715F62B7E7B76DC76BDB7F8", hash_generated_method = "0057863631731EFDD5BA15C017D35216")
    @Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.299 -0400", hash_original_method = "8076AE95CA0491033B7A3B1FDB27A00D", hash_generated_method = "FA19620A646A653AD4AE427594790488")
    @Override
    public void supplyIccPin2(String pin, Message result) {
        supplyIccPin2ForApp(pin, null, result);
        addTaint(pin.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.299 -0400", hash_original_method = "2364DF46EB4F312709574B2C726226B0", hash_generated_method = "C62379503C61BB14A24EC6677508C2D5")
    @Override
    public void supplyIccPin2ForApp(String pin, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        addTaint(pin.getTaint());
        addTaint(aid.getTaint());
        addTaint(result.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.300 -0400", hash_original_method = "02C50C8BAA9C120A4383EA48E4CE9EF9", hash_generated_method = "1A8A7206940E08EF0994C99E9D32FEEB")
    @Override
    public void supplyIccPuk2(String puk2, String newPin2, Message result) {
        supplyIccPuk2ForApp(puk2, newPin2, null, result);
        addTaint(puk2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.300 -0400", hash_original_method = "16881D0ACCF987B6F55F1477C7A8AF2E", hash_generated_method = "23A858D46A91C4525B387B8FCBB5FBF4")
    @Override
    public void supplyIccPuk2ForApp(String puk, String newPin2, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.300 -0400", hash_original_method = "E5801ABF4ED976E8B47A9DC4E0EF9FFC", hash_generated_method = "84EF96C27669BE6422B503C6D28F5AC7")
    @Override
    public void changeIccPin(String oldPin, String newPin, Message result) {
        changeIccPinForApp(oldPin, newPin, null, result);
        addTaint(oldPin.getTaint());
        addTaint(newPin.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.301 -0400", hash_original_method = "FB6D60EEFAF19AC3A68522374AFE5A34", hash_generated_method = "352D562774159B96BE8657A056B03BFA")
    @Override
    public void changeIccPinForApp(String oldPin, String newPin, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.301 -0400", hash_original_method = "09C1A469DD89C445C72DC064DAF532C6", hash_generated_method = "71E2F019F26209C28C9204F410CC5420")
    @Override
    public void changeIccPin2(String oldPin2, String newPin2, Message result) {
        changeIccPin2ForApp(oldPin2, newPin2, null, result);
        addTaint(oldPin2.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.301 -0400", hash_original_method = "5CD184F5005892F6A2376DA12B8940E7", hash_generated_method = "A68F83BB583448442E84390135DC13F0")
    @Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aid, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.301 -0400", hash_original_method = "DCA3B69D42E061A95FB4470FAF19888E", hash_generated_method = "14F17403FDAE7277CCD4E43C1EA706E8")
    public void changeBarringPassword(String facility, String oldPwd, String newPwd, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);
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
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.302 -0400", hash_original_method = "FD9166E53C98E732567F842FC6265121", hash_generated_method = "FE9964DE30FB6259D062FAA5E0787166")
    public void supplyNetworkDepersonalization(String netpin, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(1);
        rr.mp.writeString(netpin);
        send(rr);
        addTaint(netpin.getTaint());
        addTaint(result.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.302 -0400", hash_original_method = "6F2937ACBD34EE8D8FEF57D35663AFCC", hash_generated_method = "8D2FFA13CD96FFA06147A12E6AC29F6E")
    public void getCurrentCalls(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.302 -0400", hash_original_method = "A1D311E0B227CABB8D0707A1650659D2", hash_generated_method = "9FB76FC67D6532AAD0E5E2AC48373D7A")
    @Deprecated
    public void getPDPContextList(Message result) {
        getDataCallList(result);
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.303 -0400", hash_original_method = "68CF653DB375A3C63D89D09DBB57244C", hash_generated_method = "93EA503E3D67C7C0A40C8556CF10A406")
    public void getDataCallList(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.303 -0400", hash_original_method = "85029AD0E77EFB7E7AAB9535BAB079D4", hash_generated_method = "17ACC58C4441A8020141361793F38400")
    public void dial(String address, int clirMode, Message result) {
        dial(address, clirMode, null, result);
        addTaint(address.getTaint());
        addTaint(clirMode);
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.303 -0400", hash_original_method = "2937351315DD22A0DBB0EBEECB6FBD52", hash_generated_method = "756686E97E7EF026EF69E36A62228186")
    public void dial(String address, int clirMode, UUSInfo uusInfo, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DIAL, result);
        rr.mp.writeString(address);
        rr.mp.writeInt(clirMode);
        rr.mp.writeInt(0);
        {
            rr.mp.writeInt(0);
        } 
        {
            rr.mp.writeInt(1);
            rr.mp.writeInt(uusInfo.getType());
            rr.mp.writeInt(uusInfo.getDcs());
            rr.mp.writeByteArray(uusInfo.getUserData());
        } 
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(address.getTaint());
        addTaint(clirMode);
        addTaint(uusInfo.getTaint());
        addTaint(result.getTaint());
        
        
        
        
        
        
            
        
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.304 -0400", hash_original_method = "DCABA764531B1065D0038AAAD031BA27", hash_generated_method = "5636D34A12F2C4D80314135CDB5CB32D")
    public void getIMSI(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.304 -0400", hash_original_method = "4D0F2CCF9960CC448C13E6CB3F3B5DE4", hash_generated_method = "1624B88A781C3B7F9C527DDED14BDA13")
    public void getIMEI(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.305 -0400", hash_original_method = "149F0748B48493B8EA1EFEBB8389549A", hash_generated_method = "87C9BA9B8FE3166B656AC48B806817D1")
    public void getIMEISV(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.305 -0400", hash_original_method = "7905AFC17F454606777953D509A8D53A", hash_generated_method = "88B716EB06E8F7A91B046800C56507D0")
    public void hangupConnection(int gsmIndex, Message result) {
        riljLog("hangupConnection: gsmIndex=" + gsmIndex);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        addTaint(gsmIndex);
        addTaint(result.getTaint());
        
        
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.306 -0400", hash_original_method = "85440FD9AE077A395C6F94573FB9B35A", hash_generated_method = "8C3B05BEC15ABC9E760922B98BC543E4")
    public void hangupWaitingOrBackground(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                                        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.307 -0400", hash_original_method = "7CE301AE0A34FEB3B57BD0350A2D5E6A", hash_generated_method = "8635E0576B943E9B69C30A63A0252BB1")
    public void hangupForegroundResumeBackground(Message result) {
        RILRequest rr = RILRequest.obtain(
                        RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
                        
                                        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.307 -0400", hash_original_method = "D308C1E0C4F8D94B5EF5B2D9D0D36F66", hash_generated_method = "23606F0853596E7C370DC810E4FC5EDE")
    public void switchWaitingOrHoldingAndActive(Message result) {
        RILRequest rr = RILRequest.obtain(
                        RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
                        
                                        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.308 -0400", hash_original_method = "E472C7A7FA5FA1FA68AAF1D140E0BD67", hash_generated_method = "35ECA0A87BC8458EB72D804463FA5865")
    public void conference(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.308 -0400", hash_original_method = "B803BD13961A7A2F16F3119AE2CBAC6F", hash_generated_method = "3296FB37B3D5BE43B634C11121B55615")
    public void setPreferredVoicePrivacy(boolean enable, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1:0);
        send(rr);
        addTaint(enable);
        addTaint(result.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.309 -0400", hash_original_method = "3E434E6C0C8E17A9191C0565807B19D8", hash_generated_method = "F8D28E2A44663E807C9C25C3D2E0B384")
    public void getPreferredVoicePrivacy(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.309 -0400", hash_original_method = "4B8D613904DEDF72212F0EB9A1BF349B", hash_generated_method = "2E4D57DF5F63183875DCF296051EA767")
    public void separateConnection(int gsmIndex, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        addTaint(gsmIndex);
        addTaint(result.getTaint());
        
        
                
        
                            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.309 -0400", hash_original_method = "8CB5CF57551B01694681D1FE4B325AA7", hash_generated_method = "A5B688362FD8C41601990C1E8D7698B9")
    public void acceptCall(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ANSWER, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.310 -0400", hash_original_method = "2E92E83F2C082778F7F377F259918641", hash_generated_method = "1CF1DCB190A9A7B37AF4073121AF5C33")
    public void rejectCall(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_UDUB, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.310 -0400", hash_original_method = "4490A3E422842C7946255FFDE06D02C6", hash_generated_method = "2680E42049320DAC64226DB8487E7FA2")
    public void explicitCallTransfer(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.310 -0400", hash_original_method = "286D2CDF105911EDAA78CDFFAADE2FB4", hash_generated_method = "AFF6DFFC5C931C2E62ECBB36ABED670D")
    public void getLastCallFailCause(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.311 -0400", hash_original_method = "E839391FA5F4E8371F0D2466E996CFDA", hash_generated_method = "E736392F3D904B6F15316A35E764CB6F")
    public void getLastPdpFailCause(Message result) {
        getLastDataCallFailCause (result);
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.311 -0400", hash_original_method = "367089EF39FE579C6BCEE97FCB3E914B", hash_generated_method = "29D8C9F90510825E108A44D73DC78325")
    public void getLastDataCallFailCause(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.311 -0400", hash_original_method = "350AC1F658DA4E0097EF1D14A3117454", hash_generated_method = "939C61507479E4CAE7C37570720687EC")
    public void setMute(boolean enableMute, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + enableMute);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enableMute ? 1 : 0);
        send(rr);
        addTaint(enableMute);
        addTaint(response.getTaint());
        
        
                
        
                            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.311 -0400", hash_original_method = "B42AC6EC10626260A88AA941D9E9F704", hash_generated_method = "A30804800FA8CAD594611E9992A69592")
    public void getMute(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.312 -0400", hash_original_method = "16BB78D78D9B012F64B70344D11CBBD0", hash_generated_method = "5F91A2F3744E7F59C6F7DC24D4A23D4F")
    public void getSignalStrength(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.312 -0400", hash_original_method = "CD1D773750E577C45A4986B8D31A3404", hash_generated_method = "D8D76DE6F3D1BEA2817FFE6690C38B7C")
    public void getVoiceRegistrationState(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.312 -0400", hash_original_method = "A42E908B0E0EAE7E9677D8B8370610F9", hash_generated_method = "BC9BEBAADEB0CA1BF970A75906916540")
    public void getDataRegistrationState(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.313 -0400", hash_original_method = "F3EF4D956FA5FB9BDF6C62381BC62F41", hash_generated_method = "6B9200A9829FF6D5927D9C2A5F1CB4AE")
    public void getOperator(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OPERATOR, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.313 -0400", hash_original_method = "3D70E9C0BFE2429BE8FC0BF7A1D59B4A", hash_generated_method = "A294CB733C6416F14622E1AF7056551B")
    public void sendDtmf(char c, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        addTaint(c);
        addTaint(result.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.313 -0400", hash_original_method = "BAA741C14C9F73BEA8C72D4011D64DC0", hash_generated_method = "696632E550266ED79D272735B2F268B2")
    public void startDtmf(char c, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF_START, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        addTaint(c);
        addTaint(result.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.314 -0400", hash_original_method = "C4D329464DB2A188FDA1049FC1B5C820", hash_generated_method = "02726C005AC3B740B0FDEE4AA5F26F78")
    public void stopDtmf(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.314 -0400", hash_original_method = "AF9E26B6734BDEC93AE44BA0DF8E2C9A", hash_generated_method = "BC3AAAC7D7133046BF1CB608EA548015")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BURST_DTMF, result);
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
        
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.315 -0400", hash_original_method = "6216EB8701D12EFA1EABB572C0722209", hash_generated_method = "1A0689C48F11A1C8FCE28209DE0307CF")
    public void sendSMS(String smscPDU, String pdu, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(smscPDU);
        rr.mp.writeString(pdu);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(smscPDU.getTaint());
        addTaint(pdu.getTaint());
        addTaint(result.getTaint());
        
        
                
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.316 -0400", hash_original_method = "B6146A457115D22EC1FC450C9E047949", hash_generated_method = "A8C2C42E2CDA3C66577727C587A97D5F")
    public void sendCdmaSms(byte[] pdu, Message result) {
        int address_nbr_of_digits;
        int subaddr_nbr_of_digits;
        int bearerDataLength;
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SEND_SMS, result);
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
                int i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } 
            } 
            rr.mp.writeInt(dis.read());
            rr.mp.writeByte((byte) dis.read());
            subaddr_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) subaddr_nbr_of_digits);
            {
                int i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } 
            } 
            bearerDataLength = dis.read();
            rr.mp.writeInt(bearerDataLength);
            {
                int i = 0;
                {
                    rr.mp.writeByte(dis.readByte());
                } 
            } 
        } 
        catch (IOException ex)
        {
            riljLog("sendSmsCdma: conversion from input stream to object failed: "
                    + ex);
        } 
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(pdu[0]);
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.317 -0400", hash_original_method = "33AA1BF497C1DD92CFF4D18BA36EE77C", hash_generated_method = "D381B8CFD7E25D9DE28C7376894BA19C")
    public void deleteSmsOnSim(int index, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DELETE_SMS_ON_SIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } 
        send(rr);
        addTaint(index);
        addTaint(response.getTaint());
        
        
                
        
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.318 -0400", hash_original_method = "AADBC281C1547D2CD40AF49A4F15439D", hash_generated_method = "19FD4EA817F77D1227B61C78074DE159")
    public void deleteSmsOnRuim(int index, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } 
        send(rr);
        addTaint(index);
        addTaint(response.getTaint());
        
        
                
        
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.318 -0400", hash_original_method = "371A972FE084C98FCAE13C1996429D8F", hash_generated_method = "0DB47607F283863C05C9B136E313D93F")
    public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        status = translateStatus(status);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_WRITE_SMS_TO_SIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        rr.mp.writeString(smsc);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } 
        send(rr);
        addTaint(status);
        addTaint(smsc.getTaint());
        addTaint(pdu.getTaint());
        addTaint(response.getTaint());
        
        
        
                
        
        
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.319 -0400", hash_original_method = "05C70D9FCCFAC2D0EDAAC7E4EA19DFB0", hash_generated_method = "26BDFF7FBA9FD29123A486C177A85C62")
    public void writeSmsToRuim(int status, String pdu, Message response) {
        status = translateStatus(status);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        {
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } 
        send(rr);
        addTaint(status);
        addTaint(pdu.getTaint());
        addTaint(response.getTaint());
        
        
        
                
        
        
        
            
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.320 -0400", hash_original_method = "0D77FBD1C1F349CB6A533B80F899FC6F", hash_generated_method = "D2B49F63E92039B606510A526214D0A9")
    private int translateStatus(int status) {
        addTaint(status);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370379709 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370379709;
        
        
            
                
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.321 -0400", hash_original_method = "9997727B0C7061EF37C7F5F20BA491DC", hash_generated_method = "8D8EEE80F4BED78A63E4C4FF777421D1")
    public void setupDataCall(String radioTechnology, String profile, String apn,
            String user, String password, String authType, String protocol,
            Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SETUP_DATA_CALL, result);
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
        
        
                
        
        
        
        
        
        
        
        
        
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.321 -0400", hash_original_method = "7ACA8E6FBBE8E5A758B0F14E8B7A1BD0", hash_generated_method = "7609472951E52EEB7914158720D3AFD1")
    public void deactivateDataCall(int cid, int reason, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEACTIVATE_DATA_CALL, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(Integer.toString(cid));
        rr.mp.writeString(Integer.toString(reason));
        riljLog(rr.serialString() + "> " +
                requestToString(rr.mRequest) + " " + cid + " " + reason);
        send(rr);
        addTaint(cid);
        addTaint(reason);
        addTaint(result.getTaint());
        
        
                
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.322 -0400", hash_original_method = "EB783AFA41C6889D4897D81BF3D72432", hash_generated_method = "D9F9B9D7A109DE5EBF98641B48B71A90")
    public void setRadioPower(boolean on, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_RADIO_POWER, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + (on ? " on" : " off"));
        } 
        send(rr);
        addTaint(on);
        addTaint(result.getTaint());
        
        
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.322 -0400", hash_original_method = "20525E4C07E2BDDC8598F4A8A0A24AAC", hash_generated_method = "6ED275F20519A8D19761A5616898A53D")
    public void setSuppServiceNotifications(boolean enable, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest));
        send(rr);
        addTaint(enable);
        addTaint(result.getTaint());
        
        
                
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.322 -0400", hash_original_method = "2FD7CAC0F0B66293984C61A06F9D6871", hash_generated_method = "CAF40A4713A9666E1D16922A0C25D0E4")
    public void acknowledgeLastIncomingGsmSms(boolean success, int cause, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(2);
        rr.mp.writeInt(success ? 1 : 0);
        rr.mp.writeInt(cause);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
        addTaint(success);
        addTaint(cause);
        addTaint(result.getTaint());
        
        
                
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.323 -0400", hash_original_method = "7D64BD1B5FFD5E98E91826BF607F7EF6", hash_generated_method = "EFC90BE954559F12D7DA13B7D46458E9")
    public void acknowledgeLastIncomingCdmaSms(boolean success, int cause, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(success ? 0 : 1);
        rr.mp.writeInt(cause);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
        addTaint(success);
        addTaint(cause);
        addTaint(result.getTaint());
        
        
                
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.323 -0400", hash_original_method = "64AA0D67C6CE837D613809948FDF7791", hash_generated_method = "7A4508456581B91B81120127B6FD4051")
    public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(success ? "1" : "0");
        rr.mp.writeString(ackPdu);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + ' ' + success + " [" + ackPdu + ']');
        send(rr);
        addTaint(success);
        addTaint(ackPdu.getTaint());
        addTaint(result.getTaint());
        
        
                
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.324 -0400", hash_original_method = "59EE7F242CC2ECDC31CC3317E2625FB0", hash_generated_method = "68DB3BD2322D38396C9341E6E479D5C1")
    public void iccIO(int command, int fileid, String path, int p1, int p2, int p3,
            String data, String pin2, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SIM_IO, result);
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
        
        
                
        
        
        
        
        
        
        
        
        
                
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.325 -0400", hash_original_method = "ED6C155DF5FB4724355C53F41C941076", hash_generated_method = "111BE8B11D48F2275F936C1EBE123A70")
    public void getCLIR(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.326 -0400", hash_original_method = "19860D4829B0277968FE7219CA94272C", hash_generated_method = "5732E337332B1AB6BD47E2B7CAF97F37")
    public void setCLIR(int clirMode, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(clirMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + clirMode);
        send(rr);
        addTaint(clirMode);
        addTaint(result.getTaint());
        
        
                
        
        
        
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.328 -0400", hash_original_method = "32FF52B6F1E399D1F262392EAB262972", hash_generated_method = "B300D48FD9223EECFAC232D079DB4A11")
    public void queryCallWaiting(int serviceClass, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(serviceClass);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + serviceClass);
        send(rr);
        addTaint(serviceClass);
        addTaint(response.getTaint());
        
        
                
        
        
        
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.329 -0400", hash_original_method = "5A203D1E3F2536DB5285EBA696BDFC7A", hash_generated_method = "79FC0498E5F0B90E7B266928686DD0E0")
    public void setCallWaiting(boolean enable, int serviceClass, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_WAITING, response);
        rr.mp.writeInt(2);
        rr.mp.writeInt(enable ? 1 : 0);
        rr.mp.writeInt(serviceClass);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + enable + ", " + serviceClass);
        send(rr);
        addTaint(enable);
        addTaint(serviceClass);
        addTaint(response.getTaint());
        
        
                
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.330 -0400", hash_original_method = "B2CF07F1A50F7E09BFE7FA86DAEC0935", hash_generated_method = "4C6718B0C44D6340022595F57FC059E9")
    public void setNetworkSelectionModeAutomatic(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
                                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.332 -0400", hash_original_method = "D59960D2C4E94DFBAD71EBB3A94610C2", hash_generated_method = "BE754596C3D8BB82A30B6DB56DA95253")
    public void setNetworkSelectionModeManual(String operatorNumeric, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + operatorNumeric);
        rr.mp.writeString(operatorNumeric);
        send(rr);
        addTaint(operatorNumeric.getTaint());
        addTaint(response.getTaint());
        
        
                
                                    
        
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.333 -0400", hash_original_method = "7D16D9750A543F65AAA01DDCEE296D12", hash_generated_method = "799D343DC7CD82CAF611EB01F0DA5725")
    public void getNetworkSelectionMode(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
                                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.333 -0400", hash_original_method = "A28AFA8A6050502E50A0794217CD9CA3", hash_generated_method = "CB3446D3C8BCB0266DAC9EAB17E28292")
    public void getAvailableNetworks(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
                                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.334 -0400", hash_original_method = "BAE7513A4D74D7F41628BC2CA56E49A7", hash_generated_method = "C50697D2D1766584B1C706B2EAE698F0")
    public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_FORWARD, response);
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
        
        
                
        
        
        
        
        
        
        
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.335 -0400", hash_original_method = "23037026F2CF508E3AB593A615459BEF", hash_generated_method = "8BB186EB36650B15AA7B55BCE2B05566")
    public void queryCallForwardStatus(int cfReason, int serviceClass,
                String number, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_FORWARD_STATUS, response);
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
        
        
            
        
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.336 -0400", hash_original_method = "51655E0BCF7B1E2F86E04B0432A13A10", hash_generated_method = "FF2D8211771FCD303B4413707F1CCDDB")
    public void queryCLIP(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.337 -0400", hash_original_method = "A7E1CFA2EA980EF525A71B63D23749C6", hash_generated_method = "9AF7CE09E606006FF00B7208E756D448")
    public void getBasebandVersion(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.338 -0400", hash_original_method = "E2D6CDE0F4A2E0F1E247B2E96BC06629", hash_generated_method = "03D9979C1BDC618FF8F306793F7E836C")
    @Override
    public void queryFacilityLock(String facility, String password, int serviceClass,
                            Message response) {
        queryFacilityLockForApp(facility, password, serviceClass, null, response);
        addTaint(facility.getTaint());
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.339 -0400", hash_original_method = "B68C5E6FDA45200A6E5673701837774F", hash_generated_method = "2CB601FC11810DB758FFE73312F6299A")
    @Override
    public void queryFacilityLockForApp(String facility, String password, int serviceClass, String appId,
                            Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_FACILITY_LOCK, response);
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
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.339 -0400", hash_original_method = "AF27A0F06A4AEF0B8CE967EE20FD6D5A", hash_generated_method = "62ABC180D4CDA1E57B46B0F281F232A2")
    @Override
    public void setFacilityLock(String facility, boolean lockState, String password,
                        int serviceClass, Message response) {
        setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
        addTaint(facility.getTaint());
        addTaint(lockState);
        addTaint(password.getTaint());
        addTaint(serviceClass);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.340 -0400", hash_original_method = "99FAE35221FB0E541022587B483A8F41", hash_generated_method = "B49EF70FC205E562E915E26CFBDE9A6E")
    @Override
    public void setFacilityLockForApp(String facility, boolean lockState, String password,
                        int serviceClass, String appId, Message response) {
        String lockString;
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_FACILITY_LOCK, response);
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
        
        
        
                
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.340 -0400", hash_original_method = "B3D73089A364D1181DC1E2D229325D6D", hash_generated_method = "3B67792B4C945C156EC6BCA0CEFC6EA5")
    public void sendUSSD(String ussdString, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + ussdString);
        rr.mp.writeString(ussdString);
        send(rr);
        addTaint(ussdString.getTaint());
        addTaint(response.getTaint());
        
        
                
        
                            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.341 -0400", hash_original_method = "08754E29DFB7112567CD0DC9F54BCD3D", hash_generated_method = "A762D2BAE5E67DEB51A422F6DF3FD81F")
    public void cancelPendingUssd(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.341 -0400", hash_original_method = "5EED3CE7F239827AE459A68B7A5F6205", hash_generated_method = "0357CC65702D331DA7CB537CD4E41727")
    public void resetRadio(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.341 -0400", hash_original_method = "CC2053517147AA26411A18AF4FB47931", hash_generated_method = "7E7C6A6207CDF3776EE5B7F3D49E34C5")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               + "[" + IccUtils.bytesToHexString(data) + "]");
        rr.mp.writeByteArray(data);
        send(rr);
        addTaint(data[0]);
        addTaint(response.getTaint());
        
        
                
        
               
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.342 -0400", hash_original_method = "30F3E98808998C1043AF97B2AEFF80ED", hash_generated_method = "57A05730216D7FF65FE42747186810FD")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeStringArray(strings);
        send(rr);
        addTaint(strings[0].getTaint());
        addTaint(response.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.342 -0400", hash_original_method = "0483D811AD0184EC240C471A09F163C0", hash_generated_method = "E8BC82149E6A576A7F2BA0824603642D")
    public void setBandMode(int bandMode, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(bandMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 + " " + bandMode);
        send(rr);
        addTaint(bandMode);
        addTaint(response.getTaint());
        
        
                
        
        
        
                 
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.342 -0400", hash_original_method = "3559A91588B2C9F9707F9FC4DC3F7539", hash_generated_method = "7EEA386E49D145A371F4EF0033D62F9B")
    public void queryAvailableBandMode(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.343 -0400", hash_original_method = "E6DDFD05E0997BF7790CA803E711C2EC", hash_generated_method = "492B28A3BD9CDA56B556683BAF1C7DA3")
    public void sendTerminalResponse(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.343 -0400", hash_original_method = "AF8E8A7CD3B08412D1DCD73CAE0ACCA0", hash_generated_method = "54C1774DF27A1A4D10592A40CCF3864A")
    public void sendEnvelope(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.343 -0400", hash_original_method = "A3C6115C92419E7DB4E4439F1BAFD013", hash_generated_method = "2493B6C1D60B293F9D30B3E6E1E20086")
    public void sendEnvelopeWithStatus(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + '[' + contents + ']');
        rr.mp.writeString(contents);
        send(rr);
        addTaint(contents.getTaint());
        addTaint(response.getTaint());
        
        
                
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.344 -0400", hash_original_method = "0FD1EE2A52540A4F80ECA30E950318D2", hash_generated_method = "70D387A379448A863D5D93917EFFD1ED")
    public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
        RILRequest rr = RILRequest.obtain(
            RILConstants.RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM,
            response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        int[] param = new int[1];
        param[0] = accept ? 1 : 0;
        rr.mp.writeIntArray(param);
        send(rr);
        addTaint(accept);
        addTaint(response.getTaint());
        
        
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.344 -0400", hash_original_method = "E0470661D17E36A9D9FCCA070C28B88C", hash_generated_method = "8F3EBD836485C251BFD8B926999FF50B")
    @Override
    public void setCurrentPreferredNetworkType() {
        riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        setPreferredNetworkType(mSetPreferredNetworkType, null);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.344 -0400", hash_original_method = "CD05D01D2353BF09784B2C892638713C", hash_generated_method = "40E1B2DA3086C9E35243C577CD164EBD")
    public void setPreferredNetworkType(int networkType , Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(networkType);
        mSetPreferredNetworkType = networkType;
        mPreferredNetworkType = networkType;
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + networkType);
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.345 -0400", hash_original_method = "9630540DB0E1A382F252246374543CFF", hash_generated_method = "7F52A3CB81B51A9302E71701D1A878C9")
    public void getPreferredNetworkType(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.346 -0400", hash_original_method = "EA7CB0793F40AD8E91B9E82268500DF5", hash_generated_method = "3744E15E130E8EF8D2406ADCD8EDFD57")
    public void getNeighboringCids(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.346 -0400", hash_original_method = "29FCAB1F96F7A6DF63D13BAE634B9C42", hash_generated_method = "E636D79C6BBB0453FCCBEDDF4B2D61A3")
    public void setLocationUpdates(boolean enable, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + enable);
        send(rr);
        addTaint(enable);
        addTaint(response.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.347 -0400", hash_original_method = "7C3C5691348423704F3F89A5A1253262", hash_generated_method = "F2F97C512E7F519BB63A16DFE6AAC4D3")
    public void getSmscAddress(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.347 -0400", hash_original_method = "8030AF8483F275DADFE9FBCDFA4401B2", hash_generated_method = "63F7A4EB6AD295F15AB3573002BB7810")
    public void setSmscAddress(String address, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);
        rr.mp.writeString(address);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + address);
        send(rr);
        addTaint(address.getTaint());
        addTaint(result.getTaint());
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.348 -0400", hash_original_method = "E14FF49FE633CFCC7BBD49EA04EF5648", hash_generated_method = "E9E2A3B2E8A256F0699CC1F23D76F6A4")
    public void reportSmsMemoryStatus(boolean available, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(available ? 1 : 0);
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + available);
        send(rr);
        addTaint(available);
        addTaint(result.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.348 -0400", hash_original_method = "00A5515B81A4CB5336CA56505ADAAD61", hash_generated_method = "7109F18B12602E413BD3AB9927FD20A4")
    public void reportStkServiceIsRunning(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(result.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.348 -0400", hash_original_method = "8D8904D0E740DF21294F215C1D1D7109", hash_generated_method = "79CF6A6BD4DE7E74DBBC0D3690DCB408")
    public void getGsmBroadcastConfig(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.349 -0400", hash_original_method = "052EA3DC72AD24FB98DF1CE5007E33C5", hash_generated_method = "BDFFCE1A5189D81BD3A2ED65AF8DC392")
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_SET_BROADCAST_CONFIG, response);
        int numOfConfig = config.length;
        rr.mp.writeInt(numOfConfig);
        {
            int i = 0;
            {
                rr.mp.writeInt(config[i].getFromServiceId());
                rr.mp.writeInt(config[i].getToServiceId());
                rr.mp.writeInt(config[i].getFromCodeScheme());
                rr.mp.writeInt(config[i].getToCodeScheme());
                rr.mp.writeInt(config[i].isSelected() ? 1 : 0);
            } 
        } 
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " with " + numOfConfig + " configs : ");
            {
                int i = 0;
                {
                    riljLog(config[i].toString());
                } 
            } 
        } 
        send(rr);
        addTaint(config[0].getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.350 -0400", hash_original_method = "A31C3FA8B485D8364A045A89E34CE9F1", hash_generated_method = "D99334ED1FCA11001DA22D6CC7CB50B9")
    public void setGsmBroadcastActivation(boolean activate, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 : 1);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(activate);
        addTaint(response.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.350 -0400", hash_original_method = "98C8C2D826445A3B0F1B6AA20E13AA85", hash_generated_method = "62B933DB8219B7DF3340B59537DC0BF2")
    private void sendScreenState(boolean on) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest) + ": " + on);
        send(rr);
        addTaint(on);
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.351 -0400", hash_original_method = "BB835229E5EA50CDBB0B126232F0F168", hash_generated_method = "D18433B9DE179811653284B06AFFE308")
    protected void onRadioAvailable() {
        
        sendScreenState(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.352 -0400", hash_original_method = "160781DFD510822CA161AF254F33803E", hash_generated_method = "C544E5E2747B142B4BDB382B2BD3233D")
    private RadioState getRadioStateFromInt(int stateInt) {
        RadioState varB4EAC82CA7396A68D541C85D26508E83_1517538103 = null; 
        RadioState state;
        
        state = RadioState.RADIO_OFF;
        
        
        state = RadioState.RADIO_UNAVAILABLE;
        
        
        state = RadioState.SIM_NOT_READY;
        
        
        state = RadioState.SIM_LOCKED_OR_ABSENT;
        
        
        state = RadioState.SIM_READY;
        
        
        state = RadioState.RUIM_NOT_READY;
        
        
        state = RadioState.RUIM_READY;
        
        
        state = RadioState.RUIM_LOCKED_OR_ABSENT;
        
        
        state = RadioState.NV_NOT_READY;
        
        
        state = RadioState.NV_READY;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_RadioState: " + stateInt);
        
        varB4EAC82CA7396A68D541C85D26508E83_1517538103 = state;
        addTaint(stateInt);
        varB4EAC82CA7396A68D541C85D26508E83_1517538103.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1517538103;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.353 -0400", hash_original_method = "63485FEB05CEDE30346AAC1338BBCCD0", hash_generated_method = "954427291C6C8AFB7B940F81041935AF")
    private void switchToRadioState(RadioState newState) {
        setRadioState(newState);
        addTaint(newState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.354 -0400", hash_original_method = "80B68145386C06F39CF9C77A11CB4F6E", hash_generated_method = "092F2AC850E2074DA4A9502C2A207B19")
    private void acquireWakeLock() {
        {
            mWakeLock.acquire();
            mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            Message msg = mSender.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            mSender.sendMessageDelayed(msg, mWakeLockTimeout);
        } 
        
        
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.355 -0400", hash_original_method = "F7B2E2DA8A26C192DB4FA2BF8451999B", hash_generated_method = "6A6EC6D61617CD7F58569A4615A64B46")
    private void releaseWakeLockIfDone() {
        {
            {
                boolean var89EBFD9F809D519C007EEC04CB5812D0_1748667707 = (mWakeLock.isHeld() &&
                (mRequestMessagesPending == 0) &&
                (mRequestMessagesWaiting == 0));
                {
                    mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                    mWakeLock.release();
                } 
            } 
        } 
        
        
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.357 -0400", hash_original_method = "035841781AADB837D6EAD23CCB5C67B0", hash_generated_method = "D3C6079FD62199DBC8AAA51BFFFF2490")
    private void send(RILRequest rr) {
        Message msg;
        {
            rr.onError(RADIO_NOT_AVAILABLE, null);
            rr.release();
        } 
        msg = mSender.obtainMessage(EVENT_SEND, rr);
        acquireWakeLock();
        msg.sendToTarget();
        addTaint(rr.getTaint());
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.358 -0400", hash_original_method = "BE5BB24392C97184A4E1C8B58214F114", hash_generated_method = "4258AF80C29E2713EB33D8D58FE7CCE4")
    private void processResponse(Parcel p) {
        int type;
        type = p.readInt();
        {
            processUnsolicited (p);
        } 
        {
            processSolicited (p);
        } 
        releaseWakeLockIfDone();
        addTaint(p.getTaint());
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.359 -0400", hash_original_method = "BC68EE684C76422271CAFE5D885C13B0", hash_generated_method = "9A092A7384DD5D5F3DE9A1CAF4ACA98C")
    private void clearRequestsList(int error, boolean loggable) {
        RILRequest rr;
        {
            int count = mRequestsList.size();
            {
                Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                        " mReqPending=" + mRequestMessagesPending +
                        " mRequestList=" + count);
            } 
            {
                int i = 0;
                {
                    rr = mRequestsList.get(i);
                    {
                        Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] " +
                            requestToString(rr.mRequest));
                    } 
                    rr.onError(error, null);
                    rr.release();
                } 
            } 
            mRequestsList.clear();
            mRequestMessagesWaiting = 0;
        } 
        addTaint(error);
        addTaint(loggable);
        
        
        
            
            
                
                        
                        
            
            
                
                
                    
                            
                
                
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.362 -0400", hash_original_method = "821C18746C2BF0250268E9897F34563E", hash_generated_method = "2C945BF698F960B5380F38CC866910ED")
    private RILRequest findAndRemoveRequestFromList(int serial) {
        RILRequest varB4EAC82CA7396A68D541C85D26508E83_2074268741 = null; 
        RILRequest varB4EAC82CA7396A68D541C85D26508E83_898985649 = null; 
        {
            {
                int i = 0;
                int s = mRequestsList.size();
                {
                    RILRequest rr = mRequestsList.get(i);
                    {
                        mRequestsList.remove(i);
                        varB4EAC82CA7396A68D541C85D26508E83_2074268741 = rr;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_898985649 = null;
        addTaint(serial);
        RILRequest varA7E53CE21691AB073D9660D615818899_772010319; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_772010319 = varB4EAC82CA7396A68D541C85D26508E83_2074268741;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_772010319 = varB4EAC82CA7396A68D541C85D26508E83_898985649;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_772010319.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_772010319;
        
        
            
                
                
                    
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.365 -0400", hash_original_method = "E53F353584D1FC1676A6EAA90642D430", hash_generated_method = "7BDAD39A5607AD547AB0FEA709B27F7E")
    private void processSolicited(Parcel p) {
        int serial;
        int error;
        boolean found = false;
        serial = p.readInt();
        error = p.readInt();
        RILRequest rr;
        rr = findAndRemoveRequestFromList(serial);
        Object ret = null;
        {
            boolean varC99D962AF06CF99AD34CE6AAAD8ADD1D_92551175 = (error == 0 || p.dataAvail() > 0);
            {
                try 
                {
                    
                    ret =  responseIccCardStatus(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseCallList(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseSignalStrength(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseSMS(p);
                    
                    
                    ret =  responseSMS(p);
                    
                    
                    ret =  responseSetupDataCall(p);
                    
                    
                    ret =  responseICC_IO(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseCallForward(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseOperatorInfos(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseDataCallList(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseRaw(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseGetPreferredNetworkType(p);
                    
                    
                    ret = responseCellList(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseSMS(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseGmsBroadcastConfig(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseCdmaBroadcastConfig(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseVoid(p);
                    
                    
                    ret =  responseStrings(p);
                    
                    
                    ret = responseString(p);
                    
                    
                    ret = responseVoid(p);
                    
                    
                    ret = responseVoid(p);
                    
                    
                    ret = responseVoid(p);
                    
                    
                    ret = responseVoid(p);
                    
                    
                    ret =  responseInts(p);
                    
                    
                    ret =  responseString(p);
                    
                    
                    ret = responseVoid(p);
                    
                    
                    ret = responseICC_IO(p);
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized solicited response: " + rr.mRequest);
                    
                } 
                catch (Throwable tr)
                {
                    {
                        AsyncResult.forMessage(rr.mResult, null, tr);
                        rr.mResult.sendToTarget();
                    } 
                    rr.release();
                } 
            } 
        } 
        {
            rr.onError(error, ret);
            rr.release();
        } 
        riljLog(rr.serialString() + "< " + requestToString(rr.mRequest)
            + " " + retToString(rr.mRequest, ret));
        {
            AsyncResult.forMessage(rr.mResult, ret, null);
            rr.mResult.sendToTarget();
        } 
        rr.release();
        addTaint(p.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.386 -0400", hash_original_method = "8A94A1215BBA17FF474D4F8406941ACC", hash_generated_method = "EF623E45616C3795FABEF9952C4A9B39")
    private String retToString(int req, Object ret) {
        String varB4EAC82CA7396A68D541C85D26508E83_1026190199 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1810727616 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_496753434 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1026190199 = "";
        
        {
            varB4EAC82CA7396A68D541C85D26508E83_1810727616 = "";
        } 
        
        StringBuilder sb;
        String s;
        int length;
        {
            int[] intArray = (int[]) ret;
            length = intArray.length;
            sb = new StringBuilder("{");
            {
                int i = 0;
                sb.append(intArray[i++]);
                {
                    sb.append(", ").append(intArray[i++]);
                } 
            } 
            sb.append("}");
            s = sb.toString();
        } 
        {
            String[] strings = (String[]) ret;
            length = strings.length;
            sb = new StringBuilder("{");
            {
                int i = 0;
                sb.append(strings[i++]);
                {
                    sb.append(", ").append(strings[i++]);
                } 
            } 
            sb.append("}");
            s = sb.toString();
        } 
        {
            ArrayList<DriverCall> calls = (ArrayList<DriverCall>) ret;
            sb = new StringBuilder(" ");
            {
                Iterator<DriverCall> var4B2037772A81856F80258F9F44AA331B_857169720 = (calls).iterator();
                var4B2037772A81856F80258F9F44AA331B_857169720.hasNext();
                DriverCall dc = var4B2037772A81856F80258F9F44AA331B_857169720.next();
                {
                    sb.append("[").append(dc).append("] ");
                } 
            } 
            s = sb.toString();
        } 
        {
            ArrayList<NeighboringCellInfo> cells;
            cells = (ArrayList<NeighboringCellInfo>) ret;
            sb = new StringBuilder(" ");
            {
                Iterator<NeighboringCellInfo> varA3884DD0459ACF5B7D7CFE2B0AD6D134_1797100510 = (cells).iterator();
                varA3884DD0459ACF5B7D7CFE2B0AD6D134_1797100510.hasNext();
                NeighboringCellInfo cell = varA3884DD0459ACF5B7D7CFE2B0AD6D134_1797100510.next();
                {
                    sb.append(cell).append(" ");
                } 
            } 
            s = sb.toString();
        } 
        {
            s = ret.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_496753434 = s;
        addTaint(req);
        addTaint(ret.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1485925564; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1485925564 = varB4EAC82CA7396A68D541C85D26508E83_1026190199;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1485925564 = varB4EAC82CA7396A68D541C85D26508E83_1810727616;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1485925564 = varB4EAC82CA7396A68D541C85D26508E83_496753434;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1485925564.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1485925564;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.436 -0400", hash_original_method = "0DD0C2CAC9DFFC256536DE8141109DEC", hash_generated_method = "1E8DD430F54FD8DF1DC2B3393AA17D88")
    private void processUnsolicited(Parcel p) {
        int response;
        Object ret = null;
        response = p.readInt();
        try 
        {
            
            ret =  responseVoid(p);
            
            
            ret =  responseVoid(p);
            
            
            ret =  responseVoid(p);
            
            
            ret =  responseString(p);
            
            
            ret =  responseString(p);
            
            
            ret =  responseInts(p);
            
            
            ret =  responseStrings(p);
            
            
            ret =  responseString(p);
            
            
            ret = responseSignalStrength(p);
            
            
            ret = responseDataCallList(p);
            
            
            ret = responseSuppServiceNotification(p);
            
            
            ret = responseVoid(p);
            
            
            ret = responseString(p);
            
            
            ret = responseString(p);
            
            
            ret = responseInts(p);
            
            
            ret =  responseVoid(p);
            
            
            ret =  responseInts(p);
            
            
            ret =  responseCallRing(p);
            
            
            ret = responseInts(p);
            
            
            ret =  responseVoid(p);
            
            
            ret =  responseCdmaSms(p);
            
            
            ret =  responseRaw(p);
            
            
            ret =  responseVoid(p);
            
            
            ret = responseVoid(p);
            
            
            ret = responseCdmaCallWaiting(p);
            
            
            ret = responseInts(p);
            
            
            ret = responseCdmaInformationRecord(p);
            
            
            ret = responseRaw(p);
            
            
            ret = responseInts(p);
            
            
            ret = responseVoid(p);
            
            
            ret = responseInts(p);
            
            
            ret = responseInts(p);
            
            
            ret = responseVoid(p);
            
            
            ret = responseInts(p);
            
            
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized unsol response: " + response);
            
        } 
        catch (Throwable tr)
        { }
        
        RadioState newState = getRadioStateFromInt(p.readInt());
        
        
        unsljLogMore(response, newState.toString());
        
        
        switchToRadioState(newState);
        
        
        unsljLog(response);
        
        
        mCallStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        
        
        unsljLog(response);
        
        
        mVoiceNetworkStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        
        
        {
            unsljLog(response);
            String a[] = new String[2];
            a[1] = (String)ret;
            SmsMessage sms;
            sms = SmsMessage.newFromCMT(a);
            {
                mGsmSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
            } 
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mSmsStatusRegistrant.notifyRegistrant(
                            new AsyncResult(null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        int[] smsIndex = (int[])ret;
        
        
        {
            {
                mSmsOnSimRegistrant.
                                notifyRegistrant(new AsyncResult(null, smsIndex, null));
            } 
        } 
        {
            riljLog(" NEW_SMS_ON_SIM ERROR with wrong length "
                            + smsIndex.length);
        } 
        
        
        String[] resp = (String[])ret;
        
        
        {
            resp = new String[2];
            resp[0] = ((String[])ret)[0];
            resp[1] = null;
        } 
        
        
        unsljLogMore(response, resp[0]);
        
        
        {
            mUSSDRegistrant.notifyRegistrant(
                        new AsyncResult (null, resp, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        long nitzReceiveTime = p.readLong();
        
        
        Object[] result = new Object[2];
        
        
        result[0] = ret;
        
        
        result[1] = Long.valueOf(nitzReceiveTime);
        
        
        {
            mNITZTimeRegistrant
                        .notifyRegistrant(new AsyncResult (null, result, null));
        } 
        {
            mLastNITZTimeInfo = result;
        } 
        
        
        unsljLogvRet(response, ret);
        
        
        {
            mSignalStrengthRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        mDataNetworkStateRegistrants.notifyRegistrants(new AsyncResult(null, ret, null));
        
        
        unsljLogRet(response, ret);
        
        
        {
            mSsnRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLog(response);
        
        
        {
            mCatSessionEndRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCatProCmdRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCatEventRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCatCallSetUpRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLog(response);
        
        
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mIccRefreshRegistrants.notifyRegistrants(
                            new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mRingRegistrant.notifyRegistrant(
                            new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogvRet(response, ret);
        
        
        {
            mRestrictedStateRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLog(response);
        
        
        {
            mIccStatusChangedRegistrants.notifyRegistrants();
        } 
        
        
        unsljLog(response);
        
        
        SmsMessage sms = (SmsMessage) ret;
        
        
        {
            mCdmaSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
        } 
        
        
        unsljLog(response);
        
        
        {
            mGsmBroadcastSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, ret, null));
        } 
        
        
        unsljLog(response);
        
        
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } 
        
        
        unsljLog(response);
        
        
        {
            mEmergencyCallbackModeRegistrant.notifyRegistrant();
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCallWaitingInfoRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mOtaProvisionRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        ArrayList<CdmaInformationRecords> listInfoRecs = null;
        
        
        try 
        {
            listInfoRecs = (ArrayList<CdmaInformationRecords>)ret;
        } 
        catch (ClassCastException e)
        { }
        
        
        {
            Iterator<CdmaInformationRecords> var31392388BAFC4C31423B73000D3019F0_1984063425 = (listInfoRecs).iterator();
            var31392388BAFC4C31423B73000D3019F0_1984063425.hasNext();
            CdmaInformationRecords rec = var31392388BAFC4C31423B73000D3019F0_1984063425.next();
            {
                unsljLogRet(response, rec);
                notifyRegistrantsCdmaInfoRec(rec);
            } 
        } 
        
        
        unsljLogvRet(response, IccUtils.bytesToHexString((byte[])ret));
        
        
        {
            mUnsolOemHookRawRegistrant.notifyRegistrant(new AsyncResult(null, ret, null));
        } 
        
        
        unsljLogvRet(response, ret);
        
        
        {
            boolean playtone = (((int[])ret)[0] == 1);
            mRingbackToneRegistrants.notifyRegistrants(
                                        new AsyncResult (null, playtone, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mResendIncallMuteRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCdmaSubscriptionChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mCdmaPrlChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } 
        
        
        unsljLogRet(response, ret);
        
        
        {
            mExitEmergencyCallbackModeRegistrants.notifyRegistrants(
                                        new AsyncResult (null, null, null));
        } 
        
        
        {
            unsljLogRet(response, ret);
            setRadioPower(false, null);
            setPreferredNetworkType(mPreferredNetworkType, null);
            setCdmaSubscriptionSource(mCdmaSubscription, null);
            notifyRegistrantsRilConnectionChanged(((int[])ret)[0]);
        } 
        
        addTaint(p.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.437 -0400", hash_original_method = "B856EBB2256F144A73FE56175A9B6A36", hash_generated_method = "DC2B05731FADC5E6AEC3A48FE5E1D3A8")
    private void notifyRegistrantsRilConnectionChanged(int rilVer) {
        mRilVersion = rilVer;
        {
            mRilConnectedRegistrants.notifyRegistrants(
                                new AsyncResult (null, new Integer(rilVer), null));
        } 
        addTaint(rilVer);
        
        
        
            
                                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.437 -0400", hash_original_method = "2C7447093749DDBD708485E3CB5D7194", hash_generated_method = "81BC8698B08837F4B6BBC1C3A81D0EB1")
    private Object responseInts(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_191721175 = null; 
        int numInts;
        int response[];
        numInts = p.readInt();
        response = new int[numInts];
        {
            int i = 0;
            {
                response[i] = p.readInt();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_191721175 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_191721175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_191721175;
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.438 -0400", hash_original_method = "F83E9E0330A999E5D5277EA606DEC7ED", hash_generated_method = "0741AC9BDA370933B2D228D0415043F5")
    private Object responseVoid(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_177349079 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_177349079 = null;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_177349079.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_177349079;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.439 -0400", hash_original_method = "A9CCF034900EFF9E845FDB7DB22E08D2", hash_generated_method = "FB9F70F30789B88517345A76176DD24D")
    private Object responseCallForward(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2009629595 = null; 
        int numInfos;
        CallForwardInfo infos[];
        numInfos = p.readInt();
        infos = new CallForwardInfo[numInfos];
        {
            int i = 0;
            {
                infos[i] = new CallForwardInfo();
                infos[i].status = p.readInt();
                infos[i].reason = p.readInt();
                infos[i].serviceClass = p.readInt();
                infos[i].toa = p.readInt();
                infos[i].number = p.readString();
                infos[i].timeSeconds = p.readInt();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2009629595 = infos;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2009629595.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2009629595;
        
        
        
        
        
        
            
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.439 -0400", hash_original_method = "6CA2F91918640E9DE536352B73E673A3", hash_generated_method = "C917DB3BF7F145C6BDAB513234E9B043")
    private Object responseSuppServiceNotification(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_374845769 = null; 
        SuppServiceNotification notification = new SuppServiceNotification();
        notification.notificationType = p.readInt();
        notification.code = p.readInt();
        notification.index = p.readInt();
        notification.type = p.readInt();
        notification.number = p.readString();
        varB4EAC82CA7396A68D541C85D26508E83_374845769 = notification;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_374845769.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_374845769;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.441 -0400", hash_original_method = "F3FE5FFB00EF9163091B0B3C9957ECDA", hash_generated_method = "F8A53E71895E0638852AECC1DAD05C26")
    private Object responseCdmaSms(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_763664392 = null; 
        SmsMessage sms;
        sms = SmsMessage.newFromParcel(p);
        varB4EAC82CA7396A68D541C85D26508E83_763664392 = sms;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_763664392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_763664392;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.442 -0400", hash_original_method = "E706FBE3176786F101EC24273C477E8B", hash_generated_method = "CD6859F7823780802AE2997E20A0F988")
    private Object responseString(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_752646668 = null; 
        String response;
        response = p.readString();
        varB4EAC82CA7396A68D541C85D26508E83_752646668 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_752646668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_752646668;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.442 -0400", hash_original_method = "D52365FD6A67C03CB48CBBF364BA22AF", hash_generated_method = "0CB773D17C97389C1AF219A26792A840")
    private Object responseStrings(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_387633278 = null; 
        int num;
        String response[];
        response = p.readStringArray();
        {
            num = p.readInt();
            response = new String[num];
            {
                int i = 0;
                {
                    response[i] = p.readString();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_387633278 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_387633278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_387633278;
        
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.443 -0400", hash_original_method = "B7DD4FAF5DCF16E3869A5E71E7C7982F", hash_generated_method = "401358A173A4B213795D8BFE80DC746E")
    private Object responseRaw(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1620547077 = null; 
        int num;
        byte response[];
        response = p.createByteArray();
        varB4EAC82CA7396A68D541C85D26508E83_1620547077 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1620547077.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1620547077;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.444 -0400", hash_original_method = "6A2331BAD13DEAF24E14B96082F25F22", hash_generated_method = "5221F22C950D56014D0F9B344DD1A63C")
    private Object responseSMS(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1044093208 = null; 
        int messageRef;
        int errorCode;
        String ackPDU;
        messageRef = p.readInt();
        ackPDU = p.readString();
        errorCode = p.readInt();
        SmsResponse response = new SmsResponse(messageRef, ackPDU, errorCode);
        varB4EAC82CA7396A68D541C85D26508E83_1044093208 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1044093208.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1044093208;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.444 -0400", hash_original_method = "36285902341CFAECFF4B1CF0D454D382", hash_generated_method = "960842B7A3910EB47380A1E6CF3D83DF")
    private Object responseICC_IO(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1651317444 = null; 
        int sw1;
        int sw2;
        byte data[] = null;
        Message ret;
        sw1 = p.readInt();
        sw2 = p.readInt();
        String s = p.readString();
        riljLog("< iccIO: "
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s);
        varB4EAC82CA7396A68D541C85D26508E83_1651317444 = new IccIoResult(sw1, sw2, s);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1651317444.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1651317444;
        
        
        
        
        
        
        
        
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.445 -0400", hash_original_method = "D5683AC0AFFFFAC7278B155F54988C15", hash_generated_method = "103B37784E6C39B7794A20BF244F36DE")
    private Object responseIccCardStatus(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2145115922 = null; 
        IccCardApplication ca;
        IccCardStatus status = new IccCardStatus();
        status.setCardState(p.readInt());
        status.setUniversalPinState(p.readInt());
        status.setGsmUmtsSubscriptionAppIndex(p.readInt());
        status.setCdmaSubscriptionAppIndex(p.readInt());
        status.setImsSubscriptionAppIndex(p.readInt());
        int numApplications = p.readInt();
        {
            numApplications = IccCardStatus.CARD_MAX_APPS;
        } 
        status.setNumApplications(numApplications);
        {
            int i = 0;
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
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2145115922 = status;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2145115922.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2145115922;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.448 -0400", hash_original_method = "26536CEB9BA98624BF6B84456E63F303", hash_generated_method = "6B8E954EED79396A1AD5604DA7B31A5D")
    private Object responseCallList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1339660760 = null; 
        int num;
        int voiceSettings;
        ArrayList<DriverCall> response;
        DriverCall dc;
        num = p.readInt();
        response = new ArrayList<DriverCall>(num);
        {
            int i = 0;
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
                int np = p.readInt();
                dc.numberPresentation = DriverCall.presentationFromCLIP(np);
                dc.name = p.readString();
                dc.namePresentation = p.readInt();
                int uusInfoPresent = p.readInt();
                {
                    dc.uusInfo = new UUSInfo();
                    dc.uusInfo.setType(p.readInt());
                    dc.uusInfo.setDcs(p.readInt());
                    byte[] userData = p.createByteArray();
                    dc.uusInfo.setUserData(userData);
                    riljLogv(String.format("Incoming UUS : type=%d, dcs=%d, length=%d",
                                dc.uusInfo.getType(), dc.uusInfo.getDcs(),
                                dc.uusInfo.getUserData().length));
                    riljLogv("Incoming UUS : data (string)="
                        + new String(dc.uusInfo.getUserData()));
                    riljLogv("Incoming UUS : data (hex): "
                        + IccUtils.bytesToHexString(dc.uusInfo.getUserData()));
                } 
                {
                    riljLogv("Incoming UUS : NOT present!");
                } 
                dc.number = PhoneNumberUtils.stringFromStringAndTOA(dc.number, dc.TOA);
                response.add(dc);
                {
                    mVoicePrivacyOnRegistrants.notifyRegistrants();
                    riljLog("InCall VoicePrivacy is enabled");
                } 
                {
                    mVoicePrivacyOffRegistrants.notifyRegistrants();
                    riljLog("InCall VoicePrivacy is disabled");
                } 
            } 
        } 
        Collections.sort(response);
        varB4EAC82CA7396A68D541C85D26508E83_1339660760 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1339660760.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1339660760;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.450 -0400", hash_original_method = "ED5CAFCBF47B1330CD2566A0B897CA0C", hash_generated_method = "EA11B1652A0D7DD13CD1BEE46839D607")
    private DataCallState getDataCallState(Parcel p, int version) {
        DataCallState varB4EAC82CA7396A68D541C85D26508E83_20225201 = null; 
        DataCallState dataCall = new DataCallState();
        dataCall.version = version;
        {
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            String addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_504916088 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } 
            } 
        } 
        {
            dataCall.status = p.readInt();
            dataCall.suggestedRetryTime = p.readInt();
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            dataCall.ifname = p.readString();
            {
                boolean var9C097F15414DD096BEEBECEC45CBC3B3_468747928 = ((dataCall.status == DataConnection.FailCause.NONE.getErrorCode()) &&
                    TextUtils.isEmpty(dataCall.ifname));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("getDataCallState, no ifname");
                } 
            } 
            String addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_1271614959 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } 
            } 
            String dnses = p.readString();
            {
                boolean var22967F124DA8C753464DD7656A6CF5D6_199364499 = (!TextUtils.isEmpty(dnses));
                {
                    dataCall.dnses = dnses.split(" ");
                } 
            } 
            String gateways = p.readString();
            {
                boolean var68C55CDE386BBAC0DE45A0309B2750DE_272728381 = (!TextUtils.isEmpty(gateways));
                {
                    dataCall.gateways = gateways.split(" ");
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_20225201 = dataCall;
        addTaint(p.getTaint());
        addTaint(version);
        varB4EAC82CA7396A68D541C85D26508E83_20225201.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_20225201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.452 -0400", hash_original_method = "123D49A321BB97EFA9843423F7545450", hash_generated_method = "9B434493F8053CF03B7089E0B438EEBB")
    private Object responseDataCallList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_654791653 = null; 
        ArrayList<DataCallState> response;
        int ver = p.readInt();
        int num = p.readInt();
        riljLog("responseDataCallList ver=" + ver + " num=" + num);
        response = new ArrayList<DataCallState>(num);
        {
            int i = 0;
            {
                response.add(getDataCallState(p, ver));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_654791653 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_654791653.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_654791653;
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.457 -0400", hash_original_method = "6E11D362E553C380CF6ADBFD5304CD05", hash_generated_method = "CCCDFB34A00E201AAE4540A249D64B90")
    private Object responseSetupDataCall(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1092405946 = null; 
        int ver = p.readInt();
        int num = p.readInt();
        riljLog("responseSetupDataCall ver=" + ver + " num=" + num);
        DataCallState dataCall;
        {
            dataCall = new DataCallState();
            dataCall.version = ver;
            dataCall.cid = Integer.parseInt(p.readString());
            dataCall.ifname = p.readString();
            {
                boolean varFCAE9407C997419D11FB63DAA27B5891_1383345228 = (TextUtils.isEmpty(dataCall.ifname));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response, no ifname");
                } 
            } 
            String addresses = p.readString();
            {
                boolean varE215C54D9705E023ED235AD30A4A0970_1892317232 = (!TextUtils.isEmpty(addresses));
                {
                    dataCall.addresses = addresses.split(" ");
                } 
            } 
            {
                String dnses = p.readString();
                riljLog("responseSetupDataCall got dnses=" + dnses);
                {
                    boolean varA216814F255A7125BD1D54E6A9B9165D_368437265 = (!TextUtils.isEmpty(dnses));
                    {
                        dataCall.dnses = dnses.split(" ");
                    } 
                } 
            } 
            {
                String gateways = p.readString();
                riljLog("responseSetupDataCall got gateways=" + gateways);
                {
                    boolean var851B476C40C2CFC5CF415FF73D1F92EC_1199086746 = (!TextUtils.isEmpty(gateways));
                    {
                        dataCall.gateways = gateways.split(" ");
                    } 
                } 
            } 
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response expecting 1 RIL_Data_Call_response_v5"
                        + " got " + num);
            } 
            dataCall = getDataCallState(p, ver);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1092405946 = dataCall;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1092405946.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1092405946;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.459 -0400", hash_original_method = "F2D5C4032BE6024B6126759412E50A01", hash_generated_method = "307971888C6822CEB294019D0EB8D824")
    private Object responseOperatorInfos(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_553421427 = null; 
        String strings[] = (String [])responseStrings(p);
        ArrayList<OperatorInfo> ret;
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got "
                + strings.length + " strings, expected multible of 4");
        } 
        ret = new ArrayList<OperatorInfo>(strings.length / 4);
        {
            int i = 0;
            i += 4;
            {
                ret.add (
                new OperatorInfo(
                    strings[i+0],
                    strings[i+1],
                    strings[i+2],
                    strings[i+3]));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_553421427 = ret;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_553421427.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_553421427;
        
        
        
        
            
                
                
        
        
        
            
                
                    
                    
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.462 -0400", hash_original_method = "E4123D5DA30749CB6D4FFE47F8C7BEAC", hash_generated_method = "D2C4901518E459B8EBB8A07355DCD175")
    private Object responseCellList(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_958751101 = null; 
        int num;
        int rssi;
        String location;
        ArrayList<NeighboringCellInfo> response;
        NeighboringCellInfo cell;
        num = p.readInt();
        response = new ArrayList<NeighboringCellInfo>();
        String radioString = SystemProperties.get(
               TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE, "unknown");
        int radioType;
        {
            boolean var968A11328ED5DD3D9A4D0157DF90DD59_469183543 = (radioString.equals("GPRS"));
            {
                radioType = NETWORK_TYPE_GPRS;
            } 
            {
                boolean varA1A3CAAABF34B78222EF834ECB712EBE_46221272 = (radioString.equals("EDGE"));
                {
                    radioType = NETWORK_TYPE_EDGE;
                } 
                {
                    boolean var281246F88355BADDC459CFA9135E481F_1818959117 = (radioString.equals("UMTS"));
                    {
                        radioType = NETWORK_TYPE_UMTS;
                    } 
                    {
                        boolean var3EAFEEE374799CED3C653463F8D1F789_514795370 = (radioString.equals("HSDPA"));
                        {
                            radioType = NETWORK_TYPE_HSDPA;
                        } 
                        {
                            boolean varA89604559FBE3A92D87A3C7FCC5B22A2_94254579 = (radioString.equals("HSUPA"));
                            {
                                radioType = NETWORK_TYPE_HSUPA;
                            } 
                            {
                                boolean varA181BEC579269E2127B9ABCD5D79305A_101619673 = (radioString.equals("HSPA"));
                                {
                                    radioType = NETWORK_TYPE_HSPA;
                                } 
                                {
                                    radioType = NETWORK_TYPE_UNKNOWN;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    rssi = p.readInt();
                    location = p.readString();
                    cell = new NeighboringCellInfo(rssi, location, radioType);
                    response.add(cell);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_958751101 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_958751101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_958751101;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.463 -0400", hash_original_method = "225C4A262B1740AD55FF47639121D5EF", hash_generated_method = "2CB3479B49FA1E7995541AA8F096B592")
    private Object responseGetPreferredNetworkType(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1890217367 = null; 
        int [] response = (int[]) responseInts(p);
        {
            mPreferredNetworkType = response[0];
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1890217367 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1890217367.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1890217367;
        
        
        
           
       
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.465 -0400", hash_original_method = "C459166A8880B065FE8A1B083AFDAF89", hash_generated_method = "1FEEAEF7523978C660275025168399BD")
    private Object responseGmsBroadcastConfig(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_433802338 = null; 
        int num;
        ArrayList<SmsBroadcastConfigInfo> response;
        SmsBroadcastConfigInfo info;
        num = p.readInt();
        response = new ArrayList<SmsBroadcastConfigInfo>(num);
        {
            int i = 0;
            {
                int fromId = p.readInt();
                int toId = p.readInt();
                int fromScheme = p.readInt();
                int toScheme = p.readInt();
                boolean selected = (p.readInt() == 1);
                info = new SmsBroadcastConfigInfo(fromId, toId, fromScheme,
                    toScheme, selected);
                response.add(info);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_433802338 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_433802338.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_433802338;
        
        
        
        
        
        
        
            
            
            
            
            
            
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.466 -0400", hash_original_method = "55259F8FDA4B0C41A34B6184E02D7C2F", hash_generated_method = "F90E5313C4391C4497B35D8CE75CC738")
    private Object responseCdmaBroadcastConfig(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_820938852 = null; 
        int numServiceCategories;
        int response[];
        numServiceCategories = p.readInt();
        {
            int numInts;
            numInts = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES * CDMA_BSI_NO_OF_INTS_STRUCT + 1;
            response = new int[numInts];
            response[0] = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES;
            {
                int i = 1;
                i += CDMA_BSI_NO_OF_INTS_STRUCT;
                {
                    response[i + 0] = i / CDMA_BSI_NO_OF_INTS_STRUCT;
                    response[i + 1] = 1;
                    response[i + 2] = 0;
                } 
            } 
        } 
        {
            int numInts;
            numInts = (numServiceCategories * CDMA_BSI_NO_OF_INTS_STRUCT) + 1;
            response = new int[numInts];
            response[0] = numServiceCategories;
            {
                int i = 1;
                {
                    response[i] = p.readInt();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_820938852 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_820938852.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_820938852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.467 -0400", hash_original_method = "90CED6467BA07D7B46A1F95705E3AC70", hash_generated_method = "1157F0DBDDC061983264C3B46482D3CA")
    private Object responseSignalStrength(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_802434447 = null; 
        int numInts = 12;
        int response[];
        response = new int[numInts];
        {
            int i = 0;
            {
                response[i] = p.readInt();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_802434447 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_802434447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_802434447;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.468 -0400", hash_original_method = "07F57EA5026D76F851755C6714CD7CB2", hash_generated_method = "F88D5AF949822F441F1B4FBD6EF54882")
    private ArrayList<CdmaInformationRecords> responseCdmaInformationRecord(Parcel p) {
        ArrayList<CdmaInformationRecords> varB4EAC82CA7396A68D541C85D26508E83_354049086 = null; 
        int numberOfInfoRecs;
        ArrayList<CdmaInformationRecords> response;
        numberOfInfoRecs = p.readInt();
        response = new ArrayList<CdmaInformationRecords>(numberOfInfoRecs);
        {
            int i = 0;
            {
                CdmaInformationRecords InfoRec = new CdmaInformationRecords(p);
                response.add(InfoRec);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_354049086 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_354049086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_354049086;
        
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.469 -0400", hash_original_method = "C7CB5D07451D489A78BF82365C5A0B27", hash_generated_method = "2AB0CD76DFE518323C452389CBACC1CF")
    private Object responseCdmaCallWaiting(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_305330423 = null; 
        CdmaCallWaitingNotification notification = new CdmaCallWaitingNotification();
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
        varB4EAC82CA7396A68D541C85D26508E83_305330423 = notification;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_305330423.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_305330423;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.470 -0400", hash_original_method = "F4EF6B3A014077C64691F0B8D26D4AED", hash_generated_method = "7839BF846862E85BCB86CE63D2C672ED")
    private Object responseCallRing(Parcel p) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1020315582 = null; 
        char response[] = new char[4];
        response[0] = (char) p.readInt();
        response[1] = (char) p.readInt();
        response[2] = (char) p.readInt();
        response[3] = (char) p.readInt();
        varB4EAC82CA7396A68D541C85D26508E83_1020315582 = response;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1020315582.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1020315582;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.472 -0400", hash_original_method = "04666C2E99832FCFAFCF388A68EF0610", hash_generated_method = "D95045EB0B491FE50FE767D2D79EC579")
    private void notifyRegistrantsCdmaInfoRec(CdmaInformationRecords infoRec) {
        int response = RIL_UNSOL_CDMA_INFO_REC;
        {
            {
                unsljLogRet(response, infoRec.record);
                mDisplayInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mSignalInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mNumberInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mRedirNumInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mLineControlInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mT53ClirInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } 
        } 
        {
            {
                unsljLogRet(response, infoRec.record);
                mT53AudCntrlInfoRegistrants.notifyRegistrants(
                       new AsyncResult (null, infoRec.record, null));
            } 
        } 
        addTaint(infoRec.getTaint());
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.474 -0400", hash_original_method = "513B160CE13530A75C92D2BB2C156FD7", hash_generated_method = "1DBAD6D542F25A57B4009829649F29CE")
    private void riljLog(String msg) {
        Log.d(LOG_TAG, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.475 -0400", hash_original_method = "709360DE622013B25C1B037A3416C3B6", hash_generated_method = "A6A9E98C2BCD8F608F27D186F899DF39")
    private void riljLogv(String msg) {
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.475 -0400", hash_original_method = "2B7AB7C6A9DFCD91149097CF23FA21DF", hash_generated_method = "B52B409C42158CA261942C6F070B75C4")
    private void unsljLog(int response) {
        riljLog("[UNSL]< " + responseToString(response));
        addTaint(response);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.476 -0400", hash_original_method = "B9D4DA0AB06082664757422C0E23F4B2", hash_generated_method = "C635E6F7126FC1A69EEAA186FAE030B4")
    private void unsljLogMore(int response, String more) {
        riljLog("[UNSL]< " + responseToString(response) + " " + more);
        addTaint(response);
        addTaint(more.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.476 -0400", hash_original_method = "02F7DA800ECB6E455062B2AF08D2856E", hash_generated_method = "F4EBD85BD05DB5C70A5F9939E8399949")
    private void unsljLogRet(int response, Object ret) {
        riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        addTaint(response);
        addTaint(ret.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.477 -0400", hash_original_method = "5479F9B9AF9D3C3FE7229BC789506755", hash_generated_method = "DD2481D70785482CAFBAC150AD419EF5")
    private void unsljLogvRet(int response, Object ret) {
        riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        addTaint(response);
        addTaint(ret.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.477 -0400", hash_original_method = "B8DB86D0D3DD2A6C87C6DBBEA17396A3", hash_generated_method = "E2D6CE368B86E4D96AFBF4211C843AB7")
    public void getDeviceIdentity(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.478 -0400", hash_original_method = "2F4B55F10DAACCDACB48694F0AD6C5FC", hash_generated_method = "A71567D3F3F273D110E88F09D6479D08")
    public void getCDMASubscription(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.478 -0400", hash_original_method = "CD84ED40ADC2BEFF960D6D373762CCB2", hash_generated_method = "F64182D4D087BC588BF19867130D35E1")
    @Override
    public void setPhoneType(int phoneType) {
        riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        mPhoneType = phoneType;
        addTaint(phoneType);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.479 -0400", hash_original_method = "849E6CD9CCE8F1ECF8BC959270B499A0", hash_generated_method = "1BFBC102445FC0589683EED153650C90")
    public void queryCdmaRoamingPreference(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.480 -0400", hash_original_method = "BC2979EAC0CBA90D634290B385917086", hash_generated_method = "5401ED3EF180B9EA46ACBA66B0470B46")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaRoamingType);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaRoamingType);
        send(rr);
        addTaint(cdmaRoamingType);
        addTaint(response.getTaint());
        
        
                
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.481 -0400", hash_original_method = "5B737D91D0E47D0010D2976568B23A82", hash_generated_method = "DAF05AA617542EC1890494DB86B911D6")
    public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaSubscription);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaSubscription);
        send(rr);
        addTaint(cdmaSubscription);
        addTaint(response.getTaint());
        
        
                
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.482 -0400", hash_original_method = "5EEECA9C4DAFB6EB7CE2420CACC9812C", hash_generated_method = "CB39E48E3340CC009330952B83E68F48")
    @Override
    public void getCdmaSubscriptionSource(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.483 -0400", hash_original_method = "116710C0DB0DC531DE694B6BC2F4AE2B", hash_generated_method = "77C83CB11D55DA33A74AA71F3D6FBD9B")
    public void queryTTYMode(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.483 -0400", hash_original_method = "0B5DA23B67CE8A881960D39226001892", hash_generated_method = "F4D07F6A267273C17FA2CD37DC88F117")
    public void setTTYMode(int ttyMode, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_TTY_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(ttyMode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + ttyMode);
        send(rr);
        addTaint(ttyMode);
        addTaint(response.getTaint());
        
        
                
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.485 -0400", hash_original_method = "9DB0667959C6184F19426DF0FB910315", hash_generated_method = "86696BE5A95A1CF83F6BBC6B9DF8AC5B")
    public void sendCDMAFeatureCode(String FeatureCode, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);
        rr.mp.writeString(FeatureCode);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + FeatureCode);
        send(rr);
        addTaint(FeatureCode.getTaint());
        addTaint(response.getTaint());
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.486 -0400", hash_original_method = "EB6E132144573DF781138A585850ED0A", hash_generated_method = "CB7238A60B5261477995B717E0004D6F")
    public void getCdmaBroadcastConfig(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);
        send(rr);
        addTaint(response.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.487 -0400", hash_original_method = "7AE57418607D61F0BA79FD2FF4F728AF", hash_generated_method = "E554B0BD905BB5AAA1B470B720AE562A")
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);
        {
            int i = 0;
            {
                rr.mp.writeInt(configValuesArray[i]);
            } 
        } 
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.488 -0400", hash_original_method = "41C22C7BD9DE14E15F4803649E353969", hash_generated_method = "D26C3A3DA87324DC06018A7EE6EDB6FA")
    public void setCdmaBroadcastActivation(boolean activate, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 :1);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(activate);
        addTaint(response.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.488 -0400", hash_original_method = "82BAE0E7FF72D1A409D61F03DD8EFEA2", hash_generated_method = "811E437108F6928A6981792C76629CF1")
    public void exitEmergencyCallbackMode(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(response.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.489 -0400", hash_original_method = "381EF137384490D69DA50E927DA4C209", hash_generated_method = "1C61D011AB27AFE0D4F7A65187CC9142")
    public void requestIsimAuthentication(String nonce, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);
        rr.mp.writeString(nonce);
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        addTaint(nonce.getTaint());
        addTaint(response.getTaint());
        
        
        
        
        
    }

    
    class RILSender extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.489 -0400", hash_original_field = "99EC5806475395530F37CCDC6DD85CE7", hash_generated_field = "D1362109E83ED4221773106790FD549F")

        byte[] dataLength = new byte[4];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.489 -0400", hash_original_method = "4D17817439BCC34837C575257CF9147F", hash_generated_method = "29FB6336B11BB21F807AB588DD6B15C1")
        public  RILSender(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.490 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.491 -0400", hash_original_method = "D25DB5A43D9B976C2A2C198EC34CFB08", hash_generated_method = "BE8DC22AC7511A6FC0C37A6AD43EB7B3")
        @Override
        public void handleMessage(Message msg) {
            RILRequest rr = (RILRequest)(msg.obj);
            RILRequest req = null;
            
            boolean alreadySubtracted = false;
            
            
            try 
            {
                LocalSocket s;
                s = mSocket;
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
                    alreadySubtracted = true;
                } 
                {
                    mRequestsList.add(rr);
                } 
                alreadySubtracted = true;
                byte[] data;
                data = rr.mp.marshall();
                rr.mp.recycle();
                rr.mp = null;
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                    "Parcel larger than max bytes allowed! "
                                                          + data.length);
                } 
                dataLength[0] = dataLength[1] = 0;
                dataLength[2] = (byte)((data.length >> 8) & 0xff);
                dataLength[3] = (byte)((data.length) & 0xff);
                s.getOutputStream().write(dataLength);
                s.getOutputStream().write(data);
            } 
            catch (IOException ex)
            {
                req = findAndRemoveRequestFromList(rr.mSerial);
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
                } 
            } 
            catch (RuntimeException exc)
            {
                req = findAndRemoveRequestFromList(rr.mSerial);
                {
                    rr.onError(GENERIC_FAILURE, null);
                    rr.release();
                } 
            } 
            finally 
            {
                releaseWakeLockIfDone();
            } 
            
            
            {
                {
                    boolean var9A4CAC6617AE0A733634FB069C49B2EA_2134769971 = (mWakeLock.isHeld());
                    {
                        {
                            Log.d(LOG_TAG, "NOTE: mReqWaiting is NOT 0 but"
                                        + mRequestMessagesWaiting + " at TIMEOUT, reset!"
                                        + " There still msg waitng for response");
                            mRequestMessagesWaiting = 0;
                            {
                                {
                                    int count = mRequestsList.size();
                                    Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                                                " mRequestList=" + count);
                                    {
                                        int i = 0;
                                        {
                                            rr = mRequestsList.get(i);
                                            Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] "
                                                    + requestToString(rr.mRequest));
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            mRequestMessagesPending = 0;
                        } 
                        mWakeLock.release();
                    } 
                } 
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    class RILReceiver implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.491 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

        byte[] buffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.492 -0400", hash_original_method = "AEB7D4EC0C0D3B29B57F76734A093487", hash_generated_method = "832D356F5AA3BF59D3700679E90409AE")
          RILReceiver() {
            buffer = new byte[RIL_MAX_COMMAND_BYTES];
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_method = "3E25FFC0D00CEB4B0CF0C518A51DB777", hash_generated_method = "1D2F2B3DB4C351B325B9B6C35ACFC438")
        public void run() {
            int retryCount = 0;
            try 
            {
                {
                    LocalSocket s = null;
                    LocalSocketAddress l;
                    try 
                    {
                        s = new LocalSocket();
                        l = new LocalSocketAddress(SOCKET_NAME_RIL,
                            LocalSocketAddress.Namespace.RESERVED);
                        s.connect(l);
                    } 
                    catch (IOException ex)
                    {
                        try 
                        {
                            {
                                s.close();
                            } 
                        } 
                        catch (IOException ex2)
                        { }
                        try 
                        {
                            Thread.sleep(SOCKET_OPEN_RETRY_MILLIS);
                        } 
                        catch (InterruptedException er)
                        { }
                    } 
                    retryCount = 0;
                    mSocket = s;
                    int length = 0;
                    try 
                    {
                        InputStream is = mSocket.getInputStream();
                        {
                            Parcel p;
                            length = readRilMessage(is, buffer);
                            p = Parcel.obtain();
                            p.unmarshall(buffer, 0, length);
                            p.setDataPosition(0);
                            processResponse(p);
                            p.recycle();
                        } 
                    } 
                    catch (java.io.IOException ex)
                    { }
                    catch (Throwable tr)
                    { }
                    setRadioState (RadioState.RADIO_UNAVAILABLE);
                    try 
                    {
                        mSocket.close();
                    } 
                    catch (IOException ex)
                    { }
                    mSocket = null;
                    RILRequest.resetSerial();
                    clearRequestsList(RADIO_NOT_AVAILABLE, false);
                } 
            } 
            catch (Throwable tr)
            { }
            notifyRegistrantsRilConnectionChanged(-1);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "97BCE9C97BFBAA0A5C9DFC01C512C8DD", hash_generated_field = "E8AEBB7BC1E8DE7102DD065D634CC293")

    static final boolean RILJ_LOGD = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "F756B39DA24610C6F147A03CB86C32C2", hash_generated_field = "0C6948A169D6E1D2E1ADEB0F80785D40")

    static final boolean RILJ_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "6E111A082683CFC823505D73C04427F7", hash_generated_field = "571245F8DE39B2C924A36FAE73EBBA44")

    private static final int DEFAULT_WAKE_LOCK_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "08D692F77DFF6777C68397D86FEB9673", hash_generated_field = "EAFA57C607FF50983754A1B1A1DB0736")

    static final int EVENT_SEND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "57F4D6DC61899A880DD9EEDBA4F80E99", hash_generated_field = "6A179A477F6E9E6E9040DC18977E01CB")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "02403D71B4446414F4F3E9A28C344489", hash_generated_field = "A95740DBA07261E1CEACA3FF20211052")

    static final int RIL_MAX_COMMAND_BYTES = (8 * 1024);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "0838500EAFB49E0F91ECEFAAF400CACC", hash_generated_field = "7A9920177945AAD6E3BDD930CB1D5FDA")

    static final int RESPONSE_SOLICITED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "8186BFE56666A15DDA7631C9969B8ECA", hash_generated_field = "F7189327FBCA5256349AE6998692EE59")

    static final int RESPONSE_UNSOLICITED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "631DB341385DA34F9C870222FFCB6E51", hash_generated_field = "66495E17EC0A0057CA4BC33F77ACB85F")

    static final String SOCKET_NAME_RIL = "rild";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "8743C5F3EB20F43B4A7B1384E1EE0BAB", hash_generated_field = "0C3577BF4F60D2979C4EC6F1261A00D0")

    static final int SOCKET_OPEN_RETRY_MILLIS = 4 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.494 -0400", hash_original_field = "FFFA1391A6C60617637A5396E1A930EF", hash_generated_field = "B2ADEC73809EA29CBEB65E83BD1B055F")

    private static final int CDMA_BSI_NO_OF_INTS_STRUCT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.495 -0400", hash_original_field = "75B7020754749B8753BB0C8AD8761874", hash_generated_field = "8AC0B7212834068F171EE2AA5B80B5F8")

    private static final int CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES = 31;
}

