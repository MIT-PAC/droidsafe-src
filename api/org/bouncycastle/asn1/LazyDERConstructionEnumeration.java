package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;






class LazyDERConstructionEnumeration implements Enumeration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.757 -0400", hash_original_field = "C6772D15B647BB7ED61F7BBE0ED3605F", hash_generated_field = "4CF3503F92E00E638FED895EEF5FDEF4")

    private ASN1InputStream aIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.757 -0400", hash_original_field = "2B85CE51745AE1A660BDCB5CADF22061", hash_generated_field = "ACAD0BA07B1F65450E862FD2224186B5")

    private Object nextObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.758 -0400", hash_original_method = "3BCCF8774D30BE9B39FD53E71BE1236C", hash_generated_method = "1026896E0191EEEFD95638149230A1BF")
    public  LazyDERConstructionEnumeration(byte[] encoded) {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
        // ---------- Original Method ----------
        //aIn = new ASN1InputStream(encoded, true);
        //nextObj = readObject();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.758 -0400", hash_original_method = "DE6A082C3D4BE08EE722248DFA2ED752", hash_generated_method = "8F0CDBF86B89EA4800464B375D8753D1")
    public boolean hasMoreElements() {
        boolean varD33774CA35F5B6F9427B64BA73FFD039_1326275074 = (nextObj != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1605813734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1605813734;
        // ---------- Original Method ----------
        //return nextObj != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.758 -0400", hash_original_method = "7A36257711540715C5E7C9FBD3EAD6E1", hash_generated_method = "8BE38E733BB5D27F130AD7DE9C7DAB5A")
    public Object nextElement() {
        Object o = nextObj;
        nextObj = readObject();
Object varBB0FDDC5CC83552BCB5FF7675B18007A_1927770921 =         o;
        varBB0FDDC5CC83552BCB5FF7675B18007A_1927770921.addTaint(taint);
        return varBB0FDDC5CC83552BCB5FF7675B18007A_1927770921;
        // ---------- Original Method ----------
        //Object o = nextObj;
        //nextObj = readObject();
        //return o;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.759 -0400", hash_original_method = "C7A49820E6202D53B06F271620A3165C", hash_generated_method = "8028F437BE474D98039DE3AB32D80B83")
    private Object readObject() {
        try 
        {
Object var744C7B728C1BF7AC9370DA8D8B9598D6_799629651 =             aIn.readObject();
            var744C7B728C1BF7AC9370DA8D8B9598D6_799629651.addTaint(taint);
            return var744C7B728C1BF7AC9370DA8D8B9598D6_799629651;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var57076C08DD969A64C4DD184B63F478EC_1603171679 = new ASN1ParsingException("malformed DER construction: " + e, e);
            var57076C08DD969A64C4DD184B63F478EC_1603171679.addTaint(taint);
            throw var57076C08DD969A64C4DD184B63F478EC_1603171679;
        } //End block
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

