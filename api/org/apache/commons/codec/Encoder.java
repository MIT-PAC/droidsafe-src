package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Encoder {
    
    
    Object encode(Object pObject) throws EncoderException;
}
