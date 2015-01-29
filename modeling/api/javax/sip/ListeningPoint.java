package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.text.ParseException;

import javax.sip.header.ContactHeader;

public interface ListeningPoint extends Cloneable {
    String TCP = "TCP";
    String UDP = "UDP";
    String SCTP = "SCTP";
    String TLS = "TLS";
    int PORT_5060 = 5060;
    int PORT_5061 = 5061;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getIPAddress();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getPort();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getTransport();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getSentBy();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setSentBy(String sentBy) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ContactHeader createContactHeader();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void sendHeartbeat(String s, int i) throws IOException;
}
