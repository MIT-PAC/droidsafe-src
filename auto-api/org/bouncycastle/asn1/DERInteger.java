package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class DERInteger extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.529 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.530 -0400", hash_original_method = "5201B112432D21625783310AA9CEC395", hash_generated_method = "42720B8B1671B205A71B78FEF08907A6")
    public  DERInteger(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.530 -0400", hash_original_method = "52A85FB71F259AF94A4C569903FA35A3", hash_generated_method = "E20D10919EB5723E10B3A8A6847E53D2")
    public  DERInteger(
        BigInteger   value) {
        bytes = value.toByteArray();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.531 -0400", hash_original_method = "742445D1CBEB8EC33F0452B05DE17699", hash_generated_method = "3B54D0B289C9422429FE1852B21923A5")
    public  DERInteger(
        byte[]   bytes) {
        this.bytes = bytes;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERInteger getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERInteger)
        {
            return (DERInteger)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERInteger getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERInteger)
        {
            return getInstance(o);
        }
        else
        {
            return new ASN1Integer(ASN1OctetString.getInstance(obj.getObject()).getOctets());
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.532 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "7A183B30EED0572DBD4A239BB234D7E3")
    public BigInteger getValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1446074192 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1446074192 = new BigInteger(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1446074192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1446074192;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.532 -0400", hash_original_method = "71BDB36FFF593CAF4C9E79EFECF43EBD", hash_generated_method = "902676602CA8D5D905C0D4EE69FE523B")
    public BigInteger getPositiveValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1331894789 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1331894789 = new BigInteger(1, bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1331894789.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1331894789;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.533 -0400", hash_original_method = "01662A631E5ACE6C7726FCC0828E9E63", hash_generated_method = "487316090F805F90D278B906C5C496AA")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(INTEGER, bytes);
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.533 -0400", hash_original_method = "473F358B008FFCD851D487BD1750243E", hash_generated_method = "BE67725681D75E3AAB1BBE2361B17592")
    public int hashCode() {
        int value = 0;
        {
            int i = 0;
            {
                value ^= (bytes[i] & 0xff) << (i % 4);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326175964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326175964;
        
        
        
         
             
         
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.534 -0400", hash_original_method = "A031FF36E08BD1C92CE6416060813BEC", hash_generated_method = "3D3B2C7DBD93DF752D74348C350EAC18")
     boolean asn1Equals(
        DERObject  o) {
        DERInteger other = (DERInteger)o;
        boolean varEED3A374262CB159629A62F0DFEB9CCB_1087547847 = (Arrays.areEqual(bytes, other.bytes));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709889883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709889883;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.537 -0400", hash_original_method = "EFB82D2D11830675F5DB319D1D1561C4", hash_generated_method = "774E2ADF213A0540C740B97C6784CDDE")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_451596609 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_451596609 = getValue().toString();
        varB4EAC82CA7396A68D541C85D26508E83_451596609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_451596609;
        
        
    }

    
}

