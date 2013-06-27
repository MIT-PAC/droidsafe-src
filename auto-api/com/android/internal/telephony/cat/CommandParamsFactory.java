package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccFileHandler;
import java.util.Iterator;
import java.util.List;

class CommandParamsFactory extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.242 -0400", hash_original_field = "10B237369439DE6AB484E8A6DD54A69C", hash_generated_field = "066A6762D0C2A5B772EAA58E81EAA0D0")

    private IconLoader mIconLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.242 -0400", hash_original_field = "6D5B91F83FB91B54278560BE96826869", hash_generated_field = "70CAC59D17D3D0BA6E05827D916BDA7A")

    private CommandParams mCmdParams = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.242 -0400", hash_original_field = "2EC1C70BEA068846D2DD4DD6524EB7C3", hash_generated_field = "BCA982B96F91D9BC42753272B3011D5D")

    private int mIconLoadState = LOAD_NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.242 -0400", hash_original_field = "F61832AE4199B01FFC1C38C9632A67D4", hash_generated_field = "14B912560D20DD60BB608B0ED44E164A")

    private RilMessageDecoder mCaller = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.244 -0400", hash_original_method = "7BCA60CE4AA4C3E7854AB72DFCEE5CF9", hash_generated_method = "58DF729E5AC1C5DFA0BE2B31CFDA387B")
    private  CommandParamsFactory(RilMessageDecoder caller, IccFileHandler fh) {
        mCaller = caller;
        mIconLoader = IconLoader.getInstance(this, fh);
        // ---------- Original Method ----------
        //mCaller = caller;
        //mIconLoader = IconLoader.getInstance(this, fh);
    }

    
        static synchronized CommandParamsFactory getInstance(RilMessageDecoder caller,
            IccFileHandler fh) {
        if (sInstance != null) {
            return sInstance;
        }
        if (fh != null) {
            return new CommandParamsFactory(caller, fh);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.253 -0400", hash_original_method = "2E4478F23D166A2E5E35D0CD5C4A129E", hash_generated_method = "36B5CCAF54333F494DA254954EB45EB3")
    private CommandDetails processCommandDetails(List<ComprehensionTlv> ctlvs) {
        CommandDetails varB4EAC82CA7396A68D541C85D26508E83_649734517 = null; //Variable for return #1
        CommandDetails cmdDet;
        cmdDet = null;
        {
            ComprehensionTlv ctlvCmdDet;
            ctlvCmdDet = searchForTag(
                    ComprehensionTlvTag.COMMAND_DETAILS, ctlvs);
            {
                try 
                {
                    cmdDet = ValueParser.retrieveCommandDetails(ctlvCmdDet);
                } //End block
                catch (ResultException e)
                {
                    CatLog.d(this, "Failed to procees command details");
                } //End block
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_649734517 = cmdDet;
        addTaint(ctlvs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_649734517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649734517;
        // ---------- Original Method ----------
        //CommandDetails cmdDet = null;
        //if (ctlvs != null) {
            //ComprehensionTlv ctlvCmdDet = searchForTag(
                    //ComprehensionTlvTag.COMMAND_DETAILS, ctlvs);
            //if (ctlvCmdDet != null) {
                //try {
                    //cmdDet = ValueParser.retrieveCommandDetails(ctlvCmdDet);
                //} catch (ResultException e) {
                    //CatLog.d(this, "Failed to procees command details");
                //}
            //}
        //}
        //return cmdDet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.263 -0400", hash_original_method = "1AA16ED3503C2EABAE519A247570B4D1", hash_generated_method = "6E201488A15EE053FA211F44F40C693B")
     void make(BerTlv berTlv) {
        mCmdParams = null;
        mIconLoadState = LOAD_NO_ICON;
        {
            boolean varDEE29F504DEACF8D3E8405B472C2921F_1499885694 = (berTlv.getTag() != BerTlv.BER_PROACTIVE_COMMAND_TAG);
            {
                sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
            } //End block
        } //End collapsed parenthetic
        boolean cmdPending;
        cmdPending = false;
        List<ComprehensionTlv> ctlvs;
        ctlvs = berTlv.getComprehensionTlvs();
        CommandDetails cmdDet;
        cmdDet = processCommandDetails(ctlvs);
        {
            sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
        } //End block
        AppInterface.CommandType cmdType;
        cmdType = AppInterface.CommandType
                .fromInt(cmdDet.typeOfCommand);
        {
            mCmdParams = new CommandParams(cmdDet);
            sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
        } //End block
        try 
        {
            //Begin case SET_UP_MENU 
            cmdPending = processSelectItem(cmdDet, ctlvs);
            //End case SET_UP_MENU 
            //Begin case SELECT_ITEM 
            cmdPending = processSelectItem(cmdDet, ctlvs);
            //End case SELECT_ITEM 
            //Begin case DISPLAY_TEXT 
            cmdPending = processDisplayText(cmdDet, ctlvs);
            //End case DISPLAY_TEXT 
            //Begin case SET_UP_IDLE_MODE_TEXT 
            cmdPending = processSetUpIdleModeText(cmdDet, ctlvs);
            //End case SET_UP_IDLE_MODE_TEXT 
            //Begin case GET_INKEY 
            cmdPending = processGetInkey(cmdDet, ctlvs);
            //End case GET_INKEY 
            //Begin case GET_INPUT 
            cmdPending = processGetInput(cmdDet, ctlvs);
            //End case GET_INPUT 
            //Begin case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            cmdPending = processEventNotify(cmdDet, ctlvs);
            //End case SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            //Begin case SET_UP_CALL 
            cmdPending = processSetupCall(cmdDet, ctlvs);
            //End case SET_UP_CALL 
            //Begin case REFRESH 
            processRefresh(cmdDet, ctlvs);
            //End case REFRESH 
            //Begin case REFRESH 
            cmdPending = false;
            //End case REFRESH 
            //Begin case LAUNCH_BROWSER 
            cmdPending = processLaunchBrowser(cmdDet, ctlvs);
            //End case LAUNCH_BROWSER 
            //Begin case PLAY_TONE 
            cmdPending = processPlayTone(cmdDet, ctlvs);
            //End case PLAY_TONE 
            //Begin case PROVIDE_LOCAL_INFORMATION 
            cmdPending = processProvideLocalInfo(cmdDet, ctlvs);
            //End case PROVIDE_LOCAL_INFORMATION 
            //Begin case default 
            mCmdParams = new CommandParams(cmdDet);
            //End case default 
            //Begin case default 
            sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
            //End case default 
        } //End block
        catch (ResultException e)
        {
            mCmdParams = new CommandParams(cmdDet);
            sendCmdParams(e.result());
        } //End block
        {
            sendCmdParams(ResultCode.OK);
        } //End block
        addTaint(berTlv.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.264 -0400", hash_original_method = "31E304CCF35AF359465BB09182AC4380", hash_generated_method = "C37ED711937EC74C1BB4D83E5259DA68")
    @Override
    public void handleMessage(Message msg) {
        //Begin case MSG_ID_LOAD_ICON_DONE 
        sendCmdParams(setIcons(msg.obj));
        //End case MSG_ID_LOAD_ICON_DONE 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //switch (msg.what) {
        //case MSG_ID_LOAD_ICON_DONE:
            //sendCmdParams(setIcons(msg.obj));
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.303 -0400", hash_original_method = "3AB391E8251356D82C52829EE4B32ED7", hash_generated_method = "395E23537C8EF745B6B05E93B6C83BC1")
    private ResultCode setIcons(Object data) {
        ResultCode varB4EAC82CA7396A68D541C85D26508E83_225006967 = null; //Variable for return #1
        ResultCode varB4EAC82CA7396A68D541C85D26508E83_1064456411 = null; //Variable for return #2
        Bitmap[] icons;
        icons = null;
        int iconIndex;
        iconIndex = 0;
        {
            varB4EAC82CA7396A68D541C85D26508E83_225006967 = ResultCode.PRFRMD_ICON_NOT_DISPLAYED;
        } //End block
        //Begin case LOAD_SINGLE_ICON 
        mCmdParams.setIcon((Bitmap) data);
        //End case LOAD_SINGLE_ICON 
        //Begin case LOAD_MULTI_ICONS 
        icons = (Bitmap[]) data;
        //End case LOAD_MULTI_ICONS 
        //Begin case LOAD_MULTI_ICONS 
        {
            Bitmap icon = icons[0];
            {
                mCmdParams.setIcon(icon);
            } //End block
        } //End collapsed parenthetic
        //End case LOAD_MULTI_ICONS 
        varB4EAC82CA7396A68D541C85D26508E83_1064456411 = ResultCode.OK;
        addTaint(data.getTaint());
        ResultCode varA7E53CE21691AB073D9660D615818899_1461702244; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1461702244 = varB4EAC82CA7396A68D541C85D26508E83_225006967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1461702244 = varB4EAC82CA7396A68D541C85D26508E83_1064456411;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1461702244.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1461702244;
        // ---------- Original Method ----------
        //Bitmap[] icons = null;
        //int iconIndex = 0;
        //if (data == null) {
            //return ResultCode.PRFRMD_ICON_NOT_DISPLAYED;
        //}
        //switch(mIconLoadState) {
        //case LOAD_SINGLE_ICON:
            //mCmdParams.setIcon((Bitmap) data);
            //break;
        //case LOAD_MULTI_ICONS:
            //icons = (Bitmap[]) data;
            //for (Bitmap icon : icons) {
                //mCmdParams.setIcon(icon);
            //}
            //break;
        //}
        //return ResultCode.OK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.314 -0400", hash_original_method = "075D6D54A772D277DACB0A1749F22220", hash_generated_method = "C9FD6C92BFBCDD2999BD5776C3EAE1DC")
    private void sendCmdParams(ResultCode resCode) {
        mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
        addTaint(resCode.getTaint());
        // ---------- Original Method ----------
        //mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.319 -0400", hash_original_method = "747AFE004560A767DF481C3AA8002660", hash_generated_method = "53C73859CE3DE5A11F29169194D73543")
    private ComprehensionTlv searchForTag(ComprehensionTlvTag tag,
            List<ComprehensionTlv> ctlvs) {
        ComprehensionTlv varB4EAC82CA7396A68D541C85D26508E83_1389342424 = null; //Variable for return #1
        Iterator<ComprehensionTlv> iter;
        iter = ctlvs.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1389342424 = searchForNextTag(tag, iter);
        addTaint(tag.getTaint());
        addTaint(ctlvs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1389342424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389342424;
        // ---------- Original Method ----------
        //Iterator<ComprehensionTlv> iter = ctlvs.iterator();
        //return searchForNextTag(tag, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.319 -0400", hash_original_method = "D88B588A55F67F23980463DF8FB0DA04", hash_generated_method = "45E4A83A61A5FAD538DD43879A2C005B")
    private ComprehensionTlv searchForNextTag(ComprehensionTlvTag tag,
            Iterator<ComprehensionTlv> iter) {
        ComprehensionTlv varB4EAC82CA7396A68D541C85D26508E83_1547439604 = null; //Variable for return #1
        ComprehensionTlv varB4EAC82CA7396A68D541C85D26508E83_1070666025 = null; //Variable for return #2
        int tagValue;
        tagValue = tag.value();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_681613678 = (iter.hasNext());
            {
                ComprehensionTlv ctlv;
                ctlv = iter.next();
                {
                    boolean var6D1ED3DBC0A231E0CFE6119240CEE6F9_1448696190 = (ctlv.getTag() == tagValue);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1547439604 = ctlv;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1070666025 = null;
        addTaint(tag.getTaint());
        addTaint(iter.getTaint());
        ComprehensionTlv varA7E53CE21691AB073D9660D615818899_602146345; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_602146345 = varB4EAC82CA7396A68D541C85D26508E83_1547439604;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_602146345 = varB4EAC82CA7396A68D541C85D26508E83_1070666025;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_602146345.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_602146345;
        // ---------- Original Method ----------
        //int tagValue = tag.value();
        //while (iter.hasNext()) {
            //ComprehensionTlv ctlv = iter.next();
            //if (ctlv.getTag() == tagValue) {
                //return ctlv;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.326 -0400", hash_original_method = "7E1C347C9C4DEE22923C4A46BE429D13", hash_generated_method = "52EBC2481F441256119A9700D895C05F")
    private boolean processDisplayText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process DisplayText");
        TextMessage textMsg;
        textMsg = new TextMessage();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        {
            textMsg.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.IMMEDIATE_RESPONSE, ctlvs);
        {
            textMsg.responseNeeded = false;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        {
            textMsg.duration = ValueParser.retrieveDuration(ctlv);
        } //End block
        textMsg.isHighPriority = (cmdDet.commandQualifier & 0x01) != 0;
        textMsg.userClear = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997846342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997846342;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.335 -0400", hash_original_method = "7C3BADEB42DA2C878C6C5ABCBE524429", hash_generated_method = "DC459F345515BCC54963656C9E51E107")
    private boolean processSetUpIdleModeText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process SetUpIdleModeText");
        TextMessage textMsg;
        textMsg = new TextMessage();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        {
            textMsg.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        {
            ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
            {
                iconId = ValueParser.retrieveIconId(ctlv);
                textMsg.iconSelfExplanatory = iconId.selfExplanatory;
            } //End block
        } //End block
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_458584365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_458584365;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.336 -0400", hash_original_method = "025DF7E231D7740FB891A823A7EE822B", hash_generated_method = "B53CD7FD71556AA6D95DA4D7927CD660")
    private boolean processGetInkey(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process GetInkey");
        Input input;
        input = new Input();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        {
            input.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        {
            input.duration = ValueParser.retrieveDuration(ctlv);
        } //End block
        input.minLen = 1;
        input.maxLen = 1;
        input.digitOnly = (cmdDet.commandQualifier & 0x01) == 0;
        input.ucs2 = (cmdDet.commandQualifier & 0x02) != 0;
        input.yesNo = (cmdDet.commandQualifier & 0x04) != 0;
        input.helpAvailable = (cmdDet.commandQualifier & 0x80) != 0;
        input.echo = true;
        mCmdParams = new GetInputParams(cmdDet, input);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341490749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341490749;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.363 -0400", hash_original_method = "03663C70D425FF89FCC6E89BA931B637", hash_generated_method = "245C11733D07AE806D967A7842DDEDA4")
    private boolean processGetInput(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process GetInput");
        Input input;
        input = new Input();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        {
            input.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.RESPONSE_LENGTH, ctlvs);
        {
            try 
            {
                byte[] rawValue;
                rawValue = ctlv.getRawValue();
                int valueIndex;
                valueIndex = ctlv.getValueIndex();
                input.minLen = rawValue[valueIndex] & 0xff;
                input.maxLen = rawValue[valueIndex + 1] & 0xff;
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DEFAULT_TEXT, ctlvs);
        {
            input.defaultText = ValueParser.retrieveTextString(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
        } //End block
        input.digitOnly = (cmdDet.commandQualifier & 0x01) == 0;
        input.ucs2 = (cmdDet.commandQualifier & 0x02) != 0;
        input.echo = (cmdDet.commandQualifier & 0x04) == 0;
        input.packed = (cmdDet.commandQualifier & 0x08) != 0;
        input.helpAvailable = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new GetInputParams(cmdDet, input);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155495787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155495787;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.364 -0400", hash_original_method = "328C209D553235E9687156E0E720555C", hash_generated_method = "99DE17D97AF6FFDF1F0124B9F8D2D454")
    private boolean processRefresh(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        CatLog.d(this, "process Refresh");
        //Begin case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE REFRESH_NAA_INIT_AND_FILE_CHANGE REFRESH_NAA_INIT REFRESH_UICC_RESET 
        mCmdParams = new DisplayTextParams(cmdDet, null);
        //End case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE REFRESH_NAA_INIT_AND_FILE_CHANGE REFRESH_NAA_INIT REFRESH_UICC_RESET 
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979158485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979158485;
        // ---------- Original Method ----------
        //CatLog.d(this, "process Refresh");
        //switch (cmdDet.commandQualifier) {
        //case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE:
        //case REFRESH_NAA_INIT_AND_FILE_CHANGE:
        //case REFRESH_NAA_INIT:
        //case REFRESH_UICC_RESET:
            //mCmdParams = new DisplayTextParams(cmdDet, null);
            //break;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.366 -0400", hash_original_method = "BCD1A4E1E4B160F1064A009F1000860C", hash_generated_method = "FCDBCFBB0B9E675A003E594DBBA231AA")
    private boolean processSelectItem(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process SelectItem");
        Menu menu;
        menu = new Menu();
        IconId titleIconId;
        titleIconId = null;
        ItemsIconId itemsIconId;
        itemsIconId = null;
        Iterator<ComprehensionTlv> iter;
        iter = ctlvs.iterator();
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID,
                ctlvs);
        {
            menu.title = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        {
            ctlv = searchForNextTag(ComprehensionTlvTag.ITEM, iter);
            {
                menu.items.add(ValueParser.retrieveItem(ctlv));
            } //End block
        } //End block
        {
            boolean varAE5D498766CFF06FB57D1173A501E0FB_1987057015 = (menu.items.size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            } //End block
        } //End collapsed parenthetic
        ctlv = searchForTag(ComprehensionTlvTag.ITEM_ID, ctlvs);
        {
            menu.defaultItem = ValueParser.retrieveItemId(ctlv) - 1;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            titleIconId = ValueParser.retrieveIconId(ctlv);
            menu.titleIconSelfExplanatory = titleIconId.selfExplanatory;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ITEM_ICON_ID_LIST, ctlvs);
        {
            mIconLoadState = LOAD_MULTI_ICONS;
            itemsIconId = ValueParser.retrieveItemsIconId(ctlv);
            menu.itemsIconSelfExplanatory = itemsIconId.selfExplanatory;
        } //End block
        boolean presentTypeSpecified;
        presentTypeSpecified = (cmdDet.commandQualifier & 0x01) != 0;
        {
            {
                menu.presentationType = PresentationType.DATA_VALUES;
            } //End block
            {
                menu.presentationType = PresentationType.NAVIGATION_OPTIONS;
            } //End block
        } //End block
        menu.softKeyPreferred = (cmdDet.commandQualifier & 0x04) != 0;
        menu.helpAvailable = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new SelectItemParams(cmdDet, menu, titleIconId != null);
        //Begin case LOAD_SINGLE_ICON 
        mIconLoader.loadIcon(titleIconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        //End case LOAD_SINGLE_ICON 
        //Begin case LOAD_MULTI_ICONS 
        int[] recordNumbers;
        recordNumbers = itemsIconId.recordNumbers;
        //End case LOAD_MULTI_ICONS 
        //Begin case LOAD_MULTI_ICONS 
        {
            recordNumbers = new int[itemsIconId.recordNumbers.length + 1];
            recordNumbers[0] = titleIconId.recordNumber;
            System.arraycopy(itemsIconId.recordNumbers, 0, recordNumbers,
                        1, itemsIconId.recordNumbers.length);
        } //End block
        //End case LOAD_MULTI_ICONS 
        //Begin case LOAD_MULTI_ICONS 
        mIconLoader.loadIcons(recordNumbers, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        //End case LOAD_MULTI_ICONS 
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191515807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191515807;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.380 -0400", hash_original_method = "A40BEAAD1582CC67F32BB145B8ABDE84", hash_generated_method = "CE6D45C9D7C94BB96BA30C400ADA9DC5")
    private boolean processEventNotify(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process EventNotify");
        TextMessage textMsg;
        textMsg = new TextMessage();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID,
                ctlvs);
        textMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        textMsg.responseNeeded = false;
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639052429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639052429;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.381 -0400", hash_original_method = "C7EE76D8654D8C691124AB97A0520EED", hash_generated_method = "A0AAB2CA774A8FC12DA96590657E8DA4")
    private boolean processSetUpEventList(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        CatLog.d(this, "process SetUpEventList");
        addTaint(cmdDet.getTaint());
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826230226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826230226;
        // ---------- Original Method ----------
        //CatLog.d(this, "process SetUpEventList");
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.382 -0400", hash_original_method = "8945EEF95EF30DB6F3AC6F2F65AD50C7", hash_generated_method = "797FCC9A6B8895DA5E55A10AE7495CEB")
    private boolean processLaunchBrowser(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process LaunchBrowser");
        TextMessage confirmMsg;
        confirmMsg = new TextMessage();
        IconId iconId;
        iconId = null;
        String url;
        url = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.URL, ctlvs);
        {
            try 
            {
                byte[] rawValue;
                rawValue = ctlv.getRawValue();
                int valueIndex;
                valueIndex = ctlv.getValueIndex();
                int valueLen;
                valueLen = ctlv.getLength();
                {
                    url = GsmAlphabet.gsm8BitUnpackedToString(rawValue,
                            valueIndex, valueLen);
                } //End block
                {
                    url = null;
                } //End block
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            } //End block
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, ctlvs);
        confirmMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            confirmMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        LaunchBrowserMode mode;
        //Begin case 0x00 default 
        mode = LaunchBrowserMode.LAUNCH_IF_NOT_ALREADY_LAUNCHED;
        //End case 0x00 default 
        //Begin case 0x02 
        mode = LaunchBrowserMode.USE_EXISTING_BROWSER;
        //End case 0x02 
        //Begin case 0x03 
        mode = LaunchBrowserMode.LAUNCH_NEW_BROWSER;
        //End case 0x03 
        mCmdParams = new LaunchBrowserParams(cmdDet, confirmMsg, url, mode);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731942100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731942100;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.389 -0400", hash_original_method = "9E25ADC04DC19743F5D672C3FA9262A8", hash_generated_method = "1384CABFAB0E3A874FE4D6F32AEA8ECD")
    private boolean processPlayTone(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process PlayTone");
        Tone tone;
        tone = null;
        TextMessage textMsg;
        textMsg = new TextMessage();
        Duration duration;
        duration = null;
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = searchForTag(ComprehensionTlvTag.TONE, ctlvs);
        {
            {
                boolean var474268E675612C4353368685B55E93EB_1057382884 = (ctlv.getLength() > 0);
                {
                    try 
                    {
                        byte[] rawValue;
                        rawValue = ctlv.getRawValue();
                        int valueIndex;
                        valueIndex = ctlv.getValueIndex();
                        int toneVal;
                        toneVal = rawValue[valueIndex];
                        tone = Tone.fromInt(toneVal);
                    } //End block
                    catch (IndexOutOfBoundsException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, ctlvs);
        {
            textMsg.text = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        {
            duration = ValueParser.retrieveDuration(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        boolean vibrate;
        vibrate = (cmdDet.commandQualifier & 0x01) != 0x00;
        textMsg.responseNeeded = false;
        mCmdParams = new PlayToneParams(cmdDet, textMsg, tone, duration, vibrate);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719465311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719465311;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.402 -0400", hash_original_method = "1675CA7AE4DACD4909A19602008CCD7F", hash_generated_method = "35E6F888050310BA74C3E08DC25781E3")
    private boolean processSetupCall(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process SetupCall");
        Iterator<ComprehensionTlv> iter;
        iter = ctlvs.iterator();
        ComprehensionTlv ctlv;
        ctlv = null;
        TextMessage confirmMsg;
        confirmMsg = new TextMessage();
        TextMessage callMsg;
        callMsg = new TextMessage();
        IconId confirmIconId;
        confirmIconId = null;
        IconId callIconId;
        callIconId = null;
        ctlv = searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iter);
        confirmMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            confirmIconId = ValueParser.retrieveIconId(ctlv);
            confirmMsg.iconSelfExplanatory = confirmIconId.selfExplanatory;
        } //End block
        ctlv = searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iter);
        {
            callMsg.text = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            callIconId = ValueParser.retrieveIconId(ctlv);
            callMsg.iconSelfExplanatory = callIconId.selfExplanatory;
        } //End block
        mCmdParams = new CallSetupParams(cmdDet, confirmMsg, callMsg);
        {
            mIconLoadState = LOAD_MULTI_ICONS;
            int[] recordNumbers;
            recordNumbers = new int[2];
            recordNumbers[0] = confirmIconId != null
                    ? confirmIconId.recordNumber : -1;
            recordNumbers[1] = callIconId != null ? callIconId.recordNumber
                    : -1;
            mIconLoader.loadIcons(recordNumbers, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302002850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302002850;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_method = "A94C1A7A0EB7DC9619C535A1C0085435", hash_generated_method = "AFC8B2F2DCAD663F89FE81DB79D3C264")
    private boolean processProvideLocalInfo(CommandDetails cmdDet, List<ComprehensionTlv> ctlvs) throws ResultException {
        CatLog.d(this, "process ProvideLocalInfo");
        //Begin case DTTZ_SETTING 
        CatLog.d(this, "PLI [DTTZ_SETTING]");
        //End case DTTZ_SETTING 
        //Begin case DTTZ_SETTING 
        mCmdParams = new CommandParams(cmdDet);
        //End case DTTZ_SETTING 
        //Begin case LANGUAGE_SETTING 
        CatLog.d(this, "PLI [LANGUAGE_SETTING]");
        //End case LANGUAGE_SETTING 
        //Begin case LANGUAGE_SETTING 
        mCmdParams = new CommandParams(cmdDet);
        //End case LANGUAGE_SETTING 
        //Begin case default 
        CatLog.d(this, "PLI[" + cmdDet.commandQualifier + "] Command Not Supported");
        //End case default 
        //Begin case default 
        mCmdParams = new CommandParams(cmdDet);
        //End case default 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new ResultException(ResultCode.BEYOND_TERMINAL_CAPABILITY);
        //End case default 
        addTaint(ctlvs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325150923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325150923;
        // ---------- Original Method ----------
        //CatLog.d(this, "process ProvideLocalInfo");
        //switch (cmdDet.commandQualifier) {
            //case DTTZ_SETTING:
                //CatLog.d(this, "PLI [DTTZ_SETTING]");
                //mCmdParams = new CommandParams(cmdDet);
                //break;
            //case LANGUAGE_SETTING:
                //CatLog.d(this, "PLI [LANGUAGE_SETTING]");
                //mCmdParams = new CommandParams(cmdDet);
                //break;
            //default:
                //CatLog.d(this, "PLI[" + cmdDet.commandQualifier + "] Command Not Supported");
                //mCmdParams = new CommandParams(cmdDet);
                //throw new ResultException(ResultCode.BEYOND_TERMINAL_CAPABILITY);
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "A02E695433658795D44A91F9AE9E9D68")

    private static CommandParamsFactory sInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "F06FC8D30143C69FD9E3180EB141CFD6", hash_generated_field = "6BA990F35996A535FB0D183372D34DBF")

    static int MSG_ID_LOAD_ICON_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "2BCC173F891239A5A8576F2AEC0B91A0", hash_generated_field = "A11440B84734D826277EEBFBEF670160")

    static int LOAD_NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "A57771E5C7F2CE97D71E159649709634", hash_generated_field = "6715247E872F8550D75B9D87CA4D7AB8")

    static int LOAD_SINGLE_ICON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "900BD676D0EFA2244326DDA407C01CF9", hash_generated_field = "43266D4FC9DFEF411BE2490370084FDA")

    static int LOAD_MULTI_ICONS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "2FAA3391556637CDCAED99C9E616C7C0", hash_generated_field = "7F970340E87821B99A31F344EE5F8AFD")

    static int REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "699D69C7B5F124C6D3F7F032DB01A49C", hash_generated_field = "14B4063B977BE3B04E5076C262FD2866")

    static int REFRESH_NAA_INIT_AND_FILE_CHANGE = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "0DA0EEC5D7E4FD4199ABD57860E04B02", hash_generated_field = "2629C1699ACD4B7C4AFE6DAF2BC29B8D")

    static int REFRESH_NAA_INIT = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "9884D2460CE792B1DEC3C6893B0BC27C", hash_generated_field = "8979A7075279E503B40360F81675AA17")

    static int REFRESH_UICC_RESET = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "CD5701BD2A2C97379C4A10266493FC0C", hash_generated_field = "FE22C9517B34BC0313C8BAB059AC34EE")

    static int DTTZ_SETTING = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.409 -0400", hash_original_field = "B86AE44C2E0468CA3371EBAA7E72DB95", hash_generated_field = "05B04A0F9DB5F8BA5184DC0018961A1D")

    static int LANGUAGE_SETTING = 0x04;
}

