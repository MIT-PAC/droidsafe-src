package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC2ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.433 -0400", hash_original_field = "427C938A30E3C42A31441455E9C82C81", hash_generated_field = "AC6861D88456BB5E6B8CBF2574EE2E67")

    private int effectiveKeyBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.433 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.433 -0400", hash_original_method = "981D6EF1132B7EAC7AA89C92203BA1A2", hash_generated_method = "2C7506A4650CED37076AB6ECD0B6B611")
    public  RC2ParameterSpec(int effectiveKeyBits) {
        this.effectiveKeyBits = effectiveKeyBits;
        iv = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.434 -0400", hash_original_method = "66EC02A60547F68FA7875E0B5CB3BCDA", hash_generated_method = "B71AFD46F9FA275B18541CB748B38383")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
    if(iv == null)        
        {
            IllegalArgumentException varAE3874D37D8C60D27DA80215C0C565C2_1423856096 = new IllegalArgumentException("iv == null");
            varAE3874D37D8C60D27DA80215C0C565C2_1423856096.addTaint(taint);
            throw varAE3874D37D8C60D27DA80215C0C565C2_1423856096;
        } 
    if(iv.length < 8)        
        {
            IllegalArgumentException var20FD6B911038D1E945AA0AED39F8474E_1623045186 = new IllegalArgumentException("iv.length < 8");
            var20FD6B911038D1E945AA0AED39F8474E_1623045186.addTaint(taint);
            throw var20FD6B911038D1E945AA0AED39F8474E_1623045186;
        } 
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, 0, this.iv, 0, 8);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.435 -0400", hash_original_method = "F8E908A70E700CBC7624EF366C4425D3", hash_generated_method = "9D477747BB8E643BB5480718EF0E5546")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        addTaint(offset);
    if(iv == null)        
        {
            IllegalArgumentException varAE3874D37D8C60D27DA80215C0C565C2_956810043 = new IllegalArgumentException("iv == null");
            varAE3874D37D8C60D27DA80215C0C565C2_956810043.addTaint(taint);
            throw varAE3874D37D8C60D27DA80215C0C565C2_956810043;
        } 
    if(iv.length - offset < 8)        
        {
            IllegalArgumentException var8E7C769CD910E2348E5D6460F43554BB_1549454703 = new IllegalArgumentException("iv.length - offset < 8");
            var8E7C769CD910E2348E5D6460F43554BB_1549454703.addTaint(taint);
            throw var8E7C769CD910E2348E5D6460F43554BB_1549454703;
        } 
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, offset, this.iv, 0, 8);
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.435 -0400", hash_original_method = "1ACACD69299A3BB8DC7106B43ACB3CF4", hash_generated_method = "9EC7B6B8C0EB0714CF6DE7BB57BD702A")
    public int getEffectiveKeyBits() {
        int var427C938A30E3C42A31441455E9C82C81_1183960011 = (effectiveKeyBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349704889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1349704889;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.436 -0400", hash_original_method = "462AE8FB0DAC66A27C950BA3964C530D", hash_generated_method = "698212C27C4D01B3C6DD81B4D16F05D5")
    public byte[] getIV() {
    if(iv == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1745563633 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_355517761 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_355517761;
        } 
        byte[] result = new byte[iv.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1669052181 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1785439010 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1785439010;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.436 -0400", hash_original_method = "054E5AEB74111DBC68AB791919DED60A", hash_generated_method = "9E7F86E3733D22192F391EAF2F3202B7")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_929695279 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009230484 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009230484;
        } 
    if(!(obj instanceof RC2ParameterSpec))        
        {
            boolean var68934A3E9455FA72420237EB05902327_750667538 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742904390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742904390;
        } 
        RC2ParameterSpec ps = (RC2ParameterSpec) obj;
        boolean var99DF152CFADCA453B2B5AAD6D1D03071_405326165 = ((effectiveKeyBits == ps.effectiveKeyBits)
            && (Arrays.equals(iv, ps.iv)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913500673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913500673;
        
        
            
        
        
            
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.437 -0400", hash_original_method = "006AB7CB427D2D70245D98F537F7CF42", hash_generated_method = "E3528A1C8672BC8E92DDA12711640C65")
    @Override
    public int hashCode() {
        int result = effectiveKeyBits;
    if(iv == null)        
        {
            int varB4A88417B3D0170D754C647C30B7216A_1859409977 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468125896 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468125896;
        } 
for(byte element : iv)
        {
            result += element;
        } 
        int varB4A88417B3D0170D754C647C30B7216A_1990002523 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356075062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356075062;
        
        
        
            
        
        
            
        
        
    }

    
}

