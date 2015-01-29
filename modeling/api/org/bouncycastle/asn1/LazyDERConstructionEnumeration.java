package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;

class LazyDERConstructionEnumeration implements Enumeration {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.583 -0500", hash_original_field = "ED3C5FC2B559D6337D714A057B3FBFA7", hash_generated_field = "4CF3503F92E00E638FED895EEF5FDEF4")

    private ASN1InputStream aIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.586 -0500", hash_original_field = "890F140C10403D5FEBF2B3F3ED0C4E54", hash_generated_field = "ACAD0BA07B1F65450E862FD2224186B5")

    private Object          nextObj;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.588 -0500", hash_original_method = "3BCCF8774D30BE9B39FD53E71BE1236C", hash_generated_method = "6FD7FF54042015CB4C36029D0A3F7EC4")
    
public LazyDERConstructionEnumeration(byte[] encoded)
    {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.590 -0500", hash_original_method = "DE6A082C3D4BE08EE722248DFA2ED752", hash_generated_method = "3E9BC425441608BDA81D5621012B4336")
    
public boolean hasMoreElements()
    {
        return nextObj != null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.592 -0500", hash_original_method = "7A36257711540715C5E7C9FBD3EAD6E1", hash_generated_method = "26B857524E390BF45A4BC93EE3A0A75E")
    
public Object nextElement()
    {
        Object o = nextObj;

        nextObj = readObject();

        return o;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.595 -0500", hash_original_method = "C7A49820E6202D53B06F271620A3165C", hash_generated_method = "FF2F5BFCEF82AA4F463ADCBD88815047")
    
private Object readObject()
    {
        try
        {
            return aIn.readObject();
        }
        catch (IOException e)
        {
            throw new ASN1ParsingException("malformed DER construction: " + e, e);
        }
    }
    
}

