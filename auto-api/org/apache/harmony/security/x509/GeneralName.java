package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private int tag;
    private Object name;
    private byte[] encoding;
    private byte[] name_encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.773 -0400", hash_original_method = "E8D4D2361F943CCDDF33AB5563ED886E", hash_generated_method = "5779D51DDF62D4863E787CCDD47420B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralName(int tag, String name) throws IOException {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("name == null");
        } //End block
        //Begin case OTHER_NAME X400_ADDR EDIP_NAME 
        if (DroidSafeAndroidRuntime.control) throw new IOException("Unknown string representation for type [" + tag + "]");
        //End case OTHER_NAME X400_ADDR EDIP_NAME 
        //Begin case DNS_NAME 
        checkDNS(name);
        //End case DNS_NAME 
        //Begin case UR_ID 
        checkURI(name);
        //End case UR_ID 
        //Begin case REG_ID 
        this.name = oidStrToInts(name);
        //End case REG_ID 
        //Begin case DIR_NAME 
        this.name = new Name(name);
        //End case DIR_NAME 
        //Begin case IP_ADDR 
        this.name = ipStrToBytes(name);
        //End case IP_ADDR 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IOException("Unknown type: [" + tag + "]");
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.773 -0400", hash_original_method = "E499E58677EFB5DC6AB5C0B464CEB8CF", hash_generated_method = "7CACB66248A687C3A9686775B9E0C8CD")
    @DSModeled(DSC.SAFE)
    public GeneralName(OtherName name) {
        dsTaint.addTaint(name.dsTaint);
        this.tag = OTHER_NAME;
        // ---------- Original Method ----------
        //this.tag = OTHER_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.773 -0400", hash_original_method = "6111C4D1FF1E577BF7541C1C985772FA", hash_generated_method = "72F464B593378CF15BACDF99FD6DC1B6")
    @DSModeled(DSC.SAFE)
    public GeneralName(ORAddress name) {
        dsTaint.addTaint(name.dsTaint);
        this.tag = X400_ADDR;
        // ---------- Original Method ----------
        //this.tag = X400_ADDR;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.774 -0400", hash_original_method = "4A8D46C1231B71B1B6714BAB7338B8B6", hash_generated_method = "603225CD523DE5FB715233D69E7D789C")
    @DSModeled(DSC.SAFE)
    public GeneralName(Name name) {
        dsTaint.addTaint(name.dsTaint);
        this.tag = DIR_NAME;
        // ---------- Original Method ----------
        //this.tag = DIR_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.774 -0400", hash_original_method = "E96CC43FEA6BBB964F564DC514331182", hash_generated_method = "D8CE1DDA81CC0D7FEBD495D0E59724B1")
    @DSModeled(DSC.SAFE)
    public GeneralName(EDIPartyName name) {
        dsTaint.addTaint(name.dsTaint);
        this.tag = EDIP_NAME;
        // ---------- Original Method ----------
        //this.tag = EDIP_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.774 -0400", hash_original_method = "F3BB557A640D5A23013E1A6A6D3E3A5F", hash_generated_method = "DB7BC9817E48F8811B9DA625BE310C36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralName(byte[] name) throws IllegalArgumentException {
        dsTaint.addTaint(name[0]);
        int length;
        length = name.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name.length invalid");
        } //End block
        this.tag = IP_ADDR;
        this.name = new byte[name.length];
        System.arraycopy(name, 0, this.name, 0, name.length);
        // ---------- Original Method ----------
        //int length = name.length;
        //if (length != 4 && length != 8 && length != 16 && length != 32) {
            //throw new IllegalArgumentException("name.length invalid");
        //}
        //this.tag = IP_ADDR;
        //this.name = new byte[name.length];
        //System.arraycopy(name, 0, this.name, 0, name.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.774 -0400", hash_original_method = "0D9E6D76CFD125A61E2F4A9B060ECF6F", hash_generated_method = "5CB30A45D29EAA8FFDE90D8DC06911EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralName(int tag, byte[] name) throws IOException {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(name[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("GeneralName: unknown tag: " + tag);
        } //End block
        this.name_encoding = new byte[name.length];
        System.arraycopy(name, 0, this.name_encoding, 0, name.length);
        this.name = nameASN1[tag].decode(this.name_encoding);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if ((tag < 0) || (tag > 8)) {
            //throw new IOException("GeneralName: unknown tag: " + tag);
        //}
        //this.tag = tag;
        //this.name_encoding = new byte[name.length];
        //System.arraycopy(name, 0, this.name_encoding, 0, name.length);
        //this.name = nameASN1[tag].decode(this.name_encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.774 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "226427D6B46B1AE8D3C522BDEB8060A4")
    @DSModeled(DSC.SAFE)
    public int getTag() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.775 -0400", hash_original_method = "20B60556BB46EC823C9319E49D0425A2", hash_generated_method = "6863B6D8BB102FF04A3B69AA3EE09892")
    @DSModeled(DSC.SAFE)
    public Object getName() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.775 -0400", hash_original_method = "47F6A98481038A57781CC8365511AC09", hash_generated_method = "FA61A5A5BE05F4DC33C57752BEC521FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        GeneralName gname;
        gname = (GeneralName) other;
        //Begin case RFC822_NAME DNS_NAME UR_ID 
        boolean var194F9158761720EAB09623E0A647A17A_1518901356 = (((String) name).equalsIgnoreCase(
                        (String) gname.getName()));
        //End case RFC822_NAME DNS_NAME UR_ID 
        //Begin case REG_ID 
        boolean var5D87C1952D9E0CFEDEE04A72280F0FCB_709563617 = (Arrays.equals((int[]) name, (int[]) gname.name));
        //End case REG_ID 
        //Begin case IP_ADDR 
        boolean varB2D76B6F04C44BFEB89B4B19A9DB979A_1778466092 = (Arrays.equals((byte[]) name, (byte[]) gname.name));
        //End case IP_ADDR 
        //Begin case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME 
        boolean varB869665F568B838050B4A7A147786AE3_647990572 = (Arrays.equals(getEncoded(), gname.getEncoded()));
        //End case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.775 -0400", hash_original_method = "A1EE40CF64275F91ADFBB9AA6974DBAD", hash_generated_method = "DFDFFA9517B93D98C8070C0023D4EE09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        //Begin case RFC822_NAME DNS_NAME UR_ID REG_ID IP_ADDR 
        int var8EF65A1839C36EED6A25646011513717_335988418 = (name.hashCode());
        //End case RFC822_NAME DNS_NAME UR_ID REG_ID IP_ADDR 
        //Begin case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME 
        int varB4B145FD73615F1FD889E3E60CE45553_1199729919 = (Arrays.hashCode(getEncoded()));
        //End case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME 
        //Begin case default 
        int varC489EB7FF487A920847CC016ED55AE09_1412364422 = (super.hashCode());
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (tag) {
        //case RFC822_NAME:
        //case DNS_NAME:
        //case UR_ID:
        //case REG_ID:
        //case IP_ADDR:
            //return name.hashCode();
        //case DIR_NAME:
        //case X400_ADDR:
        //case OTHER_NAME:
        //case EDIP_NAME:
            //return Arrays.hashCode(getEncoded());
        //default:
            //return super.hashCode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.776 -0400", hash_original_method = "3054283C8DAE746EB9FE98BB22A2F7C2", hash_generated_method = "3E1DFA80D439E20F980D819465113CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAcceptable(GeneralName gname) {
        dsTaint.addTaint(gname.dsTaint);
        {
            boolean var428ABB11BAACC71DA3DCB0C819080230_914598298 = (this.tag != gname.getTag());
        } //End collapsed parenthetic
        //Begin case RFC822_NAME 
        boolean var01DD779FCB1229ED503C607614C4C16C_2069354832 = (((String) gname.getName()).toLowerCase(Locale.US)
                    .endsWith(((String) name).toLowerCase(Locale.US)));
        //End case RFC822_NAME 
        //Begin case DNS_NAME 
        String dns;
        dns = (String) name;
        //End case DNS_NAME 
        //Begin case DNS_NAME 
        String _dns;
        _dns = (String) gname.getName();
        //End case DNS_NAME 
        //Begin case DNS_NAME 
        {
            boolean varA59764FE2071F37C7AC521D227BA7BD7_156634468 = (dns.equalsIgnoreCase(_dns));
            {
                boolean var8B53CA92B86CF0C5D9D8ECCC7A7180EC_1959488620 = (_dns.toLowerCase(Locale.US).endsWith("." + dns.toLowerCase(Locale.US)));
            } //End block
        } //End collapsed parenthetic
        //End case DNS_NAME 
        //Begin case UR_ID 
        String uri;
        uri = (String) name;
        //End case UR_ID 
        //Begin case UR_ID 
        int begin;
        begin = uri.indexOf("://")+3;
        //End case UR_ID 
        //Begin case UR_ID 
        int end;
        end = uri.indexOf('/', begin);
        //End case UR_ID 
        //Begin case UR_ID 
        String host;
        host = uri.substring(begin);
        host = uri.substring(begin, end);
        //End case UR_ID 
        //Begin case UR_ID 
        uri = (String) gname.getName();
        //End case UR_ID 
        //Begin case UR_ID 
        begin = uri.indexOf("://")+3;
        //End case UR_ID 
        //Begin case UR_ID 
        end = uri.indexOf('/', begin);
        //End case UR_ID 
        //Begin case UR_ID 
        String _host;
        _host = uri.substring(begin);
        _host = uri.substring(begin, end);
        //End case UR_ID 
        //Begin case UR_ID 
        {
            boolean var0F2DB347CCE89100480373408932E856_1109155551 = (host.startsWith("."));
            {
                boolean var1DC9494B9FEB04BA346108B29537F28D_2054516539 = (_host.toLowerCase(Locale.US).endsWith(host.toLowerCase(Locale.US)));
            } //End block
            {
                boolean var99919774EE769A44AEAE98D1FE83F48F_365932477 = (host.equalsIgnoreCase(_host));
            } //End block
        } //End collapsed parenthetic
        //End case UR_ID 
        //Begin case IP_ADDR 
        byte[] address;
        address = (byte[]) name;
        //End case IP_ADDR 
        //Begin case IP_ADDR 
        byte[] _address;
        _address = (byte[]) gname.getName();
        //End case IP_ADDR 
        //Begin case IP_ADDR 
        int length;
        length = address.length;
        //End case IP_ADDR 
        //Begin case IP_ADDR 
        int _length;
        _length = _address.length;
        //End case IP_ADDR 
        //Begin case IP_ADDR 
        {
            boolean var8F234405025629C935D9C9D2E589F009_1674694911 = (Arrays.equals(address, _address));
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    int octet;
                    octet = _address[i] & 0xff;
                    int min;
                    min = address[i] & 0xff;
                    int max;
                    max = address[i + _length] & 0xff;
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case IP_ADDR 
        //Begin case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME REG_ID 
        boolean varB869665F568B838050B4A7A147786AE3_1943853590 = (Arrays.equals(getEncoded(), gname.getEncoded()));
        //End case DIR_NAME X400_ADDR OTHER_NAME EDIP_NAME REG_ID 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.776 -0400", hash_original_method = "8BC63B983D4898BF725054A3D5D39730", hash_generated_method = "2DADE2754B19619B1FD7CCD9026C1DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Object> getAsList() {
        ArrayList<Object> result;
        result = new ArrayList<Object>();
        result.add(tag);
        //Begin case OTHER_NAME 
        result.add(((OtherName) name).getEncoded());
        //End case OTHER_NAME 
        //Begin case RFC822_NAME DNS_NAME UR_ID 
        result.add(name);
        //End case RFC822_NAME DNS_NAME UR_ID 
        //Begin case REG_ID 
        result.add(ObjectIdentifier.toString((int[]) name));
        //End case REG_ID 
        //Begin case X400_ADDR 
        result.add(((ORAddress) name).getEncoded());
        //End case X400_ADDR 
        //Begin case DIR_NAME 
        result.add(((Name) name).getName(X500Principal.RFC2253));
        //End case DIR_NAME 
        //Begin case EDIP_NAME 
        result.add(((EDIPartyName) name).getEncoded());
        //End case EDIP_NAME 
        //Begin case IP_ADDR 
        result.add(ipBytesToStr((byte[]) name));
        //End case IP_ADDR 
        List<Object> varC3E54160A34923A26EB552108DFC5484_2041552020 = (Collections.unmodifiableList(result));
        return (List<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.777 -0400", hash_original_method = "4137EA74AADFAF54538362634CBBCA7A", hash_generated_method = "301A427FF436F9F5EDD2C11A8F39BA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String result;
        result = "";
        //Begin case OTHER_NAME 
        result = "otherName[0]: "
                         + Array.getBytesAsString(getEncoded());
        //End case OTHER_NAME 
        //Begin case RFC822_NAME 
        result = "rfc822Name[1]: " + name;
        //End case RFC822_NAME 
        //Begin case DNS_NAME 
        result = "dNSName[2]: " + name;
        //End case DNS_NAME 
        //Begin case UR_ID 
        result = "uniformResourceIdentifier[6]: " + name;
        //End case UR_ID 
        //Begin case REG_ID 
        result = "registeredID[8]: " + ObjectIdentifier.toString((int[]) name);
        //End case REG_ID 
        //Begin case X400_ADDR 
        result = "x400Address[3]: "
                         + Array.getBytesAsString(getEncoded());
        //End case X400_ADDR 
        //Begin case DIR_NAME 
        result = "directoryName[4]: "
                         + ((Name) name).getName(X500Principal.RFC2253);
        //End case DIR_NAME 
        //Begin case EDIP_NAME 
        result = "ediPartyName[5]: "
                         + Array.getBytesAsString(getEncoded());
        //End case EDIP_NAME 
        //Begin case IP_ADDR 
        result = "iPAddress[7]: " + ipBytesToStr((byte[]) name);
        //End case IP_ADDR 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.777 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.777 -0400", hash_original_method = "37C9CC72170749FE2E2B5C9DA460C3BB", hash_generated_method = "0CA7E777420858AC94C160285956A93A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncodedName() {
        {
            name_encoding = nameASN1[tag].encode(name);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (name_encoding == null) {
            //name_encoding = nameASN1[tag].encode(name);
        //}
        //return name_encoding;
    }

    
        public static void checkDNS(String dns) throws IOException {
        String string = dns.toLowerCase(Locale.US);
        int length = string.length();
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
                if (string.charAt(i-1) == '-') {
                    throw new IOException("Incorrect DNS name: label ends with '-': " + dns);
                }
                first_letter = true;
            }
        }
    }

    
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

    
        public static int[] oidStrToInts(String oid) throws IOException {
        int length = oid.length();
        if (oid.charAt(length-1) == '.') {
            throw new IOException("Bad OID: " + oid);
        }
        int[] result = new int[length/2+1];
        int number = 0;
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

    
        public static byte[] ipStrToBytes(String ip) throws IOException {
        if (!InetAddress.isNumeric(ip)) {
            throw new IOException("Not an IP address: " + ip);
        }
        return InetAddress.getByName(ip).getAddress();
    }

    
        public static String ipBytesToStr(byte[] ip) {
        try {
            return InetAddress.getByAddress(null, ip).getHostAddress();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Unexpected IP address: " + Arrays.toString(ip));
        }
    }

    
    public static final int OTHER_NAME = 0;
    public static final int RFC822_NAME = 1;
    public static final int DNS_NAME = 2;
    public static final int X400_ADDR = 3;
    public static final int DIR_NAME = 4;
    public static final int EDIP_NAME = 5;
    public static final int UR_ID = 6;
    public static final int IP_ADDR = 7;
    public static final int REG_ID = 8;
    private static ASN1Type[] nameASN1 = new ASN1Type[9];
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.778 -0400", hash_original_method = "AE1A845D7B5FC61789A7A47373288F1A", hash_generated_method = "31B6827DACFBD461729762283A06272F")
        @DSModeled(DSC.SAFE)
        public Object getObjectToEncode(Object value) {
            dsTaint.addTaint(value.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((GeneralName) value).name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.779 -0400", hash_original_method = "0776F1777C1F17109F2584BD2E2B974E", hash_generated_method = "537588D47DBB648AE639CE13EC6C2B9A")
        @DSModeled(DSC.SAFE)
        public int getIndex(java.lang.Object object) {
            dsTaint.addTaint(object.dsTaint);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return  ((GeneralName) object).tag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.779 -0400", hash_original_method = "F81949FDBF37D96CDDCB4E743948B628", hash_generated_method = "CBEB12FAF8F8C1930A0431A334B004B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            GeneralName result;
            //Begin case OTHER_NAME 
            result = new GeneralName((OtherName) in.content);
            //End case OTHER_NAME 
            //Begin case RFC822_NAME DNS_NAME 
            result = new GeneralName(in.choiceIndex, (String) in.content);
            //End case RFC822_NAME DNS_NAME 
            //Begin case X400_ADDR 
            result = new GeneralName((ORAddress) in.content);
            //End case X400_ADDR 
            //Begin case DIR_NAME 
            result = new GeneralName((Name) in.content);
            //End case DIR_NAME 
            //Begin case EDIP_NAME 
            result = new GeneralName((EDIPartyName) in.content);
            //End case EDIP_NAME 
            //Begin case UR_ID 
            String uri;
            uri = (String) in.content;
            //End case UR_ID 
            //Begin case UR_ID 
            {
                boolean var749128F744DAA9283DB037DAB1C21146_270555960 = (uri.indexOf(":") == -1);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("GeneralName: scheme is missing in URI: " + uri);
                } //End block
            } //End collapsed parenthetic
            //End case UR_ID 
            //Begin case UR_ID 
            result = new GeneralName(in.choiceIndex, uri);
            //End case UR_ID 
            //Begin case IP_ADDR 
            result = new GeneralName((byte[]) in.content);
            //End case IP_ADDR 
            //Begin case REG_ID 
            result = new GeneralName(in.choiceIndex,
                            ObjectIdentifier.toString((int[]) in.content));
            //End case REG_ID 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IOException("GeneralName: unknown tag: " + in.choiceIndex);
            //End case default 
            result.encoding = in.getEncoded();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
}

