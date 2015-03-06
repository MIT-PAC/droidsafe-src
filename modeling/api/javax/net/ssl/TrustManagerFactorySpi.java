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

public abstract class TrustManagerFactorySpi {

    /**
     * Creates a new {@code TrustManagerFactorySpi} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.357 -0500", hash_original_method = "A9501ACA551B0C72B8BE137F9D419E50", hash_generated_method = "39185E31F9FDBB49C07C5ECBF777DFC1")
    
public TrustManagerFactorySpi() {
    }

    /**
     * Initializes this factory instance with the specified keystore as source
     * of certificate authorities and trust material.
     *
     * @param ks
     *            the keystore or {@code null}.
     * @throws KeyStoreException
     *             if the initialization fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.359 -0500", hash_original_method = "A36FBD4F38FC74970786C4A1820E4581", hash_generated_method = "EE7303806E4C37482E7B9A89A4914786")
    
protected abstract void engineInit(KeyStore ks) throws KeyStoreException;

    /**
     * Initializes this factory instance with the specified provider-specific
     * parameters for a source of trust material.
     *
     * @param spec
     *            the provider-specific parameters.
     * @throws InvalidAlgorithmParameterException
     *             if the initialization fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.362 -0500", hash_original_method = "E8464373E665456E480D3D33F7327997", hash_generated_method = "6C76039366DDF10BC7CEC02412F7F915")
    
protected abstract void engineInit(ManagerFactoryParameters spec)
            throws InvalidAlgorithmParameterException;

    /**
     * Returns the list of {@code TrustManager}s with one entry for each type
     * of trust material.
     *
     * @return the list of {@code TrustManager}s
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.364 -0500", hash_original_method = "87C9EE09C143A95EAE6F2AA8C5201D60", hash_generated_method = "D66C2C8B45C4D1B239C7AF4B28248BEA")
    
protected abstract TrustManager[] engineGetTrustManagers();
    
}

