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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/entity/HttpEntityWrapper.java $
 * $Revision: 496070 $
 * $Date: 2007-01-14 04:18:34 -0800 (Sun, 14 Jan 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class HttpEntityWrapper implements HttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.816 -0500", hash_original_field = "DAC198C5909CCB54353BED3B9E4CBA7E", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;

    /**
     * Creates a new entity wrapper.
     *
     * @param wrapped   the entity to wrap
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.818 -0500", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "3B463090CD85133EA75742B90CB4B38A")
    
public HttpEntityWrapper(HttpEntity wrapped) {
        super();

        if (wrapped == null) {
            throw new IllegalArgumentException
                ("wrapped entity must not be null");
        }
        wrappedEntity = wrapped;

    } // constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.821 -0500", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "A7869F408064539376386BA11273444E")
    
public boolean isRepeatable() {
        return wrappedEntity.isRepeatable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.823 -0500", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "C078A51D2F78D56E6BFF9A341C04BF09")
    
public boolean isChunked() {
        return wrappedEntity.isChunked();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.825 -0500", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "7E046C22E149DB121AF317DB8766BFCA")
    
public long getContentLength() {
        return wrappedEntity.getContentLength();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.828 -0500", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "95948A8A1C15106D85E087E36E1A5E3E")
    
public Header getContentType() {
        return wrappedEntity.getContentType();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.830 -0500", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "BAC98E383F19DD74C4235118AB581A0B")
    
public Header getContentEncoding() {
        return wrappedEntity.getContentEncoding();
    }

    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.832 -0500", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "49F44DDDCF30859499FEBA5D2E51B47E")
    
public InputStream getContent()
        throws IOException {
        return wrappedEntity.getContent();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.834 -0500", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "7177975BE493E9B969B7CF7EB1DD7476")
    @DSVerified
    @DSSpec(DSCat.IO)
public void writeTo(OutputStream outstream)
        throws IOException {
        wrappedEntity.writeTo(outstream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.836 -0500", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "FC0CC19CCC8433A550E08DFE9A586FB3")
    
public boolean isStreaming() {
        return wrappedEntity.isStreaming();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.839 -0500", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "CCF0369DEB5EC85D69C5470E4543D266")
    
public void consumeContent()
        throws IOException {
        wrappedEntity.consumeContent();
    }
    
}

