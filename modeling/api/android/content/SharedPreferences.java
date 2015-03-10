/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Map;
import java.util.Set;

public interface SharedPreferences {
    
    public interface OnSharedPreferenceChangeListener {
        
        void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key);
    }
    
    public interface Editor {
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        @DSSink({DSSinkKind.SHARED_PREFERENCES})
        Editor putString(String key, String value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSSink({DSSinkKind.SHARED_PREFERENCES})
        Editor putStringSet(String key, Set<String> values);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        @DSSink({DSSinkKind.SHARED_PREFERENCES})
        Editor putInt(String key, int value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        @DSSink({DSSinkKind.SHARED_PREFERENCES})
        Editor putLong(String key, long value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putFloat(String key, float value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        @DSSink({DSSinkKind.SHARED_PREFERENCES})
        Editor putBoolean(String key, boolean value);

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        Editor remove(String key);

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        Editor clear();

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.SHARED_PREFERENCES)
        boolean commit();

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void apply();
    }

    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    Map<String, ?> getAll();

    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SYSTEM_PREFERENCES)
    @DSSource({DSSourceKind.SHARED_PREFERENCES})
    
    String getString(String key, String defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SHARED_PREFERENCES})
    Set<String> getStringSet(String key, Set<String> defValues);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SYSTEM_PREFERENCES)
    @DSSource({DSSourceKind.SHARED_PREFERENCES})
    int getInt(String key, int defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SYSTEM_PREFERENCES)
    @DSSource({DSSourceKind.SHARED_PREFERENCES})
    long getLong(String key, long defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SHARED_PREFERENCES})
    float getFloat(String key, float defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SYSTEM_PREFERENCES)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    boolean getBoolean(String key, boolean defValue);

    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean contains(String key);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SYSTEM_PREFERENCES)
    Editor edit();

    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.GUI)
    void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.GUI)
    void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener);
}
