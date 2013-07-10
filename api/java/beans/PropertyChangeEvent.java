package java.beans;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.292 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.292 -0400", hash_original_field = "0382B9FD9EF50B6A335F35E0AAAEBF99", hash_generated_field = "960A7902634592C07CD47A2F225C6AD8")

    Object oldValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.292 -0400", hash_original_field = "7F7CFDE5EC586119B48911A2C75851E5", hash_generated_field = "B1A1DE6E10506FDF1F20E177533AEE3E")

    Object newValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.292 -0400", hash_original_field = "395600DB5D6C7217F52C02B5FEE8B3FB", hash_generated_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88")

    Object propagationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.293 -0400", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "BBF7E086C2E072B45F9714016AD577CD")
    public  PropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue) {
        super(source);
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        addTaint(source.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.293 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "2D85D5BB89F86A8D1AE1C0C0177C468B")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1468710993 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1468710993 = propertyName;
        varB4EAC82CA7396A68D541C85D26508E83_1468710993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1468710993;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.293 -0400", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "99F56DD866E50C8B6DA45D24B96D6C66")
    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.294 -0400", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "8316B802D498BBC8FEA7B8E25C6E2367")
    public Object getPropagationId() {
        Object varB4EAC82CA7396A68D541C85D26508E83_764275430 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_764275430 = propagationId;
        varB4EAC82CA7396A68D541C85D26508E83_764275430.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_764275430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.294 -0400", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "14FA1A26C54B0A34D115721A02235A12")
    public Object getOldValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1254636291 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1254636291 = oldValue;
        varB4EAC82CA7396A68D541C85D26508E83_1254636291.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1254636291;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.294 -0400", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "9EB8F9770DE5C07477408565AACFBBFC")
    public Object getNewValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1734023643 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1734023643 = newValue;
        varB4EAC82CA7396A68D541C85D26508E83_1734023643.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1734023643;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.294 -0400", hash_original_field = "82D11D8EBC6C3E983DD174677B6801AA", hash_generated_field = "E6562888893882FF6552413C35A8C7AF")

    private static final long serialVersionUID = 7042693688939648123L;
}

