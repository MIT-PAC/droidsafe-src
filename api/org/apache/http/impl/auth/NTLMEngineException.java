/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/auth/NTLMEngineException.java $
 * $Revision: 655048 $
 * $Date: 2008-05-10 04:22:12 -0700 (Sat, 10 May 2008) $
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

package org.apache.http.impl.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.auth.AuthenticationException;

/**
 * Signals NTLM protocol failure.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 4.0
 */
public class NTLMEngineException extends AuthenticationException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.201 -0400", hash_original_field = "5C1895C43F172B646F9F40C057B98C24", hash_generated_field = "0177F3E318BC562E3C1669EE4F3F1ECC")


    private static final long serialVersionUID = 6027981323731768824L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.202 -0400", hash_original_method = "9B5D709DA7C72B4B34AF854ED47050EF", hash_generated_method = "D937C660B92352434075078B92BAD800")
    
public NTLMEngineException() {
        super();
    }

    /**
     * Creates a new NTLMEngineException with the specified message.
     * 
     * @param message the exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.204 -0400", hash_original_method = "E3CF5E1255C11A7B0E4018DC6610F4FD", hash_generated_method = "C33CB26CC9C743A741A8B65447ABCB10")
    
public NTLMEngineException(String message) {
        super(message);
    }

    /**
     * Creates a new NTLMEngineException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.205 -0400", hash_original_method = "3C13EF4F8BB167D1956FBBA6F2BB8B74", hash_generated_method = "66DD2311B50159ED671BF55B9C57100A")
    
public NTLMEngineException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
