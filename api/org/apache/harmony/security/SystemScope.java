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

/**
* @author Aleksei Y. Semenov
* @version $Revision$
*/

package org.apache.harmony.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.Identity;
import java.security.IdentityScope;
import java.security.KeyManagementException;
import java.security.PublicKey;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @see java.security.IdentityScope
 */

public class SystemScope extends IdentityScope {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.272 -0400", hash_original_field = "0E80796E22B66B554E2A916671B1D3C9", hash_generated_field = "FCBFD999DA5046B7BEEF664D41DF19FD")

    private static final long serialVersionUID = -4810285697932522607L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.273 -0400", hash_original_field = "D32C06F3AA2D7D68279CA3E62E7A38C6", hash_generated_field = "EAADC6435AB5CBE61F4E99304E1977B4")

    private Hashtable names = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.273 -0400", hash_original_field = "F76C2B604578300AA44ADCE87965E557", hash_generated_field = "F9A81B4719B25B07C93307C136DA6294")

    private Hashtable keys = new Hashtable();

    /**
     * @see java.security.IdentityScope#IdentityScope()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.274 -0400", hash_original_method = "B35B198ED4F70D998E44FE40B441EFD7", hash_generated_method = "9D3E8D656781F28F57E7E7E51FBD8254")
    
public SystemScope() {
    }

    /**
     * @see java.security.IdentityScope#IdentityScope(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.274 -0400", hash_original_method = "02204E3A76FE20829267EFF2B22BE6CC", hash_generated_method = "BBE57B8BE6D110CF09430DC3B9D4938A")
    
public SystemScope(String name) {
        super(name);
    }

    /**
     * @see java.security.IdentityScope#IdentityScope(String, IdentityScope)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.275 -0400", hash_original_method = "1CEA6AF002F18E080FFE8E26B3D5D963", hash_generated_method = "B6E7B857C4AD661A483795C093073B52")
    
public SystemScope(String name, IdentityScope scope)
            throws KeyManagementException {
        super(name, scope);
    }

    /**
     * @see java.security.IdentityScope#size()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.275 -0400", hash_original_method = "2350DF2DA265692058D3EF6395C37C4B", hash_generated_method = "45ECAB1E8CDA2B57F55E83E761D63A62")
    
public int size() {
        return names.size();
    }

    /**
     * @see java.security.IdentityScope#getIdentity(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.276 -0400", hash_original_method = "77A9E9D3BC35A93B3CCA7D20B7C98D82", hash_generated_method = "94012D816A0BA4E4194B1085AE68F187")
    
public synchronized Identity getIdentity(String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        return (Identity) names.get(name);
    }

    /**
     * @see java.security.IdentityScope#getIdentity(java.security.PublicKey)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.276 -0400", hash_original_method = "CD63541DC6AB48F0D9D05A1DB8B37244", hash_generated_method = "84FF218B6492BDB549EDC742966E4FE6")
    
public synchronized Identity getIdentity(PublicKey key) {
        if (key == null) {
            return null;
        }
        return (Identity) keys.get(key);
    }

    /**
     * @see java.security.IdentityScope#addIdentity(java.security.Identity)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.277 -0400", hash_original_method = "1A7A65F4BDE6FAAAFFC40F74D5BCFB89", hash_generated_method = "5CCEE543920D66132F5008BB0247E022")
    
public synchronized void addIdentity(Identity identity) throws KeyManagementException {
        if (identity == null) {
            throw new NullPointerException("identity == null");
        }

        String name = identity.getName();
        if (names.containsKey(name)) {
            throw new KeyManagementException("name '" + name + "' is already used");
        }

        PublicKey key = identity.getPublicKey();
        if (key != null && keys.containsKey(key)) {
            throw new KeyManagementException("key '" + key + "' is already used");
        }

        names.put(name, identity);
        if (key != null) {
            keys.put(key, identity);
        }
    }

    /**
     * @see java.security.IdentityScope#removeIdentity(java.security.Identity)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.278 -0400", hash_original_method = "3D09B88255894334AC6C0F360A015FAF", hash_generated_method = "EF8D74269BCFAB4E6589B7854EE3CDBA")
    
public synchronized void removeIdentity(Identity identity)
            throws KeyManagementException {

        //Exception caught = null;
        if (identity == null) {
            throw new NullPointerException("identity == null");
        }

        String name = identity.getName();
        if (name == null) {
            throw new NullPointerException("name == null");
        }

        boolean contains = names.containsKey(name);
        names.remove(name);

        PublicKey key = identity.getPublicKey();

        if (key != null) {
            contains = contains || keys.containsKey(key);
            keys.remove(key);
        }

        if (!contains) {
            throw new KeyManagementException("identity not found");
        }
    }

    /**
     * @see java.security.IdentityScope#identities()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.279 -0400", hash_original_method = "03259C8365C7013D9B26A19876DAD198", hash_generated_method = "449A1C6605DFE49EB1A65D613B49C324")
    
public Enumeration identities() {
        return names.elements();
    }
}
