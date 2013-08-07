package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "956D8366F7FF863766B65FA6712484C9", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "20BFD8B959FA5A8CFD340683DC2A9BA7", hash_generated_field = "5183F0D78D6F219DDA80B278EEDFCB67")

    private BigInteger prime1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "E2BFEA63AF9DE42C6E4FEFEBDF117F61", hash_generated_field = "F3BA5CAC09D7909BBB93DF7AF3E7C65D")

    private BigInteger prime2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.082 -0400", hash_original_field = "C810A5215079E8395136DF0E061D700B", hash_generated_field = "377CF518661599B835EE4672F2F31B96")

    private BigInteger exponent1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.083 -0400", hash_original_field = "9F3DEA20A14E9679832D37964B2D6191", hash_generated_field = "92E33EC2A21F45DD4C21202D0E40383E")

    private BigInteger exponent2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.083 -0400", hash_original_field = "16DEBEF90A0394D9B14C30C4281BCE0D", hash_generated_field = "0572EDC7719F4FB5A9D30181C4C0D24C")

    private BigInteger coefficient;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.083 -0400", hash_original_field = "17CAC7C39D167EF2C058C29BFB1C320A", hash_generated_field = "3ACC149C44ABAAABE0A228F468255A55")

    private ASN1Sequence otherPrimeInfos = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.085 -0400", hash_original_method = "CBF376BA3B510254060235C0D7FBAB4E", hash_generated_method = "31188D1BC3205E4C4EF73CDBDCAB4094")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.089 -0400", hash_original_method = "7CCE248335D08B10FB2A36728BE792D2", hash_generated_method = "B7CB006BB0E56524B53ECAD683785A2D")
    public  RSAPrivateKeyStructure(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        Enumeration e = seq.getObjects();
        BigInteger v = ((DERInteger)e.nextElement()).getValue();
        if(v.intValue() != 0 && v.intValue() != 1)        
        {
            IllegalArgumentException var3839672161010FC0AB6A388331AFFFD0_1390600869 = new IllegalArgumentException("wrong version for RSA private key");
            var3839672161010FC0AB6A388331AFFFD0_1390600869.addTaint(taint);
            throw var3839672161010FC0AB6A388331AFFFD0_1390600869;
        } //End block
        version = v.intValue();
        modulus = ((DERInteger)e.nextElement()).getValue();
        publicExponent = ((DERInteger)e.nextElement()).getValue();
        privateExponent = ((DERInteger)e.nextElement()).getValue();
        prime1 = ((DERInteger)e.nextElement()).getValue();
        prime2 = ((DERInteger)e.nextElement()).getValue();
        exponent1 = ((DERInteger)e.nextElement()).getValue();
        exponent2 = ((DERInteger)e.nextElement()).getValue();
        coefficient = ((DERInteger)e.nextElement()).getValue();
        if(e.hasMoreElements())        
        {
            otherPrimeInfos = (ASN1Sequence)e.nextElement();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.090 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "E663C732EE09143B5299B808F1278E97")
    public int getVersion() {
        int var2AF72F100C356273D46284F6FD1DFC08_794136929 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733851013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733851013;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.091 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "A3FBD2484A14946B64BE126D042F328C")
    public BigInteger getModulus() {
BigInteger varCC3CF2CBE0D806C40D550889F76A52A1_1856563273 =         modulus;
        varCC3CF2CBE0D806C40D550889F76A52A1_1856563273.addTaint(taint);
        return varCC3CF2CBE0D806C40D550889F76A52A1_1856563273;
        // ---------- Original Method ----------
        //return modulus;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.091 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "81770BB560C1D211854B44BF9EADA55F")
    public BigInteger getPublicExponent() {
BigInteger varB360105573401CCC465D10C242BA5623_2130552815 =         publicExponent;
        varB360105573401CCC465D10C242BA5623_2130552815.addTaint(taint);
        return varB360105573401CCC465D10C242BA5623_2130552815;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.091 -0400", hash_original_method = "DA7C8A3DDA38443F1F2D4DBDF52134FD", hash_generated_method = "73F87B8D3355F527C79733E9D9B32762")
    public BigInteger getPrivateExponent() {
BigInteger varC820A65540BECD18FC145C33971A13B0_708091089 =         privateExponent;
        varC820A65540BECD18FC145C33971A13B0_708091089.addTaint(taint);
        return varC820A65540BECD18FC145C33971A13B0_708091089;
        // ---------- Original Method ----------
        //return privateExponent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.092 -0400", hash_original_method = "B99C0F53E18C4C91C319BE2CCC968C4F", hash_generated_method = "9CDA6534B5042D079C33C0B97A6EEA46")
    public BigInteger getPrime1() {
BigInteger var84C395E888C4BB29C62262539F817382_1117502145 =         prime1;
        var84C395E888C4BB29C62262539F817382_1117502145.addTaint(taint);
        return var84C395E888C4BB29C62262539F817382_1117502145;
        // ---------- Original Method ----------
        //return prime1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.092 -0400", hash_original_method = "B93FCB0A892E4015213AB5057F688210", hash_generated_method = "A50A610244B18DB85A800BF14CAB7F85")
    public BigInteger getPrime2() {
BigInteger var3B6BDC64641E2A1BE5212CB9C728B8AB_841578879 =         prime2;
        var3B6BDC64641E2A1BE5212CB9C728B8AB_841578879.addTaint(taint);
        return var3B6BDC64641E2A1BE5212CB9C728B8AB_841578879;
        // ---------- Original Method ----------
        //return prime2;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.092 -0400", hash_original_method = "762AADF12D80291EC0F289058DBDBCEC", hash_generated_method = "ABDDE7402C7110E3444A50C716D0D8C0")
    public BigInteger getExponent1() {
BigInteger varCD17C3383CCF5695DFB6FFE083900076_298451342 =         exponent1;
        varCD17C3383CCF5695DFB6FFE083900076_298451342.addTaint(taint);
        return varCD17C3383CCF5695DFB6FFE083900076_298451342;
        // ---------- Original Method ----------
        //return exponent1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.092 -0400", hash_original_method = "DDCFEFECC032A2CEE6C8950AE5D7E294", hash_generated_method = "F51DCCF152D61C59B86B2FEDEC4FA9DE")
    public BigInteger getExponent2() {
BigInteger var610E05A27285D617974849B79B242BE2_537211396 =         exponent2;
        var610E05A27285D617974849B79B242BE2_537211396.addTaint(taint);
        return var610E05A27285D617974849B79B242BE2_537211396;
        // ---------- Original Method ----------
        //return exponent2;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.093 -0400", hash_original_method = "C7CB66A1169BB550EC38CAFFC80D3C48", hash_generated_method = "278F19D63C1AFC25EB54E5F6DE082535")
    public BigInteger getCoefficient() {
BigInteger varA44CB2A7DC1E45A055C8AC9C497560AF_877986644 =         coefficient;
        varA44CB2A7DC1E45A055C8AC9C497560AF_877986644.addTaint(taint);
        return varA44CB2A7DC1E45A055C8AC9C497560AF_877986644;
        // ---------- Original Method ----------
        //return coefficient;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.094 -0400", hash_original_method = "B4123323DA5D54F0794A6EC8CDF9F726", hash_generated_method = "5C6A2DAA9791A575E6B59F5CBB224D02")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(version));
        v.add(new DERInteger(getModulus()));
        v.add(new DERInteger(getPublicExponent()));
        v.add(new DERInteger(getPrivateExponent()));
        v.add(new DERInteger(getPrime1()));
        v.add(new DERInteger(getPrime2()));
        v.add(new DERInteger(getExponent1()));
        v.add(new DERInteger(getExponent2()));
        v.add(new DERInteger(getCoefficient()));
        if(otherPrimeInfos != null)        
        {
            v.add(otherPrimeInfos);
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_231843439 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_231843439.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_231843439;
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

