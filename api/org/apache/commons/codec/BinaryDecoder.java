package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface BinaryDecoder extends Decoder {

    
    byte[] decode(byte[] pArray) throws DecoderException;
}
