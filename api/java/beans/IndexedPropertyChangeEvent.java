package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.644 -0500", hash_original_field = "6D3B98F4853D9FAFDBF67D5E996F7D2E", hash_generated_field = "15EE4A8E739861F82460428634C59170")


    private static final long serialVersionUID = -320227448495806870L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.645 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")


    private  int index;

    /**
     * Creates a new property changed event with an indication of the property
     * index.
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
     *            value is unknown..
     * @param index
     *            the index of the property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.645 -0500", hash_original_method = "860D1012434BA4F5294622CC094A8203", hash_generated_method = "B432C0392C87ECF9CB7377C3B98ECD77")
    public IndexedPropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue, int index) {
        super(source, propertyName, oldValue, newValue);
        this.index = index;
    }

    /**
     * Returns the index of the property that was changed in this event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.646 -0500", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "96CCC69099797392A28F97F5383D17E0")
    public int getIndex() {
        return index;
    }
}

