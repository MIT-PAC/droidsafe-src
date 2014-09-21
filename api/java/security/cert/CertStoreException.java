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

package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.GeneralSecurityException;

/**
 * The exception that is thrown when an access to a {@code CertStore} fails.
 */
public class CertStoreException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.405 -0400", hash_original_field = "FAB60A9CC9714C7E021CFF1B57B8BA8A", hash_generated_field = "865C82F5864EAFBD4F5608A5727BF58E")


    private static final long serialVersionUID = 2395296107471573245L;

    /**
     * Creates a new {@code CertStoreException} with the specified message and
     * cause.
     *
     * @param msg
     *            the detail message for this exception.
     * @param cause
     *            the cause why the access to the certificate store failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.407 -0400", hash_original_method = "CD3A8423F1F7B5B59EEB37A01A31E938", hash_generated_method = "EC3F5A28A9F66BB17632076BD1FBEEA0")
    
public CertStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Creates a new {@code CertStoreException} with the specified cause.
     *
     * @param cause
     *            the cause why the access to the certificate store failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.408 -0400", hash_original_method = "15B3460E8F26BF89222E5C49E4F48354", hash_generated_method = "56BF664D52C303B20932790479863905")
    
public CertStoreException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@code CertStoreException} with the specified message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.410 -0400", hash_original_method = "D0EA5216160CA228B9B6B9B9329D77E0", hash_generated_method = "2C4A0F7077BBF3555E8B60F4DC30792E")
    
public CertStoreException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertStoreException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.411 -0400", hash_original_method = "B387E00EDC9A23B98FCA4683030CADC0", hash_generated_method = "8395FE5B80A10A9BAE95992390ACA464")
    
public CertStoreException() {
    }
}
