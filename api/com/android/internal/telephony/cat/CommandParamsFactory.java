package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Iterator;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccFileHandler;






class CommandParamsFactory extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.176 -0400", hash_original_field = "10B237369439DE6AB484E8A6DD54A69C", hash_generated_field = "066A6762D0C2A5B772EAA58E81EAA0D0")

    private IconLoader mIconLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.176 -0400", hash_original_field = "6D5B91F83FB91B54278560BE96826869", hash_generated_field = "70CAC59D17D3D0BA6E05827D916BDA7A")

    private CommandParams mCmdParams = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.176 -0400", hash_original_field = "2EC1C70BEA068846D2DD4DD6524EB7C3", hash_generated_field = "BCA982B96F91D9BC42753272B3011D5D")

    private int mIconLoadState = LOAD_NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.176 -0400", hash_original_field = "F61832AE4199B01FFC1C38C9632A67D4", hash_generated_field = "14B912560D20DD60BB608B0ED44E164A")

    private RilMessageDecoder mCaller = null;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.177 -0400", hash_original_method = "7BCA60CE4AA4C3E7854AB72DFCEE5CF9", hash_generated_method = "58DF729E5AC1C5DFA0BE2B31CFDA387B")
    private  CommandParamsFactory(RilMessageDecoder caller, IccFileHandler fh) {
        mCaller = caller;
        mIconLoader = IconLoader.getInstance(this, fh);
        // ---------- Original Method ----------
        //mCaller = caller;
        //mIconLoader = IconLoader.getInstance(this, fh);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.178 -0400", hash_original_method = "2E4478F23D166A2E5E35D0CD5C4A129E", hash_generated_method = "75638B1FAF93F0C2FFAF9F3652BB90A6")
    private CommandDetails processCommandDetails(List<ComprehensionTlv> ctlvs) {
        addTaint(ctlvs.getTaint());
        CommandDetails cmdDet = null;
        if(ctlvs != null)        
        {
            ComprehensionTlv ctlvCmdDet = searchForTag(
                    ComprehensionTlvTag.COMMAND_DETAILS, ctlvs);
            if(ctlvCmdDet != null)            
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
CommandDetails var0060BCF683BA9945E92A4949C9036F93_1839794921 =         cmdDet;
        var0060BCF683BA9945E92A4949C9036F93_1839794921.addTaint(taint);
        return var0060BCF683BA9945E92A4949C9036F93_1839794921;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.181 -0400", hash_original_method = "1AA16ED3503C2EABAE519A247570B4D1", hash_generated_method = "59514A66DC7442AA276944158CF7B24C")
     void make(BerTlv berTlv) {
        addTaint(berTlv.getTaint());
        if(berTlv == null)        
        {
            return;
        } //End block
        mCmdParams = null;
        mIconLoadState = LOAD_NO_ICON;
        if(berTlv.getTag() != BerTlv.BER_PROACTIVE_COMMAND_TAG)        
        {
            sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
            return;
        } //End block
        boolean cmdPending = false;
        List<ComprehensionTlv> ctlvs = berTlv.getComprehensionTlvs();
        CommandDetails cmdDet = processCommandDetails(ctlvs);
        if(cmdDet == null)        
        {
            sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
            return;
        } //End block
        AppInterface.CommandType cmdType = AppInterface.CommandType
                .fromInt(cmdDet.typeOfCommand);
        if(cmdType == null)        
        {
            mCmdParams = new CommandParams(cmdDet);
            sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
            return;
        } //End block
        try 
        {
switch(cmdType){
            case SET_UP_MENU:
            cmdPending = processSelectItem(cmdDet, ctlvs);
            break;
            case SELECT_ITEM:
            cmdPending = processSelectItem(cmdDet, ctlvs);
            break;
            case DISPLAY_TEXT:
            cmdPending = processDisplayText(cmdDet, ctlvs);
            break;
            case SET_UP_IDLE_MODE_TEXT:
            cmdPending = processSetUpIdleModeText(cmdDet, ctlvs);
            break;
            case GET_INKEY:
            cmdPending = processGetInkey(cmdDet, ctlvs);
            break;
            case GET_INPUT:
            cmdPending = processGetInput(cmdDet, ctlvs);
            break;
            case SEND_DTMF:
            case SEND_SMS:
            case SEND_SS:
            case SEND_USSD:
            cmdPending = processEventNotify(cmdDet, ctlvs);
            break;
            case SET_UP_CALL:
            cmdPending = processSetupCall(cmdDet, ctlvs);
            break;
            case REFRESH:
            processRefresh(cmdDet, ctlvs);
            cmdPending = false;
            break;
            case LAUNCH_BROWSER:
            cmdPending = processLaunchBrowser(cmdDet, ctlvs);
            break;
            case PLAY_TONE:
            cmdPending = processPlayTone(cmdDet, ctlvs);
            break;
            case PROVIDE_LOCAL_INFORMATION:
            cmdPending = processProvideLocalInfo(cmdDet, ctlvs);
            break;
            default:
            mCmdParams = new CommandParams(cmdDet);
            sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
            return;
}
        } //End block
        catch (ResultException e)
        {
            mCmdParams = new CommandParams(cmdDet);
            sendCmdParams(e.result());
            return;
        } //End block
        if(!cmdPending)        
        {
            sendCmdParams(ResultCode.OK);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.183 -0400", hash_original_method = "31E304CCF35AF359465BB09182AC4380", hash_generated_method = "85C9C0986A22E8564EFA629B98F81B95")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case MSG_ID_LOAD_ICON_DONE:
        sendCmdParams(setIcons(msg.obj));
        break;
}
        // ---------- Original Method ----------
        //switch (msg.what) {
        //case MSG_ID_LOAD_ICON_DONE:
            //sendCmdParams(setIcons(msg.obj));
            //break;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.184 -0400", hash_original_method = "3AB391E8251356D82C52829EE4B32ED7", hash_generated_method = "B167FCD61A20B5CCBF8F3FCB1FF15484")
    private ResultCode setIcons(Object data) {
        addTaint(data.getTaint());
        Bitmap[] icons = null;
        int iconIndex = 0;
        if(data == null)        
        {
ResultCode var87EEAE495D4A3BC9CF91C0B3CBE766B8_2053254767 =             ResultCode.PRFRMD_ICON_NOT_DISPLAYED;
            var87EEAE495D4A3BC9CF91C0B3CBE766B8_2053254767.addTaint(taint);
            return var87EEAE495D4A3BC9CF91C0B3CBE766B8_2053254767;
        } //End block
switch(mIconLoadState){
        case LOAD_SINGLE_ICON:
        mCmdParams.setIcon((Bitmap) data);
        break;
        case LOAD_MULTI_ICONS:
        icons = (Bitmap[]) data;
for(Bitmap icon : icons)
        {
            mCmdParams.setIcon(icon);
        } //End block
        break;
}ResultCode var7FF95A55B911283F2CCD032C57FAC8EE_222479903 =         ResultCode.OK;
        var7FF95A55B911283F2CCD032C57FAC8EE_222479903.addTaint(taint);
        return var7FF95A55B911283F2CCD032C57FAC8EE_222479903;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.184 -0400", hash_original_method = "075D6D54A772D277DACB0A1749F22220", hash_generated_method = "890BBE601D7498292AA6CD8EF9E6D69E")
    private void sendCmdParams(ResultCode resCode) {
        addTaint(resCode.getTaint());
        mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
        // ---------- Original Method ----------
        //mCaller.sendMsgParamsDecoded(resCode, mCmdParams);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.185 -0400", hash_original_method = "747AFE004560A767DF481C3AA8002660", hash_generated_method = "11EB5DAE1FC5BD801B4F9147A779227A")
    private ComprehensionTlv searchForTag(ComprehensionTlvTag tag,
            List<ComprehensionTlv> ctlvs) {
        addTaint(ctlvs.getTaint());
        addTaint(tag.getTaint());
        Iterator<ComprehensionTlv> iter = ctlvs.iterator();
ComprehensionTlv var855E5E8990508B7B35052B665B493CE9_1088843787 =         searchForNextTag(tag, iter);
        var855E5E8990508B7B35052B665B493CE9_1088843787.addTaint(taint);
        return var855E5E8990508B7B35052B665B493CE9_1088843787;
        // ---------- Original Method ----------
        //Iterator<ComprehensionTlv> iter = ctlvs.iterator();
        //return searchForNextTag(tag, iter);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.185 -0400", hash_original_method = "D88B588A55F67F23980463DF8FB0DA04", hash_generated_method = "AFD5AA6E268640B3116AE0F8034BAB9E")
    private ComprehensionTlv searchForNextTag(ComprehensionTlvTag tag,
            Iterator<ComprehensionTlv> iter) {
        addTaint(iter.getTaint());
        addTaint(tag.getTaint());
        int tagValue = tag.value();
        while
(iter.hasNext())        
        {
            ComprehensionTlv ctlv = iter.next();
            if(ctlv.getTag() == tagValue)            
            {
ComprehensionTlv varD3767E0B0CB0AACF1A8FB652E179ED5D_1384096908 =                 ctlv;
                varD3767E0B0CB0AACF1A8FB652E179ED5D_1384096908.addTaint(taint);
                return varD3767E0B0CB0AACF1A8FB652E179ED5D_1384096908;
            } //End block
        } //End block
ComprehensionTlv var540C13E9E156B687226421B24F2DF178_4449078 =         null;
        var540C13E9E156B687226421B24F2DF178_4449078.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_4449078;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.186 -0400", hash_original_method = "7E1C347C9C4DEE22923C4A46BE429D13", hash_generated_method = "5B41F4DD05A60D8C4B407D4885308150")
    private boolean processDisplayText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process DisplayText");
        TextMessage textMsg = new TextMessage();
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        if(ctlv != null)        
        {
            textMsg.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        if(textMsg.text == null)        
        {
            ResultException var6E8D14BE611E67DFA023E650FC522377_1944665830 = new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            var6E8D14BE611E67DFA023E650FC522377_1944665830.addTaint(taint);
            throw var6E8D14BE611E67DFA023E650FC522377_1944665830;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.IMMEDIATE_RESPONSE, ctlvs);
        if(ctlv != null)        
        {
            textMsg.responseNeeded = false;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        if(ctlv != null)        
        {
            textMsg.duration = ValueParser.retrieveDuration(ctlv);
        } //End block
        textMsg.isHighPriority = (cmdDet.commandQualifier & 0x01) != 0;
        textMsg.userClear = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_381124562 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666135849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666135849;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1804330087 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1039954042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1039954042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.187 -0400", hash_original_method = "7C3BADEB42DA2C878C6C5ABCBE524429", hash_generated_method = "B1C474FD93E1EA18898CD02FB406E66B")
    private boolean processSetUpIdleModeText(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process SetUpIdleModeText");
        TextMessage textMsg = new TextMessage();
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        if(ctlv != null)        
        {
            textMsg.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        if(textMsg.text != null)        
        {
            ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
            if(ctlv != null)            
            {
                iconId = ValueParser.retrieveIconId(ctlv);
                textMsg.iconSelfExplanatory = iconId.selfExplanatory;
            } //End block
        } //End block
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_1976318401 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149181444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_149181444;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2062538941 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815191217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815191217;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.187 -0400", hash_original_method = "025DF7E231D7740FB891A823A7EE822B", hash_generated_method = "3F108E92E362D00F4564F885D1BA8FC9")
    private boolean processGetInkey(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process GetInkey");
        Input input = new Input();
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        if(ctlv != null)        
        {
            input.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        else
        {
            ResultException var6CA5E47869237D539D80DDEFF8BE49EC_804845597 = new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            var6CA5E47869237D539D80DDEFF8BE49EC_804845597.addTaint(taint);
            throw var6CA5E47869237D539D80DDEFF8BE49EC_804845597;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        if(ctlv != null)        
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
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_408117966 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640130879 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640130879;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1713778424 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644364305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644364305;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.189 -0400", hash_original_method = "03663C70D425FF89FCC6E89BA931B637", hash_generated_method = "3334509B062EECA538344E18E1E616EF")
    private boolean processGetInput(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process GetInput");
        Input input = new Input();
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.TEXT_STRING,
                ctlvs);
        if(ctlv != null)        
        {
            input.text = ValueParser.retrieveTextString(ctlv);
        } //End block
        else
        {
            ResultException var6CA5E47869237D539D80DDEFF8BE49EC_779730958 = new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            var6CA5E47869237D539D80DDEFF8BE49EC_779730958.addTaint(taint);
            throw var6CA5E47869237D539D80DDEFF8BE49EC_779730958;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.RESPONSE_LENGTH, ctlvs);
        if(ctlv != null)        
        {
            try 
            {
                byte[] rawValue = ctlv.getRawValue();
                int valueIndex = ctlv.getValueIndex();
                input.minLen = rawValue[valueIndex] & 0xff;
                input.maxLen = rawValue[valueIndex + 1] & 0xff;
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                ResultException var6E8D14BE611E67DFA023E650FC522377_132491035 = new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                var6E8D14BE611E67DFA023E650FC522377_132491035.addTaint(taint);
                throw var6E8D14BE611E67DFA023E650FC522377_132491035;
            } //End block
        } //End block
        else
        {
            ResultException var6CA5E47869237D539D80DDEFF8BE49EC_1758387973 = new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            var6CA5E47869237D539D80DDEFF8BE49EC_1758387973.addTaint(taint);
            throw var6CA5E47869237D539D80DDEFF8BE49EC_1758387973;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DEFAULT_TEXT, ctlvs);
        if(ctlv != null)        
        {
            input.defaultText = ValueParser.retrieveTextString(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
        } //End block
        input.digitOnly = (cmdDet.commandQualifier & 0x01) == 0;
        input.ucs2 = (cmdDet.commandQualifier & 0x02) != 0;
        input.echo = (cmdDet.commandQualifier & 0x04) == 0;
        input.packed = (cmdDet.commandQualifier & 0x08) != 0;
        input.helpAvailable = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new GetInputParams(cmdDet, input);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_1610407461 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95102328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_95102328;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1954474231 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715259569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715259569;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.189 -0400", hash_original_method = "328C209D553235E9687156E0E720555C", hash_generated_method = "3345BFC515AD85ED08FB2F66F9477D41")
    private boolean processRefresh(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process Refresh");
switch(cmdDet.commandQualifier){
        case REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE:
        case REFRESH_NAA_INIT_AND_FILE_CHANGE:
        case REFRESH_NAA_INIT:
        case REFRESH_UICC_RESET:
        mCmdParams = new DisplayTextParams(cmdDet, null);
        break;
}        boolean var68934A3E9455FA72420237EB05902327_2069090432 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784198243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784198243;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.191 -0400", hash_original_method = "BCD1A4E1E4B160F1064A009F1000860C", hash_generated_method = "C4CB00BDE7EBBFA9E1557BD4729B3AAA")
    private boolean processSelectItem(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process SelectItem");
        Menu menu = new Menu();
        IconId titleIconId = null;
        ItemsIconId itemsIconId = null;
        Iterator<ComprehensionTlv> iter = ctlvs.iterator();
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID,
                ctlvs);
        if(ctlv != null)        
        {
            menu.title = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        while
(true)        
        {
            ctlv = searchForNextTag(ComprehensionTlvTag.ITEM, iter);
            if(ctlv != null)            
            {
                menu.items.add(ValueParser.retrieveItem(ctlv));
            } //End block
            else
            {
                break;
            } //End block
        } //End block
        if(menu.items.size() == 0)        
        {
            ResultException var6CA5E47869237D539D80DDEFF8BE49EC_263245351 = new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            var6CA5E47869237D539D80DDEFF8BE49EC_263245351.addTaint(taint);
            throw var6CA5E47869237D539D80DDEFF8BE49EC_263245351;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ITEM_ID, ctlvs);
        if(ctlv != null)        
        {
            menu.defaultItem = ValueParser.retrieveItemId(ctlv) - 1;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            titleIconId = ValueParser.retrieveIconId(ctlv);
            menu.titleIconSelfExplanatory = titleIconId.selfExplanatory;
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ITEM_ICON_ID_LIST, ctlvs);
        if(ctlv != null)        
        {
            mIconLoadState = LOAD_MULTI_ICONS;
            itemsIconId = ValueParser.retrieveItemsIconId(ctlv);
            menu.itemsIconSelfExplanatory = itemsIconId.selfExplanatory;
        } //End block
        boolean presentTypeSpecified = (cmdDet.commandQualifier & 0x01) != 0;
        if(presentTypeSpecified)        
        {
            if((cmdDet.commandQualifier & 0x02) == 0)            
            {
                menu.presentationType = PresentationType.DATA_VALUES;
            } //End block
            else
            {
                menu.presentationType = PresentationType.NAVIGATION_OPTIONS;
            } //End block
        } //End block
        menu.softKeyPreferred = (cmdDet.commandQualifier & 0x04) != 0;
        menu.helpAvailable = (cmdDet.commandQualifier & 0x80) != 0;
        mCmdParams = new SelectItemParams(cmdDet, menu, titleIconId != null);
switch(mIconLoadState){
        case LOAD_NO_ICON:
        boolean var68934A3E9455FA72420237EB05902327_1431990892 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042448163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042448163;
        case LOAD_SINGLE_ICON:
        mIconLoader.loadIcon(titleIconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        break;
        case LOAD_MULTI_ICONS:
        int[] recordNumbers = itemsIconId.recordNumbers;
        if(titleIconId != null)        
        {
            recordNumbers = new int[itemsIconId.recordNumbers.length + 1];
            recordNumbers[0] = titleIconId.recordNumber;
            System.arraycopy(itemsIconId.recordNumbers, 0, recordNumbers,
                        1, itemsIconId.recordNumbers.length);
        } //End block
        mIconLoader.loadIcons(recordNumbers, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_940452992 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508396848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_508396848;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.192 -0400", hash_original_method = "A40BEAAD1582CC67F32BB145B8ABDE84", hash_generated_method = "C6321A7838AE939F85F686D9C9027310")
    private boolean processEventNotify(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process EventNotify");
        TextMessage textMsg = new TextMessage();
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID,
                ctlvs);
        textMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        textMsg.responseNeeded = false;
        mCmdParams = new DisplayTextParams(cmdDet, textMsg);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_658808251 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772651599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772651599;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_877131547 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372611013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372611013;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.193 -0400", hash_original_method = "C7EE76D8654D8C691124AB97A0520EED", hash_generated_method = "80DC93769E451B6C893A49F872A74B55")
    private boolean processSetUpEventList(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) {
        addTaint(ctlvs.getTaint());
        addTaint(cmdDet.getTaint());
        CatLog.d(this, "process SetUpEventList");
        boolean varB326B5062B2F0E69046810717534CB09_800846494 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833060020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833060020;
        // ---------- Original Method ----------
        //CatLog.d(this, "process SetUpEventList");
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.194 -0400", hash_original_method = "8945EEF95EF30DB6F3AC6F2F65AD50C7", hash_generated_method = "4256943CE6F86D072D9C4FE93AE702D0")
    private boolean processLaunchBrowser(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process LaunchBrowser");
        TextMessage confirmMsg = new TextMessage();
        IconId iconId = null;
        String url = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.URL, ctlvs);
        if(ctlv != null)        
        {
            try 
            {
                byte[] rawValue = ctlv.getRawValue();
                int valueIndex = ctlv.getValueIndex();
                int valueLen = ctlv.getLength();
                if(valueLen > 0)                
                {
                    url = GsmAlphabet.gsm8BitUnpackedToString(rawValue,
                            valueIndex, valueLen);
                } //End block
                else
                {
                    url = null;
                } //End block
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                ResultException var6E8D14BE611E67DFA023E650FC522377_1119337840 = new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                var6E8D14BE611E67DFA023E650FC522377_1119337840.addTaint(taint);
                throw var6E8D14BE611E67DFA023E650FC522377_1119337840;
            } //End block
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, ctlvs);
        confirmMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            confirmMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        LaunchBrowserMode mode;
switch(cmdDet.commandQualifier){
        case 0x00:
        default:
        mode = LaunchBrowserMode.LAUNCH_IF_NOT_ALREADY_LAUNCHED;
        break;
        case 0x02:
        mode = LaunchBrowserMode.USE_EXISTING_BROWSER;
        break;
        case 0x03:
        mode = LaunchBrowserMode.LAUNCH_NEW_BROWSER;
        break;
}        mCmdParams = new LaunchBrowserParams(cmdDet, confirmMsg, url, mode);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_1032788561 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329511945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329511945;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1555001350 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218850302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218850302;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.196 -0400", hash_original_method = "9E25ADC04DC19743F5D672C3FA9262A8", hash_generated_method = "9531B1227A53D22AE10B00F87778DF14")
    private boolean processPlayTone(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process PlayTone");
        Tone tone = null;
        TextMessage textMsg = new TextMessage();
        Duration duration = null;
        IconId iconId = null;
        ComprehensionTlv ctlv = searchForTag(ComprehensionTlvTag.TONE, ctlvs);
        if(ctlv != null)        
        {
            if(ctlv.getLength() > 0)            
            {
                try 
                {
                    byte[] rawValue = ctlv.getRawValue();
                    int valueIndex = ctlv.getValueIndex();
                    int toneVal = rawValue[valueIndex];
                    tone = Tone.fromInt(toneVal);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    ResultException var6E8D14BE611E67DFA023E650FC522377_208319665 = new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                    var6E8D14BE611E67DFA023E650FC522377_208319665.addTaint(taint);
                    throw var6E8D14BE611E67DFA023E650FC522377_208319665;
                } //End block
            } //End block
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, ctlvs);
        if(ctlv != null)        
        {
            textMsg.text = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.DURATION, ctlvs);
        if(ctlv != null)        
        {
            duration = ValueParser.retrieveDuration(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            iconId = ValueParser.retrieveIconId(ctlv);
            textMsg.iconSelfExplanatory = iconId.selfExplanatory;
        } //End block
        boolean vibrate = (cmdDet.commandQualifier & 0x01) != 0x00;
        textMsg.responseNeeded = false;
        mCmdParams = new PlayToneParams(cmdDet, textMsg, tone, duration, vibrate);
        if(iconId != null)        
        {
            mIconLoadState = LOAD_SINGLE_ICON;
            mIconLoader.loadIcon(iconId.recordNumber, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_738344870 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310681877 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_310681877;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_384174214 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533243680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533243680;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.198 -0400", hash_original_method = "1675CA7AE4DACD4909A19602008CCD7F", hash_generated_method = "6C8501281A270D2A81AAA9C41CB56F0B")
    private boolean processSetupCall(CommandDetails cmdDet,
            List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process SetupCall");
        Iterator<ComprehensionTlv> iter = ctlvs.iterator();
        ComprehensionTlv ctlv = null;
        TextMessage confirmMsg = new TextMessage();
        TextMessage callMsg = new TextMessage();
        IconId confirmIconId = null;
        IconId callIconId = null;
        ctlv = searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iter);
        confirmMsg.text = ValueParser.retrieveAlphaId(ctlv);
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            confirmIconId = ValueParser.retrieveIconId(ctlv);
            confirmMsg.iconSelfExplanatory = confirmIconId.selfExplanatory;
        } //End block
        ctlv = searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iter);
        if(ctlv != null)        
        {
            callMsg.text = ValueParser.retrieveAlphaId(ctlv);
        } //End block
        ctlv = searchForTag(ComprehensionTlvTag.ICON_ID, ctlvs);
        if(ctlv != null)        
        {
            callIconId = ValueParser.retrieveIconId(ctlv);
            callMsg.iconSelfExplanatory = callIconId.selfExplanatory;
        } //End block
        mCmdParams = new CallSetupParams(cmdDet, confirmMsg, callMsg);
        if(confirmIconId != null || callIconId != null)        
        {
            mIconLoadState = LOAD_MULTI_ICONS;
            int[] recordNumbers = new int[2];
            recordNumbers[0] = confirmIconId != null
                    ? confirmIconId.recordNumber : -1;
            recordNumbers[1] = callIconId != null ? callIconId.recordNumber
                    : -1;
            mIconLoader.loadIcons(recordNumbers, this
                    .obtainMessage(MSG_ID_LOAD_ICON_DONE));
            boolean varB326B5062B2F0E69046810717534CB09_573580204 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607017796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_607017796;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2131283418 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057789559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057789559;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_method = "A94C1A7A0EB7DC9619C535A1C0085435", hash_generated_method = "B1C10186BA0F75A2CCDE93DE3C87BFDF")
    private boolean processProvideLocalInfo(CommandDetails cmdDet, List<ComprehensionTlv> ctlvs) throws ResultException {
        addTaint(ctlvs.getTaint());
        CatLog.d(this, "process ProvideLocalInfo");
switch(cmdDet.commandQualifier){
        case DTTZ_SETTING:
        CatLog.d(this, "PLI [DTTZ_SETTING]");
        mCmdParams = new CommandParams(cmdDet);
        break;
        case LANGUAGE_SETTING:
        CatLog.d(this, "PLI [LANGUAGE_SETTING]");
        mCmdParams = new CommandParams(cmdDet);
        break;
        default:
        CatLog.d(this, "PLI[" + cmdDet.commandQualifier + "] Command Not Supported");
        mCmdParams = new CommandParams(cmdDet);
        ResultException var371413381C63EBB69A0B36390E4302CE_1687969296 = new ResultException(ResultCode.BEYOND_TERMINAL_CAPABILITY);
        var371413381C63EBB69A0B36390E4302CE_1687969296.addTaint(taint);
        throw var371413381C63EBB69A0B36390E4302CE_1687969296;
}        boolean var68934A3E9455FA72420237EB05902327_1070600218 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275153206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275153206;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "A02E695433658795D44A91F9AE9E9D68")

    private static CommandParamsFactory sInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "F06FC8D30143C69FD9E3180EB141CFD6", hash_generated_field = "0509FD10C97DF0D78F994025A148CFA1")

    static final int MSG_ID_LOAD_ICON_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "2BCC173F891239A5A8576F2AEC0B91A0", hash_generated_field = "0374DAA182CC981CAAA4DE858EB0B766")

    static final int LOAD_NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "A57771E5C7F2CE97D71E159649709634", hash_generated_field = "761C07843AF0BBB06B808D9C6BAA7BEF")

    static final int LOAD_SINGLE_ICON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "900BD676D0EFA2244326DDA407C01CF9", hash_generated_field = "182C6267022EF7CFE59C2F652B4F88F7")

    static final int LOAD_MULTI_ICONS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "2FAA3391556637CDCAED99C9E616C7C0", hash_generated_field = "55FC531319D23B63500B05E76A240327")

    static final int REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "699D69C7B5F124C6D3F7F032DB01A49C", hash_generated_field = "0E4599A2E374EA02CB6A0600D5C88CB7")

    static final int REFRESH_NAA_INIT_AND_FILE_CHANGE = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "0DA0EEC5D7E4FD4199ABD57860E04B02", hash_generated_field = "9E614C5C7AF00114FEDB9AEF35435672")

    static final int REFRESH_NAA_INIT = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "9884D2460CE792B1DEC3C6893B0BC27C", hash_generated_field = "F329B35F0F2C675C33E539235C3A6551")

    static final int REFRESH_UICC_RESET = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "CD5701BD2A2C97379C4A10266493FC0C", hash_generated_field = "DD4EB25D5CA263605A614D46E2441751")

    static final int DTTZ_SETTING = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.199 -0400", hash_original_field = "B86AE44C2E0468CA3371EBAA7E72DB95", hash_generated_field = "3A59590520C8A31CBBFD0DFA1F5A61E7")

    static final int LANGUAGE_SETTING = 0x04;
}

