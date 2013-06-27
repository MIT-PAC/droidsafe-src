package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.585 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.585 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.585 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.585 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.585 -0400", hash_original_field = "20BFD8B959FA5A8CFD340683DC2A9BA7", hash_generated_field = "5183F0D78D6F219DDA80B278EEDFCB67")

    private BigInteger prime1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.586 -0400", hash_original_field = "E2BFEA63AF9DE42C6E4FEFEBDF117F61", hash_generated_field = "F3BA5CAC09D7909BBB93DF7AF3E7C65D")

    private BigInteger prime2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.586 -0400", hash_original_field = "C810A5215079E8395136DF0E061D700B", hash_generated_field = "377CF518661599B835EE4672F2F31B96")

    private BigInteger exponent1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.586 -0400", hash_original_field = "9F3DEA20A14E9679832D37964B2D6191", hash_generated_field = "92E33EC2A21F45DD4C21202D0E40383E")

    private BigInteger exponent2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.586 -0400", hash_original_field = "16DEBEF90A0394D9B14C30C4281BCE0D", hash_generated_field = "0572EDC7719F4FB5A9D30181C4C0D24C")

    private BigInteger coefficient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.586 -0400", hash_original_field = "17CAC7C39D167EF2C058C29BFB1C320A", hash_generated_field = "3ACC149C44ABAAABE0A228F468255A55")

    private ASN1Sequence otherPrimeInfos = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.602 -0400", hash_original_method = "CBF376BA3B510254060235C0D7FBAB4E", hash_generated_method = "31188D1BC3205E4C4EF73CDBDCAB4094")
    public  RSAPrivateKeyStructure(
        BigInteger  modulus,
        BigInteger  publicExponent,
        BigInteger  privateExponent,
        BigInteger  prime1,
        BigInteger  prime2,
        BigInteger  exponent1,
        BigInteger  exponent2,
        BigInteger  coefficient) {
        this.version = 0;
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        this.privateExponent = privateExponent;
        this.prime1 = prime1;
        this.prime2 = prime2;
        this.exponent1 = exponent1;
        this.exponent2 = exponent2;
        this.coefficient = coefficient;
        // ---------- Original Method ----------
        //this.version = 0;
        //this.modulus = modulus;
        //this.publicExponent = publicExponent;
        //this.privateExponent = privateExponent;
        //this.prime1 = prime1;
        //this.prime2 = prime2;
        //this.exponent1 = exponent1;
        //this.exponent2 = exponent2;
        //this.coefficient = coefficient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.607 -0400", hash_original_method = "7CCE248335D08B10FB2A36728BE792D2", hash_generated_method = "822D8B226ADE1BC89FD490AD5C1D4532")
    public  RSAPrivateKeyStructure(
        ASN1Sequence  seq) {
        Enumeration e;
        e = seq.getObjects();
        BigInteger v;
        v = ((DERInteger)e.nextElement()).getValue();
        {
            boolean var28AD555B30D1C8862ECBC1BC18572CF6_1049949078 = (v.intValue() != 0 && v.intValue() != 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("wrong version for RSA private key");
            } //End block
        } //End collapsed parenthetic
        version = v.intValue();
        modulus = ((DERInteger)e.nextElement()).getValue();
        publicExponent = ((DERInteger)e.nextElement()).getValue();
        privateExponent = ((DERInteger)e.nextElement()).getValue();
        prime1 = ((DERInteger)e.nextElement()).getValue();
        prime2 = ((DERInteger)e.nextElement()).getValue();
        exponent1 = ((DERInteger)e.nextElement()).getValue();
        exponent2 = ((DERInteger)e.nextElement()).getValue();
        coefficient = ((DERInteger)e.nextElement()).getValue();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_2081305136 = (e.hasMoreElements());
            {
                otherPrimeInfos = (ASN1Sequence)e.nextElement();
            } //End block
        } //End collapsed parenthetic
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static RSAPrivateKeyStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static RSAPrivateKeyStructure getInstance(
        Object  obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.608 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "1FBA77C7BB413D4399664936029FE2CB")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934253192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934253192;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.608 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "F468C5A0B61AF3F5F3DFFACB7F833FA2")
    public BigInteger getModulus() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_807687797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_807687797 = modulus;
        varB4EAC82CA7396A68D541C85D26508E83_807687797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_807687797;
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.612 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "2B80245B9BE7B0B29E201B95E426F419")
    public BigInteger getPublicExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2022645515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2022645515 = publicExponent;
        varB4EAC82CA7396A68D541C85D26508E83_2022645515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2022645515;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.613 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "A5DED956EE9BA60E65465F39AF2761F1")
    public BigInteger getPrivateExponent() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_261602300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_261602300 = privateExponent;
        varB4EAC82CA7396A68D541C85D26508E83_261602300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_261602300;
        // ---------- Original Method ----------
        //return privateExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.616 -0400", hash_original_method = "B99C0F53E18C4C91C319BE2CCC968C4F", hash_generated_method = "C788C6C70276F0628D9ADC6DF038704C")
    public BigInteger getPrime1() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_874943359 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_874943359 = prime1;
        varB4EAC82CA7396A68D541C85D26508E83_874943359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_874943359;
        // ---------- Original Method ----------
        //return prime1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.620 -0400", hash_original_method = "B93FCB0A892E4015213AB5057F688210", hash_generated_method = "85620CEAEF8216FAE0D7A5D11E93C119")
    public BigInteger getPrime2() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1771054972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1771054972 = prime2;
        varB4EAC82CA7396A68D541C85D26508E83_1771054972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1771054972;
        // ---------- Original Method ----------
        //return prime2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.624 -0400", hash_original_method = "762AADF12D80291EC0F289058DBDBCEC", hash_generated_method = "FD919D4317B8D378095C57F18B696A59")
    public BigInteger getExponent1() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_955201960 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_955201960 = exponent1;
        varB4EAC82CA7396A68D541C85D26508E83_955201960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_955201960;
        // ---------- Original Method ----------
        //return exponent1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.627 -0400", hash_original_method = "DDCFEFECC032A2CEE6C8950AE5D7E294", hash_generated_method = "46819CA0400357F68C20B536E4B5CF60")
    public BigInteger getExponent2() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_798192463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_798192463 = exponent2;
        varB4EAC82CA7396A68D541C85D26508E83_798192463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_798192463;
        // ---------- Original Method ----------
        //return exponent2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.629 -0400", hash_original_method = "C7CB66A1169BB550EC38CAFFC80D3C48", hash_generated_method = "4DD84AEB630E424A431A450871635C62")
    public BigInteger getCoefficient() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_311794242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_311794242 = coefficient;
        varB4EAC82CA7396A68D541C85D26508E83_311794242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_311794242;
        // ---------- Original Method ----------
        //return coefficient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.637 -0400", hash_original_method = "B4123323DA5D54F0794A6EC8CDF9F726", hash_generated_method = "9883E8E8D73AA7738C57D16FD42F0E49")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1398456692 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(new DERInteger(version));
        v.add(new DERInteger(getModulus()));
        v.add(new DERInteger(getPublicExponent()));
        v.add(new DERInteger(getPrivateExponent()));
        v.add(new DERInteger(getPrime1()));
        v.add(new DERInteger(getPrime2()));
        v.add(new DERInteger(getExponent1()));
        v.add(new DERInteger(getExponent2()));
        v.add(new DERInteger(getCoefficient()));
        {
            v.add(otherPrimeInfos);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1398456692 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1398456692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1398456692;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(new DERInteger(version));
        //v.add(new DERInteger(getModulus()));
        //v.add(new DERInteger(getPublicExponent()));
        //v.add(new DERInteger(getPrivateExponent()));
        //v.add(new DERInteger(getPrime1()));
        //v.add(new DERInteger(getPrime2()));
        //v.add(new DERInteger(getExponent1()));
        //v.add(new DERInteger(getExponent2()));
        //v.add(new DERInteger(getCoefficient()));
        //if (otherPrimeInfos != null)
        //{
            //v.add(otherPrimeInfos);
        //}
        //return new DERSequence(v);
    }

    
}

