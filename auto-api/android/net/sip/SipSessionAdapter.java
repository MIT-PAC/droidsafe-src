package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipSessionAdapter extends ISipSessionListener.Stub {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.413 -0400", hash_original_method = "9715E957DAEDD35D621F9AA31EF66293", hash_generated_method = "9715E957DAEDD35D621F9AA31EF66293")
        public SipSessionAdapter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.413 -0400", hash_original_method = "D9B50B01CCEF245E9F403677B72F58F1", hash_generated_method = "9DEB96CE69E6653482900A8ACB154887")
    @DSModeled(DSC.SAFE)
    public void onCalling(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.414 -0400", hash_original_method = "68CF4051D29CB5CF54EC2C1E1F865648", hash_generated_method = "14C4348B9F5C8D7700B7D96753C2A2E4")
    @DSModeled(DSC.SAFE)
    public void onRinging(ISipSession session, SipProfile caller,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(sessionDescription);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.414 -0400", hash_original_method = "6BF8C2840C366CDCDB34E8C031634864", hash_generated_method = "503EDBDF33A829C2866BBCCBDDC459DF")
    @DSModeled(DSC.SAFE)
    public void onRingingBack(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.414 -0400", hash_original_method = "989B25B67069600E27C59C274FCE9EFB", hash_generated_method = "4AB1FE8A26B7F9E74AE0A7FF3D94C544")
    @DSModeled(DSC.SAFE)
    public void onCallEstablished(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(sessionDescription);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.414 -0400", hash_original_method = "073E01ADE6459CBFAF241C88609AC96D", hash_generated_method = "269D74CF441136C4CDDD2690CA1A8006")
    @DSModeled(DSC.SAFE)
    public void onCallEnded(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.415 -0400", hash_original_method = "9223F37C5FAB16D56CAF3C2F99691A4A", hash_generated_method = "F63402F75E9466228E7F27FB66839189")
    @DSModeled(DSC.SAFE)
    public void onCallBusy(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.415 -0400", hash_original_method = "17675A0A36A88FC90E050E318FD1948F", hash_generated_method = "AE07FE4960C3B32DF67D5CA554E2AC13")
    @DSModeled(DSC.SAFE)
    public void onCallTransferring(ISipSession session,
            String sessionDescription) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(sessionDescription);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.415 -0400", hash_original_method = "F9A53ADFD8ADC5A16D2997779A028D82", hash_generated_method = "23FC20D83A8193F98E4C4443C60BB9B0")
    @DSModeled(DSC.SAFE)
    public void onCallChangeFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(errorCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.415 -0400", hash_original_method = "F4BB703172AA23C436248F0AB15BC933", hash_generated_method = "9497B2CFF0D725C6E01D829F70F3CACC")
    @DSModeled(DSC.SAFE)
    public void onError(ISipSession session, int errorCode, String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(errorCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.416 -0400", hash_original_method = "590E6C4381192C4810AF077688524FDD", hash_generated_method = "34C2B27E97EFE0DA77DA58248472DA03")
    @DSModeled(DSC.SAFE)
    public void onRegistering(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.416 -0400", hash_original_method = "9F59418FCCD622DBECC7E8A3F06CEC5A", hash_generated_method = "D291DEE77EE6093C0B39522BBEDF2158")
    @DSModeled(DSC.SAFE)
    public void onRegistrationDone(ISipSession session, int duration) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(duration);
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.416 -0400", hash_original_method = "6E5C0169EEE1F95E017B7D3C4E3891CB", hash_generated_method = "0CB2C640D9320506C66BD3BAA056FA52")
    @DSModeled(DSC.SAFE)
    public void onRegistrationFailed(ISipSession session, int errorCode,
            String message) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(errorCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.426 -0400", hash_original_method = "64DDA0F3D8DA9A3D724B24465577AAD9", hash_generated_method = "0352790013B3675BCCD4B3C0637AA241")
    @DSModeled(DSC.SAFE)
    public void onRegistrationTimeout(ISipSession session) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
}

