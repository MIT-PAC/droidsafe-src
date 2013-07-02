package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.436 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.436 -0400", hash_original_field = "51D04CAF6B674687BDD02BD17453D38D", hash_generated_field = "E5C2960DEEDF8FDAD07F7DFD4E59E129")

    private boolean mSuccess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.436 -0400", hash_original_field = "8226893332EC8B3D4C41881E93F86D0B", hash_generated_field = "ED139F0AF6AD2DEBB50AE480C594897C")

    private List<SmsRawData> mSms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.437 -0400", hash_original_field = "5295D397E3B8ABF68AB05F812BD7E8EE", hash_generated_field = "B84253B8FA7AB46A694B9F6B58DBB692")

    private HashMap<Integer, HashSet<String>> mCellBroadcastSubscriptions = new HashMap<Integer, HashSet<String>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.437 -0400", hash_original_field = "4DB2139541B7A82F8504421C820CB49D", hash_generated_field = "BDB100102358F9C5E6439629D9C77938")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.438 -0400", hash_original_method = "B76CF823F0B7FB39DC6F27A63B8B6D56", hash_generated_method = "108DE3522F8B92E90007B83E3548EB41")
    public  SimSmsInterfaceManager(GSMPhone phone, SMSDispatcher dispatcher) {
        super(phone);
        mDispatcher = dispatcher;
        addTaint(phone.getTaint());
        addTaint(dispatcher.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.438 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.438 -0400", hash_original_method = "B5C7D22959BE2F7C1AB4B825F6E12647", hash_generated_method = "2C33189D3CD18A31AF8A0FB6F1FC6A1D")
    @Override
    protected void finalize() {
        try 
        {
            super.finalize();
        } 
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "SimSmsInterfaceManager finalized");
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.439 -0400", hash_original_method = "F53F9B39BB318705FAF6F47512F2ECB5", hash_generated_method = "152B6C31F096096D6C2E6423AD0FF62F")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) {
        log("updateMessageOnIccEf: index=" + index +
                " status=" + status + " ==> " +
                "("+ Arrays.toString(pdu) + ")");
        enforceReceiveAndSend("Updating message on SIM");
        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            {
                mPhone.mCM.deleteSmsOnSim(index, response);
            } 
            {
                byte[] record = makeSmsRecordData(status, pdu);
                mPhone.getIccFileHandler().updateEFLinearFixed(
                        IccConstants.EF_SMS,
                        index, record, null, response);
            } 
            try 
            {
                mLock.wait();
            } 
            catch (InterruptedException e)
            {
                log("interrupted while trying to update by index");
            } 
        } 
        addTaint(index);
        addTaint(status);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322213938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322213938;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.441 -0400", hash_original_method = "5C5D2075C67DB185E1C8FAD979C1C6EE", hash_generated_method = "992F730D6B6D16E1E247FC5DC19DD4DD")
    public boolean copyMessageToIccEf(int status, byte[] pdu, byte[] smsc) {
        log("copyMessageToIccEf: status=" + status + " ==> " +
                "pdu=("+ Arrays.toString(pdu) +
                "), smsm=(" + Arrays.toString(smsc) +")");
        enforceReceiveAndSend("Copying message to SIM");
        {
            mSuccess = false;
            Message response = mHandler.obtainMessage(EVENT_UPDATE_DONE);
            mPhone.mCM.writeSmsToSim(status, IccUtils.bytesToHexString(smsc),
                    IccUtils.bytesToHexString(pdu), response);
            try 
            {
                mLock.wait();
            } 
            catch (InterruptedException e)
            {
                log("interrupted while trying to update by index");
            } 
        } 
        addTaint(status);
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626885146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626885146;
        
        
                
                
        
        
            
            
            
                    
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.443 -0400", hash_original_method = "D4D266DBBD67105329BC4DC8BFFFFEC2", hash_generated_method = "AD748EE53151136F8AB8D07346CDAEBC")
    public List<SmsRawData> getAllMessagesFromIccEf() {
        List<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_123294240 = null; 
        log("getAllMessagesFromEF");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Reading messages from SIM");
        {
            Message response = mHandler.obtainMessage(EVENT_LOAD_DONE);
            mPhone.getIccFileHandler().loadEFLinearFixedAll(IccConstants.EF_SMS, response);
            try 
            {
                mLock.wait();
            } 
            catch (InterruptedException e)
            {
                log("interrupted while trying to load from the SIM");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_123294240 = mSms;
        varB4EAC82CA7396A68D541C85D26508E83_123294240.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_123294240;
        
        
        
        
                
                
        
            
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.443 -0400", hash_original_method = "9E9858677901A40DCFB3014D7783E7CF", hash_generated_method = "CB727F8792871A04089BEA8E82CF7137")
    public boolean enableCellBroadcast(int messageIdentifier) {
        boolean var8C8D74A8863606631DE54B7E9069A175_744322832 = (enableCellBroadcastRange(messageIdentifier, messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447159460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447159460;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.444 -0400", hash_original_method = "E254B3C21063075DCFCF4B937B1FF66E", hash_generated_method = "5CB928E1D1DBCD08971268B789E7A3FB")
    public boolean disableCellBroadcast(int messageIdentifier) {
        boolean varCED64931F28FE138F7464163BC3E19E0_354355384 = (disableCellBroadcastRange(messageIdentifier, messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139564436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139564436;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.445 -0400", hash_original_method = "8E661A700D601CF050E065CDC056070F", hash_generated_method = "809957D62DBFD00283FDC226D18E2D61")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        log("enableCellBroadcastRange");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Enabling cell broadcast SMS");
        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
        {
            boolean varFBC088AEED27062F33727167AE6F95FA_737215818 = (!mCellBroadcastRangeManager.enableRange(startMessageId, endMessageId, client));
            {
                log("Failed to add cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } 
        } 
        log("Added cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678672032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678672032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.446 -0400", hash_original_method = "47BAD55325978FFE5C517009A7EF2AB8", hash_generated_method = "AA636F54AB95DE4C5F9202F90140AA6E")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        log("disableCellBroadcastRange");
        Context context = mPhone.getContext();
        context.enforceCallingPermission(
                "android.permission.RECEIVE_SMS",
                "Disabling cell broadcast SMS");
        String client = context.getPackageManager().getNameForUid(
                Binder.getCallingUid());
        {
            boolean var6F1DF54DDA7D97E10487F0EAA0F27713_249227102 = (!mCellBroadcastRangeManager.disableRange(startMessageId, endMessageId, client));
            {
                log("Failed to remove cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
            } 
        } 
        log("Removed cell broadcast subscription for MID range " + startMessageId
                    + " to " + endMessageId + " from client " + client);
        setCellBroadcastActivation(!mCellBroadcastRangeManager.isEmpty());
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931439310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931439310;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.446 -0400", hash_original_method = "13CBDA000CECA6BBED63F386B07FC011", hash_generated_method = "4DD64FBC97445F0EC15AAC7954D4385C")
    private boolean setCellBroadcastConfig(SmsBroadcastConfigInfo[] configs) {
        log("Calling setGsmBroadcastConfig with " + configs.length + " configurations");
        {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_CONFIG_DONE);
            mSuccess = false;
            mPhone.mCM.setGsmBroadcastConfig(configs, response);
            try 
            {
                mLock.wait();
            } 
            catch (InterruptedException e)
            {
                log("interrupted while trying to set cell broadcast config");
            } 
        } 
        addTaint(configs[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913792288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913792288;
        
        
            
        
            
            
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.447 -0400", hash_original_method = "D2ABD2A7A42536455FF89EC95B86ABFC", hash_generated_method = "1C1EF52FBC7F7199854A8AAA0BB959EA")
    private boolean setCellBroadcastActivation(boolean activate) {
        log("Calling setCellBroadcastActivation(" + activate + ')');
        {
            Message response = mHandler.obtainMessage(EVENT_SET_BROADCAST_ACTIVATION_DONE);
            mSuccess = false;
            mPhone.mCM.setGsmBroadcastActivation(activate, response);
            try 
            {
                mLock.wait();
            } 
            catch (InterruptedException e)
            {
                log("interrupted while trying to set cell broadcast activation");
            } 
        } 
        addTaint(activate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570742262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570742262;
        
        
            
        
            
            
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.448 -0400", hash_original_method = "8FFAE6152EC966DD60EE44B9C7188E3E", hash_generated_method = "A78A96AD63975F1872A34309071EE3EB")
    @Override
    protected void log(String msg) {
        Log.d(LOG_TAG, "[SimSmsInterfaceManager] " + msg);
        addTaint(msg.getTaint());
        
        
    }

    
    class CellBroadcastRangeManager extends IntRangeManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.448 -0400", hash_original_field = "C44116DC6796845984805B9F9E58678C", hash_generated_field = "DF520AF3FDD23D6477ECBF735C000104")

        private ArrayList<SmsBroadcastConfigInfo> mConfigList = new ArrayList<SmsBroadcastConfigInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.448 -0400", hash_original_method = "C394C8BFADF1F863BE74B5C008CAC491", hash_generated_method = "C394C8BFADF1F863BE74B5C008CAC491")
        public CellBroadcastRangeManager ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.448 -0400", hash_original_method = "9715F7B64D6F5D9B1FC00DACD193B4CE", hash_generated_method = "9FFE737D65BF3BA4E83567038136FE56")
        protected void startUpdate() {
            mConfigList.clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.449 -0400", hash_original_method = "6A2FA862D29C9C6898FE89F28FC062F6", hash_generated_method = "07F902704F05DA41D4E44FBE2E8A25C4")
        protected void addRange(int startId, int endId, boolean selected) {
            mConfigList.add(new SmsBroadcastConfigInfo(startId, endId,
                        SMS_CB_CODE_SCHEME_MIN, SMS_CB_CODE_SCHEME_MAX, selected));
            addTaint(startId);
            addTaint(endId);
            addTaint(selected);
            
            
                        
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.449 -0400", hash_original_method = "1E945351230B27489052E59869E2AD9A", hash_generated_method = "CB9B2D411D004D3776E36D3D279781A6")
        protected boolean finishUpdate() {
            {
                boolean varFCD646C4E99CC667B09618B1E7707A11_1589606998 = (mConfigList.isEmpty());
                {
                    SmsBroadcastConfigInfo[] configs = mConfigList.toArray(new SmsBroadcastConfigInfo[mConfigList.size()]);
                    boolean var65B4DD29DFB765BB5E794AEBB8DA5BA3_730250284 = (setCellBroadcastConfig(configs));
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874305343 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874305343;
            
            
                
            
                
                        
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "B0BA389891763CE058F1838506410614", hash_generated_field = "77BC6FD0DC199252047A7F7B64B6060D")

    private static final int EVENT_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "FA5C825AD4E8BE0B56282EA4E98C2D84", hash_generated_field = "15C9033C6CF121B938E3ED8FAF5BE197")

    private static final int EVENT_UPDATE_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "B60BA1295CCFC2B789AA51D8AA66C386", hash_generated_field = "BD6D4D21A28A2356F9E1C02134365F6C")

    private static final int EVENT_SET_BROADCAST_ACTIVATION_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "C61701770F019E446DE5BBFF7502996B", hash_generated_field = "AD21793B4EF8173C5031398FC452928B")

    private static final int EVENT_SET_BROADCAST_CONFIG_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "3FCCB6C601A0DC41EA1AD349CB9AE7FB", hash_generated_field = "F1286DF59C8C824170BC9070DB37FD65")

    private static final int SMS_CB_CODE_SCHEME_MIN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.450 -0400", hash_original_field = "3CA7A777CBDF7832989FADE4932F143B", hash_generated_field = "DDAC7097350FA73BA388F57E43349186")

    private static final int SMS_CB_CODE_SCHEME_MAX = 255;
}

