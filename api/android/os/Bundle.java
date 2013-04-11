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
public final class Bundle implements Parcelable, Cloneable {

    //droidsafe taint object tracks information flow through this class
    private static DSTaintObject dsTaint;

    private static final String LOG_TAG = "Bundle";
    public static final Bundle EMPTY;

    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }

    // Invariant - exactly one of mMap / mParcelledData will be null
    // (except inside a call to unparcel)
    Map<String, Object> mMap = null;

    /*
     * If mParcelledData is non-null, then mMap will be null and the
     * data are stored as a Parcel containing a Bundle.  When the data
     * are unparcelled, mParcelledData willbe set to null.
     */
    Parcel mParcelledData = null;

    private boolean mHasFds = false;
    private boolean mFdsKnown = true;
    private boolean mAllowFds = true;

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

    @DSModeled()
    Bundle(Parcel parcelledData) {
        // this version of Bundle calls readFromParcel()
        // readFromParcel calls readFromParcelInner
        // readFromParcelInner taints several propeties of mParcelledData
        dsTaint.addTaints(parcelledData);
    }

    @DSModeled()
    Bundle(Parcel parcelledData, int length) {
        // this version of Bundle calls readFromParcelInner
        // readFromParcelInner taints several propeties of mParcelledData
        dsTaint.addTaints(parcelledData, length);
    }

    @DSModeled()
    public Bundle(ClassLoader loader) {
        dsTaint.addTaints(loader);
    }

    @DSModeled(DSC.SAFE)
    public Bundle(int capacity) {
        // capacity is passed into this version of Bundle, but
        // it is only being used to determine the size of the 
        // hash map, so it does not provide a way for information
        // to flow through this object
        // mMap = new HashMap<String, Object>(capacity);
        // mClassLoader = getClass().getClassLoader();
    }

    @DSModeled()
    public Bundle(Bundle b) {
        // only taints this class, if the bundle b is not null
        // if the bundle b is null, then mParacelledData is set to null
        if (b.mParcelledData != null) {
            dsTaint.addTaints(b);
        }
    }

    @DSModeled()
    public static Bundle forPair(String key, String value) {
        // This method requires I return a Bundle, so I cast
        // dsTaint.getTaint() to a bundle to satisfy this requirement
        // However, the example in View:getTag modifies the 
        // method definition to return a generic object.  However,
        // more specific seems better, so I'm using cast.
        dsTaint.addTaints(key, value);
        return (Bundle)dsTaint.getTaint();
    }

    @DSModeled()
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaints(parcel, flags);
    }

    @DSModeled() 
    public int describeContents() {
        int mask = 0;
        return dsTaint.getTaintInt();
    }
}
