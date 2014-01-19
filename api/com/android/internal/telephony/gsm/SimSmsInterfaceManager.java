package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.IntRangeManager;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.SmsRawData;

public class SimSmsInterfaceManager extends IccSmsInterfaceManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.723 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.726 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.740 -0500", hash_original_field = "CB2C30527400449D368083C9A417745F", hash_generated_field = "77BC6FD0DC199252047A7F7B64B6060D")

    private static final int EVENT_LOAD_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.743 -0500", hash_original_field = "5409277739A12236F0DB56D6F1D6490F", hash_generated_field = "15C9033C6CF121B938E3ED8FAF5BE197")

    private static final int EVENT_UPDATE_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.747 -0500", hash_original_field = "D5BA1244C85EA9F646AB373A03D6C0C8", hash_generated_field = "BD6D4D21A28A2356F9E1C02134365F6C")

    private static final int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.749 -0500", hash_original_field = "98627770C561E5EDEFF80A58DE6B93CE", hash_generated_field = "AD21793B4EF8173C5031398FC452928B")

    private static final int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.752 -0500", hash_original_field = "EE51074070E35A7CF232586983489514", hash_generated_field = "F1286DF59C8C824170BC9070DB37FD65")

    private static final int SMS_CB_CODE_SCHEME_MIN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.755 -0500", hash_original_field = "FB0FEB39030EA1078B91CA149561147A", hash_generated_field = "DDAC7097350FA73BA388F57E43349186")

    private static final int SMS_CB_CODE_SCHEME_MAX = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.728 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.731 -0500", hash_original_field = "8DB7F83EC06955504CF74A8D7DB183AB", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.733 -0500", hash_original_field = "5370DAD9751D4F4C600491B1B9F2E288", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.736 -0500", hash_original_field = "FC4A8A561BF9E19FCEE7F48370299204", hash_generated_field = "B84253B8FA7AB46A694B9F6B58DBB692")

    private HashMap<Integer, HashSet<String>> mCellBroadcastSubscriptions =
            new HashMap<Integer, HashSet<String>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.738 -0500", hash_original_field = "FDCC8B3271B79525F924E5ED78559DFF", hash_generated_field = "BDB100102358F9C5E6439629D9C77938")

    private CellBroadcastRangeManager mCellBroadcastRangeManager =
            new CellBroadcastRangeManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.437 -0400", hash_original_field = "6D394D9EA6E1664AF7305BEAB74AC6B5", hash_generated_field = "2581284BDC9FE06CEA002CD189D3CA4F")

    Handler mHandler = new Handler() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.437 -0400", hash_original_method = "2B211BBD733007234A9B9085CE23F724", hash_generated_method = "791EB521B43B73C3BF37FF78C68699C9")
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
                    mSms  = buildValidRawData((ArrayList<byte[]>) ar.result);
                } 
                {
                    log("Cannot load Sms records");
                    mSms.clear();
                } 
                mLock.notifyAll();
            }
            
            ar = (AsyncResult) msg.obj;
            
            {
                mSuccess = (ar.exception == null);
                mLock.notifyAll();
            }
            
            addTaint(msg.getTaint());
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.764 -0500", hash_original_method = "B76CF823F0B7FB39DC6F27A63B8B6D56", hash_generated_method = "BEF1B056DF7E491E7A8E8AE57B56B670")
    
