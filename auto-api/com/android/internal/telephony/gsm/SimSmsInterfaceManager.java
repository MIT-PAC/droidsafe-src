package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.pm.PackageManager;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

public class SimSmsInterfaceManager extends IccSmsInterfaceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.463 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.468 -0400", hash_original_field = "51D04CAF6B674687BDD02BD17453D38D", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.468 -0400", hash_original_field = "8226893332EC8B3D4C41881E93F86D0B", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.468 -0400", hash_original_field = "5295D397E3B8ABF68AB05F812BD7E8EE", hash_generated_field = "B84253B8FA7AB46A694B9F6B58DBB692")

    private HashMap<Integer, HashSet<String>> mCellBroadcastSubscriptions = new HashMap<Integer, HashSet<String>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.468 -0400", hash_original_field = "4DB2139541B7A82F8504421C820CB49D", hash_generated_field = "BDB100102358F9C5E6439629D9C77938")

    private CellBroadcastRangeManager mCellBroadcastRangeManager = new CellBroadcastRangeManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.527 -0400", hash_original_field = "6D394D9EA6E1664AF7305BEAB74AC6B5", hash_generated_field = "F4B17FF743B551D88D9574EA5D666A86")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.469 -0400", hash_original_method = "2B211BBD733007234A9B9085CE23F724", hash_generated_method = "791EB521B43B73C3BF37FF78C68699C9")
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
                    mSms  = buildValidRawData((ArrayList<byte[]>) ar.result);
                } //End block
                {
                    log("Cannot load Sms records");
                    mSms.clear();
                } //End block
                mLock.notifyAll();
            } //End block
            //End case EVENT_LOAD_DONE 
            //Begin case EVENT_SET_BROADCAST_ACTIVATION_DONE EVENT_SET_BROADCAST_CONFIG_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_SET_BROADCAST_ACTIVATION_DONE EVENT_SET_BROADCAST_CONFIG_DONE 
            //Begin case EVENT_SET_BROADCAST_ACTIVATION_DONE EVENT_SET_BROADCAST_CONFIG_DONE 
            {
                mSuccess = (ar.exception == null);
                mLock.notifyAll();
            } //End block
            //End case EVENT_SET_BROADCAST_ACTIVATION_DONE EVENT_SET_BROADCAST_CONFIG_DONE 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.528 -0400", hash_original_method = "B76CF823F0B7FB39DC6F27A63B8B6D56", hash_generated_method = "108DE3522F8B92E90007B83E3548EB41")
    public  SimSmsInterfaceManager(GSMPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        mDispatcher = dispatcher;
        addTaint(phone.getTaint());
        addTaint(dispatcher.getTaint());
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.528 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.528 -0400", hash_original_method = "B5C7D22959BE2F7C1AB4B825F6E12647", hash_generated_method = "2C33189D3CD18A31AF8A0FB6F1FC6A1D")
    @Override
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.529 -0400", hash_original_method = "F53F9B39BB318705FAF6F47512F2ECB5", hash_generated_method = "B6F1EE519EBEF0A2FBFA43DE94873150")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Updating message on SIM");
        {
            mSuccess = false;
            Message response;
            response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            {
                mPhone.mCM.deleteSmsOnSim(index, response);
            } //End block
            {
                byte[] record;
                record = makeSmsRecordData(status, pdu);
                mPhone.getIccFileHandler().updateEFLinearFixed(
                        IccConstants.EF_SMS,
                        index, record, null, response);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579753846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_579753846;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.530 -0400", hash_original_method = "5C5D2075C67DB185E1C8FAD979C1C6EE", hash_generated_method = "031243BEB55E1F1F347B6438947DD04D")
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) +
                "), smsm=(" + Arrays.toString(smsc) +")");
        enforceReceiveAndSend("Copying message to SIM");
        {
            mSuccess = false;
            Message response;
            response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            mPhone.mCM.writeSmsToSim(status, IccUtils.bytesToHexString(smsc),
                    IccUtils.bytesToHexString(pdu), response);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538369020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538369020;
        // ---------- Original Method ----------
        //if (DBG) log("copyMessageToIccEf: status=" + status + " ==> " +
                //"pdu=("+ Arrays.toString(pdu) +
                //"), smsm=(" + Arrays.toString(smsc) +")");
        //enforceReceiveAndSend("Copying message to SIM");
        //synchronized(mLock) {
            //mSuccess = false;
            //Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            //mPhone.mCM.writeSmsToSim(status, IccUtils.bytesToHexString(smsc),
                    //IccUtils.bytesToHexString(pdu), response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to update by index");
            //}
        //}
        //return mSuccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.531 -0400", hash_original_method = "D4D266DBBD67105329BC4DC8BFFFFEC2", hash_generated_method = "C6232848D9E4381E79ED67E3D5BC792A")
    public List<SmsRawData> getAllMessagesFromIccEf() {
        List<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_1238682888 = null; //Variable for return #1
        log("getAllMessagesFromEF");
        Context context;
        context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from SIM");
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
                log("interrupted while trying to load from the SIM");
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1238682888 = mSms;
        varB4EAC82CA7396A68D541C85D26508E83_1238682888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1238682888;
        // ---------- Original Method ----------
        //if (DBG) log("getAllMessagesFromEF");
        //Context context = mPhone.getContext();
        //context.enforceCallingPermission(
                //"android.permission.RECEIVE_SMS",
                //"Reading messages from SIM");
        //synchronized(mLock) {
            //Message response = mHandler.obtainMessage(EVENT_LOAD_DONE);
            //mPhone.getIccFileHandler().loadEFLinearFixedAll(IccConstants.EF_SMS, response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to load from the SIM");
            //}
        //}
        //return mSms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.532 -0400", hash_original_method = "9E9858677901A40DCFB3014D7783E7CF", hash_generated_method = "49C78BE030C8037DCF5D29F4FCED0B95")
    public boolean enableCellBroadcast(int messageIdentifier) {
        boolean var8C8D74A8863606631DE54B7E9069A175_1136658139 = (enableCellBroadcastRange(messageIdentifier, messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142680206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142680206;
        // ---------- Original Method ----------
        //return enableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.532 -0400", hash_original_method = "E254B3C21063075DCFCF4B937B1FF66E", hash_generated_method = "948A3622F3CBA954CC3787D6C2368190")
    public boolean disableCellBroadcast(int messageIdentifier) {
        boolean varCED64931F28FE138F7464163BC3E19E0_1297664164 = (disableCellBroadcastRange(messageIdentifier, messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522888355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522888355;
        // ---------- Original Method ----------
        //return disableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.532 -0400", hash_original_method = "8E661A700D601CF050E065CDC056070F", hash_generated_method = "5C1FDAC33CEDD3E04F06C0E878383599")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        log("enableCellBroadcastRange");
        Context context;
        context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Enabling cell broadcast SMS");
        String client;
        client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
        {
            boolean varFBC088AEED27062F33727167AE6F95FA_1551026998 = (!mCellBroadcastRangeManager.enableRange(startMessageId, endMessageId, client));
            {
                log("Failed to add cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } //End block
        } //End collapsed parenthetic
        log("Added cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317136713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317136713;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.533 -0400", hash_original_method = "47BAD55325978FFE5C517009A7EF2AB8", hash_generated_method = "3E053768321C9EBF3B139B5BA0F5455B")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        log("disableCellBroadcastRange");
        Context context;
        context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Disabling cell broadcast SMS");
        String client;
        client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
        {
            boolean var6F1DF54DDA7D97E10487F0EAA0F27713_1455684328 = (!mCellBroadcastRangeManager.disableRange(startMessageId, endMessageId, client));
            {
                log("Failed to remove cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } //End block
        } //End collapsed parenthetic
        log("Removed cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829772708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829772708;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.534 -0400", hash_original_method = "13CBDA000CECA6BBED63F386B07FC011", hash_generated_method = "CAFA0E7A07FA9683054507C6B3FBF38B")
    private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo[] configs) {
        log("Calling setGsmBroadcastConfig with " + configs.length + " configurations");
        {
            Message response;
            response = mHandler.obtainMessage(EVENT_SET_BROADCAST_CONFIG_DONE);
            mSuccess = false;
            mPhone.mCM.setGsmBroadcastConfig(configs, response);
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
                log("interrupted while trying to set cell broadcast config");
            } //End block
        } //End block
        addTaint(configs[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953562243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953562243;
        // ---------- Original Method ----------
        //if (DBG)
            //log("Calling setGsmBroadcastConfig with " + configs.length + " configurations");
        //synchronized (mLock) {
            //Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_CONFIG_DONE);
            //mSuccess = false;
            //mPhone.mCM.setGsmBroadcastConfig(configs, response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to set cell broadcast config");
            //}
        //}
        //return mSuccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.534 -0400", hash_original_method = "D2ABD2A7A42536455FF89EC95B86ABFC", hash_generated_method = "1A35E29D8B409C4E4699F648BD56A7A3")
    private boolean setCellBroadcastActivation(boolean activate) {
        log("Calling setCellBroadcastActivation(" + activate + ')');
        {
            Message response;
            response = mHandler.obtainMessage(EVENT_SET_BROADCAST_ACTIVATION_DONE);
            mSuccess = false;
            mPhone.mCM.setGsmBroadcastActivation(activate, response);
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
                log("interrupted while trying to set cell broadcast activation");
            } //End block
        } //End block
        addTaint(activate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712071581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_712071581;
        // ---------- Original Method ----------
        //if (DBG)
            //log("Calling setCellBroadcastActivation(" + activate + ')');
        //synchronized (mLock) {
            //Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_ACTIVATION_DONE);
            //mSuccess = false;
            //mPhone.mCM.setGsmBroadcastActivation(activate, response);
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //log("interrupted while trying to set cell broadcast activation");
            //}
        //}
        //return mSuccess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.534 -0400", hash_original_method = "8FFAE6152EC966DD60EE44B9C7188E3E", hash_generated_method = "A78A96AD63975F1872A34309071EE3EB")
    @Override
    protected void log(String msg) {
        Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
    }

    
    class CellBroadcastRangeManager extends IntRangeManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.534 -0400", hash_original_field = "C44116DC6796845984805B9F9E58678C", hash_generated_field = "DF520AF3FDD23D6477ECBF735C000104")

        private ArrayList<SmsBroadcastConfigInfo> mConfigList = new ArrayList<SmsBroadcastConfigInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.535 -0400", hash_original_method = "C394C8BFADF1F863BE74B5C008CAC491", hash_generated_method = "C394C8BFADF1F863BE74B5C008CAC491")
        public CellBroadcastRangeManager ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.535 -0400", hash_original_method = "9715F7B64D6F5D9B1FC00DACD193B4CE", hash_generated_method = "9FFE737D65BF3BA4E83567038136FE56")
        protected void startUpdate() {
            mConfigList.clear();
            // ---------- Original Method ----------
            //mConfigList.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.535 -0400", hash_original_method = "6A2FA862D29C9C6898FE89F28FC062F6", hash_generated_method = "07F902704F05DA41D4E44FBE2E8A25C4")
        protected void addRange(int startId, int endId, boolean selected) {
            mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
            addTaint(startId);
            addTaint(endId);
            addTaint(selected);
            // ---------- Original Method ----------
            //mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        //SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_method = "1E945351230B27489052E59869E2AD9A", hash_generated_method = "1FC9B0F6F95EA39B70E640638E226D99")
        protected boolean finishUpdate() {
            {
                boolean varFCD646C4E99CC667B09618B1E7707A11_1405439440 = (mConfigList.isEmpty());
                {
                    SmsBroadcastConfigInfo[] configs;
                    configs = mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                    boolean var65B4DD29DFB765BB5E794AEBB8DA5BA3_1956180359 = (setCellBroadcastConfig(configs));
                } //End block
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954606925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954606925;
            // ---------- Original Method ----------
            //if (mConfigList.isEmpty()) {
                //return true;
            //} else {
                //SmsBroadcastConfigInfo[] configs =
                        //mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                //return setCellBroadcastConfig(configs);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "BA31E82B2F843C2330C45AAEA0F35804")

    static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_field = "B0BA389891763CE058F1838506410614", hash_generated_field = "864E86E102EB0C5192094AD975590E57")

    private static int EVENT_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_field = "FA5C825AD4E8BE0B56282EA4E98C2D84", hash_generated_field = "312F6B74742EA88AF68ECA2A708B5890")

    private static int EVENT_UPDATE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.564 -0400", hash_original_field = "B60BA1295CCFC2B789AA51D8AA66C386", hash_generated_field = "B105ACBA3705D18D77ADE5FB90559F5A")

    private static int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.565 -0400", hash_original_field = "C61701770F019E446DE5BBFF7502996B", hash_generated_field = "0CB28A6433E8F9146AEF9B992AD900B1")

    private static int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.565 -0400", hash_original_field = "3FCCB6C601A0DC41EA1AD349CB9AE7FB", hash_generated_field = "91BE3AD88FBF103AB55665A1BC130942")

    private static int SMS_CB_CODE_SCHEME_MIN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.565 -0400", hash_original_field = "3CA7A777CBDF7832989FADE4932F143B", hash_generated_field = "E701F0572E54F4EFA56BA65712CA9F12")

    private static int SMS_CB_CODE_SCHEME_MAX = 255;
}

