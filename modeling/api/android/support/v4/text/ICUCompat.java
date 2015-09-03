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
import android.os.Build;

public class ICUCompat {

    interface ICUCompatImpl {
        public String getScript(String locale);
        public String addLikelySubtags(String locale);
    }

    static class ICUCompatImplBase implements ICUCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getScript(String locale) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String addLikelySubtags(String locale) {
            return locale;
        }
    }

    static class ICUCompatImplIcs implements ICUCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getScript(String locale) {
            return ICUCompatIcs.getScript(locale);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String addLikelySubtags(String locale) {
            return ICUCompatIcs.addLikelySubtags(locale);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.276 -0400", hash_original_field = "D8F66A71DFF19ED9C921EA1024EFBA82", hash_generated_field = "C4714C1B1F4F7583F1F09424A179AA75")

    private static  ICUCompatImpl IMPL;

    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    /**
     * Returns the script (language code) of a script.
     *
     * @param locale The locale.
     * @return a String representing the script (language code) of the locale.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.282 -0400", hash_original_method = "46F4BF8D5BCCCCEA44904CA6B81E7330", hash_generated_method = "5EA175ACE68504C5B2475919106AE87B")
        
public static String getScript(String locale) {
        return IMPL.getScript(locale);
    }

    /**
     * Add the likely subtags for a provided locale ID, per the algorithm described in the following
     * CLDR technical report:
     *
     * http://www.unicode.org/reports/tr35/#Likely_Subtags
     *
     * If locale is already in the maximal form, or there is no data available for maximization,
     * it will be just returned. For example, "und-Zzzz" cannot be maximized, since there is no
     * reasonable maximization.
     *
     * Examples:
     *
     * "en" maximizes to "en_Latn_US"
     * "de" maximizes to "de_Latn_US"
     * "sr" maximizes to "sr_Cyrl_RS"
     * "sh" maximizes to "sr_Latn_RS" (Note this will not reverse.)
     * "zh_Hani" maximizes to "zh_Hans_CN" (Note this will not reverse.)

     * @param locale The locale to maximize
     *
     * @return the maximized locale
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 10:08:20.286 -0400", hash_original_method = "18828E5E0085D9075692CDFDCCEB6F1B", hash_generated_method = "D5142BD2C9E0622B55AA6D1FFA350BE4")
        
public static String addLikelySubtags(String locale) {
        return IMPL.addLikelySubtags(locale);
    }
}
