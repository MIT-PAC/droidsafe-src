package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.icu.CollationElementIteratorICU;





public final class CollationElementIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.663 -0400", hash_original_field = "30A759D190B9BD50E37FE9E9A3CC3CC5", hash_generated_field = "84C6F5065A9015D8FD721C1742E21463")

    private CollationElementIteratorICU icuIterator;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.663 -0400", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "2A5E66AEE713561DB977D9A2014C7603")
      CollationElementIterator(CollationElementIteratorICU iterator) {
        this.icuIterator = iterator;
        // ---------- Original Method ----------
        //this.icuIterator = iterator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.663 -0400", hash_original_method = "3D8662E172DF94DE766C937C706B5067", hash_generated_method = "BCD8859101180CFFDFE8B84D18D98CFB")
    public int getMaxExpansion(int order) {
        addTaint(order);
        int var6BA938A72BFAE853F0C37C0C94A382FD_180264485 = (this.icuIterator.getMaxExpansion(order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507111840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507111840;
        // ---------- Original Method ----------
        //return this.icuIterator.getMaxExpansion(order);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.664 -0400", hash_original_method = "86FFE9FC429F590289C595CEB48BC74B", hash_generated_method = "C3C306ED1EBE4FF8A20435561004CB77")
    public int getOffset() {
        int var2C0856C7BD96514985EC50E55CBC1833_636811793 = (this.icuIterator.getOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182328193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182328193;
        // ---------- Original Method ----------
        //return this.icuIterator.getOffset();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.665 -0400", hash_original_method = "57F823A473B8AE20AA92B1969F9DE507", hash_generated_method = "D530C24403DACFCE1F91143EA2C53940")
    public int next() {
        int varE587C240C870E1FC3E3F8202C77E0E6F_1423769142 = (this.icuIterator.next());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005338039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005338039;
        // ---------- Original Method ----------
        //return this.icuIterator.next();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.665 -0400", hash_original_method = "3E3F3B80F1885FD18E0677AD75F46948", hash_generated_method = "75442391ABBAB709C73C5B82A403FFFA")
    public int previous() {
        int varF95DFE444B448C43503FCFC78023F105_796814460 = (this.icuIterator.previous());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305484591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305484591;
        // ---------- Original Method ----------
        //return this.icuIterator.previous();
    }

    
    @DSModeled(DSC.SAFE)
    public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.666 -0400", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "317A1E790ADE9D574D1C254F3228769B")
    public void reset() {
        this.icuIterator.reset();
        // ---------- Original Method ----------
        //this.icuIterator.reset();
    }

    
    @DSModeled(DSC.SAFE)
    public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.667 -0400", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "D42505531F8E678D47D2F1164CEF7B12")
    public void setOffset(int newOffset) {
        addTaint(newOffset);
        this.icuIterator.setOffset(newOffset);
        // ---------- Original Method ----------
        //this.icuIterator.setOffset(newOffset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.667 -0400", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "A432A87B5B01B37C589FB0360C10E563")
    public void setText(CharacterIterator source) {
        addTaint(source.getTaint());
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.668 -0400", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "4A0000C9986C41D7D19356659DBCAF4C")
    public void setText(String source) {
        addTaint(source.getTaint());
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSModeled(DSC.SAFE)
    public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.668 -0400", hash_original_field = "CDF72F05F93E159801A5871838A03D4C", hash_generated_field = "507498C0E339FEAE686FB3D8460C0395")

    public static final int NULLORDER = -1;
}

