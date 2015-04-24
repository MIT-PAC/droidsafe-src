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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/AbstractHttpParams.java $
 * $Revision: 542224 $
 * $Date: 2007-05-28 06:34:04 -0700 (Mon, 28 May 2007) $
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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class AbstractHttpParams implements HttpParams {

    /**
     * Instantiates parameters.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.767 -0500", hash_original_method = "A2A1500AC9CF1B321965DC9E32B8AC94", hash_generated_method = "D0F41019489829B54E3B637A038A3594")
    
protected AbstractHttpParams() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.769 -0500", hash_original_method = "ABC520F536F6B9249E7F10C3331D9CFF", hash_generated_method = "713124F9BFF26D03D52A5B9845E657A1")
    
public long getLongParameter(final String name, long defaultValue) { 
        Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Long)param).longValue();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.772 -0500", hash_original_method = "707F0F50AD946C11EC4F03D4FF24C0BF", hash_generated_method = "99DF5A1D9C3EB7CE74F5772678738773")
    
public HttpParams setLongParameter(final String name, long value) {
        setParameter(name, new Long(value));
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.774 -0500", hash_original_method = "FC38355AD8AFE83547775A40AA8286E7", hash_generated_method = "775181AFA47CBF6E7DCF0AFA0F2AB553")
    
public int getIntParameter(final String name, int defaultValue) { 
        Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Integer)param).intValue();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.776 -0500", hash_original_method = "96343DB864AD4997F691AF608DE2D190", hash_generated_method = "84914EA0E41541A849981AFB92072B2D")
    
public HttpParams setIntParameter(final String name, int value) {
        setParameter(name, new Integer(value));
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.779 -0500", hash_original_method = "B3915F7C4095D2BECFA83FAD119B9A71", hash_generated_method = "E81B500814D73A7B73221E5DBA85AF09")
    
public double getDoubleParameter(final String name, double defaultValue) { 
        Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Double)param).doubleValue();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.781 -0500", hash_original_method = "463E9092B81310E5E36DE5B6EDA46056", hash_generated_method = "EF4D813D2CCAABCD45C14386BE46C17F")
    
public HttpParams setDoubleParameter(final String name, double value) {
        setParameter(name, new Double(value));
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.783 -0500", hash_original_method = "EE3E41732A5BC182F80D452656C028BA", hash_generated_method = "27CD00DB3A1D3D16C4B17E5367B58F01")
    
public boolean getBooleanParameter(final String name, boolean defaultValue) { 
        Object param = getParameter(name);
        if (param == null) {
            return defaultValue;
        }
        return ((Boolean)param).booleanValue();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.785 -0500", hash_original_method = "E4FF8AAC25178FB9DD8E5DC61133723C", hash_generated_method = "ABAE7C89DD514381027CD96A98F6A263")
    
public HttpParams setBooleanParameter(final String name, boolean value) {
        setParameter(name, value ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.787 -0500", hash_original_method = "77AC0729B60E14850AEA6A580DC038BB", hash_generated_method = "A52CB484D39AD5B3F1E62A2F15303E37")
    
public boolean isParameterTrue(final String name) {
        return getBooleanParameter(name, false);
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.789 -0500", hash_original_method = "2D51442B2D208BB7E61338E9C424C3DA", hash_generated_method = "3E6E91D05783F2F2960B51A4513DBB27")
    
public boolean isParameterFalse(final String name) {
        return !getBooleanParameter(name, false);
    }
    
}

