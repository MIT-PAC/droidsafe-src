package java.beans;

// Droidsafe Imports
import java.util.EventListenerProxy;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.137 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.139 -0400", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "3F85D01D8D9BC4DC92208A056D62ADE1")
    public  PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        addTaint(listener.getTaint());
        this.propertyName = propertyName;
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.139 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "1701FD2CECBBB30D39A885422C9E650A")
    public String getPropertyName() {
String var3D632F0E4FFF94E691F92D3669CF1392_2123913349 =         propertyName;
        var3D632F0E4FFF94E691F92D3669CF1392_2123913349.addTaint(taint);
        return var3D632F0E4FFF94E691F92D3669CF1392_2123913349;
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.140 -0400", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "8B64B5CEB711C3F7D18A7823B5846CFC")
    public void propertyChange(PropertyChangeEvent event) {
        addTaint(event.getTaint());
        PropertyChangeListener listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
        // ---------- Original Method ----------
        //PropertyChangeListener listener = (PropertyChangeListener) getListener();
        //listener.propertyChange(event);
    }

    
}

