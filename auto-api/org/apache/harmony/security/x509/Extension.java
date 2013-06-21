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
    private int[] extnID;
    private String extnID_str;
    private boolean critical;
    private byte[] extnValue;
    private byte[] encoding;
    private byte[] rawExtnValue;
    protected ExtensionValue extnValueObject;
    private boolean valueDecoded = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.667 -0400", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "63FF57C2523229C9C9E84A707320E8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, boolean critical,
            ExtensionValue extnValueObject) {
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(extnValueObject.dsTaint);
        this.extnID = ObjectIdentifier.toIntArray(extnID);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.667 -0400", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "3F776391EA3036E7D91F12A9CF8775E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, boolean critical, byte[] extnValue) {
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(extnValue[0]);
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.668 -0400", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "EED854EAAA6646A083CA330D7661FBC6")
    @DSModeled(DSC.SAFE)
    public Extension(int[] extnID, boolean critical, byte[] extnValue) {
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnID[0]);
        dsTaint.addTaint(extnValue[0]);
        // ---------- Original Method ----------
        //this.extnID = extnID;
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.668 -0400", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "0E1B0A6230700AEEF3A1C911260ECFD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(extnValue[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.668 -0400", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "278425B5AFB9B2A8D01B1174A0B75525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        dsTaint.addTaint(extnID[0]);
        dsTaint.addTaint(extnValue[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.668 -0400", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "15BB32D6E2DEAF1E861556009C4A6F1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Extension(int[] extnID, boolean critical, byte[] extnValue,
            byte[] rawExtnValue, byte[] encoding,
            ExtensionValue decodedExtValue) {
        this(extnID, critical, extnValue);
        dsTaint.addTaint(rawExtnValue[0]);
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnID[0]);
        dsTaint.addTaint(extnValue[0]);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(decodedExtValue.dsTaint);
        this.valueDecoded = (decodedExtValue != null);
        // ---------- Original Method ----------
        //this.rawExtnValue = rawExtnValue;
        //this.encoding = encoding;
        //this.extnValueObject = decodedExtValue;
        //this.valueDecoded = (decodedExtValue != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.668 -0400", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "428FDB2FB67E0CBF5982EBC89F2EDF03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getExtnID() {
        {
            extnID_str = ObjectIdentifier.toString(extnID);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (extnID_str == null) {
            //extnID_str = ObjectIdentifier.toString(extnID);
        //}
        //return extnID_str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.669 -0400", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "E0D559C634CE2BBCFA4C167005018C32")
    @DSModeled(DSC.SAFE)
    public boolean getCritical() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.669 -0400", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "06250FAD9FDC9FED0BFA05D2F148574B")
    @DSModeled(DSC.SAFE)
    public byte[] getExtnValue() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.669 -0400", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "0BD3FBA6089D0BC9778F3178FC9982B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getRawExtnValue() {
        {
            rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (rawExtnValue == null) {
            //rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        //}
        //return rawExtnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.669 -0400", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "6327CAE212A0C41DB90E4ADD52440D48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = Extension.ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Extension.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.669 -0400", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "FB9C9A8315586C756A859E3ABC694B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object ext) {
        dsTaint.addTaint(ext.dsTaint);
        Extension extension;
        extension = (Extension) ext;
        boolean var9DCFD56BF24A6A1546F9545527B1BEF4_524590270 = (Arrays.equals(extnID, extension.extnID)
            && (critical == extension.critical)
            && Arrays.equals(extnValue, extension.extnValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(ext instanceof Extension)) {
            //return false;
        //}
        //Extension extension = (Extension) ext;
        //return Arrays.equals(extnID, extension.extnID)
            //&& (critical == extension.critical)
            //&& Arrays.equals(extnValue, extension.extnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.670 -0400", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "43FD62A78EFF1C6D2F6F38ADA97FE48B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var5B5A1F8476FB12CFA8AEDE9AB0880DDA_1419022103 = ((Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.670 -0400", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "6AAD7424F1BDB605E9865B5829E8AA30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtensionValue getDecodedExtensionValue() throws IOException {
        {
            decodeExtensionValue();
        } //End block
        return (ExtensionValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //decodeExtensionValue();
        //}
        //return extnValueObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.670 -0400", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "F0FD4E8D1BEF46F2DEFF39D5ED16B225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyUsage getKeyUsageValue() {
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        return (KeyUsage)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.670 -0400", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "05000204ED49AC93525C3FD996816872")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BasicConstraints getBasicConstraintsValue() {
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            { }
        } //End block
        return (BasicConstraints)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.671 -0400", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "51A1F12F6C8E24E0253D0C590526222F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decodeExtensionValue() throws IOException {
        valueDecoded = true;
        {
            boolean varAB54FC05496F6295091A57B6D1F917E4_44961242 = (Arrays.equals(extnID, SUBJ_KEY_ID));
            {
                extnValueObject = SubjectKeyIdentifier.decode(extnValue);
            } //End block
            {
                boolean var79029BF70BB25748F0031BECDFC677F0_1356340491 = (Arrays.equals(extnID, KEY_USAGE));
                {
                    extnValueObject = new KeyUsage(extnValue);
                } //End block
                {
                    boolean var29928D2F0E1AE92B4EE44FD113DA26AA_1096671668 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                    {
                        extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                    } //End block
                    {
                        boolean varD20C75BE6CC43A14751C65D119228C3A_802142783 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                        {
                            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                        } //End block
                        {
                            boolean varBE53E1A959872908090C494A7AB2392D_1152424358 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                            {
                                extnValueObject = new BasicConstraints(extnValue);
                            } //End block
                            {
                                boolean var5A791D62D10D7BF57CD09CA0530210CA_952542016 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                {
                                    extnValueObject = NameConstraints.decode(extnValue);
                                } //End block
                                {
                                    boolean var112C83EF4DD7E7E88ECFE15117D39C6D_815607537 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                    {
                                        extnValueObject = CertificatePolicies.decode(extnValue);
                                    } //End block
                                    {
                                        boolean var9997835AD8D731E68A43122000F851E4_1368760873 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                        {
                                            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
                                        } //End block
                                        {
                                            boolean var09F276B08BD777DFF04E4CD8796848A1_420276091 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                            {
                                                extnValueObject = new PolicyConstraints(extnValue);
                                            } //End block
                                            {
                                                boolean var6EF1777FA134D2C6F1F80DD9F9A47B8D_1979614296 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                {
                                                    extnValueObject = new ExtendedKeyUsage(extnValue);
                                                } //End block
                                                {
                                                    boolean var44A5226B44D58B9425B0E256BE9FB527_1064444536 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                    {
                                                        extnValueObject = new InhibitAnyPolicy(extnValue);
                                                    } //End block
                                                    {
                                                        boolean var93521D58B41ADFE8278B6F7231FF23E7_922155314 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                        {
                                                            extnValueObject = new CertificateIssuer(extnValue);
                                                        } //End block
                                                        {
                                                            boolean varD5FFB1153C5E90B82F14EF6589E1DC95_1760915346 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                                            {
                                                                extnValueObject = CRLDistributionPoints.decode(extnValue);
                                                            } //End block
                                                            {
                                                                boolean var8A49AD6C907832B5A81CD0DE1019700B_2011507063 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                                {
                                                                    extnValueObject = new ReasonCode(extnValue);
                                                                } //End block
                                                                {
                                                                    boolean var3C464CC7970A9FAE3C292FB9DB775A18_38704571 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                    {
                                                                        extnValueObject = new InvalidityDate(extnValue);
                                                                    } //End block
                                                                    {
                                                                        boolean varDF59FBD3E702A0531884AAD7E88B6DAC_1119497470 = (Arrays.equals(extnID, REASON_CODE));
                                                                        {
                                                                            extnValueObject = new ReasonCode(extnValue);
                                                                        } //End block
                                                                        {
                                                                            boolean varCA92F6DC87650A9732A66EC46314EC63_1926428185 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                            {
                                                                                extnValueObject = new CRLNumber(extnValue);
                                                                            } //End block
                                                                            {
                                                                                boolean var9CB5BC68027662BFA0C2D20DA8D9A010_1898283448 = (Arrays.equals(extnID, ISSUING_DISTR_POINTS));
                                                                                {
                                                                                    extnValueObject = IssuingDistributionPoint.decode(extnValue);
                                                                                } //End block
                                                                                {
                                                                                    boolean varB24AC34B42C7A4E2668F5DCE93D76645_1524452874 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                                    {
                                                                                        extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                    } //End block
                                                                                    {
                                                                                        boolean varD2BB3DB505EC9CA31C9F97B0FCBEAE86_563049743 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.672 -0400", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "A24DABCDC12397DEE007DBA5412404BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
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
            boolean varA221B1146EC21CCCA34E2F25D5224B62_1293695912 = (Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS));
            {
                sb.append("Subject Directory Attributes Extension");
            } //End block
            {
                boolean var8DF0EC9A6AEA6EFB3FB5C280D7D74F9B_1920056280 = (Arrays.equals(extnID, SUBJ_KEY_ID));
                {
                    sb.append("Subject Key Identifier Extension");
                } //End block
                {
                    boolean varF4C07E0FE65656621B8BCE269E8B58EF_251408024 = (Arrays.equals(extnID, KEY_USAGE));
                    {
                        sb.append("Key Usage Extension");
                    } //End block
                    {
                        boolean varAA372AED1E2AA1D54925B54D69F8DB90_1827045792 = (Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD));
                        {
                            sb.append("Private Key Usage Period Extension");
                        } //End block
                        {
                            boolean var798B3C516162896973F8A912AADF2342_1492753693 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                            {
                                sb.append("Subject Alternative Name Extension");
                            } //End block
                            {
                                boolean varA7C4827A995FE964AABC87414038EBBE_1368227565 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                                {
                                    sb.append("Issuer Alternative Name Extension");
                                } //End block
                                {
                                    boolean varE21A4DBDF9C91AE82217AC44614585FE_618724864 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                                    {
                                        sb.append("Basic Constraints Extension");
                                    } //End block
                                    {
                                        boolean var7169DD5CE39017F9C9B4B9884B1B9568_2121207036 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                        {
                                            sb.append("Name Constraints Extension");
                                        } //End block
                                        {
                                            boolean varECD4FFAE2DF9F6D6E5520D99835A6F31_96553621 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                            {
                                                sb.append("CRL Distribution Points Extension");
                                            } //End block
                                            {
                                                boolean var13FF4F808684FD573126EE212EA51786_1560676405 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                                {
                                                    sb.append("Certificate Policies Extension");
                                                } //End block
                                                {
                                                    boolean varAE8E329E1E0543065CC25EC5F26F8882_349686172 = (Arrays.equals(extnID, POLICY_MAPPINGS));
                                                    {
                                                        sb.append("Policy Mappings Extension");
                                                    } //End block
                                                    {
                                                        boolean var462955B2DF2534E3BC83A1D61ACA2B44_1385838904 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                                        {
                                                            sb.append("Authority Key Identifier Extension");
                                                        } //End block
                                                        {
                                                            boolean varB2C78479445E120DEA730A255DC280D6_723123779 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                                            {
                                                                sb.append("Policy Constraints Extension");
                                                            } //End block
                                                            {
                                                                boolean var7E91A6CA310680B093FD88063F8ED148_393135045 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                                {
                                                                    sb.append("Extended Key Usage Extension");
                                                                } //End block
                                                                {
                                                                    boolean var2B9738A611418D1A003180D5A0034093_1685149452 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                                    {
                                                                        sb.append("Inhibit Any-Policy Extension");
                                                                    } //End block
                                                                    {
                                                                        boolean var2FDC903F1140F0C783B43300553D7073_1685678207 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                        {
                                                                            sb.append("Authority Information Access Extension");
                                                                        } //End block
                                                                        {
                                                                            boolean var1A9F19376AD1E1128CDFDE7F880CFF1A_375019410 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                            {
                                                                                sb.append("Subject Information Access Extension");
                                                                            } //End block
                                                                            {
                                                                                boolean var64EE348197FCEC58F6DF3BD83E5F3361_1089258428 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                                {
                                                                                    sb.append("Invalidity Date Extension");
                                                                                } //End block
                                                                                {
                                                                                    boolean varFEBBBF17861D8A2A8A1CDCEDBEADDB9A_1655826626 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                                    {
                                                                                        sb.append("CRL Number Extension");
                                                                                    } //End block
                                                                                    {
                                                                                        boolean var7A124ADB859F1043EEDF9FC8C3E2A3CB_23935145 = (Arrays.equals(extnID, REASON_CODE));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final boolean CRITICAL = true;
    public static final boolean NON_CRITICAL = false;
    static final int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
    static final int[] SUBJ_KEY_ID = {2, 5, 29, 14};
    static final int[] KEY_USAGE = {2, 5, 29, 15};
    static final int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
    static final int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
    static final int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
    static final int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
    static final int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
    static final int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
    static final int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
    static final int[] POLICY_MAPPINGS = {2, 5, 29, 33};
    static final int[] AUTH_KEY_ID = {2, 5, 29, 35};
    static final int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
    static final int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
    static final int[] FRESHEST_CRL = {2, 5, 29, 46};
    static final int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
    static final int[] AUTHORITY_INFO_ACCESS =
                                            {1, 3, 6, 1, 5, 5, 7, 1, 1};
    static final int[] SUBJECT_INFO_ACCESS =
                                            {1, 3, 6, 1, 5, 5, 7, 1, 11};
    static final int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
    static final int[] CRL_NUMBER = {2, 5, 29, 20};
    static final int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
    static final int[] INVALIDITY_DATE = {2, 5, 29, 24};
    static final int[] REASON_CODE = {2, 5, 29, 21};
    static final int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            ASN1Boolean.getInstance(),
            new ASN1OctetString() {
                @Override public Object getDecodedObject(BerInputStream in) throws IOException {
                    
                    
                    return new Object[]
                        {super.getDecodedObject(in), in.getEncoded()};
                }
            }
        }) {        {
            setDefault(Boolean.FALSE, 1);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.673 -0400", hash_original_method = "76E4451FF0478DD5E12D05D308694266", hash_generated_method = "3D2ABFCAFBF917840E74F866055BBC2C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            int[] oid;
            oid = (int[]) values[0];
            byte[] extnValue;
            extnValue = (byte[]) ((Object[]) values[2])[0];
            byte[] rawExtnValue;
            rawExtnValue = (byte[]) ((Object[]) values[2])[1];
            ExtensionValue decodedExtValue;
            decodedExtValue = null;
            {
                boolean varAE9AE3710E891E85486735315E12C933_597847898 = (Arrays.equals(oid, KEY_USAGE));
                {
                    decodedExtValue = new KeyUsage(extnValue);
                } //End block
                {
                    boolean var3B30FF49E22BF647083F3FFC7E0CA761_748327159 = (Arrays.equals(oid, BASIC_CONSTRAINTS));
                    {
                        decodedExtValue = new BasicConstraints(extnValue);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            Object var21971006B780D34B658EF754CDDC8B04_1385488684 = (new Extension((int[]) values[0], (Boolean) values[1],
                    extnValue, rawExtnValue, in.getEncoded(), decodedExtValue));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //int[] oid = (int[]) values[0];
            //byte[] extnValue = (byte[]) ((Object[]) values[2])[0];
            //byte[] rawExtnValue = (byte[]) ((Object[]) values[2])[1];
            //ExtensionValue decodedExtValue = null;
            //if (Arrays.equals(oid, KEY_USAGE)) {
                //decodedExtValue = new KeyUsage(extnValue);
            //} else if (Arrays.equals(oid, BASIC_CONSTRAINTS)) {
                //decodedExtValue = new BasicConstraints(extnValue);
            //}
            //return new Extension((int[]) values[0], (Boolean) values[1],
                    //extnValue, rawExtnValue, in.getEncoded(), decodedExtValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.673 -0400", hash_original_method = "C2EBD010FE004A7CF9B3B50ACF2F1130", hash_generated_method = "E3944718CF8D1C554C19C6F7FA916B25")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            Extension ext;
            ext = (Extension) object;
            values[0] = ext.extnID;
            values[1] = (ext.critical) ? Boolean.TRUE : Boolean.FALSE;
            values[2] = ext.extnValue;
            // ---------- Original Method ----------
            //Extension ext = (Extension) object;
            //values[0] = ext.extnID;
            //values[1] = (ext.critical) ? Boolean.TRUE : Boolean.FALSE;
            //values[2] = ext.extnValue;
        }

        
}; //Transformed anonymous class
}

