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

package org.apache.harmony.javax.security.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class AuthenticationException extends SaslException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.602 -0400", hash_original_field = "2E15FCE664F6390E7C19941409644AB6", hash_generated_field = "26ECC804C94FA3C9DE76C823A137A5B5")


    private static final long serialVersionUID = -3579708765071815007L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.602 -0400", hash_original_method = "013088ABC431C6F3F4CF96BA31947D05", hash_generated_method = "589B79B769FA1AE4B40AF25F9E862625")
    
public AuthenticationException() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.603 -0400", hash_original_method = "7E690CDB8A1182B1B4BC2A335B9AF2AD", hash_generated_method = "08DD0A125241EC1C0EE1140A93266422")
    
public AuthenticationException(String detail) {
        super(detail);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.603 -0400", hash_original_method = "801A99D9268D0666E06B1E757518CA52", hash_generated_method = "8E1C10DA2D0139EBCCCC9CFDAEB9343C")
    
public AuthenticationException(String detail, Throwable ex) {
        super(detail, ex);
    }
}
