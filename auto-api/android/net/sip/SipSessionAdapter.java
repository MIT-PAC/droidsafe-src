package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipSessionAdapter extends ISipSessionListener.Stub {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.192 -0400", hash_original_method = "9DC88F582875C7B48FD10A36B308060E", hash_generated_method = "9DC88F582875C7B48FD10A36B308060E")
    public SipSessionAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.193 -0400", hash_original_method = "D9B50B01CCEF245E9F403677B72F58F1", hash_generated_method = "E62947AB106889C0347307D7A97DDE4C")
    public void onCalling(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.193 -0400", hash_original_method = "68CF4051D29CB5CF54EC2C1E1F865648", hash_generated_method = "FFC2144D23A7FB24691747176A4F34EA")
    public void onRinging(ISipSession session, SipProfile caller,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(caller.getTaint());
        addTaint(sessionDescription.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.194 -0400", hash_original_method = "6BF8C2840C366CDCDB34E8C031634864", hash_generated_method = "F4F605EA4C4A0B28AF07181371551383")
    public void onRingingBack(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.194 -0400", hash_original_method = "989B25B67069600E27C59C274FCE9EFB", hash_generated_method = "22947BCC12A51DDB81452076D18B7AE9")
    public void onCallEstablished(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(sessionDescription.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.194 -0400", hash_original_method = "073E01ADE6459CBFAF241C88609AC96D", hash_generated_method = "BDA96436DB2919372D82A6A4286AAE36")
    public void onCallEnded(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.195 -0400", hash_original_method = "9223F37C5FAB16D56CAF3C2F99691A4A", hash_generated_method = "757BA3379229086113C0089678D4F109")
    public void onCallBusy(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.195 -0400", hash_original_method = "17675A0A36A88FC90E050E318FD1948F", hash_generated_method = "1A7A6EF6A3C9BE37AFCA166E89190167")
    public void onCallTransferring(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(sessionDescription.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.195 -0400", hash_original_method = "F9A53ADFD8ADC5A16D2997779A028D82", hash_generated_method = "774185EEC5C6ADFDBEDB68A8754AEBD2")
    public void onCallChangeFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(errorCode);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.196 -0400", hash_original_method = "F4BB703172AA23C436248F0AB15BC933", hash_generated_method = "2A559A40AC5D720604E0860FF3125FB5")
    public void onError(ISipSession session, int errorCode, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(errorCode);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.196 -0400", hash_original_method = "590E6C4381192C4810AF077688524FDD", hash_generated_method = "31EA3606811CE72369E51B3437D2B4F9")
    public void onRegistering(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.196 -0400", hash_original_method = "9F59418FCCD622DBECC7E8A3F06CEC5A", hash_generated_method = "6F61E755B2B05E20C5F1625ADED5D4EF")
    public void onRegistrationDone(ISipSession session, int duration) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(duration);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.197 -0400", hash_original_method = "6E5C0169EEE1F95E017B7D3C4E3891CB", hash_generated_method = "18FB04BBFCC3067AE54042D87CDEAB9D")
    public void onRegistrationFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        addTaint(errorCode);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.197 -0400", hash_original_method = "64DDA0F3D8DA9A3D724B24465577AAD9", hash_generated_method = "FA233EC139FE2B2237AE3F07DE75B76E")
    public void onRegistrationTimeout(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
}

