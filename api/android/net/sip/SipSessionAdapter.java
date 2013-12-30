package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class SipSessionAdapter extends ISipSessionListener.Stub {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.742 -0400", hash_original_method = "9DC88F582875C7B48FD10A36B308060E", hash_generated_method = "9DC88F582875C7B48FD10A36B308060E")
    public SipSessionAdapter ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.034 -0500", hash_original_method = "D9B50B01CCEF245E9F403677B72F58F1", hash_generated_method = "1F59E07F95F96B93C015CC1A44F36DA4")
    
public void onCalling(ISipSession session) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.036 -0500", hash_original_method = "68CF4051D29CB5CF54EC2C1E1F865648", hash_generated_method = "D1DCA4D1D2D1DC4201B71840BF695CE3")
    
public void onRinging(ISipSession session, SipProfile caller,
            String sessionDescription) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.038 -0500", hash_original_method = "6BF8C2840C366CDCDB34E8C031634864", hash_generated_method = "16D9629D0381F4824BD2087FC58BEDB5")
    
public void onRingingBack(ISipSession session) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.041 -0500", hash_original_method = "989B25B67069600E27C59C274FCE9EFB", hash_generated_method = "17D23BB3EB57109E6AB846C33C9BB2DA")
    
public void onCallEstablished(ISipSession session,
            String sessionDescription) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.043 -0500", hash_original_method = "073E01ADE6459CBFAF241C88609AC96D", hash_generated_method = "329646C4FAAAC6B8E0BFD7079A996CDA")
    
public void onCallEnded(ISipSession session) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.045 -0500", hash_original_method = "9223F37C5FAB16D56CAF3C2F99691A4A", hash_generated_method = "ECFE9AAB6BF663DF93467E1910BB661A")
    
public void onCallBusy(ISipSession session) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.047 -0500", hash_original_method = "17675A0A36A88FC90E050E318FD1948F", hash_generated_method = "B255E9AD2CD5F229DE6569938023BCFC")
    
public void onCallTransferring(ISipSession session,
            String sessionDescription) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.049 -0500", hash_original_method = "F9A53ADFD8ADC5A16D2997779A028D82", hash_generated_method = "E8B2E575AF5F456A2AD4B47F4B315AE8")
    
public void onCallChangeFailed(ISipSession session, int errorCode,
            String message) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.051 -0500", hash_original_method = "F4BB703172AA23C436248F0AB15BC933", hash_generated_method = "ACAC4D02D52F9E92F48DD9FFC3039B0E")
    
public void onError(ISipSession session, int errorCode, String message) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.053 -0500", hash_original_method = "590E6C4381192C4810AF077688524FDD", hash_generated_method = "61CA1A9FF3DE50597CDA165485FD3020")
    
public void onRegistering(ISipSession session) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.055 -0500", hash_original_method = "9F59418FCCD622DBECC7E8A3F06CEC5A", hash_generated_method = "EE58DB48CE5FDDECD99798224F7D131A")
    
public void onRegistrationDone(ISipSession session, int duration) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.057 -0500", hash_original_method = "6E5C0169EEE1F95E017B7D3C4E3891CB", hash_generated_method = "D878AEBFE45CA265494B13A77A38F85B")
    
public void onRegistrationFailed(ISipSession session, int errorCode,
            String message) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.060 -0500", hash_original_method = "64DDA0F3D8DA9A3D724B24465577AAD9", hash_generated_method = "EA444C2196CA3B4F0F6689E8FC6F6530")
    
public void onRegistrationTimeout(ISipSession session) {
    }

    
}

