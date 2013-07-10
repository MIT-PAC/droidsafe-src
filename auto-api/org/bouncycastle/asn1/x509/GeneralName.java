package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.761 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "C14035F3386E46275A7D663AC38D8A14")

    DEREncodable obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.761 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "0870A130AAC33D99955FFBF59B769627")

    int tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.762 -0400", hash_original_method = "ADE0DAE6BE5F1175688F81D676806619", hash_generated_method = "E0B97A054FF02C188587E94A8DFD80D7")
    public  GeneralName(
        X509Name  dirName) {
        this.obj = dirName;
        this.tag = 4;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.762 -0400", hash_original_method = "C9285F8047F7E752E9E16F56DB946619", hash_generated_method = "5849A1FB12E98D0EE9ECAC7307462461")
    public  GeneralName(
        X500Name dirName) {
        this.obj = dirName;
        this.tag = 4;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.762 -0400", hash_original_method = "D162BA12EC49621407922055320A05EF", hash_generated_method = "DD9CC29BA2DB0B242690EBD36A22DA6F")
    public  GeneralName(
        DERObject name, int tag) {
        this.obj = name;
        this.tag = tag;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.763 -0400", hash_original_method = "665CD76EA1DF7ECA95D5C037ABED8C02", hash_generated_method = "DA021E28FCFC1CD04E4328E4BEAD69B3")
    public  GeneralName(
        int           tag,
        ASN1Encodable name) {
        this.obj = name;
        this.tag = tag;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.763 -0400", hash_original_method = "4C7C4EFE2EC806CECAFA053C455D2BA2", hash_generated_method = "E32A747DF971A8814ADF4C9229004251")
    public  GeneralName(
        int       tag,
        String    name) {
        this.tag = tag;
        {
            this.obj = new DERIA5String(name);
        } 
        {
            this.obj = new DERObjectIdentifier(name);
        } 
        {
            this.obj = new X509Name(name);
        } 
        {
            byte[] enc = toGeneralNameEncoding(name);
            {
                this.obj = new DEROctetString(enc);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("IP Address is invalid");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("can't process String for tag: " + tag);
        } 
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.764 -0400", hash_original_method = "50B74CB2E4EBFF1B331EE5025ECA03E2", hash_generated_method = "8323C50A29F6AEA0316226F2F49807EE")
    public int getTagNo() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236927510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236927510;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.766 -0400", hash_original_method = "2A79ACAAF65B843006F5215944D07A13", hash_generated_method = "5ADE078EA69165D764079C80D894B22D")
    public DEREncodable getName() {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1515446050 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1515446050 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_1515446050.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1515446050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.768 -0400", hash_original_method = "6AFE1DDEFB420AC1C3733113CDF77755", hash_generated_method = "98A10C1EC78043A4859312F4930CA1F6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_184107149 = null; 
        StringBuffer buf = new StringBuffer();
        buf.append(tag);
        buf.append(": ");
        
        buf.append(DERIA5String.getInstance(obj).getString());
        
        
        buf.append(X509Name.getInstance(obj).toString());
        
        
        buf.append(obj.toString());
        
        varB4EAC82CA7396A68D541C85D26508E83_184107149 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_184107149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_184107149;
        
        
        
        
        
        
        
        
        
            
            
        
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.770 -0400", hash_original_method = "F02018A790F280370B2CB39B10862FEC", hash_generated_method = "0EF4030E414FB869D8C8D85B2326B045")
    private byte[] toGeneralNameEncoding(String ip) {
        {
            boolean var1109E9D9B1D21A81C08F4AC03CD8879A_1327618949 = (IPAddress.isValidIPv6WithNetmask(ip) || IPAddress.isValidIPv6(ip));
            {
                int slashIndex = ip.indexOf('/');
                {
                    byte[] addr = new byte[16];
                    int[] parsedIp = parseIPv6(ip);
                    copyInts(parsedIp, addr, 0);
                } 
                {
                    byte[] addr = new byte[32];
                    int[] parsedIp = parseIPv6(ip.substring(0, slashIndex));
                    copyInts(parsedIp, addr, 0);
                    String mask = ip.substring(slashIndex + 1);
                    {
                        boolean varCD5038F37B399E649D3619D0C0926E01_1600035820 = (mask.indexOf(':') > 0);
                        {
                            parsedIp = parseIPv6(mask);
                        } 
                        {
                            parsedIp = parseMask(mask);
                        } 
                    } 
                    copyInts(parsedIp, addr, 16);
                } 
            } 
            {
                boolean varD5B601DE6AF85665A8FAF07579E32B42_1930181584 = (IPAddress.isValidIPv4WithNetmask(ip) || IPAddress.isValidIPv4(ip));
                {
                    int slashIndex = ip.indexOf('/');
                    {
                        byte[] addr = new byte[4];
                        parseIPv4(ip, addr, 0);
                    } 
                    {
                        byte[] addr = new byte[8];
                        parseIPv4(ip.substring(0, slashIndex), addr, 0);
                        String mask = ip.substring(slashIndex + 1);
                        {
                            boolean var4C15B2AE6CB1E676E704DD915BA2619A_579508919 = (mask.indexOf('.') > 0);
                            {
                                parseIPv4(mask, addr, 4);
                            } 
                            {
                                parseIPv4Mask(mask, addr, 4);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(ip.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1576881455 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1576881455;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.771 -0400", hash_original_method = "B54AB1000C04EF98C8414C613F178EE6", hash_generated_method = "81620B91A6D092109C7E86C25940D48E")
    private void parseIPv4Mask(String mask, byte[] addr, int offset) {
        int maskVal = Integer.parseInt(mask);
        {
            int i = 0;
            {
                addr[(i / 8) + offset] |= 1 << (i % 8);
            } 
        } 
        addTaint(mask.getTaint());
        addTaint(addr[0]);
        addTaint(offset);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.771 -0400", hash_original_method = "D3256FE340A5AB891180F872DE9312FE", hash_generated_method = "84CC6B936ECBA918B1FB466B4310E31B")
    private void parseIPv4(String ip, byte[] addr, int offset) {
        StringTokenizer sTok = new StringTokenizer(ip, "./");
        int index = 0;
        {
            boolean var33552EFC0BCF12983E7C1D7D9C26C57D_1620579807 = (sTok.hasMoreTokens());
            {
                addr[offset + index++] = (byte)Integer.parseInt(sTok.nextToken());
            } 
        } 
        addTaint(ip.getTaint());
        addTaint(addr[0]);
        addTaint(offset);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.772 -0400", hash_original_method = "AAEA46BCEA791BA55D0418C441E919BF", hash_generated_method = "81D95FAA6CAE561393A582743442F733")
    private int[] parseMask(String mask) {
        int[] res = new int[8];
        int maskVal = Integer.parseInt(mask);
        {
            int i = 0;
            {
                res[i / 16] |= 1 << (i % 16);
            } 
        } 
        addTaint(mask.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_765554579 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_765554579;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.773 -0400", hash_original_method = "C5093ABFF769462F7C38A897D6D20C09", hash_generated_method = "2342F0ABD78E42F5CBC16860025CA34E")
    private void copyInts(int[] parsedIp, byte[] addr, int offSet) {
        {
            int i = 0;
            {
                addr[(i * 2) + offSet] = (byte)(parsedIp[i] >> 8);
                addr[(i * 2 + 1) + offSet] = (byte)parsedIp[i];
            } 
        } 
        addTaint(parsedIp[0]);
        addTaint(addr[0]);
        addTaint(offSet);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.773 -0400", hash_original_method = "9628A2DF5EA66A9EC56C6B58E58FBD48", hash_generated_method = "509501CEC7FB9A26BAC597848D42F98C")
    private int[] parseIPv6(String ip) {
        StringTokenizer sTok = new StringTokenizer(ip, ":", true);
        int index = 0;
        int[] val = new int[8];
        {
            boolean var7700DBF599C2D7F18B8CE11CBB745182_970831769 = (ip.charAt(0) == ':' && ip.charAt(1) == ':');
            {
                sTok.nextToken();
            } 
        } 
        int doubleColon = -1;
        {
            boolean var33552EFC0BCF12983E7C1D7D9C26C57D_917083957 = (sTok.hasMoreTokens());
            {
                String e = sTok.nextToken();
                {
                    boolean var070CF654C35E448AD498FB574FFA57CE_1058681967 = (e.equals(":"));
                    {
                        doubleColon = index;
                        val[index++] = 0;
                    } 
                    {
                        {
                            boolean var200FB43FCE28F68371DB8907E59BFEC0_173373318 = (e.indexOf('.') < 0);
                            {
                                val[index++] = Integer.parseInt(e, 16);
                                {
                                    boolean varBB14443C65DF60BC330422BEC61525CB_460713903 = (sTok.hasMoreTokens());
                                    {
                                        sTok.nextToken();
                                    } 
                                } 
                            } 
                            {
                                StringTokenizer eTok = new StringTokenizer(e, ".");
                                val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                                val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            System.arraycopy(val, doubleColon, val, val.length - (index - doubleColon), index - doubleColon);
            {
                int i = doubleColon;
                {
                    val[i] = 0;
                } 
            } 
        } 
        addTaint(ip.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_35402392 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_35402392;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.774 -0400", hash_original_method = "D622C616E457C40B929532BF47722854", hash_generated_method = "6A4D2A256DE022DFE3F25AB7367E8FD6")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1777721730 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_790810966 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1777721730 = new DERTaggedObject(true, tag, obj);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_790810966 = new DERTaggedObject(false, tag, obj);
        } 
        DERObject varA7E53CE21691AB073D9660D615818899_833022160; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_833022160 = varB4EAC82CA7396A68D541C85D26508E83_1777721730;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_833022160 = varB4EAC82CA7396A68D541C85D26508E83_790810966;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_833022160.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_833022160;
        
        
        
            
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "C4EEAEC33BD21A3FD38F227A03AE4C87", hash_generated_field = "2C60CF820709947727993EEE876A89E1")

    public static final int otherName                     = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "D9708D90C36E0FE617FB8C727BC83660", hash_generated_field = "D9BB2562526C1C2803346041FE9A9479")

    public static final int rfc822Name                    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "25CBC7428D533DBED7E4B1CE12E2B7CC", hash_generated_field = "23A7DFE231C60FEBF0B4AFFCA7C9D797")

    public static final int dNSName                       = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "FD1B5E14181A43B524B1C9EBC492E2B5", hash_generated_field = "22B173553BEDFE31A7EA23714B44E922")

    public static final int x400Address                   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "3455C762936B742EBCA759D015969534", hash_generated_field = "6771712D3DAA106B0694ED750691B023")

    public static final int directoryName                 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "FCA9CDFACE1EE026FD0F5B834981B021", hash_generated_field = "74CB4F34E97D116A425947C2F109D7AD")

    public static final int ediPartyName                  = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "CA924DBDC28208088DBEA851EF9125D5", hash_generated_field = "8995C085497DE0EAEF0DC2A248EAD3AD")

    public static final int uniformResourceIdentifier     = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "C8848C5506E3277C4C949CB15EBDCBAD", hash_generated_field = "14B98AF4049CB1ED7AAA7C8B6A2D7956")

    public static final int iPAddress                     = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.775 -0400", hash_original_field = "F9011CB3234F21E8F20DB8B97C0C13EC", hash_generated_field = "751FE59FD146DD9B6987948A4960C030")

    public static final int registeredID                  = 8;
}

