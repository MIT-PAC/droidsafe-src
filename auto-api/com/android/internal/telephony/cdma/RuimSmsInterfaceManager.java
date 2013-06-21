package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.SmsRawData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

public class RuimSmsInterfaceManager extends IccSmsInterfaceManager {
    private Object mLock = new Object();
    private boolean mSuccess;
    private List<SmsRawData> mSms;
    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.846 -0400", hash_original_method = "01E53BC323696EFAA61574434CDF6DFE", hash_generated_method = "90C1EE4F859B2509439722DCC90533EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            AsyncResult ar;
            //Begin case EVENT_UPDATE_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_UPDATE_DONE 
            {
                mSuccess = (ar.exception == null);
                mLock.notifyAll();
            } //End block
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_LOAD_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_LOAD_DONE 
            //Begin case EVENT_LOAD_DONE 
            {
                {
                    mSms = buildValidRawData((ArrayList<byte[]>) ar.result);
                } //End block
                {
                    log("Cannot load Sms records");
                    mSms.clear();
                } //End block
                mLock.notifyAll();
            } //End block
            //End case EVENT_LOAD_DONE 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.846 -0400", hash_original_method = "BD8DF48547112A1ED89E06EF8DBAC147", hash_generated_method = "B900D1BE6E2C76A3C71C652480C27C63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuimSmsInterfaceManager(CDMAPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(dispatcher.dsTaint);
        mDispatcher = dispatcher;
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.847 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.847 -0400", hash_original_method = "4FA1DF67E8E2FEA7279C76FF6F2C28E0", hash_generated_method = "EA8A25B033B6E42598553EAED746B003")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "RuimSmsInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "RuimSmsInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.847 -0400", hash_original_method = "4E34C2A3F0747FC60FF3AABB1F75DE9B", hash_generated_method = "838B8A33B46187FDCB5764913E6CB324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ pdu + ")");
        enforceReceiveAndSend("Updating message on RUIM");
        {
            mSuccess = false;
            Message response;
            response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            {
                mPhone.mCM.deleteSmsOnRuim(index, response);
            } //End block
            {
                byte[] record;
                record = makeSmsRecordData(status, pdu);
                mPhone.getIccFileHandler().updateEFLinearFixed(
                        IccConstants.EF_SMS, index, record, null, response);
            } //End block
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
                log("interrupted while trying to update by index");
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.848 -0400", hash_original_method = "F615398128ECEE16BD7E7D5E7CEBDFE4", hash_generated_method = "254A1E68E3F2BF0B35CAC77FE6CFE2B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        dsTaint.addTaint(smsc[0]);
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Copying message to RUIM");
        {
            mSuccess = false;
            Message response;
            response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            mPhone.mCM.writeSmsToRuim(status, IccUtils.bytesToHexString(pdu),
                    response);
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
                log("interrupted while trying to update by index");
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("copyMessageToIccEf: status=" + status + " ==> " +
                //"pdu=("+ Arrays.toString(pdu) + ")");
        //enforceReceiveAndSend("Copying message to RUIM");
        //synchronized(mLock) {
            //mSuccess = false;
            //Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            //mPhone.mCM.writeSmsToRuim(status, IccUtils.bytesToHexString(pdu),
                    //response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to update by index");
            //}
        //}
        //return mSuccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.848 -0400", hash_original_method = "2942961FDF8C69DB3912CFC67A52E698", hash_generated_method = "644BC4537B4625EC46986081800EC20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<SmsRawData> getAllMessagesFromIccEf() {
        log("getAllMessagesFromEF");
        Context context;
        context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from RUIM");
        {
            Message response;
            response = mHandler.obtainMessage(EVENT_LOAD_DONE);
            mPhone.getIccFileHandler().loadEFLinearFixedAll(IccConstants.EF_SMS, response);
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
                log("interrupted while trying to load from the RUIM");
            } //End block
        } //End block
        return (List<SmsRawData>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) log("getAllMessagesFromEF");
        //Context context = mPhone.getContext();
        //context.enforceCallingPermission(
                //"android.permission.RECEIVE_SMS",
                //"Reading messages from RUIM");
        //synchronized(mLock) {
            //Message response = mHandler.obtainMessage(EVENT_LOAD_DONE);
            //mPhone.getIccFileHandler().loadEFLinearFixedAll(IccConstants.EF_SMS, response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to load from the RUIM");
            //}
        //}
        //return mSms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.848 -0400", hash_original_method = "B36353E8C6494764B604BA61C09FD3A9", hash_generated_method = "412976A4B8B160074355B2C436849EE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.848 -0400", hash_original_method = "4359F4C67258CB29FAAD950989F56651", hash_generated_method = "EF48653FCD0244204C365E5192181D29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.848 -0400", hash_original_method = "AEDCAF6C3B71A6FB2E26AFF2BA601D09", hash_generated_method = "FB7435814630208952271346C127CB5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.849 -0400", hash_original_method = "395863C3AC4BAF6D1AC0ABA956E02C48", hash_generated_method = "93711D0C0BF278935BEBCC50AF6B1E5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.849 -0400", hash_original_method = "A1B1A2F1E999A2614769F6F66BA1F268", hash_generated_method = "DA88987AE7521D4C8DFF53046D29BA33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
    }

    
    static final String LOG_TAG = "CDMA";
    static final boolean DBG = true;
    private static final int EVENT_LOAD_DONE = 1;
    private static final int EVENT_UPDATE_DONE = 2;
}

