package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.CharacterIterator;






public final class CollationElementIteratorICU {

    /**
     * Gets the primary order of a collation order.
     * @param order the collation order
     * @return the primary order of a collation order.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.045 -0500", hash_original_method = "2D70A31B879518D60C1406E8BB394C01", hash_generated_method = "E145F432B5A3501F1C005D4211538DCC")
    public static int primaryOrder(int order) {
        return ((order & PRIMARY_ORDER_MASK_) >> PRIMARY_ORDER_SHIFT_) &
                UNSIGNED_16_BIT_MASK_;
    }

    /**
     * Gets the secondary order of a collation order.
     * @param order the collation order
     * @return the secondary order of a collation order.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.046 -0500", hash_original_method = "F74FE94679D9CBC1A9D9F74AEF1CAA7D", hash_generated_method = "484EE365C6556E904F590230622E9FF8")
    public static int secondaryOrder(int order) {
        return (order & SECONDARY_ORDER_MASK_) >> SECONDARY_ORDER_SHIFT_;
    }

    /**
     * Gets the tertiary order of a collation order.
     * @param order the collation order
     * @return the tertiary order of a collation order.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.047 -0500", hash_original_method = "6287831B75A2E8C792411156F0D937ED", hash_generated_method = "09A9D4CBD58FEF5C678ED96F2E5A121D")
    public static int tertiaryOrder(int order) {
        return order & TERTIARY_ORDER_MASK_;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.048 -0500", hash_original_method = "9D7C1BE8632666257030DFBB7F00B98F", hash_generated_method = "984D242F77E775048B2EF4A4E9388C4A")
    public static CollationElementIteratorICU getInstance(int collatorAddress, String source) {
        int iteratorAddress = NativeCollation.getCollationElementIterator(collatorAddress, source);
        return new CollationElementIteratorICU(iteratorAddress);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.038 -0500", hash_original_field = "C76867729D5F782CCC25D8FCCEF1B19F", hash_generated_field = "08FC46660423ED847935F1B95B8E2D6D")


    /**
     * @stable ICU 2.4
     */
    public static final int NULLORDER = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.052 -0500", hash_original_field = "61BAD343A22BEDE61A9D11F19D9262B4", hash_generated_field = "CEBD8C970794300C427FC048FCF0DA56")

    private static final int PRIMARY_ORDER_MASK_ = 0xffff0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.052 -0500", hash_original_field = "918BAE1772C6A6A1E37A96329648366D", hash_generated_field = "37B586E43FC518D2A5573873EF71D41F")

    private static final int SECONDARY_ORDER_MASK_ = 0x0000ff00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.053 -0500", hash_original_field = "79404DB7198F8ADBB465F7152AD377F5", hash_generated_field = "56A4AC37B3276A80B0F8B70BBFA42880")

    private static final int TERTIARY_ORDER_MASK_ = 0x000000ff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.054 -0500", hash_original_field = "784C0295BA59CE11EEC2218ED86B7D5F", hash_generated_field = "7348A7BD25E564DE1FC72DD93FA92189")

    private static final int PRIMARY_ORDER_SHIFT_ = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.056 -0500", hash_original_field = "0D96470BAA559A8DC3D6CC05BE74C096", hash_generated_field = "773E31A4E6B02D59EFD6B43CACA4DD1A")

    private static final int SECONDARY_ORDER_SHIFT_ = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.056 -0500", hash_original_field = "E75ED3AB5D974A9F3EE5897FFEEF76E9", hash_generated_field = "0D68B933D920F227F58988FE4B59F102")

