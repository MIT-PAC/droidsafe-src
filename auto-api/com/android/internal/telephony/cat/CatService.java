package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemProperties;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import java.io.ByteArrayOutputStream;
import java.util.Locale;

class RilMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.268 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.268 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

    Object mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.268 -0400", hash_original_field = "495A3609A7B3EA4302F80964552183B3", hash_generated_field = "70A90D72FABA26F58FDAF243629DCAD1")

    ResultCode mResCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_method = "3402C3F9EF39C06F449D290965539671", hash_generated_method = "BD9C65CEF2D7E685C85E0E957CB6EFA1")
      RilMessage(int msgId, String rawData) {
        mId = msgId;
        mData = rawData;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_method = "56F4F1F4536DAFEF01840B516ADA4963", hash_generated_method = "08086F10920F4C141BD1F6F3CA310AB9")
      RilMessage(RilMessage other) {
        this.mId = other.mId;
        this.mData = other.mData;
        this.mResCode = other.mResCode;
        
        
        
        
    }

    
}

public class CatService extends Handler implements AppInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_field = "23B72E777143CC3CCEAE49FBF3EE4284", hash_generated_field = "6EBA8BBFB850EB64C843C5863723C1B3")

    private CommandsInterface mCmdIf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_field = "441F209D9D26EF943C917521D0FF792D", hash_generated_field = "538FD5CEC06AC573B443D69E91473326")

    private CatCmdMessage mCurrntCmd = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_field = "27FB0EEF2322D37BD6B5090D234E757E", hash_generated_field = "8ABF519EF89F0346AABDA35943975CF1")

    private CatCmdMessage mMenuCmd = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.271 -0400", hash_original_field = "199A000F22D09E68AC16BA7A675CE86D", hash_generated_field = "5581F8294B4A44B480C12D4CDCF45252")

    private RilMessageDecoder mMsgDecoder = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.272 -0400", hash_original_method = "0B6E46ACD511396208B0FB6CDAFB964A", hash_generated_method = "B0FBEEF141C71BBA79BCF8876ADADE5B")
    private  CatService(CommandsInterface ci, IccRecords ir, Context context,
            IccFileHandler fh, IccCard ic) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "Service: Input parameters must not be null");
        } 
        mCmdIf = ci;
        mContext = context;
        mMsgDecoder = RilMessageDecoder.getInstance(this, fh);
        mCmdIf.setOnCatSessionEnd(this, MSG_ID_SESSION_END, null);
        mCmdIf.setOnCatProactiveCmd(this, MSG_ID_PROACTIVE_COMMAND, null);
        mCmdIf.setOnCatEvent(this, MSG_ID_EVENT_NOTIFY, null);
        mCmdIf.setOnCatCallSetUp(this, MSG_ID_CALL_SETUP, null);
        mIccRecords = ir;
        mCmdIf.registerForSIMReady(this, MSG_ID_SIM_READY, null);
        mCmdIf.registerForRUIMReady(this, MSG_ID_SIM_READY, null);
        mCmdIf.registerForNVReady(this, MSG_ID_SIM_READY, null);
        mIccRecords.registerForRecordsLoaded(this, MSG_ID_ICC_RECORDS_LOADED, null);
        CatLog.d(this, "Is running");
        addTaint(ir.getTaint());
        addTaint(ic.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.273 -0400", hash_original_method = "D708104FB5CF5762DDEBFF2BAD6B6B04", hash_generated_method = "E3620C337A6B286ABC08B087041B971D")
    public void dispose() {
        mIccRecords.unregisterForRecordsLoaded(this);
        mCmdIf.unSetOnCatSessionEnd(this);
        mCmdIf.unSetOnCatProactiveCmd(this);
        mCmdIf.unSetOnCatEvent(this);
        mCmdIf.unSetOnCatCallSetUp(this);
        this.removeCallbacksAndMessages(null);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.273 -0400", hash_original_method = "0386F7586104C91B22CE4150238AFD39", hash_generated_method = "963AC07ED7DE6AEA46B3068BB242386B")
    protected void finalize() {
        CatLog.d(this, "Service finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.274 -0400", hash_original_method = "E9D273BBD1B8139BCAB5560E10ADE1AE", hash_generated_method = "FD3E36EEA0A047F4D9103D9D2BBA1346")
    private void handleRilMsg(RilMessage rilMsg) {
        CommandParams cmdParams = null;
        
        {
            cmdParams = (CommandParams) rilMsg.mData;
            {
                handleProactiveCommand(cmdParams);
            } 
        } 
        
        
        try 
        {
            cmdParams = (CommandParams) rilMsg.mData;
        } 
        catch (ClassCastException e)
        {
            CatLog.d(this, "Fail to parse proactive command");
            sendTerminalResponse(mCurrntCmd.mCmdDet, ResultCode.CMD_DATA_NOT_UNDERSTOOD,
                                     false, 0x00, null);
        } 
        
        
        {
            {
                handleProactiveCommand(cmdParams);
            } 
            {
                sendTerminalResponse(cmdParams.cmdDet, rilMsg.mResCode,
                            false, 0, null);
            } 
        } 
        
        
        cmdParams = (CommandParams) rilMsg.mData;
        
        
        {
            handleProactiveCommand(cmdParams);
        } 
        
        
        handleSessionEnd();
        
        addTaint(rilMsg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.276 -0400", hash_original_method = "962D88968BE7A135485D50B41AC85213", hash_generated_method = "54705E41902E73D63A344D11B7B37170")
    private void handleProactiveCommand(CommandParams cmdParams) {
        CatLog.d(this, cmdParams.getCommandType().name());
        CharSequence message;
        CatCmdMessage cmdMsg = new CatCmdMessage(cmdParams);
        {
            Object varA74AB301753C81C1EF1463B16F741D65_318306998 = (cmdParams.getCommandType());
            
            {
                boolean varBDB939CADF418BD3B149DA2D195D52CC_1375826763 = (removeMenu(cmdMsg.getMenu()));
                {
                    mMenuCmd = null;
                } 
                {
                    mMenuCmd = cmdMsg;
                } 
            } 
            
            
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            
            
            {
                boolean var85EC808BECD69A26D4BEA7B0ABCBD691_543188176 = (!cmdMsg.geTextMessage().responseNeeded);
                {
                    sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                } 
            } 
            
            
            cmdParams.cmdDet.typeOfCommand = CommandType.SET_UP_IDLE_MODE_TEXT.value();
            
            
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            
            
            ResponseData resp;
            
            
            
            resp = new DTTZResponseData(null);
            
            
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
            
            
            resp = new LanguageResponseData(Locale.getDefault().getLanguage());
            
            
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
            
            
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            
            
            
            {
                boolean var289612E192C87C1C213531B7648CE2E4_888102221 = ((((LaunchBrowserParams) cmdParams).confirmMsg.text != null)
                        && (((LaunchBrowserParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.launchBrowserDefault);
                    ((LaunchBrowserParams) cmdParams).confirmMsg.text = message.toString();
                } 
            } 
            
            
            {
                boolean varF0C118B2E2B35C6F3762B0AE0908E95F_1481003793 = ((((DisplayTextParams)cmdParams).textMsg.text != null)
                        && (((DisplayTextParams)cmdParams).textMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.sending);
                    ((DisplayTextParams)cmdParams).textMsg.text = message.toString();
                } 
            } 
            
            
            {
                boolean var748082CB986285C53A80D0C3B5EED825_261200934 = ((((CallSetupParams) cmdParams).confirmMsg.text != null)
                        && (((CallSetupParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.SetupCallDefault);
                    ((CallSetupParams) cmdParams).confirmMsg.text = message.toString();
                } 
            } 
            
            
            CatLog.d(this, "Unsupported command");
            
        } 
        mCurrntCmd = cmdMsg;
        Intent intent = new Intent(AppInterface.CAT_CMD_ACTION);
        intent.putExtra("STK CMD", cmdMsg);
        mContext.sendBroadcast(intent);
        addTaint(cmdParams.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.276 -0400", hash_original_method = "F4FE7D680FC27736DB53FE02767C67C5", hash_generated_method = "AC347CF6457FB719998C7B2BD8B79CD1")
    private void handleSessionEnd() {
        CatLog.d(this, "SESSION END");
        mCurrntCmd = mMenuCmd;
        Intent intent = new Intent(AppInterface.CAT_SESSION_END_ACTION);
        mContext.sendBroadcast(intent);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.277 -0400", hash_original_method = "1946CA6BE8E37F5C447374ACD2229E75", hash_generated_method = "F5B0DA97139DD642CB080CA797F42E50")
    private void sendTerminalResponse(CommandDetails cmdDet,
            ResultCode resultCode, boolean includeAdditionalInfo,
            int additionalInfo, ResponseData resp) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        Input cmdInput = null;
        {
            cmdInput = mCurrntCmd.geInput();
        } 
        int tag = ComprehensionTlvTag.COMMAND_DETAILS.value();
        {
            tag |= 0x80;
        } 
        buf.write(tag);
        buf.write(0x03);
        buf.write(cmdDet.commandNumber);
        buf.write(cmdDet.typeOfCommand);
        buf.write(cmdDet.commandQualifier);
        tag = ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(DEV_ID_TERMINAL);
        buf.write(DEV_ID_UICC);
        tag = 0x80 | ComprehensionTlvTag.RESULT.value();
        buf.write(tag);
        int length;
        length = 2;
        length = 1;
        buf.write(length);
        buf.write(resultCode.value());
        {
            buf.write(additionalInfo);
        } 
        {
            resp.format(buf);
        } 
        {
            encodeOptionalTags(cmdDet, resultCode, cmdInput, buf);
        } 
        byte[] rawData = buf.toByteArray();
        String hexString = IccUtils.bytesToHexString(rawData);
        {
            CatLog.d(this, "TERMINAL RESPONSE: " + hexString);
        } 
        mCmdIf.sendTerminalResponse(hexString, null);
        addTaint(cmdDet.getTaint());
        addTaint(resultCode.getTaint());
        addTaint(includeAdditionalInfo);
        addTaint(additionalInfo);
        addTaint(resp.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.278 -0400", hash_original_method = "638B326A6DB369CFE44B9E340F9EEB09", hash_generated_method = "921354C394EA3EE9B8BE082B2D72DE26")
    private void encodeOptionalTags(CommandDetails cmdDet,
            ResultCode resultCode, Input cmdInput, ByteArrayOutputStream buf) {
        CommandType cmdType = AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        {
            
            {
                boolean var082860D7E23D30F4E1F73375F5BB4E0C_1329611127 = ((resultCode.value() == ResultCode.NO_RESPONSE_FROM_USER.value()) &&
                        (cmdInput != null) && (cmdInput.duration != null));
                {
                    getInKeyResponse(buf, cmdInput);
                } 
            } 
            
            
            {
                boolean varE61954B8FB8D644763D155CCE3759480_1976036012 = ((cmdDet.commandQualifier == CommandParamsFactory.LANGUAGE_SETTING) &&
                        (resultCode.value() == ResultCode.OK.value()));
                {
                    getPliResponse(buf);
                } 
            } 
            
            
            CatLog.d(this, "encodeOptionalTags() Unsupported Cmd:" + cmdDet.typeOfCommand);
            
        } 
        {
            CatLog.d(this, "encodeOptionalTags() bad Cmd:" + cmdDet.typeOfCommand);
        } 
        addTaint(cmdDet.getTaint());
        addTaint(resultCode.getTaint());
        addTaint(cmdInput.getTaint());
        addTaint(buf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.279 -0400", hash_original_method = "0852EED8EE8FA95FED775B0B05726071", hash_generated_method = "E17F9058B3F80048A482D8C016190B6F")
    private void getInKeyResponse(ByteArrayOutputStream buf, Input cmdInput) {
        int tag = ComprehensionTlvTag.DURATION.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(cmdInput.duration.timeUnit.SECOND.value());
        buf.write(cmdInput.duration.timeInterval);
        addTaint(buf.getTaint());
        addTaint(cmdInput.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.279 -0400", hash_original_method = "9C18CC5EFDD0B345CA3B94FA3BA225B1", hash_generated_method = "FA849EAA445C3A957BD90BFA4F6F78A9")
    private void getPliResponse(ByteArrayOutputStream buf) {
        String lang = SystemProperties.get("persist.sys.language");
        {
            int tag = ComprehensionTlvTag.LANGUAGE.value();
            buf.write(tag);
            ResponseData.writeLength(buf, lang.length());
            buf.write(lang.getBytes(), 0, lang.length());
        } 
        addTaint(buf.getTaint());
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.280 -0400", hash_original_method = "8584D48A0DB0867CC39B0E747FD77F24", hash_generated_method = "0BBC625250CD7BBE2E43B42A9E5751C4")
    private void sendMenuSelection(int menuId, boolean helpRequired) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int tag = BerTlv.BER_MENU_SELECTION_TAG;
        buf.write(tag);
        buf.write(0x00);
        tag = 0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(DEV_ID_KEYPAD);
        buf.write(DEV_ID_UICC);
        tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        buf.write(tag);
        buf.write(0x01);
        buf.write(menuId);
        {
            tag = ComprehensionTlvTag.HELP_REQUEST.value();
            buf.write(tag);
            buf.write(0x00);
        } 
        byte[] rawData = buf.toByteArray();
        int len = rawData.length - 2;
        rawData[1] = (byte) len;
        String hexString = IccUtils.bytesToHexString(rawData);
        mCmdIf.sendEnvelope(hexString, null);
        addTaint(menuId);
        addTaint(helpRequired);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.291 -0400", hash_original_method = "BB297ADB158EDB6C7A0522557FDE81DF", hash_generated_method = "F8096443539AC2FFFF13AB83CCA803D0")
    private void eventDownload(int event, int sourceId, int destinationId,
            byte[] additionalInfo, boolean oneShot) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int tag = BerTlv.BER_EVENT_DOWNLOAD_TAG;
        buf.write(tag);
        buf.write(0x00);
        tag = 0x80 | ComprehensionTlvTag.EVENT_LIST.value();
        buf.write(tag);
        buf.write(0x01);
        buf.write(event);
        tag = 0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(sourceId);
        buf.write(destinationId);
        {
            {
                byte b = additionalInfo[0];
                {
                    buf.write(b);
                } 
            } 
        } 
        byte[] rawData = buf.toByteArray();
        int len = rawData.length - 2;
        rawData[1] = (byte) len;
        String hexString = IccUtils.bytesToHexString(rawData);
        mCmdIf.sendEnvelope(hexString, null);
        addTaint(event);
        addTaint(sourceId);
        addTaint(destinationId);
        addTaint(additionalInfo[0]);
        addTaint(oneShot);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
                
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static CatService getInstance(CommandsInterface ci, IccRecords ir,
            Context context, IccFileHandler fh, IccCard ic) {
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                if (ci == null || ir == null || context == null || fh == null
                        || ic == null) {
                    return null;
                }
                HandlerThread thread = new HandlerThread("Cat Telephony service");
                thread.start();
                sInstance = new CatService(ci, ir, context, fh, ic);
                CatLog.d(sInstance, "NEW sInstance");
            } else if ((ir != null) && (mIccRecords != ir)) {
                CatLog.d(sInstance, "Reinitialize the Service with SIMRecords");
                mIccRecords = ir;
                mIccRecords.registerForRecordsLoaded(sInstance, MSG_ID_ICC_RECORDS_LOADED, null);
                CatLog.d(sInstance, "sr changed reinitialize and return current sInstance");
            } else {
                CatLog.d(sInstance, "Return current sInstance");
            }
            return sInstance;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static AppInterface getInstance() {
        return getInstance(null, null, null, null, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.292 -0400", hash_original_method = "08AB5E16EBCD81DA8811894A2C2969C7", hash_generated_method = "FB98718894B21CB262CC669B09886C42")
    @Override
    public void handleMessage(Message msg) {
        
        CatLog.d(this, "ril message arrived");
        
        
        String data = null;
        
        
        {
            AsyncResult ar = (AsyncResult) msg.obj;
            {
                try 
                {
                    data = (String) ar.result;
                } 
                catch (ClassCastException e)
                { }
            } 
        } 
        
        
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, data));
        
        
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, null));
        
        
        handleRilMsg((RilMessage) msg.obj);
        
        
        handleCmdResponse((CatResponseMessage) msg.obj);
        
        
        CatLog.d(this, "SIM ready. Reporting STK service running now...");
        
        
        mCmdIf.reportStkServiceIsRunning(null);
        
        
        if (DroidSafeAndroidRuntime.control) throw new AssertionError("Unrecognized CAT command: " + msg.what);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.292 -0400", hash_original_method = "8251947338311BFA45C2A2344891C68B", hash_generated_method = "2E5E6C1647EE59E72FF17D301BC930E2")
    public synchronized void onCmdResponse(CatResponseMessage resMsg) {
        
        Message msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        msg.sendToTarget();
        addTaint(resMsg.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.293 -0400", hash_original_method = "B0A9A02E0F2D96AF829ED175E58D2181", hash_generated_method = "50B18637A79142542911C3007DF34ECB")
    private boolean validateResponse(CatResponseMessage resMsg) {
        {
            boolean var36410395CD93C1DC7B6B62D97443551F_759765236 = ((resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet)));
        } 
        addTaint(resMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228464668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_228464668;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.293 -0400", hash_original_method = "FED22D423ED234057B6FD28452B9EEF5", hash_generated_method = "7FE2C3F34629B55A0704E807AF5CEEDE")
    private boolean removeMenu(Menu menu) {
        try 
        {
            {
                boolean var7A3FCD0C746293761DF6222920A6CC9F_839137984 = (menu.items.size() == 1 && menu.items.get(0) == null);
            } 
        } 
        catch (NullPointerException e)
        {
            CatLog.d(this, "Unable to get Menu's items size");
        } 
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442402042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442402042;
        
        
            
                
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_method = "48D7C107F944AA3B8D2770DC9FDB0ED7", hash_generated_method = "7D670000A3D57A009E2616B240E857CC")
    private void handleCmdResponse(CatResponseMessage resMsg) {
        {
            boolean varD22E38D970B07736EEDB0B746B6EF7EE_142529979 = (!validateResponse(resMsg));
        } 
        ResponseData resp = null;
        boolean helpRequired = false;
        CommandDetails cmdDet = resMsg.getCmdDetails();
        
        helpRequired = true;
        
        
        {
            Object var5A134572D68F084201EB42583661BD51_1426667924 = (AppInterface.CommandType.fromInt(cmdDet.typeOfCommand));
            
            helpRequired = resMsg.resCode == ResultCode.HELP_INFO_REQUIRED;
            
            
            sendMenuSelection(resMsg.usersMenuSelection, helpRequired);
            
            
            resp = new SelectItemResponseData(resMsg.usersMenuSelection);
            
            
            Input input = mCurrntCmd.geInput();
            
            
            {
                {
                    resp = new GetInkeyInputResponseData(resMsg.usersInput,
                                input.ucs2, input.packed);
                } 
            } 
            {
                resp = new GetInkeyInputResponseData(
                            resMsg.usersYesNoSelection);
            } 
            
            
            mCmdIf.handleCallSetupRequestFromSim(resMsg.usersConfirm, null);
            
            
            mCurrntCmd = null;
            
        } 
        
        
        resp = null;
        
        sendTerminalResponse(cmdDet, resMsg.resCode, false, 0, resp);
        mCurrntCmd = null;
        addTaint(resMsg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "C90E66D30105E64A69B0470347184F2E", hash_generated_field = "300A42BBD72D4F998C99A9B62F7A3C8A")

    private static IccRecords mIccRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "4B76103D546737D807190C72D978B677", hash_generated_field = "6700DAA39837D495AC0A90152C6A1E3F")

    private static final Object sInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E81D7F90EE651933B622FBF4BA337EDF")

    private static CatService sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "632F42CE616303BD224EFBB09EFA0D0F", hash_generated_field = "B933D4066C198A221B804D3C0355458A")

    static final int MSG_ID_SESSION_END = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "63C317BE2F8A9BDC47E64B4228CD6BB1", hash_generated_field = "3827004747A9C5230CD854B9D0239900")

    static final int MSG_ID_PROACTIVE_COMMAND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "E1F0605CD0B3C65B7E157FDCE4C1D4CD", hash_generated_field = "AD79C01C2910E137E618F48FA3A6407F")

    static final int MSG_ID_EVENT_NOTIFY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "CF5AD531AA56E8490EABB5F585A334BB", hash_generated_field = "726D73D04043A09992A46D2C115FBCA2")

    static final int MSG_ID_CALL_SETUP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "022752B8BB4C9107B8AA4354A9E7BA54", hash_generated_field = "A1BAA908FCC8CBA8100D820436F0EBFA")

    static final int MSG_ID_REFRESH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "589746988AD566E9B5F240DA87D7280C", hash_generated_field = "83DF57D7872F7FB69C027533FA525EA0")

    static final int MSG_ID_RESPONSE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "204656EABDF49E09856D83F756D5283D", hash_generated_field = "5407D0B76A9936CBEB54A84AB91CB3A4")

    static final int MSG_ID_SIM_READY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "1B99032C2DAAA65BB78AC11047093A7E", hash_generated_field = "1D8CED9AB3530F764CD1A10878740D1E")

    static final int MSG_ID_RIL_MSG_DECODED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "69616CB904166640B230A8A3E9BD29DF", hash_generated_field = "24237C7CDD07AE1193E4425BC5293C07")

    private static final int MSG_ID_ICC_RECORDS_LOADED = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "E606BB6536C2CD2AA1B51B2CFA643356", hash_generated_field = "FAAA5F069799BFDB7A4455FCFA51B1D0")

    private static final int DEV_ID_KEYPAD = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "9EB4C6827FE3DF8941B8D5CCF7322AC5", hash_generated_field = "FEDDF3242ED03B4066CCB4E86D6CA64E")

    private static final int DEV_ID_DISPLAY = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.294 -0400", hash_original_field = "572785F752EC0639F06FFE1B1DB6CA7B", hash_generated_field = "D49A5F3B2264885575E8D0522FB38D52")

    private static final int DEV_ID_EARPIECE = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.295 -0400", hash_original_field = "FF522F9795F08E1F1130B741C23CB557", hash_generated_field = "B0B4E321690DD56DB0A3650FB64A8E74")

    private static final int DEV_ID_UICC = 0x81;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.295 -0400", hash_original_field = "F486BFEB3DC7F8DB6A09590ECF2B6283", hash_generated_field = "A961A85BE123718E6F104B44BB4331DD")

    private static final int DEV_ID_TERMINAL = 0x82;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.295 -0400", hash_original_field = "A2BFA57161B3AFF490465A9D4249A75C", hash_generated_field = "A4537B62A3FF2B04B6AE0CFC11651C24")

    private static final int DEV_ID_NETWORK = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.295 -0400", hash_original_field = "CCC9CF7056AE506ABEF0CA54C93931BF", hash_generated_field = "F948D801B519250F532E826B09C5CF11")

    static final String STK_DEFAULT = "Defualt Message";
}

