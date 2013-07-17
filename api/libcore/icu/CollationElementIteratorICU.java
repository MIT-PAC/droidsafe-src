package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.CharacterIterator;

public final class CollationElementIteratorICU {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.520 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.521 -0400", hash_original_method = "650A589CB2D4F7C3E63293AEFAAA9A77", hash_generated_method = "9F96A6BEB757984005D7DA3929E5AC60")
    private  CollationElementIteratorICU(int address) {
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.521 -0400", hash_original_method = "71B44ACA4CC3DD57553E99908AFF2FC7", hash_generated_method = "F0D2C833BB8D0379FDD92C770F5BEBD6")
    public void reset() {
        NativeCollation.reset(address);
        // ---------- Original Method ----------
        //NativeCollation.reset(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.521 -0400", hash_original_method = "D76B0B21507A74EBC38ECF8BA836254A", hash_generated_method = "3ED4A5E0BAF818FDCBC00071B5DCD9E5")
    public int next() {
        int var95757B31B679D2A32A7D126F2DEDAC6C_2077889211 = (NativeCollation.next(address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055677259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055677259;
        // ---------- Original Method ----------
        //return NativeCollation.next(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.521 -0400", hash_original_method = "EA54CCD4F91FD8A9A4140D3CDE5AE34D", hash_generated_method = "EEE4A09C9F39C2B76394AFDC63D679B9")
    public int previous() {
        int var5AEBBA9FD332AEE232AB905DB54649B0_1166312913 = (NativeCollation.previous(address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815960926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815960926;
        // ---------- Original Method ----------
        //return NativeCollation.previous(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.522 -0400", hash_original_method = "8640B8389DB00731AE9D5E817F73B27B", hash_generated_method = "B088D84606D5751A4D50D80734733982")
    public int getMaxExpansion(int order) {
        addTaint(order);
        int varBB94C8C7409417A1D1421E950ECFC887_1362784387 = (NativeCollation.getMaxExpansion(address, order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012803356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012803356;
        // ---------- Original Method ----------
        //return NativeCollation.getMaxExpansion(address, order);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.522 -0400", hash_original_method = "603C380ACC11CC522426235C8A41DEB0", hash_generated_method = "485FAE18358D5DBA1308C3F9E141EF0D")
    public void setText(String source) {
        addTaint(source.getTaint());
        NativeCollation.setText(address, source);
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.522 -0400", hash_original_method = "1B43DCD00444559B9B02AC0B455E987E", hash_generated_method = "2DD6F3AE200AE7528488648E8A6B6733")
    public void setText(CharacterIterator source) {
        addTaint(source.getTaint());
        NativeCollation.setText(address, source.toString());
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source.toString());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.523 -0400", hash_original_method = "1F41E721FB3FAE28539A76645F583C29", hash_generated_method = "EFD33CF316CE9F7860C9DEC6DD3A5734")
    public int getOffset() {
        int var91C2613C29FBE71DA1D8A5CBBA969EFD_373643653 = (NativeCollation.getOffset(address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146931833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146931833;
        // ---------- Original Method ----------
        //return NativeCollation.getOffset(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.523 -0400", hash_original_method = "452F12B7AA1A7AC5FD41D10DD72719C4", hash_generated_method = "EA4DBBBF535114AF26EAB883ADED02ED")
    public void setOffset(int offset) {
        addTaint(offset);
        NativeCollation.setOffset(address, offset);
        // ---------- Original Method ----------
        //NativeCollation.setOffset(address, offset);
    }

    
    @DSModeled(DSC.SAFE)
    public static int primaryOrder(int order) {
        return ((order & PRIMARY_ORDER_MASK_) >> PRIMARY_ORDER_SHIFT_) &
                UNSIGNED_16_BIT_MASK_;
    }

    
    @DSModeled(DSC.SAFE)
    public static int secondaryOrder(int order) {
        return (order & SECONDARY_ORDER_MASK_) >> SECONDARY_ORDER_SHIFT_;
    }

    
    @DSModeled(DSC.SAFE)
    public static int tertiaryOrder(int order) {
        return order & TERTIARY_ORDER_MASK_;
    }

    
    @DSModeled(DSC.SAFE)
    public static CollationElementIteratorICU getInstance(int collatorAddress, String source) {
        int iteratorAddress = NativeCollation.getCollationElementIterator(collatorAddress, source);
        return new CollationElementIteratorICU(iteratorAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_method = "286B49C8E8E4DF34140969B2D7F609E6", hash_generated_method = "0D60DF47C60AB4D85F6C195166DE8F59")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCollation.closeElements(address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //NativeCollation.closeElements(address);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "FFAA3AFE82D0079EEA7E109CB227F98A", hash_generated_field = "5751BF0C0BB2F6DF1C5397A05865E3FC")

    public static final int NULLORDER = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "BC26F0148E1BFABCF195C229ACA28564", hash_generated_field = "CEBD8C970794300C427FC048FCF0DA56")

    private static final int PRIMARY_ORDER_MASK_ = 0xffff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "70EB286FF9EB2E54A276FDF8672E2469", hash_generated_field = "37B586E43FC518D2A5573873EF71D41F")

    private static final int SECONDARY_ORDER_MASK_ = 0x0000ff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "86B90CE2774A0F72004D42F08FE33A16", hash_generated_field = "56A4AC37B3276A80B0F8B70BBFA42880")

    private static final int TERTIARY_ORDER_MASK_ = 0x000000ff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "E565E3FB89858732DE8C60EB5E0FCC5F", hash_generated_field = "7348A7BD25E564DE1FC72DD93FA92189")

    private static final int PRIMARY_ORDER_SHIFT_ = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "0C0C5671AE8F751C086EBF4EC331F0FC", hash_generated_field = "773E31A4E6B02D59EFD6B43CACA4DD1A")

    private static final int SECONDARY_ORDER_SHIFT_ = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.525 -0400", hash_original_field = "FF0C25747492EAF4673A968315463362", hash_generated_field = "0D68B933D920F227F58988FE4B59F102")

    private static final int UNSIGNED_16_BIT_MASK_ = 0x0000FFFF;
}

