package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.icu.CollationElementIteratorICU;

public final class CollationElementIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.504 -0400", hash_original_field = "30A759D190B9BD50E37FE9E9A3CC3CC5", hash_generated_field = "84C6F5065A9015D8FD721C1742E21463")

    private CollationElementIteratorICU icuIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.504 -0400", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "2A5E66AEE713561DB977D9A2014C7603")
      CollationElementIterator(CollationElementIteratorICU iterator) {
        this.icuIterator = iterator;
        // ---------- Original Method ----------
        //this.icuIterator = iterator;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.504 -0400", hash_original_method = "3D8662E172DF94DE766C937C706B5067", hash_generated_method = "DF613A46E1E453AF4034C056A306AFB7")
    public int getMaxExpansion(int order) {
        addTaint(order);
        int var6BA938A72BFAE853F0C37C0C94A382FD_2077356400 = (this.icuIterator.getMaxExpansion(order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356102946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356102946;
        // ---------- Original Method ----------
        //return this.icuIterator.getMaxExpansion(order);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.505 -0400", hash_original_method = "86FFE9FC429F590289C595CEB48BC74B", hash_generated_method = "AD302B8AC057E63647E538FBFF43603E")
    public int getOffset() {
        int var2C0856C7BD96514985EC50E55CBC1833_1827098661 = (this.icuIterator.getOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641077069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641077069;
        // ---------- Original Method ----------
        //return this.icuIterator.getOffset();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.505 -0400", hash_original_method = "57F823A473B8AE20AA92B1969F9DE507", hash_generated_method = "EB7B604C46FA45CEA18D5DFC3A95F141")
    public int next() {
        int varE587C240C870E1FC3E3F8202C77E0E6F_2124508962 = (this.icuIterator.next());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942295863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942295863;
        // ---------- Original Method ----------
        //return this.icuIterator.next();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.505 -0400", hash_original_method = "3E3F3B80F1885FD18E0677AD75F46948", hash_generated_method = "1DAD8B4A51FF83333F1733011FF1D543")
    public int previous() {
        int varF95DFE444B448C43503FCFC78023F105_1702430167 = (this.icuIterator.previous());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564300318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564300318;
        // ---------- Original Method ----------
        //return this.icuIterator.previous();
    }

    
        public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.506 -0400", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "317A1E790ADE9D574D1C254F3228769B")
    public void reset() {
        this.icuIterator.reset();
        // ---------- Original Method ----------
        //this.icuIterator.reset();
    }

    
        public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.506 -0400", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "D42505531F8E678D47D2F1164CEF7B12")
    public void setOffset(int newOffset) {
        addTaint(newOffset);
        this.icuIterator.setOffset(newOffset);
        // ---------- Original Method ----------
        //this.icuIterator.setOffset(newOffset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.506 -0400", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "A432A87B5B01B37C589FB0360C10E563")
    public void setText(CharacterIterator source) {
        addTaint(source.getTaint());
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.507 -0400", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "4A0000C9986C41D7D19356659DBCAF4C")
    public void setText(String source) {
        addTaint(source.getTaint());
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
        public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.507 -0400", hash_original_field = "CDF72F05F93E159801A5871838A03D4C", hash_generated_field = "507498C0E339FEAE686FB3D8460C0395")

    public static final int NULLORDER = -1;
}

