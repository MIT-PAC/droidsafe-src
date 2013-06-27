package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Enumeration;
import java.io.IOException;

class LazyDERConstructionEnumeration implements Enumeration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.434 -0400", hash_original_field = "C6772D15B647BB7ED61F7BBE0ED3605F", hash_generated_field = "4CF3503F92E00E638FED895EEF5FDEF4")

    private ASN1InputStream aIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.434 -0400", hash_original_field = "2B85CE51745AE1A660BDCB5CADF22061", hash_generated_field = "ACAD0BA07B1F65450E862FD2224186B5")

    private Object nextObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.434 -0400", hash_original_method = "3BCCF8774D30BE9B39FD53E71BE1236C", hash_generated_method = "1026896E0191EEEFD95638149230A1BF")
    public  LazyDERConstructionEnumeration(byte[] encoded) {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
        // ---------- Original Method ----------
        //aIn = new ASN1InputStream(encoded, true);
        //nextObj = readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.434 -0400", hash_original_method = "DE6A082C3D4BE08EE722248DFA2ED752", hash_generated_method = "30B74C824E99ACA3E335149603F50B75")
    public boolean hasMoreElements() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580339936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580339936;
        // ---------- Original Method ----------
        //return nextObj != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.439 -0400", hash_original_method = "7A36257711540715C5E7C9FBD3EAD6E1", hash_generated_method = "579DA073F6CEFD220BED00D33D79C4BA")
    public Object nextElement() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1576536860 = null; //Variable for return #1
        Object o;
        o = nextObj;
        nextObj = readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1576536860 = o;
        varB4EAC82CA7396A68D541C85D26508E83_1576536860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576536860;
        // ---------- Original Method ----------
        //Object o = nextObj;
        //nextObj = readObject();
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.439 -0400", hash_original_method = "C7A49820E6202D53B06F271620A3165C", hash_generated_method = "044378E1F33863C81F9D7DA45FE5DD26")
    private Object readObject() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2121862149 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2121862149 = aIn.readObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("malformed DER construction: " + e, e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2121862149.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2121862149;
        // ---------- Original Method ----------
        //try
        //{
            //return aIn.readObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException("malformed DER construction: " + e, e);
        //}
    }

    
}

