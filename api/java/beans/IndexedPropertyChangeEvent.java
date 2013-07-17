package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.119 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.119 -0400", hash_original_method = "860D1012434BA4F5294622CC094A8203", hash_generated_method = "A5A5FFDCF3878C5EE1A0BFFED9169421")
    public  IndexedPropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue, int index) {
        super(source, propertyName, oldValue, newValue);
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(propertyName.getTaint());
        addTaint(source.getTaint());
        this.index = index;
        // ---------- Original Method ----------
        //this.index = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.120 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "7ED9176B870982A8AA4F6ED4196EECD6")
    public int getIndex() {
        int var6A992D5529F459A44FEE58C733255E86_195952968 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796611275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796611275;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.120 -0400", hash_original_field = "3E5C1BF2D1F4A60A90BEE05B200227FC", hash_generated_field = "15EE4A8E739861F82460428634C59170")

    private static final long serialVersionUID = -320227448495806870L;
}

