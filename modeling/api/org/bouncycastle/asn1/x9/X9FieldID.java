/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;






public class X9FieldID extends ASN1Encodable implements X9ObjectIdentifiers {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.870 -0500", hash_original_field = "D987F2D38D968DCAC671804ADD2345C4", hash_generated_field = "C9026F3AA6576B332E83AF850E791F56")

    private DERObjectIdentifier     id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.872 -0500", hash_original_field = "43EF05C85BE711ADB242F75900838C86", hash_generated_field = "1557C13CB9AB38DEB6A065C70AD2F74E")

    private DERObject               parameters;

    /**
     * Constructor for elliptic curves over prime fields
     * <code>F<sub>2</sub></code>.
     * @param primeP The prime <code>p</code> defining the prime field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.875 -0500", hash_original_method = "947D632CD3BB9C70FFB74606AF4AA65C", hash_generated_method = "508BD9B946D6A7BF3A047D3EDB95BAE0")
    
public X9FieldID(BigInteger primeP)
    {
        this.id = prime_field;
        this.parameters = new DERInteger(primeP);
    }

    /**
     * Constructor for elliptic curves over binary fields
     * <code>F<sub>2<sup>m</sup></sub></code>.
     * @param m  The exponent <code>m</code> of
     * <code>F<sub>2<sup>m</sup></sub></code>.
     * @param k1 The integer <code>k1</code> where <code>x<sup>m</sup> +
     * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
     * represents the reduction polynomial <code>f(z)</code>.
     * @param k2 The integer <code>k2</code> where <code>x<sup>m</sup> +
     * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
     * represents the reduction polynomial <code>f(z)</code>.
     * @param k3 The integer <code>k3</code> where <code>x<sup>m</sup> +
     * x<sup>k3</sup> + x<sup>k2</sup> + x<sup>k1</sup> + 1</code>
     * represents the reduction polynomial <code>f(z)</code>..
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.878 -0500", hash_original_method = "E68F2B5FEB9AA2D283212DC970B04168", hash_generated_method = "0E76E3D7E0EC81B6A04E1E06BD0C9156")
    
public X9FieldID(int m, int k1, int k2, int k3)
    {
        this.id = characteristic_two_field;
        ASN1EncodableVector fieldIdParams = new ASN1EncodableVector();
        fieldIdParams.add(new DERInteger(m));
        
        if (k2 == 0) 
        {
            fieldIdParams.add(tpBasis);
            fieldIdParams.add(new DERInteger(k1));
        } 
        else 
        {
            fieldIdParams.add(ppBasis);
            ASN1EncodableVector pentanomialParams = new ASN1EncodableVector();
            pentanomialParams.add(new DERInteger(k1));
            pentanomialParams.add(new DERInteger(k2));
            pentanomialParams.add(new DERInteger(k3));
            fieldIdParams.add(new DERSequence(pentanomialParams));
        }
        
        this.parameters = new DERSequence(fieldIdParams);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.880 -0500", hash_original_method = "DE0F1786B89D9192DA26A23CD26B072E", hash_generated_method = "7FCEF89C10973A477E66A3DEC30F6228")
    
public X9FieldID(
        ASN1Sequence  seq)
    {
        this.id = (DERObjectIdentifier)seq.getObjectAt(0);
        this.parameters = (DERObject)seq.getObjectAt(1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.882 -0500", hash_original_method = "A03C04E1D63CA4FFA1D88D7678177C2A", hash_generated_method = "06C723F1DDE4AB1FB0029A84510B2416")
    
public DERObjectIdentifier getIdentifier()
    {
        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.884 -0500", hash_original_method = "1898F00B5F10CC32C939404F88AE77E4", hash_generated_method = "070EFE09E3EC39ACB49401714182A489")
    
public DERObject getParameters()
    {
        return parameters;
    }

    /**
     * Produce a DER encoding of the following structure.
     * <pre>
     *  FieldID ::= SEQUENCE {
     *      fieldType       FIELD-ID.&amp;id({IOSet}),
     *      parameters      FIELD-ID.&amp;Type({IOSet}{&#64;fieldType})
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:26.887 -0500", hash_original_method = "F64CE532B89E0DF8480CF348DC73F510", hash_generated_method = "BBCFFD1770E73F75CF8F2499785F772B")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(this.id);
        v.add(this.parameters);

        return new DERSequence(v);
    }

    
}

