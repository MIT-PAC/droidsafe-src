package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventListenerProxy;






public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.536 -0500", hash_original_field = "F6E23082B68F75302CA6A0F5F57467FF", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")


    String propertyName;

    /**
     * Creates a new listener proxy that associates a listener with a property
     * name.
     *
     * @param propertyName
     *            the name of the associated property.
     * @param listener
     *            the listener to delegate incoming events to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.537 -0500", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "678F242E04D04F6D88BA9B8744D64E7F")
    public PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
    }

    /**
     * Returns the name of the property associated with this listener proxy.
     *
     * @return the name of the associated property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.537 -0500", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "79D137ECBA6D10D7E0F2DC15CD7EDB65")
    public String getPropertyName() {
        return propertyName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.538 -0500", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "AF25D61E9DB4ACA7583E68CD25FCD032")
    public void propertyChange(PropertyChangeEvent event) {
        PropertyChangeListener listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
    }

    
}

