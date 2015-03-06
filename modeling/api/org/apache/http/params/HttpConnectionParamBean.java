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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/HttpConnectionParamBean.java $
 * $Revision: 593937 $
 * $Date: 2007-11-11 10:44:12 -0800 (Sun, 11 Nov 2007) $
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


package org.apache.http.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class HttpConnectionParamBean extends HttpAbstractParamBean {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.355 -0400", hash_original_method = "8314937FD3F0C82842D77DE433EEF506", hash_generated_method = "1306C025CB47FC0A2654725B7E9CF9F4")
    
public HttpConnectionParamBean (final HttpParams params) {
        super(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.356 -0400", hash_original_method = "564B72E80B252DAEB2761B8F3F632480", hash_generated_method = "9AB35D55CF39102935B5730823339298")
    
public void setSoTimeout (int soTimeout) {
        HttpConnectionParams.setSoTimeout(params, soTimeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.358 -0400", hash_original_method = "92016FED2AC7AC0324A469B409CACC63", hash_generated_method = "48136840021A3894DE28D5B4702E4BF7")
    
public void setTcpNoDelay (boolean tcpNoDelay) {
        HttpConnectionParams.setTcpNoDelay(params, tcpNoDelay);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.359 -0400", hash_original_method = "3B40E2B25AC7067E9BD6E1CD362184D8", hash_generated_method = "BE21C8680C1B14D5B73E88FB900D94CA")
    
public void setSocketBufferSize (int socketBufferSize) {
        HttpConnectionParams.setSocketBufferSize(params, socketBufferSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.360 -0400", hash_original_method = "AE121BC5543A2D0CA968698E06BEA1DF", hash_generated_method = "EA501C1D928521A2CD1294AB4509AF81")
    
public void setLinger (int linger) {
        HttpConnectionParams.setLinger(params, linger);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.362 -0400", hash_original_method = "56E55C98A69CBC42062CFD7A02240A04", hash_generated_method = "101D6B82B1F8708E06D8B45FEC1A4C85")
    
public void setConnectionTimeout (int connectionTimeout) {
        HttpConnectionParams.setConnectionTimeout(params, connectionTimeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.363 -0400", hash_original_method = "3E2EAB8DC8D7E79C3C38EC12C81C7C01", hash_generated_method = "19CA550485070DBC5E71BAD9D27A8BA0")
    
public void setStaleCheckingEnabled (boolean staleCheckingEnabled) {
        HttpConnectionParams.setStaleCheckingEnabled(params, staleCheckingEnabled);
    }
    
}
