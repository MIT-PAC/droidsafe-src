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

// $Id: TransformerFactoryConfigurationError.java 569994 2007-08-27 04:28:57Z mrglavas $


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.xml.transform;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TransformerFactoryConfigurationError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.520 -0500", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with no
     * detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.523 -0500", hash_original_method = "B5236C2B50936EBB19164E0470E786D0", hash_generated_method = "1DCB431931DDB47E6A2B64E4103C4F35")
    
public TransformerFactoryConfigurationError() {
        this.exception = null;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with
     * the <code>String</code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.526 -0500", hash_original_method = "A106770FA0B10D144DFE1AE3A1F6A82D", hash_generated_method = "FB4B56F381D8C7CF1378D43C73163DED")
    
public TransformerFactoryConfigurationError(String msg) {

        super(msg);

        this.exception = null;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with a
     * given <code>Exception</code> base cause of the error.
     *
     * @param e The exception to be encapsulated in a
     * TransformerFactoryConfigurationError.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.528 -0500", hash_original_method = "F49E93B07FF8266081C24B5E6A3F5360", hash_generated_method = "E21F0C39A84A712BC9F7A7B90CA99E04")
    
public TransformerFactoryConfigurationError(Exception e) {

        super(e.toString());

        this.exception = e;
    }

    /**
     * Create a new <code>TransformerFactoryConfigurationError</code> with the
     * given <code>Exception</code> base cause and detail message.
     *
     * @param e The exception to be encapsulated in a
     * TransformerFactoryConfigurationError
     * @param msg The detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.532 -0500", hash_original_method = "1312292D5A501DBED2FE9598863C16EA", hash_generated_method = "C7EB206572740D5CD6DD593A49E89FBC")
    
public TransformerFactoryConfigurationError(Exception e, String msg) {

        super(msg);

        this.exception = e;
    }

    /**
     * Return the message (if any) for this error . If there is no
     * message for the exception and there is an encapsulated
     * exception then the message of that exception will be returned.
     *
     * @return The error message.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.534 -0500", hash_original_method = "87F4B9D5A318C1C88AAC3D2F1A6663D7", hash_generated_method = "794748C6DD32C677C76CF7827625B0BE")
    
public String getMessage() {

        String message = super.getMessage();

        if ((message == null) && (exception != null)) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.536 -0500", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "98F36C2AFC36910DAB242F709A323B7F")
    
public Exception getException() {
        return exception;
    }
    
}

