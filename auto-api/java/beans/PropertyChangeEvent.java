package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.902 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.902 -0400", hash_original_field = "0382B9FD9EF50B6A335F35E0AAAEBF99", hash_generated_field = "960A7902634592C07CD47A2F225C6AD8")

    Object oldValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.902 -0400", hash_original_field = "7F7CFDE5EC586119B48911A2C75851E5", hash_generated_field = "B1A1DE6E10506FDF1F20E177533AEE3E")

    Object newValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.902 -0400", hash_original_field = "395600DB5D6C7217F52C02B5FEE8B3FB", hash_generated_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88")

    Object propagationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.904 -0400", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "BBF7E086C2E072B45F9714016AD577CD")
    public  PropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue) {
        super(source);
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
        //this.oldValue = oldValue;
        //this.newValue = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.904 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "D90DE1BEF5EB4A5F4DC036A7C921DDB4")
    public String getPropertyName() {
        String varB4EAC82CA7396A68D541C85D26508E83_137713717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_137713717 = propertyName;
        varB4EAC82CA7396A68D541C85D26508E83_137713717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_137713717;
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.904 -0400", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "99F56DD866E50C8B6DA45D24B96D6C66")
    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
        // ---------- Original Method ----------
        //this.propagationId = propagationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.905 -0400", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "41EA3A26DD4E45E5769B1D58ED482FA8")
    public Object getPropagationId() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1153616500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1153616500 = propagationId;
        varB4EAC82CA7396A68D541C85D26508E83_1153616500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153616500;
        // ---------- Original Method ----------
        //return propagationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.905 -0400", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "9D5CBDE5881DD28D81D662DC61119711")
    public Object getOldValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1544122645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1544122645 = oldValue;
        varB4EAC82CA7396A68D541C85D26508E83_1544122645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544122645;
        // ---------- Original Method ----------
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "97B63517133887BDEE827D905EDFCA42")
    public Object getNewValue() {
        Object varB4EAC82CA7396A68D541C85D26508E83_235772032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_235772032 = newValue;
        varB4EAC82CA7396A68D541C85D26508E83_235772032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_235772032;
        // ---------- Original Method ----------
        //return newValue;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:36.915 -0400", hash_original_field = "82D11D8EBC6C3E983DD174677B6801AA", hash_generated_field = "CF2416C6D638D28E3D378BF04D5411E9")

    private static long serialVersionUID = 7042693688939648123L;
}

