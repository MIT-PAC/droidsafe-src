package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERIA5String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.508 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.509 -0400", hash_original_method = "6D45D0BD0357770FD3E912C483EA28A2", hash_generated_method = "35891E9AA1E5ACC02EDB4FAE0AC34CA8")
    public  DERIA5String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.509 -0400", hash_original_method = "E43446DCFA1E12AD62CEF41AA43F405C", hash_generated_method = "1148FF261F792216188D48ADE936F9C9")
    public  DERIA5String(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.510 -0400", hash_original_method = "116E9F3E400BAA7DE0ED2CEAD98AD4A9", hash_generated_method = "E4F4EF84D145EC894D9082D9E5C6F5B0")
    public  DERIA5String(
        String   string,
        boolean  validate) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string cannot be null");
        } 
        {
            boolean varB801B1D718CB8DA1FEFA96343D82FB76_295964456 = (validate && !isIA5String(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } 
        } 
        this.string = string;
        addTaint(validate);
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERIA5String getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERIA5String)
        {
            return (DERIA5String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERIA5String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERIA5String)
        {
            return getInstance(o);
        }
        else
        {
            return new DERIA5String(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.515 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "26F91638EA0F94C899194770B55DE608")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1300047749 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1300047749 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1300047749.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1300047749;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.516 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "244B563898940B9B56B19046889A8551")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_295067306 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_295067306 = string;
        varB4EAC82CA7396A68D541C85D26508E83_295067306.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_295067306;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.517 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "5B7B819CA7F8C31E10130EE33EB4B222")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_395930211 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_395930211;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.517 -0400", hash_original_method = "81A044D942E61187B7BC9BD1DB599BBA", hash_generated_method = "90F8FE9528179B4CE3890909112CE1A4")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(IA5_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.517 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "8CAAEC27E28D50715CEE16B98B0ABA52")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1067797414 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127090157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127090157;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.518 -0400", hash_original_method = "9B52498F79C21F529133E97FFA41DA30", hash_generated_method = "F019F6C7B9EA03C74D57D932E65758FB")
     boolean asn1Equals(
        DERObject  o) {
        DERIA5String s = (DERIA5String)o;
        boolean varEE57EA262042757EB3692934946962F3_541809019 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575119319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575119319;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isIA5String(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
        }
        return true;
    }

    
}

