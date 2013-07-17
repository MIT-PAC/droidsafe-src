package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.AlertDialog;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.provider.Telephony;
import android.provider.Telephony.Sms.Intents;
import android.provider.Settings;
import android.telephony.SmsMessage;
import android.telephony.ServiceState;
import android.util.Log;
import android.view.WindowManager;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import com.android.internal.util.HexDump;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import com.android.internal.R;
import static android.telephony.SmsManager.RESULT_ERROR_GENERIC_FAILURE;
import static android.telephony.SmsManager.RESULT_ERROR_NO_SERVICE;
import static android.telephony.SmsManager.RESULT_ERROR_NULL_PDU;
import static android.telephony.SmsManager.RESULT_ERROR_RADIO_OFF;
import static android.telephony.SmsManager.RESULT_ERROR_LIMIT_EXCEEDED;
import static android.telephony.SmsManager.RESULT_ERROR_FDN_CHECK_FAILURE;

public abstract class SMSDispatcher extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.933 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "510AC3BCB553F2FCF25972E2B33B836E")

    protected Phone mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.933 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.933 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "1630B770F00F809F8A5B7416CDE08CE2")

    protected ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.933 -0400", hash_original_field = "25D05DACB60858FF7568DE121D7FA36E", hash_generated_field = "44EA14B31E3BA933B4545BB894F8D6DD")

    protected CommandsInterface mCm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.933 -0400", hash_original_field = "A4E1B1A0C61EB50DE36D51B04F65122F", hash_generated_field = "08614CFD2E3E82A161B96FD6C9B9DF18")

    protected SmsStorageMonitor mStorageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "37B1953FF61F1B4EA6CF0E80B80975BE", hash_generated_field = "C7C6750503CDF0D5CF55C5995F1C9804")

    protected WapPushOverSms mWapPush;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "B4FB4A52F50084038CDC4594A0CC9626", hash_generated_field = "981B42A4AA7D7D76FE92CC8FC3EE9217")

    private SmsUsageMonitor mUsageMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "987BEC944D753473DF7E0E3C95DC7067", hash_generated_field = "0B6FB9FECCEC20F6DE6894D17734CFA2")

    private final ArrayList<SmsTracker> mSTrackers = new ArrayList<SmsTracker>(MO_MSG_QUEUE_LIMIT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "E4A7B9EA3B89381AD658E46204000FC5", hash_generated_field = "75EC0D7E6490B0B96D0939B9BF71FB36")

    protected boolean mSmsCapable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "CF80382EA6A92B376D13A0C231B56D18", hash_generated_field = "48579404C4E8F347286B87F7AF0DEE4A")

    protected boolean mSmsReceiveDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "BCC856D1D0C86ACF8BB86ABAE3A55A70", hash_generated_field = "B2DE65098D4A7C2D922A3707F98FAFC2")

    protected boolean mSmsSendDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "0AA236242112B4C52C5EDBED77F33800", hash_generated_field = "1409A3903A93A2C1F6F0AE76F3BE60FA")

    protected int mRemainingMessages = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.934 -0400", hash_original_field = "E0FB4A328A021E5BE6017CC1F501D5B3", hash_generated_field = "4A1B9E66379D834EE928048F1AFEC780")

    protected final ArrayList<SmsTracker> deliveryPendingList = new ArrayList<SmsTracker>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.796 -0400", hash_original_field = "00D154D7BC8D96B226A05CA48552CBAB", hash_generated_field = "9BC5400217A67A28F08377351C107820")

    private final DialogInterface.OnClickListener mListener = new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.795 -0400", hash_original_method = "318A7382B4CDEC030B530C6AA43A7A60", hash_generated_method = "DB9DB055783B1C757F59603348C158F4")
        public void onClick(DialogInterface dialog, int which) {
            
            {
                Log.d(TAG, "click YES to send out sms");
                sendMessage(obtainMessage(EVENT_SEND_CONFIRMED_SMS));
            } 
            {
                Log.d(TAG, "click NO to stop sending");
                sendMessage(obtainMessage(EVENT_STOP_SENDING));
            } 
            addTaint(dialog.getTaint());
            addTaint(which);
            
            
                    
                    
                
                    
                    
                
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.796 -0400", hash_original_field = "3BD1FD2D59441EC9D67424C813CB8822", hash_generated_field = "6836B0FA743263ABE1B2C701A5021A92")

    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.796 -0400", hash_original_method = "DB25CB42F24A1F0004F16056EEBCBE73", hash_generated_method = "2EB066921744C6644579A933780E2AC4")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            int rc = getResultCode();
            boolean success = (rc == Activity.RESULT_OK)
                    || (rc == Intents.RESULT_SMS_HANDLED);
            acknowledgeLastIncomingSms(success, rc, null);
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
                    
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.936 -0400", hash_original_method = "E354AE25961418D172CBDDA3C2433B63", hash_generated_method = "D72989E2ABCB6DB79C5E5D45173611FE")
    protected  SMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        mPhone = phone;
        mWapPush = new WapPushOverSms(phone, this);
        mContext = phone.getContext();
        mResolver = mContext.getContentResolver();
        mCm = phone.mCM;
        mStorageMonitor = storageMonitor;
        mUsageMonitor = usageMonitor;
        createWakelock();
        mSmsCapable = mContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable);
        mSmsReceiveDisabled = !SystemProperties.getBoolean(
                                TelephonyProperties.PROPERTY_SMS_RECEIVE, mSmsCapable);
        mSmsSendDisabled = !SystemProperties.getBoolean(
                                TelephonyProperties.PROPERTY_SMS_SEND, mSmsCapable);
        Log.d(TAG, "SMSDispatcher: ctor mSmsCapable=" + mSmsCapable + " format=" + getFormat()
                + " mSmsReceiveDisabled=" + mSmsReceiveDisabled
                + " mSmsSendDisabled=" + mSmsSendDisabled);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected static int getNextConcatenatedRef() {
        sConcatenatedRef += 1;
        return sConcatenatedRef;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void dispose();

    
    @DSModeled(DSC.SAFE)
    protected abstract String getFormat();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.937 -0400", hash_original_method = "FF8B1C8CEEDF99CA4428854C45370A3A", hash_generated_method = "9C45BC8177998F07A273AAC14939D123")
    @Override
    protected void finalize() {
        Log.d(TAG, "SMSDispatcher finalized");
        // ---------- Original Method ----------
        //Log.d(TAG, "SMSDispatcher finalized");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.938 -0400", hash_original_method = "42D9652DD1B0FE51DCC6557D894D344B", hash_generated_method = "43F503B35F317D9FB3115D6E9B210A53")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_NEW_SMS:
        if(false)        
        {
            Log.d(TAG, "New SMS Message Received");
        } //End block
        SmsMessage sms;
        ar = (AsyncResult) msg.obj;
        if(ar.exception != null)        
        {
            return;
        } //End block
        sms = (SmsMessage) ar.result;
        try 
        {
            int result = dispatchMessage(sms.mWrappedSmsMessage);
            if(result != Activity.RESULT_OK)            
            {
                boolean handled = (result == Intents.RESULT_SMS_HANDLED);
                notifyAndAcknowledgeLastIncomingSms(handled, result, null);
            } //End block
        } //End block
        catch (RuntimeException ex)
        {
            notifyAndAcknowledgeLastIncomingSms(false, Intents.RESULT_SMS_GENERIC_ERROR, null);
        } //End block
        break;
        case EVENT_SEND_SMS_COMPLETE:
        handleSendComplete((AsyncResult) msg.obj);
        break;
        case EVENT_SEND_RETRY:
        sendSms((SmsTracker) msg.obj);
        break;
        case EVENT_POST_ALERT:
        handleReachSentLimit((SmsTracker)(msg.obj));
        break;
        case EVENT_ALERT_TIMEOUT:
        ((AlertDialog)(msg.obj)).dismiss();
        msg.obj = null;
        if(mSTrackers.isEmpty() == false)        
        {
            try 
            {
                SmsTracker sTracker = mSTrackers.remove(0);
                sTracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
            } //End block
            catch (CanceledException ex)
            {
            } //End block
        } //End block
        if(false)        
        {
            Log.d(TAG, "EVENT_ALERT_TIMEOUT, message stop sending");
        } //End block
        break;
        case EVENT_SEND_CONFIRMED_SMS:
        if(mSTrackers.isEmpty() == false)        
        {
            SmsTracker sTracker = mSTrackers.remove(mSTrackers.size() - 1);
            if(sTracker.isMultipart())            
            {
                sendMultipartSms(sTracker);
            } //End block
            else
            {
                sendSms(sTracker);
            } //End block
            removeMessages(EVENT_ALERT_TIMEOUT, msg.obj);
        } //End block
        break;
        case EVENT_STOP_SENDING:
        if(mSTrackers.isEmpty() == false)        
        {
            try 
            {
                SmsTracker sTracker = mSTrackers.remove(mSTrackers.size() - 1);
                sTracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
            } //End block
            catch (CanceledException ex)
            {
            } //End block
            removeMessages(EVENT_ALERT_TIMEOUT, msg.obj);
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.944 -0400", hash_original_method = "1E59FCBE70CAB945B533C092F603248E", hash_generated_method = "D59BF0F9CEBBA085E16694B8F358387E")
    private void createWakelock() {
        PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SMSDispatcher");
        mWakeLock.setReferenceCounted(true);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        //mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SMSDispatcher");
        //mWakeLock.setReferenceCounted(true);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.951 -0400", hash_original_method = "6F7A6F4FA235882A4AAAEA7C85F33B76", hash_generated_method = "74C18E40C776EBEA7C1B979A5B65BDBD")
     void dispatch(Intent intent, String permission) {
        addTaint(permission.getTaint());
        addTaint(intent.getTaint());
        mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        mContext.sendOrderedBroadcast(intent, permission, mResultReceiver,
                this, Activity.RESULT_OK, null, null);
        // ---------- Original Method ----------
        //mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        //mContext.sendOrderedBroadcast(intent, permission, mResultReceiver,
                //this, Activity.RESULT_OK, null, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.962 -0400", hash_original_method = "B9407366468E5E2261EED2E1D1F371B3", hash_generated_method = "7E0EB94DA2DFFC75B143A6F8F2DE92C9")
    protected void handleSendComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        SmsTracker tracker = (SmsTracker) ar.userObj;
        PendingIntent sentIntent = tracker.mSentIntent;
        if(ar.exception == null)        
        {
            if(false)            
            {
                Log.d(TAG, "SMS send complete. Broadcasting "
                        + "intent: " + sentIntent);
            } //End block
            if(tracker.mDeliveryIntent != null)            
            {
                int messageRef = ((SmsResponse)ar.result).messageRef;
                tracker.mMessageRef = messageRef;
                deliveryPendingList.add(tracker);
            } //End block
            if(sentIntent != null)            
            {
                try 
                {
                    if(mRemainingMessages > -1)                    
                    {
                        mRemainingMessages--;
                    } //End block
                    if(mRemainingMessages == 0)                    
                    {
                        Intent sendNext = new Intent();
                        sendNext.putExtra(SEND_NEXT_MSG_EXTRA, true);
                        sentIntent.send(mContext, Activity.RESULT_OK, sendNext);
                    } //End block
                    else
                    {
                        sentIntent.send(Activity.RESULT_OK);
                    } //End block
                } //End block
                catch (CanceledException ex)
                {
                } //End block
            } //End block
        } //End block
        else
        {
            if(false)            
            {
                Log.d(TAG, "SMS send failed");
            } //End block
            int ss = mPhone.getServiceState().getState();
            if(ss != ServiceState.STATE_IN_SERVICE)            
            {
                handleNotInService(ss, tracker);
            } //End block
            else
            if((((CommandException)(ar.exception)).getCommandError()
                    == CommandException.Error.SMS_FAIL_RETRY) &&
                   tracker.mRetryCount < MAX_SEND_RETRIES)            
            {
                tracker.mRetryCount++;
                Message retryMsg = obtainMessage(EVENT_SEND_RETRY, tracker);
                sendMessageDelayed(retryMsg, SEND_RETRY_DELAY);
            } //End block
            else
            if(tracker.mSentIntent != null)            
            {
                int error = RESULT_ERROR_GENERIC_FAILURE;
                if(((CommandException)(ar.exception)).getCommandError()
                        == CommandException.Error.FDN_CHECK_FAILURE)                
                {
                    error = RESULT_ERROR_FDN_CHECK_FAILURE;
                } //End block
                try 
                {
                    Intent fillIn = new Intent();
                    if(ar.result != null)                    
                    {
                        fillIn.putExtra("errorCode", ((SmsResponse)ar.result).errorCode);
                    } //End block
                    if(mRemainingMessages > -1)                    
                    {
                        mRemainingMessages--;
                    } //End block
                    if(mRemainingMessages == 0)                    
                    {
                        fillIn.putExtra(SEND_NEXT_MSG_EXTRA, true);
                    } //End block
                    tracker.mSentIntent.send(mContext, error, fillIn);
                } //End block
                catch (CanceledException ex)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    protected static void handleNotInService(int ss, SmsTracker tracker) {
        if (tracker.mSentIntent != null) {
            try {
                if (ss == ServiceState.STATE_POWER_OFF) {
                    tracker.mSentIntent.send(RESULT_ERROR_RADIO_OFF);
                } else {
                    tracker.mSentIntent.send(RESULT_ERROR_NO_SERVICE);
                }
            } catch (CanceledException ex) {}
        }
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int dispatchMessage(SmsMessageBase sms);

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.966 -0400", hash_original_method = "FA883D78660186E8315D2F919EDE7FF4", hash_generated_method = "153BC1DDA64EC9B8D5A9855815FB6350")
    protected int dispatchNormalMessage(SmsMessageBase sms) {
        addTaint(sms.getTaint());
        SmsHeader smsHeader = sms.getUserDataHeader();
        if((smsHeader == null) || (smsHeader.concatRef == null))        
        {
            byte[][] pdus = new byte[1][];
            pdus[0] = sms.getPdu();
            if(smsHeader != null && smsHeader.portAddrs != null)            
            {
                if(smsHeader.portAddrs.destPort == SmsHeader.PORT_WAP_PUSH)                
                {
                    int varC16D9621464D89CD99066AA83BD16096_1659226481 = (mWapPush.dispatchWapPdu(sms.getUserData()));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062659303 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062659303;
                } //End block
                else
                {
                    dispatchPortAddressedPdus(pdus, smsHeader.portAddrs.destPort);
                } //End block
            } //End block
            else
            {
                dispatchPdus(pdus);
            } //End block
            int var4C0737507AD994723C875A6D0646D112_1222109749 = (Activity.RESULT_OK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038372390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038372390;
        } //End block
        else
        {
            SmsHeader.ConcatRef concatRef = smsHeader.concatRef;
            SmsHeader.PortAddrs portAddrs = smsHeader.portAddrs;
            int var9857EEB35FF407AEA31EF40436BE7D99_47246773 = (processMessagePart(sms.getPdu(), sms.getOriginatingAddress(),
                    concatRef.refNumber, concatRef.seqNumber, concatRef.msgCount,
                    sms.getTimestampMillis(), (portAddrs != null ? portAddrs.destPort : -1), false));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820803616 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820803616;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.970 -0400", hash_original_method = "E4A3787C1C71B47352080C233D4F2AF5", hash_generated_method = "31FEE56D1D586671C6B3F4C5F6A95641")
    protected int processMessagePart(byte[] pdu, String address, int referenceNumber,
            int sequenceNumber, int messageCount, long timestamp, int destPort,
            boolean isCdmaWapPush) {
        addTaint(isCdmaWapPush);
        addTaint(destPort);
        addTaint(timestamp);
        addTaint(messageCount);
        addTaint(sequenceNumber);
        addTaint(referenceNumber);
        addTaint(address.getTaint());
        addTaint(pdu[0]);
        byte[][] pdus = null;
        Cursor cursor = null;
        try 
        {
            String refNumber = Integer.toString(referenceNumber);
            String seqNumber = Integer.toString(sequenceNumber);
            cursor = mResolver.query(mRawUri, PDU_PROJECTION,
                    "address=? AND reference_number=? AND sequence=?",
                    new String[] {address, refNumber, seqNumber}, null);
            if(cursor.moveToNext())            
            {
                String oldPduString = cursor.getString(PDU_COLUMN);
                byte[] oldPdu = HexDump.hexStringToByteArray(oldPduString);
                if(!Arrays.equals(oldPdu, pdu))                
                {
                } //End block
                int var0A0A6D68560CC5EF46A3B9603DD175AA_1849420536 = (Intents.RESULT_SMS_HANDLED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686334529 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686334529;
            } //End block
            cursor.close();
            String where = "address=? AND reference_number=?";
            String[] whereArgs = new String[] {address, refNumber};
            cursor = mResolver.query(mRawUri, PDU_SEQUENCE_PORT_PROJECTION, where, whereArgs, null);
            int cursorCount = cursor.getCount();
            if(cursorCount != messageCount - 1)            
            {
                ContentValues values = new ContentValues();
                values.put("date", timestamp);
                values.put("pdu", HexDump.toHexString(pdu));
                values.put("address", address);
                values.put("reference_number", referenceNumber);
                values.put("count", messageCount);
                values.put("sequence", sequenceNumber);
                if(destPort != -1)                
                {
                    values.put("destination_port", destPort);
                } //End block
                mResolver.insert(mRawUri, values);
                int var0A0A6D68560CC5EF46A3B9603DD175AA_445009636 = (Intents.RESULT_SMS_HANDLED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650911529 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650911529;
            } //End block
            pdus = new byte[messageCount][];
for(int i = 0;i < cursorCount;i++)
            {
                cursor.moveToNext();
                int cursorSequence = cursor.getInt(SEQUENCE_COLUMN);
                if(!isCdmaWapPush)                
                {
                    cursorSequence--;
                } //End block
                pdus[cursorSequence] = HexDump.hexStringToByteArray(
                        cursor.getString(PDU_COLUMN));
                if(cursorSequence == 0 && !cursor.isNull(DESTINATION_PORT_COLUMN))                
                {
                    destPort = cursor.getInt(DESTINATION_PORT_COLUMN);
                } //End block
            } //End block
            if(isCdmaWapPush)            
            {
                pdus[sequenceNumber] = pdu;
            } //End block
            else
            {
                pdus[sequenceNumber - 1] = pdu;
            } //End block
            mResolver.delete(mRawUri, where, whereArgs);
        } //End block
        catch (SQLException e)
        {
            int varFCC16322707A95E5743FED9CA64177EC_1225971831 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237758992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237758992;
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
        if(isCdmaWapPush)        
        {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
for(int i = 0;i < messageCount;i++)
            {
                output.write(pdus[i], 0, pdus[i].length);
            } //End block
            byte[] datagram = output.toByteArray();
            if(destPort == SmsHeader.PORT_WAP_PUSH)            
            {
                int varB7EF89AD6AA6EEBCC55E358B507D837C_1213585572 = (mWapPush.dispatchWapPdu(datagram));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132813400 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132813400;
            } //End block
            else
            {
                pdus = new byte[1][];
                pdus[0] = datagram;
                dispatchPortAddressedPdus(pdus, destPort);
                int var4C0737507AD994723C875A6D0646D112_825565579 = (Activity.RESULT_OK);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330179835 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330179835;
            } //End block
        } //End block
        if(destPort != -1)        
        {
            if(destPort == SmsHeader.PORT_WAP_PUSH)            
            {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
for(int i = 0;i < messageCount;i++)
                {
                    SmsMessage msg = SmsMessage.createFromPdu(pdus[i], getFormat());
                    byte[] data = msg.getUserData();
                    output.write(data, 0, data.length);
                } //End block
                int var06ACBBFFC40E405A64ADCD25FF414EC2_237166828 = (mWapPush.dispatchWapPdu(output.toByteArray()));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702523816 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702523816;
            } //End block
            else
            {
                dispatchPortAddressedPdus(pdus, destPort);
            } //End block
        } //End block
        else
        {
            dispatchPdus(pdus);
        } //End block
        int var4C0737507AD994723C875A6D0646D112_1563969467 = (Activity.RESULT_OK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834045782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834045782;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.974 -0400", hash_original_method = "FFA598D36A59A89B4BA165B55017EEB5", hash_generated_method = "2F7487EEB0B9AB5999977F20D8B574A5")
    protected void dispatchPdus(byte[][] pdus) {
        addTaint(pdus[0][0]);
        Intent intent = new Intent(Intents.SMS_RECEIVED_ACTION);
        intent.putExtra("pdus", pdus);
        intent.putExtra("format", getFormat());
        dispatch(intent, RECEIVE_SMS_PERMISSION);
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intents.SMS_RECEIVED_ACTION);
        //intent.putExtra("pdus", pdus);
        //intent.putExtra("format", getFormat());
        //dispatch(intent, RECEIVE_SMS_PERMISSION);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.975 -0400", hash_original_method = "3F1122361F00F60F28196C29B48EFEBB", hash_generated_method = "977EB63BFA65376303A8877BBDAC496C")
    protected void dispatchPortAddressedPdus(byte[][] pdus, int port) {
        addTaint(port);
        addTaint(pdus[0][0]);
        Uri uri = Uri.parse("sms://localhost:" + port);
        Intent intent = new Intent(Intents.DATA_SMS_RECEIVED_ACTION, uri);
        intent.putExtra("pdus", pdus);
        intent.putExtra("format", getFormat());
        dispatch(intent, RECEIVE_SMS_PERMISSION);
        // ---------- Original Method ----------
        //Uri uri = Uri.parse("sms://localhost:" + port);
        //Intent intent = new Intent(Intents.DATA_SMS_RECEIVED_ACTION, uri);
        //intent.putExtra("pdus", pdus);
        //intent.putExtra("format", getFormat());
        //dispatch(intent, RECEIVE_SMS_PERMISSION);
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent);

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent);

    
    @DSModeled(DSC.SAFE)
    protected abstract TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.980 -0400", hash_original_method = "050C8CDC5807717B3CBB93F722D8E33D", hash_generated_method = "518621F6E72DC416EDE57941EC280AF2")
    protected void sendMultipartText(String destAddr, String scAddr,
            ArrayList<String> parts, ArrayList<PendingIntent> sentIntents,
            ArrayList<PendingIntent> deliveryIntents) {
        addTaint(deliveryIntents.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(parts.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        int refNumber = getNextConcatenatedRef() & 0x00FF;
        int msgCount = parts.size();
        int encoding = android.telephony.SmsMessage.ENCODING_UNKNOWN;
        mRemainingMessages = msgCount;
        TextEncodingDetails[] encodingForParts = new TextEncodingDetails[msgCount];
for(int i = 0;i < msgCount;i++)
        {
            TextEncodingDetails details = calculateLength(parts.get(i), false);
            if(encoding != details.codeUnitSize
                    && (encoding == android.telephony.SmsMessage.ENCODING_UNKNOWN
                            || encoding == android.telephony.SmsMessage.ENCODING_7BIT))            
            {
                encoding = details.codeUnitSize;
            } //End block
            encodingForParts[i] = details;
        } //End block
for(int i = 0;i < msgCount;i++)
        {
            SmsHeader.ConcatRef concatRef = new SmsHeader.ConcatRef();
            concatRef.refNumber = refNumber;
            concatRef.seqNumber = i + 1;
            concatRef.msgCount = msgCount;
            concatRef.isEightBits = true;
            SmsHeader smsHeader = new SmsHeader();
            smsHeader.concatRef = concatRef;
            if(encoding == android.telephony.SmsMessage.ENCODING_7BIT)            
            {
                smsHeader.languageTable = encodingForParts[i].languageTable;
                smsHeader.languageShiftTable = encodingForParts[i].languageShiftTable;
            } //End block
            PendingIntent sentIntent = null;
            if(sentIntents != null && sentIntents.size() > i)            
            {
                sentIntent = sentIntents.get(i);
            } //End block
            PendingIntent deliveryIntent = null;
            if(deliveryIntents != null && deliveryIntents.size() > i)            
            {
                deliveryIntent = deliveryIntents.get(i);
            } //End block
            sendNewSubmitPdu(destAddr, scAddr, parts.get(i), smsHeader, encoding,
                    sentIntent, deliveryIntent, (i == (msgCount - 1)));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.982 -0400", hash_original_method = "17023DDC5CC5357F9142E0DE3564955A", hash_generated_method = "7F698B164A3B8C41937B980BB7781A38")
    protected void sendRawPdu(byte[] smsc, byte[] pdu, PendingIntent sentIntent,
            PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        if(mSmsSendDisabled)        
        {
            if(sentIntent != null)            
            {
                try 
                {
                    sentIntent.send(RESULT_ERROR_NO_SERVICE);
                } //End block
                catch (CanceledException ex)
                {
                } //End block
            } //End block
            Log.d(TAG, "Device does not support sending sms.");
            return;
        } //End block
        if(pdu == null)        
        {
            if(sentIntent != null)            
            {
                try 
                {
                    sentIntent.send(RESULT_ERROR_NULL_PDU);
                } //End block
                catch (CanceledException ex)
                {
                } //End block
            } //End block
            return;
        } //End block
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("smsc", smsc);
        map.put("pdu", pdu);
        SmsTracker tracker = new SmsTracker(map, sentIntent,
                deliveryIntent);
        int ss = mPhone.getServiceState().getState();
        if(ss != ServiceState.STATE_IN_SERVICE)        
        {
            handleNotInService(ss, tracker);
        } //End block
        else
        {
            String appName = getAppNameByIntent(sentIntent);
            if(mUsageMonitor.check(appName, SINGLE_PART_SMS))            
            {
                sendSms(tracker);
            } //End block
            else
            {
                sendMessage(obtainMessage(EVENT_POST_ALERT, tracker));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.983 -0400", hash_original_method = "771250D922DD0FBC637697CE165ADE5B", hash_generated_method = "69471645ADFEB910AC4B853FE2A10579")
    protected void handleReachSentLimit(SmsTracker tracker) {
        addTaint(tracker.getTaint());
        if(mSTrackers.size() >= MO_MSG_QUEUE_LIMIT)        
        {
            try 
            {
                tracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
            } //End block
            catch (CanceledException ex)
            {
            } //End block
            return;
        } //End block
        Resources r = Resources.getSystem();
        String appName = getAppNameByIntent(tracker.mSentIntent);
        AlertDialog d = new AlertDialog.Builder(mContext)
                .setTitle(r.getString(R.string.sms_control_title))
                .setMessage(appName + " " + r.getString(R.string.sms_control_message))
                .setPositiveButton(r.getString(R.string.sms_control_yes), mListener)
                .setNegativeButton(r.getString(R.string.sms_control_no), mListener)
                .create();
        d.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        d.show();
        mSTrackers.add(tracker);
        sendMessageDelayed ( obtainMessage(EVENT_ALERT_TIMEOUT, d),
                DEFAULT_SMS_TIMEOUT);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected static String getAppNameByIntent(PendingIntent intent) {
        Resources r = Resources.getSystem();
        return (intent != null) ? intent.getTargetPackage()
            : r.getString(R.string.sms_control_default_app_name);
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void sendSms(SmsTracker tracker);

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.983 -0400", hash_original_method = "3673C71AC378B483B72EBB14D4C20DB7", hash_generated_method = "D23C6C59E22A24804F3C2FDB63F981E3")
    private void sendMultipartSms(SmsTracker tracker) {
        addTaint(tracker.getTaint());
        ArrayList<String> parts;
        ArrayList<PendingIntent> sentIntents;
        ArrayList<PendingIntent> deliveryIntents;
        HashMap<String, Object> map = tracker.mData;
        String destinationAddress = (String) map.get("destination");
        String scAddress = (String) map.get("scaddress");
        parts = (ArrayList<String>) map.get("parts");
        sentIntents = (ArrayList<PendingIntent>) map.get("sentIntents");
        deliveryIntents = (ArrayList<PendingIntent>) map.get("deliveryIntents");
        int ss = mPhone.getServiceState().getState();
        if(ss != ServiceState.STATE_IN_SERVICE)        
        {
for(int i = 0, count = parts.size();i < count;i++)
            {
                PendingIntent sentIntent = null;
                if(sentIntents != null && sentIntents.size() > i)                
                {
                    sentIntent = sentIntents.get(i);
                } //End block
                handleNotInService(ss, new SmsTracker(null, sentIntent, null));
            } //End block
            return;
        } //End block
        sendMultipartText(destinationAddress, scAddress, parts, sentIntents, deliveryIntents);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void acknowledgeLastIncomingSms(boolean success,
            int result, Message response);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_method = "3FF14669D60F392B7539BF30A1AA74B3", hash_generated_method = "72B694781084167CD4436E7A561C5E02")
    private void notifyAndAcknowledgeLastIncomingSms(boolean success,
            int result, Message response) {
        addTaint(response.getTaint());
        addTaint(result);
        addTaint(success);
        if(!success)        
        {
            Intent intent = new Intent(Intents.SMS_REJECTED_ACTION);
            intent.putExtra("result", result);
            mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
            mContext.sendBroadcast(intent, "android.permission.RECEIVE_SMS");
        } //End block
        acknowledgeLastIncomingSms(success, result, response);
        // ---------- Original Method ----------
        //if (!success) {
            //Intent intent = new Intent(Intents.SMS_REJECTED_ACTION);
            //intent.putExtra("result", result);
            //mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
            //mContext.sendBroadcast(intent, "android.permission.RECEIVE_SMS");
        //}
        //acknowledgeLastIncomingSms(success, result, response);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_method = "978DCF88E3506C5AEC52023DC36FB472", hash_generated_method = "D08875E031D5490623B0046E5DE124C9")
    protected void dispatchBroadcastPdus(byte[][] pdus, boolean isEmergencyMessage) {
        addTaint(isEmergencyMessage);
        addTaint(pdus[0][0]);
        if(isEmergencyMessage)        
        {
            Intent intent = new Intent(Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
            intent.putExtra("pdus", pdus);
            Log.d(TAG, "Dispatching " + pdus.length + " emergency SMS CB pdus");
            dispatch(intent, RECEIVE_EMERGENCY_BROADCAST_PERMISSION);
        } //End block
        else
        {
            Intent intent = new Intent(Intents.SMS_CB_RECEIVED_ACTION);
            intent.putExtra("pdus", pdus);
            Log.d(TAG, "Dispatching " + pdus.length + " SMS CB pdus");
            dispatch(intent, RECEIVE_SMS_PERMISSION);
        } //End block
        // ---------- Original Method ----------
        //if (isEmergencyMessage) {
            //Intent intent = new Intent(Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
            //intent.putExtra("pdus", pdus);
            //Log.d(TAG, "Dispatching " + pdus.length + " emergency SMS CB pdus");
            //dispatch(intent, RECEIVE_EMERGENCY_BROADCAST_PERMISSION);
        //} else {
            //Intent intent = new Intent(Intents.SMS_CB_RECEIVED_ACTION);
            //intent.putExtra("pdus", pdus);
            //Log.d(TAG, "Dispatching " + pdus.length + " SMS CB pdus");
            //dispatch(intent, RECEIVE_SMS_PERMISSION);
        //}
    }

    
    protected static final class SmsTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F3277AFBEDD51E5773577F9D8F3AB639")

        public HashMap<String, Object> mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_field = "4487E295EC45E6A32AAF433A1E157001", hash_generated_field = "600EF69150C1A1CD36492104AAC1EF9C")

        public int mRetryCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_field = "D884A3A8EE99FC2554ACC54A86E32238", hash_generated_field = "2FB86C29BD13CC07A94A3CC824368C69")

        public int mMessageRef;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_field = "8571EEC85763493969769E04AC3E13E6", hash_generated_field = "2B1B1BD1C048DD351EF6648400E6B501")

        public PendingIntent mSentIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.984 -0400", hash_original_field = "37FF3E5D69196B5DDE8723231C6AF292", hash_generated_field = "78D4FBE39C0EAD7D859F8F231728FA0A")

        public PendingIntent mDeliveryIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_method = "877569CE168114AF55747488AC637330", hash_generated_method = "9C5410FFDE3E865B7F5F741DD8378023")
        public  SmsTracker(HashMap<String, Object> data, PendingIntent sentIntent,
                PendingIntent deliveryIntent) {
            mData = data;
            mSentIntent = sentIntent;
            mDeliveryIntent = deliveryIntent;
            mRetryCount = 0;
            // ---------- Original Method ----------
            //mData = data;
            //mSentIntent = sentIntent;
            //mDeliveryIntent = deliveryIntent;
            //mRetryCount = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_method = "2949B9E8FD6643222FD24B64B0F513BD", hash_generated_method = "7AEFCC4044F721C6AC767573EE4F1A01")
        protected boolean isMultipart() {
            HashMap map = mData;
            boolean var850F373EF6EBDDE57FE553F3F31673CE_1998567710 = (map.containsKey("parts"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163139876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163139876;
            // ---------- Original Method ----------
            //HashMap map = mData;
            //return map.containsKey("parts");
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "90629186E17FDC357615E95F12CFB672", hash_generated_field = "972F0759C0398CDF52B8FBBA9D1218D9")

    static final String TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "2E86EB2F19B68E46E4798E9BDFE5C02F", hash_generated_field = "3256B8B7CFD066651B10074530C70F39")

    private static final String SEND_NEXT_MSG_EXTRA = "SendNextMsg";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "FEA2A1D2F590978ACFB2F660BA8B8E0F", hash_generated_field = "7536C71803F84D3A7C8F8915E4024C2F")

    private static final int DEFAULT_SMS_TIMEOUT = 6000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "1790BA9D2E417CBBB55439E465B7FEE5", hash_generated_field = "2F4952B32870E86C3E766722DFDC0592")

    public static final String RECEIVE_SMS_PERMISSION = "android.permission.RECEIVE_SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "D2D120CF4B7D5552982C109A37FEAEA5", hash_generated_field = "F359704DC7625C1FCF8C11C5638C4F43")

    public static final String RECEIVE_EMERGENCY_BROADCAST_PERMISSION =
            "android.permission.RECEIVE_EMERGENCY_BROADCAST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "8D6FF0CBEB39FC0957C85E923B3C7D45", hash_generated_field = "691B358EB66012581EA9C68CDC87A0CF")

    private static final String[] PDU_PROJECTION = new String[] {
            "pdu"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "E73C9B2FAD98297781146BF514022FEB", hash_generated_field = "2396A2F6E959C2EE9253BE3959150F08")

    private static final String[] PDU_SEQUENCE_PORT_PROJECTION = new String[] {
            "pdu",
            "sequence",
            "destination_port"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "68469F3EF03980A5525511363F6DA8EF", hash_generated_field = "5113709E0F0BC2B70A499B75CFE4CF4A")

    private static final int PDU_COLUMN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "69D78BF35FDC8A1F2C2EAB4531AA50EE", hash_generated_field = "EF62026972250B4FF58E013E80A34A5B")

    private static final int SEQUENCE_COLUMN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "F765B742F0F5B30F7EADCFB9B6F70631", hash_generated_field = "FBA02BF9BEA4F2373C0F490FFEF167CB")

    private static final int DESTINATION_PORT_COLUMN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "9C15291533893265799E758774627A17", hash_generated_field = "085A3AE93D0B9AC426B6A8452F5A3024")

    protected static final int EVENT_NEW_SMS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "B3F5A1F909F87B71E654F569F260C775", hash_generated_field = "79D4E5CE273C793D246CB4302A3E7E7E")

    protected static final int EVENT_SEND_SMS_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "A948E8B395A5DADC18AC94EE922BA209", hash_generated_field = "A165462D31A9BCE5DA7E0CB07922929D")

    private static final int EVENT_SEND_RETRY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.985 -0400", hash_original_field = "A4F1EDD68B1F9171D0504594507142CB", hash_generated_field = "C5E2EBAAF973F0E48F9432F5548F79AF")

    private static final int EVENT_POST_ALERT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "E2F282D6A4A2754A7F0724173B5C62E2", hash_generated_field = "F2FED0D054DE30CDBECBDF1E820A14FF")

    static final int EVENT_SEND_CONFIRMED_SMS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "34EC87015588960165A889DB07F6E35C", hash_generated_field = "7FC5B3E444A75EDFB48DE3292FEBA31E")

    private static final int EVENT_ALERT_TIMEOUT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "F544E23DBD80AD2DD9C1A552574D0500", hash_generated_field = "8744B27A486A99F431F829192EAAF5E3")

    static final int EVENT_STOP_SENDING = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "726C8B4C6D4E15107F5CCED2E60244DE", hash_generated_field = "DBF527A7CF8C20A9FE25BBDBEEDC197F")

    protected static final Uri mRawUri = Uri.withAppendedPath(Telephony.Sms.CONTENT_URI, "raw");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "9B2D7B519EA2276E0F11D12D149EEE7E", hash_generated_field = "EE2B17F7040836AE21850E28656E0BCD")

    private static final int MAX_SEND_RETRIES = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "0EF082B73C1332F85340D67EEE9936B6", hash_generated_field = "28F15011D4FD1FDC88AEAB842DCE8D07")

    private static final int SEND_RETRY_DELAY = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "0A7F5FC2649D6553E9B28E1CDE8EC696", hash_generated_field = "0947E022FFE6053CB7CB2862C1E608FC")

    private static final int SINGLE_PART_SMS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "8E925AB345F333942853D93002D650FA", hash_generated_field = "A3D7B3651CBC650DFC4AB826DEEA3966")

    private static final int MO_MSG_QUEUE_LIMIT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.986 -0400", hash_original_field = "810439A30157189D4225CE6A4AA37781", hash_generated_field = "F573472C1895C260CB038E1799F5C8C9")

    private static int sConcatenatedRef = new Random().nextInt(256);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:18.987 -0400", hash_original_field = "B59EE70074140F54FE9A40B8C9352A9F", hash_generated_field = "B4C7CBA06229E71F94E76C8B33DB30C3")

    private static final int WAKE_LOCK_TIMEOUT = 5000;
}

