package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.icu.CollationElementIteratorICU;

public final class CollationElementIterator {

    /**
     * Obtains the primary order of the specified collation element, i.e. the
     * first 16 bits. This value is unsigned.
     *
     * @param order
     *            the element of the collation.
     * @return the element's 16 bit primary order.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.271 -0500", hash_original_method = "D45AACC1784EFE96257BB7DED0205226", hash_generated_method = "7AF95849154BC919DB73EF5F0602B568")
    
public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    /**
     * Obtains the secondary order of the specified collation element, i.e. the
     * 16th to 23th bits, inclusive. This value is unsigned.
     *
     * @param order
     *            the element of the collator.
     * @return the 8 bit secondary order of the element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.275 -0500", hash_original_method = "1140CD5E96A0E40D8BD81BCBE0AC1128", hash_generated_method = "85B1520249AF45217F458EC4D3DC1BA8")
    
public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    /**
     * Obtains the tertiary order of the specified collation element, i.e. the
     * last 8 bits. This value is unsigned.
     *
     * @param order
     *            the element of the collation.
     * @return the 8 bit tertiary order of the element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.285 -0500", hash_original_method = "F642473139BF0FEECA4488F11934C82A", hash_generated_method = "68ADC2128FAEEDE72B974D8526C24406")
    
public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.254 -0500", hash_original_field = "F6016073E1C466E37EF99F3907C58641", hash_generated_field = "507498C0E339FEAE686FB3D8460C0395")

    public static final int NULLORDER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.256 -0500", hash_original_field = "B7EFCAE5DB7AA8E0B6EF62900BCC115F", hash_generated_field = "84C6F5065A9015D8FD721C1742E21463")

    private CollationElementIteratorICU icuIterator;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.259 -0500", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "C4D82AD91997942FF2D2C5DD5D5F8256")
    
CollationElementIterator(CollationElementIteratorICU iterator) {
        this.icuIterator = iterator;
    }

    /**
     * Obtains the maximum length of any expansion sequence that ends with the
     * specified collation element. Returns {@code 1} if there is no expansion
     * with this collation element as the last element.
     *
     * @param order
     *            a collation element that has been previously obtained from a
     *            call to either the {@link #next()} or {@link #previous()}
     *            method.
     * @return the maximum length of any expansion sequence ending with the
     *         specified collation element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.261 -0500", hash_original_method = "3D8662E172DF94DE766C937C706B5067", hash_generated_method = "5364E5A27E3DF6E0EF2FBFD834D7184C")
    
public int getMaxExpansion(int order) {
        return this.icuIterator.getMaxExpansion(order);
    }

    /**
     * Obtains the character offset in the source string corresponding to the
     * next collation element. This value could be any of:
     * <ul>
     * <li>The index of the first character in the source string that matches
     * the value of the next collation element. This means that if
     * {@code setOffset(offset)} sets the index in the middle of a contraction,
     * {@code getOffset()} returns the index of the first character in the
     * contraction, which may not be equal to the original offset that was set.
     * Hence calling {@code getOffset()} immediately after
     * {@code setOffset(offset)} does not guarantee that the original offset set
     * will be returned.</li>
     * <li>If normalization is on, the index of the immediate subsequent
     * character, or composite character with the first character, having a
     * combining class of 0.</li>
     * <li>The length of the source string, if iteration has reached the end.
     * </li>
     * </ul>
     *
     * @return The position of the collation element in the source string that
     *         will be returned by the next invocation of the {@link #next()}
     *         method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.264 -0500", hash_original_method = "86FFE9FC429F590289C595CEB48BC74B", hash_generated_method = "C1B3A53EF650EBA442EDBFDD333BC45F")
    
public int getOffset() {
        return this.icuIterator.getOffset();
    }

    /**
     * Obtains the next collation element in the source string.
     *
     * @return the next collation element or {@code NULLORDER} if the end
     *         of the iteration has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.266 -0500", hash_original_method = "57F823A473B8AE20AA92B1969F9DE507", hash_generated_method = "F6D4D9F8B3E5E0232F37E3438B4DA659")
    
public int next() {
        return this.icuIterator.next();
    }

    /**
     * Obtains the previous collation element in the source string.
     *
     * @return the previous collation element, or {@code NULLORDER} when
     *         the start of the iteration has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.268 -0500", hash_original_method = "3E3F3B80F1885FD18E0677AD75F46948", hash_generated_method = "5B6D4228F03D9A4091FE3AEDB1F8F662")
    
public int previous() {
        return this.icuIterator.previous();
    }

    /**
     * Repositions the cursor to point at the first element of the current
     * string. The next call to {@link #next()} or {@link #previous()} will
     * return the first and last collation element in the string, respectively.
     * <p>
     * If the {@code RuleBasedCollator} used by this iterator has had its
     * attributes changed, calling {@code reset()} reinitializes the iterator to
     * use the new attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.273 -0500", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "274D6D48484D467E674F0119E7801A2A")
    
public void reset() {
        this.icuIterator.reset();
    }

    /**
     * Points the iterator at the collation element associated with the
     * character in the source string which is found at the supplied offset.
     * After this call completes, an invocation of the {@link #next()} method
     * will return this collation element.
     * <p>
     * If {@code newOffset} corresponds to a character which is part of a
     * sequence that maps to a single collation element then the iterator is
     * adjusted to the start of that sequence. As a result of this, any
     * subsequent call made to {@code getOffset()} may not return the same value
     * set by this method.
     * <p>
     * If the decomposition mode is on, and offset is in the middle of a
     * decomposable range of source text, the iterator may not return a correct
     * result for the next forwards or backwards iteration. The user must ensure
     * that the offset is not in the middle of a decomposable range.
     *
     * @param newOffset
     *            the character offset into the original source string to set.
     *            Note that this is not an offset into the corresponding
     *            sequence of collation elements.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.278 -0500", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "D0D4C87AF30D64D3B685B8EA0A6AAE44")
    
public void setOffset(int newOffset) {
        this.icuIterator.setOffset(newOffset);
    }

    /**
     * Sets a new source string iterator for iteration, and resets the offset to
     * the beginning of the text.
     *
     * @param source
     *            the new source string iterator for iteration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.280 -0500", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "961ABBD54DCA1D21997245B688E95566")
    
public void setText(CharacterIterator source) {
        this.icuIterator.setText(source);
    }

    /**
     * Sets a new source string for iteration, and resets the offset to the
     * beginning of the text.
     *
     * @param source
     *            the new source string for iteration.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:10.283 -0500", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "01E9C99A0F71D53E6F2BC83AE127E043")
    
public void setText(String source) {
        this.icuIterator.setText(source);
    }
}

