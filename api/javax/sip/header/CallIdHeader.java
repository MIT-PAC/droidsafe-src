package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public interface CallIdHeader extends Header {
    String NAME = "Call-ID";

    String getCallId();
    void setCallId(String callId) throws ParseException;
}
