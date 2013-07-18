package org.apache.commons.codec;

// Droidsafe Imports

public interface BinaryDecoder extends Decoder {

    
    byte[] decode(byte[] pArray) throws DecoderException;
}
