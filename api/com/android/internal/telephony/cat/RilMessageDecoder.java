package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;




class RilMessageDecoder extends StateMachine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.565 -0400", hash_original_field = "323B97ECC7245864248EAE86A2F8A7C0", hash_generated_field = "1D31B9527FBE265BC5A565819E7A3298")

    private CommandParamsFactory mCmdParamsFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.565 -0400", hash_original_field = "591FE4342F4414E6BB57B72904737054", hash_generated_field = "AB545A711A7AD12E762D048FCDAEAF6C")

    private RilMessage mCurrentRilMessage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.565 -0400", hash_original_field = "F61832AE4199B01FFC1C38C9632A67D4", hash_generated_field = "3825A5A20225788FF84555766B230175")

    private Handler mCaller = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.565 -0400", hash_original_field = "3EBE40B8AFD876D3F86FD0C082916602", hash_generated_field = "E3AB6B1D1176FD0063AAF06152A6C3C1")

    private StateStart mStateStart = new StateStart();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.565 -0400", hash_original_field = "EB2974EB549E456C6C1AA2217190E491", hash_generated_field = "AA59174CBCE92AAF8CF1CF2D3197AB32")

    private StateCmdParamsReady mStateCmdParamsReady = new StateCmdParamsReady();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.566 -0400", hash_original_method = "80000F6682C0A8DA18E484599E848E2C", hash_generated_method = "5F4E68F54CB745219D0E765FBD98B005")
    private  RilMessageDecoder(Handler caller, IccFileHandler fh) {
        super("RilMessageDecoder");
        addState(mStateStart);
        addState(mStateCmdParamsReady);
        setInitialState(mStateStart);
        mCaller = caller;
        mCmdParamsFactory = CommandParamsFactory.getInstance(this, fh);
        // ---------- Original Method ----------
        //addState(mStateStart);
        //addState(mStateCmdParamsReady);
        //setInitialState(mStateStart);
        //mCaller = caller;
        //mCmdParamsFactory = CommandParamsFactory.getInstance(this, fh);
    }

    
    public static synchronized RilMessageDecoder getInstance(Handler caller, IccFileHandler fh) {
        if (sInstance == null) {
            sInstance = new RilMessageDecoder(caller, fh);
            sInstance.start();
        }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.567 -0400", hash_original_method = "558F46FD0EDA24F51E513C644847EA22", hash_generated_method = "AE47861E6BA50F81E18A47A9111ED278")
    public void sendStartDecodingMessageParams(RilMessage rilMsg) {
        addTaint(rilMsg.getTaint());
        Message msg = obtainMessage(CMD_START);
        msg.obj = rilMsg;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(CMD_START);
        //msg.obj = rilMsg;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.568 -0400", hash_original_method = "66DFFFB44E1DF2E53F71A8A0807BF75D", hash_generated_method = "ECCB5B676DCD87CD851184A597949DB1")
    public void sendMsgParamsDecoded(ResultCode resCode, CommandParams cmdParams) {
        addTaint(cmdParams.getTaint());
        addTaint(resCode.getTaint());
        Message msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        msg.arg1 = resCode.value();
        msg.obj = cmdParams;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        //msg.arg1 = resCode.value();
        //msg.obj = cmdParams;
        //sendMessage(msg);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.568 -0400", hash_original_method = "D82B03DF0CAD2B5CB90F2219FBBA492B", hash_generated_method = "1014EA25D8D8CF7E084C205B982798EF")
    private void sendCmdForExecution(RilMessage rilMsg) {
        addTaint(rilMsg.getTaint());
        Message msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                new RilMessage(rilMsg));
        msg.sendToTarget();
        // ---------- Original Method ----------
        //Message msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                //new RilMessage(rilMsg));
        //msg.sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.569 -0400", hash_original_method = "7155A04451229DB43083FDF7F69C4418", hash_generated_method = "261C5A48C7CFC617160435103586B81E")
    private boolean decodeMessageParams(RilMessage rilMsg) {
        boolean decodingStarted;
        mCurrentRilMessage = rilMsg;
switch(rilMsg.mId){
        case CatService.MSG_ID_SESSION_END:
        case CatService.MSG_ID_CALL_SETUP:
        mCurrentRilMessage.mResCode = ResultCode.OK;
        sendCmdForExecution(mCurrentRilMessage);
        decodingStarted = false;
        break;
        case CatService.MSG_ID_PROACTIVE_COMMAND:
        case CatService.MSG_ID_EVENT_NOTIFY:
        case CatService.MSG_ID_REFRESH:
        byte[] rawData = null;
        try 
        {
            rawData = IccUtils.hexStringToBytes((String) rilMsg.mData);
        } //End block
        catch (Exception e)
        {
            CatLog.d(this, "decodeMessageParams dropping zombie messages");
            decodingStarted = false;
            break;
        } //End block
        try 
        {
            mCmdParamsFactory.make(BerTlv.decode(rawData));
            decodingStarted = true;
        } //End block
        catch (ResultException e)
        {
            mCurrentRilMessage.mResCode = e.result();
            sendCmdForExecution(mCurrentRilMessage);
            decodingStarted = false;
        } //End block
        break;
        default:
        decodingStarted = false;
        break;
}        boolean var6D17ABC339EAFE96290A43067C1AF649_1199290496 = (decodingStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095343742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095343742;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class StateStart extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.570 -0400", hash_original_method = "C10CD2CE94A1CED10886036D2E1F3CE9", hash_generated_method = "C10CD2CE94A1CED10886036D2E1F3CE9")
        public StateStart ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.571 -0400", hash_original_method = "57F9642232CB19CA7FAC73C8363E6E1D", hash_generated_method = "CE6D6592BD2A1D87776E4EE614990B97")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            if(msg.what == CMD_START)            
            {
                if(decodeMessageParams((RilMessage)msg.obj))                
                {
                    transitionTo(mStateCmdParamsReady);
                } //End block
            } //End block
            else
            {
                CatLog.d(this, "StateStart unexpected expecting START=" +
                         CMD_START + " got " + msg.what);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_472727724 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169572098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_169572098;
            // ---------- Original Method ----------
            //if (msg.what == CMD_START) {
                //if (decodeMessageParams((RilMessage)msg.obj)) {
                    //transitionTo(mStateCmdParamsReady);
                //}
            //} else {
                //CatLog.d(this, "StateStart unexpected expecting START=" +
                         //CMD_START + " got " + msg.what);
            //}
            //return true;
        }

        
    }


    
    private class StateCmdParamsReady extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.572 -0400", hash_original_method = "B99964FB7C360B547C7ED4636595450B", hash_generated_method = "B99964FB7C360B547C7ED4636595450B")
        public StateCmdParamsReady ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.574 -0400", hash_original_method = "17A6F88C736680351817FD1B07408EDF", hash_generated_method = "8B918E7F0EAC4C110BC1FBF63372E8F2")
        @Override
        public boolean processMessage(Message msg) {
            addTaint(msg.getTaint());
            if(msg.what == CMD_PARAMS_READY)            
            {
                mCurrentRilMessage.mResCode = ResultCode.fromInt(msg.arg1);
                mCurrentRilMessage.mData = msg.obj;
                sendCmdForExecution(mCurrentRilMessage);
                transitionTo(mStateStart);
            } //End block
            else
            {
                CatLog.d(this, "StateCmdParamsReady expecting CMD_PARAMS_READY="
                         + CMD_PARAMS_READY + " got " + msg.what);
                deferMessage(msg);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1673882290 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275489075 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_275489075;
            // ---------- Original Method ----------
            //if (msg.what == CMD_PARAMS_READY) {
                //mCurrentRilMessage.mResCode = ResultCode.fromInt(msg.arg1);
                //mCurrentRilMessage.mData = msg.obj;
                //sendCmdForExecution(mCurrentRilMessage);
                //transitionTo(mStateStart);
            //} else {
                //CatLog.d(this, "StateCmdParamsReady expecting CMD_PARAMS_READY="
                         //+ CMD_PARAMS_READY + " got " + msg.what);
                //deferMessage(msg);
            //}
            //return true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.574 -0400", hash_original_field = "B68395A74681A0DDBC38547AD7EF0ABA", hash_generated_field = "9EA09889C86B65E89CD4E2117D5BA782")

    private static final int CMD_START = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.574 -0400", hash_original_field = "7EC9A96549249183230352DC0416584B", hash_generated_field = "D25DD8423B1F17A48262F8DB470BF25A")

    private static final int CMD_PARAMS_READY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.574 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "A7EDEBAD815A463752575C104B099CEC")

    private static RilMessageDecoder sInstance = null;
}

