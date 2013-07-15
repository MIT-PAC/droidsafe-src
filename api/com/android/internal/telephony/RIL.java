package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_field = "8CC0BA4F3132C785BD42D542F7CA8632", hash_generated_field = "2C995DC68A290AA0E91A0F8065297DF6")

    int mSerial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_field = "6F4B92891660455681591E8ACE541D68", hash_generated_field = "6C368ED9CE82768FD0B5A0D34D844F82")

    int mRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "275BCCDB24FCA985A62252086534EA41")

    Message mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_field = "1F2DFA567DCF95833EDDF7AEC167FEC7", hash_generated_field = "EEF79C3D9374B5C2140B6DF15C81B0D3")

    Parcel mp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "64C9DCC5A15FF3A81952EE0FF77BF4DE")

    RILRequest mNext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.915 -0400", hash_original_method = "9C4E8F6E2A10EF2C06F20638ED2CBC6D", hash_generated_method = "560681FC445F3861C142757487DA3B91")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_method = "E7EE736E24A2BE53AC107C249FFB0880", hash_generated_method = "0691A91AC44CFDEADBCBC5569F7616DE")
     void release() {
        synchronized
(sPoolSync)        {
    if(sPoolSize < MAX_POOL_SIZE)            
            {
                this.mNext = sPool;
                sPool = this;
                sPoolSize++;
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

    
        @DSModeled(DSC.SAFE)
    static void resetSerial() {
        synchronized(sSerialMonitor) {
            sNextSerial = 0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_method = "9C13ECBB4C9B57CD7FC06025C6091C8F", hash_generated_method = "34B4EB92B7B9FA743F0DAB42E65E94F0")
     String serialString() {
        StringBuilder sb = new StringBuilder(8);
        String sn;
        sn = Integer.toString(mSerial);
        sb.append('[');
for(int i = 0, s = sn.length();i < 4 - s;i++)
        {
            sb.append('0');
        } //End block
        sb.append(sn);
        sb.append(']');
String var2460B846747F8B22185AD8BE722266A5_1974223292 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1974223292.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1974223292;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_method = "DAF6125A6A3BAA8EA4AAF17920DB80E6", hash_generated_method = "DA50EEA5657715DE753BDECA72EE0201")
     void onError(int error, Object ret) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ret.getTaint());
        addTaint(error);
        CommandException ex;
        ex = CommandException.fromRilErrno(error);
    if(RIL.RILJ_LOGD)        
        Log.d(LOG_TAG, serialString() + "< "
            + RIL.requestToString(mRequest)
            + " error: " + ex);
    if(mResult != null)        
        {
            AsyncResult.forMessage(mResult, ret, ex);
            mResult.sendToTarget();
        } //End block
    if(mp != null)        
        {
            mp.recycle();
            mp = null;
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "5427C798EA4BCDD653BC3E19DA14EDA3", hash_generated_field = "4648C36C9B39D123F3C2DC203738A8FE")

    static int sNextSerial = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "0470E9F275C220FB347853BB1394F8E2", hash_generated_field = "A7E278FEB1EC2BFEA3ED505503B40F1D")

    static Object sSerialMonitor = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "8885194D9D2ADA6648AB65C43BA7A18A")

    private static Object sPoolSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "E6E7B1EE519E99449DC5CFD28949053E", hash_generated_field = "29AEB546B72810AE137F2724EB8AC46F")

    private static RILRequest sPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.916 -0400", hash_original_field = "F95B54369A4D6DB4C3ACF86CE99D31FA", hash_generated_field = "E10F8FF6B26141CA5E230C0B750B2798")

    private static final int MAX_POOL_SIZE = 4;
}

