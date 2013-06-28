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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.557 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.557 -0400", hash_original_field = "51D04CAF6B674687BDD02BD17453D38D", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.557 -0400", hash_original_field = "8226893332EC8B3D4C41881E93F86D0B", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_field = "654C2E444ACAAB197BCB3C0E6DCC67BF", hash_generated_field = "AA89A217FED25E195A2047490DDFA22C")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_method = "01E53BC323696EFAA61574434CDF6DFE", hash_generated_method = "66ECD7764DB1A6ED4686549C444DA384")
        @Override
        public void handleMessage(Message msg) {
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
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_method = "BD8DF48547112A1ED89E06EF8DBAC147", hash_generated_method = "98B238F62ACF3EB886676D7E16D40A59")
    public  RuimSmsInterfaceManager(CDMAPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        mDispatcher = dispatcher;
        addTaint(phone.getTaint());
        addTaint(dispatcher.getTaint());
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.558 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.559 -0400", hash_original_method = "4FA1DF67E8E2FEA7279C76FF6F2C28E0", hash_generated_method = "EA8A25B033B6E42598553EAED746B003")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.559 -0400", hash_original_method = "4E34C2A3F0747FC60FF3AABB1F75DE9B", hash_generated_method = "47BE144EF8A58BE03DAC5D7239296CFA")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ pdu + ")");
        enforceReceiveAndSend("Updating message on RUIM");
        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            {
                mPhone.mCM.deleteSmsOnRuim(index, response);
            } //End block
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
        addTaint(index);
        addTaint(status);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997254370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_997254370;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.560 -0400", hash_original_method = "F615398128ECEE16BD7E7D5E7CEBDFE4", hash_generated_method = "792F405B5F859138980328C90CF0FB6C")
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Copying message to RUIM");
        {
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
        addTaint(status);
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813078782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813078782;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.561 -0400", hash_original_method = "2942961FDF8C69DB3912CFC67A52E698", hash_generated_method = "541546E4FE07C04FC525524181D68B8A")
    public List<SmsRawData> getAllMessagesFromIccEf() {
        List<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_1285416546 = null; //Variable for return #1
        log("getAllMessagesFromEF");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from RUIM");
        {
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
        varB4EAC82CA7396A68D541C85D26508E83_1285416546 = mSms;
        varB4EAC82CA7396A68D541C85D26508E83_1285416546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285416546;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.562 -0400", hash_original_method = "B36353E8C6494764B604BA61C09FD3A9", hash_generated_method = "6EAC3E372FAE3947769DF1662350B5CD")
    public boolean enableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116762233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116762233;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.563 -0400", hash_original_method = "4359F4C67258CB29FAAD950989F56651", hash_generated_method = "78D72747B77034148ACCC6A59D51F72A")
    public boolean disableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835585848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835585848;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.563 -0400", hash_original_method = "AEDCAF6C3B71A6FB2E26AFF2BA601D09", hash_generated_method = "32240518A679C35ADEA50B765C492595")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866289560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866289560;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_method = "395863C3AC4BAF6D1AC0ABA956E02C48", hash_generated_method = "7B7FD4FABFFC056A6F3BED5EC9B3C6DF")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738680701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738680701;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "Error! Not implemented for CDMA.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_method = "A1B1A2F1E999A2614769F6F66BA1F268", hash_generated_method = "C56FE9CC6E8219CB5F82D4C77547BDFD")
    protected void log(String msg) {
        Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimSmsInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_field = "B0BA389891763CE058F1838506410614", hash_generated_field = "77BC6FD0DC199252047A7F7B64B6060D")

    private static final int EVENT_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.564 -0400", hash_original_field = "FA5C825AD4E8BE0B56282EA4E98C2D84", hash_generated_field = "15C9033C6CF121B938E3ED8FAF5BE197")

    private static final int EVENT_UPDATE_DONE = 2;
}

