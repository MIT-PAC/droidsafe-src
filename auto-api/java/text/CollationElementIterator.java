package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.CollationElementIteratorICU;

public final class CollationElementIterator {
    private CollationElementIteratorICU icuIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.875 -0400", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "3F8A1C6A6236F5B6FAE7A6672359EB22")
    @DSModeled(DSC.SAFE)
     CollationElementIterator(CollationElementIteratorICU iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        // ---------- Original Method ----------
        //this.icuIterator = iterator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.875 -0400", hash_original_method = "3D8662E172DF94DE766C937C706B5067", hash_generated_method = "F200BFC0D9ECE6526F62F1D0C2DC5F62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxExpansion(int order) {
        dsTaint.addTaint(order);
        int var53B287FFE6A4D32D12803360CEDF35E3_123823353 = (this.icuIterator.getMaxExpansion(order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.getMaxExpansion(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.876 -0400", hash_original_method = "86FFE9FC429F590289C595CEB48BC74B", hash_generated_method = "AD288A664FB7C8647CAFEC2CC862828E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getOffset() {
        int var5739C0B4683059F65EBB237D4FD4211D_1040454503 = (this.icuIterator.getOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.getOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.876 -0400", hash_original_method = "57F823A473B8AE20AA92B1969F9DE507", hash_generated_method = "AA4C2CDCEAA6C0799357EA0E64D876C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() {
        int var066A4E6567C83EA54AE23323998B2CC8_75980492 = (this.icuIterator.next());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.876 -0400", hash_original_method = "3E3F3B80F1885FD18E0677AD75F46948", hash_generated_method = "9B6BB61E2010436949EADC2E9EDD2958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previous() {
        int varC24AAB22F8742E290FD8F53A2E6E0860_430649840 = (this.icuIterator.previous());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.previous();
    }

    
        public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.876 -0400", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "317A1E790ADE9D574D1C254F3228769B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        this.icuIterator.reset();
        // ---------- Original Method ----------
        //this.icuIterator.reset();
    }

    
        public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.877 -0400", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "F7B45FE4A1F405C109D5213EE45EFDA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOffset(int newOffset) {
        dsTaint.addTaint(newOffset);
        this.icuIterator.setOffset(newOffset);
        // ---------- Original Method ----------
        //this.icuIterator.setOffset(newOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.877 -0400", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "F1FB3FC1D8782A83843F041E605ADA9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharacterIterator source) {
        dsTaint.addTaint(source.dsTaint);
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.877 -0400", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "67EA04FB46D4484BBBF6909E208EE3BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String source) {
        dsTaint.addTaint(source);
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
        public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }

    
    public static final int NULLORDER = -1;
}

