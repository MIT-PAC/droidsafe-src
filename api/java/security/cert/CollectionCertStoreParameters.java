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
import java.util.Collection;
import java.util.Collections;

/**
 * The parameters to initialize a <i>Collection</i> type {@code CertStore} instance.
 * <p>
 * It is used to specify the {@code Collection} where the {@code CertStore} will
 * retrieve the certificates and CRLs from.
 */
public class CollectionCertStoreParameters implements CertStoreParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.449 -0400", hash_original_field = "CB2B7F39B30AE71208E3865E647B29FA", hash_generated_field = "C9A8D41D1B3CBCFBAAFDE3800192C125")

    // Used if <code>CollectionCertStoreParameters</code>instance
    // created by the no arg constructor
    private static final Collection<?> defaultCollection = Collections.EMPTY_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.450 -0400", hash_original_field = "9F12405ACEA5C1E6A7896316855BE61F", hash_generated_field = "8F304A46F6A6E44B9E39155C77B14A69")

    // and <code>CRL</code>s
    private  Collection<?> collection;

    /**
     * Creates a new {@code CollectionCertStoreParameters} without a collection.
     * <p>
     * The default collection is an empty and unmodifiable {@code Collection}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.452 -0400", hash_original_method = "8855AC293E9A5B24BC9EA30268113F08", hash_generated_method = "1FAC116F8CFB763AA6C09285F6FF4FC2")
    
public CollectionCertStoreParameters() {
        this.collection = defaultCollection;
    }

    /**
     * Creates a new {@code CollectionCertStoreParameters} with the specified
     * collection.
     * <p>
     * The specified collection is not copied and therefore may be modified at
     * any time.
     *
     * @param collection
     *            the collection where the {@code Certificate}s and {@code CRL}s
     *            will be retrieved from.
     * @throws NullPointerException
     *             if {@code collection is null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.454 -0400", hash_original_method = "43678558B00A609C6AC6CC5DE2D6E494", hash_generated_method = "29BEAC1CCB897A0643B4720A67C9DF5F")
    
public CollectionCertStoreParameters(Collection<?> collection) {
        this.collection = collection;
        if (this.collection == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Clones this {@code CollectionCertStoreParameters} instance, but not the
     * underlying collection.
     *
     * @return the cloned instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.456 -0400", hash_original_method = "54040598955C6E8BA382734C61174608", hash_generated_method = "0239CEC56D53D9115DB8BFABFCC35553")
    
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Returns the collection where the {@code Certificate}s and {@code CRL}s
     * are retrieved from.
     *
     * @return the collection where the {@code Certificate}s and {@code CRL}s
     *         will be retrieved from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.457 -0400", hash_original_method = "753AD529B367BAEFE36F5809F906DE64", hash_generated_method = "FA756AE7F9D114CE7C63F2DD8B260684")
    
public Collection<?> getCollection() {
        return collection;
    }

    /**
     * Returns the string representation of this instance.
     *
     * @return the string representation of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.458 -0400", hash_original_method = "701121F800C200039146171FD9858B49", hash_generated_method = "773A0187530C4A2A8CBE79187C5CDFD7")
    
public String toString() {
        StringBuilder sb =
            new StringBuilder("CollectionCertStoreParameters: [\ncollection: ");
        sb.append(getCollection().toString());
        sb.append("\n]");
        return sb.toString();
    }
}
