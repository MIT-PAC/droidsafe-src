package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public interface RSeqHeader extends Header {
    String NAME = "RSeq";

    long getSeqNumber();
    void setSeqNumber(long sequenceNumber) throws InvalidArgumentException;

    
    int getSequenceNumber();

    
    void setSequenceNumber(int sequenceNumber) throws InvalidArgumentException;
}
