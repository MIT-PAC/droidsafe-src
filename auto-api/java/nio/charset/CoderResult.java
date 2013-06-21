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
    private int type;
    private int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.248 -0400", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "8020233159D52FA0F16780485E311269")
    @DSModeled(DSC.SAFE)
    private CoderResult(int type, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(type);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.249 -0400", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "8512267AC0677E5E3892E68634EA9993")
    @DSModeled(DSC.SAFE)
    public boolean isUnderflow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.249 -0400", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "96F727B67C7CE5744483231BB550B072")
    @DSModeled(DSC.SAFE)
    public boolean isError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT
                //|| this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.249 -0400", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "B172EC35E2F59FC089F70C685BC44557")
    @DSModeled(DSC.SAFE)
    public boolean isMalformed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.249 -0400", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "0CD05DAF875AC9DE83DA7CAC93B8CEAC")
    @DSModeled(DSC.SAFE)
    public boolean isOverflow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_OVERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.250 -0400", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "34EB0B01A7C3AD4A5425C21C0F55C168")
    @DSModeled(DSC.SAFE)
    public boolean isUnmappable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.250 -0400", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "059D210714D0B77FF1F400E873DBBFF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("length meaningless for " + toString());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR) {
            //return this.length;
        //}
        //throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.251 -0400", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "9CC9D9B5F697ABA775A97FBE154CCC83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.253 -0400", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "52E1DC9C202E597E568E09D8F2178AE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var802632AAFA98609B975C47B8B34846ED_283109141 = (getClass().getName() + "[" + dsc + "]");
        return dsTaint.getTaintString();
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

    
    private static final int TYPE_UNDERFLOW = 1;
    private static final int TYPE_OVERFLOW = 2;
    private static final int TYPE_MALFORMED_INPUT = 3;
    private static final int TYPE_UNMAPPABLE_CHAR = 4;
    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
}

