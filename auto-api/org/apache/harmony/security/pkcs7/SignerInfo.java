package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

public final class SignerInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "2D805113072BCF9647830D1BB8E51D08", hash_generated_field = "7E7BB7D422AEEBD0CB49BF63A453A9D8")

    private AlgorithmIdentifier digestAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "6898DC6E12D104D17852F4A4A49EA05A", hash_generated_field = "14A332E210BB2E11D03DC17917756851")

    private AuthenticatedAttributes authenticatedAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "2EC8DAA796125A920D42DB9ECF2FBC86", hash_generated_field = "3B7F1A7A1CCFBE00AA70C6D41E16628E")

    private AlgorithmIdentifier digestEncryptionAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "EE2C93D60E14AB73DB78160F92DCB869", hash_generated_field = "D4C160625B06809796B7FC57003B2410")

    private byte[] encryptedDigest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.852 -0400", hash_original_field = "46FE62CFB1742F131668399B08BC25A3", hash_generated_field = "2DCA3E33D424E6A8A6B614313B171ECE")

    private List<?> unauthenticatedAttributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.865 -0400", hash_original_method = "27DB92A863E4BE605C04757E557D0CAB", hash_generated_method = "FDD2499C988C6171942A52245ABD14B8")
    private  SignerInfo(int version,
            Object[] issuerAndSerialNumber,
            AlgorithmIdentifier digestAlgorithm,
            AuthenticatedAttributes authenticatedAttributes,
            AlgorithmIdentifier digestEncryptionAlgorithm,
            byte[] encryptedDigest,
            List<?> unauthenticatedAttributes) {
        this.version = version;
        this.issuer = ((Name)issuerAndSerialNumber[0]).getX500Principal();
        this.serialNumber = ASN1Integer.toBigIntegerValue(issuerAndSerialNumber[1]);
        this.digestAlgorithm = digestAlgorithm;
        this.authenticatedAttributes = authenticatedAttributes;
        this.digestEncryptionAlgorithm = digestEncryptionAlgorithm;
        this.encryptedDigest = encryptedDigest;
        this.unauthenticatedAttributes = unauthenticatedAttributes;
        // ---------- Original Method ----------
        //this.version = version;
        //this.issuer = ((Name)issuerAndSerialNumber[0]).getX500Principal();
        //this.serialNumber = ASN1Integer.toBigIntegerValue(issuerAndSerialNumber[1]);
        //this.digestAlgorithm = digestAlgorithm;
        //this.authenticatedAttributes = authenticatedAttributes;
        //this.digestEncryptionAlgorithm = digestEncryptionAlgorithm;
        //this.encryptedDigest = encryptedDigest;
        //this.unauthenticatedAttributes = unauthenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.866 -0400", hash_original_method = "4521AB691538FE3E0581DA96E2D306DA", hash_generated_method = "F2D9F552DA302C40F44558377CE46DE0")
    public X500Principal getIssuer() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_2137177246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2137177246 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_2137177246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137177246;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.866 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "9FF96150080A2A4728277DABD7495360")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2125417441 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2125417441 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_2125417441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2125417441;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.866 -0400", hash_original_method = "E49EED34625AA0C2EE5919DE429AB631", hash_generated_method = "2E4510AF2C857547086832A6A89DC0F8")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_913181591 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_913181591 = digestAlgorithm.getAlgorithm();
        varB4EAC82CA7396A68D541C85D26508E83_913181591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913181591;
        // ---------- Original Method ----------
        //return digestAlgorithm.getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.867 -0400", hash_original_method = "C6CE7835E1C3757C7439121AECC2E59C", hash_generated_method = "F5CBB199E789D6D1D0F2241B4FBECE2B")
    public String getDigestEncryptionAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_769709489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769709489 = digestEncryptionAlgorithm.getAlgorithm();
        varB4EAC82CA7396A68D541C85D26508E83_769709489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769709489;
        // ---------- Original Method ----------
        //return digestEncryptionAlgorithm.getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.868 -0400", hash_original_method = "AEBE4A58A31E26ADF89831B320BDD2E7", hash_generated_method = "9602EB62654C46E082A718C554851E79")
    public List<AttributeTypeAndValue> getAuthenticatedAttributes() {
        List<AttributeTypeAndValue> varB4EAC82CA7396A68D541C85D26508E83_1605059540 = null; //Variable for return #1
        List<AttributeTypeAndValue> varB4EAC82CA7396A68D541C85D26508E83_431815709 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1605059540 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_431815709 = authenticatedAttributes.getAttributes();
        List<AttributeTypeAndValue> varA7E53CE21691AB073D9660D615818899_1625621599; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1625621599 = varB4EAC82CA7396A68D541C85D26508E83_1605059540;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1625621599 = varB4EAC82CA7396A68D541C85D26508E83_431815709;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1625621599.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1625621599;
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.868 -0400", hash_original_method = "807A0AFC068DD73DE0C4C3C2177CA7D2", hash_generated_method = "217A146B606D3E2F46D2F082ED6C80B9")
    public byte[] getEncodedAuthenticatedAttributes() {
        byte[] varA8038B53264A40706041C0C5ED41E28E_416463251 = (authenticatedAttributes.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1590720335 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1590720335;
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.868 -0400", hash_original_method = "14A08E1AF72E02B64CEDF5DA67544611", hash_generated_method = "2EB857203B257C6A4996946F52ABA94A")
    public byte[] getEncryptedDigest() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_698001467 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_698001467;
        // ---------- Original Method ----------
        //return encryptedDigest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.883 -0400", hash_original_method = "1FB56313E7A9E641FD4CA0515EC1DCD9", hash_generated_method = "E946091CDA7CB793EF8A13D11F731266")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_690246389 = null; //Variable for return #1
        StringBuilder res;
        res = new StringBuilder();
        res.append("-- SignerInfo:");
        res.append("\n version : ");
        res.append(version);
        res.append("\nissuerAndSerialNumber:  ");
        res.append(issuer);
        res.append("   ");
        res.append(serialNumber);
        res.append("\ndigestAlgorithm:  ");
        res.append(digestAlgorithm.toString());
        res.append("\nauthenticatedAttributes:  ");
        {
            res.append(authenticatedAttributes.toString());
        } //End block
        res.append("\ndigestEncryptionAlgorithm: ");
        res.append(digestEncryptionAlgorithm.toString());
        res.append("\nunauthenticatedAttributes: ");
        {
            res.append(unauthenticatedAttributes.toString());
        } //End block
        res.append("\n-- SignerInfo End\n");
        varB4EAC82CA7396A68D541C85D26508E83_690246389 = res.toString();
        varB4EAC82CA7396A68D541C85D26508E83_690246389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_690246389;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.883 -0400", hash_original_field = "DA5E4B91C5AEA4F649C1E27EF117007C", hash_generated_field = "D0EBCF2AEA22824AC0540C4946A3C7F3")

    public static final ASN1Sequence ISSUER_AND_SERIAL_NUMBER =
            new ASN1Sequence(new ASN1Type[] {
                Name.ASN1,                       
                ASN1Integer.getInstance(),       
            })
        {
            
            @Override public void getValues(Object object, Object[] values) {
                Object [] issAndSerial = (Object[])object;
                values[0] = issAndSerial[0];
                values[1] = issAndSerial[1];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.884 -0400", hash_original_field = "7485F6B30A4859C8C1B772C8B7318B22", hash_generated_field = "6A02E77CC9008CF0FE8E20EC83C59F4A")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[] {
                ASN1Integer.getInstance(),         
                ISSUER_AND_SERIAL_NUMBER,
                AlgorithmIdentifier.ASN1,           
                new ASN1Implicit(0, AuthenticatedAttributes.ASN1),
                AlgorithmIdentifier.ASN1,            
                ASN1OctetString.getInstance(),       
                 new ASN1Implicit(1, new ASN1SetOf(
                         AttributeTypeAndValue.ASN1)),
                })  {
        {
            setOptional(3); 
            setOptional(6); 
        }

        @Override protected void getValues(Object object, Object[] values) {
            SignerInfo si = (SignerInfo) object;
            values[0] = new byte[] {(byte)si.version};
            try {
                values[1] = new Object[] { new Name(si.issuer.getName()),
                        si.serialNumber.toByteArray() };
            } catch (IOException e) {
                
                
                
                throw new RuntimeException("Failed to encode issuer name", e);
            }
            values[2] = si.digestAlgorithm;
            values[3] = si.authenticatedAttributes;
            values[4] = si.digestEncryptionAlgorithm;
            values[5] = si.encryptedDigest;
            values[6] = si.unauthenticatedAttributes;
        }

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new SignerInfo(
                        ASN1Integer.toIntValue(values[0]),
                        (Object[]) values[1],
                        (AlgorithmIdentifier) values[2],
                        (AuthenticatedAttributes) values[3],
                        (AlgorithmIdentifier) values[4],
                        (byte[]) values[5],
                        (List) values[6]
                    );
        }
   };
}

