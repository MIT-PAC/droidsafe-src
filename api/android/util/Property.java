package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;



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

    
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return getTaintBoolean();
    }

    
    public void set(T object, V value) {
    }

    
    @DSModeled(DSC.SAFE)
    public abstract V get(T object);

    
    @DSModeled(DSC.SAFE)
    public String getName() {
        return mName;
    }

    
    @DSModeled(DSC.SAFE)
    public Class<V> getType() {
        return mType;
    }

    
}

