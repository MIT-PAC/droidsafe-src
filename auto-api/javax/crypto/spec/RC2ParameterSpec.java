package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC2ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.324 -0400", hash_original_field = "427C938A30E3C42A31441455E9C82C81", hash_generated_field = "AC6861D88456BB5E6B8CBF2574EE2E67")

    private int effectiveKeyBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.325 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.325 -0400", hash_original_method = "981D6EF1132B7EAC7AA89C92203BA1A2", hash_generated_method = "2C7506A4650CED37076AB6ECD0B6B611")
    public  RC2ParameterSpec(int effectiveKeyBits) {
        this.effectiveKeyBits = effectiveKeyBits;
        iv = null;
        // ---------- Original Method ----------
        //this.effectiveKeyBits = effectiveKeyBits;
        //iv = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.325 -0400", hash_original_method = "66EC02A60547F68FA7875E0B5CB3BCDA", hash_generated_method = "86AC89E0B83C18D442FF817663A7B26F")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv.length < 8");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.326 -0400", hash_original_method = "F8E908A70E700CBC7624EF366C4425D3", hash_generated_method = "A3174DD80DD2297893235C2CD2625C4D")
    public  RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iv.length - offset < 8");
        } //End block
        this.effectiveKeyBits = effectiveKeyBits;
        this.iv = new byte[8];
        System.arraycopy(iv, offset, this.iv, 0, 8);
        addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.336 -0400", hash_original_method = "1ACACD69299A3BB8DC7106B43ACB3CF4", hash_generated_method = "90051CFD0E3103499452502DF4D293B1")
    public int getEffectiveKeyBits() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064188640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064188640;
        // ---------- Original Method ----------
        //return effectiveKeyBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.336 -0400", hash_original_method = "462AE8FB0DAC66A27C950BA3964C530D", hash_generated_method = "4137A2756F97BB8762678589E25829FA")
    public byte[] getIV() {
        byte[] result;
        result = new byte[iv.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1282078884 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1282078884;
        // ---------- Original Method ----------
        //if (iv == null) {
            //return null;
        //}
        //byte[] result = new byte[iv.length];
        //System.arraycopy(iv, 0, result, 0, iv.length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.337 -0400", hash_original_method = "054E5AEB74111DBC68AB791919DED60A", hash_generated_method = "848158AFB395781AE9FCDE64CE525B91")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_396880610 = (obj == this);
        } //End collapsed parenthetic
        RC2ParameterSpec ps;
        ps = (RC2ParameterSpec) obj;
        boolean var814504581046743AB1E1B847E14CE89F_589601021 = ((effectiveKeyBits == ps.effectiveKeyBits)
            && (Arrays.equals(iv, ps.iv)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158723638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158723638;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.357 -0400", hash_original_method = "006AB7CB427D2D70245D98F537F7CF42", hash_generated_method = "E0E8BD43E9BDF58C49847D140DA04B83")
    @Override
    public int hashCode() {
        int result;
        result = effectiveKeyBits;
        {
            byte element = iv[0];
            {
                result += element;
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287649604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287649604;
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

