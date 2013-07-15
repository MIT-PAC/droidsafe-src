package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.623 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.623 -0400", hash_original_field = "51D04CAF6B674687BDD02BD17453D38D", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.623 -0400", hash_original_field = "8226893332EC8B3D4C41881E93F86D0B", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.623 -0400", hash_original_field = "5295D397E3B8ABF68AB05F812BD7E8EE", hash_generated_field = "B84253B8FA7AB46A694B9F6B58DBB692")

    private HashMap<Integer, HashSet<String>> mCellBroadcastSubscriptions = new HashMap<Integer, HashSet<String>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.623 -0400", hash_original_field = "4DB2139541B7A82F8504421C820CB49D", hash_generated_field = "BDB100102358F9C5E6439629D9C77938")

    private CellBroadcastRangeManager mCellBroadcastRangeManager = new CellBroadcastRangeManager();
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.624 -0400", hash_original_method = "B76CF823F0B7FB39DC6F27A63B8B6D56", hash_generated_method = "17C6E43AAF66BCAF5B545A29D4E5AC79")
    public  SimSmsInterfaceManager(GSMPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        addTaint(dispatcher.getTaint());
        addTaint(phone.getTaint());
        mDispatcher = dispatcher;
        // ---------- Original Method ----------
        //mDispatcher = dispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.624 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.624 -0400", hash_original_method = "B5C7D22959BE2F7C1AB4B825F6E12647", hash_generated_method = "C9F24AD0A70ABCF81AADDCD781C3E9F0")
    @Override
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        {
        } //End block
    if(DBG)        
        Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.625 -0400", hash_original_method = "F53F9B39BB318705FAF6F47512F2ECB5", hash_generated_method = "69A8D9D907BDE89E3C45375D35FA9519")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        addTaint(pdu[0]);
        addTaint(status);
        addTaint(index);
    if(DBG)        
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Updating message on SIM");
        synchronized
(mLock)        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
    if(status == STATUS_ON_ICC_FREE)            
            {
                mPhone.mCM.deleteSmsOnSim(index, response);
            } //End block
            else
            {
                byte[] record = makeSmsRecordData(status, pdu);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_62457624 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512093757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512093757;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.625 -0400", hash_original_method = "5C5D2075C67DB185E1C8FAD979C1C6EE", hash_generated_method = "061C665D24F1572807CABAD3C91CE566")
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        addTaint(smsc[0]);
        addTaint(pdu[0]);
        addTaint(status);
    if(DBG)        
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) +
                "), smsm=(" + Arrays.toString(smsc) +")");
        enforceReceiveAndSend("Copying message to SIM");
        synchronized
(mLock)        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_1145917640 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315661155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315661155;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.626 -0400", hash_original_method = "D4D266DBBD67105329BC4DC8BFFFFEC2", hash_generated_method = "BAB966CC5C20D43C6DF68AE0A3DB643A")
    public List<SmsRawData> getAllMessagesFromIccEf() {
    if(DBG)        
        log("getAllMessagesFromEF");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from SIM");
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
                log("interrupted while trying to load from the SIM");
            } //End block
        } //End block
