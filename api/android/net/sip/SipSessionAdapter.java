package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SipSessionAdapter extends ISipSessionListener.Stub {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.521 -0400", hash_original_method = "9DC88F582875C7B48FD10A36B308060E", hash_generated_method = "9DC88F582875C7B48FD10A36B308060E")
    public SipSessionAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.521 -0400", hash_original_method = "D9B50B01CCEF245E9F403677B72F58F1", hash_generated_method = "E62947AB106889C0347307D7A97DDE4C")
    public void onCalling(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.522 -0400", hash_original_method = "68CF4051D29CB5CF54EC2C1E1F865648", hash_generated_method = "C757AE8FCD4D81FC9EACE4C08C56B353")
    public void onRinging(ISipSession session, SipProfile caller,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(sessionDescription.getTaint());
        addTaint(caller.getTaint());
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.523 -0400", hash_original_method = "6BF8C2840C366CDCDB34E8C031634864", hash_generated_method = "F4F605EA4C4A0B28AF07181371551383")
    public void onRingingBack(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.523 -0400", hash_original_method = "989B25B67069600E27C59C274FCE9EFB", hash_generated_method = "35365E4E0CB0371137D80063C9581DC6")
    public void onCallEstablished(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(sessionDescription.getTaint());
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.524 -0400", hash_original_method = "073E01ADE6459CBFAF241C88609AC96D", hash_generated_method = "BDA96436DB2919372D82A6A4286AAE36")
    public void onCallEnded(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.525 -0400", hash_original_method = "9223F37C5FAB16D56CAF3C2F99691A4A", hash_generated_method = "757BA3379229086113C0089678D4F109")
    public void onCallBusy(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.525 -0400", hash_original_method = "17675A0A36A88FC90E050E318FD1948F", hash_generated_method = "FAA39AF2DA4A5595531F873E02E515EE")
    public void onCallTransferring(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(sessionDescription.getTaint());
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.526 -0400", hash_original_method = "F9A53ADFD8ADC5A16D2997779A028D82", hash_generated_method = "6C9E5E23FCCA2CAB90919EA033729853")
    public void onCallChangeFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(errorCode);
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.526 -0400", hash_original_method = "F4BB703172AA23C436248F0AB15BC933", hash_generated_method = "2D0A2B3B1BFA322D6C5BC333CCB4A388")
    public void onError(ISipSession session, int errorCode, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(errorCode);
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.527 -0400", hash_original_method = "590E6C4381192C4810AF077688524FDD", hash_generated_method = "31EA3606811CE72369E51B3437D2B4F9")
    public void onRegistering(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.527 -0400", hash_original_method = "9F59418FCCD622DBECC7E8A3F06CEC5A", hash_generated_method = "E79EF00A41AF17C2B2F78792AA821548")
    public void onRegistrationDone(ISipSession session, int duration) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(duration);
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.528 -0400", hash_original_method = "6E5C0169EEE1F95E017B7D3C4E3891CB", hash_generated_method = "1DCBB7A3C5D241EC154EE91949791B6B")
    public void onRegistrationFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(message.getTaint());
        addTaint(errorCode);
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.528 -0400", hash_original_method = "64DDA0F3D8DA9A3D724B24465577AAD9", hash_generated_method = "FA233EC139FE2B2237AE3F07DE75B76E")
    public void onRegistrationTimeout(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
}

