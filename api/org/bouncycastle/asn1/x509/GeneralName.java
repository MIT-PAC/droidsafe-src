package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.853 -0500", hash_original_method = "54EB3F8F10D837749BD54B5257E33309", hash_generated_method = "734DA2A9C8A7CF13749D016C17E76B23")
    
public static GeneralName getInstance(
        Object obj)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.857 -0500", hash_original_method = "44CA722101605B85C9B6A11FF132BB34", hash_generated_method = "C7028C9595845F3AB819F9BDE3FE6839")
    
public static GeneralName getInstance(
        ASN1TaggedObject tagObj,
        boolean          explicit)
    {
        return GeneralName.getInstance(ASN1TaggedObject.getInstance(tagObj, true));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.810 -0500", hash_original_field = "44F7072630815187DEE3A6D8F6646429", hash_generated_field = "2C60CF820709947727993EEE876A89E1")

    public static final int otherName                     = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.813 -0500", hash_original_field = "5FC52BB5B3DD35BB32C10F76A1885344", hash_generated_field = "D9BB2562526C1C2803346041FE9A9479")

    public static final int rfc822Name                    = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.815 -0500", hash_original_field = "AFAC4931C208E7208C121DC65392DC5A", hash_generated_field = "23A7DFE231C60FEBF0B4AFFCA7C9D797")

    public static final int dNSName                       = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.818 -0500", hash_original_field = "324901C31CAE28AFFDB5191B29F8EA46", hash_generated_field = "22B173553BEDFE31A7EA23714B44E922")

    public static final int x400Address                   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.821 -0500", hash_original_field = "D03A84CE85AE42C54BE8344D6945838E", hash_generated_field = "6771712D3DAA106B0694ED750691B023")

    public static final int directoryName                 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.823 -0500", hash_original_field = "D42B43BE5F77F22363905E7924DC6DC8", hash_generated_field = "74CB4F34E97D116A425947C2F109D7AD")

    public static final int ediPartyName                  = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.825 -0500", hash_original_field = "28BD8805180FE97A8C1F0205A7F16178", hash_generated_field = "8995C085497DE0EAEF0DC2A248EAD3AD")

    public static final int uniformResourceIdentifier     = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.828 -0500", hash_original_field = "DD05770B79F3521FF99C78F36882D8C2", hash_generated_field = "14B98AF4049CB1ED7AAA7C8B6A2D7956")

    public static final int iPAddress                     = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.831 -0500", hash_original_field = "EB5ED18743AB9D3423FA82CFC2A9F58E", hash_generated_field = "751FE59FD146DD9B6987948A4960C030")

    public static final int registeredID                  = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.833 -0500", hash_original_field = "C14035F3386E46275A7D663AC38D8A14", hash_generated_field = "C14035F3386E46275A7D663AC38D8A14")

    DEREncodable      obj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.835 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "0870A130AAC33D99955FFBF59B769627")

    int               tag;
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.838 -0500", hash_original_method = "ADE0DAE6BE5F1175688F81D676806619", hash_generated_method = "9EA2D774F38468220044F60DCC33B8F8")
    
