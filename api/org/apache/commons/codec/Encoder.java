package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Encoder {
    
    
    Object encode(Object pObject) throws EncoderException;
}
