package org.apache.commons.codec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Encoder {
    
    
    Object encode(Object pObject) throws EncoderException;
}
