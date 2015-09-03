/* Licensed to the Apache Software Foundation (ASF) under one or more
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * An in-memory cookie store.
 */
final class CookieStoreImpl implements CookieStore {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.650 -0400", hash_original_field = "9B8E084857CCACA1BEFC47843FDA078C", hash_generated_field = "842CEEB766E641B4EA45962832011011")

    private final Map<URI, List<HttpCookie>> map = new HashMap<URI, List<HttpCookie>>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.651 -0400", hash_original_method = "51B797FB41044C29522312BDCDE31717", hash_generated_method = "0C817122F420E95077D2E70AF50C4B7D")
    
public synchronized void add(URI uri, HttpCookie cookie) {
        if (cookie == null) {
            throw new NullPointerException("cookie == null");
        }

        uri = cookiesUri(uri);
        List<HttpCookie> cookies = map.get(uri);
        if (cookies == null) {
            cookies = new ArrayList<HttpCookie>();
            map.put(uri, cookies);
        } else {
            cookies.remove(cookie);
        }
        cookies.add(cookie);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.652 -0400", hash_original_method = "0A2891F9C0476E3020B77298037EAD1B", hash_generated_method = "7679B8F12063276DD27093288FA69C15")
    
private URI cookiesUri(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URI("http", uri.getHost(), null, null);
        } catch (URISyntaxException e) {
            return uri; // probably a URI with no host
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.654 -0400", hash_original_method = "EE668B820BC86891303106CA0697BE66", hash_generated_method = "EAE5E7142D69D9F0E6087869A09DB38B")
    
public synchronized List<HttpCookie> get(URI uri) {
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }

        List<HttpCookie> result = new ArrayList<HttpCookie>();

        // get cookies associated with given URI. If none, returns an empty list
        List<HttpCookie> cookiesForUri = map.get(uri);
        if (cookiesForUri != null) {
            for (Iterator<HttpCookie> i = cookiesForUri.iterator(); i.hasNext(); ) {
                HttpCookie cookie = i.next();
                if (cookie.hasExpired()) {
                    i.remove(); // remove expired cookies
                } else {
                    result.add(cookie);
                }
            }
        }

        // get all cookies that domain matches the URI
        for (Map.Entry<URI, List<HttpCookie>> entry : map.entrySet()) {
            if (uri.equals(entry.getKey())) {
                continue; // skip the given URI; we've already handled it
            }

            List<HttpCookie> entryCookies = entry.getValue();
            for (Iterator<HttpCookie> i = entryCookies.iterator(); i.hasNext(); ) {
                HttpCookie cookie = i.next();
                if (!HttpCookie.domainMatches(cookie.getDomain(), uri.getHost())) {
                    continue;
                }
                if (cookie.hasExpired()) {
                    i.remove(); // remove expired cookies
                } else if (!result.contains(cookie)) {
                    result.add(cookie);
                }
            }
        }

        return Collections.unmodifiableList(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.655 -0400", hash_original_method = "7E05F0EB9E873E0D8407820433914B3A", hash_generated_method = "1218FB900E5D587B62462B05B0480598")
    
public synchronized List<HttpCookie> getCookies() {
        List<HttpCookie> result = new ArrayList<HttpCookie>();
        for (List<HttpCookie> list : map.values()) {
            for (Iterator<HttpCookie> i = list.iterator(); i.hasNext(); ) {
                HttpCookie cookie = i.next();
                if (cookie.hasExpired()) {
                    i.remove(); // remove expired cookies
                } else if (!result.contains(cookie)) {
                    result.add(cookie);
                }
            }
        }
        return Collections.unmodifiableList(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.656 -0400", hash_original_method = "E5CE7D859B55B995117F11B66850C8F9", hash_generated_method = "351803720AB7C49916CABCE98DD06C79")
    
public synchronized List<URI> getURIs() {
        List<URI> result = new ArrayList<URI>(map.keySet());
        result.remove(null); // sigh
        return Collections.unmodifiableList(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.657 -0400", hash_original_method = "85A55D5356B5FDB84F8EF5ECA828FA4E", hash_generated_method = "9E840BCFF2CB9F935D93CC2062E8CFF0")
    
public synchronized boolean remove(URI uri, HttpCookie cookie) {
        if (cookie == null) {
            throw new NullPointerException("cookie == null");
        }

        List<HttpCookie> cookies = map.get(cookiesUri(uri));
        if (cookies != null) {
            return cookies.remove(cookie);
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:49.657 -0400", hash_original_method = "2AC061B807C4805543D9B11BBCDC342B", hash_generated_method = "2C236DEC26A23D75A8ED3886C42A5E81")
    
public synchronized boolean removeAll() {
        boolean result = !map.isEmpty();
        map.clear();
        return result;
    }
}