    private static final int UNSIGNED_16_BIT_MASK_ = 0x0000FFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.050 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "B4380F1C7A07D3332CFB225F0E2EF9F5")


    /**
     * C collator
     */
    private int address;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.048 -0500", hash_original_method = "650A589CB2D4F7C3E63293AEFAAA9A77", hash_generated_method = "E15AF53D2515D281431A6ECD4A4CA9A7")
    private CollationElementIteratorICU(int address) {
        this.address = address;
    }

    // public methods -----------------------------------------------

    /**
     * Reset the collation elements to their initial state.
     * This will move the 'cursor' to the beginning of the text.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.039 -0500", hash_original_method = "71B44ACA4CC3DD57553E99908AFF2FC7", hash_generated_method = "97FD0FEA731FD340565ABEB2464702AE")
    public void reset() {
        NativeCollation.reset(address);
    }

    /**
     * Get the ordering priority of the next collation element in the text.
     * A single character may contain more than one collation element.
     * @return next collation elements ordering, or NULLORDER if the end of the
     *         text is reached.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.040 -0500", hash_original_method = "D76B0B21507A74EBC38ECF8BA836254A", hash_generated_method = "84E64B986B0F051C6A6795357BB0DE66")
    public int next() {
        return NativeCollation.next(address);
    }

    /**
     * Get the ordering priority of the previous collation element in the text.
     * A single character may contain more than one collation element.
     * @return previous collation element ordering, or NULLORDER if the end of
     *         the text is reached.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.041 -0500", hash_original_method = "EA54CCD4F91FD8A9A4140D3CDE5AE34D", hash_generated_method = "9D8AFB67B7EB3BF5B1543021205359EE")
    public int previous() {
        return NativeCollation.previous(address);
    }

    /**
     * Get the maximum length of any expansion sequences that end with the
     * specified comparison order.
     * @param order collation order returned by previous or next.
     * @return maximum size of the expansion sequences ending with the collation
     *              element or 1 if collation element does not occur at the end of
     *              any expansion sequence
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.041 -0500", hash_original_method = "8640B8389DB00731AE9D5E817F73B27B", hash_generated_method = "0628E3D5845565FB79602EB8D7925034")
    public int getMaxExpansion(int order) {
        return NativeCollation.getMaxExpansion(address, order);
    }

    /**
     * Set the text containing the collation elements.
     * @param source text containing the collation elements.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.042 -0500", hash_original_method = "603C380ACC11CC522426235C8A41DEB0", hash_generated_method = "AE90BDBAF449BA6B5299720AB29D1BBD")
    public void setText(String source) {
        NativeCollation.setText(address, source);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.043 -0500", hash_original_method = "1B43DCD00444559B9B02AC0B455E987E", hash_generated_method = "EA4070D27EE050988B4B067CC0FC8ABB")
    public void setText(CharacterIterator source) {
        NativeCollation.setText(address, source.toString());
    }

    /**
     * Get the offset of the current source character.
     * This is an offset into the text of the character containing the current
     * collation elements.
     * @return offset of the current source character.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.044 -0500", hash_original_method = "1F41E721FB3FAE28539A76645F583C29", hash_generated_method = "1D7DCE433012CC11E054B8D080E6B9AE")
    public int getOffset() {
        return NativeCollation.getOffset(address);
    }

    /**
     * Set the offset of the current source character.
     * This is an offset into the text of the character to be processed.
     * @param offset The desired character offset.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.044 -0500", hash_original_method = "452F12B7AA1A7AC5FD41D10DD72719C4", hash_generated_method = "5F5E8DABC55BC05F5E7FC89325D285B9")
    public void setOffset(int offset) {
        NativeCollation.setOffset(address, offset);
    }

    // protected methods --------------------------------------------

    /**
     * Garbage collection.
     * Close C collator and reclaim memory.
     * @stable ICU 2.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:33.049 -0500", hash_original_method = "286B49C8E8E4DF34140969B2D7F609E6", hash_generated_method = "98D0D7EFB37D3C55FC7668DF867E92C8")
    @Override
protected void finalize() throws Throwable {
        try {
            NativeCollation.closeElements(address);
        } finally {
            super.finalize();
        }
    }
}

