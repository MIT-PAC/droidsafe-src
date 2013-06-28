package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.192 -0400", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "20E1E75AF107D5F8E163BB49702D5024")
    public  SpannableString(CharSequence source) {
        super(source, 0, source.length());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.192 -0400", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "E1406CBFEB31160E9AFFB95B74398451")
    private  SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.193 -0400", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "D92FC83AB79BD7ADAF72DC01FE600A6A")
    public void setSpan(Object what, int start, int end, int flags) {
        super.setSpan(what, start, end, flags);
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(flags);
        // ---------- Original Method ----------
        //super.setSpan(what, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.193 -0400", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "522F06EDA081212E675FA60D631FF0E0")
    public void removeSpan(Object what) {
        super.removeSpan(what);
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //super.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:49.194 -0400", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "51F55AE38C37917F65FCB52A84C355E6")
    public final CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_767515345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_767515345 = new SpannableString(this, start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_767515345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767515345;
        // ---------- Original Method ----------
        //return new SpannableString(this, start, end);
    }

    
}

