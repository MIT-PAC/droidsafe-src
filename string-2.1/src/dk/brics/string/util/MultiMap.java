package dk.brics.string.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Maps keys to sets of values. 
 * 
 * <p>For practical reasons, this does <i>not</i> implement <code>Map&lt;K, Set&lt;V&gt;&gt;</code>, although
 * it is conceptually that type of map.
 * 
 * @param <K> key type
 * @param <V> value type
 */
public class MultiMap<K, V> {
	
	private HashMap<K, Set<V>> map = new HashMap<K, Set<V>>();
	private int size = 0;
	
	/**
	 * Returns the set of keys with at least one associated value, backed by the multimap.
	 * 
	 * <p>Keys may be removed from the returned set, but attempting to add a key will throw
	 * an {@link UnsupportedOperationException}. Removing a key will disconnect all existing
	 * views of that particular key from the multimap.
	 * @return a view of the keys in the multimap.
	 */
	public Set<K> keySet() {
		return map.keySet();
	}
	
	/**
	 * Returns any of the keys in the map, that has at least one associated value.
	 * @return a key from the map, or <tt>null</tt> if the map is empty. 
	 */
	public K getAnyKey() {
		if (map.size() == 0)
			return null;
		return map.keySet().iterator().next();
	}
	
	/**
	 * Returns any of the values associated with the specified key, or null if no
	 * values are associated with the key.
	 */
	public V getAnyValue(K key) {
		Set<V> v = map.get(key);
		if (v == null)
			return null;
		return v.iterator().next();
	}
	
	/**
	 * Adds a key-value pair to the multimap.
	 * @return true if the pair was added, and false if it was already there.
	 */
	public boolean add(K key, V value) {
		Set<V> set = map.get(key);
		if (set == null) {
			set = new HashSet<V>();
			set.add(value);
			map.put(key, set);
			size++;
			return true;
		} else {
			boolean added = set.add(value);
			if (added)
				size++;
			return added;
		}
	}
	
	/**
	 * Adds a key-value pair for each value in the specified set.
	 * @param key the key to associate with each of the specified values.
	 * @param values the values to associate with the specified key.
	 * @return <tt>true</tt> if at least one new mapping was created.
	 */
	public boolean addAll(K key, Collection<? extends V> values) {
		if (values.size() == 0)
			return false;
		Set<V> set = map.get(key);
		if (set == null) {
			set = new HashSet<V>(values);
			map.put(key, set);
			size += values.size();
			return true;
		}
		boolean changed = false;
		for (V v : values) {
			if (set.add(v)) {
				size++;
				changed = true;
			}
		}
		return changed;
	}
	
	/**
	 * Adds all key-value pairs from the other map to this map.
	 * Existing mappings are not removed.
	 * @param other another multi map.
	 * @return <tt>true</tt> if at least one new mapping was created.
	 */
	public <K2 extends K, V2 extends V> boolean putAll(MultiMap<K2, V2> other) {
		boolean changed = false;
		for (Map.Entry<K2, Set<V2>> entry : other.map.entrySet()) {
			changed |= addAll(entry.getKey(), entry.getValue());
		}
		return changed;
	}
	
	/**
	 * Removes a key-value pair from the multimap.
	 * @param key
	 * @param value
	 * @return true if the pair was removed, and false if it was not there in the first place.
	 */
	public boolean remove(K key, V value) {
		Set<V> set = map.get(key);
		if (set == null)
			return false;
		if (set.remove(value)) {
			size--;
			if (set.size() == 0)
				map.remove(key);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes all key-value pairs with the specified key.
	 * @param key key to remove from the map.
	 * @return <tt>true</tt> if the map changed.
	 */
	public boolean removeAll(K key) {
		Set<V> set = map.get(key);
		if (set == null)
			return false;
		size -= set.size();
		set.clear();
		map.remove(key);
		return true;
	}
	
	/**
	 * Returns a read-only view of the items associated with the specified key.
	 * Changes to the multimap <em>may or may not</em> propagate to the view!
	 * 
	 * <p>In the current implementation, changes always propagate until the
	 * specified key has no associated values, at which point all existing views
	 * of that key are cleared and disconnected from the multimap.
	 * 
	 * @return a read-only set partly backed by the multimap. Null is never returned.
	 */
	public Set<V> getView(K key) {
		Set<V> set = map.get(key);
		if (set == null)
			return Collections.<V>emptySet();
		return Collections.unmodifiableSet(set);
	}
	
	/**
	 * Returns a copy of the set of items associated with the specified key.
	 * Changes to the multimap will not affect the returned set, and vice versa.
	 * @return a set independant of the multimap. Null is never returned.
	 */
	public Set<V> getValues(K key) {
		Set<V> set = map.get(key);
		if (set == null)
			return new HashSet<V>();
		return new HashSet<V>(set);
	}
	
	/**
	 * Determines if the multimap contains the specified key-value pair.
	 */
	public boolean contains(K key, V value) {
		Set<V> set = map.get(key);
		if (set == null)
			return false;
		return set.contains(value);
	}
	
	/**
	 * @return the number of values associated with the given key.
	 */
	public int count(K key) {
		Set<V> set = map.get(key);
		if (set == null)
			return 0;
		return set.size();
	}
	
	/**
	 * @return the number of keys with at least one associated value in the multimap.
	 */
	public int numberOfKeys() {
		return map.size();
	}
	
	/**
	 * @return the number of key-value pars in the map.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all key-value pairs.
	 */
	public void clear() {
		map.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		boolean first = true;
		for (Map.Entry<K, Set<V>> entry : map.entrySet()) {
			if (!first) {
				sb.append(", ");
			}
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			first = false;
		}
		sb.append("]");
		return sb.toString();
	}
}
