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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/DefaultedHttpParams.java $
 * $Revision: 610763 $
 * $Date: 2008-01-10 04:01:13 -0800 (Thu, 10 Jan 2008) $
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
import org.apache.http.params.HttpParams;

/**
 * {@link HttpParams} implementation that delegates resolution of a parameter
 * to the given default {@link HttpParams} instance if the parameter is not 
 * present in the local one. The state of the local collection can be mutated,
 * whereas the default collection is treated as read-only.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @version $Revision: 610763 $
 */
public final class DefaultedHttpParams extends AbstractHttpParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.613 -0400", hash_original_field = "F71F590777BB7F52824FA17E1F88A6DC", hash_generated_field = "78E273B282AB8F0682098EAACED6A31D")

    private  HttpParams local;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.614 -0400", hash_original_field = "DF1AA6D8F2146835AF13AFA8B2F0E908", hash_generated_field = "7C7B9E8ECC62BA9C3B22B14F971ED885")

    private  HttpParams defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.614 -0400", hash_original_method = "F186857AF420D39CB611CAAD34A59FFE", hash_generated_method = "FB6CCDD078E49553704393F9B7F8E1BB")
    
public DefaultedHttpParams(final HttpParams local, final HttpParams defaults) {
        super();
        if (local == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.local = local;
        this.defaults = defaults;
    }

    /**
     * Creates a copy of the local collection with the same default
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.615 -0400", hash_original_method = "7A085DF6BD6668C8BAB6FA85FCE819EE", hash_generated_method = "6F4CBF1221FA064EF4FC8CD549A07F79")
    
public HttpParams copy() {
        HttpParams clone = this.local.copy();
        return new DefaultedHttpParams(clone, this.defaults);
    }

    /**
     * Retrieves the value of the parameter from the local collection and, if the 
     * parameter is not set locally, delegates its resolution to the default 
     * collection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.616 -0400", hash_original_method = "C97ACF06F663835E754EB87A94D8CF7B", hash_generated_method = "BA630F333AF1758CCAABC9EE64E33A1F")
    
public Object getParameter(final String name) {
        Object obj = this.local.getParameter(name);
        if (obj == null && this.defaults != null) {
            obj = this.defaults.getParameter(name);
        }
        return obj;
    }

    /**
     * Attempts to remove the parameter from the local collection. This method 
     * <i>does not</i> modify the default collection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.616 -0400", hash_original_method = "B3D7092279EA270B3046D7D53B6DAF5E", hash_generated_method = "3C9C97CCEB81EDB78D936A0BBFF73B9E")
    
public boolean removeParameter(final String name) {
        return this.local.removeParameter(name);
    }

    /**
     * Sets the parameter in the local collection. This method <i>does not</i> 
     * modify the default collection.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.617 -0400", hash_original_method = "254E14EDBFCE7951A0A2B2DC45614C67", hash_generated_method = "B67C3B2821EFF0E4EDA0F8BEA9BE8137")
    
public HttpParams setParameter(final String name, final Object value) {
        return this.local.setParameter(name, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.617 -0400", hash_original_method = "4221792FE7C3FA608439236DB0219127", hash_generated_method = "FA909842EF1A748649287FD12134976F")
    
public HttpParams getDefaults() {
        return this.defaults;
    }
    
}
