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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.GeneralSecurityException;

/**
 * The exception that is thrown when a certification path (or certificate chain)
 * cannot be validated.
 * <p>
 * A {@code CertPathValidatorException} may optionally include the certification
 * path instance that failed the validation and the index of the failed
 * certificate.
 */
public class CertPathValidatorException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.268 -0400", hash_original_field = "67BDC322EB0D25F67632ED61DF2B81E2", hash_generated_field = "643678988E821E2350722A78EB820726")


    private static final long serialVersionUID = -3083180014971893139L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.270 -0400", hash_original_field = "1102A718075F06795C918CF1E4D84F5F", hash_generated_field = "FF5ABA4D61B6F1CB5707CFE2F4CDD4AA")

    private CertPath certPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.271 -0400", hash_original_field = "0C3F3A62108AB7C9F2A0FD1A7BB34E58", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;

    /**
     * Creates a new {@code CertPathValidatorException} with the specified
     * message , cause, certification path and certificate index in the
     * certification path.
     *
     * @param msg
     *            the detail message for this exception.
     * @param cause
     *            the cause.
     * @param certPath
     *            the certification path that failed the validation.
     * @param index
     *            the index of the failed certificate.
     * @throws IllegalArgumentException
     *             if {@code certPath} is {@code null} and index is not {@code
     *             -1}.
     * @throws IndexOutOfBoundsException
     *             if {@code certPath} is not {@code null} and index is not
     *             referencing an certificate in the certification path.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.273 -0400", hash_original_method = "8793748E9D4C7BBB331D9C6B9A09DEA3", hash_generated_method = "85394B111D596FE1E54897BE8508F9AA")
    
public CertPathValidatorException(String msg, Throwable cause,
            CertPath certPath, int index) {
        super(msg, cause);
        // check certPath and index parameters
        if ((certPath == null) && (index != -1)) {
            throw new IllegalArgumentException("Index should be -1 when CertPath is null");
        }
        if ((certPath != null) && ((index < -1) || (index >= certPath.getCertificates().size()))) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.index = index;
    }

    /**
     * Creates a new {@code CertPathValidatorException} with the specified
     * message and cause.
     *
     * @param msg
     *            the detail message for this exception.
     * @param cause
     *            the cause why the path could not be validated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.274 -0400", hash_original_method = "67EC22C86E4D7899D1BD326875DA817D", hash_generated_method = "9FE2E79C2AF479C27057A909877FA83D")
    
public CertPathValidatorException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Creates a new {@code CertPathValidatorException} with the specified
     * cause.
     *
     * @param cause
     *            the cause why the path could not be validated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.276 -0400", hash_original_method = "BE52B6762E0C731C5008FB2E50BEE83E", hash_generated_method = "523ADAD73F05D6C113A2996C8E4BE2EC")
    
public CertPathValidatorException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@code CertPathValidatorException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.277 -0400", hash_original_method = "21CDDE47C9816B41CAC88F1A6070AC29", hash_generated_method = "6CE2E5E91D91D4EB8406F4A4D3BA1C1C")
    
public CertPathValidatorException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertPathValidatorException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.279 -0400", hash_original_method = "705757FA46A4684DE86DD52B1404BBA5", hash_generated_method = "F96FD5B4CA7853498CCCDBE5470A14F3")
    
public CertPathValidatorException() {
    }

    /**
     * Returns the certification path that failed validation.
     *
     * @return the certification path that failed validation, or {@code null} if
     *         none was specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.280 -0400", hash_original_method = "35CFF0FD7CF6918FB79869750B5E218F", hash_generated_method = "04C7C373635014C9EBF0F9663C328964")
    
public CertPath getCertPath() {
        return certPath;
    }

    /**
     * Returns the index of the failed certificate in the certification path.
     *
     * @return the index of the failed certificate in the certification path, or
     *         {@code -1} if none was specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.281 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "96CCC69099797392A28F97F5383D17E0")
    
public int getIndex() {
        return index;
    }
}
