package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;

public abstract class BreakIterator implements Cloneable {
    public static final int DONE = -1;
    NativeBreakIterator wrapped;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "F8BF866011ABE1206CEFF09ED137AEAF")
    @DSModeled(DSC.SAFE)
    protected BreakIterator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "4F41976A5FF91BEDA9F7247EE0A68677")
    @DSModeled(DSC.SAFE)
     BreakIterator(NativeBreakIterator iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        // ---------- Original Method ----------
        //wrapped = iterator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "CDAA22D1266CD653C7683C0E1E518399", hash_generated_method = "4A7E3E265648FAD4A4D4C73A60531487")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableBreakIteratorLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "73C86D2B1E3949BDD4766F0D383D3313", hash_generated_method = "F8CD5D16899329BCB2A45FB5284273F8")
    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "15D8F31D878C030C879D418D3EFBB94E", hash_generated_method = "D3C21E59704B982039AA1B36F85311CB")
    public static BreakIterator getCharacterInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getCharacterInstance(where));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "D6748027A113A968D41DBB54A60AFFCE", hash_generated_method = "029C393C3C27442C6813834BB5B5E2FF")
    public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "16F89AC74F07F2A2F95C59850320FE25", hash_generated_method = "74869C542C2ED5F6A71360831B4A52AB")
    public static BreakIterator getLineInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getLineInstance(where));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "18F9B58B267F0FC6B05A987F728E2486", hash_generated_method = "FE8BC1913425CF5CB06065188DBD7884")
    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "E0F8AFB08F46A12DF5C8B687A76303D7", hash_generated_method = "401FE9D38CCB10DFA08D8030C15E8A49")
    public static BreakIterator getSentenceInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getSentenceInstance(where));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "C28E169051A38A771BB05D3E97AC5645", hash_generated_method = "8CBFC3EF1976FDA6BB220E934E80BE9E")
    public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "57DB03753EEC66F7371A042EE0F78B09", hash_generated_method = "50A97362922152B394FB859081A73890")
    public static BreakIterator getWordInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getWordInstance(where));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "A955D2D77AC54347AF233678EB51BCAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_1876799646 = (wrapped.isBoundary(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "7D8F194068A8AB22FB17591043ED9CD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int var14341653A1F5B35705434E8CE35431DA_808547979 = (wrapped.preceding(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "5D0964E0666E1B5F81581B6CFA3A9184")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.843 -0400", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "B3A2760A5D404E94AB5E55BF0BC2D513")
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
            throw new AssertionError(e);
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

    
}


