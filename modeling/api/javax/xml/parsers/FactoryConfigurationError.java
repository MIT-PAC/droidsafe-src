/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

// $Id: FactoryConfigurationError.java 569980 2007-08-27 03:58:15Z mrglavas $


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FactoryConfigurationError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.287 -0500", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;

    /**
     * Create a new <code>FactoryConfigurationError</code> with no
     * detail message.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.290 -0500", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "745C8338A29F863D10814EC116A8F2BD")
    
public FactoryConfigurationError() {
        this.exception = null;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with
     * the <code>String </code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.292 -0500", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "D0676D1AFF49D70AC248B711D650CDA6")
    
public FactoryConfigurationError(String msg) {
        super(msg);
        this.exception = null;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with a
     * given <code>Exception</code> base cause of the error.
     *
     * @param e The exception to be encapsulated in a
     * FactoryConfigurationError.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.296 -0500", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "0108B88B4CBED651CB8E96F68E07A12C")
    
public FactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with the
     * given <code>Exception</code> base cause and detail message.
     *
     * @param e The exception to be encapsulated in a
     * FactoryConfigurationError
     * @param msg The detail message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.299 -0500", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "D14E373FB5C0C305D1EECCFB4C942FA0")
    
public FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        this.exception = e;
    }

    /**
     * Return the message (if any) for this error . If there is no
     * message for the exception and there is an encapsulated
     * exception then the message of that exception, if it exists will be
     * returned. Else the name of the encapsulated exception will be
     * returned.
     *
     * @return The error message.
     */

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.301 -0500", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "65176D00D2CAACC6AEEBD824B6D2D655")
    
public String getMessage () {
        String message = super.getMessage ();

        if (message == null && exception != null) {
            return exception.getMessage();
        }

        return message;
    }

    /**
     * Return the actual exception (if any) that caused this exception to
     * be raised.
     *
     * @return The encapsulated exception, or null if there is none.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.303 -0500", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "98F36C2AFC36910DAB242F709A323B7F")
    
public Exception getException () {
        return exception;
    }
    
}

