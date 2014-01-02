package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x501.Name;






public final class GeneralName {

    /**
     * Checks the correctness of the string representation of DNS name.
     * The correctness is checked as specified in RFC 1034 p. 10, and modified
     * by RFC 1123 (section 2.1).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.701 -0500", hash_original_method = "E65DB6002059E528D4BC27B10F44D1B3", hash_generated_method = "04F30CD712B1F5D8C17B33B7D01643F1")
    
public static void checkDNS(String dns) throws IOException {
        String string = dns.toLowerCase(Locale.US);
        int length = string.length();
        // indicates if it is a first letter of the label
        boolean first_letter = true;
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (first_letter) {
                if ((length > 2) && (ch == '*') && (string.charAt(1) == '.')) {
                    first_letter = false;
                    continue;
                }
                if ((ch > 'z' || ch < 'a') && (ch < '0' || ch > '9')) {
                    throw new IOException("DNS name must start with a letter: " + dns);
                }
                first_letter = false;
                continue;
            }
            if (!((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')
                    || (ch == '-') || (ch == '.'))) {
                throw new IOException("Incorrect DNS name: " + dns);
            }
            if (ch == '.') {
                // check the end of the previous label, it should not
                // be '-' sign
                if (string.charAt(i-1) == '-') {
                    throw new IOException("Incorrect DNS name: label ends with '-': " + dns);
                }
                first_letter = true;
            }
        }
    }

    /**
     * Checks the correctness of the string representation of URI name.
     * The correctness is checked as pointed out in RFC 3280 p. 34.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.704 -0500", hash_original_method = "7B8E28B63F298B36AFEC228A9203A43A", hash_generated_method = "BA670570AB62185827AD01CD9C696E60")
    
public static void checkURI(String uri) throws IOException {
        try {
            URI ur = new URI(uri);
            if (ur.getScheme() == null || ur.getRawSchemeSpecificPart().isEmpty()) {
                throw new IOException("No scheme or scheme-specific-part in uniformResourceIdentifier: " + uri);
            }
            if (!ur.isAbsolute()) {
                throw new IOException("Relative uniformResourceIdentifier: " + uri);
            }
        } catch (URISyntaxException e) {
            throw (IOException) new IOException("Bad representation of uniformResourceIdentifier: " + uri).initCause(e);

        }
    }

    /**
     * Converts OID into array of ints.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.707 -0500", hash_original_method = "7071111779A5C9E705ECA7E7B982D4CC", hash_generated_method = "E5B0B7E68DE882FA88F406B138EA0556")
    
public static int[] oidStrToInts(String oid) throws IOException {
        int length = oid.length();
        if (oid.charAt(length-1) == '.') {
            throw new IOException("Bad OID: " + oid);
        }
        int[] result = new int[length/2+1]; // best case: a.b.c.d.e
        int number = 0; // the number of OID's components
        for (int i = 0; i < length; i++) {
            int value = 0;
            int pos = i;
            for (; i < length; i++) {
                char ch = oid.charAt(i);
                if ((ch < '0') || (ch > '9')) {
                    break;
                }
                value = 10 * value + (ch - '0');
            }
            if (i == pos) {
                // the number was not read
                throw new IOException("Bad OID: " + oid);
            }
            result[number++] = value;
            if (i == length) {
                break;
            }
            char ch = oid.charAt(i);
            if (ch != '.') {
                throw new IOException("Bad OID: " + oid);
            }
        }
        if (number < 2) {
            throw new IOException("OID should consist of no less than 2 components: " + oid);
        }
        return Arrays.copyOfRange(result, 0, number);
    }

    /**
     * Returns the bytes of the given IP address or masked IP address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.709 -0500", hash_original_method = "A41710B20845F3ACFCFCC726F9248A81", hash_generated_method = "84B622DEBBBB9D20E9EF8071DC92C693")
    
public static byte[] ipStrToBytes(String ip) throws IOException {
        if (!InetAddress.isNumeric(ip)) {
            throw new IOException("Not an IP address: " + ip);
        }
        return InetAddress.getByName(ip).getAddress();
    }

    /**
     * Returns the string form of the given IP address. Addresses of length 2x
     * the canonical length are treated as a route/mask pair.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.712 -0500", hash_original_method = "281DC0E6C574993A1EBB9069DA08A49C", hash_generated_method = "C3C0A8184EB5568A3FA06C5AF5D879D4")
    
public static String ipBytesToStr(byte[] ip) {
        try {
            return InetAddress.getByAddress(null, ip).getHostAddress();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Unexpected IP address: " + Arrays.toString(ip));
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.621 -0500", hash_original_field = "4087038C80C0397F59F2C081E36EC543", hash_generated_field = "1A317709A171B2139EEB8BD8E4FFD633")

    public static final int OTHER_NAME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.624 -0500", hash_original_field = "DC483980E2AA5ACEEDCBC6C0A4FBC40A", hash_generated_field = "8605270A6DEED1E9241E2F779D804DB8")

    public static final int RFC822_NAME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.626 -0500", hash_original_field = "820E11A90A22A96A50181CB0CA03BAB3", hash_generated_field = "4068333BBDE31CF8DBD7F63FABF82FFD")

    public static final int DNS_NAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.628 -0500", hash_original_field = "0F2066E5A2128F7D8DA1039E2FE13DF6", hash_generated_field = "541798205EE16CF843FD25263108C9BA")

    public static final int X400_ADDR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.631 -0500", hash_original_field = "2DF6D22FC6D5BD5C3BE41F8189234FE5", hash_generated_field = "9C79E28158600675871FFC5333F55FE5")

    public static final int DIR_NAME = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.634 -0500", hash_original_field = "59D2DBEC4524B7C892EB57C25571A0BF", hash_generated_field = "F87CA0B39DDF9C21198439CE2BC901D0")

    public static final int EDIP_NAME = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.636 -0500", hash_original_field = "A8F4673BF7208265F8FCA33169C5AFD8", hash_generated_field = "3BB142C23BDE62C58F9C0B5DCCEFC3C1")

    public static final int UR_ID = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.639 -0500", hash_original_field = "57C6E85AC07AF2B4E71F64FE2A4374F3", hash_generated_field = "10C69FE566268D6D08A5BB5FE501A789")

    public static final int IP_ADDR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.641 -0500", hash_original_field = "5F68175A65EB8E43DC3DFBE3BD7EFA3F", hash_generated_field = "11541C1B6479C5A1E801E2333582AEC6")

    public static final int REG_ID = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.644 -0500", hash_original_field = "72A4D67C31460662DBA039F6D174E82C", hash_generated_field = "0E58F21A000AB906E098E31DBFAAE1B8")

    private static ASN1Type[] nameASN1 = new ASN1Type[9];
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.336 -0400", hash_original_field = "89586BE6D9C4DEF8449E660548BC67AB", hash_generated_field = "CB123AFB6852C7A5EB6A7311122CEEC7")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
           new ASN1Implicit(0, OtherName.ASN1),
           new ASN1Implicit(1, ASN1StringType.IA5STRING),
           new ASN1Implicit(2, ASN1StringType.IA5STRING),
           new ASN1Implicit(3, ORAddress.ASN1),
           new ASN1Implicit(4, Name.ASN1),
           new ASN1Implicit(5, EDIPartyName.ASN1),
           new ASN1Implicit(6, ASN1StringType.IA5STRING),
           new ASN1Implicit(7, ASN1OctetString.getInstance()),
           new ASN1Implicit(8, ASN1Oid.getInstance()) }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.715 -0500", hash_original_method = "AE1A845D7B5FC61789A7A47373288F1A", hash_generated_method = "FF468AD20423F0EC93B386AEBEEB9073")
        
public Object getObjectToEncode(Object value) {
            return ((GeneralName) value).name;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.717 -0500", hash_original_method = "0776F1777C1F17109F2584BD2E2B974E", hash_generated_method = "27DD5ED5E5803DE7ECB53D6F51E268EA")
        
public int getIndex(java.lang.Object object) {
            return  ((GeneralName) object).tag;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.722 -0500", hash_original_method = "F81949FDBF37D96CDDCB4E743948B628", hash_generated_method = "001B33F88632E38C130B96A06B3206EC")
        
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
            GeneralName result;
            switch (in.choiceIndex) {
                case OTHER_NAME: // OtherName
                    result = new GeneralName((OtherName) in.content);
                    break;
                case RFC822_NAME: // rfc822Name
                case DNS_NAME: // dNSName
                    result = new GeneralName(in.choiceIndex, (String) in.content);
                    break;
                case X400_ADDR:
                    result = new GeneralName((ORAddress) in.content);
                    break;
                case DIR_NAME: // directoryName (X.500 Name)
                    result = new GeneralName((Name) in.content);
                    break;
                case EDIP_NAME: // ediPartyName
                    result = new GeneralName((EDIPartyName) in.content);
                    break;
                case UR_ID: // uniformResourceIdentifier
                    String uri = (String) in.content;
                    if (uri.indexOf(":") == -1) {
                        throw new IOException("GeneralName: scheme is missing in URI: " + uri);
                    }
                    result = new GeneralName(in.choiceIndex, uri);
                    break;
                case IP_ADDR: // iPAddress
                    result = new GeneralName((byte[]) in.content);
                    break;
                case REG_ID: // registeredID
                    result = new GeneralName(in.choiceIndex,
                            ObjectIdentifier.toString((int[]) in.content));
                    break;
                default:
                    throw new IOException("GeneralName: unknown tag: " + in.choiceIndex);
            }
            result.encoding = in.getEncoded();
            return result;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.647 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.649 -0500", hash_original_field = "A2CDC5FC8DE296FD8A07AFD42F0D68AE", hash_generated_field = "FE36A33A4EC3AF4107DD5978C357772B")

    private Object name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.651 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.654 -0500", hash_original_field = "09164367B2B48300B4DC30C93A544DAB", hash_generated_field = "10022A525E7D3ACB3B0BC2E8BD5FE9A3")

    private byte[] name_encoding;

    /**
     * Makes the GeneralName object from the tag type and corresponding
     * well established string representation of the name value.
     * The String representation of [7] iPAddress is such as:
     *  For IP v4, as specified in RFC 791, the address must
     *  contain exactly 4 byte component.  For IP v6, as specified in
     *  RFC 1883, the address must contain exactly 16 byte component.
     *  If GeneralName structure is used as a part of Name Constraints
     *  extension, to represent an address range the number of address
     *  component is doubled (to 8 and 32 bytes respectively).
     * Note that the names:
     * [0] otherName, [3] x400Address, [5] ediPartyName
     *   have no the string representation, so exception will be thrown.
     * To make the GeneralName object with such names use another constructor.
     * @param tag is an integer which value corresponds to the name type.
     * @param name is a name value corresponding to the tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.657 -0500", hash_original_method = "E8D4D2361F943CCDDF33AB5563ED886E", hash_generated_method = "FD88C26B5A25A0720C3106DBED592951")
    
public GeneralName(int tag, String name) throws IOException {
        if (name == null) {
            throw new IOException("name == null");
        }
        this.tag = tag;
        switch (tag) {
            case OTHER_NAME :
            case X400_ADDR :
            case EDIP_NAME :
                throw new IOException("Unknown string representation for type [" + tag + "]");
            case DNS_NAME :
                // according to RFC 3280 p.34 the DNS name should be
                // checked against the
                // RFC 1034 p.10 (3.5. Preferred name syntax):
                checkDNS(name);
                this.name = name;
                break;
            case UR_ID :
                // check the uniformResourceIdentifier for correctness
                // according to RFC 3280 p.34
                checkURI(name);
                this.name = name;
                break;
            case RFC822_NAME :
                this.name = name;
                break;
            case REG_ID:
                this.name = oidStrToInts(name);
                break;
            case DIR_NAME :
                this.name = new Name(name);
                break;
            case IP_ADDR :
                this.name = ipStrToBytes(name);
                break;
            default:
                throw new IOException("Unknown type: [" + tag + "]");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.659 -0500", hash_original_method = "E499E58677EFB5DC6AB5C0B464CEB8CF", hash_generated_method = "C364F51C6481C7746858C0E22B2A6DD4")
    
public GeneralName(OtherName name) {
        this.tag = OTHER_NAME;
        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.662 -0500", hash_original_method = "6111C4D1FF1E577BF7541C1C985772FA", hash_generated_method = "C61226225F630229E57680C04D7536CC")
    
public GeneralName(ORAddress name) {
        this.tag = X400_ADDR;
        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.665 -0500", hash_original_method = "4A8D46C1231B71B1B6714BAB7338B8B6", hash_generated_method = "4F97FC753C581D28A2F27C1FBF1CB15F")
    
public GeneralName(Name name) {
        this.tag = DIR_NAME;
        this.name = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.667 -0500", hash_original_method = "E96CC43FEA6BBB964F564DC514331182", hash_generated_method = "F57309646E71864156BFBCFFB3A8FF6B")
    
public GeneralName(EDIPartyName name) {
        this.tag = EDIP_NAME;
        this.name = name;
    }
    /**
     * Constructor for type [7] iPAddress.
     * name is an array of bytes such as:
     *  For IP v4, as specified in RFC 791, the address must
     *  contain exactly 4 byte component.  For IP v6, as specified in
     *  RFC 1883, the address must contain exactly 16 byte component.
     *  If GeneralName structure is used as a part of Name Constraints
     *  extension, to represent an address range the number of address
     *  component is doubled (to 8 and 32 bytes respectively).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.670 -0500", hash_original_method = "F3BB557A640D5A23013E1A6A6D3E3A5F", hash_generated_method = "8E6A331ED5B74A107F513175B4D1FB30")
    
public GeneralName(byte[] name) throws IllegalArgumentException {
        int length = name.length;
        if (length != 4 && length != 8 && length != 16 && length != 32) {
            throw new IllegalArgumentException("name.length invalid");
        }
        this.tag = IP_ADDR;
        this.name = new byte[name.length];
        System.arraycopy(name, 0, this.name, 0, name.length);
    }

    /**
     * Constructs an object representing the value of GeneralName.
     * @param tag is an integer which value corresponds
     * to the name type (0-8),
     * @param name is a DER encoded for of the name value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.673 -0500", hash_original_method = "0D9E6D76CFD125A61E2F4A9B060ECF6F", hash_generated_method = "0A2232B81CED8AC5B5403BB3517306E9")
    
public GeneralName(int tag, byte[] name) throws IOException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        if ((tag < 0) || (tag > 8)) {
            throw new IOException("GeneralName: unknown tag: " + tag);
        }
        this.tag = tag;
        this.name_encoding = new byte[name.length];
        System.arraycopy(name, 0, this.name_encoding, 0, name.length);
        this.name = nameASN1[tag].decode(this.name_encoding);
    }

    /**
     * Returns the tag of the name in the structure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.676 -0500", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "FE377F96B9123DA66C921247212B9DB8")
    
public int getTag() {
        return tag;
    }

    /**
     * @return the value of the name.
     * The class of name object depends on the tag as follows:
     * [0] otherName - OtherName object,
     * [1] rfc822Name - String object,
     * [2] dNSName - String object,
     * [3] x400Address - ORAddress object,
     * [4] directoryName - instance of Name object,
     * [5] ediPartyName - EDIPartyName object,
     * [6] uniformResourceIdentifier - String object,
     * [7] iPAddress - array of bytes such as:
     *  For IP v4, as specified in RFC 791, the address must
     *  contain exactly 4 byte component.  For IP v6, as specified in
     *  RFC 1883, the address must contain exactly 16 byte component.
     *  If GeneralName structure is used as a part of Name Constraints
     *  extension, to represent an address range the number of address
     *  component is doubled (to 8 and 32 bytes respectively).
     * [8] registeredID - String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.678 -0500", hash_original_method = "20B60556BB46EC823C9319E49D0425A2", hash_generated_method = "96182F595C314861F48236C53D12CC54")
    
public Object getName() {
        return name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.681 -0500", hash_original_method = "47F6A98481038A57781CC8365511AC09", hash_generated_method = "E8397C6185FF9D1B47659EA083F94AF5")
    
public boolean equals(Object other) {
        if (!(other instanceof GeneralName)) {
            return false;
        }
        GeneralName gname = (GeneralName) other;
        if (this.tag != gname.tag) {
            return false;
        }
        switch(tag) {
            case RFC822_NAME:
            case DNS_NAME:
            case UR_ID:
                return ((String) name).equalsIgnoreCase(
                        (String) gname.getName());
            case REG_ID:
                return Arrays.equals((int[]) name, (int[]) gname.name);
            case IP_ADDR:
                // iPAddress [7], check by using ranges.
                return Arrays.equals((byte[]) name, (byte[]) gname.name);
            case DIR_NAME:
            case X400_ADDR:
            case OTHER_NAME:
            case EDIP_NAME:
                return Arrays.equals(getEncoded(), gname.getEncoded());
            default:
                // should never happen
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.683 -0500", hash_original_method = "A1EE40CF64275F91ADFBB9AA6974DBAD", hash_generated_method = "CC85413B6B65D9EDB49B1F99A8DCDCD0")
    
public int hashCode() {
        switch (tag) {
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        case REG_ID:
        case IP_ADDR:
            return name.hashCode();
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
            return Arrays.hashCode(getEncoded());
        default:
            return super.hashCode();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.330 -0400", hash_original_method = "3054283C8DAE746EB9FE98BB22A2F7C2", hash_generated_method = "852FE137F6F8AECE97D724D129D4876D")
    public boolean isAcceptable(GeneralName gname) {
        addTaint(gname.getTaint());
        if(this.tag != gname.getTag())        
        {
            boolean var68934A3E9455FA72420237EB05902327_930814923 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481947341 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_481947341;
        } //End block
switch(this.tag){
        case RFC822_NAME:
        boolean varE4DB60F2C2AB68B7EAE66E464520BE15_1800691677 = (((String) gname.getName()).toLowerCase(Locale.US)
                    .endsWith(((String) name).toLowerCase(Locale.US)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212622051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212622051;
        case DNS_NAME:
        String dns = (String) name;
        String _dns = (String) gname.getName();
        if(dns.equalsIgnoreCase(_dns))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_523940697 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517397045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517397045;
        } //End block
        else
        {
            boolean var68DC9E03119C19CACF04D1711506F838_1622032480 = (_dns.toLowerCase(Locale.US).endsWith("." + dns.toLowerCase(Locale.US)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884791218 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884791218;
        } //End block
        case UR_ID:
        String uri = (String) name;
        int begin = uri.indexOf("://")+3;
        int end = uri.indexOf('/', begin);
        String host = (end == -1)
                                ? uri.substring(begin)
                                : uri.substring(begin, end);
        uri = (String) gname.getName();
        begin = uri.indexOf("://")+3;
        end = uri.indexOf('/', begin);
        String _host = (end == -1)
                                ? uri.substring(begin)
                                : uri.substring(begin, end);
        if(host.startsWith("."))        
        {
            boolean var67C9167F240BBF5C137E9CE1795161E3_59891699 = (_host.toLowerCase(Locale.US).endsWith(host.toLowerCase(Locale.US)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334795292 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_334795292;
        } //End block
        else
        {
            boolean var78E4AA002A3CCF4DF18C13ADA9D082E7_1836051240 = (host.equalsIgnoreCase(_host));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614952240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614952240;
        } //End block
        case IP_ADDR:
        byte[] address = (byte[]) name;
        byte[] _address = (byte[]) gname.getName();
        int length = address.length;
        int _length = _address.length;
        if(length == _length)        
        {
            boolean var6E430C72E819BD2996CDCDC7E5F07116_796189700 = (Arrays.equals(address, _address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210161838 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210161838;
        } //End block
        else
        if(length == 2*_length)        
        {
for(int i = 0;i < _address.length;i++)
            {
                int octet = _address[i] & 0xff;
                int min = address[i] & 0xff;
                int max = address[i + _length] & 0xff;
                if((octet < min) || (octet > max))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_2054453999 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009830578 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009830578;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1752534465 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301060631 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_301060631;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1545042294 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410143046 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_410143046;
        } //End block
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        case REG_ID:
        boolean var0872D751EB4DED584B11A3B505721364_421271437 = (Arrays.equals(getEncoded(), gname.getEncoded()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689315043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689315043;
        default:
}        boolean varB326B5062B2F0E69046810717534CB09_753462736 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171864252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171864252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Gets a list representation of this GeneralName object.
     * The first entry of the list is an Integer object representing
     * the type of mane (0-8), and the second entry is a value of the name:
     * string or ASN.1 DER encoded form depending on the type as follows:
     * rfc822Name, dNSName, uniformResourceIdentifier names are returned
     * as Strings, using the string formats for those types (rfc 3280)
     * IP v4 address names are returned using dotted quad notation.
     * IP v6 address names are returned in the form "p1:p2:...:p8",
     * where p1-p8 are hexadecimal values representing the eight 16-bit
     * pieces of the address. registeredID name are returned as Strings
     * represented as a series of nonnegative integers separated by periods.
     * And directory names (distinguished names) are returned in
     * RFC 2253 string format.
     * otherName, X400Address, ediPartyName returned as byte arrays
     * containing the ASN.1 DER encoded form of the name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.690 -0500", hash_original_method = "8BC63B983D4898BF725054A3D5D39730", hash_generated_method = "2446E4509090C5B540928BC651648147")
    
public List<Object> getAsList() {
        ArrayList<Object> result = new ArrayList<Object>();
        result.add(tag);
        switch (tag) {
            case OTHER_NAME:
                result.add(((OtherName) name).getEncoded());
                break;
            case RFC822_NAME:
            case DNS_NAME:
            case UR_ID:
                result.add(name); // String
                break;
            case REG_ID:
                result.add(ObjectIdentifier.toString((int[]) name));
                break;
            case X400_ADDR:
                result.add(((ORAddress) name).getEncoded());
                break;
            case DIR_NAME: // directoryName is returned as a String
                result.add(((Name) name).getName(X500Principal.RFC2253));
                break;
            case EDIP_NAME:
                result.add(((EDIPartyName) name).getEncoded());
                break;
            case IP_ADDR: //iPAddress is returned as a String, not as a byte array
                result.add(ipBytesToStr((byte[]) name));
                break;
            default:
                // should never happen
        }
        return Collections.unmodifiableList(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.693 -0500", hash_original_method = "4137EA74AADFAF54538362634CBBCA7A", hash_generated_method = "AEF6DF182D5802F70C54F9B1BE89897F")
    
public String toString() {
        String result = "";
        switch (tag) {
            case OTHER_NAME:
                result = "otherName[0]: "
                         + Array.getBytesAsString(getEncoded());
                break;
            case RFC822_NAME:
                result = "rfc822Name[1]: " + name;
                break;
            case DNS_NAME:
                result = "dNSName[2]: " + name;
                break;
            case UR_ID:
                result = "uniformResourceIdentifier[6]: " + name;
                break;
            case REG_ID:
                result = "registeredID[8]: " + ObjectIdentifier.toString((int[]) name);
                break;
            case X400_ADDR:
                result = "x400Address[3]: "
                         + Array.getBytesAsString(getEncoded());
                break;
            case DIR_NAME:
                result = "directoryName[4]: "
                         + ((Name) name).getName(X500Principal.RFC2253);
                break;
            case EDIP_NAME:
                result = "ediPartyName[5]: "
                         + Array.getBytesAsString(getEncoded());
                break;
            case IP_ADDR:
                result = "iPAddress[7]: " + ipBytesToStr((byte[]) name);
                break;
            default:
                // should never happen
        }
        return result;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 GeneralName value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.696 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
    static {
        nameASN1[OTHER_NAME] = OtherName.ASN1;
        nameASN1[RFC822_NAME] = ASN1StringType.IA5STRING;
        nameASN1[DNS_NAME] = ASN1StringType.IA5STRING;
        nameASN1[UR_ID] = ASN1StringType.IA5STRING;
        nameASN1[X400_ADDR] = ORAddress.ASN1;
        nameASN1[DIR_NAME] = Name.ASN1;
        nameASN1[EDIP_NAME] = EDIPartyName.ASN1;
        nameASN1[IP_ADDR] = ASN1OctetString.getInstance();
        nameASN1[REG_ID] = ASN1Oid.getInstance();
    }

    /**
     * @return the encoded value of the name without the tag associated
     *         with the name in the GeneralName structure
     * @throws  IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:59.698 -0500", hash_original_method = "37C9CC72170749FE2E2B5C9DA460C3BB", hash_generated_method = "3B82B692C63AE5D0F4CBB7ECCA75E3CB")
    
public byte[] getEncodedName() {
        if (name_encoding == null) {
            name_encoding = nameASN1[tag].encode(name);
        }
        return name_encoding;
    }
    // orphaned legacy method
    public int getIndex(java.lang.Object object) {
            return  ((GeneralName) object).tag;
        }
    
    // orphaned legacy method
    public Object getObjectToEncode(Object value) {
            return ((GeneralName) value).name;
        }
    
}

