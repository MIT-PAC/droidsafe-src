package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.NativeBreakIterator;

public abstract class BreakIterator implements Cloneable {

    /**
     * Returns an array of locales for which custom {@code BreakIterator} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.463 -0500", hash_original_method = "CDAA22D1266CD653C7683C0E1E518399", hash_generated_method = "4A7E3E265648FAD4A4D4C73A60531487")
    
public static Locale[] getAvailableLocales() {
        return ICU.getAvailableBreakIteratorLocales();
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * characters using the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @return a new instance of {@code BreakIterator} using the default locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.465 -0500", hash_original_method = "73C86D2B1E3949BDD4766F0D383D3313", hash_generated_method = "F8CD5D16899329BCB2A45FB5284273F8")
    
public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * characters using the given locale.
     *
     * @param where
     *            the given locale.
     * @return a new instance of {@code BreakIterator} using the given locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.468 -0500", hash_original_method = "15D8F31D878C030C879D418D3EFBB94E", hash_generated_method = "D3C21E59704B982039AA1B36F85311CB")
    
public static BreakIterator getCharacterInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getCharacterInstance(where));
    }

    /**
     * Returns a new instance of {{@code BreakIterator} to iterate over
     * line breaks using the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @return a new instance of {@code BreakIterator} using the default locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.470 -0500", hash_original_method = "D6748027A113A968D41DBB54A60AFFCE", hash_generated_method = "029C393C3C27442C6813834BB5B5E2FF")
    
public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * line breaks using the given locale.
     *
     * @param where
     *            the given locale.
     * @return a new instance of {@code BreakIterator} using the given locale.
     * @throws NullPointerException if {@code where} is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.473 -0500", hash_original_method = "16F89AC74F07F2A2F95C59850320FE25", hash_generated_method = "74869C542C2ED5F6A71360831B4A52AB")
    
public static BreakIterator getLineInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getLineInstance(where));
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * sentence-breaks using the default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @return a new instance of {@code BreakIterator} using the default locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.475 -0500", hash_original_method = "18F9B58B267F0FC6B05A987F728E2486", hash_generated_method = "FE8BC1913425CF5CB06065188DBD7884")
    
public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * sentence-breaks using the given locale.
     *
     * @param where
     *            the given locale.
     * @return a new instance of {@code BreakIterator} using the given locale.
     * @throws NullPointerException if {@code where} is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.478 -0500", hash_original_method = "E0F8AFB08F46A12DF5C8B687A76303D7", hash_generated_method = "401FE9D38CCB10DFA08D8030C15E8A49")
    
public static BreakIterator getSentenceInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getSentenceInstance(where));
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * word-breaks using the default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * @return a new instance of {@code BreakIterator} using the default locale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.480 -0500", hash_original_method = "C28E169051A38A771BB05D3E97AC5645", hash_generated_method = "8CBFC3EF1976FDA6BB220E934E80BE9E")
    
public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    /**
     * Returns a new instance of {@code BreakIterator} to iterate over
     * word-breaks using the given locale.
     *
     * @param where
     *            the given locale.
     * @return a new instance of {@code BreakIterator} using the given locale.
     * @throws NullPointerException if {@code where} is {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.483 -0500", hash_original_method = "57DB03753EEC66F7371A042EE0F78B09", hash_generated_method = "50A97362922152B394FB859081A73890")
    
public static BreakIterator getWordInstance(Locale where) {
        return new RuleBasedBreakIterator(NativeBreakIterator.getWordInstance(where));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.452 -0500", hash_original_field = "5356062832EFE77C857AE4C67790E997", hash_generated_field = "E294711A5AAD88DB0E975ABC422940FE")

    public static final int DONE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.454 -0500", hash_original_field = "CF9D4EF05D56B4D14C66F6CD08D197A2", hash_generated_field = "CF9D4EF05D56B4D14C66F6CD08D197A2")

    NativeBreakIterator wrapped;

    /**
     * Default constructor, for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.458 -0500", hash_original_method = "472E6BA7B975B8FFC4413000E223456D", hash_generated_method = "9BA171FA3E8C1478B6CF3C9AF552D308")
    
protected BreakIterator() {
    }

    /*
     * wrapping constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.460 -0500", hash_original_method = "72AAB41934B49D5B08FCF4597E7486A8", hash_generated_method = "72AAB41934B49D5B08FCF4597E7486A8")
    
BreakIterator(NativeBreakIterator iterator) {
        wrapped = iterator;
    }

    /**
     * Indicates whether the given offset is a boundary position. If this method
     * returns true, the current iteration position is set to the given
     * position; if the function returns false, the current iteration position
     * is set as though {@link #following(int)} had been called.
     *
     * @param offset
     *            the given offset to check.
     * @return {@code true} if the given offset is a boundary position; {@code
     *         false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.485 -0500", hash_original_method = "A8CE13377E2BE8338E384DB518A75EF1", hash_generated_method = "C58EEA64A5DB6D8DF573C10506CAB375")
    
public boolean isBoundary(int offset) {
        return wrapped.isBoundary(offset);
    }

    /**
     * Returns the position of last boundary preceding the given offset, and
     * sets the current position to the returned value, or {@code DONE} if the
     * given offset specifies the starting position.
     *
     * @param offset
     *            the given start position to be searched for.
     * @return the position of the last boundary preceding the given offset.
     * @throws IllegalArgumentException
     *            if the offset is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.487 -0500", hash_original_method = "2EB9AD97D64682279E3EECC38916DED9", hash_generated_method = "C4718DF1C317CD58D8CE3B1497902D5A")
    
public int preceding(int offset) {
        return wrapped.preceding(offset);
    }

    /**
     * Sets the new text string to be analyzed, the current position will be
     * reset to the beginning of this new string, and the old string will be
     * lost.
     *
     * @param newText
     *            the new text string to be analyzed.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.490 -0500", hash_original_method = "09A01C59FC40671D2FFB70D6D2572999", hash_generated_method = "E7C4BF69463A97CC321E1D893E0F45DF")
    
public void setText(String newText) {
        wrapped.setText(newText);
    }

    /**
     * Returns this iterator's current position.
     *
     * @return this iterator's current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.493 -0500", hash_original_method = "69D4B46C3387CCEF1F85DCFFA85E63F2", hash_generated_method = "878F8AF1DFAAF15038C64B103B00D143")
    
public abstract int current();

    /**
     * Sets this iterator's current position to the first boundary and returns
     * that position.
     *
     * @return the position of the first boundary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.495 -0500", hash_original_method = "6415C76AAC35B5C5FC809D53BDF7A378", hash_generated_method = "59828B520524458D794E643E02D8AEEA")
    
public abstract int first();

    /**
     * Sets the position of the first boundary to the one following the given
     * offset and returns this position. Returns {@code DONE} if there is no
     * boundary after the given offset.
     *
     * @param offset
     *            the given position to be searched for.
     * @return the position of the first boundary following the given offset.
     * @throws IllegalArgumentException
     *            if the offset is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.497 -0500", hash_original_method = "8F59C5D89B5D4AA4348172821C4CCE0D", hash_generated_method = "F500FF888AC91A281B23FE62A2BF428D")
    
public abstract int following(int offset);

    /**
     * Returns a {@code CharacterIterator} which represents the text being
     * analyzed. Please note that the returned value is probably the internal
     * iterator used by this object. If the invoker wants to modify the status
     * of the returned iterator, it is recommended to first create a clone of
     * the iterator returned.
     *
     * @return a {@code CharacterIterator} which represents the text being
     *         analyzed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.500 -0500", hash_original_method = "09B12A37E226404A8E74ABB45E5F71D6", hash_generated_method = "CB64089D7AD9B4908387668F08249F12")
    
public abstract CharacterIterator getText();

    /**
     * Sets this iterator's current position to the last boundary and returns
     * that position.
     *
     * @return the position of last boundary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.503 -0500", hash_original_method = "5BE5864A9727A8954D25F14CBC062EFF", hash_generated_method = "06D3257037A6B55AE641F63FD05EE0A8")
    
public abstract int last();

    /**
     * Sets this iterator's current position to the next boundary after the
     * current position, and returns this position. Returns {@code DONE} if no
     * boundary was found after the current position.
     *
     * @return the position of last boundary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.505 -0500", hash_original_method = "D28A2AB4527746FD6CFD3F25CF39BB91", hash_generated_method = "C2E149DE48D99FE54AF60C0AC624C698")
    
public abstract int next();

    /**
     * Sets this iterator's current position to the next boundary after the
     * given position, and returns that position. Returns {@code DONE} if no
     * boundary was found after the given position.
     *
     * @param n
     *            the given position.
     * @return the position of last boundary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.507 -0500", hash_original_method = "39AB1ADB00FCAC8C2DD7DCA6DF218B25", hash_generated_method = "E58B40442FFF1CD8F49CACB83B22E73A")
    
public abstract int next(int n);

    /**
     * Sets this iterator's current position to the previous boundary before the
     * current position and returns that position. Returns {@code DONE} if
     * no boundary was found before the current position.
     *
     * @return the position of last boundary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.510 -0500", hash_original_method = "5CEAC88BBF02E0DCE3AD4B5185EC1E89", hash_generated_method = "BF449AEB29654E70A959A55C4B049B1A")
    
public abstract int previous();

    /**
     * Sets the new text to be analyzed by the given {@code CharacterIterator}.
     * The position will be reset to the beginning of the new text, and other
     * status information of this iterator will be kept.
     *
     * @param newText
     *            the {@code CharacterIterator} referring to the text to be
     *            analyzed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.513 -0500", hash_original_method = "5F74FC1BC98E71483489AFE568AA1A9C", hash_generated_method = "027EC73708FAB2D1AE29B570E3C08CB6")
    
public abstract void setText(CharacterIterator newText);

    /**
     * Returns a copy of this iterator.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:09.515 -0500", hash_original_method = "29575A5512234CDD5AA778EC4509422E", hash_generated_method = "730672366B2427216F76C389D81D10B3")
    
@Override
    public Object clone() {
        try {
            BreakIterator cloned = (BreakIterator) super.clone();
            cloned.wrapped = (NativeBreakIterator) wrapped.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

