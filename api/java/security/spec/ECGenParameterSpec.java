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

package java.security.spec;

/**
 * The parameter specification used to generate elliptic curve domain parameters.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ECGenParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.100 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "232D92AC17D9733A0A26DC5A1EC5FECB")

    // parameters to be generated
    private  String name;

    /**
     * Creates a new {@code ECGenParameterSpec} with the specified standard or
     * predefined name of the to-be-generated domain parameter.
     *
     * @param name
     *            the name of the elliptic curve domain parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.102 -0400", hash_original_method = "CFB9FDFD0FE906E3D652A89274CDE44E", hash_generated_method = "FA2474B24CBC42EEDEA6BE2F2DD8841D")
    
public ECGenParameterSpec(String name) {
        this.name = name;
        if (this.name == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Returns the name (standard or predefined) of the to-be-generated elliptic
     * curve domain parameter.
     *
     * @return the name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.103 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }
}
