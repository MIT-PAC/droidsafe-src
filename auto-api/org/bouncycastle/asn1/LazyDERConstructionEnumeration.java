package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Enumeration;
import java.io.IOException;

class LazyDERConstructionEnumeration implements Enumeration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.880 -0400", hash_original_field = "C6772D15B647BB7ED61F7BBE0ED3605F", hash_generated_field = "4CF3503F92E00E638FED895EEF5FDEF4")

    private ASN1InputStream aIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.880 -0400", hash_original_field = "2B85CE51745AE1A660BDCB5CADF22061", hash_generated_field = "ACAD0BA07B1F65450E862FD2224186B5")

    private Object nextObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.880 -0400", hash_original_method = "3BCCF8774D30BE9B39FD53E71BE1236C", hash_generated_method = "1026896E0191EEEFD95638149230A1BF")
    public  LazyDERConstructionEnumeration(byte[] encoded) {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.880 -0400", hash_original_method = "DE6A082C3D4BE08EE722248DFA2ED752", hash_generated_method = "F9B902E3C7EC229175B52857CD490237")
    public boolean hasMoreElements() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777675651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777675651;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.881 -0400", hash_original_method = "7A36257711540715C5E7C9FBD3EAD6E1", hash_generated_method = "644AC3C14E6087B09F91D7654D3718E1")
    public Object nextElement() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1825101601 = null; 
        Object o = nextObj;
        nextObj = readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1825101601 = o;
        varB4EAC82CA7396A68D541C85D26508E83_1825101601.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1825101601;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.881 -0400", hash_original_method = "C7A49820E6202D53B06F271620A3165C", hash_generated_method = "51CD0E6EC0B07304FE6E825CC7E68A57")
    private Object readObject() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2015952570 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2015952570 = aIn.readObject();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("malformed DER construction: " + e, e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2015952570.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2015952570;
        
        
        
            
        
        
        
            
        
    }

    
}

