package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC2ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.295 -0400", hash_original_field = "427C938A30E3C42A31441455E9C82C81", hash_generated_field = "AC6861D88456BB5E6B8CBF2574EE2E67")

    private int effectiveKeyBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.295 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.296 -0400", hash_original_method = "981D6EF1132B7EAC7AA89C92203BA1A2", hash_generated_method = "2C7506A4650CED37076AB6ECD0B6B611")
    public  RC2ParameterSpec(int effectiveKeyBits) {
        this.effectiveKeyBits = effectiveKeyBits;
        iv = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.296 -0400", hash_original_method = "66EC02A60547F68FA7875E0B5CB3BCDA", hash_generated_method = "86AC89E0B83C18D442FF817663A7B26F")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv.length < 8");
        } 
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, 0, this.iv, 0, 8);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.297 -0400", hash_original_method = "F8E908A70E700CBC7624EF366C4425D3", hash_generated_method = "A3174DD80DD2297893235C2CD2625C4D")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv.length - offset < 8");
        } 
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, offset, this.iv, 0, 8);
        addTaint(offset);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.297 -0400", hash_original_method = "1ACACD69299A3BB8DC7106B43ACB3CF4", hash_generated_method = "18F282BE2D8B06D1156FDA6D47593FDB")
    public int getEffectiveKeyBits() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695000298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695000298;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.298 -0400", hash_original_method = "462AE8FB0DAC66A27C950BA3964C530D", hash_generated_method = "E4385D7A1869CA25F1A41F0CB6482A20")
    public byte[] getIV() {
        byte[] result = new byte[iv.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1310468479 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1310468479;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.298 -0400", hash_original_method = "054E5AEB74111DBC68AB791919DED60A", hash_generated_method = "873494088CA7BE4DCD6E993F065018EE")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_735983021 = (obj == this);
        } 
        RC2ParameterSpec ps = (RC2ParameterSpec) obj;
        boolean var814504581046743AB1E1B847E14CE89F_1396714492 = ((effectiveKeyBits == ps.effectiveKeyBits)
            && (Arrays.equals(iv, ps.iv)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685882077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685882077;
        
        
            
        
        
            
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.301 -0400", hash_original_method = "006AB7CB427D2D70245D98F537F7CF42", hash_generated_method = "A0DC3B9472D7BA20955A734099ACDEE4")
    @Override
    public int hashCode() {
        int result = effectiveKeyBits;
        {
            byte element = iv[0];
            {
                result += element;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198998093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198998093;
        
        
        
            
        
        
            
        
        
    }

    
}

