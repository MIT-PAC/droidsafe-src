/*
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

package java.util.spi;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Locale;

/**
 * This abstract class should be extended by service providers that provide
 * localized currency symbols (currency names) from currency codes.
 * <p>Note that Android does not support user-supplied locale service providers.
 * @since 1.6
 * @hide
 */
public abstract class CurrencyNameProvider extends LocaleServiceProvider {
    /**
     * Default constructor, for use by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.442 -0400", hash_original_method = "11FA292EFBE79542A0006DDC7ED66555", hash_generated_method = "E6F2FFDB2C52F4D6690970BD6C19D6A2")
    
protected CurrencyNameProvider() {
        // do nothing
    }

    /**
     * Returns the localized currency symbol for the given currency code.
     *
     * @param code an ISO 4217 currency code
     * @param locale a locale
     * @return the symbol or null if there is no available symbol in the locale
     * @throws NullPointerException
     *             if {@code code == null || locale == null}
     * @throws IllegalArgumentException
     *             if code or locale is not in a legal format or not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.442 -0400", hash_original_method = "3506FD2D793D995567D25561B461E3DE", hash_generated_method = "39E35B6EF97E420E3BC43885A89AB216")
    
public abstract String getSymbol(String code, Locale locale);
}
