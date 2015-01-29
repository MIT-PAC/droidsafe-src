package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface BinaryDecoder extends Decoder {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    byte[] decode(byte[] pArray) throws DecoderException;
}
