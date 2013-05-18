package droidsafe.analyses.attr.models.android.os;

import droidsafe.analyses.attr.ModeledClass;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

public class Bundle extends ModeledClass {

  private final static Logger logger = LoggerFactory.getLogger(Bundle.class);

  Map<droidsafe.analyses.attr.models.java.lang.String, Object> mMap;

  private boolean mHasFds = false;
  private boolean mFdsKnown = true;
  private boolean mAllowFds = true;

  public Bundle() {
    mMap = new HashMap<droidsafe.analyses.attr.models.java.lang.String, Object>();
  }

  public Bundle(Bundle b) {
    putAll(b);
    mHasFds = b.mHasFds;
    mFdsKnown = b.mFdsKnown;
  } 

  public Bundle(AllocNode allocNode) {
    super(allocNode);
    this.mMap = new HashMap<droidsafe.analyses.attr.models.java.lang.String, Object>();
  }

  public void _init_(){
  }

    
    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Boolean, or null
     */
    public void putBoolean(droidsafe.analyses.attr.models.java.lang.String key, boolean value) {
        mMap.put(key, value);
    }

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a byte
     */
    public void putByte(droidsafe.analyses.attr.models.java.lang.String key, byte value) {
        mMap.put(key, value);
    }

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a char, or null
     */
    public void putChar(droidsafe.analyses.attr.models.java.lang.String key, char value) {
        mMap.put(key, value);
    }

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a short
     */
    public void putShort(droidsafe.analyses.attr.models.java.lang.String key, short value) {
      mMap.put(key, value);
    }

    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value an int, or null
     */
    public void putInt(droidsafe.analyses.attr.models.java.lang.String key, int value) {
      mMap.put(key, value);
    }

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a long
     */
    public void putLong(droidsafe.analyses.attr.models.java.lang.String key, long value) {
      mMap.put(key, value);
    }

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a float
     */
    public void putFloat(droidsafe.analyses.attr.models.java.lang.String key, float value) {
      mMap.put(key, value);
    }

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a double
     */
    public void putDouble(droidsafe.analyses.attr.models.java.lang.String key, double value) {
      mMap.put(key, value);
    }

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a String, or null
     */
    public void putString(droidsafe.analyses.attr.models.java.lang.String key, droidsafe.analyses.attr.models.java.lang.String value) {
      mMap.put(key, value);
    }

  public void putAll(droidsafe.analyses.attr.models.android.os.Bundle b) {
    mMap.putAll(b.mMap);

    // fd state is now known if and only if both bundles already knew
    mHasFds |= b.mHasFds;
    mFdsKnown = mFdsKnown && b.mFdsKnown;
  }

  @Override
  public String toString(){
    String str = "<modeled Bundle" + this.getId() + "> {";
    if (invalidated) {
      str += "invalidated";
    } else {
      ArrayList<String> attrs = new ArrayList();
      if(mMap.size() > 0)
        attrs.add("mMap: " + this.mMap);
      attrs.add("mHasFds: " + this.mHasFds);
      attrs.add("mFdsKnown: " + this.mFdsKnown);
      attrs.add("mAllowFds: " + this.mAllowFds);
      str += StringUtils.join(attrs.toArray(), ", ");
    }
    return str + "}";
  }
}
