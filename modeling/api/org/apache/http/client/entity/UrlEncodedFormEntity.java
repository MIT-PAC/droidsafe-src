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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/entity/UrlEncodedFormEntity.java $
 * $Revision: 655107 $
 * $Date: 2008-05-10 08:20:42 -0700 (Sat, 10 May 2008) $
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.client.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

public class UrlEncodedFormEntity extends StringEntity {
  
    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters in the specified encoding.
     * 
     * @param parameters list of name/value pairs
     * @param encoding encoding the name/value pairs be encoded with
     * @throws UnsupportedEncodingException if the encoding isn't supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.628 -0500", hash_original_method = "2B79106283EA78C37FC06864AB4CC20F", hash_generated_method = "97236FA94CD4379FBBB97CBB8054EEFB")
    
public UrlEncodedFormEntity (
        final List <? extends NameValuePair> parameters, 
        final String encoding) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, encoding), 
            encoding);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    /**
     * Constructs a new {@link UrlEncodedFormEntity} with the list
     * of parameters with the default encoding of {@link HTTP#DEFAULT_CONTENT_CHARSET}
     * 
     * @param parameters list of name/value pairs
     * @throws UnsupportedEncodingException if the default encoding isn't supported
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.631 -0500", hash_original_method = "EFE31A1BCD3079C9AAB0E8E3BC2999DC", hash_generated_method = "F2ADCBCD03D851844BFD7EFF8118FD22")
    
public UrlEncodedFormEntity (
        final List <? extends NameValuePair> parameters) throws UnsupportedEncodingException {
        super(URLEncodedUtils.format(parameters, HTTP.DEFAULT_CONTENT_CHARSET), 
            HTTP.DEFAULT_CONTENT_CHARSET);
        setContentType(URLEncodedUtils.CONTENT_TYPE);
    }

    
    
    
}