public SimSmsInterfaceManager(GSMPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        mDispatcher = dispatcher;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.767 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.769 -0500", hash_original_method = "B5C7D22959BE2F7C1AB4B825F6E12647", hash_generated_method = "E273096A1042D6FEE88AC16B53B4CA4A")
    
@Override
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Log.e(LOG_TAG, "Error while finalizing:", throwable);
        }
        if(DBG) Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
    }

    /**
     * Update the specified message on the SIM.
     *
     * @param index record index of message to update
     * @param status new message status (STATUS_ON_ICC_READ,
     *                  STATUS_ON_ICC_UNREAD, STATUS_ON_ICC_SENT,
     *                  STATUS_ON_ICC_UNSENT, STATUS_ON_ICC_FREE)
     * @param pdu the raw PDU to store
     * @return success or not
     *
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.772 -0500", hash_original_method = "F53F9B39BB318705FAF6F47512F2ECB5", hash_generated_method = "49E70B7A760FCEC75D209A01D89AE40A")
    
public boolean
    updateMessageOnIccEf(int index, int status, byte[] pdu) {
        if (DBG) log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Updating message on SIM");
        synchronized(mLock) {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);

            if (status == STATUS_ON_ICC_FREE) {
                // Special case FREE: call deleteSmsOnSim instead of
                // manipulating the SIM record
                mPhone.mCM.deleteSmsOnSim(index, response);
            } else {
                byte[] record = makeSmsRecordData(status, pdu);
                mPhone.getIccFileHandler().updateEFLinearFixed(
                        IccConstants.EF_SMS,
                        index, record, null, response);
            }
            try {
                mLock.wait();
            } catch (InterruptedException e) {
                log("interrupted while trying to update by index");
            }
        }
        return mSuccess;
    }

    /**
     * Copy a raw SMS PDU to the SIM.
     *
     * @param pdu the raw PDU to store
     * @param status message status (STATUS_ON_ICC_READ, STATUS_ON_ICC_UNREAD,
     *               STATUS_ON_ICC_SENT, STATUS_ON_ICC_UNSENT)
     * @return success or not
     *
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.775 -0500", hash_original_method = "5C5D2075C67DB185E1C8FAD979C1C6EE", hash_generated_method = "82AFFDC08ABE282C4377A87122DA1464")
    
public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        if (DBG) log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) +
                "), smsm=(" + Arrays.toString(smsc) +")");
        enforceReceiveAndSend("Copying message to SIM");
        synchronized(mLock) {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);

            mPhone.mCM.writeSmsToSim(status, IccUtils.bytesToHexString(smsc),
                    IccUtils.bytesToHexString(pdu), response);

            try {
                mLock.wait();
            } catch (InterruptedException e) {
                log("interrupted while trying to update by index");
            }
        }
        return mSuccess;
    }
    
    class CellBroadcastRangeManager extends IntRangeManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.791 -0500", hash_original_field = "E386E86B596DF6D51C015D0FEBAFBF70", hash_generated_field = "DF520AF3FDD23D6477ECBF735C000104")

        private ArrayList<SmsBroadcastConfigInfo> mConfigList =
                new ArrayList<SmsBroadcastConfigInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.655 -0400", hash_original_method = "C394C8BFADF1F863BE74B5C008CAC491", hash_generated_method = "C394C8BFADF1F863BE74B5C008CAC491")
        public CellBroadcastRangeManager ()
        {
            //Synthesized constructor
        }

        /**
         * Called when the list of enabled ranges has changed. This will be
         * followed by zero or more calls to {@link #addRange} followed by
         * a call to {@link #finishUpdate}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.794 -0500", hash_original_method = "9715F7B64D6F5D9B1FC00DACD193B4CE", hash_generated_method = "7EBC893659448732AD3B97598639A520")
        
protected void startUpdate() {
            mConfigList.clear();
        }

        /**
         * Called after {@link #startUpdate} to indicate a range of enabled
         * values.
         * @param startId the first id included in the range
         * @param endId the last id included in the range
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.797 -0500", hash_original_method = "6A2FA862D29C9C6898FE89F28FC062F6", hash_generated_method = "7664AF46342F2E2D005ADCB8F742A8A5")
        
protected void addRange(int startId, int endId, boolean selected) {
            mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
        }

        /**
         * Called to indicate the end of a range update started by the
         * previous call to {@link #startUpdate}.
         * @return true if successful, false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.800 -0500", hash_original_method = "1E945351230B27489052E59869E2AD9A", hash_generated_method = "BA71A2982049EF3E322D1E6EC41F3B86")
        
protected boolean finishUpdate() {
            if (mConfigList.isEmpty()) {
                return true;
            } else {
                SmsBroadcastConfigInfo[] configs =
                        mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                return setCellBroadcastConfig(configs);
            }
        }
        
    }

    /**
     * Retrieves all messages currently stored on ICC.
     *
     * @return list of SmsRawData of all sms on ICC
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.778 -0500", hash_original_method = "D4D266DBBD67105329BC4DC8BFFFFEC2", hash_generated_method = "A59CD924AC83DF924A17F88575FABD38")
    
public List<SmsRawData> getAllMessagesFromIccEf() {
        if (DBG) log("getAllMessagesFromEF");

        Context context = mPhone.getContext();

        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from SIM");
        synchronized(mLock) {
            Message response = mHandler.obtainMessage(EVENT_LOAD_DONE);
            mPhone.getIccFileHandler().loadEFLinearFixedAll(IccConstants.EF_SMS, response);

            try {
                mLock.wait();
            } catch (InterruptedException e) {
                log("interrupted while trying to load from the SIM");
            }
        }
        return mSms;
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.780 -0500", hash_original_method = "9E9858677901A40DCFB3014D7783E7CF", hash_generated_method = "3A8293AFC2012B894D8B7146FC189DC2")
    
public boolean enableCellBroadcast(int messageIdentifier) {
        return enableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.782 -0500", hash_original_method = "E254B3C21063075DCFCF4B937B1FF66E", hash_generated_method = "EE2A8CACBF247C7ED9D2D6FE76F3FDA8")
    
public boolean disableCellBroadcast(int messageIdentifier) {
        return disableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.786 -0500", hash_original_method = "8E661A700D601CF050E065CDC056070F", hash_generated_method = "7F0EBB7A5F2A2A049FCA58EAD8F1BD48")
    
public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        if (DBG) log("enableCellBroadcastRange");

        Context context = mPhone.getContext();

        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Enabling cell broadcast SMS");

        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());

        if (!mCellBroadcastRangeManager.enableRange(startMessageId, endMessageId, client)) {
            log("Failed to add cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            return false;
        }

        if (DBG)
            log("Added cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);

        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.788 -0500", hash_original_method = "47BAD55325978FFE5C517009A7EF2AB8", hash_generated_method = "5D2F23AF12FE18DE4504F45C8E6AE5D3")
    
public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        if (DBG) log("disableCellBroadcastRange");

        Context context = mPhone.getContext();

        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Disabling cell broadcast SMS");

        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());

        if (!mCellBroadcastRangeManager.disableRange(startMessageId, endMessageId, client)) {
            log("Failed to remove cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            return false;
        }

        if (DBG)
            log("Removed cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);

        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.805 -0500", hash_original_method = "13CBDA000CECA6BBED63F386B07FC011", hash_generated_method = "59120505421C36B14F3FC8FA709B07F6")
    
private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo[] configs) {
        if (DBG)
            log("Calling setGsmBroadcastConfig with " + configs.length + " configurations");

        synchronized (mLock) {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_CONFIG_DONE);

            mSuccess = false;
            mPhone.mCM.setGsmBroadcastConfig(configs, response);

            try {
                mLock.wait();
            } catch (InterruptedException e) {
                log("interrupted while trying to set cell broadcast config");
            }
        }

        return mSuccess;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.808 -0500", hash_original_method = "D2ABD2A7A42536455FF89EC95B86ABFC", hash_generated_method = "A571AA07F9819A311BBA5B94737C53F3")
    
private boolean setCellBroadcastActivation(boolean activate) {
        if (DBG)
            log("Calling setCellBroadcastActivation(" + activate + ')');

        synchronized (mLock) {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_ACTIVATION_DONE);

            mSuccess = false;
            mPhone.mCM.setGsmBroadcastActivation(activate, response);

            try {
                mLock.wait();
            } catch (InterruptedException e) {
                log("interrupted while trying to set cell broadcast activation");
            }
        }

        return mSuccess;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:28.811 -0500", hash_original_method = "8FFAE6152EC966DD60EE44B9C7188E3E", hash_generated_method = "AE18B4027DD55BFC217EF66624ED5BC3")
    
@Override
    protected void log(String msg) {
        Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
    }
}

