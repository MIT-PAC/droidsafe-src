package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DERObjectIdentifier extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.438 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "67D18ED1400CD458B308847E018D0637")

    String identifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.440 -0400", hash_original_method = "41784C2F0BEC0E535BBC46B058BAD130", hash_generated_method = "B2F120DC83F6BBA423515BDE568CAF9E")
      DERObjectIdentifier(
        byte[]  bytes) {
        addTaint(bytes[0]);
        StringBuffer objId = new StringBuffer();
        long value = 0;
        BigInteger bigValue = null;
        boolean first = true;
for(int i = 0;i != bytes.length;i++)
        {
            int b = bytes[i] & 0xff;
            if(value < 0x80000000000000L)            
            {
                value = value * 128 + (b & 0x7f);
                if((b & 0x80) == 0)                
                {
                    if(first)                    
                    {
switch((int)value / 40){
                        case 0:
                        objId.append('0');
                        break;
                        case 1:
                        objId.append('1');
                        value -= 40;
                        break;
                        default:
                        objId.append('2');
                        value -= 80;
}                        first = false;
                    } //End block
                    objId.append('.');
                    objId.append(value);
                    value = 0;
                } //End block
            } //End block
            else
            {
                if(bigValue == null)                
                {
                    bigValue = BigInteger.valueOf(value);
                } //End block
                bigValue = bigValue.shiftLeft(7);
                bigValue = bigValue.or(BigInteger.valueOf(b & 0x7f));
                if((b & 0x80) == 0)                
                {
                    objId.append('.');
                    objId.append(bigValue);
                    bigValue = null;
                    value = 0;
                } //End block
            } //End block
        } //End block
        this.identifier = objId.toString().intern();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.442 -0400", hash_original_method = "475B203FC54A32C4FE512A1ADD61E543", hash_generated_method = "C3CDBC30502A9172F58D23D9D9F9A3CA")
    public  DERObjectIdentifier(
        String  identifier) {
        if(!isValidIdentifier(identifier))        
        {
            IllegalArgumentException varCBAE66EC9F9FD20AF7F9B1329CA95DA6_38049697 = new IllegalArgumentException("string " + identifier + " not an OID");
            varCBAE66EC9F9FD20AF7F9B1329CA95DA6_38049697.addTaint(taint);
            throw varCBAE66EC9F9FD20AF7F9B1329CA95DA6_38049697;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.443 -0400", hash_original_method = "9387C33D0DE26CACBA5D2CF5AB6F5FB6", hash_generated_method = "48CBF8C7ADF518AFECC0877EADB7E913")
    public String getId() {
String var5778A82547164F0256F955B75BC8D996_810465090 =         identifier;
        var5778A82547164F0256F955B75BC8D996_810465090.addTaint(taint);
        return var5778A82547164F0256F955B75BC8D996_810465090;
        // ---------- Original Method ----------
        //return identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.444 -0400", hash_original_method = "7C147E60AEA70A2E84F8C4657E7FBA13", hash_generated_method = "07B2A7E93505A9D6A192915DF69B80DA")
    private void writeField(
        OutputStream    out,
        long            fieldValue) throws IOException {
        addTaint(fieldValue);
        addTaint(out.getTaint());
        byte[] result = new byte[9];
        int pos = 8;
        result[pos] = (byte)((int)fieldValue & 0x7f);
        while
(fieldValue >= (1L << 7))        
        {
            fieldValue >>= 7;
            result[--pos] = (byte)((int)fieldValue & 0x7f | 0x80);
        } //End block
        out.write(result, pos, 9 - pos);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.445 -0400", hash_original_method = "58F2C435CDACAD8814E2A1351775DAC9", hash_generated_method = "0F0BBCB1C8C819266FD04B8CED2320B6")
    private void writeField(
        OutputStream    out,
        BigInteger      fieldValue) throws IOException {
        addTaint(fieldValue.getTaint());
        addTaint(out.getTaint());
        int byteCount = (fieldValue.bitLength()+6)/7;
        if(byteCount == 0)        
        {
            out.write(0);
        } //End block
        else
        {
            BigInteger tmpValue = fieldValue;
            byte[] tmp = new byte[byteCount];
for(int i = byteCount-1;i >= 0;i--)
            {
                tmp[i] = (byte) ((tmpValue.intValue() & 0x7f) | 0x80);
                tmpValue = tmpValue.shiftRight(7);
            } //End block
            tmp[byteCount-1] &= 0x7f;
            out.write(tmp);
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.446 -0400", hash_original_method = "ECFD3ADA5852656A886183CB7FE8CA3F", hash_generated_method = "C4A793797058EDA1528B5704E5A956A4")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        OIDTokenizer tok = new OIDTokenizer(identifier);
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DEROutputStream dOut = new DEROutputStream(bOut);
        writeField(bOut, 
                    Integer.parseInt(tok.nextToken()) * 40
                    + Integer.parseInt(tok.nextToken()));
        while
(tok.hasMoreTokens())        
        {
            String token = tok.nextToken();
            if(token.length() < 18)            
            {
                writeField(bOut, Long.parseLong(token));
            } //End block
            else
            {
                writeField(bOut, new BigInteger(token));
            } //End block
        } //End block
        dOut.close();
        byte[] bytes = bOut.toByteArray();
        out.writeEncoded(OBJECT_IDENTIFIER, bytes);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.446 -0400", hash_original_method = "F84420975A0078554FCD832859033A65", hash_generated_method = "8666E8FF5D06355C1B82EEE329105030")
    public int hashCode() {
        int var42FEDBF4FD5BE06E4875C69EBDEDAA3A_1006866346 = (identifier.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674342618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674342618;
        // ---------- Original Method ----------
        //return identifier.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.447 -0400", hash_original_method = "0655D55E620898111D8D6A0724E88908", hash_generated_method = "A4D866E41B2015F88C3894054CB8513A")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERObjectIdentifier))        
        {
            boolean var68934A3E9455FA72420237EB05902327_289520379 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735518508 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735518508;
        } //End block
        boolean var518E4A38B92A3DF0CC7A2D14E8AC4759_2099555580 = (identifier.equals(((DERObjectIdentifier)o).identifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495518841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495518841;
        // ---------- Original Method ----------
        //if (!(o instanceof DERObjectIdentifier))
        //{
            //return false;
        //}
        //return identifier.equals(((DERObjectIdentifier)o).identifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.447 -0400", hash_original_method = "7A5AF873124B543657B1C40A56842B0C", hash_generated_method = "53A14F32B3C35BF9F5AB0FD90D010492")
    public String toString() {
String var5B63C5E61AFD535DA7B77B7EF14D4A91_360962898 =         getId();
        var5B63C5E61AFD535DA7B77B7EF14D4A91_360962898.addTaint(taint);
        return var5B63C5E61AFD535DA7B77B7EF14D4A91_360962898;
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

