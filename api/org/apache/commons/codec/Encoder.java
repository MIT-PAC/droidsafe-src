package org.apache.commons.codec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Encoder {
    
    
    Object encode(Object pObject) throws EncoderException;
}
