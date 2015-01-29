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

package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * {@code GuardedObject} controls access to an object, by checking all requests
 * for the object with a {@code Guard}.
 */
public class GuardedObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.526 -0400", hash_original_field = "C7B11645365795D7904B629F77E9389A", hash_generated_field = "895292B936A87972BD9D3350477AE620")


    private static final long serialVersionUID = -5240450096227834308L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.528 -0400", hash_original_field = "4725548B2F852700377486F07DBD49CE", hash_generated_field = "80AFDCB6A31A0FDD928E1F95B3C4C720")


    private  Object object;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.529 -0400", hash_original_field = "0DEC357E5553A289C24E8224E3FABBAF", hash_generated_field = "2A493F8B64B23945CF436E0D207B11A2")


    private  Guard guard;

    /**
     * Constructs a new instance of {@code GuardedObject} which protects access
     * to the specified {@code Object} using the specified {@code Guard}.
     *
     * @param object
     *            the {@code Object} to protect.
     * @param guard
     *            the {@code Guard} which protects the specified {@code Object},
     *            maybe {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.531 -0400", hash_original_method = "F91A4DA1A9D1397F1056F788ACC82602", hash_generated_method = "F270379E815288D6C12AEA23874A7484")
    
public GuardedObject(Object object, Guard guard) {
        this.object = object;
        this.guard = guard;
    }

    /**
     * Returns the guarded {@code Object} if the associated {@code Guard}
     * permits access. If access is not granted, then a {@code
     * SecurityException} is thrown.
     *
     * @return the guarded object.
     * @exception SecurityException
     *                if access is not granted to the guarded object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.532 -0400", hash_original_method = "3EF173A6C6367EC6BC9E6B537A363AF5", hash_generated_method = "7C5E9C80A577D6664DDEDA5993E62201")
    
public Object getObject() throws SecurityException {
        if (guard != null) {
            guard.checkGuard(object);
        }
        return object;
    }

    /**
     * Checks the guard (if there is one) before performing a default
     * serialization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.534 -0400", hash_original_method = "348630D7F52CD6FE922772D18E5A4EE3", hash_generated_method = "2981E8416B8EEBBC7C8DB8E201224C05")
    
private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        if (guard != null) {
            guard.checkGuard(object);
        }
        out.defaultWriteObject();
    }
}
