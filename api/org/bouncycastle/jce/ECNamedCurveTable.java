package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;
import java.util.Vector;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECNamedCurveTable {
    /**
     * return a parameter spec representing the passed in named
     * curve. The routine returns null if the curve is not present.
     * 
     * @param name the name of the curve requested
     * @return a parameter spec for the curve, null if it is not available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.436 -0500", hash_original_method = "658FDAFCB16D884F8A73D9920535B79B", hash_generated_method = "3176F3D3A7D2A21C8C3AFDADB5A8511A")
    
public static ECNamedCurveParameterSpec getParameterSpec(
        String  name)
    {
        X9ECParameters  ecP = X962NamedCurves.getByName(name);
        if (ecP == null)
        {
            try
            {
                ecP = X962NamedCurves.getByOID(new DERObjectIdentifier(name));
            }
            catch (IllegalArgumentException e)
            {
                // ignore - not an oid
            }
        }
        
        if (ecP == null)
        {
            ecP = SECNamedCurves.getByName(name);
            if (ecP == null)
            {
                try
                {
                    ecP = SECNamedCurves.getByOID(new DERObjectIdentifier(name));
                }
                catch (IllegalArgumentException e)
                {
                    // ignore - not an oid
                }
            }
        }

        // BEGIN android-removed
        // if (ecP == null)
        // {
        //     ecP = TeleTrusTNamedCurves.getByName(name);
        //     if (ecP == null)
        //     {
        //         try
        //         {
        //             ecP = TeleTrusTNamedCurves.getByOID(new DERObjectIdentifier(name));
        //         }
        //         catch (IllegalArgumentException e)
        //         {
        //             // ignore - not an oid
        //         }
        //     }
        // }
        // END android-removed

        if (ecP == null)
        {
            ecP = NISTNamedCurves.getByName(name);
        }
        
        if (ecP == null)
        {
            return null;
        }

        return new ECNamedCurveParameterSpec(
                                        name,
                                        ecP.getCurve(),
                                        ecP.getG(),
                                        ecP.getN(),
                                        ecP.getH(),
                                        ecP.getSeed());
    }

    /**
     * return an enumeration of the names of the available curves.
     *
     * @return an enumeration of the names of the available curves.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.439 -0500", hash_original_method = "7562D6B6F049D6670CBB9B00481D6EBB", hash_generated_method = "BBCD8CF7E4D239A16CC25971B540671E")
    
public static Enumeration getNames()
    {
        Vector v = new Vector();
        
        addEnumeration(v, X962NamedCurves.getNames());
        addEnumeration(v, SECNamedCurves.getNames());
        addEnumeration(v, NISTNamedCurves.getNames());
        // BEGIN android-removed
        // addEnumeration(v, TeleTrusTNamedCurves.getNames());
        // END android-removed

        return v.elements();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:36.441 -0500", hash_original_method = "18BFADD4FC9E195D778FFD96D4319E62", hash_generated_method = "94B42B2C3424706C7EC0D2F3A161EFA2")
    
private static void addEnumeration(
        Vector v, 
        Enumeration e)
    {
        while (e.hasMoreElements())
        {
            v.addElement(e.nextElement());
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.196 -0400", hash_original_method = "BD64543C1F72D4D2B4CE5D415F2B3F42", hash_generated_method = "BD64543C1F72D4D2B4CE5D415F2B3F42")
    public ECNamedCurveTable ()
    {
        //Synthesized constructor
    }
    
}

