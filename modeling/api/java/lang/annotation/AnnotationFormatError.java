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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang.annotation;

/**
 * Indicates that an annotation in the binary representation of a class is
 * syntactically incorrect and the annotation parser is unable to process it.
 * This exception is unlikely to ever occur, given that the code has been
 * compiled by an ordinary Java compiler.
 *
 * @since 1.5
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class AnnotationFormatError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.384 -0400", hash_original_field = "434A939298A79C6CBF244036FBFCD9F8", hash_generated_field = "9F9E1E72988777361C8FD8FE375657CF")


    private static final long serialVersionUID = -4256701562333669892L;

    /**
     * Constructs an instance with the message provided.
     *
     * @param message
     *            the details of the error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.385 -0400", hash_original_method = "17DD951E869A5C24EC057ACC20C936AE", hash_generated_method = "1DE09DB95E82E30B7FC9E344C11CE619")
    
public AnnotationFormatError(String message) {
        super(message);
    }

    /**
     * Constructs an instance with a message and a cause.
     *
     * @param message
     *            the details of the error.
     * @param cause
     *            the cause of the error or {@code null} if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.387 -0400", hash_original_method = "3DEF91AB073042C444F1A120853B7161", hash_generated_method = "5C6F8479B12BAEC8F1C43EBE644FC669")
    
public AnnotationFormatError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an instance with a cause. If the cause is not
     * {@code null}, then {@code cause.toString()} is used as the
     * error's message.
     *
     * @param cause
     *            the cause of the error or {@code null} if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.388 -0400", hash_original_method = "B0777B4424A52FFB5C86BB436E63E3E8", hash_generated_method = "2FF3C209E4B24474EE6EF5BA20E8DA45")
    
public AnnotationFormatError(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }

}
