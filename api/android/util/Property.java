package android.util;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }
    @DSModeled(DSC.SAFE)
    public Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        addTaint(name); 
    }
    public boolean isReadOnly() {
        return getTaintBoolean();
    }
    
    // How can we tell if object or value has  object
    public void set(T object, V value) {
        
    }
    public abstract V get(T object);
    
    @DSModeled (DSC.SAFE)
    public String getName() {
        return getTaintString();
    }
    public Class<V> getType() {
        return mType;
    }
}
