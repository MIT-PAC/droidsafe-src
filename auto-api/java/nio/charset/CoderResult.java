package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

public class CoderResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.725 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.725 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.725 -0400", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "D851FBA0928E192998BF1AF90BB4D1C7")
    private  CoderResult(int type, int length) {
        this.type = type;
        this.length = length;
        // ---------- Original Method ----------
        //this.type = type;
        //this.length = length;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.726 -0400", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "6E8692A30A91DA317F5F37A557E72154")
    public boolean isUnderflow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467233975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467233975;
        // ---------- Original Method ----------
        //return this.type == TYPE_UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.726 -0400", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "55D523F2CA853C806733DCD16976CE26")
    public boolean isError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137693396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137693396;
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT
                //|| this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.733 -0400", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "F2FC22CDB10374AE8DC227FE9980BBF8")
    public boolean isMalformed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130034775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130034775;
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.755 -0400", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "AC9BCC919A400D33BA1204DDD35B8470")
    public boolean isOverflow() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767262280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_767262280;
        // ---------- Original Method ----------
        //return this.type == TYPE_OVERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.756 -0400", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "CB74D75A2CEF1B129C50E3135EF6885C")
    public boolean isUnmappable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945452566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945452566;
        // ---------- Original Method ----------
        //return this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.756 -0400", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "61714F3314B54D21CB9C84738E602325")
    public int length() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("length meaningless for " + toString());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504192923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504192923;
        // ---------- Original Method ----------
        //if (this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR) {
            //return this.length;
        //}
        //throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.756 -0400", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "9CC9D9B5F697ABA775A97FBE154CCC83")
    public void throwException() throws BufferUnderflowException,
            BufferOverflowException, UnmappableCharacterException,
            MalformedInputException, CharacterCodingException {
        //Begin case TYPE_UNDERFLOW 
        if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        //End case TYPE_UNDERFLOW 
        //Begin case TYPE_OVERFLOW 
        if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        //End case TYPE_OVERFLOW 
        //Begin case TYPE_UNMAPPABLE_CHAR 
        if (DroidSafeAndroidRuntime.control) throw new UnmappableCharacterException(this.length);
        //End case TYPE_UNMAPPABLE_CHAR 
        //Begin case TYPE_MALFORMED_INPUT 
        if (DroidSafeAndroidRuntime.control) throw new MalformedInputException(this.length);
        //End case TYPE_MALFORMED_INPUT 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new CharacterCodingException();
        //End case default 
        // ---------- Original Method ----------
        //switch (this.type) {
            //case TYPE_UNDERFLOW:
                //throw new BufferUnderflowException();
            //case TYPE_OVERFLOW:
                //throw new BufferOverflowException();
            //case TYPE_UNMAPPABLE_CHAR:
                //throw new UnmappableCharacterException(this.length);
            //case TYPE_MALFORMED_INPUT:
                //throw new MalformedInputException(this.length);
            //default:
                //throw new CharacterCodingException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.757 -0400", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "99AF3B26EAB8F09956E4C133B7036032")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_542812176 = null; //Variable for return #1
        String dsc;
        dsc = null;
        //Begin case TYPE_UNDERFLOW 
        dsc = "UNDERFLOW error";
        //End case TYPE_UNDERFLOW 
        //Begin case TYPE_OVERFLOW 
        dsc = "OVERFLOW error";
        //End case TYPE_OVERFLOW 
        //Begin case TYPE_UNMAPPABLE_CHAR 
        dsc = "Unmappable-character error with erroneous input length "
                        + this.length;
        //End case TYPE_UNMAPPABLE_CHAR 
        //Begin case TYPE_MALFORMED_INPUT 
        dsc = "Malformed-input error with erroneous input length "
                        + this.length;
        //End case TYPE_MALFORMED_INPUT 
        //Begin case default 
        dsc = "";
        //End case default 
        varB4EAC82CA7396A68D541C85D26508E83_542812176 = getClass().getName() + "[" + dsc + "]";
        varB4EAC82CA7396A68D541C85D26508E83_542812176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542812176;
        // ---------- Original Method ----------
        //String dsc = null;
        //switch (this.type) {
            //case TYPE_UNDERFLOW:
                //dsc = "UNDERFLOW error";
                //break;
            //case TYPE_OVERFLOW:
                //dsc = "OVERFLOW error";
                //break;
            //case TYPE_UNMAPPABLE_CHAR:
                //dsc = "Unmappable-character error with erroneous input length "
                        //+ this.length;
                //break;
            //case TYPE_MALFORMED_INPUT:
                //dsc = "Malformed-input error with erroneous input length "
                        //+ this.length;
                //break;
            //default:
                //dsc = "";
                //break;
        //}
        //return getClass().getName() + "[" + dsc + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.757 -0400", hash_original_field = "03C7B4AF933F2D6A5DC38128ED384A7F", hash_generated_field = "69EEBC59D182BE896D06018B38B783D8")

    private static int TYPE_UNDERFLOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.757 -0400", hash_original_field = "AA19E78578F65F6E4154CA9CA90F8A18", hash_generated_field = "F98EAAC676C17E11A216F3170FC018EB")

    private static int TYPE_OVERFLOW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "095E81878478A77975586FED87B54B03", hash_generated_field = "64704DDEF068784537B6E17CAF00F7EE")

    private static int TYPE_MALFORMED_INPUT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "D840678E9B4F7C36570C32A907A5301B", hash_generated_field = "576EE4716FADB0306649A3BD8BBC60BA")

    private static int TYPE_UNMAPPABLE_CHAR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "B6A5F62DD485012C170A1DF7064B9894", hash_generated_field = "CED3245C886E68DD4C6FB67AC5FE6EEB")

    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "AAB07B6D0921816A706E308D4C7DF8C8", hash_generated_field = "17DE0F56BB1CAD86851E26DC64EBFBED")

    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "FFF836352D82A42A049116351B8E49BD", hash_generated_field = "154F7BAB5D229D86020DFDB6943A833A")

    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.758 -0400", hash_original_field = "76575679E1B34545FAB2DD4443B63583", hash_generated_field = "4A3051E3D68AB1D3FECCCF1B94957C66")

    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
}

