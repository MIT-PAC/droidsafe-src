package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Decoder {

    
    Object decode(Object pObject) throws DecoderException;
}
