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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/ResponseDate.java $
 * $Revision: 555989 $
 * $Date: 2007-07-13 06:33:39 -0700 (Fri, 13 Jul 2007) $
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


package org.apache.http.protocol;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpStatus;

/**
 * A response interceptor that adds a Date header.
 * For use on the server side.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 555989 $
 * 
 * @since 4.0
 */
public class ResponseDate implements HttpResponseInterceptor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.210 -0400", hash_original_field = "6B477E429B0C958441586425DA46E51A", hash_generated_field = "5C713FDDB3163B7722ECEF0BB9542B25")


    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator(); 
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.210 -0400", hash_original_method = "0C4D8A2C64BB87A54C685F3FB8076305", hash_generated_method = "9D778C7CDCDF4509A4F532B34BA64D94")
    
public ResponseDate() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.211 -0400", hash_original_method = "111D8C5BCB4BA0454C6C5B3B12A75ED9", hash_generated_method = "1BCBB9C33977B02FC3CBFD4385957D4F")
    
public void process(final HttpResponse response, final HttpContext context) 
            throws HttpException, IOException {
        if (response == null) {
            throw new IllegalArgumentException
                ("HTTP response may not be null.");
        }
        int status = response.getStatusLine().getStatusCode();
        if ((status >= HttpStatus.SC_OK) &&
            !response.containsHeader(HTTP.DATE_HEADER)) {
            String httpdate = DATE_GENERATOR.getCurrentDate();
            response.setHeader(HTTP.DATE_HEADER, httpdate); 
        }
    }
    
}
