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
    NativeBreakIterator wrapped;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.845 -0400", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "6FAD5F17105AA87E99EE906D945E3AD3")
    @DSModeled(DSC.SAFE)
    protected BreakIterator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.845 -0400", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "3A39A9C9C525458A83D3A3A7B14EE9DA")
    @DSModeled(DSC.SAFE)
     BreakIterator(NativeBreakIterator iterator) {
        dsTaint.addTaint(iterator.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.847 -0400", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "8C9CC355B6ECE4236188938901D0B1E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_834749986 = (wrapped.isBoundary(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.848 -0400", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "F57C74B14C19440D76C108E4BD32683A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int var14341653A1F5B35705434E8CE35431DA_1869539767 = (wrapped.preceding(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.848 -0400", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "5A2E4A6A1FCA6F5CBA57AC272DEBFDF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String newText) {
        dsTaint.addTaint(newText);
        wrapped.setText(newText);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.849 -0400", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "712EECD8AFFE8E13CA8D5172D5FBF681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            BreakIterator cloned;
            cloned = (BreakIterator) super.clone();
            cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //BreakIterator cloned = (BreakIterator) super.clone();
            //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
            //return cloned;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    public static final int DONE = -1;
}

