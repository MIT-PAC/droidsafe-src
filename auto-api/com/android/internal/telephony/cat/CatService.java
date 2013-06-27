package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.817 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.817 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

    Object mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.817 -0400", hash_original_field = "495A3609A7B3EA4302F80964552183B3", hash_generated_field = "70A90D72FABA26F58FDAF243629DCAD1")

    ResultCode mResCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_method = "3402C3F9EF39C06F449D290965539671", hash_generated_method = "BD9C65CEF2D7E685C85E0E957CB6EFA1")
      RilMessage(int msgId, String rawData) {
        mId = msgId;
        mData = rawData;
        // ---------- Original Method ----------
        //mId = msgId;
        //mData = rawData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_method = "56F4F1F4536DAFEF01840B516ADA4963", hash_generated_method = "08086F10920F4C141BD1F6F3CA310AB9")
      RilMessage(RilMessage other) {
        this.mId = other.mId;
        this.mData = other.mData;
        this.mResCode = other.mResCode;
        // ---------- Original Method ----------
        //this.mId = other.mId;
        //this.mData = other.mData;
        //this.mResCode = other.mResCode;
    }

    
}

public class CatService extends Handler implements AppInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_field = "23B72E777143CC3CCEAE49FBF3EE4284", hash_generated_field = "6EBA8BBFB850EB64C843C5863723C1B3")

    private CommandsInterface mCmdIf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_field = "441F209D9D26EF943C917521D0FF792D", hash_generated_field = "538FD5CEC06AC573B443D69E91473326")

    private CatCmdMessage mCurrntCmd = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_field = "27FB0EEF2322D37BD6B5090D234E757E", hash_generated_field = "8ABF519EF89F0346AABDA35943975CF1")

    private CatCmdMessage mMenuCmd = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.818 -0400", hash_original_field = "199A000F22D09E68AC16BA7A675CE86D", hash_generated_field = "5581F8294B4A44B480C12D4CDCF45252")

    private RilMessageDecoder mMsgDecoder = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.819 -0400", hash_original_method = "0B6E46ACD511396208B0FB6CDAFB964A", hash_generated_method = "B0FBEEF141C71BBA79BCF8876ADADE5B")
    private  CatService(CommandsInterface ci, IccRecords ir, Context context,
            IccFileHandler fh, IccCard ic) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "Service: Input parameters must not be null");
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.819 -0400", hash_original_method = "D708104FB5CF5762DDEBFF2BAD6B6B04", hash_generated_method = "E3620C337A6B286ABC08B087041B971D")
    public void dispose() {
        mIccRecords.unregisterForRecordsLoaded(this);
        mCmdIf.unSetOnCatSessionEnd(this);
        mCmdIf.unSetOnCatProactiveCmd(this);
        mCmdIf.unSetOnCatEvent(this);
        mCmdIf.unSetOnCatCallSetUp(this);
        this.removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //mIccRecords.unregisterForRecordsLoaded(this);
        //mCmdIf.unSetOnCatSessionEnd(this);
        //mCmdIf.unSetOnCatProactiveCmd(this);
        //mCmdIf.unSetOnCatEvent(this);
        //mCmdIf.unSetOnCatCallSetUp(this);
        //this.removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.820 -0400", hash_original_method = "0386F7586104C91B22CE4150238AFD39", hash_generated_method = "963AC07ED7DE6AEA46B3068BB242386B")
    protected void finalize() {
        CatLog.d(this, "Service finalized");
        // ---------- Original Method ----------
        //CatLog.d(this, "Service finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.833 -0400", hash_original_method = "E9D273BBD1B8139BCAB5560E10ADE1AE", hash_generated_method = "AB694E2435B4CCE042CA7D6766BAC646")
    private void handleRilMsg(RilMessage rilMsg) {
        CommandParams cmdParams;
        cmdParams = null;
        //Begin case MSG_ID_EVENT_NOTIFY 
        {
            cmdParams = (CommandParams) rilMsg.mData;
            {
                handleProactiveCommand(cmdParams);
            } //End block
        } //End block
        //End case MSG_ID_EVENT_NOTIFY 
        //Begin case MSG_ID_PROACTIVE_COMMAND 
        try 
        {
            cmdParams = (CommandParams) rilMsg.mData;
        } //End block
        catch (ClassCastException e)
        {
            CatLog.d(this, "Fail to parse proactive command");
            sendTerminalResponse(mCurrntCmd.mCmdDet, ResultCode.CMD_DATA_NOT_UNDERSTOOD,
                                     false, 0x00, null);
        } //End block
        //End case MSG_ID_PROACTIVE_COMMAND 
        //Begin case MSG_ID_PROACTIVE_COMMAND 
        {
            {
                handleProactiveCommand(cmdParams);
            } //End block
            {
                sendTerminalResponse(cmdParams.cmdDet, rilMsg.mResCode,
                            false, 0, null);
            } //End block
        } //End block
        //End case MSG_ID_PROACTIVE_COMMAND 
        //Begin case MSG_ID_REFRESH 
        cmdParams = (CommandParams) rilMsg.mData;
        //End case MSG_ID_REFRESH 
        //Begin case MSG_ID_REFRESH 
        {
            handleProactiveCommand(cmdParams);
        } //End block
        //End case MSG_ID_REFRESH 
        //Begin case MSG_ID_SESSION_END 
        handleSessionEnd();
        //End case MSG_ID_SESSION_END 
        addTaint(rilMsg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.836 -0400", hash_original_method = "962D88968BE7A135485D50B41AC85213", hash_generated_method = "7FBE59072E6FA1E5681C7BC097CB44C4")
    private void handleProactiveCommand(CommandParams cmdParams) {
        CatLog.d(this, cmdParams.getCommandType().name());
        CharSequence message;
        CatCmdMessage cmdMsg;
        cmdMsg = new CatCmdMessage(cmdParams);
        {
            Object varA74AB301753C81C1EF1463B16F741D65_403894409 = (cmdParams.getCommandType());
            //Begin case SET_UP_MENU 
            {
                boolean varBDB939CADF418BD3B149DA2D195D52CC_1005977986 = (removeMenu(cmdMsg.getMenu()));
                {
                    mMenuCmd = null;
                } //End block
                {
                    mMenuCmd = cmdMsg;
                } //End block
            } //End collapsed parenthetic
            //End case SET_UP_MENU 
            //Begin case SET_UP_MENU 
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            //End case SET_UP_MENU 
            //Begin case DISPLAY_TEXT 
            {
                boolean var85EC808BECD69A26D4BEA7B0ABCBD691_1591270114 = (!cmdMsg.geTextMessage().responseNeeded);
                {
                    sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                } //End block
            } //End collapsed parenthetic
            //End case DISPLAY_TEXT 
            //Begin case REFRESH 
            cmdParams.cmdDet.typeOfCommand = CommandType.SET_UP_IDLE_MODE_TEXT.value();
            //End case REFRESH 
            //Begin case SET_UP_IDLE_MODE_TEXT 
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            //End case SET_UP_IDLE_MODE_TEXT 
            //Begin case PROVIDE_LOCAL_INFORMATION 
            ResponseData resp;
            //End case PROVIDE_LOCAL_INFORMATION 
            //Begin case PROVIDE_LOCAL_INFORMATION 
            //Begin case CommandParamsFactory.DTTZ_SETTING 
            resp = new DTTZResponseData(null);
            //End case CommandParamsFactory.DTTZ_SETTING 
            //Begin case CommandParamsFactory.DTTZ_SETTING 
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
            //End case CommandParamsFactory.DTTZ_SETTING 
            //Begin case CommandParamsFactory.LANGUAGE_SETTING 
            resp = new LanguageResponseData(Locale.getDefault().getLanguage());
            //End case CommandParamsFactory.LANGUAGE_SETTING 
            //Begin case CommandParamsFactory.LANGUAGE_SETTING 
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
            //End case CommandParamsFactory.LANGUAGE_SETTING 
            //Begin case default 
            sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
            //End case default 
            //End case PROVIDE_LOCAL_INFORMATION 
            //Begin case LAUNCH_BROWSER 
            {
                boolean var289612E192C87C1C213531B7648CE2E4_694672036 = ((((LaunchBrowserParams) cmdParams).confirmMsg.text != null)
                        && (((LaunchBrowserParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.launchBrowserDefault);
                    ((LaunchBrowserParams) cmdParams).confirmMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case LAUNCH_BROWSER 
            //Begin case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            {
                boolean varF0C118B2E2B35C6F3762B0AE0908E95F_400108359 = ((((DisplayTextParams)cmdParams).textMsg.text != null)
                        && (((DisplayTextParams)cmdParams).textMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.sending);
                    ((DisplayTextParams)cmdParams).textMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            //Begin case SET_UP_CALL 
            {
                boolean var748082CB986285C53A80D0C3B5EED825_191977424 = ((((CallSetupParams) cmdParams).confirmMsg.text != null)
                        && (((CallSetupParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.SetupCallDefault);
                    ((CallSetupParams) cmdParams).confirmMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case SET_UP_CALL 
            //Begin case default 
            CatLog.d(this, "Unsupported command");
            //End case default 
        } //End collapsed parenthetic
        mCurrntCmd = cmdMsg;
        Intent intent;
        intent = new Intent(AppInterface.CAT_CMD_ACTION);
        intent.putExtra("STK CMD", cmdMsg);
        mContext.sendBroadcast(intent);
        addTaint(cmdParams.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.837 -0400", hash_original_method = "F4FE7D680FC27736DB53FE02767C67C5", hash_generated_method = "3B5C1BD9898958A40C4F8FFD0CBC6745")
    private void handleSessionEnd() {
        CatLog.d(this, "SESSION END");
        mCurrntCmd = mMenuCmd;
        Intent intent;
        intent = new Intent(AppInterface.CAT_SESSION_END_ACTION);
        mContext.sendBroadcast(intent);
        // ---------- Original Method ----------
        //CatLog.d(this, "SESSION END");
        //mCurrntCmd = mMenuCmd;
        //Intent intent = new Intent(AppInterface.CAT_SESSION_END_ACTION);
        //mContext.sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.853 -0400", hash_original_method = "1946CA6BE8E37F5C447374ACD2229E75", hash_generated_method = "51B20C22149F14D7B830C4C8DA22CD14")
    private void sendTerminalResponse(CommandDetails cmdDet,
            ResultCode resultCode, boolean includeAdditionalInfo,
            int additionalInfo, ResponseData resp) {
        ByteArrayOutputStream buf;
        buf = new ByteArrayOutputStream();
        Input cmdInput;
        cmdInput = null;
        {
            cmdInput = mCurrntCmd.geInput();
        } //End block
        int tag;
        tag = ComprehensionTlvTag.COMMAND_DETAILS.value();
        {
            tag |= 0x80;
        } //End block
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
        } //End block
        {
            resp.format(buf);
        } //End block
        {
            encodeOptionalTags(cmdDet, resultCode, cmdInput, buf);
        } //End block
        byte[] rawData;
        rawData = buf.toByteArray();
        String hexString;
        hexString = IccUtils.bytesToHexString(rawData);
        {
            CatLog.d(this, "TERMINAL RESPONSE: " + hexString);
        } //End block
        mCmdIf.sendTerminalResponse(hexString, null);
        addTaint(cmdDet.getTaint());
        addTaint(resultCode.getTaint());
        addTaint(includeAdditionalInfo);
        addTaint(additionalInfo);
        addTaint(resp.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.854 -0400", hash_original_method = "638B326A6DB369CFE44B9E340F9EEB09", hash_generated_method = "3F2AF2BA5D30367E6316B4DB10BFE591")
    private void encodeOptionalTags(CommandDetails cmdDet,
            ResultCode resultCode, Input cmdInput, ByteArrayOutputStream buf) {
        CommandType cmdType;
        cmdType = AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        {
            //Begin case GET_INKEY 
            {
                boolean var082860D7E23D30F4E1F73375F5BB4E0C_1848985871 = ((resultCode.value() == ResultCode.NO_RESPONSE_FROM_USER.value()) &&
                        (cmdInput != null) && (cmdInput.duration != null));
                {
                    getInKeyResponse(buf, cmdInput);
                } //End block
            } //End collapsed parenthetic
            //End case GET_INKEY 
            //Begin case PROVIDE_LOCAL_INFORMATION 
            {
                boolean varE61954B8FB8D644763D155CCE3759480_2082309807 = ((cmdDet.commandQualifier == CommandParamsFactory.LANGUAGE_SETTING) &&
                        (resultCode.value() == ResultCode.OK.value()));
                {
                    getPliResponse(buf);
                } //End block
            } //End collapsed parenthetic
            //End case PROVIDE_LOCAL_INFORMATION 
            //Begin case default 
            CatLog.d(this, "encodeOptionalTags() Unsupported Cmd:" + cmdDet.typeOfCommand);
            //End case default 
        } //End block
        {
            CatLog.d(this, "encodeOptionalTags() bad Cmd:" + cmdDet.typeOfCommand);
        } //End block
        addTaint(cmdDet.getTaint());
        addTaint(resultCode.getTaint());
        addTaint(cmdInput.getTaint());
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.854 -0400", hash_original_method = "0852EED8EE8FA95FED775B0B05726071", hash_generated_method = "F6DB62DDB9A9817EE6FE74FF28DF9BBC")
    private void getInKeyResponse(ByteArrayOutputStream buf, Input cmdInput) {
        int tag;
        tag = ComprehensionTlvTag.DURATION.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(cmdInput.duration.timeUnit.SECOND.value());
        buf.write(cmdInput.duration.timeInterval);
        addTaint(buf.getTaint());
        addTaint(cmdInput.getTaint());
        // ---------- Original Method ----------
        //int tag = ComprehensionTlvTag.DURATION.value();
        //buf.write(tag);
        //buf.write(0x02);
        //buf.write(cmdInput.duration.timeUnit.SECOND.value());
        //buf.write(cmdInput.duration.timeInterval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.855 -0400", hash_original_method = "9C18CC5EFDD0B345CA3B94FA3BA225B1", hash_generated_method = "63FD275A5E010C06EFC525D9C1394D58")
    private void getPliResponse(ByteArrayOutputStream buf) {
        String lang;
        lang = SystemProperties.get("persist.sys.language");
        {
            int tag;
            tag = ComprehensionTlvTag.LANGUAGE.value();
            buf.write(tag);
            ResponseData.writeLength(buf, lang.length());
            buf.write(lang.getBytes(), 0, lang.length());
        } //End block
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //String lang = SystemProperties.get("persist.sys.language");
        //if (lang != null) {
            //int tag = ComprehensionTlvTag.LANGUAGE.value();
            //buf.write(tag);
            //ResponseData.writeLength(buf, lang.length());
            //buf.write(lang.getBytes(), 0, lang.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.859 -0400", hash_original_method = "8584D48A0DB0867CC39B0E747FD77F24", hash_generated_method = "670979B22D79AC8A742D8AC8855991B0")
    private void sendMenuSelection(int menuId, boolean helpRequired) {
        ByteArrayOutputStream buf;
        buf = new ByteArrayOutputStream();
        int tag;
        tag = BerTlv.BER_MENU_SELECTION_TAG;
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
        } //End block
        byte[] rawData;
        rawData = buf.toByteArray();
        int len;
        len = rawData.length - 2;
        rawData[1] = (byte) len;
        String hexString;
        hexString = IccUtils.bytesToHexString(rawData);
        mCmdIf.sendEnvelope(hexString, null);
        addTaint(menuId);
        addTaint(helpRequired);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.937 -0400", hash_original_method = "BB297ADB158EDB6C7A0522557FDE81DF", hash_generated_method = "6F68DC63EEB262210139B6EF8ADE197D")
    private void eventDownload(int event, int sourceId, int destinationId,
            byte[] additionalInfo, boolean oneShot) {
        ByteArrayOutputStream buf;
        buf = new ByteArrayOutputStream();
        int tag;
        tag = BerTlv.BER_EVENT_DOWNLOAD_TAG;
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
                } //End block
            } //End collapsed parenthetic
        } //End block
        byte[] rawData;
        rawData = buf.toByteArray();
        int len;
        len = rawData.length - 2;
        rawData[1] = (byte) len;
        String hexString;
        hexString = IccUtils.bytesToHexString(rawData);
        mCmdIf.sendEnvelope(hexString, null);
        addTaint(event);
        addTaint(sourceId);
        addTaint(destinationId);
        addTaint(additionalInfo[0]);
        addTaint(oneShot);
        // ---------- Original Method ----------
        //ByteArrayOutputStream buf = new ByteArrayOutputStream();
        //int tag = BerTlv.BER_EVENT_DOWNLOAD_TAG;
        //buf.write(tag);
        //buf.write(0x00);
        //tag = 0x80 | ComprehensionTlvTag.EVENT_LIST.value();
        //buf.write(tag);
        //buf.write(0x01);
        //buf.write(event);
        //tag = 0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        //buf.write(tag);
        //buf.write(0x02);
        //buf.write(sourceId);
        //buf.write(destinationId);
        //if (additionalInfo != null) {
            //for (byte b : additionalInfo) {
                //buf.write(b);
            //}
        //}
        //byte[] rawData = buf.toByteArray();
        //int len = rawData.length - 2;
        //rawData[1] = (byte) len;
        //String hexString = IccUtils.bytesToHexString(rawData);
        //mCmdIf.sendEnvelope(hexString, null);
    }

    
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

    
        public static AppInterface getInstance() {
        return getInstance(null, null, null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.938 -0400", hash_original_method = "08AB5E16EBCD81DA8811894A2C2969C7", hash_generated_method = "B62012315CD2EE6B2464DB05F8781AE3")
    @Override
    public void handleMessage(Message msg) {
        //Begin case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        CatLog.d(this, "ril message arrived");
        //End case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        //Begin case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        String data;
        data = null;
        //End case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        //Begin case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        {
            AsyncResult ar;
            ar = (AsyncResult) msg.obj;
            {
                try 
                {
                    data = (String) ar.result;
                } //End block
                catch (ClassCastException e)
                { }
            } //End block
        } //End block
        //End case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        //Begin case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, data));
        //End case MSG_ID_SESSION_END MSG_ID_PROACTIVE_COMMAND MSG_ID_EVENT_NOTIFY MSG_ID_REFRESH 
        //Begin case MSG_ID_CALL_SETUP 
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, null));
        //End case MSG_ID_CALL_SETUP 
        //Begin case MSG_ID_RIL_MSG_DECODED 
        handleRilMsg((RilMessage) msg.obj);
        //End case MSG_ID_RIL_MSG_DECODED 
        //Begin case MSG_ID_RESPONSE 
        handleCmdResponse((CatResponseMessage) msg.obj);
        //End case MSG_ID_RESPONSE 
        //Begin case MSG_ID_SIM_READY 
        CatLog.d(this, "SIM ready. Reporting STK service running now...");
        //End case MSG_ID_SIM_READY 
        //Begin case MSG_ID_SIM_READY 
        mCmdIf.reportStkServiceIsRunning(null);
        //End case MSG_ID_SIM_READY 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError("Unrecognized CAT command: " + msg.what);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.939 -0400", hash_original_method = "8251947338311BFA45C2A2344891C68B", hash_generated_method = "64BEB40461B63A5B10EA46C9597FEB21")
    public synchronized void onCmdResponse(CatResponseMessage resMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Message msg;
        msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        msg.sendToTarget();
        addTaint(resMsg.getTaint());
        // ---------- Original Method ----------
        //if (resMsg == null) {
            //return;
        //}
        //Message msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        //msg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.939 -0400", hash_original_method = "B0A9A02E0F2D96AF829ED175E58D2181", hash_generated_method = "16DA7192765A9E076BF9B1E9667F1E6D")
    private boolean validateResponse(CatResponseMessage resMsg) {
        {
            boolean var36410395CD93C1DC7B6B62D97443551F_1612131552 = ((resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet)));
        } //End block
        addTaint(resMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629917133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629917133;
        // ---------- Original Method ----------
        //if (mCurrntCmd != null) {
            //return (resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.945 -0400", hash_original_method = "FED22D423ED234057B6FD28452B9EEF5", hash_generated_method = "A83037DC273D3D5DE7675D9878BA2DA9")
    private boolean removeMenu(Menu menu) {
        try 
        {
            {
                boolean var7A3FCD0C746293761DF6222920A6CC9F_1523073702 = (menu.items.size() == 1 && menu.items.get(0) == null);
            } //End collapsed parenthetic
        } //End block
        catch (NullPointerException e)
        {
            CatLog.d(this, "Unable to get Menu's items size");
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923392742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923392742;
        // ---------- Original Method ----------
        //try {
            //if (menu.items.size() == 1 && menu.items.get(0) == null) {
                //return true;
            //}
        //} catch (NullPointerException e) {
            //CatLog.d(this, "Unable to get Menu's items size");
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.950 -0400", hash_original_method = "48D7C107F944AA3B8D2770DC9FDB0ED7", hash_generated_method = "28286680B79CFBB741D771A82C6AB8F2")
    private void handleCmdResponse(CatResponseMessage resMsg) {
        {
            boolean varD22E38D970B07736EEDB0B746B6EF7EE_1011493268 = (!validateResponse(resMsg));
        } //End collapsed parenthetic
        ResponseData resp;
        resp = null;
        boolean helpRequired;
        helpRequired = false;
        CommandDetails cmdDet;
        cmdDet = resMsg.getCmdDetails();
        //Begin case HELP_INFO_REQUIRED 
        helpRequired = true;
        //End case HELP_INFO_REQUIRED 
        //Begin case OK PRFRMD_WITH_PARTIAL_COMPREHENSION PRFRMD_WITH_MISSING_INFO PRFRMD_WITH_ADDITIONAL_EFS_READ PRFRMD_ICON_NOT_DISPLAYED PRFRMD_MODIFIED_BY_NAA PRFRMD_LIMITED_SERVICE PRFRMD_WITH_MODIFICATION PRFRMD_NAA_NOT_ACTIVE PRFRMD_TONE_NOT_PLAYED 
        {
            Object var5A134572D68F084201EB42583661BD51_660303421 = (AppInterface.CommandType.fromInt(cmdDet.typeOfCommand));
            //Begin case SET_UP_MENU 
            helpRequired = resMsg.resCode == ResultCode.HELP_INFO_REQUIRED;
            //End case SET_UP_MENU 
            //Begin case SET_UP_MENU 
            sendMenuSelection(resMsg.usersMenuSelection, helpRequired);
            //End case SET_UP_MENU 
            //Begin case SELECT_ITEM 
            resp = new SelectItemResponseData(resMsg.usersMenuSelection);
            //End case SELECT_ITEM 
            //Begin case GET_INPUT GET_INKEY 
            Input input;
            input = mCurrntCmd.geInput();
            //End case GET_INPUT GET_INKEY 
            //Begin case GET_INPUT GET_INKEY 
            {
                {
                    resp = new GetInkeyInputResponseData(resMsg.usersInput,
                                input.ucs2, input.packed);
                } //End block
            } //End block
            {
                resp = new GetInkeyInputResponseData(
                            resMsg.usersYesNoSelection);
            } //End block
            //End case GET_INPUT GET_INKEY 
            //Begin case SET_UP_CALL 
            mCmdIf.handleCallSetupRequestFromSim(resMsg.usersConfirm, null);
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            mCurrntCmd = null;
            //End case SET_UP_CALL 
        } //End collapsed parenthetic
        //End case OK PRFRMD_WITH_PARTIAL_COMPREHENSION PRFRMD_WITH_MISSING_INFO PRFRMD_WITH_ADDITIONAL_EFS_READ PRFRMD_ICON_NOT_DISPLAYED PRFRMD_MODIFIED_BY_NAA PRFRMD_LIMITED_SERVICE PRFRMD_WITH_MODIFICATION PRFRMD_NAA_NOT_ACTIVE PRFRMD_TONE_NOT_PLAYED 
        //Begin case NO_RESPONSE_FROM_USER UICC_SESSION_TERM_BY_USER BACKWARD_MOVE_BY_USER 
        resp = null;
        //End case NO_RESPONSE_FROM_USER UICC_SESSION_TERM_BY_USER BACKWARD_MOVE_BY_USER 
        sendTerminalResponse(cmdDet, resMsg.resCode, false, 0, resp);
        mCurrntCmd = null;
        addTaint(resMsg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "C90E66D30105E64A69B0470347184F2E", hash_generated_field = "300A42BBD72D4F998C99A9B62F7A3C8A")

    private static IccRecords mIccRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "4B76103D546737D807190C72D978B677", hash_generated_field = "462BE78ED08F72FB2BE014F181DECF6A")

    private static Object sInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "E81D7F90EE651933B622FBF4BA337EDF")

    private static CatService sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "632F42CE616303BD224EFBB09EFA0D0F", hash_generated_field = "D493793BCCFFB3685D83519D1C56EDA6")

    static int MSG_ID_SESSION_END = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "63C317BE2F8A9BDC47E64B4228CD6BB1", hash_generated_field = "B5360C7854B2881D3268CB600FCB1B20")

    static int MSG_ID_PROACTIVE_COMMAND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "E1F0605CD0B3C65B7E157FDCE4C1D4CD", hash_generated_field = "02244DBD7D28527ED66C7CF344C9D643")

    static int MSG_ID_EVENT_NOTIFY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "CF5AD531AA56E8490EABB5F585A334BB", hash_generated_field = "E87D0E5EF4A28BA46199B6ADF3635263")

    static int MSG_ID_CALL_SETUP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "022752B8BB4C9107B8AA4354A9E7BA54", hash_generated_field = "319E5554F6FB659F5A475F568C68CDDF")

    static int MSG_ID_REFRESH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "589746988AD566E9B5F240DA87D7280C", hash_generated_field = "963BA58A616CC7F4B7CDDE85B18F60E5")

    static int MSG_ID_RESPONSE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "204656EABDF49E09856D83F756D5283D", hash_generated_field = "207D84941B072733BCDF3E2A7C998FF8")

    static int MSG_ID_SIM_READY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "1B99032C2DAAA65BB78AC11047093A7E", hash_generated_field = "3D56DABD73AF7E7A66E1356ED47A4E5A")

    static int MSG_ID_RIL_MSG_DECODED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "69616CB904166640B230A8A3E9BD29DF", hash_generated_field = "C4060D8C144F5B1F2D57156F2F834898")

    private static int MSG_ID_ICC_RECORDS_LOADED = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "E606BB6536C2CD2AA1B51B2CFA643356", hash_generated_field = "D7A0F481C9AE295C404A9BB46E7BF757")

    private static int DEV_ID_KEYPAD = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "9EB4C6827FE3DF8941B8D5CCF7322AC5", hash_generated_field = "9011443A5B6F25916DC5843A6291C28A")

    private static int DEV_ID_DISPLAY = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "572785F752EC0639F06FFE1B1DB6CA7B", hash_generated_field = "3A365C7F97490B91A1243F24B2B6D87F")

    private static int DEV_ID_EARPIECE = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "FF522F9795F08E1F1130B741C23CB557", hash_generated_field = "520315B8B74C568C1A0A908391D152B7")

    private static int DEV_ID_UICC = 0x81;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "F486BFEB3DC7F8DB6A09590ECF2B6283", hash_generated_field = "F2110DEC0BAB7DD6AD33CB03C1481F60")

    private static int DEV_ID_TERMINAL = 0x82;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "A2BFA57161B3AFF490465A9D4249A75C", hash_generated_field = "EC883D9ECE92BD54EAAE9AF032E41139")

    private static int DEV_ID_NETWORK = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.951 -0400", hash_original_field = "CCC9CF7056AE506ABEF0CA54C93931BF", hash_generated_field = "7CF3D2DBEFFF5A68A0F13B0E2DC6C627")

    static String STK_DEFAULT = "Defualt Message";
}

