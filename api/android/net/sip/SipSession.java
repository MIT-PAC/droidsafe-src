package android.net.sip;

// Droidsafe Imports
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SipSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.692 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "B127E608132911BCC4FB99E4A8F915FC")

    private ISipSession mSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.692 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "55B4CC9A7CFEB5835D007742DA36AADE")

    private Listener mListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.693 -0400", hash_original_method = "B71DAA3D1365DDABF697A1D97F8D88A8", hash_generated_method = "B1799D8A32814F6BA9312D2568FB397C")
      SipSession(ISipSession realSession) {
        mSession = realSession;
        if(realSession != null)        
        {
            try 
            {
                realSession.setListener(createListener());
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mSession = realSession;
        //if (realSession != null) {
            //try {
                //realSession.setListener(createListener());
            //} catch (RemoteException e) {
                //Log.e(TAG, "SipSession.setListener(): " + e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.693 -0400", hash_original_method = "26EA80DBAC1B6413B57EA6A425A19EE9", hash_generated_method = "1EA196BF620BE67735A18A6636993568")
      SipSession(ISipSession realSession, Listener listener) {
        this(realSession);
        addTaint(listener.getTaint());
        addTaint(realSession.getTaint());
        setListener(listener);
        // ---------- Original Method ----------
        //setListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.694 -0400", hash_original_method = "E9A721906097EBC1FEB98095FAB057F5", hash_generated_method = "7F39C80E5E6F0A5EF0ED1EC0EFA04476")
    public String getLocalIp() {
        try 
        {
String varF2012256E30E3EC5CDCFDBD3491148BF_731468385 =             mSession.getLocalIp();
            varF2012256E30E3EC5CDCFDBD3491148BF_731468385.addTaint(taint);
            return varF2012256E30E3EC5CDCFDBD3491148BF_731468385;
        } //End block
        catch (RemoteException e)
        {
String var87C6C180811A6958BEA96479D4BD7977_356609571 =             "127.0.0.1";
            var87C6C180811A6958BEA96479D4BD7977_356609571.addTaint(taint);
            return var87C6C180811A6958BEA96479D4BD7977_356609571;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.getLocalIp();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getLocalIp(): " + e);
            //return "127.0.0.1";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.694 -0400", hash_original_method = "87F54D512869FBB2D14566F63922D1B6", hash_generated_method = "049064C707AA4D45B2F5CD79860A0D5C")
    public SipProfile getLocalProfile() {
        try 
        {
SipProfile var57C14D4437C387D14E3EAF79E15CE042_572402118 =             mSession.getLocalProfile();
            var57C14D4437C387D14E3EAF79E15CE042_572402118.addTaint(taint);
            return var57C14D4437C387D14E3EAF79E15CE042_572402118;
        } //End block
        catch (RemoteException e)
        {
SipProfile var540C13E9E156B687226421B24F2DF178_1654891780 =             null;
            var540C13E9E156B687226421B24F2DF178_1654891780.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1654891780;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.getLocalProfile();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getLocalProfile(): " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.694 -0400", hash_original_method = "D61110CB083F8C813E52FD778D269E44", hash_generated_method = "E2D08FB11BCADE2909047BCA107499A8")
    public SipProfile getPeerProfile() {
        try 
        {
SipProfile var355ADE66436AA7F288242AF989730B16_538532765 =             mSession.getPeerProfile();
            var355ADE66436AA7F288242AF989730B16_538532765.addTaint(taint);
            return var355ADE66436AA7F288242AF989730B16_538532765;
        } //End block
        catch (RemoteException e)
        {
SipProfile var540C13E9E156B687226421B24F2DF178_310759214 =             null;
            var540C13E9E156B687226421B24F2DF178_310759214.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_310759214;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.getPeerProfile();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getPeerProfile(): " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.695 -0400", hash_original_method = "9EA9E21B58E34C7FB49C45688377E72F", hash_generated_method = "A291469F2DDA51DA542D8C9797588DD9")
    public int getState() {
        try 
        {
            int var2895FEA1DB332E0B32B0328975665ABE_2035798967 = (mSession.getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087720766 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1087720766;
        } //End block
        catch (RemoteException e)
        {
            int var40AACF781F4414032825CA25109A8CAA_1308820020 = (State.NOT_DEFINED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969763599 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969763599;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.getState();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getState(): " + e);
            //return State.NOT_DEFINED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.696 -0400", hash_original_method = "9EAE3F24E2C650B2D541A86A9F9A7795", hash_generated_method = "F878BDB0C5A550F9293B884A7E696A79")
    public boolean isInCall() {
        try 
        {
            boolean varC6B1CB2D264281604168431556748E3B_229279439 = (mSession.isInCall());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750893079 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_750893079;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1110192635 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58005597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_58005597;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.isInCall();
        //} catch (RemoteException e) {
            //Log.e(TAG, "isInCall(): " + e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.696 -0400", hash_original_method = "A52F1B195D0D0A598BE5EAF9C188D1E2", hash_generated_method = "87F6EEF2072C5A840DD5FC5D10B54E26")
    public String getCallId() {
        try 
        {
String var677631DBB4150DCB66606B97474409C2_2016905823 =             mSession.getCallId();
            var677631DBB4150DCB66606B97474409C2_2016905823.addTaint(taint);
            return var677631DBB4150DCB66606B97474409C2_2016905823;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_1575162473 =             null;
            var540C13E9E156B687226421B24F2DF178_1575162473.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1575162473;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mSession.getCallId();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getCallId(): " + e);
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.697 -0400", hash_original_method = "DF1CB7C0481108A53612C7FB72F6204A", hash_generated_method = "B57A845A372FD6A039C823BE04B31497")
    public void setListener(Listener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.697 -0400", hash_original_method = "8D2FD08823732E1C2D815A7E90C0FC77", hash_generated_method = "066339541D7449ABCA80A13BF6FD001B")
    public void register(int duration) {
        addTaint(duration);
        try 
        {
            mSession.register(duration);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.register(duration);
        //} catch (RemoteException e) {
            //Log.e(TAG, "register(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.698 -0400", hash_original_method = "E4AB4EE14705E79FAB12EC8A1515405F", hash_generated_method = "A6AD433C825E3D3860D4475E9C56E54F")
    public void unregister() {
        try 
        {
            mSession.unregister();
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.unregister();
        //} catch (RemoteException e) {
            //Log.e(TAG, "unregister(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.698 -0400", hash_original_method = "D9BC3F90AB4006B9EA6C3281D0F8E8EF", hash_generated_method = "2CB749862FC1F07B0E24438A82747057")
    public void makeCall(SipProfile callee, String sessionDescription,
            int timeout) {
        addTaint(timeout);
        addTaint(sessionDescription.getTaint());
        addTaint(callee.getTaint());
        try 
        {
            mSession.makeCall(callee, sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.makeCall(callee, sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "makeCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.699 -0400", hash_original_method = "A5A5F75F0E41462274C36F9EA8217848", hash_generated_method = "469F37BD8D17F937E26D2C7513BC05A7")
    public void answerCall(String sessionDescription, int timeout) {
        addTaint(timeout);
        addTaint(sessionDescription.getTaint());
        try 
        {
            mSession.answerCall(sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.answerCall(sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "answerCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.700 -0400", hash_original_method = "B98ACA998657ED3CD995605D9A274D2E", hash_generated_method = "95337EA4865B56451573D91D38E87EC4")
    public void endCall() {
        try 
        {
            mSession.endCall();
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.endCall();
        //} catch (RemoteException e) {
            //Log.e(TAG, "endCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.701 -0400", hash_original_method = "0DCF9DE8E2729C90E933890D545801E4", hash_generated_method = "79AC994AED6E9C475B3495ED30943CBA")
    public void changeCall(String sessionDescription, int timeout) {
        addTaint(timeout);
        addTaint(sessionDescription.getTaint());
        try 
        {
            mSession.changeCall(sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSession.changeCall(sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "changeCall(): " + e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.702 -0400", hash_original_method = "457DE503669A22F9796CDD5163AC081E", hash_generated_method = "055047EE0ED6979F113A6041A5BB7E83")
     ISipSession getRealSession() {
ISipSession var4330E14CA251960F6A23F8F7761A1A41_1987203933 =         mSession;
        var4330E14CA251960F6A23F8F7761A1A41_1987203933.addTaint(taint);
        return var4330E14CA251960F6A23F8F7761A1A41_1987203933;
        // ---------- Original Method ----------
        //return mSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.710 -0400", hash_original_method = "346C5E2A278D0A9A8B61352C5712D581", hash_generated_method = "BA737F97F1F0E8C104252261B2FAAAF0")
    private ISipSessionListener createListener() {
ISipSessionListener var62156A043DEFA336FA475DFB40F6B5B3_1331443629 =         new ISipSessionListener.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.704 -0400", hash_original_method = "F6AAC6893DA28A6718407EB8FE09E79E", hash_generated_method = "C3253E32BB5451632A59326BD6264842")
        public void onCalling(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCalling(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCalling(SipSession.this);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.705 -0400", hash_original_method = "F39F3E64BA1A6416EAD6DDAB559ACFA9", hash_generated_method = "3E2AF7ED97FDE6682C82B418B5F978C0")
        public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(caller.getTaint());
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRinging(SipSession.this, caller,
                            sessionDescription);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRinging(SipSession.this, caller,
                            //sessionDescription);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.705 -0400", hash_original_method = "6B72F4AC5AF01B3C76E99D25DF7CE23C", hash_generated_method = "2627628636011EEFDCCD55DE13E4798D")
        public void onRingingBack(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRingingBack(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRingingBack(SipSession.this);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.706 -0400", hash_original_method = "7B493B636814EC87BC27F7B3F6ABFCA1", hash_generated_method = "8B36DE93AA9C18B06A60107710582C69")
        public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCallEstablished(SipSession.this,
                            sessionDescription);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCallEstablished(SipSession.this,
                            //sessionDescription);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.706 -0400", hash_original_method = "AA30F7F581FD80E3580953394BBBB04E", hash_generated_method = "F6C39C39D8D6EB7B66909C0D640A2BDD")
        public void onCallEnded(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCallEnded(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCallEnded(SipSession.this);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.706 -0400", hash_original_method = "07497F1819563A3E4B5DE3C018AD8629", hash_generated_method = "7D4D470E8E6A2DB2E30C4932107CE510")
        public void onCallBusy(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCallBusy(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCallBusy(SipSession.this);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.707 -0400", hash_original_method = "1A8896FB5D333A131446D18B22452BAA", hash_generated_method = "E066080844E7FF88EC2F99EAE9AF4509")
        public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCallTransferring(
                            new SipSession(session, SipSession.this.mListener),
                            sessionDescription);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCallTransferring(
                            //new SipSession(session, SipSession.this.mListener),
                            //sessionDescription);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.707 -0400", hash_original_method = "874992DC0EF89EE44CCC20DF46598EA2", hash_generated_method = "80F37854CDE889C7AA4E7220EBAAEF44")
        public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onCallChangeFailed(SipSession.this, errorCode,
                            message);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onCallChangeFailed(SipSession.this, errorCode,
                            //message);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.708 -0400", hash_original_method = "5CA7526479580C1B86EDF9030D6C8D8F", hash_generated_method = "EC107F7C316794E69AFEBC78A8DD5EEF")
        public void onError(ISipSession session, int errorCode, String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onError(SipSession.this, errorCode, message);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onError(SipSession.this, errorCode, message);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.708 -0400", hash_original_method = "000778F0FB8347C3C0C1BE031E88B800", hash_generated_method = "B431841EBC9E9CA59CC0BC50A93FDE70")
        public void onRegistering(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRegistering(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRegistering(SipSession.this);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.708 -0400", hash_original_method = "33C53CCC0AA43F97F76FD9E19F36CB34", hash_generated_method = "0A3323072D1F932C9DA10CDF52790CA8")
        public void onRegistrationDone(ISipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(duration);
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRegistrationDone(SipSession.this, duration);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRegistrationDone(SipSession.this, duration);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.709 -0400", hash_original_method = "62D838A50BD723A90EE32C76390900AC", hash_generated_method = "38C5AD3C9C39B7F18A367758B0D65C69")
        public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(message.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRegistrationFailed(SipSession.this, errorCode,
                            message);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRegistrationFailed(SipSession.this, errorCode,
                            //message);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.709 -0400", hash_original_method = "65F153D5FCC86BC79261A858F3680A02", hash_generated_method = "6CBBF2F9CD1321A856E12D0F59EA9D36")
        public void onRegistrationTimeout(ISipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            if(mListener != null)            
            {
                mListener.onRegistrationTimeout(SipSession.this);
            } //End block
            // ---------- Original Method ----------
            //if (mListener != null) {
                    //mListener.onRegistrationTimeout(SipSession.this);
                //}
        }
};
        var62156A043DEFA336FA475DFB40F6B5B3_1331443629.addTaint(taint);
        return var62156A043DEFA336FA475DFB40F6B5B3_1331443629;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.711 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "362016197A85F3060127375CB2C169F9")
        private  State() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static String toString(int state) {
            switch (state) {
                case READY_TO_CALL:
                    return "READY_TO_CALL";
                case REGISTERING:
                    return "REGISTERING";
                case DEREGISTERING:
                    return "DEREGISTERING";
                case INCOMING_CALL:
                    return "INCOMING_CALL";
                case INCOMING_CALL_ANSWERING:
                    return "INCOMING_CALL_ANSWERING";
                case OUTGOING_CALL:
                    return "OUTGOING_CALL";
                case OUTGOING_CALL_RING_BACK:
                    return "OUTGOING_CALL_RING_BACK";
                case OUTGOING_CALL_CANCELING:
                    return "OUTGOING_CALL_CANCELING";
                case IN_CALL:
                    return "IN_CALL";
                case PINGING:
                    return "PINGING";
                default:
                    return "NOT_DEFINED";
            }
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "99A1F425B57D19FD75E48DF2C2C74A47", hash_generated_field = "D6CF7815116771C30F5505C0D30DAAA0")

        public static final int READY_TO_CALL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "23212F5EE4F8A111A02BC17B034D7D77", hash_generated_field = "6E8D637253813E25EE79327490FD11DB")

        public static final int REGISTERING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "238419291A66C1089DF7A69A3DCDAE34", hash_generated_field = "53325B9453E2CDBB5536AA0006D59656")

        public static final int DEREGISTERING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "7F7D4BEEA76C0E0FBB872E6F7B2C9E42", hash_generated_field = "4CF84D38E6E85F0013C36CDED43365C3")

        public static final int INCOMING_CALL = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "B7BB9561DD6FD2BDAA83862BE868FC7C", hash_generated_field = "8FCBA6A42A23BE1381F16A8A22F19DFB")

        public static final int INCOMING_CALL_ANSWERING = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "9D8A65355A87278E5637B5FCA9F77F71", hash_generated_field = "D525E8AB9F7FA02B8F0A85C344DB10F6")

        public static final int OUTGOING_CALL = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "D6A1E138D04923F28A4070DA4D4C3CB8", hash_generated_field = "427EF79B93399A5C3B799BBBE9407455")

        public static final int OUTGOING_CALL_RING_BACK = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "8A154CBDEBD55CB733461C499E6BFB17", hash_generated_field = "03C3904064D9ACFD5D047226208158C2")

        public static final int OUTGOING_CALL_CANCELING = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.712 -0400", hash_original_field = "0049140B8BB0B18A3B2E9943AB155113", hash_generated_field = "2DD221BAEB49EF885927070B38698CD6")

        public static final int IN_CALL = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.713 -0400", hash_original_field = "785460D49D2EB9EA797E7FE950A2EDF6", hash_generated_field = "FD07CBF55A8245950B7B2648AFEEBDFB")

        public static final int PINGING = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.713 -0400", hash_original_field = "1624A640D44E34DB103131BCABD62C6A", hash_generated_field = "43AC0184E67B2E974A2CDEEC81A3D3DF")

        public static final int ENDING_CALL = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.713 -0400", hash_original_field = "BFB26318EC54871807746114F98B080E", hash_generated_field = "777618F477CD835F0BBFD9A5E1AF42B8")

        public static final int NOT_DEFINED = 101;
    }


    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.713 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.714 -0400", hash_original_method = "AE0E913F9E3F8804DBC653BF8673EC2F", hash_generated_method = "DEA829A09039A527CA98846EDC2F4ACF")
        public void onCalling(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.714 -0400", hash_original_method = "A6495E0C14482D9554C3F987B616D040", hash_generated_method = "82E31F1EE9EA1D2D69826ED3176D1339")
        public void onRinging(SipSession session, SipProfile caller,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(caller.getTaint());
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.715 -0400", hash_original_method = "3040682D1BCFEA9BA338FA9FE200A62D", hash_generated_method = "734D120B16431C158B81B709F8D3F8DF")
        public void onRingingBack(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.715 -0400", hash_original_method = "E5D299BA3CDE0EE166AC2795783FB427", hash_generated_method = "94A782AF16BA608B7DD3B8B3191BD3F0")
        public void onCallEstablished(SipSession session,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.716 -0400", hash_original_method = "711404AF80F30F53943AF0817E2DC7DA", hash_generated_method = "4B4B0C8857AD559F3C6FAE56F4202E36")
        public void onCallEnded(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.716 -0400", hash_original_method = "DF73FA582D888219D7BAD8AC6A6DFD56", hash_generated_method = "3CB7A353A87EFF26ADA549ED713B3DD5")
        public void onCallBusy(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.726 -0400", hash_original_method = "BA5AD9CB5800C0FF06E65720317D213F", hash_generated_method = "4EC63AE57CEAA7272E7AAD95E1142F4F")
        public void onCallTransferring(SipSession newSession,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(sessionDescription.getTaint());
            addTaint(newSession.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.727 -0400", hash_original_method = "4CD681E2D11D80A916993A5E2A67B6D2", hash_generated_method = "F83149F4BD4EA11D29727C61E0F0CECC")
        public void onError(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(errorMessage.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.728 -0400", hash_original_method = "98747504BDA403336DDC3899112D7C4E", hash_generated_method = "BB943BDAA6E193FB7EB38A804D912599")
        public void onCallChangeFailed(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(errorMessage.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.729 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "49556F3917EE074EE7287D4C2426EBC3")
        public void onRegistering(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.729 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "47AF0550681D0CFCDB1972F11C6B9630")
        public void onRegistrationDone(SipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(duration);
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.730 -0400", hash_original_method = "3E873AF3736F468DF3025CAE14D73D95", hash_generated_method = "CFAACD510C8227276A30DC44ACC20937")
        public void onRegistrationFailed(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(errorMessage.getTaint());
            addTaint(errorCode);
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.730 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "92DD4357599040EC3BD89E95FDDF4AD7")
        public void onRegistrationTimeout(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.731 -0400", hash_original_field = "D9ED94DB6A5D4F0166BBD806D4CCC0A3", hash_generated_field = "C71A0754A378907E73E85A0E7FA4A060")

    private static final String TAG = "SipSession";
    // orphaned legacy method
    public void onCallBusy(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallBusy(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onRegistrationFailed(SipSession.this, errorCode,
                            message);
                }
            }
    
    // orphaned legacy method
    public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallEstablished(SipSession.this,
                            sessionDescription);
                }
            }
    
    // orphaned legacy method
    public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onRinging(SipSession.this, caller,
                            sessionDescription);
                }
            }
    
    // orphaned legacy method
    public void onRegistrationTimeout(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistrationTimeout(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onCalling(ISipSession session) {
                if (mListener != null) {
                    mListener.onCalling(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onRingingBack(ISipSession session) {
                if (mListener != null) {
                    mListener.onRingingBack(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onCallEnded(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallEnded(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallTransferring(
                            new SipSession(session, SipSession.this.mListener),
                            sessionDescription);
                }
            }
    
    // orphaned legacy method
    public void onRegistrationDone(ISipSession session, int duration) {
                if (mListener != null) {
                    mListener.onRegistrationDone(SipSession.this, duration);
                }
            }
    
    // orphaned legacy method
    public void onError(ISipSession session, int errorCode, String message) {
                if (mListener != null) {
                    mListener.onError(SipSession.this, errorCode, message);
                }
            }
    
    // orphaned legacy method
    public void onRegistering(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistering(SipSession.this);
                }
            }
    
    // orphaned legacy method
    public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onCallChangeFailed(SipSession.this, errorCode,
                            message);
                }
            }
    
}

