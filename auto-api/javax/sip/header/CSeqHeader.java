package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface CSeqHeader extends AllowHeader, RSeqHeader {
    String NAME = "CSeq";
}

