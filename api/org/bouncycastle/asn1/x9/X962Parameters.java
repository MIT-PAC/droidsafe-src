package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;






public class X962Parameters extends ASN1Encodable implements ASN1Choice {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.500 -0500", hash_original_method = "55A2CB2C96C0C33B31CA7AEA2663FBF3", hash_generated_method = "DDF322C456CEA469213920233568B1DB")
    public static X962Parameters getInstance(
        Object obj)
    {
        if (obj == null || obj instanceof X962Parameters) 
        {
            return (X962Parameters)obj;
        }
        
        if (obj instanceof DERObject) 
        {
            return new X962Parameters((DERObject)obj);
        }
        
        throw new IllegalArgumentException("unknown object in getInstance()");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.501 -0500", hash_original_method = "B17019EF377DD19E4C24E28F933AA84F", hash_generated_method = "DBFE04E5155F551B4ADC2D3A86A808D6")
    public static X962Parameters getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(obj.getObject()); // must be explicitly tagged
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.499 -0500", hash_original_field = "8BC67800CF971A6A6793AC768B39A3BF", hash_generated_field = "E86090F478AFA9B23CA08BF4EF7AF349")

    private DERObject           params = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.502 -0500", hash_original_method = "1397E8178C44E6DF45387B6B68418706", hash_generated_method = "C5A54E8F79CC0D97089F1A31BE4849B7")
    public X962Parameters(
        X9ECParameters      ecParameters)
    {
        this.params = ecParameters.getDERObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.503 -0500", hash_original_method = "E0388E86E3A80BEB8232173BF59EDA72", hash_generated_method = "4FE362FA5978342D90A0A099CA6C09B8")
    public X962Parameters(
        DERObjectIdentifier  namedCurve)
    {
        this.params = namedCurve;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.504 -0500", hash_original_method = "5A42A0C55CC0229CDC548581C7883253", hash_generated_method = "E98F3DBF2EFFBE766DAB3B6583752E52")
    public X962Parameters(
        DERObject           obj)
    {
        this.params = obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.505 -0500", hash_original_method = "1C39324908CB279AE84BA869E213B319", hash_generated_method = "4FB0547BB441E60B1529F9BC55FA6F2B")
    public boolean isNamedCurve()
    {
        return (params instanceof DERObjectIdentifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.506 -0500", hash_original_method = "475403761996D653CB6A92100ADDE6B9", hash_generated_method = "AB8C5460909ABE2C6B4BC0B0185DA574")
    public boolean isImplicitlyCA()
    {
        return (params instanceof ASN1Null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.507 -0500", hash_original_method = "43CDC3C01D01649D40574BDD3C664EE0", hash_generated_method = "AA26205C31E7909BDC1FA9AE4CD9DB60")
    public DERObject getParameters()
    {
        return params;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * Parameters ::= CHOICE {
     *    ecParameters ECParameters,
     *    namedCurve   CURVES.&id({CurveNames}),
     *    implicitlyCA NULL
     * }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:54.507 -0500", hash_original_method = "C7E96020927A19D3FB38FF97469ACE2C", hash_generated_method = "67F97195C756EFDDF5E5BECA7CE8F396")
    public DERObject toASN1Object()
    {
        return params;
    }

    
}

