package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CharacterIterator;

public final class CollationElementIteratorICU {
    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.424 -0400", hash_original_method = "650A589CB2D4F7C3E63293AEFAAA9A77", hash_generated_method = "90ECB9BC16A29C75C8605A18CAE45C12")
    @DSModeled(DSC.SAFE)
    private CollationElementIteratorICU(int address) {
        dsTaint.addTaint(address);
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.424 -0400", hash_original_method = "71B44ACA4CC3DD57553E99908AFF2FC7", hash_generated_method = "F0D2C833BB8D0379FDD92C770F5BEBD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        NativeCollation.reset(address);
        // ---------- Original Method ----------
        //NativeCollation.reset(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.424 -0400", hash_original_method = "D76B0B21507A74EBC38ECF8BA836254A", hash_generated_method = "89DFD28FB28CD4EEDF4C5DE4A6BC802B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() {
        int var3E37E7CEF4D43D48A85E18820F7DC35C_1738067321 = (NativeCollation.next(address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.next(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.424 -0400", hash_original_method = "EA54CCD4F91FD8A9A4140D3CDE5AE34D", hash_generated_method = "22CE6B932A2807A1A3AD5E0418BE5EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previous() {
        int var23CD4C87E20FD46EC60BB987A629A37F_1681852982 = (NativeCollation.previous(address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.previous(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.424 -0400", hash_original_method = "8640B8389DB00731AE9D5E817F73B27B", hash_generated_method = "7F4C4E9D362BF5CDEB51CD22F9E97DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxExpansion(int order) {
        dsTaint.addTaint(order);
        int var8602979FCA2FA4011AFB12D2C298A86E_10899636 = (NativeCollation.getMaxExpansion(address, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getMaxExpansion(address, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.425 -0400", hash_original_method = "603C380ACC11CC522426235C8A41DEB0", hash_generated_method = "1FB7ABCFBB9FF1DF095473EE70682843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String source) {
        dsTaint.addTaint(source);
        NativeCollation.setText(address, source);
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.425 -0400", hash_original_method = "1B43DCD00444559B9B02AC0B455E987E", hash_generated_method = "86BB5CC3D942E90B44597A78DDAB92B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharacterIterator source) {
        dsTaint.addTaint(source.dsTaint);
        NativeCollation.setText(address, source.toString());
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.425 -0400", hash_original_method = "1F41E721FB3FAE28539A76645F583C29", hash_generated_method = "5CA18EDAFBCE7B846DBDD9872915A9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffset() {
        int var24660AAAE875D6199DF5A3BA3B1DCD75_1395480005 = (NativeCollation.getOffset(address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getOffset(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.425 -0400", hash_original_method = "452F12B7AA1A7AC5FD41D10DD72719C4", hash_generated_method = "0897A6E01BFA6DF3EEA5A2917AE7BBB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOffset(int offset) {
        dsTaint.addTaint(offset);
        NativeCollation.setOffset(address, offset);
        // ---------- Original Method ----------
        //NativeCollation.setOffset(address, offset);
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

    
        public static CollationElementIteratorICU getInstance(int collatorAddress, String source) {
        int iteratorAddress = NativeCollation.getCollationElementIterator(collatorAddress, source);
        return new CollationElementIteratorICU(iteratorAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.426 -0400", hash_original_method = "286B49C8E8E4DF34140969B2D7F609E6", hash_generated_method = "0D60DF47C60AB4D85F6C195166DE8F59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    public static final int NULLORDER = 0xFFFFFFFF;
    private static final int PRIMARY_ORDER_MASK_ = 0xffff0000;
    private static final int SECONDARY_ORDER_MASK_ = 0x0000ff00;
    private static final int TERTIARY_ORDER_MASK_ = 0x000000ff;
    private static final int PRIMARY_ORDER_SHIFT_ = 16;
    private static final int SECONDARY_ORDER_SHIFT_ = 8;
    private static final int UNSIGNED_16_BIT_MASK_ = 0x0000FFFF;
}

