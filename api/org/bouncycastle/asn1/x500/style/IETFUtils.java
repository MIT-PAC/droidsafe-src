package org.bouncycastle.asn1.x500.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;





public class IETFUtils {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.737 -0500", hash_original_method = "983A3D28718608244DB1B77020020016", hash_generated_method = "EFCCC0589F64419E642BE38ACBC24C65")
    
public static RDN[] rDNsFromString(String name, X500NameStyle x500Style)
    {
        X500NameTokenizer nTok = new X500NameTokenizer(name);
        X500NameBuilder builder = new X500NameBuilder(x500Style);

        while (nTok.hasMoreTokens())
        {
            String  token = nTok.nextToken();
            int     index = token.indexOf('=');

            if (index == -1)
            {
                throw new IllegalArgumentException("badly formated directory string");
            }

            String               attr = token.substring(0, index);
            String               value = token.substring(index + 1);
            ASN1ObjectIdentifier oid = x500Style.attrNameToOID(attr);

            if (value.indexOf('+') > 0)
            {
                X500NameTokenizer   vTok = new X500NameTokenizer(value, '+');
                String  v = vTok.nextToken();

                Vector oids = new Vector();
                Vector values = new Vector();

                oids.addElement(oid);
                values.addElement(v);

                while (vTok.hasMoreTokens())
                {
                    String  sv = vTok.nextToken();
                    int     ndx = sv.indexOf('=');

                    String  nm = sv.substring(0, ndx);
                    String  vl = sv.substring(ndx + 1);

                    oids.addElement(x500Style.attrNameToOID(nm));
                    values.addElement(vl);
                }

                builder.addMultiValuedRDN(toOIDArray(oids), toValueArray(values));
            }
            else
            {
                builder.addRDN(oid, value);
            }
        }

        return builder.build().getRDNs();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.739 -0500", hash_original_method = "E214B529B1DCDC130AD64AFD64165517", hash_generated_method = "AB8311C45EC1C8ACB4031F1279459043")
    
private static String[] toValueArray(Vector values)
    {
        String[] tmp = new String[values.size()];

        for (int i = 0; i != tmp.length; i++)
        {
            tmp[i] = (String)values.elementAt(i);
        }

        return tmp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.742 -0500", hash_original_method = "C6B3449A8EDEDC2DE359B6D403CFA9E6", hash_generated_method = "D569F0732F3C61FB4907BD4EABBFA85E")
    
private static ASN1ObjectIdentifier[] toOIDArray(Vector oids)
    {
        ASN1ObjectIdentifier[] tmp = new ASN1ObjectIdentifier[oids.size()];

        for (int i = 0; i != tmp.length; i++)
        {
            tmp[i] = (ASN1ObjectIdentifier)oids.elementAt(i);
        }

        return tmp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.745 -0500", hash_original_method = "2B4FA08D7BEC41710260E21E1430C826", hash_generated_method = "A395E196978224D1E3E8BF078B47389D")
    
public static ASN1ObjectIdentifier decodeAttrName(
        String      name,
        Hashtable   lookUp)
    {
        if (Strings.toUpperCase(name).startsWith("OID."))
        {
            return new ASN1ObjectIdentifier(name.substring(4));
        }
        else if (name.charAt(0) >= '0' && name.charAt(0) <= '9')
        {
            return new ASN1ObjectIdentifier(name);
        }

        ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier)lookUp.get(Strings.toLowerCase(name));
        if (oid == null)
        {
            throw new IllegalArgumentException("Unknown object id - " + name + " - passed to distinguished name");
        }

        return oid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.748 -0500", hash_original_method = "135D447AB71FA29E1F47BFE5B59E6000", hash_generated_method = "5B7856AC112F22D5A62A5B20D2A3D67A")
    
public static ASN1Encodable valueFromHexString(
        String  str,
        int     off)
        throws IOException
    {
        str = Strings.toLowerCase(str);
        byte[] data = new byte[(str.length() - off) / 2];
        for (int index = 0; index != data.length; index++)
        {
            char left = str.charAt((index * 2) + off);
            char right = str.charAt((index * 2) + off + 1);

            if (left < 'a')
            {
                data[index] = (byte)((left - '0') << 4);
            }
            else
            {
                data[index] = (byte)((left - 'a' + 10) << 4);
            }
            if (right < 'a')
            {
                data[index] |= (byte)(right - '0');
            }
            else
            {
                data[index] |= (byte)(right - 'a' + 10);
            }
        }

        return ASN1Object.fromByteArray(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.750 -0500", hash_original_method = "4A947950B73C103F62C704A292BF18F7", hash_generated_method = "170E7B16BF70E250634764831293D7F5")
    
public static void appendTypeAndValue(
        StringBuffer          buf,
        AttributeTypeAndValue typeAndValue,
        Hashtable             oidSymbols)
    {
        String  sym = (String)oidSymbols.get(typeAndValue.getType());

        if (sym != null)
        {
            buf.append(sym);
        }
        else
        {
            buf.append(typeAndValue.getType().getId());
        }

        buf.append('=');

        buf.append(valueToString(typeAndValue.getValue()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.753 -0500", hash_original_method = "30AD1CBBB8AB39F951AAF7B8702A500A", hash_generated_method = "0F0D8CE8DC1390A643C41574C271536B")
    
public static String valueToString(ASN1Encodable value)
    {
        StringBuffer vBuf = new StringBuffer();

        if (value instanceof ASN1String && !(value instanceof DERUniversalString))
        {
            String v = ((ASN1String)value).getString();
            if (v.length() > 0 && v.charAt(0) == '#')
            {
                vBuf.append("\\" + v);
            }
            else
            {
                vBuf.append(v);
            }
        }
        else
        {
            vBuf.append("#" + bytesToString(Hex.encode(value.getDERObject().getDEREncoded())));
        }

        int     end = vBuf.length();
        int     index = 0;

        if (vBuf.length() >= 2 && vBuf.charAt(0) == '\\' && vBuf.charAt(1) == '#')
        {
            index += 2;
        }

        while (index != end)
        {
            if ((vBuf.charAt(index) == ',')
               || (vBuf.charAt(index) == '"')
               || (vBuf.charAt(index) == '\\')
               || (vBuf.charAt(index) == '+')
               || (vBuf.charAt(index) == '=')
               || (vBuf.charAt(index) == '<')
               || (vBuf.charAt(index) == '>')
               || (vBuf.charAt(index) == ';'))
            {
                vBuf.insert(index, "\\");
                index++;
                end++;
            }

            index++;
        }

        return vBuf.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.756 -0500", hash_original_method = "B6C7D564A6D3D0BE9A656CE0C6CFB554", hash_generated_method = "5BD375269EED1A37250371DA6FF695D6")
    
private static String bytesToString(
        byte[] data)
    {
        char[]  cs = new char[data.length];

        for (int i = 0; i != cs.length; i++)
        {
            cs[i] = (char)(data[i] & 0xff);
        }

        return new String(cs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.758 -0500", hash_original_method = "8D7080B4062A91F949A92A478FFA85DE", hash_generated_method = "9E4C1E1F59CEAD447BFDBE6BC9A760FE")
    
public static String canonicalize(String s)
    {
        String value = Strings.toLowerCase(s.trim());

        if (value.length() > 0 && value.charAt(0) == '#')
        {
            DERObject obj = decodeObject(value);

            if (obj instanceof ASN1String)
            {
                value = Strings.toLowerCase(((ASN1String)obj).getString().trim());
            }
        }

        value = stripInternalSpaces(value);

        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.761 -0500", hash_original_method = "DA9861DC0244404A041AD42C955600B0", hash_generated_method = "A58EA57D2A8246BB9F2AC7E44A284DAD")
    
private static ASN1Object decodeObject(String oValue)
    {
        try
        {
            return ASN1Object.fromByteArray(Hex.decode(oValue.substring(1)));
        }
        catch (IOException e)
        {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.765 -0500", hash_original_method = "1E1DA2E49EB072DAE70813000ABE2315", hash_generated_method = "BE9597E652D462FFC2EE6BD63E91F8C4")
    
public static String stripInternalSpaces(
        String str)
    {
        StringBuffer res = new StringBuffer();

        if (str.length() != 0)
        {
            char c1 = str.charAt(0);

            res.append(c1);

            for (int k = 1; k < str.length(); k++)
            {
                char c2 = str.charAt(k);
                if (!(c1 == ' ' && c2 == ' '))
                {
                    res.append(c2);
                }
                c1 = c2;
            }
        }

        return res.toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.478 -0400", hash_original_method = "A1DC5483E864AC4E5F00EC3185D86BA1", hash_generated_method = "A1DC5483E864AC4E5F00EC3185D86BA1")
    public IETFUtils ()
    {
        //Synthesized constructor
    }

    
}

