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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/cookie/params/CookieSpecPNames.java $
 * $Revision: 578403 $
 * $Date: 2007-09-22 03:56:04 -0700 (Sat, 22 Sep 2007) $
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


package org.apache.http.cookie.params;

/**
 * Parameter names for cookie specifications in HttpCookie.
 * 
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @version $Revision: 578403 $
 * 
 * @since 4.0
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface CookieSpecPNames {

    /**
     * Parameter for the date patterns used for parsing.
     * <p>
     * This parameter expects a value of type {@link java.util.Collection}.
     * The collection elements are of type {@link String}
     * and must be compatible with the syntax of
     * {@link java.text.SimpleDateFormat}.
     * </p>
     */
    public static final String DATE_PATTERNS = "http.protocol.cookie-datepatterns";
    
    /**
     * Parameter for Cookie header formatting.
     * Defines whether {@link org.apache.http.cookie.Cookie cookies}
     * should be put on 
     * a single {@link org.apache.http.Header request header}.
     * If not, each cookie is formatted in a seperate Cookie header.
     * <p>
     * This parameter expects a value of type {@link Boolean}.
     * </p>
     */
    public static final String SINGLE_COOKIE_HEADER = "http.protocol.single-cookie-header"; 

}
