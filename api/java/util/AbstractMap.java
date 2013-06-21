package java.util;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractMap<K, V> implements Map<K,V> {
    
    Set<K> keySet;
    Collection<V> valuesCollection;
    
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K,V>, Serializable {
        
        private static final long serialVersionUID = 7138329143949025153L;
        private /*final*/ K key;
        private /*final*/ V value;
        
        public SimpleImmutableEntry(K theKey, V theValue){
            key = theKey;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            value = theValue;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            key = theKey;
            value = theValue;
            */
        }
        
        public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> copyFrom){
            /*
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            */
        }
        
        public K getKey(){
            return key;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return key;
        }
            */
        }
        
        public V getValue(){
            return value;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return value;
        }
            */
        }
        
        public V setValue(V object){
            throw new UnsupportedOperationException();
            // Original method
            /*
            {
            throw new UnsupportedOperationException();
        }
            */
        }
        
        @Override public boolean equals(Object object){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            return getTaintBoolean();

            // Original method
            /*
            {
            if (this == object) {
                return true;
            }
            if (object instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                return (key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()));
            }
            return false;
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return key + "=" + value;
        }
            */
        }
    }
    
    
    public static class SimpleEntry<K, V> implements Map.Entry<K,V>, Serializable {
        
        private static final long serialVersionUID = -8499721149061103585L;
        private /*final*/ K key;
        private V value;
        
        public SimpleEntry(K theKey, V theValue){
            key = theKey;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            value = theValue;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            /*
            key = theKey;
            value = theValue;
            */
        }
        
        public SimpleEntry(Map.Entry<? extends K, ? extends V> copyFrom){
            /*
            key = copyFrom.getKey();
            value = copyFrom.getValue();
            */
        }
        
        public K getKey(){
            return key;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return key;
        }
            */
        }
        
        public V getValue(){
            return value;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            return value;
        }
            */
        }
        
        public V setValue(V object){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            V result = value;
            value = object;  //DSFIXME:  CODE0003: Field assignment should be reviewed
            return result;  //DSFIXME:  CODE0001: Unresolved return type/value combination

            // Original method
            /*
            {
            V result = value;
            value = object;
            return result;
        }
            */
        }
        
        @Override public boolean equals(Object object){
            //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            return getTaintBoolean();

            // Original method
            /*
            {
            if (this == object) {
                return true;
            }
            if (object instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                return (key == null ? entry.getKey() == null : key.equals(entry
                        .getKey()))
                        && (value == null ? entry.getValue() == null : value
                                .equals(entry.getValue()));
            }
            return false;
        }
            */
        }
        
        @Override public int hashCode(){
            return getTaintInt();

            // Original method
            /*
            {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }
            */
        }
        
        @Override public String toString(){
            return getTaintString();

            // Original method
            /*
            {
            return key + "=" + value;
        }
            */
        }
    }
    
    
    @DSModeled(DSC.SAFE)
    protected AbstractMap(){
    }
    
    public void clear(){
        entrySet().clear();
        // Original method
        /*
        {
        entrySet().clear();
    }
        */
    }
    
    public boolean containsKey(Object key){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        return getTaintBoolean();

        // Original method
        /*
        {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        if (key != null) {
            while (it.hasNext()) {
                if (key.equals(it.next().getKey())) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next().getKey() == null) {
                    return true;
                }
            }
        }
        return false;
    }
        */
    }
    
    public boolean containsValue(Object value){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        return getTaintBoolean();

        // Original method
        /*
        {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        if (value != null) {
            while (it.hasNext()) {
                if (value.equals(it.next().getValue())) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next().getValue() == null) {
                    return true;
                }
            }
        }
        return false;
    }
        */
    }
    
    public abstract Set<Map.Entry<K, V>> entrySet();
    
    @Override public boolean equals(Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Map<?, ?> map = (Map<?, ?>) object;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //K key = entry.getKey();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //V mine = entry.getValue();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Object theirs = map.get(key);
        return getTaintBoolean();

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    public V get(Object key){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Map.Entry<K, V> entry = it.next();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Map.Entry<K, V> entry = it.next();
        //DSFIXME:  CODE0006: Method has multiple returns and requires manual review
        //return null;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        return entry.getValue();  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /*
        {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        if (key != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                if (key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        } else {
            while (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                if (entry.getKey() == null) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
        */
    }
    
    @Override public int hashCode(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //int result = 0;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //result += it.next().hashCode();
        return getTaintInt();

        // Original method
        /*
        {
        int result = 0;
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            result += it.next().hashCode();
        }
        return result;
    }
        */
    }
    
    public boolean isEmpty(){
        return getTaintBoolean();

        // Original method
        /*
        {
        return size() == 0;
    }
        */
    }
    
    public Set<K> keySet(){
        return keySet;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    public V put(K key, V value){
        throw new UnsupportedOperationException();
        // Original method
        /*
        {
        throw new UnsupportedOperationException();
    }
        */
    }
    
    public void putAll(Map<? extends K, ? extends V> map){
        // Original method
        /*
        {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }
        */
    }
    
    public V remove(Object key){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Map.Entry<K, V> entry = it.next();
        //it.remove();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Map.Entry<K, V> entry = it.next();
        it.remove();
        //DSFIXME:  CODE0006: Method has multiple returns and requires manual review
        //return null;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        return entry.getValue();  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /*
        {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        if (key != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                if (key.equals(entry.getKey())) {
                    it.remove();
                    return entry.getValue();
                }
            }
        } else {
            while (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                if (entry.getKey() == null) {
                    it.remove();
                    return entry.getValue();
                }
            }
        }
        return null;
    }
        */
    }
    
    public int size(){
        return getTaintInt();

        // Original method
        /*
        {
        return entrySet().size();
    }
        */
    }
    
    @Override public String toString(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //StringBuilder buffer = new StringBuilder(size() * 28);
        //buffer.append('{');
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Map.Entry<K, V> entry = it.next();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Object key = entry.getKey();
        //buffer.append(key);
        //buffer.append("(this Map)");
        //buffer.append('=');
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Object value = entry.getValue();
        //buffer.append(value);
        //buffer.append("(this Map)");
        //buffer.append(", ");
        //buffer.append('}');
        return getTaintString();

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    public Collection<V> values(){
        return valuesCollection;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    @SuppressWarnings("unchecked") @Override protected Object clone(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        return ;  //DSFIXME:  CODE0001: Unresolved return type/value combination

        // Original method
        /*
        {
        AbstractMap<K, V> result = (AbstractMap<K, V>) super.clone();
        result.keySet = null;
        result.valuesCollection = null;
        return result;
    }
        */
    }
}

