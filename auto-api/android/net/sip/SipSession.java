package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.RemoteException;
import android.util.Log;

public final class SipSession {
    private ISipSession mSession;
    private Listener mListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.394 -0400", hash_original_method = "B71DAA3D1365DDABF697A1D97F8D88A8", hash_generated_method = "F159024882C3476F8A377D2EB928AC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SipSession(ISipSession realSession) {
        dsTaint.addTaint(realSession.dsTaint);
        {
            try 
            {
                realSession.setListener(createListener());
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.395 -0400", hash_original_method = "26EA80DBAC1B6413B57EA6A425A19EE9", hash_generated_method = "5EB0C916964D680F9B5C0EB3DFC4F3E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SipSession(ISipSession realSession, Listener listener) {
        this(realSession);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(realSession.dsTaint);
        setListener(listener);
        // ---------- Original Method ----------
        //setListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.396 -0400", hash_original_method = "E9A721906097EBC1FEB98095FAB057F5", hash_generated_method = "DBB7CE06EBEED40B71C87F16EE455B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalIp() {
        try 
        {
            String var0ADCD22A05C2B1D0284B748801B30A93_389447614 = (mSession.getLocalIp());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mSession.getLocalIp();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getLocalIp(): " + e);
            //return "127.0.0.1";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.397 -0400", hash_original_method = "87F54D512869FBB2D14566F63922D1B6", hash_generated_method = "DE41EA8FC20729835D7CE23BEE69F221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile getLocalProfile() {
        try 
        {
            SipProfile var5E1E1E65123BEE29A9CB22EAD573CFD8_1480766696 = (mSession.getLocalProfile());
        } //End block
        catch (RemoteException e)
        { }
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mSession.getLocalProfile();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getLocalProfile(): " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.397 -0400", hash_original_method = "D61110CB083F8C813E52FD778D269E44", hash_generated_method = "D1E6C9C150FA0AD677C92BC01B870AC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProfile getPeerProfile() {
        try 
        {
            SipProfile varA061DC31E8E2562D99E981A239D7EED5_833437665 = (mSession.getPeerProfile());
        } //End block
        catch (RemoteException e)
        { }
        return (SipProfile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mSession.getPeerProfile();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getPeerProfile(): " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.397 -0400", hash_original_method = "9EA9E21B58E34C7FB49C45688377E72F", hash_generated_method = "13F83EE2EC9DCE4BE39B3309D69EB734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getState() {
        try 
        {
            int var5C9BD891D63C83243CB7DCB3EA826EE9_1183407643 = (mSession.getState());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mSession.getState();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getState(): " + e);
            //return State.NOT_DEFINED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.397 -0400", hash_original_method = "9EAE3F24E2C650B2D541A86A9F9A7795", hash_generated_method = "4BDFA00F4D2443D5C9607EAABD55ACAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInCall() {
        try 
        {
            boolean var756F7B5AF584B3E3C76961D5CC547EFB_589994095 = (mSession.isInCall());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mSession.isInCall();
        //} catch (RemoteException e) {
            //Log.e(TAG, "isInCall(): " + e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.398 -0400", hash_original_method = "A52F1B195D0D0A598BE5EAF9C188D1E2", hash_generated_method = "DAA18E54FA3EAB47119DAF87D284146F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCallId() {
        try 
        {
            String varE47AB60BE9B4BCFFEC05E6A601322D1F_119411753 = (mSession.getCallId());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mSession.getCallId();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getCallId(): " + e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.398 -0400", hash_original_method = "DF1CB7C0481108A53612C7FB72F6204A", hash_generated_method = "D0CC6097B0E00F029FDD5F325D8127FE")
    @DSModeled(DSC.SAFE)
    public void setListener(Listener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.398 -0400", hash_original_method = "8D2FD08823732E1C2D815A7E90C0FC77", hash_generated_method = "A5465BBDE1FA66DD27AAE0C58BAE7CBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void register(int duration) {
        dsTaint.addTaint(duration);
        try 
        {
            mSession.register(duration);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.register(duration);
        //} catch (RemoteException e) {
            //Log.e(TAG, "register(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.398 -0400", hash_original_method = "E4AB4EE14705E79FAB12EC8A1515405F", hash_generated_method = "15915D17B734726F063C06BEDF2C586F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregister() {
        try 
        {
            mSession.unregister();
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.unregister();
        //} catch (RemoteException e) {
            //Log.e(TAG, "unregister(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.399 -0400", hash_original_method = "D9BC3F90AB4006B9EA6C3281D0F8E8EF", hash_generated_method = "C352CC7EB272DE3899FF0303CB209B67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void makeCall(SipProfile callee, String sessionDescription,
            int timeout) {
        dsTaint.addTaint(sessionDescription);
        dsTaint.addTaint(callee.dsTaint);
        dsTaint.addTaint(timeout);
        try 
        {
            mSession.makeCall(callee, sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.makeCall(callee, sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "makeCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.399 -0400", hash_original_method = "A5A5F75F0E41462274C36F9EA8217848", hash_generated_method = "090A100930F7FFE1D42AF30BE76BF6EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void answerCall(String sessionDescription, int timeout) {
        dsTaint.addTaint(sessionDescription);
        dsTaint.addTaint(timeout);
        try 
        {
            mSession.answerCall(sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.answerCall(sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "answerCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.399 -0400", hash_original_method = "B98ACA998657ED3CD995605D9A274D2E", hash_generated_method = "E55C0707BC087D614AF4675C2179A526")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endCall() {
        try 
        {
            mSession.endCall();
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.endCall();
        //} catch (RemoteException e) {
            //Log.e(TAG, "endCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.399 -0400", hash_original_method = "0DCF9DE8E2729C90E933890D545801E4", hash_generated_method = "93983E3EB9D2BBF5CCBEFB6A8A10FA88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void changeCall(String sessionDescription, int timeout) {
        dsTaint.addTaint(sessionDescription);
        dsTaint.addTaint(timeout);
        try 
        {
            mSession.changeCall(sessionDescription, timeout);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mSession.changeCall(sessionDescription, timeout);
        //} catch (RemoteException e) {
            //Log.e(TAG, "changeCall(): " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.399 -0400", hash_original_method = "457DE503669A22F9796CDD5163AC081E", hash_generated_method = "0F879EFBC8E50ECAF87CC82D4ED34056")
    @DSModeled(DSC.SAFE)
     ISipSession getRealSession() {
        return (ISipSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.403 -0400", hash_original_method = "346C5E2A278D0A9A8B61352C5712D581", hash_generated_method = "420398C2C8EDCC3F8E7B3A487850C5DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ISipSessionListener createListener() {
        ISipSessionListener varD1D5E737649D77ED2393D1B0AA330164_861084148 = (new ISipSessionListener.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.400 -0400", hash_original_method = "F6AAC6893DA28A6718407EB8FE09E79E", hash_generated_method = "B3426F2226E72EB6F7CAE9370DDBA818")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCalling(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onCalling(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onCalling(SipSession.this);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.400 -0400", hash_original_method = "F39F3E64BA1A6416EAD6DDAB559ACFA9", hash_generated_method = "751B04EEE0A27B02A54AB99D16D00801")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(caller.dsTaint);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(sessionDescription);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.401 -0400", hash_original_method = "6B72F4AC5AF01B3C76E99D25DF7CE23C", hash_generated_method = "D55D1B094FFB67D4C0C9E1CAFDCA4973")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRingingBack(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onRingingBack(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onRingingBack(SipSession.this);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.401 -0400", hash_original_method = "7B493B636814EC87BC27F7B3F6ABFCA1", hash_generated_method = "19162F1026CFC926146C4568B0E10952")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(sessionDescription);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.401 -0400", hash_original_method = "AA30F7F581FD80E3580953394BBBB04E", hash_generated_method = "8B7FC80960038F42AEF8C1183ADC82AD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCallEnded(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onCallEnded(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onCallEnded(SipSession.this);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.401 -0400", hash_original_method = "07497F1819563A3E4B5DE3C018AD8629", hash_generated_method = "C0F5C1DC6ECE5C50E09C001C8C427050")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCallBusy(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onCallBusy(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onCallBusy(SipSession.this);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.402 -0400", hash_original_method = "1A8896FB5D333A131446D18B22452BAA", hash_generated_method = "D1BD8A36576FF55F62F781DFBBB802E7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(sessionDescription);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.402 -0400", hash_original_method = "874992DC0EF89EE44CCC20DF46598EA2", hash_generated_method = "BB098BA478CCBAF20C087D1A735BD482")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.402 -0400", hash_original_method = "5CA7526479580C1B86EDF9030D6C8D8F", hash_generated_method = "D656CED9D836B25D926343E7D8A7D90E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onError(ISipSession session, int errorCode, String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
                {
                    mListener.onError(SipSession.this, errorCode, message);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onError(SipSession.this, errorCode, message);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.402 -0400", hash_original_method = "000778F0FB8347C3C0C1BE031E88B800", hash_generated_method = "F06F35303E2FE6676854AADCD1B0ED88")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRegistering(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onRegistering(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onRegistering(SipSession.this);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.402 -0400", hash_original_method = "33C53CCC0AA43F97F76FD9E19F36CB34", hash_generated_method = "6670414C602A37966D70A565C7100C30")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRegistrationDone(ISipSession session, int duration) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(duration);
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onRegistrationDone(SipSession.this, duration);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onRegistrationDone(SipSession.this, duration);
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.403 -0400", hash_original_method = "62D838A50BD723A90EE32C76390900AC", hash_generated_method = "775A135E6858B32E6A7972C4D6AA3993")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(message);
                dsTaint.addTaint(session.dsTaint);
                dsTaint.addTaint(errorCode);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.403 -0400", hash_original_method = "65F153D5FCC86BC79261A858F3680A02", hash_generated_method = "1D93388B2763CDB4C9761A33D04F7065")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onRegistrationTimeout(ISipSession session) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(session.dsTaint);
                {
                    mListener.onRegistrationTimeout(SipSession.this);
                } //End block
                // ---------- Original Method ----------
                //if (mListener != null) {
                    //mListener.onRegistrationTimeout(SipSession.this);
                //}
            }
});
        return (ISipSessionListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.404 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "362016197A85F3060127375CB2C169F9")
        @DSModeled(DSC.SAFE)
        private State() {
            // ---------- Original Method ----------
        }

        
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

        
        public static final int READY_TO_CALL = 0;
        public static final int REGISTERING = 1;
        public static final int DEREGISTERING = 2;
        public static final int INCOMING_CALL = 3;
        public static final int INCOMING_CALL_ANSWERING = 4;
        public static final int OUTGOING_CALL = 5;
        public static final int OUTGOING_CALL_RING_BACK = 6;
        public static final int OUTGOING_CALL_CANCELING = 7;
        public static final int IN_CALL = 8;
        public static final int PINGING = 9;
        public static final int ENDING_CALL = 10;
        public static final int NOT_DEFINED = 101;
    }


    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.404 -0400", hash_original_method = "926C6F0FEA0BD66B8F2ADD2E3C0DFCB9", hash_generated_method = "926C6F0FEA0BD66B8F2ADD2E3C0DFCB9")
                public Listener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.404 -0400", hash_original_method = "AE0E913F9E3F8804DBC653BF8673EC2F", hash_generated_method = "4B7E5AFEBDFFF813929F02D7E1895097")
        @DSModeled(DSC.SAFE)
        public void onCalling(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.404 -0400", hash_original_method = "A6495E0C14482D9554C3F987B616D040", hash_generated_method = "2CB0D2FB872459DDD2D528EAEC847AB8")
        @DSModeled(DSC.SAFE)
        public void onRinging(SipSession session, SipProfile caller,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(caller.dsTaint);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(sessionDescription);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.405 -0400", hash_original_method = "3040682D1BCFEA9BA338FA9FE200A62D", hash_generated_method = "83929D5A962166117775EB24521D0095")
        @DSModeled(DSC.SAFE)
        public void onRingingBack(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.405 -0400", hash_original_method = "E5D299BA3CDE0EE166AC2795783FB427", hash_generated_method = "356B532048B9B5D0D7E444F2143A61E2")
        @DSModeled(DSC.SAFE)
        public void onCallEstablished(SipSession session,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(sessionDescription);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.405 -0400", hash_original_method = "711404AF80F30F53943AF0817E2DC7DA", hash_generated_method = "8AFCEF665FED690406C231F804A4581A")
        @DSModeled(DSC.SAFE)
        public void onCallEnded(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.407 -0400", hash_original_method = "DF73FA582D888219D7BAD8AC6A6DFD56", hash_generated_method = "E7A209D4765BE7F3BC2551F78154F54C")
        @DSModeled(DSC.SAFE)
        public void onCallBusy(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.410 -0400", hash_original_method = "BA5AD9CB5800C0FF06E65720317D213F", hash_generated_method = "733AF8870BB89B58F89F53453DB95B7C")
        @DSModeled(DSC.SAFE)
        public void onCallTransferring(SipSession newSession,
                String sessionDescription) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(sessionDescription);
            dsTaint.addTaint(newSession.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.410 -0400", hash_original_method = "4CD681E2D11D80A916993A5E2A67B6D2", hash_generated_method = "542939ED4D5470AF6C1C4A23B9456AD9")
        @DSModeled(DSC.SAFE)
        public void onError(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(errorCode);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.411 -0400", hash_original_method = "98747504BDA403336DDC3899112D7C4E", hash_generated_method = "7D5624497C07E715477C34DA02446B1B")
        @DSModeled(DSC.SAFE)
        public void onCallChangeFailed(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(errorCode);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.411 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "0CF55F9661E17210ECF1F32ED5D8839E")
        @DSModeled(DSC.SAFE)
        public void onRegistering(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.411 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "6EAD2D0196E284D7EE872D2B037DBA14")
        @DSModeled(DSC.SAFE)
        public void onRegistrationDone(SipSession session, int duration) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(duration);
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.411 -0400", hash_original_method = "3E873AF3736F468DF3025CAE14D73D95", hash_generated_method = "785B6554A490FFC98C4D95CD1254C0EC")
        @DSModeled(DSC.SAFE)
        public void onRegistrationFailed(SipSession session, int errorCode,
                String errorMessage) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(errorMessage);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(errorCode);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.412 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "A434666F1F3585F4B05C628D7F353A79")
        @DSModeled(DSC.SAFE)
        public void onRegistrationTimeout(SipSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static final String TAG = "SipSession";
}

