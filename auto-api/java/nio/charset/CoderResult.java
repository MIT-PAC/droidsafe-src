package java.nio.charset;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

public class CoderResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.994 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.994 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.995 -0400", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "D851FBA0928E192998BF1AF90BB4D1C7")
    private  CoderResult(int type, int length) {
        this.type = type;
        this.length = length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized CoderResult malformedForLength(int length) throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_malformedErrors) {
                CoderResult r = _malformedErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_MALFORMED_INPUT, length);
                    _malformedErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized CoderResult unmappableForLength(int length) throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_unmappableErrors) {
                CoderResult r = _unmappableErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_UNMAPPABLE_CHAR, length);
                    _unmappableErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.996 -0400", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "0A088E902FC3B5BA1FA0A0D57C109C5D")
    public boolean isUnderflow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173777278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173777278;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.996 -0400", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "322A5DB774A048662FBF487C9ECB72CD")
    public boolean isError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121933034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121933034;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.996 -0400", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "B5BEBE901E83F69B189EE0F56E5EAD99")
    public boolean isMalformed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288971261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288971261;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.996 -0400", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "ED0AEEF443D8640290B3F2BC7BB74639")
    public boolean isOverflow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130944382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130944382;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.997 -0400", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "B31C7E8EB6028135EC05517ED5765BDF")
    public boolean isUnmappable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631480977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_631480977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.997 -0400", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "DBD74B9F15E890B12093B558E67B4FC8")
    public int length() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("length meaningless for " + toString());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554026394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554026394;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.997 -0400", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "9CC9D9B5F697ABA775A97FBE154CCC83")
    public void throwException() throws BufferUnderflowException,
            BufferOverflowException, UnmappableCharacterException,
            MalformedInputException, CharacterCodingException {
        
        if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        
        
        if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        
        
        if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(this.length);
        
        
        if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(this.length);
        
        
        if (DroidSafeAndroidRuntime.control) throw new CharacterCodingException();
        
        
        
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "B171209D5785D3FC4357610D55D2788D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1955482884 = null; 
        String dsc = null;
        
        dsc = "UNDERFLOW error";
        
        
        dsc = "OVERFLOW error";
        
        
        dsc = "Unmappable-character error with erroneous input length "
                        + this.length;
        
        
        dsc = "Malformed-input error with erroneous input length "
                        + this.length;
        
        
        dsc = "";
        
        varB4EAC82CA7396A68D541C85D26508E83_1955482884 = getClass().getName() + "[" + dsc + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1955482884.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1955482884;
        
        
        
            
                
                
            
                
                
            
                
                        
                
            
                
                        
                
            
                
                
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "03C7B4AF933F2D6A5DC38128ED384A7F", hash_generated_field = "5686A0817753AB01F5538639E94A3DB2")

    private static final int TYPE_UNDERFLOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "AA19E78578F65F6E4154CA9CA90F8A18", hash_generated_field = "B613814D9EB59828D84474AB56824F80")

    private static final int TYPE_OVERFLOW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "095E81878478A77975586FED87B54B03", hash_generated_field = "CEE082D95D99A5E2E7B86BB6C60A7BA8")

    private static final int TYPE_MALFORMED_INPUT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "D840678E9B4F7C36570C32A907A5301B", hash_generated_field = "257A8E9EEAB537C120C9FA5C89913FBC")

    private static final int TYPE_UNMAPPABLE_CHAR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "B6A5F62DD485012C170A1DF7064B9894", hash_generated_field = "CED3245C886E68DD4C6FB67AC5FE6EEB")

    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "AAB07B6D0921816A706E308D4C7DF8C8", hash_generated_field = "17DE0F56BB1CAD86851E26DC64EBFBED")

    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "FFF836352D82A42A049116351B8E49BD", hash_generated_field = "154F7BAB5D229D86020DFDB6943A833A")

    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.998 -0400", hash_original_field = "76575679E1B34545FAB2DD4443B63583", hash_generated_field = "4A3051E3D68AB1D3FECCCF1B94957C66")

    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
}

