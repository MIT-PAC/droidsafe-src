/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/BasicUserPrincipal.java $
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

import org.apache.http.util.LangUtils;

/**
 * Basic user principal used for HTTP authentication
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @since 4.0
 */
public final class BasicUserPrincipal implements Principal {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.911 -0400", hash_original_field = "B2F4FF4B7C64B804BB17E343923252BC", hash_generated_field = "E7582A281BF492F7D35360548F0218CD")

    private  String username;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.911 -0400", hash_original_method = "E9F4A83469279A4A12C48F4EEC0817B3", hash_generated_method = "C4D8E2A563C92DCEC84F7D71DD260122")
    
public BasicUserPrincipal(final String username) {
        super();
        if (username == null) {
            throw new IllegalArgumentException("User name may not be null");
        }
        this.username = username;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.912 -0400", hash_original_method = "C98891613636EF2965B8BFD539D89D43", hash_generated_method = "0A53A95F7E1F4EF5E4CF696D70F9BA7E")
    
public String getName() {
        return this.username;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.912 -0400", hash_original_method = "00146F6E979B31F3ADD0C335BB09FECD", hash_generated_method = "616DC7C81FE8BC24EE036C4FF39F1AD4")
    
@Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.username);
        return hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.913 -0400", hash_original_method = "0828205FE5941175F133283554EC0DB0", hash_generated_method = "92D518BED54FF750C48AB3F442D33980")
    
@Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof BasicUserPrincipal) {
            BasicUserPrincipal that = (BasicUserPrincipal) o;
            if (LangUtils.equals(this.username, that.username)) {
                return true;
            }
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.914 -0400", hash_original_method = "7E163E1A4FB07693AC35A1158CCAD841", hash_generated_method = "3752CAEFAC828A98E2316E2EE35BB5EC")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[principal: ");
        buffer.append(this.username);
        buffer.append("]");
        return buffer.toString();
    }

}

