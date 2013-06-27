package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface BinaryEncoder extends Encoder {
    
    
    byte[] encode(byte[] pArray) throws EncoderException;
}
