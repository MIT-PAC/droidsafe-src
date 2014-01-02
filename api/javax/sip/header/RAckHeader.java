package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;

public interface RAckHeader extends Header {
    String NAME = "RAck";

    String getMethod();
    void setMethod(String method) throws ParseException;

    long getCSequenceNumber();
    void setCSequenceNumber(long cSequenceNumber) throws InvalidArgumentException;

    long getRSequenceNumber();
    void setRSequenceNumber(long rSequenceNumber) throws InvalidArgumentException;

    
    int getCSeqNumber();
    
    void setCSeqNumber(int cSeqNumber) throws InvalidArgumentException;

    
    int getRSeqNumber();
    
    void setRSeqNumber(int rSeqNumber) throws InvalidArgumentException;
}
