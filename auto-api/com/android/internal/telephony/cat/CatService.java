package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import java.util.List;
import java.util.Locale;

class RilMessage {
    int mId;
    Object mData;
    ResultCode mResCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.706 -0400", hash_original_method = "3402C3F9EF39C06F449D290965539671", hash_generated_method = "0C7295DC6227E87FE64A14AA30387F7F")
    @DSModeled(DSC.SAFE)
     RilMessage(int msgId, String rawData) {
        dsTaint.addTaint(rawData);
        dsTaint.addTaint(msgId);
        // ---------- Original Method ----------
        //mId = msgId;
        //mData = rawData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.707 -0400", hash_original_method = "56F4F1F4536DAFEF01840B516ADA4963", hash_generated_method = "217B57E4787E5A6CBEEECACFB2187DA4")
    @DSModeled(DSC.SAFE)
     RilMessage(RilMessage other) {
        dsTaint.addTaint(other.dsTaint);
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
    private CommandsInterface mCmdIf;
    private Context mContext;
    private CatCmdMessage mCurrntCmd = null;
    private CatCmdMessage mMenuCmd = null;
    private RilMessageDecoder mMsgDecoder = null;
    private boolean mStkAppInstalled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.707 -0400", hash_original_method = "DAF9352B6B0C752A0F5F800B85F9E51D", hash_generated_method = "5A59CB01FD0EAAFA3C2EB46F5F8D2051")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CatService(CommandsInterface ci, IccRecords ir, Context context,
            IccFileHandler fh, IccCard ic) {
        dsTaint.addTaint(ic.dsTaint);
        dsTaint.addTaint(ir.dsTaint);
        dsTaint.addTaint(fh.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "Service: Input parameters must not be null");
        } //End block
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
        mStkAppInstalled = isStkAppInstalled();
        CatLog.d(this, "Running CAT service. STK app installed:" + mStkAppInstalled);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.708 -0400", hash_original_method = "D708104FB5CF5762DDEBFF2BAD6B6B04", hash_generated_method = "E3620C337A6B286ABC08B087041B971D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.708 -0400", hash_original_method = "0386F7586104C91B22CE4150238AFD39", hash_generated_method = "963AC07ED7DE6AEA46B3068BB242386B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        CatLog.d(this, "Service finalized");
        // ---------- Original Method ----------
        //CatLog.d(this, "Service finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.708 -0400", hash_original_method = "46E862853BCF1B4C10FC18858F4F6129", hash_generated_method = "FBC7D0A87A2B205D8B5AB83AC2FF0656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRilMsg(RilMessage rilMsg) {
        dsTaint.addTaint(rilMsg.dsTaint);
        CommandParams cmdParams;
        cmdParams = null;
        //Begin case MSG_ID_EVENT_NOTIFY 
        {
            cmdParams = (CommandParams) rilMsg.mData;
            {
                handleCommand(cmdParams, false);
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
                handleCommand(cmdParams, true);
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
            handleCommand(cmdParams, false);
        } //End block
        //End case MSG_ID_REFRESH 
        //Begin case MSG_ID_SESSION_END 
        handleSessionEnd();
        //End case MSG_ID_SESSION_END 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.709 -0400", hash_original_method = "089279BA70414B0641ABFD6DC3426623", hash_generated_method = "60BA81A799416BA2A8DB61DE8339ED37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCommand(CommandParams cmdParams, boolean isProactiveCmd) {
        dsTaint.addTaint(isProactiveCmd);
        dsTaint.addTaint(cmdParams.dsTaint);
        CatLog.d(this, cmdParams.getCommandType().name());
        CharSequence message;
        CatCmdMessage cmdMsg;
        cmdMsg = new CatCmdMessage(cmdParams);
        {
            Object varA74AB301753C81C1EF1463B16F741D65_1301244593 = (cmdParams.getCommandType());
            //Begin case SET_UP_MENU 
            {
                boolean varBDB939CADF418BD3B149DA2D195D52CC_637530804 = (removeMenu(cmdMsg.getMenu()));
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
                boolean var85EC808BECD69A26D4BEA7B0ABCBD691_789489887 = (!cmdMsg.geTextMessage().responseNeeded);
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
                boolean var289612E192C87C1C213531B7648CE2E4_986968783 = ((((LaunchBrowserParams) cmdParams).confirmMsg.text != null)
                        && (((LaunchBrowserParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.launchBrowserDefault);
                    ((LaunchBrowserParams) cmdParams).confirmMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case LAUNCH_BROWSER 
            //Begin case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            {
                boolean varF0C118B2E2B35C6F3762B0AE0908E95F_1750647234 = ((((DisplayTextParams)cmdParams).textMsg.text != null)
                        && (((DisplayTextParams)cmdParams).textMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.sending);
                    ((DisplayTextParams)cmdParams).textMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            //Begin case SET_UP_CALL 
            {
                boolean var748082CB986285C53A80D0C3B5EED825_171625170 = ((((CallSetupParams) cmdParams).confirmMsg.text != null)
                        && (((CallSetupParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT)));
                {
                    message = mContext.getText(com.android.internal.R.string.SetupCallDefault);
                    ((CallSetupParams) cmdParams).confirmMsg.text = message.toString();
                } //End block
            } //End collapsed parenthetic
            //End case SET_UP_CALL 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            BIPClientParams cmd;
            cmd = (BIPClientParams) cmdParams;
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            {
                CatLog.d(this, "cmd " + cmdParams.getCommandType() + " with null alpha id");
                {
                    sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                } //End block
            } //End block
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            {
                CatLog.d(this, "No STK application found.");
                {
                    sendTerminalResponse(cmdParams.cmdDet,
                                             ResultCode.BEYOND_TERMINAL_CAPABILITY,
                                             false, 0, null);
                } //End block
            } //End block
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            {
                boolean var507CDA315F4391D95BBEB833E0090237_123050097 = (isProactiveCmd &&
                    ((cmdParams.getCommandType() == CommandType.CLOSE_CHANNEL) ||
                     (cmdParams.getCommandType() == CommandType.RECEIVE_DATA) ||
                     (cmdParams.getCommandType() == CommandType.SEND_DATA)));
                {
                    sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                } //End block
            } //End collapsed parenthetic
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            //Begin case default 
            CatLog.d(this, "Unsupported command");
            //End case default 
        } //End collapsed parenthetic
        mCurrntCmd = cmdMsg;
        Intent intent;
        intent = new Intent(AppInterface.CAT_CMD_ACTION);
        intent.putExtra("STK CMD", cmdMsg);
        mContext.sendBroadcast(intent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.710 -0400", hash_original_method = "F4FE7D680FC27736DB53FE02767C67C5", hash_generated_method = "3B5C1BD9898958A40C4F8FFD0CBC6745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.710 -0400", hash_original_method = "1946CA6BE8E37F5C447374ACD2229E75", hash_generated_method = "D4015A5863227E555C3A667C011BE1F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendTerminalResponse(CommandDetails cmdDet,
            ResultCode resultCode, boolean includeAdditionalInfo,
            int additionalInfo, ResponseData resp) {
        dsTaint.addTaint(includeAdditionalInfo);
        dsTaint.addTaint(resultCode.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        dsTaint.addTaint(additionalInfo);
        dsTaint.addTaint(resp.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.711 -0400", hash_original_method = "638B326A6DB369CFE44B9E340F9EEB09", hash_generated_method = "17F8F6FF63FC7CA1F0CD8BEF17488D65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void encodeOptionalTags(CommandDetails cmdDet,
            ResultCode resultCode, Input cmdInput, ByteArrayOutputStream buf) {
        dsTaint.addTaint(cmdInput.dsTaint);
        dsTaint.addTaint(resultCode.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        dsTaint.addTaint(buf.dsTaint);
        CommandType cmdType;
        cmdType = AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        {
            //Begin case GET_INKEY 
            {
                boolean var082860D7E23D30F4E1F73375F5BB4E0C_1177446792 = ((resultCode.value() == ResultCode.NO_RESPONSE_FROM_USER.value()) &&
                        (cmdInput != null) && (cmdInput.duration != null));
                {
                    getInKeyResponse(buf, cmdInput);
                } //End block
            } //End collapsed parenthetic
            //End case GET_INKEY 
            //Begin case PROVIDE_LOCAL_INFORMATION 
            {
                boolean varE61954B8FB8D644763D155CCE3759480_1478757454 = ((cmdDet.commandQualifier == CommandParamsFactory.LANGUAGE_SETTING) &&
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.711 -0400", hash_original_method = "0852EED8EE8FA95FED775B0B05726071", hash_generated_method = "A102E915FBFA8A6C5B193FCC78D9A9F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getInKeyResponse(ByteArrayOutputStream buf, Input cmdInput) {
        dsTaint.addTaint(cmdInput.dsTaint);
        dsTaint.addTaint(buf.dsTaint);
        int tag;
        tag = ComprehensionTlvTag.DURATION.value();
        buf.write(tag);
        buf.write(0x02);
        buf.write(cmdInput.duration.timeUnit.SECOND.value());
        buf.write(cmdInput.duration.timeInterval);
        // ---------- Original Method ----------
        //int tag = ComprehensionTlvTag.DURATION.value();
        //buf.write(tag);
        //buf.write(0x02);
        //buf.write(cmdInput.duration.timeUnit.SECOND.value());
        //buf.write(cmdInput.duration.timeInterval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.711 -0400", hash_original_method = "9C18CC5EFDD0B345CA3B94FA3BA225B1", hash_generated_method = "7EAB0B8A4AAD268AE9A6D365F735D03D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getPliResponse(ByteArrayOutputStream buf) {
        dsTaint.addTaint(buf.dsTaint);
        String lang;
        lang = SystemProperties.get("persist.sys.language");
        {
            int tag;
            tag = ComprehensionTlvTag.LANGUAGE.value();
            buf.write(tag);
            ResponseData.writeLength(buf, lang.length());
            buf.write(lang.getBytes(), 0, lang.length());
        } //End block
        // ---------- Original Method ----------
        //String lang = SystemProperties.get("persist.sys.language");
        //if (lang != null) {
            //int tag = ComprehensionTlvTag.LANGUAGE.value();
            //buf.write(tag);
            //ResponseData.writeLength(buf, lang.length());
            //buf.write(lang.getBytes(), 0, lang.length());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.712 -0400", hash_original_method = "8584D48A0DB0867CC39B0E747FD77F24", hash_generated_method = "89C5E34363F8608A1199B3F0FCC6F9E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMenuSelection(int menuId, boolean helpRequired) {
        dsTaint.addTaint(helpRequired);
        dsTaint.addTaint(menuId);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.722 -0400", hash_original_method = "BB297ADB158EDB6C7A0522557FDE81DF", hash_generated_method = "36706066EEFFE2F3B85374058F81FD7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void eventDownload(int event, int sourceId, int destinationId,
            byte[] additionalInfo, boolean oneShot) {
        dsTaint.addTaint(oneShot);
        dsTaint.addTaint(event);
        dsTaint.addTaint(destinationId);
        dsTaint.addTaint(additionalInfo[0]);
        dsTaint.addTaint(sourceId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.724 -0400", hash_original_method = "08AB5E16EBCD81DA8811894A2C2969C7", hash_generated_method = "CC74F3E3E6A16482AFF0FD926DABEE4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.725 -0400", hash_original_method = "8251947338311BFA45C2A2344891C68B", hash_generated_method = "945CC05314CD084F89E88B90A9565D96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void onCmdResponse(CatResponseMessage resMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resMsg.dsTaint);
        Message msg;
        msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        msg.sendToTarget();
        // ---------- Original Method ----------
        //if (resMsg == null) {
            //return;
        //}
        //Message msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        //msg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.725 -0400", hash_original_method = "B0A9A02E0F2D96AF829ED175E58D2181", hash_generated_method = "87EBFF132815819D872A1FFE37DD1E01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean validateResponse(CatResponseMessage resMsg) {
        dsTaint.addTaint(resMsg.dsTaint);
        {
            boolean var36410395CD93C1DC7B6B62D97443551F_576956015 = ((resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet)));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCurrntCmd != null) {
            //return (resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.725 -0400", hash_original_method = "FED22D423ED234057B6FD28452B9EEF5", hash_generated_method = "557CB6FDE590F2F674615273B7670BD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeMenu(Menu menu) {
        dsTaint.addTaint(menu.dsTaint);
        try 
        {
            {
                boolean var7A3FCD0C746293761DF6222920A6CC9F_519662228 = (menu.items.size() == 1 && menu.items.get(0) == null);
            } //End collapsed parenthetic
        } //End block
        catch (NullPointerException e)
        {
            CatLog.d(this, "Unable to get Menu's items size");
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.726 -0400", hash_original_method = "492114C564A8529E1D49C71798FBC33A", hash_generated_method = "C3C0E1627EDEA22A066818E9F1F7E84F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCmdResponse(CatResponseMessage resMsg) {
        dsTaint.addTaint(resMsg.dsTaint);
        {
            boolean varD22E38D970B07736EEDB0B746B6EF7EE_1292644233 = (!validateResponse(resMsg));
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
            Object var5A134572D68F084201EB42583661BD51_782635974 = (AppInterface.CommandType.fromInt(cmdDet.typeOfCommand));
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
        //Begin case NO_RESPONSE_FROM_USER UICC_SESSION_TERM_BY_USER BACKWARD_MOVE_BY_USER USER_NOT_ACCEPT 
        resp = null;
        //End case NO_RESPONSE_FROM_USER UICC_SESSION_TERM_BY_USER BACKWARD_MOVE_BY_USER USER_NOT_ACCEPT 
        sendTerminalResponse(cmdDet, resMsg.resCode, false, 0, resp);
        mCurrntCmd = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.726 -0400", hash_original_method = "A33C855F74E90E671C569C899D01A092", hash_generated_method = "9B879B36553F7116E3DFDC338D4FBCE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isStkAppInstalled() {
        Intent intent;
        intent = new Intent(AppInterface.CAT_CMD_ACTION);
        PackageManager pm;
        pm = mContext.getPackageManager();
        List<ResolveInfo> broadcastReceivers;
        broadcastReceivers = pm.queryBroadcastReceivers(intent, PackageManager.GET_META_DATA);
        int numReceiver;
        numReceiver = 0;
        numReceiver = broadcastReceivers.size();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Intent intent = new Intent(AppInterface.CAT_CMD_ACTION);
        //PackageManager pm = mContext.getPackageManager();
        //List<ResolveInfo> broadcastReceivers =
                            //pm.queryBroadcastReceivers(intent, PackageManager.GET_META_DATA);
        //int numReceiver = broadcastReceivers == null ? 0 : broadcastReceivers.size();
        //return (numReceiver > 0);
    }

    
    private static IccRecords mIccRecords;
    private static final Object sInstanceLock = new Object();
    private static CatService sInstance;
    static final int MSG_ID_SESSION_END              = 1;
    static final int MSG_ID_PROACTIVE_COMMAND        = 2;
    static final int MSG_ID_EVENT_NOTIFY             = 3;
    static final int MSG_ID_CALL_SETUP               = 4;
    static final int MSG_ID_REFRESH                  = 5;
    static final int MSG_ID_RESPONSE                 = 6;
    static final int MSG_ID_SIM_READY                = 7;
    static final int MSG_ID_RIL_MSG_DECODED          = 10;
    private static final int MSG_ID_ICC_RECORDS_LOADED       = 20;
    private static final int DEV_ID_KEYPAD      = 0x01;
    private static final int DEV_ID_DISPLAY     = 0x02;
    private static final int DEV_ID_EARPIECE    = 0x03;
    private static final int DEV_ID_UICC        = 0x81;
    private static final int DEV_ID_TERMINAL    = 0x82;
    private static final int DEV_ID_NETWORK     = 0x83;
    static final String STK_DEFAULT = "Defualt Message";
}

