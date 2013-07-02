package libcore.icu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.CharacterIterator;

public final class CollationElementIteratorICU {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_method = "650A589CB2D4F7C3E63293AEFAAA9A77", hash_generated_method = "9F96A6BEB757984005D7DA3929E5AC60")
    private  CollationElementIteratorICU(int address) {
        this.address = address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_method = "71B44ACA4CC3DD57553E99908AFF2FC7", hash_generated_method = "F0D2C833BB8D0379FDD92C770F5BEBD6")
    public void reset() {
        NativeCollation.reset(address);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_method = "D76B0B21507A74EBC38ECF8BA836254A", hash_generated_method = "6E8132F291C55AFB31DF8EF27F4C409E")
    public int next() {
        int var3E37E7CEF4D43D48A85E18820F7DC35C_1813897528 = (NativeCollation.next(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315828284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315828284;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_method = "EA54CCD4F91FD8A9A4140D3CDE5AE34D", hash_generated_method = "558356776AF4CBA4DB4B12F54F8CA3ED")
    public int previous() {
        int var23CD4C87E20FD46EC60BB987A629A37F_494729226 = (NativeCollation.previous(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793944977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793944977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.126 -0400", hash_original_method = "8640B8389DB00731AE9D5E817F73B27B", hash_generated_method = "41464ABA2CAFB83530CD05C654E0B0D4")
    public int getMaxExpansion(int order) {
        int var8602979FCA2FA4011AFB12D2C298A86E_1062854314 = (NativeCollation.getMaxExpansion(address, order));
        addTaint(order);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117427482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117427482;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.127 -0400", hash_original_method = "603C380ACC11CC522426235C8A41DEB0", hash_generated_method = "D00F802972132FCA3853BC2432CCF175")
    public void setText(String source) {
        NativeCollation.setText(address, source);
        addTaint(source.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.127 -0400", hash_original_method = "1B43DCD00444559B9B02AC0B455E987E", hash_generated_method = "D948653692DF874F9BDCB16646CEF49C")
    public void setText(CharacterIterator source) {
        NativeCollation.setText(address, source.toString());
        addTaint(source.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.127 -0400", hash_original_method = "1F41E721FB3FAE28539A76645F583C29", hash_generated_method = "82C0AD8604AB4B11DE0FF26CE3F9C220")
    public int getOffset() {
        int var24660AAAE875D6199DF5A3BA3B1DCD75_1862724957 = (NativeCollation.getOffset(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078093652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078093652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.127 -0400", hash_original_method = "452F12B7AA1A7AC5FD41D10DD72719C4", hash_generated_method = "F16B957715C080EC6A7C646B91CF9CE4")
    public void setOffset(int offset) {
        NativeCollation.setOffset(address, offset);
        addTaint(offset);
        
        
    }

    
    public static int primaryOrder(int order) {
        return ((order & PRIMARY_ORDER_MASK_) >> PRIMARY_ORDER_SHIFT_) &
                UNSIGNED_16_BIT_MASK_;
    }

    
    public static int secondaryOrder(int order) {
        return (order & SECONDARY_ORDER_MASK_) >> SECONDARY_ORDER_SHIFT_;
    }

    
    public static int tertiaryOrder(int order) {
        return order & TERTIARY_ORDER_MASK_;
    }

    
    @DSModeled(DSC.SAFE)
    public static CollationElementIteratorICU getInstance(int collatorAddress, String source) {
        int iteratorAddress = NativeCollation.getCollationElementIterator(collatorAddress, source);
        return new CollationElementIteratorICU(iteratorAddress);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_method = "286B49C8E8E4DF34140969B2D7F609E6", hash_generated_method = "0D60DF47C60AB4D85F6C195166DE8F59")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCollation.closeElements(address);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "FFAA3AFE82D0079EEA7E109CB227F98A", hash_generated_field = "5751BF0C0BB2F6DF1C5397A05865E3FC")

    public static final int NULLORDER = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "BC26F0148E1BFABCF195C229ACA28564", hash_generated_field = "CEBD8C970794300C427FC048FCF0DA56")

    private static final int PRIMARY_ORDER_MASK_ = 0xffff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "70EB286FF9EB2E54A276FDF8672E2469", hash_generated_field = "37B586E43FC518D2A5573873EF71D41F")

    private static final int SECONDARY_ORDER_MASK_ = 0x0000ff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "86B90CE2774A0F72004D42F08FE33A16", hash_generated_field = "56A4AC37B3276A80B0F8B70BBFA42880")

    private static final int TERTIARY_ORDER_MASK_ = 0x000000ff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "E565E3FB89858732DE8C60EB5E0FCC5F", hash_generated_field = "7348A7BD25E564DE1FC72DD93FA92189")

    private static final int PRIMARY_ORDER_SHIFT_ = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "0C0C5671AE8F751C086EBF4EC331F0FC", hash_generated_field = "773E31A4E6B02D59EFD6B43CACA4DD1A")

    private static final int SECONDARY_ORDER_SHIFT_ = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.128 -0400", hash_original_field = "FF0C25747492EAF4673A968315463362", hash_generated_field = "0D68B933D920F227F58988FE4B59F102")

    private static final int UNSIGNED_16_BIT_MASK_ = 0x0000FFFF;
}

