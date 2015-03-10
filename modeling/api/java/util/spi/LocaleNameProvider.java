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
 * localized locale names.
 * <p>Note that Android does not support user-supplied locale service providers.
 * @since 1.6
 * @hide
 */
public abstract class LocaleNameProvider extends LocaleServiceProvider {
    /**
     * Default constructor, for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.417 -0400", hash_original_method = "8EC4C79C59FC2942169598F4B54559BB", hash_generated_method = "25AB45BCBA45C79536DA42B257C0E6A9")
    
protected LocaleNameProvider() {
        // do nothing
    }

    /**
     * Returns the localized name for the given ISO 639 language code.
     *
     * @param languageCode an ISO 639 language code
     * @param locale a locale
     * @return the name or null if unavailable
     * @throws NullPointerException
     *             if {@code code == null || locale == null}
     * @throws IllegalArgumentException
     *             if code or locale is not in a legal format or not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.417 -0400", hash_original_method = "24EA7303796B7DDF30E602F7B61DD6B0", hash_generated_method = "C0442783643EE3E97D1584168A004B0E")
    
public abstract String getDisplayLanguage(String languageCode, Locale locale);

    /**
     * Returns the localized name for the given ISO 3166 country code.
     *
     * @param countryCode an ISO 3166 language code
     * @param locale a locale
     * @return the name or null if unavailable
     * @throws NullPointerException
     *             if {@code code == null || locale == null}
     * @throws IllegalArgumentException
     *             if code or locale is not in a legal format or not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.418 -0400", hash_original_method = "D78683319ED391CE160A77B8730BE3FC", hash_generated_method = "37AC3E8B5D9FCFBBC8B34B1DF4BC8DA6")
    
public abstract String getDisplayCountry(String countryCode, Locale locale);

    /**
     * Returns the localized name for the given variant code.
     *
     * @param variantCode a variant code
     * @param locale a locale
     * @return the name or null if unavailable
     * @throws NullPointerException
     *             if {@code code == null || locale == null}
     * @throws IllegalArgumentException
     *             if code or locale is not in a legal format or not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.418 -0400", hash_original_method = "B1DA059001F88B6C9C2BF7D89112A046", hash_generated_method = "D9B29C00B11C13F0A96688BBCE5D81B3")
    
public abstract String getDisplayVariant(String variantCode, Locale locale);
}
