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
 * Copyright (C) 2009 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLSession;

public class ServerSessionContext extends AbstractSessionContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.043 -0500", hash_original_field = "E7EEAAE01EABB89BC3E379487CEBB368", hash_generated_field = "03372E20A94CFEB28F0443462F1FB862")

    private SSLServerSessionCache persistentCache;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.045 -0500", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "9294AAB5FDC3944344DC26B8620D5739")
    
public ServerSessionContext() {
        super(100, 0);

        // TODO make sure SSL_CTX does not automaticaly clear sessions we want it to cache
        // SSL_CTX_set_session_cache_mode(sslCtxNativePointer, SSL_SESS_CACHE_NO_AUTO_CLEAR);

        // TODO remove SSL_CTX session cache limit so we can manage it
        // SSL_CTX_sess_set_cache_size(sslCtxNativePointer, 0);

        // TODO override trimToSize and removeEldestEntry to use
        // SSL_CTX_sessions to remove from native cache
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.048 -0500", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "0CE628A3442C9B41FB1AD0CD0840A6BD")
    
public void setPersistentCache(SSLServerSessionCache persistentCache) {
        this.persistentCache = persistentCache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.050 -0500", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "5E399269F22ECC6C6D361AA835F3E0CE")
    
protected void sessionRemoved(SSLSession session) {}

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.053 -0500", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "686501806461EE8B4EC98F9B766B54DC")
    
@Override
    public SSLSession getSession(byte[] sessionId) {
        SSLSession session = super.getSession(sessionId);
        if (session != null) {
            return session;
        }

        // Check persistent cache.
        if (persistentCache != null) {
            byte[] data = persistentCache.getSessionData(sessionId);
            if (data != null) {
                session = toSession(data, null, -1);
                if (session != null && session.isValid()) {
                    super.putSession(session);
                    return session;
                }
            }
        }

        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.055 -0500", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "FC7A1CB319997E6C38E03AB1A8EC0177")
    
@Override
    void putSession(SSLSession session) {
        super.putSession(session);

        // TODO: In background thread.
        if (persistentCache != null) {
            byte[] data = toBytes(session);
            if (data != null) {
                persistentCache.putSessionData(session, data);
            }
        }
    }
    
}

