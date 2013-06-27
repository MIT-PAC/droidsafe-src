package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.891 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.891 -0400", hash_original_method = "860D1012434BA4F5294622CC094A8203", hash_generated_method = "733ED98F45AD976973123D27FB5CE6CD")
    public  IndexedPropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue, int index) {
        super(source, propertyName, oldValue, newValue);
        this.index = index;
        addTaint(source.getTaint());
        addTaint(propertyName.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.892 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "072A5741B49CA4D72321501D73C0A474")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139319402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139319402;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.892 -0400", hash_original_field = "3E5C1BF2D1F4A60A90BEE05B200227FC", hash_generated_field = "1AFAE5941D42C3B101F4D8E337C7E2DF")

    private static long serialVersionUID = -320227448495806870L;
}

