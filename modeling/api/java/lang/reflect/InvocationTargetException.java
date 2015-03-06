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


package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InvocationTargetException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.222 -0500", hash_original_field = "3FB1F19F5ECFA9B61FF3BEB74A0E3882", hash_generated_field = "8B92C691B9FF42AF75BC4B807D727C71")

    private static final long serialVersionUID = 4085088731926701167L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.225 -0500", hash_original_field = "BAE956BCC966588A9550DF065F923336", hash_generated_field = "5298B1A2336EAF80BB6B016828DD3384")

    private Throwable target;

    /**
     * Constructs a new {@code InvocationTargetException} instance with a
     * {@code null} cause / target exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.228 -0500", hash_original_method = "5EBB00A3899F4B7F5118F6E64DAF6A94", hash_generated_method = "F002C28ED5B431C1069BCA418FDA04D5")
    
protected InvocationTargetException() {
        super((Throwable) null);
    }

    /**
     * Constructs a new {@code InvocationTargetException} instance with its
     * cause / target exception filled in.
     *
     * @param exception
     *            the exception which occurred while running the Method or
     *            Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.231 -0500", hash_original_method = "D75C8652A4FC35D535700D06AA8AC5D8", hash_generated_method = "2FDFDD6B083187F65DFBB9D56DD19A0F")
    
public InvocationTargetException(Throwable exception) {
        super(null, exception);
        target = exception;
    }

    /**
     * Constructs a new {@code InvocationTargetException} instance with its
     * cause / target exception and message filled in.
     *
     * @param detailMessage
     *            the detail message for the exception
     * @param exception
     *            the exception which occurred while running the Method or
     *            Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.234 -0500", hash_original_method = "24D12D510338B7A1CDB30B859EF6A619", hash_generated_method = "572E6A8818653EA40EA5A1C6240471C2")
    
public InvocationTargetException(Throwable exception, String detailMessage) {
        super(detailMessage, exception);
        target = exception;
    }

    /**
     * Returns the target exception, which may be {@code null}.
     *
     * @return the target exception
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.236 -0500", hash_original_method = "F1F2316177C546F546EA483459CFF30B", hash_generated_method = "2207DC53F6302AF64B36ABA7BEE1FE70")
    
public Throwable getTargetException() {
        return target;
    }

    /**
     * Returns the cause of this exception, which may be {@code null}.
     *
     * @return the cause of this exception
     */
    @DSComment("Java language reflection")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.239 -0500", hash_original_method = "D8C22D14C73496EF517FF8FC6C6B2CD8", hash_generated_method = "99CD47B0697B3B8C9C0B34299EA01FAB")
    
@Override
    public Throwable getCause() {
        return target;
    }
}

