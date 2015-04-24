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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/util/ExceptionUtils.java $
 * $Revision: 613003 $
 * $Date: 2008-01-17 15:00:42 -0800 (Thu, 17 Jan 2008) $
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


package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Method;

public final class ExceptionUtils {

    /**
     * Returns a <code>Method<code> allowing access to
     * {@link Throwable#initCause(Throwable) initCause} method of {@link Throwable},
     * or <code>null</code> if the method
     * does not exist.
     * 
     * @return A <code>Method<code> for <code>Throwable.initCause</code>, or
     * <code>null</code> if unavailable.
     */ 
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.815 -0500", hash_original_method = "E0B19896BEC7E8973FE5692D01506C32", hash_generated_method = "41CF6E32BE46313F3FB2C00B6918F893")
    
static private Method getInitCauseMethod() {
        try {
            Class[] paramsClasses = new Class[] { Throwable.class };
            return Throwable.class.getMethod("initCause", paramsClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    
    /** 
     * If we're running on JDK 1.4 or later, initialize the cause for the given throwable.
     * 
     * @param  throwable The throwable.
     * @param  cause     The cause of the throwable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.817 -0500", hash_original_method = "9500C77C5C6AE8093B22F8C92F23F797", hash_generated_method = "1E8C4A2053650C39451358B0C7AC5086")
    
public static void initCause(Throwable throwable, Throwable cause) {
        if (INIT_CAUSE_METHOD != null) {
            try {
                INIT_CAUSE_METHOD.invoke(throwable, new Object[] { cause });
            } catch (Exception e) {
                // Well, with no logging, the only option is to munch the exception
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.812 -0500", hash_original_field = "8549D60C6BFF50442E2F356E6E865681", hash_generated_field = "909CE2AC4E4D131D0ECCF0CD71A1706C")

    static private final Method INIT_CAUSE_METHOD = getInitCauseMethod();

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.820 -0500", hash_original_method = "A1F3D67C211E4EC7543A3C1E27BD7049", hash_generated_method = "B702D3BB38F6042B3663A5D39DE6CA37")
    
private ExceptionUtils() {
    }
}

