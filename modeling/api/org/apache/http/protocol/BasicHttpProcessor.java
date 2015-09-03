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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/BasicHttpProcessor.java $
 * $Revision: 613298 $
 * $Date: 2008-01-18 14:09:22 -0800 (Fri, 18 Jan 2008) $
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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.203 -0500", hash_original_field = "F0927C12028AB6BB9BB20CCEECE3CCD1", hash_generated_field = "7398F9B2AE291E5D2787309DA0C28986")

    protected List requestInterceptors = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.206 -0500", hash_original_field = "2BC97F81D8E4786B2EA6F956785478DB", hash_generated_field = "9A978F38560CD78676894BBBC402D767")
 
    protected List responseInterceptors = null;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.271 -0400", hash_original_method = "9C379E6850D70F22993610B85EB51FC7", hash_generated_method = "9C379E6850D70F22993610B85EB51FC7")
    public BasicHttpProcessor ()
    {
        //Synthesized constructor
    }

    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.208 -0500", hash_original_method = "E1A96A9E1100F28388C805D474E7BAD5", hash_generated_method = "36D725ACA49B211F5C2BD3C69F53E8E5")
    
public void addRequestInterceptor(final HttpRequestInterceptor itcp) {

        if (itcp == null) {
            return;
        }
        if (this.requestInterceptors == null) {
            this.requestInterceptors = new ArrayList();
        }
        this.requestInterceptors.add(itcp);
    }
    
    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.211 -0500", hash_original_method = "7082E628C139155B4DBFBA26A9DAA55A", hash_generated_method = "C843B06528BD102DBAA0D8D9CF022947")
    
