/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/NTUserPrincipal.java $
 * $Revision: 658430 $
 * $Date: 2008-05-20 14:04:27 -0700 (Tue, 20 May 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.Principal;
import java.util.Locale;

import org.apache.http.util.LangUtils;

/**  NT (MS Windows specific) user principal used for HTTP authentication
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 4.0
 */
public class NTUserPrincipal implements Principal {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.781 -0400", hash_original_field = "B2F4FF4B7C64B804BB17E343923252BC", hash_generated_field = "E7582A281BF492F7D35360548F0218CD")

    private  String username;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.782 -0400", hash_original_field = "B45971700BE10ABC690F6ABCD38C274A", hash_generated_field = "5DD0748096DF7E459884FCD3EB6DD3AB")

    private  String domain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.784 -0400", hash_original_field = "EC4035914F87D72C16B7DEA6A6023DF2", hash_generated_field = "9A3F7AA3D8F4124A180AEF7176AD27A6")

    private  String ntname;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.785 -0400", hash_original_method = "15C0F071CB2762862E66156214905CCC", hash_generated_method = "4D6FF68F02FAA4CC0E84052CF5BE4AB4")
    
public NTUserPrincipal(
            final String domain,
            final String username) {
        super();
        if (username == null) {
            throw new IllegalArgumentException("User name may not be null");
        }
        this.username = username;
        if (domain != null) {
            this.domain = domain.toUpperCase(Locale.ENGLISH);
        } else {
            this.domain = null;
        }
        if (this.domain != null && this.domain.length() > 0) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.domain);
            buffer.append('/');
            buffer.append(this.username);
            this.ntname = buffer.toString();
        } else {
            this.ntname = this.username;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.786 -0400", hash_original_method = "10A59AB1040D44FC17A820082A2C139B", hash_generated_method = "DAE3BC0D97E89D0313B9F45AEC6F2749")
    
public String getName() {
        return this.ntname;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.788 -0400", hash_original_method = "BAFB5DB07A2E625BB4219341D98E5085", hash_generated_method = "A1C2B749F4290B6DF494E4FA000C14E6")
    
public String getDomain() {
        return this.domain;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.789 -0400", hash_original_method = "A8D3F1F624634C412A7A94C406A9EECE", hash_generated_method = "244D5A44EC6152AD0DF68DC2B0896494")
    
public String getUsername() {
        return this.username;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.790 -0400", hash_original_method = "9C6C9865A5B242DD47851CBBE42BEE6B", hash_generated_method = "4672BEF12838587E700F760D3044E6AB")
    
@Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.username);
        hash = LangUtils.hashCode(hash, this.domain);
        return hash;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.792 -0400", hash_original_method = "5EB6161BABF2A9FB23BAFC3B59108B85", hash_generated_method = "25B2387EA883315F3CF41AA5C50EFE5D")
    
@Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof NTUserPrincipal) {
            NTUserPrincipal that = (NTUserPrincipal) o;
            if (LangUtils.equals(this.username, that.username)
                    && LangUtils.equals(this.domain, that.domain)) {
                return true;
            }
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.793 -0400", hash_original_method = "CB93CDFC3C33AE7223FD79C48586D7E2", hash_generated_method = "29780688FB2767BBFB2CEE98F6372CE5")
    
@Override
    public String toString() {
        return this.ntname;
    }

}
