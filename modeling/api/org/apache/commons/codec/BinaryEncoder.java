package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface BinaryEncoder extends Encoder {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    byte[] encode(byte[] pArray) throws EncoderException;
}
