package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.326 -0400", hash_original_method = "860D1012434BA4F5294622CC094A8203", hash_generated_method = "8B62499DB144417B790AE4F8F1942030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IndexedPropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue, int index) {
        super(source, propertyName, oldValue, newValue);
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(index);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        // ---------- Original Method ----------
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.326 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "48B0F5CEF7537869A6C46DF0BD2A31DE")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return index;
    }

    
    private static final long serialVersionUID = -320227448495806870L;
}

