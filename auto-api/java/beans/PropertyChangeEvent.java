package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
    String propertyName;
    Object oldValue;
    Object newValue;
    Object propagationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.327 -0400", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "EFD52E9D45C0FEA2699C8D5D70E4AFEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue) {
        super(source);
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
        //this.oldValue = oldValue;
        //this.newValue = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.328 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "743F222F0FF20F893D2C12F74C9DD51F")
    @DSModeled(DSC.SAFE)
    public String getPropertyName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.328 -0400", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "B3567C75B85FFC26FCC5DBDE10921EAC")
    @DSModeled(DSC.SAFE)
    public void setPropagationId(Object propagationId) {
        dsTaint.addTaint(propagationId.dsTaint);
        // ---------- Original Method ----------
        //this.propagationId = propagationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.328 -0400", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "40BA5CA89A242A1D6563470CBBD06984")
    @DSModeled(DSC.SAFE)
    public Object getPropagationId() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return propagationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.328 -0400", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "81020607366851C066E627E2D6163AEF")
    @DSModeled(DSC.SAFE)
    public Object getOldValue() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.328 -0400", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "DDF382900D1542CE1F41595717ABC93F")
    @DSModeled(DSC.SAFE)
    public Object getNewValue() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return newValue;
    }

    
    private static final long serialVersionUID = 7042693688939648123L;
}

