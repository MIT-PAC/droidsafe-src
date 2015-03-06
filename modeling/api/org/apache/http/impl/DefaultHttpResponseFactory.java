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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/DefaultHttpResponseFactory.java $
 * $Revision: 618367 $
 * $Date: 2008-02-04 10:26:06 -0800 (Mon, 04 Feb 2008) $
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


package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HttpContext;

public class DefaultHttpResponseFactory implements HttpResponseFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.406 -0500", hash_original_field = "D8E058CC9400D2B49594453D57519F61", hash_generated_field = "0FC26A15CA4A50E5DB35DC8C30DA85B0")

    protected  ReasonPhraseCatalog reasonCatalog;

    /**
     * Creates a new response factory with the given catalog.
     *
     * @param catalog   the catalog of reason phrases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.409 -0500", hash_original_method = "0B8909DC59B5514A6A7570D0CDE2DD57", hash_generated_method = "7C3CC5D34E94A676B9105820F54624F9")
    
public DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
        if (catalog == null) {
            throw new IllegalArgumentException
                ("Reason phrase catalog must not be null.");
        }
        this.reasonCatalog = catalog;
    }

    /**
     * Creates a new response factory with the default catalog.
     * The default catalog is
     * {@link EnglishReasonPhraseCatalog EnglishReasonPhraseCatalog}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.412 -0500", hash_original_method = "FFDB5398ED0A2C8E2758E409B21A6993", hash_generated_method = "25392C23AF85C09C3AE9CC86A3CEDE9C")
    
public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    // non-javadoc, see interface HttpResponseFactory
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.414 -0500", hash_original_method = "EC452AB6471CEB13DACC9B1E83291CFC", hash_generated_method = "E2D59D7549F143FB86F464B261D10E45")
    
public HttpResponse newHttpResponse(final ProtocolVersion ver,
                                        final int status,
                                        HttpContext context) {
        if (ver == null) {
            throw new IllegalArgumentException("HTTP version may not be null");
        }
        final Locale loc      = determineLocale(context);
        final String reason   = reasonCatalog.getReason(status, loc);
        StatusLine statusline = new BasicStatusLine(ver, status, reason);
        return new BasicHttpResponse(statusline, reasonCatalog, loc); 
    }

    // non-javadoc, see interface HttpResponseFactory
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.417 -0500", hash_original_method = "5A7FFEFCFB2914E81957F795B443D54C", hash_generated_method = "EB230D42CBD98FA096165E124EAA41D1")
    
public HttpResponse newHttpResponse(final StatusLine statusline,
                                        HttpContext context) {
        if (statusline == null) {
            throw new IllegalArgumentException("Status line may not be null");
        }
        final Locale loc = determineLocale(context);
        return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    /**
     * Determines the locale of the response.
     * The implementation in this class always returns the default locale.
     *
     * @param context   the context from which to determine the locale, or
     *                  <code>null</code> to use the default locale
     *
     * @return  the locale for the response, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.419 -0500", hash_original_method = "D55AE22798B058ABD6A02EB9DF9528CC", hash_generated_method = "7D49F64D11B4FD6D4882534B751D74B0")
    
protected Locale determineLocale(HttpContext context) {
        return Locale.getDefault();
    }
    
}

