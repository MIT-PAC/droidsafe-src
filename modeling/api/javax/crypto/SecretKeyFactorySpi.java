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


package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class SecretKeyFactorySpi {

    /**
     * Creates a new {@code SecretKeyFactorySpi} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.607 -0500", hash_original_method = "37AA0CEAD968FA5AED19221177267C4C", hash_generated_method = "45D9986BE3FF03E6B58BB0BC2D3DAD9B")
    
public SecretKeyFactorySpi() {
    }

    /**
     * Generate a secret key from the specified key specification.
     *
     * @param keySpec
     *            the key specification.
     * @return a secret key.
     * @throws InvalidKeySpecException
     *             if the specified key specification cannot be used to generate
     *             a secret key.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.609 -0500", hash_original_method = "AF68CD0CA77D7F636E0A4995A1F72B0F", hash_generated_method = "8CC28459B9390463B7AB4F267782111C")
    
protected abstract SecretKey engineGenerateSecret(KeySpec keySpec)
            throws InvalidKeySpecException;

    /**
     * Returns the key specification of the specified secret key.
     *
     * @param key
     *            the secret key to get the specification from.
     * @param keySpec
     *            the target key specification class.
     * @return an instance of the specified key specification class.
     * @throws InvalidKeySpecException
     *             if the specified secret key cannot be transformed into the
     *             requested key specification.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.611 -0500", hash_original_method = "D6F8AD1DDD97E9CFA8FE854EA3F170C2", hash_generated_method = "13C83817EC1ADE4A8347EA4685336C60")
    
@SuppressWarnings("unchecked")
    protected abstract KeySpec engineGetKeySpec(SecretKey key, Class keySpec)
            throws InvalidKeySpecException;

    /**
     * Translates the specified secret key into an instance of the corresponding
     * key from the provider of this key factory.
     *
     * @param key
     *            the secret key to translate.
     * @return the corresponding translated key.
     * @throws InvalidKeyException
     *             if the specified key cannot be translated using this key
     *             factory.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.614 -0500", hash_original_method = "D8939E80868756AF07DC1B6350589F5C", hash_generated_method = "D93027D8D9217F741510084EB1711D17")
    
protected abstract SecretKey engineTranslateKey(SecretKey key)
            throws InvalidKeyException;
    
}

