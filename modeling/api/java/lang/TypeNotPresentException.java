/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TypeNotPresentException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.491 -0500", hash_original_field = "EBF563A5B6DDA62D1601288798990D1D", hash_generated_field = "52B7B4456FF9EC4629580090450082F9")

    private static final long serialVersionUID = -5101214195716534496L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.493 -0500", hash_original_field = "585C5F628C300BCA9980197A904C62B8", hash_generated_field = "DAFE675943633FA9AA0F7DE9E967D92B")

    private String typeName;

    /**
     * Constructs a new {@code TypeNotPresentException} with the current stack
     * trace, a detail message that includes the name of the type that could not
     * be found and the {@code Throwable} that caused this exception.
     *
     * @param typeName
     *            the fully qualified name of the type that could not be found.
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.496 -0500", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "2BCFE584BA35CCAD344EF3CDCD0B917A")
    
public TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        this.typeName = typeName;
    }

    /**
     * Gets the fully qualified name of the type that could not be found.
     *
     * @return the name of the type that caused this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.498 -0500", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "343275828C51915E5F1AFC6F2DBFD430")
    
public String typeName() {
        return typeName;
    }
}

