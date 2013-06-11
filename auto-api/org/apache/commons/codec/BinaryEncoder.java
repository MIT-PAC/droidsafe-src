package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface BinaryEncoder extends Encoder {
    
    
    byte[] encode(byte[] pArray) throws EncoderException;
}

