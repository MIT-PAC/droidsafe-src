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

package java.util.prefs;

/**
 * An exception to indicate that the input XML file is not well-formed or could
 * not be validated against the appropriate document type (specified by
 * in the {@code Preferences}).
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class InvalidPreferencesFormatException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.602 -0400", hash_original_field = "D089102A3C1C58F929BBF6FCA9E31F33", hash_generated_field = "9E5547B3A07A6019A1B0326F49B0F0C1")


    private static final long serialVersionUID = -791715184232119669L;

    /**
     * Constructs a new {@code InvalidPreferencesFormatException} instance with
     * a detailed exception message.
     *
     * @param s
     *            the detailed exception message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.602 -0400", hash_original_method = "25352A6F4FC9F5F2DCBDB9D49D7F6426", hash_generated_method = "4DFCBF8F12F2E34E61AD8C08EF6281CA")
    
public InvalidPreferencesFormatException (String s) {
        super(s);
    }

    /**
     * Constructs a new {@code InvalidPreferencesFormatException} instance with
     * a detailed exception message and a nested {@code Throwable}.
     *
     * @param s
     *            the detailed exception message.
     * @param t
     *            the nested {@code Throwable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.603 -0400", hash_original_method = "649283B853121C261C3ED840273F54B4", hash_generated_method = "63DC81653A5B5A7617E6509E86F85003")
    
public InvalidPreferencesFormatException (String s, Throwable t) {
        super(s,t);
    }

    /**
     * Constructs a new {@code InvalidPreferencesFormatException} instance with
     * a nested {@code Throwable}.
     *
     * @param t
     *            the nested {@code Throwable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.603 -0400", hash_original_method = "D503CDDEC312BC499CADD9D37A3A9121", hash_generated_method = "ED1BA9827BE5563CDD41E16FB2DF2112")
    
public InvalidPreferencesFormatException (Throwable t) {
        super(t);
    }
}
