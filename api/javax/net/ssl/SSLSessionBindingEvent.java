package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;






public class SSLSessionBindingEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.673 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")


    private  String name;

    /**
     * Creates a new {@code SSLSessionBindingEvent} for the specified session
     * indicating a binding event for the specified name.
     *
     * @param session
     *            the session for which the event occurs.
     * @param name
     *            the name of the object being (un)bound.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.677 -0500", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "90723A476F526A2EA850C3D830BC6724")
    
public SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        this.name = name;
    }

    /**
     * Returns the name of the binding being added or removed.
     *
     * @return the name of the binding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.679 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns the session to which the binding is added or from which it is
     * removed.
     *
     * @return the session to which the binding is added or from which it is
     *         removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.681 -0500", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "D7052E91E04E03382DA1AE832DDB434D")
    
public SSLSession getSession() {
        return (SSLSession) this.source;
    }

    
}

