package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface BinaryDecoder extends Decoder {

    
    byte[] decode(byte[] pArray) throws DecoderException;
}
