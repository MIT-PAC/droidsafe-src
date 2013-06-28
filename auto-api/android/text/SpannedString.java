package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.528 -0400", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "33D79447D7CEC7769A48AF3D60B5F026")
    public  SpannedString(CharSequence source) {
        super(source, 0, source.length());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.528 -0400", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "9FDC29043899630826B8DD71326168FC")
    private  SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.529 -0400", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "BA551110AF1EF8EBC4490721C42B0B97")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_222126006 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_222126006 = new SpannedString(this, start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_222126006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_222126006;
        // ---------- Original Method ----------
        //return new SpannedString(this, start, end);
    }

    
    public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }

    
}

