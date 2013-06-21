package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.663 -0400", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "60A08C0FBE41C8160995AE7F013B9128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowEvents() {
        super(ALLOW_EVENTS);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.664 -0400", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "AE38046FD39C6A1B8605557CE226E428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AllowEvents(String m) {
        super(ALLOW_EVENTS);
        dsTaint.addTaint(m);
        // ---------- Original Method ----------
        //eventType = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.664 -0400", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "2513D4F15881EB394662AD8B656BA20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventType(String eventType) throws ParseException {
        dsTaint.addTaint(eventType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "AllowEvents, setEventType(), the eventType parameter is null");
        //this.eventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.664 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "C98A0BA88560DFB15A24DD3ACA4BE028")
    @DSModeled(DSC.SAFE)
    public String getEventType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.664 -0400", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "9E39547B832B10EB62BDDCC2A3735190")
    @DSModeled(DSC.SAFE)
    protected String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return eventType;
    }

    
    private static final long serialVersionUID = 617962431813193114L;
}

