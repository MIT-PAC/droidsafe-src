package java.beans;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventListenerProxy;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.301 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.301 -0400", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "6A67FA688F424596DE50C0B9EFCFA30A")
    public  PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
        addTaint(listener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.302 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "5F90A3C19958D97076B1622BE789F7CE")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1726047180 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1726047180 = propertyName;
        varB4EAC82CA7396A68D541C85D26508E83_1726047180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1726047180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.302 -0400", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "32A75A0826FBE276DBA5726942E69CF3")
    public void propertyChange(PropertyChangeEvent event) {
        PropertyChangeListener listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
        addTaint(event.getTaint());
        
        
        
    }

    
}

