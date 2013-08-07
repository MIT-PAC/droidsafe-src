package org.apache.harmony.security.x509;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.322 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.322 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "FE36A33A4EC3AF4107DD5978C357772B")

    private Object name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.322 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.322 -0400", hash_original_field = "B044FB6FD80FBC2A60F506E8E61FE96C", hash_generated_field = "10022A525E7D3ACB3B0BC2E8BD5FE9A3")

    private byte[] name_encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.323 -0400", hash_original_method = "E8D4D2361F943CCDDF33AB5563ED886E", hash_generated_method = "58E2146051A8502AA74472E83EDD23CC")
    public  GeneralName(int tag, String name) throws IOException {
        if(name == null)        
        {
            IOException var9499341E0BC616F82C026F1F8830C343_629525166 = new IOException("name == null");
            var9499341E0BC616F82C026F1F8830C343_629525166.addTaint(taint);
            throw var9499341E0BC616F82C026F1F8830C343_629525166;
        } //End block
        this.tag = tag;
switch(tag){
        case OTHER_NAME :
        case X400_ADDR :
        case EDIP_NAME :
        IOException var54009A436658C2F6CB5077A8030F98FA_9183094 = new IOException("Unknown string representation for type [" + tag + "]");
        var54009A436658C2F6CB5077A8030F98FA_9183094.addTaint(taint);
        throw var54009A436658C2F6CB5077A8030F98FA_9183094;
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
        IOException var9500064D91EE0B18E4163E38C1CA4B9D_914119850 = new IOException("Unknown type: [" + tag + "]");
        var9500064D91EE0B18E4163E38C1CA4B9D_914119850.addTaint(taint);
        throw var9500064D91EE0B18E4163E38C1CA4B9D_914119850;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.324 -0400", hash_original_method = "E499E58677EFB5DC6AB5C0B464CEB8CF", hash_generated_method = "A7E878DFEBBD99087D212C020B471EED")
    public  GeneralName(OtherName name) {
        this.tag = OTHER_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = OTHER_NAME;
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.324 -0400", hash_original_method = "6111C4D1FF1E577BF7541C1C985772FA", hash_generated_method = "2274B23BB02D19178F6F1924487CB55F")
    public  GeneralName(ORAddress name) {
        this.tag = X400_ADDR;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = X400_ADDR;
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.325 -0400", hash_original_method = "4A8D46C1231B71B1B6714BAB7338B8B6", hash_generated_method = "A414828AEF9526E2BF08611BC7117D8C")
    public  GeneralName(Name name) {
        this.tag = DIR_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = DIR_NAME;
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.325 -0400", hash_original_method = "E96CC43FEA6BBB964F564DC514331182", hash_generated_method = "4265CE90B2DB501796206157F9B8D102")
    public  GeneralName(EDIPartyName name) {
        this.tag = EDIP_NAME;
        this.name = name;
        // ---------- Original Method ----------
        //this.tag = EDIP_NAME;
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.326 -0400", hash_original_method = "F3BB557A640D5A23013E1A6A6D3E3A5F", hash_generated_method = "826B61522994505FED6CF9556854013A")
    public  GeneralName(byte[] name) throws IllegalArgumentException {
        int length = name.length;
        if(length != 4 && length != 8 && length != 16 && length != 32)        
        {
            IllegalArgumentException var10C540728B922F61CA91D1CCD54071B4_1784567062 = new IllegalArgumentException("name.length invalid");
            var10C540728B922F61CA91D1CCD54071B4_1784567062.addTaint(taint);
            throw var10C540728B922F61CA91D1CCD54071B4_1784567062;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.327 -0400", hash_original_method = "0D9E6D76CFD125A61E2F4A9B060ECF6F", hash_generated_method = "4E60FF01B8A170652D560DC4810C0CF2")
    public  GeneralName(int tag, byte[] name) throws IOException {
        if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_348631113 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_348631113.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_348631113;
        } //End block
        if((tag < 0) || (tag > 8))        
        {
            IOException var103ABEB597C79D1DC6C34F3B986CC20A_98227088 = new IOException("GeneralName: unknown tag: " + tag);
            var103ABEB597C79D1DC6C34F3B986CC20A_98227088.addTaint(taint);
            throw var103ABEB597C79D1DC6C34F3B986CC20A_98227088;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.327 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "CCB2914DED13A86CB565C1E4A6C47638")
    public int getTag() {
        int varE4D23E841D8E8804190027BCE3180FA5_1650385285 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968141610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968141610;
        // ---------- Original Method ----------
        //return tag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.328 -0400", hash_original_method = "20B60556BB46EC823C9319E49D0425A2", hash_generated_method = "68CDAE751899AFE1817FBF07B3E23E6C")
    public Object getName() {
Object varB017984728AC60AD1F0BF8734F33F15C_1766431160 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1766431160.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1766431160;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.328 -0400", hash_original_method = "47F6A98481038A57781CC8365511AC09", hash_generated_method = "99ADCDBE1D97449C1035DCD1C2F457E2")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof GeneralName))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1620211131 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325397929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_325397929;
        } //End block
        GeneralName gname = (GeneralName) other;
        if(this.tag != gname.tag)        
        {
            boolean var68934A3E9455FA72420237EB05902327_752560160 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144823743 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144823743;
        } //End block
switch(tag){
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        boolean var64069A9BFB4BB340568F51433DFC2C06_1839567912 = (((String) name).equalsIgnoreCase(
                        (String) gname.getName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427504347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_427504347;
        case REG_ID:
        boolean var558A3BBBC4011EC9AD93BB2E6E25B105_571629039 = (Arrays.equals((int[]) name, (int[]) gname.name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1269204587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1269204587;
        case IP_ADDR:
        boolean var810545F5008BAE0DD3C4E2518B95BCFA_1277396671 = (Arrays.equals((byte[]) name, (byte[]) gname.name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054000037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054000037;
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        boolean var0872D751EB4DED584B11A3B505721364_1823182788 = (Arrays.equals(getEncoded(), gname.getEncoded()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855187492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855187492;
        default:
}        boolean var68934A3E9455FA72420237EB05902327_1838813778 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259324361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259324361;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.329 -0400", hash_original_method = "A1EE40CF64275F91ADFBB9AA6974DBAD", hash_generated_method = "E33EEC7F0C49C4138E4835BDC1187430")
    public int hashCode() {
switch(tag){
        case RFC822_NAME:
        case DNS_NAME:
        case UR_ID:
        case REG_ID:
        case IP_ADDR:
        int var5715838B66EDF423F24A871806972EB3_857373168 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715238457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715238457;
        case DIR_NAME:
        case X400_ADDR:
        case OTHER_NAME:
        case EDIP_NAME:
        int var142158700CDD81CFFCCC860BDEDED16B_1883204117 = (Arrays.hashCode(getEncoded()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699627903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699627903;
        default:
        int var805ED14872F1C08E5C4314680FD405F0_1953934020 = (super.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218989219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218989219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.332 -0400", hash_original_method = "8BC63B983D4898BF725054A3D5D39730", hash_generated_method = "AD082FEA5221BDA2D3FEFCA5688A944D")
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
}List<Object> varC03C174393C635249B793C3DB15AB950_1309651042 =         Collections.unmodifiableList(result);
        varC03C174393C635249B793C3DB15AB950_1309651042.addTaint(taint);
        return varC03C174393C635249B793C3DB15AB950_1309651042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.333 -0400", hash_original_method = "4137EA74AADFAF54538362634CBBCA7A", hash_generated_method = "1E110FE55D767511A41DEDD7983FA91D")
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
}String varDC838461EE2FA0CA4C9BBB70A15456B0_1689789641 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1689789641.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1689789641;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.333 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "2F1D2F9FABE8BEFB15376C146CE3C676")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1723445124 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1338981608 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1338981608;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.333 -0400", hash_original_method = "37C9CC72170749FE2E2B5C9DA460C3BB", hash_generated_method = "9B9EE7ABEC845B3B783F266362587B18")
    public byte[] getEncodedName() {
        if(name_encoding == null)        
        {
            name_encoding = nameASN1[tag].encode(name);
        } //End block
        byte[] varB044FB6FD80FBC2A60F506E8E61FE96C_1765347429 = (name_encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1544357790 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1544357790;
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static byte[] ipStrToBytes(String ip) throws IOException {
        if (!InetAddress.isNumeric(ip)) {
            throw new IOException("Not an IP address: " + ip);
        }
        return InetAddress.getByName(ip).getAddress();
    }

    
    @DSModeled(DSC.SAFE)
    public static String ipBytesToStr(byte[] ip) {
        try {
            return InetAddress.getByAddress(null, ip).getHostAddress();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Unexpected IP address: " + Arrays.toString(ip));
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "4E5D9AC1F0E8D9AB781F5EFFC24BAE80", hash_generated_field = "1A317709A171B2139EEB8BD8E4FFD633")

    public static final int OTHER_NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "C9732A793148C7EDFD4428D486FC76F2", hash_generated_field = "8605270A6DEED1E9241E2F779D804DB8")

    public static final int RFC822_NAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "4F0C3DDF227592FFCCC3399190B170BA", hash_generated_field = "4068333BBDE31CF8DBD7F63FABF82FFD")

    public static final int DNS_NAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "477AAE6DFC7C5FD37E7EA48DF1C7FCED", hash_generated_field = "541798205EE16CF843FD25263108C9BA")

    public static final int X400_ADDR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "4FB643167CAC0E1227E9EB434BE9D92D", hash_generated_field = "9C79E28158600675871FFC5333F55FE5")

    public static final int DIR_NAME = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "6B8EF3BCF61B405C9BFF6D307557D1CF", hash_generated_field = "F87CA0B39DDF9C21198439CE2BC901D0")

    public static final int EDIP_NAME = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "7C87B966D52898A3326F768DEA8B2305", hash_generated_field = "3BB142C23BDE62C58F9C0B5DCCEFC3C1")

    public static final int UR_ID = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "71FA57B7DB37AB272CE880E0BC58CB80", hash_generated_field = "10C69FE566268D6D08A5BB5FE501A789")

    public static final int IP_ADDR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "5836D0891E6962611C25E29481F6ACFB", hash_generated_field = "11541C1B6479C5A1E801E2333582AEC6")

    public static final int REG_ID = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.335 -0400", hash_original_field = "3FDE0A408DACF520036C6E6B288A77A6", hash_generated_field = "0E58F21A000AB906E098E31DBFAAE1B8")

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

