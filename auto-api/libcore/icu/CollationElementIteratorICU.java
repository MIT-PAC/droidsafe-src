package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CharacterIterator;

public final class CollationElementIteratorICU {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.992 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.997 -0400", hash_original_method = "650A589CB2D4F7C3E63293AEFAAA9A77", hash_generated_method = "9F96A6BEB757984005D7DA3929E5AC60")
    private  CollationElementIteratorICU(int address) {
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.998 -0400", hash_original_method = "71B44ACA4CC3DD57553E99908AFF2FC7", hash_generated_method = "F0D2C833BB8D0379FDD92C770F5BEBD6")
    public void reset() {
        NativeCollation.reset(address);
        // ---------- Original Method ----------
        //NativeCollation.reset(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.998 -0400", hash_original_method = "D76B0B21507A74EBC38ECF8BA836254A", hash_generated_method = "1CE3D3808F8C0D79B26A8309F5FB8162")
    public int next() {
        int var3E37E7CEF4D43D48A85E18820F7DC35C_1252856505 = (NativeCollation.next(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338100851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338100851;
        // ---------- Original Method ----------
        //return NativeCollation.next(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.999 -0400", hash_original_method = "EA54CCD4F91FD8A9A4140D3CDE5AE34D", hash_generated_method = "D9397DB356085F68F900C73E717A735D")
    public int previous() {
        int var23CD4C87E20FD46EC60BB987A629A37F_857435810 = (NativeCollation.previous(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936710582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936710582;
        // ---------- Original Method ----------
        //return NativeCollation.previous(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.016 -0400", hash_original_method = "8640B8389DB00731AE9D5E817F73B27B", hash_generated_method = "5BAEA7EEE8370529A306666AA90EC147")
    public int getMaxExpansion(int order) {
        int var8602979FCA2FA4011AFB12D2C298A86E_346575368 = (NativeCollation.getMaxExpansion(address, order));
        addTaint(order);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861397460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861397460;
        // ---------- Original Method ----------
        //return NativeCollation.getMaxExpansion(address, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.016 -0400", hash_original_method = "603C380ACC11CC522426235C8A41DEB0", hash_generated_method = "D00F802972132FCA3853BC2432CCF175")
    public void setText(String source) {
        NativeCollation.setText(address, source);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.017 -0400", hash_original_method = "1B43DCD00444559B9B02AC0B455E987E", hash_generated_method = "D948653692DF874F9BDCB16646CEF49C")
    public void setText(CharacterIterator source) {
        NativeCollation.setText(address, source.toString());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //NativeCollation.setText(address, source.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.017 -0400", hash_original_method = "1F41E721FB3FAE28539A76645F583C29", hash_generated_method = "DF6D941C13D816830175D7785159ABA8")
    public int getOffset() {
        int var24660AAAE875D6199DF5A3BA3B1DCD75_810779584 = (NativeCollation.getOffset(address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801986703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801986703;
        // ---------- Original Method ----------
        //return NativeCollation.getOffset(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.017 -0400", hash_original_method = "452F12B7AA1A7AC5FD41D10DD72719C4", hash_generated_method = "F16B957715C080EC6A7C646B91CF9CE4")
    public void setOffset(int offset) {
        NativeCollation.setOffset(address, offset);
        addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.019 -0400", hash_original_method = "286B49C8E8E4DF34140969B2D7F609E6", hash_generated_method = "0D60DF47C60AB4D85F6C195166DE8F59")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.019 -0400", hash_original_field = "FFAA3AFE82D0079EEA7E109CB227F98A", hash_generated_field = "5751BF0C0BB2F6DF1C5397A05865E3FC")

    public static final int NULLORDER = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "BC26F0148E1BFABCF195C229ACA28564", hash_generated_field = "65326604463EAC7AA4580B579DB3A510")

    private static int PRIMARY_ORDER_MASK_ = 0xffff0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "70EB286FF9EB2E54A276FDF8672E2469", hash_generated_field = "DA21275F9D198D572B5ED7912FE37376")

    private static int SECONDARY_ORDER_MASK_ = 0x0000ff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "86B90CE2774A0F72004D42F08FE33A16", hash_generated_field = "8DB725CC88F78D8C351FD69EB0B3F806")

    private static int TERTIARY_ORDER_MASK_ = 0x000000ff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "E565E3FB89858732DE8C60EB5E0FCC5F", hash_generated_field = "185069D2E367BCB1B72AF129887B8ED4")

    private static int PRIMARY_ORDER_SHIFT_ = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "0C0C5671AE8F751C086EBF4EC331F0FC", hash_generated_field = "9464B702AFB2E353B5A844AD26E27ADC")

    private static int SECONDARY_ORDER_SHIFT_ = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.023 -0400", hash_original_field = "FF0C25747492EAF4673A968315463362", hash_generated_field = "4C9D4053714705070643F89FED1E63F9")

    private static int UNSIGNED_16_BIT_MASK_ = 0x0000FFFF;
}

