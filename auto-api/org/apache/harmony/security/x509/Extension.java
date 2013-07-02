package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;

public final class Extension {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "81A958EC06A2C622709F6D43796C0CC6", hash_generated_field = "8FF788D802F19156A5C417E4A45E7E12")

    private int[] extnID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "C11702F8B721F2CD8532E5E9274B9E88", hash_generated_field = "1083E6F765C894CB0636109B4BF9EBDC")

    private String extnID_str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "A48F124796E85FB5FCAB8EC4B6BBE7D0")

    private boolean critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "C508F11B9788D23F670969FC1FC8CE29", hash_generated_field = "20FC9E7634FE8CC649C67A24E78428BB")

    private byte[] extnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "F35A92C45027DF54487736F7C73F35E4", hash_generated_field = "E823D869E9BDEB05E84E11DD9C5D645B")

    private byte[] rawExtnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "9D14BBAB97C8DBDEE261B5A3F5FA625E", hash_generated_field = "438348B11B927145AC75EBC3AE4EBA57")

    protected ExtensionValue extnValueObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_field = "C0F64CDD095C698E0A8A22FA4E7E76FA", hash_generated_field = "49181044EA66271CEFB24754874F9828")

    private boolean valueDecoded = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "50760EB0ED9565090BA8684D8B00AE4E")
    public  Extension(String extnID, boolean critical,
            ExtensionValue extnValueObject) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValueObject = extnValueObject;
        this.valueDecoded = true;
        this.extnValue = extnValueObject.getEncoded();
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.883 -0400", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "735B7734C17EB3020FD2E48FFAF24114")
    public  Extension(String extnID, boolean critical, byte[] extnValue) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValue = extnValue;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.884 -0400", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "D97F8633F554235658DAFAFD0C28C8C5")
    public  Extension(int[] extnID, boolean critical, byte[] extnValue) {
        this.extnID = extnID;
        this.critical = critical;
        this.extnValue = extnValue;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.884 -0400", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "359F60EE83B36A248D2E1524C57840CB")
    public  Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnID.getTaint());
        addTaint(extnValue[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.884 -0400", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "1A2061EBB3D383F1BDB8FE270DA0A4AA")
    public  Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnID[0]);
        addTaint(extnValue[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.884 -0400", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "79D91F320D3425D113667CA390D8F11A")
    private  Extension(int[] extnID, boolean critical, byte[] extnValue,
            byte[] rawExtnValue, byte[] encoding,
            ExtensionValue decodedExtValue) {
        this(extnID, critical, extnValue);
        this.rawExtnValue = rawExtnValue;
        this.encoding = encoding;
        this.extnValueObject = decodedExtValue;
        this.valueDecoded = (decodedExtValue != null);
        addTaint(extnID[0]);
        addTaint(critical);
        addTaint(extnValue[0]);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.885 -0400", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "F9BE3E9989C20103BAC7618E05F222BD")
    public String getExtnID() {
        String varB4EAC82CA7396A68D541C85D26508E83_180232469 = null; 
        {
            extnID_str = ObjectIdentifier.toString(extnID);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_180232469 = extnID_str;
        varB4EAC82CA7396A68D541C85D26508E83_180232469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_180232469;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.885 -0400", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "8C61353C739D7010128C2945B2CE9000")
    public boolean getCritical() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241056588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241056588;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.886 -0400", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "E0ADE0FD3A0025AFA8D60F08967854D0")
    public byte[] getExtnValue() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_307075818 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_307075818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.886 -0400", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "5F38C6ECF5189244B6BB535331542890")
    public byte[] getRawExtnValue() {
        {
            rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_964843360 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_964843360;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.887 -0400", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "4F75E8AE3F38BF40B05FA83D80E6A2F9")
    public byte[] getEncoded() {
        {
            encoding = Extension.ASN1.encode(this);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_699678479 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_699678479;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.888 -0400", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "947CEB8FC8DD68105AE862AE8081F358")
    @Override
    public boolean equals(Object ext) {
        Extension extension = (Extension) ext;
        boolean var9DCFD56BF24A6A1546F9545527B1BEF4_1477228593 = (Arrays.equals(extnID, extension.extnID)
            && (critical == extension.critical)
            && Arrays.equals(extnValue, extension.extnValue));
        addTaint(ext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943841282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943841282;
        
        
            
        
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.889 -0400", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "CB6155AEECB439D699F576044C5A04A0")
    @Override
    public int hashCode() {
        int var5B5A1F8476FB12CFA8AEDE9AB0880DDA_1083684389 = ((Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063383136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063383136;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.889 -0400", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "978F1D08C8510B9301AE11C435DE75D2")
    public ExtensionValue getDecodedExtensionValue() throws IOException {
        ExtensionValue varB4EAC82CA7396A68D541C85D26508E83_224564056 = null; 
        {
            decodeExtensionValue();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_224564056 = extnValueObject;
        varB4EAC82CA7396A68D541C85D26508E83_224564056.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_224564056;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.890 -0400", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "CA62443716A684B15164F05D108274DE")
    public KeyUsage getKeyUsageValue() {
        KeyUsage varB4EAC82CA7396A68D541C85D26508E83_1212154306 = null; 
        KeyUsage varB4EAC82CA7396A68D541C85D26508E83_1687351216 = null; 
        {
            try 
            {
                decodeExtensionValue();
            } 
            catch (IOException ignored)
            { }
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1212154306 = (KeyUsage) extnValueObject;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1687351216 = null;
        } 
        KeyUsage varA7E53CE21691AB073D9660D615818899_2001929918; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2001929918 = varB4EAC82CA7396A68D541C85D26508E83_1212154306;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2001929918 = varB4EAC82CA7396A68D541C85D26508E83_1687351216;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2001929918.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2001929918;
        
        
            
                
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.891 -0400", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "0AB05E375AFD6388935BB7802F79B4A5")
    public BasicConstraints getBasicConstraintsValue() {
        BasicConstraints varB4EAC82CA7396A68D541C85D26508E83_1714568695 = null; 
        BasicConstraints varB4EAC82CA7396A68D541C85D26508E83_1044811830 = null; 
        {
            try 
            {
                decodeExtensionValue();
            } 
            catch (IOException ignored)
            { }
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1714568695 = (BasicConstraints) extnValueObject;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1044811830 = null;
        } 
        BasicConstraints varA7E53CE21691AB073D9660D615818899_1548615757; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1548615757 = varB4EAC82CA7396A68D541C85D26508E83_1714568695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1548615757 = varB4EAC82CA7396A68D541C85D26508E83_1044811830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1548615757.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1548615757;
        
        
            
                
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.893 -0400", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "533EEDAC1F6FB8670404D9ACB5919E1C")
    private void decodeExtensionValue() throws IOException {
        valueDecoded = true;
        {
            boolean varAB54FC05496F6295091A57B6D1F917E4_213512901 = (Arrays.equals(extnID, SUBJ_KEY_ID));
            {
                extnValueObject = SubjectKeyIdentifier.decode(extnValue);
            } 
            {
                boolean var79029BF70BB25748F0031BECDFC677F0_970615174 = (Arrays.equals(extnID, KEY_USAGE));
                {
                    extnValueObject = new KeyUsage(extnValue);
                } 
                {
                    boolean var29928D2F0E1AE92B4EE44FD113DA26AA_1709151452 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                    {
                        extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                    } 
                    {
                        boolean varD20C75BE6CC43A14751C65D119228C3A_36444066 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                        {
                            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                        } 
                        {
                            boolean varBE53E1A959872908090C494A7AB2392D_739599946 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                            {
                                extnValueObject = new BasicConstraints(extnValue);
                            } 
                            {
                                boolean var5A791D62D10D7BF57CD09CA0530210CA_1990303803 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                {
                                    extnValueObject = NameConstraints.decode(extnValue);
                                } 
                                {
                                    boolean var112C83EF4DD7E7E88ECFE15117D39C6D_386298131 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                    {
                                        extnValueObject = CertificatePolicies.decode(extnValue);
                                    } 
                                    {
                                        boolean var9997835AD8D731E68A43122000F851E4_580586491 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                        {
                                            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
                                        } 
                                        {
                                            boolean var09F276B08BD777DFF04E4CD8796848A1_520758899 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                            {
                                                extnValueObject = new PolicyConstraints(extnValue);
                                            } 
                                            {
                                                boolean var6EF1777FA134D2C6F1F80DD9F9A47B8D_1336060157 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                {
                                                    extnValueObject = new ExtendedKeyUsage(extnValue);
                                                } 
                                                {
                                                    boolean var44A5226B44D58B9425B0E256BE9FB527_1439581289 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                    {
                                                        extnValueObject = new InhibitAnyPolicy(extnValue);
                                                    } 
                                                    {
                                                        boolean var93521D58B41ADFE8278B6F7231FF23E7_1067117823 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                        {
                                                            extnValueObject = new CertificateIssuer(extnValue);
                                                        } 
                                                        {
                                                            boolean varD5FFB1153C5E90B82F14EF6589E1DC95_58819175 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                                            {
                                                                extnValueObject = CRLDistributionPoints.decode(extnValue);
                                                            } 
                                                            {
                                                                boolean var8A49AD6C907832B5A81CD0DE1019700B_2055977316 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                                {
                                                                    extnValueObject = new ReasonCode(extnValue);
                                                                } 
                                                                {
                                                                    boolean var3C464CC7970A9FAE3C292FB9DB775A18_1902334487 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                    {
                                                                        extnValueObject = new InvalidityDate(extnValue);
                                                                    } 
                                                                    {
                                                                        boolean varDF59FBD3E702A0531884AAD7E88B6DAC_1348628433 = (Arrays.equals(extnID, REASON_CODE));
                                                                        {
                                                                            extnValueObject = new ReasonCode(extnValue);
                                                                        } 
                                                                        {
                                                                            boolean varCA92F6DC87650A9732A66EC46314EC63_671801260 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                            {
                                                                                extnValueObject = new CRLNumber(extnValue);
                                                                            } 
                                                                            {
                                                                                boolean var9CB5BC68027662BFA0C2D20DA8D9A010_1320550462 = (Arrays.equals(extnID, ISSUING_DISTR_POINTS));
                                                                                {
                                                                                    extnValueObject = IssuingDistributionPoint.decode(extnValue);
                                                                                } 
                                                                                {
                                                                                    boolean varB24AC34B42C7A4E2668F5DCE93D76645_244470564 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                                    {
                                                                                        extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                    } 
                                                                                    {
                                                                                        boolean varD2BB3DB505EC9CA31C9F97B0FCBEAE86_1328759924 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                                        {
                                                                                            extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                        } 
                                                                                    } 
                                                                                } 
                                                                            } 
                                                                        } 
                                                                    } 
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.895 -0400", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "79245B6CF0F163F94B01CEC51CF1F22B")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append("OID: ").append(getExtnID()).append(", Critical: ").append(critical).append('\n');
        {
            try 
            {
                decodeExtensionValue();
            } 
            catch (IOException ignored)
            { }
        } 
        {
            extnValueObject.dumpValue(sb, prefix);
        } 
        sb.append(prefix);
        {
            boolean varA221B1146EC21CCCA34E2F25D5224B62_601445766 = (Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS));
            {
                sb.append("Subject Directory Attributes Extension");
            } 
            {
                boolean var8DF0EC9A6AEA6EFB3FB5C280D7D74F9B_1362988672 = (Arrays.equals(extnID, SUBJ_KEY_ID));
                {
                    sb.append("Subject Key Identifier Extension");
                } 
                {
                    boolean varF4C07E0FE65656621B8BCE269E8B58EF_313680958 = (Arrays.equals(extnID, KEY_USAGE));
                    {
                        sb.append("Key Usage Extension");
                    } 
                    {
                        boolean varAA372AED1E2AA1D54925B54D69F8DB90_836740211 = (Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD));
                        {
                            sb.append("Private Key Usage Period Extension");
                        } 
                        {
                            boolean var798B3C516162896973F8A912AADF2342_690391298 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                            {
                                sb.append("Subject Alternative Name Extension");
                            } 
                            {
                                boolean varA7C4827A995FE964AABC87414038EBBE_61548284 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                                {
                                    sb.append("Issuer Alternative Name Extension");
                                } 
                                {
                                    boolean varE21A4DBDF9C91AE82217AC44614585FE_1063150636 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                                    {
                                        sb.append("Basic Constraints Extension");
                                    } 
                                    {
                                        boolean var7169DD5CE39017F9C9B4B9884B1B9568_1470074080 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                        {
                                            sb.append("Name Constraints Extension");
                                        } 
                                        {
                                            boolean varECD4FFAE2DF9F6D6E5520D99835A6F31_14571774 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                            {
                                                sb.append("CRL Distribution Points Extension");
                                            } 
                                            {
                                                boolean var13FF4F808684FD573126EE212EA51786_1338236164 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                                {
                                                    sb.append("Certificate Policies Extension");
                                                } 
                                                {
                                                    boolean varAE8E329E1E0543065CC25EC5F26F8882_786254392 = (Arrays.equals(extnID, POLICY_MAPPINGS));
                                                    {
                                                        sb.append("Policy Mappings Extension");
                                                    } 
                                                    {
                                                        boolean var462955B2DF2534E3BC83A1D61ACA2B44_2092595097 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                                        {
                                                            sb.append("Authority Key Identifier Extension");
                                                        } 
                                                        {
                                                            boolean varB2C78479445E120DEA730A255DC280D6_1055059685 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                                            {
                                                                sb.append("Policy Constraints Extension");
                                                            } 
                                                            {
                                                                boolean var7E91A6CA310680B093FD88063F8ED148_1929040810 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                                {
                                                                    sb.append("Extended Key Usage Extension");
                                                                } 
                                                                {
                                                                    boolean var2B9738A611418D1A003180D5A0034093_1367344845 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                                    {
                                                                        sb.append("Inhibit Any-Policy Extension");
                                                                    } 
                                                                    {
                                                                        boolean var2FDC903F1140F0C783B43300553D7073_1642984133 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                        {
                                                                            sb.append("Authority Information Access Extension");
                                                                        } 
                                                                        {
                                                                            boolean var1A9F19376AD1E1128CDFDE7F880CFF1A_1756824063 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                            {
                                                                                sb.append("Subject Information Access Extension");
                                                                            } 
                                                                            {
                                                                                boolean var64EE348197FCEC58F6DF3BD83E5F3361_1121244261 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                                {
                                                                                    sb.append("Invalidity Date Extension");
                                                                                } 
                                                                                {
                                                                                    boolean varFEBBBF17861D8A2A8A1CDCEDBEADDB9A_891584335 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                                    {
                                                                                        sb.append("CRL Number Extension");
                                                                                    } 
                                                                                    {
                                                                                        boolean var7A124ADB859F1043EEDF9FC8C3E2A3CB_1706108976 = (Arrays.equals(extnID, REASON_CODE));
                                                                                        {
                                                                                            sb.append("Reason Code Extension");
                                                                                        } 
                                                                                        {
                                                                                            sb.append("Unknown Extension");
                                                                                        } 
                                                                                    } 
                                                                                } 
                                                                            } 
                                                                        } 
                                                                    } 
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        sb.append('\n').append(prefix).append("Unparsed Extension Value:\n");
        sb.append(Array.toString(extnValue, prefix));
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.895 -0400", hash_original_field = "9D770FFDDC15870F3D3A340ACD808078", hash_generated_field = "6E31BBAF500C1070EE1FFA080111393F")

    public static final boolean CRITICAL = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.895 -0400", hash_original_field = "61B04E4695AA5F374EEFDAD16E9E0524", hash_generated_field = "57D4ADD3A20722C1472A183BBA626F17")

    public static final boolean NON_CRITICAL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.895 -0400", hash_original_field = "27AC59456ABCB1CE64FC2C3053748D09", hash_generated_field = "CFFB39566B9AEEC9AB1894E25C5DE3DA")

    static final int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "719C2AB0E2F06E3BD1FF47B05C669C52", hash_generated_field = "12E2A1B5F5C6E6E68AA435B29065A00B")

    static final int[] SUBJ_KEY_ID = {2, 5, 29, 14};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "B58C569327B16FBE6BA2EC3275E60A70", hash_generated_field = "0C70346483130DABA174062DEFA137A2")

    static final int[] KEY_USAGE = {2, 5, 29, 15};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "11C15EF3E2ED91D6D2AE5ADD3AAB40C0", hash_generated_field = "99B612A5CA31C7372E91E87AF4BCA7CF")

    static final int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "763E9AF8FC55F30DD20FEB41EE56E8F5", hash_generated_field = "EDAD333FCA26480E2985EA9905FC2E62")

    static final int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "6389938383D6D3F2B15BB97818ADA090", hash_generated_field = "E25E2376B509F67CE04E08FE645EDF3A")

    static final int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "E2763B92F43C78EB5AE7CA4C13875A2E", hash_generated_field = "4719361E8A47B688AD0277E34E1EC427")

    static final int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "2CC72DB0339D067215FFC0B86EBC615B", hash_generated_field = "49AD57F33D760933ED9349263C6F8EAE")

    static final int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "C6D831E4B714E4BEBA10A0311994F721", hash_generated_field = "7A61315B9986A127CC6F2344E095C632")

    static final int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "54E4E62889082A4291C82572415D3FD3", hash_generated_field = "1691E914E66862570393C6E34196E15C")

    static final int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "92B4E401637FF5C4D11E2E6AA1497575", hash_generated_field = "CE95833AAC25AE706C941911E24707F9")

    static final int[] POLICY_MAPPINGS = {2, 5, 29, 33};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "09CD194DEE87CC00E22813CE03AA2189", hash_generated_field = "A324E7513D96D23F13F91F8DFF91B594")

    static final int[] AUTH_KEY_ID = {2, 5, 29, 35};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "3A149D04714488EAABB6793BAAC971C7", hash_generated_field = "95538B9ED262D7F125023AC83213D22E")

    static final int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "A8CB7D09038D802044B2796F8FEC3D21", hash_generated_field = "4359CA80FF8A9D383063F767F62461EA")

    static final int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "711DE24A0324604FFC2C892BE38CA12B", hash_generated_field = "47087EB391C3782D2732916FA0F9A8F6")

    static final int[] FRESHEST_CRL = {2, 5, 29, 46};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "E584FD6E092027A6F9AE59B800B4BEE1", hash_generated_field = "904578E7AECC101C2C04F1A04DC732B5")

    static final int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "F887D8CC4B9E928778BB90E4DD18EC2B", hash_generated_field = "494BD3D519DBA72AF6B11312F94F2233")

    static final int[] AUTHORITY_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 1};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "E570A9AB6529D0B74A5004F2E1A61DC9", hash_generated_field = "C976F23CD3B6D6B36515F6F863C6502E")

    static final int[] SUBJECT_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 11};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "ADDCB4B21210BC97410BFAB822DE5567", hash_generated_field = "9CED2F6CB0726D71EE80F824234AF7BD")

    static final int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "A1BE3CEA110171E88491EB6296EC8BCE", hash_generated_field = "966A118EDFE475F73BA36FEA1B1F975C")

    static final int[] CRL_NUMBER = {2, 5, 29, 20};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "A5C359B3674964EBA0BAD84A851DDECE", hash_generated_field = "5CDEAF5DBC9CB04A80D24DF838BF2CE2")

    static final int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "274041C10371CF3BFE121AE51FD7402B", hash_generated_field = "5886D35FDD6D210067E6B9B1BF6BD0F1")

    static final int[] INVALIDITY_DATE = {2, 5, 29, 24};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "78516CB1FE0FD6BF662239155F765B89", hash_generated_field = "82525C0AB7C1B69E481DF8A6ADCBB83A")

    static final int[] REASON_CODE = {2, 5, 29, 21};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "BC1CA6B2C393BDBE6FD729838874757D", hash_generated_field = "96991C023252842FAC916A47EE9FD09B")

    static final int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.896 -0400", hash_original_field = "162B518F6D507BF8606DF33C2285800B", hash_generated_field = "3978C13F4770C29C9F00A89FB623B39E")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            ASN1Boolean.getInstance(),
            new ASN1OctetString() {
                @Override public Object getDecodedObject(BerInputStream in) throws IOException {
                    
                    
                    return new Object[]
                        {super.getDecodedObject(in), in.getEncoded()};
                }
            }
        }) {
        {
            setDefault(Boolean.FALSE, 1);
        }

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;

            int[] oid = (int[]) values[0];
            byte[] extnValue = (byte[]) ((Object[]) values[2])[0];
            byte[] rawExtnValue = (byte[]) ((Object[]) values[2])[1];

            ExtensionValue decodedExtValue = null;
            
            if (Arrays.equals(oid, KEY_USAGE)) {
                decodedExtValue = new KeyUsage(extnValue);
            } else if (Arrays.equals(oid, BASIC_CONSTRAINTS)) {
                decodedExtValue = new BasicConstraints(extnValue);
            }

            return new Extension((int[]) values[0], (Boolean) values[1],
                    extnValue, rawExtnValue, in.getEncoded(), decodedExtValue);
        }

        @Override protected void getValues(Object object, Object[] values) {
            Extension ext = (Extension) object;
            values[0] = ext.extnID;
            values[1] = (ext.critical) ? Boolean.TRUE : Boolean.FALSE;
            values[2] = ext.extnValue;
        }
    };
    
}

