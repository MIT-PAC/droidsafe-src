package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public abstract class Property<T, V> {

    
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.281 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")


    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.282 -0500", hash_original_field = "D10D35AEFBC430193A73D9A283FB42AF", hash_generated_field = "044FCC1E758F4DBF4DDAD38EDF0B8FEE")

    private  Class<V> mType;
    
    @DSModeled(DSC.SAFE)
    public Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        addTaint(name.getTaint()); 
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return getTaintBoolean();
    }

    
    public void set(T object, V value) {
    }

    /**
     * Returns the current value that this property represents on the given <code>object</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.286 -0500", hash_original_method = "6E055708EB60102C3FE3DC026AFEF30C", hash_generated_method = "749817522EE38AE315B321DE724B9835")
    public abstract V get(T object);

    /**
     * Returns the name for this property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.287 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    public String getName() {
        return mName;
    }

    /**
     * Returns the type for this property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.287 -0500", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "AEADE2CE4339C26821488FD91ADB8EEE")
    public Class<V> getType() {
        return mType;
    }

    
}

