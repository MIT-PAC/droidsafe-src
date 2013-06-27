package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.CollationElementIteratorICU;

public final class CollationElementIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.339 -0400", hash_original_field = "30A759D190B9BD50E37FE9E9A3CC3CC5", hash_generated_field = "84C6F5065A9015D8FD721C1742E21463")

    private CollationElementIteratorICU icuIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.339 -0400", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "2A5E66AEE713561DB977D9A2014C7603")
      CollationElementIterator(CollationElementIteratorICU iterator) {
        this.icuIterator = iterator;
        // ---------- Original Method ----------
        //this.icuIterator = iterator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.339 -0400", hash_original_method = "3D8662E172DF94DE766C937C706B5067", hash_generated_method = "F145B3427DB73252F7AB5AD937CCBEE2")
    public int getMaxExpansion(int order) {
        int var53B287FFE6A4D32D12803360CEDF35E3_1755362685 = (this.icuIterator.getMaxExpansion(order));
        addTaint(order);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152171721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152171721;
        // ---------- Original Method ----------
        //return this.icuIterator.getMaxExpansion(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.340 -0400", hash_original_method = "86FFE9FC429F590289C595CEB48BC74B", hash_generated_method = "97B1E4EC3879849738E6182A874532AE")
    public int getOffset() {
        int var5739C0B4683059F65EBB237D4FD4211D_209584114 = (this.icuIterator.getOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001158810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001158810;
        // ---------- Original Method ----------
        //return this.icuIterator.getOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.340 -0400", hash_original_method = "57F823A473B8AE20AA92B1969F9DE507", hash_generated_method = "950713C32460F0E9354476AF293E65B5")
    public int next() {
        int var066A4E6567C83EA54AE23323998B2CC8_1258728371 = (this.icuIterator.next());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712992106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712992106;
        // ---------- Original Method ----------
        //return this.icuIterator.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.340 -0400", hash_original_method = "3E3F3B80F1885FD18E0677AD75F46948", hash_generated_method = "56DEA80B529BE9A711171415CC647D68")
    public int previous() {
        int varC24AAB22F8742E290FD8F53A2E6E0860_184932332 = (this.icuIterator.previous());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522516856 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522516856;
        // ---------- Original Method ----------
        //return this.icuIterator.previous();
    }

    
        public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.341 -0400", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "317A1E790ADE9D574D1C254F3228769B")
    public void reset() {
        this.icuIterator.reset();
        // ---------- Original Method ----------
        //this.icuIterator.reset();
    }

    
        public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.341 -0400", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "A07CCFA422054CD58D224664976D7AC4")
    public void setOffset(int newOffset) {
        this.icuIterator.setOffset(newOffset);
        addTaint(newOffset);
        // ---------- Original Method ----------
        //this.icuIterator.setOffset(newOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.341 -0400", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "26A396D324C250CE0217BF22C38507DA")
    public void setText(CharacterIterator source) {
        this.icuIterator.setText(source);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.342 -0400", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "EB92E4AF042884D10C97EA0C0888CCDF")
    public void setText(String source) {
        this.icuIterator.setText(source);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
        public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.342 -0400", hash_original_field = "CDF72F05F93E159801A5871838A03D4C", hash_generated_field = "507498C0E339FEAE686FB3D8460C0395")

    public static final int NULLORDER = -1;
}

