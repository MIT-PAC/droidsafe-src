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


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public abstract class KeyFactorySpi {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.907 -0400", hash_original_method = "54B4D82F193E9DD361521453DB006D9F", hash_generated_method = "54B4D82F193E9DD361521453DB006D9F")
    public KeyFactorySpi ()
    {
        //Synthesized constructor
    }

    /**
     * Generates a instance of {@code PublicKey} from the given key
     * specification.
     *
     * @param keySpec
     *            the specification of the public key.
     * @return the public key.
     * @throws InvalidKeySpecException
     *             if the specified {@code keySpec} is invalid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.178 -0500", hash_original_method = "D6CBDC24661621DB5B3D02223C9C18D6", hash_generated_method = "04A9286E90285594D40D9CFA95FCFCF7")
    
protected abstract PublicKey engineGeneratePublic(KeySpec keySpec)
                                    throws InvalidKeySpecException;

    /**
     * Generates a instance of {@code PrivateKey} from the given key
     * specification.
     *
     * @param keySpec
     *            the specification of the private key.
     * @return the private key.
     * @throws InvalidKeySpecException
     *             if the specified {@code keySpec} is invalid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.180 -0500", hash_original_method = "B01010AAC698B841B835E796B271E4E0", hash_generated_method = "CBABE83B283930D737F79AC35B467C80")
    
protected abstract PrivateKey engineGeneratePrivate(KeySpec keySpec)
                                    throws InvalidKeySpecException;
    
    protected abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> keySpec)
                                    throws InvalidKeySpecException;
    //FIXME 1.5 signature: protected abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> keySpec) throws InvalidKeySpecException

    /**
     * Translates the given key into a key from this key factory.
     *
     * @param key
     *            the key to translate.
     * @return the translated key.
     * @throws InvalidKeyException
     *             if the specified key can not be translated by this key
     *             factory.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.185 -0500", hash_original_method = "739471E10F30D482CB26890FE5494425", hash_generated_method = "46A9471F10A33BCB686EEB889CF4F386")
    
protected abstract Key engineTranslateKey(Key key) throws InvalidKeyException;
    
}

