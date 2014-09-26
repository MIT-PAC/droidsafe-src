/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.nio.charset.StandardCharsets;

import static libcore.io.OsConstants.*;

/**
 * An AF_UNIX address. See {@link InetAddress}.
 * @hide
 */
public final class InetUnixAddress extends InetAddress {
  /**
   * Constructs an AF_UNIX InetAddress for the given path.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.986 -0400", hash_original_method = "CC832A35FE601E9E0A1152E789C36A46", hash_generated_method = "153ED34AB6DD9C923169A49265BFA595")
    
public InetUnixAddress(String path) {
    this(path.getBytes(StandardCharsets.UTF_8));
  }

  /**
   * Constructs an AF_UNIX InetAddress for the given path.
   */
  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.987 -0400", hash_original_method = "EC306B886409E33C7187B4E052188C9E", hash_generated_method = "E1A9B248B3601041B560DA28AF5958D1")
    
public InetUnixAddress(byte[] path) {
    super(AF_UNIX, path, null);
  }

  /**
   * Returns a string form of this InetAddress.
   */
  @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:45.987 -0400", hash_original_method = "B7A1DD9D7C4B5BB01E3117D671176C5F", hash_generated_method = "B3757691A12CBC0618277262E74206BA")
    
@Override public String toString() {
    return "InetUnixAddress[" + new String(ipaddress, StandardCharsets.UTF_8) + "]";
  }
}
