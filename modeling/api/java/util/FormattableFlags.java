/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package java.util;

/**
 * FormattableFlags are used as a parameter to
 * {@link Formattable#formatTo(Formatter, int, int, int)} and change the output
 * format in {@code Formattable}s. The validation and interpretation of the
 * flags must be done by the implementations.
 *
 * @see Formattable
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class FormattableFlags {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.024 -0400", hash_original_field = "F4C4223F6A1F677FB8B9F650E5819398", hash_generated_field = "8318FD20156446A7E032538A6752827F")

    public static final int LEFT_JUSTIFY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.024 -0400", hash_original_field = "1448C904BFB4789B5FF3D295249795EF", hash_generated_field = "4263C6F482ADA5CA54321277408B721D")

    public static final int UPPERCASE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.025 -0400", hash_original_field = "0E2B1E122ACFCE5639BEAE37F6FF980A", hash_generated_field = "79581EB69AB515E52AA45D0044DE28C9")

    public static final int ALTERNATE = 4;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:26.023 -0400", hash_original_method = "82CA9D31797264EF1BC30BBEE4B360DC", hash_generated_method = "45C560EFFBDEAC582DF2E3BBB334B4DB")
    
private FormattableFlags(){
        //prevent this class from being instantiated
    }
}
