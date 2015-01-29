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
 * Thrown when the VM notices that an attempt is made to load a
 * class which would directly or indirectly inherit from one of its subclasses.
 * <p>
 * Note that this error can only occur when inconsistent class files are loaded,
 * since it would normally be detected at compile time.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ClassCircularityError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.857 -0400", hash_original_field = "168D6F20B3E57B8F6CCB21EACC63EFAB", hash_generated_field = "56C01E3FED19A63CD5400D69912F9B04")


    private static final long serialVersionUID = 1054362542914539689L;

    /**
     * Constructs a new {@code ClassCircularityError} that include the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.858 -0400", hash_original_method = "AF03FB812F1A9B733A05CCC028516E1C", hash_generated_method = "C50D62C6B681F837B50B75902054B5DB")
    
public ClassCircularityError() {
    }

    /**
     * Constructs a new {@code ClassCircularityError} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.860 -0400", hash_original_method = "129A65496AA27E458DD21469FC078370", hash_generated_method = "BD76AB4267F1C619BE5BDF6F18FA359B")
    
public ClassCircularityError(String detailMessage) {
        super(detailMessage);
    }
}
