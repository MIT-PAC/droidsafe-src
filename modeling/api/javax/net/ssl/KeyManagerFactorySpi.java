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


package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public abstract class KeyManagerFactorySpi {

    /**
     * Creates a new {@code KeyManagerFactorySpi} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.279 -0500", hash_original_method = "6A7E81CC9CE1799ACFD008A7DC048460", hash_generated_method = "F5CC1388BD4584472660C93AE5203C58")
    
public KeyManagerFactorySpi() {
    }

    /**
     * Initializes this instance with the specified key store and password.
     *
     * @param ks
     *            the key store or {@code null} to use the default key store.
     * @param password
     *            the key store password.
     * @throws KeyStoreException
     *             if initializing this instance fails.
     * @throws NoSuchAlgorithmException
     *             if a required algorithm is not available.
     * @throws UnrecoverableKeyException
     *             if a key cannot be recovered.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.282 -0500", hash_original_method = "0D3635A5835C673EAD5B27BBB788074D", hash_generated_method = "C0D480B7C5034ED1B3D23C67E786E8C8")
    
protected abstract void engineInit(KeyStore ks, char[] password) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableKeyException;

    /**
     * Initializes this instance with the specified factory parameters.
     *
     * @param spec
     *            the factory parameters.
     * @throws InvalidAlgorithmParameterException
     *             if an error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.284 -0500", hash_original_method = "E8464373E665456E480D3D33F7327997", hash_generated_method = "6C76039366DDF10BC7CEC02412F7F915")
    
protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    /**
     * Returns a list of key managers, one instance for each type of key in the
     * key store.
     *
     * @return a list of key managers.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.286 -0500", hash_original_method = "8AA3A930AA2BEA7107EAE536F3FF6F57", hash_generated_method = "5859AFE7FD8C07975D107F33B4FBBAFE")
    
protected abstract KeyManager[] engineGetKeyManagers();
    
}

