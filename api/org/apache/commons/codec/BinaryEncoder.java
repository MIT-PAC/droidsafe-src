package org.apache.commons.codec;

// Droidsafe Imports

public interface BinaryEncoder extends Encoder {
    
    
    byte[] encode(byte[] pArray) throws EncoderException;
}
