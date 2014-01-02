package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.RemoteException;





public final class SipSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.464 -0500", hash_original_field = "AF9438B88AD0FB6B975D18D00203FE64", hash_generated_field = "C71A0754A378907E73E85A0E7FA4A060")

    private static final String TAG = "SipSession";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.538 -0500", hash_original_field = "D0612F19DE6148ECCBB71FC3A3423CE7", hash_generated_field = "B127E608132911BCC4FB99E4A8F915FC")


    private  ISipSession mSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.540 -0500", hash_original_field = "DB28047BDCC49490A13C1B72324FBE59", hash_generated_field = "55B4CC9A7CFEB5835D007742DA36AADE")

    private Listener mListener;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.543 -0500", hash_original_method = "B71DAA3D1365DDABF697A1D97F8D88A8", hash_generated_method = "B71DAA3D1365DDABF697A1D97F8D88A8")
    
SipSession(ISipSession realSession) {
        mSession = realSession;
        if (realSession != null) {
            try {
                realSession.setListener(createListener());
            } catch (RemoteException e) {
                Log.e(TAG, "SipSession.setListener(): " + e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.545 -0500", hash_original_method = "26EA80DBAC1B6413B57EA6A425A19EE9", hash_generated_method = "26EA80DBAC1B6413B57EA6A425A19EE9")
    
SipSession(ISipSession realSession, Listener listener) {
        this(realSession);
        setListener(listener);
    }

    /**
     * Gets the IP address of the local host on which this SIP session runs.
     *
     * @return the IP address of the local host
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.547 -0500", hash_original_method = "E9A721906097EBC1FEB98095FAB057F5", hash_generated_method = "677E55B4188D99256E0D8A054CA03870")
    
public String getLocalIp() {
        try {
            return mSession.getLocalIp();
        } catch (RemoteException e) {
            Log.e(TAG, "getLocalIp(): " + e);
            return "127.0.0.1";
        }
    }

    /**
     * Gets the SIP profile that this session is associated with.
     *
     * @return the SIP profile that this session is associated with
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.550 -0500", hash_original_method = "87F54D512869FBB2D14566F63922D1B6", hash_generated_method = "1FD2899D5D6411C331BF8D9381F9A633")
    
public SipProfile getLocalProfile() {
        try {
            return mSession.getLocalProfile();
        } catch (RemoteException e) {
            Log.e(TAG, "getLocalProfile(): " + e);
            return null;
        }
    }

    /**
     * Gets the SIP profile that this session is connected to. Only available
     * when the session is associated with a SIP dialog.
     *
     * @return the SIP profile that this session is connected to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.552 -0500", hash_original_method = "D61110CB083F8C813E52FD778D269E44", hash_generated_method = "A85C13DC8C4E5EC6A927456BDB42FB5A")
    
public SipProfile getPeerProfile() {
        try {
            return mSession.getPeerProfile();
        } catch (RemoteException e) {
            Log.e(TAG, "getPeerProfile(): " + e);
            return null;
        }
    }

    /**
     * Gets the session state. The value returned must be one of the states in
     * {@link State}.
     *
     * @return the session state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.554 -0500", hash_original_method = "9EA9E21B58E34C7FB49C45688377E72F", hash_generated_method = "A2A0E799F3A8BAA58BCAFEF701F28036")
    
public int getState() {
        try {
            return mSession.getState();
        } catch (RemoteException e) {
            Log.e(TAG, "getState(): " + e);
            return State.NOT_DEFINED;
        }
    }

    /**
     * Checks if the session is in a call.
     *
     * @return true if the session is in a call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.557 -0500", hash_original_method = "9EAE3F24E2C650B2D541A86A9F9A7795", hash_generated_method = "28DA8E137822FE176B67AF43B0F4F4B9")
    
public boolean isInCall() {
        try {
            return mSession.isInCall();
        } catch (RemoteException e) {
            Log.e(TAG, "isInCall(): " + e);
            return false;
        }
    }

    /**
     * Gets the call ID of the session.
     *
     * @return the call ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.559 -0500", hash_original_method = "A52F1B195D0D0A598BE5EAF9C188D1E2", hash_generated_method = "20463913D1EB1192B810213B0ACC00BE")
    
public String getCallId() {
        try {
            return mSession.getCallId();
        } catch (RemoteException e) {
            Log.e(TAG, "getCallId(): " + e);
            return null;
        }
    }


    /**
     * Sets the listener to listen to the session events. A {@code SipSession}
     * can only hold one listener at a time. Subsequent calls to this method
     * override the previous listener.
     *
     * @param listener to listen to the session events of this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.561 -0500", hash_original_method = "DF1CB7C0481108A53612C7FB72F6204A", hash_generated_method = "C77DE4E51514B6BC3180C67CBF94C5D7")
    
public void setListener(Listener listener) {
        mListener = listener;
    }


    /**
     * Performs registration to the server specified by the associated local
     * profile. The session listener is called back upon success or failure of
     * registration. The method is only valid to call when the session state is
     * in {@link State#READY_TO_CALL}.
     *
     * @param duration duration in second before the registration expires
     * @see Listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.563 -0500", hash_original_method = "8D2FD08823732E1C2D815A7E90C0FC77", hash_generated_method = "EE65FAFBA5FB190C5D75F1C5BE8FFF36")
    
public void register(int duration) {
        try {
            mSession.register(duration);
        } catch (RemoteException e) {
            Log.e(TAG, "register(): " + e);
        }
    }

    /**
     * Performs unregistration to the server specified by the associated local
     * profile. Unregistration is technically the same as registration with zero
     * expiration duration. The session listener is called back upon success or
     * failure of unregistration. The method is only valid to call when the
     * session state is in {@link State#READY_TO_CALL}.
     *
     * @see Listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.565 -0500", hash_original_method = "E4AB4EE14705E79FAB12EC8A1515405F", hash_generated_method = "6D93B3851227F8BFB9A1527B99C72931")
    
public void unregister() {
        try {
            mSession.unregister();
        } catch (RemoteException e) {
            Log.e(TAG, "unregister(): " + e);
        }
    }

    /**
     * Initiates a call to the specified profile. The session listener is called
     * back upon defined session events. The method is only valid to call when
     * the session state is in {@link State#READY_TO_CALL}.
     *
     * @param callee the SIP profile to make the call to
     * @param sessionDescription the session description of this call
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds. Default value (defined
     *        by SIP protocol) is used if {@code timeout} is zero or negative.
     * @see Listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.568 -0500", hash_original_method = "D9BC3F90AB4006B9EA6C3281D0F8E8EF", hash_generated_method = "86984BF195DEEE43217FDEDBE8C7C2D7")
    
public void makeCall(SipProfile callee, String sessionDescription,
            int timeout) {
        try {
            mSession.makeCall(callee, sessionDescription, timeout);
        } catch (RemoteException e) {
            Log.e(TAG, "makeCall(): " + e);
        }
    }

    /**
     * Answers an incoming call with the specified session description. The
     * method is only valid to call when the session state is in
     * {@link State#INCOMING_CALL}.
     *
     * @param sessionDescription the session description to answer this call
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds. Default value (defined
     *        by SIP protocol) is used if {@code timeout} is zero or negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.570 -0500", hash_original_method = "A5A5F75F0E41462274C36F9EA8217848", hash_generated_method = "1D57E00B47F68D45C9E581E52C489E47")
    
public void answerCall(String sessionDescription, int timeout) {
        try {
            mSession.answerCall(sessionDescription, timeout);
        } catch (RemoteException e) {
            Log.e(TAG, "answerCall(): " + e);
        }
    }

    /**
     * Ends an established call, terminates an outgoing call or rejects an
     * incoming call. The method is only valid to call when the session state is
     * in {@link State#IN_CALL},
     * {@link State#INCOMING_CALL},
     * {@link State#OUTGOING_CALL} or
     * {@link State#OUTGOING_CALL_RING_BACK}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.572 -0500", hash_original_method = "B98ACA998657ED3CD995605D9A274D2E", hash_generated_method = "1D4C436A95F19BCEA7E84EE01FE8E85F")
    
public void endCall() {
        try {
            mSession.endCall();
        } catch (RemoteException e) {
            Log.e(TAG, "endCall(): " + e);
        }
    }

    /**
     * Changes the session description during a call. The method is only valid
     * to call when the session state is in {@link State#IN_CALL}.
     *
     * @param sessionDescription the new session description
     * @param timeout the session will be timed out if the call is not
     *        established within {@code timeout} seconds. Default value (defined
     *        by SIP protocol) is used if {@code timeout} is zero or negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.574 -0500", hash_original_method = "0DCF9DE8E2729C90E933890D545801E4", hash_generated_method = "7AAFC9A026FCC50A76F1270B03E98963")
    
public void changeCall(String sessionDescription, int timeout) {
        try {
            mSession.changeCall(sessionDescription, timeout);
        } catch (RemoteException e) {
            Log.e(TAG, "changeCall(): " + e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.576 -0500", hash_original_method = "457DE503669A22F9796CDD5163AC081E", hash_generated_method = "457DE503669A22F9796CDD5163AC081E")
    
ISipSession getRealSession() {
        return mSession;
    }

    
    public static class State {

        /**
         * Converts the state to string.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.498 -0500", hash_original_method = "568E659DC654AF7F82B3FE327FE2A97B", hash_generated_method = "F153B60BE1575A843B5EC2EC8D1A33BE")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.468 -0500", hash_original_field = "89B4E0A703B641D3B00D63635A5F5DB3", hash_generated_field = "D6CF7815116771C30F5505C0D30DAAA0")

        public static final int READY_TO_CALL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.470 -0500", hash_original_field = "580AAF42E7166DB5FD9AC1620DB3BB92", hash_generated_field = "6E8D637253813E25EE79327490FD11DB")

        public static final int REGISTERING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.472 -0500", hash_original_field = "EF222475ED14682CC9C27068BA3D498D", hash_generated_field = "53325B9453E2CDBB5536AA0006D59656")

        public static final int DEREGISTERING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.475 -0500", hash_original_field = "B837ECD008DB85758F7809DB5C8EEABA", hash_generated_field = "4CF84D38E6E85F0013C36CDED43365C3")

        public static final int INCOMING_CALL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.477 -0500", hash_original_field = "B7333C42B8386CA24554907BF7B4E7CA", hash_generated_field = "8FCBA6A42A23BE1381F16A8A22F19DFB")

        public static final int INCOMING_CALL_ANSWERING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.479 -0500", hash_original_field = "F58256933B24D300ECA631F18CA433A1", hash_generated_field = "D525E8AB9F7FA02B8F0A85C344DB10F6")

        public static final int OUTGOING_CALL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.482 -0500", hash_original_field = "A99B8351F9D5CCDEB77807B02D1C5D92", hash_generated_field = "427EF79B93399A5C3B799BBBE9407455")

        public static final int OUTGOING_CALL_RING_BACK = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.485 -0500", hash_original_field = "9F4BF59AB46D916DEB18417D58E0E4C7", hash_generated_field = "03C3904064D9ACFD5D047226208158C2")

        public static final int OUTGOING_CALL_CANCELING = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.487 -0500", hash_original_field = "75E859461BC4EA3C685F176BBCE39F21", hash_generated_field = "2DD221BAEB49EF885927070B38698CD6")

        public static final int IN_CALL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.490 -0500", hash_original_field = "3E95FE792A699FE0739B97F1D9918942", hash_generated_field = "FD07CBF55A8245950B7B2648AFEEBDFB")

        public static final int PINGING = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.493 -0500", hash_original_field = "B446CA70B771C8D783F53BE1060A957F", hash_generated_field = "43AC0184E67B2E974A2CDEEC81A3D3DF")

        public static final int ENDING_CALL = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.495 -0500", hash_original_field = "B8570DD6362675C6ECF9AE581957B9C2", hash_generated_field = "777618F477CD835F0BBFD9A5E1AF42B8")

        public static final int NOT_DEFINED = 101;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.500 -0500", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "3C8E530756BAC73B98BD6601E6821720")
        
private State() {
        }
    }


    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.713 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            //Synthesized constructor
        }
        /**
         * Called when an INVITE request is sent to initiate a new call.
         *
         * @param session the session object that carries out the transaction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.506 -0500", hash_original_method = "AE0E913F9E3F8804DBC653BF8673EC2F", hash_generated_method = "4BD76B76AD1D7ED6C7D4EA6886F19CF2")
        
public void onCalling(SipSession session) {
        }

        /**
         * Called when an INVITE request is received.
         *
         * @param session the session object that carries out the transaction
         * @param caller the SIP profile of the caller
         * @param sessionDescription the caller's session description
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.508 -0500", hash_original_method = "A6495E0C14482D9554C3F987B616D040", hash_generated_method = "F7D2B2F3DFF01541550944824DDBFEE7")
        
public void onRinging(SipSession session, SipProfile caller,
                String sessionDescription) {
        }

        /**
         * Called when a RINGING response is received for the INVITE request sent
         *
         * @param session the session object that carries out the transaction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.511 -0500", hash_original_method = "3040682D1BCFEA9BA338FA9FE200A62D", hash_generated_method = "CAAB92B2FE1C02DD4BCA219B7AFDAD2B")
        
public void onRingingBack(SipSession session) {
        }

        /**
         * Called when the session is established.
         *
         * @param session the session object that is associated with the dialog
         * @param sessionDescription the peer's session description
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.513 -0500", hash_original_method = "E5D299BA3CDE0EE166AC2795783FB427", hash_generated_method = "30E8ED8B5F2EFB0EDF7AF05C52A4DEA7")
        
public void onCallEstablished(SipSession session,
                String sessionDescription) {
        }

        /**
         * Called when the session is terminated.
         *
         * @param session the session object that is associated with the dialog
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.515 -0500", hash_original_method = "711404AF80F30F53943AF0817E2DC7DA", hash_generated_method = "59E93A15BE6AEC5A1FBECAC978774B99")
        
public void onCallEnded(SipSession session) {
        }

        /**
         * Called when the peer is busy during session initialization.
         *
         * @param session the session object that carries out the transaction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.517 -0500", hash_original_method = "DF73FA582D888219D7BAD8AC6A6DFD56", hash_generated_method = "936390A4CBBD5E8A16D4D481EAAD3882")
        
public void onCallBusy(SipSession session) {
        }

        /**
         * Called when the call is being transferred to a new one.
         *
         * @hide
         * @param newSession the new session that the call will be transferred to
         * @param sessionDescription the new peer's session description
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.520 -0500", hash_original_method = "BA5AD9CB5800C0FF06E65720317D213F", hash_generated_method = "31DE44F9B3F8EE0CE72E5066DA9C5597")
        
public void onCallTransferring(SipSession newSession,
                String sessionDescription) {
        }

        /**
         * Called when an error occurs during session initialization and
         * termination.
         *
         * @param session the session object that carries out the transaction
         * @param errorCode error code defined in {@link SipErrorCode}
         * @param errorMessage error message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.522 -0500", hash_original_method = "4CD681E2D11D80A916993A5E2A67B6D2", hash_generated_method = "088B63961957732197A9E3C8FB47F4E7")
        
public void onError(SipSession session, int errorCode,
                String errorMessage) {
        }

        /**
         * Called when an error occurs during session modification negotiation.
         *
         * @param session the session object that carries out the transaction
         * @param errorCode error code defined in {@link SipErrorCode}
         * @param errorMessage error message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.524 -0500", hash_original_method = "98747504BDA403336DDC3899112D7C4E", hash_generated_method = "9BC2F438A4576A57E774AE431E7F4F80")
        
public void onCallChangeFailed(SipSession session, int errorCode,
                String errorMessage) {
        }

        /**
         * Called when a registration request is sent.
         *
         * @param session the session object that carries out the transaction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.527 -0500", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "6723A7318B1D6DCC42575E420836DAC4")
        
public void onRegistering(SipSession session) {
        }

        /**
         * Called when registration is successfully done.
         *
         * @param session the session object that carries out the transaction
         * @param duration duration in second before the registration expires
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.529 -0500", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "3EA76C656B8912C3A2A5543245302B75")
        
public void onRegistrationDone(SipSession session, int duration) {
        }

        /**
         * Called when the registration fails.
         *
         * @param session the session object that carries out the transaction
         * @param errorCode error code defined in {@link SipErrorCode}
         * @param errorMessage error message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.531 -0500", hash_original_method = "3E873AF3736F468DF3025CAE14D73D95", hash_generated_method = "FB0DA0EFD62D15BC45D1CEFC69F4214A")
        
public void onRegistrationFailed(SipSession session, int errorCode,
                String errorMessage) {
        }

        /**
         * Called when the registration gets timed out.
         *
         * @param session the session object that carries out the transaction
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.533 -0500", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "3BFDE7FCC6B045B1A489416B281101BE")
        
public void onRegistrationTimeout(SipSession session) {
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:29.613 -0500", hash_original_method = "346C5E2A278D0A9A8B61352C5712D581", hash_generated_method = "96775B494C1C9D031CB428176091C7E3")
    
private ISipSessionListener createListener() {
        return new ISipSessionListener.Stub() {
            public void onCalling(ISipSession session) {
                if (mListener != null) {
                    mListener.onCalling(SipSession.this);
                }
            }

            public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onRinging(SipSession.this, caller,
                            sessionDescription);
                }
            }

            public void onRingingBack(ISipSession session) {
                if (mListener != null) {
                    mListener.onRingingBack(SipSession.this);
                }
            }

            public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallEstablished(SipSession.this,
                            sessionDescription);
                }
            }

            public void onCallEnded(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallEnded(SipSession.this);
                }
            }

            public void onCallBusy(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallBusy(SipSession.this);
                }
            }

            public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallTransferring(
                            new SipSession(session, SipSession.this.mListener),
                            sessionDescription);

                }
            }

            public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onCallChangeFailed(SipSession.this, errorCode,
                            message);
                }
            }

            public void onError(ISipSession session, int errorCode, String message) {
                if (mListener != null) {
                    mListener.onError(SipSession.this, errorCode, message);
                }
            }

            public void onRegistering(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistering(SipSession.this);
                }
            }

            public void onRegistrationDone(ISipSession session, int duration) {
                if (mListener != null) {
                    mListener.onRegistrationDone(SipSession.this, duration);
                }
            }

            public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onRegistrationFailed(SipSession.this, errorCode,
                            message);
                }
            }

            public void onRegistrationTimeout(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistrationTimeout(SipSession.this);
                }
            }
        };
    }
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

