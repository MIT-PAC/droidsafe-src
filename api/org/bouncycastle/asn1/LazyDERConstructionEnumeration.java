package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Enumeration;
import java.io.IOException;

class LazyDERConstructionEnumeration implements Enumeration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.310 -0400", hash_original_field = "C6772D15B647BB7ED61F7BBE0ED3605F", hash_generated_field = "4CF3503F92E00E638FED895EEF5FDEF4")

    private ASN1InputStream aIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.311 -0400", hash_original_field = "2B85CE51745AE1A660BDCB5CADF22061", hash_generated_field = "ACAD0BA07B1F65450E862FD2224186B5")

    private Object nextObj;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.311 -0400", hash_original_method = "3BCCF8774D30BE9B39FD53E71BE1236C", hash_generated_method = "1026896E0191EEEFD95638149230A1BF")
    public  LazyDERConstructionEnumeration(byte[] encoded) {
        aIn = new ASN1InputStream(encoded, true);
        nextObj = readObject();
        // ---------- Original Method ----------
        //aIn = new ASN1InputStream(encoded, true);
        //nextObj = readObject();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.311 -0400", hash_original_method = "DE6A082C3D4BE08EE722248DFA2ED752", hash_generated_method = "9A4F420A0DE1511A150A399B133ED1A5")
    public boolean hasMoreElements() {
        boolean varD33774CA35F5B6F9427B64BA73FFD039_16652869 = (nextObj != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496010176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496010176;
        // ---------- Original Method ----------
        //return nextObj != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.312 -0400", hash_original_method = "7A36257711540715C5E7C9FBD3EAD6E1", hash_generated_method = "69D9BBDEC98969F6B3DDE84F1B7B6273")
    public Object nextElement() {
        Object o = nextObj;
        nextObj = readObject();
Object varBB0FDDC5CC83552BCB5FF7675B18007A_1285497834 =         o;
        varBB0FDDC5CC83552BCB5FF7675B18007A_1285497834.addTaint(taint);
        return varBB0FDDC5CC83552BCB5FF7675B18007A_1285497834;
        // ---------- Original Method ----------
        //Object o = nextObj;
        //nextObj = readObject();
        //return o;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.312 -0400", hash_original_method = "C7A49820E6202D53B06F271620A3165C", hash_generated_method = "00E9B17FCB6FB44C681AB788C0BA45F4")
    private Object readObject() {
        try 
        {
Object var744C7B728C1BF7AC9370DA8D8B9598D6_1669410739 =             aIn.readObject();
            var744C7B728C1BF7AC9370DA8D8B9598D6_1669410739.addTaint(taint);
            return var744C7B728C1BF7AC9370DA8D8B9598D6_1669410739;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var57076C08DD969A64C4DD184B63F478EC_560010959 = new ASN1ParsingException("malformed DER construction: " + e, e);
            var57076C08DD969A64C4DD184B63F478EC_560010959.addTaint(taint);
            throw var57076C08DD969A64C4DD184B63F478EC_560010959;
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

