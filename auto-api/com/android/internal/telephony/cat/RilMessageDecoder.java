package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import android.os.Handler;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import android.os.Message;

class RilMessageDecoder extends StateMachine {
    private CommandParamsFactory mCmdParamsFactory = null;
    private RilMessage mCurrentRilMessage = null;
    private Handler mCaller = null;
    private StateStart mStateStart = new StateStart();
    private StateCmdParamsReady mStateCmdParamsReady = new StateCmdParamsReady();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.005 -0400", hash_original_method = "80000F6682C0A8DA18E484599E848E2C", hash_generated_method = "DE6DB3E303D8F0006CB45A07F219D043")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RilMessageDecoder(Handler caller, IccFileHandler fh) {
        super("RilMessageDecoder");
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(fh.dsTaint);
        addState(mStateStart);
        addState(mStateCmdParamsReady);
        setInitialState(mStateStart);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.006 -0400", hash_original_method = "558F46FD0EDA24F51E513C644847EA22", hash_generated_method = "FE1B463F93E475D0CB549259548E1F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendStartDecodingMessageParams(RilMessage rilMsg) {
        dsTaint.addTaint(rilMsg.dsTaint);
        Message msg;
        msg = obtainMessage(CMD_START);
        msg.obj = rilMsg;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(CMD_START);
        //msg.obj = rilMsg;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.006 -0400", hash_original_method = "66DFFFB44E1DF2E53F71A8A0807BF75D", hash_generated_method = "9CD16B3DB387E239891087492A668871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMsgParamsDecoded(ResultCode resCode, CommandParams cmdParams) {
        dsTaint.addTaint(cmdParams.dsTaint);
        dsTaint.addTaint(resCode.dsTaint);
        Message msg;
        msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        msg.arg1 = resCode.value();
        msg.obj = cmdParams;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        //msg.arg1 = resCode.value();
        //msg.obj = cmdParams;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.006 -0400", hash_original_method = "D82B03DF0CAD2B5CB90F2219FBBA492B", hash_generated_method = "45870F8FF1F02B59A15D89A7B8301AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendCmdForExecution(RilMessage rilMsg) {
        dsTaint.addTaint(rilMsg.dsTaint);
        Message msg;
        msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                new RilMessage(rilMsg));
        msg.sendToTarget();
        // ---------- Original Method ----------
        //Message msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                //new RilMessage(rilMsg));
        //msg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.006 -0400", hash_original_method = "7155A04451229DB43083FDF7F69C4418", hash_generated_method = "62F5DF4D6A36641C569F1C9C981FA7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean decodeMessageParams(RilMessage rilMsg) {
        dsTaint.addTaint(rilMsg.dsTaint);
        boolean decodingStarted;
        //Begin case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        mCurrentRilMessage.mResCode = ResultCode.OK;
        //End case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        //Begin case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        sendCmdForExecution(mCurrentRilMessage);
        //End case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        //Begin case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        decodingStarted = false;
        //End case CatService.MSG_ID_SESSION_END CatService.MSG_ID_CALL_SETUP 
        //Begin case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
        byte[] rawData;
        rawData = null;
        //End case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
        //Begin case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
        try 
        {
            rawData = IccUtils.hexStringToBytes((String) rilMsg.mData);
        } //End block
        catch (Exception e)
        {
            CatLog.d(this, "decodeMessageParams dropping zombie messages");
            decodingStarted = false;
        } //End block
        //End case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
        //Begin case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
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
        //End case CatService.MSG_ID_PROACTIVE_COMMAND CatService.MSG_ID_EVENT_NOTIFY CatService.MSG_ID_REFRESH 
        //Begin case default 
        decodingStarted = false;
        //End case default 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class StateStart extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.007 -0400", hash_original_method = "8CBD62F34ABEFB5211DBC2EC84B0046F", hash_generated_method = "8CBD62F34ABEFB5211DBC2EC84B0046F")
                public StateStart ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.007 -0400", hash_original_method = "57F9642232CB19CA7FAC73C8363E6E1D", hash_generated_method = "70D65316C6C0FCE84DA988889BD84122")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                {
                    boolean var3808E777C759EF8D4B42122C317932A7_127142205 = (decodeMessageParams((RilMessage)msg.obj));
                    {
                        transitionTo(mStateCmdParamsReady);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                CatLog.d(this, "StateStart unexpected expecting START=" +
                         CMD_START + " got " + msg.what);
            } //End block
            return dsTaint.getTaintBoolean();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.007 -0400", hash_original_method = "DC2C46692CEA3FD4D24D5B37699D65C2", hash_generated_method = "DC2C46692CEA3FD4D24D5B37699D65C2")
                public StateCmdParamsReady ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.007 -0400", hash_original_method = "17A6F88C736680351817FD1B07408EDF", hash_generated_method = "10B760D8706F3B16C43AEC2621F1E85F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean processMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mCurrentRilMessage.mResCode = ResultCode.fromInt(msg.arg1);
                mCurrentRilMessage.mData = msg.obj;
                sendCmdForExecution(mCurrentRilMessage);
                transitionTo(mStateStart);
            } //End block
            {
                CatLog.d(this, "StateCmdParamsReady expecting CMD_PARAMS_READY="
                         + CMD_PARAMS_READY + " got " + msg.what);
                deferMessage(msg);
            } //End block
            return dsTaint.getTaintBoolean();
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


    
    private static final int CMD_START = 1;
    private static final int CMD_PARAMS_READY = 2;
    private static RilMessageDecoder sInstance = null;
}

