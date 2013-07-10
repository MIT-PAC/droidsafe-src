package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import android.os.Handler;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import android.os.Message;

class RilMessageDecoder extends StateMachine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.775 -0400", hash_original_field = "323B97ECC7245864248EAE86A2F8A7C0", hash_generated_field = "1D31B9527FBE265BC5A565819E7A3298")

    private CommandParamsFactory mCmdParamsFactory = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.775 -0400", hash_original_field = "591FE4342F4414E6BB57B72904737054", hash_generated_field = "AB545A711A7AD12E762D048FCDAEAF6C")

    private RilMessage mCurrentRilMessage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.775 -0400", hash_original_field = "F61832AE4199B01FFC1C38C9632A67D4", hash_generated_field = "3825A5A20225788FF84555766B230175")

    private Handler mCaller = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.775 -0400", hash_original_field = "3EBE40B8AFD876D3F86FD0C082916602", hash_generated_field = "E3AB6B1D1176FD0063AAF06152A6C3C1")

    private StateStart mStateStart = new StateStart();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.775 -0400", hash_original_field = "EB2974EB549E456C6C1AA2217190E491", hash_generated_field = "AA59174CBCE92AAF8CF1CF2D3197AB32")

    private StateCmdParamsReady mStateCmdParamsReady = new StateCmdParamsReady();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.776 -0400", hash_original_method = "80000F6682C0A8DA18E484599E848E2C", hash_generated_method = "5F4E68F54CB745219D0E765FBD98B005")
    private  RilMessageDecoder(Handler caller, IccFileHandler fh) {
        super("RilMessageDecoder");
        addState(mStateStart);
        addState(mStateCmdParamsReady);
        setInitialState(mStateStart);
        mCaller = caller;
        mCmdParamsFactory = CommandParamsFactory.getInstance(this, fh);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized RilMessageDecoder getInstance(Handler caller, IccFileHandler fh) {
        if (sInstance == null) {
            sInstance = new RilMessageDecoder(caller, fh);
            sInstance.start();
        }
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.778 -0400", hash_original_method = "558F46FD0EDA24F51E513C644847EA22", hash_generated_method = "D34A3E5E2C1AB4421BB7E5B56A2003EC")
    public void sendStartDecodingMessageParams(RilMessage rilMsg) {
        Message msg = obtainMessage(CMD_START);
        msg.obj = rilMsg;
        sendMessage(msg);
        addTaint(rilMsg.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.779 -0400", hash_original_method = "66DFFFB44E1DF2E53F71A8A0807BF75D", hash_generated_method = "910325CCB2390BFBF15EF881CAAE47C0")
    public void sendMsgParamsDecoded(ResultCode resCode, CommandParams cmdParams) {
        Message msg = obtainMessage(RilMessageDecoder.CMD_PARAMS_READY);
        msg.arg1 = resCode.value();
        msg.obj = cmdParams;
        sendMessage(msg);
        addTaint(resCode.getTaint());
        addTaint(cmdParams.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.779 -0400", hash_original_method = "D82B03DF0CAD2B5CB90F2219FBBA492B", hash_generated_method = "6BF55EA706CECBB1C08A251D3B2A8FB1")
    private void sendCmdForExecution(RilMessage rilMsg) {
        Message msg = mCaller.obtainMessage(CatService.MSG_ID_RIL_MSG_DECODED,
                new RilMessage(rilMsg));
        msg.sendToTarget();
        addTaint(rilMsg.getTaint());
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.780 -0400", hash_original_method = "7155A04451229DB43083FDF7F69C4418", hash_generated_method = "0451B40C06820BBCB29C48442995C20F")
    private boolean decodeMessageParams(RilMessage rilMsg) {
        boolean decodingStarted;
        mCurrentRilMessage = rilMsg;
        
        mCurrentRilMessage.mResCode = ResultCode.OK;
        
        
        sendCmdForExecution(mCurrentRilMessage);
        
        
        decodingStarted = false;
        
        
        byte[] rawData = null;
        
        
        try 
        {
            rawData = IccUtils.hexStringToBytes((String) rilMsg.mData);
        } 
        catch (Exception e)
        {
            CatLog.d(this, "decodeMessageParams dropping zombie messages");
            decodingStarted = false;
        } 
        
        
        try 
        {
            mCmdParamsFactory.make(BerTlv.decode(rawData));
            decodingStarted = true;
        } 
        catch (ResultException e)
        {
            mCurrentRilMessage.mResCode = e.result();
            sendCmdForExecution(mCurrentRilMessage);
            decodingStarted = false;
        } 
        
        
        decodingStarted = false;
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097236959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097236959;
        
        
    }

    
    private class StateStart extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.781 -0400", hash_original_method = "C10CD2CE94A1CED10886036D2E1F3CE9", hash_generated_method = "C10CD2CE94A1CED10886036D2E1F3CE9")
        public StateStart ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.781 -0400", hash_original_method = "57F9642232CB19CA7FAC73C8363E6E1D", hash_generated_method = "4DB42DF39EAE7F540B00B086CDDB4784")
        @Override
        public boolean processMessage(Message msg) {
            {
                {
                    boolean var3808E777C759EF8D4B42122C317932A7_1321656914 = (decodeMessageParams((RilMessage)msg.obj));
                    {
                        transitionTo(mStateCmdParamsReady);
                    } 
                } 
            } 
            {
                CatLog.d(this, "StateStart unexpected expecting START=" +
                         CMD_START + " got " + msg.what);
            } 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101589809 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101589809;
            
            
                
                    
                
            
                
                         
            
            
        }

        
    }


    
    private class StateCmdParamsReady extends State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.781 -0400", hash_original_method = "B99964FB7C360B547C7ED4636595450B", hash_generated_method = "B99964FB7C360B547C7ED4636595450B")
        public StateCmdParamsReady ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.782 -0400", hash_original_method = "17A6F88C736680351817FD1B07408EDF", hash_generated_method = "9BB5848CF51069C7AF719A437AC738A5")
        @Override
        public boolean processMessage(Message msg) {
            {
                mCurrentRilMessage.mResCode = ResultCode.fromInt(msg.arg1);
                mCurrentRilMessage.mData = msg.obj;
                sendCmdForExecution(mCurrentRilMessage);
                transitionTo(mStateStart);
            } 
            {
                CatLog.d(this, "StateCmdParamsReady expecting CMD_PARAMS_READY="
                         + CMD_PARAMS_READY + " got " + msg.what);
                deferMessage(msg);
            } 
            addTaint(msg.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179592205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179592205;
            
            
                
                
                
                
            
                
                         
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.782 -0400", hash_original_field = "B68395A74681A0DDBC38547AD7EF0ABA", hash_generated_field = "9EA09889C86B65E89CD4E2117D5BA782")

    private static final int CMD_START = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.782 -0400", hash_original_field = "7EC9A96549249183230352DC0416584B", hash_generated_field = "D25DD8423B1F17A48262F8DB470BF25A")

    private static final int CMD_PARAMS_READY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.782 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "A7EDEBAD815A463752575C104B099CEC")

    private static RilMessageDecoder sInstance = null;
}