List<SmsRawData> var7BF1E9CBCC2022F70728CF07D46D244B_1861802318 =         mSms;
        var7BF1E9CBCC2022F70728CF07D46D244B_1861802318.addTaint(taint);
        return var7BF1E9CBCC2022F70728CF07D46D244B_1861802318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.626 -0400", hash_original_method = "9E9858677901A40DCFB3014D7783E7CF", hash_generated_method = "8A479F3B035DAB750AF6FAB1A80A4EA0")
    public boolean enableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean varB663BD362DA24B90405F73C93B1CBFE0_748079414 = (enableCellBroadcastRange(messageIdentifier, messageIdentifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654884922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_654884922;
        // ---------- Original Method ----------
        //return enableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.627 -0400", hash_original_method = "E254B3C21063075DCFCF4B937B1FF66E", hash_generated_method = "A2D20E10F1A6B3E63B79E7F9E59D3B9D")
    public boolean disableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean var0B64F7335613749B5A30C4F567F9D4B5_127700556 = (disableCellBroadcastRange(messageIdentifier, messageIdentifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1742484280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1742484280;
        // ---------- Original Method ----------
        //return disableCellBroadcastRange(messageIdentifier, messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.627 -0400", hash_original_method = "8E661A700D601CF050E065CDC056070F", hash_generated_method = "37A518B3B001E7C5402B34469F6C6F59")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
    if(DBG)        
        log("enableCellBroadcastRange");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Enabling cell broadcast SMS");
        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
    if(!mCellBroadcastRangeManager.enableRange(startMessageId, endMessageId, client))        
        {
            log("Failed to add cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            boolean var68934A3E9455FA72420237EB05902327_408173285 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115199153 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_115199153;
        } //End block
    if(DBG)        
        log("Added cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        boolean varB326B5062B2F0E69046810717534CB09_667270329 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058627806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058627806;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.628 -0400", hash_original_method = "47BAD55325978FFE5C517009A7EF2AB8", hash_generated_method = "D25ABF5904DBF586EA7E87BC54810772")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
    if(DBG)        
        log("disableCellBroadcastRange");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Disabling cell broadcast SMS");
        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
    if(!mCellBroadcastRangeManager.disableRange(startMessageId, endMessageId, client))        
        {
            log("Failed to remove cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            boolean var68934A3E9455FA72420237EB05902327_158383548 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438819719 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_438819719;
        } //End block
    if(DBG)        
        log("Removed cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        boolean varB326B5062B2F0E69046810717534CB09_1826440681 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44202689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44202689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.628 -0400", hash_original_method = "13CBDA000CECA6BBED63F386B07FC011", hash_generated_method = "178AA7CDFA4DC3DF3F7FA6C2C611002A")
    private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo[] configs) {
        addTaint(configs[0].getTaint());
    if(DBG)        
        log("Calling setGsmBroadcastConfig with " + configs.length + " configurations");
        synchronized
(mLock)        {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_CONFIG_DONE);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_117208993 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949525346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949525346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.629 -0400", hash_original_method = "D2ABD2A7A42536455FF89EC95B86ABFC", hash_generated_method = "52549239E84FF3C1DAC6589654D6BFC2")
    private boolean setCellBroadcastActivation(boolean activate) {
        addTaint(activate);
    if(DBG)        
        log("Calling setCellBroadcastActivation(" + activate + ')');
        synchronized
(mLock)        {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_ACTIVATION_DONE);
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
        boolean var51D04CAF6B674687BDD02BD17453D38D_2109536868 = (mSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030304391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030304391;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.629 -0400", hash_original_method = "8FFAE6152EC966DD60EE44B9C7188E3E", hash_generated_method = "3C99C88808DCC7BFD39CFA22728C03EE")
    @Override
    protected void log(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
    }

    
    class CellBroadcastRangeManager extends IntRangeManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.629 -0400", hash_original_field = "C44116DC6796845984805B9F9E58678C", hash_generated_field = "DF520AF3FDD23D6477ECBF735C000104")

        private ArrayList<SmsBroadcastConfigInfo> mConfigList = new ArrayList<SmsBroadcastConfigInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.629 -0400", hash_original_method = "C394C8BFADF1F863BE74B5C008CAC491", hash_generated_method = "C394C8BFADF1F863BE74B5C008CAC491")
        public CellBroadcastRangeManager ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.630 -0400", hash_original_method = "9715F7B64D6F5D9B1FC00DACD193B4CE", hash_generated_method = "9FFE737D65BF3BA4E83567038136FE56")
        protected void startUpdate() {
            mConfigList.clear();
            // ---------- Original Method ----------
            //mConfigList.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.630 -0400", hash_original_method = "6A2FA862D29C9C6898FE89F28FC062F6", hash_generated_method = "FCE21ACC10B4841B0929C63597A3A8B0")
        protected void addRange(int startId, int endId, boolean selected) {
            addTaint(selected);
            addTaint(endId);
            addTaint(startId);
            mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
            // ---------- Original Method ----------
            //mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        //SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.630 -0400", hash_original_method = "1E945351230B27489052E59869E2AD9A", hash_generated_method = "BB8E1E8F2DD9592299C143A043D87537")
        protected boolean finishUpdate() {
    if(mConfigList.isEmpty())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1429886105 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778099744 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778099744;
            } //End block
            else
            {
                SmsBroadcastConfigInfo[] configs = mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                boolean varD9AB8FFD46481F76D7D67117F9EC3B04_11979929 = (setCellBroadcastConfig(configs));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394980359 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394980359;
            } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.630 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.630 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "B0BA389891763CE058F1838506410614", hash_generated_field = "77BC6FD0DC199252047A7F7B64B6060D")

    private static final int EVENT_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "FA5C825AD4E8BE0B56282EA4E98C2D84", hash_generated_field = "15C9033C6CF121B938E3ED8FAF5BE197")

    private static final int EVENT_UPDATE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "B60BA1295CCFC2B789AA51D8AA66C386", hash_generated_field = "BD6D4D21A28A2356F9E1C02134365F6C")

    private static final int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "C61701770F019E446DE5BBFF7502996B", hash_generated_field = "AD21793B4EF8173C5031398FC452928B")

    private static final int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "3FCCB6C601A0DC41EA1AD349CB9AE7FB", hash_generated_field = "F1286DF59C8C824170BC9070DB37FD65")

    private static final int SMS_CB_CODE_SCHEME_MIN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.631 -0400", hash_original_field = "3CA7A777CBDF7832989FADE4932F143B", hash_generated_field = "DDAC7097350FA73BA388F57E43349186")

    private static final int SMS_CB_CODE_SCHEME_MAX = 255;
}

