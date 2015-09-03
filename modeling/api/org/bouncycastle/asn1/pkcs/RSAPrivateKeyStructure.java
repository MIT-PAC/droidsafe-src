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


package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class RSAPrivateKeyStructure extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.448 -0500", hash_original_method = "0039F41BA6BCCE087186FCB1869A1B90", hash_generated_method = "E728EEFBC6F44F8E2AC588D2DFDE4D17")
    
public static RSAPrivateKeyStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.451 -0500", hash_original_method = "41979815CAFD85075B6EC35D10C3DA14", hash_generated_method = "03C05D2D0BE8CB3AEE32825E953DB42E")
    
public static RSAPrivateKeyStructure getInstance(
        Object  obj)
    {
        if (obj instanceof RSAPrivateKeyStructure)
        {
            return (RSAPrivateKeyStructure)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new RSAPrivateKeyStructure((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.419 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int         version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.421 -0500", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger  modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.424 -0500", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger  publicExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.427 -0500", hash_original_field = "9D6B5BA90FEDFF37C5B6F5CC23882550", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger  privateExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.431 -0500", hash_original_field = "50377F8205EBF135DDA636ED6FBA7D67", hash_generated_field = "5183F0D78D6F219DDA80B278EEDFCB67")

    private BigInteger  prime1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.434 -0500", hash_original_field = "F994C150D46BD0F239F58ECFAF200CF9", hash_generated_field = "F3BA5CAC09D7909BBB93DF7AF3E7C65D")

    private BigInteger  prime2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.436 -0500", hash_original_field = "B29548C88CF575AF79A810BDB27369C2", hash_generated_field = "377CF518661599B835EE4672F2F31B96")

    private BigInteger  exponent1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.438 -0500", hash_original_field = "6327B407F7EE79655C4F275B045D4A5B", hash_generated_field = "92E33EC2A21F45DD4C21202D0E40383E")

    private BigInteger  exponent2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.441 -0500", hash_original_field = "46FE5F9215FA4EF2050EDAA5AF0CAED2", hash_generated_field = "0572EDC7719F4FB5A9D30181C4C0D24C")

    private BigInteger  coefficient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.444 -0500", hash_original_field = "2F2AFF1EA6CD84375E51CAC2E1D047E0", hash_generated_field = "3ACC149C44ABAAABE0A228F468255A55")

    private ASN1Sequence otherPrimeInfos = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.455 -0500", hash_original_method = "CBF376BA3B510254060235C0D7FBAB4E", hash_generated_method = "73E2338878BF146754282D2B76F97740")
    
public RSAPrivateKeyStructure(
        BigInteger  modulus,
        BigInteger  publicExponent,
        BigInteger  privateExponent,
        BigInteger  prime1,
        BigInteger  prime2,
        BigInteger  exponent1,
        BigInteger  exponent2,
        BigInteger  coefficient)
    {
        this.version = 0;
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        this.privateExponent = privateExponent;
        this.prime1 = prime1;
        this.prime2 = prime2;
        this.exponent1 = exponent1;
        this.exponent2 = exponent2;
        this.coefficient = coefficient;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.459 -0500", hash_original_method = "7CCE248335D08B10FB2A36728BE792D2", hash_generated_method = "320833C67728FAB98217F02C6CCA2DEF")
    
public RSAPrivateKeyStructure(
        ASN1Sequence  seq)
    {
        Enumeration e = seq.getObjects();

        BigInteger  v = ((DERInteger)e.nextElement()).getValue();
        if (v.intValue() != 0 && v.intValue() != 1)
        {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }

        version = v.intValue();
        modulus = ((DERInteger)e.nextElement()).getValue();
        publicExponent = ((DERInteger)e.nextElement()).getValue();
        privateExponent = ((DERInteger)e.nextElement()).getValue();
        prime1 = ((DERInteger)e.nextElement()).getValue();
        prime2 = ((DERInteger)e.nextElement()).getValue();
        exponent1 = ((DERInteger)e.nextElement()).getValue();
        exponent2 = ((DERInteger)e.nextElement()).getValue();
        coefficient = ((DERInteger)e.nextElement()).getValue();
        
        if (e.hasMoreElements())
        {
            otherPrimeInfos = (ASN1Sequence)e.nextElement();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.461 -0500", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion()
    {
        return version;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.465 -0500", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "BDBC223BE67D236DB2FEEE4215FA313B")
    
public BigInteger getModulus()
    {
        return modulus;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.467 -0500", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent()
    {
        return publicExponent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.469 -0500", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "7923099ACFD3EE53AD0BB19048D39349")
    
public BigInteger getPrivateExponent()
    {
        return privateExponent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.472 -0500", hash_original_method = "B99C0F53E18C4C91C319BE2CCC968C4F", hash_generated_method = "4B038D2D5E6AAB0259D223C0219575ED")
    
public BigInteger getPrime1()
    {
        return prime1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.474 -0500", hash_original_method = "B93FCB0A892E4015213AB5057F688210", hash_generated_method = "DDF1747F78A1E46E2D712F35209598B9")
    
public BigInteger getPrime2()
    {
        return prime2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.476 -0500", hash_original_method = "762AADF12D80291EC0F289058DBDBCEC", hash_generated_method = "441B78AD00C1CCCCAE63E95E7BDC5AC5")
    
public BigInteger getExponent1()
    {
        return exponent1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.481 -0500", hash_original_method = "DDCFEFECC032A2CEE6C8950AE5D7E294", hash_generated_method = "23CE7DAE18DD4E9128C1E03F94830468")
    
public BigInteger getExponent2()
    {
        return exponent2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.483 -0500", hash_original_method = "C7CB66A1169BB550EC38CAFFC80D3C48", hash_generated_method = "F01BD76A1A203529710D00AFAB412AAC")
    
public BigInteger getCoefficient()
    {
        return coefficient;
    }

    /**
     * This outputs the key in PKCS1v2 format.
     * <pre>
     *      RSAPrivateKey ::= SEQUENCE {
     *                          version Version,
     *                          modulus INTEGER, -- n
     *                          publicExponent INTEGER, -- e
     *                          privateExponent INTEGER, -- d
     *                          prime1 INTEGER, -- p
     *                          prime2 INTEGER, -- q
     *                          exponent1 INTEGER, -- d mod (p-1)
     *                          exponent2 INTEGER, -- d mod (q-1)
     *                          coefficient INTEGER, -- (inverse of q) mod p
     *                          otherPrimeInfos OtherPrimeInfos OPTIONAL
     *                      }
     *
     *      Version ::= INTEGER { two-prime(0), multi(1) }
     *        (CONSTRAINED BY {-- version must be multi if otherPrimeInfos present --})
     * </pre>
     * <p>
     * This routine is written to output PKCS1 version 2.1, private keys.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.486 -0500", hash_original_method = "B4123323DA5D54F0794A6EC8CDF9F726", hash_generated_method = "6C257D5FA4E4BDBC396BD818135121BA")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(new DERInteger(version));                       // version
        v.add(new DERInteger(getModulus()));
        v.add(new DERInteger(getPublicExponent()));
        v.add(new DERInteger(getPrivateExponent()));
        v.add(new DERInteger(getPrime1()));
        v.add(new DERInteger(getPrime2()));
        v.add(new DERInteger(getExponent1()));
        v.add(new DERInteger(getExponent2()));
        v.add(new DERInteger(getCoefficient()));

        if (otherPrimeInfos != null)
        {
            v.add(otherPrimeInfos);
        }
        
        return new DERSequence(v);
    }

    
}

