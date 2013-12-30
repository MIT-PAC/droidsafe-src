package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.658 -0500", hash_original_field = "FF027F407105D541B6A80387FB1B5606", hash_generated_field = "6E31BBAF500C1070EE1FFA080111393F")

    public static final boolean CRITICAL = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.660 -0500", hash_original_field = "175C2EEBB222CBE4F751D43734748E66", hash_generated_field = "57D4ADD3A20722C1472A183BBA626F17")

    public static final boolean NON_CRITICAL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.662 -0500", hash_original_field = "DC2C87B55832E8255616B5417ED4D630", hash_generated_field = "A53E217C605EB1F82188015C905EA451")

    // certificate extensions:
    static final int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.665 -0500", hash_original_field = "DAE3AAF5E95AFAFC86F777E7A5E0391A", hash_generated_field = "12E2A1B5F5C6E6E68AA435B29065A00B")

    static final int[] SUBJ_KEY_ID = {2, 5, 29, 14};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.667 -0500", hash_original_field = "F474E68FB70B76470B9CA825E7E67FB9", hash_generated_field = "0C70346483130DABA174062DEFA137A2")

    static final int[] KEY_USAGE = {2, 5, 29, 15};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.669 -0500", hash_original_field = "D36C2486B8BBC379DA87FA41DFC6E558", hash_generated_field = "99B612A5CA31C7372E91E87AF4BCA7CF")

    static final int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.672 -0500", hash_original_field = "C15E81A8278BE299E557A198F095B1FE", hash_generated_field = "EDAD333FCA26480E2985EA9905FC2E62")

    static final int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.674 -0500", hash_original_field = "790E94E36C9DBD7FEE3ADA28E963F87C", hash_generated_field = "E25E2376B509F67CE04E08FE645EDF3A")

    static final int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.676 -0500", hash_original_field = "01F9C0C451D0F81BD6E12027C9E68AA1", hash_generated_field = "4719361E8A47B688AD0277E34E1EC427")

    static final int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.679 -0500", hash_original_field = "854FA3F3E9129BFB290DE8BF6F37B0B4", hash_generated_field = "49AD57F33D760933ED9349263C6F8EAE")

    static final int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.682 -0500", hash_original_field = "33AD2DA6B1BA3E0F04167A9DFF35656A", hash_generated_field = "7A61315B9986A127CC6F2344E095C632")

    static final int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.684 -0500", hash_original_field = "DE2F927C4839173756A96C6CA4204D7E", hash_generated_field = "1691E914E66862570393C6E34196E15C")

    static final int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.687 -0500", hash_original_field = "DD83958D21023D8E56207062E3E0D925", hash_generated_field = "CE95833AAC25AE706C941911E24707F9")

    static final int[] POLICY_MAPPINGS = {2, 5, 29, 33};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.689 -0500", hash_original_field = "6E2091A04A4819FB1F6B64651CD8F703", hash_generated_field = "A324E7513D96D23F13F91F8DFF91B594")

    static final int[] AUTH_KEY_ID = {2, 5, 29, 35};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.691 -0500", hash_original_field = "2042993874E5D5811269D9B19034BED5", hash_generated_field = "95538B9ED262D7F125023AC83213D22E")

    static final int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.694 -0500", hash_original_field = "5257509B16EEA70B63F18C39343F22D1", hash_generated_field = "4359CA80FF8A9D383063F767F62461EA")

    static final int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.696 -0500", hash_original_field = "6A4F786ED581D12CA868B3A1EBD409D2", hash_generated_field = "47087EB391C3782D2732916FA0F9A8F6")

    static final int[] FRESHEST_CRL = {2, 5, 29, 46};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.699 -0500", hash_original_field = "8C1FF9B5EC45DFE733371C090236856B", hash_generated_field = "904578E7AECC101C2C04F1A04DC732B5")

    static final int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.701 -0500", hash_original_field = "D08E735824B3FAE76F3983E148D8DC61", hash_generated_field = "494BD3D519DBA72AF6B11312F94F2233")

    static final int[] AUTHORITY_INFO_ACCESS =
                                            {1, 3, 6, 1, 5, 5, 7, 1, 1};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.703 -0500", hash_original_field = "00ABFF77B48446C27B82B5CB9F93F579", hash_generated_field = "C976F23CD3B6D6B36515F6F863C6502E")

    static final int[] SUBJECT_INFO_ACCESS =
                                            {1, 3, 6, 1, 5, 5, 7, 1, 11};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.706 -0500", hash_original_field = "0AF8266294AD9FCA7C4257DA8BEDC560", hash_generated_field = "9CED2F6CB0726D71EE80F824234AF7BD")

    static final int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.708 -0500", hash_original_field = "9513392B2392C6C63A91396A903512AF", hash_generated_field = "966A118EDFE475F73BA36FEA1B1F975C")

    static final int[] CRL_NUMBER = {2, 5, 29, 20};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.710 -0500", hash_original_field = "845503173720AB7D6FD8A1C38778F0F3", hash_generated_field = "5CDEAF5DBC9CB04A80D24DF838BF2CE2")

    static final int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.712 -0500", hash_original_field = "7FC054B64039E48CC51B8D4ECE34B9D1", hash_generated_field = "5886D35FDD6D210067E6B9B1BF6BD0F1")

    static final int[] INVALIDITY_DATE = {2, 5, 29, 24};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.715 -0500", hash_original_field = "1C440D409FE55E01095B72A53103263F", hash_generated_field = "82525C0AB7C1B69E481DF8A6ADCBB83A")

    static final int[] REASON_CODE = {2, 5, 29, 21};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.717 -0500", hash_original_field = "358540E88AC63F09B5FECEFD9AEBFCFD", hash_generated_field = "96991C023252842FAC916A47EE9FD09B")

    static final int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.169 -0400", hash_original_field = "162B518F6D507BF8606DF33C2285800B", hash_generated_field = "3978C13F4770C29C9F00A89FB623B39E")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            ASN1Boolean.getInstance(),
            new ASN1OctetString() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.787 -0500", hash_original_method = "57CDE7978577D3AB7059BB86E5307D16", hash_generated_method = "2C86EEB690B486048737FB3CB2C3E901")
        
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
                    // first - decoded octet string,
                    // second - raw encoding of octet string
                    return new Object[]
                        {super.getDecodedObject(in), in.getEncoded()};
                }
            }
        }) {
        {
            setDefault(Boolean.FALSE, 1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.791 -0500", hash_original_method = "76E4451FF0478DD5E12D05D308694266", hash_generated_method = "B3CCB6A9D32760E1688D393F38CABA3A")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;

            int[] oid = (int[]) values[0];
            byte[] extnValue = (byte[]) ((Object[]) values[2])[0];
            byte[] rawExtnValue = (byte[]) ((Object[]) values[2])[1];

            ExtensionValue decodedExtValue = null;
            // decode Key Usage and Basic Constraints extension values
            if (Arrays.equals(oid, KEY_USAGE)) {
                decodedExtValue = new KeyUsage(extnValue);
            } else if (Arrays.equals(oid, BASIC_CONSTRAINTS)) {
                decodedExtValue = new BasicConstraints(extnValue);
            }

            return new Extension((int[]) values[0], (Boolean) values[1],
                    extnValue, rawExtnValue, in.getEncoded(), decodedExtValue);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.794 -0500", hash_original_method = "C2EBD010FE004A7CF9B3B50ACF2F1130", hash_generated_method = "DBC9ED483412E9DE3CE85B86BAF384A5")
        
@Override protected void getValues(Object object, Object[] values) {
            Extension ext = (Extension) object;
            values[0] = ext.extnID;
            values[1] = (ext.critical) ? Boolean.TRUE : Boolean.FALSE;
            values[2] = ext.extnValue;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.720 -0500", hash_original_field = "0736AC86F6F03F6F85CCB2AC51909C40", hash_generated_field = "8FF788D802F19156A5C417E4A45E7E12")

    private  int[] extnID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.722 -0500", hash_original_field = "878A929E540A9CE66CD42747336BE8FD", hash_generated_field = "1083E6F765C894CB0636109B4BF9EBDC")

    private String extnID_str;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.724 -0500", hash_original_field = "1F76041313F1C10961473CD0339FD9F7", hash_generated_field = "A48F124796E85FB5FCAB8EC4B6BBE7D0")

    private  boolean critical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.727 -0500", hash_original_field = "075908D93D8CA93294257B557C6F4358", hash_generated_field = "20FC9E7634FE8CC649C67A24E78428BB")

    private  byte[] extnValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.729 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.732 -0500", hash_original_field = "BC12F0AE20F45790799214B4E06DBDEE", hash_generated_field = "E823D869E9BDEB05E84E11DD9C5D645B")

    private byte[] rawExtnValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.734 -0500", hash_original_field = "FF7F2EE1817516F9CA0C379229211577", hash_generated_field = "438348B11B927145AC75EBC3AE4EBA57")

    protected ExtensionValue extnValueObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.736 -0500", hash_original_field = "71B2C7E7D3BF98A9BD6CD9C08E690876", hash_generated_field = "49181044EA66271CEFB24754874F9828")

    private boolean valueDecoded = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.739 -0500", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "F4F42043836B7126B91AE64276E8C74B")
    
public Extension(String extnID, boolean critical,
            ExtensionValue extnValueObject) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValueObject = extnValueObject;
        this.valueDecoded = true;
        this.extnValue = extnValueObject.getEncoded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.741 -0500", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "A833D2459C06013F0F6A6F110CC34987")
    
public Extension(String extnID, boolean critical, byte[] extnValue) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValue = extnValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.744 -0500", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "3E0BD958EA9A7314A723227A123832F1")
    
public Extension(int[] extnID, boolean critical, byte[] extnValue) {
        this.extnID = extnID;
        this.critical = critical;
        this.extnValue = extnValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.747 -0500", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "BD7D6647D293C1820932FD5CBAB3F834")
    
public Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.749 -0500", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "286A76AA9BAA7F30CBE2023551ECDC88")
    
public Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.752 -0500", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "7807FF8F89099B2C9043BE9C105834E4")
    
private Extension(int[] extnID, boolean critical, byte[] extnValue,
            byte[] rawExtnValue, byte[] encoding,
            ExtensionValue decodedExtValue) {
        this(extnID, critical, extnValue);
        this.rawExtnValue = rawExtnValue;
        this.encoding = encoding;
        this.extnValueObject = decodedExtValue;
        this.valueDecoded = (decodedExtValue != null);
    }

    /**
     * Returns the value of extnID field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.754 -0500", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "879A197B07BE53D02BAF788515AAAC62")
    
public String getExtnID() {
        if (extnID_str == null) {
            extnID_str = ObjectIdentifier.toString(extnID);
        }
        return extnID_str;
    }

    /**
     * Returns the value of critical field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.756 -0500", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "3BB7B547EE2D857299CCD1B3DA45A26D")
    
public boolean getCritical() {
        return critical;
    }

    /**
     * Returns the value of extnValue field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.759 -0500", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "F24142DF133F3BE1BC9CF1237512A28B")
    
public byte[] getExtnValue() {
        return extnValue;
    }

    /**
     * Returns the raw (undecoded octet string) value of extnValue
     * field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.761 -0500", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "FB39DDF990F499AE3B49C1A964AFAFF9")
    
public byte[] getRawExtnValue() {
        if (rawExtnValue == null) {
            rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        }
        return rawExtnValue;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 Extension value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.764 -0500", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "B744F9E58D4CCB3856A5C56E8EA60B00")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = Extension.ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.766 -0500", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "F2B9678F2D1AEFF914C8128D344B6306")
    
@Override public boolean equals(Object ext) {
        if (!(ext instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) ext;
        return Arrays.equals(extnID, extension.extnID)
            && (critical == extension.critical)
            && Arrays.equals(extnValue, extension.extnValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.769 -0500", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "F8233D0AE3818FF4813FA16EEE3A50C7")
    
@Override public int hashCode() {
        return (Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.771 -0500", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "DEB6A9F36C83D65D7093C1FEB022FDB7")
    
public ExtensionValue getDecodedExtensionValue() throws IOException {
        if (!valueDecoded) {
            decodeExtensionValue();
        }
        return extnValueObject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.773 -0500", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "540B1C8059C95F428EDBBFD08E17B945")
    
public KeyUsage getKeyUsageValue() {
        if (!valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException ignored) {
            }
        }
        if (extnValueObject instanceof KeyUsage) {
            return (KeyUsage) extnValueObject;
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.776 -0500", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "05A909585D96DF12EB997558B334ACAC")
    
public BasicConstraints getBasicConstraintsValue() {
        if (!valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException ignored) {
            }
        }
        if (extnValueObject instanceof BasicConstraints) {
            return (BasicConstraints) extnValueObject;
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.780 -0500", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "627FF5557BF01E145C59E4EC4548E4B5")
    
private void decodeExtensionValue() throws IOException {
        if (valueDecoded) {
            return;
        }
        valueDecoded = true;
        if (Arrays.equals(extnID, SUBJ_KEY_ID)) {
            extnValueObject = SubjectKeyIdentifier.decode(extnValue);
        } else if (Arrays.equals(extnID, KEY_USAGE)) {
            extnValueObject = new KeyUsage(extnValue);
        } else if (Arrays.equals(extnID, SUBJECT_ALT_NAME)) {
            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
        } else if (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME)) {
            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
        } else if (Arrays.equals(extnID, BASIC_CONSTRAINTS)) {
            extnValueObject = new BasicConstraints(extnValue);
        } else if (Arrays.equals(extnID, NAME_CONSTRAINTS)) {
            extnValueObject = NameConstraints.decode(extnValue);
        } else if (Arrays.equals(extnID, CERTIFICATE_POLICIES)) {
            extnValueObject = CertificatePolicies.decode(extnValue);
        } else if (Arrays.equals(extnID, AUTH_KEY_ID)) {
            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
        } else if (Arrays.equals(extnID, POLICY_CONSTRAINTS)) {
            extnValueObject = new PolicyConstraints(extnValue);
        } else if (Arrays.equals(extnID, EXTENDED_KEY_USAGE)) {
            extnValueObject = new ExtendedKeyUsage(extnValue);
        } else if (Arrays.equals(extnID, INHIBIT_ANY_POLICY)) {
            extnValueObject = new InhibitAnyPolicy(extnValue);
        } else if (Arrays.equals(extnID, CERTIFICATE_ISSUER)) {
            extnValueObject = new CertificateIssuer(extnValue);
        } else if (Arrays.equals(extnID, CRL_DISTR_POINTS)) {
            extnValueObject = CRLDistributionPoints.decode(extnValue);
        } else if (Arrays.equals(extnID, CERTIFICATE_ISSUER)) {
            extnValueObject = new ReasonCode(extnValue);
        } else if (Arrays.equals(extnID, INVALIDITY_DATE)) {
            extnValueObject = new InvalidityDate(extnValue);
        } else if (Arrays.equals(extnID, REASON_CODE)) {
            extnValueObject = new ReasonCode(extnValue);
        } else if (Arrays.equals(extnID, CRL_NUMBER)) {
            extnValueObject = new CRLNumber(extnValue);
        } else if (Arrays.equals(extnID, ISSUING_DISTR_POINTS)) {
            extnValueObject = IssuingDistributionPoint.decode(extnValue);
        } else if (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS)) {
            extnValueObject = InfoAccessSyntax.decode(extnValue);
        } else if (Arrays.equals(extnID, SUBJECT_INFO_ACCESS)) {
            extnValueObject = InfoAccessSyntax.decode(extnValue);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:01.783 -0500", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "2E4585C7E761E0A433EABDAF778748AB")
    
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append("OID: ").append(getExtnID()).append(", Critical: ").append(critical).append('\n');
        if (!valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException ignored) {
            }
        }
        if (extnValueObject != null) {
            extnValueObject.dumpValue(sb, prefix);
            return;
        }
        // else: dump unparsed hex representation
        sb.append(prefix);
        if (Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS)) {
            sb.append("Subject Directory Attributes Extension");
        } else if (Arrays.equals(extnID, SUBJ_KEY_ID)) {
            sb.append("Subject Key Identifier Extension");
        } else if (Arrays.equals(extnID, KEY_USAGE)) {
            sb.append("Key Usage Extension");
        } else if (Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD)) {
            sb.append("Private Key Usage Period Extension");
        } else if (Arrays.equals(extnID, SUBJECT_ALT_NAME)) {
            sb.append("Subject Alternative Name Extension");
        } else if (Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME)) {
            sb.append("Issuer Alternative Name Extension");
        } else if (Arrays.equals(extnID, BASIC_CONSTRAINTS)) {
            sb.append("Basic Constraints Extension");
        } else if (Arrays.equals(extnID, NAME_CONSTRAINTS)) {
            sb.append("Name Constraints Extension");
        } else if (Arrays.equals(extnID, CRL_DISTR_POINTS)) {
            sb.append("CRL Distribution Points Extension");
        } else if (Arrays.equals(extnID, CERTIFICATE_POLICIES)) {
            sb.append("Certificate Policies Extension");
        } else if (Arrays.equals(extnID, POLICY_MAPPINGS)) {
            sb.append("Policy Mappings Extension");
        } else if (Arrays.equals(extnID, AUTH_KEY_ID)) {
            sb.append("Authority Key Identifier Extension");
        } else if (Arrays.equals(extnID, POLICY_CONSTRAINTS)) {
            sb.append("Policy Constraints Extension");
        } else if (Arrays.equals(extnID, EXTENDED_KEY_USAGE)) {
            sb.append("Extended Key Usage Extension");
        } else if (Arrays.equals(extnID, INHIBIT_ANY_POLICY)) {
            sb.append("Inhibit Any-Policy Extension");
        } else if (Arrays.equals(extnID, AUTHORITY_INFO_ACCESS)) {
            sb.append("Authority Information Access Extension");
        } else if (Arrays.equals(extnID, SUBJECT_INFO_ACCESS)) {
            sb.append("Subject Information Access Extension");
        } else if (Arrays.equals(extnID, INVALIDITY_DATE)) {
            sb.append("Invalidity Date Extension");
        } else if (Arrays.equals(extnID, CRL_NUMBER)) {
            sb.append("CRL Number Extension");
        } else if (Arrays.equals(extnID, REASON_CODE)) {
            sb.append("Reason Code Extension");
        } else {
            sb.append("Unknown Extension");
        }
        sb.append('\n').append(prefix).append("Unparsed Extension Value:\n");
        sb.append(Array.toString(extnValue, prefix));
    }
}

