package org.apache.commons.codec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Decoder {

    
    Object decode(Object pObject) throws DecoderException;
}
