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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/HttpTransportMetricsImpl.java $
 * $Revision: 539755 $
 * $Date: 2007-05-19 07:05:02 -0700 (Sat, 19 May 2007) $
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


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.io.HttpTransportMetrics;

public class HttpTransportMetricsImpl implements HttpTransportMetrics {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.380 -0500", hash_original_field = "E8E208568B2733C138CF9FA3514C2C0C", hash_generated_field = "758177ECF64D712D2723B646394F959F")

    private long bytesTransferred = 0;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.382 -0500", hash_original_method = "7D2D78BCCD20A0F0768C108C18222508", hash_generated_method = "5F095FB2C9B4C0EB13FBD76A4AF11235")
    
public HttpTransportMetricsImpl() {
        super();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.384 -0500", hash_original_method = "7E49696C17D36DF48010DE39377AB681", hash_generated_method = "D9CEDD25462C13008374B8527E38B9BA")
    
public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.387 -0500", hash_original_method = "7CF98125B8F87A2FD19C70088B288B78", hash_generated_method = "5E63A6C3617F7CF3B345D74E6FF08CC7")
    
public void setBytesTransferred(long count) {
        this.bytesTransferred = count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.389 -0500", hash_original_method = "5BC15BEBDBF96C2B4749F7E80B21C1AA", hash_generated_method = "4723DE3147D4F65073D54E85943C21AB")
    
public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.391 -0500", hash_original_method = "57609043FFD34118E5E2ADA78EDAAD37", hash_generated_method = "3EA0F70FC746AD3D01FF340A7B890209")
    
public void reset() {
        this.bytesTransferred = 0;
    }
    
}

