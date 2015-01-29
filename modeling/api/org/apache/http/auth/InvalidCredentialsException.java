/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/InvalidCredentialsException.java $
 * $Revision: 505684 $
 * $Date: 2007-02-10 04:40:02 -0800 (Sat, 10 Feb 2007) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.auth;

/**
 * Authentication credentials required to respond to a authentication 
 * challenge are invalid
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 4.0
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class InvalidCredentialsException extends AuthenticationException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.643 -0400", hash_original_field = "A14898236F4BD3F887D267527A03B1C4", hash_generated_field = "8E53F7EBFAF3172C5A002B65713A68A8")


    private static final long serialVersionUID = -4834003835215460648L;

    /**
     * Creates a new InvalidCredentialsException with a <tt>null</tt> detail message. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.644 -0400", hash_original_method = "EDA93575A1EBF0C0CDB929A6D82FC02A", hash_generated_method = "B564D302A45634460AF38E888A7E5604")
    
public InvalidCredentialsException() {
        super();
    }

    /**
     * Creates a new InvalidCredentialsException with the specified message.
     * 
     * @param message the exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.652 -0400", hash_original_method = "F8E26A61666054C690AF98C48F2153BE", hash_generated_method = "0B86135FC913BD6C8E0A70360170EDDF")
    
public InvalidCredentialsException(String message) {
        super(message);
    }

    /**
     * Creates a new InvalidCredentialsException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.653 -0400", hash_original_method = "23E4738A5C9932D4989DD9CE8EC50DE0", hash_generated_method = "308CA69FE4C40FB17E15A2F8607D0F8D")
    
public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
