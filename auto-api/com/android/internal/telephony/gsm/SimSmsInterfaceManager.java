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
    private Object mLock = new Object();
    private boolean mSuccess;
    private List<SmsRawData> mSms;
    private HashMap<Integer, HashSet<String>> mCellBroadcastSubscriptions =
            new HashMap<Integer, HashSet<String>>();
    private CellBroadcastRangeManager mCellBroadcastRangeManager =
            new CellBroadcastRangeManager();
    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.852 -0400", hash_original_method = "2B211BBD733007234A9B9085CE23F724", hash_generated_method = "A2B89DEFE29FA6FC11A8BD9758FDC20A")
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.853 -0400", hash_original_method = "B76CF823F0B7FB39DC6F27A63B8B6D56", hash_generated_method = "A344388B79D37EA7F6B97BFF26711181")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimSmsInterfaceManager(GSMPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(dispatcher.dsTaint);
        mDispatcher = dispatcher;
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.853 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.853 -0400", hash_original_method = "B5C7D22959BE2F7C1AB4B825F6E12647", hash_generated_method = "2C33189D3CD18A31AF8A0FB6F1FC6A1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.854 -0400", hash_original_method = "F53F9B39BB318705FAF6F47512F2ECB5", hash_generated_method = "A0E98A428A8D8571031C556D0305BB9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.854 -0400", hash_original_method = "5C5D2075C67DB185E1C8FAD979C1C6EE", hash_generated_method = "8B5D4006528D1FD1FD9EB390B4814140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        dsTaint.addTaint(smsc[0]);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.854 -0400", hash_original_method = "D4D266DBBD67105329BC4DC8BFFFFEC2", hash_generated_method = "B4F59054AA78204E5D7C6BCC2E8FB2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<SmsRawData> getAllMessagesFromIccEf() {
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
        return (List<SmsRawData>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.855 -0400", hash_original_method = "9E9858677901A40DCFB3014D7783E7CF", hash_generated_method = "3511A254D3B79E697B8BD9663CF39C97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        boolean var8C8D74A8863606631DE54B7E9069A175_1008907328 = (enableCellBroadcastRange(messageIdentifier, messageIdentifier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.855 -0400", hash_original_method = "E254B3C21063075DCFCF4B937B1FF66E", hash_generated_method = "477C33718AC3DC0879C7087D1123BA01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        boolean varCED64931F28FE138F7464163BC3E19E0_352033537 = (disableCellBroadcastRange(messageIdentifier, messageIdentifier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return disableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.855 -0400", hash_original_method = "8E661A700D601CF050E065CDC056070F", hash_generated_method = "05040CDD08E4E5B5A551982B54B2B574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
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
            boolean varFBC088AEED27062F33727167AE6F95FA_1350420928 = (!mCellBroadcastRangeManager.enableRange(startMessageId, endMessageId, client));
            {
                log("Failed to add cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } //End block
        } //End collapsed parenthetic
        log("Added cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.855 -0400", hash_original_method = "47BAD55325978FFE5C517009A7EF2AB8", hash_generated_method = "7827771404563A7FF43A583BE1A9E14A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
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
            boolean var6F1DF54DDA7D97E10487F0EAA0F27713_36160204 = (!mCellBroadcastRangeManager.disableRange(startMessageId, endMessageId, client));
            {
                log("Failed to remove cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } //End block
        } //End collapsed parenthetic
        log("Removed cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.856 -0400", hash_original_method = "13CBDA000CECA6BBED63F386B07FC011", hash_generated_method = "B8A1A1CCD99DD84C6A7319E5541B3E68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo[] configs) {
        dsTaint.addTaint(configs[0].dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.856 -0400", hash_original_method = "D2ABD2A7A42536455FF89EC95B86ABFC", hash_generated_method = "E703EA134305C001F2B9F92AE80DFAF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setCellBroadcastActivation(boolean activate) {
        dsTaint.addTaint(activate);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.856 -0400", hash_original_method = "8FFAE6152EC966DD60EE44B9C7188E3E", hash_generated_method = "8986D1D49B9FC02B297FC65F7ECA0335")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
    }

    
    class CellBroadcastRangeManager extends IntRangeManager {
        private ArrayList<SmsBroadcastConfigInfo> mConfigList =
                new ArrayList<SmsBroadcastConfigInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.856 -0400", hash_original_method = "A7FB68C3F7C46A3C9BA93C1BA7350276", hash_generated_method = "A7FB68C3F7C46A3C9BA93C1BA7350276")
                public CellBroadcastRangeManager ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.857 -0400", hash_original_method = "9715F7B64D6F5D9B1FC00DACD193B4CE", hash_generated_method = "9FFE737D65BF3BA4E83567038136FE56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void startUpdate() {
            mConfigList.clear();
            // ---------- Original Method ----------
            //mConfigList.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.857 -0400", hash_original_method = "6A2FA862D29C9C6898FE89F28FC062F6", hash_generated_method = "9923414B02311CC02610680F9E241654")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void addRange(int startId, int endId, boolean selected) {
            dsTaint.addTaint(selected);
            dsTaint.addTaint(endId);
            dsTaint.addTaint(startId);
            mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
            // ---------- Original Method ----------
            //mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        //SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.866 -0400", hash_original_method = "1E945351230B27489052E59869E2AD9A", hash_generated_method = "85CF0D1BB325BCE4AA8B50725074EB04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean finishUpdate() {
            {
                boolean varFCD646C4E99CC667B09618B1E7707A11_1071690678 = (mConfigList.isEmpty());
                {
                    SmsBroadcastConfigInfo[] configs;
                    configs = mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                    boolean var65B4DD29DFB765BB5E794AEBB8DA5BA3_614740714 = (setCellBroadcastConfig(configs));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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


    
    static final String LOG_TAG = "GSM";
    static final boolean DBG = true;
    private static final int EVENT_LOAD_DONE = 1;
    private static final int EVENT_UPDATE_DONE = 2;
    private static final int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
    private static final int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
    private static final int SMS_CB_CODE_SCHEME_MIN = 0;
    private static final int SMS_CB_CODE_SCHEME_MAX = 255;
}

