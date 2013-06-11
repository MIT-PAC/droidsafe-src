package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

public class CoderResult {
    private static final int TYPE_UNDERFLOW = 1;
    private static final int TYPE_OVERFLOW = 2;
    private static final int TYPE_MALFORMED_INPUT = 3;
    private static final int TYPE_UNMAPPABLE_CHAR = 4;
    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
    private final int type;
    private final int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "7B0C2B560DB9F60DDA471F4D4D3E46B4")
    @DSModeled(DSC.SAFE)
    private CoderResult(int type, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.type = type;
        //this.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "32B9309C5888D5D441E10DB420683F91", hash_generated_method = "EA5ABC13387F1533A05FEB74F9C87F72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "BBA6EC87D4C3AA6AD9F0D4B623871AE8", hash_generated_method = "D790B3ABAD493C64B831394CF1B5AB81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "6F6D9E910920F52588C11A780FF25C3C")
    @DSModeled(DSC.SAFE)
    public boolean isUnderflow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_UNDERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "5B408965E9380B83974693526F55C1AF")
    @DSModeled(DSC.SAFE)
    public boolean isError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT
                //|| this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "93FCE9F9F0A65AD2722395068ECF698A")
    @DSModeled(DSC.SAFE)
    public boolean isMalformed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "F6748B297E579B44B443EE37AF199E28")
    @DSModeled(DSC.SAFE)
    public boolean isOverflow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_OVERFLOW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "916EAB3A2BACC6E0D4603716DCBA265A")
    @DSModeled(DSC.SAFE)
    public boolean isUnmappable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.558 -0400", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "9AD45DBF481F4943E7E28E6DE4F4D03C")
    @DSModeled(DSC.SAFE)
    public int length() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("length meaningless for " + toString());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR) {
            //return this.length;
        //}
        //throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.559 -0400", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "38ED6D80EA44992FC5FC3DB43EE459BA")
    @DSModeled(DSC.SAFE)
    public void throwException() throws BufferUnderflowException,
            BufferOverflowException, UnmappableCharacterException,
            MalformedInputException, CharacterCodingException {
        //Begin case TYPE_UNDERFLOW 
        throw new BufferUnderflowException();
        //End case TYPE_UNDERFLOW 
        //Begin case TYPE_OVERFLOW 
        throw new BufferOverflowException();
        //End case TYPE_OVERFLOW 
        //Begin case TYPE_UNMAPPABLE_CHAR 
        throw new UnmappableCharacterException(this.length);
        //End case TYPE_UNMAPPABLE_CHAR 
        //Begin case TYPE_MALFORMED_INPUT 
        throw new MalformedInputException(this.length);
        //End case TYPE_MALFORMED_INPUT 
        //Begin case default 
        throw new CharacterCodingException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.559 -0400", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "96447EDDC91422AC7D56D4593CBB4B2C")
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
        String var802632AAFA98609B975C47B8B34846ED_733831480 = (getClass().getName() + "[" + dsc + "]");
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

    
}


