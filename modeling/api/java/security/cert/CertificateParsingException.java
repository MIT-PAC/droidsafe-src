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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CertificateParsingException extends CertificateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.113 -0500", hash_original_field = "E4DA89334FFCB7B948A51D02C208306F", hash_generated_field = "9FB65A3F56B8D84968FA0A283A775A80")

    private static final long serialVersionUID = -7989222416793322029L;

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.115 -0500", hash_original_method = "52C1CA38DD038BC33FD4ADF2F8CE17BE", hash_generated_method = "A245E685ED65819D19415A8A5D1C01EC")
    
public CertificateParsingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateParsingException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.118 -0500", hash_original_method = "8DA8B534EA167A5C50442E9F25486020", hash_generated_method = "7AFB4234C7D14EE73B98DB173DF0ADEA")
    
public CertificateParsingException() {
    }

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * message and cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the exception's source.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.120 -0500", hash_original_method = "7DFD64EF17D16B3CA905ED3004EA7773", hash_generated_method = "53E21438479EB7D5BF3DA52BEEA6C314")
    
public CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * cause.
     *
     * @param cause
     *            the exception's source.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.123 -0500", hash_original_method = "655AB0A50E551680E7DF5C232C5D908E", hash_generated_method = "06D11561C966AC7F165D89B92CFF2346")
    
public CertificateParsingException(Throwable cause) {
        super(cause);
    }
}

