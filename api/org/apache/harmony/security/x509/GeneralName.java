package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.071 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.071 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "FE36A33A4EC3AF4107DD5978C357772B")

    private Object name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.072 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.072 -0400", hash_original_field = "B044FB6FD80FBC2A60F506E8E61FE96C", hash_generated_field = "10022A525E7D3ACB3B0BC2E8BD5FE9A3")

    private byte[] name_encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.072 -0400", hash_original_method = "E8D4D2361F943CCDDF33AB5563ED886E", hash_generated_method = "9C717838B2281709CE5C0CBB5EF5A488")
    public  GeneralName(int tag, String name) throws IOException {
    if(name == null)        
        {
            IOException var9499341E0BC616F82C026F1F8830C343_900045919 = new IOException("name == null");
            var9499341E0BC616F82C026F1F8830C343_900045919.addTaint(taint);
            throw var9499341E0BC616F82C026F1F8830C343_900045919;
        } //End block
        this.tag = tag;
switch(tag){
        case OTHER_NAME :
        case X400_ADDR :
        case EDIP_NAME :
        IOException var54009A436658C2F6CB5077A8030F98FA_332657420 = new IOException("Unknown string representation for type [" + tag + "]");
        var54009A436658C2F6CB5077A8030F98FA_332657420.addTaint(taint);
        throw var54009A436658C2F6CB5077A8030F98FA_332657420;
        case DNS_NAME :
        checkDNS(name);
        this.name = name;
        break;
        case UR_ID :
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
        IOException var9500064D91EE0B18E4163E38C1CA4B9D_1466984286 = new IOException("Unknown type: [" + tag + "]");
        var9500064D91EE0B18E4163E38C1CA4B9D_1466984286.addTaint(taint);
        throw var9500064D91EE0B18E4163E38C1CA4B9D_1466984286;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.072 -0400", hash_original_method = "E499E58677EFB5DC6AB5C0B464CEB8CF", hash_generated_method = "A7E878DFEBBD99087D212C020B471EED")
    public  GeneralName(OtherName name) {
        this.tag = OTHER_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = OTHER_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.072 -0400", hash_original_method = "6111C4D1FF1E577BF7541C1C985772FA", hash_generated_method = "2274B23BB02D19178F6F1924487CB55F")
    public  GeneralName(ORAddress name) {
        this.tag = X400_ADDR;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = X400_ADDR;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.073 -0400", hash_original_method = "4A8D46C1231B71B1B6714BAB7338B8B6", hash_generated_method = "A414828AEF9526E2BF08611BC7117D8C")
    public  GeneralName(Name name) {
        this.tag = DIR_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = DIR_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.073 -0400", hash_original_method = "E96CC43FEA6BBB964F564DC514331182", hash_generated_method = "4265CE90B2DB501796206157F9B8D102")
    public  GeneralName(EDIPartyName name) {
        this.tag = EDIP_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = EDIP_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.073 -0400", hash_original_method = "F3BB557A640D5A23013E1A6A6D3E3A5F", hash_generated_method = "922FBCD70A17B3CFFFD0BB4A8C443E48")
    public  GeneralName(byte[] name) throws IllegalArgumentException {
        int length = name.length;
    if(length != 4 && length != 8 && length != 16 && length != 32)        
        {
            IllegalArgumentException var10C540728B922F61CA91D1CCD54071B4_1298622340 = new IllegalArgumentException("name.length invalid");
            var10C540728B922F61CA91D1CCD54071B4_1298622340.addTaint(taint);
            throw var10C540728B922F61CA91D1CCD54071B4_1298622340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.073 -0400", hash_original_method = "0D9E6D76CFD125A61E2F4A9B060ECF6F", hash_generated_method = "76816EC10B9A99D68FDF95F54E9161BF")
    public  GeneralName(int tag, byte[] name) throws IOException {
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_397419313 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_397419313.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_397419313;
        } //End block
    if((tag < 0) || (tag > 8))        
        {
            IOException var103ABEB597C79D1DC6C34F3B986CC20A_928683192 = new IOException("GeneralName: unknown tag: " + tag);
            var103ABEB597C79D1DC6C34F3B986CC20A_928683192.addTaint(taint);
            throw var103ABEB597C79D1DC6C34F3B986CC20A_928683192;
        } //End block
        this.tag = tag;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.074 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "8892C63C5B1B65343D6DC553876C5562")
    public int getTag() {
        int varE4D23E841D8E8804190027BCE3180FA5_1323410910 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902417792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902417792;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.074 -0400", hash_original_method = "20B60556BB46EC823C9319E49D0425A2", hash_generated_method = "D55A0377CC2295B559ED7C8861B6EB9A")
    public Object getName() {
Object varB017984728AC60AD1F0BF8734F33F15C_907179227 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_907179227.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_907179227;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.074 -0400", hash_original_method = "47F6A98481038A57781CC8365511AC09", hash_generated_method = "28017C870A652086E4AE980E2944D53D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof GeneralName))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1395383678 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755513374 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755513374;
        } //End block
        GeneralName gname = (GeneralName) other;
    if(this.tag != gname.tag)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1064476187 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671486581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671486581;
        } //End block
switch(tag){
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        boolean var64069A9BFB4BB340568F51433DFC2C06_319241793 = (((String) name).equalsIgnoreCase(
                        (String) gname.getName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522047576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522047576;
        case REG_ID:
        boolean var558A3BBBC4011EC9AD93BB2E6E25B105_159458049 = (Arrays.equals((int[]) name, (int[]) gname.name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556324978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556324978;
        case IP_ADDR:
        boolean var810545F5008BAE0DD3C4E2518B95BCFA_889858874 = (Arrays.equals((byte[]) name, (byte[]) gname.name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013573831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013573831;
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        boolean var0872D751EB4DED584B11A3B505721364_790261119 = (Arrays.equals(getEncoded(), gname.getEncoded()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606727927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606727927;
        default:
}        boolean var68934A3E9455FA72420237EB05902327_930716897 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416182736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416182736;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.074 -0400", hash_original_method = "A1EE40CF64275F91ADFBB9AA6974DBAD", hash_generated_method = "5D7FF459D226E6E4E391DB451BD0FD79")
    public int hashCode() {
switch(tag){
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        case REG_ID:
        case IP_ADDR:
        int var5715838B66EDF423F24A871806972EB3_2068843631 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282408927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282408927;
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        int var142158700CDD81CFFCCC860BDEDED16B_1819101063 = (Arrays.hashCode(getEncoded()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143003395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143003395;
        default:
        int var805ED14872F1C08E5C4314680FD405F0_1140638476 = (super.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120778314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120778314;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.075 -0400", hash_original_method = "3054283C8DAE746EB9FE98BB22A2F7C2", hash_generated_method = "78F1A61853749E0B7A75ECF02CE6A778")
    public boolean isAcceptable(GeneralName gname) {
        addTaint(gname.getTaint());
    if(this.tag != gname.getTag())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1420952052 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_22161815 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_22161815;
        } //End block
switch(this.tag){
        case RFC822_NAME:
        boolean varE4DB60F2C2AB68B7EAE66E464520BE15_2126536616 = (((String) gname.getName()).toLowerCase(Locale.US)
                    .endsWith(((String) name).toLowerCase(Locale.US)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818803122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818803122;
        case DNS_NAME:
        String dns = (String) name;
        String _dns = (String) gname.getName();
    if(dns.equalsIgnoreCase(_dns))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1532951694 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933481824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933481824;
        } //End block
        else
        {
            boolean var68DC9E03119C19CACF04D1711506F838_701958253 = (_dns.toLowerCase(Locale.US).endsWith("." + dns.toLowerCase(Locale.US)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804915939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804915939;
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
            boolean var67C9167F240BBF5C137E9CE1795161E3_228949417 = (_host.toLowerCase(Locale.US).endsWith(host.toLowerCase(Locale.US)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090375849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090375849;
        } //End block
        else
        {
            boolean var78E4AA002A3CCF4DF18C13ADA9D082E7_1641680636 = (host.equalsIgnoreCase(_host));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_337667753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_337667753;
        } //End block
        case IP_ADDR:
        byte[] address = (byte[]) name;
        byte[] _address = (byte[]) gname.getName();
        int length = address.length;
        int _length = _address.length;
    if(length == _length)        
        {
            boolean var6E430C72E819BD2996CDCDC7E5F07116_1265381015 = (Arrays.equals(address, _address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083131077 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083131077;
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
                    boolean var68934A3E9455FA72420237EB05902327_1012231670 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_384548761 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_384548761;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1342246159 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652090671 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652090671;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_310859518 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516324747 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516324747;
        } //End block
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        case REG_ID:
        boolean var0872D751EB4DED584B11A3B505721364_723036950 = (Arrays.equals(getEncoded(), gname.getEncoded()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027468154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027468154;
        default:
}        boolean varB326B5062B2F0E69046810717534CB09_739710612 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916740518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916740518;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.076 -0400", hash_original_method = "8BC63B983D4898BF725054A3D5D39730", hash_generated_method = "0543F4B5ABA48D7FF103DFB6B19A236A")
    public List<Object> getAsList() {
        ArrayList<Object> result = new ArrayList<Object>();
        result.add(tag);
switch(tag){
        case OTHER_NAME:
        result.add(((OtherName) name).getEncoded());
        break;
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        result.add(name);
        break;
        case REG_ID:
        result.add(ObjectIdentifier.toString((int[]) name));
        break;
        case X400_ADDR:
        result.add(((ORAddress) name).getEncoded());
        break;
        case DIR_NAME:
        result.add(((Name) name).getName(X500Principal.RFC2253));
        break;
        case EDIP_NAME:
        result.add(((EDIPartyName) name).getEncoded());
        break;
        case IP_ADDR:
        result.add(ipBytesToStr((byte[]) name));
        break;
        default:
}List<Object> varC03C174393C635249B793C3DB15AB950_1633570063 =         Collections.unmodifiableList(result);
        varC03C174393C635249B793C3DB15AB950_1633570063.addTaint(taint);
        return varC03C174393C635249B793C3DB15AB950_1633570063;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.076 -0400", hash_original_method = "4137EA74AADFAF54538362634CBBCA7A", hash_generated_method = "97DA93F1E95E132A0DD1C5A6EB48BC5A")
    public String toString() {
        String result = "";
switch(tag){
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
}String varDC838461EE2FA0CA4C9BBB70A15456B0_486548483 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_486548483.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_486548483;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.076 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "697EC910F9D4CAF8B2D56152E9B29EB8")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1713288793 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2086539205 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2086539205;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_method = "37C9CC72170749FE2E2B5C9DA460C3BB", hash_generated_method = "B96E010B503377F8DEA049AA1FE4B64A")
    public byte[] getEncodedName() {
    if(name_encoding == null)        
        {
            name_encoding = nameASN1[tag].encode(name);
        } //End block
        byte[] varB044FB6FD80FBC2A60F506E8E61FE96C_1364312259 = (name_encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1505679674 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1505679674;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "4E5D9AC1F0E8D9AB781F5EFFC24BAE80", hash_generated_field = "1A317709A171B2139EEB8BD8E4FFD633")

    public static final int OTHER_NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "C9732A793148C7EDFD4428D486FC76F2", hash_generated_field = "8605270A6DEED1E9241E2F779D804DB8")

    public static final int RFC822_NAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "4F0C3DDF227592FFCCC3399190B170BA", hash_generated_field = "4068333BBDE31CF8DBD7F63FABF82FFD")

    public static final int DNS_NAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "477AAE6DFC7C5FD37E7EA48DF1C7FCED", hash_generated_field = "541798205EE16CF843FD25263108C9BA")

    public static final int X400_ADDR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "4FB643167CAC0E1227E9EB434BE9D92D", hash_generated_field = "9C79E28158600675871FFC5333F55FE5")

    public static final int DIR_NAME = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "6B8EF3BCF61B405C9BFF6D307557D1CF", hash_generated_field = "F87CA0B39DDF9C21198439CE2BC901D0")

    public static final int EDIP_NAME = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "7C87B966D52898A3326F768DEA8B2305", hash_generated_field = "3BB142C23BDE62C58F9C0B5DCCEFC3C1")

    public static final int UR_ID = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "71FA57B7DB37AB272CE880E0BC58CB80", hash_generated_field = "10C69FE566268D6D08A5BB5FE501A789")

    public static final int IP_ADDR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.077 -0400", hash_original_field = "5836D0891E6962611C25E29481F6ACFB", hash_generated_field = "11541C1B6479C5A1E801E2333582AEC6")

    public static final int REG_ID = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.078 -0400", hash_original_field = "3FDE0A408DACF520036C6E6B288A77A6", hash_generated_field = "0E58F21A000AB906E098E31DBFAAE1B8")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.078 -0400", hash_original_field = "89586BE6D9C4DEF8449E660548BC67AB", hash_generated_field = "CB123AFB6852C7A5EB6A7311122CEEC7")

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

        public Object getObjectToEncode(Object value) {
            return ((GeneralName) value).name;
        }

        public int getIndex(java.lang.Object object) {
            return  ((GeneralName) object).tag;
        }

        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            GeneralName result;
            switch (in.choiceIndex) {
                case OTHER_NAME: 
                    result = new GeneralName((OtherName) in.content);
                    break;
                case RFC822_NAME: 
                case DNS_NAME: 
                    result = new GeneralName(in.choiceIndex, (String) in.content);
                    break;
                case X400_ADDR:
                    result = new GeneralName((ORAddress) in.content);
                    break;
                case DIR_NAME: 
                    result = new GeneralName((Name) in.content);
                    break;
                case EDIP_NAME: 
                    result = new GeneralName((EDIPartyName) in.content);
                    break;
                case UR_ID: 
                    String uri = (String) in.content;
                    if (uri.indexOf(":") == -1) {
                        throw new IOException("GeneralName: scheme is missing in URI: " + uri);
                    }
                    result = new GeneralName(in.choiceIndex, uri);
                    break;
                case IP_ADDR: 
                    result = new GeneralName((byte[]) in.content);
                    break;
                case REG_ID: 
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
    // orphaned legacy method
    public int getIndex(java.lang.Object object) {
            return  ((GeneralName) object).tag;
        }
    
    // orphaned legacy method
    public Object getObjectToEncode(Object value) {
            return ((GeneralName) value).name;
        }
    
}

