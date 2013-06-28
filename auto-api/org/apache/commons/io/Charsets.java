package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class Charsets {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_method = "8FD756146451E8C119EC3E5D748CAC81", hash_generated_method = "8FD756146451E8C119EC3E5D748CAC81")
    public Charsets ()
    {
        //Synthesized constructor
    }


    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    
    public static Charset toCharset(String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "D58744246B267688AF10CAC6B14A6C65", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "0600F0B856FCF8BDF1D743E87231C60D", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "94D20F1B9BF2029F0E770101DC03793C", hash_generated_field = "626EA6A3B9EE55F06343FCE9005FB573")

    public static final Charset UTF_16 = Charset.forName("UTF-16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "2B116A426355094175BF82EC4605BA3D", hash_generated_field = "2E581518D8DE46969E014F48C2B46CE9")

    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "C73873183E30F635EB6C691AAE2FF81E", hash_generated_field = "3BB0DD9828DA9BEC43999249AAF9452C")

    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.211 -0400", hash_original_field = "682D7F045F955F6516043537CA460C17", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

    public static final Charset UTF_8 = Charset.forName("UTF-8");
}