public final class RIL extends BaseCommands implements CommandsInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "6971E2A0D3E5B2508308ACDF0894CC71")

    LocalSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "D98DF8D8C44F237131E3131E7D96BB06", hash_generated_field = "447BDB484814847833708DAC5CD0741B")

    HandlerThread mSenderThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "96F4E0D75276B088A94548BBA71042AB", hash_generated_field = "F824B77C4D08BC410F85653F55DB5D17")

    RILSender mSender;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "C42E57035DC58A8EF93627DAE705E4EB", hash_generated_field = "4C5A8172CA27A059D229944DFD840114")

    Thread mReceiverThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "B718778FEA0061AFBE714CC16C50488E")

    RILReceiver mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "C3E41FC6371E803E2DA98F1EFF9EF47B", hash_generated_field = "102A8E8B4FA31B396B477F22D2A32DA8")

    int mWakeLockTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "DFF633BBB29FA60E5096BC022C074C8C", hash_generated_field = "9200B1A2FDF04FDBA9EA6DB75F97F5C2")

    int mRequestMessagesPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "8792B45034366F06E89F0CF7947B7575", hash_generated_field = "2A0F03062FAF4047F837E853AF898D37")

    int mRequestMessagesWaiting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.917 -0400", hash_original_field = "57D356D53799C83A82E9E7DBBDB489EF", hash_generated_field = "A8E052F302542BDDE893942D71524913")

    ArrayList<RILRequest> mRequestsList = new ArrayList<RILRequest>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.918 -0400", hash_original_field = "7A74E6AA0A9A2FF1A7B6935083BAFD8F", hash_generated_field = "DD6FA850B0C2512C103BBC579CD52D51")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.918 -0400", hash_original_field = "D41C93A29A8110B1E773EFFE673A66AE", hash_generated_field = "517EE6BA92CA6D3C16C0F4FDDB025C17")

    private int mSetPreferredNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.919 -0400", hash_original_method = "57415555D3C32D9CF1C37CD62128114E", hash_generated_method = "46B145C5138569BCC11BD5CF71A2EBD3")
    public  RIL(Context context, int preferredNetworkType, int cdmaSubscription) {
        super(context);
        addTaint(cdmaSubscription);
        addTaint(preferredNetworkType);
        addTaint(context.getTaint());
    if(RILJ_LOGD)        
        {
            riljLog("RIL(context, preferredNetworkType=" + preferredNetworkType +
                    " cdmaSubscription=" + cdmaSubscription + ")");
        } //End block
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
    if(cm.isNetworkSupported(ConnectivityManager.TYPE_MOBILE) == false)        
        {
            riljLog("Not starting RILReceiver: wifi-only");
        } //End block
        else
        {
            riljLog("Starting RILReceiver");
            mReceiver = new RILReceiver();
            mReceiverThread = new Thread(mReceiver, "RILReceiver");
            mReceiverThread.start();
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            context.registerReceiver(mIntentReceiver, filter);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.919 -0400", hash_original_method = "9505EC70575F3F081B82639224A26C6E", hash_generated_method = "443450A329CA9792DED812D3E399C489")
    @Override
    public void setOnNITZTime(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        super.setOnNITZTime(h, what, obj);
    if(mLastNITZTimeInfo != null)        
        {
            mNITZTimeRegistrant
                .notifyRegistrant(
                    new AsyncResult (null, mLastNITZTimeInfo, null));
            mLastNITZTimeInfo = null;
        } //End block
        // ---------- Original Method ----------
        //super.setOnNITZTime(h, what, obj);
        //if (mLastNITZTimeInfo != null) {
            //mNITZTimeRegistrant
                //.notifyRegistrant(
                    //new AsyncResult (null, mLastNITZTimeInfo, null));
            //mLastNITZTimeInfo = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.920 -0400", hash_original_method = "9A7EB00CD2404F3C288A75EFD9E4A220", hash_generated_method = "30625449A2D6202D8F07172E5DAAEE74")
    public void getIccCardStatus(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.920 -0400", hash_original_method = "A64490CEA7617DBF7C16959DD443F320", hash_generated_method = "E9804062D3D9BDD3EC45742AA2383D74")
    @Override
    public void supplyIccPin(String pin, Message result) {
        addTaint(result.getTaint());
        addTaint(pin.getTaint());
        supplyIccPinForApp(pin, null, result);
        // ---------- Original Method ----------
        //supplyIccPinForApp(pin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.920 -0400", hash_original_method = "292CEACE366769BDA48EB6300D49BD27", hash_generated_method = "12C7228081714BB37AD26D68B7BEA765")
    @Override
    public void supplyIccPinForApp(String pin, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(pin.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(2);
        //rr.mp.writeString(pin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.920 -0400", hash_original_method = "EDD0A15F8BC2322B300440A8148B03FB", hash_generated_method = "FE216EC3484D8F22963FE2D1D6E57993")
    @Override
    public void supplyIccPuk(String puk, String newPin, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin.getTaint());
        addTaint(puk.getTaint());
        supplyIccPukForApp(puk, newPin, null, result);
        // ---------- Original Method ----------
        //supplyIccPukForApp(puk, newPin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.921 -0400", hash_original_method = "1780B25BC715F62B7E7B76DC76BDB7F8", hash_generated_method = "7E447736EC3CBDC945AC31A6BFF2C54D")
    @Override
    public void supplyIccPukForApp(String puk, String newPin, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin.getTaint());
        addTaint(puk.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(puk);
        //rr.mp.writeString(newPin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.921 -0400", hash_original_method = "8076AE95CA0491033B7A3B1FDB27A00D", hash_generated_method = "3008C54518D638B6174472A8B0726109")
    @Override
    public void supplyIccPin2(String pin, Message result) {
        addTaint(result.getTaint());
        addTaint(pin.getTaint());
        supplyIccPin2ForApp(pin, null, result);
        // ---------- Original Method ----------
        //supplyIccPin2ForApp(pin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.921 -0400", hash_original_method = "2364DF46EB4F312709574B2C726226B0", hash_generated_method = "E588C303F771FA3CFCF53D9B220C360F")
    @Override
    public void supplyIccPin2ForApp(String pin, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(pin.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(2);
        //rr.mp.writeString(pin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.921 -0400", hash_original_method = "02C50C8BAA9C120A4383EA48E4CE9EF9", hash_generated_method = "48B09417659E5D8F76596C24058B4B8E")
    @Override
    public void supplyIccPuk2(String puk2, String newPin2, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(puk2.getTaint());
        supplyIccPuk2ForApp(puk2, newPin2, null, result);
        // ---------- Original Method ----------
        //supplyIccPuk2ForApp(puk2, newPin2, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.921 -0400", hash_original_method = "16881D0ACCF987B6F55F1477C7A8AF2E", hash_generated_method = "E2214803B53BCF5AA43D05CC65575A6D")
    @Override
    public void supplyIccPuk2ForApp(String puk, String newPin2, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(puk.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(puk);
        //rr.mp.writeString(newPin2);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.922 -0400", hash_original_method = "E5801ABF4ED976E8B47A9DC4E0EF9FFC", hash_generated_method = "17E33B763005F1D48074BDE07939DB09")
    @Override
    public void changeIccPin(String oldPin, String newPin, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin.getTaint());
        addTaint(oldPin.getTaint());
        changeIccPinForApp(oldPin, newPin, null, result);
        // ---------- Original Method ----------
        //changeIccPinForApp(oldPin, newPin, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.922 -0400", hash_original_method = "FB6D60EEFAF19AC3A68522374AFE5A34", hash_generated_method = "3EABB048650B0F1FCA854067BF27C8E6")
    @Override
    public void changeIccPinForApp(String oldPin, String newPin, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin.getTaint());
        addTaint(oldPin.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(oldPin);
        //rr.mp.writeString(newPin);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.922 -0400", hash_original_method = "09C1A469DD89C445C72DC064DAF532C6", hash_generated_method = "DE10FD89CD999F6E51BF837F344A1068")
    @Override
    public void changeIccPin2(String oldPin2, String newPin2, Message result) {
        addTaint(result.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(oldPin2.getTaint());
        changeIccPin2ForApp(oldPin2, newPin2, null, result);
        // ---------- Original Method ----------
        //changeIccPin2ForApp(oldPin2, newPin2, null, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "5CD184F5005892F6A2376DA12B8940E7", hash_generated_method = "22B8E5D9FC52DCE48AFA90D937606C3C")
    @Override
    public void changeIccPin2ForApp(String oldPin2, String newPin2, String aid, Message result) {
        addTaint(result.getTaint());
        addTaint(aid.getTaint());
        addTaint(newPin2.getTaint());
        addTaint(oldPin2.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin2);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(oldPin2);
        //rr.mp.writeString(newPin2);
        //rr.mp.writeString(aid);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "DCA3B69D42E061A95FB4470FAF19888E", hash_generated_method = "86BDCB59ECE350AB7CFF22DA3A33B01E")
    public void changeBarringPassword(String facility, String oldPwd, String newPwd, Message result) {
        addTaint(result.getTaint());
        addTaint(newPwd.getTaint());
        addTaint(oldPwd.getTaint());
        addTaint(facility.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(3);
        rr.mp.writeString(facility);
        rr.mp.writeString(oldPwd);
        rr.mp.writeString(newPwd);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(3);
        //rr.mp.writeString(facility);
        //rr.mp.writeString(oldPwd);
        //rr.mp.writeString(newPwd);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "FD9166E53C98E732567F842FC6265121", hash_generated_method = "91F54AEF13A00056442D8B0B59EC3F57")
    public void supplyNetworkDepersonalization(String netpin, Message result) {
        addTaint(result.getTaint());
        addTaint(netpin.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(1);
        rr.mp.writeString(netpin);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeInt(1);
        //rr.mp.writeString(netpin);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "6F2937ACBD34EE8D8FEF57D35663AFCC", hash_generated_method = "815435CBBF3D078CE97A4563CFAC3146")
    public void getCurrentCalls(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "A1D311E0B227CABB8D0707A1650659D2", hash_generated_method = "D9962A8775AA310C226D66075745BBF2")
    @Deprecated
    public void getPDPContextList(Message result) {
        addTaint(result.getTaint());
        getDataCallList(result);
        // ---------- Original Method ----------
        //getDataCallList(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "68CF653DB375A3C63D89D09DBB57244C", hash_generated_method = "8D3C087903AF4A4C426F4244C0F0DE67")
    public void getDataCallList(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.923 -0400", hash_original_method = "85029AD0E77EFB7E7AAB9535BAB079D4", hash_generated_method = "CE6F5DD322E777AC185225758B489EEA")
    public void dial(String address, int clirMode, Message result) {
        addTaint(result.getTaint());
        addTaint(clirMode);
        addTaint(address.getTaint());
        dial(address, clirMode, null, result);
        // ---------- Original Method ----------
        //dial(address, clirMode, null, result);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.924 -0400", hash_original_method = "2937351315DD22A0DBB0EBEECB6FBD52", hash_generated_method = "FDDA31EE81B53F3785EB34532F2A2208")
    public void dial(String address, int clirMode, UUSInfo uusInfo, Message result) {
        addTaint(result.getTaint());
        addTaint(uusInfo.getTaint());
        addTaint(clirMode);
        addTaint(address.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DIAL, result);
        rr.mp.writeString(address);
        rr.mp.writeInt(clirMode);
        rr.mp.writeInt(0);
    if(uusInfo == null)        
        {
            rr.mp.writeInt(0);
        } //End block
        else
        {
            rr.mp.writeInt(1);
            rr.mp.writeInt(uusInfo.getType());
            rr.mp.writeInt(uusInfo.getDcs());
            rr.mp.writeByteArray(uusInfo.getUserData());
        } //End block
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.924 -0400", hash_original_method = "DCABA764531B1065D0038AAAD031BA27", hash_generated_method = "789575E92720948A4D3F31078C6156B1")
    public void getIMSI(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.924 -0400", hash_original_method = "4D0F2CCF9960CC448C13E6CB3F3B5DE4", hash_generated_method = "8CDD893DC8B8E6088C80601BF6EA7C57")
    public void getIMEI(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.924 -0400", hash_original_method = "149F0748B48493B8EA1EFEBB8389549A", hash_generated_method = "C6513D2EDFD0F1884DB736C31B840C56")
    public void getIMEISV(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.924 -0400", hash_original_method = "7905AFC17F454606777953D509A8D53A", hash_generated_method = "E7B24869CDCEBE2652BA3DAB9E56468F")
    public void hangupConnection(int gsmIndex, Message result) {
        addTaint(result.getTaint());
        addTaint(gsmIndex);
    if(RILJ_LOGD)        
        riljLog("hangupConnection: gsmIndex=" + gsmIndex);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("hangupConnection: gsmIndex=" + gsmIndex);
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                //gsmIndex);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(gsmIndex);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "85440FD9AE077A395C6F94573FB9B35A", hash_generated_method = "409B0F0B56A42C4B1382A09D5CA688A5")
    public void hangupWaitingOrBackground(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "7CE301AE0A34FEB3B57BD0350A2D5E6A", hash_generated_method = "86362114719EEACA942021C30E9B286F")
    public void hangupForegroundResumeBackground(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(
                        RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(
                        //RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "D308C1E0C4F8D94B5EF5B2D9D0D36F66", hash_generated_method = "35CDAC6D788BF4ABF85619993FDEA875")
    public void switchWaitingOrHoldingAndActive(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(
                        RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(
                        //RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        //result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "E472C7A7FA5FA1FA68AAF1D140E0BD67", hash_generated_method = "D4B13DF876D25333D09C933859C0479E")
    public void conference(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "B803BD13961A7A2F16F3119AE2CBAC6F", hash_generated_method = "7B6FA58210678DCC348C8B829BA3D853")
    public void setPreferredVoicePrivacy(boolean enable, Message result) {
        addTaint(result.getTaint());
        addTaint(enable);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1:0);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                //result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1:0);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "3E434E6C0C8E17A9191C0565807B19D8", hash_generated_method = "6B5530921FD5DE3A1EC113CD210FAFC9")
    public void getPreferredVoicePrivacy(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                //result);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "4B8D613904DEDF72212F0EB9A1BF349B", hash_generated_method = "5C04C26B11FC0E5799A9DB57F3AF94B5")
    public void separateConnection(int gsmIndex, Message result) {
        addTaint(result.getTaint());
        addTaint(gsmIndex);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + gsmIndex);
        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + gsmIndex);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(gsmIndex);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "8CB5CF57551B01694681D1FE4B325AA7", hash_generated_method = "4A73EFEA31AB335D77F1F06C319F6A99")
    public void acceptCall(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ANSWER, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_ANSWER, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.925 -0400", hash_original_method = "2E92E83F2C082778F7F377F259918641", hash_generated_method = "5AAF02DC4B839EF820842F781FE9CA75")
    public void rejectCall(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_UDUB, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_UDUB, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "4490A3E422842C7946255FFDE06D02C6", hash_generated_method = "E71D9BACFA8EC10CF52F77A148022B62")
    public void explicitCallTransfer(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "286D2CDF105911EDAA78CDFFAADE2FB4", hash_generated_method = "EC62A008487CC961C92A033E2F8EC102")
    public void getLastCallFailCause(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "E839391FA5F4E8371F0D2466E996CFDA", hash_generated_method = "2FF70CB6EF9A23F850645FFD610C0399")
    public void getLastPdpFailCause(Message result) {
        addTaint(result.getTaint());
        getLastDataCallFailCause (result);
        // ---------- Original Method ----------
        //getLastDataCallFailCause (result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "367089EF39FE579C6BCEE97FCB3E914B", hash_generated_method = "5A58A450FEF1E4E81208C0F6DE915557")
    public void getLastDataCallFailCause(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "350AC1F658DA4E0097EF1D14A3117454", hash_generated_method = "CF02A19F30985B7706C1ADB6826B2D53")
    public void setMute(boolean enableMute, Message response) {
        addTaint(response.getTaint());
        addTaint(enableMute);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + enableMute);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enableMute ? 1 : 0);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + enableMute);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enableMute ? 1 : 0);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "B42AC6EC10626260A88AA941D9E9F704", hash_generated_method = "8960546695E3F8D0A1B026058B98C02B")
    public void getMute(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "16BB78D78D9B012F64B70344D11CBBD0", hash_generated_method = "5FEC8624499B7E1518188211739D47D5")
    public void getSignalStrength(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "CD1D773750E577C45A4986B8D31A3404", hash_generated_method = "A89363DF2811DF8B9EDB3633A7DDD3B6")
    public void getVoiceRegistrationState(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.926 -0400", hash_original_method = "A42E908B0E0EAE7E9677D8B8370610F9", hash_generated_method = "E510D020C558AC44D31C169752E88D12")
    public void getDataRegistrationState(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.927 -0400", hash_original_method = "F3EF4D956FA5FB9BDF6C62381BC62F41", hash_generated_method = "2769135470DF2AB141CB968B2456734C")
    public void getOperator(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OPERATOR, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OPERATOR, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.927 -0400", hash_original_method = "3D70E9C0BFE2429BE8FC0BF7A1D59B4A", hash_generated_method = "053DB19F6EBF59ED0E42E0086F02E778")
    public void sendDtmf(char c, Message result) {
        addTaint(result.getTaint());
        addTaint(c);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(Character.toString(c));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.927 -0400", hash_original_method = "BAA741C14C9F73BEA8C72D4011D64DC0", hash_generated_method = "B28E11935F6AE0587D9F2894094756FF")
    public void startDtmf(char c, Message result) {
        addTaint(result.getTaint());
        addTaint(c);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF_START, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(Character.toString(c));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF_START, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(Character.toString(c));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.927 -0400", hash_original_method = "C4D329464DB2A188FDA1049FC1B5C820", hash_generated_method = "0FB12846E7655FE05213B957AC71813B")
    public void stopDtmf(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.928 -0400", hash_original_method = "AF9E26B6734BDEC93AE44BA0DF8E2C9A", hash_generated_method = "F96BACD5F99829DEABA7E980EB5B0F1A")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message result) {
        addTaint(result.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BURST_DTMF, result);
        rr.mp.writeInt(3);
        rr.mp.writeString(dtmfString);
        rr.mp.writeString(Integer.toString(on));
        rr.mp.writeString(Integer.toString(off));
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + dtmfString);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.928 -0400", hash_original_method = "6216EB8701D12EFA1EABB572C0722209", hash_generated_method = "0B7FE7AC4C17CD07F70A24B5C7090B6D")
    public void sendSMS(String smscPDU, String pdu, Message result) {
        addTaint(result.getTaint());
        addTaint(pdu.getTaint());
        addTaint(smscPDU.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(smscPDU);
        rr.mp.writeString(pdu);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);
        //rr.mp.writeInt(2);
        //rr.mp.writeString(smscPDU);
        //rr.mp.writeString(pdu);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.929 -0400", hash_original_method = "B6146A457115D22EC1FC450C9E047949", hash_generated_method = "F0D339F022AA48F7409BA21B7A0B9A47")
    public void sendCdmaSms(byte[] pdu, Message result) {
        addTaint(result.getTaint());
        addTaint(pdu[0]);
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
for(int i=0;i < address_nbr_of_digits;i++)
            {
                rr.mp.writeByte(dis.readByte());
            } //End block
            rr.mp.writeInt(dis.read());
            rr.mp.writeByte((byte) dis.read());
            subaddr_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) subaddr_nbr_of_digits);
for(int i=0;i < subaddr_nbr_of_digits;i++)
            {
                rr.mp.writeByte(dis.readByte());
            } //End block
            bearerDataLength = dis.read();
            rr.mp.writeInt(bearerDataLength);
for(int i=0;i < bearerDataLength;i++)
            {
                rr.mp.writeByte(dis.readByte());
            } //End block
        } //End block
        catch (IOException ex)
        {
    if(RILJ_LOGD)            
            riljLog("sendSmsCdma: conversion from input stream to object failed: "
                    + ex);
        } //End block
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.929 -0400", hash_original_method = "33AA1BF497C1DD92CFF4D18BA36EE77C", hash_generated_method = "DAF31E637FF4AFA98BF13C15AB5E664B")
    public void deleteSmsOnSim(int index, Message response) {
        addTaint(response.getTaint());
        addTaint(index);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DELETE_SMS_ON_SIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
    if(false)        
        {
    if(RILJ_LOGD)            
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } //End block
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.929 -0400", hash_original_method = "AADBC281C1547D2CD40AF49A4F15439D", hash_generated_method = "4F4457F0B30D0598251250CEE1A6BB08")
    public void deleteSmsOnRuim(int index, Message response) {
        addTaint(response.getTaint());
        addTaint(index);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM,
                response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(index);
    if(false)        
        {
    if(RILJ_LOGD)            
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        } //End block
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.930 -0400", hash_original_method = "371A972FE084C98FCAE13C1996429D8F", hash_generated_method = "CDB1A54C25A5D76BBA90A4A64839788C")
    public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        addTaint(response.getTaint());
        addTaint(pdu.getTaint());
        addTaint(smsc.getTaint());
        addTaint(status);
        status = translateStatus(status);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_WRITE_SMS_TO_SIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        rr.mp.writeString(smsc);
    if(false)        
        {
    if(RILJ_LOGD)            
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } //End block
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.930 -0400", hash_original_method = "05C70D9FCCFAC2D0EDAAC7E4EA19DFB0", hash_generated_method = "6A4042992805B117FFAFED2E63BF1751")
    public void writeSmsToRuim(int status, String pdu, Message response) {
        addTaint(response.getTaint());
        addTaint(pdu.getTaint());
        addTaint(status);
        status = translateStatus(status);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM,
                response);
        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
    if(false)        
        {
    if(RILJ_LOGD)            
            riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        } //End block
        send(rr);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.930 -0400", hash_original_method = "0D77FBD1C1F349CB6A533B80F899FC6F", hash_generated_method = "4E17B94F15925F1F87577239BBF6E1F7")
    private int translateStatus(int status) {
        addTaint(status);
switch(status & 0x7){
        case SmsManager.STATUS_ON_ICC_READ:
        int varC4CA4238A0B923820DCC509A6F75849B_943919449 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023953676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023953676;
        case SmsManager.STATUS_ON_ICC_UNREAD:
        int varCFCD208495D565EF66E7DFF9F98764DA_1377415216 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191526038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191526038;
        case SmsManager.STATUS_ON_ICC_SENT:
        int varECCBC87E4B5CE2FE28308FD9F2A7BAF3_1805501021 = (3);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438783568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438783568;
        case SmsManager.STATUS_ON_ICC_UNSENT:
        int varC81E728D9D4C2F636F067F89CC14862C_569346723 = (2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686064001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686064001;
}        int varC4CA4238A0B923820DCC509A6F75849B_757431988 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769507538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769507538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.931 -0400", hash_original_method = "9997727B0C7061EF37C7F5F20BA491DC", hash_generated_method = "6B5BAEDF7DC1BAF872670D9C9E4E739C")
    public void setupDataCall(String radioTechnology, String profile, String apn,
            String user, String password, String authType, String protocol,
            Message result) {
        addTaint(result.getTaint());
        addTaint(protocol.getTaint());
        addTaint(authType.getTaint());
        addTaint(password.getTaint());
        addTaint(user.getTaint());
        addTaint(apn.getTaint());
        addTaint(profile.getTaint());
        addTaint(radioTechnology.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SETUP_DATA_CALL, result);
        rr.mp.writeInt(7);
        rr.mp.writeString(radioTechnology);
        rr.mp.writeString(profile);
        rr.mp.writeString(apn);
        rr.mp.writeString(user);
        rr.mp.writeString(password);
        rr.mp.writeString(authType);
        rr.mp.writeString(protocol);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + " " + radioTechnology + " "
                + profile + " " + apn + " " + user + " "
                + password + " " + authType + " " + protocol);
        send(rr);
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.931 -0400", hash_original_method = "7ACA8E6FBBE8E5A758B0F14E8B7A1BD0", hash_generated_method = "BC6CE9AA15F61739629ED679B2ECB065")
    public void deactivateDataCall(int cid, int reason, Message result) {
        addTaint(result.getTaint());
        addTaint(reason);
        addTaint(cid);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEACTIVATE_DATA_CALL, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(Integer.toString(cid));
        rr.mp.writeString(Integer.toString(reason));
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " +
                requestToString(rr.mRequest) + " " + cid + " " + reason);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.931 -0400", hash_original_method = "EB783AFA41C6889D4897D81BF3D72432", hash_generated_method = "80F9A3A646407F1FEF51BAFD49F97C15")
    public void setRadioPower(boolean on, Message result) {
        addTaint(result.getTaint());
        addTaint(on);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_RADIO_POWER, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
    if(RILJ_LOGD)        
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + (on ? " on" : " off"));
        } //End block
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.931 -0400", hash_original_method = "20525E4C07E2BDDC8598F4A8A0A24AAC", hash_generated_method = "72757BABD3322727A49FC53F5E3E69D5")
    public void setSuppServiceNotifications(boolean enable, Message result) {
        addTaint(result.getTaint());
        addTaint(enable);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.932 -0400", hash_original_method = "2FD7CAC0F0B66293984C61A06F9D6871", hash_generated_method = "399B8EEE39AB09EDCFA163A0C801CEE4")
    public void acknowledgeLastIncomingGsmSms(boolean success, int cause, Message result) {
        addTaint(result.getTaint());
        addTaint(cause);
        addTaint(success);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(2);
        rr.mp.writeInt(success ? 1 : 0);
        rr.mp.writeInt(cause);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.932 -0400", hash_original_method = "7D64BD1B5FFD5E98E91826BF607F7EF6", hash_generated_method = "11D848C9E7B48E2C3C7E2F1DB15FABA8")
    public void acknowledgeLastIncomingCdmaSms(boolean success, int cause, Message result) {
        addTaint(result.getTaint());
        addTaint(cause);
        addTaint(success);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);
        rr.mp.writeInt(success ? 0 : 1);
        rr.mp.writeInt(cause);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);
        //rr.mp.writeInt(success ? 0 : 1);
        //rr.mp.writeInt(cause);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " " + success + " " + cause);
        //send(rr);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.932 -0400", hash_original_method = "64AA0D67C6CE837D613809948FDF7791", hash_generated_method = "8A3D341C636BFC1FF9CE69113293A5C1")
    public void acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu, Message result) {
        addTaint(result.getTaint());
        addTaint(ackPdu.getTaint());
        addTaint(success);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU, result);
        rr.mp.writeInt(2);
        rr.mp.writeString(success ? "1" : "0");
        rr.mp.writeString(ackPdu);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + ' ' + success + " [" + ackPdu + ']');
        send(rr);
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "59EE7F242CC2ECDC31CC3317E2625FB0", hash_generated_method = "D5AC675DDE2089CF469920874AB4A9F4")
    public void iccIO(int command, int fileid, String path, int p1, int p2, int p3,
            String data, String pin2, Message result) {
        addTaint(result.getTaint());
        addTaint(pin2.getTaint());
        addTaint(data.getTaint());
        addTaint(p3);
        addTaint(p2);
        addTaint(p1);
        addTaint(path.getTaint());
        addTaint(fileid);
        addTaint(command);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SIM_IO, result);
        rr.mp.writeInt(command);
        rr.mp.writeInt(fileid);
        rr.mp.writeString(path);
        rr.mp.writeInt(p1);
        rr.mp.writeInt(p2);
        rr.mp.writeInt(p3);
        rr.mp.writeString(data);
        rr.mp.writeString(pin2);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> iccIO: " + requestToString(rr.mRequest)
                + " 0x" + Integer.toHexString(command)
                + " 0x" + Integer.toHexString(fileid) + " "
                + " path: " + path + ","
                + p1 + "," + p2 + "," + p3);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "ED6C155DF5FB4724355C53F41C941076", hash_generated_method = "FCACDDF99F4DAAD28200EE7FB29E8AFA")
    public void getCLIR(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "19860D4829B0277968FE7219CA94272C", hash_generated_method = "EF4F46FB25B54B5216A6AFC2E6F3D001")
    public void setCLIR(int clirMode, Message result) {
        addTaint(result.getTaint());
        addTaint(clirMode);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(clirMode);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + clirMode);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(clirMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + clirMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "32FF52B6F1E399D1F262392EAB262972", hash_generated_method = "C36CFFC41B35788BEF055D4E82ACD905")
    public void queryCallWaiting(int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(serviceClass);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + serviceClass);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(serviceClass);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + serviceClass);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "5A203D1E3F2536DB5285EBA696BDFC7A", hash_generated_method = "131E37934867F8BF870F8B4A08E0D6F2")
    public void setCallWaiting(boolean enable, int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(enable);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_WAITING, response);
        rr.mp.writeInt(2);
        rr.mp.writeInt(enable ? 1 : 0);
        rr.mp.writeInt(serviceClass);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + enable + ", " + serviceClass);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.933 -0400", hash_original_method = "B2CF07F1A50F7E09BFE7FA86DAEC0935", hash_generated_method = "FD8BFBCD77D73AE0C3FD1B7E7AC40CF3")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.934 -0400", hash_original_method = "D59960D2C4E94DFBAD71EBB3A94610C2", hash_generated_method = "97D4ECD94BEF8AFD757B378174D9FD4F")
    public void setNetworkSelectionModeManual(String operatorNumeric, Message response) {
        addTaint(response.getTaint());
        addTaint(operatorNumeric.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + operatorNumeric);
        rr.mp.writeString(operatorNumeric);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    //+ " " + operatorNumeric);
        //rr.mp.writeString(operatorNumeric);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.934 -0400", hash_original_method = "7D16D9750A543F65AAA01DDCEE296D12", hash_generated_method = "4F7ED65AB1BFB981AEEA78B2B06AF621")
    public void getNetworkSelectionMode(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.934 -0400", hash_original_method = "A28AFA8A6050502E50A0794217CD9CA3", hash_generated_method = "99377F19E89AA5E7D63EF1B5EF9AB5FD")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.934 -0400", hash_original_method = "BAE7513A4D74D7F41628BC2CA56E49A7", hash_generated_method = "87FEC78F21DD3C3CD5480C1475422EA1")
    public void setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        addTaint(response.getTaint());
        addTaint(timeSeconds);
        addTaint(number.getTaint());
        addTaint(serviceClass);
        addTaint(cfReason);
        addTaint(action);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_CALL_FORWARD, response);
        rr.mp.writeInt(action);
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (timeSeconds);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + action + " " + cfReason + " " + serviceClass
                    + timeSeconds);
        send(rr);
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "23037026F2CF508E3AB593A615459BEF", hash_generated_method = "FA72C811632A9379E882111FA8729B70")
    public void queryCallForwardStatus(int cfReason, int serviceClass,
                String number, Message response) {
        addTaint(response.getTaint());
        addTaint(number.getTaint());
        addTaint(serviceClass);
        addTaint(cfReason);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_FORWARD_STATUS, response);
        rr.mp.writeInt(2);
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (0);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + cfReason + " " + serviceClass);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "51655E0BCF7B1E2F86E04B0432A13A10", hash_generated_method = "6330D6EA7767E57B05351F39402CC7CA")
    public void queryCLIP(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
            //= RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "A7E1CFA2EA980EF525A71B63D23749C6", hash_generated_method = "C6ACA8B60B28B0ABBEE86289193C93F7")
    public void getBasebandVersion(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "E2D6CDE0F4A2E0F1E247B2E96BC06629", hash_generated_method = "2741298D7797980EFD4D10055CDEB32A")
    @Override
    public void queryFacilityLock(String facility, String password, int serviceClass,
                            Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(facility.getTaint());
        queryFacilityLockForApp(facility, password, serviceClass, null, response);
        // ---------- Original Method ----------
        //queryFacilityLockForApp(facility, password, serviceClass, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "B68C5E6FDA45200A6E5673701837774F", hash_generated_method = "DDE3B593190FAD6725C5C0B4BA3855DF")
    @Override
    public void queryFacilityLockForApp(String facility, String password, int serviceClass, String appId,
                            Message response) {
        addTaint(response.getTaint());
        addTaint(appId.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(facility.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_FACILITY_LOCK, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(4);
        rr.mp.writeString(facility);
        rr.mp.writeString(password);
        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.935 -0400", hash_original_method = "AF27A0F06A4AEF0B8CE967EE20FD6D5A", hash_generated_method = "0215D0AE9B9A1635E2FC6E1D5420E12D")
    @Override
    public void setFacilityLock(String facility, boolean lockState, String password,
                        int serviceClass, Message response) {
        addTaint(response.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(lockState);
        addTaint(facility.getTaint());
        setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
        // ---------- Original Method ----------
        //setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.936 -0400", hash_original_method = "99FAE35221FB0E541022587B483A8F41", hash_generated_method = "B92635ED3F540A015B9E4730335C6E13")
    @Override
    public void setFacilityLockForApp(String facility, boolean lockState, String password,
                        int serviceClass, String appId, Message response) {
        addTaint(response.getTaint());
        addTaint(appId.getTaint());
        addTaint(serviceClass);
        addTaint(password.getTaint());
        addTaint(lockState);
        addTaint(facility.getTaint());
        String lockString;
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_FACILITY_LOCK, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeInt(5);
        rr.mp.writeString(facility);
        lockString = (lockState)?"1":"0";
        rr.mp.writeString(lockString);
        rr.mp.writeString(password);
        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.936 -0400", hash_original_method = "B3D73089A364D1181DC1E2D229325D6D", hash_generated_method = "8C802026808E71C3453EAEED41E9288F")
    public void sendUSSD(String ussdString, Message response) {
        addTaint(response.getTaint());
        addTaint(ussdString.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + ussdString);
        rr.mp.writeString(ussdString);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            //+ " " + ussdString);
        //rr.mp.writeString(ussdString);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.936 -0400", hash_original_method = "08754E29DFB7112567CD0DC9F54BCD3D", hash_generated_method = "FFAFC87F5A6C0ADA42EDCEFC5EEF5197")
    public void cancelPendingUssd(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);
        //if (RILJ_LOGD) riljLog(rr.serialString()
                //+ "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.936 -0400", hash_original_method = "5EED3CE7F239827AE459A68B7A5F6205", hash_generated_method = "18823BB2600786DC5526AAE5743E9441")
    public void resetRadio(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.936 -0400", hash_original_method = "CC2053517147AA26411A18AF4FB47931", hash_generated_method = "DF65DAE7939D44BFCB2CA0776F392A78")
    public void invokeOemRilRequestRaw(byte[] data, Message response) {
        addTaint(response.getTaint());
        addTaint(data[0]);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               + "[" + IccUtils.bytesToHexString(data) + "]");
        rr.mp.writeByteArray(data);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               //+ "[" + IccUtils.bytesToHexString(data) + "]");
        //rr.mp.writeByteArray(data);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.937 -0400", hash_original_method = "30F3E98808998C1043AF97B2AEFF80ED", hash_generated_method = "CE2EFE3905640D50984B7A783009BE8D")
    public void invokeOemRilRequestStrings(String[] strings, Message response) {
        addTaint(response.getTaint());
        addTaint(strings[0].getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeStringArray(strings);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeStringArray(strings);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.937 -0400", hash_original_method = "0483D811AD0184EC240C471A09F163C0", hash_generated_method = "8F765AA67E2A7B1CD47371A2A6262144")
    public void setBandMode(int bandMode, Message response) {
        addTaint(response.getTaint());
        addTaint(bandMode);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(bandMode);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 + " " + bandMode);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(bandMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 //+ " " + bandMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.937 -0400", hash_original_method = "3559A91588B2C9F9707F9FC4DC3F7539", hash_generated_method = "ADF62337DEF2C3910B860E1F5FF4BBC3")
    public void queryAvailableBandMode(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr
                //= RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                //response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.938 -0400", hash_original_method = "E6DDFD05E0997BF7790CA803E711C2EC", hash_generated_method = "32490528ED757BB9BF01F94DD8E062F3")
    public void sendTerminalResponse(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.938 -0400", hash_original_method = "AF8E8A7CD3B08412D1DCD73CAE0ACCA0", hash_generated_method = "3FD84EFDFF3E47B4FB7B31C3624EC871")
    public void sendEnvelope(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        rr.mp.writeString(contents);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.938 -0400", hash_original_method = "A3C6115C92419E7DB4E4439F1BAFD013", hash_generated_method = "734CCCE9B298045EE655ED633C7FF246")
    public void sendEnvelopeWithStatus(String contents, Message response) {
        addTaint(response.getTaint());
        addTaint(contents.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + '[' + contents + ']');
        rr.mp.writeString(contents);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ '[' + contents + ']');
        //rr.mp.writeString(contents);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.939 -0400", hash_original_method = "0FD1EE2A52540A4F80ECA30E950318D2", hash_generated_method = "FE844029378BF73218295B26C7F85C81")
    public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {
        addTaint(response.getTaint());
        addTaint(accept);
        RILRequest rr = RILRequest.obtain(
            RILConstants.RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM,
            response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        int[] param = new int[1];
        param[0] = accept ? 1 : 0;
        rr.mp.writeIntArray(param);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.939 -0400", hash_original_method = "E0470661D17E36A9D9FCCA070C28B88C", hash_generated_method = "9519082A289B12C33136C3D3F90B2E0C")
    @Override
    public void setCurrentPreferredNetworkType() {
    if(RILJ_LOGD)        
        riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        setPreferredNetworkType(mSetPreferredNetworkType, null);
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        //setPreferredNetworkType(mSetPreferredNetworkType, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.939 -0400", hash_original_method = "CD05D01D2353BF09784B2C892638713C", hash_generated_method = "CF9D6BF8255A7BD1159943DACD8DB6CE")
    public void setPreferredNetworkType(int networkType , Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(networkType);
        mSetPreferredNetworkType = networkType;
        mPreferredNetworkType = networkType;
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + networkType);
        send(rr);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.939 -0400", hash_original_method = "9630540DB0E1A382F252246374543CFF", hash_generated_method = "B200971F7D7C92FE3603C03E537CFE5B")
    public void getPreferredNetworkType(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "EA7CB0793F40AD8E91B9E82268500DF5", hash_generated_method = "0B5DBDDAE337D648ED0D50D0F4DD8D4C")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "29FCAB1F96F7A6DF63D13BAE634B9C42", hash_generated_method = "A3A47A6B8FA71C868DF40085977D5D44")
    public void setLocationUpdates(boolean enable, Message response) {
        addTaint(response.getTaint());
        addTaint(enable);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + enable);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(enable ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest) + ": " + enable);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "7C3C5691348423704F3F89A5A1253262", hash_generated_method = "C4DB9C01A3FA16DF5F4A7D164FC76803")
    public void getSmscAddress(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "8030AF8483F275DADFE9FBCDFA4401B2", hash_generated_method = "4CA7109427B895DA1F558C13F6A5E8F8")
    public void setSmscAddress(String address, Message result) {
        addTaint(result.getTaint());
        addTaint(address.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);
        rr.mp.writeString(address);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + address);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);
        //rr.mp.writeString(address);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + address);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "E14FF49FE633CFCC7BBD49EA04EF5648", hash_generated_method = "13C300E7AFAE094A10CBFCBC757D24CA")
    public void reportSmsMemoryStatus(boolean available, Message result) {
        addTaint(result.getTaint());
        addTaint(available);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(available ? 1 : 0);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + available);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(available ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                //+ requestToString(rr.mRequest) + ": " + available);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.940 -0400", hash_original_method = "00A5515B81A4CB5336CA56505ADAAD61", hash_generated_method = "CDE583BB688F4C6A01FE68F55215BE01")
    public void reportStkServiceIsRunning(Message result) {
        addTaint(result.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.941 -0400", hash_original_method = "8D8904D0E740DF21294F215C1D1D7109", hash_generated_method = "795FC363BF9B382EF71FF1194B25ECC6")
    public void getGsmBroadcastConfig(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.941 -0400", hash_original_method = "052EA3DC72AD24FB98DF1CE5007E33C5", hash_generated_method = "A8BCC14A1EA0C81A9E9A5CF3E332F63B")
    public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        addTaint(response.getTaint());
        addTaint(config[0].getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_SET_BROADCAST_CONFIG, response);
        int numOfConfig = config.length;
        rr.mp.writeInt(numOfConfig);
for(int i = 0;i < numOfConfig;i++)
        {
            rr.mp.writeInt(config[i].getFromServiceId());
            rr.mp.writeInt(config[i].getToServiceId());
            rr.mp.writeInt(config[i].getFromCodeScheme());
            rr.mp.writeInt(config[i].getToCodeScheme());
            rr.mp.writeInt(config[i].isSelected() ? 1 : 0);
        } //End block
    if(RILJ_LOGD)        
        {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " with " + numOfConfig + " configs : ");
for(int i = 0;i < numOfConfig;i++)
            {
                riljLog(config[i].toString());
            } //End block
        } //End block
        send(rr);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.941 -0400", hash_original_method = "A31C3FA8B485D8364A045A89E34CE9F1", hash_generated_method = "83F6D4AA0B85DC4C552A18C9DE299052")
    public void setGsmBroadcastActivation(boolean activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 : 1);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(activate ? 0 : 1);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.941 -0400", hash_original_method = "98C8C2D826445A3B0F1B6AA20E13AA85", hash_generated_method = "4316B5CD006D75B2EF297DA731588FC1")
    private void sendScreenState(boolean on) {
        addTaint(on);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);
    if(RILJ_LOGD)        
        riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest) + ": " + on);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(on ? 1 : 0);
        //if (RILJ_LOGD) riljLog(rr.serialString()
                //+ "> " + requestToString(rr.mRequest) + ": " + on);
        //send(rr);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.942 -0400", hash_original_method = "BB835229E5EA50CDBB0B126232F0F168", hash_generated_method = "D18433B9DE179811653284B06AFFE308")
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendScreenState(true);
        // ---------- Original Method ----------
        //sendScreenState(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.942 -0400", hash_original_method = "160781DFD510822CA161AF254F33803E", hash_generated_method = "78504ECBF62E63E8BF21654DC116B91F")
    private RadioState getRadioStateFromInt(int stateInt) {
        addTaint(stateInt);
        RadioState state;
switch(stateInt){
        case 0:
        state = RadioState.RADIO_OFF;
        break;
        case 1:
        state = RadioState.RADIO_UNAVAILABLE;
        break;
        case 2:
        state = RadioState.SIM_NOT_READY;
        break;
        case 3:
        state = RadioState.SIM_LOCKED_OR_ABSENT;
        break;
        case 4:
        state = RadioState.SIM_READY;
        break;
        case 5:
        state = RadioState.RUIM_NOT_READY;
        break;
        case 6:
        state = RadioState.RUIM_READY;
        break;
        case 7:
        state = RadioState.RUIM_LOCKED_OR_ABSENT;
        break;
        case 8:
        state = RadioState.NV_NOT_READY;
        break;
        case 9:
        state = RadioState.NV_READY;
        break;
        default:
        RuntimeException var16E0F1767AC19FC4D311D5E304C493EA_600855685 = new RuntimeException(
                            "Unrecognized RIL_RadioState: " + stateInt);
        var16E0F1767AC19FC4D311D5E304C493EA_600855685.addTaint(taint);
        throw var16E0F1767AC19FC4D311D5E304C493EA_600855685;
}RadioState var37C56C9D63C623261861C16DCFB73F6D_880774529 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_880774529.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_880774529;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.942 -0400", hash_original_method = "63485FEB05CEDE30346AAC1338BBCCD0", hash_generated_method = "0096B084B958AB70710437DEDC93DD97")
    private void switchToRadioState(RadioState newState) {
        addTaint(newState.getTaint());
        setRadioState(newState);
        // ---------- Original Method ----------
        //setRadioState(newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.942 -0400", hash_original_method = "80B68145386C06F39CF9C77A11CB4F6E", hash_generated_method = "D03A1878D930A4886FEBE5EACDB5FA26")
    private void acquireWakeLock() {
        synchronized
(mWakeLock)        {
            mWakeLock.acquire();
            mRequestMessagesPending++;
            mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            Message msg = mSender.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.942 -0400", hash_original_method = "F7B2E2DA8A26C192DB4FA2BF8451999B", hash_generated_method = "F9195D5A04C45325C231DAE2CFF6655B")
    private void releaseWakeLockIfDone() {
        synchronized
(mWakeLock)        {
    if(mWakeLock.isHeld() &&
                (mRequestMessagesPending == 0) &&
                (mRequestMessagesWaiting == 0))            
            {
                mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                mWakeLock.release();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.943 -0400", hash_original_method = "035841781AADB837D6EAD23CCB5C67B0", hash_generated_method = "D5AB4BE7D0C66CC223F7BDC0F9A14F8A")
    private void send(RILRequest rr) {
        addTaint(rr.getTaint());
        Message msg;
    if(mSocket == null)        
        {
            rr.onError(RADIO_NOT_AVAILABLE, null);
            rr.release();
            return;
        } //End block
        msg = mSender.obtainMessage(EVENT_SEND, rr);
        acquireWakeLock();
        msg.sendToTarget();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.943 -0400", hash_original_method = "BE5BB24392C97184A4E1C8B58214F114", hash_generated_method = "DC07519685A7E3625224138D4DC49194")
    private void processResponse(Parcel p) {
        addTaint(p.getTaint());
        int type;
        type = p.readInt();
    if(type == RESPONSE_UNSOLICITED)        
        {
            processUnsolicited (p);
        } //End block
        else
    if(type == RESPONSE_SOLICITED)        
        {
            processSolicited (p);
        } //End block
        releaseWakeLockIfDone();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.943 -0400", hash_original_method = "BC68EE684C76422271CAFE5D885C13B0", hash_generated_method = "DFCF7DF54C3163586A450DA3475C29ED")
    private void clearRequestsList(int error, boolean loggable) {
        addTaint(loggable);
        addTaint(error);
        RILRequest rr;
        synchronized
(mRequestsList)        {
            int count = mRequestsList.size();
    if(RILJ_LOGD && loggable)            
            {
                Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                        " mReqPending=" + mRequestMessagesPending +
                        " mRequestList=" + count);
            } //End block
for(int i = 0;i < count;i++)
            {
                rr = mRequestsList.get(i);
    if(RILJ_LOGD && loggable)                
                {
                    Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] " +
                            requestToString(rr.mRequest));
                } //End block
                rr.onError(error, null);
                rr.release();
            } //End block
            mRequestsList.clear();
            mRequestMessagesWaiting = 0;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.943 -0400", hash_original_method = "821C18746C2BF0250268E9897F34563E", hash_generated_method = "3922FC163C6C0F8E6382FC2C90254F3C")
    private RILRequest findAndRemoveRequestFromList(int serial) {
        addTaint(serial);
        synchronized
(mRequestsList)        {
for(int i = 0, s = mRequestsList.size();i < s;i++)
            {
                RILRequest rr = mRequestsList.get(i);
    if(rr.mSerial == serial)                
                {
                    mRequestsList.remove(i);
    if(mRequestMessagesWaiting > 0)                    
                    mRequestMessagesWaiting--;
RILRequest var2A28F1EA1AB5EF586FD3804D7EF3F072_2056901718 =                     rr;
                    var2A28F1EA1AB5EF586FD3804D7EF3F072_2056901718.addTaint(taint);
                    return var2A28F1EA1AB5EF586FD3804D7EF3F072_2056901718;
                } //End block
            } //End block
        } //End block
RILRequest var540C13E9E156B687226421B24F2DF178_973112086 =         null;
        var540C13E9E156B687226421B24F2DF178_973112086.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_973112086;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.947 -0400", hash_original_method = "E53F353584D1FC1676A6EAA90642D430", hash_generated_method = "4D6ACCB3B2D9446CF66B13259755213A")
    private void processSolicited(Parcel p) {
        addTaint(p.getTaint());
        int serial;
        int error;
        boolean found = false;
        serial = p.readInt();
        error = p.readInt();
        RILRequest rr;
        rr = findAndRemoveRequestFromList(serial);
    if(rr == null)        
        {
            return;
        } //End block
        Object ret = null;
    if(error == 0 || p.dataAvail() > 0)        
        {
            try 
            {
switch(rr.mRequest){
                case RIL_REQUEST_GET_SIM_STATUS:
                ret =  responseIccCardStatus(p);
                break;
                case RIL_REQUEST_ENTER_SIM_PIN:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_ENTER_SIM_PUK:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_ENTER_SIM_PIN2:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_ENTER_SIM_PUK2:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CHANGE_SIM_PIN:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CHANGE_SIM_PIN2:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_GET_CURRENT_CALLS:
                ret =  responseCallList(p);
                break;
                case RIL_REQUEST_DIAL:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GET_IMSI:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_HANGUP:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CONFERENCE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_UDUB:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_LAST_CALL_FAIL_CAUSE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SIGNAL_STRENGTH:
                ret =  responseSignalStrength(p);
                break;
                case RIL_REQUEST_VOICE_REGISTRATION_STATE:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_DATA_REGISTRATION_STATE:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_OPERATOR:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_RADIO_POWER:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_DTMF:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SEND_SMS:
                ret =  responseSMS(p);
                break;
                case RIL_REQUEST_SEND_SMS_EXPECT_MORE:
                ret =  responseSMS(p);
                break;
                case RIL_REQUEST_SETUP_DATA_CALL:
                ret =  responseSetupDataCall(p);
                break;
                case RIL_REQUEST_SIM_IO:
                ret =  responseICC_IO(p);
                break;
                case RIL_REQUEST_SEND_USSD:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CANCEL_USSD:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GET_CLIR:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SET_CLIR:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS:
                ret =  responseCallForward(p);
                break;
                case RIL_REQUEST_SET_CALL_FORWARD:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_CALL_WAITING:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SET_CALL_WAITING:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SMS_ACKNOWLEDGE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GET_IMEI:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_GET_IMEISV:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_ANSWER:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_DEACTIVATE_DATA_CALL:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_FACILITY_LOCK:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SET_FACILITY_LOCK:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CHANGE_BARRING_PASSWORD:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS :
                ret =  responseOperatorInfos(p);
                break;
                case RIL_REQUEST_DTMF_START:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_DTMF_STOP:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_BASEBAND_VERSION:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_SEPARATE_CONNECTION:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SET_MUTE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GET_MUTE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_QUERY_CLIP:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_DATA_CALL_LIST:
                ret =  responseDataCallList(p);
                break;
                case RIL_REQUEST_RESET_RADIO:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_OEM_HOOK_RAW:
                ret =  responseRaw(p);
                break;
                case RIL_REQUEST_OEM_HOOK_STRINGS:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_SCREEN_STATE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_WRITE_SMS_TO_SIM:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_DELETE_SMS_ON_SIM:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SET_BAND_MODE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_STK_GET_PROFILE:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_STK_SET_PROFILE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_EXPLICIT_CALL_TRANSFER:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE:
                ret =  responseGetPreferredNetworkType(p);
                break;
                case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS:
                ret = responseCellList(p);
                break;
                case RIL_REQUEST_SET_LOCATION_UPDATES:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_SET_TTY_MODE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_QUERY_TTY_MODE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CDMA_FLASH:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_BURST_DTMF:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_SEND_SMS:
                ret =  responseSMS(p);
                break;
                case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG:
                ret =  responseGmsBroadcastConfig(p);
                break;
                case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_GSM_BROADCAST_ACTIVATION:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG:
                ret =  responseCdmaBroadcastConfig(p);
                break;
                case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_SUBSCRIPTION:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM:
                ret =  responseVoid(p);
                break;
                case RIL_REQUEST_DEVICE_IDENTITY:
                ret =  responseStrings(p);
                break;
                case RIL_REQUEST_GET_SMSC_ADDRESS:
                ret = responseString(p);
                break;
                case RIL_REQUEST_SET_SMSC_ADDRESS:
                ret = responseVoid(p);
                break;
                case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE:
                ret = responseVoid(p);
                break;
                case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS:
                ret = responseVoid(p);
                break;
                case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING:
                ret = responseVoid(p);
                break;
                case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE:
                ret =  responseInts(p);
                break;
                case RIL_REQUEST_ISIM_AUTHENTICATION:
                ret =  responseString(p);
                break;
                case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU:
                ret = responseVoid(p);
                break;
                case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS:
                ret = responseICC_IO(p);
                break;
                default:
                RuntimeException varE8CE26F5FD54EFF3FF978E83581CAC6F_649503699 = new RuntimeException("Unrecognized solicited response: " + rr.mRequest);
                varE8CE26F5FD54EFF3FF978E83581CAC6F_649503699.addTaint(taint);
                throw varE8CE26F5FD54EFF3FF978E83581CAC6F_649503699;
}
            } //End block
            catch (Throwable tr)
            {
    if(rr.mResult != null)                
                {
                    AsyncResult.forMessage(rr.mResult, null, tr);
                    rr.mResult.sendToTarget();
                } //End block
                rr.release();
                return;
            } //End block
        } //End block
    if(error != 0)        
        {
            rr.onError(error, ret);
            rr.release();
            return;
        } //End block
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "< " + requestToString(rr.mRequest)
            + " " + retToString(rr.mRequest, ret));
    if(rr.mResult != null)        
        {
            AsyncResult.forMessage(rr.mResult, ret, null);
            rr.mResult.sendToTarget();
        } //End block
        rr.release();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.949 -0400", hash_original_method = "8A94A1215BBA17FF474D4F8406941ACC", hash_generated_method = "A58FB3A3B712E10C95142E1CD8C940BF")
    private String retToString(int req, Object ret) {
        addTaint(ret.getTaint());
        addTaint(req);
    if(ret == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_173725214 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_173725214.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_173725214;
        }
switch(req){
        case RIL_REQUEST_GET_IMSI:
        case RIL_REQUEST_GET_IMEI:
        case RIL_REQUEST_GET_IMEISV:
    if(!RILJ_LOGV)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_407775788 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_407775788.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_407775788;
        } //End block
}        StringBuilder sb;
        String s;
        int length;
    if(ret instanceof int[])        
        {
            int[] intArray = (int[]) ret;
            length = intArray.length;
            sb = new StringBuilder("{");
    if(length > 0)            
            {
                int i = 0;
                sb.append(intArray[i++]);
                while
(i < length)                
                {
                    sb.append(", ").append(intArray[i++]);
                } //End block
            } //End block
            sb.append("}");
            s = sb.toString();
        } //End block
        else
    if(ret instanceof String[])        
        {
            String[] strings = (String[]) ret;
            length = strings.length;
            sb = new StringBuilder("{");
    if(length > 0)            
            {
                int i = 0;
                sb.append(strings[i++]);
                while
(i < length)                
                {
                    sb.append(", ").append(strings[i++]);
                } //End block
            } //End block
            sb.append("}");
            s = sb.toString();
        } //End block
        else
    if(req == RIL_REQUEST_GET_CURRENT_CALLS)        
        {
            ArrayList<DriverCall> calls = (ArrayList<DriverCall>) ret;
            sb = new StringBuilder(" ");
for(DriverCall dc : calls)
            {
                sb.append("[").append(dc).append("] ");
            } //End block
            s = sb.toString();
        } //End block
        else
    if(req == RIL_REQUEST_GET_NEIGHBORING_CELL_IDS)        
        {
            ArrayList<NeighboringCellInfo> cells;
            cells = (ArrayList<NeighboringCellInfo>) ret;
            sb = new StringBuilder(" ");
for(NeighboringCellInfo cell : cells)
            {
                sb.append(cell).append(" ");
            } //End block
            s = sb.toString();
        } //End block
        else
        {
            s = ret.toString();
        } //End block
String var0478718F0636FB61899C13801CE9FE09_74007223 =         s;
        var0478718F0636FB61899C13801CE9FE09_74007223.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_74007223;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.954 -0400", hash_original_method = "0DD0C2CAC9DFFC256536DE8141109DEC", hash_generated_method = "7FFAC9683547E8B3B9E90B54C17A82A1")
    private void processUnsolicited(Parcel p) {
        addTaint(p.getTaint());
        int response;
        Object ret;
        response = p.readInt();
        try 
        {
switch(response){
            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_RESPONSE_NEW_SMS:
            ret =  responseString(p);
            break;
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT:
            ret =  responseString(p);
            break;
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM:
            ret =  responseInts(p);
            break;
            case RIL_UNSOL_ON_USSD:
            ret =  responseStrings(p);
            break;
            case RIL_UNSOL_NITZ_TIME_RECEIVED:
            ret =  responseString(p);
            break;
            case RIL_UNSOL_SIGNAL_STRENGTH:
            ret = responseSignalStrength(p);
            break;
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED:
            ret = responseDataCallList(p);
            break;
            case RIL_UNSOL_SUPP_SVC_NOTIFICATION:
            ret = responseSuppServiceNotification(p);
            break;
            case RIL_UNSOL_STK_SESSION_END:
            ret = responseVoid(p);
            break;
            case RIL_UNSOL_STK_PROACTIVE_COMMAND:
            ret = responseString(p);
            break;
            case RIL_UNSOL_STK_EVENT_NOTIFY:
            ret = responseString(p);
            break;
            case RIL_UNSOL_STK_CALL_SETUP:
            ret = responseInts(p);
            break;
            case RIL_UNSOL_SIM_SMS_STORAGE_FULL:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_SIM_REFRESH:
            ret =  responseInts(p);
            break;
            case RIL_UNSOL_CALL_RING:
            ret =  responseCallRing(p);
            break;
            case RIL_UNSOL_RESTRICTED_STATE_CHANGED:
            ret = responseInts(p);
            break;
            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:
            ret =  responseCdmaSms(p);
            break;
            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:
            ret =  responseRaw(p);
            break;
            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:
            ret =  responseVoid(p);
            break;
            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE:
            ret = responseVoid(p);
            break;
            case RIL_UNSOL_CDMA_CALL_WAITING:
            ret = responseCdmaCallWaiting(p);
            break;
            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS:
            ret = responseInts(p);
            break;
            case RIL_UNSOL_CDMA_INFO_REC:
            ret = responseCdmaInformationRecord(p);
            break;
            case RIL_UNSOL_OEM_HOOK_RAW:
            ret = responseRaw(p);
            break;
            case RIL_UNSOL_RINGBACK_TONE:
            ret = responseInts(p);
            break;
            case RIL_UNSOL_RESEND_INCALL_MUTE:
            ret = responseVoid(p);
            break;
            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED:
            ret = responseInts(p);
            break;
            case RIL_UNSOl_CDMA_PRL_CHANGED:
            ret = responseInts(p);
            break;
            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE:
            ret = responseVoid(p);
            break;
            case RIL_UNSOL_RIL_CONNECTED:
            ret = responseInts(p);
            break;
            default:
            RuntimeException var0F2E625871D6054A6A77E96060AD0B2E_1715285995 = new RuntimeException("Unrecognized unsol response: " + response);
            var0F2E625871D6054A6A77E96060AD0B2E_1715285995.addTaint(taint);
            throw var0F2E625871D6054A6A77E96060AD0B2E_1715285995;
}
        } //End block
        catch (Throwable tr)
        {
            return;
        } //End block
switch(response){
        case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED:
        RadioState newState = getRadioStateFromInt(p.readInt());
    if(RILJ_LOGD)        
        unsljLogMore(response, newState.toString());
        switchToRadioState(newState);
        break;
        case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED:
    if(RILJ_LOGD)        
        unsljLog(response);
        mCallStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        break;
        case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED:
    if(RILJ_LOGD)        
        unsljLog(response);
        mVoiceNetworkStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
        break;
        case RIL_UNSOL_RESPONSE_NEW_SMS:
        {
    if(RILJ_LOGD)            
            unsljLog(response);
            String a[] = new String[2];
            a[1] = (String)ret;
            SmsMessage sms;
            sms = SmsMessage.newFromCMT(a);
    if(mGsmSmsRegistrant != null)            
            {
                mGsmSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
            } //End block
            break;
        } //End block
        case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mSmsStatusRegistrant != null)        
        {
            mSmsStatusRegistrant.notifyRegistrant(
                            new AsyncResult(null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
        int[] smsIndex = (int[])ret;
    if(smsIndex.length == 1)        
        {
    if(mSmsOnSimRegistrant != null)            
            {
                mSmsOnSimRegistrant.
                                notifyRegistrant(new AsyncResult(null, smsIndex, null));
            } //End block
        } //End block
        else
        {
    if(RILJ_LOGD)            
            riljLog(" NEW_SMS_ON_SIM ERROR with wrong length "
                            + smsIndex.length);
        } //End block
        break;
        case RIL_UNSOL_ON_USSD:
        String[] resp = (String[])ret;
    if(resp.length < 2)        
        {
            resp = new String[2];
            resp[0] = ((String[])ret)[0];
            resp[1] = null;
        } //End block
    if(RILJ_LOGD)        
        unsljLogMore(response, resp[0]);
    if(mUSSDRegistrant != null)        
        {
            mUSSDRegistrant.notifyRegistrant(
                        new AsyncResult (null, resp, null));
        } //End block
        break;
        case RIL_UNSOL_NITZ_TIME_RECEIVED:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
        long nitzReceiveTime = p.readLong();
        Object[] result = new Object[2];
        result[0] = ret;
        result[1] = Long.valueOf(nitzReceiveTime);
    if(mNITZTimeRegistrant != null)        
        {
            mNITZTimeRegistrant
                        .notifyRegistrant(new AsyncResult (null, result, null));
        } //End block
        else
        {
            mLastNITZTimeInfo = result;
        } //End block
        break;
        case RIL_UNSOL_SIGNAL_STRENGTH:
    if(RILJ_LOGV)        
        unsljLogvRet(response, ret);
    if(mSignalStrengthRegistrant != null)        
        {
            mSignalStrengthRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_DATA_CALL_LIST_CHANGED:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
        mDataNetworkStateRegistrants.notifyRegistrants(new AsyncResult(null, ret, null));
        break;
        case RIL_UNSOL_SUPP_SVC_NOTIFICATION:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mSsnRegistrant != null)        
        {
            mSsnRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_STK_SESSION_END:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mCatSessionEndRegistrant != null)        
        {
            mCatSessionEndRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_STK_PROACTIVE_COMMAND:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCatProCmdRegistrant != null)        
        {
            mCatProCmdRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_STK_EVENT_NOTIFY:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCatEventRegistrant != null)        
        {
            mCatEventRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_STK_CALL_SETUP:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCatCallSetUpRegistrant != null)        
        {
            mCatCallSetUpRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_SIM_SMS_STORAGE_FULL:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mIccSmsFullRegistrant != null)        
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } //End block
        break;
        case RIL_UNSOL_SIM_REFRESH:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mIccRefreshRegistrants != null)        
        {
            mIccRefreshRegistrants.notifyRegistrants(
                            new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_CALL_RING:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mRingRegistrant != null)        
        {
            mRingRegistrant.notifyRegistrant(
                            new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_RESTRICTED_STATE_CHANGED:
    if(RILJ_LOGD)        
        unsljLogvRet(response, ret);
    if(mRestrictedStateRegistrant != null)        
        {
            mRestrictedStateRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mIccStatusChangedRegistrants != null)        
        {
            mIccStatusChangedRegistrants.notifyRegistrants();
        } //End block
        break;
        case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:
    if(RILJ_LOGD)        
        unsljLog(response);
        SmsMessage sms = (SmsMessage) ret;
    if(mCdmaSmsRegistrant != null)        
        {
            mCdmaSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
        } //End block
        break;
        case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mGsmBroadcastSmsRegistrant != null)        
        {
            mGsmBroadcastSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mIccSmsFullRegistrant != null)        
        {
            mIccSmsFullRegistrant.notifyRegistrant();
        } //End block
        break;
        case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE:
    if(RILJ_LOGD)        
        unsljLog(response);
    if(mEmergencyCallbackModeRegistrant != null)        
        {
            mEmergencyCallbackModeRegistrant.notifyRegistrant();
        } //End block
        break;
        case RIL_UNSOL_CDMA_CALL_WAITING:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCallWaitingInfoRegistrants != null)        
        {
            mCallWaitingInfoRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mOtaProvisionRegistrants != null)        
        {
            mOtaProvisionRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_CDMA_INFO_REC:
        ArrayList<CdmaInformationRecords> listInfoRecs;
        try 
        {
            listInfoRecs = (ArrayList<CdmaInformationRecords>)ret;
        } //End block
        catch (ClassCastException e)
        {
            break;
        } //End block
for(CdmaInformationRecords rec : listInfoRecs)
        {
    if(RILJ_LOGD)            
            unsljLogRet(response, rec);
            notifyRegistrantsCdmaInfoRec(rec);
        } //End block
        break;
        case RIL_UNSOL_OEM_HOOK_RAW:
    if(RILJ_LOGD)        
        unsljLogvRet(response, IccUtils.bytesToHexString((byte[])ret));
    if(mUnsolOemHookRawRegistrant != null)        
        {
            mUnsolOemHookRawRegistrant.notifyRegistrant(new AsyncResult(null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_RINGBACK_TONE:
    if(RILJ_LOGD)        
        unsljLogvRet(response, ret);
    if(mRingbackToneRegistrants != null)        
        {
            boolean playtone = (((int[])ret)[0] == 1);
            mRingbackToneRegistrants.notifyRegistrants(
                                        new AsyncResult (null, playtone, null));
        } //End block
        break;
        case RIL_UNSOL_RESEND_INCALL_MUTE:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mResendIncallMuteRegistrants != null)        
        {
            mResendIncallMuteRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCdmaSubscriptionChangedRegistrants != null)        
        {
            mCdmaSubscriptionChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOl_CDMA_PRL_CHANGED:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mCdmaPrlChangedRegistrants != null)        
        {
            mCdmaPrlChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
        } //End block
        break;
        case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE:
    if(RILJ_LOGD)        
        unsljLogRet(response, ret);
    if(mExitEmergencyCallbackModeRegistrants != null)        
        {
            mExitEmergencyCallbackModeRegistrants.notifyRegistrants(
                                        new AsyncResult (null, null, null));
        } //End block
        break;
        case RIL_UNSOL_RIL_CONNECTED:
        {
    if(RILJ_LOGD)            
            unsljLogRet(response, ret);
            setRadioPower(false, null);
            setPreferredNetworkType(mPreferredNetworkType, null);
            setCdmaSubscriptionSource(mCdmaSubscription, null);
            notifyRegistrantsRilConnectionChanged(((int[])ret)[0]);
            break;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.955 -0400", hash_original_method = "B856EBB2256F144A73FE56175A9B6A36", hash_generated_method = "F1D8CF94359A5B4380CBB1BC9BDC5C8A")
    private void notifyRegistrantsRilConnectionChanged(int rilVer) {
        addTaint(rilVer);
        mRilVersion = rilVer;
    if(mRilConnectedRegistrants != null)        
        {
            mRilConnectedRegistrants.notifyRegistrants(
                                new AsyncResult (null, new Integer(rilVer), null));
        } //End block
        // ---------- Original Method ----------
        //mRilVersion = rilVer;
        //if (mRilConnectedRegistrants != null) {
            //mRilConnectedRegistrants.notifyRegistrants(
                                //new AsyncResult (null, new Integer(rilVer), null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.956 -0400", hash_original_method = "2C7447093749DDBD708485E3CB5D7194", hash_generated_method = "732986F8E57DD06E838BE1326FA04EA2")
    private Object responseInts(Parcel p) {
        addTaint(p.getTaint());
        int numInts;
        int response[];
        numInts = p.readInt();
        response = new int[numInts];
for(int i = 0;i < numInts;i++)
        {
            response[i] = p.readInt();
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_1567729940 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1567729940.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1567729940;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.956 -0400", hash_original_method = "F83E9E0330A999E5D5277EA606DEC7ED", hash_generated_method = "631332E3B17842C2CFA5070215488798")
    private Object responseVoid(Parcel p) {
        addTaint(p.getTaint());
Object var540C13E9E156B687226421B24F2DF178_286673073 =         null;
        var540C13E9E156B687226421B24F2DF178_286673073.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_286673073;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.957 -0400", hash_original_method = "A9CCF034900EFF9E845FDB7DB22E08D2", hash_generated_method = "8685EC294BFA0C665E2D0FCF6A6FC9D4")
    private Object responseCallForward(Parcel p) {
        addTaint(p.getTaint());
        int numInfos;
        CallForwardInfo infos[];
        numInfos = p.readInt();
        infos = new CallForwardInfo[numInfos];
for(int i = 0;i < numInfos;i++)
        {
            infos[i] = new CallForwardInfo();
            infos[i].status = p.readInt();
            infos[i].reason = p.readInt();
            infos[i].serviceClass = p.readInt();
            infos[i].toa = p.readInt();
            infos[i].number = p.readString();
            infos[i].timeSeconds = p.readInt();
        } //End block
Object var856335B33F20D10100490622F4E3620B_1815373660 =         infos;
        var856335B33F20D10100490622F4E3620B_1815373660.addTaint(taint);
        return var856335B33F20D10100490622F4E3620B_1815373660;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.957 -0400", hash_original_method = "6CA2F91918640E9DE536352B73E673A3", hash_generated_method = "F63B939696727E57963127D8F9AE2B88")
    private Object responseSuppServiceNotification(Parcel p) {
        addTaint(p.getTaint());
        SuppServiceNotification notification = new SuppServiceNotification();
        notification.notificationType = p.readInt();
        notification.code = p.readInt();
        notification.index = p.readInt();
        notification.type = p.readInt();
        notification.number = p.readString();
Object var2ED9E3026D104797820BFDEFB87E16D8_531532979 =         notification;
        var2ED9E3026D104797820BFDEFB87E16D8_531532979.addTaint(taint);
        return var2ED9E3026D104797820BFDEFB87E16D8_531532979;
        // ---------- Original Method ----------
        //SuppServiceNotification notification = new SuppServiceNotification();
        //notification.notificationType = p.readInt();
        //notification.code = p.readInt();
        //notification.index = p.readInt();
        //notification.type = p.readInt();
        //notification.number = p.readString();
        //return notification;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.957 -0400", hash_original_method = "F3FE5FFB00EF9163091B0B3C9957ECDA", hash_generated_method = "DBF07205A07DB11795AB0A31F6274897")
    private Object responseCdmaSms(Parcel p) {
        addTaint(p.getTaint());
        SmsMessage sms;
        sms = SmsMessage.newFromParcel(p);
Object var2E0C99463B58778B9565A9086F0B0FFD_537449652 =         sms;
        var2E0C99463B58778B9565A9086F0B0FFD_537449652.addTaint(taint);
        return var2E0C99463B58778B9565A9086F0B0FFD_537449652;
        // ---------- Original Method ----------
        //SmsMessage sms;
        //sms = SmsMessage.newFromParcel(p);
        //return sms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.958 -0400", hash_original_method = "E706FBE3176786F101EC24273C477E8B", hash_generated_method = "0E8669BFA1E4707D62C236D9CFD7BA53")
    private Object responseString(Parcel p) {
        addTaint(p.getTaint());
        String response;
        response = p.readString();
Object var2A1114F4272D753FE23A36E3D68CD293_1044161302 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1044161302.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1044161302;
        // ---------- Original Method ----------
        //String response;
        //response = p.readString();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.958 -0400", hash_original_method = "D52365FD6A67C03CB48CBBF364BA22AF", hash_generated_method = "2014232BCD10F86527F3E37DDE0E158D")
    private Object responseStrings(Parcel p) {
        addTaint(p.getTaint());
        int num;
        String response[];
        response = p.readStringArray();
    if(false)        
        {
            num = p.readInt();
            response = new String[num];
for(int i = 0;i < num;i++)
            {
                response[i] = p.readString();
            } //End block
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_1625445816 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1625445816.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1625445816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.958 -0400", hash_original_method = "B7DD4FAF5DCF16E3869A5E71E7C7982F", hash_generated_method = "89F276FCFBB21558182CCE7079E66301")
    private Object responseRaw(Parcel p) {
        addTaint(p.getTaint());
        int num;
        byte response[];
        response = p.createByteArray();
Object var2A1114F4272D753FE23A36E3D68CD293_1085479449 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1085479449.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1085479449;
        // ---------- Original Method ----------
        //int num;
        //byte response[];
        //response = p.createByteArray();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.958 -0400", hash_original_method = "6A2331BAD13DEAF24E14B96082F25F22", hash_generated_method = "115EB9B585BA5868C323579C808920EF")
    private Object responseSMS(Parcel p) {
        addTaint(p.getTaint());
        int messageRef;
        int errorCode;
        String ackPDU;
        messageRef = p.readInt();
        ackPDU = p.readString();
        errorCode = p.readInt();
        SmsResponse response = new SmsResponse(messageRef, ackPDU, errorCode);
Object var2A1114F4272D753FE23A36E3D68CD293_1497380133 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1497380133.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1497380133;
        // ---------- Original Method ----------
        //int messageRef, errorCode;
        //String ackPDU;
        //messageRef = p.readInt();
        //ackPDU = p.readString();
        //errorCode = p.readInt();
        //SmsResponse response = new SmsResponse(messageRef, ackPDU, errorCode);
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.959 -0400", hash_original_method = "36285902341CFAECFF4B1CF0D454D382", hash_generated_method = "2B2EDDA51F20CAA6B05ED9827130CB63")
    private Object responseICC_IO(Parcel p) {
        addTaint(p.getTaint());
        int sw1;
        int sw2;
        byte data[] = null;
        Message ret;
        sw1 = p.readInt();
        sw2 = p.readInt();
        String s = p.readString();
    if(RILJ_LOGV)        
        riljLog("< iccIO: "
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s);
Object varA4DE666E15471FC46793A14E11D99E42_1065753617 =         new IccIoResult(sw1, sw2, s);
        varA4DE666E15471FC46793A14E11D99E42_1065753617.addTaint(taint);
        return varA4DE666E15471FC46793A14E11D99E42_1065753617;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.960 -0400", hash_original_method = "D5683AC0AFFFFAC7278B155F54988C15", hash_generated_method = "2463EFC9B48BAB2E90777BF5EBB2D5DE")
    private Object responseIccCardStatus(Parcel p) {
        addTaint(p.getTaint());
        IccCardApplication ca;
        IccCardStatus status = new IccCardStatus();
        status.setCardState(p.readInt());
        status.setUniversalPinState(p.readInt());
        status.setGsmUmtsSubscriptionAppIndex(p.readInt());
        status.setCdmaSubscriptionAppIndex(p.readInt());
        status.setImsSubscriptionAppIndex(p.readInt());
        int numApplications = p.readInt();
    if(numApplications > IccCardStatus.CARD_MAX_APPS)        
        {
            numApplications = IccCardStatus.CARD_MAX_APPS;
        } //End block
        status.setNumApplications(numApplications);
for(int i = 0;i < numApplications;i++)
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
Object var62D3D5D442782C1992154E821A40FA75_1627159437 =         status;
        var62D3D5D442782C1992154E821A40FA75_1627159437.addTaint(taint);
        return var62D3D5D442782C1992154E821A40FA75_1627159437;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.961 -0400", hash_original_method = "26536CEB9BA98624BF6B84456E63F303", hash_generated_method = "8817193DD1D43447CC91036033B86C17")
    private Object responseCallList(Parcel p) {
        addTaint(p.getTaint());
        int num;
        int voiceSettings;
        ArrayList<DriverCall> response;
        DriverCall dc;
        num = p.readInt();
        response = new ArrayList<DriverCall>(num);
for(int i = 0;i < num;i++)
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
    if(uusInfoPresent == 1)            
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
            } //End block
            else
            {
                riljLogv("Incoming UUS : NOT present!");
            } //End block
            dc.number = PhoneNumberUtils.stringFromStringAndTOA(dc.number, dc.TOA);
            response.add(dc);
    if(dc.isVoicePrivacy)            
            {
                mVoicePrivacyOnRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is enabled");
            } //End block
            else
            {
                mVoicePrivacyOffRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is disabled");
            } //End block
        } //End block
        Collections.sort(response);
Object var2A1114F4272D753FE23A36E3D68CD293_1674619373 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1674619373.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1674619373;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.963 -0400", hash_original_method = "ED5CAFCBF47B1330CD2566A0B897CA0C", hash_generated_method = "BCB60CDC59EB77500AD06710EA86C90C")
    private DataCallState getDataCallState(Parcel p, int version) {
        addTaint(version);
        addTaint(p.getTaint());
        DataCallState dataCall = new DataCallState();
        dataCall.version = version;
    if(version < 5)        
        {
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            String addresses = p.readString();
    if(!TextUtils.isEmpty(addresses))            
            {
                dataCall.addresses = addresses.split(" ");
            } //End block
        } //End block
        else
        {
            dataCall.status = p.readInt();
            dataCall.suggestedRetryTime = p.readInt();
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            dataCall.ifname = p.readString();
    if((dataCall.status == DataConnection.FailCause.NONE.getErrorCode()) &&
                    TextUtils.isEmpty(dataCall.ifname))            
            {
                RuntimeException var8405CADCB98D15E5F158252C86B46497_2138785868 = new RuntimeException("getDataCallState, no ifname");
                var8405CADCB98D15E5F158252C86B46497_2138785868.addTaint(taint);
                throw var8405CADCB98D15E5F158252C86B46497_2138785868;
            } //End block
            String addresses = p.readString();
    if(!TextUtils.isEmpty(addresses))            
            {
                dataCall.addresses = addresses.split(" ");
            } //End block
            String dnses = p.readString();
    if(!TextUtils.isEmpty(dnses))            
            {
                dataCall.dnses = dnses.split(" ");
            } //End block
            String gateways = p.readString();
    if(!TextUtils.isEmpty(gateways))            
            {
                dataCall.gateways = gateways.split(" ");
            } //End block
        } //End block
DataCallState var1FA3F27DDFFF65A1C78D28EE65B36A1F_342168260 =         dataCall;
        var1FA3F27DDFFF65A1C78D28EE65B36A1F_342168260.addTaint(taint);
        return var1FA3F27DDFFF65A1C78D28EE65B36A1F_342168260;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.964 -0400", hash_original_method = "123D49A321BB97EFA9843423F7545450", hash_generated_method = "C65A2CBF64FAC9ACE797B9E4E375A201")
    private Object responseDataCallList(Parcel p) {
        addTaint(p.getTaint());
        ArrayList<DataCallState> response;
        int ver = p.readInt();
        int num = p.readInt();
        riljLog("responseDataCallList ver=" + ver + " num=" + num);
        response = new ArrayList<DataCallState>(num);
for(int i = 0;i < num;i++)
        {
            response.add(getDataCallState(p, ver));
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_710663683 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_710663683.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_710663683;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.965 -0400", hash_original_method = "6E11D362E553C380CF6ADBFD5304CD05", hash_generated_method = "1F0D8428383A370C281F290B390B0BD1")
    private Object responseSetupDataCall(Parcel p) {
        addTaint(p.getTaint());
        int ver = p.readInt();
        int num = p.readInt();
    if(RILJ_LOGV)        
        riljLog("responseSetupDataCall ver=" + ver + " num=" + num);
        DataCallState dataCall;
    if(ver < 5)        
        {
            dataCall = new DataCallState();
            dataCall.version = ver;
            dataCall.cid = Integer.parseInt(p.readString());
            dataCall.ifname = p.readString();
    if(TextUtils.isEmpty(dataCall.ifname))            
            {
                RuntimeException var07D8741E9F54B07F3ED5A991C2C9886E_132906091 = new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response, no ifname");
                var07D8741E9F54B07F3ED5A991C2C9886E_132906091.addTaint(taint);
                throw var07D8741E9F54B07F3ED5A991C2C9886E_132906091;
            } //End block
            String addresses = p.readString();
    if(!TextUtils.isEmpty(addresses))            
            {
                dataCall.addresses = addresses.split(" ");
            } //End block
    if(num >= 4)            
            {
                String dnses = p.readString();
    if(RILJ_LOGD)                
                riljLog("responseSetupDataCall got dnses=" + dnses);
    if(!TextUtils.isEmpty(dnses))                
                {
                    dataCall.dnses = dnses.split(" ");
                } //End block
            } //End block
    if(num >= 5)            
            {
                String gateways = p.readString();
    if(RILJ_LOGD)                
                riljLog("responseSetupDataCall got gateways=" + gateways);
    if(!TextUtils.isEmpty(gateways))                
                {
                    dataCall.gateways = gateways.split(" ");
                } //End block
            } //End block
        } //End block
        else
        {
    if(num != 1)            
            {
                RuntimeException varC7A41519B460DCD5DB34E74BB4F3C0D6_1053434816 = new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response expecting 1 RIL_Data_Call_response_v5"
                        + " got " + num);
                varC7A41519B460DCD5DB34E74BB4F3C0D6_1053434816.addTaint(taint);
                throw varC7A41519B460DCD5DB34E74BB4F3C0D6_1053434816;
            } //End block
            dataCall = getDataCallState(p, ver);
        } //End block
Object var1FA3F27DDFFF65A1C78D28EE65B36A1F_945005684 =         dataCall;
        var1FA3F27DDFFF65A1C78D28EE65B36A1F_945005684.addTaint(taint);
        return var1FA3F27DDFFF65A1C78D28EE65B36A1F_945005684;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.966 -0400", hash_original_method = "F2D5C4032BE6024B6126759412E50A01", hash_generated_method = "E215E20EAA427A674FD2528F0126287F")
    private Object responseOperatorInfos(Parcel p) {
        addTaint(p.getTaint());
        String strings[] = (String [])responseStrings(p);
        ArrayList<OperatorInfo> ret;
    if(strings.length % 4 != 0)        
        {
            RuntimeException varD856F6F2F980354E8E3EB71B536B0E7A_1180875145 = new RuntimeException(
                "RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got "
                + strings.length + " strings, expected multible of 4");
            varD856F6F2F980354E8E3EB71B536B0E7A_1180875145.addTaint(taint);
            throw varD856F6F2F980354E8E3EB71B536B0E7A_1180875145;
        } //End block
        ret = new ArrayList<OperatorInfo>(strings.length / 4);
for(int i = 0;i < strings.length;i += 4)
        {
            ret.add (
                new OperatorInfo(
                    strings[i+0],
                    strings[i+1],
                    strings[i+2],
                    strings[i+3]));
        } //End block
Object varEDFF4FBBF053B5DC2B444ADFA049EE0F_60610381 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_60610381.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_60610381;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.967 -0400", hash_original_method = "E4123D5DA30749CB6D4FFE47F8C7BEAC", hash_generated_method = "08C8BA9C35DB4B55E54C1FA3E2A1B884")
    private Object responseCellList(Parcel p) {
        addTaint(p.getTaint());
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
    if(radioString.equals("GPRS"))        
        {
            radioType = NETWORK_TYPE_GPRS;
        } //End block
        else
    if(radioString.equals("EDGE"))        
        {
            radioType = NETWORK_TYPE_EDGE;
        } //End block
        else
    if(radioString.equals("UMTS"))        
        {
            radioType = NETWORK_TYPE_UMTS;
        } //End block
        else
    if(radioString.equals("HSDPA"))        
        {
            radioType = NETWORK_TYPE_HSDPA;
        } //End block
        else
    if(radioString.equals("HSUPA"))        
        {
            radioType = NETWORK_TYPE_HSUPA;
        } //End block
        else
    if(radioString.equals("HSPA"))        
        {
            radioType = NETWORK_TYPE_HSPA;
        } //End block
        else
        {
            radioType = NETWORK_TYPE_UNKNOWN;
        } //End block
    if(radioType != NETWORK_TYPE_UNKNOWN)        
        {
for(int i = 0;i < num;i++)
            {
                rssi = p.readInt();
                location = p.readString();
                cell = new NeighboringCellInfo(rssi, location, radioType);
                response.add(cell);
            } //End block
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_850184970 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_850184970.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_850184970;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.968 -0400", hash_original_method = "225C4A262B1740AD55FF47639121D5EF", hash_generated_method = "F483277527E9A5C0D1B71F09A6382301")
    private Object responseGetPreferredNetworkType(Parcel p) {
        addTaint(p.getTaint());
        int [] response = (int[]) responseInts(p);
    if(response.length >= 1)        
        {
            mPreferredNetworkType = response[0];
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_800578972 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_800578972.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_800578972;
        // ---------- Original Method ----------
        //int [] response = (int[]) responseInts(p);
        //if (response.length >= 1) {
           //mPreferredNetworkType = response[0];
       //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.970 -0400", hash_original_method = "C459166A8880B065FE8A1B083AFDAF89", hash_generated_method = "C57735E34DC307C4D9CFBA2AD771D66F")
    private Object responseGmsBroadcastConfig(Parcel p) {
        addTaint(p.getTaint());
        int num;
        ArrayList<SmsBroadcastConfigInfo> response;
        SmsBroadcastConfigInfo info;
        num = p.readInt();
        response = new ArrayList<SmsBroadcastConfigInfo>(num);
for(int i = 0;i < num;i++)
        {
            int fromId = p.readInt();
            int toId = p.readInt();
            int fromScheme = p.readInt();
            int toScheme = p.readInt();
            boolean selected = (p.readInt() == 1);
            info = new SmsBroadcastConfigInfo(fromId, toId, fromScheme,
                    toScheme, selected);
            response.add(info);
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_269408000 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_269408000.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_269408000;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.971 -0400", hash_original_method = "55259F8FDA4B0C41A34B6184E02D7C2F", hash_generated_method = "8A93822217A68350AC7839B7C91F8191")
    private Object responseCdmaBroadcastConfig(Parcel p) {
        addTaint(p.getTaint());
        int numServiceCategories;
        int response[];
        numServiceCategories = p.readInt();
    if(numServiceCategories == 0)        
        {
            int numInts;
            numInts = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES * CDMA_BSI_NO_OF_INTS_STRUCT + 1;
            response = new int[numInts];
            response[0] = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES;
for(int i = 1;i < numInts;i += CDMA_BSI_NO_OF_INTS_STRUCT)
            {
                response[i + 0] = i / CDMA_BSI_NO_OF_INTS_STRUCT;
                response[i + 1] = 1;
                response[i + 2] = 0;
            } //End block
        } //End block
        else
        {
            int numInts;
            numInts = (numServiceCategories * CDMA_BSI_NO_OF_INTS_STRUCT) + 1;
            response = new int[numInts];
            response[0] = numServiceCategories;
for(int i = 1;i < numInts;i++)
            {
                response[i] = p.readInt();
            } //End block
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_1137216658 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1137216658.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1137216658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.973 -0400", hash_original_method = "90CED6467BA07D7B46A1F95705E3AC70", hash_generated_method = "968D0B342020F7E878C51EA3AF074580")
    private Object responseSignalStrength(Parcel p) {
        addTaint(p.getTaint());
        int numInts = 12;
        int response[];
        response = new int[numInts];
for(int i = 0;i < numInts;i++)
        {
            response[i] = p.readInt();
        } //End block
Object var2A1114F4272D753FE23A36E3D68CD293_1685907958 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1685907958.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1685907958;
        // ---------- Original Method ----------
        //int numInts = 12;
        //int response[];
        //response = new int[numInts];
        //for (int i = 0 ; i < numInts ; i++) {
            //response[i] = p.readInt();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.973 -0400", hash_original_method = "07F57EA5026D76F851755C6714CD7CB2", hash_generated_method = "32999EFEFF814828B03BE6036FC7BFDC")
    private ArrayList<CdmaInformationRecords> responseCdmaInformationRecord(Parcel p) {
        addTaint(p.getTaint());
        int numberOfInfoRecs;
        ArrayList<CdmaInformationRecords> response;
        numberOfInfoRecs = p.readInt();
        response = new ArrayList<CdmaInformationRecords>(numberOfInfoRecs);
for(int i = 0;i < numberOfInfoRecs;i++)
        {
            CdmaInformationRecords InfoRec = new CdmaInformationRecords(p);
            response.add(InfoRec);
        } //End block
ArrayList<CdmaInformationRecords> var2A1114F4272D753FE23A36E3D68CD293_1623757220 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1623757220.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1623757220;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.975 -0400", hash_original_method = "C7CB5D07451D489A78BF82365C5A0B27", hash_generated_method = "ED205BBB0A3DF3823B5159A6CE445E1A")
    private Object responseCdmaCallWaiting(Parcel p) {
        addTaint(p.getTaint());
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
Object var2ED9E3026D104797820BFDEFB87E16D8_1944319355 =         notification;
        var2ED9E3026D104797820BFDEFB87E16D8_1944319355.addTaint(taint);
        return var2ED9E3026D104797820BFDEFB87E16D8_1944319355;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.975 -0400", hash_original_method = "F4EF6B3A014077C64691F0B8D26D4AED", hash_generated_method = "6B993E4A4FCC7D0C5E0E637F17DA9D09")
    private Object responseCallRing(Parcel p) {
        addTaint(p.getTaint());
        char response[] = new char[4];
        response[0] = (char) p.readInt();
        response[1] = (char) p.readInt();
        response[2] = (char) p.readInt();
        response[3] = (char) p.readInt();
Object var2A1114F4272D753FE23A36E3D68CD293_1922272310 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1922272310.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1922272310;
        // ---------- Original Method ----------
        //char response[] = new char[4];
        //response[0] = (char) p.readInt();
        //response[1] = (char) p.readInt();
        //response[2] = (char) p.readInt();
        //response[3] = (char) p.readInt();
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.975 -0400", hash_original_method = "04666C2E99832FCFAFCF388A68EF0610", hash_generated_method = "03AC5866853A945A2266B0A725D503BE")
    private void notifyRegistrantsCdmaInfoRec(CdmaInformationRecords infoRec) {
        addTaint(infoRec.getTaint());
        int response = RIL_UNSOL_CDMA_INFO_REC;
    if(infoRec.record instanceof CdmaInformationRecords.CdmaDisplayInfoRec)        
        {
    if(mDisplayInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mDisplayInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaSignalInfoRec)        
        {
    if(mSignalInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mSignalInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaNumberInfoRec)        
        {
    if(mNumberInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mNumberInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaRedirectingNumberInfoRec)        
        {
    if(mRedirNumInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mRedirNumInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaLineControlInfoRec)        
        {
    if(mLineControlInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mLineControlInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaT53ClirInfoRec)        
        {
    if(mT53ClirInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mT53ClirInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        else
    if(infoRec.record instanceof CdmaInformationRecords.CdmaT53AudioControlInfoRec)        
        {
    if(mT53AudCntrlInfoRegistrants != null)            
            {
    if(RILJ_LOGD)                
                unsljLogRet(response, infoRec.record);
                mT53AudCntrlInfoRegistrants.notifyRegistrants(
                       new AsyncResult (null, infoRec.record, null));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.978 -0400", hash_original_method = "513B160CE13530A75C92D2BB2C156FD7", hash_generated_method = "7191248F88B337464E60DBF0AC3437D8")
    private void riljLog(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.978 -0400", hash_original_method = "709360DE622013B25C1B037A3416C3B6", hash_generated_method = "A6A9E98C2BCD8F608F27D186F899DF39")
    private void riljLogv(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.v(LOG_TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.978 -0400", hash_original_method = "2B7AB7C6A9DFCD91149097CF23FA21DF", hash_generated_method = "6B37F2ADCC5A5CADD310B6B073A41567")
    private void unsljLog(int response) {
        addTaint(response);
        riljLog("[UNSL]< " + responseToString(response));
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.979 -0400", hash_original_method = "B9D4DA0AB06082664757422C0E23F4B2", hash_generated_method = "57945EC78A2148C3F886934911D16295")
    private void unsljLogMore(int response, String more) {
        addTaint(more.getTaint());
        addTaint(response);
        riljLog("[UNSL]< " + responseToString(response) + " " + more);
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response) + " " + more);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.979 -0400", hash_original_method = "02F7DA800ECB6E455062B2AF08D2856E", hash_generated_method = "1F9CBF97F36CE9BF2D0611B58A074DB5")
    private void unsljLogRet(int response, Object ret) {
        addTaint(ret.getTaint());
        addTaint(response);
        riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        // ---------- Original Method ----------
        //riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "5479F9B9AF9D3C3FE7229BC789506755", hash_generated_method = "D438B3FC29860AFEFDA859AE37861CFF")
    private void unsljLogvRet(int response, Object ret) {
        addTaint(ret.getTaint());
        addTaint(response);
        riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
        // ---------- Original Method ----------
        //riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "B8DB86D0D3DD2A6C87C6DBBEA17396A3", hash_generated_method = "5D139D628FEB99EDA431682021B33782")
    public void getDeviceIdentity(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "2F4B55F10DAACCDACB48694F0AD6C5FC", hash_generated_method = "B0D7F797278DDB70269D23D8F3639FD9")
    public void getCDMASubscription(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "CD84ED40ADC2BEFF960D6D373762CCB2", hash_generated_method = "CFB35B89F2093ADC61AE6C86C7DC919B")
    @Override
    public void setPhoneType(int phoneType) {
        addTaint(phoneType);
    if(RILJ_LOGD)        
        riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        mPhoneType = phoneType;
        // ---------- Original Method ----------
        //if (RILJ_LOGD) riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        //mPhoneType = phoneType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "849E6CD9CCE8F1ECF8BC959270B499A0", hash_generated_method = "A9D93A160068A8A5D0DDDBFB20479793")
    public void queryCdmaRoamingPreference(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.980 -0400", hash_original_method = "BC2979EAC0CBA90D634290B385917086", hash_generated_method = "77B5A62B1431C55F45A117B842EAD10D")
    public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaRoamingType);
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaRoamingType);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaRoamingType);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(cdmaRoamingType);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + cdmaRoamingType);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.981 -0400", hash_original_method = "5B737D91D0E47D0010D2976568B23A82", hash_generated_method = "493E3231D476DF8D53BC1A16A1280E4F")
    public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        addTaint(response.getTaint());
        addTaint(cdmaSubscription);
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaSubscription);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaSubscription);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(cdmaSubscription);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + cdmaSubscription);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.982 -0400", hash_original_method = "5EEECA9C4DAFB6EB7CE2420CACC9812C", hash_generated_method = "88DECD4ECEAE7C22D10092CC1D5AA56B")
    @Override
    public void getCdmaSubscriptionSource(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.982 -0400", hash_original_method = "116710C0DB0DC531DE694B6BC2F4AE2B", hash_generated_method = "7D13486C5C34B8DEBCD814F6235E0A57")
    public void queryTTYMode(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.982 -0400", hash_original_method = "0B5DA23B67CE8A881960D39226001892", hash_generated_method = "DF9C042C2EFA3ECEEAB91C314FAF8A03")
    public void setTTYMode(int ttyMode, Message response) {
        addTaint(response.getTaint());
        addTaint(ttyMode);
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_TTY_MODE, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(ttyMode);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + ttyMode);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(
                //RILConstants.RIL_REQUEST_SET_TTY_MODE, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(ttyMode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + ttyMode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.982 -0400", hash_original_method = "9DB0667959C6184F19426DF0FB910315", hash_generated_method = "1F8D18089C22873ED66E90848F6DEB9B")
    public void sendCDMAFeatureCode(String FeatureCode, Message response) {
        addTaint(response.getTaint());
        addTaint(FeatureCode.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);
        rr.mp.writeString(FeatureCode);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + FeatureCode);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);
        //rr.mp.writeString(FeatureCode);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                //+ " : " + FeatureCode);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.983 -0400", hash_original_method = "EB6E132144573DF781138A585850ED0A", hash_generated_method = "B71AC3C19B84E314BC07287BEFA983F2")
    public void getCdmaBroadcastConfig(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.983 -0400", hash_original_method = "7AE57418607D61F0BA79FD2FF4F728AF", hash_generated_method = "A02F186B72F0B4F944C5832C842B12C3")
    public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);
for(int i = 0;i < configValuesArray.length;i++)
        {
            rr.mp.writeInt(configValuesArray[i]);
        } //End block
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);
        //for(int i = 0; i < configValuesArray.length; i++) {
            //rr.mp.writeInt(configValuesArray[i]);
        //}
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.983 -0400", hash_original_method = "41C22C7BD9DE14E15F4803649E353969", hash_generated_method = "47C72E24668B9BC9FEA33AFDAB4E6363")
    public void setCdmaBroadcastActivation(boolean activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 :1);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);
        //rr.mp.writeInt(1);
        //rr.mp.writeInt(activate ? 0 :1);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.984 -0400", hash_original_method = "82BAE0E7FF72D1A409D61F03DD8EFEA2", hash_generated_method = "7E12CF9E80DE6002ED688562E8DDD8C1")
    public void exitEmergencyCallbackMode(Message response) {
        addTaint(response.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.984 -0400", hash_original_method = "381EF137384490D69DA50E927DA4C209", hash_generated_method = "C11E4B51EBC2DADB7949029AFCF69038")
    public void requestIsimAuthentication(String nonce, Message response) {
        addTaint(response.getTaint());
        addTaint(nonce.getTaint());
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);
        rr.mp.writeString(nonce);
    if(RILJ_LOGD)        
        riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        send(rr);
        // ---------- Original Method ----------
        //RILRequest rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);
        //rr.mp.writeString(nonce);
        //if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));
        //send(rr);
    }

    
    class RILSender extends Handler implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.984 -0400", hash_original_field = "99EC5806475395530F37CCDC6DD85CE7", hash_generated_field = "D1362109E83ED4221773106790FD549F")

        byte[] dataLength = new byte[4];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.984 -0400", hash_original_method = "4D17817439BCC34837C575257CF9147F", hash_generated_method = "29FB6336B11BB21F807AB588DD6B15C1")
        public  RILSender(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.984 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "A2E5AE58616EECC7176440E5139E1684")
        public void run() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.986 -0400", hash_original_method = "D25DB5A43D9B976C2A2C198EC34CFB08", hash_generated_method = "4580812575F11694229823501C27C797")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            RILRequest rr = (RILRequest)(msg.obj);
            RILRequest req = null;
switch(msg.what){
            case EVENT_SEND:
            boolean alreadySubtracted = false;
            try 
            {
                LocalSocket s;
                s = mSocket;
    if(s == null)                
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
    if(mRequestMessagesPending > 0)                    
                    mRequestMessagesPending--;
                    alreadySubtracted = true;
                    return;
                } //End block
                synchronized
(mRequestsList)                {
                    mRequestsList.add(rr);
                    mRequestMessagesWaiting++;
                } //End block
    if(mRequestMessagesPending > 0)                
                mRequestMessagesPending--;
                alreadySubtracted = true;
                byte[] data;
                data = rr.mp.marshall();
                rr.mp.recycle();
                rr.mp = null;
    if(data.length > RIL_MAX_COMMAND_BYTES)                
                {
                    RuntimeException var83DABE5BB69C73B17ACD1A40CDC7D5C1_912418506 = new RuntimeException(
                                    "Parcel larger than max bytes allowed! "
                                                          + data.length);
                    var83DABE5BB69C73B17ACD1A40CDC7D5C1_912418506.addTaint(taint);
                    throw var83DABE5BB69C73B17ACD1A40CDC7D5C1_912418506;
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
    if(req != null || !alreadySubtracted)                
                {
                    rr.onError(RADIO_NOT_AVAILABLE, null);
                    rr.release();
                } //End block
            } //End block
            catch (RuntimeException exc)
            {
                req = findAndRemoveRequestFromList(rr.mSerial);
    if(req != null || !alreadySubtracted)                
                {
                    rr.onError(GENERIC_FAILURE, null);
                    rr.release();
                } //End block
            } //End block
            finally 
            {
                releaseWakeLockIfDone();
            } //End block
    if(!alreadySubtracted && mRequestMessagesPending > 0)            
            {
                mRequestMessagesPending--;
            } //End block
            break;
            case EVENT_WAKE_LOCK_TIMEOUT:
            synchronized
(mWakeLock)            {
    if(mWakeLock.isHeld())                
                {
    if(mRequestMessagesWaiting != 0)                    
                    {
                        Log.d(LOG_TAG, "NOTE: mReqWaiting is NOT 0 but"
                                        + mRequestMessagesWaiting + " at TIMEOUT, reset!"
                                        + " There still msg waitng for response");
                        mRequestMessagesWaiting = 0;
    if(RILJ_LOGD)                        
                        {
                            synchronized
(mRequestsList)                            {
                                int count = mRequestsList.size();
                                Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                                                " mRequestList=" + count);
for(int i = 0;i < count;i++)
                                {
                                    rr = mRequestsList.get(i);
                                    Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] "
                                                    + requestToString(rr.mRequest));
                                } //End block
                            } //End block
                        } //End block
                    } //End block
    if(mRequestMessagesPending != 0)                    
                    {
                        mRequestMessagesPending = 0;
                    } //End block
                    mWakeLock.release();
                } //End block
            } //End block
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class RILReceiver implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.986 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

        byte[] buffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.986 -0400", hash_original_method = "AEB7D4EC0C0D3B29B57F76734A093487", hash_generated_method = "832D356F5AA3BF59D3700679E90409AE")
          RILReceiver() {
            buffer = new byte[RIL_MAX_COMMAND_BYTES];
            // ---------- Original Method ----------
            //buffer = new byte[RIL_MAX_COMMAND_BYTES];
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_method = "3E25FFC0D00CEB4B0CF0C518A51DB777", hash_generated_method = "80F9CF4511441DA19A43E646B384E2A3")
        public void run() {
            int retryCount = 0;
            try 
            {
for(;;)
                {
                    LocalSocket s = null;
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
    if(s != null)                            
                            {
                                s.close();
                            } //End block
                        } //End block
                        catch (IOException ex2)
                        {
                        } //End block
    if(retryCount == 8)                        
                        {
                        } //End block
                        else
    if(retryCount > 0 && retryCount < 8)                        
                        {
                        } //End block
                        try 
                        {
                            Thread.sleep(SOCKET_OPEN_RETRY_MILLIS);
                        } //End block
                        catch (InterruptedException er)
                        {
                        } //End block
                        retryCount++;
                        continue;
                    } //End block
                    retryCount = 0;
                    mSocket = s;
                    int length = 0;
                    try 
                    {
                        InputStream is = mSocket.getInputStream();
for(;;)
                        {
                            Parcel p;
                            length = readRilMessage(is, buffer);
    if(length < 0)                            
                            {
                                break;
                            } //End block
                            p = Parcel.obtain();
                            p.unmarshall(buffer, 0, length);
                            p.setDataPosition(0);
                            processResponse(p);
                            p.recycle();
                        } //End block
                    } //End block
                    catch (java.io.IOException ex)
                    {
                    } //End block
                    catch (Throwable tr)
                    {
                    } //End block
                    setRadioState (RadioState.RADIO_UNAVAILABLE);
                    try 
                    {
                        mSocket.close();
                    } //End block
                    catch (IOException ex)
                    {
                    } //End block
                    mSocket = null;
                    RILRequest.resetSerial();
                    clearRequestsList(RADIO_NOT_AVAILABLE, false);
                } //End block
            } //End block
            catch (Throwable tr)
            {
            } //End block
            notifyRegistrantsRilConnectionChanged(-1);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "95B615EB080B0B03275A98143E04691C", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "97BCE9C97BFBAA0A5C9DFC01C512C8DD", hash_generated_field = "E8AEBB7BC1E8DE7102DD065D634CC293")

    static final boolean RILJ_LOGD = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "F756B39DA24610C6F147A03CB86C32C2", hash_generated_field = "0C6948A169D6E1D2E1ADEB0F80785D40")

    static final boolean RILJ_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "6E111A082683CFC823505D73C04427F7", hash_generated_field = "571245F8DE39B2C924A36FAE73EBBA44")

    private static final int DEFAULT_WAKE_LOCK_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "08D692F77DFF6777C68397D86FEB9673", hash_generated_field = "EAFA57C607FF50983754A1B1A1DB0736")

    static final int EVENT_SEND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "57F4D6DC61899A880DD9EEDBA4F80E99", hash_generated_field = "6A179A477F6E9E6E9040DC18977E01CB")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.990 -0400", hash_original_field = "02403D71B4446414F4F3E9A28C344489", hash_generated_field = "A95740DBA07261E1CEACA3FF20211052")

    static final int RIL_MAX_COMMAND_BYTES = (8 * 1024);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "0838500EAFB49E0F91ECEFAAF400CACC", hash_generated_field = "7A9920177945AAD6E3BDD930CB1D5FDA")

    static final int RESPONSE_SOLICITED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "8186BFE56666A15DDA7631C9969B8ECA", hash_generated_field = "F7189327FBCA5256349AE6998692EE59")

    static final int RESPONSE_UNSOLICITED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "631DB341385DA34F9C870222FFCB6E51", hash_generated_field = "66495E17EC0A0057CA4BC33F77ACB85F")

    static final String SOCKET_NAME_RIL = "rild";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "8743C5F3EB20F43B4A7B1384E1EE0BAB", hash_generated_field = "0C3577BF4F60D2979C4EC6F1261A00D0")

    static final int SOCKET_OPEN_RETRY_MILLIS = 4 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "FFFA1391A6C60617637A5396E1A930EF", hash_generated_field = "B2ADEC73809EA29CBEB65E83BD1B055F")

    private static final int CDMA_BSI_NO_OF_INTS_STRUCT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.991 -0400", hash_original_field = "75B7020754749B8753BB0C8AD8761874", hash_generated_field = "8AC0B7212834068F171EE2AA5B80B5F8")

    private static final int CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES = 31;
}

