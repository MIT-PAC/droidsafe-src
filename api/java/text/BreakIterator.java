package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;

public abstract class BreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.439 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "CF9D4EF05D56B4D14C66F6CD08D197A2")

    NativeBreakIterator wrapped;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.439 -0400", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "6FAD5F17105AA87E99EE906D945E3AD3")
    protected  BreakIterator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.439 -0400", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "2D0429676C289659EEA8E15847385912")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.442 -0400", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "7F44276447ABC8B4A6CC116EB8BC0902")
    public boolean isBoundary(int offset) {
        addTaint(offset);
        boolean var555B9C99F84B19502BCD77FE9A14CBFB_1496286565 = (wrapped.isBoundary(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904439012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904439012;
        // ---------- Original Method ----------
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.442 -0400", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "BF69631ABB6069C25A008A5418B0D738")
    public int preceding(int offset) {
        addTaint(offset);
        int var22FB19483F51E7C2262EC946C0BBAC14_492029307 = (wrapped.preceding(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514670793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514670793;
        // ---------- Original Method ----------
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.442 -0400", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "C256B883E92C1415C66968FF9184E557")
    public void setText(String newText) {
        addTaint(newText.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.444 -0400", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "D479DA585894382F211D512AC5D22F6F")
    @Override
    public Object clone() {
        try 
        {
            BreakIterator cloned = (BreakIterator) super.clone();
            cloned.wrapped = (NativeBreakIterator) wrapped.clone();
Object var7733EC69B7B77450072710EF7316B904_2129516862 =             cloned;
            var7733EC69B7B77450072710EF7316B904_2129516862.addTaint(taint);
            return var7733EC69B7B77450072710EF7316B904_2129516862;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1499018900 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1499018900.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1499018900;
        } //End block
        // ---------- Original Method ----------
        //try {
            //BreakIterator cloned = (BreakIterator) super.clone();
            //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
            //return cloned;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.444 -0400", hash_original_field = "AE5795245BD72341C1863329F63CD2D5", hash_generated_field = "E294711A5AAD88DB0E975ABC422940FE")

    public static final int DONE = -1;
}

