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

package java.lang;

/**
 * Thrown when an attempt is made to load a class with a format version that is
 * not supported by the VM.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class UnsupportedClassVersionError extends ClassFormatError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.355 -0400", hash_original_field = "5AB06367D616087BD67781C3EB90FB06", hash_generated_field = "EB6F2D2A96C969FA0EF5E0AC66C9837D")


    private static final long serialVersionUID = -7123279212883497373L;

    /**
     * Constructs a new {@code UnsupportedClassVersionError} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.356 -0400", hash_original_method = "944C46F7C06D99B5A3FF3B703A84283E", hash_generated_method = "B10EF6EA7CB8FBE728296D218B1A1F12")
    
public UnsupportedClassVersionError() {
    }

    /**
     * Constructs a new {@code UnsupportedClassVersionError} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.357 -0400", hash_original_method = "FBC90C9DEECC55523C0ACC4DEBCAA588", hash_generated_method = "3DCEF49C72937BD6B5E24769561C203A")
    
public UnsupportedClassVersionError(String detailMessage) {
        super(detailMessage);
    }
}
