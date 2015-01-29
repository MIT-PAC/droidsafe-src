package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.228 -0500", hash_original_field = "B02A1F0D1203DE34BB9BF2014933A140", hash_generated_field = "E6562888893882FF6552413C35A8C7AF")

    private static final long serialVersionUID = 7042693688939648123L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.230 -0500", hash_original_field = "F6E23082B68F75302CA6A0F5F57467FF", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.232 -0500", hash_original_field = "960A7902634592C07CD47A2F225C6AD8", hash_generated_field = "960A7902634592C07CD47A2F225C6AD8")

    Object oldValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.234 -0500", hash_original_field = "B1A1DE6E10506FDF1F20E177533AEE3E", hash_generated_field = "B1A1DE6E10506FDF1F20E177533AEE3E")

    Object newValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.237 -0500", hash_original_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88", hash_generated_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88")

    Object propagationId;

    /**
     * The constructor used to create a new {@code PropertyChangeEvent}.
     *
     * @param source
     *            the changed bean.
     * @param propertyName
     *            the changed property, or <code>null</code> to indicate an
     *            unspecified set of the properties has changed.
     * @param oldValue
     *            the previous value of the property, or <code>null</code> if
     *            the <code>propertyName</code> is <code>null</code> or the
     *            previous value is unknown.
     * @param newValue
     *            the new value of the property, or <code>null</code> if the
     *            <code>propertyName</code> is <code>null</code> or the new
     *            value is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.240 -0500", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "13D6616BBC8230FD1098109DD2F300ED")
    
public PropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue) {
        super(source);

        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Returns the name of the property that has changed. If an unspecified set
     * of properties has changed it returns null.
     *
     * @return the name of the property that has changed, or null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.242 -0500", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "79D137ECBA6D10D7E0F2DC15CD7EDB65")
    
public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the propagationId object.
     *
     * @see #getPropagationId()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.244 -0500", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "67506D72A9ECA48F6877280A845E3FE9")
    
public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
    }

    /**
     * Returns the propagationId object. This is reserved for future use. Beans
     * 1.0 demands that a listener receiving this property and then sending its
     * own PropertyChangeEvent sets the received propagationId on the new
     * PropertyChangeEvent's propagationId field.
     *
     * @return the propagationId object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.247 -0500", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "7D15BB631FB5997900F66BD721659878")
    
public Object getPropagationId() {
        return propagationId;
    }

    /**
     * Returns the old value that the property had. If the old value is unknown
     * this method returns null.
     *
     * @return the old property value or null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.250 -0500", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "7AFA9801F3D766F442A5CBEB2FBAF866")
    
public Object getOldValue() {
        return oldValue;
    }

    /**
     * Returns the new value that the property now has. If the new value is
     * unknown this method returns null.
     *
     * @return the old property value or null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.252 -0500", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "CFD9A4C92E90EFFA42437FFBAECBE674")
    
public Object getNewValue() {
        return newValue;
    }
}

