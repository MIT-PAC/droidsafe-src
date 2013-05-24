package droidsafe.analyses.infoflow;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DefaultHashMap<K,V> extends HashMap<K,V> {
    protected V defaultValue;

    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    public DefaultHashMap(DefaultHashMap<K, V> that) {
        super(that);
        this.defaultValue = that.defaultValue;
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        return ((value == null) && !this.containsKey(key)) ? this.defaultValue : value;
    }

    @Override
    public V remove(Object key) {
        V value = get(key);
        super.remove(key);
        return value;
    }

    @Override
    public V put(K key, V value) {
        V val = get(key);
        super.put(key, value);
        return val;
    }
}
