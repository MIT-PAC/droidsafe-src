package java.text;

// Droidsafe Imports
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class BreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.592 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "CF9D4EF05D56B4D14C66F6CD08D197A2")

    NativeBreakIterator wrapped;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.592 -0400", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "6FAD5F17105AA87E99EE906D945E3AD3")
    protected  BreakIterator() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.592 -0400", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "2D0429676C289659EEA8E15847385912")
      BreakIterator(NativeBreakIterator iterator) {
        wrapped = iterator;
        // ---------- Original Method ----------
        //wrapped = iterator;
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableBreakIteratorLocales();
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getCharacterInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getCharacterInstance(where));
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getLineInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getLineInstance(where));
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getSentenceInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getSentenceInstance(where));
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static BreakIterator getWordInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getWordInstance(where));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.593 -0400", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "E52E5BE75E56DC1B10E4731A3CA740D5")
    public boolean isBoundary(int offset) {
        addTaint(offset);
        boolean var555B9C99F84B19502BCD77FE9A14CBFB_1948608780 = (wrapped.isBoundary(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471416211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471416211;
        // ---------- Original Method ----------
        //return wrapped.isBoundary(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.593 -0400", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "D8F337620D4577C760D861AFD7A2EADF")
    public int preceding(int offset) {
        addTaint(offset);
        int var22FB19483F51E7C2262EC946C0BBAC14_1794366567 = (wrapped.preceding(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559203707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559203707;
        // ---------- Original Method ----------
        //return wrapped.preceding(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.593 -0400", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "C256B883E92C1415C66968FF9184E557")
    public void setText(String newText) {
        addTaint(newText.getTaint());
        wrapped.setText(newText);
        // ---------- Original Method ----------
        //wrapped.setText(newText);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int current();

    
    @DSModeled(DSC.SAFE)
    public abstract int first();

    
    @DSModeled(DSC.SAFE)
    public abstract int following(int offset);

    
    @DSModeled(DSC.SAFE)
    public abstract CharacterIterator getText();

    
    @DSModeled(DSC.SAFE)
    public abstract int last();

    
    @DSModeled(DSC.SAFE)
    public abstract int next();

    
    @DSModeled(DSC.SAFE)
    public abstract int next(int n);

    
    @DSModeled(DSC.SAFE)
    public abstract int previous();

    
    @DSModeled(DSC.SAFE)
    public abstract void setText(CharacterIterator newText);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.594 -0400", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "9C6B5044CBB4B6153E3F968C12A9D73E")
    @Override
    public Object clone() {
        try 
        {
            BreakIterator cloned = (BreakIterator) super.clone();
            cloned.wrapped = (NativeBreakIterator) wrapped.clone();
Object var7733EC69B7B77450072710EF7316B904_1032617607 =             cloned;
            var7733EC69B7B77450072710EF7316B904_1032617607.addTaint(taint);
            return var7733EC69B7B77450072710EF7316B904_1032617607;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1494388596 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1494388596.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1494388596;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.594 -0400", hash_original_field = "AE5795245BD72341C1863329F63CD2D5", hash_generated_field = "E294711A5AAD88DB0E975ABC422940FE")

    public static final int DONE = -1;
}

