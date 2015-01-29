/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/MethodNotSupportedException.java $
 * $Revision: 618017 $
 * $Date: 2008-02-03 08:42:22 -0800 (Sun, 03 Feb 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http;


/**
 * Indicates that an HTTP method is not supported.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 618017 $
 * 
 * @since 4.0
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class MethodNotSupportedException extends HttpException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.542 -0400", hash_original_field = "79E73BDB1EE6D8D80E75F33EED4201B6", hash_generated_field = "5CAFCC6025104348469C18F26008BD12")


    private static final long serialVersionUID = 3365359036840171201L;
    
    /**
     * Creates a new MethodNotSupportedException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.543 -0400", hash_original_method = "4B340B7A1F4FC0CB9D13EE0AB48D5C4B", hash_generated_method = "0CA7B8CF1CD01C8AC236B4EBF07CD05D")
    
public MethodNotSupportedException(final String message) {
        super(message);
    }

    /**
     * Creates a new MethodNotSupportedException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.543 -0400", hash_original_method = "2A1663F8C334FCA3EDA5A21331CBE46C", hash_generated_method = "360AFC346BBC1AD53AE615BE5483487C")
    
public MethodNotSupportedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
