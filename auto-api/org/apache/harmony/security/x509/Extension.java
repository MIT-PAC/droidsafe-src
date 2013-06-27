package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "81A958EC06A2C622709F6D43796C0CC6", hash_generated_field = "8FF788D802F19156A5C417E4A45E7E12")

    private int[] extnID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "C11702F8B721F2CD8532E5E9274B9E88", hash_generated_field = "1083E6F765C894CB0636109B4BF9EBDC")

    private String extnID_str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "A48F124796E85FB5FCAB8EC4B6BBE7D0")

    private boolean critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "C508F11B9788D23F670969FC1FC8CE29", hash_generated_field = "20FC9E7634FE8CC649C67A24E78428BB")

    private byte[] extnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "F35A92C45027DF54487736F7C73F35E4", hash_generated_field = "E823D869E9BDEB05E84E11DD9C5D645B")

    private byte[] rawExtnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "9D14BBAB97C8DBDEE261B5A3F5FA625E", hash_generated_field = "438348B11B927145AC75EBC3AE4EBA57")

    protected ExtensionValue extnValueObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_field = "C0F64CDD095C698E0A8A22FA4E7E76FA", hash_generated_field = "49181044EA66271CEFB24754874F9828")

    private boolean valueDecoded = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.680 -0400", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "50760EB0ED9565090BA8684D8B00AE4E")
    public  Extension(String extnID, boolean critical,
            ExtensionValue extnValueObject) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValueObject = extnValueObject;
        this.valueDecoded = true;
        this.extnValue = extnValueObject.getEncoded();
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValueObject = extnValueObject;
        //this.valueDecoded = true;
        //this.extnValue = extnValueObject.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.681 -0400", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "735B7734C17EB3020FD2E48FFAF24114")
    public  Extension(String extnID, boolean critical, byte[] extnValue) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValue = extnValue;
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.681 -0400", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "D97F8633F554235658DAFAFD0C28C8C5")
    public  Extension(int[] extnID, boolean critical, byte[] extnValue) {
        this.extnID = extnID;
        this.critical = critical;
        this.extnValue = extnValue;
        // ---------- Original Method ----------
        //this.extnID = extnID;
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.690 -0400", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "359F60EE83B36A248D2E1524C57840CB")
    public  Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnID.getTaint());
        addTaint(extnValue[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.690 -0400", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "1A2061EBB3D383F1BDB8FE270DA0A4AA")
    public  Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnID[0]);
        addTaint(extnValue[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.691 -0400", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "79D91F320D3425D113667CA390D8F11A")
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
        // ---------- Original Method ----------
        //this.rawExtnValue = rawExtnValue;
        //this.encoding = encoding;
        //this.extnValueObject = decodedExtValue;
        //this.valueDecoded = (decodedExtValue != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.691 -0400", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "FB48AF6881CC2ABF12ECCB33CF2C761E")
    public String getExtnID() {
        String varB4EAC82CA7396A68D541C85D26508E83_377339417 = null; //Variable for return #1
        {
            extnID_str = ObjectIdentifier.toString(extnID);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_377339417 = extnID_str;
        varB4EAC82CA7396A68D541C85D26508E83_377339417.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377339417;
        // ---------- Original Method ----------
        //if (extnID_str == null) {
            //extnID_str = ObjectIdentifier.toString(extnID);
        //}
        //return extnID_str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.694 -0400", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "87160467893D752B168F70B4E723A7F9")
    public boolean getCritical() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685429472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685429472;
        // ---------- Original Method ----------
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.694 -0400", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "83010260E9452D635AB8F3F55F038B80")
    public byte[] getExtnValue() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_442955788 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_442955788;
        // ---------- Original Method ----------
        //return extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.694 -0400", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "F39AF601123BDCAA8ED24E1C1A8AB945")
    public byte[] getRawExtnValue() {
        {
            rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1436906297 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1436906297;
        // ---------- Original Method ----------
        //if (rawExtnValue == null) {
            //rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        //}
        //return rawExtnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.695 -0400", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "6B9E668BAABEADBD6E65E90F0211ACA8")
    public byte[] getEncoded() {
        {
            encoding = Extension.ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2042776957 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2042776957;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Extension.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.695 -0400", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "B6F5CF75226A2AB2AA653D1C121B5077")
    @Override
    public boolean equals(Object ext) {
        Extension extension;
        extension = (Extension) ext;
        boolean var9DCFD56BF24A6A1546F9545527B1BEF4_1403663912 = (Arrays.equals(extnID, extension.extnID)
            && (critical == extension.critical)
            && Arrays.equals(extnValue, extension.extnValue));
        addTaint(ext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607903373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_607903373;
        // ---------- Original Method ----------
        //if (!(ext instanceof Extension)) {
            //return false;
        //}
        //Extension extension = (Extension) ext;
        //return Arrays.equals(extnID, extension.extnID)
            //&& (critical == extension.critical)
            //&& Arrays.equals(extnValue, extension.extnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.707 -0400", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "479EBEE43A0E5A6334D7EA48580C9114")
    @Override
    public int hashCode() {
        int var5B5A1F8476FB12CFA8AEDE9AB0880DDA_1528472626 = ((Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469906234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469906234;
        // ---------- Original Method ----------
        //return (Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.708 -0400", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "E4CF024268245ADCD93C18406A3F575F")
    public ExtensionValue getDecodedExtensionValue() throws IOException {
        ExtensionValue varB4EAC82CA7396A68D541C85D26508E83_1730778522 = null; //Variable for return #1
        {
            decodeExtensionValue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1730778522 = extnValueObject;
        varB4EAC82CA7396A68D541C85D26508E83_1730778522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730778522;
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //decodeExtensionValue();
        //}
        //return extnValueObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.712 -0400", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "B7E739B6525BB92AE586CA6F2A83A80B")
    public KeyUsage getKeyUsageValue() {
        KeyUsage varB4EAC82CA7396A68D541C85D26508E83_1688223740 = null; //Variable for return #1
        KeyUsage varB4EAC82CA7396A68D541C85D26508E83_902785020 = null; //Variable for return #2
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1688223740 = (KeyUsage) extnValueObject;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_902785020 = null;
        } //End block
        KeyUsage varA7E53CE21691AB073D9660D615818899_387827920; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_387827920 = varB4EAC82CA7396A68D541C85D26508E83_1688223740;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_387827920 = varB4EAC82CA7396A68D541C85D26508E83_902785020;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_387827920.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_387827920;
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //try {
                //decodeExtensionValue();
            //} catch (IOException ignored) {
            //}
        //}
        //if (extnValueObject instanceof KeyUsage) {
            //return (KeyUsage) extnValueObject;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.717 -0400", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "175E4A8296C8A0AF70C4567702C1336D")
    public BasicConstraints getBasicConstraintsValue() {
        BasicConstraints varB4EAC82CA7396A68D541C85D26508E83_1737611478 = null; //Variable for return #1
        BasicConstraints varB4EAC82CA7396A68D541C85D26508E83_145496410 = null; //Variable for return #2
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1737611478 = (BasicConstraints) extnValueObject;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_145496410 = null;
        } //End block
        BasicConstraints varA7E53CE21691AB073D9660D615818899_84238681; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_84238681 = varB4EAC82CA7396A68D541C85D26508E83_1737611478;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_84238681 = varB4EAC82CA7396A68D541C85D26508E83_145496410;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_84238681.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_84238681;
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //try {
                //decodeExtensionValue();
            //} catch (IOException ignored) {
            //}
        //}
        //if (extnValueObject instanceof BasicConstraints) {
            //return (BasicConstraints) extnValueObject;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.723 -0400", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "28A4E460AC633B50E3980E3595DAF32C")
    private void decodeExtensionValue() throws IOException {
        valueDecoded = true;
        {
            boolean varAB54FC05496F6295091A57B6D1F917E4_506306587 = (Arrays.equals(extnID, SUBJ_KEY_ID));
            {
                extnValueObject = SubjectKeyIdentifier.decode(extnValue);
            } //End block
            {
                boolean var79029BF70BB25748F0031BECDFC677F0_1543996177 = (Arrays.equals(extnID, KEY_USAGE));
                {
                    extnValueObject = new KeyUsage(extnValue);
                } //End block
                {
                    boolean var29928D2F0E1AE92B4EE44FD113DA26AA_1282362714 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                    {
                        extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                    } //End block
                    {
                        boolean varD20C75BE6CC43A14751C65D119228C3A_2115009137 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                        {
                            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                        } //End block
                        {
                            boolean varBE53E1A959872908090C494A7AB2392D_1938903085 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                            {
                                extnValueObject = new BasicConstraints(extnValue);
                            } //End block
                            {
                                boolean var5A791D62D10D7BF57CD09CA0530210CA_1038572090 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                {
                                    extnValueObject = NameConstraints.decode(extnValue);
                                } //End block
                                {
                                    boolean var112C83EF4DD7E7E88ECFE15117D39C6D_1079138899 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                    {
                                        extnValueObject = CertificatePolicies.decode(extnValue);
                                    } //End block
                                    {
                                        boolean var9997835AD8D731E68A43122000F851E4_990846574 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                        {
                                            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
                                        } //End block
                                        {
                                            boolean var09F276B08BD777DFF04E4CD8796848A1_837761237 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                            {
                                                extnValueObject = new PolicyConstraints(extnValue);
                                            } //End block
                                            {
                                                boolean var6EF1777FA134D2C6F1F80DD9F9A47B8D_2024935306 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                {
                                                    extnValueObject = new ExtendedKeyUsage(extnValue);
                                                } //End block
                                                {
                                                    boolean var44A5226B44D58B9425B0E256BE9FB527_174735358 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                    {
                                                        extnValueObject = new InhibitAnyPolicy(extnValue);
                                                    } //End block
                                                    {
                                                        boolean var93521D58B41ADFE8278B6F7231FF23E7_624125844 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                        {
                                                            extnValueObject = new CertificateIssuer(extnValue);
                                                        } //End block
                                                        {
                                                            boolean varD5FFB1153C5E90B82F14EF6589E1DC95_318706286 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                                            {
                                                                extnValueObject = CRLDistributionPoints.decode(extnValue);
                                                            } //End block
                                                            {
                                                                boolean var8A49AD6C907832B5A81CD0DE1019700B_2101915544 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                                {
                                                                    extnValueObject = new ReasonCode(extnValue);
                                                                } //End block
                                                                {
                                                                    boolean var3C464CC7970A9FAE3C292FB9DB775A18_1211579735 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                    {
                                                                        extnValueObject = new InvalidityDate(extnValue);
                                                                    } //End block
                                                                    {
                                                                        boolean varDF59FBD3E702A0531884AAD7E88B6DAC_922082603 = (Arrays.equals(extnID, REASON_CODE));
                                                                        {
                                                                            extnValueObject = new ReasonCode(extnValue);
                                                                        } //End block
                                                                        {
                                                                            boolean varCA92F6DC87650A9732A66EC46314EC63_411908192 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                            {
                                                                                extnValueObject = new CRLNumber(extnValue);
                                                                            } //End block
                                                                            {
                                                                                boolean var9CB5BC68027662BFA0C2D20DA8D9A010_442626764 = (Arrays.equals(extnID, ISSUING_DISTR_POINTS));
                                                                                {
                                                                                    extnValueObject = IssuingDistributionPoint.decode(extnValue);
                                                                                } //End block
                                                                                {
                                                                                    boolean varB24AC34B42C7A4E2668F5DCE93D76645_1405530243 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                                    {
                                                                                        extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                    } //End block
                                                                                    {
                                                                                        boolean varD2BB3DB505EC9CA31C9F97B0FCBEAE86_1377829765 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                                        {
                                                                                            extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                        } //End block
                                                                                    } //End collapsed parenthetic
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.725 -0400", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "B69FD79C1EEFFD6E610218ACF9762F17")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append("OID: ").append(getExtnID()).append(", Critical: ").append(critical).append('\n');
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        {
            extnValueObject.dumpValue(sb, prefix);
        } //End block
        sb.append(prefix);
        {
            boolean varA221B1146EC21CCCA34E2F25D5224B62_1737629033 = (Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS));
            {
                sb.append("Subject Directory Attributes Extension");
            } //End block
            {
                boolean var8DF0EC9A6AEA6EFB3FB5C280D7D74F9B_1755847977 = (Arrays.equals(extnID, SUBJ_KEY_ID));
                {
                    sb.append("Subject Key Identifier Extension");
                } //End block
                {
                    boolean varF4C07E0FE65656621B8BCE269E8B58EF_1606075739 = (Arrays.equals(extnID, KEY_USAGE));
                    {
                        sb.append("Key Usage Extension");
                    } //End block
                    {
                        boolean varAA372AED1E2AA1D54925B54D69F8DB90_1162311991 = (Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD));
                        {
                            sb.append("Private Key Usage Period Extension");
                        } //End block
                        {
                            boolean var798B3C516162896973F8A912AADF2342_2125524696 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                            {
                                sb.append("Subject Alternative Name Extension");
                            } //End block
                            {
                                boolean varA7C4827A995FE964AABC87414038EBBE_1234881653 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                                {
                                    sb.append("Issuer Alternative Name Extension");
                                } //End block
                                {
                                    boolean varE21A4DBDF9C91AE82217AC44614585FE_528939861 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                                    {
                                        sb.append("Basic Constraints Extension");
                                    } //End block
                                    {
                                        boolean var7169DD5CE39017F9C9B4B9884B1B9568_1805805270 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                        {
                                            sb.append("Name Constraints Extension");
                                        } //End block
                                        {
                                            boolean varECD4FFAE2DF9F6D6E5520D99835A6F31_845869922 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                            {
                                                sb.append("CRL Distribution Points Extension");
                                            } //End block
                                            {
                                                boolean var13FF4F808684FD573126EE212EA51786_1321649837 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                                {
                                                    sb.append("Certificate Policies Extension");
                                                } //End block
                                                {
                                                    boolean varAE8E329E1E0543065CC25EC5F26F8882_599086228 = (Arrays.equals(extnID, POLICY_MAPPINGS));
                                                    {
                                                        sb.append("Policy Mappings Extension");
                                                    } //End block
                                                    {
                                                        boolean var462955B2DF2534E3BC83A1D61ACA2B44_455770203 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                                        {
                                                            sb.append("Authority Key Identifier Extension");
                                                        } //End block
                                                        {
                                                            boolean varB2C78479445E120DEA730A255DC280D6_667175605 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                                            {
                                                                sb.append("Policy Constraints Extension");
                                                            } //End block
                                                            {
                                                                boolean var7E91A6CA310680B093FD88063F8ED148_2067783739 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                                {
                                                                    sb.append("Extended Key Usage Extension");
                                                                } //End block
                                                                {
                                                                    boolean var2B9738A611418D1A003180D5A0034093_1330070943 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                                    {
                                                                        sb.append("Inhibit Any-Policy Extension");
                                                                    } //End block
                                                                    {
                                                                        boolean var2FDC903F1140F0C783B43300553D7073_698087870 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                        {
                                                                            sb.append("Authority Information Access Extension");
                                                                        } //End block
                                                                        {
                                                                            boolean var1A9F19376AD1E1128CDFDE7F880CFF1A_1370907287 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                            {
                                                                                sb.append("Subject Information Access Extension");
                                                                            } //End block
                                                                            {
                                                                                boolean var64EE348197FCEC58F6DF3BD83E5F3361_1294769829 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                                {
                                                                                    sb.append("Invalidity Date Extension");
                                                                                } //End block
                                                                                {
                                                                                    boolean varFEBBBF17861D8A2A8A1CDCEDBEADDB9A_529559332 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                                    {
                                                                                        sb.append("CRL Number Extension");
                                                                                    } //End block
                                                                                    {
                                                                                        boolean var7A124ADB859F1043EEDF9FC8C3E2A3CB_22101781 = (Arrays.equals(extnID, REASON_CODE));
                                                                                        {
                                                                                            sb.append("Reason Code Extension");
                                                                                        } //End block
                                                                                        {
                                                                                            sb.append("Unknown Extension");
                                                                                        } //End block
                                                                                    } //End collapsed parenthetic
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        sb.append('\n').append(prefix).append("Unparsed Extension Value:\n");
        sb.append(Array.toString(extnValue, prefix));
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "9D770FFDDC15870F3D3A340ACD808078", hash_generated_field = "6E31BBAF500C1070EE1FFA080111393F")

    public static final boolean CRITICAL = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "61B04E4695AA5F374EEFDAD16E9E0524", hash_generated_field = "57D4ADD3A20722C1472A183BBA626F17")

    public static final boolean NON_CRITICAL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "27AC59456ABCB1CE64FC2C3053748D09", hash_generated_field = "F3FB36682E237724BE0F5A4E8D74DF4E")

    static int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "719C2AB0E2F06E3BD1FF47B05C669C52", hash_generated_field = "775D364E0BF804D07C9A7706EE4055C3")

    static int[] SUBJ_KEY_ID = {2, 5, 29, 14};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "B58C569327B16FBE6BA2EC3275E60A70", hash_generated_field = "1CB86C21B12C3C987FDC162B18A01616")

    static int[] KEY_USAGE = {2, 5, 29, 15};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "11C15EF3E2ED91D6D2AE5ADD3AAB40C0", hash_generated_field = "E9A95F7F137EC8FD5217F3DEA20CEA9B")

    static int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "763E9AF8FC55F30DD20FEB41EE56E8F5", hash_generated_field = "FFA57DF700D42612D005407D3F80FCE6")

    static int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "6389938383D6D3F2B15BB97818ADA090", hash_generated_field = "3555129EFB711E06B1A782927674BF52")

    static int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "E2763B92F43C78EB5AE7CA4C13875A2E", hash_generated_field = "5A691CE49FFB0D7CB09EBF605A802108")

    static int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "2CC72DB0339D067215FFC0B86EBC615B", hash_generated_field = "3E904C026550FD7862E882D63A44EF4E")

    static int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "C6D831E4B714E4BEBA10A0311994F721", hash_generated_field = "1D33CAA4EE2E611A22BF4C88C0D88E97")

    static int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "54E4E62889082A4291C82572415D3FD3", hash_generated_field = "CDDF5B7628117826FEF88DE1AF119FDE")

    static int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "92B4E401637FF5C4D11E2E6AA1497575", hash_generated_field = "657DA4434B1044CDBDB7BAC3785AC6BA")

    static int[] POLICY_MAPPINGS = {2, 5, 29, 33};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "09CD194DEE87CC00E22813CE03AA2189", hash_generated_field = "4465DDA362E1A99613C61F8A8B3842E1")

    static int[] AUTH_KEY_ID = {2, 5, 29, 35};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "3A149D04714488EAABB6793BAAC971C7", hash_generated_field = "866784E0A2C31114C2F30D2770A5E84A")

    static int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "A8CB7D09038D802044B2796F8FEC3D21", hash_generated_field = "E1F62CFF98AF75B8544CE8896061DABD")

    static int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "711DE24A0324604FFC2C892BE38CA12B", hash_generated_field = "293F70C6F8C0A131BD5BB5A09D0FE582")

    static int[] FRESHEST_CRL = {2, 5, 29, 46};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "E584FD6E092027A6F9AE59B800B4BEE1", hash_generated_field = "952E7A2A10D0DAACD10E0807F439931A")

    static int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.744 -0400", hash_original_field = "F887D8CC4B9E928778BB90E4DD18EC2B", hash_generated_field = "7A7155CCC746DE542AED60CFE89140EA")

    static int[] AUTHORITY_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 1};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_field = "E570A9AB6529D0B74A5004F2E1A61DC9", hash_generated_field = "197B5F54426CC704D6C8F834A646C12D")

    static int[] SUBJECT_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 11};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_field = "ADDCB4B21210BC97410BFAB822DE5567", hash_generated_field = "C74827D67B0ECFA0C2AB57DE848FEBD4")

    static int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_field = "A1BE3CEA110171E88491EB6296EC8BCE", hash_generated_field = "9CDA3ABAD99998B023F6A4D04664071F")

    static int[] CRL_NUMBER = {2, 5, 29, 20};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_field = "A5C359B3674964EBA0BAD84A851DDECE", hash_generated_field = "3E9E2579F9B896B1BAA46961D4B8F2CC")

    static int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_field = "274041C10371CF3BFE121AE51FD7402B", hash_generated_field = "0AA24668AA9D378D090DA8AEBF745922")

    static int[] INVALIDITY_DATE = {2, 5, 29, 24};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.747 -0400", hash_original_field = "78516CB1FE0FD6BF662239155F765B89", hash_generated_field = "F86AFA17664E1641FA0A3813B1696DBD")

    static int[] REASON_CODE = {2, 5, 29, 21};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.747 -0400", hash_original_field = "BC1CA6B2C393BDBE6FD729838874757D", hash_generated_field = "9EE43B6FB0A4465447BD8636130D469C")

    static int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.747 -0400", hash_original_field = "162B518F6D507BF8606DF33C2285800B", hash_generated_field = "3978C13F4770C29C9F00A89FB623B39E")

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

