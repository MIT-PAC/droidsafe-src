/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.database;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.text.TextUtils;

/**
 * Helper for accessing features in {@link android.database.DatabaseUtils}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class DatabaseUtilsCompat {

    /**
     * Concatenates two SQL WHERE clauses, handling empty or null values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.180 -0500", hash_original_method = "456400F7FD34BEA9F412D24A9889C2FB", hash_generated_method = "F28E65C77F981D5409FFCCEB8ED4757B")
    
public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        if (TextUtils.isEmpty(b)) {
            return a;
        }

        return "(" + a + ") AND (" + b + ")";
    }

    /**
     * Appends one set of selection args to another. This is useful when adding a selection
     * argument to a user provided set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.181 -0500", hash_original_method = "0E268DF7E77D68AC976AB928986A09DD", hash_generated_method = "2BECFD958CA5727B8248577B0B44C684")
    
public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        if (originalValues == null || originalValues.length == 0) {
            return newValues;
        }
        String[] result = new String[originalValues.length + newValues.length ];
        System.arraycopy(originalValues, 0, result, 0, originalValues.length);
        System.arraycopy(newValues, 0, result, originalValues.length, newValues.length);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.179 -0500", hash_original_method = "BAEEDBDBBA493F3625FAAFB8B3FE331D", hash_generated_method = "B1D13A3BFA2815C4352EA23C6DED5118")
    
private DatabaseUtilsCompat() {
        /* Hide constructor */
    }
}
