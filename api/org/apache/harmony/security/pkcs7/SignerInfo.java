package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.107 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

    private X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "2D805113072BCF9647830D1BB8E51D08", hash_generated_field = "7E7BB7D422AEEBD0CB49BF63A453A9D8")

    private AlgorithmIdentifier digestAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "6898DC6E12D104D17852F4A4A49EA05A", hash_generated_field = "14A332E210BB2E11D03DC17917756851")

    private AuthenticatedAttributes authenticatedAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "2EC8DAA796125A920D42DB9ECF2FBC86", hash_generated_field = "3B7F1A7A1CCFBE00AA70C6D41E16628E")

    private AlgorithmIdentifier digestEncryptionAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "EE2C93D60E14AB73DB78160F92DCB869", hash_generated_field = "D4C160625B06809796B7FC57003B2410")

    private byte[] encryptedDigest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.108 -0400", hash_original_field = "46FE62CFB1742F131668399B08BC25A3", hash_generated_field = "2DCA3E33D424E6A8A6B614313B171ECE")

    private List<?> unauthenticatedAttributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.113 -0400", hash_original_method = "27DB92A863E4BE605C04757E557D0CAB", hash_generated_method = "FDD2499C988C6171942A52245ABD14B8")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.114 -0400", hash_original_method = "4521AB691538FE3E0581DA96E2D306DA", hash_generated_method = "801320C7953B3B89F4634697440B60C7")
    public X500Principal getIssuer() {
X500Principal var8EF52627413B91AB97DB59853805E979_104517053 =         issuer;
        var8EF52627413B91AB97DB59853805E979_104517053.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_104517053;
        // ---------- Original Method ----------
        //return issuer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.114 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "73EC1033E167185E4147A9B565648594")
    public BigInteger getSerialNumber() {
BigInteger varC5241B523DA06FB03F5998149659C655_1212465315 =         serialNumber;
        varC5241B523DA06FB03F5998149659C655_1212465315.addTaint(taint);
        return varC5241B523DA06FB03F5998149659C655_1212465315;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.115 -0400", hash_original_method = "E49EED34625AA0C2EE5919DE429AB631", hash_generated_method = "6AE0E990EF8D214564AED4E5B5ACE4A4")
    public String getDigestAlgorithm() {
String var1EA0FCDFB070C78EDCDBFC3FC9833618_1841691772 =         digestAlgorithm.getAlgorithm();
        var1EA0FCDFB070C78EDCDBFC3FC9833618_1841691772.addTaint(taint);
        return var1EA0FCDFB070C78EDCDBFC3FC9833618_1841691772;
        // ---------- Original Method ----------
        //return digestAlgorithm.getAlgorithm();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.115 -0400", hash_original_method = "C6CE7835E1C3757C7439121AECC2E59C", hash_generated_method = "2C2AE83C8AD3400EF0A5ECEC319512C3")
    public String getDigestEncryptionAlgorithm() {
String varD7ABE868ACE670569FA3F032243EA182_577797351 =         digestEncryptionAlgorithm.getAlgorithm();
        varD7ABE868ACE670569FA3F032243EA182_577797351.addTaint(taint);
        return varD7ABE868ACE670569FA3F032243EA182_577797351;
        // ---------- Original Method ----------
        //return digestEncryptionAlgorithm.getAlgorithm();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.116 -0400", hash_original_method = "AEBE4A58A31E26ADF89831B320BDD2E7", hash_generated_method = "A7FB45829E387B75437A31567EE90735")
    public List<AttributeTypeAndValue> getAuthenticatedAttributes() {
        if(authenticatedAttributes == null)        
        {
List<AttributeTypeAndValue> var540C13E9E156B687226421B24F2DF178_1618424683 =             null;
            var540C13E9E156B687226421B24F2DF178_1618424683.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1618424683;
        } //End block
List<AttributeTypeAndValue> var111D566C00971C79F18A3FFB116CA856_1193797676 =         authenticatedAttributes.getAttributes();
        var111D566C00971C79F18A3FFB116CA856_1193797676.addTaint(taint);
        return var111D566C00971C79F18A3FFB116CA856_1193797676;
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getAttributes();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.117 -0400", hash_original_method = "807A0AFC068DD73DE0C4C3C2177CA7D2", hash_generated_method = "E286D09C3D64F74D13F192F3D970993B")
    public byte[] getEncodedAuthenticatedAttributes() {
        if(authenticatedAttributes == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1032611506 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_199431414 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_199431414;
        } //End block
        byte[] var2ABBE0511CBFCB05060794DBC1CE06FF_1935055034 = (authenticatedAttributes.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_16271251 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_16271251;
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getEncoded();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.118 -0400", hash_original_method = "14A08E1AF72E02B64CEDF5DA67544611", hash_generated_method = "3830C16E1C2BB649C8EBF25EA1225C4E")
    public byte[] getEncryptedDigest() {
        byte[] varEE2C93D60E14AB73DB78160F92DCB869_1343574801 = (encryptedDigest);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1242222807 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1242222807;
        // ---------- Original Method ----------
        //return encryptedDigest;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.119 -0400", hash_original_method = "1FB56313E7A9E641FD4CA0515EC1DCD9", hash_generated_method = "90327759F45D5BECE9342551FD47215E")
    public String toString() {
        StringBuilder res = new StringBuilder();
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
        if(authenticatedAttributes != null)        
        {
            res.append(authenticatedAttributes.toString());
        } //End block
        res.append("\ndigestEncryptionAlgorithm: ");
        res.append(digestEncryptionAlgorithm.toString());
        res.append("\nunauthenticatedAttributes: ");
        if(unauthenticatedAttributes != null)        
        {
            res.append(unauthenticatedAttributes.toString());
        } //End block
        res.append("\n-- SignerInfo End\n");
String varEC7EB75EF3C7FA633C54FC66A0358174_630185994 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_630185994.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_630185994;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.119 -0400", hash_original_field = "DA5E4B91C5AEA4F649C1E27EF117007C", hash_generated_field = "D0EBCF2AEA22824AC0540C4946A3C7F3")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.120 -0400", hash_original_field = "7485F6B30A4859C8C1B772C8B7318B22", hash_generated_field = "6A02E77CC9008CF0FE8E20EC83C59F4A")

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

