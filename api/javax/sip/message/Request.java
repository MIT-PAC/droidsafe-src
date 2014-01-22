package javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.address.URI;

public interface Request extends Message {
    String ACK = "ACK";
    String BYE = "BYE";
    String CANCEL = "CANCEL";
    String INVITE = "INVITE";
    String OPTIONS = "OPTIONS";
    String REGISTER = "REGISTER";

    String INFO = "INFO";
    String MESSAGE = "MESSAGE";
    String NOTIFY = "NOTIFY";
    String PRACK = "PRACK";
    String PUBLISH = "PUBLISH";
    String REFER = "REFER";
    String SUBSCRIBE = "SUBSCRIBE";
    String UPDATE = "UPDATE";

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getMethod();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setMethod(String method) throws ParseException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    URI getRequestURI();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setRequestURI(URI requestURI);
}
