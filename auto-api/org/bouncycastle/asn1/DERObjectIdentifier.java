package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class DERObjectIdentifier extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.591 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "67D18ED1400CD458B308847E018D0637")

    String identifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.592 -0400", hash_original_method = "41784C2F0BEC0E535BBC46B058BAD130", hash_generated_method = "9C40499EDB26A62DF75BBC207E6FB40A")
      DERObjectIdentifier(
        byte[]  bytes) {
        StringBuffer objId = new StringBuffer();
        long value = 0;
        BigInteger bigValue = null;
        boolean first = true;
        {
            int i = 0;
            {
                int b = bytes[i] & 0xff;
                {
                    value = value * 128 + (b & 0x7f);
                    {
                        {
                            //Begin case 0 
                            objId.append('0');
                            //End case 0 
                            //Begin case 1 
                            objId.append('1');
                            //End case 1 
                            //Begin case 1 
                            value -= 40;
                            //End case 1 
                            //Begin case default 
                            objId.append('2');
                            //End case default 
                            //Begin case default 
                            value -= 80;
                            //End case default 
                            first = false;
                        } //End block
                        objId.append('.');
                        objId.append(value);
                        value = 0;
                    } //End block
                } //End block
                {
                    {
                        bigValue = BigInteger.valueOf(value);
                    } //End block
                    bigValue = bigValue.shiftLeft(7);
                    bigValue = bigValue.or(BigInteger.valueOf(b & 0x7f));
                    {
                        objId.append('.');
                        objId.append(bigValue);
                        bigValue = null;
                        value = 0;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        this.identifier = objId.toString().intern();
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.593 -0400", hash_original_method = "475B203FC54A32C4FE512A1ADD61E543", hash_generated_method = "B4C1F82806D422C2D53865C6167500B5")
    public  DERObjectIdentifier(
        String  identifier) {
        {
            boolean varD4FAFFC1BD4AA673DC9F47F3DDC13D57_1954835971 = (!isValidIdentifier(identifier));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string " + identifier + " not an OID");
            } //End block
        } //End collapsed parenthetic
        this.identifier = identifier.intern();
        // ---------- Original Method ----------
        //if (!isValidIdentifier(identifier))
        //{
            //throw new IllegalArgumentException("string " + identifier + " not an OID");
        //}
        //this.identifier = identifier.intern();
    }

    
    public static DERObjectIdentifier getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERObjectIdentifier)
        {
            return (DERObjectIdentifier)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static DERObjectIdentifier getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERObjectIdentifier)
        {
            return getInstance(o);
        }
        else
        {
            return new ASN1ObjectIdentifier(ASN1OctetString.getInstance(obj.getObject()).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.594 -0400", hash_original_method = "9387C33D0DE26CACBA5D2CF5AB6F5FB6", hash_generated_method = "3FEE000BEC774A34156CC35984238DFF")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1707507182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1707507182 = identifier;
        varB4EAC82CA7396A68D541C85D26508E83_1707507182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1707507182;
        // ---------- Original Method ----------
        //return identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.594 -0400", hash_original_method = "7C147E60AEA70A2E84F8C4657E7FBA13", hash_generated_method = "DE185F496FA7AFE6151C0E112FC95BC2")
    private void writeField(
        OutputStream    out,
        long            fieldValue) throws IOException {
        byte[] result = new byte[9];
        int pos = 8;
        result[pos] = (byte)((int)fieldValue & 0x7f);
        {
            fieldValue >>= 7;
            result[--pos] = (byte)((int)fieldValue & 0x7f | 0x80);
        } //End block
        out.write(result, pos, 9 - pos);
        addTaint(out.getTaint());
        addTaint(fieldValue);
        // ---------- Original Method ----------
        //byte[] result = new byte[9];
        //int pos = 8;
        //result[pos] = (byte)((int)fieldValue & 0x7f);
        //while (fieldValue >= (1L << 7))
        //{
            //fieldValue >>= 7;
            //result[--pos] = (byte)((int)fieldValue & 0x7f | 0x80);
        //}
        //out.write(result, pos, 9 - pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.595 -0400", hash_original_method = "58F2C435CDACAD8814E2A1351775DAC9", hash_generated_method = "822650BBFCBA402EAEFAEC96A4DA58FE")
    private void writeField(
        OutputStream    out,
        BigInteger      fieldValue) throws IOException {
        int byteCount = (fieldValue.bitLength()+6)/7;
        {
            out.write(0);
        } //End block
        {
            BigInteger tmpValue = fieldValue;
            byte[] tmp = new byte[byteCount];
            {
                int i = byteCount-1;
                {
                    tmp[i] = (byte) ((tmpValue.intValue() & 0x7f) | 0x80);
                    tmpValue = tmpValue.shiftRight(7);
                } //End block
            } //End collapsed parenthetic
            tmp[byteCount-1] &= 0x7f;
            out.write(tmp);
        } //End block
        addTaint(out.getTaint());
        addTaint(fieldValue.getTaint());
        // ---------- Original Method ----------
        //int byteCount = (fieldValue.bitLength()+6)/7;
        //if (byteCount == 0) 
        //{
            //out.write(0);
        //}  
        //else 
        //{
            //BigInteger tmpValue = fieldValue;
            //byte[] tmp = new byte[byteCount];
            //for (int i = byteCount-1; i >= 0; i--) 
            //{
                //tmp[i] = (byte) ((tmpValue.intValue() & 0x7f) | 0x80);
                //tmpValue = tmpValue.shiftRight(7); 
            //}
            //tmp[byteCount-1] &= 0x7f;
            //out.write(tmp);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.596 -0400", hash_original_method = "ECFD3ADA5852656A886183CB7FE8CA3F", hash_generated_method = "C814997571F2D11801297BAE70290132")
     void encode(
        DEROutputStream out) throws IOException {
        OIDTokenizer tok = new OIDTokenizer(identifier);
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        writeField(bOut, 
                    Integer.parseInt(tok.nextToken()) * 40
                    + Integer.parseInt(tok.nextToken()));
        {
            boolean var89512C99A8AC3353295C5F4DBB97E3D6_399582636 = (tok.hasMoreTokens());
            {
                String token = tok.nextToken();
                {
                    boolean var687605A3A0DF464929B96AA74CA43050_509132261 = (token.length() < 18);
                    {
                        writeField(bOut, Long.parseLong(token));
                    } //End block
                    {
                        writeField(bOut, new BigInteger(token));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(OBJECT_IDENTIFIER, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //OIDTokenizer            tok = new OIDTokenizer(identifier);
        //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        //DEROutputStream         dOut = new DEROutputStream(bOut);
        //writeField(bOut, 
                    //Integer.parseInt(tok.nextToken()) * 40
                    //+ Integer.parseInt(tok.nextToken()));
        //while (tok.hasMoreTokens())
        //{
            //String token = tok.nextToken();
            //if (token.length() < 18) 
            //{
                //writeField(bOut, Long.parseLong(token));
            //}
            //else
            //{
                //writeField(bOut, new BigInteger(token));
            //}
        //}
        //dOut.close();
        //byte[]  bytes = bOut.toByteArray();
        //out.writeEncoded(OBJECT_IDENTIFIER, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.597 -0400", hash_original_method = "F84420975A0078554FCD832859033A65", hash_generated_method = "5117296EF96FE80FCB8E71E816B522D8")
    public int hashCode() {
        int var8978AA144A14510CB1789B7CB4B8CE9F_383411996 = (identifier.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559952923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559952923;
        // ---------- Original Method ----------
        //return identifier.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.597 -0400", hash_original_method = "0655D55E620898111D8D6A0724E88908", hash_generated_method = "50C67381FEF0A3CC67EB447C6BDA29F1")
     boolean asn1Equals(
        DERObject  o) {
        boolean var749A4FD9858CC8128C3F813A12C6F443_1013150521 = (identifier.equals(((DERObjectIdentifier)o).identifier));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136607825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136607825;
        // ---------- Original Method ----------
        //if (!(o instanceof DERObjectIdentifier))
        //{
            //return false;
        //}
        //return identifier.equals(((DERObjectIdentifier)o).identifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.597 -0400", hash_original_method = "7A5AF873124B543657B1C40A56842B0C", hash_generated_method = "82CEE6F57B8F71231D4E33392124C2B8")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_430371944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_430371944 = getId();
        varB4EAC82CA7396A68D541C85D26508E83_430371944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_430371944;
        // ---------- Original Method ----------
        //return getId();
    }

    
    private static boolean isValidIdentifier(
        String identifier) {
        if (identifier.length() < 3
            || identifier.charAt(1) != '.')
        {
            return false;
        }
        char first = identifier.charAt(0);
        if (first < '0' || first > '2')
        {
            return false;
        }
        boolean periodAllowed = false;
        for (int i = identifier.length() - 1; i >= 2; i--)
        {
            char ch = identifier.charAt(i);
            if ('0' <= ch && ch <= '9')
            {
                periodAllowed = true;
                continue;
            }
            if (ch == '.')
            {
                if (!periodAllowed)
                {
                    return false;
                }
                periodAllowed = false;
                continue;
            }
            return false;
        }
        return periodAllowed;
    }

    
}

