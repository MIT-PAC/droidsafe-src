package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.318 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "AEF19C0A7530E140588DCBA91FF66D28")

    private byte[] key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.318 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.319 -0400", hash_original_method = "46BCBD91E8C2018C32B65BFBDD14DAE3", hash_generated_method = "CE5D8B8B2979A20CDBFDF1415C912153")
    public  SecretKeySpec(byte[] key, String algorithm) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key.length == 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("algorithm == null");
        } 
        this.algorithm = algorithm;
        this.key = new byte[key.length];
        System.arraycopy(key, 0, this.key, 0, key.length);
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.319 -0400", hash_original_method = "97539A44FE944982691962B490B5A049", hash_generated_method = "1959FB083C106E1B89967E761A1FFBD9")
    public  SecretKeySpec(byte[] key, int offset, int len, String algorithm) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key.length == 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key too short");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("algorithm == null");
        } 
        this.algorithm = algorithm;
        this.key = new byte[len];
        System.arraycopy(key, offset, this.key, 0, len);
        addTaint(offset);
        
        
            
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.320 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "BA6C21A1760FCE9DDA768991A1008C98")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_427445669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_427445669 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_427445669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_427445669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.320 -0400", hash_original_method = "DA06499CB28B740B0D3C21B02311BB46", hash_generated_method = "4EE1371AB6EB5A76EE7778C9DBDCC2E8")
    public String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1198671846 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1198671846 = "RAW";
        varB4EAC82CA7396A68D541C85D26508E83_1198671846.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1198671846;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.321 -0400", hash_original_method = "3F6C1397C7B2518265F6653D66E9AC87", hash_generated_method = "D27252928D617473C4CF55BE9EDDE6F4")
    public byte[] getEncoded() {
        byte[] result = new byte[key.length];
        System.arraycopy(key, 0, result, 0, key.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1300724708 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1300724708;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.323 -0400", hash_original_method = "561BEB6A8D834A34E4D5A2503144263D", hash_generated_method = "29373CAC2CD504892064C22912C7574D")
    @Override
    public int hashCode() {
        int result = algorithm.length();
        {
            byte element = key[0];
            {
                result += element;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961377964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961377964;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.324 -0400", hash_original_method = "7E1551F3E39A01E70E4CFF4FAB6C7AC5", hash_generated_method = "9231DE4A5A5A1ADF8CAB7728DC36E4CF")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1771518207 = (obj == this);
        } 
        SecretKeySpec ks = (SecretKeySpec) obj;
        boolean varF2E5A45CF56A7633348AC78DE027833D_1538301162 = ((algorithm.equalsIgnoreCase(ks.algorithm))
            && (Arrays.equals(key, ks.key)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780344336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780344336;
        
        
            
        
        
            
        
        
        
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.324 -0400", hash_original_field = "5088DB7B37FA60A2A439242D11325983", hash_generated_field = "84F6801DA315233B24EACF83A24EEC96")

    private static final long serialVersionUID = 6577238317307289933L;
}

