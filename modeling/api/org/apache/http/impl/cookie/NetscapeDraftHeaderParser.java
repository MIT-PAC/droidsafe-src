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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/cookie/NetscapeDraftHeaderParser.java $
 * $Revision: 603563 $
 * $Date: 2007-12-12 03:17:55 -0800 (Wed, 12 Dec 2007) $
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


package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class NetscapeDraftHeaderParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.600 -0500", hash_original_field = "FB20D70F09B1AA5B72BC385F58A11077", hash_generated_field = "94EFCB742F16A6A619D5679042344819")

    public final static NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.603 -0500", hash_original_field = "629B9DCEAACB9F96AFCA1CB0ED0BDE17", hash_generated_field = "D5F52B0DDD543B0DC0444DE5C5A210D6")
    
    private final static char[] DELIMITERS = new char[] { ';' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.605 -0500", hash_original_field = "63BB4DDBEEFACB4F4E91079B4CA5F251", hash_generated_field = "0A4D0DC8AD150348B21035D26D544819")
    
    private  BasicHeaderValueParser nvpParser;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.607 -0500", hash_original_method = "5814035B8E0ECDCEC909AB1CD6C37999", hash_generated_method = "ED3A7624C7A9CE509FEDF5C7FD351C1C")
    
public NetscapeDraftHeaderParser() {
        super();
        this.nvpParser = BasicHeaderValueParser.DEFAULT;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.611 -0500", hash_original_method = "3C830AE22F7AA511AF75147C79DF353D", hash_generated_method = "3F643C5A3DF71092C4C33B2EE0B01F4C")
    
public HeaderElement parseHeader(
            final CharArrayBuffer buffer,
            final ParserCursor cursor) throws ParseException {
        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
        NameValuePair nvp = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
        List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        while (!cursor.atEnd()) {
            NameValuePair param = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
            params.add(param);
        }
        return new BasicHeaderElement(
                nvp.getName(), 
                nvp.getValue(), params.toArray(new NameValuePair[params.size()]));
    }
}

