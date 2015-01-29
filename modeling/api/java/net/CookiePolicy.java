/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.net;

/**
 * CookiePolicy has three pre-defined policy. They are ACCEPT_ALL, ACCEPT_NONE
 * and ACCEPT_ORIGINAL_SERVER respectively. They are used to decide which
 * cookies should be accepted and which should not be.
 *
 * See <a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a> sections 3.3 and 7 for more detail.
 *
 * @since 1.6
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface CookiePolicy {

    /**
     * A pre-defined policy, accepts all cookies.
     */
    static final CookiePolicy ACCEPT_ALL = new CookiePolicy() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.626 -0400", hash_original_method = "015A694C2E342221DE9D2D73BC29DDF0", hash_generated_method = "11B5B992CD7A7DE7C9E136D3E99FE7D7")
        
public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return true;
        }
    };

    /**
     * A pre-defined policy, accepts no cookies at all.
     */
    static final CookiePolicy ACCEPT_NONE = new CookiePolicy() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.628 -0400", hash_original_method = "6DC9D39591FE62925F95E3F90128E871", hash_generated_method = "6042D56BA824195A142831757006B938")
        
public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return false;
        }
    };

    /**
     * A pre-defined policy, only accepts cookies from original server.
     */
    static final CookiePolicy ACCEPT_ORIGINAL_SERVER = new CookiePolicy() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.630 -0400", hash_original_method = "E390BD55896157EAC9A05FECA4A37963", hash_generated_method = "33E7D7A26168939D5DA337538786561F")
        
public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return HttpCookie.domainMatches(cookie.getDomain(), uri.getHost());
        }
    };

    /**
     * This method is used to determine whether or not the specified cookie
     * should be accepted.
     *
     * @param uri
     *            the URI to used to determine acceptability
     * @param cookie
     *            the HttpCookie to be determined
     * @return true if this cookie should be accepted; false otherwise
     */
    boolean shouldAccept(URI uri, HttpCookie cookie);
}
