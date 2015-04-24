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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.spi;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Locale;

/**
 * This abstract class should be extended by service providers that provide
 * localized time zone names.
 * <p>Note that Android does not support user-supplied locale service providers.
 * @since 1.6
 * @hide
 */
public abstract class TimeZoneNameProvider extends LocaleServiceProvider {
    /**
     * Default constructor, for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.431 -0400", hash_original_method = "411B02A3DC2127356B914BDC57511CE0", hash_generated_method = "614461EC11F2E35FF606D4368F4581CB")
    
protected TimeZoneNameProvider() {
        // do nothing
    }

    /**
     * Returns the localized name for the given time zone in the given locale.
     *
     * @param id the time zone id
     * @param daylight true to return the name for daylight saving time.
     * @param style TimeZone.LONG or TimeZone.SHORT
     * @param locale the locale
     * @return the readable time zone name, or null if it is unavailable
     * @throws NullPointerException
     *             if {@code id == null || locale == null}
     * @throws IllegalArgumentException
     *             if locale is not available or style is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.432 -0400", hash_original_method = "F681F9A66AEFE9150AF2B80032D6C591", hash_generated_method = "48B61C54C3A63EE89E636C6FE40A8394")
    
public abstract String getDisplayName(String id, boolean daylight, int style, Locale locale);
}
