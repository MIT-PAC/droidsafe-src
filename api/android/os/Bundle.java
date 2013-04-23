/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.os;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

import android.util.Log;
import android.util.SparseArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A mapping from String values to various Parcelable types.
 *
 */
@DSModeled
public final class Bundle implements Parcelable, Cloneable {

    //droidsafe taint object tracks information flow through this class
    private static DSTaintObject dsTaint;

    private static final String LOG_TAG = "Bundle";

    /*
     so far, the static properites of this class are not used by any
     of the methods in Sensor.java, so they do not need to be modeled
     I've commented them out to remove the <clint> tag in the needs
     to be modeled file for Sensors.java

    public static final Bundle EMPTY;

    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    */

    // Invariant - exactly one of mMap / mParcelledData will be null
    // (except inside a call to unparcel)
    Map<String, Object> mMap = null;

    // If mParcelledData is non-null, then mMap will be null and the
    // data are stored as a Parcel containing a Bundle.  When the data
    // are unparcelled, mParcelledData will be set to null.
    Parcel mParcelledData = null;

    private boolean mHasFds = false;
    private boolean mFdsKnown = true;
    private boolean mAllowFds = true;
    
    static {
    	
    }

    /**
     * The ClassLoader used when unparcelling data from mParcelledData.
     */
    private ClassLoader mClassLoader;

    @DSModeled(value = DSC.BAN)
    public Bundle() {
        // MIT's comment below...
        //DSModel: Do we need to do something about this class loader
        //we don't allow dynamic class loading, so we should not have to model this
        //all calls that use it should be banned
        //mClassLoader = getClass().getClassLoader();
    }

    @DSModeled(DSC.SAFE)
    Bundle(Parcel parcelledData) {
        // this version of Bundle calls readFromParcel()
        // readFromParcel calls readFromParcelInner
        // readFromParcelInner taints several propeties of mParcelledData
        dsTaint.addTaints(parcelledData);
    }

    @DSModeled(DSC.SAFE)
    Bundle(Parcel parcelledData, int length) {
        // this version of Bundle calls readFromParcelInner
        // readFromParcelInner taints several propeties of mParcelledData
        dsTaint.addTaints(parcelledData, length);
    }

    @DSModeled(DSC.SAFE)
    public Bundle(ClassLoader loader) {
        // this versio of Bundle taints this class by setting mClassLoader
        // equal to loader. It initializes mMap to a HashMap, but stores nothing
        // in it.
        dsTaint.addTaints(loader);
    }

    @DSModeled(DSC.BAN)
    public Bundle(int capacity) {
        // capacity is passed into this version of Bundle, but
        // it is only being used to determine the size of the 
        // hash map, so it does not provide a way for information
        // to flow through this object
        // mMap = new HashMap<String, Object>(capacity);

	// Based on MIT's note for public Bundle()
        // dynamic class loading is not allowed.  Therefore,
        // this line of code makes this method "banned".
        // mClassLoader = getClass().getClassLoader();
    }

    @DSModeled(DSC.SAFE)
    public Bundle(Bundle b) {
        // If the bundle b is not null, then the mehtod mParcelledData
        // of this class is tainted.
        // Otherwise, mParcelledData is set to null
        dsTaint.addTaints(b.dsTaint);
    }

    @DSModeled(DSC.SAFE)
    public static Bundle forPair(String key, String value) {
        // We know that Bundle(capacity) is banned,
        // so we make the call to the banned constructor to associate 
        // this constructor with the banned constructor
        // We also taint the new bundle b with the key value pair before
        // we return it.
        Bundle b = new Bundle(1);
        b.dsTaint.addTaints(key, value);
        return b;
    }

    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel parcel, int flags) {
        // We make all of the calls to the various
        // parameters and variables so they can be tainted
        // with data from this method.

        // parcel might be tained with mAllowFds
        final boolean oldAllowFds = parcel.pushAllowFds(mAllowFds);

        // parcel might be tained with length
        int length = mParcelledData.dataSize();
        parcel.writeInt(length);

        // parcel might be tainted with length or mParcelledData
        parcel.appendFrom(mParcelledData, 0, length);

        // parcel might be tainted with mMap
        parcel.writeMapInternal(mMap);

        // parcel might be tained with oldPos or newPost
        int oldPos = parcel.dataPosition();
        int newPos = parcel.dataPosition();
        parcel.setDataPosition(oldPos - 8);
        parcel.setDataPosition(newPos);

        // parcel might be tained with oldAllowFds, which was 
        // derived through parcel.pushAllowFds
        parcel.restoreAllowFds(oldAllowFds);

    }

    @DSModeled(DSC.SAFE) 
    public int describeContents() {
        // this method returns 0, or the constant CONTENTS_FILE_DESCRIPTOR
        // I modeled this by creating a constant which is always 0
        // and returning an Int that looks like the constant
        return 0;
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String value, or null
     */
    public String getString(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (String) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "String", e);
            return null;
        }
    }

    /**
     * Removes any entry with the given key from the mapping of this Bundle.
     *
     * @param key a String key
     */
    public void remove(String key) {
        unparcel();
        mMap.remove(key);
    }

    /**
     * Returns a Set containing the Strings used as keys in this Bundle.
     *
     * @return a Set of String keys
     */
    public Set<String> keySet() {
        unparcel();
        return mMap.keySet();
    }

    /**
     * Returns the entry with the given key as an object.
     *
     * @param key a String key
     * @return an Object, or null
     */
    public Object get(String key) {
        unparcel();
        return mMap.get(key);
    }

    /**
     * Returns the value associated with the given key, or false if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a boolean value
     */
    public boolean getBoolean(String key) {
        unparcel();
        return getBoolean(key, false);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a boolean value
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Boolean) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Boolean", defaultValue, e);
            return defaultValue;
        }
    }

    @DSModeled(DSC.SAFE)
    /**
     * If the underlying data are stored as a Parcel, unparcel them
     * using the currently assigned class loader.
     */
    /* package */ synchronized void unparcel() {
        if (mParcelledData == null) {
            return;
        }

        int N = mParcelledData.readInt();
        if (N < 0) {
            return;
        }
        if (mMap == null) {
            mMap = new HashMap<String, Object>();
        }
        mParcelledData.readMapInternal(mMap, N, mClassLoader);
        mParcelledData.recycle();
        mParcelledData = null;
    }

    @DSModeled(DSC.SAFE)
    // Log a message if the value was non-null but not of the expected type
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e) {
    	//Private method used for logging, shouldn't really affect modeling
    	/*
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(key);
        sb.append(" expected ");
        sb.append(className);
        sb.append(" but value was a ");
        sb.append(value.getClass().getName());
        sb.append(".  The default value ");
        sb.append(defaultValue);
        sb.append(" was returned.");
        Log.w(LOG_TAG, sb.toString());
        Log.w(LOG_TAG, "Attempt to cast generated internal exception:", e);
        */
    }

    @DSModeled(DSC.SAFE)
    private void typeWarning(String key, Object value, String className,
        ClassCastException e) {
        typeWarning(key, value, className, "<null>", e);
    }
    
    @DSModeled //Going to model as SPEC since arbitrary data could be inside the parcelable object that is returned
    public <T extends Parcelable> T getParcelable(String key) {
    	unparcel();
    	return (T)dsTaint.getTaint();
    	/*
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (T) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Parcelable", e);
            return null;
        }
        */
    }

}
