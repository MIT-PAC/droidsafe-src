package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import libcore.icu.CollationElementIteratorICU;

public final class CollationElementIterator {
    public static final int NULLORDER = -1;
    private CollationElementIteratorICU icuIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.536 -0400", hash_original_method = "C4D82AD91997942FF2D2C5DD5D5F8256", hash_generated_method = "B79BC7D47DCD13F31F360E386FE895BA")
    @DSModeled(DSC.SAFE)
     CollationElementIterator(CollationElementIteratorICU iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        // ---------- Original Method ----------
        //this.icuIterator = iterator;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:36:41.462 -0400",hash_original_method="F642473139BF0FEECA4488F11934C82A",hash_generated_method="68ADC2128FAEEDE72B974D8526C24406")
public int getMaxExpansion(int order) {
        dsTaint.addTaint(order);
        int var53B287FFE6A4D32D12803360CEDF35E3_1523788110 = (this.icuIterator.getMaxExpansion(order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.getMaxExpansion(order);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:36:41.462 -0400",hash_original_method="F642473139BF0FEECA4488F11934C82A",hash_generated_method="68ADC2128FAEEDE72B974D8526C24406")
public int getOffset() {
        int var5739C0B4683059F65EBB237D4FD4211D_579055266 = (this.icuIterator.getOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.getOffset();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:36:41.462 -0400",hash_original_method="F642473139BF0FEECA4488F11934C82A",hash_generated_method="68ADC2128FAEEDE72B974D8526C24406")
public int next() {
        int var066A4E6567C83EA54AE23323998B2CC8_682403818 = (this.icuIterator.next());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.next();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:36:41.462 -0400",hash_original_method="F642473139BF0FEECA4488F11934C82A",hash_generated_method="68ADC2128FAEEDE72B974D8526C24406")
public int previous() {
        int varC24AAB22F8742E290FD8F53A2E6E0860_380927458 = (this.icuIterator.previous());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.icuIterator.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.539 -0400", hash_original_method = "D45AACC1784EFE96257BB7DED0205226", hash_generated_method = "7AF95849154BC919DB73EF5F0602B568")
    public static final int primaryOrder(int order) {
        return CollationElementIteratorICU.primaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.539 -0400", hash_original_method = "CFBEE5200E8F292823205998EF4A1A4C", hash_generated_method = "7D6C010611E50DAB5DFD8020B1E0A662")
    @DSModeled(DSC.SAFE)
    public void reset() {
        this.icuIterator.reset();
        // ---------- Original Method ----------
        //this.icuIterator.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.540 -0400", hash_original_method = "1140CD5E96A0E40D8BD81BCBE0AC1128", hash_generated_method = "85B1520249AF45217F458EC4D3DC1BA8")
    public static final short secondaryOrder(int order) {
        return (short) CollationElementIteratorICU.secondaryOrder(order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.541 -0400", hash_original_method = "B5159E04ADD34F8792FC76901FA3C75B", hash_generated_method = "C239BB85D1059188852E26AE20680530")
    @DSModeled(DSC.SAFE)
    public void setOffset(int newOffset) {
        dsTaint.addTaint(newOffset);
        this.icuIterator.setOffset(newOffset);
        // ---------- Original Method ----------
        //this.icuIterator.setOffset(newOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.542 -0400", hash_original_method = "4B7E5FB8D17EE6600C521F075CD85C4D", hash_generated_method = "9F6011742D5B76675F830503EA9B04BD")
    @DSModeled(DSC.SAFE)
    public void setText(CharacterIterator source) {
        dsTaint.addTaint(source.dsTaint);
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.543 -0400", hash_original_method = "5641B3FAAAA5E41E8D2876C4B877177C", hash_generated_method = "38FFD2415D172CB62691E3DF5FAB34A8")
    @DSModeled(DSC.SAFE)
    public void setText(String source) {
        dsTaint.addTaint(source);
        this.icuIterator.setText(source);
        // ---------- Original Method ----------
        //this.icuIterator.setText(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.544 -0400", hash_original_method = "F642473139BF0FEECA4488F11934C82A", hash_generated_method = "68ADC2128FAEEDE72B974D8526C24406")
    public static final short tertiaryOrder(int order) {
        return (short) CollationElementIteratorICU.tertiaryOrder(order);
    }

    
}


