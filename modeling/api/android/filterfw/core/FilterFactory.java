/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Filter;
import android.util.Log;

import dalvik.system.PathClassLoader;

import java.lang.reflect.Constructor;
import java.lang.ClassLoader;
import java.lang.Thread;
import java.util.HashSet;

/**
 * @hide
 */
public class FilterFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.244 -0400", hash_original_field = "44505D6D74D416A0E9A827846737B14F", hash_generated_field = "4E86326ACC3646AA5027E378FC5D500F")


    private static FilterFactory mSharedFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.250 -0400", hash_original_field = "0312351EB32CE350D97C6B974BAB39DC", hash_generated_field = "AC4B0B29298B21D6E7E4FD18DDA3406C")


    private static ClassLoader mCurrentClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.254 -0400", hash_original_field = "A4F93792A76E050DD992A34FAEFD3E65", hash_generated_field = "B9412CE7FE381CF8643973DA10D7F5DE")

    private static HashSet<String> mLibraries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.256 -0400", hash_original_field = "1B38EB56A1A3BAA2D851574581D2A46D", hash_generated_field = "B661016DE170C48B29E20EC92062D975")

    private static Object mClassLoaderGuard;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.260 -0400", hash_original_field = "93E07DC0CFA9388145F622254C917DE7", hash_generated_field = "DE1FE51B3F50A37E2E8AC01DE7709723")


    private static final String TAG = "FilterFactory";

    static {
        mCurrentClassLoader = Thread.currentThread().getContextClassLoader();
        mLibraries = new HashSet<String>();
        mClassLoaderGuard = new Object();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.263 -0400", hash_original_field = "FD81243965E161CDC8C8782970244830", hash_generated_field = "FF5FD45E73D7AB4E6BD27459FA417208")

    private static boolean mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.267 -0400", hash_original_method = "B8C5542345B6CF99694EDC674FD93CCD", hash_generated_method = "83680326B535F0D17960D29D5816CB5D")
    
public static FilterFactory sharedFactory() {
        if (mSharedFactory == null) {
            mSharedFactory = new FilterFactory();
        }
        return mSharedFactory;
    }

    /**
     * Adds a new Java library to the list to be scanned for filters.
     * libraryPath must be an absolute path of the jar file.  This needs to be
     * static because only one classloader per process can open a shared native
     * library, which a filter may well have.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.270 -0400", hash_original_method = "B46D23CACF4AAE8A4C0CABDB3AAFC84D", hash_generated_method = "5A1BE144C6719FDF19130A63BAB819C9")
    
public static void addFilterLibrary(String libraryPath) {
        if (mLogVerbose) Log.v(TAG, "Adding filter library " + libraryPath);
        synchronized(mClassLoaderGuard) {
            if (mLibraries.contains(libraryPath)) {
                if (mLogVerbose) Log.v(TAG, "Library already added");
                return;
            }
            mLibraries.add(libraryPath);
            // Chain another path loader to the current chain
            mCurrentClassLoader = new PathClassLoader(libraryPath, mCurrentClassLoader);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.247 -0400", hash_original_field = "D017ADF4C9E3283755A50CB6F3D1A574", hash_generated_field = "6BBDD0F00B7F48DD6BEE8A8610B6A9AE")

    private HashSet<String> mPackages = new HashSet<String>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.273 -0400", hash_original_method = "351FED0B23AFF129ECF81F1D0A72A1BC", hash_generated_method = "9D60878A1EB789182CF6DB4908C2567D")
    
public void addPackage(String packageName) {
        if (mLogVerbose) Log.v(TAG, "Adding package " + packageName);
        /* TODO: This should use a getPackage call in the caller's context, but no such method exists.
        Package pkg = Package.getPackage(packageName);
        if (pkg == null) {
            throw new IllegalArgumentException("Unknown filter package '" + packageName + "'!");
        }
        */
        mPackages.add(packageName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.276 -0400", hash_original_method = "69527F391C246307643BB7F249E7E223", hash_generated_method = "CB8BE40D3DA189C75CD4525AFF80492F")
    
public Filter createFilterByClassName(String className, String filterName) {
        if (mLogVerbose) Log.v(TAG, "Looking up class " + className);
        Class filterClass = null;

        // Look for the class in the imported packages
        for (String packageName : mPackages) {
            try {
                if (mLogVerbose) Log.v(TAG, "Trying "+packageName + "." + className);
                synchronized(mClassLoaderGuard) {
                    filterClass = mCurrentClassLoader.loadClass(packageName + "." + className);
                }
            } catch (ClassNotFoundException e) {
                continue;
            }
            // Exit loop if class was found.
            if (filterClass != null) {
                break;
            }
        }
        if (filterClass == null) {
            throw new IllegalArgumentException("Unknown filter class '" + className + "'!");
        }
        return createFilterByClass(filterClass, filterName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.279 -0400", hash_original_method = "0666BCB5B5E2196A57EC5E8BBAB9C327", hash_generated_method = "599BBDFCE63D992D5A40CD699E3F4E24")
    
public Filter createFilterByClass(Class filterClass, String filterName) {
        // Make sure this is a Filter subclass
        try {
            filterClass.asSubclass(Filter.class);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Attempting to allocate class '" + filterClass
                + "' which is not a subclass of Filter!");
        }

        // Look for the correct constructor
        Constructor filterConstructor = null;
        try {
            filterConstructor = filterClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("The filter class '" + filterClass
                + "' does not have a constructor of the form <init>(String name)!");
        }

        // Construct the filter
        Filter filter = null;
        try {
            filter = (Filter)filterConstructor.newInstance(filterName);
        } catch (Throwable t) {
            // Condition checked below
        }

        if (filter == null) {
            throw new IllegalArgumentException("Could not construct the filter '"
                + filterName + "'!");
        }
        return filter;
    }
}
