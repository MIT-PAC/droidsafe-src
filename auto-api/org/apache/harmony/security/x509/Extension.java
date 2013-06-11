package org.apache.harmony.security.x509;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
// import Iterator to deal with enhanced for loop translation

public final class Extension {
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
    private final int[] extnID;
    private String extnID_str;
    private final boolean critical;
    private final byte[] extnValue;
    private byte[] encoding;
    private byte[] rawExtnValue;
    protected ExtensionValue extnValueObject;
    private boolean valueDecoded = false;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.916 -0400", hash_original_method = "76E4451FF0478DD5E12D05D308694266", hash_generated_method = "ADB715D8D815F1CBD5DCEEA099FECA27")
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
                boolean varAE9AE3710E891E85486735315E12C933_352545878 = (Arrays.equals(oid, KEY_USAGE));
                {
                    decodedExtValue = new KeyUsage(extnValue);
                } //End block
                {
                    boolean var3B30FF49E22BF647083F3FFC7E0CA761_1348462418 = (Arrays.equals(oid, BASIC_CONSTRAINTS));
                    {
                        decodedExtValue = new BasicConstraints(extnValue);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            Object var21971006B780D34B658EF754CDDC8B04_25888884 = (new Extension((int[]) values[0], (Boolean) values[1],
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "C2EBD010FE004A7CF9B3B50ACF2F1130", hash_generated_method = "1BDAD914FD322A81CDBCC36004B0E6D0")
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

        
         {
            setDefault(Boolean.FALSE, 1);
        }
        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "8F4A081F34BAC62E720E0C23EC0783A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, boolean critical, ExtensionValue extnValueObject) {Extension
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(critical);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "5751BDA7B19807B2AA65A25FE77801FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, boolean critical, byte[] extnValue) {
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnValue);
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.extnValue = extnValue;
        this.critical = critical;
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "30FEABF7D75194A67FF16475B6C91647")
    @DSModeled(DSC.SAFE)
    public Extension(int[] extnID, boolean critical, byte[] extnValue) {
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(critical);
        dsTaint.addTaint(extnValue);
        this.critical = critical;
        this.extnValue = extnValue;
        this.extnID = extnID;
        
        // ---------- Original Method ----------
        //this.extnID = extnID;
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "72DF682E90C1DC4055D2AE6D6973DAFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(extnValue);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "F62069759547DA103FDCCEECA9ADB156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(extnValue);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "7636E5DB30FBB58D320E04037EDE06FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Extension(int[] extnID, boolean critical, byte[] extnValue,
            byte[] rawExtnValue, byte[] encoding,
            ExtensionValue decodedExtValue) {
        this(extnID, critical, extnValue);
        dsTaint.addTaint(extnID);
        dsTaint.addTaint(critical);
        dsTaint.addTaint(rawExtnValue);
        dsTaint.addTaint(extnValue);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(decodedExtValue.dsTaint);
        this.valueDecoded = (decodedExtValue != null);
        // ---------- Original Method ----------
        //this.rawExtnValue = rawExtnValue;
        //this.encoding = encoding;
        //this.extnValueObject = decodedExtValue;
        //this.valueDecoded = (decodedExtValue != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "684B6A4CAD1C904791165FD1E952F09C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "9CED8EF9DCA6DF4227E9DD2CE1F02D74")
    @DSModeled(DSC.SAFE)
    public boolean getCritical() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "D825447D59F0694452C458FF11A6557A")
    @DSModeled(DSC.SAFE)
    public byte[] getExtnValue() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "C9C35211E8A877C02811650545DC4DEB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.917 -0400", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "10B9BA53EC9D6F0644D774AD87D6D422")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.918 -0400", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "728A6491ACD57C5BF1B1D348E1703D5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object ext) {
        dsTaint.addTaint(ext.dsTaint);
        Extension extension;
        extension = (Extension) ext;
        boolean var9DCFD56BF24A6A1546F9545527B1BEF4_1723046508 = (Arrays.equals(extnID, extension.extnID)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.918 -0400", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "410FC0AFEE987AAF2568386EBA4BBEA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var5B5A1F8476FB12CFA8AEDE9AB0880DDA_686913575 = ((Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.918 -0400", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "D62C251019D056C7AAD95D9A2D365953")
    @DSModeled(DSC.SAFE)
    public ExtensionValue getDecodedExtensionValue() throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.918 -0400", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "B4C5918495B22872DBF92EBD78A10D3D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.918 -0400", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "42E31DB03051B9FB88A56EE26BF770B3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.919 -0400", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "E09183A914D78E6D993F8FB6497ACA8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decodeExtensionValue() throws IOException {
        valueDecoded = true;
        {
            boolean varAB54FC05496F6295091A57B6D1F917E4_1335443998 = (Arrays.equals(extnID, SUBJ_KEY_ID));
            {
                extnValueObject = SubjectKeyIdentifier.decode(extnValue);
            } //End block
            {
                boolean var79029BF70BB25748F0031BECDFC677F0_414836792 = (Arrays.equals(extnID, KEY_USAGE));
                {
                    extnValueObject = new KeyUsage(extnValue);
                } //End block
                {
                    boolean var29928D2F0E1AE92B4EE44FD113DA26AA_329036217 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                    {
                        extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                    } //End block
                    {
                        boolean varD20C75BE6CC43A14751C65D119228C3A_630214230 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                        {
                            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
                        } //End block
                        {
                            boolean varBE53E1A959872908090C494A7AB2392D_615104030 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                            {
                                extnValueObject = new BasicConstraints(extnValue);
                            } //End block
                            {
                                boolean var5A791D62D10D7BF57CD09CA0530210CA_1338502249 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                {
                                    extnValueObject = NameConstraints.decode(extnValue);
                                } //End block
                                {
                                    boolean var112C83EF4DD7E7E88ECFE15117D39C6D_958254172 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                    {
                                        extnValueObject = CertificatePolicies.decode(extnValue);
                                    } //End block
                                    {
                                        boolean var9997835AD8D731E68A43122000F851E4_539620296 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                        {
                                            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
                                        } //End block
                                        {
                                            boolean var09F276B08BD777DFF04E4CD8796848A1_1950588295 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                            {
                                                extnValueObject = new PolicyConstraints(extnValue);
                                            } //End block
                                            {
                                                boolean var6EF1777FA134D2C6F1F80DD9F9A47B8D_1291619523 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                {
                                                    extnValueObject = new ExtendedKeyUsage(extnValue);
                                                } //End block
                                                {
                                                    boolean var44A5226B44D58B9425B0E256BE9FB527_594984049 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                    {
                                                        extnValueObject = new InhibitAnyPolicy(extnValue);
                                                    } //End block
                                                    {
                                                        boolean var93521D58B41ADFE8278B6F7231FF23E7_697852001 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                        {
                                                            extnValueObject = new CertificateIssuer(extnValue);
                                                        } //End block
                                                        {
                                                            boolean varD5FFB1153C5E90B82F14EF6589E1DC95_846918890 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                                            {
                                                                extnValueObject = CRLDistributionPoints.decode(extnValue);
                                                            } //End block
                                                            {
                                                                boolean var8A49AD6C907832B5A81CD0DE1019700B_568248184 = (Arrays.equals(extnID, CERTIFICATE_ISSUER));
                                                                {
                                                                    extnValueObject = new ReasonCode(extnValue);
                                                                } //End block
                                                                {
                                                                    boolean var3C464CC7970A9FAE3C292FB9DB775A18_768015543 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                    {
                                                                        extnValueObject = new InvalidityDate(extnValue);
                                                                    } //End block
                                                                    {
                                                                        boolean varDF59FBD3E702A0531884AAD7E88B6DAC_1067521167 = (Arrays.equals(extnID, REASON_CODE));
                                                                        {
                                                                            extnValueObject = new ReasonCode(extnValue);
                                                                        } //End block
                                                                        {
                                                                            boolean varCA92F6DC87650A9732A66EC46314EC63_724096629 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                            {
                                                                                extnValueObject = new CRLNumber(extnValue);
                                                                            } //End block
                                                                            {
                                                                                boolean var9CB5BC68027662BFA0C2D20DA8D9A010_1158356374 = (Arrays.equals(extnID, ISSUING_DISTR_POINTS));
                                                                                {
                                                                                    extnValueObject = IssuingDistributionPoint.decode(extnValue);
                                                                                } //End block
                                                                                {
                                                                                    boolean varB24AC34B42C7A4E2668F5DCE93D76645_979882349 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                                    {
                                                                                        extnValueObject = InfoAccessSyntax.decode(extnValue);
                                                                                    } //End block
                                                                                    {
                                                                                        boolean varD2BB3DB505EC9CA31C9F97B0FCBEAE86_1669958510 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.919 -0400", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "66A5F56493672A59B996CE62D31BAC56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(prefix);
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
            boolean varA221B1146EC21CCCA34E2F25D5224B62_1348581644 = (Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS));
            {
                sb.append("Subject Directory Attributes Extension");
            } //End block
            {
                boolean var8DF0EC9A6AEA6EFB3FB5C280D7D74F9B_681929274 = (Arrays.equals(extnID, SUBJ_KEY_ID));
                {
                    sb.append("Subject Key Identifier Extension");
                } //End block
                {
                    boolean varF4C07E0FE65656621B8BCE269E8B58EF_1870400422 = (Arrays.equals(extnID, KEY_USAGE));
                    {
                        sb.append("Key Usage Extension");
                    } //End block
                    {
                        boolean varAA372AED1E2AA1D54925B54D69F8DB90_887890716 = (Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD));
                        {
                            sb.append("Private Key Usage Period Extension");
                        } //End block
                        {
                            boolean var798B3C516162896973F8A912AADF2342_345245611 = (Arrays.equals(extnID, SUBJECT_ALT_NAME));
                            {
                                sb.append("Subject Alternative Name Extension");
                            } //End block
                            {
                                boolean varA7C4827A995FE964AABC87414038EBBE_430866318 = (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME));
                                {
                                    sb.append("Issuer Alternative Name Extension");
                                } //End block
                                {
                                    boolean varE21A4DBDF9C91AE82217AC44614585FE_1746490417 = (Arrays.equals(extnID, BASIC_CONSTRAINTS));
                                    {
                                        sb.append("Basic Constraints Extension");
                                    } //End block
                                    {
                                        boolean var7169DD5CE39017F9C9B4B9884B1B9568_2142952280 = (Arrays.equals(extnID, NAME_CONSTRAINTS));
                                        {
                                            sb.append("Name Constraints Extension");
                                        } //End block
                                        {
                                            boolean varECD4FFAE2DF9F6D6E5520D99835A6F31_208493226 = (Arrays.equals(extnID, CRL_DISTR_POINTS));
                                            {
                                                sb.append("CRL Distribution Points Extension");
                                            } //End block
                                            {
                                                boolean var13FF4F808684FD573126EE212EA51786_975160333 = (Arrays.equals(extnID, CERTIFICATE_POLICIES));
                                                {
                                                    sb.append("Certificate Policies Extension");
                                                } //End block
                                                {
                                                    boolean varAE8E329E1E0543065CC25EC5F26F8882_307966742 = (Arrays.equals(extnID, POLICY_MAPPINGS));
                                                    {
                                                        sb.append("Policy Mappings Extension");
                                                    } //End block
                                                    {
                                                        boolean var462955B2DF2534E3BC83A1D61ACA2B44_1383218861 = (Arrays.equals(extnID, AUTH_KEY_ID));
                                                        {
                                                            sb.append("Authority Key Identifier Extension");
                                                        } //End block
                                                        {
                                                            boolean varB2C78479445E120DEA730A255DC280D6_772543569 = (Arrays.equals(extnID, POLICY_CONSTRAINTS));
                                                            {
                                                                sb.append("Policy Constraints Extension");
                                                            } //End block
                                                            {
                                                                boolean var7E91A6CA310680B093FD88063F8ED148_965570687 = (Arrays.equals(extnID, EXTENDED_KEY_USAGE));
                                                                {
                                                                    sb.append("Extended Key Usage Extension");
                                                                } //End block
                                                                {
                                                                    boolean var2B9738A611418D1A003180D5A0034093_1092677851 = (Arrays.equals(extnID, INHIBIT_ANY_POLICY));
                                                                    {
                                                                        sb.append("Inhibit Any-Policy Extension");
                                                                    } //End block
                                                                    {
                                                                        boolean var2FDC903F1140F0C783B43300553D7073_2059026450 = (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS));
                                                                        {
                                                                            sb.append("Authority Information Access Extension");
                                                                        } //End block
                                                                        {
                                                                            boolean var1A9F19376AD1E1128CDFDE7F880CFF1A_139564678 = (Arrays.equals(extnID, SUBJECT_INFO_ACCESS));
                                                                            {
                                                                                sb.append("Subject Information Access Extension");
                                                                            } //End block
                                                                            {
                                                                                boolean var64EE348197FCEC58F6DF3BD83E5F3361_192551916 = (Arrays.equals(extnID, INVALIDITY_DATE));
                                                                                {
                                                                                    sb.append("Invalidity Date Extension");
                                                                                } //End block
                                                                                {
                                                                                    boolean varFEBBBF17861D8A2A8A1CDCEDBEADDB9A_551339342 = (Arrays.equals(extnID, CRL_NUMBER));
                                                                                    {
                                                                                        sb.append("CRL Number Extension");
                                                                                    } //End block
                                                                                    {
                                                                                        boolean var7A124ADB859F1043EEDF9FC8C3E2A3CB_141789162 = (Arrays.equals(extnID, REASON_CODE));
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

    
}


