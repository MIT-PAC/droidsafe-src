package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    protected Phone mPhone;
    protected Context mContext;
    protected ContentResolver mResolver;
    protected CommandsInterface mCm;
    protected SmsStorageMonitor mStorageMonitor;
    protected WapPushOverSms mWapPush;
    private SmsUsageMonitor mUsageMonitor;
    private ArrayList<SmsTracker> mSTrackers = new ArrayList<SmsTracker>(MO_MSG_QUEUE_LIMIT);
    private PowerManager.WakeLock mWakeLock;
    protected boolean mSmsCapable = true;
    protected boolean mSmsReceiveDisabled;
    protected boolean mSmsSendDisabled;
    protected int mRemainingMessages = -1;
    protected ArrayList<SmsTracker> deliveryPendingList = new ArrayList<SmsTracker>();
    private final DialogInterface.OnClickListener mListener = new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.399 -0400", hash_original_method = "318A7382B4CDEC030B530C6AA43A7A60", hash_generated_method = "7D4797C337CE3081A37AFD6E6889BDE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(which);
            dsTaint.addTaint(dialog.dsTaint);
            {
                Log.d(TAG, "click YES to send out sms");
                sendMessage(obtainMessage(EVENT_SEND_CONFIRMED_SMS));
            } //End block
            {
                Log.d(TAG, "click NO to stop sending");
                sendMessage(obtainMessage(EVENT_STOP_SENDING));
            } //End block
            // ---------- Original Method ----------
            //if (which == DialogInterface.BUTTON_POSITIVE) {
                    //Log.d(TAG, "click YES to send out sms");
                    //sendMessage(obtainMessage(EVENT_SEND_CONFIRMED_SMS));
                //} else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    //Log.d(TAG, "click NO to stop sending");
                    //sendMessage(obtainMessage(EVENT_STOP_SENDING));
                //}
        }

        
}; //Transformed anonymous class
    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.399 -0400", hash_original_method = "DB25CB42F24A1F0004F16056EEBCBE73", hash_generated_method = "70A38D842D66949106CB53515D90C0E0")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            int rc;
            rc = getResultCode();
            boolean success;
            success = (rc == Activity.RESULT_OK)
                    || (rc == Intents.RESULT_SMS_HANDLED);
            acknowledgeLastIncomingSms(success, rc, null);
            // ---------- Original Method ----------
            //int rc = getResultCode();
            //boolean success = (rc == Activity.RESULT_OK)
                    //|| (rc == Intents.RESULT_SMS_HANDLED);
            //acknowledgeLastIncomingSms(success, rc, null);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.399 -0400", hash_original_method = "E354AE25961418D172CBDDA3C2433B63", hash_generated_method = "EB626DD8C35C2305DD4A592FAAE6CBD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(usageMonitor.dsTaint);
        dsTaint.addTaint(storageMonitor.dsTaint);
        mWapPush = new WapPushOverSms(phone, this);
        mContext = phone.getContext();
        mResolver = mContext.getContentResolver();
        mCm = phone.mCM;
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

    
        protected static int getNextConcatenatedRef() {
        sConcatenatedRef += 1;
        return sConcatenatedRef;
    }

    
    public abstract void dispose();

    
    protected abstract String getFormat();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.400 -0400", hash_original_method = "FF8B1C8CEEDF99CA4428854C45370A3A", hash_generated_method = "9C45BC8177998F07A273AAC14939D123")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        Log.d(TAG, "SMSDispatcher finalized");
        // ---------- Original Method ----------
        //Log.d(TAG, "SMSDispatcher finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.401 -0400", hash_original_method = "42D9652DD1B0FE51DCC6557D894D344B", hash_generated_method = "2FDBAC92F42812A238248E9B2A6FAC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_NEW_SMS 
        {
            Log.d(TAG, "New SMS Message Received");
        } //End block
        //End case EVENT_NEW_SMS 
        //Begin case EVENT_NEW_SMS 
        SmsMessage sms;
        //End case EVENT_NEW_SMS 
        //Begin case EVENT_NEW_SMS 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_NEW_SMS 
        //Begin case EVENT_NEW_SMS 
        sms = (SmsMessage) ar.result;
        //End case EVENT_NEW_SMS 
        //Begin case EVENT_NEW_SMS 
        try 
        {
            int result;
            result = dispatchMessage(sms.mWrappedSmsMessage);
            {
                boolean handled;
                handled = (result == Intents.RESULT_SMS_HANDLED);
                notifyAndAcknowledgeLastIncomingSms(handled, result, null);
            } //End block
        } //End block
        catch (RuntimeException ex)
        {
            notifyAndAcknowledgeLastIncomingSms(false, Intents.RESULT_SMS_GENERIC_ERROR, null);
        } //End block
        //End case EVENT_NEW_SMS 
        //Begin case EVENT_SEND_SMS_COMPLETE 
        handleSendComplete((AsyncResult) msg.obj);
        //End case EVENT_SEND_SMS_COMPLETE 
        //Begin case EVENT_SEND_RETRY 
        sendSms((SmsTracker) msg.obj);
        //End case EVENT_SEND_RETRY 
        //Begin case EVENT_POST_ALERT 
        handleReachSentLimit((SmsTracker)(msg.obj));
        //End case EVENT_POST_ALERT 
        //Begin case EVENT_ALERT_TIMEOUT 
        ((AlertDialog)(msg.obj)).dismiss();
        //End case EVENT_ALERT_TIMEOUT 
        //Begin case EVENT_ALERT_TIMEOUT 
        msg.obj = null;
        //End case EVENT_ALERT_TIMEOUT 
        //Begin case EVENT_ALERT_TIMEOUT 
        {
            boolean varF079B7C937A1F72AD944CB03063480BB_808813078 = (mSTrackers.isEmpty() == false);
            {
                try 
                {
                    SmsTracker sTracker;
                    sTracker = mSTrackers.remove(0);
                    sTracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
                } //End block
                catch (CanceledException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_ALERT_TIMEOUT 
        //Begin case EVENT_ALERT_TIMEOUT 
        {
            Log.d(TAG, "EVENT_ALERT_TIMEOUT, message stop sending");
        } //End block
        //End case EVENT_ALERT_TIMEOUT 
        //Begin case EVENT_SEND_CONFIRMED_SMS 
        {
            boolean varF079B7C937A1F72AD944CB03063480BB_434471487 = (mSTrackers.isEmpty() == false);
            {
                SmsTracker sTracker;
                sTracker = mSTrackers.remove(mSTrackers.size() - 1);
                {
                    boolean var25B0DE965FAB09F054D6EF88E363D5E4_441285284 = (sTracker.isMultipart());
                    {
                        sendMultipartSms(sTracker);
                    } //End block
                    {
                        sendSms(sTracker);
                    } //End block
                } //End collapsed parenthetic
                removeMessages(EVENT_ALERT_TIMEOUT, msg.obj);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_SEND_CONFIRMED_SMS 
        //Begin case EVENT_STOP_SENDING 
        {
            boolean varF079B7C937A1F72AD944CB03063480BB_95044245 = (mSTrackers.isEmpty() == false);
            {
                try 
                {
                    SmsTracker sTracker;
                    sTracker = mSTrackers.remove(mSTrackers.size() - 1);
                    sTracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
                } //End block
                catch (CanceledException ex)
                { }
                removeMessages(EVENT_ALERT_TIMEOUT, msg.obj);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_STOP_SENDING 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.401 -0400", hash_original_method = "1E59FCBE70CAB945B533C092F603248E", hash_generated_method = "CE706E35358CF1F593C59BB2D5CE9AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createWakelock() {
        PowerManager pm;
        pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SMSDispatcher");
        mWakeLock.setReferenceCounted(true);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        //mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SMSDispatcher");
        //mWakeLock.setReferenceCounted(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.401 -0400", hash_original_method = "6F7A6F4FA235882A4AAAEA7C85F33B76", hash_generated_method = "A39354A1019B8ECD996E2675D4D387EC")
    @DSModeled(DSC.SPEC)
     void dispatch(Intent intent, String permission) {
        dsTaint.addTaint(permission);
        dsTaint.addTaint(intent.dsTaint);
        mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        mContext.sendOrderedBroadcast(intent, permission, mResultReceiver,
                this, Activity.RESULT_OK, null, null);
        // ---------- Original Method ----------
        //mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        //mContext.sendOrderedBroadcast(intent, permission, mResultReceiver,
                //this, Activity.RESULT_OK, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.402 -0400", hash_original_method = "B9407366468E5E2261EED2E1D1F371B3", hash_generated_method = "35159D6C9AD5C65995EB9DB9F5298CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handleSendComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        SmsTracker tracker;
        tracker = (SmsTracker) ar.userObj;
        PendingIntent sentIntent;
        sentIntent = tracker.mSentIntent;
        {
            {
                Log.d(TAG, "SMS send complete. Broadcasting "
                        + "intent: " + sentIntent);
            } //End block
            {
                int messageRef;
                messageRef = ((SmsResponse)ar.result).messageRef;
                tracker.mMessageRef = messageRef;
                deliveryPendingList.add(tracker);
            } //End block
            {
                try 
                {
                    {
                        Intent sendNext;
                        sendNext = new Intent();
                        sendNext.putExtra(SEND_NEXT_MSG_EXTRA, true);
                        sentIntent.send(mContext, Activity.RESULT_OK, sendNext);
                    } //End block
                    {
                        sentIntent.send(Activity.RESULT_OK);
                    } //End block
                } //End block
                catch (CanceledException ex)
                { }
            } //End block
        } //End block
        {
            {
                Log.d(TAG, "SMS send failed");
            } //End block
            int ss;
            ss = mPhone.getServiceState().getState();
            {
                handleNotInService(ss, tracker);
            } //End block
            {
                boolean var33840BDE89EFFDAFF4BFAC3550647FC6_1098993330 = ((((CommandException)(ar.exception)).getCommandError()
                    == CommandException.Error.SMS_FAIL_RETRY) &&
                   tracker.mRetryCount < MAX_SEND_RETRIES);
                {
                    Message retryMsg;
                    retryMsg = obtainMessage(EVENT_SEND_RETRY, tracker);
                    sendMessageDelayed(retryMsg, SEND_RETRY_DELAY);
                } //End block
                {
                    int error;
                    error = RESULT_ERROR_GENERIC_FAILURE;
                    {
                        boolean var5D7024E527BBAFC43C30C4C3A822E80B_593036937 = (((CommandException)(ar.exception)).getCommandError()
                        == CommandException.Error.FDN_CHECK_FAILURE);
                        {
                            error = RESULT_ERROR_FDN_CHECK_FAILURE;
                        } //End block
                    } //End collapsed parenthetic
                    try 
                    {
                        Intent fillIn;
                        fillIn = new Intent();
                        {
                            fillIn.putExtra("errorCode", ((SmsResponse)ar.result).errorCode);
                        } //End block
                        {
                            fillIn.putExtra(SEND_NEXT_MSG_EXTRA, true);
                        } //End block
                        tracker.mSentIntent.send(mContext, error, fillIn);
                    } //End block
                    catch (CanceledException ex)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    public abstract int dispatchMessage(SmsMessageBase sms);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.403 -0400", hash_original_method = "FA883D78660186E8315D2F919EDE7FF4", hash_generated_method = "D89D8D88E756665E42BA52C6E2DC1CEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int dispatchNormalMessage(SmsMessageBase sms) {
        dsTaint.addTaint(sms.dsTaint);
        SmsHeader smsHeader;
        smsHeader = sms.getUserDataHeader();
        {
            byte[][] pdus;
            pdus = new byte[1][];
            pdus[0] = sms.getPdu();
            {
                {
                    int var6026FCE9AE016D5B5D5DCA94071B0475_299264603 = (mWapPush.dispatchWapPdu(sms.getUserData()));
                } //End block
                {
                    dispatchPortAddressedPdus(pdus, smsHeader.portAddrs.destPort);
                } //End block
            } //End block
            {
                dispatchPdus(pdus);
            } //End block
        } //End block
        {
            SmsHeader.ConcatRef concatRef;
            concatRef = smsHeader.concatRef;
            SmsHeader.PortAddrs portAddrs;
            portAddrs = smsHeader.portAddrs;
            int var5318F808814390A50076D4E3D3701348_1378248934 = (processMessagePart(sms.getPdu(), sms.getOriginatingAddress(),
                    concatRef.refNumber, concatRef.seqNumber, concatRef.msgCount,
                    sms.getTimestampMillis(), (portAddrs != null ? portAddrs.destPort : -1), false)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.404 -0400", hash_original_method = "E4A3787C1C71B47352080C233D4F2AF5", hash_generated_method = "F658333BC7AFD675B393E0DD37DAB6C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int processMessagePart(byte[] pdu, String address, int referenceNumber,
            int sequenceNumber, int messageCount, long timestamp, int destPort,
            boolean isCdmaWapPush) {
        dsTaint.addTaint(timestamp);
        dsTaint.addTaint(address);
        dsTaint.addTaint(referenceNumber);
        dsTaint.addTaint(isCdmaWapPush);
        dsTaint.addTaint(pdu[0]);
        dsTaint.addTaint(messageCount);
        dsTaint.addTaint(destPort);
        dsTaint.addTaint(sequenceNumber);
        byte[][] pdus;
        pdus = null;
        Cursor cursor;
        cursor = null;
        try 
        {
            String refNumber;
            refNumber = Integer.toString(referenceNumber);
            String seqNumber;
            seqNumber = Integer.toString(sequenceNumber);
            cursor = mResolver.query(mRawUri, PDU_PROJECTION,
                    "address=? AND reference_number=? AND sequence=?",
                    new String[] {address, refNumber, seqNumber}, null);
            {
                boolean varAE6F5AE7C11FB6711BD9B6FA5261E3FB_1509447618 = (cursor.moveToNext());
                {
                    String oldPduString;
                    oldPduString = cursor.getString(PDU_COLUMN);
                    byte[] oldPdu;
                    oldPdu = HexDump.hexStringToByteArray(oldPduString);
                    {
                        boolean var2CFAEFED18DDFEB594AF780EC1B68719_193663269 = (!Arrays.equals(oldPdu, pdu));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            cursor.close();
            String where;
            where = "address=? AND reference_number=?";
            String[] whereArgs;
            whereArgs = new String[] {address, refNumber};
            cursor = mResolver.query(mRawUri, PDU_SEQUENCE_PORT_PROJECTION, where, whereArgs, null);
            int cursorCount;
            cursorCount = cursor.getCount();
            {
                ContentValues values;
                values = new ContentValues();
                values.put("date", timestamp);
                values.put("pdu", HexDump.toHexString(pdu));
                values.put("address", address);
                values.put("reference_number", referenceNumber);
                values.put("count", messageCount);
                values.put("sequence", sequenceNumber);
                {
                    values.put("destination_port", destPort);
                } //End block
                mResolver.insert(mRawUri, values);
            } //End block
            pdus = new byte[messageCount][];
            {
                int i;
                i = 0;
                {
                    cursor.moveToNext();
                    int cursorSequence;
                    cursorSequence = cursor.getInt(SEQUENCE_COLUMN);
                    pdus[cursorSequence] = HexDump.hexStringToByteArray(
                        cursor.getString(PDU_COLUMN));
                    {
                        boolean var936843785D9A2B8B2B39023C8332F7AB_1577732782 = (cursorSequence == 0 && !cursor.isNull(DESTINATION_PORT_COLUMN));
                        {
                            destPort = cursor.getInt(DESTINATION_PORT_COLUMN);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                pdus[sequenceNumber] = pdu;
            } //End block
            {
                pdus[sequenceNumber - 1] = pdu;
            } //End block
            mResolver.delete(mRawUri, where, whereArgs);
        } //End block
        catch (SQLException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        {
            ByteArrayOutputStream output;
            output = new ByteArrayOutputStream();
            {
                int i;
                i = 0;
                {
                    output.write(pdus[i], 0, pdus[i].length);
                } //End block
            } //End collapsed parenthetic
            byte[] datagram;
            datagram = output.toByteArray();
            {
                int var377D8EDB33DCBB61EF93663D12935949_978298687 = (mWapPush.dispatchWapPdu(datagram));
            } //End block
            {
                pdus = new byte[1][];
                pdus[0] = datagram;
                dispatchPortAddressedPdus(pdus, destPort);
            } //End block
        } //End block
        {
            {
                ByteArrayOutputStream output;
                output = new ByteArrayOutputStream();
                {
                    int i;
                    i = 0;
                    {
                        SmsMessage msg;
                        msg = SmsMessage.createFromPdu(pdus[i], getFormat());
                        byte[] data;
                        data = msg.getUserData();
                        output.write(data, 0, data.length);
                    } //End block
                } //End collapsed parenthetic
                int varCA864DB5583E37C95D0146DAA7A61979_447212253 = (mWapPush.dispatchWapPdu(output.toByteArray()));
            } //End block
            {
                dispatchPortAddressedPdus(pdus, destPort);
            } //End block
        } //End block
        {
            dispatchPdus(pdus);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.405 -0400", hash_original_method = "FFA598D36A59A89B4BA165B55017EEB5", hash_generated_method = "316C6D42E1692A6F4BF435F08CDD45A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchPdus(byte[][] pdus) {
        dsTaint.addTaint(pdus[0][0]);
        Intent intent;
        intent = new Intent(Intents.SMS_RECEIVED_ACTION);
        intent.putExtra("pdus", pdus);
        intent.putExtra("format", getFormat());
        dispatch(intent, RECEIVE_SMS_PERMISSION);
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intents.SMS_RECEIVED_ACTION);
        //intent.putExtra("pdus", pdus);
        //intent.putExtra("format", getFormat());
        //dispatch(intent, RECEIVE_SMS_PERMISSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.405 -0400", hash_original_method = "3F1122361F00F60F28196C29B48EFEBB", hash_generated_method = "D55166D2240FAAE58555404482922943")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchPortAddressedPdus(byte[][] pdus, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(pdus[0][0]);
        Uri uri;
        uri = Uri.parse("sms://localhost:" + port);
        Intent intent;
        intent = new Intent(Intents.DATA_SMS_RECEIVED_ACTION, uri);
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

    
    protected abstract void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent);

    
    protected abstract void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent);

    
    protected abstract TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.406 -0400", hash_original_method = "050C8CDC5807717B3CBB93F722D8E33D", hash_generated_method = "474D3723A7243CEE622A2BB6ABF58492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendMultipartText(String destAddr, String scAddr,
            ArrayList<String> parts, ArrayList<PendingIntent> sentIntents,
            ArrayList<PendingIntent> deliveryIntents) {
        dsTaint.addTaint(deliveryIntents.dsTaint);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntents.dsTaint);
        dsTaint.addTaint(parts.dsTaint);
        int refNumber;
        refNumber = getNextConcatenatedRef() & 0x00FF;
        int msgCount;
        msgCount = parts.size();
        int encoding;
        encoding = android.telephony.SmsMessage.ENCODING_UNKNOWN;
        mRemainingMessages = msgCount;
        TextEncodingDetails[] encodingForParts;
        encodingForParts = new TextEncodingDetails[msgCount];
        {
            int i;
            i = 0;
            {
                TextEncodingDetails details;
                details = calculateLength(parts.get(i), false);
                {
                    encoding = details.codeUnitSize;
                } //End block
                encodingForParts[i] = details;
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            {
                SmsHeader.ConcatRef concatRef;
                concatRef = new SmsHeader.ConcatRef();
                concatRef.refNumber = refNumber;
                concatRef.seqNumber = i + 1;
                concatRef.msgCount = msgCount;
                concatRef.isEightBits = true;
                SmsHeader smsHeader;
                smsHeader = new SmsHeader();
                smsHeader.concatRef = concatRef;
                {
                    smsHeader.languageTable = encodingForParts[i].languageTable;
                    smsHeader.languageShiftTable = encodingForParts[i].languageShiftTable;
                } //End block
                PendingIntent sentIntent;
                sentIntent = null;
                {
                    boolean var3DB5B890E041E90E00E1E32AC5A4787C_1722741772 = (sentIntents != null && sentIntents.size() > i);
                    {
                        sentIntent = sentIntents.get(i);
                    } //End block
                } //End collapsed parenthetic
                PendingIntent deliveryIntent;
                deliveryIntent = null;
                {
                    boolean varEFDA6B200ECEC013151CF90135B799F7_2104777681 = (deliveryIntents != null && deliveryIntents.size() > i);
                    {
                        deliveryIntent = deliveryIntents.get(i);
                    } //End block
                } //End collapsed parenthetic
                sendNewSubmitPdu(destAddr, scAddr, parts.get(i), smsHeader, encoding,
                    sentIntent, deliveryIntent, (i == (msgCount - 1)));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.407 -0400", hash_original_method = "17023DDC5CC5357F9142E0DE3564955A", hash_generated_method = "AB8A91C710E5C181DCA96904400DFF58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendRawPdu(byte[] smsc, byte[] pdu, PendingIntent sentIntent,
            PendingIntent deliveryIntent) {
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(pdu[0]);
        dsTaint.addTaint(smsc[0]);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        {
            {
                try 
                {
                    sentIntent.send(RESULT_ERROR_NO_SERVICE);
                } //End block
                catch (CanceledException ex)
                { }
            } //End block
            Log.d(TAG, "Device does not support sending sms.");
        } //End block
        {
            {
                try 
                {
                    sentIntent.send(RESULT_ERROR_NULL_PDU);
                } //End block
                catch (CanceledException ex)
                { }
            } //End block
        } //End block
        HashMap<String, Object> map;
        map = new HashMap<String, Object>();
        map.put("smsc", smsc);
        map.put("pdu", pdu);
        SmsTracker tracker;
        tracker = new SmsTracker(map, sentIntent,
                deliveryIntent);
        int ss;
        ss = mPhone.getServiceState().getState();
        {
            handleNotInService(ss, tracker);
        } //End block
        {
            String appName;
            appName = getAppNameByIntent(sentIntent);
            {
                boolean varCC51FA81A63C5EBC2D6B3E746C548A23_1254598271 = (mUsageMonitor.check(appName, SINGLE_PART_SMS));
                {
                    sendSms(tracker);
                } //End block
                {
                    sendMessage(obtainMessage(EVENT_POST_ALERT, tracker));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.407 -0400", hash_original_method = "771250D922DD0FBC637697CE165ADE5B", hash_generated_method = "844A3E59CA8E796D0B623F89220784B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handleReachSentLimit(SmsTracker tracker) {
        dsTaint.addTaint(tracker.dsTaint);
        {
            boolean varC295D27151F3296E7FF05C5A93122E6D_181195473 = (mSTrackers.size() >= MO_MSG_QUEUE_LIMIT);
            {
                try 
                {
                    tracker.mSentIntent.send(RESULT_ERROR_LIMIT_EXCEEDED);
                } //End block
                catch (CanceledException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        Resources r;
        r = Resources.getSystem();
        String appName;
        appName = getAppNameByIntent(tracker.mSentIntent);
        AlertDialog d;
        d = new AlertDialog.Builder(mContext)
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

    
    protected abstract void sendSms(SmsTracker tracker);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.408 -0400", hash_original_method = "3673C71AC378B483B72EBB14D4C20DB7", hash_generated_method = "95B56F1791673F7264853EE6A47B0291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMultipartSms(SmsTracker tracker) {
        dsTaint.addTaint(tracker.dsTaint);
        ArrayList<String> parts;
        ArrayList<PendingIntent> sentIntents;
        ArrayList<PendingIntent> deliveryIntents;
        HashMap<String, Object> map;
        map = tracker.mData;
        String destinationAddress;
        destinationAddress = (String) map.get("destination");
        String scAddress;
        scAddress = (String) map.get("scaddress");
        parts = (ArrayList<String>) map.get("parts");
        sentIntents = (ArrayList<PendingIntent>) map.get("sentIntents");
        deliveryIntents = (ArrayList<PendingIntent>) map.get("deliveryIntents");
        int ss;
        ss = mPhone.getServiceState().getState();
        {
            {
                int i, count;
                i = 0;
                count = parts.size();
                {
                    PendingIntent sentIntent;
                    sentIntent = null;
                    {
                        boolean varE26D7E4D9FA9614D62776674C3172AEF_1080843162 = (sentIntents != null && sentIntents.size() > i);
                        {
                            sentIntent = sentIntents.get(i);
                        } //End block
                    } //End collapsed parenthetic
                    handleNotInService(ss, new SmsTracker(null, sentIntent, null));
                } //End block
            } //End collapsed parenthetic
        } //End block
        sendMultipartText(destinationAddress, scAddress, parts, sentIntents, deliveryIntents);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract void acknowledgeLastIncomingSms(boolean success,
            int result, Message response);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.410 -0400", hash_original_method = "3FF14669D60F392B7539BF30A1AA74B3", hash_generated_method = "C117E1E14FFDCC090A1A9CE34A40FA5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyAndAcknowledgeLastIncomingSms(boolean success,
            int result, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(result);
        dsTaint.addTaint(success);
        {
            Intent intent;
            intent = new Intent(Intents.SMS_REJECTED_ACTION);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.410 -0400", hash_original_method = "978DCF88E3506C5AEC52023DC36FB472", hash_generated_method = "58CA7853D7DBC7BC63C2B461605F899F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchBroadcastPdus(byte[][] pdus, boolean isEmergencyMessage) {
        dsTaint.addTaint(pdus[0][0]);
        dsTaint.addTaint(isEmergencyMessage);
        {
            Intent intent;
            intent = new Intent(Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
            intent.putExtra("pdus", pdus);
            Log.d(TAG, "Dispatching " + pdus.length + " emergency SMS CB pdus");
            dispatch(intent, RECEIVE_EMERGENCY_BROADCAST_PERMISSION);
        } //End block
        {
            Intent intent;
            intent = new Intent(Intents.SMS_CB_RECEIVED_ACTION);
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
        public HashMap<String, Object> mData;
        public int mRetryCount;
        public int mMessageRef;
        public PendingIntent mSentIntent;
        public PendingIntent mDeliveryIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.410 -0400", hash_original_method = "877569CE168114AF55747488AC637330", hash_generated_method = "5349E45FE342489C1C9B5BB75881DB13")
        @DSModeled(DSC.SAFE)
        public SmsTracker(HashMap<String, Object> data, PendingIntent sentIntent,
                PendingIntent deliveryIntent) {
            dsTaint.addTaint(sentIntent.dsTaint);
            dsTaint.addTaint(data.dsTaint);
            dsTaint.addTaint(deliveryIntent.dsTaint);
            mRetryCount = 0;
            // ---------- Original Method ----------
            //mData = data;
            //mSentIntent = sentIntent;
            //mDeliveryIntent = deliveryIntent;
            //mRetryCount = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.411 -0400", hash_original_method = "2949B9E8FD6643222FD24B64B0F513BD", hash_generated_method = "9A6E6843D66D4799F1D4D04CD441C682")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean isMultipart() {
            HashMap map;
            map = mData;
            boolean var9577280E4DBB15FF5932A5F9D1F94961_892863555 = (map.containsKey("parts"));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //HashMap map = mData;
            //return map.containsKey("parts");
        }

        
    }


    
    static final String TAG = "SMS";
    private static final String SEND_NEXT_MSG_EXTRA = "SendNextMsg";
    private static final int DEFAULT_SMS_TIMEOUT = 6000;
    public static final String RECEIVE_SMS_PERMISSION = "android.permission.RECEIVE_SMS";
    public static final String RECEIVE_EMERGENCY_BROADCAST_PERMISSION =
            "android.permission.RECEIVE_EMERGENCY_BROADCAST";
    private static final String[] PDU_PROJECTION = new String[] {
            "pdu"
    };
    private static final String[] PDU_SEQUENCE_PORT_PROJECTION = new String[] {
            "pdu",
            "sequence",
            "destination_port"
    };
    private static final int PDU_COLUMN = 0;
    private static final int SEQUENCE_COLUMN = 1;
    private static final int DESTINATION_PORT_COLUMN = 2;
    protected static final int EVENT_NEW_SMS = 1;
    protected static final int EVENT_SEND_SMS_COMPLETE = 2;
    private static final int EVENT_SEND_RETRY = 3;
    private static final int EVENT_POST_ALERT = 4;
    static final int EVENT_SEND_CONFIRMED_SMS = 5;
    private static final int EVENT_ALERT_TIMEOUT = 6;
    static final int EVENT_STOP_SENDING = 7;
    protected static final Uri mRawUri = Uri.withAppendedPath(Telephony.Sms.CONTENT_URI, "raw");
    private static final int MAX_SEND_RETRIES = 3;
    private static final int SEND_RETRY_DELAY = 2000;
    private static final int SINGLE_PART_SMS = 1;
    private static final int MO_MSG_QUEUE_LIMIT = 5;
    private static int sConcatenatedRef = new Random().nextInt(256);
    private static final int WAKE_LOCK_TIMEOUT = 5000;
}

