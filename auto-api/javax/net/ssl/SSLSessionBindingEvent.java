package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class SSLSessionBindingEvent extends EventObject {
    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.104 -0400", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "3E04B9AA5CFF48CC469DF83EFDD28EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        dsTaint.addTaint(session.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.104 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.104 -0400", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "7AC9297FA2E3B94F582AC8EE13268A44")
    @DSModeled(DSC.SAFE)
    public SSLSession getSession() {
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SSLSession) this.source;
    }

    
}

