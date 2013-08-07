package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface BinaryEncoder extends Encoder {
    
    
    byte[] encode(byte[] pArray) throws EncoderException;
}
