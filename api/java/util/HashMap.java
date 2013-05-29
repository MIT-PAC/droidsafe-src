package java.util;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class HashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable {
	// DSModeled:  Add key and value for tracking values
	K key;
	V value;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return dsTaint.getTaintBoolean();
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return dsTaint.getTaintBoolean();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return (Set<java.util.Map.Entry<K, V>>)dsTaint.getTaint();
	}

	@DSModeled(DSC.SAFE)
	@Override
	public V get(Object arg0) {
		return (V)dsTaint.getTaint();
		/*
		if (key == null) {
            HashMapEntry<K, V> e = entryForNullKey;
            return e == null ? null : e.value;
        }

        // Doug Lea's supplemental secondaryHash function (inlined)
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);

        HashMapEntry<K, V>[] tab = table;
        for (HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
                e != null; e = e.next) {
            K eKey = e.key;
            if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                return e.value;
            }
        }
        return null;
        */
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return dsTaint.getTaintBoolean();
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return (Set<K>)dsTaint.getTaint();
	}

	@Override
	@DSModeled(DSC.SAFE)
	public V put(K arg0, V arg1) {
		//dsTaint.addTaint(arg0.dsTaint, arg1.dsTaint);
		//DSFIXME:  Can't conflate until we plumb through dsTaint in Object
		key = arg0;
		value = arg1;
		return (V)dsTaint.getTaint();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SAFE)
    public HashMap() {
		/*
        table = (HashMapEntry<K, V>[]) EMPTY_TABLE;
        threshold = -1; // Forces first put invocation to replace EMPTY_TABLE
        */
    }

}
