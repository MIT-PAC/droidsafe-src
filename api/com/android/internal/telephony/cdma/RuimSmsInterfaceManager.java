package com.android.internal.telephony.cdma;

// Droidsafe Imports
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.SmsRawData;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RuimSmsInterfaceManager extends IccSmsInterfaceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.376 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.376 -0400", hash_original_field = "51D04CAF6B674687BDD02BD17453D38D", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.376 -0400", hash_original_field = "8226893332EC8B3D4C41881E93F86D0B", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_field = "654C2E444ACAAB197BCB3C0E6DCC67BF", hash_generated_field = "AA89A217FED25E195A2047490DDFA22C")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_method = "01E53BC323696EFAA61574434CDF6DFE", hash_generated_method = "66ECD7764DB1A6ED4686549C444DA384")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            
            ar = (AsyncResult) msg.obj;
            
            
            {
                mSuccess = (ar.exception == null);
                mLock.notifyAll();
            } 
            
            
            ar = (AsyncResult)msg.obj;
            
            
            {
                {
                    mSms = buildValidRawData((ArrayList<byte[]>) ar.result);
                } 
                {
                    log("Cannot load Sms records");
                    mSms.clear();
                } 
                mLock.notifyAll();
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.376 -0400", hash_original_method = "BD8DF48547112A1ED89E06EF8DBAC147", hash_generated_method = "AEC21BB3A2F8351A81A22755BF88A93F")
    public  RuimSmsInterfaceManager(CDMAPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        addTaint(dispatcher.getTaint());
        addTaint(phone.getTaint());
        mDispatcher = dispatcher;
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.376 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.377 -0400", hash_original_method = "4FA1DF67E8E2FEA7279C76FF6F2C28E0", hash_generated_method = "C0C43D8ACAFF0B71521D10DF8760751F")
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        {
        } //End block
        if(DBG)        
        Log.d(LOG_TAG, "RuimSmsInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "RuimSmsInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.377 -0400", hash_original_method = "4E34C2A3F0747FC60FF3AABB1F75DE9B", hash_generated_method = "3A86BCBED2D90F12A6D078F3B4B19D74")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        addTaint(pdu[0]);
        addTaint(status);
        addTaint(index);
        if(DBG)        
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ pdu + ")");
        enforceReceiveAndSend("Updating message on RUIM");
        synchronized
(mLock)        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            if(status == STATUS_ON_ICC_FREE)            
            {
                mPhone.mCM.deleteSmsOnRuim(index, response);
            } //End block
            else
            {
                byte[] record = makeSmsRecordData(status, pdu);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_1655734029 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482333093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_482333093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.378 -0400", hash_original_method = "F615398128ECEE16BD7E7D5E7CEBDFE4", hash_generated_method = "C9681350A558519AA2C672214E81F7C0")
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        addTaint(smsc[0]);
        addTaint(pdu[0]);
        addTaint(status);
        if(DBG)        
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Copying message to RUIM");
        synchronized
(mLock)        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_1301599386 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363623504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363623504;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.379 -0400", hash_original_method = "2942961FDF8C69DB3912CFC67A52E698", hash_generated_method = "C86287EB22C6B4EACF8EBF326DE4AC21")
    public List<SmsRawData> getAllMessagesFromIccEf() {
        if(DBG)        
        log("getAllMessagesFromEF");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from RUIM");
        synchronized
(mLock)        {
            Message response = mHandler.obtainMessage(EVENT_LOAD_DONE);
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
List<SmsRawData> var7BF1E9CBCC2022F70728CF07D46D244B_1158482755 =         mSms;
        var7BF1E9CBCC2022F70728CF07D46D244B_1158482755.addTaint(taint);
        return var7BF1E9CBCC2022F70728CF07D46D244B_1158482755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.379 -0400", hash_original_method = "B36353E8C6494764B604BA61C09FD3A9", hash_generated_method = "130CE4A09DB704C34C348B0B9965ACFE")
    public boolean enableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean var68934A3E9455FA72420237EB05902327_1358356484 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135084364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135084364;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.379 -0400", hash_original_method = "4359F4C67258CB29FAAD950989F56651", hash_generated_method = "B7580A9DD7D4BA2C3A7870F122A51233")
    public boolean disableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean var68934A3E9455FA72420237EB05902327_1665327373 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097073661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097073661;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.380 -0400", hash_original_method = "AEDCAF6C3B71A6FB2E26AFF2BA601D09", hash_generated_method = "D1A39160CCE4C012C588B324AAE3F7F0")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean var68934A3E9455FA72420237EB05902327_290997126 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473437355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473437355;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.380 -0400", hash_original_method = "395863C3AC4BAF6D1AC0ABA956E02C48", hash_generated_method = "E3988A77A29C04A8DDF633E69D7F77DC")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean var68934A3E9455FA72420237EB05902327_1163080644 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166413093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166413093;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.380 -0400", hash_original_method = "A1B1A2F1E999A2614769F6F66BA1F268", hash_generated_method = "117A5F719F847BD2E92DAA06231A89A1")
    protected void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.380 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.381 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.381 -0400", hash_original_field = "B0BA389891763CE058F1838506410614", hash_generated_field = "77BC6FD0DC199252047A7F7B64B6060D")

    private static final int EVENT_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.381 -0400", hash_original_field = "FA5C825AD4E8BE0B56282EA4E98C2D84", hash_generated_field = "15C9033C6CF121B938E3ED8FAF5BE197")

    private static final int EVENT_UPDATE_DONE = 2;
}

