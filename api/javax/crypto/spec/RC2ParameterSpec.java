package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC2ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.407 -0400", hash_original_field = "427C938A30E3C42A31441455E9C82C81", hash_generated_field = "AC6861D88456BB5E6B8CBF2574EE2E67")

    private int effectiveKeyBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.407 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.408 -0400", hash_original_method = "981D6EF1132B7EAC7AA89C92203BA1A2", hash_generated_method = "2C7506A4650CED37076AB6ECD0B6B611")
    public  RC2ParameterSpec(int effectiveKeyBits) {
        this.effectiveKeyBits = effectiveKeyBits;
        iv = null;
        // ---------- Original Method ----------
        //this.effectiveKeyBits = effectiveKeyBits;
        //iv = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.410 -0400", hash_original_method = "66EC02A60547F68FA7875E0B5CB3BCDA", hash_generated_method = "4FB0F2C9ADB92F86372625B21D977FE7")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
        if(iv == null)        
        {
            IllegalArgumentException varAE3874D37D8C60D27DA80215C0C565C2_1731256302 = new IllegalArgumentException("iv == null");
            varAE3874D37D8C60D27DA80215C0C565C2_1731256302.addTaint(taint);
            throw varAE3874D37D8C60D27DA80215C0C565C2_1731256302;
        } //End block
        if(iv.length < 8)        
        {
            IllegalArgumentException var20FD6B911038D1E945AA0AED39F8474E_1556378173 = new IllegalArgumentException("iv.length < 8");
            var20FD6B911038D1E945AA0AED39F8474E_1556378173.addTaint(taint);
            throw var20FD6B911038D1E945AA0AED39F8474E_1556378173;
        } //End block
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, 0, this.iv, 0, 8);
        // ---------- Original Method ----------
        //if (iv == null) {
            //throw new IllegalArgumentException("iv == null");
        //}
        //if (iv.length < 8) {
            //throw new IllegalArgumentException("iv.length < 8");
        //}
        //this.effectiveKeyBits = effectiveKeyBits;
        //this.iv = new byte[8];
        //System.arraycopy(iv, 0, this.iv, 0, 8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.412 -0400", hash_original_method = "F8E908A70E700CBC7624EF366C4425D3", hash_generated_method = "4D79C22F70FCCB2E3A65AA5D21B4EE70")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        addTaint(offset);
        if(iv == null)        
        {
            IllegalArgumentException varAE3874D37D8C60D27DA80215C0C565C2_932924753 = new IllegalArgumentException("iv == null");
            varAE3874D37D8C60D27DA80215C0C565C2_932924753.addTaint(taint);
            throw varAE3874D37D8C60D27DA80215C0C565C2_932924753;
        } //End block
        if(iv.length - offset < 8)        
        {
            IllegalArgumentException var8E7C769CD910E2348E5D6460F43554BB_2085292150 = new IllegalArgumentException("iv.length - offset < 8");
            var8E7C769CD910E2348E5D6460F43554BB_2085292150.addTaint(taint);
            throw var8E7C769CD910E2348E5D6460F43554BB_2085292150;
        } //End block
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, offset, this.iv, 0, 8);
        // ---------- Original Method ----------
        //if (iv == null) {
            //throw new IllegalArgumentException("iv == null");
        //}
        //if (iv.length - offset < 8) {
            //throw new IllegalArgumentException("iv.length - offset < 8");
        //}
        //this.effectiveKeyBits = effectiveKeyBits;
        //this.iv = new byte[8];
        //System.arraycopy(iv, offset, this.iv, 0, 8);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.412 -0400", hash_original_method = "1ACACD69299A3BB8DC7106B43ACB3CF4", hash_generated_method = "90266BF14C920D57B792F4C39D1C785A")
    public int getEffectiveKeyBits() {
        int var427C938A30E3C42A31441455E9C82C81_979153973 = (effectiveKeyBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957438136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957438136;
        // ---------- Original Method ----------
        //return effectiveKeyBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.413 -0400", hash_original_method = "462AE8FB0DAC66A27C950BA3964C530D", hash_generated_method = "308A8F77E92197208E05CDA2A2035077")
    public byte[] getIV() {
        if(iv == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1223904879 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1252330499 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1252330499;
        } //End block
        byte[] result = new byte[iv.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_2021242821 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1429788372 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1429788372;
        // ---------- Original Method ----------
        //if (iv == null) {
            //return null;
        //}
        //byte[] result = new byte[iv.length];
        //System.arraycopy(iv, 0, result, 0, iv.length);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.413 -0400", hash_original_method = "054E5AEB74111DBC68AB791919DED60A", hash_generated_method = "276817E2B7BF9F32B5FAF64EF596D093")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_424412144 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740359117 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740359117;
        } //End block
        if(!(obj instanceof RC2ParameterSpec))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1818106316 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191927200 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191927200;
        } //End block
        RC2ParameterSpec ps = (RC2ParameterSpec) obj;
        boolean var99DF152CFADCA453B2B5AAD6D1D03071_744216678 = ((effectiveKeyBits == ps.effectiveKeyBits)
            && (Arrays.equals(iv, ps.iv)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014174463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014174463;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (!(obj instanceof RC2ParameterSpec)) {
            //return false;
        //}
        //RC2ParameterSpec ps = (RC2ParameterSpec) obj;
        //return (effectiveKeyBits == ps.effectiveKeyBits)
            //&& (Arrays.equals(iv, ps.iv));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.414 -0400", hash_original_method = "006AB7CB427D2D70245D98F537F7CF42", hash_generated_method = "982C72D70055C56BA3315B35E4E57281")
    @Override
    public int hashCode() {
        int result = effectiveKeyBits;
        if(iv == null)        
        {
            int varB4A88417B3D0170D754C647C30B7216A_1872431183 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107392378 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_107392378;
        } //End block
for(byte element : iv)
        {
            result += element;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1277829927 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433611692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433611692;
        // ---------- Original Method ----------
        //int result = effectiveKeyBits;
        //if (iv == null) {
            //return result;
        //}
        //for (byte element : iv) {
            //result += element;
        //}
        //return result;
    }

    
}

