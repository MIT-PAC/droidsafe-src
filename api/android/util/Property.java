package android.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;
    
    @DSModeled(DSC.SAFE)
    public Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        addTaint(name.getTaint()); 
    }

    
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
    public boolean isReadOnly() {
        return getTaintBoolean();
    }

    
    public void set(T object, V value) {
    }

    
    public abstract V get(T object);

    
    @DSModeled (DSC.SAFE)
    public String getName() {
        return mName;
    }

    
    public Class<V> getType() {
        return mType;
    }

    
}

