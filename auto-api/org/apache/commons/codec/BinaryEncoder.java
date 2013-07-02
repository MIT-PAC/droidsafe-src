package org.apache.commons.codec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface BinaryEncoder extends Encoder {
    
    
    byte[] encode(byte[] pArray) throws EncoderException;
}
