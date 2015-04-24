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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InstantiationError extends IncompatibleClassChangeError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.910 -0500", hash_original_field = "FE1E0D266091647CEB7032D9E6BBCCB3", hash_generated_field = "5293F978E12C264089BA3B2578BB9948")

    private static final long serialVersionUID = -4885810657349421204L;

    /**
     * Constructs a new {@code InstantiationError} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.913 -0500", hash_original_method = "0CADFA7EDCF977E1C3E40BA09A641E39", hash_generated_method = "538956C170632FE0860C43439451E631")
    
public InstantiationError() {
    }

    /**
     * Constructs a new {@code InstantiationError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.916 -0500", hash_original_method = "023CF4960A8F6AD78560985CF4A496AC", hash_generated_method = "EB0476C17938DCAD95114043BBC05FEE")
    
public InstantiationError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code InstantiationError} with the current stack trace
     * and the class that caused this error.
     *
     * @param clazz
     *            the class that can not be instantiated.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.918 -0500", hash_original_method = "715FEA28AECD396E352AFBA27C6E8A8B", hash_generated_method = "715FEA28AECD396E352AFBA27C6E8A8B")
    
InstantiationError(Class<?> clazz) {
        super(clazz.getName());
    }
}

