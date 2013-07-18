package org.bouncycastle.jce;

// Droidsafe Imports
import java.util.Enumeration;
import java.util.Vector;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ECNamedCurveTable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.196 -0400", hash_original_method = "BD64543C1F72D4D2B4CE5D415F2B3F42", hash_generated_method = "BD64543C1F72D4D2B4CE5D415F2B3F42")
    public ECNamedCurveTable ()
    {
        //Synthesized constructor
    }


    public static ECNamedCurveParameterSpec getParameterSpec(
        String  name) {
        X9ECParameters  ecP = X962NamedCurves.getByName(name);
        if (ecP == null)
        {
            try
            {
                ecP = X962NamedCurves.getByOID(new DERObjectIdentifier(name));
            }
            catch (IllegalArgumentException e)
            {
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
                }
            }
        }
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

    
    public static Enumeration getNames() {
        Vector v = new Vector();
        addEnumeration(v, X962NamedCurves.getNames());
        addEnumeration(v, SECNamedCurves.getNames());
        addEnumeration(v, NISTNamedCurves.getNames());
        return v.elements();
    }

    
    @DSModeled(DSC.SAFE)
    private static void addEnumeration(
        Vector v, 
        Enumeration e) {
        while (e.hasMoreElements())
        {
            v.addElement(e.nextElement());
        }
    }

    
}

