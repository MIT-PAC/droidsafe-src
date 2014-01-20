package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemProperties;

import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.IccUtils;

class RilMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.984 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.986 -0500", hash_original_field = "F7E50CC556DF4A3D9F10FA584C62181F", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

    Object mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.988 -0500", hash_original_field = "70A90D72FABA26F58FDAF243629DCAD1", hash_generated_field = "70A90D72FABA26F58FDAF243629DCAD1")

    ResultCode mResCode;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.991 -0500", hash_original_method = "3402C3F9EF39C06F449D290965539671", hash_generated_method = "3402C3F9EF39C06F449D290965539671")
    
RilMessage(int msgId, String rawData) {
        mId = msgId;
        mData = rawData;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.993 -0500", hash_original_method = "56F4F1F4536DAFEF01840B516ADA4963", hash_generated_method = "56F4F1F4536DAFEF01840B516ADA4963")
    
RilMessage(RilMessage other) {
        this.mId = other.mId;
        this.mData = other.mData;
        this.mResCode = other.mResCode;
    }
    
}

public class CatService extends Handler implements AppInterface {

    /**
     * Used for instantiating/updating the Service from the GsmPhone or CdmaPhone constructor.
     *
     * @param ci CommandsInterface object
     * @param ir IccRecords object
     * @param context phone app context
     * @param fh Icc file handler
     * @param ic Icc card
     * @return The only Service object in the system
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.097 -0500", hash_original_method = "C63EAB5DD848BA822380F72359762D98", hash_generated_method = "8427669AE90C659EB7E57EBD21C26E99")
    
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

                // re-Register for SIM ready event.
                mIccRecords.registerForRecordsLoaded(sInstance, MSG_ID_ICC_RECORDS_LOADED, null);
                CatLog.d(sInstance, "sr changed reinitialize and return current sInstance");
            } else {
                CatLog.d(sInstance, "Return current sInstance");
            }
            return sInstance;
        }
    }

    /**
     * Used by application to get an AppInterface object.
     *
     * @return The only Service object in the system
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.100 -0500", hash_original_method = "CE3A18A059C769DBE5E6B1AF2557EC84", hash_generated_method = "E009B1658E081AF7F9A5E9B3AF4BF887")
    
public static AppInterface getInstance() {
        return getInstance(null, null, null, null, null);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.997 -0500", hash_original_field = "B60FC624535C672B435037929B1B89ED", hash_generated_field = "300A42BBD72D4F998C99A9B62F7A3C8A")

    private static IccRecords mIccRecords;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.999 -0500", hash_original_field = "132EBB0B958EBA9CAF6860B5750F7D05", hash_generated_field = "6AEC09437E92FC0EE8EB31FA45FA852E")

    // Protects singleton instance lazy initialization.
    private static final Object sInstanceLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.003 -0500", hash_original_field = "0B32F461A397A05DBD942FF8618C2860", hash_generated_field = "E81D7F90EE651933B622FBF4BA337EDF")

    private static CatService sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.017 -0500", hash_original_field = "D4965E5CE049985E7B795F8C063A55A0", hash_generated_field = "B933D4066C198A221B804D3C0355458A")

    static final int MSG_ID_SESSION_END              = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.020 -0500", hash_original_field = "0ECFAE5CBE7B9DD879D9B87C4BB8576E", hash_generated_field = "3827004747A9C5230CD854B9D0239900")

    static final int MSG_ID_PROACTIVE_COMMAND        = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.022 -0500", hash_original_field = "867F537DE2544CA6EA3B43A333917EED", hash_generated_field = "AD79C01C2910E137E618F48FA3A6407F")

    static final int MSG_ID_EVENT_NOTIFY             = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.024 -0500", hash_original_field = "3EA6F7CB91AE7DA9BFC0ABE3B91DFEC2", hash_generated_field = "726D73D04043A09992A46D2C115FBCA2")

    static final int MSG_ID_CALL_SETUP               = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.027 -0500", hash_original_field = "78D64FB33CE33C20F8EB2DBAD84C1F33", hash_generated_field = "A1BAA908FCC8CBA8100D820436F0EBFA")

    static final int MSG_ID_REFRESH                  = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.030 -0500", hash_original_field = "AEF1AEBA55650ECA2B83CC1F0E2F33E2", hash_generated_field = "83DF57D7872F7FB69C027533FA525EA0")

    static final int MSG_ID_RESPONSE                 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.032 -0500", hash_original_field = "3287ECB86C11F6A612391F65FA4BCB3F", hash_generated_field = "5407D0B76A9936CBEB54A84AB91CB3A4")

    static final int MSG_ID_SIM_READY                = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.034 -0500", hash_original_field = "5A40F401F5388F12ACA3333D951FF343", hash_generated_field = "1D8CED9AB3530F764CD1A10878740D1E")

    static final int MSG_ID_RIL_MSG_DECODED          = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.037 -0500", hash_original_field = "B1CEA0BE46E514989BE09579BD34C779", hash_generated_field = "24237C7CDD07AE1193E4425BC5293C07")

    private static final int MSG_ID_ICC_RECORDS_LOADED       = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.040 -0500", hash_original_field = "5316FCB0E43FA46D0C9E26373A151EE3", hash_generated_field = "FAAA5F069799BFDB7A4455FCFA51B1D0")

    private static final int DEV_ID_KEYPAD      = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.043 -0500", hash_original_field = "9896CC2EF26F5A411A86CE42D43972B5", hash_generated_field = "FEDDF3242ED03B4066CCB4E86D6CA64E")

    private static final int DEV_ID_DISPLAY     = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.046 -0500", hash_original_field = "085109FD316B1984D4C3BCCEAC8A4EFC", hash_generated_field = "D49A5F3B2264885575E8D0522FB38D52")

    private static final int DEV_ID_EARPIECE    = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.048 -0500", hash_original_field = "60C9B4D7334D5174AAEECF0D21B3C28F", hash_generated_field = "B0B4E321690DD56DB0A3650FB64A8E74")

    private static final int DEV_ID_UICC        = 0x81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.051 -0500", hash_original_field = "E080BABDA3B7C60879C5B76036C14C47", hash_generated_field = "A961A85BE123718E6F104B44BB4331DD")

    private static final int DEV_ID_TERMINAL    = 0x82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.053 -0500", hash_original_field = "B5C3D8418ABB4B3F2C746403102418EB", hash_generated_field = "A4537B62A3FF2B04B6AE0CFC11651C24")

    private static final int DEV_ID_NETWORK     = 0x83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.055 -0500", hash_original_field = "7945B2C23E1EE06BDCBF5D27E8A88446", hash_generated_field = "F948D801B519250F532E826B09C5CF11")

    static final String STK_DEFAULT = "Defualt Message";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.005 -0500", hash_original_field = "964B9B3CAEE98BE74AD9E74C2B357672", hash_generated_field = "6EBA8BBFB850EB64C843C5863723C1B3")

    private CommandsInterface mCmdIf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.007 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.010 -0500", hash_original_field = "A8FB7CDE91C0E7AAFEE78E586A96C5E1", hash_generated_field = "538FD5CEC06AC573B443D69E91473326")

    private CatCmdMessage mCurrntCmd = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.012 -0500", hash_original_field = "ADB0D63375E9BB59AFA51373F5C9CA5D", hash_generated_field = "8ABF519EF89F0346AABDA35943975CF1")

    private CatCmdMessage mMenuCmd = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.014 -0500", hash_original_field = "4BE7780ADB6072B07188254F689A2900", hash_generated_field = "5581F8294B4A44B480C12D4CDCF45252")

    private RilMessageDecoder mMsgDecoder = null;

    /* Intentionally private for singleton */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.059 -0500", hash_original_method = "0B6E46ACD511396208B0FB6CDAFB964A", hash_generated_method = "457642732FF3A3AEC8B97909E8E7EE73")
    
private CatService(CommandsInterface ci, IccRecords ir, Context context,
            IccFileHandler fh, IccCard ic) {
        if (ci == null || ir == null || context == null || fh == null
                || ic == null) {
            throw new NullPointerException(
                    "Service: Input parameters must not be null");
        }
        mCmdIf = ci;
        mContext = context;

        // Get the RilMessagesDecoder for decoding the messages.
        mMsgDecoder = RilMessageDecoder.getInstance(this, fh);

        // Register ril events handling.
        mCmdIf.setOnCatSessionEnd(this, MSG_ID_SESSION_END, null);
        mCmdIf.setOnCatProactiveCmd(this, MSG_ID_PROACTIVE_COMMAND, null);
        mCmdIf.setOnCatEvent(this, MSG_ID_EVENT_NOTIFY, null);
        mCmdIf.setOnCatCallSetUp(this, MSG_ID_CALL_SETUP, null);
        //mCmdIf.setOnSimRefresh(this, MSG_ID_REFRESH, null);

        mIccRecords = ir;

        // Register for SIM ready event.
        mCmdIf.registerForSIMReady(this, MSG_ID_SIM_READY, null);
        mCmdIf.registerForRUIMReady(this, MSG_ID_SIM_READY, null);
        mCmdIf.registerForNVReady(this, MSG_ID_SIM_READY, null);
        mIccRecords.registerForRecordsLoaded(this, MSG_ID_ICC_RECORDS_LOADED, null);

        CatLog.d(this, "Is running");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.062 -0500", hash_original_method = "D708104FB5CF5762DDEBFF2BAD6B6B04", hash_generated_method = "0E1149C2D5EF187611B6C535B353D5A6")
    
public void dispose() {
        mIccRecords.unregisterForRecordsLoaded(this);
        mCmdIf.unSetOnCatSessionEnd(this);
        mCmdIf.unSetOnCatProactiveCmd(this);
        mCmdIf.unSetOnCatEvent(this);
        mCmdIf.unSetOnCatCallSetUp(this);

        this.removeCallbacksAndMessages(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.064 -0500", hash_original_method = "0386F7586104C91B22CE4150238AFD39", hash_generated_method = "03349806B78235B92AF3612004ABF5AF")
    
protected void finalize() {
        CatLog.d(this, "Service finalized");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.067 -0500", hash_original_method = "E9D273BBD1B8139BCAB5560E10ADE1AE", hash_generated_method = "F098065BED4664F6DB4E52783450BF54")
    
private void handleRilMsg(RilMessage rilMsg) {
        if (rilMsg == null) {
            return;
        }

        // dispatch messages
        CommandParams cmdParams = null;
        switch (rilMsg.mId) {
        case MSG_ID_EVENT_NOTIFY:
            if (rilMsg.mResCode == ResultCode.OK) {
                cmdParams = (CommandParams) rilMsg.mData;
                if (cmdParams != null) {
                    handleProactiveCommand(cmdParams);
                }
            }
            break;
        case MSG_ID_PROACTIVE_COMMAND:
            try {
                cmdParams = (CommandParams) rilMsg.mData;
            } catch (ClassCastException e) {
                // for error handling : cast exception
                CatLog.d(this, "Fail to parse proactive command");
                sendTerminalResponse(mCurrntCmd.mCmdDet, ResultCode.CMD_DATA_NOT_UNDERSTOOD,
                                     false, 0x00, null);
                break;
            }
            if (cmdParams != null) {
                if (rilMsg.mResCode == ResultCode.OK) {
                    handleProactiveCommand(cmdParams);
                } else {
                    // for proactive commands that couldn't be decoded
                    // successfully respond with the code generated by the
                    // message decoder.
                    sendTerminalResponse(cmdParams.cmdDet, rilMsg.mResCode,
                            false, 0, null);
                }
            }
            break;
        case MSG_ID_REFRESH:
            cmdParams = (CommandParams) rilMsg.mData;
            if (cmdParams != null) {
                handleProactiveCommand(cmdParams);
            }
            break;
        case MSG_ID_SESSION_END:
            handleSessionEnd();
            break;
        case MSG_ID_CALL_SETUP:
            // prior event notify command supplied all the information
            // needed for set up call processing.
            break;
        }
    }

    /**
     * Handles RIL_UNSOL_STK_PROACTIVE_COMMAND unsolicited command from RIL.
     * Sends valid proactive command data to the application using intents.
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.073 -0500", hash_original_method = "962D88968BE7A135485D50B41AC85213", hash_generated_method = "5C83DB9A6C160B27DA74B31D7A2BB3C7")
    
private void handleProactiveCommand(CommandParams cmdParams) {
        CatLog.d(this, cmdParams.getCommandType().name());

        CharSequence message;
        CatCmdMessage cmdMsg = new CatCmdMessage(cmdParams);
        switch (cmdParams.getCommandType()) {
            case SET_UP_MENU:
                if (removeMenu(cmdMsg.getMenu())) {
                    mMenuCmd = null;
                } else {
                    mMenuCmd = cmdMsg;
                }
                sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                break;
            case DISPLAY_TEXT:
                // when application is not required to respond, send an immediate response.
                if (!cmdMsg.geTextMessage().responseNeeded) {
                    sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                }
                break;
            case REFRESH:
                // ME side only handles refresh commands which meant to remove IDLE
                // MODE TEXT.
                cmdParams.cmdDet.typeOfCommand = CommandType.SET_UP_IDLE_MODE_TEXT.value();
                break;
            case SET_UP_IDLE_MODE_TEXT:
                sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                break;
            case PROVIDE_LOCAL_INFORMATION:
                ResponseData resp;
                switch (cmdParams.cmdDet.commandQualifier) {
                    case CommandParamsFactory.DTTZ_SETTING:
                        resp = new DTTZResponseData(null);
                        sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
                        return;
                    case CommandParamsFactory.LANGUAGE_SETTING:
                        resp = new LanguageResponseData(Locale.getDefault().getLanguage());
                        sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, resp);
                        return;
                    default:
                        sendTerminalResponse(cmdParams.cmdDet, ResultCode.OK, false, 0, null);
                        return;
                }
            case LAUNCH_BROWSER:
                if ((((LaunchBrowserParams) cmdParams).confirmMsg.text != null)
                        && (((LaunchBrowserParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT))) {
                    message = mContext.getText(com.android.internal.R.string.launchBrowserDefault);
                    ((LaunchBrowserParams) cmdParams).confirmMsg.text = message.toString();
                }
                break;
            case SELECT_ITEM:
            case GET_INPUT:
            case GET_INKEY:
                break;
            case SEND_DTMF:
            case SEND_SMS:
            case SEND_SS:
            case SEND_USSD:
                if ((((DisplayTextParams)cmdParams).textMsg.text != null)
                        && (((DisplayTextParams)cmdParams).textMsg.text.equals(STK_DEFAULT))) {
                    message = mContext.getText(com.android.internal.R.string.sending);
                    ((DisplayTextParams)cmdParams).textMsg.text = message.toString();
                }
                break;
            case PLAY_TONE:
                break;
            case SET_UP_CALL:
                if ((((CallSetupParams) cmdParams).confirmMsg.text != null)
                        && (((CallSetupParams) cmdParams).confirmMsg.text.equals(STK_DEFAULT))) {
                    message = mContext.getText(com.android.internal.R.string.SetupCallDefault);
                    ((CallSetupParams) cmdParams).confirmMsg.text = message.toString();
                }
                break;
            default:
                CatLog.d(this, "Unsupported command");
                return;
        }
        mCurrntCmd = cmdMsg;
        Intent intent = new Intent(AppInterface.CAT_CMD_ACTION);
        intent.putExtra("STK CMD", cmdMsg);
        mContext.sendBroadcast(intent);
    }

    /**
     * Handles RIL_UNSOL_STK_SESSION_END unsolicited command from RIL.
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.075 -0500", hash_original_method = "F4FE7D680FC27736DB53FE02767C67C5", hash_generated_method = "B2C243698171FA5EFCE4E3C09AAE908D")
    
private void handleSessionEnd() {
        CatLog.d(this, "SESSION END");

        mCurrntCmd = mMenuCmd;
        Intent intent = new Intent(AppInterface.CAT_SESSION_END_ACTION);
        mContext.sendBroadcast(intent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.079 -0500", hash_original_method = "1946CA6BE8E37F5C447374ACD2229E75", hash_generated_method = "4CFED7F34B6103C4BBB591E05B230078")
    
private void sendTerminalResponse(CommandDetails cmdDet,
            ResultCode resultCode, boolean includeAdditionalInfo,
            int additionalInfo, ResponseData resp) {

        if (cmdDet == null) {
            return;
        }
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        Input cmdInput = null;
        if (mCurrntCmd != null) {
            cmdInput = mCurrntCmd.geInput();
        }

        // command details
        int tag = ComprehensionTlvTag.COMMAND_DETAILS.value();
        if (cmdDet.compRequired) {
            tag |= 0x80;
        }
        buf.write(tag);
        buf.write(0x03); // length
        buf.write(cmdDet.commandNumber);
        buf.write(cmdDet.typeOfCommand);
        buf.write(cmdDet.commandQualifier);

        // device identities
        // According to TS102.223/TS31.111 section 6.8 Structure of
        // TERMINAL RESPONSE, "For all SIMPLE-TLV objects with Min=N,
        // the ME should set the CR(comprehension required) flag to
        // comprehension not required.(CR=0)"
        // Since DEVICE_IDENTITIES and DURATION TLVs have Min=N,
        // the CR flag is not set.
        tag = ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02); // length
        buf.write(DEV_ID_TERMINAL); // source device id
        buf.write(DEV_ID_UICC); // destination device id

        // result
        tag = 0x80 | ComprehensionTlvTag.RESULT.value();
        buf.write(tag);
        int length = includeAdditionalInfo ? 2 : 1;
        buf.write(length);
        buf.write(resultCode.value());

        // additional info
        if (includeAdditionalInfo) {
            buf.write(additionalInfo);
        }

        // Fill optional data for each corresponding command
        if (resp != null) {
            resp.format(buf);
        } else {
            encodeOptionalTags(cmdDet, resultCode, cmdInput, buf);
        }

        byte[] rawData = buf.toByteArray();
        String hexString = IccUtils.bytesToHexString(rawData);
        if (false) {
            CatLog.d(this, "TERMINAL RESPONSE: " + hexString);
        }

        mCmdIf.sendTerminalResponse(hexString, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.081 -0500", hash_original_method = "638B326A6DB369CFE44B9E340F9EEB09", hash_generated_method = "9FBC4C797435896D17C51DF573A163AF")
    
private void encodeOptionalTags(CommandDetails cmdDet,
            ResultCode resultCode, Input cmdInput, ByteArrayOutputStream buf) {
        CommandType cmdType = AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        if (cmdType != null) {
            switch (cmdType) {
                case GET_INKEY:
                    // ETSI TS 102 384,27.22.4.2.8.4.2.
                    // If it is a response for GET_INKEY command and the response timeout
                    // occured, then add DURATION TLV for variable timeout case.
                    if ((resultCode.value() == ResultCode.NO_RESPONSE_FROM_USER.value()) &&
                        (cmdInput != null) && (cmdInput.duration != null)) {
                        getInKeyResponse(buf, cmdInput);
                    }
                    break;
                case PROVIDE_LOCAL_INFORMATION:
                    if ((cmdDet.commandQualifier == CommandParamsFactory.LANGUAGE_SETTING) &&
                        (resultCode.value() == ResultCode.OK.value())) {
                        getPliResponse(buf);
                    }
                    break;
                default:
                    CatLog.d(this, "encodeOptionalTags() Unsupported Cmd:" + cmdDet.typeOfCommand);
                    break;
            }
        } else {
            CatLog.d(this, "encodeOptionalTags() bad Cmd:" + cmdDet.typeOfCommand);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.084 -0500", hash_original_method = "0852EED8EE8FA95FED775B0B05726071", hash_generated_method = "6D3AEE8EC3D7C9CBAC4D9E2C25DE430B")
    
private void getInKeyResponse(ByteArrayOutputStream buf, Input cmdInput) {
        int tag = ComprehensionTlvTag.DURATION.value();

        buf.write(tag);
        buf.write(0x02); // length
        buf.write(cmdInput.duration.timeUnit.SECOND.value()); // Time (Unit,Seconds)
        buf.write(cmdInput.duration.timeInterval); // Time Duration
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.086 -0500", hash_original_method = "9C18CC5EFDD0B345CA3B94FA3BA225B1", hash_generated_method = "D486DD30354CD25DB695D7E60FD340C4")
    
private void getPliResponse(ByteArrayOutputStream buf) {

        // Locale Language Setting
        String lang = SystemProperties.get("persist.sys.language");

        if (lang != null) {
            // tag
            int tag = ComprehensionTlvTag.LANGUAGE.value();
            buf.write(tag);
            ResponseData.writeLength(buf, lang.length());
            buf.write(lang.getBytes(), 0, lang.length());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.089 -0500", hash_original_method = "8584D48A0DB0867CC39B0E747FD77F24", hash_generated_method = "57BDD7A4D9B0F2498BB585DF56AC8460")
    
private void sendMenuSelection(int menuId, boolean helpRequired) {

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // tag
        int tag = BerTlv.BER_MENU_SELECTION_TAG;
        buf.write(tag);

        // length
        buf.write(0x00); // place holder

        // device identities
        tag = 0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02); // length
        buf.write(DEV_ID_KEYPAD); // source device id
        buf.write(DEV_ID_UICC); // destination device id

        // item identifier
        tag = 0x80 | ComprehensionTlvTag.ITEM_ID.value();
        buf.write(tag);
        buf.write(0x01); // length
        buf.write(menuId); // menu identifier chosen

        // help request
        if (helpRequired) {
            tag = ComprehensionTlvTag.HELP_REQUEST.value();
            buf.write(tag);
            buf.write(0x00); // length
        }

        byte[] rawData = buf.toByteArray();

        // write real length
        int len = rawData.length - 2; // minus (tag + length)
        rawData[1] = (byte) len;

        String hexString = IccUtils.bytesToHexString(rawData);

        mCmdIf.sendEnvelope(hexString, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.093 -0500", hash_original_method = "BB297ADB158EDB6C7A0522557FDE81DF", hash_generated_method = "A773A07E2DEA8002C92E07214E391A7D")
    
private void eventDownload(int event, int sourceId, int destinationId,
            byte[] additionalInfo, boolean oneShot) {

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // tag
        int tag = BerTlv.BER_EVENT_DOWNLOAD_TAG;
        buf.write(tag);

        // length
        buf.write(0x00); // place holder, assume length < 128.

        // event list
        tag = 0x80 | ComprehensionTlvTag.EVENT_LIST.value();
        buf.write(tag);
        buf.write(0x01); // length
        buf.write(event); // event value

        // device identities
        tag = 0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value();
        buf.write(tag);
        buf.write(0x02); // length
        buf.write(sourceId); // source device id
        buf.write(destinationId); // destination device id

        // additional information
        if (additionalInfo != null) {
            for (byte b : additionalInfo) {
                buf.write(b);
            }
        }

        byte[] rawData = buf.toByteArray();

        // write real length
        int len = rawData.length - 2; // minus (tag + length)
        rawData[1] = (byte) len;

        String hexString = IccUtils.bytesToHexString(rawData);

        mCmdIf.sendEnvelope(hexString, null);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.103 -0500", hash_original_method = "08AB5E16EBCD81DA8811894A2C2969C7", hash_generated_method = "1FCCDA9D24D3D7DF806F50D3DAC87D4D")
    
@Override
    public void handleMessage(Message msg) {

        switch (msg.what) {
        case MSG_ID_SESSION_END:
        case MSG_ID_PROACTIVE_COMMAND:
        case MSG_ID_EVENT_NOTIFY:
        case MSG_ID_REFRESH:
            CatLog.d(this, "ril message arrived");
            String data = null;
            if (msg.obj != null) {
                AsyncResult ar = (AsyncResult) msg.obj;
                if (ar != null && ar.result != null) {
                    try {
                        data = (String) ar.result;
                    } catch (ClassCastException e) {
                        break;
                    }
                }
            }
            mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, data));
            break;
        case MSG_ID_CALL_SETUP:
            mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(msg.what, null));
            break;
        case MSG_ID_ICC_RECORDS_LOADED:
            break;
        case MSG_ID_RIL_MSG_DECODED:
            handleRilMsg((RilMessage) msg.obj);
            break;
        case MSG_ID_RESPONSE:
            handleCmdResponse((CatResponseMessage) msg.obj);
            break;
        case MSG_ID_SIM_READY:
            CatLog.d(this, "SIM ready. Reporting STK service running now...");
            mCmdIf.reportStkServiceIsRunning(null);
            break;
        default:
            throw new AssertionError("Unrecognized CAT command: " + msg.what);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.105 -0500", hash_original_method = "8251947338311BFA45C2A2344891C68B", hash_generated_method = "3C3EA10D0A5E0C8DA6FBE72E7892BF72")
    
public synchronized void onCmdResponse(CatResponseMessage resMsg) {
        if (resMsg == null) {
            return;
        }
        // queue a response message.
        Message msg = this.obtainMessage(MSG_ID_RESPONSE, resMsg);
        msg.sendToTarget();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.108 -0500", hash_original_method = "B0A9A02E0F2D96AF829ED175E58D2181", hash_generated_method = "722525FE0CF92E698D3BC5F94B8AA638")
    
private boolean validateResponse(CatResponseMessage resMsg) {
        if (mCurrntCmd != null) {
            return (resMsg.cmdDet.compareTo(mCurrntCmd.mCmdDet));
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.110 -0500", hash_original_method = "FED22D423ED234057B6FD28452B9EEF5", hash_generated_method = "9F1793606CFE9DCE94A14454066A450E")
    
private boolean removeMenu(Menu menu) {
        try {
            if (menu.items.size() == 1 && menu.items.get(0) == null) {
                return true;
            }
        } catch (NullPointerException e) {
            CatLog.d(this, "Unable to get Menu's items size");
            return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.114 -0500", hash_original_method = "48D7C107F944AA3B8D2770DC9FDB0ED7", hash_generated_method = "9DFDE79FDB4E24928364BAB55C565E97")
    
private void handleCmdResponse(CatResponseMessage resMsg) {
        // Make sure the response details match the last valid command. An invalid
        // response is a one that doesn't have a corresponding proactive command
        // and sending it can "confuse" the baseband/ril.
        // One reason for out of order responses can be UI glitches. For example,
        // if the application launch an activity, and that activity is stored
        // by the framework inside the history stack. That activity will be
        // available for relaunch using the latest application dialog
        // (long press on the home button). Relaunching that activity can send
        // the same command's result again to the CatService and can cause it to
        // get out of sync with the SIM.
        if (!validateResponse(resMsg)) {
            return;
        }
        ResponseData resp = null;
        boolean helpRequired = false;
        CommandDetails cmdDet = resMsg.getCmdDetails();

        switch (resMsg.resCode) {
        case HELP_INFO_REQUIRED:
            helpRequired = true;
            // fall through
        case OK:
        case PRFRMD_WITH_PARTIAL_COMPREHENSION:
        case PRFRMD_WITH_MISSING_INFO:
        case PRFRMD_WITH_ADDITIONAL_EFS_READ:
        case PRFRMD_ICON_NOT_DISPLAYED:
        case PRFRMD_MODIFIED_BY_NAA:
        case PRFRMD_LIMITED_SERVICE:
        case PRFRMD_WITH_MODIFICATION:
        case PRFRMD_NAA_NOT_ACTIVE:
        case PRFRMD_TONE_NOT_PLAYED:
            switch (AppInterface.CommandType.fromInt(cmdDet.typeOfCommand)) {
            case SET_UP_MENU:
                helpRequired = resMsg.resCode == ResultCode.HELP_INFO_REQUIRED;
                sendMenuSelection(resMsg.usersMenuSelection, helpRequired);
                return;
            case SELECT_ITEM:
                resp = new SelectItemResponseData(resMsg.usersMenuSelection);
                break;
            case GET_INPUT:
            case GET_INKEY:
                Input input = mCurrntCmd.geInput();
                if (!input.yesNo) {
                    // when help is requested there is no need to send the text
                    // string object.
                    if (!helpRequired) {
                        resp = new GetInkeyInputResponseData(resMsg.usersInput,
                                input.ucs2, input.packed);
                    }
                } else {
                    resp = new GetInkeyInputResponseData(
                            resMsg.usersYesNoSelection);
                }
                break;
            case DISPLAY_TEXT:
            case LAUNCH_BROWSER:
                break;
            case SET_UP_CALL:
                mCmdIf.handleCallSetupRequestFromSim(resMsg.usersConfirm, null);
                // No need to send terminal response for SET UP CALL. The user's
                // confirmation result is send back using a dedicated ril message
                // invoked by the CommandInterface call above.
                mCurrntCmd = null;
                return;
            }
            break;
        case NO_RESPONSE_FROM_USER:
        case UICC_SESSION_TERM_BY_USER:
        case BACKWARD_MOVE_BY_USER:
            resp = null;
            break;
        default:
            return;
        }
        sendTerminalResponse(cmdDet, resMsg.resCode, false, 0, resp);
        mCurrntCmd = null;
    }
}

