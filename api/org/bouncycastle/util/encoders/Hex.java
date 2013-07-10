package org.bouncycastle.util.encoders;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Hex {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.302 -0400", hash_original_method = "2062DFA17AA591396821D3397343CC6D", hash_generated_method = "2062DFA17AA591396821D3397343CC6D")
    public Hex ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static byte[] encode(
        byte[]    data) {
        return encode(data, 0, data.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] encode(
        byte[]    data,
        int       off,
        int       length) {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        try
        {
            encoder.encode(data, off, length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception encoding Hex string: " + e);
        }
        return bOut.toByteArray();
    }

    
    @DSModeled(DSC.SAFE)
    public static int encode(
        byte[]         data,
        OutputStream   out) throws IOException {
        return encoder.encode(data, 0, data.length, out);
    }

    
    @DSModeled(DSC.SAFE)
    public static int encode(
        byte[]         data,
        int            off,
        int            length,
        OutputStream   out) throws IOException {
        return encoder.encode(data, off, length, out);
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] decode(
        byte[]    data) {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        try
        {
            encoder.decode(data, 0, data.length, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding Hex string: " + e);
        }
        return bOut.toByteArray();
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] decode(
        String    data) {
        ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        try
        {
            encoder.decode(data, bOut);
        }
        catch (IOException e)
        {
            throw new RuntimeException("exception decoding Hex string: " + e);
        }
        return bOut.toByteArray();
    }

    
    @DSModeled(DSC.SAFE)
    public static int decode(
        String          data,
        OutputStream    out) throws IOException {
        return encoder.decode(data, out);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.307 -0400", hash_original_field = "47B1E2CC247F9E9D15422E2198CF336B", hash_generated_field = "AD615070C424731857294F4AC6DCDB3B")

    private static final Encoder encoder = new HexEncoder();
}

