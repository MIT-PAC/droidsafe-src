package java.beans;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventListenerProxy;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.668 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.669 -0400", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "3F85D01D8D9BC4DC92208A056D62ADE1")
    public  PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        addTaint(listener.getTaint());
        this.propertyName = propertyName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.669 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "F7AA94D4443A9B45822A90B6167CA6BB")
    public String getPropertyName() {
String var3D632F0E4FFF94E691F92D3669CF1392_1917840490 =         propertyName;
        var3D632F0E4FFF94E691F92D3669CF1392_1917840490.addTaint(taint);
        return var3D632F0E4FFF94E691F92D3669CF1392_1917840490;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.669 -0400", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "8B64B5CEB711C3F7D18A7823B5846CFC")
    public void propertyChange(PropertyChangeEvent event) {
        addTaint(event.getTaint());
        PropertyChangeListener listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
        
        
        
    }

    
}

