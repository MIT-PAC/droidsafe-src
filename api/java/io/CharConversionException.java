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

package java.io;

/**
 * The top level class for character conversion exceptions.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class CharConversionException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:32.385 -0400", hash_original_field = "9D6E8CC0E2D9AF36C0A8ADA37A1E5C8F", hash_generated_field = "65B2BE3C51DC9ACB0D9DEF0D743B85D6")


    private static final long serialVersionUID = -8680016352018427031L;

    /**
     * Constructs a new {@code CharConversionException} with its stack trace
     * filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:32.385 -0400", hash_original_method = "DC569460E6B613C2EB5E9DBFD397A52F", hash_generated_method = "E79B1FBEBB194EC57FE3D3CCDDAEE9F3")
    
public CharConversionException() {
    }

    /**
     * Constructs a new {@code CharConversionException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:32.386 -0400", hash_original_method = "FDBB99B99B9CAB30BA127F908E7A50CF", hash_generated_method = "592115C9E0C9D324EB3B385A2CC9506E")
    
public CharConversionException(String detailMessage) {
        super(detailMessage);
    }
}
