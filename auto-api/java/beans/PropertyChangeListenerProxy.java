package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventListenerProxy;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    String propertyName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.330 -0400", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "C60867C22694BCA48D2E8C2BD30AAF8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.330 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "743F222F0FF20F893D2C12F74C9DD51F")
    @DSModeled(DSC.SAFE)
    public String getPropertyName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.330 -0400", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "89695884FC15B09F8AEF9EB566F2A1F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void propertyChange(PropertyChangeEvent event) {
        dsTaint.addTaint(event.dsTaint);
        PropertyChangeListener listener;
        listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
        // ---------- Original Method ----------
        //PropertyChangeListener listener = (PropertyChangeListener) getListener();
        //listener.propertyChange(event);
    }

    
}

