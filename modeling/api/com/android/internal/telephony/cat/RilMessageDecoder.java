package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

class RilMessageDecoder extends StateMachine {

    /**
     * Get the singleton instance, constructing if necessary.
     *
     * @param caller
     * @param fh
     * @return RilMesssageDecoder
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.489 -0500", hash_original_method = "903735E0D39211F3CD1FCDD839935A4F", hash_generated_method = "D4496C5954757CE1790873D1D41C4360")
    
public static synchronized RilMessageDecoder getInstance(Handler caller, IccFileHandler fh) {
        if (sInstance == null) {
            sInstance = new RilMessageDecoder(caller, fh);
            sInstance.start();
        }
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.469 -0500", hash_original_field = "AEC7F3E7F4E64FD893FEF932943410BF", hash_generated_field = "9EA09889C86B65E89CD4E2117D5BA782")

    private static final int CMD_START = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.472 -0500", hash_original_field = "F28048575CE0E3AB342A1C7C23E66AC7", hash_generated_field = "D25DD8423B1F17A48262F8DB470BF25A")

    private static final int CMD_PARAMS_READY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.475 -0500", hash_original_field = "D0BF7DAE3AF7210A1CECCA4C107D5F6C", hash_generated_field = "A7EDEBAD815A463752575C104B099CEC")

    private static RilMessageDecoder sInstance = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.477 -0500", hash_original_field = "BD386C2EA07CBCE2F80753F2E16BF4D8", hash_generated_field = "1D31B9527FBE265BC5A565819E7A3298")

    private CommandParamsFactory mCmdParamsFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.479 -0500", hash_original_field = "159B169B37F0C7C85C3C1B673D7BAB93", hash_generated_field = "AB545A711A7AD12E762D048FCDAEAF6C")

    private RilMessage mCurrentRilMessage = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.482 -0500", hash_original_field = "3BDF5A36D8C849FF77045D06ADFA8292", hash_generated_field = "3825A5A20225788FF84555766B230175")

    private Handler mCaller = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.484 -0500", hash_original_field = "F409831FEA93846A8E6905AF4DA4E6E3", hash_generated_field = "E3AB6B1D1176FD0063AAF06152A6C3C1")

    private StateStart mStateStart = new StateStart();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.487 -0500", hash_original_field = "6A5781C1EF4738939E5F505812C9E12F", hash_generated_field = "AA59174CBCE92AAF8CF1CF2D3197AB32")

    private StateCmdParamsReady mStateCmdParamsReady = new StateCmdParamsReady();

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.501 -0500", hash_original_method = "80000F6682C0A8DA18E484599E848E2C", hash_generated_method = "9565B3CB3B1EACDD4FD41ECCCECE106D")
    
private RilMessageDecoder(Handler caller, IccFileHandler fh) {
        super("RilMessageDecoder");

        addState(mStateStart);
        addState(mStateCmdParamsReady);
        setInitialState(mStateStart);

        mCaller = caller;
        mCmdParamsFactory = CommandParamsFactory.getInstance(this, fh);
    }

    /**
     * Start decoding the message parameters,
     * when complete MSG_ID_RIL_MSG_DECODED will be returned to caller.
     *
     * @param rilMsg
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.493 -0500", hash_original_method = "558F46FD0EDA24F51E513C644847EA22", hash_generated_method = "57CFD73F472AD8C72010E38B2FDA71B6")
    
public void sendStartDecodingMessageParams(RilMessage rilMsg) {
        Message msg = obtainMessage(CMD_START);
        msg.obj = rilMsg;
        sendMessage(msg);
    }
    
    private class StateStart extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.570 -0400", hash_original_method = "C10CD2CE94A1CED10886036D2E1F3CE9", hash_generated_method = "C10CD2CE94A1CED10886036D2E1F3CE9")
        public StateStart ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.505 -0500", hash_original_method = "57F9642232CB19CA7FAC73C8363E6E1D", hash_generated_method = "E8FE7468543D4E8C2E224F6A2F04575A")
        
@Override
        public boolean processMessage(Message msg) {
            if (msg.what == CMD_START) {
                if (decodeMessageParams((RilMessage)msg.obj)) {
                    transitionTo(mStateCmdParamsReady);
                }
            } else {
                CatLog.d(this, "StateStart unexpected expecting START=" +
                         CMD_START + " got " + msg.what);
            }
            return true;
        }
        
    }
    
    private class StateCmdParamsReady extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.572 -0400", hash_original_method = "B99964FB7C360B547C7ED4636595450B", hash_generated_method = "B99964FB7C360B547C7ED4636595450B")
        public StateCmdParamsReady ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.511 -0500", hash_original_method = "17A6F88C736680351817FD1B07408EDF", hash_generated_method = "8A699B853A56DAD18C5BBE12E0079BFC")
        
@Override
        public boolean processMessage(Message msg) {
            if (msg.what == CMD_PARAMS_READY) {
                mCurrentRilMessage.mResCode = ResultCode.fromInt(msg.arg1);
                mCurrentRilMessage.mData = msg.obj;
                sendCmdForExecution(mCurrentRilMessage);
                transitionTo(mStateStart);
            } else {
                CatLog.d(this, "StateCmdParamsReady expecting CMD_PARAMS_READY="
                         + CMD_PARAMS_READY + " got " + msg.what);
                deferMessage(msg);
            }
            return true;
        }
        
    }

    /**
     * The command parameters have been decoded.
     *
     * @param resCode
     * @param cmdParams
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.496 -0500", hash_original_method = "66DFFFB44E1DF2E53F71A8A0807BF75D", hash_generated_method = "E5AF027701615F992BC2C9EB4DE84A43")
    
public void sendMsgParamsDecoded(ResultCode resCode, CommandParams cmdParams) {
        Message msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        msg.arg1 = resCode.value();
        msg.obj = cmdParams;
        sendMessage(msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.498 -0500", hash_original_method = "D82B03DF0CAD2B5CB90F2219FBBA492B", hash_generated_method = "D0F037313C7D6CC20CC902F4ED6A64D9")
    
private void sendCmdForExecution(RilMessage rilMsg) {
        Message msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                new RilMessage(rilMsg));
        msg.sendToTarget();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.516 -0500", hash_original_method = "7155A04451229DB43083FDF7F69C4418", hash_generated_method = "DBD2ED0D72F82A23D65961ED7B908121")
    
private boolean decodeMessageParams(RilMessage rilMsg) {
        boolean decodingStarted;

        mCurrentRilMessage = rilMsg;
        switch(rilMsg.mId) {
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
            try {
                rawData = IccUtils.hexStringToBytes((String) rilMsg.mData);
            } catch (Exception e) {
                // zombie messages are dropped
                CatLog.d(this, "decodeMessageParams dropping zombie messages");
                decodingStarted = false;
                break;
            }
            try {
                // Start asynch parsing of the command parameters.
                mCmdParamsFactory.make(BerTlv.decode(rawData));
                decodingStarted = true;
            } catch (ResultException e) {
                // send to Service for proper RIL communication.
                mCurrentRilMessage.mResCode = e.result();
                sendCmdForExecution(mCurrentRilMessage);
                decodingStarted = false;
            }
            break;
        default:
            decodingStarted = false;
            break;
        }
        return decodingStarted;
    }
}

