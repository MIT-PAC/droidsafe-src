/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
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

package java.util.jar;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.zip.ZipException;

/**
 * This runtime exception is thrown when a problem occurs while reading a JAR
 * file.
 */
public class JarException extends ZipException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.099 -0400", hash_original_field = "A7210338BC92ECEBCB6D8CCE92C63311", hash_generated_field = "A48860069F1F718FA86C378985B88BDE")


    private static final long serialVersionUID = 7159778400963954473L;

    /**
     * Constructs a new {@code JarException} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.099 -0400", hash_original_method = "DCFA58EF40362CB1E945FEC9479F1EEC", hash_generated_method = "848DFF85BD14A211D7BCDA4A2DA7ECDD")
    
public JarException() {
    }

    /**
     * Constructs a new {@code JarException} instance with the specified
     * message.
     *
     * @param detailMessage
     *            the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.100 -0400", hash_original_method = "FB6337731B58C1ABF03C2302BC0C531B", hash_generated_method = "4270A35B5400AF33F7A2EFD131597F74")
    
public JarException(String detailMessage) {
        super(detailMessage);
    }
}
