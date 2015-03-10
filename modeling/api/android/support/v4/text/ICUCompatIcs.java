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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v4.text;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.390 -0400", hash_original_field = "93A074F2D0CE30095324BE8F1F604B49", hash_generated_field = "75AE8698C5AE2610AF1C8FA20E6B04F0")

    private static final String TAG = "ICUCompatIcs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.394 -0400", hash_original_field = "CC8DA3C27A51DC54CE7C8EE462ACD8E3", hash_generated_field = "80795AFD3F1BBDE1DF4E227A65AC6B12")

    private static Method sGetScriptMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.398 -0400", hash_original_field = "91BCB22981CF9CCE00255470BD996CDE", hash_generated_field = "4E24C43CC19F6E2AC03FB5080A8DFE1A")

    private static Method sAddLikelySubtagsMethod;

    static {
        try {
            final Class<?> clazz = Class.forName("libcore.icu.ICU");
            if (clazz != null) {
                sGetScriptMethod = clazz.getMethod("getScript",
                        new Class[]{ String.class });
                sAddLikelySubtagsMethod = clazz.getMethod("addLikelySubtags",
                        new Class[]{ String.class });
            }
        } catch (Exception e) {
            // Nothing we can do here, we just log the exception
            Log.w(TAG, e);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.405 -0400", hash_original_method = "389700BBE9A453E32A6259FFD36925D2", hash_generated_method = "C6DBCF8FAA0BBD6E8D73F387A5DD4D6D")
    
public static String getScript(String locale) {
        try {
            if (sGetScriptMethod != null) {
                final Object[] args = new Object[] { locale };
                return (String) sGetScriptMethod.invoke(null, args);
            }
        } catch (IllegalAccessException e) {
            // Nothing we can do here, we just log the exception
            Log.w(TAG, e);
        }
        catch (InvocationTargetException e) {
            // Nothing we can do here, we just log the exception
            Log.w(TAG, e);
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.411 -0400", hash_original_method = "33EE41F78141C64DB76D030DB68A0522", hash_generated_method = "C5D2FF3C7D5B0B507638EBE106E5A7F2")
    
public static String addLikelySubtags(String locale) {
        try {
            if (sAddLikelySubtagsMethod != null) {
                final Object[] args = new Object[] { locale };
                return (String) sAddLikelySubtagsMethod.invoke(null, args);
            }
        } catch (IllegalAccessException e) {
            // Nothing we can do here, we just log the exception
            Log.w(TAG, e);
        }
        catch (InvocationTargetException e) {
            // Nothing we can do here, we just log the exception
            Log.w(TAG, e);
        }
        return locale;
    }
}
