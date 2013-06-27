package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventListenerProxy;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.228 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.235 -0400", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "6A67FA688F424596DE50C0B9EFCFA30A")
    public  PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.236 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "5B2C40294C95E750156C19047F91CD2B")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_614245406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_614245406 = propertyName;
        varB4EAC82CA7396A68D541C85D26508E83_614245406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614245406;
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.236 -0400", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "BCE9C14ECBAB535F4BFF17A1886AC241")
    public void propertyChange(PropertyChangeEvent event) {
        PropertyChangeListener listener;
        listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //PropertyChangeListener listener = (PropertyChangeListener) getListener();
        //listener.propertyChange(event);
    }

    
}

