package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.IPAddress;

public class GeneralName extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.693 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "C14035F3386E46275A7D663AC38D8A14")

    DEREncodable obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.693 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "0870A130AAC33D99955FFBF59B769627")

    int tag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.694 -0400", hash_original_method = "ADE0DAE6BE5F1175688F81D676806619", hash_generated_method = "E0B97A054FF02C188587E94A8DFD80D7")
    public  GeneralName(
        X509Name  dirName) {
        this.obj = dirName;
        this.tag = 4;
        // ---------- Original Method ----------
        //this.obj = dirName;
        //this.tag = 4;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.694 -0400", hash_original_method = "C9285F8047F7E752E9E16F56DB946619", hash_generated_method = "5849A1FB12E98D0EE9ECAC7307462461")
    public  GeneralName(
        X500Name dirName) {
        this.obj = dirName;
        this.tag = 4;
        // ---------- Original Method ----------
        //this.obj = dirName;
        //this.tag = 4;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.695 -0400", hash_original_method = "D162BA12EC49621407922055320A05EF", hash_generated_method = "DD9CC29BA2DB0B242690EBD36A22DA6F")
    public  GeneralName(
        DERObject name, int tag) {
        this.obj = name;
        this.tag = tag;
        // ---------- Original Method ----------
        //this.obj = name;
        //this.tag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.695 -0400", hash_original_method = "665CD76EA1DF7ECA95D5C037ABED8C02", hash_generated_method = "DA021E28FCFC1CD04E4328E4BEAD69B3")
    public  GeneralName(
        int           tag,
        ASN1Encodable name) {
        this.obj = name;
        this.tag = tag;
        // ---------- Original Method ----------
        //this.obj = name;
        //this.tag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.696 -0400", hash_original_method = "4C7C4EFE2EC806CECAFA053C455D2BA2", hash_generated_method = "951D3C9E74FDA3DC2422664B845CA28A")
    public  GeneralName(
        int       tag,
        String    name) {
        this.tag = tag;
        if(tag == rfc822Name || tag == dNSName || tag == uniformResourceIdentifier)        
        {
            this.obj = new DERIA5String(name);
        } //End block
        else
        if(tag == registeredID)        
        {
            this.obj = new DERObjectIdentifier(name);
        } //End block
        else
        if(tag == directoryName)        
        {
            this.obj = new X509Name(name);
        } //End block
        else
        if(tag == iPAddress)        
        {
            byte[] enc = toGeneralNameEncoding(name);
            if(enc != null)            
            {
                this.obj = new DEROctetString(enc);
            } //End block
            else
            {
                IllegalArgumentException varA45D23F663C3D7D4B9E0CE18FD179036_2145024128 = new IllegalArgumentException("IP Address is invalid");
                varA45D23F663C3D7D4B9E0CE18FD179036_2145024128.addTaint(taint);
                throw varA45D23F663C3D7D4B9E0CE18FD179036_2145024128;
            } //End block
        } //End block
        else
        {
            IllegalArgumentException var334DA4DD96B542180B6378A70311997E_841755793 = new IllegalArgumentException("can't process String for tag: " + tag);
            var334DA4DD96B542180B6378A70311997E_841755793.addTaint(taint);
            throw var334DA4DD96B542180B6378A70311997E_841755793;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public static GeneralName getInstance(
        Object obj) {
        if (obj == null || obj instanceof GeneralName)
        {
            return (GeneralName)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            ASN1TaggedObject    tagObj = (ASN1TaggedObject)obj;
            int                 tag = tagObj.getTagNo();
            switch (tag)
            {
            case otherName:
                return new GeneralName(tag, ASN1Sequence.getInstance(tagObj, false));
            case rfc822Name:
                return new GeneralName(tag, DERIA5String.getInstance(tagObj, false));
            case dNSName:
                return new GeneralName(tag, DERIA5String.getInstance(tagObj, false));
            case x400Address:
                throw new IllegalArgumentException("unknown tag: " + tag);
            case directoryName:
                return new GeneralName(tag, X509Name.getInstance(tagObj, true));
            case ediPartyName:
                return new GeneralName(tag, ASN1Sequence.getInstance(tagObj, false));
            case uniformResourceIdentifier:
                return new GeneralName(tag, DERIA5String.getInstance(tagObj, false));
            case iPAddress:
                return new GeneralName(tag, ASN1OctetString.getInstance(tagObj, false));
            case registeredID:
                return new GeneralName(tag, DERObjectIdentifier.getInstance(tagObj, false));
            }
        }
        if (obj instanceof byte[])
        {
            try
            {
                return getInstance(ASN1Object.fromByteArray((byte[])obj));
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static GeneralName getInstance(
        ASN1TaggedObject tagObj,
        boolean          explicit) {
        return GeneralName.getInstance(ASN1TaggedObject.getInstance(tagObj, true));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.698 -0400", hash_original_method = "50B74CB2E4EBFF1B331EE5025ECA03E2", hash_generated_method = "AD8A66EB266585BE643A554596E7349C")
    public int getTagNo() {
        int varE4D23E841D8E8804190027BCE3180FA5_1578918202 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221261539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221261539;
        // ---------- Original Method ----------
        //return tag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.698 -0400", hash_original_method = "2A79ACAAF65B843006F5215944D07A13", hash_generated_method = "1CAC1269F1DBE5878661572B303835FF")
    public DEREncodable getName() {
DEREncodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_407195119 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_407195119.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_407195119;
        // ---------- Original Method ----------
        //return obj;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.699 -0400", hash_original_method = "6AFE1DDEFB420AC1C3733113CDF77755", hash_generated_method = "F170A325189A54396C0C61DAA970075E")
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(tag);
        buf.append(": ");
switch(tag){
        case rfc822Name:
        case dNSName:
        case uniformResourceIdentifier:
        buf.append(DERIA5String.getInstance(obj).getString());
        break;
        case directoryName:
        buf.append(X509Name.getInstance(obj).toString());
        break;
        default:
        buf.append(obj.toString());
}String var4FC680801218E6372BC708D6FA44AE60_2082989642 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_2082989642.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_2082989642;
        // ---------- Original Method ----------
        //StringBuffer buf = new StringBuffer();
        //buf.append(tag);
        //buf.append(": ");
        //switch (tag)
        //{
        //case rfc822Name:
        //case dNSName:
        //case uniformResourceIdentifier:
            //buf.append(DERIA5String.getInstance(obj).getString());
            //break;
        //case directoryName:
            //buf.append(X509Name.getInstance(obj).toString());
            //break;
        //default:
            //buf.append(obj.toString());
        //}
        //return buf.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.700 -0400", hash_original_method = "F02018A790F280370B2CB39B10862FEC", hash_generated_method = "DDB0D059B2067E140D94E3642AF5A8FF")
    private byte[] toGeneralNameEncoding(String ip) {
        addTaint(ip.getTaint());
        if(IPAddress.isValidIPv6WithNetmask(ip) || IPAddress.isValidIPv6(ip))        
        {
            int slashIndex = ip.indexOf('/');
            if(slashIndex < 0)            
            {
                byte[] addr = new byte[16];
                int[] parsedIp = parseIPv6(ip);
                copyInts(parsedIp, addr, 0);
                byte[] var3EF9A0D7FAB5D2BCABF0978C0A35244E_1913228825 = (addr);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1644774477 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1644774477;
            } //End block
            else
            {
                byte[] addr = new byte[32];
                int[] parsedIp = parseIPv6(ip.substring(0, slashIndex));
                copyInts(parsedIp, addr, 0);
                String mask = ip.substring(slashIndex + 1);
                if(mask.indexOf(':') > 0)                
                {
                    parsedIp = parseIPv6(mask);
                } //End block
                else
                {
                    parsedIp = parseMask(mask);
                } //End block
                copyInts(parsedIp, addr, 16);
                byte[] var3EF9A0D7FAB5D2BCABF0978C0A35244E_1723097362 = (addr);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_566011639 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_566011639;
            } //End block
        } //End block
        else
        if(IPAddress.isValidIPv4WithNetmask(ip) || IPAddress.isValidIPv4(ip))        
        {
            int slashIndex = ip.indexOf('/');
            if(slashIndex < 0)            
            {
                byte[] addr = new byte[4];
                parseIPv4(ip, addr, 0);
                byte[] var3EF9A0D7FAB5D2BCABF0978C0A35244E_1929802531 = (addr);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_152566365 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_152566365;
            } //End block
            else
            {
                byte[] addr = new byte[8];
                parseIPv4(ip.substring(0, slashIndex), addr, 0);
                String mask = ip.substring(slashIndex + 1);
                if(mask.indexOf('.') > 0)                
                {
                    parseIPv4(mask, addr, 4);
                } //End block
                else
                {
                    parseIPv4Mask(mask, addr, 4);
                } //End block
                byte[] var3EF9A0D7FAB5D2BCABF0978C0A35244E_2053714764 = (addr);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_330647115 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_330647115;
            } //End block
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1906926863 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1803539014 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1803539014;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.701 -0400", hash_original_method = "B54AB1000C04EF98C8414C613F178EE6", hash_generated_method = "258BA28276EF9E214656AFB3B86C624E")
    private void parseIPv4Mask(String mask, byte[] addr, int offset) {
        addTaint(offset);
        addTaint(addr[0]);
        addTaint(mask.getTaint());
        int maskVal = Integer.parseInt(mask);
for(int i = 0;i != maskVal;i++)
        {
            addr[(i / 8) + offset] |= 1 << (i % 8);
        } //End block
        // ---------- Original Method ----------
        //int   maskVal = Integer.parseInt(mask);
        //for (int i = 0; i != maskVal; i++)
        //{
            //addr[(i / 8) + offset] |= 1 << (i % 8);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.701 -0400", hash_original_method = "D3256FE340A5AB891180F872DE9312FE", hash_generated_method = "68A2479A5E81FFF17B9F79253FBFBA95")
    private void parseIPv4(String ip, byte[] addr, int offset) {
        addTaint(offset);
        addTaint(addr[0]);
        addTaint(ip.getTaint());
        StringTokenizer sTok = new StringTokenizer(ip, "./");
        int index = 0;
        while
(sTok.hasMoreTokens())        
        {
            addr[offset + index++] = (byte)Integer.parseInt(sTok.nextToken());
        } //End block
        // ---------- Original Method ----------
        //StringTokenizer sTok = new StringTokenizer(ip, "./");
        //int    index = 0;
        //while (sTok.hasMoreTokens())
        //{
            //addr[offset + index++] = (byte)Integer.parseInt(sTok.nextToken());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.702 -0400", hash_original_method = "AAEA46BCEA791BA55D0418C441E919BF", hash_generated_method = "0F6A2469E9723EB3FAAD0B6F596419E7")
    private int[] parseMask(String mask) {
        addTaint(mask.getTaint());
        int[] res = new int[8];
        int maskVal = Integer.parseInt(mask);
for(int i = 0;i != maskVal;i++)
        {
            res[i / 16] |= 1 << (i % 16);
        } //End block
        int[] var9B207167E5381C47682C6B4F58A623FB_1180224778 = (res);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_24417402 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_24417402;
        // ---------- Original Method ----------
        //int[] res = new int[8];
        //int   maskVal = Integer.parseInt(mask);
        //for (int i = 0; i != maskVal; i++)
        //{
            //res[i / 16] |= 1 << (i % 16);
        //}
        //return res;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_method = "C5093ABFF769462F7C38A897D6D20C09", hash_generated_method = "1B8046E623BFD2322A87EA4A941EA3A9")
    private void copyInts(int[] parsedIp, byte[] addr, int offSet) {
        addTaint(offSet);
        addTaint(addr[0]);
        addTaint(parsedIp[0]);
for(int i = 0;i != parsedIp.length;i++)
        {
            addr[(i * 2) + offSet] = (byte)(parsedIp[i] >> 8);
            addr[(i * 2 + 1) + offSet] = (byte)parsedIp[i];
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i != parsedIp.length; i++)
        //{
            //addr[(i * 2) + offSet] = (byte)(parsedIp[i] >> 8);
            //addr[(i * 2 + 1) + offSet] = (byte)parsedIp[i];
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_method = "9628A2DF5EA66A9EC56C6B58E58FBD48", hash_generated_method = "BBB15ABE6E3E996BCCDEA7E1184EFDE5")
    private int[] parseIPv6(String ip) {
        addTaint(ip.getTaint());
        StringTokenizer sTok = new StringTokenizer(ip, ":", true);
        int index = 0;
        int[] val = new int[8];
        if(ip.charAt(0) == ':' && ip.charAt(1) == ':')        
        {
            sTok.nextToken();
        } //End block
        int doubleColon = -1;
        while
(sTok.hasMoreTokens())        
        {
            String e = sTok.nextToken();
            if(e.equals(":"))            
            {
                doubleColon = index;
                val[index++] = 0;
            } //End block
            else
            {
                if(e.indexOf('.') < 0)                
                {
                    val[index++] = Integer.parseInt(e, 16);
                    if(sTok.hasMoreTokens())                    
                    {
                        sTok.nextToken();
                    } //End block
                } //End block
                else
                {
                    StringTokenizer eTok = new StringTokenizer(e, ".");
                    val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                    val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                } //End block
            } //End block
        } //End block
        if(index != val.length)        
        {
            System.arraycopy(val, doubleColon, val, val.length - (index - doubleColon), index - doubleColon);
for(int i = doubleColon;i != val.length - (index - doubleColon);i++)
            {
                val[i] = 0;
            } //End block
        } //End block
        int[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_563815008 = (val);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2054204182 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2054204182;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_method = "D622C616E457C40B929532BF47722854", hash_generated_method = "4371BD4B535C3E2C8EF402B8226B74CC")
    public DERObject toASN1Object() {
        if(tag == directoryName)        
        {
DERObject varC7D22BA08906A6FB4FA5FD3A5B70696A_1547912227 =             new DERTaggedObject(true, tag, obj);
            varC7D22BA08906A6FB4FA5FD3A5B70696A_1547912227.addTaint(taint);
            return varC7D22BA08906A6FB4FA5FD3A5B70696A_1547912227;
        } //End block
        else
        {
DERObject var4177AE842156D9924A23BE6FE4BD83AD_2067328720 =             new DERTaggedObject(false, tag, obj);
            var4177AE842156D9924A23BE6FE4BD83AD_2067328720.addTaint(taint);
            return var4177AE842156D9924A23BE6FE4BD83AD_2067328720;
        } //End block
        // ---------- Original Method ----------
        //if (tag == directoryName)       
        //{
            //return new DERTaggedObject(true, tag, obj);
        //}
        //else
        //{
            //return new DERTaggedObject(false, tag, obj);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_field = "C4EEAEC33BD21A3FD38F227A03AE4C87", hash_generated_field = "2C60CF820709947727993EEE876A89E1")

    public static final int otherName                     = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_field = "D9708D90C36E0FE617FB8C727BC83660", hash_generated_field = "D9BB2562526C1C2803346041FE9A9479")

    public static final int rfc822Name                    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_field = "25CBC7428D533DBED7E4B1CE12E2B7CC", hash_generated_field = "23A7DFE231C60FEBF0B4AFFCA7C9D797")

    public static final int dNSName                       = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.703 -0400", hash_original_field = "FD1B5E14181A43B524B1C9EBC492E2B5", hash_generated_field = "22B173553BEDFE31A7EA23714B44E922")

    public static final int x400Address                   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.704 -0400", hash_original_field = "3455C762936B742EBCA759D015969534", hash_generated_field = "6771712D3DAA106B0694ED750691B023")

    public static final int directoryName                 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.704 -0400", hash_original_field = "FCA9CDFACE1EE026FD0F5B834981B021", hash_generated_field = "74CB4F34E97D116A425947C2F109D7AD")

    public static final int ediPartyName                  = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.704 -0400", hash_original_field = "CA924DBDC28208088DBEA851EF9125D5", hash_generated_field = "8995C085497DE0EAEF0DC2A248EAD3AD")

    public static final int uniformResourceIdentifier     = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.704 -0400", hash_original_field = "C8848C5506E3277C4C949CB15EBDCBAD", hash_generated_field = "14B98AF4049CB1ED7AAA7C8B6A2D7956")

    public static final int iPAddress                     = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.704 -0400", hash_original_field = "F9011CB3234F21E8F20DB8B97C0C13EC", hash_generated_field = "751FE59FD146DD9B6987948A4960C030")

    public static final int registeredID                  = 8;
}

