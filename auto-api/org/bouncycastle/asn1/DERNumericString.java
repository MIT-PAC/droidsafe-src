package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERNumericString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.554 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.554 -0400", hash_original_method = "68F5D78267A661375BFA3ED79E149992", hash_generated_method = "78B024605EFEACE188D22A41742E5050")
    public  DERNumericString(
        byte[]   string) {
        char[] cs = new char[string.length];
        {
            int i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } 
        } 
        this.string = new String(cs);
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.555 -0400", hash_original_method = "4A4CC31A466FEB81F134844B7BA257FB", hash_generated_method = "F68CB3283C8D4442C3B0A799F975D5BD")
    public  DERNumericString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.555 -0400", hash_original_method = "E352C3D2266CB71465C2437206485D10", hash_generated_method = "30529F5E3958AE3336AC9B4AA51374C7")
    public  DERNumericString(
        String   string,
        boolean  validate) {
        {
            boolean varA832D522550617E6474D96A174BFFC39_1073835095 = (validate && !isNumericString(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } 
        } 
        this.string = string;
        addTaint(validate);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERNumericString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERNumericString)
        {
            return (DERNumericString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERNumericString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERNumericString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERNumericString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.557 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "2429D317FA604346FCCBF9F0126D0E5D")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1552915533 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1552915533 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1552915533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1552915533;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.557 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "E80A3190CD77450494AA041DB665C439")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1268632315 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1268632315 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1268632315.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1268632315;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.558 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "0BCFC014CDFD26F6A28754608C811986")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_654255687 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_654255687;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.558 -0400", hash_original_method = "9CAFE2F99C4AA1A810005CA2021DBA5F", hash_generated_method = "35A32FE8EBB6FD07F8E3CC34B44D1432")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(NUMERIC_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.559 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "F4BA7425EE87D3539E2D31FD52EEB9EA")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1214003051 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145250715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145250715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.560 -0400", hash_original_method = "8BA017E030540263DAC8EBF952EA3B45", hash_generated_method = "9FE1CB70DC62E0B00B2CE0668602F484")
     boolean asn1Equals(
        DERObject  o) {
        DERNumericString s = (DERNumericString)o;
        boolean varEE57EA262042757EB3692934946962F3_446442375 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723235152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723235152;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNumericString(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }
            return false;
        }
        return true;
    }

    
}