public GeneralName(
        X509Name  dirName)
    {
        this.obj = dirName;
        this.tag = 4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.840 -0500", hash_original_method = "C9285F8047F7E752E9E16F56DB946619", hash_generated_method = "811B62136DBE9E6032CF923D8E7BD002")
    
public GeneralName(
        X500Name dirName)
    {
        this.obj = dirName;
        this.tag = 4;
    }

    /**
     * @deprecated this constructor seems the wrong way round! Use GeneralName(tag, name).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.844 -0500", hash_original_method = "D162BA12EC49621407922055320A05EF", hash_generated_method = "48254A9057AD3239613E6903E1359E24")
    
public GeneralName(
        DERObject name, int tag)
    {
        this.obj = name;
        this.tag = tag;
    }

    /**
     * When the subjectAltName extension contains an Internet mail address,
     * the address MUST be included as an rfc822Name. The format of an
     * rfc822Name is an "addr-spec" as defined in RFC 822 [RFC 822].
     *
     * When the subjectAltName extension contains a domain name service
     * label, the domain name MUST be stored in the dNSName (an IA5String).
     * The name MUST be in the "preferred name syntax," as specified by RFC
     * 1034 [RFC 1034].
     *
     * When the subjectAltName extension contains a URI, the name MUST be
     * stored in the uniformResourceIdentifier (an IA5String). The name MUST
     * be a non-relative URL, and MUST follow the URL syntax and encoding
     * rules specified in [RFC 1738].  The name must include both a scheme
     * (e.g., "http" or "ftp") and a scheme-specific-part.  The scheme-
     * specific-part must include a fully qualified domain name or IP
     * address as the host.
     *
     * When the subjectAltName extension contains a iPAddress, the address
     * MUST be stored in the octet string in "network byte order," as
     * specified in RFC 791 [RFC 791]. The least significant bit (LSB) of
     * each octet is the LSB of the corresponding byte in the network
     * address. For IP Version 4, as specified in RFC 791, the octet string
     * MUST contain exactly four octets.  For IP Version 6, as specified in
     * RFC 1883, the octet string MUST contain exactly sixteen octets [RFC
     * 1883].
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.846 -0500", hash_original_method = "665CD76EA1DF7ECA95D5C037ABED8C02", hash_generated_method = "9684B6B8C49EDC9870A0E10E55BB4075")
    
public GeneralName(
        int           tag,
        ASN1Encodable name)
    {
        this.obj = name;
        this.tag = tag;
    }
    
    /**
     * Create a GeneralName for the given tag from the passed in String.
     * <p>
     * This constructor can handle:
     * <ul>
     * <li>rfc822Name
     * <li>iPAddress
     * <li>directoryName
     * <li>dNSName
     * <li>uniformResourceIdentifier
     * <li>registeredID
     * </ul>
     * For x400Address, otherName and ediPartyName there is no common string
     * format defined.
     * <p>
     * Note: A directory name can be encoded in different ways into a byte
     * representation. Be aware of this if the byte representation is used for
     * comparing results.
     *
     * @param tag tag number
     * @param name string representation of name
     * @throws IllegalArgumentException if the string encoding is not correct or     *             not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.849 -0500", hash_original_method = "4C7C4EFE2EC806CECAFA053C455D2BA2", hash_generated_method = "BDC409D73F93AD00C545DA0FDF8765A4")
    
public GeneralName(
        int       tag,
        String    name)
    {
        this.tag = tag;

        if (tag == rfc822Name || tag == dNSName || tag == uniformResourceIdentifier)
        {
            this.obj = new DERIA5String(name);
        }
        else if (tag == registeredID)
        {
            this.obj = new DERObjectIdentifier(name);
        }
        else if (tag == directoryName)
        {
            this.obj = new X509Name(name);
        }
        else if (tag == iPAddress)
        {
            byte[] enc = toGeneralNameEncoding(name);
            if (enc != null)
            {
                this.obj = new DEROctetString(enc);
            }
            else
            {
                throw new IllegalArgumentException("IP Address is invalid");
            }
        }
        else
        {
            throw new IllegalArgumentException("can't process String for tag: " + tag);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.860 -0500", hash_original_method = "50B74CB2E4EBFF1B331EE5025ECA03E2", hash_generated_method = "23B1C06DAFA4E9350DF8CB21C0BC784D")
    
public int getTagNo()
    {
        return tag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.863 -0500", hash_original_method = "2A79ACAAF65B843006F5215944D07A13", hash_generated_method = "33D45F11368A03539F6780F8A31378FD")
    
public DEREncodable getName()
    {
        return obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.866 -0500", hash_original_method = "6AFE1DDEFB420AC1C3733113CDF77755", hash_generated_method = "DFD4363F51561851C2E908EC45C14087")
    
public String toString()
    {
        StringBuffer buf = new StringBuffer();

        buf.append(tag);
        buf.append(": ");
        switch (tag)
        {
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
        }
        return buf.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.869 -0500", hash_original_method = "F02018A790F280370B2CB39B10862FEC", hash_generated_method = "B4114A90346BAC2CA37E578F2040413C")
    
private byte[] toGeneralNameEncoding(String ip)
    {
        if (IPAddress.isValidIPv6WithNetmask(ip) || IPAddress.isValidIPv6(ip))
        {
            int    slashIndex = ip.indexOf('/');

            if (slashIndex < 0)
            {
                byte[] addr = new byte[16];
                int[]  parsedIp = parseIPv6(ip);
                copyInts(parsedIp, addr, 0);

                return addr;
            }
            else
            {
                byte[] addr = new byte[32];
                int[]  parsedIp = parseIPv6(ip.substring(0, slashIndex));
                copyInts(parsedIp, addr, 0);
                String mask = ip.substring(slashIndex + 1);
                if (mask.indexOf(':') > 0)
                {
                    parsedIp = parseIPv6(mask);
                }
                else
                {
                    parsedIp = parseMask(mask);
                }
                copyInts(parsedIp, addr, 16);

                return addr;
            }
        }
        else if (IPAddress.isValidIPv4WithNetmask(ip) || IPAddress.isValidIPv4(ip))
        {
            int    slashIndex = ip.indexOf('/');

            if (slashIndex < 0)
            {
                byte[] addr = new byte[4];

                parseIPv4(ip, addr, 0);

                return addr;
            }
            else
            {
                byte[] addr = new byte[8];

                parseIPv4(ip.substring(0, slashIndex), addr, 0);

                String mask = ip.substring(slashIndex + 1);
                if (mask.indexOf('.') > 0)
                {
                    parseIPv4(mask, addr, 4);
                }
                else
                {
                    parseIPv4Mask(mask, addr, 4);
                }

                return addr;
            }
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.872 -0500", hash_original_method = "B54AB1000C04EF98C8414C613F178EE6", hash_generated_method = "26D3FB892318A3AD15278E196768ABF7")
    
private void parseIPv4Mask(String mask, byte[] addr, int offset)
    {
        int   maskVal = Integer.parseInt(mask);

        for (int i = 0; i != maskVal; i++)
        {
            addr[(i / 8) + offset] |= 1 << (i % 8);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.874 -0500", hash_original_method = "D3256FE340A5AB891180F872DE9312FE", hash_generated_method = "01C7845478B8D1321EA2883987ADA9ED")
    
private void parseIPv4(String ip, byte[] addr, int offset)
    {
        StringTokenizer sTok = new StringTokenizer(ip, "./");
        int    index = 0;

        while (sTok.hasMoreTokens())
        {
            addr[offset + index++] = (byte)Integer.parseInt(sTok.nextToken());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.876 -0500", hash_original_method = "AAEA46BCEA791BA55D0418C441E919BF", hash_generated_method = "F4E9F7CAD7EE1AF06DCCBCEC5D429EDA")
    
private int[] parseMask(String mask)
    {
        int[] res = new int[8];
        int   maskVal = Integer.parseInt(mask);

        for (int i = 0; i != maskVal; i++)
        {
            res[i / 16] |= 1 << (i % 16);
        }
        return res;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.878 -0500", hash_original_method = "C5093ABFF769462F7C38A897D6D20C09", hash_generated_method = "E1E3F895F3628CA1484F8C1FB38DDD84")
    
private void copyInts(int[] parsedIp, byte[] addr, int offSet)
    {
        for (int i = 0; i != parsedIp.length; i++)
        {
            addr[(i * 2) + offSet] = (byte)(parsedIp[i] >> 8);
            addr[(i * 2 + 1) + offSet] = (byte)parsedIp[i];
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.883 -0500", hash_original_method = "9628A2DF5EA66A9EC56C6B58E58FBD48", hash_generated_method = "7BE89C247823BE0E04BBB5E195A9B3F6")
    
private int[] parseIPv6(String ip)
    {
        StringTokenizer sTok = new StringTokenizer(ip, ":", true);
        int index = 0;
        int[] val = new int[8];

        if (ip.charAt(0) == ':' && ip.charAt(1) == ':')
        {
           sTok.nextToken(); // skip the first one
        }

        int doubleColon = -1;

        while (sTok.hasMoreTokens())
        {
            String e = sTok.nextToken();

            if (e.equals(":"))
            {
                doubleColon = index;
                val[index++] = 0;
            }
            else
            {
                if (e.indexOf('.') < 0)
                {
                    val[index++] = Integer.parseInt(e, 16);
                    if (sTok.hasMoreTokens())
                    {
                        sTok.nextToken();
                    }
                }
                else
                {
                    StringTokenizer eTok = new StringTokenizer(e, ".");

                    val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                    val[index++] = (Integer.parseInt(eTok.nextToken()) << 8) | Integer.parseInt(eTok.nextToken());
                }
            }
        }

        if (index != val.length)
        {
            System.arraycopy(val, doubleColon, val, val.length - (index - doubleColon), index - doubleColon);
            for (int i = doubleColon; i != val.length - (index - doubleColon); i++)
            {
                val[i] = 0;
            }
        }

        return val;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.885 -0500", hash_original_method = "D622C616E457C40B929532BF47722854", hash_generated_method = "775FAEAD46F706C44089DD228C701A33")
    
public DERObject toASN1Object()
    {
        if (tag == directoryName)       // directoryName is explicitly tagged as it is a CHOICE
        {
            return new DERTaggedObject(true, tag, obj);
        }
        else
        {
            return new DERTaggedObject(false, tag, obj);
        }
    }
}

