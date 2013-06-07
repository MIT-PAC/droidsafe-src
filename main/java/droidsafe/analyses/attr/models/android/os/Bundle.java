package droidsafe.analyses.attr.models.android.os;

import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.AttrModelingSet;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class Bundle extends AttrModeledClass {

    Map<String, AttrModelingSet<Object>> mMap = null;

    public Bundle() {
        mMap = new HashMap<String, AttrModelingSet<Object>>();
    }

    public Bundle(AllocNode allocNode) {
        super(allocNode);
        mMap = new HashMap<String, AttrModelingSet<Object>>();
    }

    /**
     * Constructs a new, empty Bundle.
     */
    public void _init_(){
        // TODO: decide if we need the classLoader and uncomment/delete the line below
        // mClassLoader = getClass().getClassLoader();
    }

    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Boolean, or null
     */
    public void putBoolean(Set<String> keys, Set<Boolean> values) {
        for(String key : keys) {
            for(Boolean value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Boolean>(Arrays.asList(new Boolean[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a byte
     */
    public void putByte(Set<String> keys, Set<Byte> values) {
        for(String key : keys) {
            for(Byte value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Byte>(Arrays.asList(new Byte[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a char, or null
     */
    public void putChar(Set<String> keys, Set<Character> values) {
        for(String key : keys) {
            for(Character value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Character>(Arrays.asList(new Character[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a short
     */
    public void putShort(Set<String> keys, Set<Short> values) {
        for(String key : keys) {
            for(Short value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Short>(Arrays.asList(new Short[]{value}))));
                }
            }
        }
    }
    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value an int, or null
     */
    public void putInt(Set<String> keys, Set<Integer> values) {
        for(String key : keys) {
            for(Integer value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Integer>(Arrays.asList(new Integer[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a long
     */
    public void putLong(Set<String> keys, Set<Long> values) {
        for(String key : keys) {
            for(Long value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Long>(Arrays.asList(new Long[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a float
     */
    public void putFloat(Set<String> keys, Set<Float> values) {
        for(String key : keys) {
            for(Float value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Float>(Arrays.asList(new Float[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a double
     */
    public void putDouble(Set<String> keys, Set<Double> values) {
        for(String key : keys) {
            for(Double value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<Double>(Arrays.asList(new Double[]{value}))));
                }
            }
        }
    }

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a String, or null
     */
    public void putString(Set<String> keys, Set<String> values) {
        for(String key : keys) {
            for(String value : values){
                if(mMap.containsKey(key)){
                    mMap.get(key).add(value);
                } else {
                    mMap.put(key, new AttrModelingSet(new HashSet<String>(Arrays.asList(new String[]{value}))));
                }
            }
        }  
    }

    /**
     * Inserts all mappings from the given Bundle into this Bundle.
     *
     * @param map a Bundle
     */
    public void putAll(Bundle b) {
        for(Map.Entry<String, AttrModelingSet<Object>> entry : b.mMap.entrySet()) {
            String key = entry.getKey();
            AttrModelingSet<Object> value = entry.getValue();
            if(mMap.containsKey(key)){
                mMap.get(key).addAll(value);
            } else {
                mMap.put(key, value);
            }
        }

        // fd state is now known if and only if both bundles already knew
        // TODO: figure out if we need the two variables below and uncomment or delete the two lines below
        // mHasFds |= b.mHasFds;
        // mFdsKnown = mFdsKnown && b.mFdsKnown;
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String value, or null
     */
    public Set<String> getString(String key) {
        HashSet<String> results = new HashSet<String>();
        if(mMap.containsKey(key)) {
            AttrModelingSet attrModelingSet = mMap.get(key);
            for(Object o : attrModelingSet){
                try {
                    results.add((String)o);
                } catch(ClassCastException e){
                    return null;
                }
            }
            return results;
        }
        return null;
    }

    public String dsDisplay(){
        String str = "<modeled Bundle" + this.getId() + "> {";
        if (invalidated) {
            str += "invalidated";
        } else {
            ArrayList<String> attrs = new ArrayList();
            if(mMap.size() > 0)
                attrs.add("mMap: " + this.mMap);
            str += StringUtils.join(attrs.toArray(), ", ");
        }
        return str + "}";
    }
}
