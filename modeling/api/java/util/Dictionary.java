package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Dictionary<K, V> {
    /**
     * Constructs a new instance of this class.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.666 -0500", hash_original_method = "9548777BBF89E111326DB823D31BF669", hash_generated_method = "67AA0AA4C96C51711438979747E7DF76")
    
public Dictionary() {
    }

    /**
     * Returns an enumeration on the elements of this dictionary.
     *
     * @return an enumeration of the values of this dictionary.
     * @see #keys
     * @see #size
     * @see Enumeration
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.668 -0500", hash_original_method = "2B1B08CBDD81C49D2B5E4AC208EB777B", hash_generated_method = "92A2E6F6E9E68F30A7DCE6EF7590D57C")
    
public abstract Enumeration<V> elements();

    /**
     * Returns the value which is associated with {@code key}.
     *
     * @param key
     *            the key of the value returned.
     * @return the value associated with {@code key}, or {@code null} if the
     *         specified key does not exist.
     * @see #put
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.670 -0500", hash_original_method = "4DC521C50FC180D0A829A339D28D1E43", hash_generated_method = "F8FAB54A06FA27D6DD4E0747EFF302FC")
    
public abstract V get(Object key);

    /**
     * Returns true if this dictionary has no key/value pairs.
     *
     * @return {@code true} if this dictionary has no key/value pairs,
     *         {@code false} otherwise.
     * @see #size
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.673 -0500", hash_original_method = "9B1CCC3AB82A9C7B7A46C788921405FB", hash_generated_method = "047840219A293BF58358C9060BC573A9")
    
public abstract boolean isEmpty();

    /**
     * Returns an enumeration on the keys of this dictionary.
     *
     * @return an enumeration of the keys of this dictionary.
     * @see #elements
     * @see #size
     * @see Enumeration
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.676 -0500", hash_original_method = "6D63BB6C1B315D67DDB35D9AEA065BC7", hash_generated_method = "7F44DED22D10E7B4BC8DC0043C367CC6")
    
public abstract Enumeration<K> keys();

    /**
     * Associate {@code key} with {@code value} in this dictionary. If {@code
     * key} exists in the dictionary before this call, the old value in the
     * dictionary is replaced by {@code value}.
     *
     * @param key
     *            the key to add.
     * @param value
     *            the value to add.
     * @return the old value previously associated with {@code key} or {@code
     *         null} if {@code key} is new to the dictionary.
     * @see #elements
     * @see #get
     * @see #keys
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.678 -0500", hash_original_method = "BD21111CF81539902A64A2DF802E019F", hash_generated_method = "D33043EA605BA15F0A87136D06B7B415")
    
public abstract V put(K key, V value);

    /**
     * Removes the key/value pair with the specified {@code key} from this
     * dictionary.
     *
     * @param key
     *            the key to remove.
     * @return the associated value before the deletion or {@code null} if
     *         {@code key} was not known to this dictionary.
     * @see #get
     * @see #put
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.680 -0500", hash_original_method = "215D36D7628FF869E3E31B83EC6D1AD7", hash_generated_method = "1D28A0310E9BF7B8BB14D40A1AB19C0C")
    
public abstract V remove(Object key);

    /**
     * Returns the number of key/value pairs in this dictionary.
     *
     * @return the number of key/value pairs in this dictionary.
     * @see #elements
     * @see #keys
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.683 -0500", hash_original_method = "9059BAA01A6DF8FE6EC9ED95D6860211", hash_generated_method = "28E434F824F1ADE6246D326A37A67206")
    
public abstract int size();
    
}