public void addRequestInterceptor(final HttpRequestInterceptor itcp,
                                      int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        if (itcp == null) {
            return;
        }

        if (this.requestInterceptors == null) {
            if (index > 0) {
                throw new IndexOutOfBoundsException(String.valueOf(index));
            }
            this.requestInterceptors = new ArrayList();
        }
        this.requestInterceptors.add(index, itcp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.213 -0500", hash_original_method = "306BD5279F186A7F697194E65EEC0E22", hash_generated_method = "0647AEE1FAA42EC4789386AE1509F27A")
    
public void addResponseInterceptor(HttpResponseInterceptor itcp,
                                       int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        if (itcp == null) {
            return;
        }

        if (this.responseInterceptors == null) {
            if (index > 0) {
                throw new IndexOutOfBoundsException(String.valueOf(index));
            }
            this.responseInterceptors = new ArrayList();
        }
        this.responseInterceptors.add(index, itcp);
    }
    
    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.216 -0500", hash_original_method = "EFB13BD2F5F78871DC67563CE3418B82", hash_generated_method = "EC73B16DAE71315F2FE7CD31D187BFFD")
    
public void removeRequestInterceptorByClass(final Class clazz) {
        if (this.requestInterceptors == null) {
            return;
        }
        for (Iterator it = this.requestInterceptors.iterator();
             it.hasNext(); ) {
            Object request = it.next();
            if (request.getClass().equals(clazz)) {
                it.remove();
            }
        }
    }
    
    // non-Javadoc, see interface HttpResponseInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.219 -0500", hash_original_method = "DF5F226D1AE22FA4A42A4921E11EE920", hash_generated_method = "5974694CC3CA9F59ED0771C37AC18FCF")
    
public void removeResponseInterceptorByClass(final Class clazz) {
        if (this.responseInterceptors == null) {
            return;
        }
        for (Iterator it = this.responseInterceptors.iterator();
             it.hasNext(); ) {
            Object request = it.next();
            if (request.getClass().equals(clazz)) {
                it.remove();
            }
        }
    }
    
    /**
     * Same as {@link #addRequestInterceptor(HttpRequestInterceptor) addRequestInterceptor}.
     *
     * @param interceptor       the interceptor to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.221 -0500", hash_original_method = "49979C36D9B3AD67BC7E969CE817FBA1", hash_generated_method = "CA4F4D90C55BF69E633C00510AA7D1AD")
    
public final
            void addInterceptor(final HttpRequestInterceptor interceptor) {
        addRequestInterceptor(interceptor);
    }
    
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.224 -0500", hash_original_method = "E7AC62DE103BF676D1A944DB4C5B9066", hash_generated_method = "45675F7AE861D454364E166BA607A2C6")
    
public final
            void addInterceptor(final HttpRequestInterceptor interceptor,
                                int index) {
        addRequestInterceptor(interceptor, index);
    }
    
    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.226 -0500", hash_original_method = "88BEDAF27A7611A7A46622E627DC9A63", hash_generated_method = "FCC03D0B7B33D37098A6196DD1AECD89")
    
public int getRequestInterceptorCount() {
        return (this.requestInterceptors == null) ?
            0 : this.requestInterceptors.size();
    }
    
    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.228 -0500", hash_original_method = "977729FD94F3060F22AEFDD0D34CFD7C", hash_generated_method = "97812F7A13B1A29BD5C585434AB29987")
    
public HttpRequestInterceptor getRequestInterceptor(int index) {
        
        if ((this.requestInterceptors == null) ||
                (index < 0) || (index >= this.requestInterceptors.size()))
            return null;
        
        return (HttpRequestInterceptor) this.requestInterceptors.get(index);
    }
    
    // non-Javadoc, see interface HttpRequestInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.231 -0500", hash_original_method = "145E2FEDCA1A32FEC7370D21776649A2", hash_generated_method = "6D49CAC2418C0263BF0152380A974F60")
    
public void clearRequestInterceptors() {
        this.requestInterceptors = null;
    }
    
    // non-Javadoc, see interface HttpResponseInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.234 -0500", hash_original_method = "7D6C31789EA3365B9B9BD2DA3F7D37E3", hash_generated_method = "728F4E0865346D9141027EF7ABC38892")
    
public void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        if (itcp == null) {
            return;
        }
        if (this.responseInterceptors == null) {
            this.responseInterceptors = new ArrayList();
        }
        this.responseInterceptors.add(itcp);
    }
    
    /**
     * Same as {@link #addResponseInterceptor(HttpResponseInterceptor) addResponseInterceptor}.
     *
     * @param interceptor       the interceptor to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.238 -0500", hash_original_method = "7DCB6CEE097C8760F94401368BED6C8A", hash_generated_method = "60DF96D9BA7C2EC0BA86C23F102CE99A")
    
public final
            void addInterceptor(final HttpResponseInterceptor interceptor) {
        addResponseInterceptor(interceptor);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.240 -0500", hash_original_method = "5F99216482E6DE112B8985A77BFA25FC", hash_generated_method = "45669F9B439692FC59D65F3837F027D7")
    
public final void addInterceptor(final HttpResponseInterceptor interceptor,
                                     int index) {
        addResponseInterceptor(interceptor, index);
    }
    
    // non-Javadoc, see interface HttpResponseInterceptorList
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.242 -0500", hash_original_method = "076BC0B3D789CD5AF4622C7C18D19D27", hash_generated_method = "524749162A855AC91F21EA7A7ACDCBD7")
    
public int getResponseInterceptorCount() {
        return (this.responseInterceptors == null) ?
            0 : this.responseInterceptors.size();
    }
    
    // non-Javadoc, see interface HttpResponseInterceptorList
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.244 -0500", hash_original_method = "745ED53DD037C2DD0D029886B0DA9F3E", hash_generated_method = "E73C579B3FDC010E06DE90ECFFDFD7B4")
    
public HttpResponseInterceptor getResponseInterceptor(int index) {
        
        if ((this.responseInterceptors == null) ||
                (index < 0) || (index >= this.responseInterceptors.size()))
            return null;
        
        return (HttpResponseInterceptor) this.responseInterceptors.get(index);
    }
    
    // non-Javadoc, see interface HttpResponseInterceptorList
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.247 -0500", hash_original_method = "312DB737544A7054D89F25FB9ECC2521", hash_generated_method = "CEF1B504F2F465F90D63442FC5DC9F1B")
    
public void clearResponseInterceptors() {
        this.responseInterceptors = null;
    }
    
    /**
     * Sets the interceptor lists.
     * First, both interceptor lists maintained by this processor
     * will be cleared.
     * Subsequently,
     * elements of the argument list that are request interceptors will be
     * added to the request interceptor list.
     * Elements that are response interceptors will be
     * added to the response interceptor list.
     * Elements that are both request and response interceptor will be
     * added to both lists.
     * Elements that are neither request nor response interceptor
     * will be ignored.
     *
     * @param list      the list of request and response interceptors
     *                  from which to initialize
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.249 -0500", hash_original_method = "2546A12B167929D122A18C572AD1485C", hash_generated_method = "D4DB2B779E134539710BA68ECDC9E8F1")
    
public void setInterceptors(final List list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null.");
        }
        if (this.requestInterceptors != null) {
            this.requestInterceptors.clear();
        }
        if (this.responseInterceptors != null) {
            this.responseInterceptors.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof HttpRequestInterceptor) {
                addInterceptor((HttpRequestInterceptor)obj);
            }
            if (obj instanceof HttpResponseInterceptor) {
                addInterceptor((HttpResponseInterceptor)obj);
            }
        }
    }
    
    /**
     * Clears both interceptor lists maintained by this processor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.251 -0500", hash_original_method = "D115BE155D407C71B3079D92DD3ABF36", hash_generated_method = "E083AE564F1A70F4C8B241C8A4873920")
    
public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
    }
    
    // non-Javadoc, see interface HttpRequestInterceptor (via HttpProcessor)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.254 -0500", hash_original_method = "73AD1047DC7932E91E23500135DCAA1F", hash_generated_method = "787290C705ECD7B548488F2A0DDCF825")
    
public void process(
            final HttpRequest request,
            final HttpContext context)
            throws IOException, HttpException {
        if (this.requestInterceptors != null) {
            for (int i = 0; i < this.requestInterceptors.size(); i++) {
                HttpRequestInterceptor interceptor =
                    (HttpRequestInterceptor) this.requestInterceptors.get(i);
                interceptor.process(request, context);
            }
        }
    }
    
    // non-Javadoc, see interface HttpResponseInterceptor (via HttpProcessor)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.256 -0500", hash_original_method = "41A094A5EA8F96220C5B29D851C7CE79", hash_generated_method = "5DDA49EF0792677DD8A9DEB7BC9A3EE6")
    
public void process(
            final HttpResponse response,
            final HttpContext context)
            throws IOException, HttpException {
        if (this.responseInterceptors != null) {
            for (int i = 0; i < this.responseInterceptors.size(); i++) {
                HttpResponseInterceptor interceptor =
                    (HttpResponseInterceptor) this.responseInterceptors.get(i);
                interceptor.process(response, context);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.259 -0500", hash_original_method = "1B68B439697A421DCA2B8CED4C47D3CE", hash_generated_method = "CBD717A04D1A914D9B363B84F625D015")
    
protected void copyInterceptors(final BasicHttpProcessor target) {
        if (this.requestInterceptors != null) {
            target.requestInterceptors =
                new ArrayList(this.requestInterceptors);
        }
        if (this.responseInterceptors != null) {
            target.responseInterceptors =
                new ArrayList(this.responseInterceptors);
        }
    }
    
    /**
     * Creates a copy of this instance
     *
     * @return new instance of the BasicHttpProcessor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.261 -0500", hash_original_method = "166F0C6BA2B53E84DB5B8B4516A0E908", hash_generated_method = "A499CC215A2AD31EF71C24E8CF5996A6")
    
public BasicHttpProcessor copy() {
        BasicHttpProcessor clone = new BasicHttpProcessor();
        copyInterceptors(clone);
        return clone;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.263 -0500", hash_original_method = "5AA72A12635065E25111537F7EBBA8DC", hash_generated_method = "7BEBDC195C53D4F44E60CA2921426284")
    
public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        copyInterceptors(clone);
        return clone;
    }
    
}

