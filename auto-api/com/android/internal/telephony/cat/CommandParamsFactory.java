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
    private IconLoader mIconLoader;
    private CommandParams mCmdParams = null;
    private int mIconLoadState = LOAD_NO_ICON;
    private RilMessageDecoder mCaller = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.852 -0400", hash_original_method = "7BCA60CE4AA4C3E7854AB72DFCEE5CF9", hash_generated_method = "5F794E89175F96977DE574BDC494165B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CommandParamsFactory(RilMessageDecoder caller, IccFileHandler fh) {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(fh.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.853 -0400", hash_original_method = "2E4478F23D166A2E5E35D0CD5C4A129E", hash_generated_method = "3AC0BEEDB84928E98B70B507D0597287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CommandDetails processCommandDetails(List<ComprehensionTlv> ctlvs) {
        dsTaint.addTaint(ctlvs.dsTaint);
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
        return (CommandDetails)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.853 -0400", hash_original_method = "2A81A2B758F59F5E5B56A3715437E583", hash_generated_method = "B1C728A7C3200D34B5F5A4AF84A1AA89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void make(BerTlv berTlv) {
        dsTaint.addTaint(berTlv.dsTaint);
        mCmdParams = null;
        mIconLoadState = LOAD_NO_ICON;
        {
            boolean varDEE29F504DEACF8D3E8405B472C2921F_2136200265 = (berTlv.getTag() != BerTlv.BER_PROACTIVE_COMMAND_TAG);
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
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            cmdPending = processBIPClient(cmdDet, ctlvs);
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.854 -0400", hash_original_method = "31E304CCF35AF359465BB09182AC4380", hash_generated_method = "E3DECC503015FE1A1E0B7B840506F134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case MSG_ID_LOAD_ICON_DONE 
        sendCmdParams(setIcons(msg.obj));
        //End case MSG_ID_LOAD_ICON_DONE 
        // ---------- Original Method ----------
        //switch (msg.what) {
        //case MSG_ID_LOAD_ICON_DONE:
            //sendCmdParams(setIcons(msg.obj));
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.858 -0400", hash_original_method = "3AB391E8251356D82C52829EE4B32ED7", hash_generated_method = "FB9D0F92BF330927C8C68469DEA62B7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ResultCode setIcons(Object data) {
        dsTaint.addTaint(data.dsTaint);
        Bitmap[] icons;
        icons = null;
        int iconIndex;
        iconIndex = 0;
        //Begin case LOAD_SINGLE_ICON 
        mCmdParams.setIcon((Bitmap) data);
        //End case LOAD_SINGLE_ICON 
        //Begin case LOAD_MULTI_ICONS 
        icons = (Bitmap[]) data;
        //End case LOAD_MULTI_ICONS 
        //Begin case LOAD_MULTI_ICONS 
        {
            Iterator<Bitmap> var50610057585CADFE38834953CAA22540_903949017 = (icons).iterator();
            var50610057585CADFE38834953CAA22540_903949017.hasNext();
            Bitmap icon = var50610057585CADFE38834953CAA22540_903949017.next();
            {
                mCmdParams.setIcon(icon);
            } //End block
        } //End collapsed parenthetic
        //End case LOAD_MULTI_ICONS 
        return (ResultCode)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.858 -0400", hash_original_method = "075D6D54A772D277DACB0A1749F22220", hash_generated_method = "0E07016EF3D0D5DE6CDC5695697BAC01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCmdParams(ResultCode resCode) {
        dsTaint.addTaint(resCode.dsTaint);
        mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
        // ---------- Original Method ----------
        //mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.858 -0400", hash_original_method = "747AFE004560A767DF481C3AA8002660", hash_generated_method = "509947BA644532270C73E1D673DC14B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ComprehensionTlv searchForTag(ComprehensionTlvTag tag,
            List<ComprehensionTlv> ctlvs) {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(tag.dsTaint);
        Iterator<ComprehensionTlv> iter;
        iter = ctlvs.iterator();
        ComprehensionTlv varA93430CB44F5735F27A8B8FCE5790AD6_1005636393 = (searchForNextTag(tag, iter));
        return (ComprehensionTlv)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Iterator<ComprehensionTlv> iter = ctlvs.iterator();
        //return searchForNextTag(tag, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.859 -0400", hash_original_method = "D88B588A55F67F23980463DF8FB0DA04", hash_generated_method = "58F540CB87DD4E49EB161A729794A869")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ComprehensionTlv searchForNextTag(ComprehensionTlvTag tag,
            Iterator<ComprehensionTlv> iter) {
        dsTaint.addTaint(tag.dsTaint);
        dsTaint.addTaint(iter.dsTaint);
        int tagValue;
        tagValue = tag.value();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1799711462 = (iter.hasNext());
            {
                ComprehensionTlv ctlv;
                ctlv = iter.next();
                {
                    boolean var6D1ED3DBC0A231E0CFE6119240CEE6F9_2046977339 = (ctlv.getTag() == tagValue);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ComprehensionTlv)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.859 -0400", hash_original_method = "7E1C347C9C4DEE22923C4A46BE429D13", hash_generated_method = "EBFF2381F996895ACF661BF2678AB338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processDisplayText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.860 -0400", hash_original_method = "7C3BADEB42DA2C878C6C5ABCBE524429", hash_generated_method = "C0C0EC1E6ED2379C9F1E2ED36393A72C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processSetUpIdleModeText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.860 -0400", hash_original_method = "025DF7E231D7740FB891A823A7EE822B", hash_generated_method = "2AE00F7B1BC8B74FECCD3D8758CCE528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processGetInkey(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.861 -0400", hash_original_method = "03663C70D425FF89FCC6E89BA931B637", hash_generated_method = "2AC7DFC8E2FC6A71DC5B701AB9113457")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processGetInput(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.862 -0400", hash_original_method = "328C209D553235E9687156E0E720555C", hash_generated_method = "BA9992287831E9033428551D2C89A44C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processRefresh(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        CatLog.d(this, "process Refresh");
        //Begin case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE REFRESH_NAA_INIT_AND_FILE_CHANGE REFRESH_NAA_INIT REFRESH_UICC_RESET 
        mCmdParams = new DisplayTextParams(cmdDet, null);
        //End case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE REFRESH_NAA_INIT_AND_FILE_CHANGE REFRESH_NAA_INIT REFRESH_UICC_RESET 
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.862 -0400", hash_original_method = "BCD1A4E1E4B160F1064A009F1000860C", hash_generated_method = "704A61B60853C21B46520FE2CA5A8414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processSelectItem(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
            boolean varAE5D498766CFF06FB57D1173A501E0FB_1589956928 = (menu.items.size() == 0);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.864 -0400", hash_original_method = "A40BEAAD1582CC67F32BB145B8ABDE84", hash_generated_method = "E94AE381C3D2F81B139A26F839D9060C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processEventNotify(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.864 -0400", hash_original_method = "C7EE76D8654D8C691124AB97A0520EED", hash_generated_method = "F093D0E167503EACF6C47C09C5D15530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processSetUpEventList(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        CatLog.d(this, "process SetUpEventList");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CatLog.d(this, "process SetUpEventList");
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.865 -0400", hash_original_method = "8945EEF95EF30DB6F3AC6F2F65AD50C7", hash_generated_method = "7BCA0A920608F0A8FC81FAA5F1F53448")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processLaunchBrowser(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.866 -0400", hash_original_method = "9E25ADC04DC19743F5D672C3FA9262A8", hash_generated_method = "2BCAC9D67F99B4FB12584D2A4C2BE7C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processPlayTone(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
                boolean var474268E675612C4353368685B55E93EB_1305946570 = (ctlv.getLength() > 0);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.866 -0400", hash_original_method = "1675CA7AE4DACD4909A19602008CCD7F", hash_generated_method = "DF63511EBD5D3DBB597F8738F671219E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processSetupCall(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.867 -0400", hash_original_method = "A94C1A7A0EB7DC9619C535A1C0085435", hash_generated_method = "35B7CCC4B29A4CA1B647B45510373552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processProvideLocalInfo(CommandDetails cmdDet, List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.867 -0400", hash_original_method = "4613B38A8D553E22A78DE459C1D09801", hash_generated_method = "1793B02C9F729DDEC66E8FB27B795CAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processBIPClient(CommandDetails cmdDet,
                                     List<ComprehensionTlv> ctlvs) throws ResultException {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(cmdDet.dsTaint);
        AppInterface.CommandType commandType;
        commandType = AppInterface.CommandType.fromInt(cmdDet.typeOfCommand);
        {
            CatLog.d(this, "process "+ commandType.name());
        } //End block
        TextMessage textMsg;
        textMsg = new TextMessage();
        IconId iconId;
        iconId = null;
        ComprehensionTlv ctlv;
        ctlv = null;
        boolean has_alpha_id;
        has_alpha_id = false;
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, ctlvs);
        {
            textMsg.text = ValueParser.retrieveAlphaId(ctlv);
            CatLog.d(this, "alpha TLV text=" + textMsg.text);
            has_alpha_id = true;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        textMsg.responseNeeded = false;
        mCmdParams = new BIPClientParams(cmdDet, textMsg, has_alpha_id);
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this.obtainMessage(MSG_ID_LOAD_ICON_DONE));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static CommandParamsFactory sInstance = null;
    static final int MSG_ID_LOAD_ICON_DONE = 1;
    static final int LOAD_NO_ICON           = 0;
    static final int LOAD_SINGLE_ICON       = 1;
    static final int LOAD_MULTI_ICONS       = 2;
    static final int REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE  = 0x00;
    static final int REFRESH_NAA_INIT_AND_FILE_CHANGE       = 0x02;
    static final int REFRESH_NAA_INIT                       = 0x03;
    static final int REFRESH_UICC_RESET                     = 0x04;
    static final int DTTZ_SETTING                           = 0x03;
    static final int LANGUAGE_SETTING                       = 0x04;
}

