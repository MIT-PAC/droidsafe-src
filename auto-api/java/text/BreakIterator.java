package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;

public abstract class BreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.770 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "CF9D4EF05D56B4D14C66F6CD08D197A2")

    NativeBreakIterator wrapped;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.774 -0400", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "6FAD5F17105AA87E99EE906D945E3AD3")
    protected  BreakIterator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.774 -0400", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "2D0429676C289659EEA8E15847385912")
      BreakIterator(NativeBreakIterator iterator) {
        wrapped = iterator;
        // ---------- Original Method ----------
        //wrapped = iterator;
    }

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableBreakIteratorLocales();
    }

    
        public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    
        public static BreakIterator getCharacterInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getCharacterInstance(where));
    }

    
        public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    
        public static BreakIterator getLineInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getLineInstance(where));
    }

    
        public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    
        public static BreakIterator getSentenceInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getSentenceInstance(where));
    }

    
        public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    
        public static BreakIterator getWordInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getWordInstance(where));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.794 -0400", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "A296FADCA960148FB39A7081848B1FBC")
    public boolean isBoundary(int offset) {
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_767021283 = (wrapped.isBoundary(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70333003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70333003;
        // ---------- Original Method ----------
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.794 -0400", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "42DF6668CD65E5312DB85EB4DF669534")
    public int preceding(int offset) {
        int var14341653A1F5B35705434E8CE35431DA_1832541803 = (wrapped.preceding(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325342758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325342758;
        // ---------- Original Method ----------
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.794 -0400", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "FBEDC7319143BB7CC131602A892314EE")
    public void setText(String newText) {
        wrapped.setText(newText);
        addTaint(newText.getTaint());
        // ---------- Original Method ----------
        //wrapped.setText(newText);
    }

    
    public abstract int current();

    
    public abstract int first();

    
    public abstract int following(int offset);

    
    public abstract CharacterIterator getText();

    
    public abstract int last();

    
    public abstract int next();

    
    public abstract int next(int n);

    
    public abstract int previous();

    
    public abstract void setText(CharacterIterator newText);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.821 -0400", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "178E1741F827E326B5181A8C5192B1EC")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2049587897 = null; //Variable for return #1
        try 
        {
            BreakIterator cloned;
            cloned = (BreakIterator) super.clone();
            cloned.wrapped = (NativeBreakIterator) wrapped.clone();
            varB4EAC82CA7396A68D541C85D26508E83_2049587897 = cloned;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2049587897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2049587897;
        // ---------- Original Method ----------
        //try {
            //BreakIterator cloned = (BreakIterator) super.clone();
            //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
            //return cloned;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.821 -0400", hash_original_field = "AE5795245BD72341C1863329F63CD2D5", hash_generated_field = "E294711A5AAD88DB0E975ABC422940FE")

    public static final int DONE = -1;
}

