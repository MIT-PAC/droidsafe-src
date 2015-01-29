package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Encoder {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    Object encode(Object pObject) throws EncoderException;
}
