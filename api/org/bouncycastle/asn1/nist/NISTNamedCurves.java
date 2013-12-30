package org.bouncycastle.asn1.nist;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;
import java.util.Hashtable;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.util.Strings;




public class NISTNamedCurves {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.249 -0500", hash_original_method = "60633E74F2BDAD39112953D581E8F19E", hash_generated_method = "DCF3E93F4F04112545B2D19828602D8F")
    
static void defineCurve(String name, DERObjectIdentifier oid)
    {
        objIds.put(name, oid);
        names.put(oid, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.251 -0500", hash_original_method = "D77DA041D0327B53EAF0F5E5B44EE309", hash_generated_method = "53BAB7CF499D9565B735A2139319EE15")
    
public static X9ECParameters getByName(
        String  name)
    {
        DERObjectIdentifier oid = (DERObjectIdentifier)objIds.get(Strings.toUpperCase(name));

        if (oid != null)
        {
            return getByOID(oid);
        }

        return null;
    }

    /**
     * return the X9ECParameters object for the named curve represented by
     * the passed in object identifier. Null if the curve isn't present.
     *
     * @param oid an object identifier representing a named curve, if present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.253 -0500", hash_original_method = "9392A09FCA21090738F843DB8D1E9A07", hash_generated_method = "7D645816D04AAD675C6A15E28D4239E7")
    
public static X9ECParameters getByOID(
        DERObjectIdentifier  oid)
    {
        return SECNamedCurves.getByOID(oid);
    }

    /**
     * return the object identifier signified by the passed in name. Null
     * if there is no object identifier associated with name.
     *
     * @return the object identifier associated with name, if present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.256 -0500", hash_original_method = "9C8D8DE03E7B8C724597A4D21DFDA13D", hash_generated_method = "370E5ECFED27845A7EFA75B9D2BA1492")
    
public static DERObjectIdentifier getOID(
        String  name)
    {
        return (DERObjectIdentifier)objIds.get(Strings.toUpperCase(name));
    }

    /**
     * return the named curve name represented by the given object identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.258 -0500", hash_original_method = "842AE20B2323661CD1A911AC1FDD139F", hash_generated_method = "FD2759FE761DD6B24CA207881D36F304")
    
public static String getName(
        DERObjectIdentifier  oid)
    {
        return (String)names.get(oid);
    }

    /**
     * returns an enumeration containing the name strings for curves
     * contained in this structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.261 -0500", hash_original_method = "516595D0FA5B972F8928119781E833A4", hash_generated_method = "2FF83217840B907592489710D19997C3")
    
public static Enumeration getNames()
    {
        return objIds.keys();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.244 -0500", hash_original_field = "C19E4507CE52B3E3E9AD718D35D22591", hash_generated_field = "1269679D47B7C172C418131040DC03AA")

    static final Hashtable objIds = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.247 -0500", hash_original_field = "D32C06F3AA2D7D68279CA3E62E7A38C6", hash_generated_field = "734EE0BA6EAA0FCA9CCE9A4B643B3169")

    static final Hashtable names = new Hashtable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.842 -0400", hash_original_method = "63679769172F8C8B10620B74D01768FE", hash_generated_method = "63679769172F8C8B10620B74D01768FE")
    public NISTNamedCurves ()
    {
        //Synthesized constructor
    }
    static {
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }
    
}

