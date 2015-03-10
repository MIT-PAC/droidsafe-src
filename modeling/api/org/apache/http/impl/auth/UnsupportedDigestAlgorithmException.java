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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/auth/UnsupportedDigestAlgorithmException.java $
 * $Revision: 527479 $
 * $Date: 2007-04-11 05:55:12 -0700 (Wed, 11 Apr 2007) $
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnsupportedDigestAlgorithmException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.042 -0500", hash_original_field = "47DF2A481C6BC40752D3C4F1C2886B2D", hash_generated_field = "61CED41D2DA90D7495CCD2197DC1362E")

    private static final long serialVersionUID = 319558534317118022L;

    /**
     * Creates a new UnsupportedAuthAlgoritmException with a <tt>null</tt> detail message. 
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.045 -0500", hash_original_method = "4D7AFBD3BCBFF7BF63D8A1B788355A01", hash_generated_method = "0D0E9BD43ABF71A78095A031D34B153D")
    
public UnsupportedDigestAlgorithmException() {
        super();
    }

    /**
     * Creates a new UnsupportedAuthAlgoritmException with the specified message.
     * 
     * @param message the exception detail message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.047 -0500", hash_original_method = "53A11CFB931BDAEE1F32CE61EF0BEDA2", hash_generated_method = "42AD5E13A84C0A5943C2A2C723DC64B6")
    
public UnsupportedDigestAlgorithmException(String message) {
        super(message);
    }

    /**
     * Creates a new UnsupportedAuthAlgoritmException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.050 -0500", hash_original_method = "2D686768D3996E22528B81DECB6C8570", hash_generated_method = "766A17FA3CDCBCBF06E26F240ACBF411")
    
public UnsupportedDigestAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}

