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

package java.net;

/**
 * The {@code NoRouteToHostException} will be thrown while attempting to connect
 * to a remote host but the host cannot be reached for instance because of a
 * badly configured router or a blocking firewall.
 *
 * <p>Most applications <strong>should not</strong> catch this exception; it is
 * more robust to catch the superclass {@code SocketException}.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class NoRouteToHostException extends SocketException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.295 -0400", hash_original_field = "7C19665E2CCBB8AA6FA496854904944F", hash_generated_field = "C39E7BFAC6C97B4E2AA3C72FA2F670D4")


    private static final long serialVersionUID = -1897550894873493790L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.297 -0400", hash_original_method = "B717F8BB65CEF7F4AB8BDF4C9050EA74", hash_generated_method = "77C263E13E8D3D16C451A78F90CAED4F")
    
public NoRouteToHostException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.298 -0400", hash_original_method = "A338A2C46A5DAA31B5F3D3B73AA16B49", hash_generated_method = "59C3EBD8D9BDD3F1810EFCD43DA984FB")
    
public NoRouteToHostException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.300 -0400", hash_original_method = "EF06695079F2C9BA1719975CFCD8F116", hash_generated_method = "E93289BAEBC31F389CBAABE9FE2D4253")
    
public NoRouteToHostException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}
