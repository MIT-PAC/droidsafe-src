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
import java.security.InvalidAlgorithmParameterException;

/**
 * The <i>Service Provider Interface</i> (<b>SPI</b>) for the {@code
 * CertPathBuilder} class to be implemented by security providers.
 */
public abstract class CertPathBuilderSpi {

    /**
     * Creates a new {@code CertPathBuilderSpi} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.176 -0400", hash_original_method = "55FFF38B95139A5950DF41ED10B169E6", hash_generated_method = "30E3FA01CF6B1F20644F7043879EB4AF")
    
public CertPathBuilderSpi() {
    }

    /**
     * Builds a certification path with the specified algorithm parameters.
     *
     * @param params
     *            the algorithm parameters.
     * @return a result of the build.
     * @throws CertPathBuilderException
     *             if the build fails.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to build the path
     *             with this builder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.178 -0400", hash_original_method = "6708C6C839E807F9080FF64DCD37A4A3", hash_generated_method = "157A94773CCEB9E791B0CEF21C9D5979")
    
public abstract CertPathBuilderResult engineBuild(CertPathParameters params)
            throws CertPathBuilderException, InvalidAlgorithmParameterException;
}
